import Data.LegalPerson;
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

        RepositoryFile rf = new RepositoryFile(PropertyService.PathTempFile);
        FromuResponse fromuResponse = rf.GetResponse( "temp/" + "fromu.xml");

       // List<CommonSubject> collect = fromuResponse.Entities.stream().filter(c -> c.Fl != null).collect(Collectors.toList());

       // collect.forEach(p->System.out.println(p.Address));

        List<LegalPerson> legal = LegalPerson.ConvertCommonSubjectToLegalPerson(fromuResponse.Entities);

        DataSaveRepositoryDb db = new DataSaveRepositoryDb(PropertyService.DbConnectProperty);

        db.AddLegalPerson(legal);
    }
}