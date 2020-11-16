import RepositoryFromu.Data.CommonSubject;
import RepositoryFromu.Data.FromuResponse;
import RepositoryFromu.RepositoryFile;
import Service.PropertyService;

import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) throws Exception {
        PropertyService.Initialization();

        RepositoryFile rf = new RepositoryFile(PropertyService.PathTempFile);
        FromuResponse fromuResponse = rf.GetResponse( "temp/" + "fromu.xml");

        List<CommonSubject> collect = fromuResponse.Entities.stream().filter(c -> c.Fl != null).collect(Collectors.toList());

        collect.forEach(p->System.out.println(p.Address));
    }
}