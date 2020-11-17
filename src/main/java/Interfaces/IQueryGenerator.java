package Interfaces;

/**
 * Интерфейс взаимодействия с генератором SQL запросов
 */
public interface IQueryGenerator {


    String GetQueryInsertLegal();

    String GetQueryInsertPhysical();

    String GetQueryInsertPhysicalDocuments();
}