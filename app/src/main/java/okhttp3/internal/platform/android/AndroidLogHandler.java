package okhttp3.internal.platform.android;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class AndroidLogHandler extends Handler {
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    @Override // java.util.logging.Handler
    public final void publish(LogRecord logRecord) {
        int i;
        logRecord.getClass();
        CopyOnWriteArraySet copyOnWriteArraySet = AndroidLog.configuredLoggers;
        String loggerName = logRecord.getLoggerName();
        loggerName.getClass();
        int iIntValue = logRecord.getLevel().intValue();
        Level level = Level.INFO;
        if (iIntValue > level.intValue()) {
            i = 5;
        } else {
            i = logRecord.getLevel().intValue() == level.intValue() ? 4 : 3;
        }
        String message = logRecord.getMessage();
        message.getClass();
        AndroidLog.androidLog$okhttp(loggerName, i, message, logRecord.getThrown());
    }

    @Override // java.util.logging.Handler
    public final void close() {
    }

    @Override // java.util.logging.Handler
    public final void flush() {
    }
}
