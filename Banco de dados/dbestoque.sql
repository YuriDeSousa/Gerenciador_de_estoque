SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";



CREATE TABLE `produto` (
  `cod` int(11) NOT NULL,
  `nome` varchar(110) NOT NULL,
  `valor` double NOT NULL,
  `qtd` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `produto` (`cod`, `nome`, `valor`, `qtd`) VALUES
(1, 'Chinela', 30, 34),
(2, 'rodo', 20, 10);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`cod`);

ALTER TABLE `produto`
  MODIFY `cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;
