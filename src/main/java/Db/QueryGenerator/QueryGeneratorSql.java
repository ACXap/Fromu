package Db.QueryGenerator;

public class QueryGeneratorSql extends CommonQueryGenerator {

    public QueryGeneratorSql(String schema) {
        super(schema);
    }

    private final String _selectLastUpdate = "SELECT MAX(updated_at_sec) FROM ";

    public String GetQuerySelectLastUpdatePeople() {
        return _selectLastUpdate + TABLE_PEOPLE;
    }

    public String GetQuerySelectLastUpdateDeletedPeople() {
        return _selectLastUpdate + TABLE_DELETED;
    }
}