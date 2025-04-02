package com.smarttech.email_sender.adapters.out;


import com.smarttech.email_sender.core.domain.EmailDomain;
import com.smarttech.email_sender.enums.StatusEmail;
import com.smarttech.email_sender.porters.out.IEmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderImpl implements IEmailSender {

    @Autowired
    JavaMailSender emailSender;

    @Override
    public EmailDomain sendEmail(EmailDomain emailDomain) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailDomain.getEmailTo());
            message.setSubject(emailDomain.getSubject());
            message.setText(emailDomain.getText());
            emailSender.send(message);

            emailDomain.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e){
            emailDomain.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return emailDomain;
        }
    }
}
