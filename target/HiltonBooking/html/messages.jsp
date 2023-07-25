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
            <h2>Messages</h2>

            <div class="messages_main">
              <div class="messages_block">
                <div class="messages_headline">
                  <div class="bar">Sent Time</div>
                  <div class="bar">Name</div>
                  <div class="bar">Email</div>
                  <div class="bar">Phone #</div>
                  <div class="bar">Message</div>
                  <div class="bar"></div>
                </div>

                <div class="messages">

                <c:forEach items="${messageList}" var="message">
                    <div class="message">
                        <div class="bar">${message.getSentAt()}</div>
                        <div class="bar">${message.getName()}</div>
                        <div class="bar">${message.getEmail()}</div>
                        <div class="bar">${message.getPhoneNumber()}</div>
                        <div class="bar">${message.getText()}</div>
                        <div class="bar">
                            <a class="check_btn view_btn" href="">View</a>
                        </div>
                    </div>
                </c:forEach>


                  <div class="message">
                  <div class="bar">12/12/2023</div>
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