package com.proxy.practice.service;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

class HelloTargetTest {

    @Test
    void simpleProxy() {
        Hello hello = new HelloTarget();
        assertEquals("Hello Icarus", hello.sayHello("Icarus"));
        assertEquals("Hi Icarus", hello.sayHi("Icarus"));
        assertEquals("Thank You Icarus", hello.sayThankYou("Icarus"));
    }

    @Test
    void helloUppercaseTest() {
        Hello proxiedHello = new HelloUppercase(new HelloTarget());
        assertEquals("HELLO ICARUS", proxiedHello.sayHello("Icarus"));
        assertEquals("HI ICARUS", proxiedHello.sayHi("Icarus"));
        assertEquals("THANK YOU ICARUS", proxiedHello.sayThankYou("Icarus"));
    }

    @Test
    void dynamicProxyTest() {
        Hello proxiedHello = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{Hello.class},
                new UppercaseHandler(new HelloTarget())
        );

        assertEquals("HELLO ICARUS", proxiedHello.sayHello("Icarus"));
        assertEquals("HI ICARUS", proxiedHello.sayHi("Icarus"));
        assertEquals("THANK YOU ICARUS", proxiedHello.sayThankYou("Icarus"));
    }
}