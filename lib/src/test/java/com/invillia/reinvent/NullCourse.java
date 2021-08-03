package com.invillia.reinvent;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NullCourse {

    /**
     * Vamos acessar uma variável null
     */
    @Test
    public void accessingNull() {

        assert true;
    }

    /**
     * Vamos checar uma variável null
     */
    @Test
    public void checkingNull() {

        String string = null;

        assertThrows(
                NullPointerException.class,
                () -> {
                    string.trim();
                }
        );
    }

    /**
     * Vamos checar uma variável null com Objects
     */
    @Test
    public void checkingNullWithObjects() {

        String string = null;

        assertThrows(
                NullPointerException.class,
                () -> {
                    Objects.requireNonNull(string);
                }
        );
    }

    /**
     * Vamos usar um Optional
     */
    @Test
    public void usingOptional() {

        Optional<String> string = Optional.empty();

        assertThrows(
                NoSuchElementException.class,
                () -> {
                    string.get();
                }
        );
    }
}
