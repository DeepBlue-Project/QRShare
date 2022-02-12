package com.deepblue.qrshare.web.controllers;

import com.deepblue.qrshare.business.entities.ScannedQRCode;
import com.deepblue.qrshare.business.entities.TextContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScanController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping("/api/v1/scan/")
    public void greeting(@RequestBody ScannedQRCode scannedQRCode) throws MessagingException {
        String clientCanal = String.format("/topic/%s", scannedQRCode.getCanal());
        messagingTemplate.convertAndSend(clientCanal, new TextContent(scannedQRCode.getContent()));
    }

    @GetMapping("/api/v1/scan/{token}/{text}")
    public void greeting(@PathVariable String token, @PathVariable String text) throws MessagingException {
        String clientCanal = String.format("/topic/%s", token);
        messagingTemplate.convertAndSend(clientCanal, new TextContent(text));
    }
}
