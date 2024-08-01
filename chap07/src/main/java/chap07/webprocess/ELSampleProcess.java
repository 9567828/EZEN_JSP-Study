package chap07.webprocess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap07.dto.Student;
import chap07.web.WebProcess;

public class ELSampleProcess implements WebProcess {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("book", "해리포터와 마법사의 돌");
		request.setAttribute("student", new Student("김민수", "화곡초등학교", 100, 80, 89));
		request.setAttribute("appleCount", 123);
		request.setAttribute("basketSize", 10);
		return "/jstl/el";
	}

}
