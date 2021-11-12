-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 12 nov. 2021 à 11:04
-- Version du serveur :  8.0.21
-- Version de PHP : 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet_android`
--

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `mdp` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `pseudo`, `email`, `mdp`) VALUES
(1, 'pseudo', 'email', '$2y$10$7MaBzDZzs192gEK0S2PxN.oxsqc75VxcLok.YZEPxO/n3fkcpGE8W'),
(2, 'test', 'blabla', '$2y$10$Hlb5TOGWwf8fvqooeYqoQuNcKyPmp8fmWbyBYReAE3rteJeNnplUW'),
(3, '', '', '$2y$10$PzDYPH3fiuZYacU2id4gr.iA.TnmilF/TkWT38SBRoSuX.FMXp6Zi'),
(4, 'zefsdfz', 'dsfzefdcxf', '$2y$10$XTBaXBmj/i57kPcEpe.NouDuiIwQh.F42rCaHAQxw/vYjD19.tK3O'),
(5, 'test', 'test2', '$2y$10$nnzA7N.AbSXi7jQoaENWXuWYKi0P30cVV3Tek.g7qm5HAVl6kAbhe'),
(6, 'azerty', 'azerty', '$2y$10$XTA6X8QqZqdf0Sa.w6cf9uRAOlP7S4wtxSuahc.YlJJGGkMKKd6F2'),
(7, 'test1', 'test4', '$2y$10$2HsfrhE2Lzz6YjnRMNMrj.rmy1R8Ff1tqWcHokO/LNpn2EE64e/Ze'),
(8, 'jerem', 'jerem@test.fr', '$2y$10$pV2BO6vp2NpdX45JyfELbOdniYMj1oaF6gTPxR7Cia0xuGnrRk5OK'),
(9, 'azerty', 'test', '$2y$10$dW54v7Rz0kgpyYd9gkv/luJ8Jb95AjqcfIIKWeXvvnTMdD2xtYEJq'),
(10, 'test', 'azertyaz', '$2y$10$.F/LVSfFtxQx.t1QPEzxOOeQAD3GTrcPmt87zN/TF2Fsb9/OiEA0m'),
(11, '123', '123', '$2y$10$IuGgFX4U7YXLmUtC/n.2yOr/tzVSIMMV8lfIGsr/TlH0MQw.r.VjO'),
(12, '1', '2', '$2y$10$gqykBkLN73aPHr//lV9qJen/2xeUdnLyIS1daj2LAivgyme5LGNii'),
(13, 'qwerty', 'azerty123', '$2y$10$NhhlDpRzzxI7bFIJO1kQIOLZ4fZ/hS2xFNUeDXxnRnDLxQEMxS4BW');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
