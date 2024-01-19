package issue.issueservice.web

import issue.issueservice.config.AuthUser
import issue.issueservice.model.CommentRequest
import issue.issueservice.model.CommentResponse
import issue.issueservice.service.CommentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/issues/{issueId}/comments")
class CommentController(
    private val commentService: CommentService,
) {

    @PostMapping
    fun create(
        authUser: AuthUser,
        @PathVariable issueId: Long,
        @RequestBody request: CommentRequest
    ): CommentResponse {
        return commentService.create(issueId, authUser.userId, authUser.username, request)
    }
}