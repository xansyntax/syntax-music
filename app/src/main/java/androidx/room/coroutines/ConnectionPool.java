package androidx.room.coroutines;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ConnectionPool extends AutoCloseable {
    Object useConnection(boolean z, Function2 function2, ContinuationImpl continuationImpl);
}
