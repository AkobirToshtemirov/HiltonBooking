function openBookingDetails(bookingId) {
    // Send an AJAX request to fetch the booking details
    // Replace '/getBookingDetails' with the actual URL to fetch booking details from the server
    fetch(`/getBookingDetails?bookingId=${bookingId}`)
        .then(response => response.json())
        .then(bookingDetails => {
            // Create a popup window with the booking details
            const popupWindow = window.open('', 'Booking Details', 'width=600,height=400,scrollbars=1,resizable=1');

            // Write the booking details to the popup window
            popupWindow.document.write('<h2>Booking Details</h2>');
            popupWindow.document.write('<p>Client: ' + bookingDetails.user.firstName + ' ' + bookingDetails.user.lastName + '</p>');
            popupWindow.document.write('<p>Check In: ' + bookingDetails.checkIn + '</p>');
            popupWindow.document.write('<p>Check Out: ' + bookingDetails.checkOut + '</p>');
            // Add other booking details as needed

            // Create a form inside the popup window to approve or cancel the booking
            popupWindow.document.write(`
                <form action="/reservations" method="post">
                    <input type="hidden" name="action" value="takeAction">
                    <input type="hidden" name="booking_id" value="${bookingId}">
                    <button type="submit" name="actionType" value="approve">Approve</button>
                    <button type="submit" name="actionType" value="cancel">Cancel</button>
                </form>
            `);

            popupWindow.document.close();
        })
        .catch(error => console.error('Error fetching booking details:', error));
}