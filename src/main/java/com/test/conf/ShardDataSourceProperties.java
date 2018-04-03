package com.test.conf;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;


//@Data
@ConfigurationProperties(prefix="sharding.jdbc")
public class ShardDataSourceProperties {
	
	private String driverClassName;
	
	private String masterUrl0;
	
	private String masterUsername0;
	
	private String masterPassword0;
	
	private String slaveUrl0;
	
	private String slaveUsername0;
	
	private String slavePassword0;
	
	private String slaveUrl1;
	
	private String slaveUsername1;
	
	private String slavePassword1;
	
	private String filters;
	
	private int maxActive;
	
	private int initialSize;
	
	private int maxWait;
	
	private int minIdle;
	
	private int timeBetweenEvictionRunsMillis;
	
	private int minEvictableIdleTimeMillis;
	
	private String validationQuery;
	
	private boolean testWhileIdle;
	
	private boolean testOnBorrow;
	
	private boolean testOnReturn;
	
	private boolean poolPreparedStatements;
	
	private int maxPoolPreparedStatementPerConnectionSize;
	
	private boolean removeAbandoned;

	private int removeAbandonedTimeout;
	
	private boolean logAbandoned;
	
	private List<String> connectionInitSqls;

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getMasterUrl0() {
		return masterUrl0;
	}

	public void setMasterUrl0(String masterUrl0) {
		this.masterUrl0 = masterUrl0;
	}

	public String getMasterUsername0() {
		return masterUsername0;
	}

	public void setMasterUsername0(String masterUsername0) {
		this.masterUsername0 = masterUsername0;
	}

	public String getMasterPassword0() {
		return masterPassword0;
	}

	public void setMasterPassword0(String masterPassword0) {
		this.masterPassword0 = masterPassword0;
	}

	public String getSlaveUrl0() {
		return slaveUrl0;
	}

	public void setSlaveUrl0(String slaveUrl0) {
		this.slaveUrl0 = slaveUrl0;
	}

	public String getSlaveUsername0() {
		return slaveUsername0;
	}

	public void setSlaveUsername0(String slaveUsername0) {
		this.slaveUsername0 = slaveUsername0;
	}

	public String getSlavePassword0() {
		return slavePassword0;
	}

	public void setSlavePassword0(String slavePassword0) {
		this.slavePassword0 = slavePassword0;
	}

	public String getSlaveUrl1() {
		return slaveUrl1;
	}

	public void setSlaveUrl1(String slaveUrl1) {
		this.slaveUrl1 = slaveUrl1;
	}

	public String getSlaveUsername1() {
		return slaveUsername1;
	}

	public void setSlaveUsername1(String slaveUsername1) {
		this.slaveUsername1 = slaveUsername1;
	}

	public String getSlavePassword1() {
		return slavePassword1;
	}

	public void setSlavePassword1(String slavePassword1) {
		this.slavePassword1 = slavePassword1;
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public int getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public boolean isTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public boolean isPoolPreparedStatements() {
		return poolPreparedStatements;
	}

	public void setPoolPreparedStatements(boolean poolPreparedStatements) {
		this.poolPreparedStatements = poolPreparedStatements;
	}

	public int getMaxPoolPreparedStatementPerConnectionSize() {
		return maxPoolPreparedStatementPerConnectionSize;
	}

	public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
		this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
	}

	public boolean isRemoveAbandoned() {
		return removeAbandoned;
	}

	public void setRemoveAbandoned(boolean removeAbandoned) {
		this.removeAbandoned = removeAbandoned;
	}

	public int getRemoveAbandonedTimeout() {
		return removeAbandonedTimeout;
	}

	public void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
		this.removeAbandonedTimeout = removeAbandonedTimeout;
	}

	public boolean isLogAbandoned() {
		return logAbandoned;
	}

	public void setLogAbandoned(boolean logAbandoned) {
		this.logAbandoned = logAbandoned;
	}

	public List<String> getConnectionInitSqls() {
		return connectionInitSqls;
	}

	public void setConnectionInitSqls(List<String> connectionInitSqls) {
		this.connectionInitSqls = connectionInitSqls;
	}

}
