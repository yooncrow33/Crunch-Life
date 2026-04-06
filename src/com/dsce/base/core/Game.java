package com.dsce.base.core;

import com.dsce.base.core.contents.project.Project;
import com.dsce.base.core.graphics.Button;
import com.dsce.base.core.graphics.Shutter;
import com.dsce.base.core.window.Window;
import com.dsce.base.sys.mouse.Click;
import com.dsce.base.sys.mouse.IClickEvent;
import com.dsce.base.utils.RenderU;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Game implements IClickEvent {
    public static Map<String, Button> buttonMap = new LinkedHashMap<>();

    String barButtonsKeys[] = {"newProject","projectManagement","docs","staff","breakroom","community"};
    String barButtonLabels[] = {"New Project","Management","Docs","Staff","Break room","Community"};

    public static String projectCreateTabStep0ButtonKeys[] = {"projectCreateStart"};
    public static String projectCreateTabStep1ButtonKeys[] = {"unity", "unreal", "godot", "libgdx", "lwjgl"};
    public static String projectCreateTabStep2ButtonKeys[] = {"c", "cpp", "rust", "java", "kotlin", "cs", "js", "py"};
    public static String projectCreateTabStep3ButtonKeys[] = {"vulkan", "opengl", "directx"};
    public static String projectCreateTabStep4ButtonKeys[] = {"prototype", "standard", "LTS"};
    public static String projectCreateTabStep5ButtonKeys[] = {"projectCreate"};
    public static String[] projectCreateTabButtons[] = {projectCreateTabStep0ButtonKeys,projectCreateTabStep1ButtonKeys,projectCreateTabStep2ButtonKeys,projectCreateTabStep3ButtonKeys,projectCreateTabStep4ButtonKeys,projectCreateTabStep5ButtonKeys};

    GameState.state state = GameState.state.night;

    final com.dsce.base.core.window.Window window = new Window();
    final Shutter shutter = new Shutter(this);

    private static ArrayList<Project> projects = new ArrayList<>();

    public static void addProject(Project p) {
        projects.add(p);
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public Game() {
        Click.g().registerClickEventObject(this::clickEvent);
        buttonMap.put("commit",new Button(1920-310,1080-90,300,80));
        buttonMap.put("projectCreateNext",new Button(1920-260,1080-70-100,250,60));
        buttonMap.put("projectCreateBack",new Button(1920-260-260,1080-70-100,250,60));
        for (int i = 0; i < barButtonsKeys.length; i++) {
            buttonMap.put(barButtonsKeys[i],new Button(10+(i*260),1010,250,60));
        }
        for (int i = 0; i < projectCreateTabButtons.length; i++) {
            if (i == 0 || i == 5) {
                buttonMap.put(projectCreateTabButtons[i][0],new Button(1920/2-150,1080-100-120,300,80));
            } else {
                for (int ie = 0; ie < projectCreateTabButtons[i].length; ie++) {
                    buttonMap.put(projectCreateTabButtons[i][ie],new Button((1920/2)-250,260+(ie*70),500,60));
                }
            }
        }
    }

    public void update(double deltaTime) {
        shutter.update();
    }

    @Override
    public void clickEvent() {
        for (int i = 0; i < barButtonsKeys.length; i++) {
            if (buttonMap.get(barButtonsKeys[i]).isOnMouse()) {
                window.windowTabIndex = i;
            }
        }
        if (state == GameState.state.day) {
            if (buttonMap.get("commit").isOnMouse()) {
                shutter.changScreen(GameState.state.night);
            }
            if (window.windowTabIndex == 0) {
                window.projectCreateTab.clickEvent();
            }
        } else if (state == GameState.state.night) {
            if (buttonMap.get("commit").isOnMouse()) {
                shutter.changScreen(GameState.state.day);
            }
        }
    }

    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Color darkBlue = new Color(5,80,125);
        //backGround
        g.setColor(Color.black);
        g.fillRect(-5000,-5000,100000,1000000);
        if (state == GameState.state.night) {
            //interface
            g.setColor(darkBlue);
            g.fillRect(0,0,1920,100);
            g.fillRect(0,980,1920,100);
            //commit button
            g2.setStroke(new BasicStroke(2f));
            Button commitButton = buttonMap.get("commit");
            g.setColor(commitButton.isOnMouse()? Color.green : Color.gray);
            g.fillRect(commitButton.getX(),commitButton.getY(),commitButton.getW(),commitButton.getH());
            g.setColor(Color.white);
            g.drawRect(commitButton.getX(),commitButton.getY(),commitButton.getW()-2,commitButton.getH()-2);
            g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 36));
            g.setColor(Color.black);
            RenderU.drawStringCenter(g,"Next Day",commitButton.getX()+(commitButton.getW()/2),commitButton.getY()+32);

        } else if (state == GameState.state.day) {
            //interface
            g.setColor(darkBlue);
            g.fillRect(0,0,1920,100);
            g.fillRect(0,980,1920,100);
            //commit button
            g2.setStroke(new BasicStroke(2f));
            Button commitButton = buttonMap.get("commit");
            g.setColor(commitButton.isOnMouse()? Color.green : Color.gray);
            g.fillRect(commitButton.getX(),commitButton.getY(),commitButton.getW(),commitButton.getH());
            g.setColor(Color.white);
            g.drawRect(commitButton.getX(),commitButton.getY(),commitButton.getW()-2,commitButton.getH()-2);
            g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 64));
            g.setColor(Color.black);
            RenderU.drawStringCenter(g,"Commit",commitButton.getX()+(commitButton.getW()/2),commitButton.getY()+32);
            //buttons
            g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
            for (int i = 0; i < barButtonsKeys.length; i++) {
                Button currentButton = buttonMap.get(barButtonsKeys[i]);
                g.setColor(currentButton.isOnMouse()? Color.green : Color.gray);
                g.fillRect(currentButton.getX(),currentButton.getY(),currentButton.getW(),currentButton.getH());
                g.setColor(Color.white);
                g.drawRect(currentButton.getX(),currentButton.getY(),currentButton.getW()-2,currentButton.getH()-2);
                g.setColor(Color.black);
                RenderU.drawStringCenter(g, barButtonLabels[i],currentButton.getX()+(currentButton.getW()/2),currentButton.getY()+26);
            }
            //top bar
            g.setColor(Color.white);
            g.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 24));
            g.drawString(barButtonLabels[window.windowTabIndex]+ " Tab", 10,90);


            //window
            window.render(g);

            //end
            g.setColor(Color.white);
            g2.setStroke(new BasicStroke(2f));
            g.drawRect(0,0,1918,1078);
        }
        shutter.render(g);
    }
    public void setState(GameState.state state) {
        this.state = state;
    }
}