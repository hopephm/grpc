package kr.hope.grpc.domain.board.service.dto

import kr.hope.grpc.domain.board.aggregate.Board

data class CreateBoardResponse(
    val board: Board,
)
