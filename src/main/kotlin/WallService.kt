import javax.print.attribute.standard.JobStateReason

class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    fun add(post: Post):Post {
        return post.also {
            posts += it
        }
    }

    fun remove(post: Post) {
        posts.also {
            posts = it.filterIndexed { index, post1 ->
                post1 != post
            }.toTypedArray()
        }
    }

    fun createComment(postId: Int, comment: Comment):Comment {
        posts.find {
            it.id == postId
        } ?: throw PostNotFoundException()
        return comment.also {
            comments+=comment
        }
    }
}