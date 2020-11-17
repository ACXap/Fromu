package Data;

import RepositoryFromu.Data.Address;
import RepositoryFromu.Data.CommonSubject;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class LegalPerson {
    public static String Separator = ",";

    public LegalPerson(CommonSubject person) {
        ListId = person.Id;
        Unc = person.UNC;
        Note = person.Note;
        DateChange = person.History.DateChange;
        DateCreate = person.History.DateInput;
        Address = person.Address;
        AllName = GetAllName(person);
    }

    public static List<LegalPerson> ConvertCommonSubjectToLegalPerson(List<CommonSubject> subject){
       return subject.parallelStream().filter(s->s.Ul!=null).map(LegalPerson::new).collect(Collectors.toList());
    }

    private String GetAllName(CommonSubject person) {
        if (person.Ul.Name.equals(person.Ul.NamLat)) return person.Ul.Name;

        return person.Ul.Name + Separator + person.Ul.NamLat;
    }

    public final int ListId;
    public final String Unc;
    public final String Note;
    public final String AllName;
    public final Date DateCreate;
    public final Date DateChange;
    public List<Address> Address;
}