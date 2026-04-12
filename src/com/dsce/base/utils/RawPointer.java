package com.dsce.base.utils;

import sun.misc.Unsafe;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class RawPointer {
    private static final Unsafe unsafe;
    private final Object base;
    private final long offset;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public RawPointer(Object target, String fieldName) {
        try {
            Field field;
            if (target instanceof Class<?> clazz) {
                // target이 클래스면 static 필드로 취급
                field = clazz.getDeclaredField(fieldName);
                this.base = unsafe.staticFieldBase(field);
                this.offset = unsafe.staticFieldOffset(field);
            } else {
                // target이 객체면 인스턴스 필드로 취급
                field = target.getClass().getDeclaredField(fieldName);
                this.base = target;
                this.offset = unsafe.objectFieldOffset(field);
            }
        } catch (Exception e) {
            throw new RuntimeException("포인터 생성 실패: " + fieldName, e);
        }
    }

    public int getInt() { return unsafe.getInt(base, offset); }
    public void setInt(int val) { unsafe.putInt(base, offset, val); }
}