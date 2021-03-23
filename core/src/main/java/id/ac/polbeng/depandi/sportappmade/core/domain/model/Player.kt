package id.ac.polbeng.depandi.sportappmade.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    var idPlayer: Int,
    var idTeam: Int?,
    var strNationality: String?,
    var strPlayer: String?,
    var strTeam: String?,
    var strSport: String?,
    var dateBorn: String?,
    var strBirthLocation: String?,
    var strDescriptionEN: String?,
    var strGender: String?,
    var strPosition: String?,
    var strFacebook: String?,
    var strTwitter: String?,
    var strInstagram: String?,
    var strHeight: String?,
    var strWeight: String?,
    var strThumb: String?
): Parcelable