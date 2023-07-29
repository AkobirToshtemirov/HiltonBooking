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
          <li><a href="book">Book</a></li>
          <li><a href="reservations">Bookings</a></li>
          <li><a href="home#contact">Contact</a></li>
        </ul>
      </nav>

      <div class="manager_btns">
        <a class="accaunt_btn btn" href="profile">My Profile</a>
        <a class="logout_btn btn" href="logout">Log Out</a>
        <form action="" id="localeForm">
          <select name="language" id="lan">
            <option value="en" ${pageContext.request.locale.language eq 'en' ? 'selected' : '' }>EN</option>
            <option value="uz" ${pageContext.request.locale.language eq 'uz' ? 'selected' : '' }>UZ</option>
            <option value="ru" ${pageContext.request.locale.language eq 'ru' ? 'selected' : '' }>RU</option>
          </select>
        </form>
      </div>
    </div>
  </div>
</header>