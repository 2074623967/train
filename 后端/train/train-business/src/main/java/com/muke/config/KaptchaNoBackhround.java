package com.muke.config;

import com.google.code.kaptcha.BackgroundProducer;
import com.google.code.kaptcha.util.Configurable;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * 验证码背景
 *
 * @author tangcj
 * @date 2024/01/26 11:34
 **/
public class KaptchaNoBackhround extends Configurable implements BackgroundProducer {

    public KaptchaNoBackhround(){
    }
    @Override
    public BufferedImage addBackground(BufferedImage baseImage) {
        int width = baseImage.getWidth();
        int height = baseImage.getHeight();
        BufferedImage imageWithBackground = new BufferedImage(width, height, 1);
        Graphics2D graph = (Graphics2D)imageWithBackground.getGraphics();
        graph.fill(new Rectangle2D.Double(0.0D, 0.0D, (double)width, (double)height));
        graph.drawImage(baseImage, 0, 0, null);
        return imageWithBackground;
    }
}
