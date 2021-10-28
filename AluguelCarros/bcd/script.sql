Drop database if exists Vilebe;

create database Vilebe;

use Vilebe;

create table Cliente(
    idCliente int not null auto_increment primary key,
    nome VARCHAR(50) not null,
    cnh VARCHAR(20),
    cpf VARCHAR(20) not null,
    endereco VARCHAR(150) not null,
    idade integer not null,
    cart VARCHAR(40),
    observacoes VARCHAR(150),
    email VARCHAR(60) not null,
    telefone VARCHAR(20) not null
);

create table Telefone(
    idCliente integer not null,
    telefone VARCHAR (20) not null
);

create table Veiculo(
    idVeiculo integer not null auto_increment primary key,
    tipo varchar(50) not null,
    modelo VARCHAR(50) not null,
    marca VARCHAR(50) not null,
    placa VARCHAR(50) not null,
    espf VARCHAR(150) not null,
    datarevisao varchar(15) not null,
    kminit varchar(100) not null

);

create table Locacao(
    idLoc integer not null auto_increment primary key,
    idAero integer not null,
    idCliente integer not null,
    idVeiculo integer not null,
    DataDevolucao date not null,
    DataRetirada date not null,
    LocalRetirada VARCHAR(150) not null,
    LocalDevolucao VARCHAR(150) not null,
    KM_Final VARCHAR(50) not null
);

create table Venda(
    idLoc integer not null auto_increment primary key,
    idVeiculo integer not null,
    idCliente integer not null,
    idAero integer not null,
    ValorDiaria decimal(9, 2) not null,
    DataCompra date not null
);

create table Aeroporto(
    idAero integer not null auto_increment primary key,
    Nome VARCHAR(50),
    Estado VARCHAR(2)
);


alter table
    Telefone
add
    constraint fk_telefone foreign key (idCliente) references Cliente(idCliente);


alter table
    Locacao
add
    constraint fk_idCliente foreign key (idCliente) references Cliente(idCliente);

alter table
    Locacao
add
    constraint fk_idVeiculo foreign key (idVeiculo) references Veiculo(idVeiculo);

alter table
    Venda
add
    constraint fk_iAero foreign key (idAero) references Aeroporto(idAero);

alter table
    Venda
add
    constraint fk_idCliente2 foreign key (idCliente) references Locacao(idCliente);

alter table
    Venda
add
    constraint fk_idVeiculo2 foreign key (idVeiculo) references Locacao(idVeiculo);

alter table
    Venda
add
    constraint fk_idLoc foreign key (idLoc) references Locacao(idLoc);

alter table
    Venda
add
    constraint fk_iAero2 foreign key (idAero) references Aeroporto(idAero);
