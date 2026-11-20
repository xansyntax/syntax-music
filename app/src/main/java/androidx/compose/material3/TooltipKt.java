package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.internal.Lock;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.material3.internal.BasicTooltipDefaults;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.media3.extractor.flv.TagPayloadReader;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda29;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TooltipKt {
    public static final PaddingValuesImpl PlainTooltipContentPadding = new PaddingValuesImpl(8.0f, 4.0f, 8.0f, 4.0f);

    /* JADX INFO: renamed from: PlainTooltip-gv3ox5I, reason: not valid java name */
    public static final void m361PlainTooltipgv3ox5I(final TooltipScopeImpl tooltipScopeImpl, final Modifier modifier, final float f, final Shape shape, final long j, final long j2, final ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i) {
        int i2;
        GapComposer gapComposer;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-343758958);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer2.changed(tooltipScopeImpl) : gapComposer2.changedInstance(tooltipScopeImpl) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer2.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer2.changed((Object) null) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer2.changed(f) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer2.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer2.changed(j) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer2.changed(j2) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= gapComposer2.changed(CropImageView.DEFAULT_ASPECT_RATIO) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= gapComposer2.changed(CropImageView.DEFAULT_ASPECT_RATIO) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i2 |= gapComposer2.changedInstance(composableLambdaImpl) ? 536870912 : WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        if (gapComposer2.shouldExecute(i2 & 1, (306783379 & i2) != 306783378)) {
            gapComposer2.startDefaults();
            if ((i & 1) != 0 && !gapComposer2.getDefaultsInvalid()) {
                gapComposer2.skipToGroupEnd();
            }
            gapComposer2.endDefaults();
            gapComposer2.startReplaceGroup(-1719845879);
            gapComposer2.end(false);
            int i3 = 12582912 | ((i2 >> 12) & 896);
            int i4 = i2 >> 9;
            gapComposer = gapComposer2;
            SurfaceKt.m337SurfaceT9BRK9s(modifier, shape, j2, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(-1573998995, new TooltipKt$$ExternalSyntheticLambda10(f, j, composableLambdaImpl), gapComposer2), gapComposer, i3 | (57344 & i4) | (i4 & 458752), 72);
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    TooltipKt.m361PlainTooltipgv3ox5I(tooltipScopeImpl, modifier, f, shape, j, j2, composableLambdaImpl, (Composer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: PlainTooltipInternal-kw8QeXY, reason: not valid java name */
    public static final void m362PlainTooltipInternalkw8QeXY(final TooltipScopeImpl tooltipScopeImpl, final String str, Modifier modifier, float f, Shape shape, long j, long j2, final ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i) {
        int i2;
        final Modifier modifier2;
        final float f2;
        final Shape shape2;
        final long j3;
        final long j4;
        int i3;
        Shape shape3;
        float f3;
        long value;
        long j5;
        Modifier modifier3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1931523930);
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? gapComposer.changed(tooltipScopeImpl) : gapComposer.changedInstance(tooltipScopeImpl) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(str) ? 32 : 16;
        }
        int i4 = i2 | 28032;
        if ((i & 196608) == 0) {
            i4 = 93568 | i2;
        }
        if ((i & 1572864) == 0) {
            i4 |= 524288;
        }
        if ((i & 12582912) == 0) {
            i4 |= 4194304;
        }
        int i5 = 905969664 | i4;
        if (gapComposer.shouldExecute(i5 & 1, (306783379 & i5) != 306783378)) {
            gapComposer.startDefaults();
            int i6 = i & 1;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (i6 == 0 || gapComposer.getDefaultsInvalid()) {
                float f4 = TooltipDefaults.plainTooltipMaxWidth;
                Shape value2 = ShapesKt.getValue(4, gapComposer);
                long value3 = ColorSchemeKt.getValue(3, gapComposer);
                i3 = i5 & (-33488897);
                shape3 = value2;
                f3 = f4;
                value = ColorSchemeKt.getValue(5, gapComposer);
                j5 = value3;
                modifier3 = companion;
            } else {
                gapComposer.skipToGroupEnd();
                i3 = i5 & (-33488897);
                modifier3 = modifier;
                f3 = f;
                shape3 = shape;
                j5 = j;
                value = j2;
            }
            gapComposer.endDefaults();
            boolean z = (i3 & 112) == 32;
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new IconKt$$ExternalSyntheticLambda1(str, (byte) 9);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierThen = SemanticsModifierKt.semantics(companion, false, (Function1) objRememberedValue).then(modifier3);
            int i7 = i3 & 14;
            int i8 = i3 >> 3;
            long j6 = j5;
            long j7 = value;
            m361PlainTooltipgv3ox5I(tooltipScopeImpl, modifierThen, f3, shape3, j6, j7, composableLambdaImpl, gapComposer, (i8 & 234881024) | i7 | (i8 & 896) | (i8 & 7168) | (29360128 & i8) | 805306368);
            j4 = j7;
            j3 = j6;
            f2 = f3;
            shape2 = shape3;
            modifier2 = modifier3;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            f2 = f;
            shape2 = shape;
            j3 = j;
            j4 = j2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    TooltipKt.m362PlainTooltipInternalkw8QeXY(tooltipScopeImpl, str, modifier2, f2, shape2, j3, j4, composableLambdaImpl, (Composer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:105:0x0204  */
    /* JADX WARN: Code duplicated, block: B:107:0x0211  */
    /* JADX WARN: Code duplicated, block: B:111:0x0218  */
    /* JADX WARN: Code duplicated, block: B:114:0x0220  */
    /* JADX WARN: Code duplicated, block: B:122:0x0240  */
    /* JADX WARN: Code duplicated, block: B:125:0x0258  */
    /* JADX WARN: Code duplicated, block: B:126:0x025b  */
    /* JADX WARN: Code duplicated, block: B:130:0x026f  */
    /* JADX WARN: Code duplicated, block: B:134:0x028e  */
    /* JADX WARN: Code duplicated, block: B:138:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:140:0x030a  */
    /* JADX WARN: Code duplicated, block: B:143:0x0316  */
    /* JADX WARN: Code duplicated, block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:44:0x007f  */
    /* JADX WARN: Code duplicated, block: B:48:0x008d  */
    /* JADX WARN: Code duplicated, block: B:49:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0098 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x009a  */
    /* JADX WARN: Code duplicated, block: B:54:0x009d  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:69:0x0121  */
    /* JADX WARN: Code duplicated, block: B:75:0x0135  */
    /* JADX WARN: Code duplicated, block: B:77:0x013b  */
    /* JADX WARN: Code duplicated, block: B:79:0x0144  */
    /* JADX WARN: Code duplicated, block: B:87:0x0163  */
    /* JADX WARN: Code duplicated, block: B:90:0x0180  */
    /* JADX WARN: Code duplicated, block: B:91:0x0183  */
    /* JADX WARN: Code duplicated, block: B:95:0x0198  */
    /* JADX WARN: Code duplicated, block: B:98:0x01b5  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean, byte] */
    public static final void TooltipBox(final PopupPositionProvider popupPositionProvider, final ComposableLambdaImpl composableLambdaImpl, final TooltipStateImpl tooltipStateImpl, Modifier modifier, boolean z, final ComposableLambdaImpl composableLambdaImpl2, Composer composer, final int i, final int i2) {
        int i3;
        ComposableLambdaImpl composableLambdaImpl3;
        Modifier modifier2;
        int i4;
        boolean z2;
        final boolean z3;
        final Modifier modifier3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier modifier4;
        Transition transitionRememberTransition;
        Object objRememberedValue;
        Object obj;
        MutableState mutableState;
        Object objRememberedValue2;
        ComposableLambdaImpl composableLambdaImplRememberComposableLambda;
        Object objRememberedValue3;
        MutableState mutableState2;
        Object objRememberedValue4;
        boolean zIsSeeking;
        TagPayloadReader tagPayloadReader;
        ?? r0;
        Object objM;
        boolean zBooleanValue;
        float f;
        boolean zChanged;
        Object objRememberedValue5;
        boolean zChanged2;
        Object objRememberedValue6;
        Object obj2;
        boolean z4;
        Object objM2;
        boolean zBooleanValue2;
        float f2;
        boolean zChanged3;
        Object objRememberedValue7;
        boolean zChanged4;
        Object objRememberedValue8;
        boolean zChanged5;
        Snapshot currentThreadSnapshot;
        Function1 readObserver;
        Snapshot snapshotMakeCurrentNonObservable;
        boolean zChanged6;
        Snapshot currentThreadSnapshot2;
        Function1 readObserver2;
        Snapshot snapshotMakeCurrentNonObservable2;
        int i5;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-293753984);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(popupPositionProvider) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            composableLambdaImpl3 = composableLambdaImpl;
            i3 |= gapComposer.changedInstance(composableLambdaImpl3) ? 32 : 16;
        } else {
            composableLambdaImpl3 = composableLambdaImpl;
        }
        if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? gapComposer.changed(tooltipStateImpl) : gapComposer.changedInstance(tooltipStateImpl) ? 256 : 128;
        }
        int i6 = i2 & 8;
        if (i6 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= gapComposer.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i3 | 14376960;
            if ((100663296 & i) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl2)) {
                    i5 = 67108864;
                } else {
                    i5 = 33554432;
                }
                i4 |= i5;
            }
            if ((38347923 & i4) != 38347922) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (gapComposer.shouldExecute(i4 & 1, z2)) {
                if (i6 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                transitionRememberTransition = ArcSplineKt.rememberTransition(tooltipStateImpl.transition, "tooltip transition", gapComposer, 48);
                objRememberedValue = gapComposer.rememberedValue();
                obj = Composer.Companion.Empty;
                if (objRememberedValue == obj) {
                    objRememberedValue = Stack.mutableStateOf$default(null);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == obj) {
                    new MainActivity$$ExternalSyntheticLambda29(mutableState, (byte) 11);
                    objRememberedValue2 = new TooltipScopeImpl();
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                TooltipScopeImpl tooltipScopeImpl = (TooltipScopeImpl) objRememberedValue2;
                composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-23901870, new ButtonKt$$ExternalSyntheticLambda1(mutableState, composableLambdaImpl2, (byte) 23), gapComposer);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (objRememberedValue3 == obj) {
                    objRememberedValue3 = Stack.mutableStateOf$default(null);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                mutableState2 = (MutableState) objRememberedValue3;
                objRememberedValue4 = gapComposer.rememberedValue();
                if (objRememberedValue4 == obj) {
                    objRememberedValue4 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$$ExternalSyntheticLambda2(mutableState, mutableState2, (byte) 0));
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                State state = (State) objRememberedValue4;
                FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs = CardKt.m272valueyDoVZcs(1, gapComposer);
                FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs2 = CardKt.m272valueyDoVZcs(4, gapComposer);
                TwoWayConverterImpl twoWayConverterImpl = ArcSplineKt.FloatToVector;
                zIsSeeking = transitionRememberTransition.isSeeking();
                tagPayloadReader = transitionRememberTransition.transitionState;
                if (zIsSeeking) {
                    composableLambdaImplRememberComposableLambda = composableLambdaImplRememberComposableLambda;
                    r0 = 0;
                    objM = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
                } else {
                    gapComposer.startReplaceGroup(1666573488);
                    zChanged6 = gapComposer.changed(transitionRememberTransition);
                    objM = gapComposer.rememberedValue();
                    if (zChanged6 || objM == obj) {
                        currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                        if (currentThreadSnapshot2 != null) {
                            readObserver2 = currentThreadSnapshot2.getReadObserver();
                        } else {
                            readObserver2 = null;
                        }
                        snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                        try {
                            Object currentState = tagPayloadReader.getCurrentState();
                            Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                            gapComposer.updateRememberedValue(currentState);
                            objM = currentState;
                        } catch (Throwable th) {
                            Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                            throw th;
                        }
                    }
                    r0 = 0;
                    gapComposer.end(false);
                }
                zBooleanValue = ((Boolean) objM).booleanValue();
                gapComposer.startReplaceGroup(838300572);
                if (zBooleanValue) {
                    f = 1.0f;
                } else {
                    f = 0.8f;
                }
                gapComposer.end(r0);
                Float fValueOf = Float.valueOf(f);
                zChanged = gapComposer.changed(transitionRememberTransition);
                objRememberedValue5 = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue5 == obj) {
                    objRememberedValue5 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, r0));
                    gapComposer.updateRememberedValue(objRememberedValue5);
                }
                boolean zBooleanValue3 = ((Boolean) ((State) objRememberedValue5).getValue()).booleanValue();
                gapComposer.startReplaceGroup(838300572);
                float f3 = zBooleanValue3 ? 1.0f : 0.8f;
                gapComposer.end(false);
                Float fValueOf2 = Float.valueOf(f3);
                zChanged2 = gapComposer.changed(transitionRememberTransition);
                objRememberedValue6 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue6 == obj) {
                    objRememberedValue6 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, (byte) 5));
                    gapComposer.updateRememberedValue(objRememberedValue6);
                }
                gapComposer.startReplaceGroup(-1664496585);
                gapComposer.end(false);
                Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionRememberTransition, fValueOf, fValueOf2, finiteAnimationSpecM272valueyDoVZcs, twoWayConverterImpl, gapComposer, 196608);
                if (transitionRememberTransition.isSeeking()) {
                    obj2 = obj;
                    z4 = false;
                    objM2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
                } else {
                    gapComposer.startReplaceGroup(1666573488);
                    zChanged5 = gapComposer.changed(transitionRememberTransition);
                    objM2 = gapComposer.rememberedValue();
                    try {
                        if (zChanged5) {
                            obj2 = obj;
                        } else {
                            obj2 = obj;
                            if (objM2 == obj2) {
                            }
                            gapComposer.end(false);
                            z4 = false;
                        }
                        Object currentState2 = tagPayloadReader.getCurrentState();
                        Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        gapComposer.updateRememberedValue(currentState2);
                        objM2 = currentState2;
                        gapComposer.end(false);
                        z4 = false;
                    } catch (Throwable th2) {
                        Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        throw th2;
                    }
                    currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                    readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                    snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                }
                zBooleanValue2 = ((Boolean) objM2).booleanValue();
                gapComposer.startReplaceGroup(-1903393104);
                if (zBooleanValue2) {
                    f2 = 1.0f;
                } else {
                    f2 = CropImageView.DEFAULT_ASPECT_RATIO;
                }
                gapComposer.end(z4);
                Float fValueOf3 = Float.valueOf(f2);
                zChanged3 = gapComposer.changed(transitionRememberTransition);
                objRememberedValue7 = gapComposer.rememberedValue();
                if (zChanged3 || objRememberedValue7 == obj2) {
                    objRememberedValue7 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, (byte) 6));
                    gapComposer.updateRememberedValue(objRememberedValue7);
                }
                boolean zBooleanValue4 = ((Boolean) ((State) objRememberedValue7).getValue()).booleanValue();
                gapComposer.startReplaceGroup(-1903393104);
                float f4 = zBooleanValue4 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO;
                gapComposer.end(z4);
                Float fValueOf4 = Float.valueOf(f4);
                zChanged4 = gapComposer.changed(transitionRememberTransition);
                objRememberedValue8 = gapComposer.rememberedValue();
                if (zChanged4 || objRememberedValue8 == obj2) {
                    objRememberedValue8 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, (byte) 7));
                    gapComposer.updateRememberedValue(objRememberedValue8);
                }
                gapComposer.startReplaceGroup(-111222965);
                gapComposer.end(z4);
                int i7 = (i4 & 14) | 100663344 | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (i4 & 29360128);
                Modifier modifier5 = modifier4;
                Icons$Filled.BasicTooltipBox(popupPositionProvider, Expect_jvmKt.rememberComposableLambda(-527401546, new TooltipKt$$ExternalSyntheticLambda3(mutableState2, transitionAnimationStateCreateTransitionAnimation, ArcSplineKt.createTransitionAnimation(transitionRememberTransition, fValueOf3, fValueOf4, finiteAnimationSpecM272valueyDoVZcs2, twoWayConverterImpl, gapComposer, 196608), state, composableLambdaImpl3, tooltipScopeImpl), gapComposer), tooltipStateImpl, modifier5, composableLambdaImplRememberComposableLambda, gapComposer, i7);
                modifier3 = modifier5;
                z3 = true;
            } else {
                gapComposer.skipToGroupEnd();
                z3 = z;
                modifier3 = modifier2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        ((Integer) obj4).getClass();
                        TooltipKt.TooltipBox(popupPositionProvider, composableLambdaImpl, tooltipStateImpl, modifier3, z3, composableLambdaImpl2, (Composer) obj3, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i3 | 14376960;
        if ((100663296 & i) == 0) {
            if (gapComposer.changedInstance(composableLambdaImpl2)) {
                i5 = 67108864;
            } else {
                i5 = 33554432;
            }
            i4 |= i5;
        }
        if ((38347923 & i4) != 38347922) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (gapComposer.shouldExecute(i4 & 1, z2)) {
            if (i6 != 0) {
                modifier4 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            transitionRememberTransition = ArcSplineKt.rememberTransition(tooltipStateImpl.transition, "tooltip transition", gapComposer, 48);
            objRememberedValue = gapComposer.rememberedValue();
            obj = Composer.Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == obj) {
                new MainActivity$$ExternalSyntheticLambda29(mutableState, (byte) 11);
                objRememberedValue2 = new TooltipScopeImpl();
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            TooltipScopeImpl tooltipScopeImpl2 = (TooltipScopeImpl) objRememberedValue2;
            composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-23901870, new ButtonKt$$ExternalSyntheticLambda1(mutableState, composableLambdaImpl2, (byte) 23), gapComposer);
            objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == obj) {
                objRememberedValue3 = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            mutableState2 = (MutableState) objRememberedValue3;
            objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == obj) {
                objRememberedValue4 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$$ExternalSyntheticLambda2(mutableState, mutableState2, (byte) 0));
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            State state2 = (State) objRememberedValue4;
            FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs3 = CardKt.m272valueyDoVZcs(1, gapComposer);
            FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs4 = CardKt.m272valueyDoVZcs(4, gapComposer);
            TwoWayConverterImpl twoWayConverterImpl2 = ArcSplineKt.FloatToVector;
            zIsSeeking = transitionRememberTransition.isSeeking();
            tagPayloadReader = transitionRememberTransition.transitionState;
            if (zIsSeeking) {
                gapComposer.startReplaceGroup(1666573488);
                zChanged6 = gapComposer.changed(transitionRememberTransition);
                objM = gapComposer.rememberedValue();
                if (zChanged6) {
                    currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot2 != null) {
                        readObserver2 = currentThreadSnapshot2.getReadObserver();
                    } else {
                        readObserver2 = null;
                    }
                    snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                    Object currentState3 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    gapComposer.updateRememberedValue(currentState3);
                    objM = currentState3;
                } else {
                    currentThreadSnapshot2 = Lock.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot2 != null) {
                        readObserver2 = currentThreadSnapshot2.getReadObserver();
                    } else {
                        readObserver2 = null;
                    }
                    snapshotMakeCurrentNonObservable2 = Lock.makeCurrentNonObservable(currentThreadSnapshot2);
                    Object currentState4 = tagPayloadReader.getCurrentState();
                    Lock.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                    gapComposer.updateRememberedValue(currentState4);
                    objM = currentState4;
                }
                r0 = 0;
                gapComposer.end(false);
            } else {
                composableLambdaImplRememberComposableLambda = composableLambdaImplRememberComposableLambda;
                r0 = 0;
                objM = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
            }
            zBooleanValue = ((Boolean) objM).booleanValue();
            gapComposer.startReplaceGroup(838300572);
            if (zBooleanValue) {
                f = 1.0f;
            } else {
                f = 0.8f;
            }
            gapComposer.end(r0);
            Float fValueOf5 = Float.valueOf(f);
            zChanged = gapComposer.changed(transitionRememberTransition);
            objRememberedValue5 = gapComposer.rememberedValue();
            if (zChanged) {
                objRememberedValue5 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, r0));
                gapComposer.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, r0));
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            boolean zBooleanValue5 = ((Boolean) ((State) objRememberedValue5).getValue()).booleanValue();
            gapComposer.startReplaceGroup(838300572);
            if (zBooleanValue5) {
            }
            gapComposer.end(false);
            Float fValueOf6 = Float.valueOf(f3);
            zChanged2 = gapComposer.changed(transitionRememberTransition);
            objRememberedValue6 = gapComposer.rememberedValue();
            if (zChanged2) {
                objRememberedValue6 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, (byte) 5));
                gapComposer.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, (byte) 5));
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            gapComposer.startReplaceGroup(-1664496585);
            gapComposer.end(false);
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionRememberTransition, fValueOf5, fValueOf6, finiteAnimationSpecM272valueyDoVZcs3, twoWayConverterImpl2, gapComposer, 196608);
            if (transitionRememberTransition.isSeeking()) {
                gapComposer.startReplaceGroup(1666573488);
                zChanged5 = gapComposer.changed(transitionRememberTransition);
                objM2 = gapComposer.rememberedValue();
                if (zChanged5) {
                    obj2 = obj;
                    if (objM2 == obj2) {
                    }
                    gapComposer.end(false);
                    z4 = false;
                } else {
                    obj2 = obj;
                }
                currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
                readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
                Object currentState5 = tagPayloadReader.getCurrentState();
                Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                gapComposer.updateRememberedValue(currentState5);
                objM2 = currentState5;
                gapComposer.end(false);
                z4 = false;
            } else {
                obj2 = obj;
                z4 = false;
                objM2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer, 1666827533, false, tagPayloadReader);
            }
            zBooleanValue2 = ((Boolean) objM2).booleanValue();
            gapComposer.startReplaceGroup(-1903393104);
            if (zBooleanValue2) {
                f2 = 1.0f;
            } else {
                f2 = CropImageView.DEFAULT_ASPECT_RATIO;
            }
            gapComposer.end(z4);
            Float fValueOf7 = Float.valueOf(f2);
            zChanged3 = gapComposer.changed(transitionRememberTransition);
            objRememberedValue7 = gapComposer.rememberedValue();
            if (zChanged3) {
                objRememberedValue7 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, (byte) 6));
                gapComposer.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, (byte) 6));
                gapComposer.updateRememberedValue(objRememberedValue7);
            }
            boolean zBooleanValue6 = ((Boolean) ((State) objRememberedValue7).getValue()).booleanValue();
            gapComposer.startReplaceGroup(-1903393104);
            if (zBooleanValue6) {
            }
            gapComposer.end(z4);
            Float fValueOf8 = Float.valueOf(f4);
            zChanged4 = gapComposer.changed(transitionRememberTransition);
            objRememberedValue8 = gapComposer.rememberedValue();
            if (zChanged4) {
                objRememberedValue8 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, (byte) 7));
                gapComposer.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionRememberTransition, (byte) 7));
                gapComposer.updateRememberedValue(objRememberedValue8);
            }
            gapComposer.startReplaceGroup(-111222965);
            gapComposer.end(z4);
            int i8 = (i4 & 14) | 100663344 | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (i4 & 29360128);
            Modifier modifier6 = modifier4;
            Icons$Filled.BasicTooltipBox(popupPositionProvider, Expect_jvmKt.rememberComposableLambda(-527401546, new TooltipKt$$ExternalSyntheticLambda3(mutableState2, transitionAnimationStateCreateTransitionAnimation2, ArcSplineKt.createTransitionAnimation(transitionRememberTransition, fValueOf7, fValueOf8, finiteAnimationSpecM272valueyDoVZcs4, twoWayConverterImpl2, gapComposer, 196608), state2, composableLambdaImpl3, tooltipScopeImpl2), gapComposer), tooltipStateImpl, modifier6, composableLambdaImplRememberComposableLambda, gapComposer, i8);
            modifier3 = modifier6;
            z3 = true;
        } else {
            gapComposer.skipToGroupEnd();
            z3 = z;
            modifier3 = modifier2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    ((Integer) obj4).getClass();
                    TooltipKt.TooltipBox(popupPositionProvider, composableLambdaImpl, tooltipStateImpl, modifier3, z3, composableLambdaImpl2, (Composer) obj3, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final TooltipStateImpl rememberTooltipState(Composer composer) {
        MutatorMutex mutatorMutex = BasicTooltipDefaults.GlobalMutatorMutex;
        boolean zChanged = ((GapComposer) composer).changed(false) | ((GapComposer) composer).changed(mutatorMutex);
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new TooltipStateImpl(mutatorMutex);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (TooltipStateImpl) objRememberedValue;
    }
}
