package Db.QueryGenerator;


public class QueryGeneratorPostgreSql extends CommonQueryGenerator {

    public QueryGeneratorPostgreSql(String schema) {
        super(schema);
    }

    private final String _selectLastUpdate = "SELECT updated_at_sec FROM %s ORDER by updated_at_sec DESC LIMIT 1;";

    public String GetQuerySelectLastUpdatePeople() {
        return String.format(_selectLastUpdate, TABLE_PEOPLE);
    }

    public String GetQuerySelectLastUpdateDeletedPeople() {
        return String.format(_selectLastUpdate, TABLE_DELETED);
    }
}