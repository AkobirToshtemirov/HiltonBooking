<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>HotelBooking - Content</title>

      <link rel="stylesheet" href="./css/style.css">

      <!-- header css -->
      <link rel="stylesheet" href="./css/header.css">

      <!-- footer css -->
      <link rel="stylesheet" href="./css/footer.css">
    </head>

    <body>

      <jsp:include page="header.jsp" />

      <jsp:useBean id="user" scope="session" type="com.epam.hiltonbooking.bean.User"></jsp:useBean>

      <section id="home">
        <div class="container">
          <div class="profile_main">
            <form action="profile" method="post">
              <h1>Profile Infromation</h1>

              <div class="profile_block">
                <% String info=(String) request.getAttribute("info"); %>

                  <% if (info !=null && !info.isEmpty()) { %>
                    <p style="color: red; font-size: 16px; text-align: center;" class="error-message">
                      <%= info %>
                    </p>
                    <% } %>
                      <label for="first_name">
                        <h3>Firstname: </h3>
                        <input class="info_input" type="text" name="firstname" id="first_name" value="${user.firstName}"
                          required>
                      </label>
                      <br>
                      <label for="last_name">
                        <h3>Lastname: </h3>
                        <input class="info_input" type="text" name="lastname" id="last_name" value="${user.lastName}"
                          required>
                      </label>
                      <br>
                      <label for="email">
                        <h3>Email: </h3>
                        <input class="info_input" type="email" name="email" id="email" value="${user.email}" required>
                      </label>
                      <br>
                      <label for="username">
                        <h3>Username: </h3>
                        <input class="info_input" type="text" name="username" id="username" value="${user.username}"
                          required>
                      </label>
                      <br>
                      <label for=" password">
                        <h3>Password: </h3>
                        <input class="info_input" type="password" name="password" id="password" value="${user.password}"
                          required>
                      </label>
                      <br>
                      <label for="">
                        <input class="update_btn" type="submit" value="Update" name="submit">
                      </label>
              </div>
            </form>
          </div>
        </div>
      </section>


      <jsp:include page="footer.jsp" />

      <script src="./js/script.js"></script>

    </body>

    </html>