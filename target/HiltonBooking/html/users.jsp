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
            <div class="users_main_headline">
              <h2>Users</h2>
            </div>

            <div class="add_room_main">
              <h3>Register a User</h3>

              <form action="users" method="post">
                <div class="add_room_form_main">
                  <label for="first_name_user">
                    <p>First Name</p>
                    <input type="text" id="first_name_user" name="firstname-user" required>
                  </label>
                  <label for="last_name_user">
                    <p>Last Name</p>
                    <input type="text" id="last_name_user" name="lastname-user" required>
                  </label>
                  <label for="email_user">
                    <p>Email</p>
                    <input type="email" id="email_user" name="email-user" required>
                  </label>
                  <label for="username_user">
                    <p>Username</p>
                    <input type="text" id="username_user" name="username-user" required>
                  </label>
                  <label for="password_user">
                    <p>Pasword</p>
                    <input type="password" id="password_user" name="password-user" required>
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

                   <c:forEach items="${userList}" var="user">

                          <div class="users">
                                  <div class="bar">${user.getFirstName()}</div>
                                  <div class="bar">${user.getLastName()}</div>
                                  <div class="bar">${user.getUsername()}</div>
                                  <div class="bar">${user.getEmail()}</div>
                                  <div class="bar">${user.getPassword()}</div>
                                  <div class="bar">${user.getJoinedTime()}</div>
                                  <div class="bar delete_btn_bar">
                                    <a class="check_btn delete_btn" href="">Delete</a>
                                  </div>
                          </div>
                   </c:forEach>

              </div>
            </div>
          </div>
        </div>
      </div>

    </div>

  </section>

</body>

</html>