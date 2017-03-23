package myapp;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/status-callback")
public class StatusCallbackServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req);
    }

    private void doProcess(final HttpServletRequest req) throws IOException {
        System.out.println("[status-callback] " + req.getRemoteHost() + ", " + req.getMethod());

        final Enumeration<String> headerNames = req.getHeaderNames();

        while(headerNames.hasMoreElements()){
            final String headerName = headerNames.nextElement();
            final String headerBody = req.getHeader(headerName);
            System.out.println(headerName + ": " + headerBody);
        }

        try(final ServletInputStream inputStream = req.getInputStream()){
            System.out.println(IOUtils.toString(inputStream, Charset.forName("UTF-8")));
        }

        System.out.println();
    }
}
