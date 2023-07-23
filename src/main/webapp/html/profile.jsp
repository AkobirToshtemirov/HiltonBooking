<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>HotelBooking - Content</title>

  <!-- general css -->
  <link rel="stylesheet" href="/css/general.css">

  <link rel="stylesheet" href="/css/style.css">

  <!-- header css -->
  <link rel="stylesheet" href="/css/header.css">

  <!-- footer css -->
  <link rel="stylesheet" href="/css/footer.css">
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
      <div class="profile_main">
        <form action="req">
          <h1>Profile Infromation</h1>
          <div class="profile_block">
            <label for="first_name">
              <h3>Firstname: </h3>
              <input class="info_input" type="text" name="firstname" id="first_name" value="Jon">
            </label>
            <br>
            <label for="last_name">
              <h3>Lastname: </h3>
              <input class="info_input" type="text" name="lastname" id="last_name" value="Doe">
            </label>
            <br>
            <label for="email">
              <h3>Email: </h3>
              <input class="info_input" type="email" name="email" id="email" value="jondoe@gmail.com">
            </label>
            <br>
            <label for="username">
              <h3>Username: </h3>
              <input class="info_input" type="text" name="username" id="username" value="jondoe12"">
            </label>
            <br>
            <label for=" password">
              <h3>Password: </h3>
              <input class="info_input" type="password" name="password" id="password" value="1234">
            </label>
            <br>
            <label for="">
              <input class="update_btn" type="submit" value="Update" name="submit">
            </label>
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