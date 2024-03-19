package ir.m3.rahmani.leitner.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.m3.rahmani.leitner.utils.DATABASE_NAME
import ir.m3.rahmani.leitner.utils.DATABASE_VERSION
import ir.m3.rahmani.leitner.data.local.dao.LeitnerDao
import ir.m3.rahmani.leitner.data.local.entities.Card
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Card::class], version = DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

  abstract fun leitnerDao(): LeitnerDao

  companion object {
    @Volatile
    private var instance: AppDatabase? = null

    @OptIn(InternalCoroutinesApi::class)
    fun getInstance(context: Context): AppDatabase {
      return instance ?: synchronized(this) {
        instance ?: buildDatabase(context).also { instance = it }
      }
    }

    private fun buildDatabase(context: Context) =
      Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()

  }
}