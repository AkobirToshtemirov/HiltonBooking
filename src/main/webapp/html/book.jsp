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

  <header>
    <div class="container">
      <div class="header">
        <div class="logo">
          <a href="">
            <!-- <h2>Booking</h2> -->
            <h1><span class="text_logo">Hilton</span>Tashkent</h1>
          </a>
        </div>

        <nav>
          <ul>
            <li><a href="">Home</a></li>
            <!-- <li><a href="">About</a></li>
            <li><a href="">Rooms</a></li> -->
            <li><a class="active" href="#">Book</a></li>
            <li><a href="./bookings.html">Bookings</a></li>
            <li><a href="">Contact</a></li>
          </ul>
        </nav>

        <div class="manager_btns">
          <a class="accaunt_btn btn" href="">My Profile</a>
          <a class="logout_btn btn" href="">Log Out</a>
          <select name="locale" form="language_change" id="lan">
            <option value="en" selected>EN</option>
            <option value="uz">UZ</option>
            <option value="ru">RU</option>
          </select>
        </div>
      </div>
    </div>
  </header>

  <section id="home">
    <div class="container">
      <div class="book_main">
        <form action="get">
          <div class="book_block">
            <div class="check_in_block">
              <label for="checkin">Check in</label>
              <input class="input_date" type="date" name="check-in" id="checkin">
            </div>
            <div class="check_out_block">
              <label for="checkout">Check out</label>
              <input class="input_date" type="date" name="check-out" id="checkout">
            </div>
            <!-- <div class="number_of_adults">
              <label for="adult">Adult</label>
              <select name="adult" id="adult">
                <option value=""></option>
              </select>
            </div> -->
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
        </form>
      </div>
    </div>
  </section>


  <footer>
    <div class="container">
      <div class="footer_main">
        <div class="copyright_block">
          <h3><span class="highlight">HiltonTashkent</span> &copy; 2023. <span class="weight">All rights
              reserved.</span>
          </h3>
          <br>
          <h4><span class="epam">Epam Training.</span> Final Project</h4>
        </div>
        <div class="links_block">

        </div>
        <div class="social_media_block">

        </div>
      </div>
    </div>
  </footer>

</body>

</html>