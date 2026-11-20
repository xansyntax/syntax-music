package androidx.datastore.core;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class FileReadScope implements Closeable {
    public final AtomicBoolean closed = new AtomicBoolean(false);
    public final File file;

    public FileReadScope(File file) {
        this.file = file;
    }

    @Override // androidx.datastore.core.Closeable
    public final void close() {
        this.closed.set(true);
    }
}
