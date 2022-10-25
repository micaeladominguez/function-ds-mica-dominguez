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


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        Function op = new Operation(new Variable(1), new Variable(6), MultipleOperator.SUM);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();
        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        Function op = new Operation(new Variable(12), new Variable(2), MultipleOperator.DIV);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        Function op1 = new Operation(new Variable(9), new Variable(2), MultipleOperator.DIV);
        Function op2 = new Operation(op1, new Variable(3), MultipleOperator.MUL);

        SolveVisitor printVisitor = new SolveVisitor();
        op2.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();
        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        Function op1 = new Operation(new Variable(27), new Variable(6), MultipleOperator.DIV);
        Function op2 = new Operation(op1, new Variable(2), MultipleOperator.EXP);

        SolveVisitor printVisitor = new SolveVisitor();
        op2.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();
        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        Function op = new SelfOperation(new Variable(36), SelfOperator.SQR);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();
        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        Function op = new SelfOperation(new Variable(136), SelfOperator.ABS);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();
        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        Function op = new SelfOperation(new Variable(-136), SelfOperator.ABS);

        SolveVisitor printVisitor = new SolveVisitor();
        op.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();
        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Function op1 = new Operation(new Variable(5), new Variable(5), MultipleOperator.SUB);
        Function op2 = new Operation(op1, new Variable(8), MultipleOperator.MUL);

        SolveVisitor printVisitor = new SolveVisitor();
        op2.acceptVisitor(printVisitor);

        final Double result = printVisitor.getResult();

        assertThat(result, equalTo(0d));
    }
}
