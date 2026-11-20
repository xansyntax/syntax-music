package com.metrolist.music.ui.screens.settings;

import androidx.compose.runtime.MutableState;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AiSettingsKt$$ExternalSyntheticLambda66 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ DataStoreKt$rememberPreference$1$1 f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ AiSettingsKt$$ExternalSyntheticLambda66(DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = dataStoreKt$rememberPreference$1$1;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = this.f$0;
        switch (b) {
            case 0:
                dataStoreKt$rememberPreference$1$1.setValue("");
                mutableState.setValue(Boolean.FALSE);
                break;
            default:
                dataStoreKt$rememberPreference$1$1.setValue("");
                mutableState.setValue("");
                break;
        }
        return unit;
    }
}
