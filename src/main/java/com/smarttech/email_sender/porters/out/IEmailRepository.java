package com.smarttech.email_sender.porters.out;

import com.smarttech.email_sender.core.domain.EmailDomain;

public interface IEmailRepository {

    EmailDomain salvar(EmailDomain emailDomain);

}
