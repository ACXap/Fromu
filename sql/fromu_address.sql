-- Drop table

-- DROP TABLE cdi.fromu_address;

CREATE TABLE cdi.fromu_address (
	id serial NOT NULL, -- Идентификатор записи адреса
	list_id int4 NULL, -- Идентификатор записи лица из источника
	type_id int4 NULL, -- Идентификатор типа адреса
	text_address varchar NULL, -- Текст адреса
	country_id varchar NULL, -- Идентификатор страны
	address_type varchar NULL, -- Тип адреса
	addr_actual_date date NULL DEFAULT CURRENT_DATE, -- Дата создания записи в MDS
	person_id int4 NULL, -- Идентификатор записи лица
	CONSTRAINT fromu_address_pk PRIMARY KEY (id)
);
COMMENT ON TABLE cdi.fromu_address IS 'Таблица адресов для лиц';

-- Column comments

COMMENT ON COLUMN cdi.fromu_address.id IS 'Идентификатор записи адреса';
COMMENT ON COLUMN cdi.fromu_address.list_id IS 'Идентификатор записи лица из источника';
COMMENT ON COLUMN cdi.fromu_address.type_id IS 'Идентификатор типа адреса';
COMMENT ON COLUMN cdi.fromu_address.text_address IS 'Текст адреса';
COMMENT ON COLUMN cdi.fromu_address.country_id IS 'Идентификатор страны';
COMMENT ON COLUMN cdi.fromu_address.address_type IS 'Тип адреса';
COMMENT ON COLUMN cdi.fromu_address.addr_actual_date IS 'Дата создания записи в MDS';
COMMENT ON COLUMN cdi.fromu_address.person_id IS 'Идентификатор записи лица';
