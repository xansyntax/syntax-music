package androidx.compose.foundation;

import android.content.res.Configuration;
import android.os.Build;
import android.view.KeyEvent;
import android.widget.EdgeEffect;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.material3.IconKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.RippleNodeFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.ComposedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.utils.io.ByteChannelKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImageKt {
    public static final MarqueeSpacing$Companion$$ExternalSyntheticLambda0 Spacing = new MarqueeSpacing$Companion$$ExternalSyntheticLambda0(0);
    public static final float Velocity = 30.0f;

    /* JADX INFO: renamed from: BorderStroke-cXLIe8U, reason: not valid java name */
    public static final BorderStroke m38BorderStrokecXLIe8U(long j, float f) {
        return new BorderStroke(f, new SolidColor(j));
    }

    public static final void Canvas(int i, Composer composer, Modifier modifier, Function1 function1) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-932836462);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function1) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            OffsetKt.Spacer(gapComposer, ClipKt.drawBehind(modifier, function1));
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CanvasKt$$ExternalSyntheticLambda0(modifier, function1, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:37:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:44:0x0088  */
    /* JADX WARN: Code duplicated, block: B:45:0x008a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0093  */
    /* JADX WARN: Code duplicated, block: B:50:0x0097  */
    /* JADX WARN: Code duplicated, block: B:53:0x009c  */
    /* JADX WARN: Code duplicated, block: B:54:0x009f  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:72:0x010e  */
    /* JADX WARN: Code duplicated, block: B:73:0x0114  */
    /* JADX WARN: Code duplicated, block: B:75:0x013a  */
    /* JADX WARN: Code duplicated, block: B:78:0x014a  */
    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    public static final void Image(final Painter painter, final String str, final Modifier modifier, Alignment alignment, ContentScale contentScale, float f, BlendModeColorFilter blendModeColorFilter, Composer composer, final int i, final int i2) {
        ContentScale contentScale2;
        int i3;
        int i4;
        int i5;
        int i6;
        byte b;
        boolean z;
        final Alignment alignment2;
        final float f2;
        final BlendModeColorFilter blendModeColorFilter2;
        final ContentScale contentScale3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        BlendModeColorFilter blendModeColorFilter3;
        Modifier modifierSemantics;
        NeverEqualPolicy neverEqualPolicy;
        Object objRememberedValue;
        boolean z2;
        Object objRememberedValue2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1142754848);
        int i7 = ((i & 8) == 0 ? gapComposer.changed(painter) : gapComposer.changedInstance(painter) ? 4 : 2) | i;
        if ((i & 48) == 0) {
            i7 |= gapComposer.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i7 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        int i8 = i7 | 3072;
        int i9 = i2 & 16;
        if (i9 == 0) {
            if ((i & 24576) == 0) {
                contentScale2 = contentScale;
                i8 |= gapComposer.changed(contentScale2) ? 16384 : 8192;
            }
            i3 = 196608 | i8;
            i4 = i2 & 64;
            if (i4 != 0) {
                i6 = i8 | 1769472;
            } else {
                if (gapComposer.changed(blendModeColorFilter)) {
                    i5 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i5 = 524288;
                }
                i6 = i3 | i5;
            }
            b = 1;
            if ((599187 & i6) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i6 & 1, z)) {
                BiasAlignment biasAlignment = Alignment.Companion.Center;
                if (i9 != 0) {
                    contentScale2 = ContentScale.Companion.Fit;
                }
                ContentScale contentScale4 = contentScale2;
                if (i4 != 0) {
                    blendModeColorFilter3 = null;
                } else {
                    blendModeColorFilter3 = blendModeColorFilter;
                }
                modifierSemantics = Modifier.Companion.$$INSTANCE;
                neverEqualPolicy = Composer.Companion.Empty;
                if (str != null) {
                    gapComposer.startReplaceGroup(1899222916);
                    if ((i6 & 112) == 32) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (z2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new IconKt$$ExternalSyntheticLambda1(str, b);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    modifierSemantics = SemanticsModifierKt.semantics(modifierSemantics, false, (Function1) objRememberedValue2);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(1899381698);
                    gapComposer.end(false);
                }
                Modifier modifierPaint$default = ClipKt.paint$default(ClipKt.clipToBounds(modifier.then(modifierSemantics)), painter, contentScale4, 1.0f, blendModeColorFilter3, 2);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = ImageKt$Image$1$1.INSTANCE;
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
                int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierPaint$default);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                ComposeUiNode.Companion.getClass();
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(LayoutNode.Constructor);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m389reconcileimpl(gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                gapComposer.end(true);
                contentScale3 = contentScale4;
                f2 = 1.0f;
                blendModeColorFilter2 = blendModeColorFilter3;
                alignment2 = biasAlignment;
            } else {
                gapComposer.skipToGroupEnd();
                alignment2 = alignment;
                f2 = f;
                blendModeColorFilter2 = blendModeColorFilter;
                contentScale3 = contentScale2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        ImageKt.Image(painter, str, modifier, alignment2, contentScale3, f2, blendModeColorFilter2, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i8 = i7 | 27648;
        contentScale2 = contentScale;
        i3 = 196608 | i8;
        i4 = i2 & 64;
        if (i4 != 0) {
            i6 = i8 | 1769472;
        } else {
            if (gapComposer.changed(blendModeColorFilter)) {
                i5 = ByteChannelKt.CHANNEL_MAX_SIZE;
            } else {
                i5 = 524288;
            }
            i6 = i3 | i5;
        }
        b = 1;
        if ((599187 & i6) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i6 & 1, z)) {
            BiasAlignment biasAlignment2 = Alignment.Companion.Center;
            if (i9 != 0) {
                contentScale2 = ContentScale.Companion.Fit;
            }
            ContentScale contentScale5 = contentScale2;
            if (i4 != 0) {
                blendModeColorFilter3 = null;
            } else {
                blendModeColorFilter3 = blendModeColorFilter;
            }
            modifierSemantics = Modifier.Companion.$$INSTANCE;
            neverEqualPolicy = Composer.Companion.Empty;
            if (str != null) {
                gapComposer.startReplaceGroup(1899222916);
                if ((i6 & 112) == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = gapComposer.rememberedValue();
                if (z2) {
                    objRememberedValue2 = new IconKt$$ExternalSyntheticLambda1(str, b);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new IconKt$$ExternalSyntheticLambda1(str, b);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                modifierSemantics = SemanticsModifierKt.semantics(modifierSemantics, false, (Function1) objRememberedValue2);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1899381698);
                gapComposer.end(false);
            }
            Modifier modifierPaint$default2 = ClipKt.paint$default(ClipKt.clipToBounds(modifier.then(modifierSemantics)), painter, contentScale5, 1.0f, blendModeColorFilter3, 2);
            objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = ImageKt$Image$1$1.INSTANCE;
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy2 = (MeasurePolicy) objRememberedValue;
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierPaint$default2);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
            gapComposer.end(true);
            contentScale3 = contentScale5;
            f2 = 1.0f;
            blendModeColorFilter2 = blendModeColorFilter3;
            alignment2 = biasAlignment2;
        } else {
            gapComposer.skipToGroupEnd();
            alignment2 = alignment;
            f2 = f;
            blendModeColorFilter2 = blendModeColorFilter;
            contentScale3 = contentScale2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    ImageKt.Image(painter, str, modifier, alignment2, contentScale3, f2, blendModeColorFilter2, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static float absorbToRelaxIfNeeded(EdgeEffect edgeEffect, float f, float f2, Density density) {
        float f3 = EdgeEffectCompat_androidKt.PlatformFlingScrollFriction;
        double density2 = density.getDensity() * 386.0878f * 160.0f * 0.84f;
        double dAbs = Math.abs(f) * 0.35f;
        double d = ((double) EdgeEffectCompat_androidKt.PlatformFlingScrollFriction) * density2;
        float fExp = (float) (Math.exp((EdgeEffectCompat_androidKt.DecelerationRate / EdgeEffectCompat_androidKt.DecelMinusOne) * Math.log(dAbs / d)) * d);
        int i = Build.VERSION.SDK_INT;
        if (fExp > (i >= 31 ? Api31Impl.getDistance(edgeEffect) : 0.0f) * f2) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        int iRoundToInt = MathKt.roundToInt(f);
        if (i >= 31) {
            edgeEffect.onAbsorb(iRoundToInt);
            return f;
        }
        if (edgeEffect.isFinished()) {
            edgeEffect.onAbsorb(iRoundToInt);
        }
        return f;
    }

    /* JADX INFO: renamed from: background-bw27NRU, reason: not valid java name */
    public static final Modifier m39backgroundbw27NRU(Modifier modifier, long j, Shape shape) {
        return modifier.then(new BackgroundElement(j, null, shape, 2));
    }

    /* JADX INFO: renamed from: basicMarquee-1Mj1MLw$default, reason: not valid java name */
    public static Modifier m41basicMarquee1Mj1MLw$default(Modifier modifier, int i) {
        int i2 = (i & 1) != 0 ? 3 : 1;
        int i3 = (i & 8) != 0 ? 1200 : 3000;
        int i4 = i & 32;
        return modifier.then(new MarqueeModifierElement(i2, i3, Spacing, 30.0f));
    }

    /* JADX INFO: renamed from: border-xT4_qwU, reason: not valid java name */
    public static final Modifier m42borderxT4_qwU(Modifier modifier, float f, long j, Shape shape) {
        return m43borderziNgDLE(modifier, f, new SolidColor(j), shape);
    }

    /* JADX INFO: renamed from: border-ziNgDLE, reason: not valid java name */
    public static final Modifier m43borderziNgDLE(Modifier modifier, float f, Brush brush, Shape shape) {
        return modifier.then(new BorderModifierNodeElement(f, brush, shape));
    }

    /* JADX INFO: renamed from: checkScrollableContainerConstraints-K40F9xA, reason: not valid java name */
    public static final void m44checkScrollableContainerConstraintsK40F9xA(long j, Orientation orientation) {
        if (orientation == Orientation.Vertical) {
            if (Constraints.m783getMaxHeightimpl(j) != Integer.MAX_VALUE) {
                return;
            }
            InlineClassHelperKt.throwIllegalStateException("Vertically scrollable component was measured with an infinity maximum height constraints, which is disallowed. One of the common reasons is nesting layouts like LazyColumn and Column(Modifier.verticalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyColumn scope. There could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.");
        } else {
            if (Constraints.m784getMaxWidthimpl(j) != Integer.MAX_VALUE) {
                return;
            }
            InlineClassHelperKt.throwIllegalStateException("Horizontally scrollable component was measured with an infinity maximum width constraints, which is disallowed. One of the common reasons is nesting layouts like LazyRow and Row(Modifier.horizontalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyRow scope. There could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.");
        }
    }

    /* JADX INFO: renamed from: clickable-O2vRcR0$default, reason: not valid java name */
    public static Modifier m45clickableO2vRcR0$default(Modifier modifier, MutableInteractionSourceImpl mutableInteractionSourceImpl, final IndicationNodeFactory indicationNodeFactory, boolean z, Role role, final Function0 function0, int i) {
        Modifier modifierThen;
        if ((i & 4) != 0) {
            z = true;
        }
        final boolean z2 = z;
        if ((i & 16) != 0) {
            role = null;
        }
        final Role role2 = role;
        if (indicationNodeFactory != null) {
            modifierThen = new ClickableElement(mutableInteractionSourceImpl, indicationNodeFactory, false, z2, null, role2, function0);
        } else if (indicationNodeFactory == null) {
            modifierThen = new ClickableElement(mutableInteractionSourceImpl, null, false, z2, null, role2, function0);
        } else {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            modifierThen = mutableInteractionSourceImpl != null ? IndicationKt.indication(companion, mutableInteractionSourceImpl, indicationNodeFactory).then(new ClickableElement(mutableInteractionSourceImpl, null, false, z2, null, role2, function0)) : companion.then(new ComposedModifier(new Function3() { // from class: androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    ((Number) obj3).intValue();
                    GapComposer gapComposer = (GapComposer) ((Composer) obj2);
                    gapComposer.startReplaceGroup(-1525724089);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    MutableInteractionSourceImpl mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    Modifier modifierThen2 = IndicationKt.indication(Modifier.Companion.$$INSTANCE, mutableInteractionSourceImpl2, indicationNodeFactory).then(new ClickableElement(mutableInteractionSourceImpl2, null, false, z2, null, role2, function0));
                    gapComposer.end(false);
                    return modifierThen2;
                }
            }));
        }
        return modifier.then(modifierThen);
    }

    /* JADX INFO: renamed from: clickable-oSLSa3U$default, reason: not valid java name */
    public static Modifier m46clickableoSLSa3U$default(Modifier modifier, boolean z, String str, Function0 function0, int i) {
        if ((i & 1) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 2) != 0) {
            str = null;
        }
        return modifier.then(new ClickableElement(null, null, true, z2, str, null, function0));
    }

    /* JADX INFO: renamed from: combinedClickable-auXiCPI$default, reason: not valid java name */
    public static Modifier m47combinedClickableauXiCPI$default(Modifier modifier, MutableInteractionSourceImpl mutableInteractionSourceImpl, final RippleNodeFactory rippleNodeFactory, boolean z, Role role, Function0 function0, final Function0 function1, int i) {
        Modifier modifierThen;
        if ((i & 4) != 0) {
            z = true;
        }
        final boolean z2 = z;
        final Role role2 = (i & 16) != 0 ? null : role;
        final Function0 function2 = (i & 64) != 0 ? null : function0;
        final String str = null;
        if (rippleNodeFactory != null) {
            modifierThen = new CombinedClickableElement(rippleNodeFactory, mutableInteractionSourceImpl, role2, null, function1, function2, false, z2);
        } else if (rippleNodeFactory == null) {
            modifierThen = new CombinedClickableElement(null, mutableInteractionSourceImpl, role2, null, function1, function2, false, z2);
        } else {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            modifierThen = mutableInteractionSourceImpl != null ? IndicationKt.indication(companion, mutableInteractionSourceImpl, rippleNodeFactory).then(new CombinedClickableElement(null, mutableInteractionSourceImpl, role2, null, function1, function2, false, z2)) : companion.then(new ComposedModifier(new Function3() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-auXiCPI$$inlined$clickableWithIndicationIfNeeded$1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    ((Number) obj3).intValue();
                    GapComposer gapComposer = (GapComposer) ((Composer) obj2);
                    gapComposer.startReplaceGroup(-1525724089);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    MutableInteractionSourceImpl mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    Modifier modifierThen2 = IndicationKt.indication(Modifier.Companion.$$INSTANCE, mutableInteractionSourceImpl2, rippleNodeFactory).then(new CombinedClickableElement(null, mutableInteractionSourceImpl2, role2, str, function1, function2, false, z2));
                    gapComposer.end(false);
                    return modifierThen2;
                }
            }));
        }
        return modifier.then(modifierThen);
    }

    /* JADX INFO: renamed from: combinedClickable-hoGz1lA$default, reason: not valid java name */
    public static Modifier m48combinedClickablehoGz1lA$default(Modifier modifier, boolean z, Function0 function0, Function0 function1, int i) {
        if ((i & 1) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            function0 = null;
        }
        return modifier.then(new CombinedClickableElement(null, null, null, null, function1, function0, true, z2));
    }

    public static final Modifier focusGroup(Modifier modifier) {
        return modifier.then(FocusGroupElement.INSTANCE);
    }

    public static final Modifier focusable(Modifier modifier, boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl) {
        return modifier.then(z ? new FocusableElement(mutableInteractionSourceImpl) : Modifier.Companion.$$INSTANCE);
    }

    /* JADX INFO: renamed from: isEnter-ZmokQxo, reason: not valid java name */
    public static final boolean m49isEnterZmokQxo(KeyEvent keyEvent) {
        long jM580getKeyZmokQxo = Key.m580getKeyZmokQxo(keyEvent);
        return Key.m579equalsimpl0(jM580getKeyZmokQxo, 98784247808L) || Key.m579equalsimpl0(jM580getKeyZmokQxo, 283467841536L) || Key.m579equalsimpl0(jM580getKeyZmokQxo, 687194767360L) || Key.m579equalsimpl0(jM580getKeyZmokQxo, 266287972352L);
    }

    public static final boolean isSystemInDarkTheme(Composer composer) {
        return (((Configuration) ((GapComposer) composer).consume(AndroidCompositionLocals_androidKt.LocalConfiguration)).uiMode & 48) == 32;
    }

    public static final ScrollState rememberScrollState(Composer composer) {
        byte b = 0;
        Object[] objArr = new Object[0];
        boolean zChanged = ((GapComposer) composer).changed(0);
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new ScrollKt$$ExternalSyntheticLambda0(b);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (ScrollState) SaverKt.m393rememberSaveable(objArr, (Saver) ScrollState.Saver, (Function0) objRememberedValue, (Composer) gapComposer, 0);
    }

    public static Modifier scroll$default(Modifier modifier, ScrollState scrollState, boolean z) {
        Orientation orientation = Orientation.Vertical;
        Orientation orientation2 = z ? orientation : Orientation.Horizontal;
        MutableInteractionSourceImpl mutableInteractionSourceImpl = scrollState.internalInteractionSource;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        return modifier.then(orientation2 == orientation ? ClipKt.clip(companion, VerticalScrollableClipShape.INSTANCE) : ClipKt.clip(companion, VerticalScrollableClipShape.INSTANCE$1)).then(new ScrollableAreaElement(null, null, null, orientation2, scrollState, mutableInteractionSourceImpl, true, true)).then(new ScrollingLayoutElement(scrollState, z));
    }

    public static final Modifier scrollableArea(Modifier modifier, ScrollableState scrollableState, Orientation orientation, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, boolean z, FlingBehavior flingBehavior, MutableInteractionSourceImpl mutableInteractionSourceImpl, BringIntoViewSpec bringIntoViewSpec) {
        Orientation orientation2 = Orientation.Vertical;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        return modifier.then(orientation == orientation2 ? ClipKt.clip(companion, VerticalScrollableClipShape.INSTANCE) : ClipKt.clip(companion, VerticalScrollableClipShape.INSTANCE$1)).then(new ScrollableAreaElement(androidEdgeEffectOverscrollEffect, bringIntoViewSpec, flingBehavior, orientation, scrollableState, mutableInteractionSourceImpl, z, false));
    }

    /* JADX INFO: renamed from: shrink-Kibmq7A, reason: not valid java name */
    public static final long m50shrinkKibmq7A(long j, float f) {
        float fMax = Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Float.intBitsToFloat((int) (j >> 32)) - f);
        float fMax2 = Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Float.intBitsToFloat((int) (j & 4294967295L)) - f);
        return (((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax2)) & 4294967295L);
    }
}
