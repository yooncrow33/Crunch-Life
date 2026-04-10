package com.dsce.base.core.popup.internal;


import com.dsce.base.core.graphics.Button;
import com.dsce.base.utils.RenderU;

import java.awt.*;

public abstract class Popup {
    final String title;
    final String e;
    private final int centerX = 1920/2;
    private final int centerY = 1080/2;
    public final String key;
    Button y = new Button(1920/2-300+20,800,260,90);
    Button n = new Button(1920/2+20,800,260,90);
    public boolean enabled = false;
    public Popup(String title, String explanation, String key) {
        this.title = title;
        this.e = explanation;
        PopupManager.registerPopup(key,this);
        this.key = key;
    }
    public abstract void exe();
    public void clickEvent() {
        if (!enabled) {
            return;
        }
        if (y.isOnMouse()) {
            exe();
            enabled = false;
        } else if (n.isOnMouse()) {
            enabled = false;
        }
    }
    public void render(Graphics g) {
        g.setColor(new Color(0,0,0,150));
        g.fillRect(-3000,-3000,900000,900000);
        g.setColor(Color.white);
        g.fillRect(centerX-300,centerY-200,600,400);
        Color darkBlue = new Color(5,80,125);
        g.setColor(darkBlue);
        g.fillRect(centerX-298,centerY-198,596,396);
        g.setFont(new Font(Font.MONOSPACED,Font.BOLD ,64));
        g.setColor(Color.white);
        RenderU.drawStringCenter(g,title,1920/2,400);

        g.setFont(new Font(Font.MONOSPACED,Font.BOLD ,48));
        RenderU.drawStringCenter(g,e,1920/2,600);

        RenderU.drawButton(g,y,Color.green,Color.gray,Color.white,Color.black,32,"Y",25);
        RenderU.drawButton(g,n,Color.green,Color.gray,Color.white,Color.black,32,"N",25);
    }
}
