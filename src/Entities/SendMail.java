package Entities;

import Utils.DataSource;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SendMail {
    private Connection con;
    private Statement ste;

    public SendMail() {
        con = DataSource.getInstance().getCon();

    }
    public static void mailing(User user) throws Exception {
        Properties prop = new Properties();
        final String mail = "wtravel721@gmail.com";
        final String password = "ytugyptqnsxvaxrp";
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mail, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            message.setSubject("Welcome" + user.getName());
            message.setText("Welcome " + user.getName() + " we are more than happy for choosing our app \n" +
                    "if you need any information or assistance feel free to contact us \n Have a nice day!");
            Transport.send(message);
            System.out.println("Messeage send succefully");
        }
        catch (MessagingException ex) {
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

    }



}
