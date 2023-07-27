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
          <div class="bookings_main">
            <div class="overflow_content">
              <div class="content_container">
                <div class="headline_main">
                  <div class="bar header_bar">Client</div>
                  <div class="bar header_bar">Check In</div>
                  <div class="bar header_bar">Check Out</div>
                  <div class="bar header_bar">Number of beds</div>
                  <div class="bar header_bar">Room class</div>
                  <div class="bar header_bar">Status</div>
                  <div class="bar header_bar last_bar"></div>
                </div>

                <div class="booking_info_container">

                  <c:forEach items="${userBookings}" var="element">

                    <div class="booking_information user_booking_info">
                      <div class="bar info_bar">${element.getUser().getFirstName()} ${element.getUser().getLastName()}
                      </div>
                      <div class="bar info_bar">${element.getCheckIn()}</div>
                      <div class="bar info_bar">${element.getCheckOut()}</div>
                      <div class="bar info_bar">${element.getBedsAmount()}</div>
                      <div class="bar info_bar">${element.getRoomClass()}</div>
                      <div class="bar info_bar">${element.getStatus()}</div>
                      <div class="bar info_bar">
                        <c:choose>
                          <c:when test="${element.status.equals('APPROVED')}">
                            <form action="invoice" method="get">
                              <input type="hidden" name="booking-id" value="${element.id}" />
                              <button type="submit" class="check_btn take_action_btn">Invoice</button>
                            </form>
                          </c:when>
                          <c:when test="${element.status.equals('CANCELLED')}">
                            <button class="check_btn disabled_btn cancelled_btn" disabled>CANCELLED</button>
                          </c:when>
                          <c:otherwise>
                            <button class="check_btn disabled_btn waiting_btn" disabled>WAITING</button>
                          </c:otherwise>
                        </c:choose>
                      </div>
                    </div>

                  </c:forEach>
                </div>
              </div>
            </div>
          </div>
      </section>


      <jsp:include page="footer.jsp" />

    </body>

    </html>