package ir.m3.rahmani.leitner.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey
import ir.m3.rahmani.leitner.data.model.Card

@Fts4   // for fast to search
@Entity(tableName = "card")
data class CardEntity(
  @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
  val question: String,
  val answer: String,
  val nextReviewDate: Long
)
