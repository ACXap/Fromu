package Db.QueryGenerator;

import Interfaces.IQueryGenerator;

public class CommonQueryGenerator implements IQueryGenerator {

    public CommonQueryGenerator(String schema) {
        TABLE_LEGAL = schema + "fromu_legal";

    }

    //region PrivateField
    protected final String TABLE_LEGAL;
    private final String INSERT_INTO = "INSERT INTO ";
    //endregion PrivateField

    public String GetQueryInsertLegal() {
        return INSERT_INTO + TABLE_LEGAL
                + " (list_id,unc,all_name,date_create,date_change, note)"
                + " VALUES(?,?,?,?,?,?);";
    }

}