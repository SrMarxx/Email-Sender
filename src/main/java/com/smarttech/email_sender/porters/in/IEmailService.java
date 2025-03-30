package com.smarttech.email_sender.porters.in;

import com.smarttech.email_sender.core.domain.EmailDomain;

public interface IEmailService {

    EmailDomain sendEmail(EmailDomain emailDomain);
}
