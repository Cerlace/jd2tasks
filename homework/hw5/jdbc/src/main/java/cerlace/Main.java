package cerlace;

import cerlace.dao.EmployeeDAO;
import cerlace.dao.impl.EmployeeDAOImpl;
import cerlace.util.JDBCResources;
import cerlace.util.PagingUtil;

/**
 * Точка входа в приложение.
 * Выполняет основные функции, предусмотренные задачей.
 */
public class Main {
    public static void main(String[] args) {
        String url = JDBCResources.getUrl();
        String user = JDBCResources.getUser();
        String password = JDBCResources.getPassword();
        EmployeeDAO db = new EmployeeDAOImpl(url, user, password);

        PagingUtil.printEmployeesByPages(db.selectAll(), 4);
    }
}
