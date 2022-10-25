package edu.austral.ingsis.math.function;

import edu.austral.ingsis.math.operators.SelfOperator;
import edu.austral.ingsis.math.vistors.Visitor;

public class SelfOperation implements Function {

    private final Function firstArg;
    private final SelfOperator operator;

    public SelfOperation(Function firstArg , SelfOperator operator) {
        this.firstArg = firstArg;
        this.operator = operator;
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitSelfOperation(this);
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    public Function getArg() {
        return firstArg;
    }

    public SelfOperator getOperator() {
        return operator;
    }
}
