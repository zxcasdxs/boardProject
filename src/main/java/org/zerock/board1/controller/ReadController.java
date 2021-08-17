package org.zerock.board1.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.board1.dto.BoardDTO;
import org.zerock.board1.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet (name = "ReadController", value = "/board/read")
public class ReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("Read Controller........");

        Long bno = Long.parseLong(request.getParameter("bno"));

        BoardDTO boardDTO = BoardService.INSTANCE.read(bno);

        request.setAttribute("dto", boardDTO);

        request.getRequestDispatcher("/WEB-INF/board/read.jsp")
                .forward(request, response);

    }
}
