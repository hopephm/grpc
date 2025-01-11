package kr.hope.grpc.ui.grpc.board

import io.grpc.stub.StreamObserver
import kr.hope.grpc.domain.board.service.BoardService
import kr.hope.grpc.protocol.BoardServiceGrpc
import kr.hope.grpc.protocol.CreateBoardRequest
import kr.hope.grpc.protocol.CreateBoardResponse
import kr.hope.grpc.protocol.DeleteBoardRequest
import kr.hope.grpc.protocol.DeleteBoardResponse
import kr.hope.grpc.protocol.GetBoardRequest
import kr.hope.grpc.protocol.GetBoardResponse
import kr.hope.grpc.protocol.UpdateBoardRequest
import kr.hope.grpc.protocol.UpdateBoardResponse
import kr.hope.grpc.ui.grpc.board.converter.BoardDtoConverter.toDto
import kr.hope.grpc.ui.grpc.board.converter.BoardDtoConverter.toProto
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class BoardGrpcService(
    private val boardService: BoardService,
) : BoardServiceGrpc.BoardServiceImplBase() {
    override fun createBoard(
        request: CreateBoardRequest,
        responseObserver: StreamObserver<CreateBoardResponse>,
    ) {
        val response = boardService.createBoard(request.toDto())
        responseObserver.onNext(response.toProto())
        responseObserver.onCompleted()
    }

    override fun getBoard(
        request: GetBoardRequest,
        responseObserver: StreamObserver<GetBoardResponse>,
    ) {
        val response = boardService.getBoard(request.toDto())
        responseObserver.onNext(response.toProto())
        responseObserver.onCompleted()
    }

    override fun updateBoard(
        request: UpdateBoardRequest,
        responseObserver: StreamObserver<UpdateBoardResponse>,
    ) {
        val response = boardService.updateBoard(request.toDto())
        responseObserver.onNext(response.toProto())
        responseObserver.onCompleted()
    }

    override fun deleteBoard(
        request: DeleteBoardRequest,
        responseObserver: StreamObserver<DeleteBoardResponse>,
    ) {
        val response = boardService.deleteBoard(request.toDto())
        responseObserver.onNext(response.toProto())
        responseObserver.onCompleted()
    }
}
