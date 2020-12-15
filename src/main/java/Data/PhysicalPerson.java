package Data;

import RepositoryFromu.Data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhysicalPerson extends Person {

    public PhysicalPerson(CommonSubject person) {
       super(person);

        Nationality = GetNationality(person);
        AllBirthday = GetAllBirthday(person.Fl);
        Documents = person.Fl.listDocuments;
    }

    public static List<PhysicalPerson> ConvertCommonSubjectToPhysicalPerson(List<CommonSubject> subject) {
        return subject.parallelStream().filter(s -> s.Fl != null).map(PhysicalPerson::new).collect(Collectors.toList());
    }


    public final String AllBirthday;
    public final String Nationality;
    public final List<RepositoryFromu.Data.PhysicalPerson.Documents> Documents;

    private String GetAllBirthday(RepositoryFromu.Data.PhysicalPerson fl) {
        List<String> birthdays = new ArrayList<>();

        if (fl.Birthday != null) {
            birthdays.add(fl.Birthday);

            if (!fl.Birthday.equals(fl.BirthYear)) {
                birthdays.add(fl.BirthYear);
            }
        }

        if (fl.ListOtherName != null && !fl.ListOtherName.isEmpty()) {
            birthdays.addAll(fl.ListOtherName.stream().filter(p -> p.Birthday != null && !p.Birthday.isEmpty()).map(p -> p.Birthday).distinct().collect(Collectors.toList()));
            birthdays.addAll(fl.ListOtherName.stream().filter(p -> p.BirthYear != null && !p.BirthYear.isEmpty()).map(p -> p.BirthYear).distinct().collect(Collectors.toList()));
        }

        if (birthdays.size() > 0) return birthdays.stream().distinct().collect(Collectors.joining(SEPARATOR));


        return null;
    }

    @Override
    protected String GetAllName(CommonSubject person) {
        List<String> names = new ArrayList<>();
        RepositoryFromu.Data.PhysicalPerson fl = person.Fl;

        names.add(fl.Fio);

        if (!fl.FioLat.equals(fl.Fio)) {
            names.add(fl.FioLat);
        }

        if (!fl.Surname.equals(fl.Fio)) {
            names.add(fl.Surname);
        }

        if (fl.ListOtherName != null && !fl.ListOtherName.isEmpty()) {
            names.addAll(fl.ListOtherName.stream().filter(p -> p.Fio != null && !p.Fio.isEmpty()).map(p -> p.Fio).distinct().collect(Collectors.toList()));
        }

        return names.stream().distinct().collect(Collectors.joining(SEPARATOR));
    }

    private String GetNationality(CommonSubject person) {
        if (person.Fl.ListNationality == null || person.Fl.ListNationality.isEmpty()) return null;

        return person.Fl.ListNationality.stream().distinct().collect(Collectors.joining(SEPARATOR));
    }
}