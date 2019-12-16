package conections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryFactory {

    public List<Map<String, String>> queryExecutor(Connection conn, String query, String... columns) {
        List<Map<String, String>> list = null;
        try {
            Statement statement = conn.createStatement();
            ResultSet resultOfQuery = statement.executeQuery(query);
            list = new ArrayList();

            while (resultOfQuery.next()) {
                Map<String, String> values = new HashMap();
                for (String column : columns) {
                    String value = resultOfQuery.getString(column);
                    values.put(column, value);
                }
                list.add(values);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
