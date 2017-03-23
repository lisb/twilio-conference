package myapp;

import com.twilio.twiml.Conference;
import com.twilio.twiml.Dial;
import com.twilio.twiml.Method;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;

import java.util.Arrays;

public class ConferenceTwimlFactory {

    public String create(final String conferenceName) {
        try {
            return new VoiceResponse.Builder().dial(new Dial.Builder().conference(new Conference.Builder(conferenceName).statusCallbackEvents(
                    Arrays.asList(Conference.ConferenceEvent.values()))
                    .statusCallback("status-callback")
                    .statusCallbackMethod(Method.POST)
                    //.maxParticipants(2)
                    .build()).build()).build().toXml();
        } catch (TwiMLException e) {
            throw new RuntimeException(e);
        }
    }
}
