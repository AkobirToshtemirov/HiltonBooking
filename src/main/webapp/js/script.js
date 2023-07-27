window.addEventListener('load', function () {
  const messageTextElements = document.querySelectorAll('.messageText');

  messageTextElements.forEach(messageText => {
    const hasEllipsis = messageText.scrollWidth > messageText.clientWidth;

    if (hasEllipsis) {
      messageText.classList.add('ellipsis');
    }
  });
});


document.addEventListener("DOMContentLoaded", function () {
  const checkinInput = document.getElementById("checkin");
  const checkoutInput = document.getElementById("checkout");

  const today = new Date().toISOString().split("T")[0];
  const tomorrow = new Date(new Date().getTime() + 24 * 60 * 60 * 1000).toISOString().split("T")[0];

  checkinInput.setAttribute("min", today);
  checkoutInput.setAttribute("min", tomorrow);

  checkinInput.value = today;
  checkoutInput.value = tomorrow;
});

const localeForm = document.getElementById('localeForm');
const lanSelect = document.getElementById('lan');

lanSelect.addEventListener('change', () => {
    localeForm.submit();
});