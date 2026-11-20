package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SubstituteLoggerFactory implements ILoggerFactory {
    public volatile boolean postInitialization = false;
    public final ConcurrentHashMap loggers = new ConcurrentHashMap();
    public final LinkedBlockingQueue eventQueue = new LinkedBlockingQueue();

    @Override // org.slf4j.ILoggerFactory
    public final synchronized Logger getLogger(String str) {
        SubstituteLogger substituteLogger;
        substituteLogger = (SubstituteLogger) this.loggers.get(str);
        if (substituteLogger == null) {
            substituteLogger = new SubstituteLogger(str, this.eventQueue, this.postInitialization);
            this.loggers.put(str, substituteLogger);
        }
        return substituteLogger;
    }
}
