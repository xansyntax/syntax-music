package com.metrolist.music.ui.component.shimmer;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.datastore.preferences.core.Preferences$Key;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$2 implements MutableState {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ Preferences$Key $key;
    public final /* synthetic */ State $state;

    public GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$2(MutableState mutableState, CoroutineScope coroutineScope, Context context, Preferences$Key preferences$Key) {
        this.$state = mutableState;
        this.$coroutineScope = coroutineScope;
        this.$context = context;
        this.$key = preferences$Key;
    }

    @Override // androidx.compose.runtime.MutableState
    public final Object component1() {
        return (Enum) this.$state.getValue();
    }

    @Override // androidx.compose.runtime.MutableState
    public final Function1 component2() {
        return new CallsKt$await$2$1((byte) 19, this);
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return (Enum) this.$state.getValue();
    }

    @Override // androidx.compose.runtime.MutableState
    public final void setValue(Object obj) {
        Enum r3 = (Enum) obj;
        r3.getClass();
        AwaitKt.launch$default(this.$coroutineScope, null, null, new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2.AnonymousClass1(this.$context, this.$key, r3, null, (byte) 11), 3);
    }
}
