package org.slf4j;

import org.slf4j.event.Level;
import org.slf4j.spi.LoggingEventBuilder;
import org.slf4j.spi.NOPLoggingEventBuilder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface Logger {
    void debug(String str);

    void debug(String str, Object obj);

    void debug(String str, Object obj, Object obj2);

    void debug(String str, Throwable th);

    void debug(String str, Object... objArr);

    void debug(Marker marker, String str);

    void debug(Marker marker, String str, Object obj);

    void debug(Marker marker, String str, Object obj, Object obj2);

    void debug(Marker marker, String str, Throwable th);

    void debug(Marker marker, String str, Object... objArr);

    void error(String str);

    void error(String str, Object obj);

    void error(String str, Object obj, Object obj2);

    void error(String str, Throwable th);

    void error(String str, Object... objArr);

    void error(Marker marker, String str);

    void error(Marker marker, String str, Object obj);

    void error(Marker marker, String str, Object obj, Object obj2);

    void error(Marker marker, String str, Throwable th);

    void error(Marker marker, String str, Object... objArr);

    String getName();

    void info(String str);

    void info(String str, Object obj);

    void info(String str, Object obj, Object obj2);

    void info(String str, Throwable th);

    void info(String str, Object... objArr);

    void info(Marker marker, String str);

    void info(Marker marker, String str, Object obj);

    void info(Marker marker, String str, Object obj, Object obj2);

    void info(Marker marker, String str, Throwable th);

    void info(Marker marker, String str, Object... objArr);

    boolean isDebugEnabled();

    boolean isDebugEnabled(Marker marker);

    default boolean isEnabledForLevel(Level level) {
        byte b = level.levelInt;
        if (b == 0) {
            return isTraceEnabled();
        }
        if (b == 10) {
            return isDebugEnabled();
        }
        if (b == 20) {
            return isInfoEnabled();
        }
        if (b == 30) {
            return isWarnEnabled();
        }
        if (b == 40) {
            return isErrorEnabled();
        }
        throw new IllegalArgumentException("Level [" + level + "] not recognized.");
    }

    boolean isErrorEnabled();

    boolean isErrorEnabled(Marker marker);

    boolean isInfoEnabled();

    boolean isInfoEnabled(Marker marker);

    boolean isTraceEnabled();

    boolean isTraceEnabled(Marker marker);

    boolean isWarnEnabled();

    boolean isWarnEnabled(Marker marker);

    default LoggingEventBuilder makeLoggingEventBuilder(Level level) {
        return new NOPLoggingEventBuilder();
    }

    void trace(String str);

    void trace(String str, Object obj);

    void trace(String str, Object obj, Object obj2);

    void trace(String str, Throwable th);

    void trace(String str, Object... objArr);

    void trace(Marker marker, String str);

    void trace(Marker marker, String str, Object obj);

    void trace(Marker marker, String str, Object obj, Object obj2);

    void trace(Marker marker, String str, Throwable th);

    void trace(Marker marker, String str, Object... objArr);

    void warn(String str);

    void warn(String str, Object obj);

    void warn(String str, Object obj, Object obj2);

    void warn(String str, Throwable th);

    void warn(String str, Object... objArr);

    void warn(Marker marker, String str);

    void warn(Marker marker, String str, Object obj);

    void warn(Marker marker, String str, Object obj, Object obj2);

    void warn(Marker marker, String str, Throwable th);

    void warn(Marker marker, String str, Object... objArr);
}
