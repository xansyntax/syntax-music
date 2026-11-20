package androidx.compose.material3;

import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.LayoutDirection;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.ui.component.AppNavigationKt;
import com.metrolist.music.ui.component.LensController;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda11;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlertDialogKt$$ExternalSyntheticLambda11 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ float f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ AlertDialogKt$$ExternalSyntheticLambda11(float f, PaddingValuesImpl paddingValuesImpl, float f2, float f3, ComposableLambdaImpl composableLambdaImpl) {
        this.f$1 = f;
        this.f$2 = paddingValuesImpl;
        this.f$3 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        byte b2 = 6;
        Unit unit = Unit.INSTANCE;
        float f = this.f$1;
        Object obj3 = this.f$3;
        Object obj4 = this.f$2;
        switch (b) {
            case 0:
                LayoutDirection layoutDirection = (LayoutDirection) obj4;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    OffsetKt.FlowRow(null, new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), new Arrangement$SpacedAligned(f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), null, 0, 0, Expect_jvmKt.rememberComposableLambda(879927511, new AlbumMenuKt$$ExternalSyntheticLambda11(layoutDirection, composableLambdaImpl, b2), gapComposer), gapComposer, 1572864, 57);
                }
                break;
            case 1:
                PaddingValuesImpl paddingValuesImpl = (PaddingValuesImpl) obj4;
                ComposableLambdaImpl composableLambdaImpl2 = (ComposableLambdaImpl) obj3;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Modifier modifierPadding = OffsetKt.padding(SizeKt.m144defaultMinSizeVpY3zN4$default(Modifier.Companion.$$INSTANCE, CropImageView.DEFAULT_ASPECT_RATIO, f, 1), paddingValuesImpl);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Center, Alignment.Companion.CenterVertically, gapComposer2, 54);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierPadding);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    gapComposer2.startReplaceGroup(1884008924);
                    gapComposer2.end(false);
                    composableLambdaImpl2.invoke((Object) RowScopeInstance.INSTANCE, (Object) gapComposer2, (Object) 6);
                    gapComposer2.end(true);
                }
                break;
            default:
                LensController lensController = (LensController) obj4;
                PointerInputChange pointerInputChange = (PointerInputChange) obj;
                float fFloatValue = ((Float) obj2).floatValue();
                pointerInputChange.getClass();
                pointerInputChange.consume();
                lensController.dragging$delegate.setValue(Boolean.TRUE);
                CoroutineScope coroutineScope = lensController.scope;
                AwaitKt.launch$default(coroutineScope, null, null, new AppNavigationKt.AnonymousClass2(lensController, null, (byte) 3), 3);
                float fFloatValue2 = (fFloatValue / f) + ((Number) lensController.pos.getValue()).floatValue();
                float f2 = lensController.n - 1;
                float fCoerceIn = UuidKt.coerceIn(fFloatValue2, -0.28f, 0.28f + f2);
                ((Ref$FloatRef) obj3).element = fCoerceIn;
                if (fCoerceIn < CropImageView.DEFAULT_ASPECT_RATIO) {
                    fCoerceIn *= 0.45f;
                } else if (fCoerceIn > f2) {
                    fCoerceIn = ((fCoerceIn - f2) * 0.45f) + f2;
                }
                AwaitKt.launch$default(coroutineScope, null, null, new MusicService.AnonymousClass14(lensController, fCoerceIn, null, (byte) 2), 3);
                break;
        }
        return unit;
    }

    public /* synthetic */ AlertDialogKt$$ExternalSyntheticLambda11(float f, LayoutDirection layoutDirection, ComposableLambdaImpl composableLambdaImpl) {
        this.f$1 = f;
        this.f$2 = layoutDirection;
        this.f$3 = composableLambdaImpl;
    }

    public /* synthetic */ AlertDialogKt$$ExternalSyntheticLambda11(LensController lensController, Ref$FloatRef ref$FloatRef, float f) {
        this.f$2 = lensController;
        this.f$3 = ref$FloatRef;
        this.f$1 = f;
    }
}
