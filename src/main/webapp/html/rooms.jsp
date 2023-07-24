<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin - dashboard</title>

  <link rel="stylesheet" href="../css/style.css">
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

              <form action="">
                <div class="add_room_form_main">
                  <label for="room_number">
                    <p>Room number</p>
                    <input name="room-number" type="number" id="room_number">
                  </label>
                  <label for="room_class">
                    <p>Room class</p>
                    <input name="room-class" type="text">
                  </label>
                  <label for="beds_number">
                    <p>Beds</p>
                    <select name="beds-amount" id="add_beds">
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
                    <input name="room-cost" type="number">
                  </label>
                  <label for="">
                    <p>Action</p>
                    <input class="check_btn register_user_btn add_room_btn" type="submit" value="Add Room">
                  </label>
                </div>
              </form>
            </div>

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

                  <div class="room">
                    <div class="bar">1</div>
                    <div class="bar">Standard</div>
                    <div class="bar">3</div>
                    <div class="bar">
                      <form action="">
                        <input type="checkbox" checked>
                      </form>
                    </div>
                    <div class="bar">100$</div>
                    <div class="bar delete_btn_bar">
                      <a class="check_btn update_btn" href="">Update</a>
                      <a class="check_btn delete_btn" href="">Delete</a>
                    </div>
                  </div>

                  <div class="room">
                    <div class="bar">4</div>
                    <div class="bar">Deluxe</div>
                    <div class="bar">2</div>
                    <div class="bar">
                      <form action="">
                        <input type="checkbox" checked>
                      </form>
                    </div>
                    <div class="bar">200$</div>
                    <div class="bar delete_btn_bar">
                      <a class="check_btn update_btn" href="">Update</a>
                      <a class="check_btn delete_btn" href="">Delete</a>
                    </div>
                  </div>

                  <div class="room">
                    <div class="bar">20</div>
                    <div class="bar">Premium</div>
                    <div class="bar">5</div>
                    <div class="bar">
                      <form action="">
                        <input type="checkbox" checked>
                      </form>
                    </div>
                    <div class="bar">300$</div>
                    <div class="bar delete_btn_bar">
                      <a class="check_btn update_btn" href="">Update</a>
                      <a class="check_btn delete_btn" href="">Delete</a>
                    </div>
                  </div>

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