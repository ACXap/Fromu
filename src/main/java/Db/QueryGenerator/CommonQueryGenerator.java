package Db.QueryGenerator;

import Interfaces.IQueryGenerator;

public class CommonQueryGenerator implements IQueryGenerator {

    public CommonQueryGenerator(String schema) {
        TABLE_LEGAL = schema + "fromu_legal";
        TABLE_PHYSICAL = schema + "fromu_physical";
        TABLE_PHYSICAL_DOCUMENT = schema + "fromu_physical_document";
        TABLE_ADDRESS = schema + "fromu_address";

    }

    //region PrivateField
    protected final String TABLE_LEGAL;
    protected final String TABLE_PHYSICAL;
    protected final String TABLE_PHYSICAL_DOCUMENT;
    protected final String TABLE_ADDRESS;

    private final String INSERT_INTO = "INSERT INTO ";
    //endregion PrivateField

    @Override
    public String GetQueryInsertLegal() {
        return INSERT_INTO + TABLE_LEGAL
                + " (list_id,unc,all_name,date_create,date_change, note)"
                + " VALUES(?,?,?,?,?,?);";
    }

    @Override
    public String GetQueryInsertPhysical() {
        return INSERT_INTO + TABLE_PHYSICAL
                + " (list_id,unc,all_name,all_birthdates,all_nationality,date_create,date_change,note)"
                + " VALUES(?,?,?,?,?,?,?,?);";
    }

    @Override
    public String GetQueryInsertPhysicalDocuments() {
        return INSERT_INTO + TABLE_PHYSICAL_DOCUMENT
                + " (list_id,type_id,number,organ,date_issue,document_type,series,person_id)"
                + " VALUES(?,?,?,?,?,?,?,?);";
    }

    @Override
    public String GetQueryInsertAddress() {
        return INSERT_INTO + TABLE_ADDRESS
                + " (list_id,type_id,text_address,country_id,address_type,person_id)"
                + " VALUES(?,?,?,?,?,?);";
    }

    @Override
    public String GetQueryDeleteData() {
        String delete = "DELETE FROM ";
        return delete + TABLE_LEGAL + ";" +
                delete + TABLE_PHYSICAL + ";" +
                delete + TABLE_PHYSICAL_DOCUMENT + ";"+
                delete + TABLE_ADDRESS + ";";
    }
}