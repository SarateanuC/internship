import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task1.exceptions.NoElementsException;
import tasks.task1.model.Person;
import tasks.task1.model.SortingResponse;
import tasks.task1.service.SortingService;

import java.util.List;

import static java.math.BigInteger.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SortingServiceTest {
    private SortingService sortingService;

    @BeforeEach
    public void init() {
        sortingService = new SortingService();
    }

    @Test
    @SneakyThrows
    public void concatValuesTestSuccess() {
        Person person = Person.builder()
                .age(20)
                .firstname("Ion")
                .gender("M")
                .lastname("Buga")
                .build();
        Object[] obj = new Object[]{1, 2L, "nice", '&', "pretty", person};
        SortingResponse sortingResponse = sortingService.concatenateValues(obj);
        assertEquals(sortingResponse.getSum(), valueOf(3));
        assertEquals(sortingResponse.getJoinedText(), "nice & pretty");
        assertEquals(sortingResponse.getPersons(), List.of(person));
    }

    @Test
    public void concatValuesTestNullObj() {
        Object[] obj = new Object[]{};
        Throwable exception = assertThrows(NoElementsException.class, () -> sortingService.concatenateValues(obj));
        assertEquals("input must not be null", exception.getMessage());
    }
}
