package com.gmail.brian.model;

import org.springframework.stereotype.Component;

@Component
public class Circle extends Duct {
    private long diameter;
    public static final double PI = Math.PI;
    private double radius = diameter/2;


    public Circle() {
    }

    public double Thickness() {
        if (diameter <= 1000) {
            SteelThickness = 1d;
        } else if (diameter > 2000) {
            SteelThickness = 1.25d;
        } else {
            SteelThickness = 1.13d;
        }
        return SteelThickness;
    }

    public double CalculationWeigh() {
        Thickness();
        if ((!IsInsulation) & (!IsOutdoor)) {
            Weigh = (circleArea(diameter+2*SteelThickness) - circleArea(diameter)) * 1.3F / 1000000 * SteelDensity;
        }
//        else if ((IsInsulation) & (!IsOutdoor)) {
//            Weigh = ((((sideA + SteelThickness * 2) * (sideB + SteelThickness * 2)) - (sideA * sideB)) * 1.3F / 1000000 * SteelDensity) +
//                    ((((sideA + InsulationThickness * 2) * (sideB + InsulationThickness * 2)) - (sideA * sideB)) / 1000000F * WoolDensity);
//        } else {
//            Weigh = ((((sideA + SteelThickness * 2) * (sideB + SteelThickness * 2)) - (sideA * sideB)) * 1.3F / 1000000 * SteelDensity) +
//                    ((((sideA + InsulationThickness * 2) * (sideB + InsulationThickness * 2)) - (sideA * sideB)) / 1000000F * WoolDensity) +
//                    (((sideA + 2 * InsulationThickness + 4 * SteelThickness) * (sideB + 2 * InsulationThickness + 4 * SteelThickness)) -
//                            ((sideA + 2 * InsulationThickness + 2 * SteelThickness) * (sideB + 2 * InsulationThickness + 2 * SteelThickness))) * 1.3F / 1000000 * SteelDensity;
//        }
        return Circle.round(Weigh,1);
    }

    public double circleArea(double diameter){
        return diameter*PI/4 *1000;
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
