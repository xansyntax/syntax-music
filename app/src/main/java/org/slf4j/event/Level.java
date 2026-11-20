package org.slf4j.event;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public enum Level {
    ERROR("ERROR", "ERROR"),
    WARN("WARN", "WARN"),
    INFO("INFO", "INFO"),
    DEBUG("DEBUG", "DEBUG"),
    TRACE("TRACE", "TRACE");

    public final byte levelInt;
    public final String levelStr;

    /* JADX WARN: Multi-variable type inference failed */
    Level(String str, String str2) {
        this.levelInt = i;
        this.levelStr = str2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.levelStr;
    }
}
