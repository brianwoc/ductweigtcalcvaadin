package com.gmail.brian.model;

import org.springframework.stereotype.Component;

@Component
public class Rectangular extends Duct {
    private long sideA;
    private long sideB;

    public Rectangular() {

    }

    public double Thickness() {
        if ((sideA <= 1000) && (sideB <= 1000)) {
            SteelThickness = 1d;
        } else if ((sideA > 2000) || (sideB > 2000)) {
            SteelThickness = 1.25d;
        } else {
            SteelThickness = 1.13d;
        }
        return SteelThickness;
    }

    public double CalculationWeigh() {
//        Thickness();
        if ((!IsInsulation) & (!IsOutdoor)) {
            Weigh = ((sideA + SteelThickness * 2) * ((sideB + SteelThickness * 2)) - (sideA * sideB)) * 1.3F / 1000000 * SteelDensity;
        } else if ((IsInsulation) & (!IsOutdoor)) {
            Weigh = ((((sideA + SteelThickness * 2) * (sideB + SteelThickness * 2)) - (sideA * sideB)) * 1.3F / 1000000 * SteelDensity) +
                    ((((sideA + InsulationThickness * 2) * (sideB + InsulationThickness * 2)) - (sideA * sideB)) / 1000000F * WoolDensity);
        } else {
            Weigh = ((((sideA + SteelThickness * 2) * (sideB + SteelThickness * 2)) - (sideA * sideB)) * 1.3F / 1000000 * SteelDensity) +
                    ((((sideA + InsulationThickness * 2) * (sideB + InsulationThickness * 2)) - (sideA * sideB)) / 1000000F * WoolDensity) +
                    (((sideA + 2 * InsulationThickness + 4 * SteelThickness) * (sideB + 2 * InsulationThickness + 4 * SteelThickness)) -
                    ((sideA + 2 * InsulationThickness + 2 * SteelThickness) * (sideB + 2 * InsulationThickness + 2 * SteelThickness))) * 1.3F / 1000000 * SteelDensity;
        }
        return Rectangular.round(Weigh,1);
    }

    public double CalculationWeighSilencer(double silencerWeight) {
        Thickness();
        if ((!IsInsulation) & (!IsOutdoor)) {
            Weigh = silencerWeight;
        } else if ((IsInsulation) & (!IsOutdoor)) {
            Weigh = silencerWeight +
                    ((((sideA + InsulationThickness * 2) * (sideB + InsulationThickness * 2)) - (sideA * sideB)) / 1000000F * WoolDensity);
        } else {
            Weigh = silencerWeight +
                    ((((sideA + InsulationThickness * 2) * (sideB + InsulationThickness * 2)) - (sideA * sideB)) / 1000000F * WoolDensity) +
                    (((sideA + 2 * InsulationThickness + 4 * SteelThickness) * (sideB + 2 * InsulationThickness + 4 * SteelThickness)) -
                            ((sideA + 2 * InsulationThickness + 2 * SteelThickness) * (sideB + 2 * InsulationThickness + 2 * SteelThickness))) * 1.3F / 1000000 * SteelDensity;
        }
        return Rectangular.round(Weigh,1);
    }

    public long getSideA() {
        return sideA;
    }

    public void setSideA(long sideA) {
        this.sideA = sideA;
    }

    public long getSideB() {
        return sideB;
    }

    public void setSideB(long sideB) {
        this.sideB = sideB;
    }



    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
