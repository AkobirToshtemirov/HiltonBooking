<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin - dashboard</title>

  <link rel="stylesheet" href="./css/style.css">
</head>

<body>

  <jsp:useBean id="user" scope="session" type="com.epam.hiltonbooking.bean.User"></jsp:useBean>

  <section id="dashboard">

    <div class="dashborad_main">

      <jsp:include page="adminMenu.jsp" />

      <div class="dashboard_workspace_main">
        <div class="dashborad_workspace">

          <jsp:include page="dashboardHeader.jsp" />

          <div class="dashboard_tools">

            <h2>Admin Settings</h2>
            <div class="admin_settings_main">
              <div class="admin_settings_block">
                <form action="profile" method="post">
                  <div class="profile_block">
                    <label for="first_name">
                      <h3>Firstname: </h3>
                      <input class="info_input" type="text" name="firstname" id="first_name"
                        value="<jsp:getProperty property="firstName" name="user" />">
                    </label>
                    <br>
                    <label for="last_name">
                      <h3>Lastname: </h3>
                      <input class="info_input" type="text" name="lastname" id="last_name"
                        value="<jsp:getProperty property="lastName" name="user" />">
                    </label>
                    <br>
                    <label for="email">
                      <h3>Email: </h3>
                      <input class="info_input" type="email" name="email" id="email" value="<jsp:getProperty property="email" name="user" />">
                    </label>
                    <br>
                    <label for="username">
                      <h3>Username: </h3>
                      <input class="info_input" type="text" name="username" id="username"
                        value="<jsp:getProperty property="username" name="user" />"">
                    </label>
                    <br>
                    <label for=" password">
                      <h3>Password: </h3>
                      <input class="info_input" type="password" name="password" id="password"
                        value="<jsp:getProperty property="password" name="user" />">
                    </label>
                    <br>
                    <label for="">
                      <input class="update_btn" type="submit" value="Update" name="submit">
                    </label>
                  </div>
                </form>

                <img src="https://cdn-icons-png.flaticon.com/512/6277/6277478.png" alt="">
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>

  </section>

</body>

</html>