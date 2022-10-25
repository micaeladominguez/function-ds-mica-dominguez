package edu.austral.ingsis.math.vistors;

import edu.austral.ingsis.math.function.Operation;
import edu.austral.ingsis.math.function.SelfOperation;
import edu.austral.ingsis.math.function.Variable;

public interface Visitor {
    void visitOperation(Operation operation);
    void visitVariable(Variable variable);
    void visitSelfOperation(SelfOperation singleOperation);

}
