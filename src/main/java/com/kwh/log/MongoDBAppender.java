/*package com.kwh.log;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.mongodb.BasicDBObject;

import ch.qos.logback.classic.spi.ILoggingEvent;

*//**
 * 
 * 
 * 类说明:自定义Mongodb输出类
 * 
 * @author 作者 LzwGlory
 * @version 创建时间：2016年2月22日 下午3:59:14
 *
 *//*
public class MongoDBAppender extends MongoDBAppenderBase<ILoggingEvent> {

    public MongoDBAppender() {
        super("loggingEvents");
    }

    @SuppressWarnings("deprecation")
    @Override
    protected BasicDBObject toMongoDocument(ILoggingEvent eventObject) {
        final BasicDBObject doc = new BasicDBObject();
        doc.append("date", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(eventObject.getTimeStamp())));
        doc.append("level", eventObject.getLevel().toString());
        doc.append("logger", eventObject.getLoggerName());
        doc.append("thread", eventObject.getThreadName());
        doc.append("message", eventObject.getFormattedMessage());
        if (eventObject.getMdc() != null && !eventObject.getMdc().isEmpty())
            doc.append("mdc", eventObject.getMdc());
        return doc;
    }
}
*/