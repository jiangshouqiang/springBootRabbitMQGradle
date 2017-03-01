package com.gr.jiang.po;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by jiang on 2017/1/4.
 */
@Component
public class TestPo {
    public void handle(String receiveStr){
        System.out.println("receiveStr -> " + receiveStr);
    }
    public void handleObj(Person man){
        ObjectMapper objectMapper = new ObjectMapper();
        Writer writer = new StringWriter();

        try {
            objectMapper.writeValue(writer,man);
            String result = writer.toString();
            System.out.println("result ==> "+result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
