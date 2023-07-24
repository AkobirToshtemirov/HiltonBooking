<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>HotelBooking - Content</title>

      <!-- general css -->
      <link rel="stylesheet" href="./css/general.css">

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

                    <div class="booking_inormation">
                      <div class="bar info_bar">
                        <jsp:getProperty property="firstName" name="user" />
                      </div>
                      <div class="bar info_bar">element.getCheckIn()</div>
                      <div class="bar info_bar">element.getCheckOut()</div>
                      <div class="bar info_bar">element.getBedsAmount()</div>
                      <div class="bar info_bar">element.getRoomClass()</div>
                      <div class="bar info_bar">element.getStatus()</div>
                      <div class="bar info_bar">
                        <a class="check_btn" href="">Invoice</a>
                      </div>
                    </div>

                  </c:forEach>

                  <div class="booking_inormation">
                    <div class="bar info_bar">Jon Doe</div>
                    <div class="bar info_bar">03/12/2023</div>
                    <div class="bar info_bar">04/12/2023</div>
                    <div class="bar info_bar">5</div>
                    <div class="bar info_bar">Deluxe</div>
                    <div class="bar info_bar">Waiting</div>
                    <div class="bar info_bar">
                      <a class="check_btn" href="">Invoice</a>
                    </div>
                  </div>

                </div>
              </div>
            </div>
          </div>
      </section>


      <jsp:include page="footer.jsp" />

    </body>

    </html>