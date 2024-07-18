package com.io.unittest.junit;

import org.junit.Ignore;
import org.junit.Test;


@Ignore
public class IgnoreTest {

    @Test
    public void testMerhaba() throws Exception {
        System.out.println("Hello");
    }

    @Test
    @Ignore("This method will be used recently")
    public void testMerhaba2() throws Exception {
        System.out.println("Hello 2");
    }
}