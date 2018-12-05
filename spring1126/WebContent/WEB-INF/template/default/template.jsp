<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>kosta188</title>
<link rel="stylesheet" href="resources/css/basic.css" type="text/css"  />
<link rel="stylesheet" href="resources/css/style.css" type="text/css" />
<!-- ckeditor.js  -->
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//cdn.ckeditor.com/4.4.7/full/ckeditor.js"></script>
<!-- ckeditor.js  -->
</head>
<body>
	<div id="wrap">
		<tiles:insertAttribute name="header"/>
		 <div id="navigation">
		 	<tiles:insertAttribute name="menu"/>
		 </div>
			<tiles:insertAttribute name="body"/>
		<tiles:insertAttribute name="footer"/>
	</div>
</body>
</html>








