package org.slf4j.event;

import java.io.Serializable;
import java.util.concurrent.LinkedBlockingQueue;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class EventRecordingLogger implements Logger, Serializable {
    public LinkedBlockingQueue eventQueue;
    public SubstituteLogger logger;
    public String name;

    @Override // org.slf4j.Logger
    public final void debug(String str) {
        handleNormalizedLoggingCall(Level.DEBUG, null);
    }

    @Override // org.slf4j.Logger
    public final void error(String str) {
        handleNormalizedLoggingCall(Level.ERROR, null);
    }

    @Override // org.slf4j.Logger
    public final String getName() {
        return this.name;
    }

    public final void handle2ArgsCall(Level level, String str, Object obj, Object obj2) {
        if (obj2 instanceof Throwable) {
            handleNormalizedLoggingCall(level, new Object[]{obj});
        } else {
            handleNormalizedLoggingCall(level, new Object[]{obj, obj2});
        }
    }

    public final void handleArgArrayCall(Level level, String str, Object[] objArr) {
        Throwable th = null;
        if (objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                th = (Throwable) obj;
            }
        }
        if (th == null) {
            handleNormalizedLoggingCall(level, objArr);
            return;
        }
        if (objArr.length == 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("non-sensical empty or null argument array");
            return;
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        if (length > 0) {
            System.arraycopy(objArr, 0, objArr2, 0, length);
        }
        handleNormalizedLoggingCall(level, objArr2);
    }

    public final void handleNormalizedLoggingCall(Level level, Object[] objArr) {
        SubstituteLoggingEvent substituteLoggingEvent = new SubstituteLoggingEvent();
        System.currentTimeMillis();
        substituteLoggingEvent.level = level;
        substituteLoggingEvent.logger = this.logger;
        Thread.currentThread().getName();
        substituteLoggingEvent.argArray = objArr;
        this.eventQueue.add(substituteLoggingEvent);
    }

    public final void handle_1ArgsCall(Level level, String str, Object obj) {
        handleNormalizedLoggingCall(level, new Object[]{obj});
    }

    @Override // org.slf4j.Logger
    public final void info(String str) {
        handleNormalizedLoggingCall(Level.INFO, null);
    }

    @Override // org.slf4j.Logger
    public final boolean isDebugEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isErrorEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isInfoEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isTraceEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isWarnEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public final void trace(String str) {
        handleNormalizedLoggingCall(Level.TRACE, null);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str) {
        handleNormalizedLoggingCall(Level.WARN, null);
    }

    @Override // org.slf4j.Logger
    public final boolean isDebugEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isErrorEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isInfoEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isTraceEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.Logger
    public final boolean isWarnEnabled(Marker marker) {
        return true;
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object obj) {
        handle_1ArgsCall(Level.DEBUG, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object obj) {
        handle_1ArgsCall(Level.ERROR, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object obj) {
        handle_1ArgsCall(Level.INFO, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object obj) {
        handle_1ArgsCall(Level.TRACE, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object obj) {
        handle_1ArgsCall(Level.WARN, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object obj, Object obj2) {
        handle2ArgsCall(Level.DEBUG, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object obj, Object obj2) {
        handle2ArgsCall(Level.ERROR, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object obj, Object obj2) {
        handle2ArgsCall(Level.INFO, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object obj, Object obj2) {
        handle2ArgsCall(Level.TRACE, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object obj, Object obj2) {
        handle2ArgsCall(Level.WARN, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object... objArr) {
        handleArgArrayCall(Level.DEBUG, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object... objArr) {
        handleArgArrayCall(Level.ERROR, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object... objArr) {
        handleArgArrayCall(Level.INFO, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object... objArr) {
        handleArgArrayCall(Level.TRACE, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object... objArr) {
        handleArgArrayCall(Level.WARN, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Throwable th) {
        handleNormalizedLoggingCall(Level.DEBUG, null);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Throwable th) {
        handleNormalizedLoggingCall(Level.ERROR, null);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Throwable th) {
        handleNormalizedLoggingCall(Level.INFO, null);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Throwable th) {
        handleNormalizedLoggingCall(Level.TRACE, null);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Throwable th) {
        handleNormalizedLoggingCall(Level.WARN, null);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str) {
        handleNormalizedLoggingCall(Level.DEBUG, null);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str) {
        handleNormalizedLoggingCall(Level.ERROR, null);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str) {
        handleNormalizedLoggingCall(Level.INFO, null);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str) {
        handleNormalizedLoggingCall(Level.TRACE, null);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str) {
        handleNormalizedLoggingCall(Level.WARN, null);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Object obj) {
        handle_1ArgsCall(Level.DEBUG, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Object obj) {
        handle_1ArgsCall(Level.ERROR, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Object obj) {
        handle_1ArgsCall(Level.INFO, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Object obj) {
        handle_1ArgsCall(Level.TRACE, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Object obj) {
        handle_1ArgsCall(Level.WARN, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Object obj, Object obj2) {
        handle2ArgsCall(Level.DEBUG, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Object obj, Object obj2) {
        handle2ArgsCall(Level.ERROR, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Object obj, Object obj2) {
        handle2ArgsCall(Level.INFO, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Object obj, Object obj2) {
        handle2ArgsCall(Level.TRACE, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Object obj, Object obj2) {
        handle2ArgsCall(Level.WARN, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Object... objArr) {
        handleArgArrayCall(Level.DEBUG, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Object... objArr) {
        handleArgArrayCall(Level.ERROR, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Object... objArr) {
        handleArgArrayCall(Level.INFO, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Object... objArr) {
        handleArgArrayCall(Level.TRACE, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Object... objArr) {
        handleArgArrayCall(Level.WARN, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Throwable th) {
        handleNormalizedLoggingCall(Level.DEBUG, null);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Throwable th) {
        handleNormalizedLoggingCall(Level.ERROR, null);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Throwable th) {
        handleNormalizedLoggingCall(Level.INFO, null);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Throwable th) {
        handleNormalizedLoggingCall(Level.TRACE, null);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Throwable th) {
        handleNormalizedLoggingCall(Level.WARN, null);
    }
}
