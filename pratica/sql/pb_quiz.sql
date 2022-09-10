CREATE DATABASE pb_quiz;
USE pb_quiz;

CREATE TABLE questoes (id INT AUTO_INCREMENT NOT NULL, pergunta VARCHAR(255) NOT NULL, verdadeira BIT(1) NOT NULL, ativa BIT(1) NOT NULL, PRIMARY KEY (id));
CREATE TABLE resultados (id INT AUTO_INCREMENT NOT NULL, jogador VARCHAR(255) NOT NULL, acertos INT NOT NULL, erros INT NOT NULL, dataDaPartida DATE NOT NULL, PRIMARY KEY (id));

INSERT INTO questoes (pergunta, verdadeira, ativa) VALUES ("Baleias sao mamiferos?", true, true);
INSERT INTO questoes (pergunta, verdadeira, ativa) VALUES ("Cavalos sao quadrupedes?", true, true);
INSERT INTO questoes (pergunta, verdadeira, ativa) VALUES ("A raiz quadrada de 49 eh 5?", false, true);
INSERT INTO questoes (pergunta, verdadeira, ativa) VALUES ("O ceu eh azul?", true, true);
INSERT INTO questoes (pergunta, verdadeira, ativa) VALUES ("O brasil fica na europa?", false, false);
INSERT INTO questoes (pergunta, verdadeira, ativa) VALUES ("A pascoa acontece em Dezembro?", false, true);
INSERT INTO questoes (pergunta, verdadeira, ativa) VALUES ("O batman eh um heroi da marvel?", false, true);
INSERT INTO questoes (pergunta, verdadeira, ativa) VALUES ("A copa acontece a cada 4 anos?", true, false);
INSERT INTO questoes (pergunta, verdadeira, ativa) VALUES ("Cachorros sao animais?", true, true);