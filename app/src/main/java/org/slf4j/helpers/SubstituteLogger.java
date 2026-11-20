package org.slf4j.helpers;

import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.EventRecordingLogger;
import org.slf4j.event.Level;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.spi.LoggingEventBuilder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SubstituteLogger implements Logger {
    public volatile Logger _delegate;
    public final boolean createdPostInitialization;
    public Boolean delegateEventAware;
    public final LinkedBlockingQueue eventQueue;
    public EventRecordingLogger eventRecordingLogger;
    public Method logMethodCache;
    public final String name;

    public SubstituteLogger(String str, LinkedBlockingQueue linkedBlockingQueue, boolean z) {
        this.name = str;
        this.eventQueue = linkedBlockingQueue;
        this.createdPostInitialization = z;
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str) {
        delegate().debug((Marker) null, str);
    }

    public final Logger delegate() {
        if (this._delegate != null) {
            return this._delegate;
        }
        if (this.createdPostInitialization) {
            return NOPLogger.NOP_LOGGER;
        }
        EventRecordingLogger eventRecordingLogger = this.eventRecordingLogger;
        if (eventRecordingLogger != null) {
            return eventRecordingLogger;
        }
        LinkedBlockingQueue linkedBlockingQueue = this.eventQueue;
        EventRecordingLogger eventRecordingLogger2 = new EventRecordingLogger();
        eventRecordingLogger2.logger = this;
        eventRecordingLogger2.name = this.name;
        eventRecordingLogger2.eventQueue = linkedBlockingQueue;
        this.eventRecordingLogger = eventRecordingLogger2;
        return eventRecordingLogger2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && SubstituteLogger.class == obj.getClass() && this.name.equals(((SubstituteLogger) obj).name);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str) {
        delegate().error((Marker) null, str);
    }

    @Override // org.slf4j.Logger
    public final String getName() {
        return this.name;
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str) {
        delegate().info((Marker) null, str);
    }

    @Override // org.slf4j.Logger
    public final boolean isDebugEnabled(Marker marker) {
        return delegate().isDebugEnabled(null);
    }

    public final boolean isDelegateEventAware() {
        Boolean bool;
        Boolean bool2 = this.delegateEventAware;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        try {
            this.logMethodCache = this._delegate.getClass().getMethod("log", SubstituteLoggingEvent.class);
            bool = Boolean.TRUE;
            this.delegateEventAware = bool;
        } catch (NoSuchMethodException unused) {
            bool = Boolean.FALSE;
            this.delegateEventAware = bool;
        }
        return bool.booleanValue();
    }

    @Override // org.slf4j.Logger
    public final boolean isEnabledForLevel(Level level) {
        return delegate().isEnabledForLevel(level);
    }

    @Override // org.slf4j.Logger
    public final boolean isErrorEnabled(Marker marker) {
        return delegate().isErrorEnabled(null);
    }

    @Override // org.slf4j.Logger
    public final boolean isInfoEnabled(Marker marker) {
        return delegate().isInfoEnabled(null);
    }

    @Override // org.slf4j.Logger
    public final boolean isTraceEnabled(Marker marker) {
        return delegate().isTraceEnabled(null);
    }

    @Override // org.slf4j.Logger
    public final boolean isWarnEnabled(Marker marker) {
        return delegate().isWarnEnabled(null);
    }

    @Override // org.slf4j.Logger
    public final LoggingEventBuilder makeLoggingEventBuilder(Level level) {
        return delegate().makeLoggingEventBuilder(level);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str) {
        delegate().trace((Marker) null, str);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str) {
        delegate().warn((Marker) null, str);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object obj) {
        delegate().debug(str, obj);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object obj) {
        delegate().error(str, obj);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object obj) {
        delegate().info(str, obj);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object obj) {
        delegate().trace(str, obj);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object obj) {
        delegate().warn(str, obj);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object obj, Object obj2) {
        delegate().debug(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object obj, Object obj2) {
        delegate().error(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object obj, Object obj2) {
        delegate().info(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final boolean isDebugEnabled() {
        return delegate().isDebugEnabled();
    }

    @Override // org.slf4j.Logger
    public final boolean isErrorEnabled() {
        return delegate().isErrorEnabled();
    }

    @Override // org.slf4j.Logger
    public final boolean isInfoEnabled() {
        return delegate().isInfoEnabled();
    }

    @Override // org.slf4j.Logger
    public final boolean isTraceEnabled() {
        return delegate().isTraceEnabled();
    }

    @Override // org.slf4j.Logger
    public final boolean isWarnEnabled() {
        return delegate().isWarnEnabled();
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object obj, Object obj2) {
        delegate().trace(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object obj, Object obj2) {
        delegate().warn(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object... objArr) {
        delegate().debug(str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object... objArr) {
        delegate().error(str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object... objArr) {
        delegate().info(str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object... objArr) {
        delegate().trace(str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object... objArr) {
        delegate().warn(str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Throwable th) {
        delegate().debug(str, th);
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Throwable th) {
        delegate().error(str, th);
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Throwable th) {
        delegate().info(str, th);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Throwable th) {
        delegate().trace(str, th);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Throwable th) {
        delegate().warn(str, th);
    }

    @Override // org.slf4j.Logger
    public final void debug(String str) {
        delegate().debug(str);
    }

    @Override // org.slf4j.Logger
    public final void error(String str) {
        delegate().error(str);
    }

    @Override // org.slf4j.Logger
    public final void info(String str) {
        delegate().info(str);
    }

    @Override // org.slf4j.Logger
    public final void trace(String str) {
        delegate().trace(str);
    }

    @Override // org.slf4j.Logger
    public final void warn(String str) {
        delegate().warn(str);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Object obj) {
        delegate().debug((Marker) null, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Object obj) {
        delegate().error((Marker) null, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Object obj) {
        delegate().info((Marker) null, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Object obj) {
        delegate().trace((Marker) null, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Object obj) {
        delegate().warn((Marker) null, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Object obj, Object obj2) {
        delegate().debug(null, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Object obj, Object obj2) {
        delegate().error(null, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Object obj, Object obj2) {
        delegate().info(null, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Object obj, Object obj2) {
        delegate().trace(null, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Object obj, Object obj2) {
        delegate().warn(null, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Object... objArr) {
        delegate().debug((Marker) null, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Object... objArr) {
        delegate().error((Marker) null, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Object... objArr) {
        delegate().info((Marker) null, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Object... objArr) {
        delegate().trace((Marker) null, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Object... objArr) {
        delegate().warn((Marker) null, str, objArr);
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Throwable th) {
        delegate().debug((Marker) null, str, th);
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Throwable th) {
        delegate().error((Marker) null, str, th);
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Throwable th) {
        delegate().info((Marker) null, str, th);
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Throwable th) {
        delegate().trace((Marker) null, str, th);
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Throwable th) {
        delegate().warn((Marker) null, str, th);
    }
}
