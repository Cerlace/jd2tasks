package cerlace.util;

import cerlace.dto.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс {@code PagingUtil} является утилитарным классом для
 * реализации пагинации при выполнении запросов множественного выбора.
 */
public class PagingUtil {
    private PagingUtil() {
    }

    /**
     * Метод выводит в консоль список сотрудников в формате постраничной таблицы.
     *
     * @param list           список сотрудников;
     * @param recordsPerPage количество записей на каждой странице.
     */
    public static void printEmployeesByPages(List<Employee> list, int recordsPerPage) {
        List<List<Employee>> pages = getPagesList(list, recordsPerPage);
        if (pages.isEmpty()) {
            System.out.println("\nСписок пуст!");
        } else {
            for (int i = 0; i < pages.size(); i++) {
                System.out.printf("\nСтраница %d из %d\n\n", i + 1, pages.size());
                System.out.println(TableUtil.getEmployeesTable(pages.get(i)));
            }
        }
    }

    /**
     * Метод преобразует {@code List<Employee>} в {@code List<List<Employee>>},
     * разделенный по количеству записей на страницу {@code recordsPerPage}.
     *
     * @param list           список сотрудников;
     * @param recordsPerPage количество записей на страницу;
     * @return список страниц {@code List<List<Employee>>}.
     */
    private static List<List<Employee>> getPagesList(List<Employee> list, int recordsPerPage) {
        List<List<Employee>> pages = new ArrayList<>();
        int pagesCount = list.size() / recordsPerPage;
        Iterator<Employee> employeeIterator = list.iterator();
        for (int i = 0; i < pagesCount; i++) {
            List<Employee> page = new ArrayList<>();
            for (int j = 0; j < recordsPerPage; j++) {
                page.add(employeeIterator.next());
            }
            pages.add(page);
        }
        int remainder = list.size() % recordsPerPage;
        if (remainder != 0) {
            List<Employee> page = new ArrayList<>();
            for (int i = 0; i < remainder; i++) {
                page.add(employeeIterator.next());
            }
            pages.add(page);
        }

        return pages;
    }
}
