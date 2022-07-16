-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 30, 2022 at 07:44 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wetravel`
--

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(160) NOT NULL,
  `capacity` int(11) NOT NULL,
  `date` date NOT NULL,
  `adresse` varchar(160) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `pays` varchar(50) NOT NULL,
  `image` varchar(190) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`id`, `name`, `capacity`, `date`, `adresse`, `ville`, `pays`, `image`) VALUES
(1, 'Songkran Festival', 500, '2022-06-26', 'Chiang Mai', 'Khon Kaen', 'Thailande', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\Songkran Festival.PNG'),
(2, 'Rio Carnival', 265, '2022-06-26', 'Rio de Janeiro', 'Rio de Janeiro', 'Brésil', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\Rio Carnival.PNG'),
(3, 'Queen\'s Day', 900, '2022-06-26', 'Amsterdam', 'Amsterdam', 'Pays-Bas', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\Queen\'s Day.PNG'),
(4, 'Gamescom', 600, '2022-06-26', 'Kolnmesse', 'Kolnmesse', 'Allemagne', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\Gamescom.PNG'),
(5, 'Chinese New Year', 1200, '2022-06-26', 'hong kong', 'hong kong', 'China', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\Chinese New Year.PNG'),
(6, 'Party', 120, '2022-06-30', 'beach', 'gabes', 'Tunise', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\Rio Carnival.PNG');

-- --------------------------------------------------------

--
-- Table structure for table `hotels`
--

CREATE TABLE `hotels` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) NOT NULL,
  `stars` int(11) NOT NULL,
  `capacity` int(11) NOT NULL,
  `adresse` varchar(160) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `pays` varchar(50) NOT NULL,
  `image` varchar(190) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hotels`
--

