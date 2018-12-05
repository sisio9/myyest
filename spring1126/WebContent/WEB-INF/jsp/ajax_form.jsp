<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<div id="article">
	<div id="header2">
		<h1>�н���ǥ : RestAPI�� Ajax ����ϱ�</h1>
		<p id="time">2018-11-23</p>
	</div>
	<div id="content">
		<p>����� ���� ������</p>
		<div>
			<fieldset>
				<legend></legend>
				<table>
					<thead>
						<tr>
							<td>��ȣ</td>
							<td>���̵�</td>
							<td>�̸�</td>
							<td>��°�</td>
							<td>���Գ�¥</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="5"></td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="5"><input type="button" id="btn1" value="�����ͷε�">
							</td>
						</tr>
					</tfoot>
				</table>
			</fieldset>
		</div>
	</div>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function() {
		$("#btn1").click(function() {
			$.ajax({
				url : "./members/respList",
				dataType : 'json',
				cache : false,
				success : function(data) {
					//console.log(data);
					let tag;
					$.each(data, function(idx, key) {
						//console.log(idx+":"+key.id);
						tag += "<tr>";
						tag += "<td>" + key.num + "</td>";
						tag += "<td>" + key.id + "</td>";
						tag += "<td>" + key.name + "</td>";
						tag += "<td>" + key.address + "</td>";
						tag += "<td>" + key.createDate + "</td>";
						tag += "</tr>";
					});
					$("tbody").html(tag);
				}
			});
		});
	});
</script>
