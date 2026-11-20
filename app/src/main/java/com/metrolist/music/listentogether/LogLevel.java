package com.metrolist.music.listentogether;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LogLevel {
    public static final /* synthetic */ LogLevel[] $VALUES;
    public static final LogLevel DEBUG;
    public static final LogLevel ERROR;
    public static final LogLevel INFO;
    public static final LogLevel WARNING;

    static {
        LogLevel logLevel = new LogLevel("INFO", 0);
        INFO = logLevel;
        LogLevel logLevel2 = new LogLevel("WARNING", 1);
        WARNING = logLevel2;
        LogLevel logLevel3 = new LogLevel("ERROR", 2);
        ERROR = logLevel3;
        LogLevel logLevel4 = new LogLevel("DEBUG", 3);
        DEBUG = logLevel4;
        $VALUES = new LogLevel[]{logLevel, logLevel2, logLevel3, logLevel4};
    }

    public static LogLevel valueOf(String str) {
        return (LogLevel) Enum.valueOf(LogLevel.class, str);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) $VALUES.clone();
    }
}
