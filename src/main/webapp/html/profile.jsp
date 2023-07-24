<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>HotelBooking - Content</title>

  <!-- general css -->
  <link rel="stylesheet" href="./css/general.css">

  <link rel="stylesheet" href="./css/style.css">

  <!-- header css -->
  <link rel="stylesheet" href="./css/header.css">

  <!-- footer css -->
  <link rel="stylesheet" href="./css/footer.css">
</head>

<body>

  <jsp:include page="header.jsp" />

  <jsp:useBean id="user" scope="session" type="com.epam.hiltonbooking.bean.User"></jsp:useBean>

  <section id="home">
    <div class="container">
      <div class="profile_main">
        <form action="profile" method="post">
          <h1>Profile Infromation</h1>
          <div class="profile_block">
            <label for="first_name">
              <h3>Firstname: </h3>
              <input class="info_input" type="text" name="firstname" id="first_name" value="<jsp:getProperty property="firstName" name="user" />">
            </label>
            <br>
            <label for="last_name">
              <h3>Lastname: </h3>
              <input class="info_input" type="text" name="lastname" id="last_name" value="<jsp:getProperty property="lastName" name="user" />">
            </label>
            <br>
            <label for="email">
              <h3>Email: </h3>
              <input class="info_input" type="email" name="email" id="email" value="<jsp:getProperty property="email"
                name="user" />">
            </label>
            <br>
            <label for="username">
              <h3>Username: </h3>
              <input class="info_input" type="text" name="username" id="username" value="<jsp:getProperty property="username" name="user" />"">
            </label>
            <br>
            <label for=" password">
              <h3>Password: </h3>
              <input class="info_input" type="password" name="password" id="password" value="<jsp:getProperty property="password" name="user" />">
            </label>
            <br>
            <label for="">
              <input class="update_btn" type="submit" value="Update" name="submit">
            </label>
          </div>
        </form>
      </div>
    </div>
  </section>


  <jsp:include page="footer.jsp" />

</body>

</html>