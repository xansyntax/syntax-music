package androidx.compose.material3.internal;

import android.content.Context;
import android.content.res.Resources;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.internal.Lock;
import androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1$1;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda3;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda4;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda13;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda8;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.ListItemKt$InteractiveListItem$$inlined$animateColor$1;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.MinimumInteractiveModifier;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SliderState;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldLabelPosition$Cutout;
import androidx.compose.material3.TextFieldLabelPosition$Inside;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.material3.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.LayoutIdModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.EmojiSupportMatch;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.ParagraphStyleKt;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.SpanStyleKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BrushStyle;
import androidx.compose.ui.text.style.ColorStyle;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import androidx.emoji2.text.EmojiProcessor;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda0;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.media3.extractor.flv.TagPayloadReader;
import androidx.sqlite.SQLite;
import coil3.compose.AsyncImagePainter;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import coil3.size.ViewSizeResolver$size$3$1;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda22;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.ui.component.ItemsKt$$ExternalSyntheticLambda72;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda49;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda5;
import io.ktor.client.utils.CIOKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.StringValuesKt$$ExternalSyntheticLambda0;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.Headers;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Icons$Filled {
    public static ImageVector _arrowDropDown;
    public static ImageVector _check;

    public static final void BackHandler(int i, Composer composer, Function0 function0, boolean z) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1339183247);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        byte b = 1;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            UtilsKt.BackHandler(z, function0, gapComposer, i2 & 126, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ItemsKt$$ExternalSyntheticLambda72(z, function0, i, b);
        }
    }

    public static final void BasicTooltipBox(PopupPositionProvider popupPositionProvider, ComposableLambdaImpl composableLambdaImpl, TooltipStateImpl tooltipStateImpl, Modifier modifier, ComposableLambdaImpl composableLambdaImpl2, Composer composer, int i) {
        PopupPositionProvider popupPositionProvider2;
        int i2;
        MutableState mutableState;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1221877520);
        if ((i & 6) == 0) {
            popupPositionProvider2 = popupPositionProvider;
            i2 = (gapComposer.changed(popupPositionProvider2) ? 4 : 2) | i;
        } else {
            popupPositionProvider2 = popupPositionProvider;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? gapComposer.changed(tooltipStateImpl) : gapComposer.changedInstance(tooltipStateImpl) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(modifier) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changedInstance(null) ? 16384 : 8192;
        }
        boolean z = false;
        if ((i & 196608) == 0) {
            i2 |= gapComposer.changed(false) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer.changed(true) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= gapComposer.changed(false) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl2) ? 67108864 : 33554432;
        }
        int i3 = i2;
        if (gapComposer.shouldExecute(i3 & 1, (38347923 & i3) != 38347922)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            gapComposer.startReplaceGroup(-1104742522);
            gapComposer.end(false);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, Modifier.Companion.$$INSTANCE);
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
            if (tooltipStateImpl.isVisible()) {
                gapComposer.startReplaceGroup(-1891243071);
                TooltipPopup(popupPositionProvider2, tooltipStateImpl, coroutineScope, false, mutableState2, composableLambdaImpl, gapComposer, ((i3 << 15) & 3670016) | (i3 & 14) | 196608 | ((i3 >> 3) & 112) | ((i3 >> 6) & 896));
                mutableState = mutableState2;
                gapComposer = gapComposer;
                gapComposer.end(false);
            } else {
                mutableState = mutableState2;
                gapComposer.startReplaceGroup(-1890863476);
                gapComposer.end(false);
            }
            WrappedAnchor(tooltipStateImpl, mutableState, modifier, composableLambdaImpl2, gapComposer, ((i3 >> 18) & 14) | 384 | ((i3 >> 3) & 112) | ((i3 >> 12) & 7168) | (57344 & (i3 << 3)) | ((i3 >> 9) & 458752));
            gapComposer.end(true);
            if ((i3 & 896) == 256 || ((i3 & 512) != 0 && gapComposer.changedInstance(tooltipStateImpl))) {
                z = true;
            }
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (z || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new TextKt$$ExternalSyntheticLambda2((byte) 7, tooltipStateImpl);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Stack.DisposableEffect(tooltipStateImpl, (Function1) objRememberedValue3, gapComposer);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CrossfadeKt$$ExternalSyntheticLambda4(popupPositionProvider, composableLambdaImpl, tooltipStateImpl, modifier, composableLambdaImpl2, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:245:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:261:0x040e  */
    public static final void CommonDecorationBox(final CharSequence charSequence, final Function2 function2, final ScrimKt scrimKt, final Function3 function3, final Function2 function4, final Function2 function5, final Function2 function6, final Function2 function7, final boolean z, final boolean z2, final InteractionSource interactionSource, final PaddingValues paddingValues, final TextFieldColors textFieldColors, final Function2 function8, Composer composer, final int i, final int i2) {
        CharSequence charSequence2;
        int i3;
        int i4;
        GapComposer gapComposer;
        InputPhase inputPhase;
        GapComposer gapComposer2;
        TransitionInstance transitionInstance;
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation;
        GapComposer gapComposer3;
        TransitionInstance transitionInstance2;
        boolean z3;
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation2;
        GapComposer gapComposer4;
        Transition.TransitionAnimationState transitionAnimationState;
        boolean z4;
        final TextStyle textStyle;
        TextFieldColors textFieldColors2;
        TextStyle textStyle2;
        Transition.TransitionAnimationState transitionAnimationState2;
        ComposableLambdaImpl composableLambdaImpl;
        final long j;
        ComposableLambdaImpl composableLambdaImpl2;
        long j2;
        ComposableLambdaImpl composableLambdaImplRememberComposableLambda;
        long j3;
        ComposableLambdaImpl composableLambdaImpl3;
        long j4;
        boolean z5;
        ComposableLambdaImpl composableLambdaImpl4;
        Object objM;
        float f;
        float f2;
        boolean z6;
        Object objM2;
        float f3;
        Object objDerivedStateOf;
        float f4;
        NeverEqualPolicy neverEqualPolicy = NeverEqualPolicy.INSTANCE$3;
        TwoWayConverterImpl twoWayConverterImpl = ArcSplineKt.FloatToVector;
        GapComposer gapComposer5 = (GapComposer) composer;
        gapComposer5.startRestartGroup(-1478429597);
        if ((i & 6) == 0) {
            charSequence2 = charSequence;
            i3 = i | (gapComposer5.changedInstance(charSequence2) ? 4 : 2);
        } else {
            charSequence2 = charSequence;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer5.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer5.changed(scrimKt) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer5.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer5.changedInstance(function4) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= gapComposer5.changedInstance(function5) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= gapComposer5.changedInstance(function6) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer5.changedInstance(null) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= gapComposer5.changedInstance(null) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= gapComposer5.changedInstance(function7) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        int i5 = i3;
        if ((i2 & 6) == 0) {
            i4 = i2 | (gapComposer5.changed(z) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer5.changed(z2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= gapComposer5.changed(false) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= gapComposer5.changed(interactionSource) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= gapComposer5.changed(paddingValues) ? 16384 : 8192;
        }
        if ((i2 & 196608) == 0) {
            i4 |= gapComposer5.changed(textFieldColors) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= gapComposer5.changedInstance(function8) ? 1048576 : 524288;
        }
        int i6 = i4;
        if (gapComposer5.shouldExecute(i5 & 1, ((i5 & 306783379) == 306783378 && (i6 & 599187) == 599186) ? false : true)) {
            boolean zBooleanValue = ((Boolean) DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(interactionSource, gapComposer5, (i6 >> 9) & 14).getValue()).booleanValue();
            InputPhase inputPhase2 = InputPhase.UnfocusedNotEmpty;
            InputPhase inputPhase3 = InputPhase.UnfocusedEmpty;
            InputPhase inputPhase4 = InputPhase.Focused;
            if (zBooleanValue) {
                inputPhase = inputPhase4;
            } else {
                inputPhase = charSequence2.length() == 0 ? inputPhase3 : inputPhase2;
            }
            Typography typography = ((MaterialTheme$Values) gapComposer5.consume(MaterialThemeKt._localMaterialTheme)).typography;
            TextStyle textStyle3 = typography.bodyLarge;
            TextStyle textStyle4 = typography.bodySmall;
            long jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
            Rgb rgb = ColorSpaces.Unspecified;
            boolean z7 = (ULong.m1869equalsimpl0(jM752getColor0d7_KjU, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb)) && !ULong.m1869equalsimpl0(textStyle4.m752getColor0d7_KjU(), ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb))) || (!ULong.m1869equalsimpl0(textStyle3.m752getColor0d7_KjU(), ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb)) && ULong.m1869equalsimpl0(textStyle4.m752getColor0d7_KjU(), ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb)));
            TransitionInstance transitionInstanceUpdateTransition = ArcSplineKt.updateTransition(inputPhase, "TextFieldInputState", gapComposer5, 48, 0);
            TagPayloadReader tagPayloadReader = transitionInstanceUpdateTransition.transitionState;
            boolean z8 = function3 != null && ((scrimKt instanceof TextFieldLabelPosition$Inside) || (scrimKt instanceof TextFieldLabelPosition$Cutout));
            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
            if (function3 != null) {
                gapComposer5.startReplaceGroup(994993276);
                FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs = CardKt.m272valueyDoVZcs(1, gapComposer5);
                if (transitionInstanceUpdateTransition.isSeeking()) {
                    z8 = z8;
                    z7 = z7;
                    objM2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer5, 1666827533, false, tagPayloadReader);
                } else {
                    gapComposer5.startReplaceGroup(1666573488);
                    boolean zChanged = gapComposer5.changed(transitionInstanceUpdateTransition);
                    objM2 = gapComposer5.rememberedValue();
                    if (zChanged || objM2 == neverEqualPolicy2) {
                        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            Object currentState = tagPayloadReader.getCurrentState();
                            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            gapComposer5.updateRememberedValue(currentState);
                            objM2 = currentState;
                        } catch (Throwable th) {
                            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            throw th;
                        }
                    }
                    gapComposer5.end(false);
                }
                gapComposer5.startReplaceGroup(1071902915);
                int iOrdinal = ((InputPhase) objM2).ordinal();
                if (iOrdinal == 0) {
                    f3 = 1.0f;
                } else {
                    if (iOrdinal != 1) {
                        if (iOrdinal != 2) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return;
                        }
                    } else if (z8) {
                        f3 = CropImageView.DEFAULT_ASPECT_RATIO;
                    }
                    f3 = 1.0f;
                }
                gapComposer5.end(false);
                Float fValueOf = Float.valueOf(f3);
                boolean zChanged2 = gapComposer5.changed(transitionInstanceUpdateTransition);
                Object objRememberedValue = gapComposer5.rememberedValue();
                if (zChanged2 || objRememberedValue == neverEqualPolicy2) {
                    objDerivedStateOf = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 20));
                    gapComposer5.updateRememberedValue(objDerivedStateOf);
                } else {
                    objDerivedStateOf = objRememberedValue;
                }
                InputPhase inputPhase5 = (InputPhase) ((State) objDerivedStateOf).getValue();
                gapComposer5.startReplaceGroup(1071902915);
                int iOrdinal2 = inputPhase5.ordinal();
                if (iOrdinal2 == 0) {
                    f4 = 1.0f;
                } else {
                    if (iOrdinal2 != 1) {
                        if (iOrdinal2 != 2) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return;
                        }
                    } else if (z8) {
                        f4 = CropImageView.DEFAULT_ASPECT_RATIO;
                    }
                    f4 = 1.0f;
                }
                gapComposer5.end(false);
                Float fValueOf2 = Float.valueOf(f4);
                boolean zChanged3 = gapComposer5.changed(transitionInstanceUpdateTransition);
                Object objRememberedValue2 = gapComposer5.rememberedValue();
                if (zChanged3 || objRememberedValue2 == neverEqualPolicy2) {
                    objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstanceUpdateTransition, (byte) 21));
                    gapComposer5.updateRememberedValue(objRememberedValue2);
                }
                gapComposer5.startReplaceGroup(1806589607);
                gapComposer5.end(false);
                transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionInstanceUpdateTransition, fValueOf, fValueOf2, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl, gapComposer5, 196608);
                transitionInstance = transitionInstanceUpdateTransition;
                gapComposer2 = gapComposer5;
                gapComposer2.end(false);
            } else {
                z8 = z8;
                z7 = z7;
                gapComposer2 = gapComposer5;
                transitionInstance = transitionInstanceUpdateTransition;
                gapComposer2.startReplaceGroup(995064483);
                gapComposer2.end(false);
                transitionAnimationStateCreateTransitionAnimation = null;
            }
            if (function4 != null) {
                gapComposer2.startReplaceGroup(995155127);
                FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs2 = CardKt.m272valueyDoVZcs(4, gapComposer2);
                FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs3 = CardKt.m272valueyDoVZcs(5, gapComposer2);
                if (transitionInstance.isSeeking()) {
                    objM = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2, 1666827533, false, tagPayloadReader);
                } else {
                    gapComposer2.startReplaceGroup(1666573488);
                    boolean zChanged4 = gapComposer2.changed(transitionInstance);
                    objM = gapComposer2.rememberedValue();
                    if (zChanged4 || objM == neverEqualPolicy2) {
                        Snapshot currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                        Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                        Snapshot snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                        try {
                            Object currentState2 = tagPayloadReader.getCurrentState();
                            Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                            gapComposer2.updateRememberedValue(currentState2);
                            objM = currentState2;
                        } catch (Throwable th2) {
                            Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                            throw th2;
                        }
                    }
                    gapComposer2.end(false);
                }
                gapComposer2.startReplaceGroup(-2037958114);
                int iOrdinal3 = ((InputPhase) objM).ordinal();
                if (iOrdinal3 == 0) {
                    f = 1.0f;
                } else {
                    if (iOrdinal3 != 1) {
                        if (iOrdinal3 != 2) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return;
                        }
                    } else if (!z8) {
                        f = 1.0f;
                    }
                    f = CropImageView.DEFAULT_ASPECT_RATIO;
                }
                gapComposer2.end(false);
                Float fValueOf3 = Float.valueOf(f);
                boolean zChanged5 = gapComposer2.changed(transitionInstance);
                Object objRememberedValue3 = gapComposer2.rememberedValue();
                if (zChanged5 || objRememberedValue3 == neverEqualPolicy2) {
                    objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance, (byte) 24));
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                InputPhase inputPhase6 = (InputPhase) ((State) objRememberedValue3).getValue();
                gapComposer2.startReplaceGroup(-2037958114);
                int iOrdinal4 = inputPhase6.ordinal();
                if (iOrdinal4 == 0) {
                    f2 = 1.0f;
                    z6 = false;
                } else {
                    if (iOrdinal4 != 1) {
                        if (iOrdinal4 != 2) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return;
                        }
                    } else if (!z8) {
                        f2 = 1.0f;
                        z6 = false;
                    }
                    z6 = false;
                    f2 = CropImageView.DEFAULT_ASPECT_RATIO;
                }
                gapComposer2.end(z6);
                Float fValueOf4 = Float.valueOf(f2);
                boolean zChanged6 = gapComposer2.changed(transitionInstance);
                Object objRememberedValue4 = gapComposer2.rememberedValue();
                if (zChanged6 || objRememberedValue4 == neverEqualPolicy2) {
                    objRememberedValue4 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance, (byte) 25));
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                }
                Transition.Segment segment = (Transition.Segment) ((State) objRememberedValue4).getValue();
                gapComposer2.startReplaceGroup(-1370891590);
                FiniteAnimationSpec finiteAnimationSpec = (!segment.isTransitioningTo(inputPhase4, inputPhase3) && (segment.isTransitioningTo(inputPhase3, inputPhase4) || segment.isTransitioningTo(inputPhase2, inputPhase3))) ? finiteAnimationSpecM272valueyDoVZcs3 : finiteAnimationSpecM272valueyDoVZcs2;
                z3 = false;
                gapComposer2.end(false);
                GapComposer gapComposer6 = gapComposer2;
                transitionInstance2 = transitionInstance;
                transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionInstance2, fValueOf3, fValueOf4, finiteAnimationSpec, twoWayConverterImpl, gapComposer6, 196608);
                gapComposer3 = gapComposer6;
                gapComposer3.end(false);
            } else {
                gapComposer3 = gapComposer2;
                transitionInstance2 = transitionInstance;
                z3 = false;
                gapComposer3.startReplaceGroup(995231139);
                gapComposer3.end(false);
                transitionAnimationStateCreateTransitionAnimation2 = null;
            }
            gapComposer3.startReplaceGroup(995398787);
            gapComposer3.end(z3);
            if (function3 == null) {
                gapComposer3.startReplaceGroup(995475232);
                gapComposer3.end(z3);
                textFieldColors2 = textFieldColors;
                transitionAnimationState2 = transitionAnimationStateCreateTransitionAnimation;
                transitionAnimationState = transitionAnimationStateCreateTransitionAnimation2;
                gapComposer4 = gapComposer3;
                z4 = zBooleanValue;
                textStyle2 = textStyle4;
                composableLambdaImpl = null;
            } else {
                gapComposer3.startReplaceGroup(995475233);
                gapComposer4 = gapComposer3;
                transitionAnimationState = transitionAnimationStateCreateTransitionAnimation2;
                z4 = zBooleanValue;
                Transition.TransitionAnimationState transitionAnimationState3 = transitionAnimationStateCreateTransitionAnimation;
                textFieldColors2 = textFieldColors;
                textStyle2 = textStyle4;
                transitionAnimationState2 = transitionAnimationState3;
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(-568812970, new TextFieldImplKt$$ExternalSyntheticLambda1(transitionAnimationState3, textFieldColors, z2, z4, z7, transitionInstance2, textStyle4, textStyle, function3), gapComposer4);
                gapComposer4.end(false);
                composableLambdaImpl = composableLambdaImplRememberComposableLambda2;
            }
            if (z2) {
                j = z4 ? textFieldColors2.focusedPlaceholderColor : textFieldColors2.unfocusedPlaceholderColor;
            } else {
                textStyle = textStyle3;
                textStyle = textStyle3;
                j = textFieldColors2.disabledPlaceholderColor;
            }
            Object objRememberedValue5 = gapComposer4.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy2) {
                MainActivity$$ExternalSyntheticLambda22 mainActivity$$ExternalSyntheticLambda22 = new MainActivity$$ExternalSyntheticLambda22(transitionAnimationState, (byte) 10);
                EmojiProcessor emojiProcessor = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                DerivedSnapshotState derivedSnapshotState = new DerivedSnapshotState(mainActivity$$ExternalSyntheticLambda22, neverEqualPolicy);
                gapComposer4.updateRememberedValue(derivedSnapshotState);
                objRememberedValue5 = derivedSnapshotState;
            }
            State state = (State) objRememberedValue5;
            if (function4 != null && charSequence.length() == 0 && ((Boolean) state.getValue()).booleanValue()) {
                gapComposer4.startReplaceGroup(996489057);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Expect_jvmKt.rememberComposableLambda(1789869489, new Function3() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Modifier modifier = (Modifier) obj;
                        Composer composer2 = (Composer) obj2;
                        int iIntValue = ((Integer) obj3).intValue();
                        if ((iIntValue & 6) == 0) {
                            iIntValue |= ((GapComposer) composer2).changed(modifier) ? 4 : 2;
                        }
                        GapComposer gapComposer7 = (GapComposer) composer2;
                        if (gapComposer7.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                            int iHashCode = Long.hashCode(gapComposer7.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer7.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer7, modifier);
                            ComposeUiNode.Companion.getClass();
                            gapComposer7.startReusableNode();
                            if (gapComposer7.inserting) {
                                gapComposer7.createNode(LayoutNode.Constructor);
                            } else {
                                gapComposer7.useNode();
                            }
                            Stack.m390setimpl(gapComposer7, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                            Stack.m390setimpl(gapComposer7, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                            Stack.m390setimpl(gapComposer7, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                            Stack.m389reconcileimpl(gapComposer7);
                            Stack.m390setimpl(gapComposer7, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                            Icons$Filled.m368Decoration3JVO9M(j, textStyle, function4, gapComposer7, 0);
                            gapComposer7.end(true);
                        } else {
                            gapComposer7.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer4);
                gapComposer4.end(false);
                composableLambdaImpl2 = composableLambdaImplRememberComposableLambda3;
            } else {
                gapComposer4.startReplaceGroup(996800730);
                gapComposer4.end(false);
                composableLambdaImpl2 = null;
            }
            Object objRememberedValue6 = gapComposer4.rememberedValue();
            byte b = 6;
            if (objRememberedValue6 == neverEqualPolicy2) {
                MainActivity$$ExternalSyntheticLambda22 mainActivity$$ExternalSyntheticLambda23 = new MainActivity$$ExternalSyntheticLambda22(null, b);
                EmojiProcessor emojiProcessor2 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                DerivedSnapshotState derivedSnapshotState2 = new DerivedSnapshotState(mainActivity$$ExternalSyntheticLambda23, r24);
                gapComposer4.updateRememberedValue(derivedSnapshotState2);
                objRememberedValue6 = derivedSnapshotState2;
            }
            gapComposer4.startReplaceGroup(997244154);
            gapComposer4.end(false);
            gapComposer4.startReplaceGroup(997564570);
            gapComposer4.end(false);
            if (z2) {
                j2 = z4 ? textFieldColors2.focusedLeadingIconColor : textFieldColors2.unfocusedLeadingIconColor;
            } else {
                j2 = textFieldColors2.disabledLeadingIconColor;
            }
            if (function5 == null) {
                gapComposer4.startReplaceGroup(997719105);
                gapComposer4.end(false);
                composableLambdaImplRememberComposableLambda = null;
            } else {
                gapComposer4.startReplaceGroup(997719106);
                composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-341635739, new ChipKt$$ExternalSyntheticLambda13(j2, function5, (byte) 3), gapComposer4);
                gapComposer4.end(false);
            }
            if (z2) {
                j3 = z4 ? textFieldColors2.focusedTrailingIconColor : textFieldColors2.unfocusedTrailingIconColor;
            } else {
                j3 = textFieldColors2.disabledTrailingIconColor;
            }
            if (function6 == null) {
                gapComposer4.startReplaceGroup(997963168);
                gapComposer4.end(false);
                composableLambdaImpl3 = null;
            } else {
                gapComposer4.startReplaceGroup(997963169);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda4 = Expect_jvmKt.rememberComposableLambda(-1014805251, new ChipKt$$ExternalSyntheticLambda13(j3, function6, (byte) 4), gapComposer4);
                gapComposer4.end(false);
                composableLambdaImpl3 = composableLambdaImplRememberComposableLambda4;
            }
            if (z2) {
                j4 = z4 ? textFieldColors2.focusedSupportingTextColor : textFieldColors2.unfocusedSupportingTextColor;
            } else {
                j4 = textFieldColors2.disabledSupportingTextColor;
            }
            if (function7 == null) {
                gapComposer4.startReplaceGroup(998217523);
                z5 = false;
                gapComposer4.end(false);
                composableLambdaImpl4 = null;
            } else {
                z5 = false;
                gapComposer4.startReplaceGroup(998217524);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda5 = Expect_jvmKt.rememberComposableLambda(-1718586554, new ButtonKt$$ExternalSyntheticLambda4(j4, textStyle2, function7, (byte) 5), gapComposer4);
                gapComposer4.end(false);
                composableLambdaImpl4 = composableLambdaImplRememberComposableLambda5;
            }
            boolean zChanged7 = gapComposer4.changed(transitionAnimationState2);
            Object objRememberedValue7 = gapComposer4.rememberedValue();
            if (zChanged7 || objRememberedValue7 == neverEqualPolicy2) {
                objRememberedValue7 = new MainActivity$$ExternalSyntheticLambda22(transitionAnimationState2, (byte) 7);
                gapComposer4.updateRememberedValue(objRememberedValue7);
            }
            Function0 function0 = (Function0) objRememberedValue7;
            boolean zChanged8 = gapComposer4.changed(transitionAnimationState);
            Object objRememberedValue8 = gapComposer4.rememberedValue();
            if (zChanged8 || objRememberedValue8 == neverEqualPolicy2) {
                objRememberedValue8 = new MainActivity$$ExternalSyntheticLambda22(transitionAnimationState, (byte) 8);
                gapComposer4.updateRememberedValue(objRememberedValue8);
            }
            Function0 function1 = (Function0) objRememberedValue8;
            State state2 = null;
            boolean zChanged9 = gapComposer4.changed((Object) null);
            Object objRememberedValue9 = gapComposer4.rememberedValue();
            byte b2 = 9;
            if (zChanged9 || objRememberedValue9 == neverEqualPolicy2) {
                objRememberedValue9 = new MainActivity$$ExternalSyntheticLambda22(state2, b2);
                gapComposer4.updateRememberedValue(objRememberedValue9);
            }
            Function0 function9 = (Function0) objRememberedValue9;
            if (scrimKt instanceof TextFieldLabelPosition$Cutout) {
                gapComposer4.startReplaceGroup(998651493);
                Object objRememberedValue10 = gapComposer4.rememberedValue();
                if (objRememberedValue10 == neverEqualPolicy2) {
                    objRememberedValue10 = Stack.mutableStateOf$default(new Size(0L));
                    gapComposer4.updateRememberedValue(objRememberedValue10);
                }
                MutableState mutableState = (MutableState) objRememberedValue10;
                GapComposer gapComposer7 = gapComposer4;
                boolean z9 = z5;
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda6 = Expect_jvmKt.rememberComposableLambda(-852893942, new CrossfadeKt$$ExternalSyntheticLambda3(mutableState, scrimKt, paddingValues, function8, (byte) 3), gapComposer7);
                TextFieldLabelPosition$Cutout textFieldLabelPosition$Cutout = (TextFieldLabelPosition$Cutout) scrimKt;
                TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 = new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function0);
                TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1 = new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function1);
                TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2 = new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function9);
                boolean zChanged10 = gapComposer7.changed(function0);
                Object objRememberedValue11 = gapComposer7.rememberedValue();
                if (zChanged10 || objRememberedValue11 == neverEqualPolicy2) {
                    objRememberedValue11 = new ZIndexNode$$ExternalSyntheticLambda0((Object) function0, (Object) mutableState, (byte) 20);
                    gapComposer7.updateRememberedValue(objRememberedValue11);
                }
                CutoutTextFieldLayout(function2, charSequence, composableLambdaImpl2, composableLambdaImpl, composableLambdaImplRememberComposableLambda, composableLambdaImpl3, null, null, z, textFieldLabelPosition$Cutout, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, (Function1) objRememberedValue11, composableLambdaImplRememberComposableLambda6, composableLambdaImpl4, paddingValues, gapComposer7, (i5 & 112) | 6 | ((i5 << 6) & 896) | ((i6 << 27) & 1879048192), ((i5 >> 6) & 14) | 196608 | (29360128 & (i6 << 9)));
                gapComposer = gapComposer7;
                gapComposer.end(z9);
            } else {
                GapComposer gapComposer8 = gapComposer4;
                gapComposer8.startReplaceGroup(1000371776);
                InsideTextFieldLayout(function2, charSequence, composableLambdaImpl, composableLambdaImpl2, composableLambdaImplRememberComposableLambda, composableLambdaImpl3, null, null, z, scrimKt, new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function0), new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function1), new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function9), Expect_jvmKt.rememberComposableLambda(590261845, new StringValuesKt$$ExternalSyntheticLambda0(function8, (byte) 5), gapComposer8), composableLambdaImpl4, paddingValues, gapComposer8, (i5 & 112) | 6 | ((i5 << 6) & 896) | ((i6 << 27) & 1879048192), ((i5 >> 6) & 14) | 24576 | (3670016 & (i6 << 6)));
                gapComposer = gapComposer8;
                gapComposer.end(false);
            }
        } else {
            gapComposer = gapComposer5;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    Icons$Filled.CommonDecorationBox(charSequence, function2, scrimKt, function3, function4, function5, function6, function7, z, z2, interactionSource, paddingValues, textFieldColors, function8, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:275:0x0587  */
    /* JADX WARN: Code duplicated, block: B:279:0x058e  */
    /* JADX WARN: Code duplicated, block: B:282:0x05ca  */
    /* JADX WARN: Code duplicated, block: B:283:0x05ce  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void CutoutTextFieldLayout(final Function2 function2, CharSequence charSequence, final Function3 function3, Function2 function4, final Function2 function5, final Function2 function6, final Function2 function7, final Function2 function8, final boolean z, final TextFieldLabelPosition$Cutout textFieldLabelPosition$Cutout, final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, final Function1 function1, final ComposableLambdaImpl composableLambdaImpl, Function2 function9, PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Function2 function10;
        Function2 function11;
        CharSequence charSequence2;
        GapComposer gapComposer;
        PaddingValues paddingValues2;
        float f;
        LayoutDirection layoutDirection;
        boolean z2;
        Function2 function12;
        float f2;
        boolean z3;
        TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3;
        boolean z4;
        Object objRememberedValue;
        boolean z5;
        BiasAlignment biasAlignment = Alignment.Companion.TopStart;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(720589198);
        int i5 = i & 6;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (i5 == 0) {
            i3 = i | (gapComposer2.changed(companion) ? 4 : 2);
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer2.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer2.changedInstance(charSequence) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer2.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer2.changedInstance(function4) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= gapComposer2.changedInstance(function5) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= gapComposer2.changedInstance(function6) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer2.changedInstance(function7) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= gapComposer2.changedInstance(function8) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= gapComposer2.changed(z) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (gapComposer2.changed(textFieldLabelPosition$Cutout) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= (i2 & 64) == 0 ? gapComposer2.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0) : gapComposer2.changedInstance(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= (i2 & 512) == 0 ? gapComposer2.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1) : gapComposer2.changedInstance(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= (i2 & 4096) == 0 ? gapComposer2.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2) : gapComposer2.changedInstance(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= gapComposer2.changedInstance(function1) ? 16384 : 8192;
        }
        if ((i2 & 196608) == 0) {
            i4 |= gapComposer2.changedInstance(composableLambdaImpl) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= gapComposer2.changedInstance(function9) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= gapComposer2.changed(paddingValues) ? 8388608 : 4194304;
        }
        int i6 = i4;
        if (gapComposer2.shouldExecute(i3 & 1, ((i3 & 306783379) == 306783378 && (4793491 & i6) == 4793490) ? false : true)) {
            float fTextFieldHorizontalIconPadding = textFieldHorizontalIconPadding(gapComposer2);
            int i7 = i6 & 112;
            boolean zChanged = ((57344 & i6) == 16384) | ((i3 & 1879048192) == 536870912) | ((i6 & 14) == 4) | (i7 == 32 || ((i6 & 64) != 0 && gapComposer2.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0))) | ((i6 & 896) == 256 || ((i6 & 512) != 0 && gapComposer2.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1))) | ((i6 & 7168) == 2048 || ((i6 & 4096) != 0 && gapComposer2.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2))) | ((29360128 & i6) == 8388608) | gapComposer2.changed(fTextFieldHorizontalIconPadding);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                f = fTextFieldHorizontalIconPadding;
                gapComposer = gapComposer2;
                OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = new OutlinedTextFieldMeasurePolicy(function1, z, textFieldLabelPosition$Cutout, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, paddingValues, f);
                gapComposer.updateRememberedValue(outlinedTextFieldMeasurePolicy);
                objRememberedValue2 = outlinedTextFieldMeasurePolicy;
            } else {
                f = fTextFieldHorizontalIconPadding;
                gapComposer = gapComposer2;
            }
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy2 = (OutlinedTextFieldMeasurePolicy) objRememberedValue2;
            LayoutDirection layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, companion);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z6 = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z6) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, outlinedTextFieldMeasurePolicy2, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            composableLambdaImpl.invoke(gapComposer, Integer.valueOf((i6 >> 15) & 14));
            MinimumInteractiveModifier minimumInteractiveModifier = MinimumInteractiveModifier.INSTANCE;
            if (function5 != null) {
                gapComposer.startReplaceGroup(1958829341);
                Modifier modifierThen = RulerKt.layoutId(companion, "Leading").then(minimumInteractiveModifier);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen);
                gapComposer.startReusableNode();
                layoutDirection = layoutDirection2;
                if (gapComposer.inserting) {
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                function5.invoke(gapComposer, Integer.valueOf((i3 >> 15) & 14));
                gapComposer.end(true);
                z2 = false;
                gapComposer.end(false);
            } else {
                layoutDirection = layoutDirection2;
                z2 = false;
                gapComposer.startReplaceGroup(1959075357);
                gapComposer.end(false);
            }
            if (function6 != null) {
                gapComposer.startReplaceGroup(1959118075);
                Modifier modifierThen2 = RulerKt.layoutId(companion, "Trailing").then(minimumInteractiveModifier);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, z2);
                int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen2);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                function6.invoke(gapComposer, Integer.valueOf((i3 >> 18) & 14));
                gapComposer.end(true);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1959366013);
                gapComposer.end(z2);
            }
            paddingValues2 = paddingValues;
            LayoutDirection layoutDirection3 = layoutDirection;
            float fCalculateStartPadding = OffsetKt.calculateStartPadding(paddingValues2, layoutDirection3);
            float fCalculateEndPadding = OffsetKt.calculateEndPadding(paddingValues2, layoutDirection3);
            if (function5 != null) {
                fCalculateStartPadding = (fCalculateStartPadding - f) + CropImageView.DEFAULT_ASPECT_RATIO;
                if (fCalculateStartPadding < CropImageView.DEFAULT_ASPECT_RATIO) {
                    fCalculateStartPadding = 0.0f;
                }
            }
            float f3 = fCalculateStartPadding;
            if (function6 != null) {
                fCalculateEndPadding = (fCalculateEndPadding - f) + CropImageView.DEFAULT_ASPECT_RATIO;
                if (fCalculateEndPadding < CropImageView.DEFAULT_ASPECT_RATIO) {
                    fCalculateEndPadding = 0.0f;
                }
            }
            if (function7 != null) {
                gapComposer.startReplaceGroup(1960069992);
                Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m147heightInVpY3zN4$default(RulerKt.layoutId(companion, "Prefix"), 24.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2)), f3, CropImageView.DEFAULT_ASPECT_RATIO, 2.0f, CropImageView.DEFAULT_ASPECT_RATIO, 10);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                int iHashCode4 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM139paddingqDBjuR0$default);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy3, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda3);
                function7.invoke(gapComposer, Integer.valueOf((i3 >> 21) & 14));
                gapComposer.end(true);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1960397693);
                gapComposer.end(false);
            }
            if (function8 != null) {
                gapComposer.startReplaceGroup(1960440938);
                f2 = fCalculateEndPadding;
                Modifier modifierM139paddingqDBjuR0$default2 = OffsetKt.m139paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m147heightInVpY3zN4$default(RulerKt.layoutId(companion, "Suffix"), 24.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2)), 2.0f, CropImageView.DEFAULT_ASPECT_RATIO, f2, CropImageView.DEFAULT_ASPECT_RATIO, 10);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(r16, false);
                int iHashCode5 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM139paddingqDBjuR0$default2);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy4, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda3);
                function12 = function8;
                function12.invoke(gapComposer, Integer.valueOf((i3 >> 24) & 14));
                gapComposer.end(true);
                gapComposer.end(false);
            } else {
                function12 = function8;
                f2 = fCalculateEndPadding;
                gapComposer.startReplaceGroup(1960766717);
                gapComposer.end(false);
            }
            Modifier modifierM139paddingqDBjuR0$default3 = OffsetKt.m139paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m147heightInVpY3zN4$default(companion, 24.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2)), function7 == null ? f3 : CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, function12 == null ? f2 : CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 10);
            if (function3 != null) {
                gapComposer.startReplaceGroup(1961136702);
                function3.invoke(RulerKt.layoutId(companion, "Hint").then(modifierM139paddingqDBjuR0$default3), gapComposer, Integer.valueOf((i3 >> 6) & 112));
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1961227997);
                gapComposer.end(false);
            }
            Modifier modifierLayoutId = RulerKt.layoutId(companion, "TextField");
            charSequence2 = charSequence;
            Modifier modifierThen3 = visualTextSemantics(modifierLayoutId, charSequence2, (function7 == null && function12 == null) ? false : true).then(modifierM139paddingqDBjuR0$default3);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(r16, true);
            int iHashCode6 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen3);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy5, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode6, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda3);
            function2.invoke(gapComposer, Integer.valueOf((i3 >> 3) & 14));
            gapComposer.end(true);
            if (function4 != null) {
                gapComposer.startReplaceGroup(1962015552);
                if (i7 != 32) {
                    if ((i6 & 64) != 0) {
                        textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
                        if (gapComposer.changedInstance(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3)) {
                        }
                        objRememberedValue = gapComposer.rememberedValue();
                        if (!z4 || objRememberedValue == neverEqualPolicy) {
                            z5 = false;
                            objRememberedValue = new TextFieldImplKt$$ExternalSyntheticLambda15(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, 0 == true ? 1 : 0);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        } else {
                            z5 = false;
                        }
                        Modifier modifierThen4 = RulerKt.layoutId(SizeKt.wrapContentHeight$default(RulerKt.layout(companion, new PlayerMenuKt$$ExternalSyntheticLambda49((Function0) objRememberedValue, (byte) 1))), "Label").then(companion);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(r16, z5);
                        int iHashCode7 = Long.hashCode(gapComposer.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope7 = gapComposer.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier7 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen4);
                        gapComposer.startReusableNode();
                        if (gapComposer.inserting) {
                            gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer.useNode();
                        }
                        Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy6, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope7, updater$$ExternalSyntheticLambda1);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode7, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                        Stack.m390setimpl(gapComposer, modifierMaterializeModifier7, updater$$ExternalSyntheticLambda3);
                        function10 = function4;
                        function10.invoke(gapComposer, Integer.valueOf((i3 >> 12) & 14));
                        gapComposer.end(true);
                        gapComposer.end(false);
                    } else {
                        textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
                    }
                    z4 = false;
                    objRememberedValue = gapComposer.rememberedValue();
                    if (z4) {
                        z5 = false;
                        objRememberedValue = new TextFieldImplKt$$ExternalSyntheticLambda15(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, 0 == true ? 1 : 0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    } else {
                        z5 = false;
                        objRememberedValue = new TextFieldImplKt$$ExternalSyntheticLambda15(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, 0 == true ? 1 : 0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierThen5 = RulerKt.layoutId(SizeKt.wrapContentHeight$default(RulerKt.layout(companion, new PlayerMenuKt$$ExternalSyntheticLambda49((Function0) objRememberedValue, (byte) 1))), "Label").then(companion);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(r16, z5);
                    int iHashCode8 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope8 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier8 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen5);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy7, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope8, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode8, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier8, updater$$ExternalSyntheticLambda3);
                    function10 = function4;
                    function10.invoke(gapComposer, Integer.valueOf((i3 >> 12) & 14));
                    gapComposer.end(true);
                    gapComposer.end(false);
                } else {
                    textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
                }
                z4 = true;
                objRememberedValue = gapComposer.rememberedValue();
                if (z4) {
                    z5 = false;
                    objRememberedValue = new TextFieldImplKt$$ExternalSyntheticLambda15(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, 0 == true ? 1 : 0);
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    z5 = false;
                    objRememberedValue = new TextFieldImplKt$$ExternalSyntheticLambda15(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, 0 == true ? 1 : 0);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierThen6 = RulerKt.layoutId(SizeKt.wrapContentHeight$default(RulerKt.layout(companion, new PlayerMenuKt$$ExternalSyntheticLambda49((Function0) objRememberedValue, (byte) 1))), "Label").then(companion);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(r16, z5);
                int iHashCode9 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope9 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier9 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen6);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy8, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope9, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode9, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier9, updater$$ExternalSyntheticLambda3);
                function10 = function4;
                function10.invoke(gapComposer, Integer.valueOf((i3 >> 12) & 14));
                gapComposer.end(true);
                gapComposer.end(false);
            } else {
                function10 = function4;
                gapComposer.startReplaceGroup(1962412445);
                gapComposer.end(false);
            }
            if (function9 != null) {
                gapComposer.startReplaceGroup(1962460960);
                Modifier modifierPadding = OffsetKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m147heightInVpY3zN4$default(RulerKt.layoutId(companion, "Supporting"), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2)), new PaddingValuesImpl(16.0f, 4.0f, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(r16, false);
                int iHashCode10 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope10 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier10 = ZIndexModifierKt.materializeModifier(gapComposer, modifierPadding);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy9, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope10, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode10, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier10, updater$$ExternalSyntheticLambda3);
                function11 = function9;
                function11.invoke(gapComposer, Integer.valueOf((i6 >> 18) & 14));
                z3 = true;
                gapComposer.end(true);
                gapComposer.end(false);
            } else {
                function11 = function9;
                z3 = true;
                gapComposer.startReplaceGroup(1962796349);
                gapComposer.end(false);
            }
            gapComposer.end(z3);
        } else {
            function10 = function4;
            function11 = function9;
            charSequence2 = charSequence;
            gapComposer = gapComposer2;
            paddingValues2 = paddingValues;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final Function2 function13 = function11;
            final Function2 function14 = function10;
            final CharSequence charSequence3 = charSequence2;
            final PaddingValues paddingValues3 = paddingValues2;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    Icons$Filled.CutoutTextFieldLayout(function2, charSequence3, function3, function14, function5, function6, function7, function8, z, textFieldLabelPosition$Cutout, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, function1, composableLambdaImpl, function13, paddingValues3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:124:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:127:0x0207  */
    /* JADX WARN: Code duplicated, block: B:129:0x020b  */
    /* JADX WARN: Code duplicated, block: B:141:0x022c  */
    /* JADX WARN: Code duplicated, block: B:191:0x034a  */
    /* JADX WARN: Code duplicated, block: B:203:0x0388  */
    /* JADX WARN: Code duplicated, block: B:206:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:207:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:216:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:218:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:233:0x0439  */
    /* JADX WARN: Code duplicated, block: B:236:0x0459  */
    /* JADX WARN: Code duplicated, block: B:239:0x045f  */
    /* JADX WARN: Code duplicated, block: B:242:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:243:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:246:0x04af  */
    /* JADX WARN: Code duplicated, block: B:247:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:250:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:254:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:259:0x050a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:260:0x050c  */
    /* JADX WARN: Code duplicated, block: B:261:0x0530  */
    /* JADX WARN: Code duplicated, block: B:263:0x053d  */
    /* JADX WARN: Code duplicated, block: B:264:0x0553  */
    /* JADX WARN: Code duplicated, block: B:269:0x057d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:270:0x057f  */
    /* JADX WARN: Code duplicated, block: B:274:0x05dd  */
    /* JADX WARN: Code duplicated, block: B:277:0x05e3  */
    /* JADX WARN: Code duplicated, block: B:282:0x0609  */
    /* JADX WARN: Code duplicated, block: B:284:0x060d  */
    /* JADX WARN: Code duplicated, block: B:287:0x0612  */
    /* JADX WARN: Code duplicated, block: B:290:0x0617  */
    /* JADX WARN: Code duplicated, block: B:291:0x061a  */
    /* JADX WARN: Code duplicated, block: B:294:0x069d  */
    /* JADX WARN: Code duplicated, block: B:296:0x06ce  */
    public static final void DecoratedLabel(State state, TextFieldColors textFieldColors, boolean z, boolean z2, boolean z3, TransitionInstance transitionInstance, TextStyle textStyle, TextStyle textStyle2, Function3 function3, Composer composer, int i) {
        Function3 function4;
        long j;
        boolean z4;
        int i2;
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation;
        byte b;
        boolean z5;
        Object objM;
        TransitionInstance transitionInstance2;
        int i3;
        Transition.TransitionAnimationState transitionAnimationState;
        boolean z6;
        Object objRememberedValue;
        boolean z7;
        Object objRememberedValue2;
        Transition.TransitionAnimationState transitionAnimationState2;
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation2;
        float fFloatValue;
        TextStyle textStyle3;
        TextForegroundStyle textForegroundStyle;
        TextForegroundStyle textForegroundStyle2;
        boolean z8;
        TextForegroundStyle brushStyle;
        GapComposer gapComposer;
        FontWeight fontWeight;
        FontWeight fontWeight2;
        BaselineShift baselineShift;
        float f;
        BaselineShift baselineShift2;
        float f2;
        TextGeometricTransform textGeometricTransform;
        TextGeometricTransform textGeometricTransform2;
        TextGeometricTransform textGeometricTransform3;
        Shadow shadow;
        Shadow shadow2;
        Transition.TransitionAnimationState transitionAnimationState3;
        Transition.TransitionAnimationState transitionAnimationState4;
        float f3;
        long j2;
        long j3;
        Shadow shadow3;
        PlatformSpanStyle platformSpanStyle;
        PlatformSpanStyle platformSpanStyle2;
        TextIndent textIndent;
        TextIndent textIndent2;
        PlatformParagraphStyle platformParagraphStyle;
        PlatformParagraphStyle platformParagraphStyle2;
        PlatformParagraphStyle platformParagraphStyle3;
        boolean z9;
        boolean z10;
        PlatformParagraphStyle platformParagraphStyle4;
        TextStyle textStyleM750copyp1EtxEg$default;
        int i4;
        boolean z11;
        Object objM2;
        Color color;
        boolean z12;
        Object objRememberedValue3;
        InputPhase inputPhase;
        long j4;
        boolean z13;
        Object objRememberedValue4;
        TransitionInstance transitionInstance3 = transitionInstance;
        TagPayloadReader tagPayloadReader = transitionInstance3.transitionState;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = transitionInstance3.targetState$delegate;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(376119213);
        int i5 = i | (gapComposer2.changed(state) ? 4 : 2) | (gapComposer2.changed(textFieldColors) ? 32 : 16) | (gapComposer2.changed(z) ? 256 : 128) | (gapComposer2.changed(false) ? 2048 : 1024) | (gapComposer2.changed(z2) ? 16384 : 8192) | (gapComposer2.changed(z3) ? 131072 : 65536) | (gapComposer2.changed(transitionInstance3) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288) | (gapComposer2.changed(textStyle) ? 8388608 : 4194304) | (gapComposer2.changed(textStyle2) ? 67108864 : 33554432) | (gapComposer2.changedInstance(function3) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE);
        if (gapComposer2.shouldExecute(i5 & 1, (i5 & 306783379) != 306783378)) {
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new TextFieldImplKt$DecoratedLabel$labelScope$1$1();
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            TextFieldImplKt$DecoratedLabel$labelScope$1$1 textFieldImplKt$DecoratedLabel$labelScope$1$1 = (TextFieldImplKt$DecoratedLabel$labelScope$1$1) objRememberedValue5;
            if (z) {
                j = z2 ? textFieldColors.focusedLabelColor : textFieldColors.unfocusedLabelColor;
            } else {
                j = textFieldColors.disabledLabelColor;
            }
            ColorVectorConverterKt$ColorToVector$1$1 colorVectorConverterKt$ColorToVector$1$1 = ColorVectorConverterKt$ColorToVector$1$1.INSTANCE;
            if (z3) {
                gapComposer2.startReplaceGroup(-601510006);
                long jM752getColor0d7_KjU = textStyle.m752getColor0d7_KjU();
                if (z3 && jM752getColor0d7_KjU == 16) {
                    jM752getColor0d7_KjU = j;
                }
                long jM752getColor0d7_KjU2 = textStyle2.m752getColor0d7_KjU();
                if (z3 && jM752getColor0d7_KjU2 == 16) {
                    jM752getColor0d7_KjU2 = j;
                }
                FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs = CardKt.m272valueyDoVZcs(4, gapComposer2);
                int i6 = ((i5 >> 18) & 14) | 384;
                InputPhase inputPhase2 = (InputPhase) parcelableSnapshotMutableState.getValue();
                gapComposer2.startReplaceGroup(-759924327);
                int[] iArr = TextFieldImplKt$WhenMappings.$EnumSwitchMapping$0;
                long j5 = iArr[inputPhase2.ordinal()] == 1 ? jM752getColor0d7_KjU : jM752getColor0d7_KjU2;
                gapComposer2.end(false);
                ColorSpace colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(j5);
                boolean zChanged = gapComposer2.changed(colorSpaceM483getColorSpaceimpl);
                Object objRememberedValue6 = gapComposer2.rememberedValue();
                if (zChanged || objRememberedValue6 == neverEqualPolicy) {
                    objRememberedValue6 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl), gapComposer2);
                }
                TwoWayConverterImpl twoWayConverterImpl = (TwoWayConverterImpl) objRememberedValue6;
                int i7 = (i6 & 14) | 3072;
                if (transitionInstance3.isSeeking()) {
                    i4 = i7;
                    z11 = false;
                    objM2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2, 1666827533, false, tagPayloadReader);
                } else {
                    gapComposer2.startReplaceGroup(1666573488);
                    i4 = i7;
                    boolean z14 = (((i7 & 14) ^ 6) > 4 && gapComposer2.changed(transitionInstance3)) || (i4 & 6) == 4;
                    objM2 = gapComposer2.rememberedValue();
                    if (z14 || objM2 == neverEqualPolicy) {
                        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            Object currentState = tagPayloadReader.getCurrentState();
                            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            gapComposer2.updateRememberedValue(currentState);
                            objM2 = currentState;
                        } catch (Throwable th) {
                            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            throw th;
                        }
                    }
                    z11 = false;
                    gapComposer2.end(false);
                }
                gapComposer2.startReplaceGroup(-759924327);
                Color colorM = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, z11, iArr[((InputPhase) objM2).ordinal()] == 1 ? jM752getColor0d7_KjU : jM752getColor0d7_KjU2);
                int i8 = i4 & 14;
                int i9 = i8 ^ 6;
                if (i9 <= 4 || !gapComposer2.changed(transitionInstance3)) {
                    color = colorM;
                    if ((i4 & 6) != 4) {
                        z12 = false;
                    }
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (z12 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance3, (byte) 22));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    inputPhase = (InputPhase) ((State) objRememberedValue3).getValue();
                    gapComposer2.startReplaceGroup(-759924327);
                    if (iArr[inputPhase.ordinal()] == 1) {
                        j4 = jM752getColor0d7_KjU;
                    } else {
                        j4 = jM752getColor0d7_KjU2;
                    }
                    Color colorM2 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, false, j4);
                    transitionInstance3 = transitionInstance;
                    z13 = (i9 <= 4 && gapComposer2.changed(transitionInstance3)) || (i4 & 6) == 4;
                    objRememberedValue4 = gapComposer2.rememberedValue();
                    if (z13 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance3, (byte) 23));
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    gapComposer2.startReplaceGroup(1730286052);
                    z4 = false;
                    gapComposer2.end(false);
                    i2 = 4;
                    transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionInstance3, color, colorM2, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl, gapComposer2, i8 | 196608);
                    gapComposer2.end(false);
                } else {
                    color = colorM;
                }
                z12 = true;
                objRememberedValue3 = gapComposer2.rememberedValue();
                if (z12) {
                    objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance3, (byte) 22));
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance3, (byte) 22));
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                inputPhase = (InputPhase) ((State) objRememberedValue3).getValue();
                gapComposer2.startReplaceGroup(-759924327);
                if (iArr[inputPhase.ordinal()] == 1) {
                    j4 = jM752getColor0d7_KjU;
                } else {
                    j4 = jM752getColor0d7_KjU2;
                }
                Color colorM3 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer2, false, j4);
                transitionInstance3 = transitionInstance;
                if (i9 <= 4) {
                }
                objRememberedValue4 = gapComposer2.rememberedValue();
                if (z13) {
                    objRememberedValue4 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance3, (byte) 23));
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance3, (byte) 23));
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                }
                gapComposer2.startReplaceGroup(1730286052);
                z4 = false;
                gapComposer2.end(false);
                i2 = 4;
                transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionInstance3, color, colorM3, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl, gapComposer2, i8 | 196608);
                gapComposer2.end(false);
            } else {
                z4 = false;
                i2 = 4;
                gapComposer2.startReplaceGroup(-601031335);
                gapComposer2.end(false);
                transitionAnimationStateCreateTransitionAnimation = null;
            }
            FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs2 = CardKt.m272valueyDoVZcs(i2, gapComposer2);
            int i10 = ((i5 >> 18) & 14) | 384;
            gapComposer2.startReplaceGroup(1139343725);
            gapComposer2.end(z4);
            ColorSpace colorSpaceM483getColorSpaceimpl2 = Color.m483getColorSpaceimpl(j);
            boolean zChanged2 = gapComposer2.changed(colorSpaceM483getColorSpaceimpl2);
            Object objRememberedValue7 = gapComposer2.rememberedValue();
            if (zChanged2 || objRememberedValue7 == neverEqualPolicy) {
                b = 1;
                objRememberedValue7 = IntIntPair$$ExternalSyntheticOutline0.m(colorVectorConverterKt$ColorToVector$1$1, new CallsKt$await$2$1(b, colorSpaceM483getColorSpaceimpl2), gapComposer2);
            } else {
                b = 1;
            }
            TwoWayConverterImpl twoWayConverterImpl2 = (TwoWayConverterImpl) objRememberedValue7;
            int i11 = (i10 & 14) | 3072;
            if (transitionInstance3.isSeeking()) {
                z5 = false;
                objM = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2, 1666827533, false, tagPayloadReader);
            } else {
                gapComposer2.startReplaceGroup(1666573488);
                byte b2 = ((((i11 & 14) ^ 6) <= i2 || !gapComposer2.changed(transitionInstance3)) && (i11 & 6) != i2) ? (byte) 0 : b;
                objM = gapComposer2.rememberedValue();
                if (b2 != 0 || objM == neverEqualPolicy) {
                    Snapshot currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                    Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                    Snapshot snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                    try {
                        Object currentState2 = tagPayloadReader.getCurrentState();
                        Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        gapComposer2.updateRememberedValue(currentState2);
                        objM = currentState2;
                    } catch (Throwable th2) {
                        Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        throw th2;
                    }
                }
                gapComposer2.end(false);
                z5 = false;
            }
            gapComposer2.startReplaceGroup(1139343725);
            gapComposer2.end(z5);
            Transition.TransitionAnimationState transitionAnimationState5 = transitionAnimationStateCreateTransitionAnimation;
            long j6 = j;
            Color color2 = new Color(j6);
            int i12 = i11 & 14;
            int i13 = i12 ^ 6;
            if (i13 > 4) {
                transitionInstance2 = transitionInstance;
                if (gapComposer2.changed(transitionInstance2)) {
                    i3 = i11;
                    transitionAnimationState = transitionAnimationState5;
                }
                objRememberedValue = gapComposer2.rememberedValue();
                if (z6 || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance2, (byte) 18));
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                gapComposer2.startReplaceGroup(1139343725);
                gapComposer2.end(false);
                Color color3 = new Color(j6);
                z7 = (i13 <= 4 && gapComposer2.changed(transitionInstance2)) || (i3 & 6) == 4;
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (z7 || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance2, (byte) 19));
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                gapComposer2.startReplaceGroup(-1207102280);
                gapComposer2.end(false);
                transitionAnimationState2 = transitionAnimationState;
                transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionInstance2, color2, color3, finiteAnimationSpecM272valueyDoVZcs2, twoWayConverterImpl2, gapComposer2, i12 | 196608);
                if (state != null) {
                    fFloatValue = ((Number) state.getValue()).floatValue();
                } else {
                    fFloatValue = 1.0f;
                }
                SpanStyle spanStyle = textStyle2.spanStyle;
                SpanStyle spanStyle2 = textStyle.spanStyle;
                TextForegroundStyle textForegroundStyle3 = SpanStyleKt.DefaultColorForegroundStyle;
                textForegroundStyle = spanStyle.textForegroundStyle;
                textForegroundStyle2 = spanStyle2.textForegroundStyle;
                z8 = textForegroundStyle instanceof BrushStyle;
                brushStyle = TextForegroundStyle.Unspecified.INSTANCE;
                if (!z8 || (textForegroundStyle2 instanceof BrushStyle)) {
                    gapComposer = gapComposer2;
                    if (z8 || !(textForegroundStyle2 instanceof BrushStyle)) {
                        brushStyle = (TextForegroundStyle) SpanStyleKt.lerpDiscrete(textForegroundStyle, textForegroundStyle2, fFloatValue);
                    } else {
                        BrushStyle brushStyle2 = (BrushStyle) textForegroundStyle;
                        BrushStyle brushStyle3 = (BrushStyle) textForegroundStyle2;
                        Brush brush = (Brush) SpanStyleKt.lerpDiscrete(brushStyle2.value, brushStyle3.value, fFloatValue);
                        float fLerp = LifecyclesKt.lerp(brushStyle2.alpha, brushStyle3.alpha, fFloatValue);
                        if (brush != null) {
                            if (brush instanceof SolidColor) {
                                long jM901modulateDxMtmZc = IntMath.m901modulateDxMtmZc(((SolidColor) brush).value, fLerp);
                                if (jM901modulateDxMtmZc != 16) {
                                    brushStyle = new ColorStyle(jM901modulateDxMtmZc);
                                }
                            } else {
                                if (!(brush instanceof ShaderBrush)) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return;
                                }
                                brushStyle = new BrushStyle((ShaderBrush) brush, fLerp);
                            }
                        }
                    }
                } else {
                    gapComposer = gapComposer2;
                    long jM493lerpjxsXWHM = ColorKt.m493lerpjxsXWHM(textForegroundStyle.mo768getColor0d7_KjU(), textForegroundStyle2.mo768getColor0d7_KjU(), fFloatValue);
                    if (jM493lerpjxsXWHM != 16) {
                        brushStyle = new ColorStyle(jM493lerpjxsXWHM);
                    }
                }
                TextForegroundStyle textForegroundStyle4 = brushStyle;
                FontFamily fontFamily = (FontFamily) SpanStyleKt.lerpDiscrete(spanStyle.fontFamily, spanStyle2.fontFamily, fFloatValue);
                long jM735lerpTextUnitInheritableC3pnCVY = SpanStyleKt.m735lerpTextUnitInheritableC3pnCVY(spanStyle.fontSize, spanStyle2.fontSize, fFloatValue);
                fontWeight = spanStyle.fontWeight;
                if (fontWeight == null) {
                    fontWeight = FontWeight.Normal;
                }
                fontWeight2 = spanStyle2.fontWeight;
                if (fontWeight2 == null) {
                    fontWeight2 = FontWeight.Normal;
                }
                FontWeight fontWeight3 = new FontWeight(UuidKt.coerceIn(LifecyclesKt.lerp(fFloatValue, fontWeight.weight, fontWeight2.weight), 1, CIOKt.DEFAULT_HTTP_POOL_SIZE));
                FontStyle fontStyle = (FontStyle) SpanStyleKt.lerpDiscrete(spanStyle.fontStyle, spanStyle2.fontStyle, fFloatValue);
                FontSynthesis fontSynthesis = (FontSynthesis) SpanStyleKt.lerpDiscrete(spanStyle.fontSynthesis, spanStyle2.fontSynthesis, fFloatValue);
                String str = (String) SpanStyleKt.lerpDiscrete(spanStyle.fontFeatureSettings, spanStyle2.fontFeatureSettings, fFloatValue);
                long jM735lerpTextUnitInheritableC3pnCVY2 = SpanStyleKt.m735lerpTextUnitInheritableC3pnCVY(spanStyle.letterSpacing, spanStyle2.letterSpacing, fFloatValue);
                baselineShift = spanStyle.baselineShift;
                if (baselineShift != null) {
                    f = baselineShift.multiplier;
                } else {
                    f = CropImageView.DEFAULT_ASPECT_RATIO;
                }
                baselineShift2 = spanStyle2.baselineShift;
                if (baselineShift2 != null) {
                    f2 = baselineShift2.multiplier;
                } else {
                    f2 = CropImageView.DEFAULT_ASPECT_RATIO;
                }
                float fLerp2 = LifecyclesKt.lerp(f, f2, fFloatValue);
                textGeometricTransform = spanStyle.textGeometricTransform;
                textGeometricTransform2 = TextGeometricTransform.None;
                if (textGeometricTransform == null) {
                    textGeometricTransform = textGeometricTransform2;
                }
                textGeometricTransform3 = spanStyle2.textGeometricTransform;
                if (textGeometricTransform3 != null) {
                    textGeometricTransform2 = textGeometricTransform3;
                }
                TextGeometricTransform textGeometricTransform4 = new TextGeometricTransform(LifecyclesKt.lerp(textGeometricTransform.scaleX, textGeometricTransform2.scaleX, fFloatValue), LifecyclesKt.lerp(textGeometricTransform.skewX, textGeometricTransform2.skewX, fFloatValue));
                LocaleList localeList = (LocaleList) SpanStyleKt.lerpDiscrete(spanStyle.localeList, spanStyle2.localeList, fFloatValue);
                long jM493lerpjxsXWHM2 = ColorKt.m493lerpjxsXWHM(spanStyle.background, spanStyle2.background, fFloatValue);
                TextDecoration textDecoration = (TextDecoration) SpanStyleKt.lerpDiscrete(spanStyle.textDecoration, spanStyle2.textDecoration, fFloatValue);
                shadow = spanStyle.shadow;
                shadow2 = spanStyle2.shadow;
                if (shadow != null && shadow2 == null) {
                    transitionAnimationState3 = transitionAnimationStateCreateTransitionAnimation2;
                    transitionAnimationState4 = transitionAnimationState2;
                    shadow3 = null;
                } else if (shadow == null) {
                    shadow2.getClass();
                    float f4 = shadow2.blurRadius;
                    long j7 = shadow2.offset;
                    long j8 = shadow2.color;
                    transitionAnimationState3 = transitionAnimationStateCreateTransitionAnimation2;
                    transitionAnimationState4 = transitionAnimationState2;
                    shadow3 = new Shadow(ColorKt.m493lerpjxsXWHM(ColorKt.Color(Color.m485getRedimpl(j8), Color.m484getGreenimpl(j8), Color.m482getBlueimpl(j8), CropImageView.DEFAULT_ASPECT_RATIO, Color.m483getColorSpaceimpl(j8)), j8, fFloatValue), coil3.size.SizeKt.m867lerpWko1d7g(j7, j7, fFloatValue), LifecyclesKt.lerp(f4, f4, fFloatValue));
                } else {
                    transitionAnimationState3 = transitionAnimationStateCreateTransitionAnimation2;
                    transitionAnimationState4 = transitionAnimationState2;
                    f3 = shadow.blurRadius;
                    j2 = shadow.offset;
                    j3 = shadow.color;
                    if (shadow2 == null) {
                        shadow3 = new Shadow(ColorKt.m493lerpjxsXWHM(j3, ColorKt.Color(Color.m485getRedimpl(j3), Color.m484getGreenimpl(j3), Color.m482getBlueimpl(j3), CropImageView.DEFAULT_ASPECT_RATIO, Color.m483getColorSpaceimpl(j3)), fFloatValue), coil3.size.SizeKt.m867lerpWko1d7g(j2, j2, fFloatValue), LifecyclesKt.lerp(f3, f3, fFloatValue));
                    } else {
                        shadow3 = new Shadow(ColorKt.m493lerpjxsXWHM(shadow.color, shadow2.color, fFloatValue), coil3.size.SizeKt.m867lerpWko1d7g(shadow.offset, shadow2.offset, fFloatValue), LifecyclesKt.lerp(shadow.blurRadius, shadow2.blurRadius, fFloatValue));
                    }
                }
                platformSpanStyle = spanStyle.platformStyle;
                PlatformSpanStyle platformSpanStyle3 = spanStyle2.platformStyle;
                if (platformSpanStyle == null || platformSpanStyle3 != null) {
                    if (platformSpanStyle == null) {
                        platformSpanStyle = PlatformSpanStyle.Default;
                    }
                    platformSpanStyle2 = platformSpanStyle;
                } else {
                    platformSpanStyle2 = null;
                }
                SpanStyle spanStyle3 = new SpanStyle(textForegroundStyle4, jM735lerpTextUnitInheritableC3pnCVY, fontWeight3, fontStyle, fontSynthesis, fontFamily, str, jM735lerpTextUnitInheritableC3pnCVY2, new BaselineShift(fLerp2), textGeometricTransform4, localeList, jM493lerpjxsXWHM2, textDecoration, shadow3, platformSpanStyle2, (DrawStyle) SpanStyleKt.lerpDiscrete(spanStyle.drawStyle, spanStyle2.drawStyle, fFloatValue));
                ParagraphStyle paragraphStyle = textStyle2.paragraphStyle;
                ParagraphStyle paragraphStyle2 = textStyle.paragraphStyle;
                int i14 = ParagraphStyleKt.$r8$clinit;
                int i15 = ((TextAlign) SpanStyleKt.lerpDiscrete(new TextAlign(paragraphStyle.textAlign), new TextAlign(paragraphStyle2.textAlign), fFloatValue)).value;
                int i16 = ((TextDirection) SpanStyleKt.lerpDiscrete(new TextDirection(paragraphStyle.textDirection), new TextDirection(paragraphStyle2.textDirection), fFloatValue)).value;
                long jM735lerpTextUnitInheritableC3pnCVY3 = SpanStyleKt.m735lerpTextUnitInheritableC3pnCVY(paragraphStyle.lineHeight, paragraphStyle2.lineHeight, fFloatValue);
                textIndent = paragraphStyle.textIndent;
                if (textIndent == null) {
                    textIndent = TextIndent.None;
                }
                textIndent2 = paragraphStyle2.textIndent;
                if (textIndent2 == null) {
                    textIndent2 = TextIndent.None;
                }
                TextIndent textIndent3 = new TextIndent(SpanStyleKt.m735lerpTextUnitInheritableC3pnCVY(textIndent.firstLine, textIndent2.firstLine, fFloatValue), SpanStyleKt.m735lerpTextUnitInheritableC3pnCVY(textIndent.restLine, textIndent2.restLine, fFloatValue));
                platformParagraphStyle = paragraphStyle.platformStyle;
                platformParagraphStyle2 = paragraphStyle2.platformStyle;
                if (platformParagraphStyle == null || platformParagraphStyle2 != null) {
                    platformParagraphStyle3 = PlatformParagraphStyle.Default;
                    if (platformParagraphStyle == null) {
                        platformParagraphStyle = platformParagraphStyle3;
                    }
                    z9 = platformParagraphStyle.includeFontPadding;
                    if (platformParagraphStyle2 == null) {
                        platformParagraphStyle2 = platformParagraphStyle3;
                    }
                    z10 = platformParagraphStyle2.includeFontPadding;
                    if (z9 == z10) {
                        platformParagraphStyle4 = platformParagraphStyle;
                    } else {
                        platformParagraphStyle4 = new PlatformParagraphStyle(((EmojiSupportMatch) SpanStyleKt.lerpDiscrete(new EmojiSupportMatch(platformParagraphStyle.emojiSupportMatch), new EmojiSupportMatch(platformParagraphStyle2.emojiSupportMatch), fFloatValue)).value, ((Boolean) SpanStyleKt.lerpDiscrete(Boolean.valueOf(z9), Boolean.valueOf(z10), fFloatValue)).booleanValue());
                    }
                } else {
                    platformParagraphStyle4 = null;
                }
                textStyle3 = new TextStyle(spanStyle3, new ParagraphStyle(i15, i16, jM735lerpTextUnitInheritableC3pnCVY3, textIndent3, platformParagraphStyle4, (LineHeightStyle) SpanStyleKt.lerpDiscrete(paragraphStyle.lineHeightStyle, paragraphStyle2.lineHeightStyle, fFloatValue), ((LineBreak) SpanStyleKt.lerpDiscrete(new LineBreak(paragraphStyle.lineBreak), new LineBreak(paragraphStyle2.lineBreak), fFloatValue)).mask, ((Hyphens) SpanStyleKt.lerpDiscrete(new Hyphens(paragraphStyle.hyphens), new Hyphens(paragraphStyle2.hyphens), fFloatValue)).value, (TextMotion) SpanStyleKt.lerpDiscrete(paragraphStyle.textMotion, paragraphStyle2.textMotion, fFloatValue)));
                if (z3) {
                    transitionAnimationState4.getClass();
                    textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(textStyle3, ((Color) transitionAnimationState4.value$delegate.getValue()).value, 0L, null, null, null, null, 0L, 0L, null, null, 16777214);
                } else {
                    textStyleM750copyp1EtxEg$default = textStyle3;
                }
                function4 = function3;
                gapComposer2 = gapComposer;
                m368Decoration3JVO9M(((Color) transitionAnimationState3.value$delegate.getValue()).value, textStyleM750copyp1EtxEg$default, Expect_jvmKt.rememberComposableLambda(57043598, new ButtonKt$$ExternalSyntheticLambda1(function4, textFieldImplKt$DecoratedLabel$labelScope$1$1), gapComposer2), gapComposer, 384);
            } else {
                transitionInstance2 = transitionInstance;
            }
            i3 = i11;
            transitionAnimationState = transitionAnimationState5;
            z6 = (i3 & 6) == 4;
            objRememberedValue = gapComposer2.rememberedValue();
            if (z6) {
                objRememberedValue = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance2, (byte) 18));
                gapComposer2.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance2, (byte) 18));
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            gapComposer2.startReplaceGroup(1139343725);
            gapComposer2.end(false);
            Color color4 = new Color(j6);
            if (i13 <= 4) {
            }
            objRememberedValue2 = gapComposer2.rememberedValue();
            if (z7) {
                objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance2, (byte) 19));
                gapComposer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ListItemKt$InteractiveListItem$$inlined$animateColor$1(transitionInstance2, (byte) 19));
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            gapComposer2.startReplaceGroup(-1207102280);
            gapComposer2.end(false);
            transitionAnimationState2 = transitionAnimationState;
            transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionInstance2, color2, color4, finiteAnimationSpecM272valueyDoVZcs2, twoWayConverterImpl2, gapComposer2, i12 | 196608);
            if (state != null) {
                fFloatValue = ((Number) state.getValue()).floatValue();
            } else {
                fFloatValue = 1.0f;
            }
            SpanStyle spanStyle4 = textStyle2.spanStyle;
            SpanStyle spanStyle5 = textStyle.spanStyle;
            TextForegroundStyle textForegroundStyle5 = SpanStyleKt.DefaultColorForegroundStyle;
            textForegroundStyle = spanStyle4.textForegroundStyle;
            textForegroundStyle2 = spanStyle5.textForegroundStyle;
            z8 = textForegroundStyle instanceof BrushStyle;
            brushStyle = TextForegroundStyle.Unspecified.INSTANCE;
            if (z8) {
                gapComposer = gapComposer2;
                if (z8) {
                    brushStyle = (TextForegroundStyle) SpanStyleKt.lerpDiscrete(textForegroundStyle, textForegroundStyle2, fFloatValue);
                } else {
                    brushStyle = (TextForegroundStyle) SpanStyleKt.lerpDiscrete(textForegroundStyle, textForegroundStyle2, fFloatValue);
                }
            } else {
                gapComposer = gapComposer2;
                if (z8) {
                    brushStyle = (TextForegroundStyle) SpanStyleKt.lerpDiscrete(textForegroundStyle, textForegroundStyle2, fFloatValue);
                } else {
                    brushStyle = (TextForegroundStyle) SpanStyleKt.lerpDiscrete(textForegroundStyle, textForegroundStyle2, fFloatValue);
                }
            }
            TextForegroundStyle textForegroundStyle6 = brushStyle;
            FontFamily fontFamily2 = (FontFamily) SpanStyleKt.lerpDiscrete(spanStyle4.fontFamily, spanStyle5.fontFamily, fFloatValue);
            long jM735lerpTextUnitInheritableC3pnCVY4 = SpanStyleKt.m735lerpTextUnitInheritableC3pnCVY(spanStyle4.fontSize, spanStyle5.fontSize, fFloatValue);
            fontWeight = spanStyle4.fontWeight;
            if (fontWeight == null) {
                fontWeight = FontWeight.Normal;
            }
            fontWeight2 = spanStyle5.fontWeight;
            if (fontWeight2 == null) {
                fontWeight2 = FontWeight.Normal;
            }
            FontWeight fontWeight4 = new FontWeight(UuidKt.coerceIn(LifecyclesKt.lerp(fFloatValue, fontWeight.weight, fontWeight2.weight), 1, CIOKt.DEFAULT_HTTP_POOL_SIZE));
            FontStyle fontStyle2 = (FontStyle) SpanStyleKt.lerpDiscrete(spanStyle4.fontStyle, spanStyle5.fontStyle, fFloatValue);
            FontSynthesis fontSynthesis2 = (FontSynthesis) SpanStyleKt.lerpDiscrete(spanStyle4.fontSynthesis, spanStyle5.fontSynthesis, fFloatValue);
            String str2 = (String) SpanStyleKt.lerpDiscrete(spanStyle4.fontFeatureSettings, spanStyle5.fontFeatureSettings, fFloatValue);
            long jM735lerpTextUnitInheritableC3pnCVY5 = SpanStyleKt.m735lerpTextUnitInheritableC3pnCVY(spanStyle4.letterSpacing, spanStyle5.letterSpacing, fFloatValue);
            baselineShift = spanStyle4.baselineShift;
            if (baselineShift != null) {
                f = baselineShift.multiplier;
            } else {
                f = CropImageView.DEFAULT_ASPECT_RATIO;
            }
            baselineShift2 = spanStyle5.baselineShift;
            if (baselineShift2 != null) {
                f2 = baselineShift2.multiplier;
            } else {
                f2 = CropImageView.DEFAULT_ASPECT_RATIO;
            }
            float fLerp3 = LifecyclesKt.lerp(f, f2, fFloatValue);
            textGeometricTransform = spanStyle4.textGeometricTransform;
            textGeometricTransform2 = TextGeometricTransform.None;
            if (textGeometricTransform == null) {
                textGeometricTransform = textGeometricTransform2;
            }
            textGeometricTransform3 = spanStyle5.textGeometricTransform;
            if (textGeometricTransform3 != null) {
                textGeometricTransform2 = textGeometricTransform3;
            }
            TextGeometricTransform textGeometricTransform5 = new TextGeometricTransform(LifecyclesKt.lerp(textGeometricTransform.scaleX, textGeometricTransform2.scaleX, fFloatValue), LifecyclesKt.lerp(textGeometricTransform.skewX, textGeometricTransform2.skewX, fFloatValue));
            LocaleList localeList2 = (LocaleList) SpanStyleKt.lerpDiscrete(spanStyle4.localeList, spanStyle5.localeList, fFloatValue);
            long jM493lerpjxsXWHM3 = ColorKt.m493lerpjxsXWHM(spanStyle4.background, spanStyle5.background, fFloatValue);
            TextDecoration textDecoration2 = (TextDecoration) SpanStyleKt.lerpDiscrete(spanStyle4.textDecoration, spanStyle5.textDecoration, fFloatValue);
            shadow = spanStyle4.shadow;
            shadow2 = spanStyle5.shadow;
            if (shadow != null) {
                if (shadow == null) {
                    shadow2.getClass();
                    float f5 = shadow2.blurRadius;
                    long j9 = shadow2.offset;
                    long j10 = shadow2.color;
                    transitionAnimationState3 = transitionAnimationStateCreateTransitionAnimation2;
                    transitionAnimationState4 = transitionAnimationState2;
                    shadow3 = new Shadow(ColorKt.m493lerpjxsXWHM(ColorKt.Color(Color.m485getRedimpl(j10), Color.m484getGreenimpl(j10), Color.m482getBlueimpl(j10), CropImageView.DEFAULT_ASPECT_RATIO, Color.m483getColorSpaceimpl(j10)), j10, fFloatValue), coil3.size.SizeKt.m867lerpWko1d7g(j9, j9, fFloatValue), LifecyclesKt.lerp(f5, f5, fFloatValue));
                } else {
                    transitionAnimationState3 = transitionAnimationStateCreateTransitionAnimation2;
                    transitionAnimationState4 = transitionAnimationState2;
                    f3 = shadow.blurRadius;
                    j2 = shadow.offset;
                    j3 = shadow.color;
                    if (shadow2 == null) {
                        shadow3 = new Shadow(ColorKt.m493lerpjxsXWHM(j3, ColorKt.Color(Color.m485getRedimpl(j3), Color.m484getGreenimpl(j3), Color.m482getBlueimpl(j3), CropImageView.DEFAULT_ASPECT_RATIO, Color.m483getColorSpaceimpl(j3)), fFloatValue), coil3.size.SizeKt.m867lerpWko1d7g(j2, j2, fFloatValue), LifecyclesKt.lerp(f3, f3, fFloatValue));
                    } else {
                        shadow3 = new Shadow(ColorKt.m493lerpjxsXWHM(shadow.color, shadow2.color, fFloatValue), coil3.size.SizeKt.m867lerpWko1d7g(shadow.offset, shadow2.offset, fFloatValue), LifecyclesKt.lerp(shadow.blurRadius, shadow2.blurRadius, fFloatValue));
                    }
                }
            } else if (shadow == null) {
                shadow2.getClass();
                float f6 = shadow2.blurRadius;
                long j11 = shadow2.offset;
                long j12 = shadow2.color;
                transitionAnimationState3 = transitionAnimationStateCreateTransitionAnimation2;
                transitionAnimationState4 = transitionAnimationState2;
                shadow3 = new Shadow(ColorKt.m493lerpjxsXWHM(ColorKt.Color(Color.m485getRedimpl(j12), Color.m484getGreenimpl(j12), Color.m482getBlueimpl(j12), CropImageView.DEFAULT_ASPECT_RATIO, Color.m483getColorSpaceimpl(j12)), j12, fFloatValue), coil3.size.SizeKt.m867lerpWko1d7g(j11, j11, fFloatValue), LifecyclesKt.lerp(f6, f6, fFloatValue));
            } else {
                transitionAnimationState3 = transitionAnimationStateCreateTransitionAnimation2;
                transitionAnimationState4 = transitionAnimationState2;
                f3 = shadow.blurRadius;
                j2 = shadow.offset;
                j3 = shadow.color;
                if (shadow2 == null) {
                    shadow3 = new Shadow(ColorKt.m493lerpjxsXWHM(j3, ColorKt.Color(Color.m485getRedimpl(j3), Color.m484getGreenimpl(j3), Color.m482getBlueimpl(j3), CropImageView.DEFAULT_ASPECT_RATIO, Color.m483getColorSpaceimpl(j3)), fFloatValue), coil3.size.SizeKt.m867lerpWko1d7g(j2, j2, fFloatValue), LifecyclesKt.lerp(f3, f3, fFloatValue));
                } else {
                    shadow3 = new Shadow(ColorKt.m493lerpjxsXWHM(shadow.color, shadow2.color, fFloatValue), coil3.size.SizeKt.m867lerpWko1d7g(shadow.offset, shadow2.offset, fFloatValue), LifecyclesKt.lerp(shadow.blurRadius, shadow2.blurRadius, fFloatValue));
                }
            }
            platformSpanStyle = spanStyle4.platformStyle;
            PlatformSpanStyle platformSpanStyle4 = spanStyle5.platformStyle;
            if (platformSpanStyle == null) {
                if (platformSpanStyle == null) {
                    platformSpanStyle = PlatformSpanStyle.Default;
                }
                platformSpanStyle2 = platformSpanStyle;
            } else {
                if (platformSpanStyle == null) {
                    platformSpanStyle = PlatformSpanStyle.Default;
                }
                platformSpanStyle2 = platformSpanStyle;
            }
            SpanStyle spanStyle6 = new SpanStyle(textForegroundStyle6, jM735lerpTextUnitInheritableC3pnCVY4, fontWeight4, fontStyle2, fontSynthesis2, fontFamily2, str2, jM735lerpTextUnitInheritableC3pnCVY5, new BaselineShift(fLerp3), textGeometricTransform5, localeList2, jM493lerpjxsXWHM3, textDecoration2, shadow3, platformSpanStyle2, (DrawStyle) SpanStyleKt.lerpDiscrete(spanStyle4.drawStyle, spanStyle5.drawStyle, fFloatValue));
            ParagraphStyle paragraphStyle3 = textStyle2.paragraphStyle;
            ParagraphStyle paragraphStyle4 = textStyle.paragraphStyle;
            int i17 = ParagraphStyleKt.$r8$clinit;
            int i18 = ((TextAlign) SpanStyleKt.lerpDiscrete(new TextAlign(paragraphStyle3.textAlign), new TextAlign(paragraphStyle4.textAlign), fFloatValue)).value;
            int i19 = ((TextDirection) SpanStyleKt.lerpDiscrete(new TextDirection(paragraphStyle3.textDirection), new TextDirection(paragraphStyle4.textDirection), fFloatValue)).value;
            long jM735lerpTextUnitInheritableC3pnCVY6 = SpanStyleKt.m735lerpTextUnitInheritableC3pnCVY(paragraphStyle3.lineHeight, paragraphStyle4.lineHeight, fFloatValue);
            textIndent = paragraphStyle3.textIndent;
            if (textIndent == null) {
                textIndent = TextIndent.None;
            }
            textIndent2 = paragraphStyle4.textIndent;
            if (textIndent2 == null) {
                textIndent2 = TextIndent.None;
            }
            TextIndent textIndent4 = new TextIndent(SpanStyleKt.m735lerpTextUnitInheritableC3pnCVY(textIndent.firstLine, textIndent2.firstLine, fFloatValue), SpanStyleKt.m735lerpTextUnitInheritableC3pnCVY(textIndent.restLine, textIndent2.restLine, fFloatValue));
            platformParagraphStyle = paragraphStyle3.platformStyle;
            platformParagraphStyle2 = paragraphStyle4.platformStyle;
            if (platformParagraphStyle == null) {
                platformParagraphStyle3 = PlatformParagraphStyle.Default;
                if (platformParagraphStyle == null) {
                    platformParagraphStyle = platformParagraphStyle3;
                }
                z9 = platformParagraphStyle.includeFontPadding;
                if (platformParagraphStyle2 == null) {
                    platformParagraphStyle2 = platformParagraphStyle3;
                }
                z10 = platformParagraphStyle2.includeFontPadding;
                if (z9 == z10) {
                    platformParagraphStyle4 = platformParagraphStyle;
                } else {
                    platformParagraphStyle4 = new PlatformParagraphStyle(((EmojiSupportMatch) SpanStyleKt.lerpDiscrete(new EmojiSupportMatch(platformParagraphStyle.emojiSupportMatch), new EmojiSupportMatch(platformParagraphStyle2.emojiSupportMatch), fFloatValue)).value, ((Boolean) SpanStyleKt.lerpDiscrete(Boolean.valueOf(z9), Boolean.valueOf(z10), fFloatValue)).booleanValue());
                }
            } else {
                platformParagraphStyle3 = PlatformParagraphStyle.Default;
                if (platformParagraphStyle == null) {
                    platformParagraphStyle = platformParagraphStyle3;
                }
                z9 = platformParagraphStyle.includeFontPadding;
                if (platformParagraphStyle2 == null) {
                    platformParagraphStyle2 = platformParagraphStyle3;
                }
                z10 = platformParagraphStyle2.includeFontPadding;
                if (z9 == z10) {
                    platformParagraphStyle4 = platformParagraphStyle;
                } else {
                    platformParagraphStyle4 = new PlatformParagraphStyle(((EmojiSupportMatch) SpanStyleKt.lerpDiscrete(new EmojiSupportMatch(platformParagraphStyle.emojiSupportMatch), new EmojiSupportMatch(platformParagraphStyle2.emojiSupportMatch), fFloatValue)).value, ((Boolean) SpanStyleKt.lerpDiscrete(Boolean.valueOf(z9), Boolean.valueOf(z10), fFloatValue)).booleanValue());
                }
            }
            textStyle3 = new TextStyle(spanStyle6, new ParagraphStyle(i18, i19, jM735lerpTextUnitInheritableC3pnCVY6, textIndent4, platformParagraphStyle4, (LineHeightStyle) SpanStyleKt.lerpDiscrete(paragraphStyle3.lineHeightStyle, paragraphStyle4.lineHeightStyle, fFloatValue), ((LineBreak) SpanStyleKt.lerpDiscrete(new LineBreak(paragraphStyle3.lineBreak), new LineBreak(paragraphStyle4.lineBreak), fFloatValue)).mask, ((Hyphens) SpanStyleKt.lerpDiscrete(new Hyphens(paragraphStyle3.hyphens), new Hyphens(paragraphStyle4.hyphens), fFloatValue)).value, (TextMotion) SpanStyleKt.lerpDiscrete(paragraphStyle3.textMotion, paragraphStyle4.textMotion, fFloatValue)));
            if (z3) {
                transitionAnimationState4.getClass();
                textStyleM750copyp1EtxEg$default = TextStyle.m750copyp1EtxEg$default(textStyle3, ((Color) transitionAnimationState4.value$delegate.getValue()).value, 0L, null, null, null, null, 0L, 0L, null, null, 16777214);
            } else {
                textStyleM750copyp1EtxEg$default = textStyle3;
            }
            function4 = function3;
            gapComposer2 = gapComposer;
            m368Decoration3JVO9M(((Color) transitionAnimationState3.value$delegate.getValue()).value, textStyleM750copyp1EtxEg$default, Expect_jvmKt.rememberComposableLambda(57043598, new ButtonKt$$ExternalSyntheticLambda1(function4, textFieldImplKt$DecoratedLabel$labelScope$1$1), gapComposer2), gapComposer, 384);
        } else {
            function4 = function3;
            gapComposer2.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextFieldImplKt$$ExternalSyntheticLambda1(state, textFieldColors, z, z2, z3, transitionInstance, textStyle, textStyle2, function4, i);
        }
    }

    /* JADX INFO: renamed from: Decoration-3J-VO9M, reason: not valid java name */
    public static final void m368Decoration3JVO9M(long j, TextStyle textStyle, Function2 function2, Composer composer, final int i) {
        final Function2 function3;
        final TextStyle textStyle2;
        final long j2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(396611577);
        int i2 = (gapComposer.changed(j) ? 4 : 2) | i | (gapComposer.changed(textStyle) ? 32 : 16);
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            m370ProvideContentColorTextStyle3JVO9M(j, textStyle, function2, gapComposer, i2 & 1022);
            j2 = j;
            textStyle2 = textStyle;
            function3 = function2;
        } else {
            function3 = function2;
            textStyle2 = textStyle;
            j2 = j;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    Icons$Filled.m368Decoration3JVO9M(j2, textStyle2, function3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: Decoration-Iv8Zu3U, reason: not valid java name */
    public static final void m369DecorationIv8Zu3U(long j, Function2 function2, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(590397809);
        int i2 = (gapComposer.changed(j) ? 4 : 2) | i | (gapComposer.changedInstance(function2) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            Stack.CompositionLocalProvider(Fragment$5$$ExternalSyntheticOutline0.m(j, ContentColorKt.LocalContentColor), function2, gapComposer, (i2 & 112) | 8);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ChipKt$$ExternalSyntheticLambda13(j, function2, i, (byte) 5);
        }
    }

    /* JADX WARN: Code duplicated, block: B:242:0x04d7  */
    /* JADX WARN: Code duplicated, block: B:246:0x04de  */
    /* JADX WARN: Code duplicated, block: B:249:0x0514  */
    /* JADX WARN: Code duplicated, block: B:250:0x0518  */
    public static final void InsideTextFieldLayout(Function2 function2, CharSequence charSequence, final Function2 function3, final Function3 function4, final Function2 function5, final Function2 function6, final Function2 function7, Function2 function8, final boolean z, final ScrimKt scrimKt, final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, final ComposableLambdaImpl composableLambdaImpl, Function2 function9, PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Function2 function10;
        final Function2 function11;
        CharSequence charSequence2;
        Function2 function12;
        PaddingValues paddingValues2;
        final Function2 function13;
        GapComposer gapComposer;
        Object textFieldMeasurePolicy;
        BiasAlignment biasAlignment;
        GapComposer gapComposer2;
        boolean z2;
        Function2 function14;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0;
        BiasAlignment biasAlignment2;
        Function2 function15;
        Function2 function16;
        boolean z3;
        TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3;
        boolean z4;
        Object objRememberedValue;
        byte b;
        Function2 function17 = function8;
        BiasAlignment biasAlignment3 = Alignment.Companion.Center;
        BiasAlignment biasAlignment4 = Alignment.Companion.TopStart;
        GapComposer gapComposer3 = (GapComposer) composer;
        gapComposer3.startRestartGroup(908032139);
        int i5 = i & 6;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (i5 == 0) {
            i3 = i | (gapComposer3.changed(companion) ? 4 : 2);
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer3.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer3.changedInstance(charSequence) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer3.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer3.changedInstance(function4) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= gapComposer3.changedInstance(function5) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= gapComposer3.changedInstance(function6) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer3.changedInstance(function7) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= gapComposer3.changedInstance(function17) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= gapComposer3.changed(z) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        int i6 = i3;
        if ((i2 & 6) == 0) {
            i4 = i2 | (gapComposer3.changed(scrimKt) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= (i2 & 64) == 0 ? gapComposer3.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0) : gapComposer3.changedInstance(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= (i2 & 512) == 0 ? gapComposer3.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1) : gapComposer3.changedInstance(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= (i2 & 4096) == 0 ? gapComposer3.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2) : gapComposer3.changedInstance(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImpl;
            i4 |= gapComposer3.changedInstance(composableLambdaImpl2) ? 16384 : 8192;
            function10 = composableLambdaImpl2;
        } else {
            function10 = composableLambdaImpl;
        }
        if ((i2 & 196608) == 0) {
            i4 |= gapComposer3.changedInstance(function9) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= gapComposer3.changed(paddingValues) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        int i7 = i4;
        if (gapComposer3.shouldExecute(i6 & 1, ((i6 & 306783379) == 306783378 && (599187 & i7) == 599186) ? false : true)) {
            float fMinimizedLabelHalfHeight = minimizedLabelHalfHeight(gapComposer3);
            int i8 = i7 & 112;
            boolean zChanged = ((3670016 & i7) == 1048576) | ((i6 & 1879048192) == 536870912) | ((i7 & 14) == 4) | (i8 == 32 || ((i7 & 64) != 0 && gapComposer3.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0))) | ((i7 & 896) == 256 || ((i7 & 512) != 0 && gapComposer3.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1))) | ((i7 & 7168) == 2048 || ((i7 & 4096) != 0 && gapComposer3.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2))) | gapComposer3.changed(fMinimizedLabelHalfHeight);
            Object objRememberedValue2 = gapComposer3.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                biasAlignment = biasAlignment3;
                GapComposer gapComposer4 = gapComposer3;
                paddingValues2 = paddingValues;
                textFieldMeasurePolicy = new TextFieldMeasurePolicy(z, scrimKt, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, paddingValues2, fMinimizedLabelHalfHeight);
                gapComposer4.updateRememberedValue(textFieldMeasurePolicy);
                gapComposer2 = gapComposer4;
            } else {
                textFieldMeasurePolicy = objRememberedValue2;
                gapComposer2 = gapComposer3;
                biasAlignment = biasAlignment3;
                paddingValues2 = paddingValues;
            }
            TextFieldMeasurePolicy textFieldMeasurePolicy2 = (TextFieldMeasurePolicy) textFieldMeasurePolicy;
            LayoutDirection layoutDirection = (LayoutDirection) gapComposer2.consume(CompositionLocalsKt.LocalLayoutDirection);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, companion);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            boolean z5 = gapComposer2.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z5) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer2, textFieldMeasurePolicy2, updater$$ExternalSyntheticLambda1);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda3);
            Stack.m389reconcileimpl(gapComposer2);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda4);
            function10.invoke(gapComposer2, Integer.valueOf((i7 >> 12) & 14));
            MinimumInteractiveModifier minimumInteractiveModifier = MinimumInteractiveModifier.INSTANCE;
            if (function5 != null) {
                gapComposer2.startReplaceGroup(-556998400);
                Modifier modifierLayoutId = RulerKt.layoutId(companion, "Leading");
                HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
                Modifier modifierThen = modifierLayoutId.then(minimumInteractiveModifier);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierThen);
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda1);
                Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda3, gapComposer2);
                Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda4);
                function5.invoke(gapComposer2, Integer.valueOf((i6 >> 15) & 14));
                gapComposer2.end(true);
                z2 = false;
                gapComposer2.end(false);
            } else {
                z2 = false;
                gapComposer2.startReplaceGroup(-556752384);
                gapComposer2.end(false);
            }
            if (function6 != null) {
                gapComposer2.startReplaceGroup(-556709666);
                Modifier modifierLayoutId2 = RulerKt.layoutId(companion, "Trailing");
                HorizontalAlignmentLine horizontalAlignmentLine2 = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
                Modifier modifierThen2 = modifierLayoutId2.then(minimumInteractiveModifier);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, z2);
                int iHashCode3 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierThen2);
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda1);
                Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer2, updater$$ExternalSyntheticLambda3, gapComposer2);
                Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda4);
                Function2 function18 = function6;
                function18.invoke(gapComposer2, Integer.valueOf((i6 >> 18) & 14));
                gapComposer2.end(true);
                gapComposer2.end(false);
                function14 = function18;
            } else {
                function14 = function6;
                gapComposer2.startReplaceGroup(-556461728);
                gapComposer2.end(z2);
            }
            float fCalculateStartPadding = OffsetKt.calculateStartPadding(paddingValues2, layoutDirection);
            float fCalculateEndPadding = OffsetKt.calculateEndPadding(paddingValues2, layoutDirection);
            float fTextFieldHorizontalIconPadding = textFieldHorizontalIconPadding(gapComposer2);
            if (function5 != null) {
                fCalculateStartPadding = (fCalculateStartPadding - fTextFieldHorizontalIconPadding) + CropImageView.DEFAULT_ASPECT_RATIO;
                if (fCalculateStartPadding < CropImageView.DEFAULT_ASPECT_RATIO) {
                    fCalculateStartPadding = 0.0f;
                }
            }
            float f = fCalculateStartPadding;
            if (function14 != null) {
                fCalculateEndPadding = (fCalculateEndPadding - fTextFieldHorizontalIconPadding) + CropImageView.DEFAULT_ASPECT_RATIO;
                if (fCalculateEndPadding < CropImageView.DEFAULT_ASPECT_RATIO) {
                    fCalculateEndPadding = 0.0f;
                }
            }
            float f2 = fCalculateEndPadding;
            if (function7 != null) {
                gapComposer2.startReplaceGroup(-555685333);
                Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m147heightInVpY3zN4$default(RulerKt.layoutId(companion, "Prefix"), 24.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2)), f, CropImageView.DEFAULT_ASPECT_RATIO, 2.0f, CropImageView.DEFAULT_ASPECT_RATIO, 10);
                biasAlignment2 = biasAlignment4;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
                updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda3;
                int iHashCode4 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM139paddingqDBjuR0$default);
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy3, updater$$ExternalSyntheticLambda1);
                Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer2, updater$$ExternalSyntheticLambda0, gapComposer2);
                Stack.m390setimpl(gapComposer2, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda4);
                function7.invoke(gapComposer2, Integer.valueOf((i6 >> 21) & 14));
                gapComposer2.end(true);
                gapComposer2.end(false);
            } else {
                updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda3;
                biasAlignment2 = r17;
                gapComposer2.startReplaceGroup(-555357632);
                gapComposer2.end(false);
            }
            if (function8 != null) {
                gapComposer2.startReplaceGroup(-555314387);
                Modifier modifierM139paddingqDBjuR0$default2 = OffsetKt.m139paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m147heightInVpY3zN4$default(RulerKt.layoutId(companion, "Suffix"), 24.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2)), 2.0f, CropImageView.DEFAULT_ASPECT_RATIO, f2, CropImageView.DEFAULT_ASPECT_RATIO, 10);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
                int iHashCode5 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM139paddingqDBjuR0$default2);
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy4, updater$$ExternalSyntheticLambda1);
                Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer2, updater$$ExternalSyntheticLambda0, gapComposer2);
                Stack.m390setimpl(gapComposer2, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda4);
                Function2 function19 = function8;
                function19.invoke(gapComposer2, Integer.valueOf((i6 >> 24) & 14));
                gapComposer2.end(true);
                gapComposer2.end(false);
                function15 = function19;
            } else {
                function15 = function8;
                gapComposer2.startReplaceGroup(-554988608);
                gapComposer2.end(false);
            }
            Modifier modifierM139paddingqDBjuR0$default3 = OffsetKt.m139paddingqDBjuR0$default(companion, f, CropImageView.DEFAULT_ASPECT_RATIO, f2, CropImageView.DEFAULT_ASPECT_RATIO, 10);
            if (function3 != null) {
                gapComposer2.startReplaceGroup(-554488733);
                Modifier modifierLayoutId3 = RulerKt.layoutId(companion, "Label");
                if (i8 != 32) {
                    if ((i7 & 64) != 0) {
                        textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
                        if (gapComposer2.changedInstance(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3)) {
                        }
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (!z4 || objRememberedValue == neverEqualPolicy) {
                            b = 1;
                            objRememberedValue = new TextFieldImplKt$$ExternalSyntheticLambda15(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, b);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        } else {
                            b = 1;
                        }
                        Modifier modifierThen3 = SizeKt.wrapContentHeight$default(RulerKt.layout(modifierLayoutId3, new PlayerMenuKt$$ExternalSyntheticLambda49((Function0) objRememberedValue, b))).then(modifierM139paddingqDBjuR0$default3);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
                        int iHashCode6 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierThen3);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy5, updater$$ExternalSyntheticLambda1);
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda2);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode6, gapComposer2, updater$$ExternalSyntheticLambda0, gapComposer2);
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda4);
                        function3.invoke(gapComposer2, Integer.valueOf((i6 >> 9) & 14));
                        gapComposer2.end(true);
                        gapComposer2.end(false);
                    } else {
                        textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
                    }
                    z4 = false;
                    objRememberedValue = gapComposer2.rememberedValue();
                    if (z4) {
                        b = 1;
                        objRememberedValue = new TextFieldImplKt$$ExternalSyntheticLambda15(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, b);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    } else {
                        b = 1;
                        objRememberedValue = new TextFieldImplKt$$ExternalSyntheticLambda15(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, b);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierThen4 = SizeKt.wrapContentHeight$default(RulerKt.layout(modifierLayoutId3, new PlayerMenuKt$$ExternalSyntheticLambda49((Function0) objRememberedValue, b))).then(modifierM139paddingqDBjuR0$default3);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
                    int iHashCode7 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope7 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier7 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierThen4);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy6, updater$$ExternalSyntheticLambda1);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope7, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode7, gapComposer2, updater$$ExternalSyntheticLambda0, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier7, updater$$ExternalSyntheticLambda4);
                    function3.invoke(gapComposer2, Integer.valueOf((i6 >> 9) & 14));
                    gapComposer2.end(true);
                    gapComposer2.end(false);
                } else {
                    textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
                }
                z4 = true;
                objRememberedValue = gapComposer2.rememberedValue();
                if (z4) {
                    b = 1;
                    objRememberedValue = new TextFieldImplKt$$ExternalSyntheticLambda15(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, b);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                } else {
                    b = 1;
                    objRememberedValue = new TextFieldImplKt$$ExternalSyntheticLambda15(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, b);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierThen5 = SizeKt.wrapContentHeight$default(RulerKt.layout(modifierLayoutId3, new PlayerMenuKt$$ExternalSyntheticLambda49((Function0) objRememberedValue, b))).then(modifierM139paddingqDBjuR0$default3);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
                int iHashCode8 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope8 = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier8 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierThen5);
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy7, updater$$ExternalSyntheticLambda1);
                Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope8, updater$$ExternalSyntheticLambda2);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode8, gapComposer2, updater$$ExternalSyntheticLambda0, gapComposer2);
                Stack.m390setimpl(gapComposer2, modifierMaterializeModifier8, updater$$ExternalSyntheticLambda4);
                function3.invoke(gapComposer2, Integer.valueOf((i6 >> 9) & 14));
                gapComposer2.end(true);
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(-554091840);
                gapComposer2.end(false);
            }
            Modifier modifierM139paddingqDBjuR0$default4 = OffsetKt.m139paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m147heightInVpY3zN4$default(companion, 24.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2)), function7 == null ? f : CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, function15 == null ? f2 : CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 10);
            if (function4 != null) {
                gapComposer2.startReplaceGroup(-553721855);
                function4.invoke(RulerKt.layoutId(companion, "Hint").then(modifierM139paddingqDBjuR0$default4), gapComposer2, Integer.valueOf((i6 >> 9) & 112));
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(-553630560);
                gapComposer2.end(false);
            }
            charSequence2 = charSequence;
            Modifier modifierThen6 = visualTextSemantics(RulerKt.layoutId(companion, "TextField"), charSequence2, (function7 == null && function15 == null) ? false : true).then(modifierM139paddingqDBjuR0$default4);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, true);
            int iHashCode9 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope9 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier9 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierThen6);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy8, updater$$ExternalSyntheticLambda1);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope9, updater$$ExternalSyntheticLambda2);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode9, gapComposer2, updater$$ExternalSyntheticLambda0, gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier9, updater$$ExternalSyntheticLambda4);
            Function2 function20 = function2;
            function20.invoke(gapComposer2, Integer.valueOf((i6 >> 3) & 14));
            gapComposer2.end(true);
            if (function9 != null) {
                gapComposer2.startReplaceGroup(-553246997);
                Modifier modifierPadding = OffsetKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m147heightInVpY3zN4$default(RulerKt.layoutId(companion, "Supporting"), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2)), new PaddingValuesImpl(16.0f, 4.0f, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
                int iHashCode10 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope10 = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier10 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierPadding);
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy9, updater$$ExternalSyntheticLambda1);
                Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope10, updater$$ExternalSyntheticLambda2);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode10, gapComposer2, updater$$ExternalSyntheticLambda0, gapComposer2);
                Stack.m390setimpl(gapComposer2, modifierMaterializeModifier10, updater$$ExternalSyntheticLambda4);
                Function2 function21 = function9;
                function21.invoke(gapComposer2, Integer.valueOf((i7 >> 15) & 14));
                z3 = true;
                gapComposer2.end(true);
                gapComposer2.end(false);
                function16 = function21;
            } else {
                function16 = function9;
                z3 = true;
                gapComposer2.startReplaceGroup(-552857792);
                gapComposer2.end(false);
            }
            gapComposer2.end(z3);
            function11 = function20;
            gapComposer = gapComposer2;
            function13 = function15;
            function12 = function16;
        } else {
            function11 = function2;
            charSequence2 = charSequence;
            function12 = function9;
            GapComposer gapComposer5 = gapComposer3;
            paddingValues2 = paddingValues;
            gapComposer5.skipToGroupEnd();
            gapComposer = gapComposer5;
            function13 = function17;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final CharSequence charSequence3 = charSequence2;
            final PaddingValues paddingValues3 = paddingValues2;
            final Function2 function22 = function12;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    Icons$Filled.InsideTextFieldLayout(function11, charSequence3, function3, function4, function5, function6, function7, function13, z, scrimKt, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, composableLambdaImpl, function22, paddingValues3, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void ObserveState(LifecycleOwner lifecycleOwner, Function1 function1, Function0 function0, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1868327245);
        byte b = 16;
        int i2 = (gapComposer.changedInstance(lifecycleOwner) ? 4 : 2) | i | (gapComposer.changedInstance(function1) ? 32 : 16) | (gapComposer.changedInstance(function0) ? 256 : 128);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            boolean zChangedInstance = ((i2 & 112) == 32) | gapComposer.changedInstance(lifecycleOwner) | ((i2 & 896) == 256);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new UtilsKt$$ExternalSyntheticLambda0(lifecycleOwner, function1, function0, b);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Stack.DisposableEffect(lifecycleOwner, (Function1) objRememberedValue, gapComposer);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda9((byte) 10, i, lifecycleOwner, function1, function0);
        }
    }

    public static final void PredictiveBackHandler(boolean z, Function2 function2, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1437916225);
        int i2 = (gapComposer.changed(z) ? 4 : 2) | i | (gapComposer.changedInstance(function2) ? 32 : 16);
        byte b = 1;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            SQLite.PredictiveBackHandler(z, function2, gapComposer, i2 & 126, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new HttpRequestRetryConfig$$ExternalSyntheticLambda5(z, function2, i, b);
        }
    }

    /* JADX INFO: renamed from: ProvideContentColorTextStyle-3J-VO9M, reason: not valid java name */
    public static final void m370ProvideContentColorTextStyle3JVO9M(final long j, final TextStyle textStyle, final Function2 function2, Composer composer, final int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-684938728);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(textStyle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = TextKt.LocalTextStyle;
            Stack.CompositionLocalProvider(new ProvidedValue[]{Fragment$5$$ExternalSyntheticOutline0.m(j, ContentColorKt.LocalContentColor), staticProvidableCompositionLocal.defaultProvidedValue$runtime(((TextStyle) gapComposer.consume(staticProvidableCompositionLocal)).merge(textStyle))}, function2, gapComposer, ((i2 >> 3) & 112) | 8);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.internal.ProvideContentColorTextStyleKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).intValue();
                    Icons$Filled.m370ProvideContentColorTextStyle3JVO9M(j, textStyle, function2, (Composer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: ProvideContentColorTextStyle-KTwxG1Y, reason: not valid java name */
    public static final void m371ProvideContentColorTextStyleKTwxG1Y(final long j, final TextStyle textStyle, final ProvidedValue[] providedValueArr, final Function2 function2, Composer composer, final int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1730739611);
        int i2 = ((i & 6) == 0 ? (gapComposer.changed(j) ? 4 : 2) | i : i) | (gapComposer.changed(textStyle) ? 32 : 16) | (gapComposer.changedInstance(function2) ? 2048 : 1024);
        gapComposer.startMovableGroup(-1088419735, Integer.valueOf(providedValueArr.length));
        int i3 = i2 | (gapComposer.changed(providedValueArr.length) ? 256 : 0);
        for (ProvidedValue providedValue : providedValueArr) {
            i3 |= gapComposer.changedInstance(providedValue) ? 256 : 0;
        }
        gapComposer.end(false);
        if ((i3 & 896) == 0) {
            i3 |= 128;
        }
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 1171) != 1170)) {
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = TextKt.LocalTextStyle;
            TextStyle textStyleMerge = ((TextStyle) gapComposer.consume(staticProvidableCompositionLocal)).merge(textStyle);
            Headers.Builder builder = new Headers.Builder(3);
            builder.add(ContentColorKt.LocalContentColor.defaultProvidedValue$runtime(new Color(j)));
            builder.add(staticProvidableCompositionLocal.defaultProvidedValue$runtime(textStyleMerge));
            builder.addSpread(providedValueArr);
            ArrayList arrayList = builder.namesAndValues;
            Stack.CompositionLocalProvider((ProvidedValue[]) arrayList.toArray(new ProvidedValue[arrayList.size()]), function2, gapComposer, ((i3 >> 6) & 112) | 8);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.internal.ProvideContentColorTextStyleKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    Icons$Filled.m371ProvideContentColorTextStyleKTwxG1Y(j, textStyle, providedValueArr, function2, (Composer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void TooltipPopup(PopupPositionProvider popupPositionProvider, TooltipStateImpl tooltipStateImpl, CoroutineScope coroutineScope, boolean z, MutableState mutableState, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        PopupPositionProvider popupPositionProvider2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1413720282);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(popupPositionProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? gapComposer.changed(tooltipStateImpl) : gapComposer.changedInstance(tooltipStateImpl) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(null) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changedInstance(coroutineScope) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changed(mutableState) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if (gapComposer.shouldExecute(i2 & 1, (599187 & i2) != 599186)) {
            String strStringResource = MathKt.stringResource(R.string.tooltip_description, gapComposer);
            boolean zChangedInstance = ((i2 & 112) == 32 || ((i2 & 64) != 0 && gapComposer.changedInstance(tooltipStateImpl))) | ((i2 & 896) == 256) | gapComposer.changedInstance(coroutineScope) | ((458752 & i2) == 131072);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new GapComposer$$ExternalSyntheticLambda0(tooltipStateImpl, coroutineScope, mutableState, (byte) 7);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            popupPositionProvider2 = popupPositionProvider;
            AndroidPopup_androidKt.Popup(popupPositionProvider2, (Function0) objRememberedValue, new PopupProperties(z, 22), Expect_jvmKt.rememberComposableLambda(-1287705660, new ButtonKt$$ExternalSyntheticLambda1(strStringResource, composableLambdaImpl, (byte) 24), gapComposer), gapComposer, (i2 & 14) | 3072, 0);
        } else {
            popupPositionProvider2 = popupPositionProvider;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new IconButtonKt$$ExternalSyntheticLambda8(popupPositionProvider2, tooltipStateImpl, coroutineScope, z, mutableState, composableLambdaImpl, i);
        }
    }

    public static final void WrappedAnchor(final TooltipStateImpl tooltipStateImpl, MutableState mutableState, Modifier modifier, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1873232064);
        final byte b = 1;
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(true) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? gapComposer.changed(tooltipStateImpl) : gapComposer.changedInstance(tooltipStateImpl) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(mutableState) ? 256 : 128;
        }
        final byte b2 = 0;
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(false) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(modifier) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 131072 : 65536;
        }
        if (gapComposer.shouldExecute(i2 & 1, (74899 & i2) != 74898)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            String strStringResource = MathKt.stringResource(R.string.tooltip_label, gapComposer);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            Modifier modifierOnPreviewKeyEvent = Key.onPreviewKeyEvent(FocusTraversalKt.onFocusChanged(SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(modifier, tooltipStateImpl, new PointerInputEventHandler() { // from class: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1

                /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                public final class AnonymousClass1 extends SuspendLambda implements Function2 {
                    public final /* synthetic */ byte $r8$classId;
                    public final /* synthetic */ TooltipStateImpl $state;
                    public final /* synthetic */ PointerInputScope $this_pointerInput;
                    public /* synthetic */ Object L$0;
                    public boolean label;

                    /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    public final class C00001 extends RestrictedSuspendLambda implements Function2 {
                        public final /* synthetic */ CoroutineScope $$this$coroutineScope;
                        public final /* synthetic */ TooltipStateImpl $state;
                        public long J$0;
                        public /* synthetic */ Object L$0;
                        public MutableStateFlow L$1;
                        public PointerEventPass L$2;
                        public byte label;

                        /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$1, reason: invalid class name and collision with other inner class name */
                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        public final class C00011 extends RestrictedSuspendLambda implements Function2 {
                            public final /* synthetic */ Object $pass;
                            public final /* synthetic */ byte $r8$classId;
                            public /* synthetic */ Object L$0;
                            public boolean label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public /* synthetic */ C00011(Object obj, Continuation continuation, byte b) {
                                super(2, continuation);
                                this.$r8$classId = b;
                                this.$pass = obj;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation create(Object obj, Continuation continuation) {
                                byte b = this.$r8$classId;
                                Object obj2 = this.$pass;
                                switch (b) {
                                    case 0:
                                        C00011 c00011 = new C00011((PointerEventPass) obj2, continuation, (byte) 0);
                                        c00011.L$0 = obj;
                                        return c00011;
                                    case 1:
                                        C00011 c00012 = new C00011((CoreTextFieldKt$$ExternalSyntheticLambda1) obj2, continuation, (byte) 1);
                                        c00012.L$0 = obj;
                                        return c00012;
                                    default:
                                        C00011 c00013 = new C00011((MutableState) obj2, continuation, (byte) 2);
                                        c00013.L$0 = obj;
                                        return c00013;
                                }
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                byte b = this.$r8$classId;
                                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                Unit unit = Unit.INSTANCE;
                                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj;
                                Continuation continuation = (Continuation) obj2;
                                switch (b) {
                                    case 0:
                                        return ((C00011) create(pointerEventHandlerCoroutine, continuation)).invokeSuspend(unit);
                                    case 1:
                                        ((C00011) create(pointerEventHandlerCoroutine, continuation)).invokeSuspend(unit);
                                        return coroutineSingletons;
                                    default:
                                        ((C00011) create(pointerEventHandlerCoroutine, continuation)).invokeSuspend(unit);
                                        return coroutineSingletons;
                                }
                            }

                            /* JADX WARN: Code duplicated, block: B:39:? A[RETURN, SYNTHETIC] */
                            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002d -> B:13:0x0030). Please report as a decompilation issue!!! */
                            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0073 -> B:28:0x0076). Please report as a decompilation issue!!! */
                            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:19:0x004e
                                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                                */
                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                                /*
                                    r8 = this;
                                    byte r0 = r8.$r8$classId
                                    java.lang.Object r1 = r8.$pass
                                    java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                                    kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                                    r4 = 1
                                    r5 = 0
                                    switch(r0) {
                                        case 0: goto L88;
                                        case 1: goto L4e;
                                        default: goto Ld;
                                    }
                                Ld:
                                    java.lang.Object r0 = r8.L$0
                                    androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r0
                                    boolean r6 = r8.label
                                    if (r6 == 0) goto L20
                                    if (r6 != r4) goto L1b
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    goto L30
                                L1b:
                                    okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r2)
                                    r3 = r5
                                    goto L2f
                                L20:
                                    kotlin.ResultKt.throwOnFailure(r9)
                                L23:
                                    r8.L$0 = r0
                                    r8.label = r4
                                    androidx.compose.ui.input.pointer.PointerEventPass r9 = androidx.compose.ui.input.pointer.PointerEventPass.Main
                                    java.lang.Object r9 = r0.awaitPointerEvent(r9, r8)
                                    if (r9 != r3) goto L30
                                L2f:
                                    return r3
                                L30:
                                    androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
                                    java.util.List r9 = r9.changes
                                    java.lang.Object r9 = kotlin.collections.CollectionsKt.firstOrNull(r9)
                                    androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
                                    if (r9 == 0) goto L44
                                    long r6 = r9.position
                                    androidx.compose.ui.geometry.Offset r9 = new androidx.compose.ui.geometry.Offset
                                    r9.<init>(r6)
                                    goto L45
                                L44:
                                    r9 = r5
                                L45:
                                    if (r9 == 0) goto L23
                                    r2 = r1
                                    androidx.compose.runtime.MutableState r2 = (androidx.compose.runtime.MutableState) r2
                                    r2.setValue(r9)
                                    goto L23
                                L4e:
                                    boolean r0 = r8.label
                                    if (r0 == 0) goto L61
                                    if (r0 != r4) goto L5c
                                    java.lang.Object r0 = r8.L$0
                                    androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r0
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    goto L76
                                L5c:
                                    okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r2)
                                    r3 = r5
                                    goto L75
                                L61:
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    java.lang.Object r9 = r8.L$0
                                    androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r9 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r9
                                    r0 = r9
                                L69:
                                    r8.L$0 = r0
                                    r8.label = r4
                                    androidx.compose.ui.input.pointer.PointerEventPass r9 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                                    java.lang.Object r9 = r0.awaitPointerEvent(r9, r8)
                                    if (r9 != r3) goto L76
                                L75:
                                    return r3
                                L76:
                                    androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
                                    r2 = r1
                                    androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1 r2 = (androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1) r2
                                    boolean r9 = androidx.compose.foundation.text.selection.SelectionGestures_androidKt.isMouseOrTouchPad(r9)
                                    r9 = r9 ^ r4
                                    java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
                                    r2.invoke(r9)
                                    goto L69
                                L88:
                                    boolean r0 = r8.label
                                    if (r0 == 0) goto L97
                                    if (r0 != r4) goto L92
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    goto La9
                                L92:
                                    okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r2)
                                    r9 = r5
                                    goto La9
                                L97:
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    java.lang.Object r9 = r8.L$0
                                    androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r9 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r9
                                    androidx.compose.ui.input.pointer.PointerEventPass r1 = (androidx.compose.ui.input.pointer.PointerEventPass) r1
                                    r8.label = r4
                                    java.lang.Object r9 = androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(r9, r1, r8)
                                    if (r9 != r3) goto La9
                                    r9 = r3
                                La9:
                                    return r9
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1.AnonymousClass1.C00001.C00011.invokeSuspend(java.lang.Object):java.lang.Object");
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C00001(CoroutineScope coroutineScope, TooltipStateImpl tooltipStateImpl, Continuation continuation) {
                            super(2, continuation);
                            this.$$this$coroutineScope = coroutineScope;
                            this.$state = tooltipStateImpl;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            C00001 c00001 = new C00001(this.$$this$coroutineScope, this.$state, continuation);
                            c00001.L$0 = obj;
                            return c00001;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ((C00001) create((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Code duplicated, block: B:40:0x00c2  */
                        /* JADX WARN: Code duplicated, block: B:43:0x00c7 A[Catch: all -> 0x0019, TRY_LEAVE, TryCatch #3 {all -> 0x0019, blocks: (B:8:0x0014, B:41:0x00c3, B:43:0x00c7), top: B:55:0x0014 }] */
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v0, types: [byte] */
                        /* JADX WARN: Type inference failed for: r0v1 */
                        /* JADX WARN: Type inference failed for: r0v14 */
                        /* JADX WARN: Type inference failed for: r0v15 */
                        /* JADX WARN: Type inference failed for: r0v16 */
                        /* JADX WARN: Type inference failed for: r0v17 */
                        /* JADX WARN: Type inference failed for: r0v8 */
                        /* JADX WARN: Type inference failed for: r0v9 */
                        /* JADX WARN: Type inference failed for: r13v1 */
                        /* JADX WARN: Type inference failed for: r13v11 */
                        /* JADX WARN: Type inference failed for: r13v13 */
                        /* JADX WARN: Type inference failed for: r13v16, types: [kotlinx.coroutines.flow.MutableStateFlow] */
                        /* JADX WARN: Type inference failed for: r13v17 */
                        /* JADX WARN: Type inference failed for: r13v2 */
                        /* JADX WARN: Type inference failed for: r13v7 */
                        /* JADX WARN: Type inference failed for: r13v9 */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            ?? r13;
                            long j;
                            SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine;
                            PointerEventPass pointerEventPass;
                            MutableStateFlow mutableStateFlow;
                            MutableStateFlow mutableStateFlow2;
                            Object obj2;
                            ?? r0;
                            PointerInputChange pointerInputChange;
                            ?? r1 = this.label;
                            Continuation continuation = null;
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            try {
                                if (r1 == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine2 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                                    StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
                                    long longPressTimeoutMillis = pointerEventHandlerCoroutine2.getViewConfiguration().getLongPressTimeoutMillis();
                                    this.L$0 = pointerEventHandlerCoroutine2;
                                    this.L$1 = stateFlowImplMutableStateFlow;
                                    PointerEventPass pointerEventPass2 = PointerEventPass.Initial;
                                    this.L$2 = pointerEventPass2;
                                    this.J$0 = longPressTimeoutMillis;
                                    this.label = (byte) 1;
                                    Object objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(pointerEventHandlerCoroutine2, this, 1);
                                    if (objAwaitFirstDown$default != coroutineSingletons) {
                                        j = longPressTimeoutMillis;
                                        pointerEventHandlerCoroutine = pointerEventHandlerCoroutine2;
                                        obj = objAwaitFirstDown$default;
                                        mutableStateFlow = stateFlowImplMutableStateFlow;
                                        pointerEventPass = pointerEventPass2;
                                    }
                                    return coroutineSingletons;
                                }
                                if (r1 != 1) {
                                    if (r1 != 2) {
                                        if (r1 != 3) {
                                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                            return null;
                                        }
                                        r13 = (MutableStateFlow) this.L$0;
                                        try {
                                            ResultKt.throwOnFailure(obj);
                                            r0 = r1;
                                            r13 = r13;
                                            pointerInputChange = (PointerInputChange) obj;
                                            if (pointerInputChange != null) {
                                                pointerInputChange.consume();
                                            }
                                            Boolean bool = Boolean.FALSE;
                                            StateFlowImpl stateFlowImpl = (StateFlowImpl) r13;
                                            stateFlowImpl.getClass();
                                            stateFlowImpl.updateState(null, bool);
                                            r1 = r0;
                                            return Unit.INSTANCE;
                                        } catch (Throwable th) {
                                            th = th;
                                            Boolean bool2 = Boolean.FALSE;
                                            StateFlowImpl stateFlowImpl2 = (StateFlowImpl) r13;
                                            stateFlowImpl2.getClass();
                                            stateFlowImpl2.updateState(null, bool2);
                                            throw th;
                                        }
                                    }
                                    PointerEventPass pointerEventPass3 = this.L$2;
                                    MutableStateFlow mutableStateFlow3 = this.L$1;
                                    pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                                    try {
                                        ResultKt.throwOnFailure(obj);
                                        obj2 = pointerEventPass3;
                                        mutableStateFlow2 = mutableStateFlow3;
                                        Boolean bool3 = Boolean.FALSE;
                                        StateFlowImpl stateFlowImpl3 = (StateFlowImpl) mutableStateFlow2;
                                        stateFlowImpl3.getClass();
                                        stateFlowImpl3.updateState(null, bool3);
                                        r1 = obj2;
                                    } catch (PointerEventTimeoutCancellationException unused) {
                                        pointerEventPass = pointerEventPass3;
                                        mutableStateFlow = mutableStateFlow3;
                                        AwaitKt.launch$default(this.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AsyncImagePainter.AnonymousClass1(mutableStateFlow, this.$state, continuation, (byte) 6), 1);
                                        this.L$0 = mutableStateFlow;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.label = (byte) 3;
                                        obj = TapGestureDetectorKt.waitForUpOrCancellation(pointerEventHandlerCoroutine, pointerEventPass, this);
                                        if (obj != coroutineSingletons) {
                                            r13 = mutableStateFlow;
                                            r0 = mutableStateFlow;
                                            pointerInputChange = (PointerInputChange) obj;
                                            if (pointerInputChange != null) {
                                                pointerInputChange.consume();
                                            }
                                            Boolean bool4 = Boolean.FALSE;
                                            StateFlowImpl stateFlowImpl4 = (StateFlowImpl) r13;
                                            stateFlowImpl4.getClass();
                                            stateFlowImpl4.updateState(null, bool4);
                                            r1 = r0;
                                        }
                                        return coroutineSingletons;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        r13 = mutableStateFlow3;
                                        Boolean bool5 = Boolean.FALSE;
                                        StateFlowImpl stateFlowImpl5 = (StateFlowImpl) r13;
                                        stateFlowImpl5.getClass();
                                        stateFlowImpl5.updateState(null, bool5);
                                        throw th;
                                    }
                                    return Unit.INSTANCE;
                                }
                                long j2 = this.J$0;
                                PointerEventPass pointerEventPass4 = this.L$2;
                                MutableStateFlow mutableStateFlow4 = this.L$1;
                                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine3 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                pointerEventPass = pointerEventPass4;
                                mutableStateFlow = mutableStateFlow4;
                                j = j2;
                                pointerEventHandlerCoroutine = pointerEventHandlerCoroutine3;
                                long j3 = j;
                                int i = ((PointerInputChange) obj).type;
                                if (i == 1 || i == 3) {
                                    try {
                                        C00011 c00011 = new C00011(pointerEventPass, continuation, (byte) 0);
                                        this.L$0 = pointerEventHandlerCoroutine;
                                        this.L$1 = mutableStateFlow;
                                        this.L$2 = pointerEventPass;
                                        this.label = (byte) 2;
                                        if (pointerEventHandlerCoroutine.withTimeout(j3, c00011, this) != coroutineSingletons) {
                                            mutableStateFlow2 = mutableStateFlow;
                                            obj2 = mutableStateFlow;
                                            Boolean bool6 = Boolean.FALSE;
                                            StateFlowImpl stateFlowImpl6 = (StateFlowImpl) mutableStateFlow2;
                                            stateFlowImpl6.getClass();
                                            stateFlowImpl6.updateState(null, bool6);
                                            r1 = obj2;
                                        }
                                    } catch (PointerEventTimeoutCancellationException unused2) {
                                        AwaitKt.launch$default(this.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AsyncImagePainter.AnonymousClass1(mutableStateFlow, this.$state, continuation, (byte) 6), 1);
                                        this.L$0 = mutableStateFlow;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.label = (byte) 3;
                                        obj = TapGestureDetectorKt.waitForUpOrCancellation(pointerEventHandlerCoroutine, pointerEventPass, this);
                                        if (obj != coroutineSingletons) {
                                            r13 = mutableStateFlow;
                                            r0 = mutableStateFlow;
                                            pointerInputChange = (PointerInputChange) obj;
                                            if (pointerInputChange != null) {
                                                pointerInputChange.consume();
                                            }
                                            Boolean bool7 = Boolean.FALSE;
                                            StateFlowImpl stateFlowImpl7 = (StateFlowImpl) r13;
                                            stateFlowImpl7.getClass();
                                            stateFlowImpl7.updateState(null, bool7);
                                            r1 = r0;
                                            return Unit.INSTANCE;
                                        }
                                    }
                                    return coroutineSingletons;
                                }
                                return Unit.INSTANCE;
                            } catch (Throwable th3) {
                                th = th3;
                                r13 = r1;
                            }
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public /* synthetic */ AnonymousClass1(PointerInputScope pointerInputScope, TooltipStateImpl tooltipStateImpl, Continuation continuation, byte b) {
                        super(2, continuation);
                        this.$r8$classId = b;
                        this.$this_pointerInput = pointerInputScope;
                        this.$state = tooltipStateImpl;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        switch (this.$r8$classId) {
                            case 0:
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_pointerInput, this.$state, continuation, (byte) 0);
                                anonymousClass1.L$0 = obj;
                                return anonymousClass1;
                            default:
                                AnonymousClass1 anonymousClass2 = new AnonymousClass1(this.$this_pointerInput, this.$state, continuation, (byte) 1);
                                anonymousClass2.L$0 = obj;
                                return anonymousClass2;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        byte b = this.$r8$classId;
                        Unit unit = Unit.INSTANCE;
                        CoroutineScope coroutineScope = (CoroutineScope) obj;
                        Continuation continuation = (Continuation) obj2;
                        switch (b) {
                            case 0:
                                break;
                        }
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        byte b = this.$r8$classId;
                        Unit unit = Unit.INSTANCE;
                        TooltipStateImpl tooltipStateImpl = this.$state;
                        PointerInputScope pointerInputScope = this.$this_pointerInput;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        switch (b) {
                            case 0:
                                boolean z = this.label;
                                if (!z) {
                                    ResultKt.throwOnFailure(obj);
                                    C00001 c00001 = new C00001((CoroutineScope) this.L$0, tooltipStateImpl, null);
                                    this.label = true;
                                    return ScrollableKt.awaitEachGesture(pointerInputScope, c00001, this) == coroutineSingletons ? coroutineSingletons : unit;
                                }
                                if (z) {
                                    ResultKt.throwOnFailure(obj);
                                    return unit;
                                }
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            default:
                                boolean z2 = this.label;
                                if (!z2) {
                                    ResultKt.throwOnFailure(obj);
                                    BasicTooltipKt$handleGestures$2$1$1 basicTooltipKt$handleGestures$2$1$1 = new BasicTooltipKt$handleGestures$2$1$1((CoroutineScope) this.L$0, tooltipStateImpl, null);
                                    this.label = true;
                                    return ((SuspendingPointerInputModifierNodeImpl) pointerInputScope).awaitPointerEventScope(basicTooltipKt$handleGestures$2$1$1, this) == coroutineSingletons ? coroutineSingletons : unit;
                                }
                                if (z2) {
                                    ResultKt.throwOnFailure(obj);
                                    return unit;
                                }
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                        }
                    }
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                    byte b3 = b2;
                    Unit unit = Unit.INSTANCE;
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    Continuation continuation2 = null;
                    TooltipStateImpl tooltipStateImpl2 = tooltipStateImpl;
                    switch (b3) {
                        case 0:
                            Object objCoroutineScope = AwaitKt.coroutineScope(new AnonymousClass1(pointerInputScope, tooltipStateImpl2, continuation2, (byte) 0), continuation);
                            return objCoroutineScope == coroutineSingletons ? objCoroutineScope : unit;
                        default:
                            Object objCoroutineScope2 = AwaitKt.coroutineScope(new AnonymousClass1(pointerInputScope, tooltipStateImpl2, continuation2, (byte) 1), continuation);
                            return objCoroutineScope2 == coroutineSingletons ? objCoroutineScope2 : unit;
                    }
                }
            }), tooltipStateImpl, new PointerInputEventHandler() { // from class: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1

                /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                public final class AnonymousClass1 extends SuspendLambda implements Function2 {
                    public final /* synthetic */ byte $r8$classId;
                    public final /* synthetic */ TooltipStateImpl $state;
                    public final /* synthetic */ PointerInputScope $this_pointerInput;
                    public /* synthetic */ Object L$0;
                    public boolean label;

                    /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    public final class C00001 extends RestrictedSuspendLambda implements Function2 {
                        public final /* synthetic */ CoroutineScope $$this$coroutineScope;
                        public final /* synthetic */ TooltipStateImpl $state;
                        public long J$0;
                        public /* synthetic */ Object L$0;
                        public MutableStateFlow L$1;
                        public PointerEventPass L$2;
                        public byte label;

                        /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$1, reason: invalid class name and collision with other inner class name */
                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        public final class C00011 extends RestrictedSuspendLambda implements Function2 {
                            public final /* synthetic */ Object $pass;
                            public final /* synthetic */ byte $r8$classId;
                            public /* synthetic */ Object L$0;
                            public boolean label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public /* synthetic */ C00011(Object obj, Continuation continuation, byte b) {
                                super(2, continuation);
                                this.$r8$classId = b;
                                this.$pass = obj;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation create(Object obj, Continuation continuation) {
                                byte b = this.$r8$classId;
                                Object obj2 = this.$pass;
                                switch (b) {
                                    case 0:
                                        C00011 c00011 = new C00011((PointerEventPass) obj2, continuation, (byte) 0);
                                        c00011.L$0 = obj;
                                        return c00011;
                                    case 1:
                                        C00011 c00012 = new C00011((CoreTextFieldKt$$ExternalSyntheticLambda1) obj2, continuation, (byte) 1);
                                        c00012.L$0 = obj;
                                        return c00012;
                                    default:
                                        C00011 c00013 = new C00011((MutableState) obj2, continuation, (byte) 2);
                                        c00013.L$0 = obj;
                                        return c00013;
                                }
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                byte b = this.$r8$classId;
                                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                Unit unit = Unit.INSTANCE;
                                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj;
                                Continuation continuation = (Continuation) obj2;
                                switch (b) {
                                    case 0:
                                        return ((C00011) create(pointerEventHandlerCoroutine, continuation)).invokeSuspend(unit);
                                    case 1:
                                        ((C00011) create(pointerEventHandlerCoroutine, continuation)).invokeSuspend(unit);
                                        return coroutineSingletons;
                                    default:
                                        ((C00011) create(pointerEventHandlerCoroutine, continuation)).invokeSuspend(unit);
                                        return coroutineSingletons;
                                }
                            }

                            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:19:0x004e
                                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                                */
                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                                /*
                                    r8 = this;
                                    byte r0 = r8.$r8$classId
                                    java.lang.Object r1 = r8.$pass
                                    java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                                    kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                                    r4 = 1
                                    r5 = 0
                                    switch(r0) {
                                        case 0: goto L88;
                                        case 1: goto L4e;
                                        default: goto Ld;
                                    }
                                Ld:
                                    java.lang.Object r0 = r8.L$0
                                    androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r0
                                    boolean r6 = r8.label
                                    if (r6 == 0) goto L20
                                    if (r6 != r4) goto L1b
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    goto L30
                                L1b:
                                    okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r2)
                                    r3 = r5
                                    goto L2f
                                L20:
                                    kotlin.ResultKt.throwOnFailure(r9)
                                L23:
                                    r8.L$0 = r0
                                    r8.label = r4
                                    androidx.compose.ui.input.pointer.PointerEventPass r9 = androidx.compose.ui.input.pointer.PointerEventPass.Main
                                    java.lang.Object r9 = r0.awaitPointerEvent(r9, r8)
                                    if (r9 != r3) goto L30
                                L2f:
                                    return r3
                                L30:
                                    androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
                                    java.util.List r9 = r9.changes
                                    java.lang.Object r9 = kotlin.collections.CollectionsKt.firstOrNull(r9)
                                    androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
                                    if (r9 == 0) goto L44
                                    long r6 = r9.position
                                    androidx.compose.ui.geometry.Offset r9 = new androidx.compose.ui.geometry.Offset
                                    r9.<init>(r6)
                                    goto L45
                                L44:
                                    r9 = r5
                                L45:
                                    if (r9 == 0) goto L23
                                    r2 = r1
                                    androidx.compose.runtime.MutableState r2 = (androidx.compose.runtime.MutableState) r2
                                    r2.setValue(r9)
                                    goto L23
                                L4e:
                                    boolean r0 = r8.label
                                    if (r0 == 0) goto L61
                                    if (r0 != r4) goto L5c
                                    java.lang.Object r0 = r8.L$0
                                    androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r0
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    goto L76
                                L5c:
                                    okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r2)
                                    r3 = r5
                                    goto L75
                                L61:
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    java.lang.Object r9 = r8.L$0
                                    androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r9 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r9
                                    r0 = r9
                                L69:
                                    r8.L$0 = r0
                                    r8.label = r4
                                    androidx.compose.ui.input.pointer.PointerEventPass r9 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                                    java.lang.Object r9 = r0.awaitPointerEvent(r9, r8)
                                    if (r9 != r3) goto L76
                                L75:
                                    return r3
                                L76:
                                    androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
                                    r2 = r1
                                    androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1 r2 = (androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1) r2
                                    boolean r9 = androidx.compose.foundation.text.selection.SelectionGestures_androidKt.isMouseOrTouchPad(r9)
                                    r9 = r9 ^ r4
                                    java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
                                    r2.invoke(r9)
                                    goto L69
                                L88:
                                    boolean r0 = r8.label
                                    if (r0 == 0) goto L97
                                    if (r0 != r4) goto L92
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    goto La9
                                L92:
                                    okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r2)
                                    r9 = r5
                                    goto La9
                                L97:
                                    kotlin.ResultKt.throwOnFailure(r9)
                                    java.lang.Object r9 = r8.L$0
                                    androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r9 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r9
                                    androidx.compose.ui.input.pointer.PointerEventPass r1 = (androidx.compose.ui.input.pointer.PointerEventPass) r1
                                    r8.label = r4
                                    java.lang.Object r9 = androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(r9, r1, r8)
                                    if (r9 != r3) goto La9
                                    r9 = r3
                                La9:
                                    return r9
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1.AnonymousClass1.C00001.C00011.invokeSuspend(java.lang.Object):java.lang.Object");
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C00001(CoroutineScope coroutineScope, TooltipStateImpl tooltipStateImpl, Continuation continuation) {
                            super(2, continuation);
                            this.$$this$coroutineScope = coroutineScope;
                            this.$state = tooltipStateImpl;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            C00001 c00001 = new C00001(this.$$this$coroutineScope, this.$state, continuation);
                            c00001.L$0 = obj;
                            return c00001;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ((C00001) create((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Code duplicated, block: B:40:0x00c2  */
                        /* JADX WARN: Code duplicated, block: B:43:0x00c7 A[Catch: all -> 0x0019, TRY_LEAVE, TryCatch #3 {all -> 0x0019, blocks: (B:8:0x0014, B:41:0x00c3, B:43:0x00c7), top: B:55:0x0014 }] */
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v0, types: [byte] */
                        /* JADX WARN: Type inference failed for: r0v1 */
                        /* JADX WARN: Type inference failed for: r0v14 */
                        /* JADX WARN: Type inference failed for: r0v15 */
                        /* JADX WARN: Type inference failed for: r0v16 */
                        /* JADX WARN: Type inference failed for: r0v17 */
                        /* JADX WARN: Type inference failed for: r0v8 */
                        /* JADX WARN: Type inference failed for: r0v9 */
                        /* JADX WARN: Type inference failed for: r13v1 */
                        /* JADX WARN: Type inference failed for: r13v11 */
                        /* JADX WARN: Type inference failed for: r13v13 */
                        /* JADX WARN: Type inference failed for: r13v16, types: [kotlinx.coroutines.flow.MutableStateFlow] */
                        /* JADX WARN: Type inference failed for: r13v17 */
                        /* JADX WARN: Type inference failed for: r13v2 */
                        /* JADX WARN: Type inference failed for: r13v7 */
                        /* JADX WARN: Type inference failed for: r13v9 */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            ?? r13;
                            long j;
                            SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine;
                            PointerEventPass pointerEventPass;
                            MutableStateFlow mutableStateFlow;
                            MutableStateFlow mutableStateFlow2;
                            Object obj2;
                            ?? r0;
                            PointerInputChange pointerInputChange;
                            ?? r1 = this.label;
                            Continuation continuation = null;
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            try {
                                if (r1 == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine2 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                                    StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
                                    long longPressTimeoutMillis = pointerEventHandlerCoroutine2.getViewConfiguration().getLongPressTimeoutMillis();
                                    this.L$0 = pointerEventHandlerCoroutine2;
                                    this.L$1 = stateFlowImplMutableStateFlow;
                                    PointerEventPass pointerEventPass2 = PointerEventPass.Initial;
                                    this.L$2 = pointerEventPass2;
                                    this.J$0 = longPressTimeoutMillis;
                                    this.label = (byte) 1;
                                    Object objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(pointerEventHandlerCoroutine2, this, 1);
                                    if (objAwaitFirstDown$default != coroutineSingletons) {
                                        j = longPressTimeoutMillis;
                                        pointerEventHandlerCoroutine = pointerEventHandlerCoroutine2;
                                        obj = objAwaitFirstDown$default;
                                        mutableStateFlow = stateFlowImplMutableStateFlow;
                                        pointerEventPass = pointerEventPass2;
                                    }
                                    return coroutineSingletons;
                                }
                                if (r1 != 1) {
                                    if (r1 != 2) {
                                        if (r1 != 3) {
                                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                            return null;
                                        }
                                        r13 = (MutableStateFlow) this.L$0;
                                        try {
                                            ResultKt.throwOnFailure(obj);
                                            r0 = r1;
                                            r13 = r13;
                                            pointerInputChange = (PointerInputChange) obj;
                                            if (pointerInputChange != null) {
                                                pointerInputChange.consume();
                                            }
                                            Boolean bool7 = Boolean.FALSE;
                                            StateFlowImpl stateFlowImpl7 = (StateFlowImpl) r13;
                                            stateFlowImpl7.getClass();
                                            stateFlowImpl7.updateState(null, bool7);
                                            r1 = r0;
                                            return Unit.INSTANCE;
                                        } catch (Throwable th) {
                                            th = th;
                                            Boolean bool5 = Boolean.FALSE;
                                            StateFlowImpl stateFlowImpl5 = (StateFlowImpl) r13;
                                            stateFlowImpl5.getClass();
                                            stateFlowImpl5.updateState(null, bool5);
                                            throw th;
                                        }
                                    }
                                    PointerEventPass pointerEventPass3 = this.L$2;
                                    MutableStateFlow mutableStateFlow3 = this.L$1;
                                    pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                                    try {
                                        ResultKt.throwOnFailure(obj);
                                        obj2 = pointerEventPass3;
                                        mutableStateFlow2 = mutableStateFlow3;
                                        Boolean bool6 = Boolean.FALSE;
                                        StateFlowImpl stateFlowImpl6 = (StateFlowImpl) mutableStateFlow2;
                                        stateFlowImpl6.getClass();
                                        stateFlowImpl6.updateState(null, bool6);
                                        r1 = obj2;
                                    } catch (PointerEventTimeoutCancellationException unused) {
                                        pointerEventPass = pointerEventPass3;
                                        mutableStateFlow = mutableStateFlow3;
                                        AwaitKt.launch$default(this.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AsyncImagePainter.AnonymousClass1(mutableStateFlow, this.$state, continuation, (byte) 6), 1);
                                        this.L$0 = mutableStateFlow;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.label = (byte) 3;
                                        obj = TapGestureDetectorKt.waitForUpOrCancellation(pointerEventHandlerCoroutine, pointerEventPass, this);
                                        if (obj != coroutineSingletons) {
                                            r13 = mutableStateFlow;
                                            r0 = mutableStateFlow;
                                            pointerInputChange = (PointerInputChange) obj;
                                            if (pointerInputChange != null) {
                                                pointerInputChange.consume();
                                            }
                                            Boolean bool8 = Boolean.FALSE;
                                            StateFlowImpl stateFlowImpl8 = (StateFlowImpl) r13;
                                            stateFlowImpl8.getClass();
                                            stateFlowImpl8.updateState(null, bool8);
                                            r1 = r0;
                                        }
                                        return coroutineSingletons;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        r13 = mutableStateFlow3;
                                        Boolean bool9 = Boolean.FALSE;
                                        StateFlowImpl stateFlowImpl9 = (StateFlowImpl) r13;
                                        stateFlowImpl9.getClass();
                                        stateFlowImpl9.updateState(null, bool9);
                                        throw th;
                                    }
                                    return Unit.INSTANCE;
                                }
                                long j2 = this.J$0;
                                PointerEventPass pointerEventPass4 = this.L$2;
                                MutableStateFlow mutableStateFlow4 = this.L$1;
                                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine3 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                pointerEventPass = pointerEventPass4;
                                mutableStateFlow = mutableStateFlow4;
                                j = j2;
                                pointerEventHandlerCoroutine = pointerEventHandlerCoroutine3;
                                long j3 = j;
                                int i = ((PointerInputChange) obj).type;
                                if (i == 1 || i == 3) {
                                    try {
                                        C00011 c00011 = new C00011(pointerEventPass, continuation, (byte) 0);
                                        this.L$0 = pointerEventHandlerCoroutine;
                                        this.L$1 = mutableStateFlow;
                                        this.L$2 = pointerEventPass;
                                        this.label = (byte) 2;
                                        if (pointerEventHandlerCoroutine.withTimeout(j3, c00011, this) != coroutineSingletons) {
                                            mutableStateFlow2 = mutableStateFlow;
                                            obj2 = mutableStateFlow;
                                            Boolean bool10 = Boolean.FALSE;
                                            StateFlowImpl stateFlowImpl10 = (StateFlowImpl) mutableStateFlow2;
                                            stateFlowImpl10.getClass();
                                            stateFlowImpl10.updateState(null, bool10);
                                            r1 = obj2;
                                        }
                                    } catch (PointerEventTimeoutCancellationException unused2) {
                                        AwaitKt.launch$default(this.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AsyncImagePainter.AnonymousClass1(mutableStateFlow, this.$state, continuation, (byte) 6), 1);
                                        this.L$0 = mutableStateFlow;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.label = (byte) 3;
                                        obj = TapGestureDetectorKt.waitForUpOrCancellation(pointerEventHandlerCoroutine, pointerEventPass, this);
                                        if (obj != coroutineSingletons) {
                                            r13 = mutableStateFlow;
                                            r0 = mutableStateFlow;
                                            pointerInputChange = (PointerInputChange) obj;
                                            if (pointerInputChange != null) {
                                                pointerInputChange.consume();
                                            }
                                            Boolean bool11 = Boolean.FALSE;
                                            StateFlowImpl stateFlowImpl11 = (StateFlowImpl) r13;
                                            stateFlowImpl11.getClass();
                                            stateFlowImpl11.updateState(null, bool11);
                                            r1 = r0;
                                            return Unit.INSTANCE;
                                        }
                                    }
                                    return coroutineSingletons;
                                }
                                return Unit.INSTANCE;
                            } catch (Throwable th3) {
                                th = th3;
                                r13 = r1;
                            }
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public /* synthetic */ AnonymousClass1(PointerInputScope pointerInputScope, TooltipStateImpl tooltipStateImpl, Continuation continuation, byte b) {
                        super(2, continuation);
                        this.$r8$classId = b;
                        this.$this_pointerInput = pointerInputScope;
                        this.$state = tooltipStateImpl;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        switch (this.$r8$classId) {
                            case 0:
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_pointerInput, this.$state, continuation, (byte) 0);
                                anonymousClass1.L$0 = obj;
                                return anonymousClass1;
                            default:
                                AnonymousClass1 anonymousClass2 = new AnonymousClass1(this.$this_pointerInput, this.$state, continuation, (byte) 1);
                                anonymousClass2.L$0 = obj;
                                return anonymousClass2;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        byte b = this.$r8$classId;
                        Unit unit = Unit.INSTANCE;
                        CoroutineScope coroutineScope = (CoroutineScope) obj;
                        Continuation continuation = (Continuation) obj2;
                        switch (b) {
                            case 0:
                                break;
                        }
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        byte b = this.$r8$classId;
                        Unit unit = Unit.INSTANCE;
                        TooltipStateImpl tooltipStateImpl = this.$state;
                        PointerInputScope pointerInputScope = this.$this_pointerInput;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        switch (b) {
                            case 0:
                                boolean z = this.label;
                                if (!z) {
                                    ResultKt.throwOnFailure(obj);
                                    C00001 c00001 = new C00001((CoroutineScope) this.L$0, tooltipStateImpl, null);
                                    this.label = true;
                                    return ScrollableKt.awaitEachGesture(pointerInputScope, c00001, this) == coroutineSingletons ? coroutineSingletons : unit;
                                }
                                if (z) {
                                    ResultKt.throwOnFailure(obj);
                                    return unit;
                                }
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            default:
                                boolean z2 = this.label;
                                if (!z2) {
                                    ResultKt.throwOnFailure(obj);
                                    BasicTooltipKt$handleGestures$2$1$1 basicTooltipKt$handleGestures$2$1$1 = new BasicTooltipKt$handleGestures$2$1$1((CoroutineScope) this.L$0, tooltipStateImpl, null);
                                    this.label = true;
                                    return ((SuspendingPointerInputModifierNodeImpl) pointerInputScope).awaitPointerEventScope(basicTooltipKt$handleGestures$2$1$1, this) == coroutineSingletons ? coroutineSingletons : unit;
                                }
                                if (z2) {
                                    ResultKt.throwOnFailure(obj);
                                    return unit;
                                }
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                        }
                    }
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                    byte b3 = b;
                    Unit unit = Unit.INSTANCE;
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    Continuation continuation2 = null;
                    TooltipStateImpl tooltipStateImpl2 = tooltipStateImpl;
                    switch (b3) {
                        case 0:
                            Object objCoroutineScope = AwaitKt.coroutineScope(new AnonymousClass1(pointerInputScope, tooltipStateImpl2, continuation2, (byte) 0), continuation);
                            return objCoroutineScope == coroutineSingletons ? objCoroutineScope : unit;
                        default:
                            Object objCoroutineScope2 = AwaitKt.coroutineScope(new AnonymousClass1(pointerInputScope, tooltipStateImpl2, continuation2, (byte) 1), continuation);
                            return objCoroutineScope2 == coroutineSingletons ? objCoroutineScope2 : unit;
                    }
                }
            }).then(new ParentSemanticsNodeElement(new UtilsKt$$ExternalSyntheticLambda0((Object) strStringResource, (Object) coroutineScope, (Object) tooltipStateImpl, (byte) 18))), new UtilsKt$$ExternalSyntheticLambda0((Object) coroutineScope, (Object) mutableState2, (Object) tooltipStateImpl, (byte) 17)), new ViewSizeResolver$size$3$1(tooltipStateImpl, mutableState, mutableState2, b));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierOnPreviewKeyEvent);
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
            Fragment$5$$ExternalSyntheticOutline0.m((i2 >> 15) & 14, composableLambdaImpl, gapComposer, true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LifecycleEffectKt$$ExternalSyntheticLambda0(tooltipStateImpl, mutableState, modifier, composableLambdaImpl, i, (byte) 1);
        }
    }

    public static final Modifier draggableAnchors(Modifier modifier, NodeChain nodeChain, Orientation orientation, Function2 function2) {
        return modifier.then(new DraggableAnchorsElement(nodeChain, function2, orientation));
    }

    /* JADX INFO: renamed from: drawStopIndicator-VnkRyUA, reason: not valid java name */
    public static final void m372drawStopIndicatorVnkRyUA(LayoutNodeDrawScope layoutNodeDrawScope, float f, long j, float f2, float f3, Stroke stroke, long j2) {
        float fMin = Math.min(stroke.width, layoutNodeDrawScope.mo81toPx0680j_4(f2));
        float f4 = stroke.width;
        int i = (int) (j >> 32);
        float fIntBitsToFloat = (Float.intBitsToFloat(i) - fMin) - (fMin == f4 ? 0.0f : f4 / 4.0f);
        float fIntBitsToFloat2 = (Float.intBitsToFloat(i) * f) + f3;
        if (fIntBitsToFloat <= fIntBitsToFloat2) {
            fMin = Math.max(CropImageView.DEFAULT_ASPECT_RATIO, fMin - (fIntBitsToFloat2 - fIntBitsToFloat));
            fIntBitsToFloat = fIntBitsToFloat2;
        }
        if (fMin > CropImageView.DEFAULT_ASPECT_RATIO) {
            if (stroke.cap == 1) {
                float f5 = fMin / 2.0f;
                DrawScope.m543drawCircleVaOC9Bg$default(layoutNodeDrawScope, j2, f5, (((long) Float.floatToRawIntBits(fIntBitsToFloat + f5)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) / 2.0f)) & 4294967295L), null, 0, 120);
            } else {
                DrawScope.m550drawRectnJ9OG0$default(layoutNodeDrawScope, j2, (((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (j & 4294967295L)) - fMin) / 2.0f)) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32), (((long) Float.floatToRawIntBits(fMin)) << 32) | (((long) Float.floatToRawIntBits(fMin)) & 4294967295L), CropImageView.DEFAULT_ASPECT_RATIO, 0, 120);
            }
        }
    }

    public static final Alignment.Horizontal getExpandedAlignment(ScrimKt scrimKt) {
        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
        if ((scrimKt instanceof TextFieldLabelPosition$Inside) || (scrimKt instanceof TextFieldLabelPosition$Cutout)) {
            return horizontal;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$3(scrimKt, "Unknown position: ");
        return null;
    }

    public static final Object getLayoutId(Measurable measurable) {
        Object parentData = measurable.getParentData();
        LayoutIdModifier layoutIdModifier = parentData instanceof LayoutIdModifier ? (LayoutIdModifier) parentData : null;
        if (layoutIdModifier != null) {
            return layoutIdModifier.layoutId;
        }
        return null;
    }

    public static final Alignment.Horizontal getMinimizedAlignment(ScrimKt scrimKt) {
        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
        if ((scrimKt instanceof TextFieldLabelPosition$Inside) || (scrimKt instanceof TextFieldLabelPosition$Cutout)) {
            return horizontal;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$3(scrimKt, "Unknown position: ");
        return null;
    }

    /* JADX INFO: renamed from: getString-2EP1pXo, reason: not valid java name */
    public static final String m373getString2EP1pXo(int i, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.consume(AndroidCompositionLocals_androidKt.LocalConfiguration);
        return ((Resources) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalResources)).getString(i);
    }

    /* JADX INFO: renamed from: linearWavyProgressIndicator-bMBChCs, reason: not valid java name */
    public static final Modifier m374linearWavyProgressIndicatorbMBChCs(Modifier modifier, Function0 function0, Function1 function1, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4) {
        return modifier.then(new DeterminateLinearWavyProgressElement(f, f2, f3, f4, j, j2, stroke, stroke2, function0, function1));
    }

    public static final float minimizedLabelHalfHeight(Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        long j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.bodySmall.paragraphStyle.lineHeight;
        long sp = IntMath.getSp(16.0d);
        if ((1095216660480L & j) != 4294967296L) {
            j = sp;
        }
        return (((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo76toDpGaN1DYA(j) / 2.0f) + CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public static final Listener rememberAccessibilityServiceState(int i, int i2, Composer composer) {
        boolean z = (i2 & 4) != 0;
        GapComposer gapComposer = (GapComposer) composer;
        Object systemService = ((Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext)).getSystemService("accessibility");
        systemService.getClass();
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        boolean z2 = ((((i & 896) ^ 384) > 256 && gapComposer.changed(z)) || (i & 384) == 256) | ((((i & 14) ^ 6) > 4 && gapComposer.changed(true)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && gapComposer.changed(true)) || (i & 48) == 32);
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (z2 || objRememberedValue == neverEqualPolicy) {
            objRememberedValue = new Listener(true, true, z);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        Listener listener = (Listener) objRememberedValue;
        LifecycleOwner lifecycleOwner = (LifecycleOwner) gapComposer.consume(LocalLifecycleOwnerKt.LocalLifecycleOwner);
        boolean zChanged = gapComposer.changed(listener) | gapComposer.changedInstance(accessibilityManager);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new ZIndexNode$$ExternalSyntheticLambda0((Object) listener, (Object) accessibilityManager, (byte) 17);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Function1 function1 = (Function1) objRememberedValue2;
        boolean zChanged2 = gapComposer.changed(listener) | gapComposer.changedInstance(accessibilityManager);
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = new Recomposer$$ExternalSyntheticLambda6((Object) listener, (Object) accessibilityManager, (byte) 20);
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        ObserveState(lifecycleOwner, function1, (Function0) objRememberedValue3, gapComposer, 0);
        return listener;
    }

    public static final AnimatedShapeKt$rememberAnimatedShape$1$1 rememberAnimatedShape(RoundedCornerShape roundedCornerShape, FiniteAnimationSpec finiteAnimationSpec, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        boolean zChanged = gapComposer.changed(finiteAnimationSpec);
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (zChanged || objRememberedValue == neverEqualPolicy) {
            objRememberedValue = new AnimatedShapeState(roundedCornerShape, finiteAnimationSpec);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        final AnimatedShapeState animatedShapeState = (AnimatedShapeState) objRememberedValue;
        boolean zChanged2 = gapComposer.changed(animatedShapeState) | ((((i & 14) ^ 6) > 4 && gapComposer.changed(roundedCornerShape)) || (i & 6) == 4);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new SliderState.AnonymousClass2(animatedShapeState, roundedCornerShape, null, (byte) 21);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Stack.LaunchedEffect(roundedCornerShape, animatedShapeState, (Function2) objRememberedValue2, gapComposer);
        boolean zChanged3 = gapComposer.changed(animatedShapeState);
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = new Shape() { // from class: androidx.compose.material3.internal.AnimatedShapeKt$rememberAnimatedShape$1$1
                /* JADX WARN: Code duplicated, block: B:21:0x0044  */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // androidx.compose.ui.graphics.Shape
                /* JADX INFO: renamed from: createOutline-Pq9zytI */
                public final ColorKt mo56createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
                    Object obj;
                    AnimatedShapeState animatedShapeState2 = animatedShapeState;
                    float fFloatValue = ((Number) animatedShapeState2.progress.getValue()).floatValue();
                    RoundedCornerShape roundedCornerShape2 = animatedShapeState2.cachedMorphedShape;
                    if (fFloatValue != animatedShapeState2.cachedProgress || roundedCornerShape2 == null) {
                        RoundedCornerShape roundedCornerShape3 = animatedShapeState2.startShape;
                        RoundedCornerShape roundedCornerShape4 = animatedShapeState2.targetShape;
                        if (!Intrinsics.areEqual(roundedCornerShape3, roundedCornerShape4)) {
                            Object objLerp = roundedCornerShape3 != null ? roundedCornerShape3.lerp(fFloatValue, roundedCornerShape4) : null;
                            if (objLerp == null && roundedCornerShape4 != null) {
                                objLerp = roundedCornerShape4.lerp(1.0f - fFloatValue, roundedCornerShape3);
                            }
                            if (objLerp != null) {
                                obj = objLerp;
                            } else if (fFloatValue >= 0.5f) {
                                obj = roundedCornerShape3;
                                obj = roundedCornerShape3;
                                obj = roundedCornerShape4;
                            }
                        } else if (fFloatValue >= 0.5f) {
                            obj = roundedCornerShape3;
                            obj = roundedCornerShape3;
                            obj = roundedCornerShape4;
                        }
                        obj = roundedCornerShape3;
                        obj = roundedCornerShape3;
                        obj.getClass();
                        roundedCornerShape2 = (RoundedCornerShape) obj;
                        animatedShapeState2.cachedProgress = fFloatValue;
                        animatedShapeState2.cachedMorphedShape = roundedCornerShape2;
                    }
                    return roundedCornerShape2.mo56createOutlinePq9zytI(j, layoutDirection, density);
                }
            };
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        return (AnimatedShapeKt$rememberAnimatedShape$1$1) objRememberedValue3;
    }

    public static final int subtractConstraintSafely(int i, int i2) {
        if (i == Integer.MAX_VALUE) {
            return i;
        }
        int i3 = i - i2;
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    public static final float textFieldHorizontalIconPadding(Composer composer) {
        float f = ((Dp) ((GapComposer) composer).consume(InteractiveComponentSizeKt.LocalMinimumInteractiveComponentSize)).value;
        if (Float.isNaN(f)) {
            f = 0.0f;
        }
        float f2 = (((f - 24.0f) + CropImageView.DEFAULT_ASPECT_RATIO) / 2.0f) + CropImageView.DEFAULT_ASPECT_RATIO;
        return f2 < CropImageView.DEFAULT_ASPECT_RATIO ? CropImageView.DEFAULT_ASPECT_RATIO : f2;
    }

    public static final Modifier visualTextSemantics(Modifier modifier, CharSequence charSequence, boolean z) {
        Modifier modifierSemantics = Modifier.Companion.$$INSTANCE;
        if (z && charSequence.length() > 0) {
            modifierSemantics = SemanticsModifierKt.semantics(modifierSemantics, false, new TextKt$$ExternalSyntheticLambda2((byte) 8, charSequence));
        }
        return modifier.then(modifierSemantics);
    }
}
