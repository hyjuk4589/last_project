<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.div1 {
padding-top: 200px;
padding-bottom: 100px;
font: 400 14px 'Poppins',sans-serif;
}
  table {
    width: 60%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
 a { text-decoration:none;  color: #000; !important  } 
a:link { color: #000; text-decoration: none; } <!-- link : 방문전 링크 상태 -->
a:visited {
	color: #000; text-decoration: none; } <!-- visited : 방문후 링크 상태 -->
a:hover { color: #000; text-decoration: none; } <!-- hover : 마우스 오버했을 때 링크 상태 -->
a:active { text-decoration: none; color: #000; } <!-- active : 클릭했을 때 링크 상태 -->
 fieldset {
    border: none;
    vertical-align: top;
}
</style>
</head>
<body>

<jsp:include page="../default/header.jsp"/>
<%-- <%@include file="header.jsp"%> --%>
<br>
<div align="center" class="div1">
	<table border="0">
		<caption><font style="font: 400 30px 'Poppins',sans-serif;">Notice<br></font></caption>
			<tr>
				<th style="width: 10%;">번호</th>
				<th style="width: 50%;">제목</th>
				<th style="width: 10%;">작성자</th>
				<th style="width: 10%;">작성일</th>
				<th style="width: 10%;">조회수</th>
			</tr>

			<tr>
				<td colspan="5" style="text-align: center; height: 200px;"><br>검색
					결과가 없습니다.<br></td>
			</tr>
		</table>


        <p class="category displaynone"></p>
        <p><select id="search_date" name="search_date">
<option value="week">일주일</option>
<option value="month">한달</option>
<option value="month3">세달</option>
<option value="all">전체</option>
</select> <select id="search_key" name="search_key">
<option value="subject">제목</option>
<option value="content">내용</option>
<option value="writer_name">글쓴이</option>
<option value="member_id">아이디</option>
<option value="nick_name">별명</option>
<option value="product">상품정보</option>
</select> <input id="search" name="search" class="inputTypeText" placeholder="" value="" type="text"  /> 
<a href="#none" onclick="BOARD.form_submit('boardSearchForm');">search</a></p>
</div>
<jsp:include page="../default/footer.jsp"/>
<%-- <%@include file="footer.jsp"%> --%>
</body>
</html>>