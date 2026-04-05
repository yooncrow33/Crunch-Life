package com.dsce.base.core.contents.project.internal;

public class Engine {
    public enum type {
        unity(0.8f, 0.5f, 0.1f),
        unreal(0.4f, 0.9f, 0.4f),
        godot(0.7f, 0.6f, 0.2f),
        lwjgl(0.3f, 1.0f, 1.0f),
        libGDX(0.6f, 0.7f, 0.3f);

        float speed;
        float optimization;
        float setupCost;

        public float getSetupCOst() {
            return setupCost;
        }

        type(float speed, float optimization, float setupCost) {
            this.speed = speed;
            this.optimization = optimization;
            this.setupCost = setupCost;
        }

        public float getOptimization() {
            return optimization;
        }

        public float getSpeed() {
            return speed;
        }
    }
}
