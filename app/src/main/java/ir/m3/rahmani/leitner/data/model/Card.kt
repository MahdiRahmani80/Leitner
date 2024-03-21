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
    cardValidate(question)
    cardValidate(answer)
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

private fun cardValidate(str:String){
  if (str.isEmpty() || str.length < 3)
    throw ValidateException(CARD_VALIDATION_MESSAGE)
}

private const val CARD_VALIDATION_MESSAGE = "question/answer is empty or less than 3 chars."