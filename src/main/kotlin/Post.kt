data class Post(
    val id: Int,
    val ownerId: Int,
    val text: String = "Hello World",
    val postType: String,
    val canPin: Boolean = true,
    val canEdit: Boolean = true,
    val comments: DataComments
)
