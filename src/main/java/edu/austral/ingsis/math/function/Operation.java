package edu.austral.ingsis.math.function;

import edu.austral.ingsis.math.operators.MultipleOperator;
import edu.austral.ingsis.math.vistors.Visitor;

public class Operation implements Function {


    private final Function firstArg;
    private final Function secondArg;
    private final MultipleOperator operator;

    public Operation(Function firstArg, Function secondArg, MultipleOperator operator) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
        this.operator = operator;
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitOperation(this);
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    public Function getFirstArg() {
        return firstArg;
    }

    public Function getSecondArg() {
        return secondArg;
    }

    public MultipleOperator getOperator() {
        return operator;
    }
}
