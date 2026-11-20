package com.metrolist.music.ui.menu;

import androidx.compose.runtime.MutableState;
import coil3.network.NetworkFetcher$doFetch$fetchResult$1;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt$LastFMSettings$2$1$1$1;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.SyncUtils;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AddToPlaylistDialogKt$$ExternalSyntheticLambda11 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ MutableState f$2;
    public final /* synthetic */ MutableState f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;

    public /* synthetic */ AddToPlaylistDialogKt$$ExternalSyntheticLambda11(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, Function1 function1, Function1 function2, Function1 function3) {
        this.$r8$classId = (byte) 2;
        this.f$0 = function1;
        this.f$4 = function2;
        this.f$5 = function3;
        this.f$1 = mutableState;
        this.f$2 = mutableState2;
        this.f$3 = mutableState3;
        this.f$6 = mutableState4;
        this.f$7 = mutableState5;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0045  */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        MutableState mutableState = this.f$1;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$7;
        Object obj2 = this.f$6;
        Object obj3 = this.f$5;
        Object obj4 = this.f$4;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                mutableState.setValue(Boolean.FALSE);
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj5, DefaultIoScheduler.INSTANCE, null, new NetworkFetcher$doFetch$fetchResult$1(this.f$2, this.f$3, (MusicDatabase) obj4, (AddToPlaylistPosition) obj3, (SyncUtils) obj2, (Function0) obj, null, (byte) 5), 2);
                break;
            case 1:
                mutableState.setValue(Boolean.FALSE);
                AwaitKt.launch$default((CoroutineScope) obj5, null, null, new QueueMenuKt$QueueMenu$7$1$1$1((MusicDatabase) obj4, (AddToPlaylistPosition) obj3, (Function0) obj, this.f$2, this.f$3, (MutableState) obj2, (Continuation) null), 3);
                break;
            case 2:
                Function1 function1 = (Function1) obj4;
                Function1 function2 = (Function1) obj3;
                MutableState mutableState2 = (MutableState) obj2;
                MutableState mutableState3 = (MutableState) obj;
                ((Function1) obj5).invoke((String) mutableState.getValue());
                MutableState mutableState4 = this.f$2;
                function1.invoke(((Boolean) mutableState4.getValue()).booleanValue() ? (String) this.f$3.getValue() : "");
                function2.invoke(((Boolean) mutableState4.getValue()).booleanValue() ? (String) mutableState2.getValue() : "");
                mutableState3.setValue(Boolean.FALSE);
                break;
            default:
                CoroutineScope coroutineScope = (CoroutineScope) obj5;
                MutableState mutableState5 = (MutableState) obj4;
                MutableState mutableState6 = (MutableState) obj3;
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = (DataStoreKt$rememberPreference$1$1) obj2;
                MutableState mutableState7 = (MutableState) obj;
                MutableState mutableState8 = this.f$1;
                boolean zIsBlank = StringsKt.isBlank((String) mutableState8.getValue());
                MutableState mutableState9 = this.f$3;
                if (!zIsBlank) {
                    MutableState mutableState10 = this.f$2;
                    if (!StringsKt.isBlank((String) mutableState10.getValue())) {
                        mutableState5.setValue(Boolean.TRUE);
                        mutableState9.setValue(null);
                        DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                        AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new LastFMSettingsKt$LastFMSettings$2$1$1$1(coroutineScope, mutableState8, mutableState10, mutableState6, dataStoreKt$rememberPreference$1$1, mutableState5, mutableState7, mutableState9, null), 2);
                    } else {
                        mutableState9.setValue("Please enter both username and password");
                    }
                } else {
                    mutableState9.setValue("Please enter both username and password");
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ AddToPlaylistDialogKt$$ExternalSyntheticLambda11(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, AddToPlaylistPosition addToPlaylistPosition, MusicDatabase musicDatabase, Function0 function0, CoroutineScope coroutineScope) {
        this.$r8$classId = (byte) 1;
        this.f$0 = coroutineScope;
        this.f$1 = mutableState;
        this.f$4 = musicDatabase;
        this.f$5 = addToPlaylistPosition;
        this.f$7 = function0;
        this.f$2 = mutableState2;
        this.f$3 = mutableState3;
        this.f$6 = mutableState4;
    }

    public /* synthetic */ AddToPlaylistDialogKt$$ExternalSyntheticLambda11(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Object obj, Object obj2, Object obj3, Object obj4, byte b) {
        this.$r8$classId = b;
        this.f$0 = coroutineScope;
        this.f$1 = mutableState;
        this.f$2 = mutableState2;
        this.f$3 = mutableState3;
        this.f$4 = obj;
        this.f$5 = obj2;
        this.f$6 = obj3;
        this.f$7 = obj4;
    }
}
