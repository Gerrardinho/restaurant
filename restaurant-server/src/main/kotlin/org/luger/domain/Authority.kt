package org.luger.app.domain

import org.hibernate.validator.constraints.NotEmpty
import org.springframework.data.jpa.domain.AbstractPersistable
import java.io.Serializable
import javax.persistence.*

/**
 * Created by gerardo8.
 */
@Entity
class Authority(

        @NotEmpty(message = "Authority is required.")
        @Column(unique = true, nullable = false, columnDefinition = "TEXT")
        var authority: String = ""

) : AbstractPersistable<Short>()
