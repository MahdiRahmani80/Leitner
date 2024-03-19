package ir.m3.rahmani.leitner.data.repository

import ir.m3.rahmani.leitner.data.local.entities.CardEntity
import ir.m3.rahmani.leitner.data.model.Card
import ir.m3.rahmani.leitner.data.model.asCardEntity
import ir.m3.rahmani.leitner.data.model.asExternalModel
import ir.m3.rahmani.leitner.data.repository.source.LeitnerDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LeitnerRepositoryImpl(
  private val localDataSource: LeitnerDataSource
  // and remote data source if we have
) : LeitnerRepository {

  override fun todayReviewCards(currentTime: Long): Flow<List<Card>> =
    localDataSource.todayReviewCards(currentTime)
      .map { it.map(CardEntity::asExternalModel) } // to convert to external model [Card] not [CardEntity]

  override suspend fun removeCard(card: Card) {
    localDataSource.removeCard(card.asCardEntity())
  }

  override suspend fun updateCard(card: Card) {
    localDataSource.updateCard(card.asCardEntity())
  }

  override suspend fun addCard(card: Card) {
    localDataSource.addCard(card.asCardEntity())
  }
}