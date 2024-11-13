package cerlace.util;

import cerlace.dto.Employee;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import java.util.List;

public class TableUtil {

    private TableUtil() {
    }

    public static String getEmployeesTable(List<Employee> list) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("id", "first_name", "last_name",
                "email", "department", "salary", "hire_date");
        table.addRule();

        for (Employee emp : list) {
            table.addRow(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail(), emp.getDepartment(), emp.getSalary(), emp.getHireDate().toString());
            table.addRule();
        }
        table.setTextAlignment(TextAlignment.CENTER);

        return table.render();
    }
}
