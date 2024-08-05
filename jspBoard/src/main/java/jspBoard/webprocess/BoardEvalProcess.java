package jspBoard.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspBoard.dao.HikariConnector;
import jspBoard.web.WebProcess;

public class BoardEvalProcess implements WebProcess {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		ServletContext application = request.getServletContext();
		String pick = request.getParameter("pick").equals("g") ? "board_good_count" : "board_bad_count";
		HttpSession session = request.getSession();

		Integer board_id = Integer.parseInt(request.getParameter("board_id"));
		
		// 지금 웹 브라우져로 접속한 클라이언트(사용자)가 추천을 한적이 있으면 추천을 하지 못하도록 해야 한다.
		// (쿠키 또는 세션을 사용) 그냥 session에 true로 저장하게 되면 그 웹브라우저에서 추천한 기록이 남아서
		// 다른사람의 글에 추천/비추천을 하지 못하게 된다. 그래서 List타입을 이용해서 해당 게시글 아이디에 추천/비추천이 존재하는지로 판단
		
		// 리스트에서 현재 추천을 누른 글 번호가 존재하면 더 이상 진행하지 않고 리다이렉트를 한다.
		if (session.getAttribute("picked") != null) {
			List<Integer> pickedList = (List) session.getAttribute("picked");
			
			if (pickedList.contains(board_id)) {
				return "redirect:/board/detail?board_id=" + board_id;				
			}
		}
		
		// 좋아요 싫어요 올리는 것. 스트링포맷으로 pick에 따라 선택해서 올려준다
		// 추천수를 먼저 반영한 후 글 내용을 불러서 포워드 한다 (대신 글 보기 페이지로 리다이렉트)
		String sql1 = String.format("UPDATE board SET %s=%s+1 WHERE board_id = ?", pick, pick);
		// String sql2 = "SELECT * FROM board WHERE board_id = ?";

		
		try (
				Connection conn = ((HikariConnector) application.getAttribute("hikari")).getConnecion();
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
				// PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				
			) {
				pstmt1.setInt(1, board_id);
				pstmt1.executeUpdate();
				
				
//				pstmt2.setInt(1, board_id);
//				
//				try (ResultSet rs = pstmt2.executeQuery();) {
//					rs.next();
//					request.setAttribute("board", new JspBoard(rs));
//				}
				
				// 이 클라이언트가 추천 또는 비추천 했던 글 번호를 모두 목록에 저장
				// 세션을 사용하게 되면 동시접속자가 많을 시에 서버가 느려지는 상황이 발생한다.
				// 만약 쿠키를 사용하게 되면 누군가가 추천/비추천을 삭제할 수 있게 된다.
				// 쿠키/세션을 선택하는 것을 생각해서 선택하도록 한다.
				List<Integer> pickedList = new ArrayList<>();
				pickedList.add(board_id);
				session.setAttribute("picked", pickedList);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return "redirect:/board/detail?board_id=" + board_id;
	}

}
