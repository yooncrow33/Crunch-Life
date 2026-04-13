package com.dsce.base.core.contents.staff.inetnal;

import com.dsce.base.core.contents.staff.Staff;
import com.dsce.base.utils.RTraitOption;
import com.dsce.base.utils.Utils;

public class RandomStaff extends Staff {

   public int scan = 0;

   public boolean isGetTrait = Math.random() >= 0.5;

    public RandomStaff(Boolean dummy) {
        if (dummy) {
            registerName("Dummy");
            registerXp((0.0f));
            registerTeam("Basic");

            // --- Language Levels ---
            registercLevel((0.0f));
            registerCppLevel((0.0f));
            registerRustLevel((0.0f));
            registerJavaLevel((0.0f));
            registerKotlinLevel((0.0f));
            registerCsLevel((0.0f));
            registerPyLevel((0.0f));
            registerJsLevel((0.0f));

            // --- Engine Levels ---
            registerUnityLevel((0.0f));
            registerGodotLevel((0.0f));
            registerUnrealLevel((0.0f));
            registerLwjglLevel((0.0f));
            registerLibgdxLevel((0.0f));

            // --- Graphics API Levels ---
            registerVulkanLevel((0.0f));
            registerDirectxLevel((0.0f));
            registerOpenglLevel((0.0f));

            registerLaborCost(20000); // temp value

            updateStack();

            super.dummy = dummy;
        }
    }

    public boolean isDummy() {
        return dummy;
    }

    public RandomStaff() {
        registerName(Utils.getRandomName());
        registerXp((float)Math.random());
        registerTeam("Basic");

        // --- Language Levels ---
        registercLevel((float)Math.random());
        registerCppLevel((float)Math.random());
        registerRustLevel((float)Math.random());
        registerJavaLevel((float)Math.random());
        registerKotlinLevel((float)Math.random());
        registerCsLevel((float)Math.random());
        registerPyLevel((float)Math.random());
        registerJsLevel((float)Math.random());

        // --- Engine Levels ---
        registerUnityLevel((float)Math.random());
        registerGodotLevel((float)Math.random());
        registerUnrealLevel((float)Math.random());
        registerLwjglLevel((float)Math.random());
        registerLibgdxLevel((float)Math.random());

        // --- Graphics API Levels ---
        registerVulkanLevel((float)Math.random());
        registerDirectxLevel((float)Math.random());
        registerOpenglLevel((float)Math.random());

        registerLaborCost(300); // temp value

        if (isGetTrait) {
            super.Traits.add(new Trait(RTraitOption.getRandomTrait()));
        }

        updateStack();
    }
}
