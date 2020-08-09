package com.gmail.brian.model;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RectangularTest {
    Rectangular rectangular;

    @Before
    public void init() {
        rectangular = new Rectangular();
    }

    @Test
    public void CalculationWeigh_WhenNoIsolation_ShouldReturnCorrectValue(){
        rectangular.setInsulation(false);
        rectangular.setOutdoor(false);
        rectangular.setSideA(200);
        rectangular.setSideB(200);
        Assert.assertEquals(8.2,rectangular.CalculationWeigh(),0.1);
    }

}
