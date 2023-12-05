<%--<jsp:include page="/includes/header.jsp" />--%>
<%--<jsp:include page="/includes/column_left_all.jsp" />--%>


<%--<section>--%>

<%--    <h1>Login Form</h1>--%>
<%--    <p>Please enter a username and password to continue.</p>--%>
<%--    <form action="j_security_check" method="post">--%>
<%--        <label>Username</label>--%>
<%--        <input type="text" name="j_username"><br>--%>
<%--        <label>Password</label>--%>
<%--        <input type="password" name="j_password"><br>--%>
<%--        <label>&nbsp;</label>--%>
<%--        <input type="submit" value="Login">--%>
<%--    </form>--%>

<%--</section>--%>

<%--<!-- end the middle column -->--%>

<%--&lt;%&ndash;<jsp:include page="/includes/column_right_news.jsp" />&ndash;%&gt;--%>
<%--<jsp:include page="/includes/footer.jsp" />--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        body {
            background-image: url(/assets/img/hero-bg-2.jpg); /* Replace with the actual path to your image */
            background-size: cover;
            background-repeat: no-repeat;
            font-family: "Open Sans", sans-serif;
            font-weight: 400;
            font-size: 1rem;
            letter-spacing: 0.1px;
            line-height: 1.8;
            color: #051922;
            overflow-x: hidden;
        }

        /* Add other styles as needed */
        section {
            /* Your existing section styles */
            width: 520px;
            padding-right: 20px;
            padding-left: 20px;
            float: left;
            margin-top: 50px; /* Adjust as needed */
        }

        h1 {
            /* Your existing h1 styles */
            font-size: 3rem; /* Adjust as needed */
            color: black; /* Adjust text color */
        }

        p {
            /* Your existing p styles */
            color: black; /* Adjust text color */
        }

        form {
            /* Your existing form styles */
            /* Add background color or other styles as needed */
        }

        label {
            /* Your existing label styles */
            color: black; /* Adjust text color */
        }

        input {
            /* Your existing input styles */
            /* Add background color or other styles as needed */
        }
    </style>
</head>
<body>

<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_all.jsp" />

<section>

    <h1>Login Form</h1>
    <p>Please enter a username and password to continue.</p>
    <form action="j_security_check" method="post">
        <label>Username</label>
        <input type="text" name="j_username"><br>
        <label>Password</label>
        <input type="password" name="j_password"><br>
        <label>&nbsp;</label>
        <input type="submit" value="Login">
    </form>

</section>

<!-- end the middle column -->

<%--<jsp:include page="/includes/column_right_news.jsp" />--%>
<jsp:include page="/includes/footer.jsp" />

</body>
</html>
