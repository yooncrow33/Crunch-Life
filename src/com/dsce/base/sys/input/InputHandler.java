package com.dsce.base.sys.input;

import com.dsce.base.core.text.InputText;
import com.dsce.base.sys.Main;
import com.dsce.base.sys.ViewMetrics;
import com.dsce.base.sys.file.FileManager;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
    private final ViewMetrics viewMetrics;
    private final Main main;
    InputExecutor inputExecutor = null;

    private static boolean requestInputTextForGameStringBuilder = false;

    public static boolean isRequestInputTextForGameStringBuilder() {
        return requestInputTextForGameStringBuilder;
    }

    public static void setRequestInputTextForGameStringBuilder(boolean requestInputTextForGameStringBuilder) {
        InputHandler.requestInputTextForGameStringBuilder = requestInputTextForGameStringBuilder;
    }

    public void registerInputExecutor(InputExecutor inputExecutor) {
        this.inputExecutor = inputExecutor;
    }

    public InputHandler(ViewMetrics viewMetrics, Main main) {
        this.viewMetrics = viewMetrics;
        this.main = main;
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
            if (e.getID() == KeyEvent.KEY_TYPED && main.getConsole().isOpen()) {
                char c = e.getKeyChar();
                if (c != '\n' && c != '\b' && c != 27) {
                    main.getConsole().inputKey(c, 0);
                }
            } else if (e.getID() == KeyEvent.KEY_TYPED && requestInputTextForGameStringBuilder) {
                char c = e.getKeyChar();
                if (c != '\n' && c != '\b' && c != 27) {
                    InputText.inputKey(c,0);
                }
            }
            return false;
        });

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F12) {
            main.getConsole().toggle();
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (main.getConsole().isOpen()) main.getConsole().inputKey('\n', 10);
            if (requestInputTextForGameStringBuilder) {
                InputText.inputKey('\n', 10);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (main.getConsole().isOpen()) main.getConsole().inputKey('\b', 8);
            if (requestInputTextForGameStringBuilder) {
                InputText.inputKey('\b', 8);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (main.getConsole().isOpen()) {main.getConsole().inputKey('\b', 8); return;}
            if (requestInputTextForGameStringBuilder) {
                InputText.inputKey('\b', 8);
            }
            FileManager.save(main.game);
            System.exit(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_M) {
            viewMetrics.calculateViewMetrics();
        }
       if (inputExecutor != null) { inputExecutor.keyPressedExe(e); }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (inputExecutor != null) { inputExecutor.keyReleasedExe(e); }
    }

}
