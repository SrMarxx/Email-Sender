package com.smarttech.email_sender.adapters.in.dtos;

import java.util.UUID;

public record EmailRecordDTO(UUID userId, String emailTo, String subject, String text) {
}
