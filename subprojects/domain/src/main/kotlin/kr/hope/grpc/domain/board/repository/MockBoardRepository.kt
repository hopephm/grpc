package kr.hope.grpc.domain.board.repository

import kr.hope.grpc.domain.board.aggregate.Board
import org.springframework.stereotype.Repository

@Repository
class MockBoardRepository : BoardRepository {
    private val mockStore = mutableMapOf<Int, Board>()

    override fun createBoard(board: Board): Board {
        return save(board)
    }

    private fun generateId(): Int {
        return mockStore.keys.maxOrNull()?.plus(1) ?: 1
    }

    private fun save(board: Board): Board {
        val boardId = board.id ?: generateId().also { board.id = it }
        mockStore[boardId] = board
        return board
    }

    override fun getBoard(id: Int): Board {
        return mockStore[id] ?: throw IllegalArgumentException("Board not found $id")
    }

    override fun updateBoard(board: Board): Board {
        return save(board)
    }

    override fun deleteBoard(id: Int): Board {
        return delete(getBoard(id))
    }

    private fun delete(board: Board): Board {
        return mockStore.remove(board.id) ?: throw IllegalArgumentException("Board not found ${board.id}")
    }
}
