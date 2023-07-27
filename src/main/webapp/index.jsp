<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>


<!DOCTYPE html>
<html lang="${pageContext.request.locale.language}">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>HotelBooking - Content</title>

  <link rel="stylesheet" href="css/style.css">

  <!-- header css -->
  <link rel="stylesheet" href="css/header.css">

  <!-- footer css -->
  <link rel="stylesheet" href="css/footer.css">
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
            <li><a href="#about">About</a></li>
            <li><a href="#rooms">Rooms</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </nav>

        <div class="manager_btns">
          <a class="login_btn btn" href="login">Log in</a>
          <a class="register_btn btn" href="register">Sign Up</a>
          <form action="" id="localeForm">
            <select name="locale" id="lan">
                      <option value="en" ${pageContext.request.locale.language eq 'en' ? 'selected' : '' }>EN</option>
                      <option value="uz" ${pageContext.request.locale.language eq 'uz' ? 'selected' : '' }>UZ</option>
                      <option value="ru" ${pageContext.request.locale.language eq 'ru' ? 'selected' : '' }>RU</option>
            </select>
          </form>
        </div>
      </div>
    </div>
  </header>

 <section id="home">
    <div class="container">
      <div class="overview_main">
        <div class="overview">
          <!-- <h1><fmt:message key="welcome" /></h1> -->
          <h1>Welcome to Hilton in Tashkent - Where Timeless Elegance Meets Modern Comfort!</h1>
        </div>
        <div class="login_block">
         <!-- <a class="overview_login_btn" href="login"><fmt:message key="login.button" /></a> -->
         <a class="overview_login_btn" href="login">Log in to book a room</a>
        </div>
      </div>
    </div>
  </section>

  <section id="about">
    <div class="container">
      <div class="about_main">
        <div class="text_block">

          <div class="text_inner">
            <h3>About Us</h3>
            <h2>Welcome to Hilton Tashkent - Where Hospitality Meets Excellence!</h2>
            <br/>
            <p>At Hilton Tashkent, we take pride in offering a distinguished hotel experience in the heart of Uzbekistan. With a perfect blend of contemporary luxury and warm hospitality, our hotel stands as a symbol of elegance and comfort. Explore the rich history of Tashkent while enjoying world-class amenities and personalized service. We are committed to making your stay an unforgettable journey. Welcome to Hilton Tashkent, your home away from home.</p>
          </div>

        </div>

        <div class="img_block">
          <div class="square"></div>
          <img src="./images/about.jpg" alt="about img">
        </div>
      </div>
    </div>
  </section>

  <section id="rooms">
    <div class="rooms_main">
      <div class="room_inner inner1">
        <img src="images/room1.jpg" alt="room1">
      </div>
      <div class="room_inner inner2">
        <img src="images/room2.jpg" alt="room2">
      </div>
      <div class="room_inner inner3">
        <img src="images/room3.jpg" alt="room3">
      </div>
    </div>
  </section>

  <section id="contact">
    <div class="container">
      <div class="contact_main">
        <div class="contact_overview">
          <h1>Contact Us</h1>
        </div>

        <div class="contact_info_main">
          <div class="hotel_info_block">
            <div class="info_container">
              <h3>Location:</h3>
              <p>2 Islam Karimov Street, block 5
                Tashkent, 100027, Uzbekistan</p>
            </div>

            <div class="info_container">
              <h3>Email:</h3>
              <p>reservations@hilton-tashkent.com</p>
            </div>

            <div class="info_container">
              <h3>Phone Number:</h3>
              <p>+998 71 210 88 88</p>
            </div>

            <div class="map_container">
              <iframe
                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2996.764680501716!2d69.24402658546573!3d41.31398259733232!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x38ae8b685b689e13%3A0xaf4cdf526e02f5e7!2sHilton%20Tashkent%20City!5e0!3m2!1sen!2s!4v1689417464820!5m2!1sen!2s"
                style="border:0;" allowfullscreen="" loading="lazy"
                referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
          </div>
          <div class="user_info_block">
            <form action="home" method="post">
              <div>
              <p style="color: red; font-size: 18px;" class="error-message">${infoMessage}</p>
                <div class="basic_info">
                    <label for="contact_name">
                      <p>Your name</p>
                      <input class="top" type="text" name="messanger_name" id="contact_name" required>
                    </label>
                    <label for="contact_email">
                      <p>Your email</p>
                      <input name="messanger_email" id="contact_email" class="top" type="email" required>
                    </label>
                  </div>
              </div>
              <label for="contact_phone">
                <p>Phone number</p>
                <input name="messanger_phone" id="contact_phone" class="top" type="text" required>
              </label>
              <label for="contact_message">
                <p>Message</p>
                <textarea class="top" name="message_text" id="contact_message" cols="30" rows="10" required></textarea>
              </label>
              <label for="contact_submit_btn">
                <input id="contact_submit_btn" class="contact_submit_btn" type="submit" value="Send Message">
              </label>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>

  <jsp:include page="/html/footer.jsp" />

  <script src="./js/script.js"></script>

</body>

</html>