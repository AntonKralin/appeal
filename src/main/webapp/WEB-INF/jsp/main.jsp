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
		<link rel="stylesheet" href="resources/styles/main.css?1" type="text/css" />
		<link rel="stylesheet" href="resources/styles/jquery-ui.min.css" type="text/css" />
		<link rel="stylesheet" href="resources/styles/jquery-ui.structure.min.css" type="text/css" />
		<link rel="stylesheet" href="resources/styles/jquery-ui.theme.min.css" type="text/css" />
		<link rel="stylesheet" href="resources/styles/selectize.default.css?1" type="text/css" />
		<script type="text/javascript" src="resources/js/functions.js?4"></script>
		<script type="text/javascript" src="resources/js/jquery.js"></script>
		<script type="text/javascript" src="resources/js/sort.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>
		<script type="text/javascript" src="resources/js/selectize.min.js?3"></script>
	
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
						<td width="2%">№ п/п</td>
						<td width="10%">Дата и номер письма МНС</td>
						<td width="13%">Наименование плательщика</td>
						<td width="28%">Суть жалобы</td>
						<td width="10%">Результат рассмотрения жалобы</td>
						<td width="23%">Что сделано</td>
						<td width="5%">Вид документа</td>
						<td width="7%">Управление, самостоятельный отдел</td>
						<td width="5%">ИМНС</td>
						<td width="2%"></td>					
					</tr>
				</thead>
				<tbody>		
						<c:forEach var="appeals" items="${appealsList}">
							<tr>
								<td>${appeals.getId()}</td>
								<td>${appeals.getDateMessage()}</td>
								<td>${appeals.getWho()}</td>
								<td>${appeals.getWhat()}</td>
								<td>${appeals.getResult()}</td>
								<td>${appeals.getDone()}</td>
								<td>${appeals.getType()}</td>
								<td>${appeals.getUnit()}</td>
								<td>${appeals.getImns()}</td>
								<td><input class="button" type="button" onclick="edit_fild(${appeals.getId()})" value="📒" title="изменить доступ"></td>
							</tr>
						</c:forEach>	
				</tbody>
			</table>
		</div>
		
		<div id="bottom">
			<button id="appeal" onclick="appeal_click();">Жалобы</button>
			<button id="reportButton" onclick="report_click();">Отчеты</button>
		</div>
		
<!-- ---------------------------------------------------------------------------------------------------------------------------------------------- -->		

		<div id="appeal_dialog" style="display:none;"  title="Жалоба">
			<form:form method="POST" modelAttribute="appearDataForm" action="/appeal/main">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
				<form:input path="id" style="display:none" />
				<p>
					<label>Выберите ИМНС</label><form:select path="imns" id="imns" multiple="true" items="${imnsList}" itemValue="number" itemLabel="number"></form:select>
				</p>
				<p><form:input path="date" id="date" readonly="true" onclick='choose_date(this);' title='Дата рассмотрения жалобы' placeholder="Дата рассмотрения жалобы" style="width:1000px"/></p>
				<p><form:input path="message" autofocus="true" title='Дата и номер письма, предписания, иного документа' placeholder='Дата и номер письма, предписания, иного документа' style='width:1000px' /></p>
				<p><form:input path="who"  title='Наименование плательщика' placeholder="Наименование плательщика" style="width:1000px"/></p>
				<p><form:input path="what"  title="Суть жалобы / Суть нарушений в письме, предписании, ином документе" placeholder="Суть жалобы / Суть нарушений в письме, предписании, ином документе"  style="width:1000px"/></p>
				<p>
					<form:select path="result">
						<form:options items="${resultList}" />
					</form:select>
				</p>
				<p><form:input path="done"  title="Что сделано / Результат проделанной работы, направленной на устранение нарушений, отраженных в письме, предписании, ином документе" placeholder="Что сделано / Результат проделанной работы, направленной на устранение нарушений, отраженных в письме, предписании, ином документе"  style="width:1000px"/></p>
				<p>
					<form:select path="type">
						<form:options items="${typeList}"/>
					</form:select>
				</p>
				<p>
					<form:select path="unit">
						<form:options items="${departmentList}"/>
					</form:select>
				</p>			
				<p><input type="submit" name="save" value="Сохранить" title="Сохранить пользователя"></p>
			</form:form>
		</div>
		
		<div id="report_dialog" style="display:none;" title="Отчеты">
			<form:form method="GET" modelAttribute="reportDataForm" action="/appeal/report">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<p><form:input path="from" id="from" readonly="true" onclick='choose_date(this);' title='С' placeholder="С" style="width:500px"/></p>
				<p><form:input path="to" id="to" readonly="true" onclick='choose_date(this);' title='По' placeholder="По" style="width:500px"/></p>
				<p>
					<input type="submit" name="button" id="7" value="Отчет по жалобам"/>
					<input type="submit" name="button" id="74" value="Письма"/>
				</p>
				<p>
					<input type="submit" name="button" id="exel7" value="Excel отчет по жалобам"/>
					<input type="submit" name="button" id="exel74" value="Excel Письма"/>
				</p>
			</form:form>
		</div>
		
		<form:form id="hides" method="GET" modelAttribute="appearIdForm" style="display:none" action="/appeal/main">
			<form:input path="id_fild" id="id_fild" name="id_fild" />
			<input type="submit" id="sub_hides" name="sub_hides">
		</form:form>
		
		
	</body>
	<script type="text/javascript">
		$("#imns").selectize();
	
		$( "#appeal_dialog" ).dialog({
			autoOpen: false,
			width: 1100
		})
		
		$( "#report_dialog" ).dialog({
			autoOpen: false,
			width: 600
		})
	
		function choose_date(elem){
			$(elem).datepicker({
				changeYear: true,
				dateFormat: "yy-mm-dd",
				monthNames: ['Январь','Февраль','Март','Апрель','Май','Июнь','Июль','Август','Сентябрь','Октябрь','Ноябрь','Декабрь'],
				dayNamesMin: ['Вс','Пн','Вт','Ср','Чт','Пт','Сб']
			});
			$(elem).datepicker("show");
		}
		
	</script>
	
	<c:if test="${display == true }">
		<script type="text/javascript">
		$( "#appeal_dialog" ).dialog( "open" );
		</script>
	</c:if>
</html>