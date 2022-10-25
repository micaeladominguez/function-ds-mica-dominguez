package edu.austral.ingsis.math.vistors;

import edu.austral.ingsis.math.function.Function;
import edu.austral.ingsis.math.function.Operation;
import edu.austral.ingsis.math.function.SelfOperation;
import edu.austral.ingsis.math.function.Variable;
import edu.austral.ingsis.math.operators.MultipleOperator;
import edu.austral.ingsis.math.operators.SelfOperator;

public class PrintVisitor implements Visitor{
    String result;
    @Override
    public void visitOperation(Operation operation) {
        MultipleOperator operator = operation.getOperator();
        Function fstArg = operation.getFirstArg();
        Function sndArg = operation.getSecondArg();

        if (fstArg.isComposite()){
            result = "(" + getString(fstArg) + ")";
        } else result = getString(fstArg);

        result += " " + operator.getLabel() + " ";

        if (sndArg.isComposite()){
            result += "(" + getString(sndArg) + ")";
        } else result += getString(sndArg);
    }

    @Override
    public void visitVariable(Variable variable) {
        Double value = variable.getValue();
        String name = variable.getName();

        if (value != null){
            result = String.valueOf(Math.round(value));
        } else result = name;
    }

    @Override
    public void visitSelfOperation(SelfOperation selfOperation) {
        SelfOperator selfOperator = selfOperation.getOperator();
        String argString = getString(selfOperation.getArg());

        switch (selfOperator) {
            case ABS:
                result = selfOperator.getLabel() + argString + selfOperator.getLabel();
                break;
            case SQR:
                result = selfOperator.getLabel() + "(" + argString + ")";
                break;
            default:
                throw new UnsupportedOperationException("The operator is not correct!");
        }
    }

    private String getString(Function function) {
        function.acceptVisitor(this);
        return this.result;
    }

    public String getResult() {
        return result;
    }
}
