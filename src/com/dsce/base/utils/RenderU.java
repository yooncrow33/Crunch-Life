package com.dsce.base.utils;

import com.dsce.base.core.graphics.Button;
import com.dsce.base.core.graphics.ScrollButton;
import com.dsce.base.sys.Console;

import java.awt.*;

public class RenderU {
    public static void drawStringCenter(Graphics g, String text, int x, int y) {
        FontMetrics metrics = g.getFontMetrics();

        int textWidth = metrics.stringWidth(text);

        int drawX = x - (textWidth / 2);

        int textHeight = metrics.getAscent();
        int drawY = y + (textHeight / 2);

        g.drawString(text, drawX, drawY);
    }

    public static void applyQualityHints(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    }

    public static void drawButton(Graphics g, Button button, Color enableColor,Color disableColor, Color color, Color textColor,int fontSize,String text, int fontOffset) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2f));
        g.setColor(button.isOnMouse()? enableColor : disableColor);
        g.fillRect(button.getX(),button.getY(),button.getW(),button.getH());
        g.setColor(color);
        g.drawRect(button.getX(),button.getY(),button.getW()-2,button.getH()-2);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, fontSize));
        g.setColor(textColor);
        RenderU.drawStringCenter(g,text,button.getX()+(button.getW()/2),button.getY()+fontOffset);
    }

    public static void drawScrollButton(Graphics g, ScrollButton button, Color enableColor, Color disableColor, Color color, Color textColor, int fontSize, String text, int fontOffset) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2f));
        g.setColor(button.isOnMouse()? enableColor : disableColor);
        g.fillRect(button.getX(),button.getY(),button.getW(),button.getH());
        g.setColor(color);
        g.drawRect(button.getX(),button.getY(),button.getW()-2,button.getH()-2);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, fontSize));
        g.setColor(textColor);
        RenderU.drawStringCenter(g,text,button.getX()+(button.getW()/2),button.getY()+fontOffset);
    }
}
