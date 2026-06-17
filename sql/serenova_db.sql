-- ============================================================
-- Serenova Boutique Hotel Management System
-- Database Setup Script
-- Developer: Ravi Nadheeshan | CODSE252F037 | NIBM
-- ============================================================

CREATE DATABASE IF NOT EXISTS serenova_db;
USE serenova_db;

-- ============================================================
-- TABLE: users
-- Purpose: Admin login management
-- ============================================================
CREATE TABLE IF NOT EXISTS users (
    user_id   INT AUTO_INCREMENT PRIMARY KEY,
    username  VARCHAR(50)  NOT NULL UNIQUE,
    password  VARCHAR(255) NOT NULL,
    role      VARCHAR(20)  NOT NULL DEFAULT 'Admin'
);

-- Default admin account (password: admin123)
INSERT INTO users (username, password, role)
VALUES ('admin', 'admin123', 'Admin');


-- ============================================================
-- TABLE: guests
-- Purpose: Store hotel guest information
-- ============================================================
CREATE TABLE IF NOT EXISTS guests (
    guest_id     INT AUTO_INCREMENT PRIMARY KEY,
    full_name    VARCHAR(100) NOT NULL,
    nic_passport VARCHAR(50)  NOT NULL,
    phone        VARCHAR(15)  NOT NULL,
    email        VARCHAR(100),
    address      VARCHAR(255)
);


-- ============================================================
-- TABLE: rooms
-- Purpose: Store room details and availability status
-- Status values: 'Available', 'Occupied', 'Maintenance'
-- ============================================================
CREATE TABLE IF NOT EXISTS rooms (
    room_id         INT AUTO_INCREMENT PRIMARY KEY,
    room_number     VARCHAR(10)    NOT NULL UNIQUE,
    room_type       VARCHAR(50)    NOT NULL,
    price_per_night DECIMAL(10,2)  NOT NULL,
    status          VARCHAR(20)    NOT NULL DEFAULT 'Available'
);

-- Sample rooms
INSERT INTO rooms (room_number, room_type, price_per_night, status) VALUES
('101', 'Standard',  5500.00,  'Available'),
('102', 'Standard',  5500.00,  'Available'),
('201', 'Deluxe',    9500.00,  'Available'),
('202', 'Deluxe',    9500.00,  'Available'),
('301', 'Suite',    18000.00,  'Available');


-- ============================================================
-- TABLE: reservations
-- Purpose: Store room bookings made by guests
-- Status values: 'Reserved', 'Checked-In', 'Completed', 'Cancelled'
-- ============================================================
CREATE TABLE IF NOT EXISTS reservations (
    reservation_id  INT AUTO_INCREMENT PRIMARY KEY,
    guest_id        INT            NOT NULL,
    room_id         INT            NOT NULL,
    checkin_date    DATE           NOT NULL,
    checkout_date   DATE           NOT NULL,
    total_amount    DECIMAL(10,2)  NOT NULL,
    status          VARCHAR(20)    NOT NULL DEFAULT 'Reserved',
    created_at      TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_reservation_guest FOREIGN KEY (guest_id) REFERENCES guests(guest_id),
    CONSTRAINT fk_reservation_room  FOREIGN KEY (room_id)  REFERENCES rooms(room_id)
);


-- ============================================================
-- TABLE: payments
-- Purpose: Store payment records for reservations
-- Payment methods: 'Cash', 'Card'
-- ============================================================
CREATE TABLE IF NOT EXISTS payments (
    payment_id      INT AUTO_INCREMENT PRIMARY KEY,
    reservation_id  INT            NOT NULL,
    payment_date    DATE           NOT NULL,
    amount          DECIMAL(10,2)  NOT NULL,
    payment_method  VARCHAR(20)    NOT NULL,
    CONSTRAINT fk_payment_reservation FOREIGN KEY (reservation_id) REFERENCES reservations(reservation_id)
);


-- ============================================================
-- Verify setup
-- ============================================================
SELECT 'Database setup complete!' AS status;
SHOW TABLES;