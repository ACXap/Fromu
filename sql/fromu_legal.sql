-- Drop table

-- DROP TABLE cdi.fromu_legal;

CREATE TABLE cdi.fromu_legal (
	id int4 NOT NULL DEFAULT nextval('cdi.fromu_common_id_seq'::regclass), -- Идентификатор записи юридического лица
	list_id int4 NOT NULL, -- Идентификатор записи в источнике
	unc varchar NULL, -- УНС
	all_name varchar NULL, -- Все наименования
	date_create date NULL, -- Дата включения
	date_change date NULL, -- Дата модификации
	note varchar NULL, -- Примечание
	changedate date NULL DEFAULT CURRENT_DATE, -- Дата создания записи в MDS
	CONSTRAINT fromu_legal_pk PRIMARY KEY (list_id)
);
COMMENT ON TABLE cdi.fromu_legal IS 'Таблица юридических лиц';

-- Column comments

COMMENT ON COLUMN cdi.fromu_legal.id IS 'Идентификатор записи юридического лица';
COMMENT ON COLUMN cdi.fromu_legal.list_id IS 'Идентификатор записи в источнике';
COMMENT ON COLUMN cdi.fromu_legal.unc IS 'УНС';
COMMENT ON COLUMN cdi.fromu_legal.all_name IS 'Все наименования';
COMMENT ON COLUMN cdi.fromu_legal.date_create IS 'Дата включения';
COMMENT ON COLUMN cdi.fromu_legal.date_change IS 'Дата модификации';
COMMENT ON COLUMN cdi.fromu_legal.note IS 'Примечание';
COMMENT ON COLUMN cdi.fromu_legal.changedate IS 'Дата создания записи в MDS';
