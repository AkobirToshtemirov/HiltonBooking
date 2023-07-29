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

  if (checkinInput && checkoutInput) {
    const today = new Date().toISOString().split("T")[0];
    const tomorrow = new Date(new Date().getTime() + 24 * 60 * 60 * 1000).toISOString().split("T")[0];

    checkinInput.setAttribute("min", today);
    checkoutInput.setAttribute("min", tomorrow);

    checkinInput.value = today;
    checkoutInput.value = tomorrow;
  } else {
    console.error("Elements with IDs 'checkin' and/or 'checkout' not found.");
  }
});


const localeForm = document.getElementById('localeForm');
const lanSelect = document.getElementById('lan');

lanSelect.addEventListener('change', () => {
    localeForm.submit();
});

document.addEventListener('DOMContentLoaded', function() {
const buttons = document.querySelectorAll('.tool_link');
const actionInput = document.getElementById('actionInput');

buttons.forEach(button => {
button.addEventListener('click', function(event) {
  event.preventDefault();
  const action = button.dataset.action;
  actionInput.value = action;
  console.log("actionInput.value");
  document.getElementById('toolForm').submit();
});
});
});

function generatePDF() {
    const invoiceBlock = document.getElementById('invoiceBlock');
    const opt = {
        margin: 10,
        filename: 'invoice.pdf',
        image: { type: 'jpeg', quality: 0.98 },
        html2canvas: { scale: 2 },
        jsPDF: { unit: 'mm', format: 'a4', orientation: 'portrait' }
    };

    html2pdf().from(invoiceBlock).set(opt).save();
}