import RepositoryFromu.Data.FromuResponse;
import RepositoryFromu.RepositoryFile;
import Service.PropertyService;

public class Program {
    public static void main(String[] args) throws Exception {

        PropertyService.Initialization();

        RepositoryFile rf = new RepositoryFile(PropertyService.PathTempFile);

        FromuResponse fromuResponse = rf.GetResponse();

        fromuResponse.Entities.forEach(c->System.out.println(c.Address));

    }
}
