package com.gmail.brian.model;

import org.springframework.stereotype.Component;

@Component
public class Circle extends Duct {
    private long diameter;
    public static final double PI = Math.PI;

    public Circle() {
    }

    public double Thickness() {
        if (diameter <= 250) {
            SteelThickness = 0.75d;
        } else {
            SteelThickness = 0.88d;}

        return SteelThickness;
    }

    public double CalculationWeigh() {
        Thickness();
        if ((!IsInsulation) & (!IsOutdoor)) {
            Weigh = (circleArea(diameter+2*SteelThickness) - circleArea(diameter))  / 1000000 * SteelDensity;
        }
        else if ((IsInsulation) & (!IsOutdoor)) {
        Weigh = (circleArea(diameter+2*SteelThickness) - circleArea(diameter))  / 1000000 * SteelDensity
            + (circleArea(diameter+2*SteelThickness+ 2* InsulationThickness) - circleArea(diameter+2*SteelThickness))  / 1000000 * WoolDensity;

        }

         else {
        Weigh = (circleArea(diameter+2*SteelThickness) - circleArea(diameter))  / 1000000 * SteelDensity
                + (circleArea(diameter+2*SteelThickness+ 2* InsulationThickness) - circleArea(diameter+2*SteelThickness))  / 1000000 * WoolDensity
        + (circleArea(diameter+4*SteelThickness+2*InsulationThickness) - circleArea(diameter+2*SteelThickness+2*InsulationThickness)) /1000000* SteelDensity;

        }
        return Circle.round(Weigh,1);
    }

    public double circleArea(double diameter){
        return diameter*diameter*PI/4;
    }


    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    public long getDiameter() {
        return diameter;
    }

    public void setDiameter(long diameter) {
        this.diameter = diameter;
    }
}
