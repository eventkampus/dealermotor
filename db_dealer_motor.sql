-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 13 Jun 2021 pada 09.09
-- Versi server: 10.4.19-MariaDB
-- Versi PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_dealer_motor`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_motor`
--

CREATE TABLE `tb_motor` (
  `kodemotor` varchar(50) NOT NULL,
  `namamotor` varchar(50) NOT NULL,
  `jumlahmotor` int(50) NOT NULL,
  `tanggalmasuk` date NOT NULL,
  `bataspenjualan` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_motor`
--

INSERT INTO `tb_motor` (`kodemotor`, `namamotor`, `jumlahmotor`, `tanggalmasuk`, `bataspenjualan`) VALUES
('DM001', 'VARIO', 14, '2021-01-10', '2025-01-10'),
('DM002', 'SUPRA', 16, '2021-04-26', '2023-04-26'),
('DM003', 'JUPITER', 29, '2021-03-12', '2026-03-12'),
('DM005', 'NINJA', 19, '2021-05-29', '2027-05-29');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_motor`
--
ALTER TABLE `tb_motor`
  ADD PRIMARY KEY (`kodemotor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
