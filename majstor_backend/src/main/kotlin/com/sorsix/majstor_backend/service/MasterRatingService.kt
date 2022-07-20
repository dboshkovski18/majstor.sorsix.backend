package com.sorsix.majstor_backend.service

import com.sorsix.majstor_backend.domain.MasterRating
import com.sorsix.majstor_backend.domain.dtos.MasterRatingDto
import com.sorsix.majstor_backend.domain.enum.Recommendation
import com.sorsix.majstor_backend.repository.MasterRatingRepo
import org.springframework.stereotype.Service

@Service
class MasterRatingService(private val master_rating_repo: MasterRatingRepo) {


    fun rate(ratingDto: MasterRatingDto): MasterRating {
        return master_rating_repo.save(
            MasterRating(
                client = ratingDto.client,
                master = ratingDto.master,
                recommendation = Recommendation.valueOf(ratingDto.recommendation)
            )
        )
    }

}