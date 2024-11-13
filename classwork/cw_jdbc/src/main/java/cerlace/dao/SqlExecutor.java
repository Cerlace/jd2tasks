package cerlace.dao;

import java.sql.SQLException;

@FunctionalInterface
public interface SqlExecutor<T> {
    void execute() throws SQLException;
}
