
    package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.Length.LengthUnit;

    public class QuantityMeasurementApp {
        public static Length demonstrateLengthAddition(Length l1, Length l2) {
            return l1.add(l2);
        }

        public static Length demonstrateLengthAddition(double v1, Length.LengthUnit u1,
                                                       double v2, Length.LengthUnit u2) {
            Length l1 = new Length(v1, u1);
            Length l2 = new Length(v2, u2);
            return l1.add(l2);
        }


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

            System.out.println("\n=== UC6 Addition ===");

// 1 ft + 12 inches = 2 feet
            Length a = new Length(1, Length.LengthUnit.FEET);
            Length b = new Length(12, Length.LengthUnit.INCHES);
            System.out.println("1 ft + 12 in = " + a.add(b));

// 12 inches + 1 foot = 24 inches
            Length c = new Length(12, Length.LengthUnit.INCHES);
            Length d = new Length(1, Length.LengthUnit.FEET);
            System.out.println("12 in + 1 ft = " + c.add(d));

// Same unit
            System.out.println("1 ft + 2 ft = " +
                    new Length(1, Length.LengthUnit.FEET)
                            .add(new Length(2, Length.LengthUnit.FEET)));

// Yard + Feet
            System.out.println("1 yard + 3 ft = " +
                    new Length(1, Length.LengthUnit.YARDS)
                            .add(new Length(3, Length.LengthUnit.FEET)));

// Zero case
            System.out.println("5 ft + 0 in = " +
                    new Length(5, Length.LengthUnit.FEET)
                            .add(new Length(0, Length.LengthUnit.INCHES)));
            }
        }


