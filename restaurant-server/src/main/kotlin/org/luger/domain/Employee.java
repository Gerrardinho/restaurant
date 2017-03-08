package org.luger.domain;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * Created by gerardo8.
 */
@Data
@NoArgsConstructor
@Entity
public class Employee extends Person {

    @NotEmpty
    @Column(nullable = false, columnDefinition = "text")
    private String rfc;

    public Employee(String firstName, String lastName, String email, LocalDate birthDate, String rfc) {
        super(firstName, lastName, email, birthDate);
        this.rfc = rfc;
    }
}
