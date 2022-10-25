package edu.austral.ingsis.math.extra;

import edu.austral.ingsis.math.operators.MultipleOperator;
import edu.austral.ingsis.math.operators.SelfOperator;

public class EquationResolver {
    public double getResultFromOperator(double firstValue, double secondValue, MultipleOperator operator){
        switch (operator) {
            case SUM:
                return firstValue + secondValue;
            case SUB:
                return firstValue - secondValue;
            case MUL:
                return firstValue * secondValue;
            case DIV:
                return firstValue / secondValue;
            case EXP:
                return Math.pow(firstValue, secondValue);
            default:
                throw new UnsupportedOperationException("The operator is not correct!");
        }
    }

    public Double getSelfResultFromOperator(double arg, SelfOperator operator) {
        switch (operator) {
            case ABS:
                return Math.abs(arg);
            case SQR:
                return Math.sqrt(arg);
            default:
                throw new UnsupportedOperationException("The operator is not correct!");
        }
    }
}
