package ir.m3.rahmani.leitner.data

import java.util.Calendar

/**
 * todo add this to ROOM database
 */
data class Card(
  val question: String = "",
  val answer: String = "",
  val nextReviewDate: Long = Calendar.getInstance().timeInMillis
) {
  val id: Int = 0
  val addedDate = Calendar.getInstance().timeInMillis
}
