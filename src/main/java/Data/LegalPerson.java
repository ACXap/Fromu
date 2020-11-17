package Data;

import RepositoryFromu.Data.Address;
import RepositoryFromu.Data.CommonSubject;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class LegalPerson extends Person {

    public LegalPerson(CommonSubject person) {
        super(person);
    }

    public static List<LegalPerson> ConvertCommonSubjectToLegalPerson(List<CommonSubject> subject){
       return subject.parallelStream().filter(s->s.Ul!=null).map(LegalPerson::new).collect(Collectors.toList());
    }

    @Override
    protected String GetAllName(CommonSubject person) {
        if (person.Ul.Name.equals(person.Ul.NamLat)) return person.Ul.Name;

        return person.Ul.Name + SEPARATOR + person.Ul.NamLat;
    }
}