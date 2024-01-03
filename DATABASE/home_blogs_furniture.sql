-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 03, 2024 lúc 04:52 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `home_blogs_furniture`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `blogs`
--

CREATE TABLE `blogs` (
  `id_blog` int(11) NOT NULL,
  `blog_title` varchar(255) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_date` datetime(6) DEFAULT NULL,
  `id_category` int(11) DEFAULT NULL,
  `short_content` varchar(255) DEFAULT NULL,
  `blog_avatar` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `blogs`
--

INSERT INTO `blogs` (`id_blog`, `blog_title`, `content`, `create_by`, `create_date`, `status`, `update_by`, `update_date`, `id_category`, `short_content`, `blog_avatar`) VALUES
(1, 'bai viet thu 1', 'day la bai viet thu 1 demo', 'vy', '2023-11-23 14:52:18.000000', 1, '1', '2023-11-23 10:26:08.000000', 3, 'day la short content thu 1 demo', '1.jpg'),
(3, 'bai viet thu 2', 'day la bai viet thu 2 demo', 'vy', '2023-11-23 14:52:18.000000', 1, '1', '2023-11-23 10:26:08.000000', 4, 'day la short content thu 2 demo', '2.jpg'),
(5, 'bai viet thu 4', 'day la bai viet thu 4 demo', 'vy', '2023-11-23 14:52:18.000000', 1, '1', '2023-11-23 10:26:08.000000', 3, 'day la short content thu 3 demo', '3.jpg'),
(6, 'bai viet thu 5', 'day la bai viet thu 5 demo', 'vy', '2023-11-23 14:52:18.000000', 1, '1', '2023-11-23 10:26:08.000000', 1, 'day la short content thu 4 demo', '4.jpg'),
(7, 'bai viet thu test 1', 'day la bai viet thu 1 demo', 'vy', '2023-11-23 14:52:18.000000', 1, '1', '2023-11-23 10:26:08.000000', 3, 'day la short content thu 1 demo', '1.jpg'),
(8, 'bai viet thu test 2', 'day la bai viet thu 4 demo', 'vy', '2023-11-23 14:52:18.000000', 1, '1', '2023-11-23 10:26:08.000000', 3, 'day la short content thu 3 demo', '3.jpg'),
(9, 'bai viet thu test 3', 'day la bai viet thu 1 demo', 'vy', '2023-11-23 14:52:18.000000', 1, '1', '2023-11-23 10:26:08.000000', 3, 'day la short content thu 1 demo', '1.jpg'),
(10, 'bai viet thu test 4', 'day la bai viet thu 4 demo', 'vy', '2023-11-23 14:52:18.000000', 1, '1', '2023-11-23 10:26:08.000000', 3, 'day la short content thu 3 demo', '3.jpg'),
(11, 'bai viet thu test 5', 'day la bai viet thu 1 demo', 'vy', '2023-11-23 14:52:18.000000', 1, '1', '2023-11-23 10:26:08.000000', 3, 'day la short content thu 1 demo', '1.jpg'),
(12, 'bai viet thu test 6', 'day la bai viet thu 4 demo', 'vy', '2023-11-23 14:52:18.000000', 1, '1', '2023-11-23 10:26:08.000000', 3, 'day la short content thu 3 demo', '3.jpg'),
(13, 'bai viet thu test 7', 'day la bai viet thu 1 demo', 'vy', '2023-11-23 14:52:18.000000', 1, '1', '2023-11-23 10:26:08.000000', 3, 'day la short content thu 1 demo', '1.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories_blog`
--

CREATE TABLE `categories_blog` (
  `id_category` int(11) NOT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_date` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `categories_blog`
--

INSERT INTO `categories_blog` (`id_category`, `category_name`, `create_by`, `create_date`, `status`, `update_by`, `update_date`) VALUES
(1, 'Table', 'Vy', '2023-11-23 10:26:08.000000', 1, 'Vy', '2023-11-23 10:26:08.000000'),
(2, 'Lamp', 'Vy', '2023-11-23 10:26:08.000000', 0, 'Vy', '2023-11-23 10:26:08.000000'),
(3, 'Chair', 'Vy', '2023-11-23 10:26:08.000000', 1, 'Vy', '2023-11-23 10:26:08.000000'),
(4, 'Window', 'Vy', '2023-11-23 10:26:08.000000', 1, 'Vy', '2023-11-23 10:26:08.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `comment_blog`
--

CREATE TABLE `comment_blog` (
  `id_comment` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_blog` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_date` datetime(6) DEFAULT NULL,
  `id_room` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `comment_blog`
--

INSERT INTO `comment_blog` (`id_comment`, `content`, `create_by`, `create_date`, `id_user`, `id_blog`, `status`, `update_by`, `update_date`, `id_room`) VALUES
(1, 'hay', 'vy', '2023-12-04 14:16:40.000000', 1, 1, 1, 'Vy', '2023-12-04 14:16:40.000000', NULL),
(2, 'do', 'vy', '2023-12-04 14:16:40.000000', 1, 1, 1, 'Vy', '2023-12-04 14:16:40.000000', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cooperate_blog_tag`
--

CREATE TABLE `cooperate_blog_tag` (
  `id_cooperate` int(11) NOT NULL,
  `id_blog` int(11) NOT NULL,
  `id_tag` int(11) NOT NULL,
  `create_by` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_by` varchar(255) NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `cooperate_blog_tag`
--

INSERT INTO `cooperate_blog_tag` (`id_cooperate`, `id_blog`, `id_tag`, `create_by`, `create_date`, `update_by`, `update_date`) VALUES
(1, 1, 1, 'vy', '2023-12-06 08:17:59', 'vy', '2023-12-06 08:17:59'),
(2, 1, 2, '', '2023-12-06 08:19:13', '', '2023-12-06 08:19:13'),
(3, 5, 3, '', '2023-12-06 08:20:06', '', '2023-12-06 08:20:06'),
(4, 6, 3, '', '2023-12-06 08:20:48', '', '2023-12-06 08:20:48');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `rating`
--

CREATE TABLE `rating` (
  `id_rating` int(11) NOT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_date` datetime(6) DEFAULT NULL,
  `id_blog` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tag_blog`
--

CREATE TABLE `tag_blog` (
  `id_tag` int(11) NOT NULL,
  `tag_name` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_date` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tag_blog`
--

INSERT INTO `tag_blog` (`id_tag`, `tag_name`, `status`, `create_by`, `create_date`, `update_by`, `update_date`) VALUES
(1, 'Hot', 1, 'Vy', '2023-12-05 09:20:37.000000', 'Vy', '2023-12-05 09:20:37.000000'),
(2, 'Hot Chair', 1, 'Vy', '2023-12-05 09:20:37.000000', 'Vy', '2023-12-05 09:20:37.000000'),
(3, 'Hot Lamp', 1, 'Vy', '2023-12-05 09:20:37.000000', 'Vy', '2023-12-05 09:20:37.000000'),
(4, 'Hot Design', 1, 'Vy', '2023-12-05 09:20:37.000000', 'Vy', '2023-12-05 09:20:37.000000'),
(5, 'Trend', 1, 'Vy', '2023-12-05 09:20:37.000000', 'Vy', '2023-12-05 09:20:37.000000'),
(6, 'Room', 1, 'Vy', '2023-12-05 09:20:37.000000', 'Vy', '2023-12-05 09:20:37.000000'),
(7, 'Kitchen', 1, 'Vy', '2023-12-05 09:20:37.000000', 'Vy', '2023-12-05 09:20:37.000000');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `blogs`
--
ALTER TABLE `blogs`
  ADD PRIMARY KEY (`id_blog`),
  ADD KEY `blogs_category` (`id_category`);

--
-- Chỉ mục cho bảng `categories_blog`
--
ALTER TABLE `categories_blog`
  ADD PRIMARY KEY (`id_category`);

--
-- Chỉ mục cho bảng `comment_blog`
--
ALTER TABLE `comment_blog`
  ADD PRIMARY KEY (`id_comment`),
  ADD UNIQUE KEY `UK_8fib0e0ee67fkh3iviqxjnstt` (`id_room`),
  ADD KEY `comment_blog` (`id_blog`);

--
-- Chỉ mục cho bảng `cooperate_blog_tag`
--
ALTER TABLE `cooperate_blog_tag`
  ADD PRIMARY KEY (`id_cooperate`),
  ADD KEY `cooperate_blog` (`id_blog`),
  ADD KEY `cooperate_tag` (`id_tag`);

--
-- Chỉ mục cho bảng `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`id_rating`),
  ADD UNIQUE KEY `UK_k3kbt434v8p8agqrtml9vq257` (`id_blog`);

--
-- Chỉ mục cho bảng `tag_blog`
--
ALTER TABLE `tag_blog`
  ADD PRIMARY KEY (`id_tag`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `blogs`
--
ALTER TABLE `blogs`
  MODIFY `id_blog` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT cho bảng `categories_blog`
--
ALTER TABLE `categories_blog`
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `comment_blog`
--
ALTER TABLE `comment_blog`
  MODIFY `id_comment` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `cooperate_blog_tag`
--
ALTER TABLE `cooperate_blog_tag`
  MODIFY `id_cooperate` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `rating`
--
ALTER TABLE `rating`
  MODIFY `id_rating` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `tag_blog`
--
ALTER TABLE `tag_blog`
  MODIFY `id_tag` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `blogs`
--
ALTER TABLE `blogs`
  ADD CONSTRAINT `blogs_category` FOREIGN KEY (`id_category`) REFERENCES `categories_blog` (`id_category`);

--
-- Các ràng buộc cho bảng `comment_blog`
--
ALTER TABLE `comment_blog`
  ADD CONSTRAINT `FKc3oopsq9xfa3ru99kuc8u4m7t` FOREIGN KEY (`id_room`) REFERENCES `blogs` (`id_blog`),
  ADD CONSTRAINT `comment_blog` FOREIGN KEY (`id_blog`) REFERENCES `blogs` (`id_blog`);

--
-- Các ràng buộc cho bảng `cooperate_blog_tag`
--
ALTER TABLE `cooperate_blog_tag`
  ADD CONSTRAINT `cooperate_blog` FOREIGN KEY (`id_blog`) REFERENCES `blogs` (`id_blog`),
  ADD CONSTRAINT `cooperate_tag` FOREIGN KEY (`id_tag`) REFERENCES `tag_blog` (`id_tag`);

--
-- Các ràng buộc cho bảng `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `FK3aurx2iswt5c7blt0topx8g86` FOREIGN KEY (`id_blog`) REFERENCES `blogs` (`id_blog`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
