package id.ac.polbeng.depandi.sportappmade.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class PlayerResponse (
    @field:SerializedName("idPlayer")
    var idPlayer: Int,
    @field:SerializedName("idTeam")
    var idTeam: Int,
    @field:SerializedName("strNationality")
    var strNationality: String,
    @field:SerializedName("strPlayer")
    var strPlayer: String,
    @field:SerializedName("strTeam")
    var strTeam: String,
    @field:SerializedName("strSport")
    var strSport: String,
    @field:SerializedName("dateBorn")
    var dateBorn: String,
    @field:SerializedName("strBirthLocation")
    var strBirthLocation: String,
    @field:SerializedName("strDescriptionEN")
    var strDescriptionEN: String,
    @field:SerializedName("strGender")
    var strGender: String,
    @field:SerializedName("strPosition")
    var strPosition: String,
    @field:SerializedName("strFacebook")
    var strFacebook: String,
    @field:SerializedName("strTwitter")
    var strTwitter: String,
    @field:SerializedName("strInstagram")
    var strInstagram: String,
    @field:SerializedName("strHeight")
    var strHeight: String,
    @field:SerializedName("strWeight")
    var strWeight: String,
    @field:SerializedName("strThumb")
    var strThumb: String
)