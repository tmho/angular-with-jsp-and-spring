<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <title>Smarta App</title>
</head>

<body>

<div class="container" style="padding:50px;">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#home" data-toggle="tab">Company</a></li>
        <li><a href="#profile" data-toggle="tab">Managers</a></li>
    </ul>

    <div class="tab-content">
        <div class="tab-pane active" id="home"><jsp:include page="company.jsp"/></div>
        <div class="tab-pane" id="profile">...</div>
    </div>


    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
    <script src="<c:url value="/resources/js/company.js" />"></script>

    <script>
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: '/company/getAll',
                dataType: 'json',
                contentType: 'application/json',
                success: Company.getAllSuccess,
                error: Company.getAllFailure
            });
        });
    </script>

</div>


</body>
</html>