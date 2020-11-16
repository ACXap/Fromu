package RepositoryFromu.Data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Address {

    @JacksonXmlProperty(localName = "ТипАдреса")
    public TypeAddress TypeAddress;

    @JacksonXmlProperty(localName = "ТекстАдреса")
    public String TextAddress;

    @JacksonXmlProperty(localName = "Страна")
    public Country Country;

    public static class TypeAddress {
        @JacksonXmlProperty(localName = "Идентификатор")
        public int Id;

        @JacksonXmlProperty(localName = "Наименование")
        public String Name;
    }

    public static class Country{

        @JacksonXmlProperty(localName = "Код")
        public String Code;

        @JacksonXmlProperty(localName = "Наименование")
        public String Name;
    }
}