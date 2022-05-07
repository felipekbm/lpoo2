/**
 *
 * @author Ricardo Filho
 */

create table participante(id int not null primary key AUTO_INCREMENT, nacionalidade varchar(255) not null, 
data_nasc date not null, nome varchar(255) not null, foto varchar(255));

create table selecao(id int not null primary key AUTO_INCREMENT, nome varchar(255) not null);

create table posicao(id int not null primary key AUTO_INCREMENT, nome varchar(255) not null);

create table jogador(id int not null primary key, selec_id int not null, posicao_id int not null, camisa int not null,  
CONSTRAINT FK_Selecao_Jogador FOREIGN KEY (selec_id) REFERENCES selecao(id),
CONSTRAINT FK_Posicao_Jogador FOREIGN KEY (posicao_id) REFERENCES posicao(id),
CONSTRAINT FK_Participante_Jogador FOREIGN KEY (id) REFERENCES participante(id)
);

create table treinador(id int not null primary key, selec_id int not null,   
CONSTRAINT FK_Selecao_Treinador FOREIGN KEY (selec_id) REFERENCES selecao(id),
CONSTRAINT FK_Participante_Treinador FOREIGN KEY (id) REFERENCES participante(id)
);

create table juiz(id int not null primary key, selec_id int not null,   
CONSTRAINT FK_Participante_Juiz FOREIGN KEY (id) REFERENCES participante(id)
);

create table jogo(id int not null primary key AUTO_INCREMENT, selecao_1 int not null, selecao_2 int not null,
data date, resultado varchar(10), local varchar(250),
CONSTRAINT FK_Selecao1_Jogo FOREIGN KEY (selecao_1) REFERENCES selecao(id),
CONSTRAINT FK_Selecao2_Jogo FOREIGN KEY (selecao_2) REFERENCES selecao(id)
);

create table juiz_jogo(id int not null primary key AUTO_INCREMENT, id_juiz int not null, id_jogo int not null,
CONSTRAINT FK_Juiz_Jogo FOREIGN KEY (id_juiz) REFERENCES juiz(id),
CONSTRAINT FK_Jogo_Jogo FOREIGN KEY (id_jogo) REFERENCES jogo(id)
);

