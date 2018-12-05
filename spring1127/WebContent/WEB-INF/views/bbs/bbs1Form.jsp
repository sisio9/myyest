<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>bbs1Form.jsp</title>
<style type="text/css">
	#bbs1 { width: 650px; margin: auto}
	#bbs1 table { width: 100%; border: 1px dotted  #9900ff}
	#bbs1 table .fd {width:100px; background-color: #b9b9ff; 
	font-weight: bold; text-align: center}
	#sub { width: 250px;}
</style>
<script src="//cdn.ckeditor.com/4.4.7/full/ckeditor.js"></script>
<script>
window.onload=function(){
	CKEDITOR.replace('cont', {
		height: '500px' ,
		filebrowserImageUploadUrl: 'imageUpload'
	})
};
</script>
</head>
<body>
<c:choose>
<c:when test="${pageContext.request.userPrincipal.name != null}">
<c:set var="writer" value="${pageContext.request.userPrincipal.name}"></c:set>
</c:when>
</c:choose>
	<div id="bbs1">
		<form method="post" action="bbs1In">
		<input type="hidden" name="reip" value="<%=request.getRemoteAddr() %>">
			<table>
				<thead>
					<tr>
						<th colspan="2">
							Bbs1 입력폼
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
					<td class="fd">제 목</td>
					<td>
						<input name="sub" id="sub">
					</td>
					</tr>
					<tr>
					<td class="fd">작 성 자</td>
					<td>
						<input name="writer" id="writer" value="${writer }">
					</td>
					</tr>
					<tr>
					<td class="fd">비 밀 번 호</td>
					<td>
						<input name="pwd" id="pwd" type="password" maxlength="10">
					</td>
					</tr>
					<tr>
					<td class="fd">내 용</td>
					<td>
						<textarea rows="20" cols="20" name="cont" id="cont"></textarea>
					</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
					<th colspan="2"><input type="submit" value="send">
						&nbsp;
						<input type="button" value="list" 
											onclick="location='bbs1List'">
					</th>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>