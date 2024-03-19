package ir.m3.rahmani.leitner.feature.home

import ir.m3.rahmani.leitner.data.model.Card
import kotlinx.coroutines.flow.Flow


data class HomeUiState(
  val isForegroundCard: Boolean = true,
  val cards: Flow<List<Card>>? = null,
  val isPremium: Boolean = false,
  val countCardLeft: Int = 0
)
