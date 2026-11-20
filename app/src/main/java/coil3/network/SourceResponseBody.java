package coil3.network;

import java.io.IOException;
import okio.BufferedSource;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SourceResponseBody implements AutoCloseable {
    public final BufferedSource source;

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        this.source.close();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof SourceResponseBody) {
            return this.source.equals(((SourceResponseBody) obj).source);
        }
        return false;
    }

    public final int hashCode() {
        return this.source.hashCode();
    }

    public final String toString() {
        return "SourceResponseBody(source=" + this.source + ")";
    }
}
