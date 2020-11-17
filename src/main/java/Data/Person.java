package Data;

import RepositoryFromu.Data.CommonSubject;

import java.util.Date;
import java.util.List;

public abstract class Person {
    public static String SEPARATOR = ",";

    public final int ListId;
    public final String Unc;
    public final String Note;
    public final String AllName;

    public final Date DateCreate;
    public final Date DateChange;

    public List<RepositoryFromu.Data.Address> Address;

    public Person(CommonSubject person) {
        ListId = person.Id;
        Unc =person.UNC;
        Note = person.Note;
        DateCreate = person.History.DateInput;
        DateChange = person.History.DateChange;
        Address = person.Address;
        AllName = GetAllName(person);
    }

    protected abstract String GetAllName(CommonSubject person);
}