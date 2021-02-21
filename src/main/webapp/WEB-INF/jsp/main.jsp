<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>

	<head>
		<title>«Учет компьютерной техники»</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="description" content="Учет компьютерной техники" />
		<meta name="keywords" content="Учет компьютерной техники" />
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
			<form:form method = "POST" modelAttribute="imnsForm" action = "main">
				<form:select path="imns" onchange="this.form.submit();">
					<form:options items = "${imnsList}" />
				</form:select>
			</form:form>
		</div>
		
		<div id="log_out">
			<H9> Учет компьютерной техники</H9>
			<a href="/UchetKT" id="log_out" class="button">Выйти</a>
		</div>
		
		<div id="tabs">
			<div class="tab">
				<form:form method ="POST" action="main"> 
					<input type = "submit" value = "Компьютеры"/>
				</form:form>	
			</div>
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
			<button id="user" onclick="user_click();">Пользователи</button>
		</div>
		
<!-- ---------------------------------------------------------------------------------------------------------------------------------------------- -->		
		<div id="user_dialog" style="display:none;" title="Пользователи">
			<form:form method="POST" modelAttribute="userForm" action="choose_user">
				<form:select path="user_select" onchange="this.form.submit();">
					<form:option value="0">Выберите пользователя</form:option>
					<form:options items="${list_users}"/>
				</form:select>
			</form:form>
			<form:form method="POST" modelAttribute="userDataForm" action="user_save">
				<p><form:input path="fio" pattern='^[А-Яа-яЁё\s]+$' title='Фамилия Имя Отчество' placeholder="Фамилия Имя Отчество" style="width:470px"/></p>
				<p><form:input path="ip"  pattern="\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}" title='IP адрес (xxx.xxx.xxx.xxx)' placeholder="IP адрес (xxx.xxx.xxx.xxx)" style="width:470px"/></p>
				<p><form:input path="ad"  title="Логин AD" placeholder="Логин AD"  size="60px"/></p>
				<p><input type="submit" name="save" value="Сохранить" title="Сохранить пользователя"></p>
			</form:form>
		</div>
	</body>
	<script type="text/javascript">
		$( "#user_dialog" ).dialog({
			autoOpen: false,
			width: 500
		})
	</script>
</html>