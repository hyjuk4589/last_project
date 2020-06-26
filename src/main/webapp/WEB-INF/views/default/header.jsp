<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

div#fixed { 
position: fixed;
top: 0;
left: 0;
right: 0;

height: 75px;
padding: 1rem;
color: black;
font-weight: bold;
display: flex;
justify-content: space-between;
align-items: center;

 }
h1 {
	margin: 0;
    display: block;
    font-size: 2em;
    margin-block-start: 0.67em;
    margin-block-end: 0.67em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
}
nav { color: gray; }
 }
a { text-decoration:none;  color: #000; !important  } 
a:link { color: #000; text-decoration: none; } <!-- link : 방문전 링크 상태 -->
a:visited {
	color: #000; text-decoration: none; } <!-- visited : 방문후 링크 상태 -->
a:hover { color: #000; text-decoration: none; } <!-- hover : 마우스 오버했을 때 링크 상태 -->
a:active { text-decoration: none; color: #000; } <!-- active : 클릭했을 때 링크 상태 -->

main { padding: 1rem; }

body { 
background: #EEE; }

body, html {
	
 }
 
.dropdown { position: relative; display: inline-block;}
.dropdown-content {   display: none; position: absolute; background-color:#f1f1f1;
			 min-width: 80px; min-height: 150px; text-align:center; right: 0px; 
			 box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);font-weight:normal;font-size:18px;font-family:윤고딕;
 z-index:1; }
.dropdown-content a:hover { background-color: #ddd; }
.dropdown:hover .dropdown-content { display: block; }
.dropdown:hover .dropbtn {  }

.dropdown1 { position: relative; display: inline-block;}
.dropdown-content1 {   display: none; position: absolute; background-color:#f1f1f1;
			 min-width: 100px; min-height: 150px; text-align:center; right: 0px;
			 box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);font-weight:normal;font-size:18px;font-family:윤고딕;
 z-index:1; }
.dropdown-content1 a:hover { background-color: #ddd; }
.dropdown1:hover .dropdown-content1 { display: block; }
.dropdown1:hover .dropbtn1 {   }

.dropdown0 { position: relative; display: inline-block;}
.dropdown-content0 {   display: none; position: absolute; background-color:#f1f1f1;
			 min-width: 80px; min-height: 120px; text-align:center; right: 0px;
			 box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);font-weight:normal;font-size:18px;font-family:윤고딕;
 z-index:1; }
.dropdown-content0 a:hover { background-color: #ddd; }
.dropdown0:hover .dropdown-content0 { display: block; }
.dropdown0:hover .dropbtn1 {   }

</style>
</head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
<!-- height: 200%;  -->
<div id="fixed">
	<div><h1><a href="/Tiffany/default/index" style="color: black;">Brand</a></h1></div>
		<div>
		<nav>
			<div class="dropdown">
			<span class="dropbtn"><a href="#" style="color: black;">SHOP</a></span>&nbsp;&nbsp;
				<div class="dropdown-content">
				<a href="#" style="color: black;">ALL</a><br>
				<a href="#" style="color: black;">RING</a>
				<a href="#" style="color: black;">EARRING</a>
				<a href="#" style="color: black;">NECKLACE</a>
				<a href="#" style="color: black;">BRACELET</a>
				<a href="#" style="color: black;">CLOTHES</a>
				<a href="#" style="color: black;">PANTS</a>
				<a href="#" style="color: black;">BAGS</a>
				</div></div>
			
			<span><a href="#" style="color: black;">COLLECTION</a></span>&nbsp;&nbsp;
			<span><a href="#" style="color: black;">PROGECT</a></span>&nbsp;&nbsp;
			<span><a href="#" style="color: black;">STOCKIST</a></span>&nbsp;&nbsp;
			
			<div class="dropdown0">
			<span class="dropbtn0" ><a href="#" style="color: black;">COMMUNITY</a></span>&nbsp;&nbsp;
				<div class="dropdown-content0">
				<a href="notice" style="color: black;">NOTICE</a><br>
				<a href="list"style="color: black;">Q / A</a><br>
				<a href="review" style="color: black;">REVIEW</a>
				</div></div>
				
			<div class="dropdown1" >
			<span class="dropbtn1" ><a href="#" style="color: black;">ACCOUNT</a></span>
				<div class="dropdown-content1">
				
				<c:choose>
				<c:when test="${sessionScope.id eq null}">
				
				<script type="text/javascript">
    
        var openWin;
    
        function openChild() {
            window.name = "parentForm";
            var popupX = (window.screen.width / 2) - (900 / 2);
         	var popupY= (window.screen.height /2) - (600 / 2);
         
            openWin = window.open("../login&join/login.jsp",
                    "logindForm", 'status=no, height=600, width=900, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY + ", resizable = no, scrollbars = no");    
        }
        function openChild2()
        {
            window.name = "parentForm";
            var popupX = (window.screen.width / 2) - (900 / 2);
            var popupY= (window.screen.height /2) - (600 / 2);
            openWin = window.open("../login&join/join.jsp",
                    "joinForm", 'status=no, height=600, width=900, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY + ", resizable = no, scrollbars = no");     
        }
   </script>

				<span><a href="#" style="color: black;" onclick="openChild()">LOGIN</a></span><br>
				</c:when>
				<c:otherwise>
				<span><a href="../login&join/logout" style="color: black;">LOGOUT</a></span>
				</c:otherwise>
				</c:choose>
				
				
				<a href="#" style="color: black;" onclick="openChild2()">JOIN US</a>
				
				
				<c:choose>
				<c:when test="${sessionScope.id eq null}">
					<script type="text/javascript">
						function loginafter(){
							alert("로그인 후 이용바랍니다!")
						}
						
					</script>
					<a href="#" style="color: black;" onclick="loginafter()">CART</a>
					<a href="#" style="color: black;" onclick="loginafter()">MYSHOP</a>
					<a href="#" style="color: black;" onclick="loginafter()">WISH LIST</a>
					<a href="#" style="color: black;" onclick="loginafter()">ORDER LIST</a>
				</c:when>
				<c:otherwise>
				<a href="../SHOP/cart.jsp" style="color: black;">CART</a>
				<a href="#" style="color: black;">MYSHOP</a>
				<a href="#" style="color: black;">WISH LIST</a>
				<a href="#" style="color: black;">ORDER LIST</a>
				</c:otherwise>
				</c:choose>
				</div></div>
		</nav>
</div>
</div>
	

</body>
</html>