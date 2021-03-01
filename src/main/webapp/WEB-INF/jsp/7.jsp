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
					<td width="2%">№ п/п</td>
						<td width="10%">Дата рассмотрения</td>
						<td width="5%">Вид документа</td>
						<td width="13%">Наименование плательщика</td>
						<td width="30%">Суть жалобы</td>
						<td width="10%">Результат рассмотрения (удовлетворена или нет)</td>
						<td width="23%">Что сделано (в случае удовлетворения)</td>
						<td width="7%">Управление, самостоятельный отдел, к компетенции которого относится рассматриваемый вопрос</td>
						<td width="5%">ИМНС</td>			
				</tr>
			</thead>
			<tbody>		
					<c:forEach var="appeals" items="${reportsList7}">
						<tr>
							<td>${appeals.getId()}</td>
								<td>${appeals.getDateMessage()}</td>
								<td>${appeals.getType()}</td>
								<td>${appeals.getWho()}</td>
								<td>${appeals.getWhat()}</td>
								<td>${appeals.getResult()}</td>
								<td>${appeals.getDone()}</td>							
								<td>${appeals.getUnit()}</td>
								<td>${appeals.getId_imns().getNumber()}</td>
						</tr>
					</c:forEach>	
			</tbody>
		</table>	
<!-- ---------------------------------------------------------------------------------------------------------------------------------------------- -->		

		
	</body>
</html>