package RepositoryFromu.Data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class LegalPerson {

    @JacksonXmlProperty(localName = "Наименование")
    public String Name;

    @JacksonXmlProperty(localName = "НаименованиеЛат")
    public String NamLat;
}