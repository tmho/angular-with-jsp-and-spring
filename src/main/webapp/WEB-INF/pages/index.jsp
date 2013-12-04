<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html lang="en" ng-app="smartaApp">
<head>
    <meta charset="utf-8">
    <title>Smarta App</title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/smarta.css"/>" rel="stylesheet">
</head>
<body>

<div class="container">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#companies-tab" data-toggle="tab">Company</a></li>
        <li><a href="#managers-tab" data-toggle="tab">Managers</a></li>
    </ul>

    <div class="tab-content">

        <div class="tab-pane active" id="companies-tab" ng-controller="companiesListController">
            <jsp:include page="company.jsp"/>
        </div>

        <div class="tab-pane" id="managers-tab">
            ...
        </div>
    </div>
    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
    <script src="<c:url value="/resources/js/angular.js" />"></script>
    <script src="<c:url value="/resources/js/controllers.js" />"></script>
</div>


</body>
</html>