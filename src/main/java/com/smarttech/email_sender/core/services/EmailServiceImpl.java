package com.smarttech.email_sender.core.services;


import com.smarttech.email_sender.porters.in.IEmailService;
import com.smarttech.email_sender.core.domain.EmailDomain;
import com.smarttech.email_sender.enums.StatusEmail;
import com.smarttech.email_sender.porters.out.IEmailRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailServiceImpl implements IEmailService {
    final IEmailRepository IEmailRepository;
    final JavaMailSender emailSender;

    public EmailServiceImpl(IEmailRepository IEmailRepository, JavaMailSender emailSender){
        this.IEmailRepository = IEmailRepository;
        this.emailSender = emailSender;
    }

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @Override
    public EmailDomain sendEmail(EmailDomain emailDomain){
        try{
            emailDomain.setSendDateEmail(LocalDateTime.now());
            emailDomain.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailDomain.getEmailTo());
            message.setSubject(emailDomain.getSubject());
            message.setText(emailDomain.getText());
            emailSender.send(message);

            emailDomain.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            emailDomain.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return IEmailRepository.salvar(emailDomain);
        }
    }

}
