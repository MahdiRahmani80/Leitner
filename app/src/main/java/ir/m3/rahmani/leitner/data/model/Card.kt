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
    // Question validation
    if (question.isEmpty() || question.length < 3)
      throw ValidateException(QUESTION_VALIDATION_MESSAGE)

    // Answer validation
    if (answer.isEmpty() || answer.length < 3)
      throw ValidateException(ANSWER_VALIDATION_MESSAGE)

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

private const val QUESTION_VALIDATION_MESSAGE = "question is empty or less than 3 chars."
private const val ANSWER_VALIDATION_MESSAGE = "answer is empty or less than 3 chars."