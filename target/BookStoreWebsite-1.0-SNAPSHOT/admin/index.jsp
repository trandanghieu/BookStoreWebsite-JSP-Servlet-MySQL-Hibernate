<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Administration</title>
</head>
<body>
    <jsp:directive.include file = "header.jsp" />

    <div align="center">
        <h2>Administrative Dashboard</h2>

    </div>
    <div align="center">
        <hr width="60%"/>
        <h2>Quick Actions</h2>
        <b>
        <a href="create_book"> New Book</a> &nbsp;
        <a href="create_user"> New User</a> &nbsp;
        <a href="create_category"> New Category</a> &nbsp;
        <a href="create_customer"> New Customer</a> &nbsp;
        </b>
    </div>
    <div align="center">
        <hr width="60%"/>
        <h2>Recent Sales</h2>
    </div>
    <div align="center">
        <hr width="60%"/>
        <h2>Recent Review</h2>
    </div>
    <div align="center">
        <hr width="60%"/>
        <h2>Statistics</h2>
    </div>

    <jsp:directive.include file = "footer.jsp" />
</body>
</html>