INSERT INTO `hotels` (`id`, `name`, `stars`, `capacity`, `adresse`, `ville`, `pays`, `image`) VALUES
(1, 'el mouradi', 4, 100, 'elmouradi@Sousse.com', 'Sousse', 'Tunisie', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\el mouradi.PNG'),
(2, 'Capella Bangkok', 300, 5, '300, 2 Charoen Krung Rd', 'Sathon', 'Thaïlande', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\Capella Bangkok.PNG'),
(3, 'Mahali Mzuri', 400, 4, 'Motorogi Conservancy Masai Mara', 'Motorogi', 'Kenya', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\Mahali Mzuri.PNG'),
(4, 'Nayara Tented Camp', 450, 5, 'de, Alajuela Province', 'La Fortuna', 'Costa Rica', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\Nayara Tented Camp.PNG'),
(5, 'The Opposite House', 200, 4, 'Building 1 No 11 Sanlitun Road Chaoyang, Sanlitun Road', 'Beijing', 'Chine', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\The Opposite House.PNG'),
(6, 'Seabel Rym Beach', 0, 3, 'Tunisie, Jerba', 'Jerba', 'Tunisie', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\Seabel Rym Beach.PNG');

-- --------------------------------------------------------

--
-- Table structure for table `menu_categories`
--

CREATE TABLE `menu_categories` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(160) NOT NULL,
  `restaurant_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `produits`
--

CREATE TABLE `produits` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(160) NOT NULL,
  `menu_category_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `reservations`
--

CREATE TABLE `reservations` (
  `id` int(10) UNSIGNED NOT NULL,
  `date` date NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  `restaurant_id` int(11) UNSIGNED NOT NULL,
  `hotel_id` int(11) UNSIGNED NOT NULL,
  `event_id` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `restaurants`
--

CREATE TABLE `restaurants` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(160) NOT NULL,
  `capacity` int(11) NOT NULL,
  `adresse` varchar(160) NOT NULL,
  `ville` varchar(160) NOT NULL,
  `pays` varchar(160) NOT NULL,
  `image` varchar(190) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restaurants`
--

INSERT INTO `restaurants` (`id`, `name`, `capacity`, `adresse`, `ville`, `pays`, `image`) VALUES
(1, 'via mercato', 70, 'Lac 2', 'Tunis', 'Tunisie', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\via mercato.PNG'),
(2, 'Good Food', 60, 'Lac 1', 'Tunis', 'Tunisie', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\Good Food.PNG'),
(3, 'New Food', 50, 'Lac 1', 'Tunis', 'Tunisie', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\New Food.PNG'),
(4, 'Asador Etxebarri', 100, 'San Juan Plaza', 'Bizkaia', 'Espagne', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\Asador Etxebarri.PNG'),
(5, 'Geranium', 80, 'Per Henrik Lings Allé 4', 'Kobenhavn', 'Danemark', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\Geranium.PNG'),
(6, 'Noma', 90, 'Refshalevej 96', 'Kobenhavn', 'Danemark', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\Noma.PNG'),
(7, 'Tunis', 0, 'Kram', 'Tunisie', 'dar el ikram', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Java\\src\\assets\\dar el ikram.PNG');

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `id` int(10) UNSIGNED NOT NULL,
  `content` varchar(191) NOT NULL,
  `rating` int(11) NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  `event_id` int(10) UNSIGNED NOT NULL,
  `hotel_id` int(10) UNSIGNED NOT NULL,
  `restaurant_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(160) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  `image` varchar(190) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `phone`, `email`, `password`, `role`, `image`) VALUES
(1, 'Mohamed', '22001002', 'moihamed@wetravel.com', 'mohamed123', 'ADMIN', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Web_Esprit\\assets\\images\\album2.PNG'),
(2, 'test', '123456', 'test@gmail.com', 'test', 'ADMIN', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Web_Esprit\\assets\\images\\party.PNG'),
(3, 'hama', '123123', 'hama@hama.com', 'hama', 'CLIENT', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Web_Esprit\\assets\\images\\party.PNG'),
(4, 'hama', '123456', 'hama@test.com', 'hama', 'CLIENT', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Web_Esprit\\assets\\images\\album2.PNG'),
(5, 'hama', '22222222', 'hama63591@gmail.com', 'hama', 'CLIENT', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Web_Esprit\\assets\\images\\party.PNG'),
(6, 'hama', '789564132', 'hama63591@gmail.com', '123456', 'CLIENT', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Web_Esprit\\assets\\images\\album2.PNG'),
(7, 'test', '798465', 'test@gmail.com', '123456', 'CLIENT', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Web_Esprit\\assets\\images\\party.PNG'),
(8, 'Adel', '465132', 'adel@gmail.com', '123', 'ADMIN', 'C:\\Users\\Hamza Taoujouti\\Desktop\\Web_Esprit\\assets\\images\\album6.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hotels`
--
ALTER TABLE `hotels`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menu_categories`
--
ALTER TABLE `menu_categories`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_restaurant_id` (`restaurant_id`);

--
-- Indexes for table `produits`
--
ALTER TABLE `produits`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_produits_menu` (`menu_category_id`);

--
-- Indexes for table `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_reservation_user` (`user_id`),
  ADD KEY `fk_reservation_hotel` (`hotel_id`),
  ADD KEY `fk_reservation_event` (`event_id`),
  ADD KEY `fk_reservation_restaurant` (`restaurant_id`);

--
-- Indexes for table `restaurants`
--
ALTER TABLE `restaurants`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_review_user` (`user_id`),
  ADD KEY `fk_review_hotel` (`hotel_id`),
  ADD KEY `fk_review_event` (`event_id`),
  ADD KEY `fk_review_restaurant` (`restaurant_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `hotels`
--
ALTER TABLE `hotels`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `menu_categories`
--
ALTER TABLE `menu_categories`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `produits`
--
ALTER TABLE `produits`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reservations`
--
ALTER TABLE `reservations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `restaurants`
--
ALTER TABLE `restaurants`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `menu_categories`
--
ALTER TABLE `menu_categories`
  ADD CONSTRAINT `FK_restaurant_id` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `produits`
--
ALTER TABLE `produits`
  ADD CONSTRAINT `fk_produits_menu` FOREIGN KEY (`menu_category_id`) REFERENCES `menu_categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `fk_reservation_event` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_reservation_hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_reservation_restaurant` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_reservation_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `fk_review_event` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_review_hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_review_restaurant` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_review_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
