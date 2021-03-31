<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>

	<head>
		<title>«Жалобы»</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="description" content="Жалобы" />
		<meta name="keywords" content="Жалобы" />
		<link href="resources/images/favicon.ico" rel="shortcut icon" type="image/x-icon" />
		<link rel="stylesheet" href="resources/styles/main.css" type="text/css" />
		<link rel="stylesheet" href="resources/styles/jquery-ui.min.css" type="text/css" />
		<link rel="stylesheet" href="resources/styles/jquery-ui.structure.min.css" type="text/css" />
		<link rel="stylesheet" href="resources/styles/jquery-ui.theme.min.css" type="text/css" />
		<script type="text/javascript" src="resources/js/functions.js?1"></script>
		<script type="text/javascript" src="resources/js/jquery.js"></script>
		<script type="text/javascript" src="resources/js/jquery1.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>
	
	</head>

	<body>
	
		<table border="1" width="100%" cellpading="1" style="background-color: white;" class="sortable">
			<thead>
				<tr>
					<td width="5%">Дата и номер письма МНС</td>
					<td width="30%">Суть нарушений</td>
					<td width="10%">ИМНС, в которых установлены нарушения</td>
					<td width="35%">Результат проделанной работы, направленной на устранение нарушений</td>
					<td width="10%">Вид документа</td>
					<td width="10%">Управление, самостоятельный отдел, к компетенции которого относится рассматриваемый вопрос</td>				
				</tr>
			</thead>
			<tbody>		
					<c:forEach var="appeals" items="${reportsList74}">
						<tr>
							<td>${appeals.getDateMessage()}</td>
							<td>${appeals.getWhat()}</td>
							<td>${appeals.getImns()}</td>
							<td>${appeals.getDone()}</td>
							<td>${appeals.getType()}</td>
							<td>${appeals.getUnit()}</td>
						</tr>
					</c:forEach>	
			</tbody>
		</table>	
<!-- ---------------------------------------------------------------------------------------------------------------------------------------------- -->		

		
	</body>
</html>