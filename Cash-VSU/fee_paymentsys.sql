-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 18, 2022 at 12:27 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fee_paymentsys`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_fee_list`
--

CREATE TABLE `tbl_fee_list` (
  `FeeCode` varchar(50) NOT NULL,
  `StudentNum` int(9) NOT NULL,
  `Category` varchar(50) NOT NULL,
  `Amount` decimal(13,2) NOT NULL,
  `DueDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_fee_list`
--

INSERT INTO `tbl_fee_list` (`FeeCode`, `StudentNum`, `Category`, `Amount`, `DueDate`) VALUES
('MED0001', 202013958, 'Medical', '300.00', '2022-06-17'),
('MED0002', 202013500, 'Medical', '400.00', '2022-06-24'),
('TUI3898', 202210540, 'Tuition', '5000.00', '2022-06-22');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pending`
--

CREATE TABLE `tbl_pending` (
  `PendingId` int(11) NOT NULL,
  `FeeCode` varchar(50) NOT NULL,
  `DateRequested` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `StudentNum` int(9) NOT NULL,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `MiddleName` varchar(255) NOT NULL,
  `Age` int(11) NOT NULL,
  `Course` varchar(255) NOT NULL,
  `Section` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`StudentNum`, `FirstName`, `LastName`, `MiddleName`, `Age`, `Course`, `Section`, `Email`, `Password`) VALUES
(202013500, 'Sofia', 'Carisma', 'Lopez', 20, 'BSBM', '2-1', 'sofiacarisma@email.com', 'EF797C8118F02DFB649607DD5D3F8C7623048C9C063D532CC95C5ED7A898A64F'),
(202013958, 'Micha', 'Caldaira', 'Seballos', 19, 'BSCS', '2-5', 'micha.caldaira@cvsu.edu.ph', 'EF797C8118F02DFB649607DD5D3F8C7623048C9C063D532CC95C5ED7A898A64F'),
(202210540, 'Ian', 'Polon', 'Tanael', 20, 'BSIT', '1-3', 'ian@gmail.com', 'EF797C8118F02DFB649607DD5D3F8C7623048C9C063D532CC95C5ED7A898A64F');

-- --------------------------------------------------------

--
-- Table structure for table `transaction_history`
--

CREATE TABLE `transaction_history` (
  `TransactionID` int(11) NOT NULL,
  `FeeCode` varchar(50) NOT NULL,
  `StudentNum` int(9) NOT NULL,
  `Category` varchar(50) NOT NULL,
  `Amount` decimal(13,2) NOT NULL,
  `DueDate` date NOT NULL,
  `DatePaid` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction_history`
--

INSERT INTO `transaction_history` (`TransactionID`, `FeeCode`, `StudentNum`, `Category`, `Amount`, `DueDate`, `DatePaid`) VALUES
(4, 'LAB1298', 202013958, 'Laboratory', '600.00', '2022-06-08', '2022-05-29'),
(9, 'LAB1200', 202210540, 'Laboratory', '600.00', '2022-06-01', '2022-06-04'),
(10, 'TUI0001', 202013958, 'Tuition', '5850.00', '2022-06-17', '2022-06-06'),
(11, 'MED1301', 202210540, 'Medical', '300.00', '2022-06-01', '2022-06-08'),
(13, 'MED3218', 202210540, 'Medical', '300.00', '2022-06-24', '2022-06-18');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_fee_list`
--
ALTER TABLE `tbl_fee_list`
  ADD PRIMARY KEY (`FeeCode`),
  ADD KEY `StudentNum` (`StudentNum`);

--
-- Indexes for table `tbl_pending`
--
ALTER TABLE `tbl_pending`
  ADD PRIMARY KEY (`PendingId`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`StudentNum`);

--
-- Indexes for table `transaction_history`
--
ALTER TABLE `transaction_history`
  ADD PRIMARY KEY (`TransactionID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_pending`
--
ALTER TABLE `tbl_pending`
  MODIFY `PendingId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `transaction_history`
--
ALTER TABLE `transaction_history`
  MODIFY `TransactionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_fee_list`
--
ALTER TABLE `tbl_fee_list`
  ADD CONSTRAINT `tbl_fee_list_ibfk_1` FOREIGN KEY (`StudentNum`) REFERENCES `tbl_user` (`StudentNum`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
