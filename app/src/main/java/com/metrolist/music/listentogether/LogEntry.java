package com.metrolist.music.listentogether;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LogEntry {
    public final String details;
    public final LogLevel level;
    public final String message;
    public final String timestamp;

    public LogEntry(String str, LogLevel logLevel, String str2, String str3) {
        this.timestamp = str;
        this.level = logLevel;
        this.message = str2;
        this.details = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEntry)) {
            return false;
        }
        LogEntry logEntry = (LogEntry) obj;
        return this.timestamp.equals(logEntry.timestamp) && this.level == logEntry.level && this.message.equals(logEntry.message) && Intrinsics.areEqual(this.details, logEntry.details);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m((this.level.hashCode() + (this.timestamp.hashCode() * 31)) * 31, 31, this.message);
        String str = this.details;
        return iM + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LogEntry(timestamp=");
        sb.append(this.timestamp);
        sb.append(", level=");
        sb.append(this.level);
        sb.append(", message=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.message, ", details=", this.details, ")");
    }
}
