package RepositoryFromu.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


@JsonIgnoreProperties(value = { "ЮЛ", "ФЛ"})
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
    public Object Address;
}
