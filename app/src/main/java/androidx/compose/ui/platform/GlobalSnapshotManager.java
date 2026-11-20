package androidx.compose.ui.platform;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GlobalSnapshotManager {
    public static final AtomicBoolean started = new AtomicBoolean(false);
    public static final AtomicBoolean sent = new AtomicBoolean(false);
}
