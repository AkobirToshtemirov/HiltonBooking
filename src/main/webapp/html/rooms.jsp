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
                  <h2>Rooms</h2>
                  <!-- <a class="check_btn register_user_btn" href="">Add Room</a> -->
                </div>

                <div class="add_room_main">
                  <h3>Adding a Room</h3>

                  <% String info=(String) request.getAttribute("info"); %>

                    <% if (info !=null && !info.isEmpty()) { %>
                      <p style="color: red; font-size: 18px;" class="error-message">
                        <%= info %>
                      </p>
                      <% } %>

                        <form action="rooms" method="post">
                          <div class="add_room_form_main">
                            <label for="room_number">
                              <p>Room number</p>
                              <input name="room-number" type="number" id="room_number" required>
                            </label>
                            <label for="room_class">
                              <p>Room class</p>
                              <select name="room-class" id="room_class">
                                <option value="Standard" selected>Standard</option>
                                <option value="Suite">Suite</option>
                                <option value="Deluxe">Deluxe</option>
                                <option value="Premium">Premium</option>
                              </select>
                            </label>
                            <label for="beds_number">
                              <p>Beds</p>
                              <select name="beds-amount" id="add_beds" required>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                              </select>
                            </label>
                            <label for="room_cost">
                              <p>Cost(per day)</p>
                              <input name="room-cost" type="number" required>
                            </label>
                            <label for="">
                              <p>Action</p>
                              <input class="check_btn register_user_btn add_room_btn" type="submit" value="Add Room">
                            </label>
                          </div>
                        </form>
                </div>



              <p style="color: red; font-size: 16px;" class="error-message">${deleteMessage}</p>

                <div class="rooms_main">
                  <div class="rooms_block">
                    <div class="rooms_headline">
                      <div class="bar">Room Number</div>
                      <div class="bar">Class</div>
                      <div class="bar">Beds</div>
                      <div class="bar">Active</div>
                      <div class="bar">Cost(per day)</div>
                      <div class="bar"></div>
                    </div>

                    <div class="rooms">

                      <c:forEach items="${roomList}" var="room">

                        <div class="room">
                          <div class="bar">${room.roomNumber}</div>
                          <div class="bar">${room.roomClass}</div>
                          <div class="bar">${room.bedsAmount}</div>
                          <div class="bar">
                            <input type="checkbox" ${room.active ? 'checked' : '' }>
                          </div>
                          <div class="bar">${room.roomCost}</div>
                          <div class="bar delete_btn_bar">
                            <form action="delete-room" method="post">
                              <input type="hidden" name="room-id" value="${room.id}" />
                              <button type="submit" class="check_btn delete_btn">Delete</button>
                            </form>
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

      <script src="./js/script.js"></script>

    </body>

    </html>