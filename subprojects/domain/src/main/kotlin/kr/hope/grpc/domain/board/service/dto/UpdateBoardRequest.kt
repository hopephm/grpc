package kr.hope.grpc.domain.board.service.dto

data class UpdateBoardRequest(
    val boardId: Int,
    val title: String,
    val content: String,
    val writer: String,
)
