/*******************************************************************************
 * Copyright 2013 Technology Blueprint Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package uk.co.techblue.jboss.controller;

import java.util.List;

import org.jboss.dmr.ModelNode;

import uk.co.techblue.jboss.controller.exception.ControllerOperationException;
import uk.co.techblue.jboss.controller.vo.ControllerClientConfig;
import uk.co.techblue.jboss.controller.vo.JndiDataSource;

// TODO: Auto-generated Javadoc

/**
 * A service that executes operations on an application server management model controller.
 *
 * @author <a href="mailto:ajay.deshwal@techblue.co.uk">Ajay Deshwal</a>
 * @follower <a href="mailto:yjmyzz@126.com">Jimmy Yang</a>
 */
public interface ControllerOperationExecutor {

    /**
     * The Enum DatasourceStatus.
     */
    enum DatasourceStatus {

        /**
         * The enabled.
         */
        ENABLED,

        /**
         * The disabled.
         */
        DISABLED,

        /**
         * The all.
         */
        ALL
    }

    ;

    /**
     * Creates a datasource using given client configuration and DS properties into the given server profiles.
     *
     * @param controllerClientConfig the controller client configuration
     * @param dataSource             the datasource configuration object
     * @param enable                 whether to enable the datasource or not
     * @param serverProfileNames     the server profile names to which datasource must be added
     * @throws ControllerOperationException the controller operation exception
     */
    void createDatasource(ControllerClientConfig controllerClientConfig, JndiDataSource dataSource, boolean enable,
                          String... serverProfileNames) throws ControllerOperationException;

    /**
     * Checks if datasource exists against the specified name.
     *
     * @param controllerClientConfig the controller client configuration
     * @param dataSourceName         the datasource configuration object
     * @return true, if datasource exists
     * @throws ControllerOperationException the controller operation exception
     */
    boolean isDatasourceExists(final ControllerClientConfig controllerClientConfig, final String dataSourceName)
            throws ControllerOperationException;

    /**
     * Checks if datasource exists against the specified name in the given server profile.
     *
     * @param controllerClientConfig the controller client configuration
     * @param dataSourceName         the datasource configuration object
     * @param serverProfileName      the server profile name
     * @return true, if datasource exists
     * @throws ControllerOperationException the controller operation exception
     */
    boolean isDatasourceExists(ControllerClientConfig controllerClientConfig, String dataSourceName, String serverProfileName)
            throws ControllerOperationException;

    /**
     * Enables the datasource against given name in specified server profiles.
     *
     * @param controllerClientConfig the controller client configuration
     * @param datasourceName         the datasource name
     * @param serverProfileNames     the server profile names
     * @throws ControllerOperationException the controller operation exception
     */
    void enableDataSource(ControllerClientConfig controllerClientConfig, String datasourceName, String... serverProfileNames)
            throws ControllerOperationException;

    /**
     * Removes datasource.
     *
     * @param controllerClientConfig the controller client config
     * @param datasourceName         the datasource name
     * @param serverProfileNames     the server profile names
     * @throws ControllerOperationException the controller operation exception
     */
    void removeDatasource(final ControllerClientConfig controllerClientConfig, final String datasourceName,
                          final String... serverProfileNames) throws ControllerOperationException;

    /**
     * Gets the datasources.
     *
     * @param controllerClientConfig the controller client config
     * @param serverProfileName      the server profile name
     * @param dataSourceStatus       the data source status
     * @return the datasources
     * @throws ControllerOperationException the controller operation exception
     */
    List<ModelNode> getDatasources(final ControllerClientConfig controllerClientConfig, final String serverProfileName,
                                   final DatasourceStatus dataSourceStatus) throws ControllerOperationException;

    /**
     * Disable data source.
     *
     * @param controllerClientConfig the controller client config
     * @param datasourceName         the datasource name
     * @param serverProfileNames     the server profile names
     * @throws ControllerOperationException the controller operation exception
     */
    void disableDataSource(ControllerClientConfig controllerClientConfig, String datasourceName, String... serverProfileNames)
            throws ControllerOperationException;

