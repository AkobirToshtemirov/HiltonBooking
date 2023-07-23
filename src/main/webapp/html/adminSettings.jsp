<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin - dashboard</title>

  <link rel="stylesheet" href="../css/style.css">
</head>

<body>

  <section id="dashboard">

    <div class="dashborad_main">

      <div class="dashborad_menu_main">
        <div class="dashborad_menu">
          <div class="admin_menu_bar">
            <div class="admin_menu_profile">
              <img src="../images/admin.png" alt="asdmin_img">
              <h2>Admin</h2>
            </div>

            <ul>
              <li><a href="./dashboard.html">Dashboard</a></li>
              <li><a href="">Reservations</a></li>
              <li><a href="./messages.html">Messages</a></li>
              <li><a href="">Rooms</a></li>
              <li><a href="">Users</a></li>
              <li><a href="">Sign out</a></li>
            </ul>
          </div>

          <p><span>HiltonTashkent</span> &copy; 2023. Admin Page</p>
        </div>
      </div>

      <div class="dashboard_workspace_main">
        <div class="dashborad_workspace">
          <div class="dashboard_header">
            <div class="logo">
              <h1>HiltonTashkent</h1>
            </div>

            <div class="setting_manager_block">
              <a class="settings_btn" href="">Admin Settings</a>
              <select name="locale" form="language_change" id="lan">
                <option value="en" selected>EN</option>
                <option value="uz">UZ</option>
                <option value="ru">RU</option>
              </select>
            </div>
          </div>

          <div class="dashboard_tools">

            <h2>Admin Settings</h2>
            <div class="admin_settings_main">
              <div class="admin_settings_block">
                <form action="req">
                  <div class="profile_block">
                    <label for="first_name">
                      <h3>Firstname: </h3>
                      <input class="info_input" type="text" name="firstname" id="first_name" value="Jon">
                    </label>
                    <br>
                    <label for="last_name">
                      <h3>Lastname: </h3>
                      <input class="info_input" type="text" name="lastname" id="last_name" value="Doe">
                    </label>
                    <br>
                    <label for="email">
                      <h3>Email: </h3>
                      <input class="info_input" type="email" name="email" id="email" value="adminHotel@gmail.com">
                    </label>
                    <br>
                    <label for="username">
                      <h3>Username: </h3>
                      <input class="info_input" type="text" name="username" id="username" value="admin"">
                    </label>
                    <br>
                    <label for=" password">
                      <h3>Password: </h3>
                      <input class="info_input" type="password" name="password" id="password" value="admin">
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