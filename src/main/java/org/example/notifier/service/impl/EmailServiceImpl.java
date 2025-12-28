package org.example.notifier.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.notifier.enums.ContactType;
import org.example.notifier.service.Notifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl implements Notifier {
    @Override
    public void sendNotification(String address, String message) {
        log.info("EMAIL: {} was sent to {}", message, address);
    }

    @Override
    public ContactType supports() {return ContactType.EMAIL; }
}
