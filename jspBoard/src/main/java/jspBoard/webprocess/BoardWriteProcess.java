package jspBoard.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspBoard.dao.HikariConnector;
import jspBoard.dto.JspBoard;
import jspBoard.web.WebProcess;

public class BoardWriteProcess implements WebProcess {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// 받은 파라미터로 DB에 글 추가하기
		// 글 추가하고 나면 board로 리다이렉트한다
		// https는 보안이 되어서 비밀번호 유출이 불가능 하지만 http는 중간에서 가로채 갈 수 있다
		ServletContext application = request.getServletContext();
		
		JspBoard to_write = new JspBoard().setWrite(request);
		
		System.out.println("글을씁니다");
		
		String sql = "INSERT INTO board("
				+ "board_id, board_title, board_writer, board_password, board_writer_ip_addr, board_content) "
				+ "VALUES(board_seq.nextval, ?, ?, ?, ?, ?)";
		
		// 서버 초기화시 만들어놓은 연결을 꺼낸다(히카리시피로 만든 리스너)
		try (
			Connection conn = ((HikariConnector) application.getAttribute("hikari")).getConnecion();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, to_write.getBoard_title());
			pstmt.setString(2, to_write.getBoard_writer());
			pstmt.setString(3, to_write.getBoard_password());
			pstmt.setString(4, to_write.getBoard_writer_ip_addr());
			pstmt.setString(5, to_write.getBoard_content());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/board/";
	}
}
