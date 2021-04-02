<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<head>
	<title>«Жалобы» | Авторизация</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="description" content="Жалобы" />
	<meta name="keywords" content="Жалобы" />
	<link href="resources/images/favicon.ico" rel="shortcut icon" type="image/x-icon" />
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
		<div class ="body_div">
			<div id="work_index" >
			<!-- <hr> -->
			<br>
			<p><h3 style="text-align:center; background:#66cc99; font-size:18pt; padding:1em;">«Жалобы»</h3>
			<form:form  id="pass" method = "POST" modelAttribute="passwordForm" action = "#">
				<p><h2>Авторизуйтесь:</h2>
				Логин:
				<br>
				<form:input style="width:100%" path = "username"/>
				<br>
				Пароль:
				<br>
				<td><form:password style="width:100%" path = "password" /></td>
				<p></p>
				<input class="button" style="width:147px" type="submit" name="submit" value="Войти" title="Войти">
				<input class="button" style="width:147px" type="reset" value="Очистить">
				<br>
				<td>${loginfo}</td>
				<br>
			</form:form>
			</div>
		</div>
	
	</body>
	
</html>