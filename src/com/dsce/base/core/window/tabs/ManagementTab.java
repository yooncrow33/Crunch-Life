package com.dsce.base.core.window.tabs;

import com.dsce.base.core.Game;

import java.awt.*;

public class ManagementTab extends Tab {

    public static int scrollY = 0;

    @Override
    public void render(Graphics g) {
        for(int i = 0; i< Game.projects.toArray().length; i++) {
            if ((i & 1) == 0) {
                g.setColor(new Color(5,100,135));
            } else{
                g.setColor(new Color(25,130,185));
            }
            g.fillRect(0,100+scrollY+(i*50),1920,50);
            g.setColor(Color.white);
            g.setFont(new Font(Font.MONOSPACED,Font.PLAIN, 40));
            if (Game.projects.get(i).getProjectEngineType().toString() == null) {
                System.err.println("project name is null");
                System.out.println(Game.projects.toArray().length);
                System.exit(0);
            }
            g.drawString(Game.projects.get(i).getProjectEngineType().toString(),10,100+scrollY+(i*50)+45);
        }
    }
}
