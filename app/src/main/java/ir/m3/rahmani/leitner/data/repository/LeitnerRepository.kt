package ir.m3.rahmani.leitner.data.repository

import ir.m3.rahmani.leitner.data.local.entities.CardEntity
import ir.m3.rahmani.leitner.data.model.Card
import kotlinx.coroutines.flow.Flow

interface LeitnerRepository {

  fun todayReviewCards(currentTime:Long): Flow<List<Card>>
  suspend fun removeCard(card: Card)
  suspend fun updateCard(card: Card)
  suspend fun addCard(card: Card)

}