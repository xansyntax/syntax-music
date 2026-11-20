package com.google.common.util.concurrent;

import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLogger {
    public final Object lock = new Object();
    public volatile Logger logger;
    public final String loggerName;

    public LazyLogger(Class cls) {
        this.loggerName = cls.getName();
    }

    public final Logger get() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        synchronized (this.lock) {
            try {
                Logger logger2 = this.logger;
                if (logger2 != null) {
                    return logger2;
                }
                this.logger = Logger.getLogger(this.loggerName);
                return this.logger;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
