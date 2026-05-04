package com.dsce.base.core.contents.team;

import com.dsce.base.core.Game;
import com.dsce.base.core.contents.staff.Staff;
import com.dsce.base.core.graphics.overlay.internal.ArrList;
import com.dsce.base.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Team implements ArrList {
    public Map<String, Staff> staffs = new LinkedHashMap<>();
    String name;

    public void registerName(String name) {
        this.name = name;
    }

    public void registerStaffs(Map<String,Staff> staffs) {
        this.staffs = staffs;
    }

    public String getName() {
        return name;
    }

    public void addStaffForTeam(Staff s) {
        for (Team t : Game.teams) {
            t.staffs.remove(s.getId());
        }
        staffs.put(s.getId(), s);
        s.registerTeam(getName());
    }

    public void removeStaffForTeam(Staff s) {
        try {
            staffs.get(s.getId()).registerTeam("Basic");
        } catch(Exception e) {
            System.err.println("No Staff in Team! Error! " + Utils.getReportMessage());
        }
        staffs.remove(s.getId());
    }

    @Override
    public String getLabel() {
        return getName();
    }

    @Override
    public String getValue() {
        return "scale : " + staffs.size();
    }
}
