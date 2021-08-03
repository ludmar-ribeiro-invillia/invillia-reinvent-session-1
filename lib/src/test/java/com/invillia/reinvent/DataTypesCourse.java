package com.invillia.reinvent;

import org.junit.jupiter.api.Test;

public class DataTypesCourse {

    /**
     * Tipos primitivos inteiros
     */
    @Test
    public void definingIntegerPrimitiveTypes() {

        byte byteNumber = 127;
        short shortNumber = 32767;
        int intNumber = 2147483647;
        long longNumber = 9223372036854775807l;

        assert Byte.MAX_VALUE == byteNumber;
        assert Short.MAX_VALUE == shortNumber;
        assert Integer.MAX_VALUE == intNumber;
        assert Long.MAX_VALUE == longNumber;
    }

    /**
     * Tipos primitivos decimais
     */
    @Test
    public void definingDecimalsPrimitiveTypes() {

        float floatNumber = 3.4028235E38f;
        double doubleNumber = 1.7976931348623157E308;

        assert Float.MAX_VALUE == floatNumber;
        assert Double.MAX_VALUE == doubleNumber;
    }

    /**
     * Tipo primitivo booleano
     */
    @Test
    public void definingBooleanPrimitiveType() {

        boolean trueBoolean = true;
        boolean falseBoolean = false;

        assert trueBoolean;
        assert !falseBoolean;
    }

    /**
     * Tipo caractér primitivo
     */
    @Test
    public void definingCharacterPrimitiveType() {
        char charALower = 'a';
        char charALowerFromOrd = (char) 97;

        char charZUpper = 'Z';
        char charZUpperFromOrd = (char) 90;

        assert charALower == charALowerFromOrd;
        assert charZUpper == charZUpperFromOrd;
    }

    /**
     * Empacotadores de tipos primitivos inteiros
     */
    @Test
    public void definingIntegerPrimitiveWrappers() {

        Byte byteNumber = 127;
        Short shortNumber = 32767;
        Integer intNumber = 2147483647;
        Long longNumber = 9223372036854775807L;

        assert Byte.valueOf(Byte.MAX_VALUE) == byteNumber;
        assert Short.valueOf(Short.MAX_VALUE) != shortNumber;
        assert Integer.valueOf(Integer.MAX_VALUE) != intNumber;
        assert Long.valueOf(Long.MAX_VALUE) != longNumber;

        assert Byte.valueOf(Byte.MAX_VALUE).equals(byteNumber);
        assert Short.valueOf(Short.MAX_VALUE).equals(shortNumber);
        assert Integer.valueOf(Integer.MAX_VALUE).equals(intNumber);
        assert Long.valueOf(Long.MAX_VALUE).equals(longNumber);

        assert Integer.valueOf(128) != Integer.valueOf(128);
    }

    /**
     * Empacotadores de tipos primitivos decimais
     */
    @Test
    public void definingDecimalsPrimitiveWrappers() {

        Float floatNumber = 3.4028235E38F;
        Double doubleNumber = 1.7976931348623157E308D;

        assert Float.valueOf(Float.MAX_VALUE) != floatNumber;
        assert Double.valueOf(Double.MAX_VALUE) != doubleNumber;

        assert Float.valueOf(Float.MAX_VALUE).equals(floatNumber);
        assert Double.valueOf(Double.MAX_VALUE).equals(doubleNumber);
    }

    /**
     * Empacotador de tipo primitivo booleano
     */
    @Test
    public void definingBooleanPrimitiveWrapper() {

        Boolean trueBoolean = Boolean.TRUE;
        Boolean falseBoolean = Boolean.FALSE;

        assert Boolean.TRUE == trueBoolean;
        assert Boolean.FALSE == falseBoolean;
    }

    /**
     * Empacotador de tipo caractér primitivo
     */
    @Test
    public void definingCharacterPrimitiveWrapper() {
        Character charUntil127 = Character.valueOf((char) 127);
        Character charFrom128 = Character.valueOf((char) 128);

        assert Character.valueOf((char) 127) == charUntil127;
        assert Character.valueOf((char) 128) != charFrom128;
    }

    /**
     * String
     */
    @Test
    public void definingStrings() {

        String stringFromLiteral = "how much wood would a woodchuck chuck if a woodchuck could chuck wood?";
        String stringFromLiteralB = "how much wood would a woodchuck chuck if a woodchuck could chuck wood?";

        String stringFromConcat = "how much wood would a woodchuck chuck"
                +" if a woodchuck could chuck wood?";

        String stringFromSegmentedConcat = "how much wood would a woodchuck chuck";
        stringFromSegmentedConcat += " if a woodchuck could chuck wood?";

        String stringFromNewString = new String(stringFromLiteral);

        String stringFromStringBuilder = new StringBuilder()
                .append("how much wood would a woodchuck chuck")
                .append(" if a woodchuck could chuck wood?")
                .toString();

        assert stringFromLiteral == "how much wood would a woodchuck chuck if a woodchuck could chuck wood?";
        assert stringFromLiteral == stringFromLiteralB;
        assert stringFromLiteral == stringFromConcat;
        assert stringFromLiteral != stringFromSegmentedConcat;
        assert stringFromLiteral != stringFromNewString;
        assert stringFromLiteral != stringFromStringBuilder;

        assert stringFromLiteral.equals("how much wood would a woodchuck chuck if a woodchuck could chuck wood?");
        assert stringFromLiteral.equals(stringFromLiteralB);
        assert stringFromLiteral.equals(stringFromConcat);
        assert stringFromLiteral.equals(stringFromSegmentedConcat);
        assert stringFromLiteral.equals(stringFromNewString);
        assert stringFromLiteral.equals(stringFromStringBuilder);
    }

    /**
     * Array
     */
    @Test
    public void definingArray() {

        int[] intArray = {1,2,3};
        int[] intArrayB = {1,2,3};
        int[] copyIntArray = intArray;

        assert intArray != intArrayB;
        assert !intArray.equals(intArrayB);
        assert intArray == copyIntArray;
    }

    /**
     * Definir um Enum
     */
    @Test
    public void definingEnumAndAttributing() {

        assert true;
    }
}
