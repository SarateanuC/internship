package org.example.service;

import lombok.SneakyThrows;
import org.example.exceptions.NoElementsException;
import org.example.model.Person;
import org.example.model.SortingResponse;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class SortingService {
    @SneakyThrows
    public SortingResponse concatenateValuesNew(Object[] input) {
        List<Object> objects = List.of(input);
        if (objects.isEmpty()) {
            throw new NoElementsException("input must not be null");
        }
        String join = objects.stream()
                .filter(e -> e instanceof String || e instanceof Character)
                .map(Object::toString)
                .collect(joining(" "));

        BigInteger sum = objects.stream()
                .filter(e -> e instanceof Number)
                .map(this::sumAllNumbers)
                .reduce(BigInteger.ZERO, BigInteger::add);

        List<Person> people = objects.stream()
                .filter(e -> e instanceof Person)
                .map(e -> (Person) e)
                .collect(Collectors.toList());

        return SortingResponse.builder()
                .joinedText(join)
                .persons(people)
                .sum(sum)
                .build();
    }

    private BigInteger sumAllNumbers(Object o) {
        if (o instanceof Integer) {
            return BigInteger.valueOf((Integer) o);
        }
        return BigInteger.valueOf((Long) o);
    }
}
