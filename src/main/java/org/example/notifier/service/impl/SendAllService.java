package org.example.notifier.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.notifier.entity.Client;
import org.example.notifier.entity.ContactPoint;
import org.example.notifier.factory.NotifierFactory;
import org.example.notifier.repository.ClientRepository;
import org.example.notifier.service.Notifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SendAllService {
    private final ClientRepository CLIENT_REPOSITORY;

    private final NotifierFactory NOTIFIER_FACTORY;

    public void sendAll(String text) {
        List<Client> clients = CLIENT_REPOSITORY.findAll();
        clients.forEach(client -> {
            String prefix = "Dear " + client.getName() + "\n";
            String message = prefix + text;
            List<ContactPoint> clientContactPoints = client.getContactPoints();
            clientContactPoints.forEach(contactPoint -> {
                if (contactPoint.getIsActive()) {
                    Notifier notifier = NOTIFIER_FACTORY.getNotifier(contactPoint.getContactType());
                    notifier.sendNotification(contactPoint.getAddress(), message);
                }
            });
        });
    }

}
