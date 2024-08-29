-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 19 Jul 2024 pada 04.56
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `travelku`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `penumpang`
--

CREATE TABLE `penumpang` (
  `id_penumpang` int(11) NOT NULL,
  `nik` varchar(20) NOT NULL,
  `nama_penumpang` varchar(50) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `email` varchar(20) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `penumpang`
--

INSERT INTO `penumpang` (`id_penumpang`, `nik`, `nama_penumpang`, `jenis_kelamin`, `no_hp`, `email`, `alamat`) VALUES
(1, '32072019989763542', 'Doni Setiawan Wahyono', 'Laki-laki', '085757501928', 'doni@gmail.com', 'Pagaden, Subang'),
(2, '32072010098767544', 'Aji', 'Perempuan', '089776543789', 'putriayu@gmail.com', 'Sukajadi, Bandung Barat Jawa Barat');

--
-- Trigger `penumpang`
--
DELIMITER $$
CREATE TRIGGER `update_transaksi_after_penumpang_update` AFTER UPDATE ON `penumpang` FOR EACH ROW BEGIN
    -- Update kolom-kolom di tabel transaksi sesuai perubahan di tabel penumpang
    UPDATE transaksi t
    SET t.nik = NEW.nik,
        t.nama_penumpang = NEW.nama_penumpang,
        t.jenis_kelamin = NEW.jenis_kelamin,
        t.no_hp = NEW.no_hp
    WHERE t.penumpang_id = NEW.id_penumpang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tiket`
--

CREATE TABLE `tiket` (
  `id_tiket` int(11) NOT NULL,
  `kd_tiket` varchar(15) NOT NULL,
  `jurusan` varchar(100) NOT NULL,
  `harga` int(11) NOT NULL,
  `nama_mobil` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tiket`
--

INSERT INTO `tiket` (`id_tiket`, `kd_tiket`, `jurusan`, `harga`, `nama_mobil`) VALUES
(4, 'TKT001', 'Banjar - Tasikmalaya', 170000, 'Hilux Blck 2020'),
(5, 'TKT002', 'Pangandaran - Cikatomas', 100000, 'Avanza New Born'),
(6, 'TKT003', 'Bandung - Subang', 75000, 'Elf Trayek');

--
-- Trigger `tiket`
--
DELIMITER $$
CREATE TRIGGER `update_transaksi_after_tiket_update` AFTER UPDATE ON `tiket` FOR EACH ROW BEGIN
    -- Update kolom-kolom di tabel transaksi sesuai perubahan di tabel tiket
    UPDATE transaksi t
    SET t.jurusan = NEW.jurusan,
        t.nama_mobil = NEW.nama_mobil,
        t.harga = NEW.harga
    WHERE t.tiket_id = NEW.id_tiket;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `tiket_id` int(11) NOT NULL,
  `penumpang_id` int(11) NOT NULL,
  `tgl_pemesanan` date DEFAULT NULL,
  `tgl_berangkat` date DEFAULT NULL,
  `kd_tiket` varchar(20) NOT NULL,
  `jurusan` varchar(50) NOT NULL,
  `nama_mobil` varchar(50) NOT NULL,
  `harga` int(11) NOT NULL,
  `nik` varchar(20) NOT NULL,
  `nama_penumpang` varchar(50) NOT NULL,
  `jenis_kelamin` varchar(15) NOT NULL,
  `no_hp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `tiket_id`, `penumpang_id`, `tgl_pemesanan`, `tgl_berangkat`, `kd_tiket`, `jurusan`, `nama_mobil`, `harga`, `nik`, `nama_penumpang`, `jenis_kelamin`, `no_hp`) VALUES
(7, 4, 1, '2024-07-18', '2024-07-18', 'TKT002', 'Banjar - Tasikmalaya', 'Hilux Blck 2020', 170000, '32072010098767544', 'Doni Setiawan Wahyono', 'L', '085757501928'),
(8, 4, 2, NULL, NULL, 'TKT001', 'Banjar - Tasikmalaya', 'Hilux Blck 2020', 170000, '32072010098767544', 'Aji', 'P', '089776543789');

--
-- Trigger `transaksi`
--
DELIMITER $$
CREATE TRIGGER `fill_transaksi_details` BEFORE INSERT ON `transaksi` FOR EACH ROW BEGIN
    DECLARE v_jurusan VARCHAR(100);
    DECLARE v_nama_mobil VARCHAR(100);
    DECLARE v_harga INT;
    DECLARE v_nama_penumpang VARCHAR(100);
    DECLARE v_jenis_kelamin CHAR(1);
    DECLARE v_no_hp VARCHAR(15);
    DECLARE v_kd_tiket VARCHAR(50); -- Tambahkan deklarasi untuk kd_tiket
    DECLARE v_nik VARCHAR(20); -- Tambahkan deklarasi untuk nik

    -- Ambil data dari tabel tiket
    SELECT kd_tiket, jurusan, nama_mobil, harga
    INTO v_kd_tiket, v_jurusan, v_nama_mobil, v_harga
    FROM tiket
    WHERE id_tiket = NEW.tiket_id;

    -- Ambil data dari tabel penumpang
    SELECT nik, nama_penumpang, jenis_kelamin, no_hp
    INTO v_nik, v_nama_penumpang, v_jenis_kelamin, v_no_hp
    FROM penumpang
    WHERE id_penumpang = NEW.penumpang_id;

    -- Set nilai kolom di tabel transaksi
    SET NEW.kd_tiket = v_kd_tiket; -- Set kd_tiket
    SET NEW.jurusan = v_jurusan;
    SET NEW.nama_mobil = v_nama_mobil;
    SET NEW.harga = v_harga;
    SET NEW.nik = v_nik; -- Set nik
    SET NEW.nama_penumpang = v_nama_penumpang;
    SET NEW.jenis_kelamin = v_jenis_kelamin;
    SET NEW.no_hp = v_no_hp;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `no_hp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `nama`, `no_hp`) VALUES
(7, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Doni Wahyono', '085217208543'),
(8, 'fadhil', '38192ce03916b5981a68e8afd651a0e2', 'Fadhil Najmi Syafarian', '082121661839'),
(9, 'restu', 'de9ce4ee35f378f6d801a3820855f1cd', 'Restu Alfina Rahayu', '081213345778');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `penumpang`
--
ALTER TABLE `penumpang`
  ADD PRIMARY KEY (`id_penumpang`);

--
-- Indeks untuk tabel `tiket`
--
ALTER TABLE `tiket`
  ADD PRIMARY KEY (`id_tiket`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `fk_penumpang_id` (`penumpang_id`),
  ADD KEY `fk_tiket_id` (`tiket_id`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `penumpang`
--
ALTER TABLE `penumpang`
  MODIFY `id_penumpang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `tiket`
--
ALTER TABLE `tiket`
  MODIFY `id_tiket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `fk_penumpang_id` FOREIGN KEY (`penumpang_id`) REFERENCES `penumpang` (`id_penumpang`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_tiket_id` FOREIGN KEY (`tiket_id`) REFERENCES `tiket` (`id_tiket`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
