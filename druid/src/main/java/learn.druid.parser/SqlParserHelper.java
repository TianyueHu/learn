package learn.druid.parser;

import com.alibaba.druid.sql.dialect.db2.visitor.DB2SchemaStatVisitor;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.sql.dialect.oracle.visitor.OracleSchemaStatVisitor;
import com.alibaba.druid.sql.dialect.postgresql.visitor.PGSchemaStatVisitor;
import com.alibaba.druid.sql.dialect.sqlserver.visitor.SQLServerSchemaStatVisitor;
import com.alibaba.druid.sql.visitor.SchemaStatVisitor;
import com.alibaba.druid.util.JdbcConstants;

public class SqlParserHelper {

    public static boolean isSupportedDBType(String dbType){
        switch(dbType){
            case JdbcConstants.MYSQL:
            case JdbcConstants.ORACLE:
            case JdbcConstants.SQL_SERVER:
            case JdbcConstants.POSTGRESQL:
            case JdbcConstants.DB2:
            case JdbcConstants.DERBY:
                return true;
            default:
                return false;
        }
    }

    public static SchemaStatVisitor getSchemaStatVisitor(String dbType){
        switch (dbType){
            case JdbcConstants.MYSQL:
                return new MySqlSchemaStatVisitor();
            case JdbcConstants.ORACLE:
                return new OracleSchemaStatVisitor();
            case JdbcConstants.SQL_SERVER:
                return new SQLServerSchemaStatVisitor();
            case JdbcConstants.POSTGRESQL:
                return new PGSchemaStatVisitor();
            case JdbcConstants.DB2:
                return new DB2SchemaStatVisitor();
            default:
                return null;
        }
    }
}
