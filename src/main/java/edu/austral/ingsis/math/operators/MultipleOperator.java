package edu.austral.ingsis.math.operators;

public enum MultipleOperator {

    SUM("+"),
    SUB("-"),
    MUL("*"),
    DIV("/"),
    EXP("^");


    private final String label;

    MultipleOperator(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

}
