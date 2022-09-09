package developer.abdulaziz.valyutawithservice.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import developer.abdulaziz.valyutawithservice.Class.MyCurrency
import developer.abdulaziz.valyutawithservice.Room.Dao.MyDao

@Database(entities = [MyCurrency::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun myDao(): MyDao

    companion object {
        private var appDatabase: MyDatabase? = null

        @Synchronized
        fun getInstance(context: Context): MyDatabase {
            if (appDatabase == null) {
                appDatabase =
                    Room.databaseBuilder(context, MyDatabase::class.java, "user_data")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return appDatabase!!
        }
    }
}