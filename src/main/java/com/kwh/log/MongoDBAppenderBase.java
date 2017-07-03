package com.kwh.log;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;

import ch.qos.logback.core.UnsynchronizedAppenderBase;

/**
 * 
 * 
 * 类说明:logback的日志扩展基础类
 * 
 * @author 作者 LzwGlory
 * @version 创建时间：2016年2月22日 下午3:58:14 
 *
 */
public abstract class MongoDBAppenderBase<E> extends
		UnsynchronizedAppenderBase<E> {

	private Mongo mongo;
	private DBCollection eventsCollection;

	private String host = "localhost";
	private int port = 27017;
	private String dbName = "db";
	private String collectionName;
	private String username;
	private String password;

	private int connectionsPerHost = 10;
	private int threadsAllowedToBlockForConnectionMultiplier = 5;
	private int maxWaitTime = 1000 * 60 * 2;
	private int connectTimeout;
	private int socketTimeout;
	private boolean autoConnectRetry;
	private boolean slaveOk;
	private boolean safe;
	private int w;
	private int wtimeout;
	private boolean fsync;

	protected MongoDBAppenderBase(String collectionName) {
		this.collectionName = collectionName;
	}

	@Override
	public void start() {
		try {
			connectToMongoDB();
			super.start();
		} catch (UnknownHostException e) {
			addError(
					"Error connecting to MongoDB server: " + host + ":" + port,
					e);
		}
	}

    private void connectToMongoDB() throws UnknownHostException {
		mongo = new Mongo(new ServerAddress(host, port), buildOptions());
		DB db = mongo.getDB(dbName);
		if (username != null && password != null)
			db.authenticate(username, password.toCharArray());
		eventsCollection = db.getCollection(collectionName);
	}

	private MongoOptions buildOptions() {
		final MongoOptions options = new MongoOptions();
		options.connectionsPerHost = connectionsPerHost;
		options.threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;
		options.maxWaitTime = maxWaitTime;
		options.connectTimeout = connectTimeout;
		options.socketTimeout = socketTimeout;
		options.autoConnectRetry = autoConnectRetry;
		options.slaveOk = slaveOk;
		options.safe = safe;
		options.w = w;
		options.wtimeout = wtimeout;
		options.fsync = fsync;
		return options;
	}

	protected abstract BasicDBObject toMongoDocument(E event);

	@Override
	protected void append(E eventObject) {
		eventsCollection.insert(toMongoDocument(eventObject));
	}

	@Override
	public void stop() {
		if (mongo != null)
			mongo.close();
		super.stop();
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConnectionsPerHost(int connectionsPerHost) {
		this.connectionsPerHost = connectionsPerHost;
	}

	public void setThreadsAllowedToBlockForConnectionMultiplier(
			int threadsAllowedToBlockForConnectionMultiplier) {
		this.threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;
	}

	public void setMaxWaitTime(int maxWaitTime) {
		this.maxWaitTime = maxWaitTime;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	public void setAutoConnectRetry(boolean autoConnectRetry) {
		this.autoConnectRetry = autoConnectRetry;
	}

	public void setSlaveOk(boolean slaveOk) {
		this.slaveOk = slaveOk;
	}

	public void setSafe(boolean safe) {
		this.safe = safe;
	}

	public void setW(int w) {
		this.w = w;
	}

	public void setWtimeout(int wtimeout) {
		this.wtimeout = wtimeout;
	}

	public void setFsync(boolean fsync) {
		this.fsync = fsync;
	}

}