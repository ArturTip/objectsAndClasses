fun main() {
    WallServise.add(Post(50, 10, "HelloWord", Comments(), Reposts(), Likes()))
    WallServise.add(Post(10, 15, "HelloWord2", Comments(), Reposts(), Likes()))
    WallServise.add(Post(25, 36, "HelloWord3", Comments(), Reposts(), Likes()))
    WallServise.add(Post(1, 20, "HelloWord4", Comments(), Reposts(), Likes()))
    WallServise.update(Post(id = 2, 15, 15, "newHelloWord", Comments(), Reposts(), Likes()))
    WallServise.showPost()
}

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
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }


    fun add(post: Post): Post { // Добавляет новый пост
        val newPost = post.copy(id = nextId)
        posts += newPost
        nextId += 1
        return newPost
    }

}

data class Post(
    var id: Int,
    val ownerId: Int = 1,
    val fromId: Int = 10,
    val text: String,
    val comments: Comments,
    val reposts: Reposts,
    val likes: Likes
) {
    constructor(
        ownerId: Int, fromId: Int, text: String, comments: Comments, reposts: Reposts, likes: Likes
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

class Likes(var countLikes: Int = 0, val userLikes: Boolean = true, val userCanLikes: Boolean = true)

