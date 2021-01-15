package Data;

import RepositoryFromu.Data.CommonSubject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LegalPerson extends Person {

    public LegalPerson(CommonSubject person) {
        super(person);

        AllInn = GetAllInn(person.Ul);
        AllOgrn = GetAllOgrn(person.Ul);
    }

    public String AllInn;
    public String AllOgrn;

    private String GetAllOgrn(RepositoryFromu.Data.LegalPerson ul) {
        return ul.Ogrn;
    }

    private String GetAllInn(RepositoryFromu.Data.LegalPerson ul) {
        List<String> list = new ArrayList<>();
        AddString(list, ul.Inn);

        if (ul.ListOtherName != null && !ul.ListOtherName.isEmpty()) {
            ul.ListOtherName.forEach(e -> AddString(list, e.Inn));
        }

     String result = list.stream().distinct().collect(Collectors.joining(SEPARATOR));


        return result.isEmpty() ? null: result;
    }

    public static List<LegalPerson> ConvertCommonSubjectToLegalPerson(List<CommonSubject> subject) {
        return subject.parallelStream().filter(s -> s.Ul != null).map(LegalPerson::new).collect(Collectors.toList());
    }

    @Override
    protected String GetAllName(CommonSubject person) {
        List<String> list = new ArrayList<>();

        RepositoryFromu.Data.LegalPerson p = person.Ul;

        AddString(list, p.Name);
        AddString(list, p.NamLat);

        if (p.ListOtherName != null && !p.ListOtherName.isEmpty()) {
            p.ListOtherName.forEach(e -> {
                AddString(list, e.Name);
                AddString(list, e.NamLat);
            });
        }

        return list.stream().distinct().collect(Collectors.joining(SEPARATOR));
    }
}