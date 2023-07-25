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
                <h2>Booking Information</h2>

                <div class="reservations_main">
                  <div class="reservations_block">

                    <div class="booking_information_main">
                      <div class="booking_info_header">
                        <div class="bar">Client Name:</div>
                        <div class="bar">Email: </div>
                        <div class="bar">Check-in: </div>
                        <div class="bar">Check-out: </div>
                        <div class="bar">Beds amount: </div>
                        <div class="bar">Room class: </div>
                        <div class="bar">Room Number: </div>
                        <div class="bar">Total cost: </div>
                        <div class="bar">Booking time: </div>
                      </div>

                      <div class="booking_info_show">
                        <div class="bar">${booking.user.firstName} ${booking.user.lastName}</div>
                        <div class="bar">${booking.user.email}</div>
                        <div class="bar">${booking.checkIn}</div>
                        <div class="bar">${booking.checkOut}</div>
                        <div class="bar">${booking.bedsAmount}</div>
                        <div class="bar">${booking.roomClass}</div>
                        <div class="bar">
                          <select name="room-number-booking" id="">
                           <option value="" disabled selected>Select</option>
                            <c:forEach items="${roomList}" var="room">
                              <option value="${room.getId()}">${room.roomNumber}</option>
                            </c:forEach>
                          </select>
                        </div>
                        <div id="total-cost-bar" class="bar">0.00</div>
                        <div class="bar">${booking.bookingTime}</div>
                      </div>
                    </div>

                  </div>
                </div>
              </div>
            </div>
          </div>

        </div>

      </section>


      <!-- <script>
        function calculateTotalCost() {
          var roomId = document.getElementById("room-number-booking").value;
      
          // Find the corresponding booking object by its ID (assuming booking is a JSON object received from the server)
          var booking = ${booking};
      
          // Get the room cost from the booking (assuming booking.roomCost is the room cost)
          var roomCost = booking.room.roomCost;
      
          // Get the check-in and check-out dates from the booking (assuming booking.checkIn and booking.checkOut are the dates)
          var checkIn = new Date("${booking.checkIn}");
          var checkOut = new Date("${booking.checkOut}");
      
          // Calculate the staying days
          var millisecondsPerDay = 24 * 60 * 60 * 1000;
          var stayingDays = Math.round((checkOut - checkIn) / millisecondsPerDay);
      
          // Calculate the total cost
          var totalCost = roomCost * stayingDays;
      
          // Update the totalCost bar to show the calculated value
          document.getElementById("total-cost-bar").innerText = "Total Cost: " + totalCost;
        }
      </script> -->

    </body>

    </html>