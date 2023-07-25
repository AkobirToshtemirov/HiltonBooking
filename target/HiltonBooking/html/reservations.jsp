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
                <h2>Reservations</h2>

                <div class="reservations_main">
                  <div class="reservations_block">

                    <div class="reservation_headline">
                      <div class="bar">Client</div>
                      <div class="bar">Check In</div>
                      <div class="bar">Check Out</div>
                      <div class="bar">Room No</div>
                      <div class="bar">No of beds</div>
                      <div class="bar">Room class</div>
                      <div class="bar">Status</div>
                      <div class="bar">
                        <a class="check_btn" href=""></a>
                        <a class="check_btn" href=""></a>
                      </div>
                    </div>

                    <div class="reservations">

                     <c:forEach items="${allBookings}" var="element">
                         <div class="reservation">
                             <div class="bar">${element.user.firstName} ${element.user.lastName}</div>
                             <div class="bar">${element.checkIn}</div>
                             <div class="bar">${element.checkOut}</div>
                             <div class="bar">
                                 <select name="room_number" id="room_number">
                                     <option value="${element.room.roomNumber}" selected>${element.room.roomNumber}</option>
                                     <!-- Add other options if needed -->
                                 </select>
                             </div>
                             <div class="bar">${element.bedsAmount}</div>
                             <div class="bar">${element.roomClass}</div>
                             <div class="bar">${element.status}</div>
                             <div class="bar">
                                 <button class="check_btn take_action_btn" onclick="openBookingDetails(${element.bookingId})">Take Action</button>
                             </div>
                         </div>
                     </c:forEach>

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