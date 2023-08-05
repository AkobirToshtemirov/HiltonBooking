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
                        <c:if
                          test="${booking.status.equals('APPROVED') || booking.status.equals('CHECKED IN') || booking.status.equals('CHECKED OUT')}">
                          <div class="bar">Total cost: </div>
                        </c:if>
                        <div class="bar">Booking time: </div>
                      </div>

                      <form action="booking-details" method="post">
                        <div class="booking_info_show">
                          <c:choose>
                            <c:when
                              test="${booking.status.equals('APPROVED') || booking.status.equals('CHECKED IN') || booking.status.equals('CHECKED OUT')}">
                              <div class="bar">${booking.user.firstName} ${booking.user.lastName}</div>
                              <div class="bar">${booking.user.email}</div>
                              <div class="bar">${booking.checkIn}</div>
                              <div class="bar">${booking.checkOut}</div>
                              <div class="bar">${booking.bedsAmount}</div>
                              <div class="bar">${booking.roomClass}</div>
                              <div class="bar">${booking.room.roomNumber}</div>
                              <div id="total-cost-bar" class="bar">${booking.totalCost} $</div>
                              <div class="bar">${booking.bookingTime}</div>
                            </c:when>
                            <c:otherwise>
                              <div class="bar">${booking.user.firstName} ${booking.user.lastName}</div>
                              <div class="bar">${booking.user.email}</div>
                              <div class="bar">${booking.checkIn}</div>
                              <div class="bar">${booking.checkOut}</div>
                              <div class="bar">${booking.bedsAmount}</div>
                              <div class="bar">${booking.roomClass}</div>
                              <div class="bar">
                                <select name="room-id" id="">
                                  <option value="" disabled selected>Select</option>
                                  <c:forEach items="${roomList}" var="room">
                                    <option value="${room.id}">${room.roomNumber}</option>
                                  </c:forEach>
                                </select>
                              </div>
                              <div class="bar">${booking.bookingTime}</div>
                            </c:otherwise>
                          </c:choose>

                          <br>
                          <div class="booking_information_btns">
                            <input type="hidden" name="booking-id" value="${booking.id}">

                            <c:choose>
                              <c:when test="${booking.status.equals('WAITING')}">
                                <input name="action" type="submit" value="APPROVE" class="check_btn approve_btn">
                                <input name="action" type="submit" value="CANCEL" class="check_btn delete_btn">
                              </c:when>
                              <c:when test="${booking.status.equals('APPROVED')}">
                                <input name="action" type="submit" value="CHECK IN" class="check_btn approve_btn">
                              </c:when>
                              <c:when test="${booking.status.equals('CHECKED IN')}">
                                <input name="action" type="submit" value="CHECK OUT" class="check_btn approve_btn">
                              </c:when>
                              <c:otherwise>
                                <a class="back_btn" href="reservations">Back to Reservations</a>
                                <a class="back_btn" href="dashboard">Back to Dashboard</a>
                              </c:otherwise>
                            </c:choose>
                          </div>
                        </div>

                      </form>
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