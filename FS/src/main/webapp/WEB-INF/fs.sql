DROP DATABASE fs;

CREATE DATABASE fs
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'es_CO.UTF-8'
       LC_CTYPE = 'es_CO.UTF-8'
       CONNECTION LIMIT = -1;

\c fs;

CREATE SCHEMA fs
  AUTHORIZATION postgres;
  
CREATE SCHEMA gestion
  AUTHORIZATION postgres;

CREATE TABLE fs.CONPGML(
  CCIA character varying NOT NULL , -- 
  CLINE integer, -- 
  CDESC character varying, -- 
  CYEAR character varying, -- Año de proceso
  CPERS character varying, -- Periódo
  CVALM character varying, -- mes actual 
  CVALP character varying, -- mes ppto 
  CVAR1 character varying, -- variacion
  CVALMYA character varying, -- mes ano ant 
  CVAR2 character varying, -- variacion
  CVALMA character varying, -- mes anterior
  CVAR3 character varying, -- variacion
  op character varying, -- option
  CONSTRAINT CONPGML_pk PRIMARY KEY (CCIA, CLINE, CYEAR, CPERS)
)WITH (OIDS=FALSE); ALTER TABLE fs.CONPGML OWNER TO postgres;

-- -------------------------------------------------------------------------------

CREATE TABLE fs.CONPGMU(
  CCIA character varying NOT NULL , -- 
  CLINE integer, -- 
  CDESC character varying, -- 
  CYEAR character varying, -- Año de proceso
  CPERS character varying, -- Periódo
  CVALM character varying, -- mes actual 
  CVALP character varying, -- mes ppto 
  CVAR1 character varying, -- variacion
  CVALMYA character varying, -- mes ano ant 
  CVAR2 character varying, -- variacion
  CVALMA character varying, -- mes anterior
  CVAR3 character varying, -- variacion
  op character varying, -- option
  CONSTRAINT CONPGMU_pk PRIMARY KEY (CCIA, CLINE, CYEAR, CPERS)
)WITH (OIDS=FALSE); ALTER TABLE fs.CONPGMU OWNER TO postgres;

-- -------------------------------------------------------------------------------

CREATE TABLE fs.CONBSML(
  CCIA character varying NOT NULL , -- Año de proceso
  CLINE integer, -- 
  CDESC character varying, --
  CYEAR character varying, -- Año
  CPERS character varying, -- Periódo
  CVALM character varying, -- al mes actual 
  CVALMA character varying, -- al mes anterior
  CVALAA character varying, -- año anterior
  op character varying, -- option
  CONSTRAINT CONBSML_pk PRIMARY KEY (CCIA, CLINE, CYEAR, CPERS)
)WITH (OIDS=FALSE); ALTER TABLE fs.CONBSML OWNER TO postgres;

-- -------------------------------------------------------------------------------

CREATE TABLE fs.CONBSMU(
  CCIA character varying NOT NULL , -- Año de proceso
  CLINE integer, -- 
  CDESC character varying, --
  CYEAR character varying, -- Año
  CPERS character varying, -- Periódo
  CVALM character varying, -- al mes actual 
  CVALMA character varying, -- al mes anterior
  CVALAA character varying, -- año anterior
  op character varying, -- option
  CONSTRAINT CONBSMU_pk PRIMARY KEY (CCIA, CLINE, CYEAR, CPERS)
)WITH (OIDS=FALSE); ALTER TABLE fs.CONBSMU OWNER TO postgres;

-- -------------------------------------------------------------------------------

CREATE TABLE fs.CONPGAL(
  CCIA character varying NOT NULL , -- Año de proceso
  CLINE integer, -- 
  CDESC character varying, --
  CYEAR character varying, -- Año
  CPERS character varying, -- Periódo 
  CVALM character varying, -- al mes actual 
  CVALP character varying, -- al mes ppto   
  CVAR1 character varying, -- variacion
  CVALMYA character varying, -- mes ano ant 
  CVAR2 character varying, -- variacion
  op character varying, -- option
  CONSTRAINT CONPGAL_pk PRIMARY KEY (CCIA, CLINE, CYEAR, CPERS)
)WITH (OIDS=FALSE); ALTER TABLE fs.CONPGAL OWNER TO postgres;

