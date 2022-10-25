package edu.austral.ingsis.math;

import edu.austral.ingsis.math.function.Function;
import edu.austral.ingsis.math.function.Operation;
import edu.austral.ingsis.math.function.SelfOperation;
import edu.austral.ingsis.math.function.Variable;
import edu.austral.ingsis.math.operators.MultipleOperator;
import edu.austral.ingsis.math.operators.SelfOperator;
import edu.austral.ingsis.math.vistors.PrintVisitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1 + 6";
        Function op = new Operation(new Variable(1), new Variable(6), MultipleOperator.SUM);
        PrintVisitor printVisitor = new PrintVisitor();
        op.acceptVisitor(printVisitor);
        final String result = printVisitor.getResult();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "12 / 2";
        Function op = new Operation(new Variable(12), new Variable(2), MultipleOperator.DIV);
        PrintVisitor printVisitor = new PrintVisitor();
        op.acceptVisitor(printVisitor);
        final String result = printVisitor.getResult();
        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9 / 2) * 3";
        Function op1 = new Operation(new Variable(9), new Variable(2), MultipleOperator.DIV);
        Function op2 = new Operation(op1, new Variable(3), MultipleOperator.MUL);
        PrintVisitor printVisitor = new PrintVisitor();
        op2.acceptVisitor(printVisitor);
        final String result = printVisitor.getResult();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";
        Function op1 = new Operation(new Variable(27), new Variable(6), MultipleOperator.DIV);
        Function op2 = new Operation(op1, new Variable(2), MultipleOperator.EXP);
        PrintVisitor printVisitor = new PrintVisitor();
        op2.acceptVisitor(printVisitor);
        final String result = printVisitor.getResult();
        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";
        Function op1 = new SelfOperation(new Variable("value"), SelfOperator.ABS);
        Function op2 = new Operation(op1, new Variable(8), MultipleOperator.SUB);
        PrintVisitor printVisitor = new PrintVisitor();
        op2.acceptVisitor(printVisitor);
        final String result = printVisitor.getResult();
        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";
        Function op1 = new Operation(new Variable(5), new Variable("i"),MultipleOperator.SUB);
        Function op2 = new Operation(op1, new Variable(8), MultipleOperator.MUL);
        PrintVisitor printVisitor = new PrintVisitor();
        op2.acceptVisitor(printVisitor);
        final String result = printVisitor.getResult();

        assertThat(result, equalTo(expected));
    }
}
