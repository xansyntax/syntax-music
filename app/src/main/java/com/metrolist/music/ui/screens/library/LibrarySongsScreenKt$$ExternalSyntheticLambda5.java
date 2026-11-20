package com.metrolist.music.ui.screens.library;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LibrarySongsScreenKt$$ExternalSyntheticLambda5 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ParcelableSnapshotMutableIntState f$0;
    public final /* synthetic */ ParcelableSnapshotMutableIntState f$1;
    public final /* synthetic */ MutableState f$2;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState f$3;

    public /* synthetic */ LibrarySongsScreenKt$$ExternalSyntheticLambda5(ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2, MutableState mutableState, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, byte b) {
        this.$r8$classId = b;
        this.f$0 = parcelableSnapshotMutableIntState;
        this.f$1 = parcelableSnapshotMutableIntState2;
        this.f$2 = mutableState;
        this.f$3 = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.f$3;
        MutableState mutableState = this.f$2;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.f$1;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    String strStringResource = MathKt.stringResource(R.string.upload_progress, new Object[]{Integer.valueOf(parcelableSnapshotMutableIntState2.getIntValue()), Integer.valueOf(parcelableSnapshotMutableIntState.getIntValue())}, gapComposer);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer, 0, 0, 131070);
                    OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 8.0f));
                    TextKt.m352TextNvy7gAk((String) mutableState.getValue(), null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer, 0, 0, 131066);
                    OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 16.0f));
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new LibrarySongsScreenKt$$ExternalSyntheticLambda12(parcelableSnapshotMutableFloatState, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    ProgressIndicatorKt.m309LinearProgressIndicatorGJbTh5U((Function0) objRememberedValue, SizeKt.fillMaxWidth(companion, 1.0f), 0L, 0L, 0, CropImageView.DEFAULT_ASPECT_RATIO, null, gapComposer, 54, 124);
                }
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    String strStringResource2 = MathKt.stringResource(R.string.upload_progress, new Object[]{Integer.valueOf(parcelableSnapshotMutableIntState2.getIntValue()), Integer.valueOf(parcelableSnapshotMutableIntState.getIntValue())}, gapComposer2);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource2, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).typography.bodyMedium, gapComposer2, 0, 0, 131070);
                    OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 8.0f));
                    TextKt.m352TextNvy7gAk((String) mutableState.getValue(), null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).typography.bodySmall, gapComposer2, 0, 0, 131066);
                    OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 16.0f));
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new LibrarySongsScreenKt$$ExternalSyntheticLambda12(parcelableSnapshotMutableFloatState, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    ProgressIndicatorKt.m309LinearProgressIndicatorGJbTh5U((Function0) objRememberedValue2, SizeKt.fillMaxWidth(companion, 1.0f), 0L, 0L, 0, CropImageView.DEFAULT_ASPECT_RATIO, null, gapComposer2, 54, 124);
                }
                break;
        }
        return unit;
    }
}
