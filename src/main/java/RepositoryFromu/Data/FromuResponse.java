package RepositoryFromu.Data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Date;
import java.util.List;

public class FromuResponse {

    @JacksonXmlProperty(localName = "ВерсияФормата")
    public String Version;

    @JacksonXmlProperty(localName = "ДатаСписка")
    public Date CurrentDate;

    @JacksonXmlProperty(localName = "ДатаПредыдущегоСписка")
    public Date PreviousDate;

    @JacksonXmlElementWrapper(localName = "АктуальныйСписок")
    @JacksonXmlProperty(localName = "Субъект")
    public List<CommonSubject> Entities;
}