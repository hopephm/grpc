package kr.hope.grpc.domain.board.service.dto

data class CreateBoardRequest(
    val title: String,
    val content: String,
    val writer: String,
)
