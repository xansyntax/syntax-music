package com.metrolist.music.ui.menu;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.runtime.MutableState;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerMenuKt$$ExternalSyntheticLambda105 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ ListenTogetherManager f$1;
    public final /* synthetic */ MutableState f$2;
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 f$3;
    public final /* synthetic */ MutableState f$4;
    public final /* synthetic */ MutableState f$5;
    public final /* synthetic */ MutableState f$6;

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda105(Context context, ListenTogetherManager listenTogetherManager, MutableState mutableState, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, byte b) {
        this.$r8$classId = b;
        this.f$0 = context;
        this.f$1 = listenTogetherManager;
        this.f$2 = mutableState;
        this.f$3 = dataStoreKt$rememberPreference$1$1;
        this.f$4 = mutableState2;
        this.f$5 = mutableState3;
        this.f$6 = mutableState4;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$6;
        MutableState mutableState2 = this.f$5;
        MutableState mutableState3 = this.f$4;
        DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = this.f$3;
        MutableState mutableState4 = this.f$2;
        ListenTogetherManager listenTogetherManager = this.f$1;
        Context context = this.f$0;
        switch (b) {
            case 0:
                String str = (String) mutableState4.getValue();
                if (StringsKt.isBlank(str)) {
                    str = null;
                }
                if (str == null) {
                    str = (String) dataStoreKt$rememberPreference$1$1.$state.getValue();
                }
                String string = StringsKt.trim(str).toString();
                if (!StringsKt.isBlank(string)) {
                    dataStoreKt$rememberPreference$1$1.setValue(string);
                    Toast.makeText(context, R.string.creating_room, 0).show();
                    mutableState3.setValue(Boolean.TRUE);
                    mutableState2.setValue(Boolean.FALSE);
                    mutableState.setValue(null);
                    listenTogetherManager.connect();
                    listenTogetherManager.createRoom(string);
                } else {
                    Toast.makeText(context, R.string.error_username_empty, 0).show();
                }
                break;
            default:
                String str2 = (String) mutableState4.getValue();
                if (StringsKt.isBlank(str2)) {
                    str2 = null;
                }
                if (str2 == null) {
                    str2 = (String) dataStoreKt$rememberPreference$1$1.$state.getValue();
                }
                String string2 = StringsKt.trim(str2).toString();
                if (!StringsKt.isBlank(string2)) {
                    dataStoreKt$rememberPreference$1$1.setValue(string2);
                    Toast.makeText(context, R.string.creating_room, 0).show();
                    mutableState3.setValue(Boolean.TRUE);
                    mutableState2.setValue(Boolean.FALSE);
                    mutableState.setValue(null);
                    listenTogetherManager.connect();
                    listenTogetherManager.createRoom(string2);
                } else {
                    Toast.makeText(context, R.string.error_username_empty, 0).show();
                }
                break;
        }
        return unit;
    }
}
