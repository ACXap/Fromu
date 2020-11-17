package RepositoryFromu.Data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Date;
import java.util.List;

public class PhysicalPerson {

    @JacksonXmlProperty(localName = "ФИО")
    public String Fio;

    @JacksonXmlProperty(localName = "Фамилия")
    public String Surname;

    @JacksonXmlProperty(localName = "ФИОЛат")
    public String FioLat;

    @JacksonXmlProperty(localName = "ДатаРождения")
    public String Birthday;

    @JacksonXmlProperty(localName = "ГодРождения")
    public String BirthYear;

    @JacksonXmlProperty(localName = "СписокДокументов")
    public List<Documents> listDocuments;

    @JacksonXmlProperty(localName = "СписокДрНаименований")
    public List<OtherName> ListOtherName;

    @JacksonXmlElementWrapper(localName = "СписокГражданств")
    @JacksonXmlProperty(localName = "Гражданство")
    public List<String> ListNationality;

    public static class OtherName{
        @JacksonXmlProperty(localName = "ФИО")
        public String Fio;

        @JacksonXmlProperty(localName = "ДатаРождения")
        public String Birthday;

        @JacksonXmlProperty(localName = "ГодРождения")
        public String BirthYear;
    }

    public static class Documents {

        @JacksonXmlProperty(localName = "ТипДокумента")
        public TypeDocuments TypeDocuments;

        @JacksonXmlProperty(localName = "Номер")
        public String Number;

        @JacksonXmlProperty(localName = "ОрганВыдачи")
        public String Organ;

        @JacksonXmlProperty(localName = "ДатаВыдачи")
        public Date Date;

        public static class TypeDocuments {
            @JacksonXmlProperty(localName = "Идентификатор")
            public int Id;

            @JacksonXmlProperty(localName = "Наименование")
            public String Name;
        }
    }
}