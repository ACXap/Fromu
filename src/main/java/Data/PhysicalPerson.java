package Data;

import RepositoryFromu.Data.*;

import java.util.Date;
import java.util.List;

public class PhysicalPerson {
    public static String Separator = ",";

    public PhysicalPerson(CommonSubject person) {


    }

    public int ListId;
    public String Unc;
    public String Note;
    public String AllName;
    public Date DateCreate;
    public Date DateChange;
    public String AllBirthday;
    public String Nationality;

    public List<Address> Address;
    public List<RepositoryFromu.Data.PhysicalPerson.Docum> Documents;
}
