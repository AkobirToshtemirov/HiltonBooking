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
            <h2>Reservations</h2>

            <div class="reservations_main">
              <div class="reservations_block">

                <div class="reservation_headline">
                  <div class="bar">Client</div>
                  <div class="bar">Check In</div>
                  <div class="bar">Check Out</div>
                  <div class="bar">Room No</div>
                  <div class="bar">No of beds</div>
                  <div class="bar">Room class</div>
                  <div class="bar">Status</div>
                  <div class="bar">
                    <a class="check_btn" href=""></a>
                    <a class="check_btn" href=""></a>
                  </div>
                </div>

                <div class="reservations">
                  <div class="reservation">
                    <div class="bar">Jon Doe</div>
                    <div class="bar">03/12/2023</div>
                    <div class="bar">04/12/2023</div>
                    <div class="bar">
                      <select name="room_number" id="room_number">
                        <option value="12" selected>12</option>
                        <option value="3">3</option>
                        <option value="5">5</option>
                      </select>
                    </div>
                    <div class="bar">5</div>
                    <div class="bar">Deluxe</div>
                    <div class="bar">Waiting</div>
                    <div class="bar">
                      <a class="check_btn approve_btn" href="">Approve</a>
                      <a class="check_btn cancel_btn" href="">Cancel</a>
                    </div>
                  </div>

                  <div class="reservation">
                    <div class="bar">Sue Allen</div>
                    <div class="bar">03/12/2023</div>
                    <div class="bar">04/12/2023</div>
                    <div class="bar">
                      <select name="room_number" id="room_number">
                        <option value="12" selected>12</option>
                        <option value="3">3</option>
                        <option value="5">5</option>
                      </select>
                    </div>
                    <div class="bar">3</div>
                    <div class="bar">Standard</div>
                    <div class="bar">Waiting</div>
                    <div class="bar">
                      <a class="check_btn approve_btn" href="">Approve</a>
                      <a class="check_btn cancel_btn" href="">Cancel</a>
                    </div>
                  </div>

                  <div class="reservation">
                    <div class="bar">Jon Doe</div>
                    <div class="bar">03/12/2023</div>
                    <div class="bar">04/12/2023</div>
                    <div class="bar">
                      <select name="room_number" id="room_number">
                        <option value="12" selected>12</option>
                        <option value="3">3</option>
                        <option value="5">5</option>
                      </select>
                    </div>
                    <div class="bar">5</div>
                    <div class="bar">Deluxe</div>
                    <div class="bar">Waiting</div>
                    <div class="bar">
                      <a class="check_btn approve_btn" href="">Approve</a>
                      <a class="check_btn cancel_btn" href="">Cancel</a>
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