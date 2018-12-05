select * from usuario;

insert into usuario(email, senha, tipo)
values('admin', 'admin', 1), ('professor', 'professor', 2), ('aluno', 'aluno', 3);

select * from noticia;

insert into noticia(data, descricao, titulo, usuario_id)
values(now(), 'A Fatec Taquaritinga convida os alunos de seus 
	   cursos de graduação a participarem do curso de curta duração, cujos encontros, que se iniciam 
	   no dia 14 de setembro, acontecem às sextas-feiras, das 7h30 as 9h30.'
, 'Aprimoramento em Matemática Básca', 1);

insert into noticia(data, descricao, titulo, usuario_id)
values(now(), 'A Coordenadoria dos Laboratórios de Informática da Fatec Taquaritinga,
	   comunica a abertura de inscrições para o Processo Seletivo 01/2018, 
	   com o objetivo de escolher 2 alunos para atuarem como estagiários nesse departamento.'
, 'Seleção de Novos Estagiários', 1);

select * from objeto;

insert into objeto(data, objeto, descricao, local, tipo, usuario_id)
values(now(), 'Mouse multilaser', 'Perdi meu mouse, modelo DELL, sem fio. No LAB 3 do Bloco A1', 'Bloco A1', 1, 2),
(now(), 'Guarda-chuva preto', 'Achei um guarda-chuva perto do CLI', 'Bloco A2', 1, 3),
(now(), 'Pen Drive 32gb', 'Oi, pessoal! Perdi um pen-drive rosa no BLOCO A3 hoje a noite! Se alguém achar entre em contato', 'Bloco A3', 2, 3);
