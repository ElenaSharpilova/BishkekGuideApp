package android.example.tourguideapp

data class InfoAboutObject(
    val name: String? = null,
    //val urlImage: String?,
    val address: String? = null,
    val description: String? = null,
    val phone: String?,
    var expand : Boolean = false,
    val location: String
)
