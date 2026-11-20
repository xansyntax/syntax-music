package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import coil3.size.SizeKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ChipKt$$ExternalSyntheticLambda15 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda15(long j, PullToRefreshStateImpl pullToRefreshStateImpl) {
        this.f$2 = j;
        this.f$1 = pullToRefreshStateImpl;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Object obj4 = this.f$1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                ((Integer) obj3).getClass();
                Function2 function2M278leadingContentXOJAsU = ChipKt.m278leadingContentXOJAsU((Function2) obj4, this.f$2, composer);
                GapComposer gapComposer = (GapComposer) composer;
                Object objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.mutableStateOf$default(function2M278leadingContentXOJAsU);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                MutableState mutableState = (MutableState) objRememberedValue;
                if (function2M278leadingContentXOJAsU != null) {
                    mutableState.setValue(function2M278leadingContentXOJAsU);
                }
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, companion);
                ComposeUiNode.Companion.getClass();
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(LayoutNode.Constructor);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                Stack.m389reconcileimpl(gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                Function2 function2 = (Function2) mutableState.getValue();
                if (function2 == null) {
                    gapComposer.startReplaceGroup(2094511935);
                } else {
                    gapComposer.startReplaceGroup(1037396226);
                    function2.invoke(gapComposer, 0);
                }
                gapComposer.end(false);
                gapComposer.end(true);
                break;
            default:
                PullToRefreshStateImpl pullToRefreshStateImpl = (PullToRefreshStateImpl) obj4;
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                Composer composer2 = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= ((GapComposer) composer2).changed(zBooleanValue) ? 4 : 2;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(1 & iIntValue, (iIntValue & 19) != 18)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    long j = this.f$2;
                    if (!zBooleanValue) {
                        gapComposer2.startReplaceGroup(-499540745);
                        boolean zChanged = gapComposer2.changed(pullToRefreshStateImpl);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new AppBarKt$$ExternalSyntheticLambda5((byte) 2, pullToRefreshStateImpl);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        SizeKt.m860CircularArrowProgressIndicatorRPmYEkk((FloatProducer) objRememberedValue2, j, gapComposer2, 0);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(-499763759);
                        ProgressIndicatorKt.m307CircularProgressIndicator4lLiAd8(androidx.compose.foundation.layout.SizeKt.m151size3ABfNKs(companion, 16.0f), j, 2.5f, 0, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer2, 6);
                        gapComposer2.end(false);
                    }
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda15(long j, Function2 function2) {
        this.f$1 = function2;
        this.f$2 = j;
    }
}
