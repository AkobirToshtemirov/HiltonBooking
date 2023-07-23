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

      <div class="dashborad_menu_main">
        <div class="dashborad_menu">
          <div class="admin_menu_bar">
            <div class="admin_menu_profile">
              <img src="./images/admin.png" alt="asdmin_img">
              <h2>Admin</h2>
            </div>

            <ul>
              <li><a href="">Dashboard</a></li>
              <li><a href="./reservations.html">Reservations</a></li>
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
            <h2>Dashboard</h2>

            <div class="tools">
              <a class="tool_link" href="">Bookings</a>
              <a class="tool_link" href="">Messages</a>
              <a class="tool_link" href="">Approved Bookings</a>
              <a class="tool_link" href="">Cancelled Bookings</a>
              <a class="tool_link" href="">Rooms</a>
              <a class="tool_link" href="">Users</a>
            </div>
          </div>
        </div>
      </div>

    </div>

  </section>

</body>

</html>











<!--

Hotel Booking. The Client fills in the Application, indicating the number of beds in the room, the class of apartments and the time of stay. The administrator manages the Clients and the Numbers, reviews the received Applications, selects the most suitable of the available Numbers, issues an Invoice to the Client.

-->