package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.navigation.NavDeepLinkRequest;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.LinkHeader;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppBarKt {
    public static final float TopAppBarTitleInset;

    static {
        new CubicBezierEasing(0.8f, CropImageView.DEFAULT_ASPECT_RATIO, 0.8f, 0.15f);
        TopAppBarTitleInset = 12.0f;
    }

    /* JADX INFO: renamed from: SingleRowTopAppBar-TCVpFMg, reason: not valid java name */
    public static final void m243SingleRowTopAppBarTCVpFMg(final Modifier modifier, final Function2 function2, final TextStyle textStyle, final TextStyle textStyle2, final Function2 function3, final Function3 function4, final float f, final PaddingValues paddingValues, final WindowInsets windowInsets, final TopAppBarColors topAppBarColors, final NavDeepLinkRequest navDeepLinkRequest, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        GapComposer gapComposer;
        TopAppBarState topAppBarState;
        Modifier modifierOnSizeChanged;
        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(703932376);
        if ((i & 6) == 0) {
            i3 = (gapComposer2.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer2.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer2.changed(textStyle) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer2.changedInstance(null) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer2.changed(textStyle2) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= gapComposer2.changed(horizontal) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= gapComposer2.changedInstance(function3) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer2.changedInstance(function4) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= gapComposer2.changed(f) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= gapComposer2.changed(paddingValues) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (gapComposer2.changed(windowInsets) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer2.changed(topAppBarColors) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= gapComposer2.changed(navDeepLinkRequest) ? 256 : 128;
        }
        int i5 = i4;
        int i6 = i3;
        if (!gapComposer2.shouldExecute(i6 & 1, ((i3 & 306783379) == 306783378 && (i5 & 147) == 146) ? false : true)) {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        } else {
            if (Float.isNaN(f) || (Float.floatToRawIntBits(f) & Integer.MAX_VALUE) >= 2139095040) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The expandedHeight is expected to be specified and finite");
                return;
            }
            int i7 = i5 & 896;
            boolean z = ((i5 & 112) == 32) | (i7 == 256);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = SnapshotStateKt__DerivedStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$targetColor$2$1
                    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        float fCoerceIn;
                        TopAppBarState topAppBarState2;
                        NavDeepLinkRequest navDeepLinkRequest2 = navDeepLinkRequest;
                        if (navDeepLinkRequest2 == null || (topAppBarState2 = (TopAppBarState) navDeepLinkRequest2.uri) == null) {
                            fCoerceIn = 0.0f;
                        } else {
                            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = topAppBarState2.contentOffset$delegate;
                            float f2 = topAppBarState2.heightOffsetLimit;
                            if (f2 == CropImageView.DEFAULT_ASPECT_RATIO) {
                                fCoerceIn = 0.0f;
                            } else {
                                fCoerceIn = 1.0f - (UuidKt.coerceIn(Math.abs(parcelableSnapshotMutableFloatState.getFloatValue()) + f2, topAppBarState2.heightOffsetLimit, CropImageView.DEFAULT_ASPECT_RATIO) / topAppBarState2.heightOffsetLimit);
                            }
                        }
                        float f3 = fCoerceIn <= 0.01f ? 0.0f : 1.0f;
                        TopAppBarColors topAppBarColors2 = topAppBarColors;
                        return new Color(ColorKt.m493lerpjxsXWHM(topAppBarColors2.containerColor, topAppBarColors2.scrolledContainerColor, EasingKt.FastOutLinearInEasing.transform(f3)));
                    }
                });
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            AnimateAsState animateAsStateM17animateColorAsStateeuL9pac = SingleValueAnimationKt.m17animateColorAsStateeuL9pac(((Color) ((State) objRememberedValue).getValue()).value, CardKt.m272valueyDoVZcs(3, gapComposer2), null, gapComposer2, 0, 12);
            gapComposer = gapComposer2;
            byte b = 0;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1222546095, new AppBarKt$$ExternalSyntheticLambda2(function4, b), gapComposer);
            gapComposer.startReplaceGroup(-1473335574);
            gapComposer.end(false);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierThen = modifier.then(companion);
            boolean zChanged = gapComposer.changed(animateAsStateM17animateColorAsStateeuL9pac);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new AppBarKt$$ExternalSyntheticLambda3(animateAsStateM17animateColorAsStateeuL9pac, b);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierDrawBehind = ClipKt.drawBehind(modifierThen, (Function1) objRememberedValue2);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new ChipKt$$ExternalSyntheticLambda3((byte) 17);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierDrawBehind, false, (Function1) objRememberedValue3);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = SurfaceKt$Surface$1$3$1.INSTANCE$1;
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierSemantics, Unit.INSTANCE, (PointerInputEventHandler) objRememberedValue4);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierPointerInput);
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
            Modifier modifierClipToBounds = ClipKt.clipToBounds(OffsetKt.windowInsetsPadding(companion, windowInsets));
            Modifier modifier2 = (navDeepLinkRequest == null || (topAppBarState = (TopAppBarState) navDeepLinkRequest.uri) == null || (modifierOnSizeChanged = RulerKt.onSizeChanged(modifierClipToBounds, new TextKt$$ExternalSyntheticLambda2((byte) 1, topAppBarState))) == null) ? modifierClipToBounds : modifierOnSizeChanged;
            boolean z2 = i7 == 256;
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (z2 || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new AppBarKt$$ExternalSyntheticLambda5((byte) 0, navDeepLinkRequest);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            FloatProducer floatProducer = (FloatProducer) objRememberedValue5;
            long j = topAppBarColors.navigationIconContentColor;
            long j2 = topAppBarColors.titleContentColor;
            long j3 = topAppBarColors.actionIconContentColor;
            long j4 = topAppBarColors.subtitleContentColor;
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = new TextKt$$ExternalSyntheticLambda3((byte) 2);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            int i8 = i6 >> 3;
            m245TopAppBarLayout_5F1rQI(modifier2, floatProducer, j, j2, j4, j3, function2, textStyle, textStyle2, (Function0) objRememberedValue6, function3, composableLambdaImplRememberComposableLambda, f, paddingValues, gapComposer, (i6 << 15) & 2146959360, ((i6 >> 9) & 896) | 1600566 | (i8 & 458752) | (i8 & 29360128) | (i8 & 234881024));
            gapComposer.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    AppBarKt.m243SingleRowTopAppBarTCVpFMg(modifier, function2, textStyle, textStyle2, function3, function4, f, paddingValues, windowInsets, topAppBarColors, navDeepLinkRequest, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: TopAppBar-gNPyAyM, reason: not valid java name */
    public static final void m244TopAppBargNPyAyM(final Function2 function2, final Modifier modifier, final Function2 function3, final Function3 function4, final float f, final WindowInsets windowInsets, final TopAppBarColors topAppBarColors, final NavDeepLinkRequest navDeepLinkRequest, PaddingValues paddingValues, Composer composer, final int i) {
        int i2;
        GapComposer gapComposer;
        final PaddingValues paddingValues2;
        PaddingValues paddingValues3;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(660588393);
        if ((i & 6) == 0) {
            i2 = (gapComposer2.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer2.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer2.changedInstance(function3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer2.changedInstance(function4) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer2.changed(f) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer2.changed(windowInsets) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer2.changed(topAppBarColors) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= gapComposer2.changed(navDeepLinkRequest) ? 8388608 : 4194304;
        }
        int i3 = i2 | 100663296;
        if (gapComposer2.shouldExecute(i3 & 1, (38347923 & i3) != 38347922)) {
            gapComposer2.startDefaults();
            if ((i & 1) == 0 || gapComposer2.getDefaultsInvalid()) {
                paddingValues3 = TopAppBarDefaults.ContentPadding;
            } else {
                gapComposer2.skipToGroupEnd();
                paddingValues3 = paddingValues;
            }
            gapComposer2.endDefaults();
            int i4 = i3 << 3;
            int i5 = i3 << 12;
            gapComposer = gapComposer2;
            m243SingleRowTopAppBarTCVpFMg(modifier, function2, CardKt.getValue(12, gapComposer2), TextStyle.Default, function3, function4, (Dp.m796equalsimpl0(f, Float.NaN) || Dp.m796equalsimpl0(f, Float.POSITIVE_INFINITY)) ? TopAppBarDefaults.TopAppBarExpandedHeight : f, paddingValues3, windowInsets, topAppBarColors, navDeepLinkRequest, gapComposer, ((i3 >> 3) & 14) | 224256 | (i4 & 112) | (i5 & 3670016) | (i5 & 29360128) | (i4 & 1879048192), (i3 >> 15) & 1022);
            paddingValues2 = paddingValues3;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            paddingValues2 = paddingValues;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    AppBarKt.m244TopAppBargNPyAyM(function2, modifier, function3, function4, f, windowInsets, topAppBarColors, navDeepLinkRequest, paddingValues2, (Composer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: TopAppBarLayout-_5F1rQI, reason: not valid java name */
    public static final void m245TopAppBarLayout_5F1rQI(final Modifier modifier, final FloatProducer floatProducer, final long j, final long j2, final long j3, long j4, final Function2 function2, final TextStyle textStyle, final TextStyle textStyle2, final Function0 function0, final Function2 function3, ComposableLambdaImpl composableLambdaImpl, final float f, final PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        PaddingValues paddingValues2;
        ComposableLambdaImpl composableLambdaImpl2;
        GapComposer gapComposer;
        boolean z;
        final long j5 = j4;
        FlowRowOverflow flowRowOverflow = OffsetKt.Center;
        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(239553141);
        if ((i & 6) == 0) {
            i3 = i | (gapComposer2.changed(modifier) ? 4 : 2);
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= (i & 64) == 0 ? gapComposer2.changed(floatProducer) : gapComposer2.changedInstance(floatProducer) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer2.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer2.changed(j2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer2.changed(j3) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= gapComposer2.changed(j5) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer2.changed(textStyle) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= gapComposer2.changedInstance(null) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= gapComposer2.changed(textStyle2) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (gapComposer2.changedInstance(function0) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer2.changed(flowRowOverflow) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= gapComposer2.changed(horizontal) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= gapComposer2.changed(0) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= gapComposer2.changed(false) ? 16384 : 8192;
        }
        if ((i2 & 196608) == 0) {
            i4 |= gapComposer2.changedInstance(function3) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= gapComposer2.changedInstance(composableLambdaImpl) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= gapComposer2.changed(f) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            paddingValues2 = paddingValues;
            i4 |= gapComposer2.changed(paddingValues2) ? 67108864 : 33554432;
        } else {
            paddingValues2 = paddingValues;
        }
        int i5 = i4;
        if (gapComposer2.shouldExecute(i3 & 1, ((i3 & 306783379) == 306783378 && (38347923 & i5) == 38347922) ? false : true)) {
            boolean z2 = ((i3 & 112) == 32 || ((i3 & 64) != 0 && gapComposer2.changed(floatProducer))) | ((i5 & 112) == 32) | ((i5 & 896) == 256) | ((i5 & 7168) == 2048) | ((29360128 & i5) == 8388608);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z2 || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new TopAppBarMeasurePolicy(floatProducer, f, paddingValues2);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            TopAppBarMeasurePolicy topAppBarMeasurePolicy = (TopAppBarMeasurePolicy) objRememberedValue;
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifier);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            boolean z3 = gapComposer2.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z3) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer2, topAppBarMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer2);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(RulerKt.layoutId(companion, "navigationIcon"), 4.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14);
            BiasAlignment biasAlignment = Alignment.Companion.TopStart;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM139paddingqDBjuR0$default);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = ContentColorKt.LocalContentColor;
            Stack.CompositionLocalProvider(Fragment$5$$ExternalSyntheticOutline0.m(j, staticProvidableCompositionLocal), function3, gapComposer2, ((i5 >> 12) & 112) | 8);
            gapComposer2.end(true);
            gapComposer2.startReplaceGroup(408669108);
            Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(RulerKt.layoutId(companion, LinkHeader.Parameters.Title), 4.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            gapComposer2.startReplaceGroup(-402447002);
            gapComposer2.end(false);
            Modifier modifierThen = modifierM137paddingVpY3zN4$default.then(companion);
            boolean z4 = (i5 & 14) == 4;
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (z4 || objRememberedValue2 == neverEqualPolicy) {
                z = false;
                objRememberedValue2 = new AppBarKt$$ExternalSyntheticLambda8(function0, (byte) 0);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            } else {
                z = false;
            }
            Modifier modifierGraphicsLayer = ColorKt.graphicsLayer(modifierThen, (Function1) objRememberedValue2);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, z);
            int iHashCode3 = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierGraphicsLayer);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
            Icons$Filled.m370ProvideContentColorTextStyle3JVO9M(j2, textStyle, function2, gapComposer2, ((i3 >> 9) & 14) | ((i3 >> 18) & 112) | ((i3 >> 12) & 896));
            gapComposer = gapComposer2;
            gapComposer.end(true);
            gapComposer.end(false);
            Modifier modifierM139paddingqDBjuR0$default2 = OffsetKt.m139paddingqDBjuR0$default(RulerKt.layoutId(companion, "actionIcons"), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, CropImageView.DEFAULT_ASPECT_RATIO, 11);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            int iHashCode4 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM139paddingqDBjuR0$default2);
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
            j5 = j4;
            composableLambdaImpl2 = composableLambdaImpl;
            Stack.CompositionLocalProvider(staticProvidableCompositionLocal.defaultProvidedValue$runtime(new Color(j5)), composableLambdaImpl2, gapComposer, 8 | ((i5 >> 15) & 112));
            gapComposer.end(true);
            gapComposer.end(true);
        } else {
            composableLambdaImpl2 = composableLambdaImpl;
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final ComposableLambdaImpl composableLambdaImpl3 = composableLambdaImpl2;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    AppBarKt.m245TopAppBarLayout_5F1rQI(modifier, floatProducer, j, j2, j3, j5, function2, textStyle, textStyle2, function0, function3, composableLambdaImpl3, f, paddingValues, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
