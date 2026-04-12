package com.dsce.base.core.graphics;

import com.dsce.base.sys.mouse.Mouse;
import com.dsce.base.utils.RawPointer;

public class ScrollButton {
    final int x,y,w,h;
    RawPointer xs;
    RawPointer ys;

    public ScrollButton(int x, int y, int w, int h, RawPointer ScrollX, RawPointer ScrollY) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.xs = ScrollX;
        this.ys = ScrollY;
    }

    public int getX() {
        return x+xs.getInt();
    }

    public int getY() {
        return y+ ys.getInt();
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public boolean isOnMouse() {
        int curX = x + xs.getInt();
        int curY = y + ys.getInt();
        int mx = Mouse.g().x();
        int my = Mouse.g().y();

        return (mx >= curX && mx <= curX + w &&
                my >= curY && my <= curY + h);
    }
}
