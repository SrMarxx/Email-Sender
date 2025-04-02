package com.smarttech.email_sender.core.services;

import com.smarttech.email_sender.core.domain.EmailDomain;
import com.smarttech.email_sender.porters.in.IEmailService;
import com.smarttech.email_sender.porters.out.IEmailRepository;
import com.smarttech.email_sender.porters.out.IEmailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailServiceImpl implements IEmailService {
    final IEmailRepository iEmailRepository;
    final IEmailSender iEmailSender;

    public EmailServiceImpl(IEmailRepository iEmailRepository, IEmailSender iEmailSender) {
        this.iEmailRepository = iEmailRepository;
        this.iEmailSender = iEmailSender;
    }

    @Override
    public EmailDomain sendEmail(EmailDomain emailDomain) {

        emailDomain.setSendDateEmail(LocalDateTime.now());

        //Chamar o cara que vai enviar o e-mail
        emailDomain = iEmailSender.sendEmail(emailDomain);

        return iEmailRepository.salvar(emailDomain);
    }

}
