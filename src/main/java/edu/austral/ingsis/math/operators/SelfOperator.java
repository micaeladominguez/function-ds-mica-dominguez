package edu.austral.ingsis.math.operators;

public enum SelfOperator {

    SQR("sqrt"),
    ABS("|");

    private final String label;

     SelfOperator(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
