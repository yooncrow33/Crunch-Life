package com.dsce.base.core.window;

import com.dsce.base.core.window.tabs.ManagementTab;
import com.dsce.base.core.window.tabs.ProjectCreateTab;
import com.dsce.base.utils.Utils;

import java.awt.*;

public class Window {
    final int width = 1920;
    final int height = 880;
    public int windowTabIndex = 0;

    public ProjectCreateTab projectCreateTab = new ProjectCreateTab();
    public ManagementTab managementTab = new ManagementTab();

    public void render(Graphics g) {
        switch (windowTabIndex) {
            case 0:
                //new project
                projectCreateTab.render(g);
                break;
            case 1:
                //project management
                managementTab.render(g);
                break;
            case 2:
                //docs

                break;
            case 3:
                //staff

                break;
            case 4:
                //break room

                break;
            case 5:
                //community

                break;
            default:
                System.err.println("Invalid Window Index: " + windowTabIndex);
                System.err.println("Window Index Error! " + Utils.getReportMessage());
                break;
        }
    }
}
