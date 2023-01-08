package guru.qa.data.database;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public enum DataSourceProvider {
    INSTANCE;

    private PGSimpleDataSource dataSource;

    public DataSource getDataSource() {
        if(dataSource == null) {
            dataSource = new PGSimpleDataSource();
            dataSource.setServerNames(new String[]{"localhost"});
            dataSource.setPortNumbers(new int[]{5432});
            dataSource.setDatabaseName("qapbd");
            dataSource.setUser("postgres");
            dataSource.setPassword("123456");
        }

        return  dataSource;
    }
}
