package com.test.conf;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.MasterSlaveRuleConfiguration;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingjdbc.core.api.config.strategy.NoneShardingStrategyConfiguration;

@Configuration
@EnableConfigurationProperties(ShardDataSourceProperties.class)
public class ShardDataSourceConfig {

	@Autowired
	private ShardDataSourceProperties shardDataSourceProperties;

	private DruidDataSource parentDs() throws SQLException {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(shardDataSourceProperties.getDriverClassName());
		ds.setFilters(shardDataSourceProperties.getFilters());
		ds.setMaxActive(shardDataSourceProperties.getMaxActive());
		ds.setInitialSize(shardDataSourceProperties.getInitialSize());
		ds.setMaxWait(shardDataSourceProperties.getMaxWait());
		ds.setMinIdle(shardDataSourceProperties.getMinIdle());
		ds.setTimeBetweenEvictionRunsMillis(shardDataSourceProperties.getTimeBetweenEvictionRunsMillis());
		ds.setMinEvictableIdleTimeMillis(shardDataSourceProperties.getMinEvictableIdleTimeMillis());
		ds.setValidationQuery(shardDataSourceProperties.getValidationQuery());
		ds.setTestWhileIdle(shardDataSourceProperties.isTestWhileIdle());
		ds.setTestOnBorrow(shardDataSourceProperties.isTestOnBorrow());
		ds.setTestOnReturn(shardDataSourceProperties.isTestOnReturn());
		ds.setPoolPreparedStatements(shardDataSourceProperties.isPoolPreparedStatements());
		ds.setMaxPoolPreparedStatementPerConnectionSize(shardDataSourceProperties.getMaxPoolPreparedStatementPerConnectionSize());
		ds.setRemoveAbandoned(shardDataSourceProperties.isRemoveAbandoned());
		ds.setRemoveAbandonedTimeout(shardDataSourceProperties.getRemoveAbandonedTimeout());
		ds.setLogAbandoned(shardDataSourceProperties.isLogAbandoned());
		ds.setConnectionInitSqls(shardDataSourceProperties.getConnectionInitSqls());
		return ds;
	}

	/**
	 * 配置数据源
	 * @return
	 * @throws SQLException
	 */
	private Map<String, DataSource> getDataSource() throws SQLException{
		
		Map<String, DataSource> dataSourceMap = new HashMap<String, DataSource>();		
		
		// 配置第一个数据源
		DruidDataSource master = parentDs();
		master.setUrl(shardDataSourceProperties.getMasterUrl0());
		master.setUsername(shardDataSourceProperties.getMasterUsername0());
		master.setPassword(shardDataSourceProperties.getMasterPassword0());
	    dataSourceMap.put("ds_0", master);
	    
	    // 配置第二个数据源
	    DruidDataSource salve1 = parentDs();
	    salve1.setUrl(shardDataSourceProperties.getSlaveUrl0());
	    salve1.setUsername(shardDataSourceProperties.getSlaveUsername0());
	    salve1.setPassword(shardDataSourceProperties.getSlavePassword0());
	    dataSourceMap.put("ds_1", salve1);
	    
	    // 配置第二个数据源
	    DruidDataSource salve2 = parentDs();
	    salve2.setUrl(shardDataSourceProperties.getSlaveUrl1());
	    salve2.setUsername(shardDataSourceProperties.getSlaveUsername1());
	    salve2.setPassword(shardDataSourceProperties.getSlavePassword1());
	    dataSourceMap.put("ds_2", salve2);
		
		return dataSourceMap;
	}
	

	/**
	 * 分表不分库 t_product
	 * @return
	 * @throws SQLException
	 */
	private TableRuleConfiguration productTableRule(){
		
		TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
	    orderTableRuleConfig.setLogicTable("t_product");
	    orderTableRuleConfig.setActualDataNodes("master_slave.t_product_${0..1}");
	    orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("product_id", "t_product_${product_id % 2}"));
	    orderTableRuleConfig.setDatabaseShardingStrategyConfig(new NoneShardingStrategyConfiguration());
	    return orderTableRuleConfig;
	}
	
	/**
	 * 分表不分库 t_product_sku
	 * @return
	 * @throws SQLException
	 */
	private TableRuleConfiguration productSkuTableRule(){
		
		TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
	    orderTableRuleConfig.setLogicTable("t_product_sku");
	    orderTableRuleConfig.setActualDataNodes("master_slave.t_product_sku_${0..1}");
	    orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("product_id", "t_product_sku_${product_id % 2}"));
	    orderTableRuleConfig.setDatabaseShardingStrategyConfig(new NoneShardingStrategyConfiguration());
	    return orderTableRuleConfig;
	}
	
	/**
	 * 配置读写分离
	 * @return
	 * @throws SQLException 
	 */
	private MasterSlaveRuleConfiguration masterSlaveConfig() throws SQLException {
		
		MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration();
		masterSlaveRuleConfig.setName("master_slave");
		masterSlaveRuleConfig.setMasterDataSourceName("ds_0");
		masterSlaveRuleConfig.setSlaveDataSourceNames(Arrays.asList("ds_1", "ds_2"));
		return masterSlaveRuleConfig;
	}
	
	/**
	 * 配置分片规则
	 * @return
	 * @throws SQLException 
	 */
	private ShardingRuleConfiguration shardingRuleConfig() throws SQLException {
		
		ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
		shardingRuleConfig.getMasterSlaveRuleConfigs().add(masterSlaveConfig());
		shardingRuleConfig.getTableRuleConfigs().add(productTableRule());
		shardingRuleConfig.getTableRuleConfigs().add(productSkuTableRule());
		return shardingRuleConfig;
	}
	
	@Bean
	public DataSource dataSource() throws SQLException {
		
		return ShardingDataSourceFactory.createDataSource(getDataSource(),shardingRuleConfig());
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws SQLException {
		return new DataSourceTransactionManager(dataSource());
	}
}
