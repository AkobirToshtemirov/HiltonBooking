<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HotelBooking - Invoice</title>

    <!-- general css -->
    <link rel="stylesheet" href="./css/general.css">

    <link rel="stylesheet" href="./css/style.css">

    <!-- header css -->
    <link rel="stylesheet" href="./css/header.css">

    <!-- footer css -->
    <link rel="stylesheet" href="./css/footer.css">
</head>

<body>

<jsp:include page="header.jsp"/>

<section id="home">
    <div class="container">
        <div class="invoice_main">
            <div class="invoice_block">
                <h1>Invoice Details</h1>

                <div class="invoice_table">
                    <div>
                        <div class="invoice_highlight_text">
                            <h4>Booking No: </h4>
                        </div>
                        <div>
                            <h4>${booking.id}</h4>
                        </div>
                    </div>

                    <div>
                        <div class="invoice_highlight_text">Booking Date:</div>
                        <div class="invoice_text">${booking.bookingTime}</div>
                    </div>

                    <div>
                        <div class="invoice_highlight_text">Customer Name:</div>
                        <div class="invoice_text">${booking.user.firstName} ${booking.user.lastName}</div>
                    </div>

                    <div>
                        <div class="invoice_highlight_text">Email:</div>
                        <div class="invoice_text">${booking.user.email}</div>
                    </div>

                    <div>
                        <div class="invoice_highlight_text">Number of beds:</div>
                        <div class="invoice_text">${booking.bedsAmount}</div>
                    </div>

                    <div>
                        <div class="invoice_highlight_text">Room Class:</div>
                        <div class="invoice_text">${booking.roomClass}</div>
                    </div>

                    <div>
                        <div class="invoice_highlight_text">Room Number:</div>
                        <div class="invoice_text">${booking.room.roomNumber}</div>
                    </div>

                    <div>
                        <div class="invoice_highlight_text">Room Price for Per Day:</div>
                        <div class="invoice_text">${booking.room.roomCost}</div>
                    </div>

                    <div>
                        <div class="invoice_highlight_text">Check In:</div>
                        <div class="invoice_text">${booking.checkIn}</div>
                    </div>

                    <div>
                        <div class="invoice_highlight_text">Check Out:</div>
                        <div class="invoice_text">${booking.checkOut}</div>
                    </div>

                    <div>
                        <div class="invoice_highlight_text">Total Number of Days:</div>
                        <div class="invoice_text">${stayingDays}</div>
                    </div>

                    <div>
                        <div class="invoice_highlight_text">
                            <h4>Total Price: </h4>
                        </div>
                        <div class="invoice_text">
                            <h4>${booking.totalCost}</h4>
                        </div>
                    </div>

                </div>

                <div class="print_btn_container">
                    <a class="print_btn" href="">Print</a>
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="footer.jsp"/>

</body>

</html>