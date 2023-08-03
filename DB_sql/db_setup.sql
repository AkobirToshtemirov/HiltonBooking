--   HiltonTashkent DB:

DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS bookings;
DROP TABLE IF EXISTS rooms;
DROP TABLE IF EXISTS users;


CREATE TABLE users (
  user_id SERIAL PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  username  VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  is_admin BOOLEAN NOT NULL DEFAULT false,
  join_time TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE rooms (
  room_id SERIAL PRIMARY KEY,
  room_number INT NOT NULL UNIQUE,
  room_class VARCHAR(50) NOT NULL,
  beds_amount SMALLINT NOT NULL,
  is_active BOOLEAN NOT NULL DEFAULT true,
  room_cost DECIMAL(10, 2) NOT NULL
);

CREATE TABLE bookings (
    booking_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    room_id INT,
    status VARCHAR(20) NOT NULL CHECK (status IN ('WAITING', 'APPROVED', 'CANCELLED')),
    check_in DATE NOT NULL,
    check_out DATE NOT NULL,
    beds_amount SMALLINT NOT NULL,
    total_cost DECIMAL(10, 2),
    room_class VARCHAR(50) NOT NULL,
    booking_time TIMESTAMP NOT NULL DEFAULT NOW(),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);

CREATE TABLE messages (
  message_id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  text TEXT NOT NULL,
  email VARCHAR(50) NOT NULL,
  sent_at TIMESTAMP NOT NULL DEFAULT NOW()
);