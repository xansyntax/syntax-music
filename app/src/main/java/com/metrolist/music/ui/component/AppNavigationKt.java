package com.metrolist.music.ui.component;

import android.graphics.RenderEffect;
import android.graphics.RuntimeShader;
import android.os.Build;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState$scrollToItem$2;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda11;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda13;
import androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda14;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda6;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda7;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.AndroidRenderEffect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.InlineClassHelperKt;
import androidx.compose.ui.unit.Velocity;
import com.dokar.quickjs.QuickJs$$ExternalSyntheticLambda1;
import com.google.common.math.IntMath;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.Screens;
import com.metrolist.music.ui.theme.UiStyle;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.RawWebSocketCommonKt$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.math.MathKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.xmlpull.v1.XmlPullParserException;
import sh.calvin.reorderable.DraggableKt$draggable$3$2$1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppNavigationKt {

    /* JADX INFO: renamed from: com.metrolist.music.ui.component.AppNavigationKt$lensGesture$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public float F$0;
        public SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine L$0;
        public LensController L$1;
        public VelocityTracker L$3;
        public Ref$FloatRef L$4;
        public PointerInputChange L$5;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppNavigationKt.lensGesture(null, null, CropImageView.DEFAULT_ASPECT_RATIO, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.ui.component.AppNavigationKt$lensGesture$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ LensController $c;
        public final /* synthetic */ byte $r8$classId;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(LensController lensController, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$c = lensController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            LensController lensController = this.$c;
            switch (b) {
                case 0:
                    return new AnonymousClass2(lensController, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass2(lensController, continuation, (byte) 1);
                case 2:
                    return new AnonymousClass2(lensController, continuation, (byte) 2);
                default:
                    return new AnonymousClass2(lensController, continuation, (byte) 3);
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
                case 1:
                    break;
                case 2:
                    break;
            }
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            LensController lensController = this.$c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (z) {
                        if (z) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = lensController.press;
                    Float f = new Float(1.0f);
                    SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(0.5f, 700.0f, null, 4);
                    this.label = true;
                    return Animatable.animateTo$default(animatable, f, springSpecSpring$default, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
                case 1:
                    boolean z2 = this.label;
                    if (z2) {
                        if (z2) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable2 = lensController.press;
                    Float f2 = new Float(CropImageView.DEFAULT_ASPECT_RATIO);
                    SpringSpec springSpecSpring$default2 = ArcSplineKt.spring$default(0.55f, 520.0f, null, 4);
                    this.label = true;
                    return Animatable.animateTo$default(animatable2, f2, springSpecSpring$default2, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
                case 2:
                    boolean z3 = this.label;
                    if (z3) {
                        if (z3) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable3 = lensController.stretch;
                    Float f3 = new Float(CropImageView.DEFAULT_ASPECT_RATIO);
                    SpringSpec springSpecSpring$default3 = ArcSplineKt.spring$default(0.5f, 500.0f, null, 4);
                    this.label = true;
                    return Animatable.animateTo$default(animatable3, f3, springSpecSpring$default3, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
                default:
                    boolean z4 = this.label;
                    if (!z4) {
                        ResultKt.throwOnFailure(obj);
                        Animatable animatable4 = lensController.pos;
                        this.label = true;
                        return animatable4.stop(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z4) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        }
    }

    public static final void AppNavigationBar(List list, String str, Function2 function2, Modifier modifier, boolean z, boolean z2, Function0 function0, Function0 function1, Composer composer, int i) {
        list.getClass();
        function2.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(949389913);
        int i2 = i | (gapComposer.changed(list) ? 4 : 2) | (gapComposer.changed(str) ? 32 : 16) | (gapComposer.changedInstance(function2) ? 256 : 128) | (gapComposer.changed(modifier) ? 2048 : 1024) | (gapComposer.changed(z) ? 16384 : 8192) | (gapComposer.changed(z2) ? 131072 : 65536) | (gapComposer.changedInstance(function0) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288) | (gapComposer.changedInstance(function1) ? 8388608 : 4194304);
        if (gapComposer.shouldExecute(i2 & 1, (4793491 & i2) != 4793490)) {
            LensNavigationBar(list, str, function2, modifier, z, z2, function0, function1, gapComposer, i2 & 33554430);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ChipKt$$ExternalSyntheticLambda7(list, str, function2, modifier, z, z2, function0, function1, i);
        }
    }

    public static final void AppNavigationRail(List list, String str, Function2 function2, Modifier modifier, boolean z, Function0 function0, Function0 function1, Composer composer, int i) {
        Modifier modifier2;
        long j;
        list.getClass();
        function2.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1606696976);
        int i2 = i | (gapComposer.changed(list) ? 4 : 2) | (gapComposer.changed(str) ? 32 : 16) | (gapComposer.changedInstance(function2) ? 256 : 128) | 3072 | (gapComposer.changed(z) ? 16384 : 8192) | (gapComposer.changedInstance(function0) ? 131072 : 65536) | (gapComposer.changedInstance(function1) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288);
        if (gapComposer.shouldExecute(i2 & 1, (599187 & i2) != 599186)) {
            if (z) {
                gapComposer.startReplaceGroup(-2142523947);
                gapComposer.end(false);
                j = -72057594037927936L;
            } else {
                gapComposer.startReplaceGroup(-2142522752);
                j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainer;
                gapComposer.end(false);
            }
            CardKt.m264NavigationRailqi6gXK8(j, 0L, null, Expect_jvmKt.rememberComposableLambda(1645446024, new SongMenuKt$$ExternalSyntheticLambda8(list, str, function0, function1, (ViewConfiguration) gapComposer.consume(CompositionLocalsKt.LocalViewConfiguration), (HapticFeedback) gapComposer.consume(CompositionLocalsKt.LocalHapticFeedback), function2), gapComposer), gapComposer, 196614);
            modifier2 = Modifier.Companion.$$INSTANCE;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new IconButtonKt$$ExternalSyntheticLambda1(list, str, function2, modifier2, z, function0, function1, i);
        }
    }

    public static final void GlassLensBar(final List list, final int i, final LensController lensController, final Function2 function2, boolean z, final boolean z2, final Function0 function0, final Function0 function1, Composer composer, int i2) {
        int i3;
        GapComposer gapComposer;
        Object failure;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-119010631);
        if ((i2 & 6) == 0) {
            i3 = ((i2 & 8) == 0 ? gapComposer2.changed(list) : gapComposer2.changedInstance(list) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= gapComposer2.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= gapComposer2.changed(lensController) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= gapComposer2.changedInstance(function2) ? 2048 : 1024;
        }
        if ((196608 & i2) == 0) {
            i3 |= gapComposer2.changed(z2) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i3 |= gapComposer2.changedInstance(function0) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((12582912 & i2) == 0) {
            i3 |= gapComposer2.changedInstance(function1) ? 8388608 : 4194304;
        }
        int i4 = i3;
        if (gapComposer2.shouldExecute(i4 & 1, (4785299 & i4) != 4785298)) {
            final int i5 = lensController.n;
            final ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(36.0f);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            RoundedCornerShape roundedCornerShape = (RoundedCornerShape) objRememberedValue;
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(30.0f);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            final RoundedCornerShape roundedCornerShape2 = (RoundedCornerShape) objRememberedValue2;
            float f = z2 ? 58.0f : 68.0f;
            final long j = colorScheme.primary;
            ColorKt.m494luminance8_81llA(colorScheme.surface);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                if (Build.VERSION.SDK_INT >= 33) {
                    try {
                        failure = new RuntimeShader("\nuniform shader content;\nuniform float4 lens;      // centre x, centre y, half width, half height (px)\nuniform float radius;     // corner radius of the lens\nuniform float amount;     // 0..1 how strongly the lens is engaged\nfloat sdRoundBox(float2 p, float2 b, float r) {\n    float2 q = abs(p) - b + r;\n    return min(max(q.x, q.y), 0.0) + length(max(q, 0.0)) - r;\n}\nhalf4 main(float2 fc) {\n    float2 p = fc - lens.xy;\n    float d = sdRoundBox(p, lens.zw, radius);\n    if (d > 0.0) return content.eval(fc);\n    float w = 0.50 * min(lens.z, lens.w);\n    float t = clamp(-d / w, 0.0, 1.0);\n    float bend = pow(1.0 - t, 2.0);\n    float e = 1.0;\n    float2 n = normalize(float2(\n        sdRoundBox(p + float2(e, 0.0), lens.zw, radius) - sdRoundBox(p - float2(e, 0.0), lens.zw, radius),\n        sdRoundBox(p + float2(0.0, e), lens.zw, radius) - sdRoundBox(p - float2(0.0, e), lens.zw, radius)\n    ) + float2(0.0001));\n    float zoom = 1.0 + 0.20 * amount;\n    float2 base = lens.xy + p / zoom;\n    float2 s = base + n * (bend * w * 2.6 * amount);\n    float disp = bend * 6.0 * amount;\n    half4 cr = content.eval(s + n * disp);\n    half4 cg = content.eval(s);\n    half4 cb = content.eval(s - n * disp);\n    return half4(cr.r, cg.g, cb.b, max(cr.a, max(cg.a, cb.a)));\n}\n");
                    } catch (Throwable th) {
                        failure = new Result.Failure(th);
                    }
                    objRememberedValue3 = PathKt$$ExternalSyntheticBUOutline0.m(failure instanceof Result.Failure ? null : failure);
                } else {
                    objRememberedValue3 = null;
                }
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            final RuntimeShader runtimeShaderM = PathKt$$ExternalSyntheticBUOutline0.m(objRememberedValue3);
            Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(OffsetKt.m139paddingqDBjuR0$default(OffsetKt.m137paddingVpY3zN4$default(Modifier.Companion.$$INSTANCE, 22.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), CropImageView.DEFAULT_ASPECT_RATIO, 6.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13), 1.0f), f);
            boolean z3 = (i4 & 896) == 256;
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (z3 || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new AppNavigationKt$$ExternalSyntheticLambda6(lensController, (byte) 4);
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(GlassComponentsKt.m1478glassBlur942rkJo(ColorKt.graphicsLayer(modifierM145height3ABfNKs, (Function1) objRememberedValue4), roundedCornerShape, gapComposer2, 48), 4.0f);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(LayoutNode.Constructor);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1340781149, new Function3() { // from class: com.metrolist.music.ui.component.AppNavigationKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
                    float f2;
                    Screens screens;
                    Modifier.Companion companion;
                    AppNavigationKt$$ExternalSyntheticLambda10 appNavigationKt$$ExternalSyntheticLambda10 = this;
                    RuntimeShader runtimeShader = runtimeShaderM;
                    BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj;
                    Composer composer2 = (Composer) obj2;
                    int iIntValue = ((Integer) obj3).intValue();
                    boxWithConstraintsScopeImpl.getClass();
                    long j2 = boxWithConstraintsScopeImpl.constraints;
                    byte b = 2;
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= ((GapComposer) composer2).changed(boxWithConstraintsScopeImpl) ? 4 : 2;
                    }
                    GapComposer gapComposer3 = (GapComposer) composer2;
                    if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                        Density density = (Density) gapComposer3.consume(CompositionLocalsKt.LocalDensity);
                        float fM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(j2);
                        float fM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j2);
                        float f3 = fM784getMaxWidthimpl / i5;
                        float fMo77toDpu2uoSUM = density.mo77toDpu2uoSUM(f3);
                        LensController lensController2 = lensController;
                        boolean zChanged = gapComposer3.changed(lensController2) | gapComposer3.changed(f3);
                        Object objRememberedValue5 = gapComposer3.rememberedValue();
                        byte b2 = 3;
                        NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                        if (zChanged || objRememberedValue5 == neverEqualPolicy2) {
                            objRememberedValue5 = new BottomSheetKt$$ExternalSyntheticLambda13(lensController2, f3, b2);
                            gapComposer3.updateRememberedValue(objRememberedValue5);
                        }
                        Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                        Modifier modifierThen = SizeKt.m155width3ABfNKs(OffsetKt.offset(companion2, (Function1) objRememberedValue5), fMo77toDpu2uoSUM).then(SizeKt.FillWholeMaxHeight);
                        boolean zChanged2 = gapComposer3.changed(lensController2);
                        Object objRememberedValue6 = gapComposer3.rememberedValue();
                        if (zChanged2 || objRememberedValue6 == neverEqualPolicy2) {
                            objRememberedValue6 = new AppNavigationKt$$ExternalSyntheticLambda6(lensController2, b);
                            gapComposer3.updateRememberedValue(objRememberedValue6);
                        }
                        Modifier modifierGraphicsLayer = ColorKt.graphicsLayer(modifierThen, (Function1) objRememberedValue6);
                        RoundedCornerShape roundedCornerShape3 = roundedCornerShape2;
                        Modifier modifierGlass = GlassComponentsKt.glass(modifierGraphicsLayer, roundedCornerShape3, true, gapComposer3, 432, 0);
                        long j3 = j;
                        Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(modifierGlass, ColorKt.Color(Color.m485getRedimpl(j3), Color.m484getGreenimpl(j3), Color.m482getBlueimpl(j3), 0.14f, Color.m483getColorSpaceimpl(j3)), ColorKt.RectangleShape);
                        boolean zChanged3 = gapComposer3.changed(lensController2);
                        Object objRememberedValue7 = gapComposer3.rememberedValue();
                        if (zChanged3 || objRememberedValue7 == neverEqualPolicy2) {
                            objRememberedValue7 = new QuickJs$$ExternalSyntheticLambda1(lensController2, roundedCornerShape3, (byte) 25);
                            gapComposer3.updateRememberedValue(objRememberedValue7);
                        }
                        Modifier modifierGraphicsLayer2 = ColorKt.graphicsLayer(modifierM39backgroundbw27NRU, (Function1) objRememberedValue7);
                        boolean zChanged4 = gapComposer3.changed(lensController2);
                        Object objRememberedValue8 = gapComposer3.rememberedValue();
                        if (zChanged4 || objRememberedValue8 == neverEqualPolicy2) {
                            objRememberedValue8 = new AppNavigationKt$$ExternalSyntheticLambda6(lensController2, b2);
                            gapComposer3.updateRememberedValue(objRememberedValue8);
                        }
                        BoxKt.Box(ClipKt.drawWithContent(modifierGraphicsLayer2, (Function1) objRememberedValue8), gapComposer3, 0);
                        FillElement fillElement2 = SizeKt.FillWholeMaxSize;
                        boolean zChangedInstance = gapComposer3.changedInstance(runtimeShader) | gapComposer3.changed(lensController2) | gapComposer3.changed(f3) | gapComposer3.changed(fM783getMaxHeightimpl);
                        Object objRememberedValue9 = gapComposer3.rememberedValue();
                        if (zChangedInstance || objRememberedValue9 == neverEqualPolicy2) {
                            objRememberedValue9 = new AppNavigationKt$$ExternalSyntheticLambda22(runtimeShader, lensController2, f3, fM783getMaxHeightimpl);
                            gapComposer3.updateRememberedValue(objRememberedValue9);
                        }
                        Modifier modifierGraphicsLayer3 = ColorKt.graphicsLayer(fillElement2, (Function1) objRememberedValue9);
                        Integer numValueOf = Integer.valueOf(lensController2.n);
                        Float fValueOf = Float.valueOf(f3);
                        AppNavigationKt$lensGestures$1 appNavigationKt$lensGestures$1 = new AppNavigationKt$lensGestures$1(lensController2, f3);
                        PointerEvent pointerEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
                        Modifier modifierThen2 = modifierGraphicsLayer3.then(new SuspendPointerInputElement(numValueOf, fValueOf, appNavigationKt$lensGestures$1, 4));
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer3, 0);
                        int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierThen2);
                        ComposeUiNode.Companion.getClass();
                        gapComposer3.startReusableNode();
                        boolean z4 = gapComposer3.inserting;
                        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                        if (z4) {
                            gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m390setimpl(gapComposer3, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                        Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                        gapComposer3.startReplaceGroup(539353030);
                        Iterator it = list.iterator();
                        int i6 = 0;
                        while (it.hasNext()) {
                            Object next = it.next();
                            int i7 = i6 + 1;
                            RuntimeShader runtimeShader2 = runtimeShader;
                            if (i6 < 0) {
                                CollectionsKt__IterablesKt.throwIndexOverflow();
                                throw null;
                            }
                            Screens screens2 = (Screens) next;
                            boolean z5 = lensController2.getDragging() && lensController2.getNearest() == i6;
                            boolean dragging = lensController2.getDragging();
                            boolean z6 = z5;
                            int i8 = i;
                            Iterator it2 = it;
                            boolean z7 = !dragging ? i8 != i6 : lensController2.getNearest() != i6;
                            int i9 = z7 ? screens2.iconIdActive : screens2.iconIdInactive;
                            LensController lensController3 = lensController2;
                            boolean zAreEqual = Intrinsics.areEqual(screens2, Screens.Search.INSTANCE);
                            Function0 function3 = function0;
                            boolean z8 = zAreEqual && function3 != null;
                            long j4 = j3;
                            boolean zAreEqual2 = Intrinsics.areEqual(screens2, Screens.Home.INSTANCE);
                            Function0 function4 = function1;
                            boolean z9 = zAreEqual2 && function4 != null;
                            Object objRememberedValue10 = gapComposer3.rememberedValue();
                            if (objRememberedValue10 == neverEqualPolicy2) {
                                objRememberedValue10 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer3);
                            }
                            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue10;
                            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda4 = textKt$$ExternalSyntheticLambda3;
                            boolean z10 = i8 == i6;
                            GapComposer gapComposer4 = gapComposer3;
                            Function2 function5 = function2;
                            Modifier.Companion companion3 = companion2;
                            int i10 = i6;
                            AppNavigationKt.NavLongPress(screens2, mutableInteractionSourceImpl, z10, function5, function3, function4, gapComposer4, 48);
                            int i11 = i9;
                            AnimateAsState animateAsStateM17animateColorAsStateeuL9pac = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(z7 != 0 ? j4 : colorScheme.onSurfaceVariant, ArcSplineKt.tween$default(160, 0, null, 6), "glassNavContent", gapComposer4, 432, 8);
                            if (z6 && runtimeShader2 == null) {
                                f2 = 1.32f;
                            } else {
                                f2 = z7 ? 1.12f : 1.0f;
                            }
                            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = updater$$ExternalSyntheticLambda3;
                            AnimateAsState animateAsStateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f2, ArcSplineKt.spring$default(0.42f, 1500.0f, null, 4), "glassNavIcon", gapComposer4, 3120, 20);
                            Modifier modifierThen3 = new LayoutWeightElement(1.0f, true).then(SizeKt.FillWholeMaxHeight);
                            Role role = new Role(4);
                            boolean zChanged5 = gapComposer4.changed(z8) | gapComposer4.changed(z9) | gapComposer4.changed(function5) | gapComposer4.changed(screens2) | gapComposer4.changed(i8) | gapComposer4.changed(i10);
                            Object objRememberedValue11 = gapComposer4.rememberedValue();
                            if (zChanged5 || objRememberedValue11 == neverEqualPolicy2) {
                                objRememberedValue11 = new AppNavigationKt$$ExternalSyntheticLambda14(z8, z9, function5, screens2, i8, i10, (byte) 1);
                                screens = screens2;
                                gapComposer4.updateRememberedValue(objRememberedValue11);
                            } else {
                                screens = screens2;
                            }
                            Modifier modifierM45clickableO2vRcR0$default = ImageKt.m45clickableO2vRcR0$default(modifierThen3, mutableInteractionSourceImpl, null, false, role, (Function0) objRememberedValue11, 12);
                            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Center, Alignment.Companion.CenterHorizontally, gapComposer4, 54);
                            int iHashCode3 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer4.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM45clickableO2vRcR0$default);
                            ComposeUiNode.Companion.getClass();
                            gapComposer4.startReusableNode();
                            if (gapComposer4.inserting) {
                                gapComposer4.createNode(textKt$$ExternalSyntheticLambda4);
                            } else {
                                gapComposer4.useNode();
                            }
                            Stack.m390setimpl(gapComposer4, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                            Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer4, updater$$ExternalSyntheticLambda2, gapComposer4);
                            Stack.m390setimpl(gapComposer4, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda4);
                            Painter painterPainterResource = IntMath.painterResource(i11, 0, gapComposer4);
                            String strStringResource = MathKt.stringResource(screens.titleId, gapComposer4);
                            long j5 = ((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value;
                            boolean z11 = z2;
                            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion3, z11 ? 24.0f : 25.0f);
                            boolean zChanged6 = gapComposer4.changed(animateAsStateAnimateFloatAsState);
                            Object objRememberedValue12 = gapComposer4.rememberedValue();
                            if (zChanged6 || objRememberedValue12 == neverEqualPolicy2) {
                                objRememberedValue12 = new AppBarKt$$ExternalSyntheticLambda3(animateAsStateAnimateFloatAsState, (byte) 4);
                                gapComposer4.updateRememberedValue(objRememberedValue12);
                            }
                            IconKt.m290Iconww6aTOc(painterPainterResource, strStringResource, ColorKt.graphicsLayer(modifierM151size3ABfNKs, (Function1) objRememberedValue12), j5, gapComposer4, 8, 0);
                            gapComposer3 = gapComposer4;
                            if (z11) {
                                companion = companion3;
                                gapComposer3.startReplaceGroup(516340403);
                                gapComposer3.end(false);
                            } else {
                                gapComposer3.startReplaceGroup(515909069);
                                companion = companion3;
                                TextKt.m352TextNvy7gAk(MathKt.stringResource(screens.titleId, gapComposer3), OffsetKt.m139paddingqDBjuR0$default(companion3, CropImageView.DEFAULT_ASPECT_RATIO, 2.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13), ((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer3, 48, 24960, 110584);
                                gapComposer3 = gapComposer3;
                                gapComposer3.end(false);
                            }
                            gapComposer3.end(true);
                            textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                            appNavigationKt$$ExternalSyntheticLambda10 = this;
                            i6 = i7;
                            it = it2;
                            lensController2 = lensController3;
                            j3 = j4;
                            updater$$ExternalSyntheticLambda3 = updater$$ExternalSyntheticLambda4;
                            companion2 = companion;
                            runtimeShader = runtimeShader2;
                        }
                        gapComposer3.end(false);
                        gapComposer3.end(true);
                    } else {
                        gapComposer3.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer2);
            gapComposer = gapComposer2;
            OffsetKt.BoxWithConstraints(fillElement, null, composableLambdaImplRememberComposableLambda, gapComposer, 3078, 6);
            gapComposer.end(true);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AppNavigationKt$$ExternalSyntheticLambda8(list, i, lensController, function2, z, z2, function0, function1, i2, (byte) 1);
        }
    }

    public static final void GlassLensBar$lambda$4$0$5$0(RuntimeShader runtimeShader, LensController lensController, float f, float f2, ReusableGraphicsLayerScope reusableGraphicsLayerScope) {
        reusableGraphicsLayerScope.getClass();
        Animatable animatable = lensController.press;
        Animatable animatable2 = lensController.stretch;
        float fFloatValue = ((Number) animatable.getValue()).floatValue();
        if (runtimeShader == null || fFloatValue < 0.01f) {
            reusableGraphicsLayerScope.setRenderEffect(null);
            return;
        }
        float fFloatValue2 = ((((Number) animatable2.getValue()).floatValue() * 0.22f) + (0.16f * fFloatValue) + 1.0f) * (f / 2.0f);
        float f3 = f2 / 2.0f;
        float fFloatValue3 = (((0.1f * fFloatValue) + 1.0f) - (((Number) animatable2.getValue()).floatValue() * 0.05f)) * f3;
        runtimeShader.setFloatUniform("lens", (((Number) lensController.pos.getValue()).floatValue() + 0.5f) * f, f3, fFloatValue2, fFloatValue3);
        runtimeShader.setFloatUniform("radius", fFloatValue3 * 0.96f);
        runtimeShader.setFloatUniform("amount", fFloatValue);
        RenderEffect renderEffectCreateRuntimeShaderEffect = RenderEffect.createRuntimeShaderEffect(runtimeShader, "content");
        renderEffectCreateRuntimeShaderEffect.getClass();
        reusableGraphicsLayerScope.setRenderEffect(new AndroidRenderEffect(renderEffectCreateRuntimeShaderEffect));
    }

    public static final void LensNavigationBar(final List list, final String str, final Function2 function2, final Modifier modifier, final boolean z, final boolean z2, final Function0 function0, final Function0 function1, Composer composer, final int i) {
        int i2;
        Function0 function3;
        Function0 function4;
        int i3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1364263854);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer.changed(list) : gapComposer.changedInstance(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(modifier) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changed(z2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            function3 = function0;
            i2 |= gapComposer.changedInstance(function3) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        } else {
            function3 = function0;
        }
        if ((12582912 & i) == 0) {
            function4 = function1;
            i2 |= gapComposer.changedInstance(function4) ? 8388608 : 4194304;
        } else {
            function4 = function1;
        }
        if (gapComposer.shouldExecute(i2 & 1, (4793491 & i2) != 4793490)) {
            int size = list.size();
            if (size < 1) {
                size = 1;
            }
            int i4 = i2 & 14;
            boolean z3 = (i4 == 4 || ((i2 & 8) != 0 && gapComposer.changed(list))) | ((i2 & 112) == 32);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z3 || objRememberedValue == neverEqualPolicy) {
                Iterator it = list.iterator();
                int i5 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i3 = i2;
                        i5 = -1;
                        break;
                    } else {
                        i3 = i2;
                        if (isRouteSelected(str, ((Screens) it.next()).route, list)) {
                            break;
                        }
                        i5++;
                        i2 = i3;
                    }
                }
                if (i5 < 0) {
                    i5 = 0;
                }
                objRememberedValue = Integer.valueOf(i5);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                i3 = i2;
            }
            int iIntValue = ((Number) objRememberedValue).intValue();
            MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(list, gapComposer);
            MutableState mutableStateRememberUpdatedState2 = Stack.rememberUpdatedState(function2, gapComposer);
            boolean zChanged = gapComposer.changed(mutableStateRememberUpdatedState2) | gapComposer.changed(mutableStateRememberUpdatedState);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new AlbumMenuKt$$ExternalSyntheticLambda8(mutableStateRememberUpdatedState2, mutableStateRememberUpdatedState, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function5 = (Function1) objRememberedValue2;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue3;
            HapticFeedback hapticFeedback = (HapticFeedback) gapComposer.consume(CompositionLocalsKt.LocalHapticFeedback);
            boolean zChanged2 = gapComposer.changed(size);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new LensController(size, coroutineScope, hapticFeedback, iIntValue);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            LensController lensController = (LensController) objRememberedValue4;
            lensController.selected$delegate.setIntValue(iIntValue);
            function5.getClass();
            lensController.onSelect = function5;
            Integer numValueOf = Integer.valueOf(iIntValue);
            boolean zChanged3 = gapComposer.changed(lensController) | gapComposer.changed(iIntValue);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new LazyListState$scrollToItem$2(lensController, iIntValue, null, (byte) 3);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            Stack.LaunchedEffect(gapComposer, numValueOf, (Function2) objRememberedValue5);
            Integer numValueOf2 = Integer.valueOf(lensController.getNearest());
            Boolean boolValueOf = Boolean.valueOf(lensController.getDragging());
            boolean zChanged4 = gapComposer.changed(lensController) | gapComposer.changedInstance(hapticFeedback);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = new DownloadUtil.AnonymousClass2(lensController, hapticFeedback, null, (byte) 22);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            Stack.LaunchedEffect(numValueOf2, boolValueOf, (Function2) objRememberedValue6, gapComposer);
            Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(modifier, z ? -72057594037927936L : 0L, ColorKt.RectangleShape);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopCenter, false);
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
            if (gapComposer.consume(UiStyleKt.LocalUiStyle) == UiStyle.GLASS) {
                gapComposer.startReplaceGroup(-2145792702);
                GlassLensBar(list, iIntValue, lensController, function2, z, z2, function3, function4, gapComposer, ((i3 << 3) & 7168) | i4 | (i3 & 57344) | (i3 & 458752) | (i3 & 3670016) | (i3 & 29360128));
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-2145639996);
                PillNavBar(list, iIntValue, lensController, function2, z, z2, function0, function1, gapComposer, ((i3 << 3) & 7168) | i4 | (i3 & 57344) | (i3 & 458752) | (i3 & 3670016) | (i3 & 29360128));
                gapComposer.end(false);
            }
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.AppNavigationKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).intValue();
                    AppNavigationKt.LensNavigationBar(list, str, function2, modifier, z, z2, function0, function1, (Composer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void NavLongPress(Screens screens, MutableInteractionSourceImpl mutableInteractionSourceImpl, boolean z, Function2 function2, Function0 function0, Function0 function1, Composer composer, int i) {
        MutableInteractionSourceImpl mutableInteractionSourceImpl2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(20122171);
        int i2 = i | (gapComposer.changed(screens) ? 4 : 2) | (gapComposer.changed(z) ? 256 : 128) | (gapComposer.changedInstance(function2) ? 2048 : 1024) | (gapComposer.changedInstance(function0) ? 16384 : 8192) | (gapComposer.changedInstance(function1) ? 131072 : 65536);
        if (gapComposer.shouldExecute(i2 & 1, (74899 & i2) != 74898)) {
            HapticFeedback hapticFeedback = (HapticFeedback) gapComposer.consume(CompositionLocalsKt.LocalHapticFeedback);
            ViewConfiguration viewConfiguration = (ViewConfiguration) gapComposer.consume(CompositionLocalsKt.LocalViewConfiguration);
            boolean z2 = Intrinsics.areEqual(screens, Screens.Search.INSTANCE) && function0 != null;
            boolean z3 = Intrinsics.areEqual(screens, Screens.Home.INSTANCE) && function1 != null;
            MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(Boolean.valueOf(z), gapComposer);
            if (z2 || z3) {
                gapComposer.startReplaceGroup(-1835200744);
                boolean zChanged = ((i2 & 14) == 4) | ((i2 & 7168) == 2048) | ((57344 & i2) == 16384) | ((i2 & 458752) == 131072) | gapComposer.changed(z3) | gapComposer.changedInstance(viewConfiguration) | gapComposer.changedInstance(hapticFeedback) | gapComposer.changed(mutableStateRememberUpdatedState);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                    DraggableKt$draggable$3$2$1 draggableKt$draggable$3$2$1 = new DraggableKt$draggable$3$2$1(mutableInteractionSourceImpl, z3, viewConfiguration, hapticFeedback, function1, function0, function2, screens, mutableStateRememberUpdatedState, null, (byte) 2);
                    gapComposer.updateRememberedValue(draggableKt$draggable$3$2$1);
                    objRememberedValue = draggableKt$draggable$3$2$1;
                }
                mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                Stack.LaunchedEffect(gapComposer, mutableInteractionSourceImpl2, (Function2) objRememberedValue);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1834325273);
                gapComposer.end(false);
                mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
            }
        } else {
            mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda6(screens, mutableInteractionSourceImpl2, z, function2, function0, function1, i);
        }
    }

    public static final void PillNavBar(final List list, final int i, final LensController lensController, final Function2 function2, boolean z, final boolean z2, final Function0 function0, Function0 function1, Composer composer, int i2) {
        int i3;
        final Function0 function3;
        GapComposer gapComposer;
        ArrayList arrayList;
        Object obj;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1052304809);
        if ((i2 & 6) == 0) {
            i3 = ((i2 & 8) == 0 ? gapComposer2.changed(list) : gapComposer2.changedInstance(list) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= gapComposer2.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= gapComposer2.changed(lensController) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= gapComposer2.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= gapComposer2.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= gapComposer2.changed(z2) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i3 |= gapComposer2.changedInstance(function0) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((12582912 & i2) == 0) {
            function3 = function1;
            i3 |= gapComposer2.changedInstance(function3) ? 8388608 : 4194304;
        } else {
            function3 = function1;
        }
        if (gapComposer2.shouldExecute(i3 & 1, (4793491 & i3) != 4793490)) {
            final int i4 = lensController.n;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            final ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme;
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(22.0f);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            RoundedCornerShape roundedCornerShape = (RoundedCornerShape) objRememberedValue;
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(17.0f);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            final RoundedCornerShape roundedCornerShape2 = (RoundedCornerShape) objRememberedValue2;
            final long j = colorScheme.primary;
            TextMeasurer textMeasurerRememberTextMeasurer = TextRangeKt.rememberTextMeasurer(gapComposer2);
            final TextStyle textStyle = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.labelLarge;
            gapComposer2.startReplaceGroup(1947626635);
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(MathKt.stringResource(((Screens) it.next()).titleId, gapComposer2));
            }
            gapComposer2.end(false);
            boolean zChanged = gapComposer2.changed(arrayList2) | gapComposer2.changed(textStyle);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
                int size = arrayList2.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj2 = arrayList2.get(i5);
                    i5++;
                    arrayList3.add(Float.valueOf((int) (TextMeasurer.m738measurexDpz5zY$default(textMeasurerRememberTextMeasurer, new AnnotatedString((String) obj2), textStyle, false, 0L, null, null, null, 2044).size >> 32)));
                    size = size;
                    arrayList2 = arrayList2;
                }
                arrayList = arrayList2;
                gapComposer2.updateRememberedValue(arrayList3);
                obj = arrayList3;
            } else {
                arrayList = arrayList2;
                obj = objRememberedValue3;
            }
            final List list2 = (List) obj;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = CompositionLocalsKt.LocalDensity;
            final float fMo81toPx0680j_4 = ((Density) gapComposer2.consume(staticProvidableCompositionLocal2)).mo81toPx0680j_4(8.0f);
            final float fMo81toPx0680j_5 = ((Density) gapComposer2.consume(staticProvidableCompositionLocal2)).mo81toPx0680j_4(46.0f);
            Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(OffsetKt.m139paddingqDBjuR0$default(OffsetKt.m137paddingVpY3zN4$default(Modifier.Companion.$$INSTANCE, 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), CropImageView.DEFAULT_ASPECT_RATIO, 6.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13), 1.0f), z2 ? 52.0f : 62.0f);
            boolean z3 = (i3 & 896) == 256;
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (z3 || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new AppNavigationKt$$ExternalSyntheticLambda6(lensController, (byte) 0);
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(ImageKt.m42borderxT4_qwU(ImageKt.m39backgroundbw27NRU(ClipKt.clip(ColorKt.graphicsLayer(modifierM145height3ABfNKs, (Function1) objRememberedValue4), roundedCornerShape), z ? -66407130768343040L : colorScheme.surfaceContainer, ColorKt.RectangleShape), 1.0f, colorScheme.outlineVariant, roundedCornerShape), 5.0f);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(LayoutNode.Constructor);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            final ArrayList arrayList4 = arrayList;
            GapComposer gapComposer3 = gapComposer2;
            OffsetKt.BoxWithConstraints(SizeKt.FillWholeMaxSize, null, Expect_jvmKt.rememberComposableLambda(-657906099, new Function3() { // from class: com.metrolist.music.ui.component.AppNavigationKt$$ExternalSyntheticLambda7
                /* JADX WARN: Code duplicated, block: B:100:0x0381  */
                /* JADX WARN: Code duplicated, block: B:104:0x03a0  */
                /* JADX WARN: Code duplicated, block: B:107:0x03cc  */
                /* JADX WARN: Code duplicated, block: B:108:0x03d0  */
                /* JADX WARN: Code duplicated, block: B:110:0x0429  */
                /* JADX WARN: Code duplicated, block: B:38:0x016e A[PHI: r16
                  0x016e: PHI (r16v19 androidx.compose.runtime.Updater$$ExternalSyntheticLambda0) = 
                  (r16v4 androidx.compose.runtime.Updater$$ExternalSyntheticLambda0)
                  (r16v20 androidx.compose.runtime.Updater$$ExternalSyntheticLambda0)
                 binds: [B:41:0x0176, B:37:0x016c] A[DONT_GENERATE, DONT_INLINE]] */
                /* JADX WARN: Code duplicated, block: B:39:0x0171 A[PHI: r16
                  0x0171: PHI (r16v5 androidx.compose.runtime.Updater$$ExternalSyntheticLambda0) = 
                  (r16v4 androidx.compose.runtime.Updater$$ExternalSyntheticLambda0)
                  (r16v20 androidx.compose.runtime.Updater$$ExternalSyntheticLambda0)
                 binds: [B:41:0x0176, B:37:0x016c] A[DONT_GENERATE, DONT_INLINE]] */
                /* JADX WARN: Code duplicated, block: B:84:0x02bc  */
                /* JADX WARN: Code duplicated, block: B:86:0x02c2  */
                /* JADX WARN: Code duplicated, block: B:89:0x02f3  */
                /* JADX WARN: Code duplicated, block: B:90:0x02f7  */
                /* JADX WARN: Code duplicated, block: B:94:0x033c  */
                /* JADX WARN: Code duplicated, block: B:97:0x0361  */
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) throws XmlPullParserException, IOException {
                    float f;
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0;
                    boolean z4;
                    NeverEqualPolicy neverEqualPolicy2;
                    final int i6;
                    ArrayList arrayList5;
                    boolean zChanged2;
                    Object objRememberedValue5;
                    byte b;
                    boolean z5;
                    final LensController lensController2;
                    boolean zChanged3;
                    Object objRememberedValue6;
                    boolean zChanged4;
                    Object objRememberedValue7;
                    AppNavigationKt$$ExternalSyntheticLambda7 appNavigationKt$$ExternalSyntheticLambda7 = this;
                    BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj3;
                    Composer composer2 = (Composer) obj4;
                    int iIntValue = ((Integer) obj5).intValue();
                    Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
                    boxWithConstraintsScopeImpl.getClass();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= ((GapComposer) composer2).changed(boxWithConstraintsScopeImpl) ? 4 : 2;
                    }
                    byte b2 = 1;
                    GapComposer gapComposer4 = (GapComposer) composer2;
                    if (gapComposer4.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                        float fM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(boxWithConstraintsScopeImpl.constraints);
                        final int i7 = i4;
                        final float f2 = fM784getMaxWidthimpl / i7;
                        final LensController lensController3 = lensController;
                        boolean zChanged5 = gapComposer4.changed(lensController3);
                        final float f3 = fMo81toPx0680j_5;
                        boolean zChanged6 = zChanged5 | gapComposer4.changed(f3) | gapComposer4.changed(i7);
                        final List list3 = list2;
                        boolean zChangedInstance = zChanged6 | gapComposer4.changedInstance(list3);
                        final float f4 = fMo81toPx0680j_4;
                        boolean zChanged7 = zChangedInstance | gapComposer4.changed(f4) | gapComposer4.changed(f2);
                        Object objRememberedValue8 = gapComposer4.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy3 = Composer.Companion.Empty;
                        if (zChanged7 || objRememberedValue8 == neverEqualPolicy3) {
                            Function3 function4 = new Function3() { // from class: com.metrolist.music.ui.component.AppNavigationKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj6, Object obj7, Object obj8) {
                                    MeasureScope measureScope = (MeasureScope) obj6;
                                    Measurable measurable = (Measurable) obj7;
                                    Constraints constraints = (Constraints) obj8;
                                    measureScope.getClass();
                                    measurable.getClass();
                                    final float fFloatValue = ((Number) lensController3.pos.getValue()).floatValue();
                                    float fFloatValue2 = f3;
                                    for (int i8 = 0; i8 < i7; i8++) {
                                        fFloatValue2 += (((Number) list3.get(i8)).floatValue() + f4) * UuidKt.coerceIn(1.0f - Math.abs(fFloatValue - i8), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                    }
                                    final int iRoundToInt = MathKt.roundToInt(fFloatValue2);
                                    long j2 = constraints.value;
                                    int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(j2);
                                    if (iRoundToInt > iM784getMaxWidthimpl) {
                                        iRoundToInt = iM784getMaxWidthimpl;
                                    }
                                    int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j2);
                                    if (!((iM783getMaxHeightimpl >= 0) & (iRoundToInt >= 0))) {
                                        InlineClassHelperKt.throwIllegalArgumentException("width and height must be >= 0");
                                    }
                                    final Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(ConstraintsKt.createConstraints(iRoundToInt, iRoundToInt, iM783getMaxHeightimpl, iM783getMaxHeightimpl));
                                    int iM784getMaxWidthimpl2 = Constraints.m784getMaxWidthimpl(j2);
                                    int iM783getMaxHeightimpl2 = Constraints.m783getMaxHeightimpl(j2);
                                    final float f5 = f2;
                                    return measureScope.layout(iM784getMaxWidthimpl2, iM783getMaxHeightimpl2, EmptyMap.INSTANCE, new Function1() { // from class: com.metrolist.music.ui.component.AppNavigationKt$$ExternalSyntheticLambda29
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj9) {
                                            Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj9;
                                            placementScope.getClass();
                                            placementScope.place(placeableMo598measureBRTryo0, MathKt.roundToInt(((fFloatValue + 0.5f) * f5) - (iRoundToInt / 2.0f)), 0, CropImageView.DEFAULT_ASPECT_RATIO);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                            };
                            f = f4;
                            gapComposer4.updateRememberedValue(function4);
                            objRememberedValue8 = function4;
                        } else {
                            f = f4;
                        }
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier modifierLayout = RulerKt.layout(companion, (Function3) objRememberedValue8);
                        boolean zChanged8 = gapComposer4.changed(lensController3);
                        Object objRememberedValue9 = gapComposer4.rememberedValue();
                        if (zChanged8 || objRememberedValue9 == neverEqualPolicy3) {
                            objRememberedValue9 = new AppNavigationKt$$ExternalSyntheticLambda6(lensController3, b2);
                            gapComposer4.updateRememberedValue(objRememberedValue9);
                        }
                        Modifier modifierGraphicsLayer = ColorKt.graphicsLayer(modifierLayout, (Function1) objRememberedValue9);
                        RoundedCornerShape roundedCornerShape3 = roundedCornerShape2;
                        Modifier modifierClip = ClipKt.clip(modifierGraphicsLayer, roundedCornerShape3);
                        long j2 = j;
                        BoxKt.Box(ImageKt.m42borderxT4_qwU(ImageKt.m39backgroundbw27NRU(modifierClip, ColorKt.Color(Color.m485getRedimpl(j2), Color.m484getGreenimpl(j2), Color.m482getBlueimpl(j2), 0.14f, Color.m483getColorSpaceimpl(j2)), ColorKt.RectangleShape), 1.0f, ColorKt.Color(Color.m485getRedimpl(j2), Color.m484getGreenimpl(j2), Color.m482getBlueimpl(j2), 0.34f, Color.m483getColorSpaceimpl(j2)), roundedCornerShape3), gapComposer4, 0);
                        FillElement fillElement = SizeKt.FillWholeMaxSize;
                        Integer numValueOf = Integer.valueOf(lensController3.n);
                        Float fValueOf = Float.valueOf(f2);
                        AppNavigationKt$lensGestures$1 appNavigationKt$lensGestures$1 = new AppNavigationKt$lensGestures$1(lensController3, f2);
                        PointerEvent pointerEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
                        Modifier modifierThen = fillElement.then(new SuspendPointerInputElement(numValueOf, fValueOf, appNavigationKt$lensGestures$1, 4));
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$End$1, Alignment.Companion.Top, gapComposer4, 0);
                        int iHashCode2 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer4.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierThen);
                        ComposeUiNode.Companion.getClass();
                        gapComposer4.startReusableNode();
                        boolean z6 = gapComposer4.inserting;
                        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                        if (z6) {
                            gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer4.useNode();
                        }
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m390setimpl(gapComposer4, rowMeasurePolicy, updater$$ExternalSyntheticLambda1);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer4, updater$$ExternalSyntheticLambda3, gapComposer4);
                        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = ComposeUiNode.Companion.SetModifier;
                        Stack.m390setimpl(gapComposer4, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda4);
                        gapComposer4.startReplaceGroup(918581528);
                        int i8 = 0;
                        for (Object obj6 : list) {
                            int i9 = i8 + 1;
                            final float f5 = f;
                            if (i8 < 0) {
                                CollectionsKt__IterablesKt.throwIndexOverflow();
                                throw null;
                            }
                            Screens screens = (Screens) obj6;
                            boolean dragging = lensController3.getDragging();
                            int i10 = i;
                            if (dragging) {
                                updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda1;
                                if (lensController3.getNearest() == i8) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                            } else {
                                updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda1;
                                if (i10 == i8) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                            }
                            int i11 = z4 ? screens.iconIdActive : screens.iconIdInactive;
                            boolean zAreEqual = Intrinsics.areEqual(screens, Screens.Search.INSTANCE);
                            long j3 = j2;
                            Function0 function5 = function0;
                            boolean z7 = zAreEqual && function5 != null;
                            boolean zAreEqual2 = Intrinsics.areEqual(screens, Screens.Home.INSTANCE);
                            Function0 function6 = function3;
                            boolean z8 = zAreEqual2 && function6 != null;
                            boolean z9 = z7;
                            Object objRememberedValue10 = gapComposer4.rememberedValue();
                            if (objRememberedValue10 == neverEqualPolicy3) {
                                objRememberedValue10 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer4);
                            }
                            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue10;
                            NeverEqualPolicy neverEqualPolicy4 = neverEqualPolicy3;
                            boolean z10 = i10 == i8;
                            GapComposer gapComposer5 = gapComposer4;
                            Function2 function7 = function2;
                            Modifier.Companion companion2 = companion;
                            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda5 = updater$$ExternalSyntheticLambda0;
                            AppNavigationKt.NavLongPress(screens, mutableInteractionSourceImpl, z10, function7, function5, function6, gapComposer5, 48);
                            Arrangement$End$1 arrangement$End$2 = arrangement$End$1;
                            AnimateAsState animateAsStateM17animateColorAsStateeuL9pac = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(z4 ? j3 : colorScheme.onSurfaceVariant, ArcSplineKt.tween$default(180, 0, null, 6), "pillNavContent", gapComposer5, 432, 8);
                            AnimateAsState animateAsStateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z4 ? 1.12f : 1.0f, ArcSplineKt.spring$default(0.45f, 1500.0f, null, 4), "pillNavIcon", gapComposer5, 3120, 20);
                            Modifier modifierThen2 = new LayoutWeightElement(1.0f, true).then(SizeKt.FillWholeMaxHeight);
                            Role role = new Role(4);
                            boolean zChanged9 = gapComposer5.changed(z9) | gapComposer5.changed(z8) | gapComposer5.changed(function7) | gapComposer5.changed(screens) | gapComposer5.changed(i10) | gapComposer5.changed(i8);
                            Object objRememberedValue11 = gapComposer5.rememberedValue();
                            if (zChanged9) {
                                neverEqualPolicy2 = neverEqualPolicy4;
                            } else {
                                neverEqualPolicy2 = neverEqualPolicy4;
                                if (objRememberedValue11 != neverEqualPolicy2) {
                                    i6 = i8;
                                }
                                Modifier modifierM45clickableO2vRcR0$default = ImageKt.m45clickableO2vRcR0$default(modifierThen2, mutableInteractionSourceImpl, null, false, role, (Function0) objRememberedValue11, 12);
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                                int iHashCode3 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer5.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer5, modifierM45clickableO2vRcR0$default);
                                ComposeUiNode.Companion.getClass();
                                gapComposer5.startReusableNode();
                                if (gapComposer5.inserting) {
                                    gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                                } else {
                                    gapComposer5.useNode();
                                }
                                Stack.m390setimpl(gapComposer5, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda5);
                                Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer5, updater$$ExternalSyntheticLambda3, gapComposer5);
                                Stack.m390setimpl(gapComposer5, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda4);
                                RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$End$2, Alignment.Companion.CenterVertically, gapComposer5, 48);
                                int iHashCode4 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer5.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer5, companion2);
                                gapComposer5.startReusableNode();
                                if (gapComposer5.inserting) {
                                    gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                                } else {
                                    gapComposer5.useNode();
                                }
                                Stack.m390setimpl(gapComposer5, rowMeasurePolicy2, updater$$ExternalSyntheticLambda5);
                                Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer5, updater$$ExternalSyntheticLambda3, gapComposer5);
                                Stack.m390setimpl(gapComposer5, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda4);
                                Painter painterPainterResource = IntMath.painterResource(i11, 0, gapComposer5);
                                arrayList5 = arrayList4;
                                String str = (String) arrayList5.get(i6);
                                long j4 = ((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value;
                                Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion2, 24.0f);
                                zChanged2 = gapComposer5.changed(animateAsStateAnimateFloatAsState);
                                objRememberedValue5 = gapComposer5.rememberedValue();
                                b = 3;
                                if (zChanged2 || objRememberedValue5 == neverEqualPolicy2) {
                                    objRememberedValue5 = new AppBarKt$$ExternalSyntheticLambda3(animateAsStateAnimateFloatAsState, b);
                                    gapComposer5.updateRememberedValue(objRememberedValue5);
                                }
                                Modifier modifierGraphicsLayer2 = ColorKt.graphicsLayer(modifierM151size3ABfNKs, (Function1) objRememberedValue5);
                                NeverEqualPolicy neverEqualPolicy5 = neverEqualPolicy2;
                                IconKt.m290Iconww6aTOc(painterPainterResource, str, modifierGraphicsLayer2, j4, gapComposer5, 8, 0);
                                gapComposer4 = gapComposer5;
                                if (z2) {
                                    f = f5;
                                    z5 = true;
                                    gapComposer4.startReplaceGroup(-1948727473);
                                    gapComposer4.end(false);
                                } else {
                                    gapComposer4.startReplaceGroup(-1949979656);
                                    lensController2 = lensController3;
                                    zChanged3 = gapComposer4.changed(lensController2) | gapComposer4.changed(i6) | gapComposer4.changed(f5);
                                    objRememberedValue6 = gapComposer4.rememberedValue();
                                    if (zChanged3 || objRememberedValue6 == neverEqualPolicy5) {
                                        objRememberedValue6 = new Function3() { // from class: com.metrolist.music.ui.component.AppNavigationKt$$ExternalSyntheticLambda16
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj7, Object obj8, Object obj9) {
                                                MeasureScope measureScope = (MeasureScope) obj7;
                                                Measurable measurable = (Measurable) obj8;
                                                measureScope.getClass();
                                                measurable.getClass();
                                                float fCoerceIn = UuidKt.coerceIn(1.0f - Math.abs(((Number) lensController2.pos.getValue()).floatValue() - i6), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                                Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(ConstraintsKt.Constraints$default(0, 0, 0, 0, 15));
                                                float f6 = placeableMo598measureBRTryo0.width;
                                                float f7 = f5;
                                                return measureScope.layout(MathKt.roundToInt((f6 + f7) * fCoerceIn), placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BottomSheetKt$$ExternalSyntheticLambda14(placeableMo598measureBRTryo0, f7, fCoerceIn));
                                            }
                                        };
                                        gapComposer4.updateRememberedValue(objRememberedValue6);
                                    }
                                    Modifier modifierLayout2 = RulerKt.layout(companion2, (Function3) objRememberedValue6);
                                    zChanged4 = gapComposer4.changed(lensController2) | gapComposer4.changed(i6);
                                    objRememberedValue7 = gapComposer4.rememberedValue();
                                    if (zChanged4 || objRememberedValue7 == neverEqualPolicy5) {
                                        objRememberedValue7 = new RawWebSocketCommonKt$$ExternalSyntheticLambda0(lensController2, i6, (byte) 3);
                                        gapComposer4.updateRememberedValue(objRememberedValue7);
                                    }
                                    Modifier modifierGraphicsLayer3 = ColorKt.graphicsLayer(modifierLayout2, (Function1) objRememberedValue7);
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                                    int iHashCode5 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer4.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierGraphicsLayer3);
                                    gapComposer4.startReusableNode();
                                    if (gapComposer4.inserting) {
                                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                                    } else {
                                        gapComposer4.useNode();
                                    }
                                    Stack.m390setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy3, updater$$ExternalSyntheticLambda5);
                                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer4, updater$$ExternalSyntheticLambda3, gapComposer4);
                                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda4);
                                    f = f5;
                                    lensController3 = lensController2;
                                    TextKt.m352TextNvy7gAk((String) arrayList5.get(i6), null, ((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value, 0L, null, null, null, 0L, null, 0L, 1, false, 1, 0, textStyle, gapComposer4, 0, 28032, 102394);
                                    gapComposer4 = gapComposer4;
                                    z5 = true;
                                    gapComposer4.end(true);
                                    gapComposer4.end(false);
                                }
                                gapComposer4.end(z5);
                                gapComposer4.end(z5);
                                appNavigationKt$$ExternalSyntheticLambda7 = this;
                                updater$$ExternalSyntheticLambda1 = updater$$ExternalSyntheticLambda5;
                                i8 = i9;
                                lensController3 = lensController3;
                                j2 = j3;
                                neverEqualPolicy3 = neverEqualPolicy5;
                                companion = companion2;
                                arrangement$End$1 = arrangement$End$2;
                            }
                            int i12 = i8;
                            objRememberedValue11 = new AppNavigationKt$$ExternalSyntheticLambda14(z9, z8, function7, screens, i10, i12, (byte) 0);
                            i6 = i12;
                            gapComposer5.updateRememberedValue(objRememberedValue11);
                            Modifier modifierM45clickableO2vRcR0$default2 = ImageKt.m45clickableO2vRcR0$default(modifierThen2, mutableInteractionSourceImpl, null, false, role, (Function0) objRememberedValue11, 12);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                            int iHashCode6 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer5.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer5, modifierM45clickableO2vRcR0$default2);
                            ComposeUiNode.Companion.getClass();
                            gapComposer5.startReusableNode();
                            if (gapComposer5.inserting) {
                                gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                            } else {
                                gapComposer5.useNode();
                            }
                            Stack.m390setimpl(gapComposer5, measurePolicyMaybeCachedBoxMeasurePolicy4, updater$$ExternalSyntheticLambda5);
                            Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda2);
                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode6, gapComposer5, updater$$ExternalSyntheticLambda3, gapComposer5);
                            Stack.m390setimpl(gapComposer5, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda4);
                            RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement$End$2, Alignment.Companion.CenterVertically, gapComposer5, 48);
                            int iHashCode7 = Long.hashCode(gapComposer5.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope7 = gapComposer5.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier7 = ZIndexModifierKt.materializeModifier(gapComposer5, companion2);
                            gapComposer5.startReusableNode();
                            if (gapComposer5.inserting) {
                                gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                            } else {
                                gapComposer5.useNode();
                            }
                            Stack.m390setimpl(gapComposer5, rowMeasurePolicy3, updater$$ExternalSyntheticLambda5);
                            Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope7, updater$$ExternalSyntheticLambda2);
                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode7, gapComposer5, updater$$ExternalSyntheticLambda3, gapComposer5);
                            Stack.m390setimpl(gapComposer5, modifierMaterializeModifier7, updater$$ExternalSyntheticLambda4);
                            Painter painterPainterResource2 = IntMath.painterResource(i11, 0, gapComposer5);
                            arrayList5 = arrayList4;
                            String str2 = (String) arrayList5.get(i6);
                            long j5 = ((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value;
                            Modifier modifierM151size3ABfNKs2 = SizeKt.m151size3ABfNKs(companion2, 24.0f);
                            zChanged2 = gapComposer5.changed(animateAsStateAnimateFloatAsState);
                            objRememberedValue5 = gapComposer5.rememberedValue();
                            b = 3;
                            if (zChanged2) {
                                objRememberedValue5 = new AppBarKt$$ExternalSyntheticLambda3(animateAsStateAnimateFloatAsState, b);
                                gapComposer5.updateRememberedValue(objRememberedValue5);
                            } else {
                                objRememberedValue5 = new AppBarKt$$ExternalSyntheticLambda3(animateAsStateAnimateFloatAsState, b);
                                gapComposer5.updateRememberedValue(objRememberedValue5);
                            }
                            Modifier modifierGraphicsLayer4 = ColorKt.graphicsLayer(modifierM151size3ABfNKs2, (Function1) objRememberedValue5);
                            NeverEqualPolicy neverEqualPolicy6 = neverEqualPolicy2;
                            IconKt.m290Iconww6aTOc(painterPainterResource2, str2, modifierGraphicsLayer4, j5, gapComposer5, 8, 0);
                            gapComposer4 = gapComposer5;
                            if (z2) {
                                gapComposer4.startReplaceGroup(-1949979656);
                                lensController2 = lensController3;
                                zChanged3 = gapComposer4.changed(lensController2) | gapComposer4.changed(i6) | gapComposer4.changed(f5);
                                objRememberedValue6 = gapComposer4.rememberedValue();
                                if (zChanged3) {
                                    objRememberedValue6 = new Function3() { // from class: com.metrolist.music.ui.component.AppNavigationKt$$ExternalSyntheticLambda16
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj7, Object obj8, Object obj9) {
                                            MeasureScope measureScope = (MeasureScope) obj7;
                                            Measurable measurable = (Measurable) obj8;
                                            measureScope.getClass();
                                            measurable.getClass();
                                            float fCoerceIn = UuidKt.coerceIn(1.0f - Math.abs(((Number) lensController2.pos.getValue()).floatValue() - i6), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                            Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(ConstraintsKt.Constraints$default(0, 0, 0, 0, 15));
                                            float f6 = placeableMo598measureBRTryo0.width;
                                            float f7 = f5;
                                            return measureScope.layout(MathKt.roundToInt((f6 + f7) * fCoerceIn), placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BottomSheetKt$$ExternalSyntheticLambda14(placeableMo598measureBRTryo0, f7, fCoerceIn));
                                        }
                                    };
                                    gapComposer4.updateRememberedValue(objRememberedValue6);
                                } else {
                                    objRememberedValue6 = new Function3() { // from class: com.metrolist.music.ui.component.AppNavigationKt$$ExternalSyntheticLambda16
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj7, Object obj8, Object obj9) {
                                            MeasureScope measureScope = (MeasureScope) obj7;
                                            Measurable measurable = (Measurable) obj8;
                                            measureScope.getClass();
                                            measurable.getClass();
                                            float fCoerceIn = UuidKt.coerceIn(1.0f - Math.abs(((Number) lensController2.pos.getValue()).floatValue() - i6), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                                            Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(ConstraintsKt.Constraints$default(0, 0, 0, 0, 15));
                                            float f6 = placeableMo598measureBRTryo0.width;
                                            float f7 = f5;
                                            return measureScope.layout(MathKt.roundToInt((f6 + f7) * fCoerceIn), placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BottomSheetKt$$ExternalSyntheticLambda14(placeableMo598measureBRTryo0, f7, fCoerceIn));
                                        }
                                    };
                                    gapComposer4.updateRememberedValue(objRememberedValue6);
                                }
                                Modifier modifierLayout3 = RulerKt.layout(companion2, (Function3) objRememberedValue6);
                                zChanged4 = gapComposer4.changed(lensController2) | gapComposer4.changed(i6);
                                objRememberedValue7 = gapComposer4.rememberedValue();
                                if (zChanged4) {
                                    objRememberedValue7 = new RawWebSocketCommonKt$$ExternalSyntheticLambda0(lensController2, i6, (byte) 3);
                                    gapComposer4.updateRememberedValue(objRememberedValue7);
                                } else {
                                    objRememberedValue7 = new RawWebSocketCommonKt$$ExternalSyntheticLambda0(lensController2, i6, (byte) 3);
                                    gapComposer4.updateRememberedValue(objRememberedValue7);
                                }
                                Modifier modifierGraphicsLayer5 = ColorKt.graphicsLayer(modifierLayout3, (Function1) objRememberedValue7);
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                                int iHashCode8 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope8 = gapComposer4.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier8 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierGraphicsLayer5);
                                gapComposer4.startReusableNode();
                                if (gapComposer4.inserting) {
                                    gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                                } else {
                                    gapComposer4.useNode();
                                }
                                Stack.m390setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy5, updater$$ExternalSyntheticLambda5);
                                Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope8, updater$$ExternalSyntheticLambda2);
                                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode8, gapComposer4, updater$$ExternalSyntheticLambda3, gapComposer4);
                                Stack.m390setimpl(gapComposer4, modifierMaterializeModifier8, updater$$ExternalSyntheticLambda4);
                                f = f5;
                                lensController3 = lensController2;
                                TextKt.m352TextNvy7gAk((String) arrayList5.get(i6), null, ((Color) animateAsStateM17animateColorAsStateeuL9pac.getValue()).value, 0L, null, null, null, 0L, null, 0L, 1, false, 1, 0, textStyle, gapComposer4, 0, 28032, 102394);
                                gapComposer4 = gapComposer4;
                                z5 = true;
                                gapComposer4.end(true);
                                gapComposer4.end(false);
                            } else {
                                f = f5;
                                z5 = true;
                                gapComposer4.startReplaceGroup(-1948727473);
                                gapComposer4.end(false);
                            }
                            gapComposer4.end(z5);
                            gapComposer4.end(z5);
                            appNavigationKt$$ExternalSyntheticLambda7 = this;
                            updater$$ExternalSyntheticLambda1 = updater$$ExternalSyntheticLambda5;
                            i8 = i9;
                            lensController3 = lensController3;
                            j2 = j3;
                            neverEqualPolicy3 = neverEqualPolicy6;
                            companion = companion2;
                            arrangement$End$1 = arrangement$End$2;
                        }
                        gapComposer4.end(false);
                        gapComposer4.end(true);
                    } else {
                        gapComposer4.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer3), gapComposer3, 3078, 6);
            gapComposer3.end(true);
            gapComposer = gapComposer3;
        } else {
            gapComposer2.skipToGroupEnd();
            gapComposer = gapComposer2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AppNavigationKt$$ExternalSyntheticLambda8(list, i, lensController, function2, z, z2, function0, function1, i2, (byte) 0);
        }
    }

    public static final boolean isRouteSelected(String str, String str2, List list) {
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
            if (list == null || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((Screens) it.next()).route.equals(str2)) {
                        if (!StringsKt__StringsJVMKt.startsWith(str, str2.concat("/"), false)) {
                            break;
                        }
                        return true;
                    }
                }
            }
            if (str2.equals("search_input") && (StringsKt__StringsJVMKt.startsWith(str, "search/", false) || str.equals("search/{query}"))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:33:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:34:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:37:0x011b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0148  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public static final Object lensGesture(SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine, LensController lensController, float f, BaseContinuationImpl baseContinuationImpl) {
        AnonymousClass1 anonymousClass1;
        LensController lensController2;
        float f2;
        Object objAwaitFirstDown$default;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine2;
        float f3;
        Ref$FloatRef ref$FloatRef;
        LensController lensController3;
        VelocityTracker velocityTracker;
        PointerInputChange pointerInputChange;
        long j;
        AppNavigationKt$$ExternalSyntheticLambda27 appNavigationKt$$ExternalSyntheticLambda27;
        PointerInputChange pointerInputChange2;
        VelocityTracker velocityTracker2;
        LensController lensController4;
        float fM819getXimpl;
        boolean dragging;
        CoroutineScope coroutineScope;
        int iCoerceIn;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine3 = pointerEventHandlerCoroutine;
        if (baseContinuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) baseContinuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(baseContinuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(baseContinuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        byte b = 2;
        byte b2 = 0;
        byte b3 = 1;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            anonymousClass1.L$0 = pointerEventHandlerCoroutine3;
            lensController2 = lensController;
            anonymousClass1.L$1 = lensController2;
            f2 = f;
            anonymousClass1.F$0 = f2;
            anonymousClass1.label = 1;
            objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(pointerEventHandlerCoroutine3, anonymousClass1, 2);
            if (objAwaitFirstDown$default != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            float f4 = anonymousClass1.F$0;
            LensController lensController5 = anonymousClass1.L$1;
            SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine4 = anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            f2 = f4;
            pointerEventHandlerCoroutine3 = pointerEventHandlerCoroutine4;
            objAwaitFirstDown$default = obj;
            lensController2 = lensController5;
        } else {
            if (i2 == 2) {
                f3 = anonymousClass1.F$0;
                ref$FloatRef = anonymousClass1.L$4;
                velocityTracker = anonymousClass1.L$3;
                lensController3 = anonymousClass1.L$1;
                pointerEventHandlerCoroutine2 = anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    j = pointerInputChange.id;
                    appNavigationKt$$ExternalSyntheticLambda27 = new AppNavigationKt$$ExternalSyntheticLambda27(velocityTracker, ref$FloatRef, f3, lensController3);
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = lensController3;
                    anonymousClass1.L$3 = velocityTracker;
                    anonymousClass1.L$4 = null;
                    anonymousClass1.L$5 = pointerInputChange;
                    anonymousClass1.F$0 = f3;
                    anonymousClass1.label = 3;
                    if (ScrollableKt.m92horizontalDragjO51t88(pointerEventHandlerCoroutine2, j, appNavigationKt$$ExternalSyntheticLambda27, anonymousClass1) != coroutineSingletons) {
                        pointerInputChange2 = pointerInputChange;
                        velocityTracker2 = velocityTracker;
                        lensController4 = lensController3;
                    }
                    return coroutineSingletons;
                }
                if (pointerInputChange != null) {
                    fM819getXimpl = Velocity.m819getXimpl(velocityTracker.m595calculateVelocity9UxMQ8M());
                } else {
                    fM819getXimpl = CropImageView.DEFAULT_ASPECT_RATIO;
                }
                dragging = lensController3.getDragging();
                coroutineScope = lensController3.scope;
                lensController3.dragging$delegate.setValue(Boolean.FALSE);
                AwaitKt.launch$default(coroutineScope, null, null, new AnonymousClass2(lensController3, continuation, b3), 3);
                AwaitKt.launch$default(coroutineScope, null, null, new AnonymousClass2(lensController3, continuation, b), 3);
                if (dragging) {
                    iCoerceIn = UuidKt.coerceIn(MathKt.roundToInt(((fM819getXimpl / f3) * 0.18f) + ((Number) lensController3.pos.getValue()).floatValue()), 0, lensController3.n - 1);
                    AwaitKt.launch$default(coroutineScope, null, null, new LensController$slideTo$1(lensController3, iCoerceIn, null, (byte) 1), 3);
                    if (iCoerceIn != lensController3.selected$delegate.getIntValue()) {
                        ((PlatformHapticFeedback) lensController3.haptics).m578performHapticFeedbackCdsT49E(0);
                        lensController3.onSelect.invoke(new Integer(iCoerceIn));
                    }
                }
                return Unit.INSTANCE;
            }
            if (i2 != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            f3 = anonymousClass1.F$0;
            pointerInputChange2 = anonymousClass1.L$5;
            velocityTracker2 = anonymousClass1.L$3;
            lensController4 = anonymousClass1.L$1;
            ResultKt.throwOnFailure(obj);
        }
        lensController3 = lensController4;
        pointerInputChange = pointerInputChange2;
        velocityTracker = velocityTracker2;
        if (pointerInputChange != null) {
            fM819getXimpl = Velocity.m819getXimpl(velocityTracker.m595calculateVelocity9UxMQ8M());
        } else {
            fM819getXimpl = CropImageView.DEFAULT_ASPECT_RATIO;
        }
        dragging = lensController3.getDragging();
        coroutineScope = lensController3.scope;
        lensController3.dragging$delegate.setValue(Boolean.FALSE);
        AwaitKt.launch$default(coroutineScope, null, null, new AnonymousClass2(lensController3, continuation, b3), 3);
        AwaitKt.launch$default(coroutineScope, null, null, new AnonymousClass2(lensController3, continuation, b), 3);
        if (dragging) {
            iCoerceIn = UuidKt.coerceIn(MathKt.roundToInt(((fM819getXimpl / f3) * 0.18f) + ((Number) lensController3.pos.getValue()).floatValue()), 0, lensController3.n - 1);
            AwaitKt.launch$default(coroutineScope, null, null, new LensController$slideTo$1(lensController3, iCoerceIn, null, (byte) 1), 3);
            if (iCoerceIn != lensController3.selected$delegate.getIntValue()) {
                ((PlatformHapticFeedback) lensController3.haptics).m578performHapticFeedbackCdsT49E(0);
                lensController3.onSelect.invoke(new Integer(iCoerceIn));
            }
        }
        return Unit.INSTANCE;
        PointerInputChange pointerInputChange3 = (PointerInputChange) objAwaitFirstDown$default;
        AwaitKt.launch$default(lensController2.scope, null, null, new AnonymousClass2(lensController2, continuation, b2), 3);
        VelocityTracker velocityTracker3 = new VelocityTracker();
        velocityTracker3.m594addPositionUv8p0NA(pointerInputChange3.uptimeMillis, pointerInputChange3.position);
        Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
        ref$FloatRef2.element = ((Number) lensController2.pos.getValue()).floatValue();
        long j2 = pointerInputChange3.id;
        AlertDialogKt$$ExternalSyntheticLambda11 alertDialogKt$$ExternalSyntheticLambda11 = new AlertDialogKt$$ExternalSyntheticLambda11(lensController2, ref$FloatRef2, f2);
        anonymousClass1.L$0 = pointerEventHandlerCoroutine3;
        anonymousClass1.L$1 = lensController2;
        anonymousClass1.L$3 = velocityTracker3;
        anonymousClass1.L$4 = ref$FloatRef2;
        anonymousClass1.F$0 = f2;
        anonymousClass1.label = 2;
        Object objM86awaitHorizontalTouchSlopOrCancellationjO51t88 = ScrollableKt.m86awaitHorizontalTouchSlopOrCancellationjO51t88(pointerEventHandlerCoroutine3, j2, alertDialogKt$$ExternalSyntheticLambda11, anonymousClass1);
        if (objM86awaitHorizontalTouchSlopOrCancellationjO51t88 != coroutineSingletons) {
            pointerEventHandlerCoroutine2 = pointerEventHandlerCoroutine3;
            f3 = f2;
            ref$FloatRef = ref$FloatRef2;
            lensController3 = lensController2;
            obj = objM86awaitHorizontalTouchSlopOrCancellationjO51t88;
            velocityTracker = velocityTracker3;
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
                j = pointerInputChange.id;
                appNavigationKt$$ExternalSyntheticLambda27 = new AppNavigationKt$$ExternalSyntheticLambda27(velocityTracker, ref$FloatRef, f3, lensController3);
                anonymousClass1.L$0 = null;
                anonymousClass1.L$1 = lensController3;
                anonymousClass1.L$3 = velocityTracker;
                anonymousClass1.L$4 = null;
                anonymousClass1.L$5 = pointerInputChange;
                anonymousClass1.F$0 = f3;
                anonymousClass1.label = 3;
                if (ScrollableKt.m92horizontalDragjO51t88(pointerEventHandlerCoroutine2, j, appNavigationKt$$ExternalSyntheticLambda27, anonymousClass1) != coroutineSingletons) {
                    pointerInputChange2 = pointerInputChange;
                    velocityTracker2 = velocityTracker;
                    lensController4 = lensController3;
                    lensController3 = lensController4;
                    pointerInputChange = pointerInputChange2;
                    velocityTracker = velocityTracker2;
                }
            }
            if (pointerInputChange != null) {
                fM819getXimpl = Velocity.m819getXimpl(velocityTracker.m595calculateVelocity9UxMQ8M());
            } else {
                fM819getXimpl = CropImageView.DEFAULT_ASPECT_RATIO;
            }
            dragging = lensController3.getDragging();
            coroutineScope = lensController3.scope;
            lensController3.dragging$delegate.setValue(Boolean.FALSE);
            AwaitKt.launch$default(coroutineScope, null, null, new AnonymousClass2(lensController3, continuation, b3), 3);
            AwaitKt.launch$default(coroutineScope, null, null, new AnonymousClass2(lensController3, continuation, b), 3);
            if (dragging) {
                iCoerceIn = UuidKt.coerceIn(MathKt.roundToInt(((fM819getXimpl / f3) * 0.18f) + ((Number) lensController3.pos.getValue()).floatValue()), 0, lensController3.n - 1);
                AwaitKt.launch$default(coroutineScope, null, null, new LensController$slideTo$1(lensController3, iCoerceIn, null, (byte) 1), 3);
                if (iCoerceIn != lensController3.selected$delegate.getIntValue()) {
                    ((PlatformHapticFeedback) lensController3.haptics).m578performHapticFeedbackCdsT49E(0);
                    lensController3.onSelect.invoke(new Integer(iCoerceIn));
                }
            }
            return Unit.INSTANCE;
        }
        return coroutineSingletons;
    }
}
