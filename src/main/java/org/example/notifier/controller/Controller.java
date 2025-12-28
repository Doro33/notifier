package org.example.notifier.controller;

import lombok.RequiredArgsConstructor;
import org.example.notifier.record.MessageRecord;
import org.example.notifier.service.impl.SendAllService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class Controller {

    private final SendAllService SEND_ALL_SERVICE;

    @PostMapping("/send-notification")
    private String sendNotification(@RequestBody MessageRecord messageRecord) {
        try {
            if (ObjectUtils.isEmpty(messageRecord) || ObjectUtils.isEmpty(messageRecord.message()))
                return "Message can not be empty";
            SEND_ALL_SERVICE.sendAll(messageRecord.message());
            return "Sent to all successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
