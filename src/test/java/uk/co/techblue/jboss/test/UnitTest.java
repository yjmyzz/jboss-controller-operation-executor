package uk.co.techblue.jboss.test;

import org.jboss.dmr.ModelNode;
import org.junit.Test;
import uk.co.techblue.jboss.controller.ControllerOperationExecutor;
import uk.co.techblue.jboss.controller.as7.JBoss7ControllerOpeartionExecutor;
import uk.co.techblue.jboss.controller.vo.ControllerClientConfig;

import java.util.List;


public class UnitTest {

    private final String host = "change to your host";
    private final String username = "change to your username";
    private final String password = "change to your password";
    private final int port = 9999;


    @Test
    public void testGetDataSourceStatus() {
        try {
            String dataSourceName = "ciqDS";
            final ControllerClientConfig clientConfig = new ControllerClientConfig(host, port);
            clientConfig.setUserName(username);
            clientConfig.setPassword(password);
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
            final ControllerClientConfig clientConfig = new ControllerClientConfig(host, port);
            clientConfig.setUserName(username);
            clientConfig.setPassword(password);
            List<ModelNode> dataSources = new JBoss7ControllerOpeartionExecutor().getDatasources(clientConfig, "ha",
                    ControllerOperationExecutor.DatasourceStatus.ALL);
            for (ModelNode dataSource : dataSources) {
                System.out.println(dataSource.asProperty().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetServers() {
        try {
            final ControllerClientConfig clientConfig = new ControllerClientConfig(host, port);
            clientConfig.setUserName(username);
            clientConfig.setPassword(password);
            List<ModelNode> servers = new JBoss7ControllerOpeartionExecutor().getServers(clientConfig, "master");
            for (ModelNode s : servers) {
                System.out.println(s.asProperty().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStartServer() {
        try {
            final ControllerClientConfig clientConfig = new ControllerClientConfig(host, port);
            clientConfig.setUserName(username);
            clientConfig.setPassword(password);
            ModelNode result = new JBoss7ControllerOpeartionExecutor().startServer(clientConfig, "master", "server8080");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStopServer() {
        try {
            final ControllerClientConfig clientConfig = new ControllerClientConfig(host, port);
            clientConfig.setUserName(username);
            clientConfig.setPassword(password);
            ModelNode result = new JBoss7ControllerOpeartionExecutor().stopServer(clientConfig, "master", "server8080");
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetServerState() {
        try {
            final ControllerClientConfig clientConfig = new ControllerClientConfig(host, port);
            clientConfig.setUserName(username);
            clientConfig.setPassword(password);
            ModelNode result = new JBoss7ControllerOpeartionExecutor().getServerState(clientConfig, "master", "server8080");
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
            if (e.getMessage().contains("JBAS014883")){
                System.out.println("The server is not running");
            }
        }
    }

    @Test
    public void testGetServerStatus() {
        try {
            final ControllerClientConfig clientConfig = new ControllerClientConfig(host, port);
            clientConfig.setUserName(username);
            clientConfig.setPassword(password);
            ModelNode result = new JBoss7ControllerOpeartionExecutor().getServerStatus(clientConfig, "master", "server8080");
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStartServerGroup() {
        try {
            final ControllerClientConfig clientConfig = new ControllerClientConfig(host, port);
            clientConfig.setUserName(username);
            clientConfig.setPassword(password);
            ModelNode result = new JBoss7ControllerOpeartionExecutor().startServerGroup(clientConfig, "group8080");
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStopServerGroup() {
        try {
            final ControllerClientConfig clientConfig = new ControllerClientConfig(host, port);
            clientConfig.setUserName(username);
            clientConfig.setPassword(password);
            ModelNode result = new JBoss7ControllerOpeartionExecutor().stopServerGroup(clientConfig, "group8080");
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
