package chap08.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 만든 필터를 web.xml에 등록해주어야 한다.
public class MyFilter1 implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter1이 최초로 실행되었습니다... (초기화)");	
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("서블릿 호출 전에 필터가 작동함");
		
		request.setAttribute("myfilter1", "MyFilter1에 들렸다 왔다는 증거");
		request.setAttribute("animals", "사자/호랑이/토끼뱀/소/말/닭/쥐/하마/코끼리");
		
		System.out.println("필터 처리 끝난 후 다음 필터를 호출해야 함...");
		chain.doFilter(request, response);
		
	}

}
