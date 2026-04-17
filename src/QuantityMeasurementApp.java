public class QuantityMeasurementApp {

    // ---------------- ENUM (Units with conversion to FEET) ----------------
    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0);

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }
    }

    // ---------------- GENERIC QUANTITY CLASS ----------------
    static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        // Convert to base unit (FEET)
        private double toBaseUnit() {
            return unit.toFeet(value);
        }

        // Override equals()
        @Override
        public boolean equals(Object obj) {

            // Reflexive
            if (this == obj) return true;

            // Null + Type check
            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            // Compare after conversion to base unit
            return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toBaseUnit());
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        System.out.println("Input: " + q1 + " and " + q2);
        System.out.println("Output: Equal (" + q1.equals(q2) + ")");

        Quantity q3 = new Quantity(1.0, LengthUnit.INCH);
        Quantity q4 = new Quantity(1.0, LengthUnit.INCH);

        System.out.println("\nInput: " + q3 + " and " + q4);
        System.out.println("Output: Equal (" + q3.equals(q4) + ")");
    }
}