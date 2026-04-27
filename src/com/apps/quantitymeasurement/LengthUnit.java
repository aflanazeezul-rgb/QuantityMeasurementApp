
    package com.apps.quantitymeasurement;

    /**
     * Standalone Enum for Length Units
     * Base Unit = FEET
     */
    public enum LengthUnit {

        FEET(1.0),
        INCHES(1.0 / 12),
        YARDS(3.0),
        CENTIMETERS(1.0 / 30.48);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }

        // Convert to base unit (feet)
        public double convertToBaseUnit(double value) {
            return value * factor;
        }

        // Convert from base unit (feet)
        public double convertFromBaseUnit(double baseValue) {
            return baseValue / factor;
        }
    }

