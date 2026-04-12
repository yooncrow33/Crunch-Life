package com.dsce.base.core.graphics.popup;

import com.dsce.base.core.Game;
import com.dsce.base.core.contents.staff.Staff;
import com.dsce.base.core.contents.team.Team;
import com.dsce.base.core.graphics.popup.internal.Popup;
import com.dsce.base.core.window.tabs.StaffTab;

public class DismissPopup extends Popup {

    @Override
    public void exe() {
        Staff s = Game.staffs.get(StaffTab.selectedStaffIndex);
        Game.staffs.remove(StaffTab.selectedStaffIndex);
        for (Team t : Game.teams) {
            t.removeStaffForTeam(s);
        }
    }

    public DismissPopup() {
        super("Are You Sure?","Dismiss","dismissp");
    }
}
