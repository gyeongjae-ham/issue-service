package issue.issueservice.service

import issue.issueservice.domain.Comment
import issue.issueservice.domain.CommentRepository
import issue.issueservice.domain.IssueRepository
import issue.issueservice.exception.NotFoundException
import issue.issueservice.model.CommentRequest
import issue.issueservice.model.CommentResponse
import issue.issueservice.model.toResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentService(
    private val commentRepository: CommentRepository,
    private val issueRepository: IssueRepository,
) {

    @Transactional
    fun create(issueId: Long, userId: Long, username: String, request: CommentRequest): CommentResponse {
        val issue = issueRepository.findByIdOrNull(issueId) ?: throw NotFoundException("이슈가 존재하지 않습니다")

        val comment = Comment(
            issue = issue,
            userId = userId,
            username = username,
            body = request.body,
        )

        issue.comments.add(comment)
        return commentRepository.save(comment).toResponse()
    }
}