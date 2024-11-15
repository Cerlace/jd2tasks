package cerlace.util;

import cerlace.dto.Address;
import cerlace.dto.People;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.List;

/**
 * Класс {@code TableUtil} является утилитарным классом для
 * преобразования данных в виде таблицы. Использует библиотеку {@code de.vandermeer.asciitable}.
 */
public class TableUtil {

    private TableUtil() {
    }

    /**
     * Метод преобразует список адресов в таблицу, для печати в консоль.
     *
     * @param list список адресов;
     * @return представление списка в виде таблицы.
     */
    public static String getAddressTable(List<Address> list) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("id", "street", "house");
        table.addRule();

        for (Address address : list) {
            table.addRow(address.getId(), address.getStreet(), address.getHouse());
            table.addRule();
        }
        table.setTextAlignment(TextAlignment.CENTER);

        return table.render();
    }

    /**
     * Метод преобразует список людей в таблицу, для печати в консоль.
     *
     * @param list список людей;
     * @return представление списка в виде таблицы.
     */
    public static String getPeopleTable(List<People> list) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("id", "name", "surname", "age");
        table.addRule();

        for (People people : list) {
            table.addRow(people.getId(), people.getName(), people.getSurname(), people.getAge());
            table.addRule();
        }
        table.setTextAlignment(TextAlignment.CENTER);

        return table.render();
    }
}