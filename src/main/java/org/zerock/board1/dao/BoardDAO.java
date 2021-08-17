package org.zerock.board1.dao;

import lombok.extern.log4j.Log4j2;
import org.zerock.board1.dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public enum BoardDAO {
    INSTANCE;
    private static final String SQL_INSERT = "insert into tbl_board (title, content, assort, writer)\n" +
            "values (?, ?, ?, ?)";
    private static final String SQL_LIST = "select bno, title, content, assort, writer, count, regdate\n" +
            "from tbl_board";
    private static final String SQL_SELECTREAD = "select bno, title, content, assort, writer, count, regdate from tbl_board where bno = ?";
    private static final String SQL_UPDATE = "update tbl_board set title=?, content=?, assort=?, writer =? where bno = ?";
    private static final String SQL_REMOVE = "delete from tbl_board where bno = ?";

    public void insert(BoardDTO boardDTO) throws RuntimeException {

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {
                //title, content, assort
                preparedStatement = connection.prepareStatement(SQL_INSERT);
                preparedStatement.setString(1, boardDTO.getTitle());
                preparedStatement.setString(2, boardDTO.getContent());
                preparedStatement.setString(3, boardDTO.getAssort());
                preparedStatement.setString(4, boardDTO.getWriter());

                preparedStatement.executeUpdate();
                log.info("insert success......");
            }
        }.makeAll();
    }//insert end

    public List<BoardDTO> list() throws RuntimeException {
        List<BoardDTO> targetList = new ArrayList<>();

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {
                preparedStatement = connection.prepareStatement(SQL_LIST);
                resultSet = preparedStatement.executeQuery();

                log.info(resultSet);

                while (resultSet.next()) {

                    targetList.add(BoardDTO.builder()
                                    .bno(resultSet.getLong(1))
                                    .title(resultSet.getString(2))
                                    .content(resultSet.getString(3))
                                    .assort(resultSet.getString(4))
                                    .writer(resultSet.getString(5))
                                    .count(resultSet.getLong(6))
                                    .regdate(resultSet.getTimestamp(7))
                            .build());
                }
            }
        }.makeAll();

        return targetList;
    }//list end

    public BoardDTO selectRead(Long bno) throws RuntimeException {

        BoardDTO boardDTO = BoardDTO.builder()
                .build();

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {

                preparedStatement = connection.prepareStatement(SQL_SELECTREAD);
                preparedStatement.setLong(1, bno);

                resultSet = preparedStatement.executeQuery();
                resultSet.next();

                //bno, title, content, assort, writer,
                //count, regdate
                boardDTO.setBno(resultSet.getLong(1));
                boardDTO.setTitle(resultSet.getString(2));
                boardDTO.setContent(resultSet.getString(3));
                boardDTO.setAssort(resultSet.getString(4));
                boardDTO.setWriter(resultSet.getString(5));
                boardDTO.setCount(resultSet.getLong(6));
                boardDTO.setRegdate(resultSet.getTimestamp(7));


            }
        }.makeAll();
        return boardDTO;
    }//selectRead end

    public BoardDTO selectUpdate(Long bno) throws RuntimeException {

        BoardDTO boardDTO = BoardDTO.builder()
                .build();

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {

                preparedStatement = connection.prepareStatement(SQL_UPDATE);
                preparedStatement.setLong(5, bno);
                preparedStatement.executeUpdate();

                boardDTO.setTitle(resultSet.getString(1));
                boardDTO.setContent(resultSet.getString(2));
                boardDTO.setAssort(resultSet.getString(3));
                boardDTO.setWriter(resultSet.getString(4));

                resultSet = preparedStatement.executeQuery();
                resultSet.next();

            }
        }.makeAll();
        return boardDTO;
    }//selectUpdate end

    public BoardDTO remove(Long mno) throws RuntimeException {

        BoardDTO boardDTO = BoardDTO.builder()
                .build();

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {

                preparedStatement = connection.prepareStatement(SQL_REMOVE);
                preparedStatement.setLong(1, mno);
                preparedStatement.executeQuery();


            }
        }.makeAll();
        return boardDTO;
    }

}//e end
