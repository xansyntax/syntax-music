package org.slf4j.helpers;

import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.Marker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class NOPLogger implements Logger, Serializable {
    public static final NOPLogger NOP_LOGGER = new NOPLogger();

    @Override // org.slf4j.Logger
    public final String getName() {
        return "NOP";
    }

    @Override // org.slf4j.Logger
    public final boolean isDebugEnabled() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final boolean isErrorEnabled() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final boolean isInfoEnabled() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final boolean isTraceEnabled() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final boolean isWarnEnabled() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final boolean isDebugEnabled(Marker marker) {
        return false;
    }

    @Override // org.slf4j.Logger
    public final boolean isErrorEnabled(Marker marker) {
        return false;
    }

    @Override // org.slf4j.Logger
    public final boolean isInfoEnabled(Marker marker) {
        return false;
    }

    @Override // org.slf4j.Logger
    public final boolean isTraceEnabled(Marker marker) {
        return false;
    }

    @Override // org.slf4j.Logger
    public final boolean isWarnEnabled(Marker marker) {
        return false;
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object... objArr) {
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object... objArr) {
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object... objArr) {
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object... objArr) {
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object... objArr) {
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str) {
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str) {
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str) {
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str) {
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str) {
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void debug(Marker marker, String str, Object... objArr) {
    }

    @Override // org.slf4j.Logger
    public final void error(Marker marker, String str, Object... objArr) {
    }

    @Override // org.slf4j.Logger
    public final void info(Marker marker, String str, Object... objArr) {
    }

    @Override // org.slf4j.Logger
    public final void trace(Marker marker, String str, Object... objArr) {
    }

    @Override // org.slf4j.Logger
    public final void warn(Marker marker, String str, Object... objArr) {
    }

    @Override // org.slf4j.Logger
    public final void debug(String str) {
    }

    @Override // org.slf4j.Logger
    public final void error(String str) {
    }

    @Override // org.slf4j.Logger
    public final void info(String str) {
    }

    @Override // org.slf4j.Logger
    public final void trace(String str) {
    }

    @Override // org.slf4j.Logger
    public final void warn(String str) {
    }
}
