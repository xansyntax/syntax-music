package com.metrolist.music.ui.screens.settings;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.Modifier;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda12;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppearanceSettingsKt$$ExternalSyntheticLambda51 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ float f$0;
    public final /* synthetic */ Function1 f$1;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState f$2;
    public final /* synthetic */ MutableState f$3;

    public /* synthetic */ AppearanceSettingsKt$$ExternalSyntheticLambda51(float f, MutableState mutableState, Function1 function1, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState) {
        this.$r8$classId = (byte) 1;
        this.f$0 = f;
        this.f$3 = mutableState;
        this.f$1 = function1;
        this.f$2 = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        MutableState mutableState = this.f$3;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.f$2;
        Function1 function1 = this.f$1;
        float f = this.f$0;
        switch (b) {
            case 0:
                RowScope rowScope = (RowScope) obj;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                rowScope.getClass();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= ((GapComposer) composer).changed(rowScope) ? 4 : 2;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new LibrarySongsScreenKt$$ExternalSyntheticLambda12(parcelableSnapshotMutableFloatState, (byte) 3);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, AiSettingsKt.f473lambda$1401131877, gapComposer, 805306374, 510);
                    OffsetKt.Spacer(gapComposer, rowScope.weight(companion, 1.0f, true));
                    boolean zChanged = gapComposer.changed(f);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new AppearanceSettingsKt$$ExternalSyntheticLambda50(f, parcelableSnapshotMutableFloatState, mutableState, (byte) 3);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    CardKt.TextButton((Function0) objRememberedValue2, null, false, null, null, null, AiSettingsKt.f485lambda$1536441212, gapComposer, 805306368, 510);
                    boolean zChanged2 = gapComposer.changed(function1);
                    Object objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new ContentSettingsKt$$ExternalSyntheticLambda106(function1, parcelableSnapshotMutableFloatState, mutableState, (byte) 2);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.TextButton((Function0) objRememberedValue3, null, false, null, null, null, AiSettingsKt.lambda$717850979, gapComposer, 805306368, 510);
                }
                break;
            case 1:
                RowScope rowScope2 = (RowScope) obj;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                rowScope2.getClass();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= ((GapComposer) composer2).changed(rowScope2) ? 4 : 2;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new LibrarySongsScreenKt$$ExternalSyntheticLambda12(parcelableSnapshotMutableFloatState, (byte) 4);
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    CardKt.TextButton((Function0) objRememberedValue4, null, false, null, null, null, AiSettingsKt.f555lambda$541758338, gapComposer2, 805306374, 510);
                    OffsetKt.Spacer(gapComposer2, rowScope2.weight(companion, 1.0f, true));
                    boolean zChanged3 = gapComposer2.changed(f) | gapComposer2.changed(mutableState);
                    Object objRememberedValue5 = gapComposer2.rememberedValue();
                    if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new AppearanceSettingsKt$$ExternalSyntheticLambda50(f, parcelableSnapshotMutableFloatState, mutableState, (byte) 4);
                        gapComposer2.updateRememberedValue(objRememberedValue5);
                    }
                    CardKt.TextButton((Function0) objRememberedValue5, null, false, null, null, null, AiSettingsKt.f490lambda$1633740761, gapComposer2, 805306368, 510);
                    boolean zChanged4 = gapComposer2.changed(function1) | gapComposer2.changed(mutableState);
                    Object objRememberedValue6 = gapComposer2.rememberedValue();
                    if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new ContentSettingsKt$$ExternalSyntheticLambda106(function1, parcelableSnapshotMutableFloatState, mutableState, (byte) 3);
                        gapComposer2.updateRememberedValue(objRememberedValue6);
                    }
                    CardKt.TextButton((Function0) objRememberedValue6, null, false, null, null, null, AiSettingsKt.f575lambda$860698810, gapComposer2, 805306368, 510);
                }
                break;
            default:
                RowScope rowScope3 = (RowScope) obj;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                rowScope3.getClass();
                if ((iIntValue3 & 6) == 0) {
                    iIntValue3 |= ((GapComposer) composer3).changed(rowScope3) ? 4 : 2;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Object objRememberedValue7 = gapComposer3.rememberedValue();
                    if (objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new LibrarySongsScreenKt$$ExternalSyntheticLambda12(parcelableSnapshotMutableFloatState, (byte) 2);
                        gapComposer3.updateRememberedValue(objRememberedValue7);
                    }
                    CardKt.TextButton((Function0) objRememberedValue7, null, false, null, null, null, AiSettingsKt.f459lambda$1256722182, gapComposer3, 805306374, 510);
                    OffsetKt.Spacer(gapComposer3, rowScope3.weight(companion, 1.0f, true));
                    boolean zChanged5 = gapComposer3.changed(f);
                    Object objRememberedValue8 = gapComposer3.rememberedValue();
                    if (zChanged5 || objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new AppearanceSettingsKt$$ExternalSyntheticLambda50(f, parcelableSnapshotMutableFloatState, mutableState, (byte) 2);
                        gapComposer3.updateRememberedValue(objRememberedValue8);
                    }
                    CardKt.TextButton((Function0) objRememberedValue8, null, false, null, null, null, AiSettingsKt.f472lambda$1392031517, gapComposer3, 805306368, 510);
                    boolean zChanged6 = gapComposer3.changed(function1);
                    Object objRememberedValue9 = gapComposer3.rememberedValue();
                    if (zChanged6 || objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new ContentSettingsKt$$ExternalSyntheticLambda106(function1, parcelableSnapshotMutableFloatState, mutableState, (byte) 1);
                        gapComposer3.updateRememberedValue(objRememberedValue9);
                    }
                    CardKt.TextButton((Function0) objRememberedValue9, null, false, null, null, null, AiSettingsKt.lambda$862260674, gapComposer3, 805306368, 510);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ AppearanceSettingsKt$$ExternalSyntheticLambda51(float f, Function1 function1, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = f;
        this.f$1 = function1;
        this.f$2 = parcelableSnapshotMutableFloatState;
        this.f$3 = mutableState;
    }
}
