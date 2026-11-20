package androidx.datastore.core;

import java.io.Serializable;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataMigrationInitializer$Companion$runMigrations$1 extends ContinuationImpl {
    public Serializable L$0;
    public Iterator L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ DataMigrationInitializer$Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataMigrationInitializer$Companion$runMigrations$1(DataMigrationInitializer$Companion dataMigrationInitializer$Companion, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = dataMigrationInitializer$Companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.runMigrations(null, null, this);
    }
}
