package uk.co.techblue.jboss.test;

import org.jboss.dmr.ModelNode;
import org.junit.Test;
import uk.co.techblue.jboss.controller.ControllerOperationExecutor;
import uk.co.techblue.jboss.controller.as7.JBoss7ControllerOpeartionExecutor;
import uk.co.techblue.jboss.controller.vo.ControllerClientConfig;
import uk.co.techblue.jboss.controller.vo.JndiDataSource;

import java.util.List;

/**
 * Created by jimmy on 2015/8/25.
 */
public class DataSourceTest {


    @Test
    public void testGetDataSourceStatus() {
        try {
            String dataSourceName = "ciqDS";
            final ControllerClientConfig clientConfig = new ControllerClientConfig("172.20.16.191", 9999);
            clientConfig.setUserName("weblogic");
            clientConfig.setPassword("weblogic123!");
            System.out.println(dataSourceName + " is exists ?  " + new JBoss7ControllerOpeartionExecutor().isDatasourceExists(clientConfig,
                    dataSourceName, "ha"));
            System.out.println(dataSourceName + " is enabled ?  " + new JBoss7ControllerOpeartionExecutor().isDatasourceEnabled(clientConfig,
                    "ha", dataSourceName));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDataSourceList() {
        try {
            final ControllerClientConfig clientConfig = new ControllerClientConfig("172.20.16.191", 9999);
            clientConfig.setUserName("weblogic");
            clientConfig.setPassword("weblogic123!");
            List<ModelNode> dataSources = new JBoss7ControllerOpeartionExecutor().getDatasources(clientConfig, "ha",
                    ControllerOperationExecutor.DatasourceStatus.ALL);
            for (ModelNode dataSource : dataSources) {
                System.out.println(dataSource.asProperty().getName());
            }
            // new JBoss7ControllerOpeartionExecutor().disableDataSource(clientConfig, "java:/mysql-testjboss7","");
            //new JBoss7ControllerOpeartionExecutor().removeDatasource(clientConfig, "java:/mysql-testjboss7", "");
            // new JBoss7ControllerOpeartionExecutor().createDatasource(clientConfig, dataSource, true);
            // new JBoss7ControllerOpeartionExecutor().isDatasourceExists(clientConfig, dataSource.getJndiName());
            // new JBoss7ControllerOpeartionExecutor().createDatasource(clientConfig, dataSource, true, "ha");
            // new JBoss7ControllerOpeartionExecutor().isDatasourceExists(clientConfig, dataSource.getJndiName(), "full-ha");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