    /**
     * Enable data sources.
     *
     * @param controllerClientConfig the controller client config
     * @param datasourceName         the datasource name
     * @param serverProfileNames     the server profile names
     * @throws ControllerOperationException the controller operation exception
     */
    void enableDataSources(ControllerClientConfig controllerClientConfig, List<String> datasourceName,
                           String... serverProfileNames) throws ControllerOperationException;

    /**
     * Disable data sources.
     *
     * @param controllerClientConfig the controller client config
     * @param datasourceName         the datasource name
     * @param serverProfileNames     the server profile names
     * @throws ControllerOperationException the controller operation exception
     */
    void disableDataSources(ControllerClientConfig controllerClientConfig, List<String> datasourceName,
                            String... serverProfileNames) throws ControllerOperationException;

    /**
     * Checks if is datasource enabled.
     *
     * @param controllerClientConfig the controller client config
     * @param serverProfileName      the server profile name
     * @param datasource             the datasource
     * @return true, if is datasource enabled
     * @throws ControllerOperationException the controller operation exception
     */
    boolean isDatasourceEnabled(final ControllerClientConfig controllerClientConfig, final String serverProfileName,
                                final String datasource) throws ControllerOperationException;

    /**
     * Creates the datasources from a list.
     *
     * @param controllerClientConfig the controller client config
     * @param dataSources            the data sources
     * @param enable                 the enable
     * @param serverProfileNames     the server profile names
     * @throws ControllerOperationException the controller operation exception
     */
    void createDatasources(final ControllerClientConfig controllerClientConfig, final List<JndiDataSource> dataSources,
                           final boolean enable, final String... serverProfileNames) throws ControllerOperationException;

    /**
     * Removes the datasources.
     *
     * @param controllerClientConfig the controller client config
     * @param datasourceNames        the datasource names
     * @param serverProfileNames     the server profile names
     * @throws ControllerOperationException the controller operation exception
     */
    void removeDatasources(final ControllerClientConfig controllerClientConfig, final List<String> datasourceNames,
                           final String... serverProfileNames) throws ControllerOperationException;


    /**
     * Get Servers list
     *
     * @param controllerClientConfig
     * @param host                   host name in domain mode
     * @return server name list
     * @throws ControllerOperationException
     */
    List<ModelNode> getServers(final ControllerClientConfig controllerClientConfig, final String host) throws ControllerOperationException;

    /**
     * start specified server
     *
     * @param controllerClientConfig
     * @param host
     * @param serverName
     * @return
     * @throws ControllerOperationException
     */
    ModelNode startServer(final ControllerClientConfig controllerClientConfig, final String host, final String serverName) throws ControllerOperationException;


    /**
     * stop specified server
     *
     * @param controllerClientConfig
     * @param host
     * @param serverName
     * @return
     * @throws ControllerOperationException
     */
    ModelNode stopServer(final ControllerClientConfig controllerClientConfig, final String host, final String serverName) throws ControllerOperationException;

    /**
     * get server state
     *
     * @param controllerClientConfig
     * @param host
     * @param serverName
     * @return
     * @throws ControllerOperationException
     */
    ModelNode getServerState(final ControllerClientConfig controllerClientConfig, final String host, final String serverName) throws ControllerOperationException;

    /**
     * get server status
     *
     * @param controllerClientConfig
     * @param host
     * @param serverName
     * @return
     * @throws ControllerOperationException
     */
    ModelNode getServerStatus(final ControllerClientConfig controllerClientConfig, final String host, final String serverName) throws ControllerOperationException;

    /**
     * start all the servers of a group
     * @param controllerClientConfig
     * @param serverGroup
     * @return
     * @throws ControllerOperationException
     */
    ModelNode startServerGroup(final ControllerClientConfig controllerClientConfig,  final String serverGroup) throws ControllerOperationException;

    /**
     * stop all the servers of a group
     * @param controllerClientConfig
     * @param serverGroup
     * @return
     * @throws ControllerOperationException
     */
    ModelNode stopServerGroup(final ControllerClientConfig controllerClientConfig,  final String serverGroup) throws ControllerOperationException;


}
