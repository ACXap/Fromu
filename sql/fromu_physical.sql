-- Drop table

-- DROP TABLE cdi.fromu_physical;

CREATE TABLE cdi.fromu_physical (
	id int4 NOT NULL DEFAULT nextval('cdi.fromu_common_id_seq'::regclass), -- Идентификатор записи физического лица
	list_id int4 NOT NULL, -- Идентификатор записи в источнике
	unc varchar NULL, -- УНС
	all_name varchar NULL, -- Все имена
	all_birthdates varchar NULL, -- Все дни рождения
	all_nationality varchar NULL, -- Все гражданства
	date_create date NULL, -- Дата включения
	date_change date NULL, -- Дата модификации
	note varchar NULL, -- Примечание
	changedate date NULL DEFAULT CURRENT_DATE, -- Дата создания записи в MDS
	CONSTRAINT fromu_physical_pk PRIMARY KEY (list_id)
);
COMMENT ON TABLE cdi.fromu_physical IS 'Таблица физических лиц';

-- Column comments

COMMENT ON COLUMN cdi.fromu_physical.id IS 'Идентификатор записи физического лица';
COMMENT ON COLUMN cdi.fromu_physical.list_id IS 'Идентификатор записи в источнике';
COMMENT ON COLUMN cdi.fromu_physical.unc IS 'УНС';
COMMENT ON COLUMN cdi.fromu_physical.all_name IS 'Все имена';
COMMENT ON COLUMN cdi.fromu_physical.all_birthdates IS 'Все дни рождения';
COMMENT ON COLUMN cdi.fromu_physical.all_nationality IS 'Все гражданства';
COMMENT ON COLUMN cdi.fromu_physical.date_create IS 'Дата включения';
COMMENT ON COLUMN cdi.fromu_physical.date_change IS 'Дата модификации';
COMMENT ON COLUMN cdi.fromu_physical.note IS 'Примечание';
COMMENT ON COLUMN cdi.fromu_physical.changedate IS 'Дата создания записи в MDS';
