<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<div id="article">
	<div id="header2">
		<h1>E-Mail</h1>

	</div>
	<div id="content">
		<form action="sendMailAttach" method="post" enctype="multipart/form-data">
			<table style="width: 80%">
				<tr>
					<td>Email To :</td>
					<td><input type="email" name="mailTo" required="required"></td>
				</tr>
				<tr>
					<td>Subject :</td>
					<td><input type="text" name="subject"></td>
				</tr>
				<tr>
					<td>Message :</td>
					<td><textarea cols="50" rows="10" name="text"></textarea></td>
				</tr>
				<tr>
					<td>Ã·ºÎ</td>
					<td><input type="file" name="mfile"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Send E-mail"></td>
				</tr>

			</table>
		</form>
	</div>
</div>
<script>
	$(function() {

	});
