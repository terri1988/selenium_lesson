package com.meyoung.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo2 {
    //校验 assertEquals a==b
    @Test
    public void assertEqualTest() {
        String a = "username";
        String b = "username2";
//    assert之后不要接任何操作，防止第一个assert失败后，之后的操作没有被执行到
        Assert.assertEquals(a, b, "a not equals b");
        Assert.assertEquals(a, b);
    }

    //校验 assertNotEquals a!=b
    @Test
    public void assertNotEqualTest() {
        int a = 1;
        int b = 1;
        Assert.assertNotEquals(a, b, "a equals b");
    }

    //校验 assertNull
    @Test
    public void assertNullTest() {
        String a = "";
        Assert.assertNull(a,"a is not null");
    }

    //校验 assertNotNull
    @Test
    public void assertNotNullTest() {
        String a = null;
        Assert.assertNotNull(a,"a is null");
    }

    //校验 assertFalse and assertTrue
    @Test
    public void assertFalseTest() {
        Boolean a = true;
        Assert.assertTrue(a,"a is not true");
        Assert.assertFalse(a,"a is not false");
    }
}
