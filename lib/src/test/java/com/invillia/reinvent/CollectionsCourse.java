package com.invillia.reinvent;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionsCourse {

    /**
     * Vamos usar uma Lista
     */
    @Test
    public void handlingList() {

        assert true;
    }

    /**
     * Vamos usar um Set
     */
    @Test
    public void handlingSet() {

        assert true;
    }

    /**
     * Vamos usar uma Fila
     */
    @Test
    public void handlingQueue() {

        assert true;
    }

    /**
     * Vamos usar uma Pilha
     */
    @Test
    public void handlingStack() {

        assert true;
    }

    /**
     * Vamos usar um Deque
     */
    @Test
    public void handlingDeque() {

        assert true;
    }

    /**
     * Vamos usar um Map
     */
    @Test
    public void handlingMap() {

        assert true;
    }

    /**
     * Vamos usar Collections factory methods
     */
    @Test
    public void invokingCollectionsFactoryMethods() {

        List<String> list = Collections.emptyList();
        assert list.isEmpty();

        list = Collections.singletonList("bananas");
        assert list.size() == 1;
        assert list.contains("bananas");
    }

    /**
     * Vamos usar Arrays factory methods
     */
    @Test
    public void invokingArraysFactoryMethods() {

        List<String> list = Arrays.asList("bananas", "maçãs", "laranjas");

        assert list.size() == 3;
        assert list.contains("bananas");
    }
}
