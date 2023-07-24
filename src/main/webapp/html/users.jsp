<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin - dashboard</title>

  <link rel="stylesheet" href="./css/style.css">
</head>

<body>

  <section id="dashboard">

    <div class="dashborad_main">

      <jsp:include page="adminMenu.jsp" />

      <div class="dashboard_workspace_main">
        <div class="dashborad_workspace">

          <jsp:include page="dashboardHeader.jsp" />

          <div class="dashboard_tools">
            <div class="users_main_headline">
              <h2>Users</h2>
            </div>

            <div class="add_room_main">
              <h3>Register a User</h3>

              <form action="">
                <div class="add_room_form_main">
                  <label for="first_name_user">
                    <p>First Name</p>
                    <input type="text" id="first_name_user" name="first_name_user">
                  </label>
                  <label for="last_name_user">
                    <p>Last Name</p>
                    <input type="text" id="last_name_user" name="last_name_user">
                  </label>
                  <label for="email_user">
                    <p>Email</p>
                    <input type="text" id="email_user" name="email_user">
                  </label>
                  <label for="username_user">
                    <p>Username</p>
                    <input type="text" id="username_user" name="username_user">
                  </label>
                  <label for="password_user">
                    <p>Pasword</p>
                    <input type="password" id="password_user" name="password_user">
                  </label>
                </div>

                <div class="add_room_form_main">

                  <label for="">
                    <input type="submit" id="register_user_btn_admin" name="register_user_btn_admin"
                      class="check_btn register_user_btn" value="Register User">
                  </label>
                </div>
              </form>
            </div>

            <div class="users_main">
              <div class="users_block">
                <div class="users_headline">
                  <div class="bar">First Name</div>
                  <div class="bar">Last Name</div>
                  <div class="bar">Username</div>
                  <div class="bar">Email</div>
                  <div class="bar">Password</div>
                  <div class="bar">Date of registration</div>
                  <div class="bar"></div>
                </div>

                <div class="users">
                  <div class="bar">Jon</div>
                  <div class="bar">Doe</div>
                  <div class="bar">jondoe11</div>
                  <div class="bar">jondoe@gmail.com</div>
                  <div class="bar">20031221</div>
                  <div class="bar">04/12/2023</div>
                  <div class="bar delete_btn_bar">
                    <a class="check_btn delete_btn" href="">Delete</a>
                  </div>
                </div>

                <div class="users">
                  <div class="bar">Sue</div>
                  <div class="bar">Allen</div>
                  <div class="bar">sueallen</div>
                  <div class="bar">sueallen@gmail.com</div>
                  <div class="bar">2321312</div>
                  <div class="bar">03/07/2023</div>
                  <div class="bar delete_btn_bar">
                    <a class="check_btn delete_btn" href="">Delete</a>
                  </div>
                </div>

              </div>
            </div>
          </div>
        </div>
      </div>

    </div>

  </section>

</body>

</html>