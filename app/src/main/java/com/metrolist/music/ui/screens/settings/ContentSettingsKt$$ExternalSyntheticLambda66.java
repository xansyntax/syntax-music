package com.metrolist.music.ui.screens.settings;

import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import com.metrolist.music.ui.menu.AddToPlaylistDialogKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ContentSettingsKt$$ExternalSyntheticLambda66 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ MutableState f$3;
    public final /* synthetic */ MutableState f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ MutableState f$6;
    public final /* synthetic */ MutableState f$7;

    public /* synthetic */ ContentSettingsKt$$ExternalSyntheticLambda66(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, Function1 function1, Function1 function2, Function1 function3) {
        this.f$0 = function1;
        this.f$1 = mutableState;
        this.f$2 = function2;
        this.f$3 = mutableState2;
        this.f$4 = mutableState3;
        this.f$5 = function3;
        this.f$6 = mutableState4;
        this.f$7 = mutableState5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Object obj3 = this.f$5;
        Object obj4 = this.f$2;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                Function1 function1 = (Function1) obj5;
                Function1 function2 = (Function1) obj4;
                Function1 function3 = (Function1) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean zChanged = gapComposer.changed(function1);
                    MutableState mutableState = this.f$1;
                    boolean zChanged2 = zChanged | gapComposer.changed(mutableState) | gapComposer.changed(function2);
                    MutableState mutableState2 = this.f$3;
                    boolean zChanged3 = zChanged2 | gapComposer.changed(mutableState2);
                    MutableState mutableState3 = this.f$4;
                    boolean zChanged4 = zChanged3 | gapComposer.changed(mutableState3) | gapComposer.changed(function3);
                    MutableState mutableState4 = this.f$6;
                    boolean zChanged5 = zChanged4 | gapComposer.changed(mutableState4);
                    MutableState mutableState5 = this.f$7;
                    boolean zChanged6 = zChanged5 | gapComposer.changed(mutableState5);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged6 || objRememberedValue == neverEqualPolicy) {
                        AddToPlaylistDialogKt$$ExternalSyntheticLambda11 addToPlaylistDialogKt$$ExternalSyntheticLambda11 = new AddToPlaylistDialogKt$$ExternalSyntheticLambda11(mutableState, mutableState2, mutableState3, mutableState4, mutableState5, function1, function2, function3);
                        gapComposer.updateRememberedValue(addToPlaylistDialogKt$$ExternalSyntheticLambda11);
                        objRememberedValue = addToPlaylistDialogKt$$ExternalSyntheticLambda11;
                    }
                    CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, AiSettingsKt.f478lambda$1504755658, gapComposer, 805306368, 510);
                }
                break;
            default:
                CoroutineScope coroutineScope = (CoroutineScope) obj5;
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = (DataStoreKt$rememberPreference$1$1) obj4;
                MutableState mutableState6 = (MutableState) obj3;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    MutableState mutableState7 = this.f$1;
                    boolean zChanged7 = gapComposer2.changed(mutableState7);
                    MutableState mutableState8 = this.f$3;
                    boolean zChanged8 = zChanged7 | gapComposer2.changed(mutableState8);
                    MutableState mutableState9 = this.f$4;
                    boolean zChanged9 = zChanged8 | gapComposer2.changed(mutableState9);
                    MutableState mutableState10 = this.f$6;
                    boolean zChanged10 = zChanged9 | gapComposer2.changed(mutableState10) | gapComposer2.changedInstance(coroutineScope);
                    MutableState mutableState11 = this.f$7;
                    boolean zChanged11 = zChanged10 | gapComposer2.changed(mutableState11) | gapComposer2.changed(dataStoreKt$rememberPreference$1$1) | gapComposer2.changed(mutableState6);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged11 || objRememberedValue2 == neverEqualPolicy) {
                        AddToPlaylistDialogKt$$ExternalSyntheticLambda11 addToPlaylistDialogKt$$ExternalSyntheticLambda12 = new AddToPlaylistDialogKt$$ExternalSyntheticLambda11(coroutineScope, mutableState7, mutableState8, mutableState9, mutableState10, mutableState11, dataStoreKt$rememberPreference$1$1, mutableState6, (byte) 3);
                        gapComposer2.updateRememberedValue(addToPlaylistDialogKt$$ExternalSyntheticLambda12);
                        objRememberedValue2 = addToPlaylistDialogKt$$ExternalSyntheticLambda12;
                    }
                    CardKt.TextButton((Function0) objRememberedValue2, null, !((Boolean) mutableState10.getValue()).booleanValue(), null, null, null, LastFMSettingsKt.lambda$2017183053, gapComposer2, 805306368, 506);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ ContentSettingsKt$$ExternalSyntheticLambda66(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, CoroutineScope coroutineScope, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$2, MutableState mutableState5) {
        this.f$1 = mutableState;
        this.f$3 = mutableState2;
        this.f$4 = mutableState3;
        this.f$6 = mutableState4;
        this.f$0 = coroutineScope;
        this.f$7 = dataStoreKt$rememberPreference$1$1;
        this.f$2 = dataStoreKt$rememberPreference$1$2;
        this.f$5 = mutableState5;
    }
}
