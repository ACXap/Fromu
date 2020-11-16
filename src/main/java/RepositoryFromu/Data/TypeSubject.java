package RepositoryFromu.Data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TypeSubject {

    @JacksonXmlProperty(localName = "Идентификатор")
    public int Id;

    @JacksonXmlProperty(localName = "Наименование")
    public String Name;
}
