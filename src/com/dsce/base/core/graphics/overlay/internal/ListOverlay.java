package com.dsce.base.core.graphics.overlay.internal;

import com.dsce.base.sys.mouse.Mouse;
import com.dsce.base.utils.RenderU;

import java.awt.*;
import java.util.ArrayList;

public abstract class ListOverlay {
    int mdx, mdy = 20;
    int width = 500;
    int height = 390;
    final ArrayList<?  extends ArrList> list;
    public int listScrollY = 50;
    public int maxListScrollY = 0;
    public int selectedIndex = 0;
    public boolean enabled = false;
    public String key;

    public ListOverlay(String key, ArrayList<? extends ArrList> list) {
        this.key = key;
        this.list = list;
    }

    public void clickEvent() {
        for (int i = 0; i < list.size(); i++) {
            if (Mouse.g().x()>= OverlayManager.x &&Mouse.g().x()<= OverlayManager.x +width&& OverlayManager.y +listScrollY +(i*50)<= Mouse.g().y()&&50+ OverlayManager.y +listScrollY +(i*50)>=Mouse.g().y()) {
                //managementSelectedProject =  list.get(i);
                selectedIndex = i;
            }
        }
        if (Mouse.g().x()>=OverlayManager.x+width-30&&Mouse.g().x()<=OverlayManager.x+width&&Mouse.g().y()>=OverlayManager.y&&Mouse.g().y()<=OverlayManager.y+30) {
            OverlayManager.allDisabled();
            OverlayManager.requestFocus = false;
        }
        if (Mouse.g().x()>=OverlayManager.x&&Mouse.g().x()<=OverlayManager.x+width&&Mouse.g().y()>=OverlayManager.y+350&&Mouse.g().y()<=OverlayManager.y+390) {
            //exe
            exe();
            OverlayManager.allDisabled();
            OverlayManager.requestFocus = false;
        }
    }
    public void render(Graphics g) {
        if (list.size() >= 7) {
            int i = list.size() - 7;
            maxListScrollY = i*50;
        } else {
            maxListScrollY = 0;
        }
        g.setColor(Color.white);
        g.fillRect(OverlayManager.x -5, OverlayManager.y -5,width+10,height+10);

        g.setColor(Color.black);
        g.fillRect(OverlayManager.x, OverlayManager.y,width,height);

        ((Graphics2D) g).setStroke(new BasicStroke(3f));
        g.setColor(Color.black);
        g.drawRect(OverlayManager.x -2, OverlayManager.y -2,width+4,height+4);

        for (int i = 0; i < list.size(); i++) {
            if (OverlayManager.y + listScrollY + (i * 50) < OverlayManager.y) continue;
            if (i==selectedIndex) {
                g.setColor(Color.white);
                g.fillRect(OverlayManager.x, OverlayManager.y + listScrollY + (i * 50), width, 50);
                g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 32));
                g.setColor(Color.blue);
                g.drawString(list.get(i).getLabel(), OverlayManager.x +10, OverlayManager.y + listScrollY + (i * 50) + 35);
                g.setColor(Color.black);
                g.drawString("| " + list.get(i).getValue(), OverlayManager.x +200, OverlayManager.y + listScrollY + (i * 50) + 35);
            } else {
                if ((i & 1) == 0) {
                    g.setColor(new Color(5, 100, 135));
                } else {
                    g.setColor(new Color(25, 130, 185));
                }
                g.fillRect(OverlayManager.x, OverlayManager.y + listScrollY + (i * 50), width, 50);
                g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 32));
                g.setColor(Color.green);
                g.drawString(list.get(i).getLabel(), OverlayManager.x +10, OverlayManager.y + listScrollY + (i * 50) + 35);
                g.setColor(Color.white);
                g.drawString("| " + list.get(i).getValue(), OverlayManager.x +200, OverlayManager.y + listScrollY + (i * 50) + 35);
            }
            if (listScrollY+(i*50)>=300) {
                break;
            }
        }

        g.setColor(Color.gray);
        g.fillRect(OverlayManager.x,OverlayManager.y,width,50);
        g.setColor(Color.blue);
        g.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
        RenderU.drawStringCenter(g,"List Overly v0.1", OverlayManager.x+250,OverlayManager.y+18);

        g.setColor(Color.red);
        g.fillRect(OverlayManager.x+width-30,OverlayManager.y,30,30);

        g.setColor(Color.gray);
        g.fillRect(OverlayManager.x,OverlayManager.y+350,width,40);
        g.setColor(Color.blue);
        g.setFont(new Font(Font.MONOSPACED,Font.BOLD,35));
        RenderU.drawStringCenter(g,"Execute!", OverlayManager.x+250,OverlayManager.y+350+15);
    }

    public void scrollUp() {
        if (!enabled) return;
        listScrollY += 25;
        if (listScrollY >= 50) listScrollY = 50;
    }

    public void scrollUDown() {
        if (!enabled) return;
        listScrollY -= 25;
        if (listScrollY <= maxListScrollY) listScrollY = maxListScrollY;
    }

    public ArrList getCurrentValue() {
        return list.get(selectedIndex);
    }

    public abstract void exe();
}
