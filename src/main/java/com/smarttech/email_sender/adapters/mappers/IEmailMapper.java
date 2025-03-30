package com.smarttech.email_sender.adapters.mappers;

import com.smarttech.email_sender.adapters.out.entities.EmailEntity;
import com.smarttech.email_sender.core.domain.EmailDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IEmailMapper {

    EmailEntity toEntity(EmailDomain emailDomain);

    EmailDomain toDomain(EmailEntity emailEntity);
}
