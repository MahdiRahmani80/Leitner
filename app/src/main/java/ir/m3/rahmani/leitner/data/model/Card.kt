package ir.m3.rahmani.leitner.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey
import ir.m3.rahmani.leitner.data.local.entities.CardEntity
import java.util.Calendar
import java.util.Date

data class Card(
  val id: Int,
  val question: String,
  val answer: String,
  val nextReviewDate: Long
)

/**
 * Converts the local model to the external model for use
 * by layers external to the data layer
 */
fun CardEntity.asExternalModel() = Card(
  id = id,
  question = question,
  answer = answer,
  nextReviewDate = nextReviewDate
)

fun Card.asCardEntity() = CardEntity(
  id = id,
  question = question,
  answer=answer,
  nextReviewDate= nextReviewDate
)