package developer.abdulaziz.valyutawithservice.Room.Dao

import androidx.room.*
import developer.abdulaziz.valyutawithservice.Class.MyCurrency

@Dao
interface MyDao {
    @Insert
    fun create(myCurrency: MyCurrency)

    @Query("select * from mycurrency")
    fun read(): List<MyCurrency>

    @Update
    fun update(myCurrency: MyCurrency)

    @Delete
    fun delete(myCurrency: MyCurrency)
}