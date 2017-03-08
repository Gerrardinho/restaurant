package org.luger.repository

import org.luger.domain.MexicanFoodRestaurant
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by gerardo8.
 */
interface MexicanFoodRestaurantRepository : JpaRepository<MexicanFoodRestaurant, Short>
