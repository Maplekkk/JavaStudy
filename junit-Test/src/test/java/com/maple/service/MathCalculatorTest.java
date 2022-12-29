package com.maple.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * ClassName:MathCalculatorTest
 * Package: com.maple.service
 * Description:
 * Author maple
 * Create 2022-12-29
 * Version: v1.0
 */

// 类名的规范:  测试类名 + Test
public class MathCalculatorTest {
    // 一般是一个业务一个测试
    // 测试方法的规范: public void testXxx(){}
    @Test
    public void testSum(){
        // 单元测试中有两个重要的规范
        // 实际值 和 期望值
        MathCalculator mathCalculator = new MathCalculator();
        int actual = mathCalculator.sum(5, 5);
        int expected = 10;
        Assert.assertEquals(expected, actual);
    }
}
