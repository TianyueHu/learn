package learn.druid.parser;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.util.JdbcConstants;

import java.util.ArrayList;
import java.util.List;

public class SqlParser {

    public static boolean sqlParser(List<String> sqls, String dbType, List<ParsedSql> parsedSqls){

        sqls.forEach(sql -> {
            String result = SQLUtils.format(sql, dbType);
            System.out.println(result); // 缺省大写格式
            List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);

            //解析出的独立语句的个数
            System.out.println("size is:" + stmtList.size());
            for (int i = 0; i < stmtList.size(); i++) {

                SQLStatement stmt = stmtList.get(i);
                MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
                stmt.accept(visitor);

                System.out.println("getTables : " + visitor.getTables());
                System.out.println("getColumns : " + visitor.getColumns());
                System.out.println("getConditions : " + visitor.getConditions());
                System.out.println("getGroupByColumns : " + visitor.getGroupByColumns());
                System.out.println("getOrderByColumns : " + visitor.getOrderByColumns());
            }

        });

        return true;
    }
    private static final String SELECT = "select";
 	private static final String INSERT = "insert";
 	private static final String DELETE = "delete";
 	private static final String UPDATE = "update";
 	private static final String TABLE = "demoTable";
 	private static final String INNER_TABLE = "innerTable";
 	private static final String JOIN_TABLE = "joinTable";
 	private static final String INNER_JOIN_TABLE = "innerJoinTable";

    public static void main(String[] args){
        List<String> sqls = new ArrayList<>();
        String mysql = "UPDATE table1 t1 " +
                "SET (column1,column2 ) = ( " +
                "SELECT (column1, column2) " +
                "FROM table2" +
                " WHERE column1 = t1.column1) " +
                " WHERE column2 = 3";
        sqls.add(mysql);
        SqlParser.sqlParser(sqls, JdbcConstants.MYSQL, new ArrayList<>());

    }
}
