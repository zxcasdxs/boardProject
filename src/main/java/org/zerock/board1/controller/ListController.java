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
import java.util.List;

@Log4j2
@WebServlet (name = "ListController", value = "/board/list")
public class ListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       List<BoardDTO> result = BoardService.INSTANCE.listView();

        request.setAttribute("All", result);

        request.getRequestDispatcher("/WEB-INF/board/list.jsp")
                .forward(request, response);


    }

}//c end
