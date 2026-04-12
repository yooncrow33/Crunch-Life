package com.dsce.base.core.graphics.overlay.internal;

import com.dsce.base.sys.mouse.Mouse;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OverlayManager {
    public static Map<String, ListOverlay> listOverlays = new HashMap();

    private static int width = 500;
    private static int height = 390;

    public static int x,y = 200;

    public static boolean requestFocus = false;

    public static void setX(int xd) {
        x = xd;
    }

    public static void setY(int yd) {
        y = yd;
    }

    public static void addX(int xd) {
        x += xd;
    }

    public static void addY(int yd) {
        y += yd;
    }

    public static void registerListOverly(String key, ListOverlay listOverlay) {
        listOverlays.put(key,listOverlay);
    }

    public static void enableListOverlay(String key) {
        for (ListOverlay p : listOverlays.values()) {
            p.enabled = false;
            if (Objects.equals(p.key, key)) {
                p.enabled = true;
                OverlayManager.requestFocus = true;
            }
        }
    }

    public static void allDisabled() {
        for (ListOverlay p : listOverlays.values()) {
            p.enabled = false;
            OverlayManager.requestFocus = false;
        }
    }

    public static void render(Graphics g) {
        for (ListOverlay p : listOverlays.values()) {
            if (!p.enabled) continue;
            p.render(g);
        }
        checkBound();
    }

    public static void clickEvent() {
        if (!(Mouse.g().x()>=OverlayManager.x)||!(Mouse.g().x()<=OverlayManager.x+width)||!(Mouse.g().y()>=OverlayManager.y)||!(Mouse.g().y()<=OverlayManager.y+height)) {return;}
        for (ListOverlay p : listOverlays.values()) {
            if (p.enabled) {
                p.clickEvent();
            }
        }
    }

    public static void checkBound() {
        if (OverlayManager.x+width>=1920) OverlayManager.x = 1920-width;
        if (OverlayManager.x<=0) OverlayManager.x = 0;
        if (OverlayManager.y+height>=1080) OverlayManager.y = 1080-height;
        if (OverlayManager.y<=0) OverlayManager.y = 0;
    }

    public static void scrollUp() {
        if (!(Mouse.g().x()>=OverlayManager.x)||!(Mouse.g().x()<=OverlayManager.x+width)||!(Mouse.g().y()>=OverlayManager.y)||!(Mouse.g().y()<=OverlayManager.y+height)) {return;}
        for (ListOverlay p : listOverlays.values()) {
            if (p.enabled) {
                p.scrollUp();
            }
        }
    }
    public static void scrollDown() {
        if (!(Mouse.g().x()>=OverlayManager.x)||!(Mouse.g().x()<=OverlayManager.x+width)||!(Mouse.g().y()>=OverlayManager.y)||!(Mouse.g().y()<=OverlayManager.y+height)) {return;}
        for (ListOverlay p : listOverlays.values()) {
            if (p.enabled) {
                p.scrollUDown();
            }
        }
    }

}
