package RepositoryFromu.Data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Date;
import java.util.List;

public class CommonSubject {

    @JacksonXmlProperty(localName = "ИдСубъекта")
    public int Id;

    @JacksonXmlProperty(localName = "УНС")
    public String UNC;

    @JacksonXmlProperty(localName = "ТипСубъекта")
    public TypeSubject TypeSubject;

    @JacksonXmlProperty(localName = "История")
    public History History;

    @JacksonXmlProperty(localName = "Примечание")
    public String Note;

    @JacksonXmlProperty(localName = "СписокАдресов")
    public List<Address> Address;

    @JacksonXmlProperty(localName = "ФЛ")
    public Fl Fl;

    @JacksonXmlProperty(localName = "ЮЛ")
    public Ul Ul;

    public static class TypeSubject {

        @JacksonXmlProperty(localName = "Идентификатор")
        public int Id;

        @JacksonXmlProperty(localName = "Наименование")
        public String Name;
    }

    public static class History {

        @JacksonXmlProperty(localName = "ДатаВключения")
        public Date DateInput;

        @JacksonXmlProperty(localName = "ДатаМодификации")
        public Date DateChange;
    }
}