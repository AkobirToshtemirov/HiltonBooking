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
            <h2>Dashboard</h2>

            <div class="tools">
              <a class="tool_link" href="reservations">Bookings</a>
              <a class="tool_link" href="messages">Messages</a>
              <a class="tool_link" href="">Approved Bookings</a>
              <a class="tool_link" href="">Cancelled Bookings</a>
              <a class="tool_link" href="rooms">Rooms</a>
              <a class="tool_link" href="users">Users</a>
            </div>
          </div>
        </div>
      </div>

    </div>

  </section>

</body>

</html>