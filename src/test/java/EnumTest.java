import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static tasks.task2.GradingEnum.*;

public class EnumTest {
    @Test
    public void testEnumAll() {
        Assertions.assertEquals(GOOD.showAll(), List.of(EXCELLENT, GOOD, SATISFACTORY, UNSATISFACTORY));
    }

    @Test
    public void testEnumNext() {
        Assertions.assertEquals(EXCELLENT.next(), GOOD);
        Assertions.assertEquals(GOOD.next(), SATISFACTORY);
        Assertions.assertEquals(SATISFACTORY.next(), UNSATISFACTORY);
    }

    @Test
    public void testEnumPrevious() {
        Assertions.assertEquals(UNSATISFACTORY.previous(), SATISFACTORY);
        Assertions.assertEquals(SATISFACTORY.previous(), GOOD);
    }
}

