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
@WebServlet(name = "RemoveController", value = "/board/remove")
public class RemoveController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Long bno = Long.parseLong(request.getParameter("bno"));

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(bno)
                .build();

        log.info("bno : " + bno);



        BoardService.INSTANCE.remove(bno);

        request.setAttribute("dto", boardDTO);

        response.sendRedirect("/board/list");






    }


}
