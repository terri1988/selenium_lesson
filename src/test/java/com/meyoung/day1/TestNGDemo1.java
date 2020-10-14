package com.meyoung.day1;

import org.testng.annotations.*;

public class TestNGDemo1 {

    @BeforeTest
    public void beforeTestCase01() {
        System.out.println("@BeforeTest annotations");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("@BeforeMethod annotations");
    }

    @Test
    public void testCase1() {
        System.out.println("@Test annotations case1");
    }

    @Test
    public void testCase2() {
        System.out.println("@Test annotations case2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("@AfterMethod annotations");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest annotations");
    }
}
