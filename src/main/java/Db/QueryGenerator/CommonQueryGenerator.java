package Db.QueryGenerator;

import Interfaces.IQueryGenerator;

public abstract class CommonQueryGenerator implements IQueryGenerator {

    public CommonQueryGenerator(String schema) {
        TABLE_PEOPLE = schema + "compliance_people";
        TABLE_CATEGORIES = schema + "compliance_categories";
        TABLE_RELATIVES = schema + "compliance_relatives";
        TABLE_CONTACTS = schema + "compliance_contacts";
        TABLE_DELETED = schema + "compliance_deleted";
        TABLE_ADDRESS = schema + "compliance_address";
        TABLE_DOCUMENT = schema + "compliance_document";
        TABLE_RELATIVES_TYPE = schema + "compliance_relatives_type";
    }

    //region PrivateField
    protected final String TABLE_PEOPLE;
    protected final String TABLE_CATEGORIES;
    protected final String TABLE_RELATIVES;
    protected final String TABLE_CONTACTS;
    protected final String TABLE_DELETED;
    protected final String TABLE_ADDRESS;
    protected final String TABLE_DOCUMENT;
    protected final String TABLE_RELATIVES_TYPE;
    private final String INSERT_INTO = "INSERT INTO ";
    //endregion PrivateField

    public String GetQueryInsertPeople() {
        return INSERT_INTO + TABLE_PEOPLE
                + " (black_list_id,all_names,full_name,birth_date,birth_date_extra,birth_place,birth_place_extra,updated_at_sec,updated_at,dead,dead_date_extra)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?);";
    }

    public String GetQueryInsertContact() {
        return INSERT_INTO + TABLE_CONTACTS + " (black_list_id,contact,type) VALUES(?,?,?);";
    }

    public String GetQueryInsertRelative() {
        // удалили код типа связи, если не вернут, можно удалить эту строку
        //return INSERT_INTO + TABLE_RELATIVES + " (black_list_id,relative_black_list_id,type_relationship_id) VALUES(?,?,?);";

        return INSERT_INTO + TABLE_RELATIVES + " (black_list_id,relative_black_list_id,type_relationship_id) VALUES(?,?,(SELECT type_relationship_id FROM " + TABLE_RELATIVES_TYPE + " where type_relationship = ?));";
    }

    public String GetQueryInsertCategory() {
        return INSERT_INTO + TABLE_CATEGORIES + " (black_list_id,category) VALUES(?,?);";
    }

    public String GetQueryInsertPeopleAddress() {
        return INSERT_INTO + TABLE_ADDRESS + " (black_list_id,address_id,city,address,updated_at) VALUES(?,?,?,?,?);";
    }

    public String GetQueryInsertPeopleDocument() {
        return INSERT_INTO + TABLE_DOCUMENT + " (black_list_id,document_id,updated_at,date_start,date_end,name,mserial,number,common,issuing_country,issue) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
    }

    public String GetQueryInsertDeletedPeople() {
        return INSERT_INTO + TABLE_DELETED + " (black_list_id,updated_at_sec,merged_black_list_id) VALUES(?,?,?);";
    }

    public String GetQueryDeletePeople() {
        return String.format("DELETE FROM %s WHERE black_list_id=?;", TABLE_PEOPLE);
    }

    public String GetQueryDeleteDeletedPeople() {
        return String.format("DELETE FROM %s WHERE black_list_id=?;", TABLE_DELETED);
    }

    public abstract String GetQuerySelectLastUpdatePeople();

    public abstract String GetQuerySelectLastUpdateDeletedPeople();
}