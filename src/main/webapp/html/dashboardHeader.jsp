<div class="dashboard_header">
  <div class="logo">
    <h1>HiltonTashkent</h1>
  </div>

  <div class="setting_manager_block">
    <a class="settings_btn" href="profile">Admin Settings</a>
      <form action="" id="localeForm">
        <select name="language" id="lan">
                  <option value="en" ${pageContext.request.locale.language eq 'en' ? 'selected' : '' }>EN</option>
                  <option value="uz" ${pageContext.request.locale.language eq 'uz' ? 'selected' : '' }>UZ</option>
                  <option value="ru" ${pageContext.request.locale.language eq 'ru' ? 'selected' : '' }>RU</option>
        </select>
      </form>
  </div>
</div>