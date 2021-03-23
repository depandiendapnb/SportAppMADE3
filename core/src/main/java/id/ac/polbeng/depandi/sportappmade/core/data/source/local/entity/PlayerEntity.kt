package id.ac.polbeng.depandi.sportappmade.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_favorite_player")
data class PlayerEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idPlayer")
    var idPlayer: Int,
    @ColumnInfo(name = "idTeam")
    var idTeam: Int?,
    @ColumnInfo(name = "strNationality")
    var strNationality: String?,
    @ColumnInfo(name = "strPlayer")
    var strPlayer: String?,
    @ColumnInfo(name = "strTeam")
    var strTeam: String?,
    @ColumnInfo(name = "strSport")
    var strSport: String?,
    @ColumnInfo(name = "dateBorn")
    var dateBorn: String?,
    @ColumnInfo(name = "strBirthLocation")
    var strBirthLocation: String?,
    @ColumnInfo(name = "strDescriptionEN")
    var strDescriptionEN: String?,
    @ColumnInfo(name = "strGender")
    var strGender: String?,
    @ColumnInfo(name = "strPosition")
    var strPosition: String?,
    @ColumnInfo(name = "strFacebook")
    var strFacebook: String?,
    @ColumnInfo(name = "strTwitter")
    var strTwitter: String?,
    @ColumnInfo(name = "strInstagram")
    var strInstagram: String?,
    @ColumnInfo(name = "strHeight")
    var strHeight: String?,
    @ColumnInfo(name = "strWeight")
    var strWeight: String?,
    @ColumnInfo(name = "strThumb")
    var strThumb: String?
)