-- -------------------------------------------------------------------------------

CREATE TABLE fs.CONPGAU(
  CCIA character varying NOT NULL , -- Año de proceso
  CLINE integer, -- 
  CDESC character varying, --
  CYEAR character varying, -- Año
  CPERS character varying, -- Periódo 
  CVALM character varying, -- al mes actual 
  CVALP character varying, -- al mes ppto   
  CVAR1 character varying, -- variacion
  CVALMYA character varying, -- mes ano ant 
  CVAR2 character varying, -- variacion
  op character varying, -- option
  CONSTRAINT CONPGAU_pk PRIMARY KEY (CCIA, CLINE, CYEAR, CPERS)
)WITH (OIDS=FALSE); ALTER TABLE fs.CONPGAU OWNER TO postgres;

-- -------------------------------------------------------------------------------


CREATE TABLE gestion.region
(
  region_id character varying(6) NOT NULL,
  descripcion character varying(128),
  CONSTRAINT region_pk PRIMARY KEY (region_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.region
  OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE gestion.company
(
  comp_id character varying(6) NOT NULL,
  region_id character varying(6),
  comp_desc character varying(255),
  nit character varying(55),
  CONSTRAINT comp_id_pk PRIMARY KEY (comp_id),
  CONSTRAINT region_fk FOREIGN KEY (region_id)
      REFERENCES gestion.region (region_id)  
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.company
  OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE gestion.nivel_organico
(
  nivel_organico_id serial NOT NULL,
  descripcion character varying(128),
  area_estrategica character varying(32),
  CONSTRAINT nivel_organico_pk PRIMARY KEY (nivel_organico_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.nivel_organico
  OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE gestion.currency
(
  currency_id integer NOT NULL,
  currency_desc character varying(255) COLLATE pg_catalog."es_CO.utf8",
  CONSTRAINT currency_id_pk PRIMARY KEY (currency_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.currency
  OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE gestion.type_users
(
  id serial NOT NULL,
  descripcion character varying(30),
  CONSTRAINT tip_id_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.type_users
  OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE gestion.users
(
  id character varying(255) COLLATE pg_catalog."es_CO.utf8" NOT NULL,
  pass character varying(255) COLLATE pg_catalog."es_CO.utf8",
  type_id integer,
  comp_comp_id character varying(6),
  curr_currency_id integer,
  nivel_organico_id integer,
  CONSTRAINT users_id_pk PRIMARY KEY (id),
  CONSTRAINT users_comp_id FOREIGN KEY (comp_comp_id)
      REFERENCES gestion.company (comp_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT users_curr_fk FOREIGN KEY (curr_currency_id)
      REFERENCES gestion.currency (currency_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT users_tip_fk FOREIGN KEY (type_id)
      REFERENCES gestion.type_users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT nivel_organico_fk FOREIGN KEY (nivel_organico_id)
      REFERENCES gestion.nivel_organico (nivel_organico_id)
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.users
  OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE gestion.cfg
(
  indicador character varying(10),
  operacion character varying(3),
  area character varying,
  division character varying,
  descripcion character varying,
  unidad character varying,
  tipo character varying,
  CONSTRAINT cfg_pk PRIMARY KEY (indicador)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.cfg
  OWNER TO postgres;
  

-- -------------------------------------------------------------------------------

CREATE TABLE gestion.indicador_nivel
(
  indicador character varying(10),
  nivel_organico_id integer NOT NULL,
  CONSTRAINT indicador_nivel_pk PRIMARY KEY (indicador, nivel_organico_id),
  CONSTRAINT nivel_fk FOREIGN KEY (nivel_organico_id)
      REFERENCES gestion.nivel_organico (nivel_organico_id)
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT cfg_fk FOREIGN KEY (indicador)
      REFERENCES gestion.cfg (indicador)
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.indicador_nivel
  OWNER TO postgres;

-- -------------------------------------------------------------------------------

CREATE TABLE gestion.plan
(
  plan_id serial NOT NULL,
  indicador character varying(10),
  fecha date,
  problema_encontrado character varying,
  impacto_discrepancia character varying,
  plan_accion character varying,
  tipo character varying,
  responsable character varying,
  resultado_esperado character varying,
  fecha_compromiso date,
  estado character varying,
  CONSTRAINT plan_pk PRIMARY KEY (plan_id),
  CONSTRAINT indicador_fk FOREIGN KEY (indicador)
      REFERENCES gestion.cfg (indicador)  
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (OIDS=FALSE); ALTER TABLE gestion.plan OWNER TO postgres;
 
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------

INSERT INTO gestion.region(region_id, descripcion) VALUES ('COL','COLOMBIA');
INSERT INTO gestion.region(region_id, descripcion) VALUES ('VEN','VENEZUELA');
INSERT INTO gestion.region(region_id, descripcion) VALUES ('PAN','PANAMA');
INSERT INTO gestion.region(region_id, descripcion) VALUES ('TRI','TRINIDAD');
INSERT INTO gestion.region(region_id, descripcion) VALUES ('GUA','GUATEMALA');

INSERT INTO gestion.company(comp_id, region_id, comp_desc, nit) VALUES ('1', 'COL', 'PAPELES NACIONALES S.A', '900.900.900.900');
INSERT INTO gestion.company(comp_id, region_id, comp_desc, nit) VALUES ('5', 'COL', 'GB BIOPACOL ANDINA S.A.S.', '900588276-4');
INSERT INTO gestion.company(comp_id, region_id, comp_desc, nit) VALUES ('10', 'VEN', 'PAPELES VENEZOLANOS C.A.', '900.900.900.900');
INSERT INTO gestion.company(comp_id, region_id, comp_desc, nit) VALUES ('24', 'VEN', 'DESARROLLOS FORESTALES S.C. II', '900.900.900.900');
INSERT INTO gestion.company(comp_id, region_id, comp_desc, nit) VALUES ('50', 'PAN', 'PAPELERA ISTMEÑA S.A.', '900.900.900.900');
INSERT INTO gestion.company(comp_id, region_id, comp_desc, nit) VALUES ('30', 'TRI', 'GRANDBAY PAPER PRODUCTS LIMITE', '900.900.900.900');
INSERT INTO gestion.company(comp_id, region_id, comp_desc, nit) VALUES ('33', 'TRI', 'TRINIDAD TISSUE', '900.900.900.900');
INSERT INTO gestion.company(comp_id, region_id, comp_desc, nit) VALUES ('12', 'GUA', 'PAPELERA LAT.DE NICARAGUA,S.A', '900.900.900.900');
INSERT INTO gestion.company(comp_id, region_id, comp_desc, nit) VALUES ('14', 'GUA', 'RED ECOLOGICA Y PAPEL S.A. COSTA RICA', '900.900.900.900');
INSERT INTO gestion.company(comp_id, region_id, comp_desc, nit) VALUES ('16', 'GUA', 'PAINSA EL SALVADOR,S.A.DE C.V.', '900.900.900.900');
INSERT INTO gestion.company(comp_id, region_id, comp_desc, nit) VALUES ('17', 'GUA', 'PAINSA DE HONDURAS,S.A.DE C.V.', '900.900.900.900');
INSERT INTO gestion.company(comp_id, region_id, comp_desc, nit) VALUES ('20', 'GUA', 'PAPELERA INTERNACIONAL, S.A.', '900.900.900.900');

INSERT INTO gestion.currency(currency_id, currency_desc) VALUES ('0', 'USD');
INSERT INTO gestion.currency(currency_id, currency_desc) VALUES ('1', 'LOCAL');
INSERT INTO gestion.type_users(id, descripcion) VALUES ('1', 'Usuario');
INSERT INTO gestion.type_users(id, descripcion)VALUES ('2', 'Regional');
INSERT INTO gestion.type_users(id, descripcion)VALUES ('3', 'Superuser');

INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('Saleman', 'Operational');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('Supervisor', 'Operational');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('District Manager', 'Tactical');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('Middle Manager', 'Tactical');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('Area Manager', 'Estrategic');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('General Manager', 'Estrategic');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('Regional V.P.', 'Estrategic');

INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id, nivel_organico_id) VALUES ('americo.valles', 'c4ca4238a0b923820dcc509a6f75849b','3' , '1', '1', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id, nivel_organico_id) VALUES ('hugo.barrios', 'c4ca4238a0b923820dcc509a6f75849b','3' , '1', '1', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id, nivel_organico_id) VALUES ('armando.hung', 'c4ca4238a0b923820dcc509a6f75849b','2' , '1', '1', '1');

INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id, nivel_organico_id) VALUES ('diana.contreras', 'c4ca4238a0b923820dcc509a6f75849b','2' , '1', '1', '1');

INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id, nivel_organico_id) VALUES ('ricauter.jurado', '643e8cff3f108b36b2b3aa816ecebe37','2' , '50', '1', '1');


INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN001', 'SUM', 'Comercial', '', 'Ventas', 'Own Cases', 'V');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN002', 'SUM', 'Comercial', '', 'Ventas', 'TM', 'V');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN003', 'SUM', 'Comercial', '', 'Venta Neta', 'USD', '$');

INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN004', 'SUM', 'Comercial', '', 'Salesman Perfo', 'USD', '$');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN005', 'SUM', 'Comercial', '', 'Descuentos, Promociones o Reembolsos', 'USD', '$');

INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN006', 'SUM', 'Comercial', '', 'Descuentos, Promociones o Reembolsos', 'USD', '$');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN007', 'AVG', 'Comercial', '', 'Cobertura de Clientes', '%', '%');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN008', 'AV2', 'Comercial', '', 'Precio Promedio', '%', '$');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN009', 'AV2', 'Comercial', '', 'Precio Promedio', 'USD/TM', '$');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN010', 'AV2', 'Comercial', '', 'Devoluciones', '%', '%');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN011', 'SUM', 'Comercial', '', 'Venta Perdida', 'Cases', 'V');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN012', 'AV2', 'Comercial', '', 'Cumplimiento del Forecast', '%', '%');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN013', 'AV2', 'Comercial', '', 'Cumplimiento del Presupuesto', '%', '%');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN014', 'AV2', 'Comercial', '', 'Precisión del Forecast', '%', '%');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN015', 'AV2', 'Comercial', '', 'Precisión del Presupuesto', '%', '%');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN016', 'SUM', 'Comercial', '', 'Estacionalidad de la Venta', 'Last Week', 'V');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN017', 'AVG', 'Comercial', '', 'Variabilidad de la Venta', '%', 'V');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN018', 'AVG', 'Comercial', '', 'Gastos de Ventas y Marketing', '% Revenue', '$');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN019', 'SUM', 'Comercial', '', 'Gastos de Ventas y Marketing', 'USD/Ton Sold.', 'V');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN020', 'SUM', 'Comercial', '', 'OSHA', '#', 'V');

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN001', 1);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN001', 2);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN001', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN001', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN001', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN001', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN001', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN002', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN002', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN002', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN002', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN002', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN003', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN003', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN003', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN003', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN004', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN004', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN004', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN004', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN005', 1);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN005', 2);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN005', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN005', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN005', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN005', 6);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN006', 1);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN006', 2);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN006', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN006', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN006', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN006', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN006', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN007', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN007', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN007', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN007', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN007', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN008', 1);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN008', 2);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN008', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN008', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN008', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN008', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN008', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN009', 1);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN009', 2);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN009', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN009', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN009', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN009', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN009', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN010', 1);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN010', 2);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN010', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN010', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN010', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN010', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN010', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN011', 1);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN011', 2);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN011', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN011', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN011', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN011', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN011', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN012', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN012', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN012', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN012', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN012', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN013', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN013', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN013', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN013', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN013', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN014', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN014', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN014', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN014', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN014', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN015', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN015', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN015', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN015', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN015', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN016', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN016', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN016', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN016', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN017', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN017', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN017', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN017', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN018', 1);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN018', 2);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN018', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN018', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN018', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN018', 6);

