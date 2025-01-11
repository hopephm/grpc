package kr.hope.grpc.domain.board.service.dto

import kr.hope.grpc.domain.board.aggregate.Board

data class UpdateBoardResponse(
    val board: Board,
)
