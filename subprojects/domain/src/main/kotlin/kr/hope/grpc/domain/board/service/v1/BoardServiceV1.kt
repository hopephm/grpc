package kr.hope.grpc.domain.board.service.v1

import kr.hope.grpc.domain.board.aggregate.Board
import kr.hope.grpc.domain.board.repository.BoardRepository
import kr.hope.grpc.domain.board.service.BoardService
import kr.hope.grpc.domain.board.service.dto.CreateBoardRequest
import kr.hope.grpc.domain.board.service.dto.CreateBoardResponse
import kr.hope.grpc.domain.board.service.dto.DeleteBoardRequest
import kr.hope.grpc.domain.board.service.dto.DeleteBoardResponse
import kr.hope.grpc.domain.board.service.dto.GetBoardRequest
import kr.hope.grpc.domain.board.service.dto.GetBoardResponse
import kr.hope.grpc.domain.board.service.dto.UpdateBoardRequest
import kr.hope.grpc.domain.board.service.dto.UpdateBoardResponse
import org.springframework.stereotype.Service

@Service
class BoardServiceV1(
    private val boardRepository: BoardRepository,
) : BoardService {
    override fun createBoard(request: CreateBoardRequest): CreateBoardResponse {
        val board = boardRepository.createBoard(
            Board(
                title = request.title,
                content = request.content,
                writer = request.writer,
            )
        )
        return CreateBoardResponse(board)
    }

    override fun getBoard(request: GetBoardRequest): GetBoardResponse {
        val board = boardRepository.getBoard(request.boardId)
        return GetBoardResponse(board)
    }

    override fun updateBoard(request: UpdateBoardRequest): UpdateBoardResponse {
        val board = boardRepository.getBoard(request.boardId).let {
            it.title = request.title
            it.content = request.content
            it.writer = request.writer
            boardRepository.updateBoard(it)
        }
        return UpdateBoardResponse(board)
    }

    override fun deleteBoard(request: DeleteBoardRequest): DeleteBoardResponse {
        val board = boardRepository.deleteBoard(request.boardId)
        return DeleteBoardResponse(board.id)
    }
}
