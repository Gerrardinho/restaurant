package org.luger.domain;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.money.MonetaryAmount;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by gerardo8.
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Entity
public class Item extends AbstractPersistable<Long> {

    @NotEmpty
    @Column(nullable = false, columnDefinition = "text")
    private String name;

    private MonetaryAmount price;

}
