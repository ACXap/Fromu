package Interfaces;

/**
 * Интерфейс взаимодействия с генератором SQL запросов
 */
public interface IQueryGenerator {

    /**
     * Получить строку запроса для вставки данных человека
     *
     * @return Строка запроса для PreparedStatement
     */
    String GetQueryInsertPeople();

    /**
     * Получить строку запроса для вставки категории человека
     *
     * @return Строка запроса для PreparedStatement
     */
    String GetQueryInsertCategory();

    /**
     * Получить строку запроса для вставки близких связей человека
     *
     * @return Строка запроса для PreparedStatement
     */
    String GetQueryInsertRelative();

    /**
     * Получить строку запроса для вставки родственника человека
     *
     * @return Строка запроса для PreparedStatement
     */
    String GetQueryInsertContact();

    /**
     * Получить строку запроса для вставки адресов физических лиц
     *
     * @return Строка запроса для PreparedStatement
     */
    String GetQueryInsertPeopleAddress();

    /**
     * Получить строку запроса для вставки документов физических лиц
     *
     * @return Строка запроса для PreparedStatement
     */
    String GetQueryInsertPeopleDocument();

    /**
     * Получить строку запроса для вставки данных удаленного человека
     *
     * @return Строка запроса для PreparedStatement
     */
    String GetQueryInsertDeletedPeople();

    /**
     * Получить строку запроса для удаления человека
     *
     * @return Строка запроса для PreparedStatement
     */
    String GetQueryDeletePeople();

    /**
     * Получить строку запроса для удаления удаленного человека
     *
     * @return Строка запроса для PreparedStatement
     */
    String GetQueryDeleteDeletedPeople();

    /**
     * Получить строку запроса для получения последней даты обновления записи в таблице о людях
     *
     * @return Строка запроса
     */
    String GetQuerySelectLastUpdatePeople();

    /**
     * Получить строку запроса для получения последней даты обновления записи в таблице о удаленных людях
     *
     * @return Строка запроса
     */
    String GetQuerySelectLastUpdateDeletedPeople();
}