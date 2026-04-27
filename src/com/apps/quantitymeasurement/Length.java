
    package com.apps.quantitymeasurement;

import java.util.Objects;


    public class Length {

        private final double value;
        private final LengthUnit unit;

        public Length(double value, LengthUnit unit) {
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid value");
            }
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }

        /**
         * Convert this length to another unit
         */
        public Length convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }

            double baseValue = convertToBaseUnit();
            double converted = baseValue / targetUnit.getFactor();

            return new Length(round(converted), targetUnit);
        }

        /**
         * Convert to base unit (inches)
         */
        private double convertToBaseUnit() {
            return value * unit.getFactor();
        }

        /**
         * Equality based on base unit value
         */
        private boolean compare(Length other) {
            double thisBase = this.convertToBaseUnit();
            double otherBase = other.convertToBaseUnit();

            return Math.abs(thisBase - otherBase) < 0.0001;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Length)) return false;
            Length length = (Length) o;
            return compare(length);
        }

        @Override
        public int hashCode() {
            return Objects.hash(round(convertToBaseUnit()));
        }

        @Override
        public String toString() {
            return String.format("%.2f %s", value, unit);
        }

        private double round(double value) {
            return Math.round(value * 100.0) / 100.0;
        }

        public enum LengthUnit {
            INCHES(1.0),
            FEET(12.0),
            YARDS(36.0),
            CENTIMETERS(0.393701);

            private final double factor;

            LengthUnit(double factor) {
                this.factor = factor;
            }

            public double getFactor() {
                return factor;
            }
        }
    }

