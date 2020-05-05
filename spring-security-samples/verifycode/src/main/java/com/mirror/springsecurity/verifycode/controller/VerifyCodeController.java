package com.mirror.springsecurity.verifycode.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-05-05 13:36
 **/
@RestController
public class VerifyCodeController {

    @Autowired
    Producer producer;

    @GetMapping("/vc.jpg")
    public void getVerifyCode(HttpServletResponse response, HttpSession session) throws IOException {
        response.setContentType("image/jpeg");
        String text = producer.createText();
        session.setAttribute("verify_code", text);
        BufferedImage image = producer.createImage(text);
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            ImageIO.write(image, "jpg", outputStream);
        }
    }

}
