
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
        public static Length demonstrateLengthAddition(Length l1, Length l2, Length.LengthUnit target) {
            return l1.add(l2, target);
        }

        public static void main(String[] args) {

            System.out.println("\n=== UC7 Addition with Target Unit ===");

// 1 ft + 12 in → FEET
            System.out.println("Result in FEET = " +
                    new Length(1, Length.LengthUnit.FEET)
                            .add(new Length(12, Length.LengthUnit.INCHES),
                                    Length.LengthUnit.FEET));

// Result in INCHES
            System.out.println("Result in INCHES = " +
                    new Length(1, Length.LengthUnit.FEET)
                            .add(new Length(12, Length.LengthUnit.INCHES),
                                    Length.LengthUnit.INCHES));

// Result in YARDS
            System.out.println("Result in YARDS = " +
                    new Length(1, Length.LengthUnit.FEET)
                            .add(new Length(12, Length.LengthUnit.INCHES),
                                    Length.LengthUnit.YARDS));

// Yard + Feet → YARDS
            System.out.println("1 yard + 3 ft (yards) = " +
                    new Length(1, Length.LengthUnit.YARDS)
                            .add(new Length(3, Length.LengthUnit.FEET),
                                    Length.LengthUnit.YARDS));

// Inches + Yard → FEET
            System.out.println("36 in + 1 yard (feet) = " +
                    new Length(36, Length.LengthUnit.INCHES)
                            .add(new Length(1, Length.LengthUnit.YARDS),
                                    Length.LengthUnit.FEET));
        }
        }