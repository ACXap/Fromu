package RepositoryFromu.Data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Address {

    @JacksonXmlProperty(localName = "ТипАдреса")
    public TypeAddress TypeAddress;

    @JacksonXmlProperty(localName = "ТекстАдреса")
    public String TextAddress;

    @JacksonXmlProperty(localName = "Страна")
    public Country Country;

    @JacksonXmlProperty(localName = "ИдентификаторФИАС")
    public String FiasId;
    @JacksonXmlProperty(localName = "УровеньАдреснОбъекта")
    public Integer AddressLevel;
    @JacksonXmlProperty(localName = "Индекс")
    public String PostIndex;
    @JacksonXmlProperty(localName = "ОКАТО")
    public String Okato;
    @JacksonXmlProperty(localName = "Регион")
    public String Region;
    @JacksonXmlProperty(localName = "АвтономныйОкруг")
    public String AutonomousRegion;
    @JacksonXmlProperty(localName = "Район")
    public String RegionRegion;
    @JacksonXmlProperty(localName = "Город")
    public String City;
    @JacksonXmlProperty(localName = "ВнутригородскРайон")
    public String CityRegion;
    @JacksonXmlProperty(localName = "НаселПункт")
    public String Settlement;
    @JacksonXmlProperty(localName = "Улица")
    public String Street;
    @JacksonXmlProperty(localName = "Дом")
    public String House;
    @JacksonXmlProperty(localName = "Корпус")
    public String Corpus;
    @JacksonXmlProperty(localName = "Строение")
    public String Building;
    @JacksonXmlProperty(localName = "Помещение")
    public String Room;

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