package ir.m3.rahmani.leitner.feature.home

import ir.m3.rahmani.leitner.data.Card

data class HomeUiState(
  val isForegroundCard: Boolean = true,
  val card: Card = Card(),
  val isPremium: Boolean = false,
  val countCardLeft: Int = 0
)
