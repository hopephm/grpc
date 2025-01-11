package kr.hope.grpc.ui.grpc.board.converter

import kr.hope.grpc.protocol.Board
import kr.hope.grpc.protocol.CreateBoardRequest
import kr.hope.grpc.protocol.CreateBoardResponse
import kr.hope.grpc.protocol.DeleteBoardRequest
import kr.hope.grpc.protocol.DeleteBoardResponse
import kr.hope.grpc.protocol.GetBoardRequest
import kr.hope.grpc.protocol.GetBoardResponse
import kr.hope.grpc.protocol.UpdateBoardRequest
import kr.hope.grpc.protocol.UpdateBoardResponse

object BoardDtoConverter {
    fun CreateBoardRequest.toDto(): kr.hope.grpc.domain.board.service.dto.CreateBoardRequest {
        return kr.hope.grpc.domain.board.service.dto.CreateBoardRequest(
            title = title,
            content = content,
            writer = writer,
        )
    }

    fun kr.hope.grpc.domain.board.service.dto.CreateBoardResponse.toProto(): CreateBoardResponse {
        return CreateBoardResponse.newBuilder()
            .setBoard(this.board.toProto())
            .build()
    }

    private fun kr.hope.grpc.domain.board.aggregate.Board.toProto(): Board {
        return Board.newBuilder().also { builder ->
            this.id?.let { builder.boardId = it }
            builder.title = this.title
            builder.content = this.content
            builder.writer = this.writer

        }.build()
    }

    fun GetBoardRequest.toDto(): kr.hope.grpc.domain.board.service.dto.GetBoardRequest {
        return kr.hope.grpc.domain.board.service.dto.GetBoardRequest(
            boardId = boardId,
        )
    }

    fun kr.hope.grpc.domain.board.service.dto.GetBoardResponse.toProto(): GetBoardResponse {
        return GetBoardResponse.newBuilder()
            .setBoard(this.board.toProto())
            .build()
    }

    fun UpdateBoardRequest.toDto(): kr.hope.grpc.domain.board.service.dto.UpdateBoardRequest {
        return kr.hope.grpc.domain.board.service.dto.UpdateBoardRequest(
            boardId = boardId,
            title = title,
            content = content,
            writer = writer,
        )
    }

    fun kr.hope.grpc.domain.board.service.dto.UpdateBoardResponse.toProto(): UpdateBoardResponse {
        return UpdateBoardResponse.newBuilder()
            .setBoard(this.board.toProto())
            .build()
    }

    fun DeleteBoardRequest.toDto(): kr.hope.grpc.domain.board.service.dto.DeleteBoardRequest {
        return kr.hope.grpc.domain.board.service.dto.DeleteBoardRequest(
            boardId = boardId,
        )
    }

    fun kr.hope.grpc.domain.board.service.dto.DeleteBoardResponse.toProto(): DeleteBoardResponse {
        return DeleteBoardResponse.newBuilder().also { builder ->
            this.boardId?.let { builder.boardId = it }
        }.build()
    }
}
