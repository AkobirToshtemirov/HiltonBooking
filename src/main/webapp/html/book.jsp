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

      <section id="home">
        <div class="container">
          <div class="book_main">



            <form action="book" method="post">
              <% String info=(String) request.getAttribute("error"); %>

                <% if (info !=null && !info.isEmpty()) { %>
                  <p style="color: red; font-size: 18px;" class="error-message">
                    <%= info %>
                  </p>
                  <% } %>
                    <div class="book_form">
                      <div class="book_block">
                        <div class="check_in_block">
                          <label for="checkin">Check in</label>
                          <input minimumDate="today" class="input_date" type="date" name="check-in" id="checkin">
                        </div>
                        <div class="check_out_block">
                          <label for="checkout">Check out</label>
                          <input minimumDate="tomorrow" class="input_date" type="date" name="check-out" id="checkout">
                        </div>
                        <div class="number_of_beds_block">
                          <label for="beds">Number of beds</label>
                          <select name="beds-amount" id="beds" class="select_beds">
                            <option value="1" selected>1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                          </select>
                        </div>
                        <div class="room_class_block">
                          <label for="class">Room class</label>
                          <select name="room-class" id="class">
                            <option value="Standard" selected>Standard</option>
                            <option value="Suite">Suite</option>
                            <option value="Deluxe">Deluxe</option>
                            <option value="Premium">Premium</option>
                          </select>
                        </div>

                        <div class="book_btn_container">
                          <input class="book_btn" type="submit" value="Book Now">
                        </div>
                      </div>
                    </div>
            </form>
          </div>
        </div>
      </section>


      <jsp:include page="footer.jsp" />

      <script src="./js/script.js"></script>

    </body>

    </html>