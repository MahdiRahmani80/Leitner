package ir.m3.rahmani.leitner.data.repository.source

import ir.m3.rahmani.leitner.data.local.dao.LeitnerDao
import ir.m3.rahmani.leitner.data.local.entities.CardEntity
import kotlinx.coroutines.flow.Flow

class LeitnerLocalDataSource(
  private val dao: LeitnerDao
) : LeitnerDataSource {

  override fun todayReviewCards(currentTime: Long) =
    dao.getTodayReviewCards(currentTime)

  override suspend fun removeCard(card: CardEntity) {
    dao.removeCard(card)
  }

  override suspend fun updateCard(card: CardEntity) {
    dao.updateCard(card)
  }

  override suspend fun addCard(card: CardEntity) {
    dao.addCard(card)
  }
}