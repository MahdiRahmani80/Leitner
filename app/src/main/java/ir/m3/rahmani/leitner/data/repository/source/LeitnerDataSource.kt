package ir.m3.rahmani.leitner.data.repository.source

import ir.m3.rahmani.leitner.data.local.entities.CardEntity
import kotlinx.coroutines.flow.Flow

interface LeitnerDataSource {

  fun todayReviewCards(currentTime: Long): Flow<List<CardEntity>>
  suspend fun removeCard(card: CardEntity)
  suspend fun updateCard(card: CardEntity)
  suspend fun addCard(card: CardEntity)
}