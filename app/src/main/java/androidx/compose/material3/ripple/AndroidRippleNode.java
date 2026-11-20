package androidx.compose.material3.ripple;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableObjectList;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.material3.DelegatingThemeAwareRippleNode$$ExternalSyntheticLambda0;
import androidx.compose.material3.SliderState;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.core.provider.CallbackWrapper;
import androidx.emoji2.text.EmojiProcessor;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import coil3.size.SizeKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlinx.coroutines.AwaitKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidRippleNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, ObserverModifierNode, DrawModifierNode, LayoutAwareModifierNode {
    public RippleNodeConfiguration _rippleNodeConfiguration;
    public RippleNode$BorderLogicLayerDelegate focusedBorderLogic;
    public boolean hasValidSize;
    public final InteractionSource interactionSource;
    public RippleContainer rippleContainer;
    public RippleHostView rippleHostView;
    public final Function0 rippleNodeConfiguration;
    public float targetRadius;
    public long rippleSize = 0;
    public final MutableObjectList pendingInteractions = new MutableObjectList();
    public final Animatable animatedAlpha = ArcSplineKt.Animatable$default(CropImageView.DEFAULT_ASPECT_RATIO);
    public final Animatable animatedFocusRingInterpolation = ArcSplineKt.Animatable$default(CropImageView.DEFAULT_ASPECT_RATIO);

    public AndroidRippleNode(InteractionSource interactionSource, DelegatingThemeAwareRippleNode$$ExternalSyntheticLambda0 delegatingThemeAwareRippleNode$$ExternalSyntheticLambda0) {
        this.interactionSource = interactionSource;
        this.rippleNodeConfiguration = delegatingThemeAwareRippleNode$$ExternalSyntheticLambda0;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) throws Throwable {
        long j;
        layoutNodeDrawScope.drawContent();
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        Canvas canvas = canvasDrawScope.drawContext.getCanvas();
        RippleHostView rippleHostView = this.rippleHostView;
        if (rippleHostView != null) {
            RippleNodeConfiguration rippleNodeConfiguration = getRippleNodeConfiguration(false);
            rippleHostView.m382setRipplePropertiesbiQXAtU(this.rippleSize, MathKt.roundToInt(this.targetRadius), rippleNodeConfiguration.color.mo314invoke0d7_KjU(), rippleNodeConfiguration.pressConfiguration instanceof RippleNodeConfiguration.PressConfiguration.Opacity ? 0.1f : 0.0f);
            rippleHostView.draw(AndroidCanvas_androidKt.getNativeCanvas(canvas));
        }
        float fFloatValue = ((Number) this.animatedAlpha.getValue()).floatValue();
        if (fFloatValue > CropImageView.DEFAULT_ASPECT_RATIO) {
            RippleNodeConfiguration rippleNodeConfiguration2 = getRippleNodeConfiguration(false);
            long jMo314invoke0d7_KjU = rippleNodeConfiguration2.color.mo314invoke0d7_KjU();
            long jColor = ColorKt.Color(Color.m485getRedimpl(jMo314invoke0d7_KjU), Color.m484getGreenimpl(jMo314invoke0d7_KjU), Color.m482getBlueimpl(jMo314invoke0d7_KjU), fFloatValue, Color.m483getColorSpaceimpl(jMo314invoke0d7_KjU));
            if (rippleNodeConfiguration2.isBounded) {
                float fIntBitsToFloat = Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() >> 32));
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L));
                EmojiProcessor emojiProcessor = canvasDrawScope.drawContext;
                long jM831getSizeNHjbRc = emojiProcessor.m831getSizeNHjbRc();
                emojiProcessor.getCanvas().save();
                try {
                    ((DrawResult) emojiProcessor.mSpanFactory).m401clipRectN_I0leg(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, fIntBitsToFloat, fIntBitsToFloat2, 1);
                    j = jM831getSizeNHjbRc;
                    try {
                        DrawScope.m543drawCircleVaOC9Bg$default(layoutNodeDrawScope, jColor, this.targetRadius, 0L, null, 0, 124);
                        IntIntPair$$ExternalSyntheticOutline0.m(emojiProcessor, j);
                    } catch (Throwable th) {
                        th = th;
                        IntIntPair$$ExternalSyntheticOutline0.m(emojiProcessor, j);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    j = jM831getSizeNHjbRc;
                }
            } else {
                DrawScope.m543drawCircleVaOC9Bg$default(layoutNodeDrawScope, jColor, this.targetRadius, 0L, null, 0, 124);
            }
        }
        if (((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() > CropImageView.DEFAULT_ASPECT_RATIO) {
            RippleNode$BorderLogicLayerDelegate rippleNode$BorderLogicLayerDelegate = this.focusedBorderLogic;
            if (rippleNode$BorderLogicLayerDelegate == null) {
                rippleNode$BorderLogicLayerDelegate = new RippleNode$BorderLogicLayerDelegate();
            }
            this.focusedBorderLogic = rippleNode$BorderLogicLayerDelegate;
            getRippleNodeConfiguration(false);
        }
    }

    public final RippleNodeConfiguration getRippleNodeConfiguration(boolean z) {
        boolean z2;
        RippleNodeConfiguration rippleNodeConfiguration = this._rippleNodeConfiguration;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (z || rippleNodeConfiguration == null) {
            HitTestResultKt.observeReads(this, new Recomposer$$ExternalSyntheticLambda6(ref$ObjectRef, this, (byte) 22));
            Object obj = ref$ObjectRef.element;
            if (obj == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resolvedConfiguration");
                throw null;
            }
            z2 = !((RippleNodeConfiguration) obj).equals(rippleNodeConfiguration);
        } else {
            ref$ObjectRef.element = rippleNodeConfiguration;
            z2 = false;
        }
        Object obj2 = ref$ObjectRef.element;
        if (obj2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resolvedConfiguration");
            throw null;
        }
        RippleNodeConfiguration rippleNodeConfiguration2 = (RippleNodeConfiguration) obj2;
        this._rippleNodeConfiguration = rippleNodeConfiguration2;
        if (z2) {
            updateTargetRadius(rippleNodeConfiguration2);
            HitTestResultKt.invalidateDraw(this);
        }
        Object obj3 = ref$ObjectRef.element;
        if (obj3 != null) {
            return (RippleNodeConfiguration) obj3;
        }
        Intrinsics.throwUninitializedPropertyAccessException("resolvedConfiguration");
        throw null;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    public final void handlePressInteraction(PressInteraction pressInteraction) {
        RippleHostView rippleHostView;
        if (!(pressInteraction instanceof PressInteraction.Press)) {
            if (pressInteraction instanceof PressInteraction.Release) {
                RippleHostView rippleHostView2 = this.rippleHostView;
                if (rippleHostView2 != null) {
                    rippleHostView2.removeRipple();
                    return;
                }
                return;
            }
            if (!(pressInteraction instanceof PressInteraction.Cancel) || (rippleHostView = this.rippleHostView) == null) {
                return;
            }
            rippleHostView.removeRipple();
            return;
        }
        PressInteraction.Press press = (PressInteraction.Press) pressInteraction;
        long j = this.rippleSize;
        float f = this.targetRadius;
        RippleContainer rippleContainer = this.rippleContainer;
        if (rippleContainer == null) {
            Object obj = (View) HitTestResultKt.currentValueOf(this, AndroidCompositionLocals_androidKt.LocalView);
            while (!(obj instanceof ViewGroup)) {
                ViewParent parent = ((View) obj).getParent();
                if (!(parent instanceof View)) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m("Couldn't find a valid parent for ", obj, ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?");
                    return;
                }
                obj = parent;
            }
            ViewGroup viewGroup = (ViewGroup) obj;
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    RippleContainer rippleContainer2 = new RippleContainer(viewGroup.getContext());
                    viewGroup.addView(rippleContainer2);
                    rippleContainer = rippleContainer2;
                    break;
                } else {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt instanceof RippleContainer) {
                        rippleContainer = (RippleContainer) childAt;
                        break;
                    }
                    i++;
                }
            }
            this.rippleContainer = rippleContainer;
        }
        ArrayList arrayList = rippleContainer.rippleHosts;
        CallbackWrapper callbackWrapper = rippleContainer.rippleHostMap;
        LinkedHashMap linkedHashMap = (LinkedHashMap) callbackWrapper.mCallback;
        LinkedHashMap linkedHashMap2 = (LinkedHashMap) callbackWrapper.mCallback;
        LinkedHashMap linkedHashMap3 = (LinkedHashMap) callbackWrapper.mExecutor;
        RippleHostView rippleHostView3 = (RippleHostView) linkedHashMap.get(this);
        if (rippleHostView3 == null) {
            ArrayList arrayList2 = rippleContainer.unusedRippleHosts;
            arrayList2.getClass();
            rippleHostView3 = (RippleHostView) (arrayList2.isEmpty() ? null : arrayList2.remove(0));
            if (rippleHostView3 == null) {
                if (rippleContainer.nextHostIndex > CollectionsKt__IterablesKt.getLastIndex(arrayList)) {
                    rippleHostView3 = new RippleHostView(rippleContainer.getContext());
                    rippleContainer.addView(rippleHostView3);
                    arrayList.add(rippleHostView3);
                } else {
                    rippleHostView3 = (RippleHostView) arrayList.get(rippleContainer.nextHostIndex);
                    AndroidRippleNode androidRippleNode = (AndroidRippleNode) linkedHashMap3.get(rippleHostView3);
                    if (androidRippleNode != null) {
                        androidRippleNode.rippleHostView = null;
                        HitTestResultKt.invalidateDraw(androidRippleNode);
                        RippleHostView rippleHostView4 = (RippleHostView) linkedHashMap2.get(androidRippleNode);
                        if (rippleHostView4 != null) {
                        }
                        linkedHashMap2.remove(androidRippleNode);
                        rippleHostView3.disposeRipple();
                    }
                }
                int i2 = rippleContainer.nextHostIndex;
                if (i2 < rippleContainer.MaxRippleHosts - 1) {
                    rippleContainer.nextHostIndex = i2 + 1;
                } else {
                    rippleContainer.nextHostIndex = 0;
                }
            }
            linkedHashMap2.put(this, rippleHostView3);
            linkedHashMap3.put(rippleHostView3, this);
        }
        RippleNodeConfiguration rippleNodeConfiguration = getRippleNodeConfiguration(false);
        RippleHostView rippleHostView5 = rippleHostView3;
        rippleHostView5.m381addRippleKOepWvA(press, rippleNodeConfiguration.isBounded, j, MathKt.roundToInt(f), rippleNodeConfiguration.color.mo314invoke0d7_KjU(), rippleNodeConfiguration.pressConfiguration instanceof RippleNodeConfiguration.PressConfiguration.Opacity ? 0.1f : CropImageView.DEFAULT_ASPECT_RATIO, new RoomDatabase$$ExternalSyntheticLambda0((byte) 2, this));
        this.rippleHostView = rippleHostView5;
        HitTestResultKt.invalidateDraw(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        getRippleNodeConfiguration(false);
        AwaitKt.launch$default(getCoroutineScope(), null, null, new SliderState.AnonymousClass2(this, null, (byte) 23), 3);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        RippleContainer rippleContainer = this.rippleContainer;
        if (rippleContainer != null) {
            this.rippleHostView = null;
            HitTestResultKt.invalidateDraw(this);
            CallbackWrapper callbackWrapper = rippleContainer.rippleHostMap;
            RippleHostView rippleHostView = (RippleHostView) ((LinkedHashMap) callbackWrapper.mCallback).get(this);
            if (rippleHostView != null) {
                rippleHostView.disposeRipple();
                LinkedHashMap linkedHashMap = (LinkedHashMap) callbackWrapper.mCallback;
                RippleHostView rippleHostView2 = (RippleHostView) linkedHashMap.get(this);
                if (rippleHostView2 != null) {
                }
                linkedHashMap.remove(this);
                rippleContainer.unusedRippleHosts.add(rippleHostView);
            }
        }
        this.focusedBorderLogic = null;
        this._rippleNodeConfiguration = null;
        this.hasValidSize = false;
        this.rippleSize = 0L;
        this.targetRadius = CropImageView.DEFAULT_ASPECT_RATIO;
        this.pendingInteractions.clear();
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        getRippleNodeConfiguration(true);
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode, androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public final void mo61onRemeasuredozmzZPI(long j) {
        this.hasValidSize = true;
        this.rippleSize = SizeKt.m876toSizeozmzZPI(j);
        if (updateTargetRadius(getRippleNodeConfiguration(false))) {
            HitTestResultKt.invalidateDraw(this);
        }
        MutableObjectList mutableObjectList = this.pendingInteractions;
        Object[] objArr = mutableObjectList.content;
        int i = mutableObjectList._size;
        for (int i2 = 0; i2 < i; i2++) {
            handlePressInteraction((PressInteraction) objArr[i2]);
        }
        mutableObjectList.clear();
    }

    public final boolean updateTargetRadius(RippleNodeConfiguration rippleNodeConfiguration) {
        float fMo81toPx0680j_4;
        if (!this.hasValidSize) {
            return false;
        }
        Density density = HitTestResultKt.requireLayoutNode(this).density;
        if (Float.isNaN(rippleNodeConfiguration.radius)) {
            boolean z = rippleNodeConfiguration.isBounded;
            long j = this.rippleSize;
            fMo81toPx0680j_4 = Offset.m435getDistanceimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)))) << 32)) / 2.0f;
            if (z) {
                fMo81toPx0680j_4 += density.mo81toPx0680j_4(10.0f);
            }
        } else {
            fMo81toPx0680j_4 = density.mo81toPx0680j_4(rippleNodeConfiguration.radius);
        }
        boolean z2 = this.targetRadius == fMo81toPx0680j_4;
        boolean z3 = !z2;
        if (!z2) {
            this.targetRadius = fMo81toPx0680j_4;
        }
        return z3;
    }
}
