package com.dsce.base.core.contents.project;

import com.dsce.base.core.contents.project.internal.Engine;
import com.dsce.base.core.contents.project.internal.Graphics;
import com.dsce.base.core.contents.project.internal.Lang;
import com.dsce.base.core.contents.project.internal.Platform;

public class Project {
    String name = "if you can see this word, it's a bug. please report to me about this bug. github: Crunch-Life";
    float codeQuality = 0.0f;
    float graphics = 0.0f;
    float funny = 0.0f;
    float addictive = 0.0f;
    boolean released = false;
    float price = 0.0f; //dollar
    float optimization = 0.0f;
    float stability = 0.0f;
    int fileSize = 0; //mb
    int scale = 0;
    ProjectType.type projectType = null;
    Engine.type projectEngineType = null;
    Graphics.type projectGraphicsType = null;
    Lang.type projectLangType = null;
    Platform.type projectPlatformType = null;

    public void registerName(String name) { this.name = name; }
    public void registerCodeQuality(float codeQuality) { this.codeQuality = codeQuality; }
    public void registerGraphics(float graphics) { this.graphics = graphics; }
    public void registerFunny(float funny) { this.funny = funny; }
    public void registerAddictive(float addictive) { this.addictive = addictive; }
    public void registerReleased(boolean released) { this.released = released; }
    public void registerPrice(float price) { this.price = price; }
    public void registerOptimization(float optimization) { this.optimization = optimization; }
    public void registerStability(float stability) { this.stability = stability; }
    public void registerFileSize(int fileSize) { this.fileSize = fileSize; }
    public void registerScale(int scale) { this.scale = scale; }
    public void registerProjectType(ProjectType.type projectType) { this.projectType = projectType; }
    public void registerProjectEngineType(Engine.type projectEngineType) { this.projectEngineType = projectEngineType; }
    public void registerProjectGraphicsType(Graphics.type projectGraphicsType) { this.projectGraphicsType = projectGraphicsType; }
    public void registerProjectLangType(Lang.type projectLangType) { this.projectLangType = projectLangType; }
    public void registerProjectPlatformType(Platform.type projectPlatformType) { this.projectPlatformType = projectPlatformType; }}
