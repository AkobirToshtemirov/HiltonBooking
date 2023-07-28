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
                      <div class="bar">No of beds</div>
                      <div class="bar">Room class</div>
                      <div class="bar">Status</div>
                      <div class="bar">Booking Time</div>
                      <div class="bar">
                        <a class="check_btn" href=""></a>
                        <a class="check_btn" href=""></a>
                      </div>
                    </div>

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
                                          <div class="bar">${element.bedsAmount}</div>
                                          <div class="bar">${element.roomClass}</div>
                                          <div class="bar">${element.status}</div>
                                          <div class="bar">${element.bookingTime}</div>
                                          <div class="bar delete_btn_bar">
                                              <button class="check_btn disabled_btn approved_btn" disabled>APPROVED</button>
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
                        <%--
                         <c:when test="${tool.equals('newMessages')}">
                            <div class="messages">

                                  <c:forEach items="${messages}" var="message">
                                    <div class="message">
                                      <div class="bar messageText">${message.sentAt}</div>
                                      <div class="bar messageText">${message.name}</div>
                                      <div class="bar messageText">${message.email}</div>
                                      <div class="bar messageText">${message.phoneNumber}</div>
                                      <div class="bar messageText">${message.text}</div>
                                      <div class="bar delete_btn_bar">
                                        <form action="view-message" method="get">
                                          <input type="hidden" name="message-id" value="${message.id}" />
                                          <button type="submit" class="check_btn view_btn">View</button>
                                        </form>
                                      </div>
                                    </div>
                                  </c:forEach>

                                </div>
                         </c:when>
                         --%>
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