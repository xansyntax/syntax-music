package com.metrolist.music.lyrics;

import kotlin.text.Regex;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LyricsUtilsKt {
    public static final Regex LINE_REGEX = new Regex("((\\[\\d\\d:\\d\\d\\.\\d{2,3}\\] ?)+)(.*)");
    public static final Regex TIME_REGEX = new Regex("\\[(\\d\\d):(\\d\\d)\\.(\\d{2,3})\\]");
    public static final Regex RICH_SYNC_LINE_REGEX = new Regex("\\[(\\d{1,2}):(\\d{2})\\.(\\d{2,3})\\](.*)");
    public static final Regex RICH_SYNC_WORD_REGEX = new Regex("<(\\d{1,2}):(\\d{2})\\.(\\d{2,3})>([^<]+)");
    public static final Regex PAXSENIX_AGENT_LINE_REGEX = new Regex("\\[(\\d{1,2}):(\\d{2})\\.(\\d{2,3})\\](v\\d+):\\s*(.*)");
    public static final Regex PAXSENIX_BG_LINE_REGEX = new Regex("^\\[bg:\\s*(.*)\\]$");
    public static final Regex AGENT_REGEX = new Regex("\\{agent:([^}]+)\\}");
    public static final Regex BACKGROUND_REGEX = new Regex("^\\{bg\\}");
}
