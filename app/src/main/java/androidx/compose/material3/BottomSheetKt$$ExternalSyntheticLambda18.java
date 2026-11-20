package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.grid.LazyGridIntervalContent;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.music.constants.DimensionsKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BottomSheetKt$$ExternalSyntheticLambda18 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ float f$0;

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda18(float f, byte b) {
        this.$r8$classId = b;
        this.f$0 = f;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        final float f = this.f$0;
        switch (b) {
            case 0:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                float fCalculateSheetPredictiveBackScaleX = CardKt.calculateSheetPredictiveBackScaleX(reusableGraphicsLayerScope, f);
                float fCalculateSheetPredictiveBackScaleY = CardKt.calculateSheetPredictiveBackScaleY(reusableGraphicsLayerScope, f);
                reusableGraphicsLayerScope.setScaleY(fCalculateSheetPredictiveBackScaleY == CropImageView.DEFAULT_ASPECT_RATIO ? 1.0f : fCalculateSheetPredictiveBackScaleX / fCalculateSheetPredictiveBackScaleY);
                reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(ColorKt.TransformOrigin(0.5f, CropImageView.DEFAULT_ASPECT_RATIO));
                break;
            default:
                LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj;
                lazyGridIntervalContent.getClass();
                LazyGridIntervalContent.items$default(lazyGridIntervalContent, 4, null, new ComposableLambdaImpl(true, 1387264418, new Function4() { // from class: com.metrolist.music.ui.screens.ComposableSingletons$ChartsScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                        ((Integer) obj3).getClass();
                        Composer composer = (Composer) obj4;
                        int iIntValue = ((Integer) obj5).intValue();
                        ((LazyGridItemScopeImpl) obj2).getClass();
                        GapComposer gapComposer = (GapComposer) composer;
                        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 129) != 128)) {
                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                            Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(SizeKt.m155width3ABfNKs(companion, f), 8.0f);
                            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer, 48);
                            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM135padding3ABfNKs);
                            ComposeUiNode.Companion.getClass();
                            gapComposer.startReusableNode();
                            boolean z = gapComposer.inserting;
                            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                            if (z) {
                                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                            } else {
                                gapComposer.useNode();
                            }
                            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                            Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                            Integer numValueOf = Integer.valueOf(iHashCode);
                            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
                            Stack.m389reconcileimpl(gapComposer);
                            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                            SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                            Modifier modifierM = Format$$ExternalSyntheticOutline0.m(18.0f, 8.0f, gapComposer, SizeKt.m151size3ABfNKs(companion, 48.0f));
                            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                            long j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surfaceContainerHigh;
                            RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = ColorKt.RectangleShape;
                            BoxKt.Box(ImageKt.m39backgroundbw27NRU(modifierM, j, rectangleShapeKt$RectangleShape$1), gapComposer, 0);
                            OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, 8.0f));
                            FillElement fillElement = SizeKt.FillWholeMaxHeight;
                            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Center, Alignment.Companion.Start, gapComposer, 6);
                            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, fillElement);
                            gapComposer.startReusableNode();
                            if (gapComposer.inserting) {
                                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                            } else {
                                gapComposer.useNode();
                            }
                            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                            BoxKt.Box(ImageKt.m39backgroundbw27NRU(SizeKt.m155width3ABfNKs(SizeKt.m145height3ABfNKs(companion, 16.0f), 120.0f), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surfaceContainerHigh, rectangleShapeKt$RectangleShape$1), gapComposer, 0);
                            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 8.0f));
                            BoxKt.Box(ImageKt.m39backgroundbw27NRU(SizeKt.m155width3ABfNKs(SizeKt.m145height3ABfNKs(companion, 12.0f), 80.0f), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surfaceContainerHigh, rectangleShapeKt$RectangleShape$1), gapComposer, 0);
                            gapComposer.end(true);
                            gapComposer.end(true);
                        } else {
                            gapComposer.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }), 14);
                break;
        }
        return unit;
    }
}
