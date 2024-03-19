package ir.m3.rahmani.leitner.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ir.m3.rahmani.leitner.data.local.entities.CardEntity
import kotlinx.coroutines.flow.Flow

/**
 *  Based on Android doc [Write asynchronous DAO queries](https://developer.android.com/training/data-storage/room/async-queries)
 */
@Dao
interface LeitnerDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun addCard(card: CardEntity)

  @Delete
  suspend fun removeCard(card: CardEntity)

  @Query("SELECT * FROM card WHERE nextReviewDate <= :currentTime")
  fun getTodayReviewCards(currentTime: Long): Flow<List<CardEntity>>

  @Update
  suspend fun updateCard(card: CardEntity)

}