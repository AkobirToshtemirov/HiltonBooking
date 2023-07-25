<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>HotelBooking - Login</title>

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
            <li><a href="home">Home</a></li>
            <li><a href="home#about">About</a></li>
            <li><a href="home#rooms">Rooms</a></li>
            <li><a href="home#contact">Contact</a></li>
          </ul>
        </nav>

        <div class="manager_btns">
          <a class="login_btn btn" href="login">Log in</a>
          <a class="register_btn btn" href="register">Sign Up</a>
          <form action="">
            <select name="locale" id="lan">
              <option value="en" selected>EN</option>
              <option value="uz">UZ</option>
              <option value="ru">RU</option>
            </select>
          </form>
        </div>
      </div>
    </div>
  </header>

  <section id="home">
    <div class="container">
      <div class="login_main">
        <div class="login_block_main">
          <form action="login" method="post">
            <p>Log in to your profile</p>
            <label for="username">
              <button>
                <img src="./images/user.png" alt="username">
              </button>
              <input class="information" type="text" name="username" id="username" placeholder="Enter username..." required>
            </label>
            <br>
            <label for="password">
              <button>
                <img src="./images/password.png" alt="password">
              </button>
              <input class="information" type="password" name="password" id="password" placeholder="Enter password..." required>
            </label>
            <br>
            <label for="">
              <input class="submit_btn" type="submit" value="Log in" name="submit">
            </label>

            <p class="no_accaunt">No accaunt yet? <a href="register">Sign Up</a></p>
          </form>
        </div>

        <div class="login_img_content">
          <img src="./images/room9.jpg" alt="login_img">
        </div>
      </div>
    </div>
  </section>


  <jsp:include page="footer.jsp" />

</body>

</html>