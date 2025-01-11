package kr.hope.grpc.domain.board.service

import kr.hope.grpc.domain.board.service.dto.CreateBoardRequest
import kr.hope.grpc.domain.board.service.dto.CreateBoardResponse
import kr.hope.grpc.domain.board.service.dto.DeleteBoardRequest
import kr.hope.grpc.domain.board.service.dto.DeleteBoardResponse
import kr.hope.grpc.domain.board.service.dto.GetBoardRequest
import kr.hope.grpc.domain.board.service.dto.GetBoardResponse
import kr.hope.grpc.domain.board.service.dto.UpdateBoardRequest
import kr.hope.grpc.domain.board.service.dto.UpdateBoardResponse

interface BoardService {
    fun createBoard(request: CreateBoardRequest): CreateBoardResponse
    fun getBoard(request: GetBoardRequest): GetBoardResponse
    fun updateBoard(request: UpdateBoardRequest): UpdateBoardResponse
    fun deleteBoard(request: DeleteBoardRequest): DeleteBoardResponse
}
