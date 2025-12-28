package org.example.notifier.service;

import org.example.notifier.enums.ContactType;

public interface Notifier {
    void sendNotification(String address, String message);
    ContactType supports();
}
