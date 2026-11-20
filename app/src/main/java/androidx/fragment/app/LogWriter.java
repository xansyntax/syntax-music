package androidx.fragment.app;

import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LogWriter extends Writer {
    public final StringBuilder mBuilder = new StringBuilder(128);

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        flushBuilder();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        flushBuilder();
    }

    public final void flushBuilder() {
        StringBuilder sb = this.mBuilder;
        if (sb.length() > 0) {
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                flushBuilder();
            } else {
                this.mBuilder.append(c);
            }
        }
    }
}
