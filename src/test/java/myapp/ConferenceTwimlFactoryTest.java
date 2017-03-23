package myapp;

import org.junit.Test;

public class ConferenceTwimlFactoryTest {

    private myapp.ConferenceTwimlFactory sut = new ConferenceTwimlFactory();

    @Test
    public void name() throws Exception {
        String actual = sut.create("foo");

        System.out.println(actual);
    }
}
