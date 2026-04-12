package com.dsce.base.sys.mouse;

import com.dsce.base.core.graphics.overlay.internal.OverlayManager;
import com.dsce.base.core.graphics.popup.internal.PopupManager;

import java.util.ArrayList;

public class Click {
    private static Click instance;
    private ArrayList<IClickEvent> clickEvents = new ArrayList<>();

    public static Click g() {
        if (instance == null) instance = new Click();
        return instance;
    }

    private Click() {}

    public void clickEvent() {
        if (PopupManager.requestFocus) {
            PopupManager.clickEvent();
            return;
        }

        if (OverlayManager.requestFocus) {
            OverlayManager.clickEvent();
            return;
        }

        for (IClickEvent iClickEvent : clickEvents) {
            iClickEvent.clickEvent();
        }
    }

    public void registerClickEventObject(IClickEvent iClickEvent) {
        if (iClickEvent != null && !clickEvents.contains(iClickEvent)) {
            clickEvents.add(iClickEvent);
        }
    }
    public void unregisterClickEventObject(IClickEvent iClickEvent) {
        clickEvents.remove(iClickEvent);
    }

}
