<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- scope에 페이지가 들어가면 출력이 불가능고 request가 들어가면 출력이 가능하다 -->
<c:set var="animal" value="lion" scope="request" />

<jsp:include page="jsp_header.jsp" />
<jsp:include page="jsp_content.jsp" />
<jsp:include page="jsp_footer.jsp" />