package com.dsce.base.core.graphics.overlay;

import com.dsce.base.core.Game;
import com.dsce.base.core.contents.staff.Staff;
import com.dsce.base.core.contents.team.Team;
import com.dsce.base.core.graphics.overlay.internal.ListOverlay;
import com.dsce.base.core.graphics.overlay.internal.OverlayManager;
import com.dsce.base.core.window.tabs.StaffTab;

public class TeamChangeAtTeamTabListOverlay extends ListOverlay {

    public TeamChangeAtTeamTabListOverlay(String key) {
        super(key, Game.teams);
        OverlayManager.registerListOverly(key,this);
    }

    @Override
    public void exe() {
        Team t = (Team) getCurrentValue();
        Staff s = Game.teams.get(StaffTab.selectedTeamIndex).staffs.get(StaffTab.selectedStaffAtTeam);
        for (Team tt : Game.teams) {
            tt.removeStaffForTeam(s);
            System.out.println(s.getName());
        }
        t.addStaffForTeam(s);
        System.out.println(s.getTeam());
        StaffTab.selectedStaffAtTeam = 0;
        StaffTab.selectedStaffIndex = 0;
        StaffTab.selectedTeamIndex = 0;
    }
}
