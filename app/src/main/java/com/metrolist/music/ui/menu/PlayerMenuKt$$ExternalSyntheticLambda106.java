package com.metrolist.music.ui.menu;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.R;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerMenuKt$$ExternalSyntheticLambda106 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ MutableState f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ MutableState f$5;
    public final /* synthetic */ MutableState f$6;
    public final /* synthetic */ MutableState f$7;
    public final /* synthetic */ Object f$8;

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda106(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, AddToPlaylistPosition addToPlaylistPosition, MusicDatabase musicDatabase, SyncUtils syncUtils, Function0 function0, CoroutineScope coroutineScope) {
        this.$r8$classId = (byte) 2;
        this.f$0 = coroutineScope;
        this.f$3 = mutableState;
        this.f$5 = mutableState2;
        this.f$6 = mutableState3;
        this.f$7 = mutableState4;
        this.f$1 = musicDatabase;
        this.f$2 = addToPlaylistPosition;
        this.f$8 = syncUtils;
        this.f$4 = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        MutableState mutableState = this.f$7;
        MutableState mutableState2 = this.f$6;
        MutableState mutableState3 = this.f$5;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$4;
        Object obj2 = this.f$8;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        MutableState mutableState4 = this.f$3;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                Context context = (Context) obj5;
                String str = (String) obj4;
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) obj3;
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = (DataStoreKt$rememberPreference$1$1) obj;
                MutableState mutableState5 = (MutableState) obj2;
                String str2 = (String) mutableState4.getValue();
                if (StringsKt.isBlank(str2)) {
                    str2 = null;
                }
                if (str2 == null) {
                    str2 = (String) dataStoreKt$rememberPreference$1$1.$state.getValue();
                }
                String string = StringsKt.trim(str2).toString();
                if (!StringsKt.isBlank(string)) {
                    dataStoreKt$rememberPreference$1$1.setValue(string);
                    Toast.makeText(context, String.format(str, Arrays.copyOf(new Object[]{(String) mutableState3.getValue()}, 1)), 0).show();
                    mutableState2.setValue(Boolean.TRUE);
                    mutableState.setValue(Boolean.FALSE);
                    mutableState5.setValue(null);
                    listenTogetherManager.connect();
                    listenTogetherManager.joinRoom((String) mutableState3.getValue(), string);
                } else {
                    Toast.makeText(context, R.string.error_username_empty, 0).show();
                }
                break;
            case 1:
                Context context2 = (Context) obj5;
                String str3 = (String) obj4;
                ListenTogetherManager listenTogetherManager2 = (ListenTogetherManager) obj3;
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$2 = (DataStoreKt$rememberPreference$1$1) obj;
                MutableState mutableState6 = (MutableState) obj2;
                String str4 = (String) mutableState4.getValue();
                if (StringsKt.isBlank(str4)) {
                    str4 = null;
                }
                if (str4 == null) {
                    str4 = (String) dataStoreKt$rememberPreference$1$2.$state.getValue();
                }
                String string2 = StringsKt.trim(str4).toString();
                if (!StringsKt.isBlank(string2)) {
                    dataStoreKt$rememberPreference$1$2.setValue(string2);
                    Toast.makeText(context2, String.format(str3, Arrays.copyOf(new Object[]{(String) mutableState3.getValue()}, 1)), 0).show();
                    mutableState2.setValue(Boolean.TRUE);
                    mutableState.setValue(Boolean.FALSE);
                    mutableState6.setValue(null);
                    listenTogetherManager2.connect();
                    listenTogetherManager2.joinRoom((String) mutableState3.getValue(), string2);
                } else {
                    Toast.makeText(context2, R.string.error_username_empty, 0).show();
                }
                break;
            default:
                mutableState4.setValue(Boolean.FALSE);
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                AwaitKt.launch$default((CoroutineScope) obj5, DefaultIoScheduler.INSTANCE, null, new MutatorMutex.AnonymousClass2(this.f$5, this.f$6, this.f$7, (MusicDatabase) obj4, (AddToPlaylistPosition) obj3, (SyncUtils) obj2, (Function0) obj, null), 2);
                break;
        }
        return unit;
    }

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda106(Context context, String str, ListenTogetherManager listenTogetherManager, MutableState mutableState, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, byte b) {
        this.$r8$classId = b;
        this.f$0 = context;
        this.f$1 = str;
        this.f$2 = listenTogetherManager;
        this.f$3 = mutableState;
        this.f$4 = dataStoreKt$rememberPreference$1$1;
        this.f$5 = mutableState2;
        this.f$6 = mutableState3;
        this.f$7 = mutableState4;
        this.f$8 = mutableState5;
    }
}
