package com.dsce.base.core.graphics.overlay;

import com.dsce.base.core.Game;
import com.dsce.base.core.contents.staff.Staff;
import com.dsce.base.core.contents.team.Team;
import com.dsce.base.core.graphics.overlay.internal.ListOverlay;
import com.dsce.base.core.graphics.overlay.internal.OverlayManager;
import com.dsce.base.core.window.tabs.StaffTab;

public class TeamChangeListOverlay extends ListOverlay {

    public TeamChangeListOverlay(String key) {
        super(key, Game.teams);
        OverlayManager.registerListOverly(key,this);
    }

    @Override
    public void exe() {
        Team t = (Team) getCurrentValue();
        Staff s = Game.staffs.get(StaffTab.selectedStaffIndex);
        for (Team tt : Game.teams) {
            tt.removeStaffForTeam(s);
        }
        t.addStaffForTeam(s);
    }
}
