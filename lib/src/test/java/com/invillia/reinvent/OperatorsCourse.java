package com.invillia.reinvent;

import org.junit.jupiter.api.Test;

public class OperatorsCourse {

    /**
     * Operadores aritméticos
     */
    @Test
    public void arithmeticOperators() {

        assert 44 == 42 + 2;
        assert 6 == 2 * 3;
        assert 0 == 2 - 2;
        assert 21 == 42 / 2;
        assert 1 == 13 % 2;
    }

    /**
     * Operadores comparativos
     */
    @Test
    public void comparativeOperators() {

        assert 42 == 42;
        assert 42 != 88;

        assert 42 < 88;
        assert 88 > 42;

        assert 42 <= 42;
        assert 42 <= 88;

        assert 88 >= 88;
        assert 88 >= 42;

        String string = "bananas";
        assert string instanceof CharSequence;
    }

    /**
     * Operadores lógicos
     */
    @Test
    public void logicOperators() {

        assert true == (true && true);
        assert false == (false && false);
        assert false == (true && false);
        assert false == (false && true);

        assert true == (true || true);
        assert false == (false || false);
        assert true == (true || false);
        assert true == (false || true);

        assert true == ( !false );
    }

    /**
     * Operadores de atribuição
     */
    @Test
    public void attributionOperators() {

        int number = 10;
        assert 10 == number;

        number += 2;
        assert 12 == number;

        number -= 4;
        assert 8 == number;

        number *= 2;
        assert 16 == number;

        number /= 4;
        assert 4 == number;

        number %= 3;
        assert 1 == number;

    }
}
