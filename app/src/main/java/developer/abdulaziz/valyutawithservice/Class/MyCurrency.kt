package developer.abdulaziz.valyutawithservice.Class

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyCurrency(
    val Ccy: String? = null,
    val CcyNm_EN: String? = null,
    val CcyNm_RU: String? = null,
    val CcyNm_UZ: String? = null,
    val CcyNm_UZC: String? = null,
    val Code: String? = null,
    val Date: String? = null,
    val Diff: String? = null,
    val Nominal: String? = null,
    val Rate: String? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)