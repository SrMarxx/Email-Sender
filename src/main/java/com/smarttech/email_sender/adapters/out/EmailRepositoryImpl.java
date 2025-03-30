package com.smarttech.email_sender.adapters.out;

import com.smarttech.email_sender.adapters.mappers.IEmailMapper;
import com.smarttech.email_sender.adapters.out.repositories.IEmailJpaRepository;
import com.smarttech.email_sender.core.domain.EmailDomain;
import com.smarttech.email_sender.porters.out.IEmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailRepositoryImpl implements IEmailRepository {

    @Autowired
    IEmailMapper IEmailMapper;

    @Autowired
    IEmailJpaRepository IEmailJpaRepository;

    @Override
    @Transactional
    public EmailDomain salvar(EmailDomain emailDomain) {
        return IEmailMapper.toDomain(
                IEmailJpaRepository.save(
                        IEmailMapper.toEntity(emailDomain)
                )
        );
    }
}
