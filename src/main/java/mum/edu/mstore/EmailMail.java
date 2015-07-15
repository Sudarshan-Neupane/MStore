package mum.edu.mstore;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Component;

/**
 *
 * @author sudarshan
 */
@Component
public class EmailMail {

    public void sendmail(String userTo) {

        final String username = "sudarshanneupane7@gmail.com";
        final String password = "musicmum";
      

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sn6195@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(userTo));
            message.setSubject("Testing Subject");
            message.setText("Hi,"
                    + "\n\n Thank you for submitting your profile!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
