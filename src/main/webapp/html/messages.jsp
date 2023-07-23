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
              <li><a href="">Messages</a></li>
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
            <h2>Messages</h2>

            <div class="messages_main">
              <div class="messages_block">
                <div class="messages_headline">
                  <div class="bar">Name</div>
                  <div class="bar">Email</div>
                  <div class="bar">Phone #</div>
                  <div class="bar">Message</div>
                  <div class="bar"></div>
                </div>

                <div class="messages">
                  <div class="message">
                    <div class="bar">Jon Doe</div>
                    <div class="bar">jondoe@gmail.com</div>
                    <div class="bar">99 989 76 54</div>
                    <div class="bar">Message starts here...</div>
                    <div class="bar">
                      <a class="check_btn view_btn" href="">View</a>
                    </div>
                  </div>
                  <div class="message">
                    <div class="bar">Jon Doe</div>
                    <div class="bar">jondoe@gmail.com</div>
                    <div class="bar">99 989 76 54</div>
                    <div class="bar">Message starts here...</div>
                    <div class="bar">
                      <a class="check_btn view_btn" href="">View</a>
                    </div>
                  </div>
                  <div class="message">
                    <div class="bar">Jon Doe</div>
                    <div class="bar">jondoe@gmail.com</div>
                    <div class="bar">99 989 76 54</div>
                    <div class="bar">Message starts here...</div>
                    <div class="bar">
                      <a class="check_btn view_btn" href="">View</a>
                    </div>
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