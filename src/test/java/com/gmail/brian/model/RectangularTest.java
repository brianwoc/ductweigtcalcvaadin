package com.gmail.brian.model;


import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;


public class RectangularTest {
    Rectangular rectangular;

    @Before
    public void init() {
        rectangular = new Rectangular();
        rectangular.setSideA(200);
        rectangular.setSideB(200);
        rectangular.Thickness();
    }

    @Test
    public void CalculationWeigh_WhenNoIsolation_ShouldReturnCorrectValue8(){
        rectangular.setInsulation(false);
        rectangular.setOutdoor(false);
        assertThat(rectangular.CalculationWeigh()).isEqualTo(8.2);
    }

    @Test
    public void CalculationWeigh_WhenWoolDuct630and430_ShouldReturnCorrectValue5(){
        rectangular.setInsulation(true);
        rectangular.setOutdoor(false);
        rectangular.setSideA(630);
        rectangular.setSideB(400);
        rectangular.setInsulationThickness(25);
        rectangular.setSteelThickness(0);
        assertThat(rectangular.CalculationWeigh()).isEqualTo(4.3);
    }

    @Test
    public void CalculationWeigh_WhenIsIsolation_ShouldReturn11(){
        rectangular.setInsulation(true);
        rectangular.setInsulationThickness(40);
        rectangular.setOutdoor(false);
        assertThat(rectangular.CalculationWeigh()).isEqualTo(11.3);
    }


    @Test
    public void CalculationWeigh_WhenIsIsolationAndOutdoor_ShouldReturn23(){
        rectangular.setInsulation(true);
        rectangular.setInsulationThickness(40);
        rectangular.setOutdoor(true);
        assertThat(rectangular.CalculationWeigh()).isEqualTo(22.8);
    }

    @Test
    public void CalculationWeigh_WhenPromat_ShouldReturn62(){
        rectangular.setSideA(1000);
        rectangular.setSideB(1000);
        rectangular.setInsulation(true);
        rectangular.setInsulationThickness(12);
        rectangular.setOutdoor(false);
        assertThat(rectangular.CalculationWeighPromat()).isEqualTo(62.3);
    }

    @Test
    public void  Thickness_WhenDuct1000and1000_ShouldReturn1(){
        //Given
        rectangular.setSideA(1000);
        rectangular.setSideB(1000);
        //When
        rectangular.Thickness();
        //Then
        assertThat(rectangular.SteelThickness).isEqualTo(1);
    }

    @Test
    public void  Thickness_WhenDuct1500and1500_ShouldReturn1And13(){
        //Given
        rectangular.setSideA(1500);
        rectangular.setSideB(1500);
        //When
        rectangular.Thickness();
        //Then
        assertThat(rectangular.SteelThickness).isEqualTo(1.13);
    }

    @Test
    public void  Thickness_WhenDuct2500and2500_ShouldReturn1And25(){
        //Given
        rectangular.setSideA(2500);
        rectangular.setSideB(2500);
        //When
        rectangular.Thickness();
        //Then
        assertThat(rectangular.SteelThickness).isEqualTo(1.25);
    }
    @Test
    public void  Thickness_WhenDuct2500and100_ShouldReturn1And25(){
        //Given
        rectangular.setSideA(2500);
        rectangular.setSideB(100);
        //When
        rectangular.Thickness();
        //Then
        assertThat(rectangular.SteelThickness).isEqualTo(1.25);
    }


}
