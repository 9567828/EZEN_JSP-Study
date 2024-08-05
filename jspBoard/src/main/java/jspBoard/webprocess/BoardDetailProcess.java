package jspBoard.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspBoard.dao.HikariConnector;
import jspBoard.dto.JspBoard;
import jspBoard.web.CheckParameters;
import jspBoard.web.CookieTools;
import jspBoard.web.WebProcess;

public class BoardDetailProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		ServletContext application = request.getServletContext();
		
		Integer board_id = CheckParameters.parseInt(request, "board_id");
		
		// 글 조회수를 1 올리고, 해당 글의 내용을 조회해서 포워드
		String updateSql = "UPDATE board SET board_view_count = board_view_count+1 WHERE board_id = ?";
		
		String sql = "SELECT * FROM board WHERE board_id = ?";
		
		// 어트리뷰트에 데이터를 실어놓는다
		try (
				Connection conn = ((HikariConnector) application.getAttribute("hikari")).getConnecion();
				PreparedStatement updatePstmt = conn.prepareStatement(updateSql);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
			
				// 쿠키 꺼내기
				Cookie cookie = CookieTools.getCooke(request, "visited");
			
				// 쿠키를 꺼낸 값에 글 id가 포함되어 있다면 조회수가 증가하지 않아야 함
				// update 쿼리문 스킵
				boolean visitedBoard = false;
				
				List<String> ids = null;
				
				if (cookie != null) {
					String value = cookie.getValue();
					
					ids = Arrays.asList(value.split("/"));
					
					for (String id : ids) {
						if (id.equals(board_id + "")) {
							visitedBoard = true;
							break;
						}
					}
				}
				
				// 조회수 1 증가 (쿠키 확인 후 결정)
				if (!visitedBoard) {
					updatePstmt.setInt(1, board_id);
					updatePstmt.executeUpdate();
				}
				
				// 글 조회
				pstmt.setInt(1, board_id);
				
				try(ResultSet rs = pstmt.executeQuery();) {
					rs.next();
					request.setAttribute("board", new JspBoard(rs));
				}
				
				// 쿠키등록 (이 글을 조회한적이 있다는 표시)
				// 이미 쿠키가 있다면 값을 꺼내서 방금 조회수가 올라간 글 번호를 붙여서 쿠키 수정
				
				// 조회수가 올라간적이 있다 (글번호가 이미 올라가 있따 -> 추가안함)
				// 조회수가 방금 올라갔따 (글 번호가 아직 없다 -> 추가해야함)
				// 조회수가 방금 올라갔고 쿠기가 아예없었다 (새로 추가해야함)
				if (ids != null) {
					if (!ids.contains("" + board_id)) {
						String value = cookie.getValue();
						value += board_id + "/";
						
						cookie.setValue(value);						
					}
					
				} else {
					cookie = new Cookie("visited", board_id + "/");
				}
				// if나 else에서 반복되는 행위라 밖으로 둠
				cookie.setPath(request.getContextPath() + "/board/detail");
				cookie.setMaxAge(300); // 5분에 한 번 조회수가 올라가도록
				response.addCookie(cookie); // 응답에 쿠키 싣기
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		return "/board/detail";
	}

}
