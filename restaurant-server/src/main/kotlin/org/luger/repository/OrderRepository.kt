package org.luger.repository

import org.luger.domain.Order
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by gerardo8.
 */
interface OrderRepository : JpaRepository<Order, Long>
