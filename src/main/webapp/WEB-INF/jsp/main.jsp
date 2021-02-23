<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>

	<head>
		<title>«Жалобы»</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="description" content="Жалобы" />
		<meta name="keywords" content="Жалобы" />
		<link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon" />
		<link rel="stylesheet" href="resources/styles/main.css" type="text/css" />
		<link rel="stylesheet" href="resources/styles/jquery-ui.min.css" type="text/css" />
		<link rel="stylesheet" href="resources/styles/jquery-ui.structure.min.css" type="text/css" />
		<link rel="stylesheet" href="resources/styles/jquery-ui.theme.min.css" type="text/css" />
		<script type="text/javascript" src="resources/js/functions.js"></script>
		<script type="text/javascript" src="resources/js/jquery.js"></script>
		<script type="text/javascript" src="resources/js/jquery1.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>
	
	</head>

	<body>
		<div id="imns_label">
			${imnsname}
		</div>

		<div id="log_out">
			<a href="/appeal" id="log_out" class="button">Выйти</a>
		</div>
		
		<div id="work">
			<table border="1" width="100%" cellpading="1" class="sortable">
				<thead>
					<tr>
						<c:forEach var="head" items="${heads}">
							<td>${head}</td>
						</c:forEach>
					</tr>
				</thead>
			</table>
		</div>
		
		<div id="bottom">
			<button id="appeal" onclick="appeal_click();">Жалобы</button>
		</div>
		
<!-- ---------------------------------------------------------------------------------------------------------------------------------------------- -->		
		<div id="appeal_dialog" style="display:none;" title="Жалоба">
			<form:form method="POST" modelAttribute="appearDataForm" action="/appeal/main">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
				<p><form:input path="date" title='Дата рассмотрения жалобы / Дата и номер письма МНС' placeholder="Дата рассмотрения жалобы / Дата и номер письма МНС" style="width:1000px"/></p>
				<p><form:input path="who"  title='Наименование плательщика' placeholder="Наименование плательщика" style="width:1000px"/></p>
				<p><form:input path="what"  title="Суть жалобы / Суть нарушений в письме МНС" placeholder="Суть жалобы / Суть нарушений в письме МНС"  style="width:1000px"/></p>
				<p><form:input path="result"  title="Результат рассмотрения жалобы (Удовлетворена или нет)" placeholder="Результат рассмотрения жалобы"  style="width:1000px"/></p>
				<p><form:input path="done"  title="Что сделано / Результат проделанной работы, направленной на устранение нарушений, отраженных в письме МНС" placeholder="Что сделано / Результат проделанной работы, направленной на устранение нарушений, отраженных в письме МНС"  style="width:1000px"/></p>
				<p><form:input path="type"  title="Вид документа" placeholder="Вид документа"  style="width:1000px"/></p>
				<p><form:input path="unit"  title="Управление, самостоятельный отдел, к компетенции которого относится рассматриваемый вопрос" placeholder="Управление, самостоятельный отдел"  style="width:1000px"/></p>
				<p><input type="submit" name="save" value="Сохранить" title="Сохранить пользователя"></p>
			</form:form>
		</div>
	</body>
	<script type="text/javascript">
		$( "#appeal_dialog" ).dialog({
			autoOpen: false,
			width: 1100
		})
	</script>
</html>