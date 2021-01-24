package com.gmail.brian.model;

public class Duct {

    protected final double SteelDensity = 7850;
    protected final double WoolDensity = 80;
    protected final double PromatDensity = 975;

    protected double Weigh;
    protected double SteelThickness;
    protected boolean IsInsulation;
    protected boolean IsOutdoor;
    protected  int InsulationThickness;

    public double getSteelDensity() {
        return SteelDensity;
    }

    public double getWoolDensity() {
        return WoolDensity;
    }

    public double getWeigh() {
        return Weigh;
    }

    public void setWeigh(double weigh) {
        Weigh = weigh;
    }

    public double getSteelThickness() {
        return SteelThickness;
    }

    public void setSteelThickness(double steelThickness) {
        SteelThickness = steelThickness;
    }

    public boolean isInsulation() {
        return IsInsulation;
    }

    public void setInsulation(boolean insulation) {
        IsInsulation = insulation;
    }

    public boolean isOutdoor() {
        return IsOutdoor;
    }

    public void setOutdoor(boolean outdoor) {
        IsOutdoor = outdoor;
    }

    public int getInsulationThickness() {
        return InsulationThickness;
    }

    public void setInsulationThickness(int insulationThickness) {
        InsulationThickness = insulationThickness;
    }
}
