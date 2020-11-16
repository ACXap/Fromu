package Db;

import Data.DbConnectProperty;
import Data.LegalPerson;
import Interfaces.IQueryGenerator;
import Interfaces.ISaveDataRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DataSaveRepositoryDb implements ISaveDataRepository {

    public DataSaveRepositoryDb(DbConnectProperty dbConnectProperty) throws Exception {
        _dbConnectProperty = dbConnectProperty;
        _queryGenerator = _dbConnectProperty.GetQueryGenerator();
    }

    //region PrivateField
    protected final IQueryGenerator _queryGenerator;
    protected final DbConnectProperty _dbConnectProperty;
    //endregion PrivateField

    @Override
    public void AddLegalPerson(List<LegalPerson> persons) throws SQLException {
        Connection con = _dbConnectProperty.GetConnection();
        try {
            con.setAutoCommit(false);

            String query = _queryGenerator.GetQueryInsertLegal();

            try (PreparedStatement ps = con.prepareStatement(query)) {
                for (LegalPerson p : persons) {

                    int parameterIndex = 1;
                    ps.setInt(parameterIndex++, p.ListId);
                    ps.setString(parameterIndex++, p.Unc);
                    ps.setString(parameterIndex++, p.AllName);
                    ps.setObject(parameterIndex++, GetSqlDate(p.DateCreate));
                    ps.setObject(parameterIndex++, GetSqlDate(p.DateChange));
                    ps.setString(parameterIndex, p.Note);

                    ps.addBatch();
                }
                ps.executeBatch();
            }

            con.commit();
        } catch (SQLException sex) {
            con.rollback();
            con.close();
            throw sex;
        } finally {
            con.close();
        }
    }

    private Object GetSqlDate(Date date) {
        if (date != null) {
            return new java.sql.Date(date.getTime());
        }

        return null;
    }
}