package br.com.serratec.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.fromNumber}")
    private String fromNumber;

    public void sendSms(String numero, String body) {
        Twilio.init(accountSid, authToken);
        Message.creator(new PhoneNumber(numero), new PhoneNumber(fromNumber), body).create();
    }
}

