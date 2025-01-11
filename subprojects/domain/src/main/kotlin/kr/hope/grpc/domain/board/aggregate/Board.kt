package kr.hope.grpc.domain.board.aggregate

class Board(
    var id: Int? = null,
    var title: String,
    var content: String,
    var writer: String,
)
