package Interfaces;

import Data.LegalPerson;

import java.sql.SQLException;
import java.util.List;

public interface ISaveDataRepository {

    void AddLegalPerson(List<LegalPerson> persons) throws SQLException;

}
