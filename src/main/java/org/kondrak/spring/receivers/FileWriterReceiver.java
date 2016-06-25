package org.kondrak.spring.receivers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Administrator on 6/24/2016.
 */
@Component
public class FileWriterReceiver {
    @JmsListener(destination = "file-writer-destination", containerFactory = "jmsContainerFactory")
    public void receiveMessage(String message) {
        BufferedWriter w = null;
        try {
            File f = new File("messages/msg.txt");
            f.createNewFile();
            w = new BufferedWriter(new FileWriter(f));
            w.write(message);
            w.flush();
        } catch(IOException ex) {
            ex.printStackTrace();
        } finally {
            if(w != null) {
                try {
                    w.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
