<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>HotelBooking - Register</title>

  <!-- general css -->
  <link rel="stylesheet" href="./css/general.css">

  <link rel="stylesheet" href="./css/style.css">

  <!-- header css -->
  <link rel="stylesheet" href="./css/header.css">

  <!-- footer css -->
  <link rel="stylesheet" href="./css/footer.css">
</head>

<body>

  <section id="register">
    <div class="register_main">
      <div class="register_img">
        <div class="register_content">

        </div>
      </div>
      <div class="register_block">
        <form class="register_form" action="register" method="post">
          <h2>Sign Up</h2>
          <label for="first_name">
            <input class="info_input" type="text" name="firstname" id="first_name" placeholder="Enter firstname...">
          </label>
          <br>
          <label for="last_name">
            <input class="info_input" type="text" name="lastname" id="last_name" placeholder="Enter lastname...">
          </label>
          <br>
          <label for="email">
            <input class="info_input" type="email" name="email" id="email" placeholder="Enter email...">
          </label>
          <br>
          <label for="username">
            <input class="info_input" type="text" name="username" id="username" placeholder="Enter username...">
          </label>
          <br>
          <label for="password">
            <input class="info_input" type="password" name="password" id="password" placeholder="Enter password...">
          </label>
          <br>
          <label for="">
            <input class="sign_up_btn" type="submit" value="Sign Up" name="submit">
          </label>

          <p>Already have accaunt? <a href="login">Log in</a></p>
        </form>
      </div>
    </div>
  </section>


</body>

</html>