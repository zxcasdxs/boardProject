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
@WebServlet (name = "UpdateController", value = "/board/update")
public class UpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/board/fix.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        //title, content, assort, writer
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String assort = request.getParameter("assort");
        String writer = request.getParameter("writer");

        BoardDTO boardDTO = BoardDTO.builder()
                .title(title)
                .content(content)
                .assort(assort)
                .writer(writer)
                .build();

        BoardService.INSTANCE.update(boardDTO.getBno());

        response.sendRedirect("/board/read?bno=");
    }
}
