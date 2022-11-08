package tasks.task1.model;

import lombok.*;

import java.math.BigInteger;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SortingResponse {
    private String joinedText;
    private BigInteger sum;
    private List<Person> persons;
}
