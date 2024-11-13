package cerlace.util;

import cerlace.dto.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PagingUtil {
    private PagingUtil(){
    }
    public static void printEmployeesByPages(List<Employee> list, int recordsPerPage) {
        List<List<Employee>> pages = getPagesList(list, recordsPerPage);
        for(int i = 0; i < pages.size(); i++) {
            System.out.printf("\nСтраница %d из %d\n\n", i + 1, pages.size());
            System.out.println(TableUtil.getEmployeesTable(pages.get(i)));
        }
    }

    private static List<List<Employee>> getPagesList(List<Employee> list, int recordsPerPage) {
        List<List<Employee>> pages = new ArrayList<>();
        int pagesCount = list.size() / recordsPerPage;
        Iterator<Employee> employeeIterator = list.iterator();
        for(int i = 0; i < pagesCount; i++) {
            List<Employee> page = new ArrayList<>();
            for(int j = 0; j < recordsPerPage; j++){
                page.add(employeeIterator.next());
            }
            pages.add(page);
        }
        int remainder = list.size() % recordsPerPage;
        if (remainder != 0) {
            List<Employee> page = new ArrayList<>();
            for(int i = 0; i < remainder; i++){
                page.add(employeeIterator.next());
            }
            pages.add(page);
        }

        return pages;
    }
}
