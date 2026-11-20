package com.metrolist.music.ui.component;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda63;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda7;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ChipsRowKt$$ExternalSyntheticLambda7 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState f$1;
    public final /* synthetic */ List f$2;
    public final /* synthetic */ Function1 f$3;

    public /* synthetic */ ChipsRowKt$$ExternalSyntheticLambda7(MutableState mutableState, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, List list, Function1 function1) {
        this.f$0 = mutableState;
        this.f$1 = parcelableSnapshotMutableFloatState;
        this.f$2 = list;
        this.f$3 = function1;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        MutableState mutableState = this.f$0;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.f$1;
        Function1 function1 = this.f$3;
        List<Pair> list = this.f$2;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14);
                    boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new QueueKt$$ExternalSyntheticLambda7(mutableState, parcelableSnapshotMutableFloatState, (byte) 1);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.m256DropdownMenuIlH_yew(zBooleanValue, (Function0) objRememberedValue, modifierM139paddingqDBjuR0$default, 0L, null, null, null, 0L, CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(144490335, new ChipsRowKt$$ExternalSyntheticLambda7(list, function1, parcelableSnapshotMutableFloatState, mutableState), gapComposer), gapComposer, 432, 2040);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    for (Pair pair : list) {
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-393084440, new MainActivity$$ExternalSyntheticLambda0((byte) 6, pair), gapComposer2);
                        boolean zChanged = gapComposer2.changed(function1) | gapComposer2.changed(pair);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new SongMenuKt$$ExternalSyntheticLambda63(function1, pair, parcelableSnapshotMutableFloatState, mutableState);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        CardKt.DropdownMenuItem(composableLambdaImplRememberComposableLambda, (Function0) objRememberedValue2, null, null, null, false, null, null, gapComposer2, 6, 508);
                    }
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ ChipsRowKt$$ExternalSyntheticLambda7(List list, Function1 function1, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, MutableState mutableState) {
        this.f$2 = list;
        this.f$3 = function1;
        this.f$1 = parcelableSnapshotMutableFloatState;
        this.f$0 = mutableState;
    }
}
