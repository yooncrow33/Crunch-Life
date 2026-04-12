package com.dsce.base.core.graphics.overlay;

import com.dsce.base.core.Game;
import com.dsce.base.core.graphics.overlay.internal.ListOverlay;
import com.dsce.base.core.graphics.overlay.internal.OverlayManager;

public class StaffListOverly extends ListOverlay {

    public StaffListOverly(String key) {
        super(key, Game.staffs);
        OverlayManager.registerListOverly(key,this);
    }

    @Override
    public void exe() {
        //null
    }
}
