-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-10-2022 a las 01:29:03
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mecanica`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividades`
--

CREATE TABLE `actividades` (
  `id_Actividad` int(11) NOT NULL,
  `id_Ficha_Mecanica` int(11) NOT NULL,
  `hs_Empleadas` int(11) NOT NULL,
  `costo_Servicio` decimal(11,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_Cliente` int(11) NOT NULL,
  `id_Persona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id_Empleado` int(11) NOT NULL,
  `usuario` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `pass` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `id_Rol` int(11) NOT NULL,
  `id_Persona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidades`
--

CREATE TABLE `especialidades` (
  `id_Especialidad` int(11) NOT NULL,
  `tipo_Especialidad` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fichas_mecanicas`
--

CREATE TABLE `fichas_mecanicas` (
  `id_Ficha_Mecanica` int(11) NOT NULL,
  `id_Turno` int(11) NOT NULL,
  `id_Vehiculo` int(11) NOT NULL,
  `motivo` text COLLATE utf8mb4_spanish_ci NOT NULL,
  `repuesto` text COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios_atencion`
--

CREATE TABLE `horarios_atencion` (
  `id_Horario` int(11) NOT NULL,
  `id_Mecanico` int(11) NOT NULL,
  `dia` date NOT NULL,
  `hora_Inicio` date NOT NULL,
  `hora_Fin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mecanicos`
--

CREATE TABLE `mecanicos` (
  `id_Mecanico` int(11) NOT NULL,
  `id_Empleado` int(11) NOT NULL,
  `id_Especialidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `id_Persona` int(11) NOT NULL,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `tipo_Documento` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `nro_Documento` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_Rol` int(11) NOT NULL,
  `rol` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguros`
--

CREATE TABLE `seguros` (
  `id_Seguro` int(11) NOT NULL,
  `seguro` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turnos`
--

CREATE TABLE `turnos` (
  `id_Turno` int(11) NOT NULL,
  `id_Cliente` int(11) NOT NULL,
  `id_Mecanico` int(11) NOT NULL,
  `dia` date NOT NULL,
  `hora` date NOT NULL,
  `estado_Turno` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `id_Ficha_Mecanica` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE `vehiculos` (
  `id_Vehiculo` int(11) NOT NULL,
  `id_Cliente` int(11) NOT NULL,
  `id_Seguro` int(11) NOT NULL,
  `modelo` int(11) NOT NULL,
  `marca` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `poliza` int(11) NOT NULL,
  `año` int(11) NOT NULL,
  `patente` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD PRIMARY KEY (`id_Actividad`),
  ADD KEY `id_Ficha_Mecanica` (`id_Ficha_Mecanica`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_Cliente`),
  ADD KEY `id_Persona` (`id_Persona`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id_Empleado`),
  ADD KEY `id_Rol` (`id_Rol`),
  ADD KEY `id_Persona` (`id_Persona`);

--
-- Indices de la tabla `especialidades`
--
ALTER TABLE `especialidades`
  ADD PRIMARY KEY (`id_Especialidad`);

--
-- Indices de la tabla `fichas_mecanicas`
--
ALTER TABLE `fichas_mecanicas`
  ADD PRIMARY KEY (`id_Ficha_Mecanica`),
  ADD KEY `id_Turno` (`id_Turno`),
  ADD KEY `id_Vehiculo` (`id_Vehiculo`);

--
-- Indices de la tabla `horarios_atencion`
--
ALTER TABLE `horarios_atencion`
  ADD PRIMARY KEY (`id_Horario`),
  ADD KEY `id_Mecanico` (`id_Mecanico`);

--
-- Indices de la tabla `mecanicos`
--
ALTER TABLE `mecanicos`
  ADD PRIMARY KEY (`id_Mecanico`),
  ADD KEY `id_Cliente` (`id_Empleado`),
  ADD KEY `id_Especialidad` (`id_Especialidad`),
  ADD KEY `id_Empleado` (`id_Empleado`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`id_Persona`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_Rol`);

--
-- Indices de la tabla `seguros`
--
ALTER TABLE `seguros`
  ADD PRIMARY KEY (`id_Seguro`);

--
-- Indices de la tabla `turnos`
--
ALTER TABLE `turnos`
  ADD PRIMARY KEY (`id_Turno`),
  ADD KEY `id_Cliente` (`id_Cliente`),
  ADD KEY `id_Mecanico` (`id_Mecanico`),
  ADD KEY `id_Ficha_Mecanica` (`id_Ficha_Mecanica`);

--
-- Indices de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD PRIMARY KEY (`id_Vehiculo`),
  ADD KEY `id_Cliente` (`id_Cliente`),
  ADD KEY `id_Seguro` (`id_Seguro`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD CONSTRAINT `actividades_ibfk_1` FOREIGN KEY (`id_Ficha_Mecanica`) REFERENCES `fichas_mecanicas` (`id_Ficha_Mecanica`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`id_Persona`) REFERENCES `personas` (`id_Persona`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`id_Rol`) REFERENCES `roles` (`id_Rol`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `empleados_ibfk_2` FOREIGN KEY (`id_Persona`) REFERENCES `personas` (`id_Persona`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `fichas_mecanicas`
--
ALTER TABLE `fichas_mecanicas`
  ADD CONSTRAINT `fichas_mecanicas_ibfk_1` FOREIGN KEY (`id_Turno`) REFERENCES `turnos` (`id_Turno`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fichas_mecanicas_ibfk_2` FOREIGN KEY (`id_Vehiculo`) REFERENCES `vehiculos` (`id_Vehiculo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `horarios_atencion`
--
ALTER TABLE `horarios_atencion`
  ADD CONSTRAINT `horarios_atencion_ibfk_1` FOREIGN KEY (`id_Mecanico`) REFERENCES `mecanicos` (`id_Mecanico`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mecanicos`
--
ALTER TABLE `mecanicos`
  ADD CONSTRAINT `mecanicos_ibfk_1` FOREIGN KEY (`id_Especialidad`) REFERENCES `especialidades` (`id_Especialidad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mecanicos_ibfk_2` FOREIGN KEY (`id_Empleado`) REFERENCES `empleados` (`id_Empleado`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `turnos`
--
ALTER TABLE `turnos`
  ADD CONSTRAINT `turnos_ibfk_1` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes` (`id_Cliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `turnos_ibfk_2` FOREIGN KEY (`id_Ficha_Mecanica`) REFERENCES `fichas_mecanicas` (`id_Ficha_Mecanica`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `turnos_ibfk_3` FOREIGN KEY (`id_Mecanico`) REFERENCES `mecanicos` (`id_Mecanico`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD CONSTRAINT `vehiculos_ibfk_1` FOREIGN KEY (`id_Seguro`) REFERENCES `seguros` (`id_Seguro`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vehiculos_ibfk_2` FOREIGN KEY (`id_Cliente`) REFERENCES `clientes` (`id_Cliente`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;