import Data.LegalPerson;
import Data.PhysicalPerson;
import Db.DataSaveRepositoryDb;
import RepositoryFromu.Data.CommonSubject;
import RepositoryFromu.Data.FromuResponse;
import RepositoryFromu.RepositoryFile;
import Service.PropertyService;

import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) throws Exception {
        PropertyService.Initialization();

        LegalPerson.Separator = PropertyService.DbSeparator;
        PhysicalPerson.Separator = PropertyService.DbSeparator;

        RepositoryFile rf = new RepositoryFile(PropertyService.PathTempFile);
        FromuResponse fromuResponse = rf.GetResponse("temp/" + "fromu.xml");

        List<LegalPerson> legal = LegalPerson.ConvertCommonSubjectToLegalPerson(fromuResponse.Entities);
        List<PhysicalPerson> physical = PhysicalPerson.ConvertCommonSubjectToPhysicalPerson(fromuResponse.Entities);

        DataSaveRepositoryDb db = new DataSaveRepositoryDb(PropertyService.DbConnectProperty);
        db.AddLegalPerson(legal);
        db.AddPhysicalPerson(physical);
    }
}