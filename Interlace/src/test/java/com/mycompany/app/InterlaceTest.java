package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class InterlaceTest {
    public void test_that_two_zeros_gave_one_zero(){
        Assert.assertEquals(new Interlace().interlace(0, 0), 0);
    }

    public void test_that_0_and_1_gave_one(){
        Assert.assertEquals(new Interlace().interlace(0, 1), 1);
    }

    public void test_that_1_and_0_gave_10(){
        Assert.assertEquals(new Interlace().interlace(1, 0), 10);
    }

    public void test_that_0_and_11_gave_11(){
        Assert.assertEquals(new Interlace().interlace(0, 11), 11);
    }

    public void test_that_11_and_0_gave_101(){
        Assert.assertEquals(new Interlace().interlace(11, 0), 101);
    }

    public void test_that_1111_and_22_gave_121211(){
        Assert.assertEquals(new Interlace().interlace(1111, 22), 121211);
    }

    public void test_that_11_and_222222_gave_12122222(){
        Assert.assertEquals(new Interlace().interlace(11, 222222), 12122222);
    }

}