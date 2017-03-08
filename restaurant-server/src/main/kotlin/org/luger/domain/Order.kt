package org.luger.domain

import org.luger.app.domain.User
import org.springframework.data.jpa.domain.AbstractPersistable
import java.time.LocalDateTime
import javax.persistence.*

/**
 * Created by gerardo8.
 */
@Entity
class Order(

    @ManyToOne
    val user: User?,

    @OrderColumn
    @Column(unique = true)
    @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
    val items: List<Item> = listOf(),

    val orderedDate: LocalDateTime = LocalDateTime.now(),

    var status: Status = Order.Status.PAYMENT_EXPECTED

) : AbstractPersistable<Long>() {

    enum class Status {
        PAYMENT_EXPECTED,
        PAID,
        PREPARING,
        READY,
        TAKEN
    }
}
