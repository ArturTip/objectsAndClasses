fun main() {
    val newPost = Post(1, 1, "new post text", null, Reposts(), Likes())
    val newPostTestNull = Post(4, 5, "postText", Comments(), null, Likes())
    WallServise.add(newPost)
    WallServise.add(newPostTestNull)
    WallServise.showPost()

    addAttachment(newPost.attachments, AudioAttachment())
    addAttachment(newPostTestNull.attachments, VideoAttachment())
    WallServise.showPost()

}



data class Post(
    var id: Int,
    val ownerId: Int? = 1,
    val fromId: Int = 10,
    val text: String,
    val comments: Comments? = null,
    val reposts: Reposts? = null,
    val likes: Likes,
    val attachments: MutableList<Attachment> = mutableListOf<Attachment>()
) {
    constructor(
        ownerId: Int?, fromId: Int, text: String, comments: Comments?, reposts: Reposts?, likes: Likes,
    ) : this(0, ownerId, fromId, text, comments, reposts, likes)

}

class Comments(
    var countComments: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canUserCloseComments: Boolean = true,
    val canUserOpenComments: Boolean = true,

    )

class Reposts(
    var countReposts: Int = 0, val userReposted: Boolean = true
)

data class Likes(var countLikes: Int = 0, val userLikes: Boolean = true, val userCanLikes: Boolean = true)

object WallServise {
    var posts = emptyArray<Post>()

    private var nextId = 1

    fun clear() {
        posts = emptyArray()
        nextId = 1
    }

    fun showPost() { //Выводит посты
        for (post in posts) {
            println(post)
        }
    }

    fun update(post: Post): Boolean {

        for ((index, updatePost) in posts.withIndex()) {
            if (updatePost.id == post.id) {
                posts[index] = post.copy(likes = post.likes.copy())
                return true
            }
        }
        return false
    }

    fun add(post: Post): Post { // Добавляет новый пост
        val newPost = post.copy(id = nextId, likes = post.likes.copy())
        posts += newPost
        nextId += 1
        return newPost
    }


}







