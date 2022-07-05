create table contact (
	id SERIAL NOT NULL,
    nome varchar(100) NOT NULL,
	ramal_interno varchar(10),
    ramal_externo varchar(16),
    corporativo varchar(16),
    email varchar(100),
	setor varchar(100)  NOT NULL,
    imagem_url varchar(255),
	status boolean DEFAULT true NOT NULL,
    primary key (id)
);