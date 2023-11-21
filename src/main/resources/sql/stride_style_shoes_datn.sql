-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 21, 2023 lúc 11:31 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `stride_style_shoes_datn`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `create_at` date DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `down_total` double DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `note_refund` varchar(2000) DEFAULT NULL,
  `payment` bit(1) DEFAULT NULL,
  `refund` int(11) DEFAULT NULL,
  `sale_point` varchar(255) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `status_shipping` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `transport_fee` double DEFAULT NULL,
  `update_ats` date DEFAULT NULL,
  `voucher_id` bigint(20) DEFAULT NULL,
  `id_customer` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `bill`
--

INSERT INTO `bill` (`id`, `address`, `create_at`, `discount`, `down_total`, `full_name`, `is_delete`, `note`, `note_refund`, `payment`, `refund`, `sale_point`, `sdt`, `status_shipping`, `total`, `transport_fee`, `update_ats`, `voucher_id`, `id_customer`) VALUES
(234543, 'Mộc Châu', '2023-11-18', 500000, NULL, 'Kiên Ngu', b'0', 'Mua Online', NULL, b'1', NULL, '100', '0867621485', 1, 4900000, 200000, NULL, 2, 3),
(567854, 'Hà Nội', '2023-11-18', 100000, NULL, 'Phạm Anh Tú', b'0', 'Mua Online', NULL, b'1', NULL, '100', '0338583502', 0, 2929000, 200000, NULL, 1, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `gender` bit(1) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `gender`, `is_delete`, `name`) VALUES
(1, b'0', b'0', 'Giày Nam'),
(2, b'1', b'0', 'Giày Nữ'),
(3, b'0', b'0', 'Unisex');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `id_user` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`id`, `address`, `email`, `full_name`, `is_delete`, `phone`, `id_user`) VALUES
(1, 'Tiểu khu 64 thị trấn nông trường Mộc Châu Sơn La', 'tupaph13622@fpt.edu.vn', 'Phạm Anh Tú', b'0', '0338583502', NULL),
(2, 'Hà Nội', 'kienntph13809@fpt.edu.vn', 'Nguyễn Trung Kiên', b'0', '0867621485', NULL),
(3, 'Hà Nội ', 'phamanhtu132002@gmail.com', 'Phạm Anh Tú', b'0', '0397596018', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `event`
--

CREATE TABLE `event` (
  `id_event` bigint(20) NOT NULL,
  `end_day` date DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_day` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `event`
--

INSERT INTO `event` (`id_event`, `end_day`, `is_delete`, `name`, `start_day`) VALUES
(1, '2023-12-30', b'0', 'giảm giá cho khách hàng mới', '2023-11-16'),
(2, '2023-12-13', b'0', 'giảm giá', '2023-11-16');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `image`
--

CREATE TABLE `image` (
  `id` bigint(20) NOT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `id_account` bigint(20) DEFAULT NULL,
  `id_product` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `image`
--

INSERT INTO `image` (`id`, `is_delete`, `name`, `url`, `id_account`, `id_product`) VALUES
(1, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/00375837-849f-4f17-ba24-d201d27be49b/air-force-1-07-shoes-WrLlWX.png', 1, 1),
(2, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/3cc96f43-47b6-43cb-951d-d8f73bb2f912/air-force-1-07-shoes-WrLlWX.png', 1, 1),
(3, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/33533fe2-1157-4001-896e-1803b30659c8/air-force-1-07-shoes-WrLlWX.png', 1, 1),
(4, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/a0a300da-2e16-4483-ba64-9815cf0598ac/air-force-1-07-shoes-WrLlWX.png', 1, 1),
(5, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/120a31b0-efa7-41c7-9a84-87b1e56ab9c3/air-force-1-07-shoes-WrLlWX.png', 1, 1),
(6, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/1c1e5f55-99c2-4522-b398-2352e01ba566/air-force-1-07-shoes-WrLlWX.png', 1, 1),
(7, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/021d4cdb-916f-4fde-940b-04fdb736530c/air-max-excee-shoe-lPbXqt.png', 1, 2),
(8, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/3b9f4e47-9275-4b13-81b4-340dc55ddb43/air-max-excee-shoe-lPbXqt.png', 1, 2),
(9, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/22e3a2d3-e6b7-4083-99ed-738491d5e228/air-max-excee-shoe-lPbXqt.png', 1, 2),
(10, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/f2015476-6a8f-4575-80d5-5b006a94e084/air-max-excee-shoe-lPbXqt.png', 1, 2),
(11, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/59d7825e-f362-4776-ac4a-eeb9086c0772/air-max-excee-shoe-lPbXqt.png', 1, 2),
(12, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/bf143af6-e270-4514-b161-a5540a90cb53/air-max-excee-shoe-lPbXqt.png', 1, 2),
(13, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/3d926f26-ebb9-4270-88e3-d97a5184904d/air-max-excee-shoe-lPbXqt.png', 1, 2),
(14, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/308e9d66-7c75-4370-868c-5462835744d5/air-max-pulse-shoes-zD62r3.png', 1, 3),
(15, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/c2a25c9f-9455-43e0-ade7-dc92730e419a/air-max-pulse-shoes-zD62r3.png', 1, 3),
(16, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/23fce8c3-e5f7-47ed-94d9-b5ac371321f9/air-max-pulse-shoes-zD62r3.png', 1, 3),
(17, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/2034d827-001e-4353-beca-2e2cb5676e55/air-max-pulse-shoes-zD62r3.png', 1, 3),
(18, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/1ee5d2f9-2b4d-4919-8719-d87e7529812f/air-max-pulse-shoes-zD62r3.png', 1, 3),
(19, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/3b6ef4ca-216c-4a73-beb7-601bb6a3d1db/air-max-pulse-shoes-zD62r3.png', 1, 3),
(20, b'0', 'Giày Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/8c8601af-42f2-4008-9e99-2502c7cf8d78/air-max-pulse-shoes-zD62r3.png', 1, 3),
(21, NULL, 'giày nike', NULL, 1, 21),
(22, b'0', 'sp1700216540982280956974_1131457350764085_7593548632116725276_n.jpg', 'http://localhost:8080/manager/image/get/sp1700216540982280956974_1131457350764085_7593548632116725276_n.jpg', NULL, 21);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderdetail`
--

CREATE TABLE `orderdetail` (
  `id` bigint(20) NOT NULL,
  `down_price` double DEFAULT NULL,
  `into_money` double DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity_oder` bigint(20) DEFAULT NULL,
  `id_bill` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `orderdetail`
--

INSERT INTO `orderdetail` (`id`, `down_price`, `into_money`, `is_delete`, `price`, `quantity_oder`, `id_bill`, `product_id`) VALUES
(1, 100000, 2829000, b'0', 2929000, 1, 567854, 1),
(2, 300000, 2149000, b'0', 2649000, 1, 567854, 2),
(3, 2000000, 2903000, b'0', 28767474, 2, 234543, 5),
(4, 2345234, 23423424, b'0', 512313132, 5, 234543, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `date_create` date DEFAULT NULL,
  `date_update` date DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `description_detail` varchar(5000) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `name_product` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `id_category` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `date_create`, `date_update`, `description`, `description_detail`, `discount`, `image`, `is_delete`, `name_product`, `price`, `status`, `id_category`) VALUES
(1, '2023-11-16', NULL, 'Sự rạng rỡ vẫn tồn tại trong Nike Air Force 1 \'07, phiên bản bóng rổ nguyên bản mang đến sự thay đổi mới mẻ về những gì bạn biết rõ nhất: lớp phủ được khâu bền, lớp hoàn thiện gọn gàng và lượng đèn flash hoàn hảo giúp bạn tỏa sáng.', 'Thông tin chi tiết sản phẩm\r\n\r\nĐế giữa xốp\r\nCác vết thủng ở ngón chân\r\nĐế cao su\r\nMàu sắc hiển thị: Trắng/Trắng\r\nPhong cách: CW2288-111\r\nQuốc gia/Khu vực xuất xứ: Việt Nam, Ấn Độ\r\n\r\nNguồn gốc của lực lượng không quân 1\r\n\r\nRa mắt lần đầu tiên vào năm 1982, AF-1 là đôi giày bóng rổ đầu tiên có Nike Air, tạo nên một cuộc cách mạng trong môn thể thao này đồng thời nhanh chóng thu hút được sự chú ý trên toàn thế giới. Ngày nay, Air Force 1 vẫn giữ nguyên nguồn gốc của nó với lớp đệm mềm mại và đàn hồi đã làm thay đổi lịch sử giày thể thao.', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/b7d9211c-26e7-431a-ac24-b0540fb3c00f/air-force-1-07-shoes-WrLlWX.png', b'0', 'Nike Air Force 1 \'07', 2929000, 'còn hàng', 1),
(2, '2023-11-16', NULL, 'Lấy cảm hứng từ Nike Air Max 90, Nike Air Max Excee là sự tôn vinh nét cổ điển qua lăng kính mới. Những đường nét thon dài và tỷ lệ méo mó ở phía trên mang lại diện mạo của thập niên 90 mà bạn yêu thích trong một không gian mới, hiện đại.', 'Thông tin chi tiết sản phẩm\r\n\r\nMặt trên bằng lưới, da và da lộn với lớp phủ bằng da tổng hợp\r\nKhông nhằm mục đích sử dụng làm Thiết bị bảo hộ cá nhân (PPE)\r\nMàu sắc hiển thị: Trắng/Phantom/Nho hành động/Đen\r\nPhong cách: CD4165-118\r\nQuốc gia/Khu vực xuất xứ: Việt Nam\r\n\r\nNguồn gốc Nike Air Max\r\n\r\nCông nghệ Revolution Air lần đầu tiên được đưa vào giày Nike vào năm 1978. Năm 1987, Air Max 1 ra mắt với công nghệ Air có thể nhìn thấy ở gót chân, mang đến cho người hâm mộ nhiều thứ hơn là chỉ cảm nhận về đệm Air—đột nhiên họ có thể nhìn thấy nó. Kể từ đó, giày Air Max thế hệ tiếp theo đã trở thành điểm nhấn với các vận động viên và nhà sưu tập nhờ mang đến sự kết hợp màu sắc nổi bật và lớp đệm nhẹ, đáng tin cậy.', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/5b0e2877-09a4-4cad-8459-9118a5bc4c4f/air-max-excee-shoe-lPbXqt.png', b'0', 'Nike Air Max Excee', 2649000, 'còn hàng', 3),
(3, '2023-11-16', NULL, 'Pha trộn một phần thành thị với một phần cứng cáp, Air Max Pulse mang đến vẻ ngoài tràn đầy năng lượng cho dòng Air Max mang tính biểu tượng. Nó kết hợp đế giữa được bọc bằng vải và các điểm nhấn kín chân không để nâng cao uy tín trên đường phố. Đệm Nike Air chịu tải điểm—được cải tiến từ Air Max 270 vô cùng sang trọng—mang đến sự thoải mái mà bạn tin tưởng. Hãy mặc chúng với bộ trang phục đẹp nhất của bạn và đạt đến mức tối đa.', 'Thông tin chi tiết sản phẩm\r\n\r\nChi tiết thiết kế phản quang\r\nKhông nhằm mục đích sử dụng làm thiết bị bảo hộ cá nhân (PPE)\r\nMàu sắc hiển thị: Đen/Antraxit/Vàng phẳng/Vàng kim loại\r\nPhong cách: FQ8733-010\r\nQuốc gia/Khu vực xuất xứ: Việt Nam\r\n\r\nNguồn gốc Nike Air Max\r\n\r\nCông nghệ Revolution Air lần đầu tiên được đưa vào giày Nike vào năm 1978. Năm 1987, Air Max 1 ra mắt với công nghệ Air có thể nhìn thấy ở gót chân, mang đến cho người hâm mộ nhiều thứ hơn là chỉ cảm nhận về đệm Air—đột nhiên họ có thể nhìn thấy nó. Kể từ đó, giày Air Max thế hệ tiếp theo đã trở thành điểm nhấn với các vận động viên và nhà sưu tập nhờ mang đến sự kết hợp màu sắc nổi bật và lớp đệm nhẹ, đáng tin cậy.', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/0f97608e-ff07-4aff-b338-f86c28ecff8c/air-max-pulse-shoes-zD62r3.png', b'0', 'Nike Air Max Pulse', 4409000, 'còn hàng', 3),
(4, '2023-11-16', NULL, 'Gặp gỡ người lãnh đạo của gói. Đi trên những đám mây phía trên tiếng ồn, Air Max 1 kết hợp thiết kế vượt thời gian với sự thoải mái có đệm. Với kiểu dáng nhanh nhẹn, tấm chắn bùn gợn sóng và Nike Air, biểu tượng cổ điển này xuất hiện vào năm 1987 và tiếp tục là linh hồn của thương hiệu này cho đến ngày nay.', 'Không khí tối đa 1\r\n\r\nChắc chắn, Air Max 1 khởi đầu là một đôi giày chạy bộ, nhưng bạn không thể kìm hãm sự đổi mới. Được tiếp nhận bởi văn hóa hip-hop, người chạy bộ này với bộ phận Air gây tranh cãi có thể được tìm thấy ở bất cứ đâu từ trung tâm Brooklyn đến đường phố London. Thiết kế tiên tiến và màu sắc nổi bật của nó cho đến ngày nay vẫn được tôn vinh năm này qua năm khác.', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/f55dfd2e-9130-4b69-b3be-184f039043e2/air-max-1-shoes-ZCSX34.png', b'0', 'Nike Air Max 1', 4109000, 'còn hàng', 3),
(5, '2023-11-16', NULL, 'Thoải mái, bền bỉ và vượt thời gian—không có lý do gì nó là số 1. Kết cấu cổ điển của thập niên 80 kết hợp với da bền và vải Ripstop để tạo nên kết cấu chắc chắn. Đệm Nike Air mang lại sự thoải mái lâu dài trong khi các chi tiết thiết kế phản chiếu và đế ngoài màu xanh mờ tạo thêm phong cách táo bạo giúp bạn theo dõi dù bạn đang ở trên sân hay đang di chuyển.', 'Thông tin chi tiết sản phẩm\r\n\r\nĐế giữa xốp\r\nCác vết thủng ở ngón chân\r\nChi tiết thiết kế phản quang\r\nKhông nhằm mục đích sử dụng làm thiết bị bảo hộ cá nhân (PPE)\r\nMàu sắc hiển thị: Trắng/Bạc phản chiếu/Xanh công nghiệp/Trắng\r\nPhong cách: FV0383-100\r\nQuốc gia/Khu vực xuất xứ: Indonesia\r\n\r\nLực lượng Không quân 1\r\n\r\nRa mắt lần đầu tiên vào năm 1982 như một thứ không thể thiếu trong bóng rổ, Lực lượng Không quân 1 đã trở thành của riêng mình vào những năm 90. Vẻ ngoài gọn gàng của AF-1 trắng trên nền trắng cổ điển đã được khẳng định từ sân bóng rổ đến đường phố và xa hơn nữa. Tìm thấy nhịp điệu của mình trong văn hóa hip-hop, phát hành các sản phẩm cộng tác và phối màu hạn chế, Air Force 1 đã trở thành đôi giày thể thao mang tính biểu tượng trên toàn cầu. Và với hơn 2.000 lần lặp lại mặt hàng chủ lực này, không thể phủ nhận tác động của nó đối với văn hóa thời trang, âm nhạc và giày thể thao.', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/bff3d49a-fd0e-4471-8a97-e7973551ddb4/air-force-1-07-shoes-KMT0fF.png', b'0', 'Nike Air Force 1 \'07', 3829000, 'còn hàng', 3),
(6, '2023-11-16', NULL, 'Được đường phố khen ngợi vì sự đơn giản và thoải mái cổ điển, Nike Blazer Low \'77 Vintage trở lại với phong cách cổ điển và vẻ ngoài b-ball truyền thống. Với các chi tiết da lộn quyến rũ, thiết kế Swoosh cổ điển và cổ áo siêu mềm, đây là món đồ không thể thiếu trong tủ quần áo sẽ đưa bạn đi khắp mọi nơi.', 'Những lợi ích\r\n\r\nĐược thiết kế ban đầu cho các vòng biểu diễn, Nike Blazer Low mang đến độ bền và sự thoải mái kéo dài. Phiên bản làm lại gần như 1-1 có da sắc nét ở phía trên với da lộn mềm và các chi tiết tổng hợp để tăng độ bền và kiểu dáng cổ điển.\r\nMàu sắc cực kỳ sạch sẽ, đường nét đơn giản và cổ áo có đệm, cắt thấp tạo nên vẻ ngoài bóng bẩy mang lại cảm giác tuyệt vời.\r\nCấu trúc lưu hóa kết hợp đế ngoài với đế giữa để mang lại vẻ ngoài hợp lý, bền bỉ và thoải mái.\r\nĐế ngoài bằng cao su rắn với họa tiết xương cá tăng thêm lực kéo, độ bền và kiểu dáng di sản.\r\nMàu sắc hiển thị: Trắng/Cánh buồm/Đen/Xanh thông\r\nPhong cách: DA6364-115\r\nQuốc gia/Khu vực xuất xứ: Ấn Độ', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/f450b123-2c17-48d5-9329-cc4c87dd604c/blazer-low-77-vintage-shoes-5Gw9TZ.png', b'0', 'Nike Blazer Low \'77 Vintage', 2499000, 'còn hàng ', 3),
(7, '2023-11-16', NULL, 'Được thiết kế dành cho gỗ cứng nhưng lại được ưa chuộng trên đường phố, biểu tượng bóng rổ của thập niên 80 trở lại với các chi tiết cổ điển và sự tinh tế của những chiếc vòng quay cổ điển. Da bền và vải Ripstop được kết hợp với các chi tiết thiết kế phản chiếu và đế ngoài màu xanh mờ tạo nên kết cấu chắc chắn giúp bạn đối mặt với các điều kiện khắc nghiệt. Và cổ áo có đệm, cổ thấp cho phép bạn mang trò chơi của mình đi bất cứ đâu—một cách thoải mái.', 'Thông tin chi tiết sản phẩm\r\n\r\nChi tiết thiết kế phản quang\r\nKhông nhằm mục đích sử dụng làm thiết bị bảo hộ cá nhân (PPE)\r\nMàu sắc hiển thị: Antraxit/Xám mát/Xanh công nghiệp/Bạch kim nguyên chất\r\nPhong cách: FV0384-001\r\nQuốc gia/Khu vực xuất xứ: Indonesia\r\n\r\nNike Dunk\r\n\r\nRa đời từ một loạt sự kết hợp, hack và thời hạn chặt chẽ, Nike Dunk đã có mặt trên sân bóng rổ của trường đại học trong mùa giải \'85–\'86. Trong khi các thiết kế \'College Colours\' ban đầu giúp người hâm mộ trung thành với trường phái của họ thì Dunk lại không chứng tỏ được sự phổ biến. Nhưng chính sự thiếu phổ biến của đôi giày thể thao khiêm tốn này—và đế phẳng, bám chắc—đã giúp nó thu hút những người trượt ván. Nhiều thập kỷ sau, món đồ được yêu thích hàng ngày này tiếp tục được ưa chuộng với vô số màu sắc, chứng tỏ tầm ảnh hưởng của nó là không thể phủ nhận.', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/938273c4-d731-4fe6-b2c7-1a75002a1536/dunk-low-shoes-Knf0qX.png', b'0', 'Nike Dunk Low', 3829000, 'còn hàng ', 1),
(8, '2023-11-16', NULL, 'Được tạo ra cho gỗ cứng nhưng lại được ưa chuộng trên đường phố, biểu tượng b-ball của thập niên 80 trở lại với chất liệu cổ điển và những chiếc vòng cầu kỳ tinh tế. Mang phong cách cổ điển trở lại đường phố, cổ áo có đệm giúp bạn mang trò chơi của mình đi bất cứ đâu—một cách thoải mái.', 'Nike Dunk\r\n\r\nTừ ván rổ cho đến ván trượt, tầm ảnh hưởng của Nike Dunk là không thể phủ nhận. Mặc dù được giới thiệu là giày bóng rổ vào năm 1985, đế phẳng và bám chắc của nó là sự lựa chọn hoàn hảo cho cộng đồng thể thao bị lãng quên—vận động viên trượt băng. Khám phá một nền văn hóa nhóm khao khát sự sáng tạo cũng như chức năng, Dunk đã cho ra đời vô số màu sắc trong hàng thập kỷ tiếp tục thu hút linh hồn của những người trượt ván từ bờ biển này sang bờ biển khác.\r\n\r\n', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/35cd473e-b388-4de0-83f5-8a8f3287eef6/dunk-low-retro-shoes-Zc0601.png', b'0', 'Nike Dunk Low Retro Premium', 3519000, 'còn hàng ', 1),
(9, '2023-11-16', NULL, 'Trông Max, cảm thấy Max. Air Max SYSTM mang lại mọi thứ bạn yêu thích về phong cách thập niên 80 yêu thích của bạn (không cần quần dù). Cặp đệm Nike Air có thể nhìn thấy được đã được thử và kiểm nghiệm với phần trên kiểu dáng đẹp, lấy cảm hứng từ thể thao. Lại là Air Max đang giao hàng nữa.', 'Rung cảm cổ điển\r\n\r\nLấy cảm hứng từ tất cả các mẫu Air Max yêu thích của bạn từ những năm 80, bạn sẽ có được nét thẩm mỹ di sản với cảm giác hiện đại.\r\n\r\n\r\nPhong cách lâu dài\r\n\r\nPhần trên bằng vật liệu hỗn hợp mang lại độ bền và độ thoáng khí trong khi đế ngoài bằng cao su tăng thêm lực kéo kéo dài.\r\n\r\n\r\nNguồn gốc Nike Air Max\r\n\r\nCông nghệ Revolution Air lần đầu tiên được đưa vào giày Nike vào năm 1978. Năm 1987, Air Max 1 ra mắt với công nghệ Air có thể nhìn thấy ở gót chân, mang đến cho người hâm mộ nhiều thứ hơn là chỉ cảm nhận về đệm Air—đột nhiên họ có thể nhìn thấy nó. Kể từ đó, giày Air Max thế hệ tiếp theo đã trở thành điểm nhấn với các vận động viên và nhà sưu tập nhờ mang đến sự kết hợp màu sắc nổi bật và lớp đệm nhẹ, đáng tin cậy.\r\n\r\n', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/568e0b8d-85e0-4fae-bb98-26d77fdfe88b/air-max-systm-shoes-hLmQ85.png', b'0', 'Nike Air Max SYSTM', 2779000, 'còn hàng', 3),
(10, '2023-11-16', NULL, 'Một đôi giày mới với nét hấp dẫn cổ điển—giấc mơ cổ điển của bạn vừa trở thành hiện thực. Thiết kế tối giản này lấy cảm hứng từ AF-1 cổ điển, sau đó chuyển sang phong cách thập niên 80 với đường khâu ngược và màu sắc lấy cảm hứng từ trường đại học. Tuy nhiên, không phải mọi thứ đều phải cũ—sự thoải mái và độ bền hiện đại giúp chúng dễ dàng đeo mọi lúc, mọi nơi. Đã đến lúc ném chúng vào và dùng hết sức lực.', 'Những lợi ích\r\n\r\nDa trên có độ tuổi mềm mại hoàn hảo.\r\nChọn từ nhiều cách phối màu lấy cảm hứng từ trường đại học để phù hợp với mọi tâm trạng và diện mạo.\r\nLớp bọt tiếp xúc cho phép bạn cảm nhận được sự mềm mại chạy hoàn toàn dưới chân.\r\n\r\nThông tin chi tiết sản phẩm\r\n\r\nĐế giữa xốp\r\nĐế giày cao su\r\nMàu sắc hiển thị: Trắng/Thiếc/Cánh buồm/Đen\r\nPhong cách: FB1362-101\r\nQuốc gia/Khu vực xuất xứ: Việt Nam', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/812a427a-3923-4a9e-96de-16c93d658542/full-force-low-shoes-w2MKmW.png', b'0', 'Nike Full Force Low', 2478000, 'còn hàng', 3),
(11, '2023-11-16', NULL, 'Lấy cảm hứng từ phiên bản gốc ra mắt năm 1985, Air Jordan 1 Low mang đến vẻ ngoài cổ điển, gọn gàng, quen thuộc nhưng luôn mới mẻ. Với thiết kế mang tính biểu tượng kết hợp hoàn hảo với bất kỳ kiểu giày nào, những đôi giày này đảm bảo bạn sẽ luôn đi đúng hướng.', 'Những lợi ích\r\n\r\nBộ phận Air-Sole đóng gói cung cấp đệm nhẹ.\r\nDa thật ở phía trên mang lại độ bền và vẻ ngoài cao cấp.\r\nĐế ngoài cao su rắn tăng cường lực kéo trên nhiều bề mặt.\r\nMàu sắc hiển thị: Trắng/Đen/Trắng/Xanh hoàng gia\r\nPhong cách: 553558-140\r\nQuốc gia/Khu vực xuất xứ: Việt Nam\r\nĐã thử và đúng\r\n\r\nĐế cao su vượt thời gian kết hợp với lót giày sang trọng và đệm Nike Air bọc kín để mang lại sự thoải mái cả ngày. Đế ngoài bằng cao su cung cấp lực kéo bền trên nhiều bề mặt.', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/cd83452d-3a6c-4742-9129-3693e06a26e2/air-jordan-1-low-shoes-6Q1tFM.png', b'0', 'Air Jordan 1 Low', 3239000, 'còn hàng', 3),
(12, '2023-11-16', NULL, 'Ánh hào quang vẫn tồn tại trong Lực lượng Không quân 1 \'07 LV8. Bản gốc b-ball này tạo ra một luồng gió mới về những gì bạn biết rõ nhất: lớp phủ được khâu bền, lớp hoàn thiện gọn gàng và lượng đèn flash hoàn hảo để giúp bạn tỏa sáng. Phiên bản sẵn sàng cho mùa đông này giúp bạn giữ ấm và có khả năng chống chọi với thời tiết khắc nghiệt.', 'Thông tin chi tiết sản phẩm\r\n\r\nĐế giữa xốp\r\nĐục lỗ trên hộp ngón chân\r\nKhông nhằm mục đích sử dụng làm thiết bị bảo hộ cá nhân (PPE)\r\nMàu sắc hiển thị: Phantom/Kaki hàng hóa/Nâu đỏ đậm/Phantom\r\nPhong cách: FB8877-001\r\nQuốc gia/Khu vực xuất xứ: Việt Nam\r\n\r\nLực lượng Không quân 1\r\n\r\nRa mắt lần đầu tiên vào năm 1982 như một thứ không thể thiếu trong bóng rổ, Lực lượng Không quân 1 đã trở thành của riêng mình vào những năm 90. Vẻ ngoài gọn gàng của AF-1 trắng trên nền trắng cổ điển đã được khẳng định từ sân bóng rổ đến đường phố và xa hơn nữa. Tìm thấy nhịp điệu của mình trong văn hóa hip-hop, phát hành các sản phẩm cộng tác và phối màu hạn chế, Air Force 1 đã trở thành đôi giày thể thao mang tính biểu tượng trên toàn cầu. Và với hơn 2.000 lần lặp lại mặt hàng chủ lực này, không thể phủ nhận tác động của nó đối với văn hóa thời trang, âm nhạc và giày thể thao.', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/5706ffe6-8975-46d9-a309-b406b4d720ca/air-force-1-07-lv8-shoes-hHz3rg.png', b'0', 'Nike Air Force 1 \'07 LV8', 3519000, 'còn hàng', 1),
(13, '2023-11-16', NULL, 'Bạn đã bao giờ đi trên Air chưa? Bước vào Air VaporMax 2023 để xem nó được thực hiện như thế nào. Công nghệ tiên tiến được bộc lộ qua lớp lót giày đục lỗ (kéo ra để xem thêm). Thân giày Flyknit co giãn được làm từ ít nhất 20% vật liệu tái chế tính theo trọng lượng.', 'Thông tin chi tiết sản phẩm\r\n\r\nĐế giày cao su\r\nDây buộc truyền thống\r\nKhông nhằm mục đích sử dụng làm Thiết bị bảo hộ cá nhân (PPE)\r\nMàu sắc hiển thị: Đen/Antraxit/Đen/Đen\r\nPhong cách: DV1678-003\r\nQuốc gia/Khu vực xuất xứ: Việt Nam\r\n\r\nNike Air VaporMax\r\n\r\nSau hành trình 7 năm từ khi hình thành đến khi ra mắt, Air VaporMax đại diện cho một kỷ nguyên mới trong sự đổi mới của Nike. Để thực sự nắm bắt được cảm giác \"chạy trên không\", các nhà thiết kế đã cơ cấu lại bộ phận Air để gắn trực tiếp vào phần trên. Khi bạn bước xuống, mỗi vấu sẽ được đẩy vào bộ phận Air, làm tăng áp suất. Sau đó, khi bạn bước đi, áp lực sẽ giải phóng tạo ra độ nảy đàn hồi với độ linh hoạt vượt trội. Được thiết kế dành cho người chạy bộ, công nghệ tương lai này nhanh chóng được áp dụng trên đường phố, mang lại cảm giác nhẹ nhàng như không khí cho đại chúng.', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/c82627ea-5151-4ef1-904b-9c11f802ffc1/air-vapormax-2023-flyknit-shoes-xjVzw5.png', b'0', 'Nike Air VaporMax 2023 Flyknit', 6179000, 'còn hàng', 1),
(14, '2023-11-16', NULL, 'Nhanh hơn 1, 2, 3—giày vòng ban đầu cho phép bạn bước vào và bắt đầu. Hệ thống nhập EasyOn mang đến cho bạn trải nghiệm rảnh tay, trong khi da sắc nét mang lại màu sắc sạch sẽ nhất để mang lại khả năng đeo tối ưu. Vâng, đó là tất cả những gì bạn yêu thích và sau đó là một số.', 'Lực lượng Không quân 1\r\n\r\nRa mắt lần đầu tiên vào năm 1982 như một thứ không thể thiếu trong bóng rổ, Lực lượng Không quân 1 đã trở thành của riêng mình vào những năm 90. Vẻ ngoài gọn gàng của AF-1 trắng trên nền trắng cổ điển đã được khẳng định từ sân bóng rổ đến đường phố và xa hơn nữa. Tìm thấy nhịp điệu của mình trong văn hóa hip-hop, phát hành các sản phẩm cộng tác và phối màu hạn chế, Air Force 1 đã trở thành đôi giày thể thao mang tính biểu tượng trên toàn cầu. Và với hơn 2.000 lần lặp lại mặt hàng chủ lực này, không thể phủ nhận tác động của nó đối với văn hóa thời trang, âm nhạc và giày thể thao.', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/13721f24-2774-443e-a27d-998d2c6be068/air-force-1-07-easyon-shoes-LKXPhZ.png', b'0', 'Nike Air Force 1 \'07 EasyOn', 3237890, 'còn hàng ', 3),
(15, '2023-11-16', NULL, 'Sự rạng rỡ vẫn tồn tại trong Nike Air Force 1 \'07, biểu tượng b-ball mang đến một luồng gió mới mẻ cho những gì bạn biết rõ nhất: da sắc nét, màu sắc đậm và lượng ánh sáng hoàn hảo giúp bạn tỏa sáng.', 'Thông tin chi tiết sản phẩm\r\n\r\nĐế giữa xốp\r\nCác vết thủng ở ngón chân\r\nMàu sắc hiển thị: Trắng/Cam chắc chắn\r\nPhong cách: DD8959-115\r\nQuốc gia/Khu vực xuất xứ: Việt Nam\r\n\r\nNguồn gốc của lực lượng không quân 1\r\n\r\nRa mắt lần đầu tiên vào năm 1982, AF-1 là đôi giày bóng rổ đầu tiên có Nike Air, tạo nên một cuộc cách mạng trong môn thể thao này đồng thời nhanh chóng thu hút được sự chú ý trên toàn thế giới. Ngày nay, Air Force 1 vẫn giữ nguyên nguồn gốc của nó với lớp đệm mềm mại và đàn hồi đã làm thay đổi lịch sử giày sneaker.', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/22a7de43-5ccc-4409-a6e9-b235f3f4b711/air-force-1-07-shoe-NMmm1B.png', b'0', 'Nike Air Force 1 \'07', 2923900, 'còn hàng', 3),
(16, '2023-11-16', NULL, 'Bạn đã sẵn sàng nâng tầm phong cách của mình chưa? Chúng tôi đã hình dung lại biểu tượng của Air để mang đến cho bạn sự kết hợp hoàn hảo giữa các chi tiết cũ và thiết kế tương lai. Viền răng cưa xung quanh đế ngoài được kết hợp với da mịn và logo Swoosh nổi một phần để mang đến sự sang trọng được chế tác khéo léo. Đệm mắt cá chân sang trọng và đệm Max Air mang đến cho bạn sự thoải mái hạng nhất. Với thiết kế thể thao, vui tươi và vô cùng thoải mái, những đôi giày này đều hướng tới việc bước tới tương lai.', 'Thông tin chi tiết sản phẩm\r\n\r\nKéo tab ở gót chân và lưỡi\r\nNhãn lưỡi da tổng hợp\r\nMàu sắc hiển thị: Stardust đỏ/Trắng đỉnh núi/Cam lửa trại/Cam chắc chắn\r\nPhong cách: FQ8881-618\r\nQuốc gia/Khu vực xuất xứ: Việt Nam\r\n\r\nAir Max 90\r\n\r\nThập niên 90 là một bước ngoặt trong văn hóa—nghệ thuật, âm nhạc, thời trang và giày thể thao. Air Max đã đi đầu trong phong trào. Với lớp đệm khí lộ ra nhiều hơn và màu sắc mới táo bạo được trìu mến gọi là \"Hồng ngoại\", thiết kế mang tính cách mạng của nó đã giúp những chiếc 90 đầu tiên có được sức sống riêng. Không còn chỉ là một đôi giày chạy bộ, nó đã củng cố Air Max như một nền tảng của trang phục dạo phố.', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/c548a178-cd58-4b62-9b8b-020260e80515/air-max-90-futura-shoes-nfmGzj.png', b'0', 'Nike Air Max 90 Futura', 4109000, 'còn hàng', 1),
(17, '2023-11-16', NULL, 'Thông tin chi tiết sản phẩm\r\n\r\nĐệm cổ\r\nLogo Swoosh thêu\r\nKéo tab ở gót chân\r\nMàu sắc hiển thị: Monarch/Xương nhạt/Cánh buồm/Đen\r\nPhong cách: DR9761-800\r\nQuốc gia/Khu vực xuất xứ: Việt Nam', 'Lấy cảm hứng từ hoạt động chạy bộ đầu những năm 2000, Tech Hera sẵn sàng đáp ứng mọi mong muốn về giày sneaker chunky của bạn. Đế giữa nâng lên gợn sóng và các điểm nhấn bằng da lộn giúp tôn lên vẻ ngoài của bạn trong khi vẫn giữ cho bạn cảm giác thoải mái. Thiết kế bền bỉ của nó phù hợp với trang phục hàng ngày—điều này thật hoàn hảo vì bạn chắc chắn sẽ muốn đeo những thứ này hàng ngày.', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/da60203a-742a-4f79-8dee-c5574c15bdd0/tech-hera-shoes-JlV5km.png', b'0', 'Nike Tech Hera', 3239000, 'còn hàng', 1),
(18, '2023-11-16', NULL, 'Được tạo ra dành cho gỗ cứng nhưng lại được ưa chuộng trên đường phố, biểu tượng của thập niên 80 quay trở lại để giúp bạn làm việc tốt bằng cách trông đẹp mắt. Hiện được làm từ ít nhất 20% vật liệu tái chế tính theo trọng lượng, chúng tôi đã làm mới kiểu dáng cổ điển giúp giữ được tính toàn vẹn ban đầu với tác động được giảm thiểu. Được chế tác từ da tổng hợp, Dunk Low thể hiện phong cách baller cổ điển và phong cách giản dị trên đường phố.', 'Thông tin chi tiết sản phẩm\r\n\r\nĐế xốp\r\nCác vết thủng ở ngón chân\r\nĐệm cổ\r\nMàu sắc hiển thị: Màu xanh lam/Trắng đỉnh cao/Volt/Coban hạnh phúc\r\nPhong cách: DD1873-400\r\nQuốc gia/Khu vực xuất xứ: Việt Nam\r\n\r\nNguồn gốc Dunk\r\n\r\nBan đầu là một đôi giày Nike Hoops cổ điển, Dunk đã được văn hóa trượt ván tiếp nhận một cách hữu cơ—và theo thời gian được thiết kế lại cho Nike SB. Ngày nay, Nike SB Dunk đóng vai trò là điểm khởi đầu cho nhiều cộng tác viên thiết kế có ảnh hưởng nhất của thương hiệu — từ các cửa hàng giày trượt ở thị trấn nhỏ đến các hãng thời trang mang tính biểu tượng ở New York.', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/12686e08-ca36-4de2-9856-1df88c74d487/dunk-low-shoes-wbxcmN.png', b'0', 'Nike Dunk Low', 2929000, 'còn hàng', 1),
(19, '2023-11-16', NULL, 'Nâng cao phong cách AF-1 ban đầu của bạn—theo nghĩa đen. AF-1 PLT.AF.ORM là tất cả những gì bạn yêu thích về kiểu dáng cổ điển, với đế giữa nâng cao có hình dáng trang nhã để tăng thêm sức mạnh. Cổ giày được chạm khắc và phần gót êm ái giúp giày luôn thoải mái, đồng thời biểu tượng Swoosh màu hồng xếp lớp nổi bật trên nền trắng cổ điển.', 'Thông tin chi tiết sản phẩm\r\n\r\nDây buộc truyền thống\r\nĐế giữa xốp\r\nChữ “AIR” được dập nổi trên đế giữa\r\nMàu sắc hiển thị: Trắng/Fireberry/Hồng dữ dội\r\nPhong cách: FJ2986-100\r\nQuốc gia/Khu vực xuất xứ: Việt Nam\r\n\r\nLực lượng Không quân 1\r\n\r\nRa mắt lần đầu tiên vào năm 1982 như một thứ không thể thiếu trong bóng rổ, Lực lượng Không quân 1 đã trở thành của riêng mình vào những năm 90. Vẻ ngoài gọn gàng của AF-1 trắng trên nền trắng cổ điển đã được khẳng định từ sân bóng rổ đến đường phố và xa hơn nữa. Tìm thấy nhịp điệu của mình trong văn hóa hip-hop, phát hành các sản phẩm cộng tác và phối màu hạn chế, Air Force 1 đã trở thành đôi giày thể thao mang tính biểu tượng trên toàn cầu. Và với hơn 2.000 lần lặp lại mặt hàng chủ lực này, không thể phủ nhận tác động của nó đối với văn hóa thời trang, âm nhạc và giày thể thao.\r\n\r\n', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/f871f634-54b5-44e8-b857-0261a1e0f3c2/air-force-1-pltaform-shoes-pNLDVM.png', b'0', 'Nike Air Force 1 PLT.AF.ORM', 3519000, 'còn hàng', 3),
(20, '2023-11-16', NULL, 'Da lộn cao cấp và bọt Công thức 23 đặc trưng của Jordan Brand kết hợp với nhau để mang đến cho bạn chiếc AJ1 sang trọng hơn (và cực kỳ ấm cúng). Bạn không cần phải chơi trò \"hoặc\" khi chọn phong cách hoặc sự thoải mái với kiểu này—điều này thật tuyệt, vì bạn xứng đáng có được cả hai.', 'Da lộn cao cấp và bọt Công thức 23 đặc trưng của Jordan Brand kết hợp với nhau để mang đến cho bạn chiếc AJ1 sang trọng hơn (và cực kỳ ấm cúng). Bạn không cần phải chơi trò \"hoặc\" khi chọn phong cách hoặc sự thoải mái với kiểu này—điều này thật tuyệt, vì bạn xứng đáng có được cả hai.\r\n\r\n\r\nNhững lợi ích\r\n\r\nCông nghệ Nike Air hấp thụ lực tác động để giảm chấn theo từng bước đi.\r\nDa lộn ở phần trên và ngón chân dễ dàng xỏ vào và ôm sát bàn chân của bạn.\r\nBọt Jordan Formula 23 giúp đôi chân của bạn được đệm thêm.\r\nMàu sắc hiển thị: Trắng/Xám trung tính/Vàng kim loại\r\nPhong cách: DV1307-107\r\nQuốc gia/Khu vực xuất xứ: Indonesia', NULL, 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/ce384e4f-3176-43de-a914-d480c221e248/air-jordan-1-zoom-cmft-2-shoes-nX8Qqx.png', b'0', 'Air Jordan 1 Zoom CMFT 2', 4259000, 'còn hàng', 3),
(21, '2023-11-17', NULL, 'test', 'test', NULL, NULL, NULL, 'tétt', 100000, 'còn hàng', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_detail`
--

CREATE TABLE `product_detail` (
  `id` bigint(20) NOT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `id_product` bigint(20) DEFAULT NULL,
  `id_property` bigint(20) DEFAULT NULL,
  `id_size` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product_detail`
--

INSERT INTO `product_detail` (`id`, `is_delete`, `quantity`, `id_product`, `id_property`, `id_size`) VALUES
(1, b'0', 10, 1, 1, 1),
(2, b'0', 10, 2, 2, 2),
(3, NULL, 10, 3, 3, 3),
(4, NULL, 10, 4, 4, 4),
(5, NULL, 10, 5, 5, 5),
(6, NULL, 10, 6, 6, 6),
(7, NULL, 10, 7, 7, 7),
(8, NULL, 10, 8, 8, 6),
(9, NULL, 10, 9, 1, 3),
(10, NULL, 10, 10, 2, 4),
(11, NULL, 10, 11, 3, 1),
(12, NULL, 10, 12, 1, 5),
(13, NULL, 10, 13, 4, 6),
(14, NULL, 10, 14, 1, 1),
(15, NULL, 10, 15, 5, 7),
(16, NULL, 10, 16, 6, 4),
(17, NULL, 10, 17, 7, 2),
(18, NULL, 10, 18, 1, 6),
(19, NULL, 10, 19, 3, 1),
(20, NULL, 10, 20, 2, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `property`
--

CREATE TABLE `property` (
  `id_property` bigint(20) NOT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `property`
--

INSERT INTO `property` (`id_property`, `is_delete`, `name`) VALUES
(1, b'0', 'xanh'),
(2, b'0', 'đỏ'),
(3, b'0', 'tím'),
(4, b'0', 'vàng'),
(5, b'0', 'hồng'),
(6, b'0', 'nâu'),
(7, b'0', 'đen'),
(8, b'0', 'tím');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER'),
(3, 'ROLE_GUEST');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `size`
--

CREATE TABLE `size` (
  `id` bigint(20) NOT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `size`
--

INSERT INTO `size` (`id`, `is_delete`, `name`) VALUES
(1, b'0', '36'),
(2, b'0', '37'),
(3, b'0', '38'),
(4, b'0', '39'),
(5, b'0', '40'),
(6, b'0', '41'),
(7, b'0', '42'),
(8, b'0', '43');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `password` varchar(120) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `email`, `is_delete`, `password`, `phone`, `username`) VALUES
(1, 'admin@gmail.com', b'0', '$2a$12$L3CMp7hLrA01JtRFACVKZut3rDvtGpbezTjJc1vZ2THJmhpRBvLh6', '01234567890', 'admin'),
(2, 'user@gmail.com', b'0', '$2a$12$JFzrShjyIuQEYkVjBFfw3eIuf81xkwPtaR5KuKfp/oO3b9MTF.FRC', '0123456789', 'user'),
(3, 'guest@gmail.com', b'0', '$2a$12$4p0nwc1a272/kwX4PdMQ3uH3LWTDquMVWjmc8dgKBe9NB4AfrYFfm', '033478629', 'guest');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `voucher`
--

CREATE TABLE `voucher` (
  `id` bigint(20) NOT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `id_event` bigint(20) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `minimum_value` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `id_bill` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `voucher`
--

INSERT INTO `voucher` (`id`, `amount`, `discount`, `id_event`, `is_delete`, `minimum_value`, `name`, `id_bill`) VALUES
(1, 4, 300000, 1, b'0', 500000, '500 giảm 300', 567854),
(2, 3, 100000, 2, b'0', 300000, '300 giảm 100', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `voucherbill`
--

CREATE TABLE `voucherbill` (
  `id` bigint(20) NOT NULL,
  `id_bill` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfhkxwb71lvn1t7d0l234hxywa` (`id_customer`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpoqebxaihjikj61qqwxcugeoq` (`id_user`);

--
-- Chỉ mục cho bảng `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`id_event`);

--
-- Chỉ mục cho bảng `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnehdwamvp4hqgh0ab1yy7igst` (`id_account`),
  ADD KEY `FKebv5p4e8gjysj4vdgkom261ru` (`id_product`);

--
-- Chỉ mục cho bảng `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK10wu65rsj42intbo9hwa2tmqe` (`id_bill`),
  ADD KEY `FKeltonm2iefs6sykatyg117ve1` (`product_id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5cxv31vuhc7v32omftlxa8k3c` (`id_category`);

--
-- Chỉ mục cho bảng `product_detail`
--
ALTER TABLE `product_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKiyk9npasmucg0xxq9ooc31g04` (`id_product`),
  ADD KEY `FKf23hjslxh6mdlxjm94k7c366d` (`id_property`),
  ADD KEY `FKklell1kj4i5npdyb7un3n55nj` (`id_size`);

--
-- Chỉ mục cho bảng `property`
--
ALTER TABLE `property`
  ADD PRIMARY KEY (`id_property`);

--
-- Chỉ mục cho bảng `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `size`
--
ALTER TABLE `size`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- Chỉ mục cho bảng `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`);

--
-- Chỉ mục cho bảng `voucher`
--
ALTER TABLE `voucher`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6jo87s1hl0p4o0e1ns1fak2w1` (`id_bill`),
  ADD KEY `FKld3esjf4ens5xs9phpkvwte1i` (`id_event`);

--
-- Chỉ mục cho bảng `voucherbill`
--
ALTER TABLE `voucherbill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkb8k4j1bo8nn3bdsau19yh6s6` (`id_bill`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `event`
--
ALTER TABLE `event`
  MODIFY `id_event` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `image`
--
ALTER TABLE `image`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT cho bảng `orderdetail`
--
ALTER TABLE `orderdetail`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT cho bảng `product_detail`
--
ALTER TABLE `product_detail`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `property`
--
ALTER TABLE `property`
  MODIFY `id_property` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `size`
--
ALTER TABLE `size`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `voucher`
--
ALTER TABLE `voucher`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `voucherbill`
--
ALTER TABLE `voucherbill`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `FKfhkxwb71lvn1t7d0l234hxywa` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id`);

--
-- Các ràng buộc cho bảng `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `FKpoqebxaihjikj61qqwxcugeoq` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `FKebv5p4e8gjysj4vdgkom261ru` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKnehdwamvp4hqgh0ab1yy7igst` FOREIGN KEY (`id_account`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD CONSTRAINT `FK10wu65rsj42intbo9hwa2tmqe` FOREIGN KEY (`id_bill`) REFERENCES `bill` (`id`),
  ADD CONSTRAINT `FKeltonm2iefs6sykatyg117ve1` FOREIGN KEY (`product_id`) REFERENCES `product_detail` (`id`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK5cxv31vuhc7v32omftlxa8k3c` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`);

--
-- Các ràng buộc cho bảng `product_detail`
--
ALTER TABLE `product_detail`
  ADD CONSTRAINT `FKf23hjslxh6mdlxjm94k7c366d` FOREIGN KEY (`id_property`) REFERENCES `property` (`id_property`),
  ADD CONSTRAINT `FKiyk9npasmucg0xxq9ooc31g04` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKklell1kj4i5npdyb7un3n55nj` FOREIGN KEY (`id_size`) REFERENCES `size` (`id`);

--
-- Các ràng buộc cho bảng `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `voucher`
--
ALTER TABLE `voucher`
  ADD CONSTRAINT `FK6jo87s1hl0p4o0e1ns1fak2w1` FOREIGN KEY (`id_bill`) REFERENCES `bill` (`id`),
  ADD CONSTRAINT `FKld3esjf4ens5xs9phpkvwte1i` FOREIGN KEY (`id_event`) REFERENCES `event` (`id_event`);

--
-- Các ràng buộc cho bảng `voucherbill`
--
ALTER TABLE `voucherbill`
  ADD CONSTRAINT `FKkb8k4j1bo8nn3bdsau19yh6s6` FOREIGN KEY (`id_bill`) REFERENCES `bill` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
