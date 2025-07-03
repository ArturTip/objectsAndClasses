interface Attachment {
    val type: String
}


class AudioAttachment(
    val audio: Audio = Audio(null, null, null)
) : Attachment {
    override val type: String = "audio"
    override fun toString(): String {
        return "$type(${audio.id}, ${audio.albumId}, ${audio.title})"
    }
}

class VideoAttachment(val video: Video = Video(null, null, null)) : Attachment {
    override val type: String = "video"
    override fun toString(): String {
        return "$type ${video.id},${video.userId},${video.title})"
    }
}

class PhotoAttachment(
    val photo: Photo = Photo(null, null, null)
) : Attachment {
    override val type: String = "photo"
    override fun toString(): String {
        return "$type${photo.id},${photo.userId},${photo.albumId})"
    }
}

class FileAttachment(
    val file: File = File(null, null, null)
) : Attachment {
    override val type: String = "file"
    override fun toString(): String {
        return "$type ${file.id},${file.userId}, ${file.title}"
    }
}

class LinkAttachment(
    val link: AttachedLink = AttachedLink(null, null, null)
) : Attachment {
    override val type: String = "link"
    override fun toString(): String {
        return "$type ${link.url}, ${link.title}, ${link.caption}"
    }


}


class Audio(var id: Int?, var albumId: Int?, var title: String?)

class Video(var id: Int? = null, val userId: Int? = null, val title: String? = null)

class Photo(val id: Int? = null, val userId: Int? = null, val albumId: String? = null)

class File(val id: Int? = null, val userId: Int? = null, val title: String? = null)

class AttachedLink(val url: String? = null, val title: String? = null, val caption: String? = null)


fun addAttachment(attachments: MutableList<Attachment>, newAttachment: Attachment) {
    attachments.add(newAttachment)

}