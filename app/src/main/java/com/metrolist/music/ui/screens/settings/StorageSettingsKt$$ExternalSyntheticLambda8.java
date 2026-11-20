package com.metrolist.music.ui.screens.settings;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import com.google.common.math.IntMath;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.screens.settings.integrations.DiscordSettingsKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.metrolist.music.ui.screens.settings.integrations.ListenTogetherSettingsKt$$ExternalSyntheticLambda45;
import com.metrolist.music.ui.theme.UiStyleKt$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StorageSettingsKt$$ExternalSyntheticLambda8 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;

    public /* synthetic */ StorageSettingsKt$$ExternalSyntheticLambda8(MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        int i = R.drawable.close;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new PlayerSettingsKt$$ExternalSyntheticLambda29(mutableState, (byte) 16);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, AiSettingsKt.lambda$1056651547, gapComposer, 805306374, 510);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new AlarmSettingsKt$$ExternalSyntheticLambda14(mutableState, (byte) 3);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    CardKt.TextButton((Function0) objRememberedValue2, null, false, null, null, null, AiSettingsKt.lambda$656537910, gapComposer2, 805306374, 510);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    TextFieldDefaults.INSTANCE$2.TrailingIcon(((Boolean) mutableState.getValue()).booleanValue(), null, gapComposer3, 384);
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    boolean zChanged = gapComposer4.changed(mutableState);
                    Object objRememberedValue3 = gapComposer4.rememberedValue();
                    if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new PlayerSettingsKt$$ExternalSyntheticLambda0(mutableState, (byte) 25);
                        gapComposer4.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.TextButton((Function0) objRememberedValue3, null, false, null, null, null, AiSettingsKt.lambda$1247292924, gapComposer4, 805306368, 510);
                }
                break;
            case 4:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    boolean zChanged2 = gapComposer5.changed(mutableState);
                    Object objRememberedValue4 = gapComposer5.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new PlayerSettingsKt$$ExternalSyntheticLambda0(mutableState, (byte) 24);
                        gapComposer5.updateRememberedValue(objRememberedValue4);
                    }
                    CardKt.TextButton((Function0) objRememberedValue4, null, false, null, null, null, AiSettingsKt.lambda$1595929464, gapComposer5, 805306368, 510);
                }
                break;
            case 5:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    boolean zChanged3 = gapComposer6.changed(mutableState);
                    Object objRememberedValue5 = gapComposer6.rememberedValue();
                    if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new PlayerSettingsKt$$ExternalSyntheticLambda0(mutableState, (byte) 26);
                        gapComposer6.updateRememberedValue(objRememberedValue5);
                    }
                    CardKt.TextButton((Function0) objRememberedValue5, null, false, null, null, null, AiSettingsKt.f439lambda$105802056, gapComposer6, 805306368, 510);
                }
                break;
            case 6:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    gapComposer7.startReplaceGroup(848844837);
                    String strStringResource = (String) mutableState.getValue();
                    if (strStringResource.length() == 0) {
                        strStringResource = MathKt.stringResource(R.string.not_set, gapComposer7);
                    }
                    gapComposer7.end(false);
                    TextKt.m352TextNvy7gAk(strStringResource, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 262142);
                }
                break;
            case 7:
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                    boolean zChanged4 = gapComposer8.changed(mutableState);
                    Object objRememberedValue6 = gapComposer8.rememberedValue();
                    if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new ListenTogetherSettingsKt$$ExternalSyntheticLambda45(mutableState, (byte) 2);
                        gapComposer8.updateRememberedValue(objRememberedValue6);
                    }
                    MenuKt.Switch(zBooleanValue, (Function1) objRememberedValue6, null, Expect_jvmKt.rememberComposableLambda(579398849, new StorageSettingsKt$$ExternalSyntheticLambda8(mutableState, (byte) 9), gapComposer8), false, null, gapComposer8, 3072, 116);
                }
                break;
            case 8:
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer9), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer9, 56, 8);
                }
                break;
            case 9:
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    gapComposer10.skipToGroupEnd();
                } else {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer10), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer10, 56, 8);
                }
                break;
            case 10:
                Composer composer11 = (Composer) obj;
                int iIntValue11 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (!gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 3) != 2)) {
                    gapComposer11.skipToGroupEnd();
                } else if (!StringsKt.isBlank((String) mutableState.getValue())) {
                    gapComposer11.startReplaceGroup(1534904904);
                    boolean zChanged5 = gapComposer11.changed(mutableState);
                    Object objRememberedValue7 = gapComposer11.rememberedValue();
                    if (zChanged5 || objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new DiscordSettingsKt$$ExternalSyntheticLambda5(mutableState, (byte) 28);
                        gapComposer11.updateRememberedValue(objRememberedValue7);
                    }
                    Function0 function0 = (Function0) objRememberedValue7;
                    Object objRememberedValue8 = gapComposer11.rememberedValue();
                    if (objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new UiStyleKt$$ExternalSyntheticLambda0((byte) 26);
                        gapComposer11.updateRememberedValue(objRememberedValue8);
                    }
                    MenuKt.IconButton(function0, (Function0) objRememberedValue8, null, false, null, null, LastFMSettingsKt.lambda$1706219691, gapComposer11, 1572912);
                    gapComposer11.end(false);
                } else {
                    gapComposer11.startReplaceGroup(1535127856);
                    gapComposer11.end(false);
                }
                break;
            default:
                Composer composer12 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (!gapComposer12.shouldExecute(iIntValue12 & 1, (iIntValue12 & 3) != 2)) {
                    gapComposer12.skipToGroupEnd();
                } else {
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        i = R.drawable.check;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer12), (String) null, SizeKt.m151size3ABfNKs(companion, 16.0f), 0L, gapComposer12, 56, 8);
                }
                break;
        }
        return unit;
    }
}
