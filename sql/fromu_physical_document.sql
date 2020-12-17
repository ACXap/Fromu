-- Drop table

-- DROP TABLE cdi.fromu_physical_document;

CREATE TABLE cdi.fromu_physical_document (
	id serial NOT NULL, -- Идентификатор записи документа
	list_id int4 NOT NULL, -- Идентификатор записи физического лица из источника
	type_id int4 NULL, -- Идентификатор типа документа
	"number" varchar NULL, -- Номер документа
	organ varchar NULL, -- Кем выдан
	date_issue date NULL, -- Когда выдан
	document_type varchar NULL, -- Тип документа
	series varchar NULL, -- Серия документа
	doc_actual_date date NULL DEFAULT CURRENT_DATE, -- Дата создания записи в MDS
	person_id int4 NULL, -- Идентификатор записи лица
	CONSTRAINT fromu_physical_document_pk PRIMARY KEY (id),
	CONSTRAINT fromu_physical_document_fk FOREIGN KEY (list_id) REFERENCES cdi.fromu_physical(list_id) ON DELETE CASCADE
);
COMMENT ON TABLE cdi.fromu_physical_document IS 'Таблица документов физических лиц';

-- Column comments

COMMENT ON COLUMN cdi.fromu_physical_document.id IS 'Идентификатор записи документа';
COMMENT ON COLUMN cdi.fromu_physical_document.list_id IS 'Идентификатор записи физического лица из источника';
COMMENT ON COLUMN cdi.fromu_physical_document.type_id IS 'Идентификатор типа документа';
COMMENT ON COLUMN cdi.fromu_physical_document."number" IS 'Номер документа';
COMMENT ON COLUMN cdi.fromu_physical_document.organ IS 'Кем выдан';
COMMENT ON COLUMN cdi.fromu_physical_document.date_issue IS 'Когда выдан';
COMMENT ON COLUMN cdi.fromu_physical_document.document_type IS 'Тип документа';
COMMENT ON COLUMN cdi.fromu_physical_document.series IS 'Серия документа';
COMMENT ON COLUMN cdi.fromu_physical_document.doc_actual_date IS 'Дата создания записи в MDS';
COMMENT ON COLUMN cdi.fromu_physical_document.person_id IS 'Идентификатор записи лица';
