package mum.edu.mstore.scheduler;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import mum.edu.mstore.domain.User;
import mum.edu.mstore.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class EmailScheduler {

    @Autowired
    private UserService userService;
    @Scheduled(cron= "0 0 0 1 1 ?")
    public void sendEmail() {
        System.out.println("email send");
        List<User> users = this.userService.findAll();
        for(User u : users){
            this.sendNewYearEmail(u.getUserName());
        }
    }

    private void sendNewYearEmail(String email) {
        final String username = "sn6195@gmail.com";
        final String password = "onetwofc";

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
                    InternetAddress.parse(email));
            message.setSubject("Happy New Year");
            message.setText("Dear " + email
                    + "\n\n Happy New Year \n May this NEW YEAR bring lots of happiness in your life."
                    + "\n\n\n Thank you for using MusicStore(mstore.com)"
                    + "\n MStore Team");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
