package androidx.activity;

import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FullyDrawnReporter {
    public final Object lock;
    public final ArrayList onReportCallbacks;
    public boolean reportedFullyDrawn;

    public FullyDrawnReporter(Executor executor, ComponentActivity$$ExternalSyntheticLambda1 componentActivity$$ExternalSyntheticLambda1) {
        executor.getClass();
        this.lock = new Object();
        this.onReportCallbacks = new ArrayList();
    }
}
