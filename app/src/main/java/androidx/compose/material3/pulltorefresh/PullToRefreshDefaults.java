package androidx.compose.material3.pulltorefresh;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda50;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PullToRefreshDefaults {
    public static final PullToRefreshDefaults INSTANCE = new PullToRefreshDefaults();
    public static final RoundedCornerShape indicatorShape = RoundedCornerShapeKt.CircleShape;
    public static final float PositionalThreshold = 80.0f;
    public static final float IndicatorMaxDistance = 80.0f;
    public static final float Elevation = 3.0f;

    /* JADX INFO: renamed from: Indicator-2poqoh4, reason: not valid java name */
    public final void m378Indicator2poqoh4(final PullToRefreshStateImpl pullToRefreshStateImpl, final boolean z, final Modifier modifier, long j, long j2, float f, Composer composer, final int i) {
        final long j3;
        final long j4;
        final float f2;
        int i2;
        float f3;
        long j5;
        long j6;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1076870256);
        int i3 = i | (gapComposer.changed(pullToRefreshStateImpl) ? 4 : 2) | (gapComposer.changed(z) ? 32 : 16) | (gapComposer.changed(modifier) ? 256 : 128) | 74752;
        if (gapComposer.shouldExecute(i3 & 1, (599187 & i3) != 599186)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                long j7 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.surfaceContainerHigh;
                long j8 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant;
                i2 = i3 & (-523265);
                f3 = IndicatorMaxDistance;
                j5 = j8;
                j6 = j7;
            } else {
                gapComposer.skipToGroupEnd();
                i2 = i3 & (-523265);
                j6 = j;
                j5 = j2;
                f3 = f;
            }
            gapComposer.endDefaults();
            m379IndicatorBox1CPYgEU(pullToRefreshStateImpl, z, modifier, f3, null, j6, CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(298232649, new PlayerKt$$ExternalSyntheticLambda50(z, j5, pullToRefreshStateImpl), gapComposer), gapComposer, (i2 & 896) | (i2 & 14) | 12582912 | (i2 & 112) | 100663296);
            f2 = f3;
            j3 = j6;
            j4 = j5;
        } else {
            gapComposer.skipToGroupEnd();
            j3 = j;
            j4 = j2;
            f2 = f;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(pullToRefreshStateImpl, z, modifier, j3, j4, f2, i) { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda1
                public final /* synthetic */ PullToRefreshStateImpl f$1;
                public final /* synthetic */ boolean f$2;
                public final /* synthetic */ Modifier f$3;
                public final /* synthetic */ long f$4;
                public final /* synthetic */ long f$5;
                public final /* synthetic */ float f$6;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1572865);
                    this.f$0.m378Indicator2poqoh4(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: IndicatorBox-1CPYgEU, reason: not valid java name */
    public final void m379IndicatorBox1CPYgEU(final PullToRefreshStateImpl pullToRefreshStateImpl, final boolean z, final Modifier modifier, final float f, Shape shape, final long j, float f2, final ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i) {
        final PullToRefreshStateImpl pullToRefreshStateImpl2;
        int i2;
        PullToRefreshDefaults pullToRefreshDefaults;
        final Shape shape2;
        final float f3;
        int i3;
        Shape shape3;
        final Shape shape4;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1341144489);
        if ((i & 6) == 0) {
            pullToRefreshStateImpl2 = pullToRefreshStateImpl;
            i2 = (gapComposer.changed(pullToRefreshStateImpl2) ? 4 : 2) | i;
        } else {
            pullToRefreshStateImpl2 = pullToRefreshStateImpl;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(f) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changed(j) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            pullToRefreshDefaults = this;
            i2 |= gapComposer.changed(pullToRefreshDefaults) ? 67108864 : 33554432;
        } else {
            pullToRefreshDefaults = this;
        }
        if (gapComposer.shouldExecute(i2 & 1, (38347923 & i2) != 38347922)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                i3 = i2 & (-3727361);
                shape3 = indicatorShape;
                f3 = Elevation;
            } else {
                gapComposer.skipToGroupEnd();
                i3 = i2 & (-3727361);
                shape3 = shape;
                f3 = f2;
            }
            int i4 = i3;
            gapComposer.endDefaults();
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(modifier, 40.0f);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 24);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierDrawWithContent = ClipKt.drawWithContent(modifierM151size3ABfNKs, (Function1) objRememberedValue);
            boolean zChanged = ((i4 & 112) == 32) | ((i4 & 14) == 4) | ((((i4 & 7168) ^ 3072) > 2048 && gapComposer.changed(f)) || (i4 & 3072) == 2048) | gapComposer.changed(f3) | gapComposer.changed(shape3);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                shape4 = shape3;
                Function3 function3 = new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        final Placeable placeableMo598measureBRTryo0 = ((Measurable) obj2).mo598measureBRTryo0(((Constraints) obj3).value);
                        int i5 = placeableMo598measureBRTryo0.width;
                        int i6 = placeableMo598measureBRTryo0.height;
                        final PullToRefreshStateImpl pullToRefreshStateImpl3 = pullToRefreshStateImpl2;
                        final boolean z2 = z;
                        final float f4 = f;
                        final float f5 = f3;
                        final Shape shape5 = shape4;
                        return ((MeasureScope) obj).layout(i5, i6, EmptyMap.INSTANCE, new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj4) {
                                final PullToRefreshStateImpl pullToRefreshStateImpl4 = pullToRefreshStateImpl3;
                                final boolean z3 = z2;
                                final float f6 = f4;
                                final float f7 = f5;
                                final Shape shape6 = shape5;
                                Placeable.PlacementScope.placeWithLayer$default((Placeable.PlacementScope) obj4, placeableMo598measureBRTryo0, 0, 0, new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj5) {
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj5;
                                        PullToRefreshStateImpl pullToRefreshStateImpl5 = pullToRefreshStateImpl4;
                                        float fFloatValue = ((Number) pullToRefreshStateImpl5.anim.getValue()).floatValue();
                                        float density = CropImageView.DEFAULT_ASPECT_RATIO;
                                        boolean z4 = fFloatValue > CropImageView.DEFAULT_ASPECT_RATIO || z3;
                                        reusableGraphicsLayerScope.setTranslationY((((Number) pullToRefreshStateImpl5.anim.getValue()).floatValue() * reusableGraphicsLayerScope.mo75roundToPx0680j_4(f6)) - Float.intBitsToFloat((int) (reusableGraphicsLayerScope.size & 4294967295L)));
                                        if (z4) {
                                            density = reusableGraphicsLayerScope.graphicsDensity.getDensity() * f7;
                                        }
                                        reusableGraphicsLayerScope.setShadowElevation(density);
                                        reusableGraphicsLayerScope.setShape(shape6);
                                        reusableGraphicsLayerScope.setClip(true);
                                        return Unit.INSTANCE;
                                    }
                                }, 4);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                };
                gapComposer.updateRememberedValue(function3);
                objRememberedValue2 = function3;
            } else {
                shape4 = shape3;
            }
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(RulerKt.layout(modifierDrawWithContent, (Function3) objRememberedValue2), j, shape4);
            int i5 = ((i4 >> 12) & 7168) | 48;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM39backgroundbw27NRU);
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
            composableLambdaImpl.invoke(BoxScopeInstance.INSTANCE, gapComposer, Integer.valueOf(((i5 >> 6) & 112) | 6));
            gapComposer.end(true);
            shape2 = shape4;
        } else {
            gapComposer.skipToGroupEnd();
            shape2 = shape;
            f3 = f2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final PullToRefreshDefaults pullToRefreshDefaults2 = pullToRefreshDefaults;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    this.f$0.m379IndicatorBox1CPYgEU(pullToRefreshStateImpl, z, modifier, f, shape2, j, f3, composableLambdaImpl, (Composer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
