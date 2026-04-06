package com.dsce.base.core.text;

import com.dsce.base.sys.input.InputHandler;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class InputText {
    private static StringBuilder buffer = new StringBuilder();
    public static String lastInputWord = "";
    public static String currentWord = "";

    public static void initLastInputWord() {lastInputWord = null;}

    public static void inputKey(char key, int code) {
        if (!InputHandler.isRequestInputTextForGameStringBuilder()) {
            return;
        }
        currentWord=buffer.toString();
        if (code == 10) { // Enter Key Code
            String result = buffer.toString();
            lastInputWord = result;
            buffer.setLength(0); // 버퍼 초기화
            InputHandler.setRequestInputTextForGameStringBuilder(false);
        } else if (code == 8) { // Backspace
            if (buffer.length() > 0) {
                buffer.deleteCharAt(buffer.length() - 1);
            }
        } else {
            // 자바에서 char의 정수 값은 (int) 캐스팅이나 직접 비교가 가능합니다.
            if (key >= 32 && key <= 126) {
                buffer.append(key);
            }
        }
    }
}
