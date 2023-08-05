<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                <h2>Message Information</h2>

                <div class="reservations_main">
                  <div class="reservations_block">

                    <div class="booking_information_main">
                      <div class="booking_info_header">
                        <div class="bar">Messanger Name:</div>
                        <div class="message_bar_info">${message.name}</div>
                        <div class="bar">Messanger Email: </div>
                        <div class="message_bar_info">${message.email}</div>
                        <div class="bar">Messanger Phone Number: </div>
                        <div class="message_bar_info">${message.phoneNumber}</div>
                        <div class="bar">Sent at: </div>
                        <div class="message_bar_info">${message.sentAt}</div>
                        <div class="bar">Message:</div>
                        <div class="message_bar_info text_message">${message.text}</div>

                        <a class="back_btn" href="messages">Back to Messages</a>
                        <a class="back_btn" href="dashboard">Back to Dashboard</a>
                      </div>

                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>

      </section>

      <script src="./js/script.js"></script>

    </body>

    </html>