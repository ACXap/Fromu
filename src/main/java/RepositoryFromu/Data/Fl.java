package RepositoryFromu.Data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Date;

public class Fl {

    @JacksonXmlProperty(localName = "ФИО")
    public String Fio;

    @JacksonXmlProperty(localName = "Фамилия")
    public String Surname;

    @JacksonXmlProperty(localName = "ФИОЛат")
    public String FioLat;

    @JacksonXmlProperty(localName = "ДатаРождения")
    public Date Birthday;

    @JacksonXmlProperty(localName = "ГодРождения")
    public String BirthYear;

    @JacksonXmlProperty(localName = "СписокДокументов")
    public Object ListDocum;

    @JacksonXmlProperty(localName = "СписокДрНаименований")
    public Object ListName;

    @JacksonXmlProperty(localName = "СписокГражданств")
    public Object ListNationality;
}