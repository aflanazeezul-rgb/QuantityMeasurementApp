
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

            // Equality
            QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
            QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

            System.out.println("Equal: " + w1.equals(w2));

            // Conversion
            System.out.println("Convert: " + w1.convertTo(WeightUnit.GRAM));

            // Addition (default)
            QuantityWeight sum1 = w1.add(w2);
            System.out.println("Add (default): " + sum1);

            // Addition (explicit target)
            QuantityWeight sum2 = w1.add(w2, WeightUnit.POUND);
            System.out.println("Add (to pounds): " + sum2);
        }
    }