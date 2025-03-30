package com.smarttech.email_sender.adapters.out.repositories;

import com.smarttech.email_sender.adapters.out.entities.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IEmailJpaRepository extends JpaRepository<EmailEntity, UUID> {
}