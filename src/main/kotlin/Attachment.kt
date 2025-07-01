interface Attachment { val type : String}

 class AudioAttachment  : Attachment {
   override val type : String = "audio"
    val audio = Audio()
     override fun toString(): String {
         return "Audio(${audio.id}, ${audio.userId}, ${audio.text})"
     }
}

 class VideoAttachment  : Attachment {
   override val type : String = "video"
    val vidio = Vidio()
}

class PhotoAttachment  : Attachment {
    override val type : String = "photo"
    val photo = Photo()
}


 class Audio(var id : Int? = null, var userId:Int? = null, var text : String? = null)

 class Vidio(var id : Int? = null, val userId:Int? = null, val text : String? = null)

 class Photo (val id : Int? = null, val userId:Int? = null, val text : String? = null)