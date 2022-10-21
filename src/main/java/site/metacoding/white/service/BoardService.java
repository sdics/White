
package site.metacoding.white.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.white.domain.Board;
import site.metacoding.white.domain.BoardRepository;

@RequiredArgsConstructor
@Service // @서비스, @ 컨트롤러, @컨퍼넌트, @ 컨피그래이션, 붙으면 IOC 에 데이터 뜸 + 1개
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void save(Board board) {
        boardRepository.save(board);
    }

    public Board findByid(Long id) {
        return boardRepository.findById(id);
    }

    @Transactional
    public void update(Long id, Board board) {
        Board boardPS = boardRepository.findById(id);
        boardPS.setTitle(board.getTitle());
        boardPS.setContent(board.getContent());
        boardPS.setAuthoir(board.getAuthoir());
    } // 트랜잭션 종료시 -> 더티체킹을 함

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }
}
