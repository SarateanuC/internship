package tasks.task1.service;

import lombok.SneakyThrows;
import tasks.task1.exceptions.NoElementsException;
import tasks.task1.model.Person;
import tasks.task1.model.SortingResponse;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.join;
import static java.math.BigInteger.*;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;

public class SortingService {
    @SneakyThrows
    public SortingResponse concatenateValues(Object[] input) {
        List<Object> objects = List.of(input);
        List<String> strings = new ArrayList<>();
        List<Person> persons = new ArrayList<>();
        List<BigInteger> numbersToBeSummed = new ArrayList<>();

        if (isEmpty(objects)) {
            throw new NoElementsException("input must not be null");
        }
        objects.forEach(e -> {
                    if (e instanceof Person) {
                        persons.add((Person) e);
                    }
                    if (e instanceof Number) {
                        numbersToBeSummed.add(castToBigInt(e));
                    }
                    if (e instanceof String || e instanceof Character) {
                        strings.add(e.toString());
                    }
                }
        );
        return SortingResponse.builder()
                .sum(numbersToBeSummed.stream().reduce(ZERO, BigInteger::add))
                .joinedText(join(" ", strings))
                .persons(persons)
                .build();
    }

    private BigInteger castToBigInt(Object o) {
        if (o instanceof Integer) {
            return valueOf((Integer) o);
        }
        return valueOf((Long) o);
    }
}
