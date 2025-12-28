package org.example.notifier.factory;

import org.example.notifier.enums.ContactType;
import org.example.notifier.service.Notifier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NotifierFactory {
    private final Map<ContactType, Notifier> notifierMap;

    private NotifierFactory(List<Notifier> notifiers) {
        this.notifierMap = notifiers.stream()
                .collect(Collectors.toMap(Notifier::supports, notifier -> notifier));
    }

    public Notifier getNotifier(ContactType contactType) {
        Notifier notifier = notifierMap.get(contactType);
        if (ObjectUtils.isEmpty(notifier)) {
            throw new IllegalArgumentException("Unsupported type: " + contactType);
        }
        return notifier;
    }
}