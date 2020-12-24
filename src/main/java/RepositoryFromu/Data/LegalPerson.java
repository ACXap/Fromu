package RepositoryFromu.Data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class LegalPerson {

    @JacksonXmlProperty(localName = "Наименование")
    public String Name;

    @JacksonXmlProperty(localName = "НаименованиеЛат")
    public String NamLat;

    @JacksonXmlProperty(localName = "ИНН")
    public String Inn;

    @JacksonXmlProperty(localName = "ОГРН")
    public String Ogrn;

    @JacksonXmlProperty(localName = "СписокДрНаименований")
    public List<OtherName> ListOtherName;

    public static class OtherName{
        @JacksonXmlProperty(localName = "Наименование")
        public String Name;

        @JacksonXmlProperty(localName = "НаименованиеЛат")
        public String NamLat;

        @JacksonXmlProperty(localName = "ИНН")
        public String Inn;
    }
}