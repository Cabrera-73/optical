-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-10-2024 a las 03:03:25
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `optical`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `fecha` varchar(100) NOT NULL,
  `total` float NOT NULL,
  `ruta` varchar(255) NOT NULL,
  `nit` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `facturas`
--

INSERT INTO `facturas` (`id`, `nombre`, `fecha`, `total`, `ruta`, `nit`) VALUES
(9, 'Luis Moran', '14-10-2024', 23860, 'facturas/Luis Moran_14-10-2024.pdf', '449117184');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `ID` int(11) NOT NULL,
  `codigo` varchar(150) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `precio` double NOT NULL,
  `existencia` int(11) NOT NULL,
  `categoria` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`ID`, `codigo`, `nombre`, `precio`, `existencia`, `categoria`) VALUES
(9, 'crantireflejo-1', 'Plastico Ar', 150, 10, 'lentes'),
(10, 'crblanco', 'Plastico Blanco', 75, 10, 'lentes'),
(11, 'crantireflejoblue', 'Plastico Ar anti BLUE', 250, 10, 'lentes'),
(12, 'crarfoto', 'Plastico Antireflejo Fotocromatico', 375, 10, 'lentes'),
(13, 'topes', 'Topes para lentes', 15, 10, 'accesorios'),
(14, 'estuche', 'Estuche duro', 20, 10, 'accesorios'),
(15, 'ar001', 'Aro Economico', 150, 10, 'aro'),
(16, 'ar002', 'Economico Premium', 250, 10, 'aro'),
(17, 'ar003', 'Aro Intermedio', 300, 10, 'aro'),
(18, 'ar004', 'Aro Premium', 400, 10, 'aro'),
(19, 'ar005', 'Aro de Marca', 900, 10, 'aro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `username` varchar(18) NOT NULL,
  `name` varchar(13) NOT NULL,
  `password` varchar(25) NOT NULL,
  `nivel` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `username`, `name`, `password`, `nivel`) VALUES
(1, 'admin', 'Admin', 'root123', 'admin'),
(2, 'cabrera73', 'Alejandro Cab', 'ale123', 'usuario'),
(3, 'luisardium', 'Luis Moran', 'luis123', 'usuario');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `facturas`
--
ALTER TABLE `facturas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
