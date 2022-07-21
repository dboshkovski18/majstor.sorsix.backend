package com.sorsix.majstor_backend.repository

import com.sorsix.majstor_backend.domain.MasterRating
import com.sorsix.majstor_backend.domain.enum.Recommendation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MasterRatingRepo : JpaRepository<MasterRating,Long> {

    fun countAllByMaster_IdAndRecommendation(master_id: Long, recommendation: Recommendation): Int

    fun countAllByClient_IdAndMaster_Id(client_id: Long, master_id: Long): Int
}