package Data;

import RepositoryFromu.Data.CommonSubject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Person {
    public static String SEPARATOR = ",";

    public final int ListId;
    public int IdDb;
    public final String Unc;
    public final String Note;
    public final String AllName;

    public final Date DateInput;
    public final Date DateChange;
    public final Date DateOutput;
    public Date DateList;

    public List<RepositoryFromu.Data.Address> Address;

    public Person(CommonSubject person) {
        ListId = person.Id;
        Unc = person.UNC;
        Note = person.Note;
        DateInput = person.History.DateInput;
        DateChange = person.History.DateChange;
        DateOutput = person.History.DateOutput;
        Address = person.Address;
        AllName = GetAllName(person);
    }

    protected abstract String GetAllName(CommonSubject person);

    protected void AddString(List<String> list, String data) {
        if (data != null && !data.isEmpty()) {
            list.add(data);
        }
    }
}