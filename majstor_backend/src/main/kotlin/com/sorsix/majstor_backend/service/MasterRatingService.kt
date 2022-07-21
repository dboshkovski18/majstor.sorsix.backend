package com.sorsix.majstor_backend.service

import com.sorsix.majstor_backend.domain.MasterRating
import com.sorsix.majstor_backend.domain.dtos.MasterRatingDto
import com.sorsix.majstor_backend.domain.enum.Recommendation
import com.sorsix.majstor_backend.repository.ClientRepo
import com.sorsix.majstor_backend.repository.MasterRatingRepo
import com.sorsix.majstor_backend.repository.MasterRepo
import org.springframework.stereotype.Service

@Service
class MasterRatingService(
    private val master_rating_repo: MasterRatingRepo,
    private val masterRepo: MasterRepo,
    private val clientRepo: ClientRepo
) {


    fun rate(ratingDto: MasterRatingDto): MasterRating {
        return master_rating_repo.save(
            MasterRating(
                client = clientRepo.findById(ratingDto.client).get(),
                master = masterRepo.findById(ratingDto.master).get(),
                recommendation = Recommendation.valueOf(ratingDto.recommendation)
            )
        )
    }

    fun getRecommendationsByMaster(master_id: Long): Int{
        return master_rating_repo.countAllByMaster_IdAndRecommendation(master_id, Recommendation.RECOMMENDED)
    }

    fun checkIfMasterRatedByClient(client_id: Long, master_id: Long): Boolean{
        return master_rating_repo.countAllByClient_IdAndMaster_Id(client_id,master_id) > 0
    }

}