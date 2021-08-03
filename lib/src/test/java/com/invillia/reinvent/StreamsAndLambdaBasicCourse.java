package com.invillia.reinvent;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAndLambdaBasicCourse {

    /**
     * Usar stream de uma Coleção
     */
    @Test
    public void handlingStreamsFromCollections() {

        List<String> list = Arrays.asList("bananas", "maçãs", "laranjas");
        List<String> otherList = new LinkedList<>();
        assert list.size() == 3;
        assert otherList.size() == 0;

        list.stream().forEach(
                (String it) -> otherList.add(it)
        );

        assert list.size() == 3;
        assert otherList.size() == 3;
    }

    /**
     * Coletar stream de uma Coleção para outra
     */
    @Test
    public void collectingStreamsFromCollectionsToAnother() {

        List<String> list = Arrays.asList(
                "bananas",
                "maçãs",
                "laranjas",
                "bananas",
                "maçãs"
        );

        Set<String> set = list.stream().collect(Collectors.toSet());

        assert list.size() == 5;
        assert set.size() == 3;
    }

    /**
     * Multiplas operações seguidas de uma stream de uma Coleção
     */
    @Test
    public void handlingStreamsFromCollectionsMultipleOperations() {

        List<String> list = Arrays.asList(
                "bananas",
                "maçãs",
                "laranjas",
                "bananas",
                "maçãs"
        );

        Stream<String> stream = list.stream()
                .distinct()
                .filter(
                        (String it) -> !it.equals("bananas")
                );

        Set<String> set = stream
                .map(
                        (String it) -> it.substring(2)
                ).collect(Collectors.toSet());

        assert list.size() == 5;

        assert set.size() == 2;
        assert set.contains("çãs");
        assert set.contains("ranjas");

        assert !set.contains("nanas");
        assert !set.contains("bananas");
    }

    /**
     * Executar redução em uma Stream de uma Coleção
     */
    @Test
    public void reducingStreamsFromCollections() {
        List<String> list = Arrays.asList(
                "bananas",
                "maçãs",
                "laranjas",
                "bananas",
                "maçãs"
        );

        String initialAndFinalChars = list.stream()
                .sorted()
                .map(
                        (String it) -> {

                            char initialChar = it.charAt(0);
                            char finalChar = it.charAt(it.length()-1);

                            return String.valueOf(initialChar) + String.valueOf(finalChar);
                        }
                ).reduce(
                        "-",
                        (accrual, it) -> it.charAt(0) + accrual + it.charAt(1)
                );

        assert "mmlbb-sssss".equals(initialAndFinalChars);
    }

    /**
     * Executar um flatFlap em uma Stream de uma Coleção de Coleções
     */
    @Test
    public void flatMappingStreamsFromCollectionsOfCollections() {

        List<List<String>> listOfSet = Arrays.asList(
                Arrays.asList(
                     "bananas",
                     "maçãs"
                ),
                Arrays.asList(
                        "laranjas",
                        "goiabas",
                        "jabuticabas"
                ),
                Arrays.asList(
                        "tangerinas"
                )
        );

        List<String> list = listOfSet.stream()
                .flatMap(
                        (List<String> it) -> it.stream()
                ).collect(Collectors.toList());

        assert list.size() == 6;
        assert list.contains("bananas");
        assert list.contains("tangerinas");
    }
}
