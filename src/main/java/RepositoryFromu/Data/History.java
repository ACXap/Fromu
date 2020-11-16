package RepositoryFromu.Data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Date;

public class History {

    @JacksonXmlProperty(localName = "ДатаВключения")
    public Date DateInput;

    @JacksonXmlProperty(localName = "ДатаМодификации")
    public Date DateChange;
}
