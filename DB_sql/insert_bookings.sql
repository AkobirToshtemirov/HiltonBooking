INSERT INTO bookings (user_id, room_id, status, check_in, check_out, beds_amount, total_cost, room_class, booking_time)
VALUES
  (1, null, 'WAITING', '2023-08-10', '2023-08-15', 2, null, 'Standard', '2023-07-26 12:34:56'),
  (2, 2, 'APPROVED', '2023-08-12', '2023-08-18', 3, 450.00, 'Deluxe', '2023-07-26 13:45:22'),
  (3, null, 'CANCELLED', '2023-08-20', '2023-08-25', 4, null, 'Suite', '2023-07-26 14:55:43'),
  (5, null, 'WAITING', '2023-08-18', '2023-08-24', 3, null, 'Deluxe', '2023-07-26 17:21:35'),
  (6, 6, 'APPROVED', '2023-08-22', '2023-08-28', 4, 600.00, 'Suite', '2023-07-26 18:33:01'),
  (7, 7, 'APPROVED', '2023-08-25', '2023-08-30', 2, 300.00, 'Standard', '2023-07-26 19:45:22'),
  (8, null, 'WAITING', '2023-08-28', '2023-09-03', 3, null, 'Deluxe', '2023-07-26 20:57:44'),
  (9, null, 'CANCELLED', '2023-08-30', '2023-09-05', 4, null, 'Suite', '2023-07-26 22:11:10'),
  (10, 10, 'APPROVED', '2023-09-01', '2023-09-07', 2, 300.00, 'Standard', '2023-07-26 23:24:32');