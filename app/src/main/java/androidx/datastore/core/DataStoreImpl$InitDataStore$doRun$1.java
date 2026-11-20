package androidx.datastore.core;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DataStoreImpl$InitDataStore$doRun$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ Dispatcher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$InitDataStore$doRun$1(Dispatcher dispatcher, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = dispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doRun(this);
    }
}
