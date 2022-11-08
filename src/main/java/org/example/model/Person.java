package org.example.model;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String firstname;
    private String lastname;
    private Integer age;
    private String gender;
}
