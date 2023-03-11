import org.junit.Assert.*
import org.junit.Test

class MainKtTest {

    @Test
    fun createCommentTest() {
        val firstPost = Post(1, 0, comments = DataComments(12), postType = "news")
        val secondPost = Post(2, 12, comments = DataComments(116), postType = "mems")
        val wall = WallService().apply {
            add(firstPost)
            add(secondPost)
        }
        val comment = Comment(12,11032023,"Hello")
        val result = wall.createComment(1,comment)
    }
    @Test(expected = PostNotFoundException::class)
    fun createCommentTestException(){
        val firstPost = Post(1, 0, comments = DataComments(12), postType = "news")
        val secondPost = Post(2, 12, comments = DataComments(116), postType = "mems")
        val wall = WallService().apply {
            add(firstPost)
            add(secondPost)
        }
        val comment = Comment(12,11032023,"Hello")
        val result = wall.createComment(5,comment)
        assertEquals(comment,result)
    }
}