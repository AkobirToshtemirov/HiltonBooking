<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Error 404 - Page Not Found</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
    <div class="error_main">
        <h1>Error 404 - Page Not Found</h1>
        <p>The requested page is not available.</p>
       <form action="${pageContext.request.contextPath}/error" method="post">
           <input type="submit" value="Back to home page" />
       </form>
    </div>
</body>

</html>
