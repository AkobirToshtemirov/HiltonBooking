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