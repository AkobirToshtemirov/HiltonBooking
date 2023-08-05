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

            <form action="tool" method="get" id="toolForm">
              <input type="hidden" id="actionInput" name="action" value="" />
              <div class="tools">
                <button class="tool_link" data-action="newBookings">New Bookings</button>
                <button class="tool_link" data-action="approvedBookings">Approved Bookings <br /> (Check In)</button>
                <button class="tool_link" data-action="checkedInBookings">Checked In Bookings <br /> (Check
                  Out)</button>
                <button class="tool_link" data-action="newMessages">Unread Messages</button>
                <button class="tool_link" data-action="checkedOutBookings">Checked Out Bookings <br /> (Closed
                  Bookings)</button>
                <button class="tool_link" data-action="cancelledBookings">Cancelled Bookings</button>
              </div>
              <form>
          </div>
        </div>
      </div>

    </div>

  </section>

  <script src="./js/script.js"></script>

</body>

</html>