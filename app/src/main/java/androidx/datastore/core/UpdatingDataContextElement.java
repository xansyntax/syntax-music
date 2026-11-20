package androidx.datastore.core;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class UpdatingDataContextElement implements CoroutineContext.Element {
    public final DataStoreImpl instance;
    public final UpdatingDataContextElement parent;

    public UpdatingDataContextElement(UpdatingDataContextElement updatingDataContextElement, DataStoreImpl dataStoreImpl) {
        this.parent = updatingDataContextElement;
        this.instance = dataStoreImpl;
    }

    public final void checkNotUpdating(DataStoreImpl dataStoreImpl) {
        if (this.instance == dataStoreImpl) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.");
            return;
        }
        UpdatingDataContextElement updatingDataContextElement = this.parent;
        if (updatingDataContextElement != null) {
            updatingDataContextElement.checkNotUpdating(dataStoreImpl);
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final /* bridge */ CoroutineContext.Element get(CoroutineContext.Key key) {
        return StringsKt__IndentKt.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return DataMigrationInitializer$Companion.INSTANCE;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final /* bridge */ CoroutineContext minusKey(CoroutineContext.Key key) {
        return StringsKt__IndentKt.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final /* bridge */ CoroutineContext plus(CoroutineContext coroutineContext) {
        return StringsKt__IndentKt.plus(this, coroutineContext);
    }
}
