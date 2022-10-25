package edu.austral.ingsis.math;

import edu.austral.ingsis.math.function.Function;
import edu.austral.ingsis.math.function.Operation;
import edu.austral.ingsis.math.function.SelfOperation;
import edu.austral.ingsis.math.function.Variable;
import edu.austral.ingsis.math.operators.MultipleOperator;
import edu.austral.ingsis.math.operators.SelfOperator;
import edu.austral.ingsis.math.vistors.ListVariablesVisitor;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Function op = new Operation(new Variable(1), new Variable(6), MultipleOperator.SUM);
        ListVariablesVisitor variableVisitor = new ListVariablesVisitor();
        op.acceptVisitor(variableVisitor);
        final List<String> result = variableVisitor.getVariables();

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        Function op = new Operation(new Variable(1), new Variable("div"), MultipleOperator.DIV);

        ListVariablesVisitor variableVisitor = new ListVariablesVisitor();
        op.acceptVisitor(variableVisitor);

        final List<String> result = variableVisitor.getVariables();

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Function op1 = new Operation(new Variable(9), new Variable("x"), MultipleOperator.DIV);
        Function op2 = new Operation(op1, new Variable("y"), MultipleOperator.MUL);
        ListVariablesVisitor variableVisitor = new ListVariablesVisitor();
        op2.acceptVisitor(variableVisitor);

        final List<String> result = variableVisitor.getVariables();

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Function op1 = new Operation(new Variable(27), new Variable("a"), MultipleOperator.DIV);
        Function op2 = new Operation(op1, new Variable("b"), MultipleOperator.EXP);
        ListVariablesVisitor variableVisitor = new ListVariablesVisitor();
        op2.acceptVisitor(variableVisitor);

        final List<String> result = variableVisitor.getVariables();

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Function op = new Operation(new Variable("z"), new Variable(1/2), MultipleOperator.EXP);
        ListVariablesVisitor variableVisitor = new ListVariablesVisitor();
        op.acceptVisitor(variableVisitor);

        final List<String> result = variableVisitor.getVariables();
        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Function op1 = new SelfOperation(new Variable("value"), SelfOperator.ABS);
        Function op2 = new Operation(op1, new Variable(8), MultipleOperator.SUB);
        ListVariablesVisitor variableVisitor = new ListVariablesVisitor();
        op2.acceptVisitor(variableVisitor);

        final List<String> result = variableVisitor.getVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Function op1 = new Operation(new Variable(5), new Variable("i"), MultipleOperator.SUB);
        Function op2 = new Operation(op1, new Variable(8), MultipleOperator.MUL);
        ListVariablesVisitor variableVisitor = new ListVariablesVisitor();
        op2.acceptVisitor(variableVisitor);

        final List<String> result = variableVisitor.getVariables();

        assertThat(result, containsInAnyOrder("i"));
    }
}
