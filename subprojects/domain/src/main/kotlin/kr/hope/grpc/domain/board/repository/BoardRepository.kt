package kr.hope.grpc.domain.board.repository

import kr.hope.grpc.domain.board.aggregate.Board

interface BoardRepository {
    fun createBoard(board: Board): Board
    fun getBoard(id: Int): Board
    fun updateBoard(board: Board): Board
    fun deleteBoard(id: Int): Board
}
