window.addEventListener('load', function() {
  const messageTextElements = document.querySelectorAll('.messageText');

  messageTextElements.forEach(messageText => {
    const hasEllipsis = messageText.scrollWidth > messageText.clientWidth;

    if (hasEllipsis) {
      messageText.classList.add('ellipsis');
    }
  });
});
