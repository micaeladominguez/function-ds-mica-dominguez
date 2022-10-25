package edu.austral.ingsis.math.vistors;

import edu.austral.ingsis.math.extra.EquationResolver;
import edu.austral.ingsis.math.function.Function;
import edu.austral.ingsis.math.function.Operation;
import edu.austral.ingsis.math.function.SelfOperation;
import edu.austral.ingsis.math.function.Variable;
import edu.austral.ingsis.math.operators.MultipleOperator;
import edu.austral.ingsis.math.operators.SelfOperator;

public class SolveVisitor implements Visitor{
    Double result;
    EquationResolver equationResolver = new EquationResolver();

    @Override
    public void visitOperation(Operation operation) {
        MultipleOperator operator = operation.getOperator();
        double fArg = getResult(operation.getFirstArg());
        double sArg = getResult(operation.getSecondArg());
        result = equationResolver.getResultFromOperator(fArg,sArg,operator);
    }

    private double getResult(Function function) {
        function.acceptVisitor(this);
        return result;
    }

    @Override
    public void visitVariable(Variable variable) {
        result = variable.getValue();
    }

    @Override
    public void visitSelfOperation(SelfOperation singleOperation) {
        SelfOperator operator = singleOperation.getOperator();
        double arg = getResult(singleOperation.getArg());
        result = equationResolver.getSelfResultFromOperator(arg,operator);
    }


    public Double getResult() {
        return result;
    }
}
