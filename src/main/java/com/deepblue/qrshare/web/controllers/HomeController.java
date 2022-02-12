package com.deepblue.qrshare.web.controllers;

import com.deepblue.qrshare.business.conversion.Base64Converter;
import com.deepblue.qrshare.business.generation.QRGenerator;
import com.deepblue.qrshare.business.generation.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;

@Controller
public class HomeController {

    @Autowired
    private QRGenerator qrGenerator;
    @Autowired
    private Base64Converter base64Converter;
    @Autowired
    private TokenGenerator tokenGenerator;

    @GetMapping("/")
    public String home(Model model) throws IOException {
        String token = tokenGenerator.generateToken();
        File generatedQRCode = qrGenerator.generateQRCodeImage(token);
        String base64QRCode = base64Converter.toBase64(generatedQRCode);
        model.addAttribute("qrcode", String.format("data:image/png;base64,%s", base64QRCode));
        model.addAttribute("token", token);
        return "home";
    }
}
