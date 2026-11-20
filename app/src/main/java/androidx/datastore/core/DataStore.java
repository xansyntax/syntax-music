package androidx.datastore.core;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface DataStore {
    Flow getData();

    Object updateData(Function2 function2, ContinuationImpl continuationImpl);
}
