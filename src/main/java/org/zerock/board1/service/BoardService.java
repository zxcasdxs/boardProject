package org.zerock.board1.service;

import lombok.extern.log4j.Log4j2;
import org.zerock.board1.dao.BoardDAO;
import org.zerock.board1.dto.BoardDTO;

import java.util.List;
import java.util.Map;

@Log4j2
public enum BoardService {

    INSTANCE;

    public void register(BoardDTO boardDTO) throws RuntimeException {
        BoardDAO.INSTANCE.insert(boardDTO);
    }//register end

    public List<BoardDTO> listView() throws RuntimeException {

        List<BoardDTO> result = BoardDAO.INSTANCE.list();

        return result;
    }//listView end

    public BoardDTO read(Long bno) throws RuntimeException {

       return BoardDAO.INSTANCE.selectRead(bno);
    }//read end

    public BoardDTO update(Long bno) throws RuntimeException {

       return BoardDAO.INSTANCE.selectUpdate(bno);
    }//update end

    public BoardDTO remove(Long bno) throws RuntimeException {

        return BoardDAO.INSTANCE.remove(bno);
    }
}
