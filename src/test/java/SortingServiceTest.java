import lombok.SneakyThrows;
import org.example.exceptions.NoElementsException;
import org.example.model.Person;
import org.example.model.SortingResponse;
import org.example.service.SortingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

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
        SortingResponse sortingResponse = sortingService.concatenateValuesNew(obj);
        assertEquals(sortingResponse.getSum(), BigInteger.valueOf(3));
        assertEquals(sortingResponse.getJoinedText(), "nice & pretty");
        assertEquals(sortingResponse.getPersons(), List.of(person));
    }

    @Test
    public void concatValuesTestNullObj() {
        Object[] obj = new Object[]{};
        Throwable exception = assertThrows(NoElementsException.class, () -> sortingService.concatenateValuesNew(obj));
        assertEquals("input must not be null", exception.getMessage());
    }
}
