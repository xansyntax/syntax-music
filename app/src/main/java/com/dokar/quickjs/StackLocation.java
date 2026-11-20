package com.dokar.quickjs;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StackLocation {
    public final Integer columnNumber;
    public final String fileName;
    public final Integer lineNumber;

    public StackLocation(String str, Integer num, Integer num2) {
        this.fileName = str;
        this.lineNumber = num;
        this.columnNumber = num2;
    }
}
