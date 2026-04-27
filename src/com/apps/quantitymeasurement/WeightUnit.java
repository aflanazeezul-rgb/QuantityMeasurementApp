package com.apps.quantitymeasurement;

public enum WeightUnit {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double factor;

    WeightUnit(double factor) {
        this.factor = factor;
    }

    public double getConversionFactor() {
        return factor;
    }

    // Convert to base unit (kg)
    public double convertToBaseUnit(double value) {
        return value * factor;
    }

    // Convert from base unit (kg)
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / factor;
    }
}