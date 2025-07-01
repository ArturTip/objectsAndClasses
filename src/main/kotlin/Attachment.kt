interface Attachment {
    val type: String
}


class AudioAttachment : Attachment {
    override val type: String = "audio"
    val audio = Audio(null,null,null)
    override fun toString(): String {
        return "$type(${audio.id}, ${audio.userId}, ${audio.text})"
    }
}

class VideoAttachment : Attachment {
    override val type: String = "video"
     val video = Video()
    override fun toString(): String {
        return "$type ${video.id},${video.userId},${video.text})"
    }
}

class PhotoAttachment : Attachment {
    override val type: String = "photo"
    val photo = Photo()
    override fun toString(): String {
        return "$type${photo.id},${photo.userId},${photo.text})"
    }
}


class Audio(var id: Int?, var userId: Int?, var text: String?)

class Video(var id: Int? = null, val userId: Int? = null, val text: String? = null)

class Photo(val id: Int? = null, val userId: Int? = null, val text: String? = null)

fun addAttachment(attachments: MutableList<Attachment>, newAttachment: Attachment) {
    attachments.add(newAttachment)

}