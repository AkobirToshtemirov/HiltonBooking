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
              <c:choose>
                <c:when test="${tool.equals('newBookings')}">
                    <h2>New Reservations</h2>
                </c:when>

                 <c:when test="${tool.equals('approvedBookings')}">
                    <h2>Approved Reservations</h2>
                </c:when>

                <c:when test="${tool.equals('checkedInBookings')}">
                    <h2>Checked In Reservations</h2>
                </c:when>

                <c:when test="${tool.equals('checkedOutBookings')}">
                    <h2>Checked Out Reservations</h2>
                </c:when>

                <c:when test="${tool.equals('cancelledBookings')}">
                    <h2>Cancelled Reservations</h2>
                </c:when>

                <c:when test="${tool.equals('newMessages')}">
                    <h2>Unread Messages</h2>
                </c:when>
              </c:choose>

                <div class="reservations_main">
                  <div class="reservations_block">

                    <c:choose>

                        <c:when test="${tool.equals('newMessages')}">
                           <div class="messages_headline">
                             <div class="bar">Sent Time</div>
                             <div class="bar">Name</div>
                             <div class="bar">Email</div>
                             <div class="bar">Phone #</div>
                             <div class="bar">Message</div>
                             <div class="bar"></div>
                           </div>
                        </c:when>

                        <%--
                        <c:when test="${tool.equals('newUsers')}">

                        </c:when>
                        --%>

                        <c:when test="${tool.equals('newBookings') || tool.equals('approvedBookings') || tool.equals('checkedInBookings') || tool.equals('checkedOutBookings') || tool.equals('cancelledBookings')}">

                            <div class="reservation_headline">
                                 <div class="bar">Client</div>
                                 <div class="bar">Check In</div>
                                 <div class="bar">Check Out</div>
                                 <c:if test="${tool.equals('approvedBookings') || tool.equals('checkedInBookings') || tool.equals('checkedOutBookings')}">
                                    <div class="bar">Room No</div>
                                 </c:if>
                                 <div class="bar">No of beds</div>
                                 <div class="bar">Room class</div>
                                 <div class="bar">Status</div>
                                 <div class="bar">Booking Time</div>
                                 <div class="bar">
                                   <a class="check_btn" href=""></a>
                                 </div>
                            </div>
                        </c:when>
                    </c:choose>

                    <c:choose>

                      <c:when test="${tool.equals('newBookings')}">
                        <div class="reservations">

                          <c:forEach items="${bookings}" var="element">
                            <c:if test="${element.status.equals('WAITING')}">
                              <div class="reservation">
                                <div class="bar">${element.user.firstName} ${element.user.lastName}</div>
                                <div class="bar">${element.checkIn}</div>
                                <div class="bar">${element.checkOut}</div>
                                <div class="bar">${element.bedsAmount}</div>
                                <div class="bar">${element.roomClass}</div>
                                <div class="bar">${element.status}</div>
                                <div class="bar">${element.bookingTime}</div>
                                <div class="bar delete_btn_bar">
                                  <form action="booking-details" method="get">
                                    <input type="hidden" name="booking-id" value="${element.id}" />
                                    <button type="submit" class="check_btn take_action_btn">Take Action</button>
                                  </form>
                                </div>
                              </div>
                            </c:if>
                          </c:forEach>

                        </div>
                      </c:when>

                      <c:when test="${tool.equals('approvedBookings')}">
                        <div class="reservations">

                          <c:forEach items="${bookings}" var="element">
                            <c:if test="${element.status.equals('APPROVED')}">
                              <div class="reservation">
                                <div class="bar">${element.user.firstName} ${element.user.lastName}</div>
                                <div class="bar">${element.checkIn}</div>
                                <div class="bar">${element.checkOut}</div>
                                <div class="bar">${element.room.roomNumber}</div>
                                <div class="bar">${element.bedsAmount}</div>
                                <div class="bar">${element.roomClass}</div>
                                <div class="bar">${element.status}</div>
                                <div class="bar">${element.bookingTime}</div>
                                <div class="bar delete_btn_bar">
                                  <form action="booking-details" method="get">
                                      <input type="hidden" name="booking-id" value="${element.id}" />
                                      <button type="submit" class="check_btn take_action_btn checked_btn">Check In</button>
                                  </form>
                                </div>
                              </div>
                            </c:if>
                          </c:forEach>

                        </div>
                      </c:when>

                    <c:when test="${tool.equals('checkedInBookings')}">
                      <div class="reservations">

                        <c:forEach items="${bookings}" var="element">
                          <c:if test="${element.status.equals('CHECKED IN')}">
                            <div class="reservation">
                              <div class="bar">${element.user.firstName} ${element.user.lastName}</div>
                              <div class="bar">${element.checkIn}</div>
                              <div class="bar">${element.checkOut}</div>
                              <div class="bar">${element.room.roomNumber}</div>
                              <div class="bar">${element.bedsAmount}</div>
                              <div class="bar">${element.roomClass}</div>
                              <div class="bar">${element.status}</div>
                              <div class="bar">${element.bookingTime}</div>
                              <div class="bar delete_btn_bar">
                               <form action="booking-details" method="get">
                                   <input type="hidden" name="booking-id" value="${element.id}" />
                                   <button type="submit" class="check_btn take_action_btn checked_btn">Check Out</button>
                               </form>
                              </div>
                            </div>
                          </c:if>
                        </c:forEach>

                      </div>
                    </c:when>

                     <c:when test="${tool.equals('checkedOutBookings')}">
                      <div class="reservations">

                        <c:forEach items="${bookings}" var="element">
                          <c:if test="${element.status.equals('CHECKED OUT')}">
                            <div class="reservation">
                              <div class="bar">${element.user.firstName} ${element.user.lastName}</div>
                              <div class="bar">${element.checkIn}</div>
                              <div class="bar">${element.checkOut}</div>
                              <div class="bar">${element.room.roomNumber}</div>
                              <div class="bar">${element.bedsAmount}</div>
                              <div class="bar">${element.roomClass}</div>
                              <div class="bar">${element.status}</div>
                              <div class="bar">${element.bookingTime}</div>
                              <div class="bar delete_btn_bar">
                                <form action="booking-details" method="get">
                                  <input type="hidden" name="booking-id" value="${element.id}" />
                                  <button type="submit" class="check_btn take_action_btn checked_btn">View Details</button>
                              </form>
                              </div>
                            </div>
                          </c:if>
                        </c:forEach>

                      </div>
                    </c:when>

                      <c:when test="${tool.equals('cancelledBookings')}">
                        <div class="reservations">

                          <c:forEach items="${bookings}" var="element">
                            <c:if test="${element.status.equals('CANCELLED')}">
                              <div class="reservation">
                                <div class="bar">${element.user.firstName} ${element.user.lastName}</div>
                                <div class="bar">${element.checkIn}</div>
                                <div class="bar">${element.checkOut}</div>
                                <div class="bar">${element.bedsAmount}</div>
                                <div class="bar">${element.roomClass}</div>
                                <div class="bar">${element.status}</div>
                                <div class="bar">${element.bookingTime}</div>
                                <div class="bar delete_btn_bar">
                                  <button class="check_btn disabled_btn cancelled_btn" disabled>CANCELLED</button>
                                </div>
                              </div>
                            </c:if>
                          </c:forEach>

                        </div>
                      </c:when>
                      <c:when test="${tool.equals('newMessages')}">
                        <div class="messages">

                          <c:forEach items="${messages}" var="message">
                            <c:if test="${!message.isRead()}">
                                <div class="message">
                                  <div class="bar messageText">${message.sentAt}</div>
                                  <div class="bar messageText">${message.name}</div>
                                  <div class="bar messageText">${message.email}</div>
                                  <div class="bar messageText">${message.phoneNumber}</div>
                                  <div class="bar messageText">${message.text}</div>
                                  <div class="bar delete_btn_bar">
                                    <form action="view-message" method="post">
                                      <input type="hidden" name="message-id" value="${message.id}" />
                                      <button type="submit" class="check_btn view_btn">View</button>
                                    </form>
                                  </div>
                                </div>
                            </c:if>
                          </c:forEach>

                        </div>
                        </c:when>

                    </c:choose>

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