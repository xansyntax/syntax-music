package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.grid.GridCells$Fixed;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import coil3.util.LifecyclesKt;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda24;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda12;
import com.metrolist.music.ui.screens.settings.AppearanceSettingsKt$$ExternalSyntheticLambda50;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda32 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ float f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda32(float f, MutableState mutableState, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState) {
        this.f$1 = f;
        this.f$0 = mutableState;
        this.f$2 = mimesKt$$ExternalSyntheticLambda0;
        this.f$3 = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Object obj4 = this.f$3;
        Object obj5 = this.f$2;
        Object obj6 = this.f$0;
        float f = this.f$1;
        switch (b) {
            case 0:
                List list = (List) obj6;
                PaddingValuesImpl paddingValuesImpl = (PaddingValuesImpl) obj5;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj4;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    int i = list.size() <= 6 ? 1 : 2;
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new LazyGridState(0, 0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    LazyGridState lazyGridState = (LazyGridState) objRememberedValue;
                    GridCells$Fixed gridCells$Fixed = new GridCells$Fixed(i);
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    gapComposer.startReplaceGroup(-838583153);
                    Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    float fMo76toDpGaN1DYA = density.mo76toDpGaN1DYA(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodySmall.paragraphStyle.lineHeight) + density.mo76toDpGaN1DYA(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.titleMedium.paragraphStyle.lineHeight) + CropImageView.DEFAULT_ASPECT_RATIO + 40.0f + CropImageView.DEFAULT_ASPECT_RATIO;
                    gapComposer.end(false);
                    Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(modifierFillMaxWidth, ((f + fMo76toDpGaN1DYA + CropImageView.DEFAULT_ASPECT_RATIO) * i) + CropImageView.DEFAULT_ASPECT_RATIO);
                    boolean zChangedInstance = gapComposer.changedInstance(list);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new HomeScreenKt$$ExternalSyntheticLambda60(list, composableLambdaImpl, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    LifecyclesKt.LazyHorizontalGrid(gridCells$Fixed, modifierM145height3ABfNKs, lazyGridState, paddingValuesImpl, null, null, null, false, null, null, (Function1) objRememberedValue2, gapComposer, 384, 2032);
                }
                break;
            default:
                MutableState mutableState = (MutableState) obj6;
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) obj5;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj4;
                RowScope rowScope = (RowScope) obj;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                rowScope.getClass();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= ((GapComposer) composer2).changed(rowScope) ? 4 : 2;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new LibrarySongsScreenKt$$ExternalSyntheticLambda12(parcelableSnapshotMutableFloatState, (byte) 5);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.TextButton((Function0) objRememberedValue3, null, false, null, null, null, LastFMSettingsKt.f592lambda$1043351634, gapComposer2, 805306374, 510);
                    OffsetKt.Spacer(gapComposer2, rowScope.weight(companion, 1.0f, true));
                    boolean zChanged = gapComposer2.changed(f) | gapComposer2.changed(mutableState);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new AppearanceSettingsKt$$ExternalSyntheticLambda50(f, parcelableSnapshotMutableFloatState, mutableState, (byte) 7);
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    CardKt.TextButton((Function0) objRememberedValue4, null, false, null, null, null, LastFMSettingsKt.lambda$1109179301, gapComposer2, 805306368, 510);
                    boolean zChanged2 = gapComposer2.changed(mimesKt$$ExternalSyntheticLambda0) | gapComposer2.changed(mutableState);
                    Object objRememberedValue5 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new QueueKt$$ExternalSyntheticLambda24((Object) mimesKt$$ExternalSyntheticLambda0, (Object) parcelableSnapshotMutableFloatState, (Object) mutableState, (byte) 15);
                        gapComposer2.updateRememberedValue(objRememberedValue5);
                    }
                    CardKt.TextButton((Function0) objRememberedValue5, null, false, null, null, null, LastFMSettingsKt.lambda$1285507558, gapComposer2, 805306368, 510);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda32(List list, float f, PaddingValuesImpl paddingValuesImpl, ComposableLambdaImpl composableLambdaImpl) {
        this.f$0 = list;
        this.f$1 = f;
        this.f$2 = paddingValuesImpl;
        this.f$3 = composableLambdaImpl;
    }
}
