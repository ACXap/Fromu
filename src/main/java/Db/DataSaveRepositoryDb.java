package Db;

import Data.DbConnectProperty;
import Data.LegalPerson;
import Data.Person;
import Data.PhysicalPerson;
import Interfaces.IQueryGenerator;
import Interfaces.ISaveDataRepository;
import RepositoryFromu.Data.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public void DeleteData() throws SQLException {
        Connection con = _dbConnectProperty.GetConnection();

        try {
            con.setAutoCommit(false);

            String query = _queryGenerator.GetQueryDeleteData();

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.execute();
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

    @Override
    public void AddLegalPerson(List<LegalPerson> persons) throws SQLException {
        Connection con = _dbConnectProperty.GetConnection();

        try {
            con.setAutoCommit(false);

            AddLegal(persons, con);
            AddAddress(persons, con);

            con.commit();
        } catch (SQLException sex) {
            con.rollback();
            con.close();
            throw sex;
        } finally {
            con.close();
        }
    }

    @Override
    public void AddPhysicalPerson(List<PhysicalPerson> persons) throws SQLException {
        Connection con = _dbConnectProperty.GetConnection();

        try {
            con.setAutoCommit(false);

            AddPhysical(persons, con);
            AddPhysicalDocument(persons, con);
            AddAddress(persons, con);

            con.commit();
        } catch (SQLException sex) {
            con.rollback();
            con.close();
            throw sex;
        } finally {
            con.close();
        }
    }

    private void AddPhysicalDocument(List<PhysicalPerson> persons, Connection con) throws SQLException {
        String query = _queryGenerator.GetQueryInsertPhysicalDocuments();

        try (PreparedStatement ps = con.prepareStatement(query)) {

            for (PhysicalPerson p : persons) {
                if (p.Documents == null || p.Documents.isEmpty()) continue;

                for (RepositoryFromu.Data.PhysicalPerson.Documents d : p.Documents) {
                    int parameterIndex = 1;

                    ps.setInt(parameterIndex++, p.ListId);
                    ps.setInt(parameterIndex++, d.TypeDocuments.Id);
                    ps.setString(parameterIndex++, d.Number);
                    ps.setString(parameterIndex++, d.Organ);
                    ps.setObject(parameterIndex++, GetSqlDate(d.Date));
                    ps.setObject(parameterIndex++, d.TypeDocuments.Name);
                    ps.setObject(parameterIndex++, d.Series);
                    ps.setInt(parameterIndex++, p.IdDb);

                    ps.addBatch();
                }
            }

            ps.executeBatch();
        }
    }

    private void AddPhysical(List<PhysicalPerson> persons, Connection con) throws SQLException {
        String query = _queryGenerator.GetQueryInsertPhysical();

        String[] generatedKeys = {"id"};

        try (PreparedStatement ps = con.prepareStatement(query,generatedKeys)) {

            for (PhysicalPerson p : persons) {

                int parameterIndex = 1;
                ps.setInt(parameterIndex++, p.ListId);
                ps.setString(parameterIndex++, p.Unc);
                ps.setString(parameterIndex++, p.AllName);
                ps.setString(parameterIndex++, p.AllBirthday);
                ps.setString(parameterIndex++, p.Nationality);
                ps.setObject(parameterIndex++, GetSqlDate(p.DateCreate));
                ps.setObject(parameterIndex++, GetSqlDate(p.DateChange));
                ps.setString(parameterIndex, p.Note);

                ps.addBatch();
            }
            ps.executeBatch();

            ResultSet keys = ps.getGeneratedKeys();
            for (PhysicalPerson c : persons) {
                keys.next();
                c.IdDb = keys.getInt(1);
            }
        }
    }

    private void AddLegal(List<LegalPerson> persons, Connection con) throws SQLException {
        String query = _queryGenerator.GetQueryInsertLegal();

        String[] generatedKeys = {"id"};

        try (PreparedStatement ps = con.prepareStatement(query,generatedKeys)) {
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

            ResultSet keys = ps.getGeneratedKeys();
            for (LegalPerson c : persons) {
                keys.next();
                c.IdDb = keys.getInt(1);
            }
        }
    }

    private <T extends Person> void AddAddress(List<T> persons, Connection con) throws SQLException{
        String query = _queryGenerator.GetQueryInsertAddress();

        try (PreparedStatement ps = con.prepareStatement(query)) {

            for (Person p : persons) {
                if (p.Address == null || p.Address.isEmpty()) continue;

                for (Address a : p.Address) {
                    int parameterIndex = 1;

                    ps.setInt(parameterIndex++, p.ListId);
                    ps.setInt(parameterIndex++, a.TypeAddress.Id);
                    ps.setString(parameterIndex++, a.TextAddress);
                    ps.setObject(parameterIndex++, GetCountryCode(a.Country));
                    ps.setObject(parameterIndex++, a.TypeAddress.Name);
                    ps.setInt(parameterIndex++, p.IdDb);

                    ps.addBatch();
                }
            }

            ps.executeBatch();
        }
    }

    private Object GetCountryCode(Address.Country country) {
        if(country== null) return  null;

        return country.Code;
    }

    private Object GetSqlDate(Date date) {
        if (date != null) {
            return new java.sql.Date(date.getTime());
        }

        return null;
    }
}