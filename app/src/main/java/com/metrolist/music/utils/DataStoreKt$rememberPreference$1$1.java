package com.metrolist.music.utils;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.datastore.preferences.core.Preferences$Key;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreKt$rememberPreference$1$1 implements MutableState {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ Preferences$Key $key;
    public final /* synthetic */ State $state;

    public DataStoreKt$rememberPreference$1$1(MutableState mutableState, CoroutineScope coroutineScope, Context context, Preferences$Key preferences$Key) {
        this.$state = mutableState;
        this.$coroutineScope = coroutineScope;
        this.$context = context;
        this.$key = preferences$Key;
    }

    @Override // androidx.compose.runtime.MutableState
    public final Object component1() {
        return this.$state.getValue();
    }

    @Override // androidx.compose.runtime.MutableState
    public final Function1 component2() {
        return new MimesKt$$ExternalSyntheticLambda0((byte) 18, this);
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return this.$state.getValue();
    }

    @Override // androidx.compose.runtime.MutableState
    public final void setValue(Object obj) {
        AwaitKt.launch$default(this.$coroutineScope, null, null, new DataStoreKt$get$2((Object) this.$context, (Object) this.$key, obj, (Continuation) null, (byte) 22), 3);
    }
}
