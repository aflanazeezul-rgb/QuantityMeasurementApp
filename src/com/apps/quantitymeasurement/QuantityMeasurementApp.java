
    package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.Length.LengthUnit;

    public class QuantityMeasurementApp {

        public static double convert(double value, LengthUnit source, LengthUnit target) {

            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid value");
            }
            if (source == null || target == null) {
                throw new IllegalArgumentException("Units cannot be null");
            }

            double base = value * source.getFactor();
            return base / target.getFactor();
        }

        public static boolean demonstrateLengthEquality(Length l1, Length l2) {
            return l1.equals(l2);
        }

        public static boolean demonstrateLengthComparison(double v1, LengthUnit u1,
                                                          double v2, LengthUnit u2) {
            Length l1 = new Length(v1, u1);
            Length l2 = new Length(v2, u2);
            return l1.equals(l2);
        }

        public static Length demonstrateLengthConversion(double value,
                                                         LengthUnit from,
                                                         LengthUnit to) {
            Length length = new Length(value, from);
            return length.convertTo(to);
        }

        public static Length demonstrateLengthConversion(Length length,
                                                         LengthUnit to) {
            return length.convertTo(to);
        }

        public static void main(String[] args) {

            System.out.println("=== UC5 Length Conversion ===");

            // Static API
            System.out.println("1 ft to inches = " +
                    convert(1.0, LengthUnit.FEET, LengthUnit.INCHES));

            System.out.println("3 yards to feet = " +
                    convert(3.0, LengthUnit.YARDS, LengthUnit.FEET));

            // Object conversion
            Length l1 = new Length(36, LengthUnit.INCHES);
            System.out.println("36 inches to yards = " +
                    l1.convertTo(LengthUnit.YARDS));

            // Equality
            Length a = new Length(1, LengthUnit.FEET);
            Length b = new Length(12, LengthUnit.INCHES);
            System.out.println("1 foot == 12 inches ? " +
                    demonstrateLengthEquality(a, b));

            // Overloaded method
            System.out.println("2 feet to cm = " +
                    demonstrateLengthConversion(2, LengthUnit.FEET,
                            LengthUnit.CENTIMETERS));
        }
    }

