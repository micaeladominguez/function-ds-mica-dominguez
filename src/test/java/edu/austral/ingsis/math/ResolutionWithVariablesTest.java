package edu.austral.ingsis.math;

import edu.austral.ingsis.math.function.Function;
import edu.austral.ingsis.math.function.Operation;
import edu.austral.ingsis.math.function.SelfOperation;
import edu.austral.ingsis.math.function.Variable;
import edu.austral.ingsis.math.operators.MultipleOperator;
import edu.austral.ingsis.math.operators.SelfOperator;
import edu.austral.ingsis.math.vistors.SolveVisitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        Function op = new Operation(new Variable(1), new Variable("x",3), MultipleOperator.SUM);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();
        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        Function op = new Operation(new Variable(12), new Variable("div",4), MultipleOperator.DIV);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();
        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        Function op1 = new Operation(new Variable(9), new Variable("x",3), MultipleOperator.DIV);
        Function op2 = new Operation(op1, new Variable("y",4), MultipleOperator.MUL);

        SolveVisitor printVisitor = new SolveVisitor();
        op2.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        Function op1 = new Operation(new Variable(27), new Variable("a", 9), MultipleOperator.DIV);
        Function op2 = new Operation(op1, new Variable("b", 3), MultipleOperator.EXP);

        SolveVisitor printVisitor = new SolveVisitor();
        op2.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();
        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        Function op= new SelfOperation(new Variable("z",36), SelfOperator.SQR);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        Function op1 = new SelfOperation(new Variable("value",8),SelfOperator.ABS);
        Function op2 = new Operation(op1, new Variable(8), MultipleOperator.SUB);

        SolveVisitor printVisitor = new SolveVisitor();
        op2.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();
        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        Function op1 = new Operation(new Variable(5), new Variable("i",2), MultipleOperator.SUB);
        Function op2 = new Operation(op1, new Variable(8), MultipleOperator.MUL);

        SolveVisitor printVisitor = new SolveVisitor();
        op2.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(24d));
    }
}
