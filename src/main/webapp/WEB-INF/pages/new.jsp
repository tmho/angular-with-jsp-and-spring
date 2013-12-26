<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html ng-app="smartaApp">
<head>
    <title>Customer Manager</title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/smarta.css"/>" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand">Smarta</a>
    </div>

    <ul class="nav navbar-nav">
        <li class="active">
            <a href="#jobs" data-toggle="tab">Jobs</a>
        </li>
        <li><a href="#companies" data-toggle="tab">Companies</a></li>
    </ul>

    <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Search" ng-model="searchText">
        </div>
    </form>
</nav>

<div ng-view></div>


<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/angular.js" />"></script>
<script src="<c:url value="/resources/js/angular-route.js" />"></script>
<script src="<c:url value="/resources/app/app.js" />"></script>
<script src="<c:url value="/resources/app/controllers/controllers.js" />"></script>
<script src="<c:url value="/resources/app/services/CompanyService.js" />"></script>
<script src="<c:url value="/resources/app/services/JobService.js" />"></script>


</body>
</html>