package com.proxy.practice;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class ReflectionTest {
    @Test
    public void invokeMethod() throws Exception {
        String name = "Icarus";

        // length()
        assertEquals(6, name.length());

        Method lengthMethod = String.class.getMethod("length");
        assertEquals(6, (Integer)lengthMethod.invoke(name));

        // charAt()
        assertEquals('I', name.charAt(0));

        Method charAtMethod = String.class.getMethod("charAt", int.class);
        assertEquals('I', (Character)charAtMethod.invoke(name, 0));
    }
}
