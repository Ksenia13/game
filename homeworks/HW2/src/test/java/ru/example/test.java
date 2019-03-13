package ru.example;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;


public class test {
    @Test
    public void test1() throws Exception {
        assertEquals("Unexpected value", main.count("/Users/Fortapianka/Desktop/test1.txt"), 1);
    }
    @Test
    public void test2() throws Exception {
        assertEquals("Unexpected value", main.count("/Users/Fortapianka/Desktop/test2.txt"), 2);
    }
}
