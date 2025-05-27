import WallServise.posts
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class WallServiseTest {
    @Before
    fun clearBeforeTest() {
        WallServise.clear()
    }

    @Test
    fun update() {
        WallServise.add(Post(15, 20, "Test", Comments(), Reposts(), Likes()))
        WallServise.add(Post(id = 3, 15, 20, "HelloWord", Comments(), Reposts(), Likes()))
        println(WallServise.update(Post(id = 1, 15, 20, "NewTestText", Comments(), Reposts(), Likes())))
        WallServise.showPost()
        val result = WallServise.update(Post(id = 1, 15, 20, "NewTestText", Comments(), Reposts(), Likes()))
        assertEquals(true, result)

    }

    @Test
    fun updateNotId() {
        WallServise.add(Post(15, 20, "Test", Comments(), Reposts(), Likes()))
        WallServise.add(Post(id = 3, 15, 20, "HelloWord", Comments(), Reposts(), Likes()))
        println(WallServise.update(Post(id = 1, 15, 20, "NewTestText", Comments(), Reposts(), Likes())))
        WallServise.showPost()
        val result = WallServise.update(Post(id = 25, 15, 20, "NewTestText", Comments(), Reposts(), Likes()))
        assertEquals(false, result)
    }

    @Test
    fun add() {

        val posts = WallServise.posts
        WallServise.add(Post(15, 20, "Test", Comments(), Reposts(), Likes()))
        WallServise.add(Post(id = 3, 15, 20, "HelloWord", Comments(), Reposts(), Likes()))
        WallServise.showPost()
        val result = posts.size
        assertEquals(2, result)

    }
}