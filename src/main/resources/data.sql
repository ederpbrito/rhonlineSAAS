INSERT INTO DATASOURCECONFIG VALUES (1, 'org.h2.Driver', 'jdbc:h2:mem:secondDS', 'secondDS', 'sa', '', true);
INSERT INTO DATASOURCECONFIG VALUES (2, 'org.h2.Driver', 'jdbc:h2:mem:thirdDS', 'thirdDS', 'sa', '', true);
INSERT INTO DATASOURCECONFIG VALUES (3, 'org.h2.Driver', 'jdbc:h2:mem:fourDS', 'fourDS', 'sa', '', true);

/* *********************************Enquadramento Tributário************************************************/
INSERT INTO enquadramento_tributario(aliquota, descricao) VALUES (7,'Simples Nacional');
INSERT INTO enquadramento_tributario(aliquota, descricao) VALUES (15,'Lucro Real');
INSERT INTO enquadramento_tributario(aliquota, descricao) VALUES (22,'Lucro Presumido');

/* *********************************Enquadramento Tributário************************************************/
INSERT INTO imposto (descricao, dt_pagamento, valor) VALUES ('INSS','2018-04-17',7);
INSERT INTO imposto (descricao, dt_pagamento, valor) VALUES ('IMPOSTO DE RENDA','2018-04-17',22);
INSERT INTO imposto (descricao, dt_pagamento, valor) VALUES('FGTS','2018-04-17',15);

/* *********************************Logradouro************************************************/
INSERT INTO logradouro(idlogradouro, bairro, cep, cidade, estado, municipio, pais, rua) VALUES (1,'Centro','01301000','São Paulo','SP','São Paulo','Brasil','Rua da Consolação');
INSERT INTO logradouro(idlogradouro, bairro, cep, cidade, estado, municipio, pais, rua)VALUES(2,'Centro','01301001','São Paulo','SP','São Paulo','Brasil','Rua da Xavier de Toledo');
INSERT INTO logradouro(idlogradouro, bairro, cep, cidade, estado, municipio, pais, rua)VALUES(3,'Centro','01301002','São Paulo','SP','São Paulo','Brasil','Rua Praça Ramos');