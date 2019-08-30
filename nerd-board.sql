CREATE DATABASE nerdboard;

-- Dentro da database library executar os comandos abaixo.


CREATE TABLE public.categoria
(
    categoriaid serial PRIMARY KEY,
    nome character varying NOT NULL
);


CREATE TABLE public.cliente
(
    clienteid serial PRIMARY KEY,
    nome character varying NOT NULL,
    endereco character varying NOT NULL,
    telefone character varying NOT NULL
);

CREATE TABLE public.jogo
(
    jogoid serial PRIMARY KEY,
    nome character varying NOT NULL,
    preco float NOT NULL,
    status character varying NOT NULL
);


CREATE TABLE public.pedido
(
    pedidoid serial PRIMARY KEY,
    desconto float NOT NULL,
    clienteid INTEGER NOT NULL REFERENCES cliente(clienteid)
);


CREATE TABLE public.reserva
(
    reservaid serial PRIMARY KEY,
    dataretirada date NOT NULL,
    dataentrega date NOT NULL,
    clienteid INTEGER NOT NULL REFERENCES cliente(clienteid)
);


CREATE TABLE public.categoriajogo
(
    categoriajogoid serial PRIMARY KEY,
    categoriaid INTEGER NOT NULL REFERENCES categoria(categoriaid),
    jogoid INTEGER NOT NULL REFERENCES jogo(jogoid)
);


CREATE TABLE public.pedidojogo
(
    pedidojogoid serial PRIMARY KEY,
    pedidoid integer NOT NULL REFERENCES pedido(pedidoid),
    jogoid integer NOT NULL REFERENCES jogo(jogoid)
);


CREATE TABLE public.reservajogo
(
    reservajogoid serial PRIMARY KEY,
    reservaid integer NOT NULL REFERENCES reserva(reservaid),
    jogoid integer NOT NULL REFERENCES jogo(jogoid)
);