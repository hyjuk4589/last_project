<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
   $("#btnSave").click(function(){
      var title = $("#title").val();
      var content = $("#content").val();
      var writer = $("#writer").val();
      if(title == "") {
         swal("제목을 입력하세요");
         document.form1.title.focus();
         return;
      }
      if(content == "") {
         swal("내용을 입력하세요");
         document.form1.content.focus();
         return;
      }
      if(writer == "") {
         swal("이름을 입력하세요");
         document.form1.writer.focus();
         return;
      }
      document.form1.submit();
   });
});
</script>

<style type="text/css">
.div1 {
padding-top: 200px;
padding-bottom: 100px;
font: 400 14px 'Poppins',sans-serif;
}


 fieldset {
/*     border: none; */
    vertical-align: top;
}
</style>
</head>
<body>
<jsp:include page="../default/header.jsp"/>
<div class="div1">
   <form name="form1" action="save_write" method="post">
   <div>
      제목 : 
      <input name="title" id="title" size="50" placeholder="제목을 입력하세요.">
   </div>
   <div>
      내용 :
      <textarea name="content" id="content" rows="5" cols="100" placeholder="내용을 입력하세요."></textarea>
   </div>
   <div>
      이름 :
      <input name="writer" id="writer" placeholder="이름을 입력하세요." >
   </div>
   <div>
      <button type="button" id="btnSave">확인</button>
      <button type="reset">취소</button>
   </div>
   </form>
</div>
<jsp:include page="../default/footer.jsp"/>
</body>
</html>