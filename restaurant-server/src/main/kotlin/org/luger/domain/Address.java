package org.luger.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by gerardo8.
 */
@Getter
@Setter
@Entity
public class Address extends AbstractPersistable<Long> {

    @Column(nullable = false, columnDefinition = "text")
    private String street;

    @Column(nullable = false, columnDefinition = "text")
    private String city;

    @Column(nullable = false, columnDefinition = "text")
    private String state;

    @Column(nullable = false, columnDefinition = "text")
    private String country;

    @Column(nullable = false, columnDefinition = "text")
    private String postalCode;

}
