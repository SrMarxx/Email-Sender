package com.smarttech.email_sender.adapters.in.consumers;


import com.smarttech.email_sender.porters.in.IEmailService;
import com.smarttech.email_sender.adapters.in.dtos.EmailRecordDTO;
import com.smarttech.email_sender.adapters.mappers.IEmailMapper;
import com.smarttech.email_sender.adapters.out.entities.EmailEntity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    IEmailMapper iEmailMapper;
    @Autowired
    IEmailService iEmailService;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDTO emailRecordDTO){
        var emailEntity = new EmailEntity();
        BeanUtils.copyProperties(emailRecordDTO, emailEntity);
        iEmailService.sendEmail(iEmailMapper.toDomain(emailEntity));
    }
}