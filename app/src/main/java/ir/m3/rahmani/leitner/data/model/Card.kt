package ir.m3.rahmani.leitner.data.model


import ir.m3.rahmani.leitner.data.local.entities.CardEntity
import ir.m3.rahmani.leitner.utils.ValidateException


data class Card(
  val id: Int,
  val question: String,
  val answer: String,
  val nextReviewDate: Long
) {
  init {
    cardValidate(question, Label.QUESTION)
    cardValidate(answer, Label.ANSWER)
  }
}

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
  answer = answer,
  nextReviewDate = nextReviewDate
)

private fun cardValidate(str: String, label: Label) {
  if (str.isEmpty() || str.length < 3)
    throw ValidateException(label.name + CARD_VALIDATION_MESSAGE)
}

private enum class Label {
  QUESTION, ANSWER
}

private const val CARD_VALIDATION_MESSAGE = " is empty or less than 3 chars."