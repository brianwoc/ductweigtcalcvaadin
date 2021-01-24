package com.gmail.brian.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CircleTest {
Circle circle;

    @Before
    public void setUp() throws Exception {
        circle =new Circle();
        circle.setDiameter(315);
        circle.Thickness();
    }

    @Test
    public void CalculationWeigh_WhenIsIsolation_ShouldReturn10() {
        circle.setInsulation(true);
        circle.setInsulationThickness(40);
        circle.setOutdoor(false);
        assertThat(circle.CalculationWeigh()).isEqualTo(10.4);
    }

    @Test
    public void CalculationWeigh_WhenIsIsolationAndOutdoor_ShouldReturn19() {
        circle.setInsulation(true);
        circle.setInsulationThickness(40);
        circle.setOutdoor(true);
        assertThat(circle.CalculationWeigh()).isEqualTo(19.1);
    }
    @Test
    public void CalculationWeigh_WhenNoIsolation_ShouldReturn7() {
        circle.setInsulation(false);
        circle.setOutdoor(false);
        assertThat(circle.CalculationWeigh()).isEqualTo(6.9);
    }

    @Test
    public void  Thickness_WhenPass250_ShouldReturn077(){
        //Given
        circle.setDiameter(250);
        //When
        circle.Thickness();
        //Then
        assertThat(circle.SteelThickness).isEqualTo(0.75);
    }

    @Test
    public void  Thickness_WhenPass250_ShouldReturn088(){
        //Given
        circle.setDiameter(315);
        //When
        circle.Thickness();
        //Then
        assertThat(circle.SteelThickness).isEqualTo(0.88);
    }
}
