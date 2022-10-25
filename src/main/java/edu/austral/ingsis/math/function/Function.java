package edu.austral.ingsis.math.function;

import edu.austral.ingsis.math.vistors.Visitor;

public interface Function {
    boolean isComposite();
    void acceptVisitor(Visitor visitor);
}
