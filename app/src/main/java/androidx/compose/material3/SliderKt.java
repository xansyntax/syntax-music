package androidx.compose.material3;

import android.view.KeyEvent;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.HoverableElement;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeElement;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerHoverIconModifierElement;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.room.InvalidationTracker$createFlow$2;
import coil3.RealImageLoader;
import coil3.util.LifecyclesKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.utils.io.ByteChannelKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.ClosedFloatRange;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SliderKt {
    public static final VerticalAlignmentLine CornerSizeAlignmentLine = new VerticalAlignmentLine(SliderKt$CornerSizeAlignmentLine$1.INSTANCE);

    /* JADX WARN: Code duplicated, block: B:100:0x0143  */
    /* JADX WARN: Code duplicated, block: B:106:0x0152 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:107:0x0154  */
    /* JADX WARN: Code duplicated, block: B:109:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:112:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0053  */
    /* JADX WARN: Code duplicated, block: B:32:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x005c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:41:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0080  */
    /* JADX WARN: Code duplicated, block: B:49:0x0083  */
    /* JADX WARN: Code duplicated, block: B:51:0x008b  */
    /* JADX WARN: Code duplicated, block: B:52:0x008e  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:81:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:83:0x0102  */
    /* JADX WARN: Code duplicated, block: B:86:0x0107  */
    /* JADX WARN: Code duplicated, block: B:87:0x0111  */
    /* JADX WARN: Code duplicated, block: B:90:0x0119  */
    /* JADX WARN: Code duplicated, block: B:94:0x012f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0132  */
    /* JADX WARN: Code duplicated, block: B:98:0x013d  */
    public static final void Slider(final float f, final Function1 function1, Modifier modifier, boolean z, final ClosedFloatRange closedFloatRange, int i, SliderColors sliderColors, MutableInteractionSourceImpl mutableInteractionSourceImpl, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        SliderColors sliderColorsColors;
        int i12;
        boolean z3;
        boolean z4;
        final MutableInteractionSourceImpl mutableInteractionSourceImpl2;
        final Modifier modifier3;
        final boolean z5;
        final int i13;
        final SliderColors sliderColors2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i14;
        NeverEqualPolicy neverEqualPolicy;
        int i15;
        Object objRememberedValue;
        int i16;
        int i17;
        boolean z6;
        boolean z7;
        Object objRememberedValue2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-202044027);
        if ((i2 & 6) == 0) {
            i4 = (gapComposer.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer.changedInstance(function1) ? 32 : 16;
        }
        int i18 = i3 & 4;
        if (i18 == 0) {
            if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i4 |= gapComposer.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 3072) == 0) {
                    z2 = z;
                    if (gapComposer.changed(z2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                if (gapComposer.changed(closedFloatRange)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i8 = i4 | i7;
                i9 = i3 & 32;
                if (i9 != 0) {
                    if ((196608 & i2) == 0) {
                        i10 = i;
                        if (gapComposer.changed(i10)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i8 |= i11;
                    }
                    int i19 = i8 | 1572864;
                    if ((i3 & 128) == 0) {
                        sliderColorsColors = sliderColors;
                        int i20 = gapComposer.changed(sliderColorsColors) ? 8388608 : 4194304;
                        i12 = i19 | i20 | 100663296;
                        z3 = true;
                        if ((i12 & 38347923) != 38347922) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (gapComposer.shouldExecute(i12 & 1, z4)) {
                            gapComposer.startDefaults();
                            i14 = i2 & 1;
                            neverEqualPolicy = Composer.Companion.Empty;
                            if (i14 != 0 || gapComposer.getDefaultsInvalid()) {
                                if (i18 != 0) {
                                    modifier3 = Modifier.Companion.$$INSTANCE;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if (i9 != 0) {
                                    i10 = 0;
                                }
                                if ((i3 & 128) != 0) {
                                    SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                                    i15 = i12 & (-29360129);
                                    sliderColorsColors = SliderDefaults.colors(gapComposer);
                                } else {
                                    i15 = i12;
                                }
                                objRememberedValue = gapComposer.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                                }
                                mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                                i16 = i15;
                            } else {
                                gapComposer.skipToGroupEnd();
                                if ((i3 & 128) != 0) {
                                    mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                                    i16 = i12 & (-29360129);
                                    modifier3 = modifier2;
                                } else {
                                    mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                                    modifier3 = modifier2;
                                    z5 = z2;
                                    i17 = i10;
                                    sliderColors2 = sliderColorsColors;
                                    i16 = i12;
                                }
                                gapComposer.endDefaults();
                                if ((i16 & 458752) == 131072) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                if ((((57344 & i16) ^ 24576) > 16384 || !gapComposer.changed(closedFloatRange)) && (i16 & 24576) != 16384) {
                                }
                                z7 = z6 | z3;
                                objRememberedValue2 = gapComposer.rememberedValue();
                                if (z7 || objRememberedValue2 == neverEqualPolicy) {
                                    objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                                    gapComposer.updateRememberedValue(objRememberedValue2);
                                }
                                SliderState sliderState = (SliderState) objRememberedValue2;
                                int i21 = i17;
                                sliderState.onValueChangeFinishedInternal = null;
                                sliderState.onValueChangeInternal = function1;
                                sliderState.setValue(f);
                                byte b = 0;
                                ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b), gapComposer);
                                ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b), gapComposer);
                                int i22 = i16 >> 3;
                                Slider(sliderState, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda, composableLambdaImplRememberComposableLambda2, gapComposer, ((i16 << 6) & 7168) | (i22 & 112) | 113246208 | (i22 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
                                i13 = i21;
                            }
                            z5 = z2;
                            i17 = i10;
                            sliderColors2 = sliderColorsColors;
                            gapComposer.endDefaults();
                            if ((i16 & 458752) == 131072) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            z3 = ((57344 & i16) ^ 24576) > 16384 ? false : false;
                            z7 = z6 | z3;
                            objRememberedValue2 = gapComposer.rememberedValue();
                            if (z7) {
                                objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            }
                            SliderState sliderState2 = (SliderState) objRememberedValue2;
                            int i23 = i17;
                            sliderState2.onValueChangeFinishedInternal = null;
                            sliderState2.onValueChangeInternal = function1;
                            sliderState2.setValue(f);
                            byte b2 = 0;
                            ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b2), gapComposer);
                            ComposableLambdaImpl composableLambdaImplRememberComposableLambda4 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b2), gapComposer);
                            int i24 = i16 >> 3;
                            Slider(sliderState2, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda3, composableLambdaImplRememberComposableLambda4, gapComposer, ((i16 << 6) & 7168) | (i24 & 112) | 113246208 | (i24 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
                            i13 = i23;
                        } else {
                            gapComposer.skipToGroupEnd();
                            mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                            modifier3 = modifier2;
                            z5 = z2;
                            i13 = i10;
                            sliderColors2 = sliderColorsColors;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    ((Integer) obj2).getClass();
                                    SliderKt.Slider(f, function1, modifier3, z5, closedFloatRange, i13, sliderColors2, mutableInteractionSourceImpl2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                    }
                    sliderColorsColors = sliderColors;
                    i12 = i19 | i20 | 100663296;
                    z3 = true;
                    if ((i12 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (gapComposer.shouldExecute(i12 & 1, z4)) {
                        gapComposer.startDefaults();
                        i14 = i2 & 1;
                        neverEqualPolicy = Composer.Companion.Empty;
                        if (i14 != 0) {
                            if (i18 != 0) {
                                modifier3 = Modifier.Companion.$$INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if (i9 != 0) {
                                i10 = 0;
                            }
                            if ((i3 & 128) != 0) {
                                SliderDefaults sliderDefaults2 = SliderDefaults.INSTANCE;
                                i15 = i12 & (-29360129);
                                sliderColorsColors = SliderDefaults.colors(gapComposer);
                            } else {
                                i15 = i12;
                            }
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                            i16 = i15;
                            z5 = z2;
                            i17 = i10;
                            sliderColors2 = sliderColorsColors;
                        } else {
                            if (i18 != 0) {
                                modifier3 = Modifier.Companion.$$INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if (i9 != 0) {
                                i10 = 0;
                            }
                            if ((i3 & 128) != 0) {
                                SliderDefaults sliderDefaults3 = SliderDefaults.INSTANCE;
                                i15 = i12 & (-29360129);
                                sliderColorsColors = SliderDefaults.colors(gapComposer);
                            } else {
                                i15 = i12;
                            }
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                            i16 = i15;
                            z5 = z2;
                            i17 = i10;
                            sliderColors2 = sliderColorsColors;
                        }
                        gapComposer.endDefaults();
                        if ((i16 & 458752) == 131072) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (((57344 & i16) ^ 24576) > 16384) {
                        }
                        z7 = z6 | z3;
                        objRememberedValue2 = gapComposer.rememberedValue();
                        if (z7) {
                            objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        SliderState sliderState3 = (SliderState) objRememberedValue2;
                        int i25 = i17;
                        sliderState3.onValueChangeFinishedInternal = null;
                        sliderState3.onValueChangeInternal = function1;
                        sliderState3.setValue(f);
                        byte b3 = 0;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda5 = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b3), gapComposer);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda6 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b3), gapComposer);
                        int i26 = i16 >> 3;
                        Slider(sliderState3, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda5, composableLambdaImplRememberComposableLambda6, gapComposer, ((i16 << 6) & 7168) | (i26 & 112) | 113246208 | (i26 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
                        i13 = i25;
                    } else {
                        gapComposer.skipToGroupEnd();
                        mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                        modifier3 = modifier2;
                        z5 = z2;
                        i13 = i10;
                        sliderColors2 = sliderColorsColors;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                SliderKt.Slider(f, function1, modifier3, z5, closedFloatRange, i13, sliderColors2, mutableInteractionSourceImpl2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i8 |= 196608;
                i10 = i;
                int i110 = i8 | 1572864;
                if ((i3 & 128) == 0) {
                    sliderColorsColors = sliderColors;
                    if (gapComposer.changed(sliderColorsColors)) {
                    }
                    i12 = i110 | i20 | 100663296;
                    z3 = true;
                    if ((i12 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (gapComposer.shouldExecute(i12 & 1, z4)) {
                        gapComposer.startDefaults();
                        i14 = i2 & 1;
                        neverEqualPolicy = Composer.Companion.Empty;
                        if (i14 != 0) {
                            if (i18 != 0) {
                                modifier3 = Modifier.Companion.$$INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if (i9 != 0) {
                                i10 = 0;
                            }
                            if ((i3 & 128) != 0) {
                                SliderDefaults sliderDefaults4 = SliderDefaults.INSTANCE;
                                i15 = i12 & (-29360129);
                                sliderColorsColors = SliderDefaults.colors(gapComposer);
                            } else {
                                i15 = i12;
                            }
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                            i16 = i15;
                            z5 = z2;
                            i17 = i10;
                            sliderColors2 = sliderColorsColors;
                        } else {
                            if (i18 != 0) {
                                modifier3 = Modifier.Companion.$$INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if (i9 != 0) {
                                i10 = 0;
                            }
                            if ((i3 & 128) != 0) {
                                SliderDefaults sliderDefaults5 = SliderDefaults.INSTANCE;
                                i15 = i12 & (-29360129);
                                sliderColorsColors = SliderDefaults.colors(gapComposer);
                            } else {
                                i15 = i12;
                            }
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                            i16 = i15;
                            z5 = z2;
                            i17 = i10;
                            sliderColors2 = sliderColorsColors;
                        }
                        gapComposer.endDefaults();
                        if ((i16 & 458752) == 131072) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (((57344 & i16) ^ 24576) > 16384) {
                        }
                        z7 = z6 | z3;
                        objRememberedValue2 = gapComposer.rememberedValue();
                        if (z7) {
                            objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        SliderState sliderState4 = (SliderState) objRememberedValue2;
                        int i27 = i17;
                        sliderState4.onValueChangeFinishedInternal = null;
                        sliderState4.onValueChangeInternal = function1;
                        sliderState4.setValue(f);
                        byte b4 = 0;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda7 = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b4), gapComposer);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda8 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b4), gapComposer);
                        int i28 = i16 >> 3;
                        Slider(sliderState4, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda7, composableLambdaImplRememberComposableLambda8, gapComposer, ((i16 << 6) & 7168) | (i28 & 112) | 113246208 | (i28 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
                        i13 = i27;
                    } else {
                        gapComposer.skipToGroupEnd();
                        mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                        modifier3 = modifier2;
                        z5 = z2;
                        i13 = i10;
                        sliderColors2 = sliderColorsColors;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                SliderKt.Slider(f, function1, modifier3, z5, closedFloatRange, i13, sliderColors2, mutableInteractionSourceImpl2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                sliderColorsColors = sliderColors;
                i12 = i110 | i20 | 100663296;
                z3 = true;
                if ((i12 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z4)) {
                    gapComposer.startDefaults();
                    i14 = i2 & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i14 != 0) {
                        if (i18 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if (i9 != 0) {
                            i10 = 0;
                        }
                        if ((i3 & 128) != 0) {
                            SliderDefaults sliderDefaults6 = SliderDefaults.INSTANCE;
                            i15 = i12 & (-29360129);
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        } else {
                            i15 = i12;
                        }
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        i16 = i15;
                        z5 = z2;
                        i17 = i10;
                        sliderColors2 = sliderColorsColors;
                    } else {
                        if (i18 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if (i9 != 0) {
                            i10 = 0;
                        }
                        if ((i3 & 128) != 0) {
                            SliderDefaults sliderDefaults7 = SliderDefaults.INSTANCE;
                            i15 = i12 & (-29360129);
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        } else {
                            i15 = i12;
                        }
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        i16 = i15;
                        z5 = z2;
                        i17 = i10;
                        sliderColors2 = sliderColorsColors;
                    }
                    gapComposer.endDefaults();
                    if ((i16 & 458752) == 131072) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (((57344 & i16) ^ 24576) > 16384) {
                    }
                    z7 = z6 | z3;
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (z7) {
                        objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    SliderState sliderState5 = (SliderState) objRememberedValue2;
                    int i29 = i17;
                    sliderState5.onValueChangeFinishedInternal = null;
                    sliderState5.onValueChangeInternal = function1;
                    sliderState5.setValue(f);
                    byte b5 = 0;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda9 = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b5), gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda10 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b5), gapComposer);
                    int i210 = i16 >> 3;
                    Slider(sliderState5, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda9, composableLambdaImplRememberComposableLambda10, gapComposer, ((i16 << 6) & 7168) | (i210 & 112) | 113246208 | (i210 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
                    i13 = i29;
                } else {
                    gapComposer.skipToGroupEnd();
                    mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                    modifier3 = modifier2;
                    z5 = z2;
                    i13 = i10;
                    sliderColors2 = sliderColorsColors;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            SliderKt.Slider(f, function1, modifier3, z5, closedFloatRange, i13, sliderColors2, mutableInteractionSourceImpl2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i4 |= 3072;
            z2 = z;
            if (gapComposer.changed(closedFloatRange)) {
                i7 = 16384;
            } else {
                i7 = 8192;
            }
            i8 = i4 | i7;
            i9 = i3 & 32;
            if (i9 != 0) {
                if ((196608 & i2) == 0) {
                    i10 = i;
                    if (gapComposer.changed(i10)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i8 |= i11;
                }
                int i111 = i8 | 1572864;
                if ((i3 & 128) == 0) {
                    sliderColorsColors = sliderColors;
                    if (gapComposer.changed(sliderColorsColors)) {
                    }
                    i12 = i111 | i20 | 100663296;
                    z3 = true;
                    if ((i12 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (gapComposer.shouldExecute(i12 & 1, z4)) {
                        gapComposer.startDefaults();
                        i14 = i2 & 1;
                        neverEqualPolicy = Composer.Companion.Empty;
                        if (i14 != 0) {
                            if (i18 != 0) {
                                modifier3 = Modifier.Companion.$$INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if (i9 != 0) {
                                i10 = 0;
                            }
                            if ((i3 & 128) != 0) {
                                SliderDefaults sliderDefaults8 = SliderDefaults.INSTANCE;
                                i15 = i12 & (-29360129);
                                sliderColorsColors = SliderDefaults.colors(gapComposer);
                            } else {
                                i15 = i12;
                            }
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                            i16 = i15;
                            z5 = z2;
                            i17 = i10;
                            sliderColors2 = sliderColorsColors;
                        } else {
                            if (i18 != 0) {
                                modifier3 = Modifier.Companion.$$INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if (i9 != 0) {
                                i10 = 0;
                            }
                            if ((i3 & 128) != 0) {
                                SliderDefaults sliderDefaults9 = SliderDefaults.INSTANCE;
                                i15 = i12 & (-29360129);
                                sliderColorsColors = SliderDefaults.colors(gapComposer);
                            } else {
                                i15 = i12;
                            }
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                            i16 = i15;
                            z5 = z2;
                            i17 = i10;
                            sliderColors2 = sliderColorsColors;
                        }
                        gapComposer.endDefaults();
                        if ((i16 & 458752) == 131072) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (((57344 & i16) ^ 24576) > 16384) {
                        }
                        z7 = z6 | z3;
                        objRememberedValue2 = gapComposer.rememberedValue();
                        if (z7) {
                            objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        SliderState sliderState6 = (SliderState) objRememberedValue2;
                        int i211 = i17;
                        sliderState6.onValueChangeFinishedInternal = null;
                        sliderState6.onValueChangeInternal = function1;
                        sliderState6.setValue(f);
                        byte b6 = 0;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda11 = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b6), gapComposer);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda12 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b6), gapComposer);
                        int i212 = i16 >> 3;
                        Slider(sliderState6, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda11, composableLambdaImplRememberComposableLambda12, gapComposer, ((i16 << 6) & 7168) | (i212 & 112) | 113246208 | (i212 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
                        i13 = i211;
                    } else {
                        gapComposer.skipToGroupEnd();
                        mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                        modifier3 = modifier2;
                        z5 = z2;
                        i13 = i10;
                        sliderColors2 = sliderColorsColors;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                SliderKt.Slider(f, function1, modifier3, z5, closedFloatRange, i13, sliderColors2, mutableInteractionSourceImpl2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                sliderColorsColors = sliderColors;
                i12 = i111 | i20 | 100663296;
                z3 = true;
                if ((i12 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z4)) {
                    gapComposer.startDefaults();
                    i14 = i2 & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i14 != 0) {
                        if (i18 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if (i9 != 0) {
                            i10 = 0;
                        }
                        if ((i3 & 128) != 0) {
                            SliderDefaults sliderDefaults10 = SliderDefaults.INSTANCE;
                            i15 = i12 & (-29360129);
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        } else {
                            i15 = i12;
                        }
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        i16 = i15;
                        z5 = z2;
                        i17 = i10;
                        sliderColors2 = sliderColorsColors;
                    } else {
                        if (i18 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if (i9 != 0) {
                            i10 = 0;
                        }
                        if ((i3 & 128) != 0) {
                            SliderDefaults sliderDefaults11 = SliderDefaults.INSTANCE;
                            i15 = i12 & (-29360129);
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        } else {
                            i15 = i12;
                        }
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        i16 = i15;
                        z5 = z2;
                        i17 = i10;
                        sliderColors2 = sliderColorsColors;
                    }
                    gapComposer.endDefaults();
                    if ((i16 & 458752) == 131072) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (((57344 & i16) ^ 24576) > 16384) {
                    }
                    z7 = z6 | z3;
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (z7) {
                        objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    SliderState sliderState7 = (SliderState) objRememberedValue2;
                    int i213 = i17;
                    sliderState7.onValueChangeFinishedInternal = null;
                    sliderState7.onValueChangeInternal = function1;
                    sliderState7.setValue(f);
                    byte b7 = 0;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda13 = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b7), gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda14 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b7), gapComposer);
                    int i214 = i16 >> 3;
                    Slider(sliderState7, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda13, composableLambdaImplRememberComposableLambda14, gapComposer, ((i16 << 6) & 7168) | (i214 & 112) | 113246208 | (i214 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
                    i13 = i213;
                } else {
                    gapComposer.skipToGroupEnd();
                    mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                    modifier3 = modifier2;
                    z5 = z2;
                    i13 = i10;
                    sliderColors2 = sliderColorsColors;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            SliderKt.Slider(f, function1, modifier3, z5, closedFloatRange, i13, sliderColors2, mutableInteractionSourceImpl2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i8 |= 196608;
            i10 = i;
            int i112 = i8 | 1572864;
            if ((i3 & 128) == 0) {
                sliderColorsColors = sliderColors;
                if (gapComposer.changed(sliderColorsColors)) {
                }
                i12 = i112 | i20 | 100663296;
                z3 = true;
                if ((i12 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z4)) {
                    gapComposer.startDefaults();
                    i14 = i2 & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i14 != 0) {
                        if (i18 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if (i9 != 0) {
                            i10 = 0;
                        }
                        if ((i3 & 128) != 0) {
                            SliderDefaults sliderDefaults12 = SliderDefaults.INSTANCE;
                            i15 = i12 & (-29360129);
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        } else {
                            i15 = i12;
                        }
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        i16 = i15;
                        z5 = z2;
                        i17 = i10;
                        sliderColors2 = sliderColorsColors;
                    } else {
                        if (i18 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if (i9 != 0) {
                            i10 = 0;
                        }
                        if ((i3 & 128) != 0) {
                            SliderDefaults sliderDefaults13 = SliderDefaults.INSTANCE;
                            i15 = i12 & (-29360129);
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        } else {
                            i15 = i12;
                        }
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        i16 = i15;
                        z5 = z2;
                        i17 = i10;
                        sliderColors2 = sliderColorsColors;
                    }
                    gapComposer.endDefaults();
                    if ((i16 & 458752) == 131072) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (((57344 & i16) ^ 24576) > 16384) {
                    }
                    z7 = z6 | z3;
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (z7) {
                        objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    SliderState sliderState8 = (SliderState) objRememberedValue2;
                    int i215 = i17;
                    sliderState8.onValueChangeFinishedInternal = null;
                    sliderState8.onValueChangeInternal = function1;
                    sliderState8.setValue(f);
                    byte b8 = 0;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda15 = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b8), gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda16 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b8), gapComposer);
                    int i216 = i16 >> 3;
                    Slider(sliderState8, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda15, composableLambdaImplRememberComposableLambda16, gapComposer, ((i16 << 6) & 7168) | (i216 & 112) | 113246208 | (i216 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
                    i13 = i215;
                } else {
                    gapComposer.skipToGroupEnd();
                    mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                    modifier3 = modifier2;
                    z5 = z2;
                    i13 = i10;
                    sliderColors2 = sliderColorsColors;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            SliderKt.Slider(f, function1, modifier3, z5, closedFloatRange, i13, sliderColors2, mutableInteractionSourceImpl2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            sliderColorsColors = sliderColors;
            i12 = i112 | i20 | 100663296;
            z3 = true;
            if ((i12 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (gapComposer.shouldExecute(i12 & 1, z4)) {
                gapComposer.startDefaults();
                i14 = i2 & 1;
                neverEqualPolicy = Composer.Companion.Empty;
                if (i14 != 0) {
                    if (i18 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if (i9 != 0) {
                        i10 = 0;
                    }
                    if ((i3 & 128) != 0) {
                        SliderDefaults sliderDefaults14 = SliderDefaults.INSTANCE;
                        i15 = i12 & (-29360129);
                        sliderColorsColors = SliderDefaults.colors(gapComposer);
                    } else {
                        i15 = i12;
                    }
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    i16 = i15;
                    z5 = z2;
                    i17 = i10;
                    sliderColors2 = sliderColorsColors;
                } else {
                    if (i18 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if (i9 != 0) {
                        i10 = 0;
                    }
                    if ((i3 & 128) != 0) {
                        SliderDefaults sliderDefaults15 = SliderDefaults.INSTANCE;
                        i15 = i12 & (-29360129);
                        sliderColorsColors = SliderDefaults.colors(gapComposer);
                    } else {
                        i15 = i12;
                    }
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    i16 = i15;
                    z5 = z2;
                    i17 = i10;
                    sliderColors2 = sliderColorsColors;
                }
                gapComposer.endDefaults();
                if ((i16 & 458752) == 131072) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (((57344 & i16) ^ 24576) > 16384) {
                }
                z7 = z6 | z3;
                objRememberedValue2 = gapComposer.rememberedValue();
                if (z7) {
                    objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                SliderState sliderState9 = (SliderState) objRememberedValue2;
                int i217 = i17;
                sliderState9.onValueChangeFinishedInternal = null;
                sliderState9.onValueChangeInternal = function1;
                sliderState9.setValue(f);
                byte b9 = 0;
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda17 = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b9), gapComposer);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda18 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b9), gapComposer);
                int i218 = i16 >> 3;
                Slider(sliderState9, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda17, composableLambdaImplRememberComposableLambda18, gapComposer, ((i16 << 6) & 7168) | (i218 & 112) | 113246208 | (i218 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
                i13 = i217;
            } else {
                gapComposer.skipToGroupEnd();
                mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                modifier3 = modifier2;
                z5 = z2;
                i13 = i10;
                sliderColors2 = sliderColorsColors;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        SliderKt.Slider(f, function1, modifier3, z5, closedFloatRange, i13, sliderColors2, mutableInteractionSourceImpl2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i2 & 3072) == 0) {
                z2 = z;
                if (gapComposer.changed(z2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            if (gapComposer.changed(closedFloatRange)) {
                i7 = 16384;
            } else {
                i7 = 8192;
            }
            i8 = i4 | i7;
            i9 = i3 & 32;
            if (i9 != 0) {
                if ((196608 & i2) == 0) {
                    i10 = i;
                    if (gapComposer.changed(i10)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i8 |= i11;
                }
                int i113 = i8 | 1572864;
                if ((i3 & 128) == 0) {
                    sliderColorsColors = sliderColors;
                    if (gapComposer.changed(sliderColorsColors)) {
                    }
                    i12 = i113 | i20 | 100663296;
                    z3 = true;
                    if ((i12 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (gapComposer.shouldExecute(i12 & 1, z4)) {
                        gapComposer.startDefaults();
                        i14 = i2 & 1;
                        neverEqualPolicy = Composer.Companion.Empty;
                        if (i14 != 0) {
                            if (i18 != 0) {
                                modifier3 = Modifier.Companion.$$INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if (i9 != 0) {
                                i10 = 0;
                            }
                            if ((i3 & 128) != 0) {
                                SliderDefaults sliderDefaults16 = SliderDefaults.INSTANCE;
                                i15 = i12 & (-29360129);
                                sliderColorsColors = SliderDefaults.colors(gapComposer);
                            } else {
                                i15 = i12;
                            }
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                            i16 = i15;
                            z5 = z2;
                            i17 = i10;
                            sliderColors2 = sliderColorsColors;
                        } else {
                            if (i18 != 0) {
                                modifier3 = Modifier.Companion.$$INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if (i9 != 0) {
                                i10 = 0;
                            }
                            if ((i3 & 128) != 0) {
                                SliderDefaults sliderDefaults17 = SliderDefaults.INSTANCE;
                                i15 = i12 & (-29360129);
                                sliderColorsColors = SliderDefaults.colors(gapComposer);
                            } else {
                                i15 = i12;
                            }
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                            i16 = i15;
                            z5 = z2;
                            i17 = i10;
                            sliderColors2 = sliderColorsColors;
                        }
                        gapComposer.endDefaults();
                        if ((i16 & 458752) == 131072) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (((57344 & i16) ^ 24576) > 16384) {
                        }
                        z7 = z6 | z3;
                        objRememberedValue2 = gapComposer.rememberedValue();
                        if (z7) {
                            objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        SliderState sliderState10 = (SliderState) objRememberedValue2;
                        int i219 = i17;
                        sliderState10.onValueChangeFinishedInternal = null;
                        sliderState10.onValueChangeInternal = function1;
                        sliderState10.setValue(f);
                        byte b10 = 0;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda19 = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b10), gapComposer);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda110 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b10), gapComposer);
                        int i2110 = i16 >> 3;
                        Slider(sliderState10, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda19, composableLambdaImplRememberComposableLambda110, gapComposer, ((i16 << 6) & 7168) | (i2110 & 112) | 113246208 | (i2110 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
                        i13 = i219;
                    } else {
                        gapComposer.skipToGroupEnd();
                        mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                        modifier3 = modifier2;
                        z5 = z2;
                        i13 = i10;
                        sliderColors2 = sliderColorsColors;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                SliderKt.Slider(f, function1, modifier3, z5, closedFloatRange, i13, sliderColors2, mutableInteractionSourceImpl2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                sliderColorsColors = sliderColors;
                i12 = i113 | i20 | 100663296;
                z3 = true;
                if ((i12 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z4)) {
                    gapComposer.startDefaults();
                    i14 = i2 & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i14 != 0) {
                        if (i18 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if (i9 != 0) {
                            i10 = 0;
                        }
                        if ((i3 & 128) != 0) {
                            SliderDefaults sliderDefaults18 = SliderDefaults.INSTANCE;
                            i15 = i12 & (-29360129);
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        } else {
                            i15 = i12;
                        }
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        i16 = i15;
                        z5 = z2;
                        i17 = i10;
                        sliderColors2 = sliderColorsColors;
                    } else {
                        if (i18 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if (i9 != 0) {
                            i10 = 0;
                        }
                        if ((i3 & 128) != 0) {
                            SliderDefaults sliderDefaults19 = SliderDefaults.INSTANCE;
                            i15 = i12 & (-29360129);
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        } else {
                            i15 = i12;
                        }
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        i16 = i15;
                        z5 = z2;
                        i17 = i10;
                        sliderColors2 = sliderColorsColors;
                    }
                    gapComposer.endDefaults();
                    if ((i16 & 458752) == 131072) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (((57344 & i16) ^ 24576) > 16384) {
                    }
                    z7 = z6 | z3;
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (z7) {
                        objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    SliderState sliderState11 = (SliderState) objRememberedValue2;
                    int i2111 = i17;
                    sliderState11.onValueChangeFinishedInternal = null;
                    sliderState11.onValueChangeInternal = function1;
                    sliderState11.setValue(f);
                    byte b11 = 0;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda111 = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b11), gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda112 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b11), gapComposer);
                    int i2112 = i16 >> 3;
                    Slider(sliderState11, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda111, composableLambdaImplRememberComposableLambda112, gapComposer, ((i16 << 6) & 7168) | (i2112 & 112) | 113246208 | (i2112 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
                    i13 = i2111;
                } else {
                    gapComposer.skipToGroupEnd();
                    mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                    modifier3 = modifier2;
                    z5 = z2;
                    i13 = i10;
                    sliderColors2 = sliderColorsColors;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            SliderKt.Slider(f, function1, modifier3, z5, closedFloatRange, i13, sliderColors2, mutableInteractionSourceImpl2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i8 |= 196608;
            i10 = i;
            int i114 = i8 | 1572864;
            if ((i3 & 128) == 0) {
                sliderColorsColors = sliderColors;
                if (gapComposer.changed(sliderColorsColors)) {
                }
                i12 = i114 | i20 | 100663296;
                z3 = true;
                if ((i12 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z4)) {
                    gapComposer.startDefaults();
                    i14 = i2 & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i14 != 0) {
                        if (i18 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if (i9 != 0) {
                            i10 = 0;
                        }
                        if ((i3 & 128) != 0) {
                            SliderDefaults sliderDefaults110 = SliderDefaults.INSTANCE;
                            i15 = i12 & (-29360129);
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        } else {
                            i15 = i12;
                        }
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        i16 = i15;
                        z5 = z2;
                        i17 = i10;
                        sliderColors2 = sliderColorsColors;
                    } else {
                        if (i18 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if (i9 != 0) {
                            i10 = 0;
                        }
                        if ((i3 & 128) != 0) {
                            SliderDefaults sliderDefaults111 = SliderDefaults.INSTANCE;
                            i15 = i12 & (-29360129);
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        } else {
                            i15 = i12;
                        }
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        i16 = i15;
                        z5 = z2;
                        i17 = i10;
                        sliderColors2 = sliderColorsColors;
                    }
                    gapComposer.endDefaults();
                    if ((i16 & 458752) == 131072) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (((57344 & i16) ^ 24576) > 16384) {
                    }
                    z7 = z6 | z3;
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (z7) {
                        objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    SliderState sliderState12 = (SliderState) objRememberedValue2;
                    int i2113 = i17;
                    sliderState12.onValueChangeFinishedInternal = null;
                    sliderState12.onValueChangeInternal = function1;
                    sliderState12.setValue(f);
                    byte b12 = 0;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda113 = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b12), gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda114 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b12), gapComposer);
                    int i2114 = i16 >> 3;
                    Slider(sliderState12, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda113, composableLambdaImplRememberComposableLambda114, gapComposer, ((i16 << 6) & 7168) | (i2114 & 112) | 113246208 | (i2114 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
                    i13 = i2113;
                } else {
                    gapComposer.skipToGroupEnd();
                    mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                    modifier3 = modifier2;
                    z5 = z2;
                    i13 = i10;
                    sliderColors2 = sliderColorsColors;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            SliderKt.Slider(f, function1, modifier3, z5, closedFloatRange, i13, sliderColors2, mutableInteractionSourceImpl2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            sliderColorsColors = sliderColors;
            i12 = i114 | i20 | 100663296;
            z3 = true;
            if ((i12 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (gapComposer.shouldExecute(i12 & 1, z4)) {
                gapComposer.startDefaults();
                i14 = i2 & 1;
                neverEqualPolicy = Composer.Companion.Empty;
                if (i14 != 0) {
                    if (i18 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if (i9 != 0) {
                        i10 = 0;
                    }
                    if ((i3 & 128) != 0) {
                        SliderDefaults sliderDefaults112 = SliderDefaults.INSTANCE;
                        i15 = i12 & (-29360129);
                        sliderColorsColors = SliderDefaults.colors(gapComposer);
                    } else {
                        i15 = i12;
                    }
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    i16 = i15;
                    z5 = z2;
                    i17 = i10;
                    sliderColors2 = sliderColorsColors;
                } else {
                    if (i18 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if (i9 != 0) {
                        i10 = 0;
                    }
                    if ((i3 & 128) != 0) {
                        SliderDefaults sliderDefaults113 = SliderDefaults.INSTANCE;
                        i15 = i12 & (-29360129);
                        sliderColorsColors = SliderDefaults.colors(gapComposer);
                    } else {
                        i15 = i12;
                    }
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    i16 = i15;
                    z5 = z2;
                    i17 = i10;
                    sliderColors2 = sliderColorsColors;
                }
                gapComposer.endDefaults();
                if ((i16 & 458752) == 131072) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (((57344 & i16) ^ 24576) > 16384) {
                }
                z7 = z6 | z3;
                objRememberedValue2 = gapComposer.rememberedValue();
                if (z7) {
                    objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                SliderState sliderState13 = (SliderState) objRememberedValue2;
                int i2115 = i17;
                sliderState13.onValueChangeFinishedInternal = null;
                sliderState13.onValueChangeInternal = function1;
                sliderState13.setValue(f);
                byte b13 = 0;
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda115 = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b13), gapComposer);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda116 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b13), gapComposer);
                int i2116 = i16 >> 3;
                Slider(sliderState13, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda115, composableLambdaImplRememberComposableLambda116, gapComposer, ((i16 << 6) & 7168) | (i2116 & 112) | 113246208 | (i2116 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
                i13 = i2115;
            } else {
                gapComposer.skipToGroupEnd();
                mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                modifier3 = modifier2;
                z5 = z2;
                i13 = i10;
                sliderColors2 = sliderColorsColors;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        SliderKt.Slider(f, function1, modifier3, z5, closedFloatRange, i13, sliderColors2, mutableInteractionSourceImpl2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 3072;
        z2 = z;
        if (gapComposer.changed(closedFloatRange)) {
            i7 = 16384;
        } else {
            i7 = 8192;
        }
        i8 = i4 | i7;
        i9 = i3 & 32;
        if (i9 != 0) {
            if ((196608 & i2) == 0) {
                i10 = i;
                if (gapComposer.changed(i10)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i8 |= i11;
            }
            int i115 = i8 | 1572864;
            if ((i3 & 128) == 0) {
                sliderColorsColors = sliderColors;
                if (gapComposer.changed(sliderColorsColors)) {
                }
                i12 = i115 | i20 | 100663296;
                z3 = true;
                if ((i12 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (gapComposer.shouldExecute(i12 & 1, z4)) {
                    gapComposer.startDefaults();
                    i14 = i2 & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i14 != 0) {
                        if (i18 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if (i9 != 0) {
                            i10 = 0;
                        }
                        if ((i3 & 128) != 0) {
                            SliderDefaults sliderDefaults114 = SliderDefaults.INSTANCE;
                            i15 = i12 & (-29360129);
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        } else {
                            i15 = i12;
                        }
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        i16 = i15;
                        z5 = z2;
                        i17 = i10;
                        sliderColors2 = sliderColorsColors;
                    } else {
                        if (i18 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if (i9 != 0) {
                            i10 = 0;
                        }
                        if ((i3 & 128) != 0) {
                            SliderDefaults sliderDefaults115 = SliderDefaults.INSTANCE;
                            i15 = i12 & (-29360129);
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        } else {
                            i15 = i12;
                        }
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        i16 = i15;
                        z5 = z2;
                        i17 = i10;
                        sliderColors2 = sliderColorsColors;
                    }
                    gapComposer.endDefaults();
                    if ((i16 & 458752) == 131072) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (((57344 & i16) ^ 24576) > 16384) {
                    }
                    z7 = z6 | z3;
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (z7) {
                        objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    SliderState sliderState14 = (SliderState) objRememberedValue2;
                    int i2117 = i17;
                    sliderState14.onValueChangeFinishedInternal = null;
                    sliderState14.onValueChangeInternal = function1;
                    sliderState14.setValue(f);
                    byte b14 = 0;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda117 = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b14), gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda118 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b14), gapComposer);
                    int i2118 = i16 >> 3;
                    Slider(sliderState14, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda117, composableLambdaImplRememberComposableLambda118, gapComposer, ((i16 << 6) & 7168) | (i2118 & 112) | 113246208 | (i2118 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
                    i13 = i2117;
                } else {
                    gapComposer.skipToGroupEnd();
                    mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                    modifier3 = modifier2;
                    z5 = z2;
                    i13 = i10;
                    sliderColors2 = sliderColorsColors;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            SliderKt.Slider(f, function1, modifier3, z5, closedFloatRange, i13, sliderColors2, mutableInteractionSourceImpl2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            sliderColorsColors = sliderColors;
            i12 = i115 | i20 | 100663296;
            z3 = true;
            if ((i12 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (gapComposer.shouldExecute(i12 & 1, z4)) {
                gapComposer.startDefaults();
                i14 = i2 & 1;
                neverEqualPolicy = Composer.Companion.Empty;
                if (i14 != 0) {
                    if (i18 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if (i9 != 0) {
                        i10 = 0;
                    }
                    if ((i3 & 128) != 0) {
                        SliderDefaults sliderDefaults116 = SliderDefaults.INSTANCE;
                        i15 = i12 & (-29360129);
                        sliderColorsColors = SliderDefaults.colors(gapComposer);
                    } else {
                        i15 = i12;
                    }
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    i16 = i15;
                    z5 = z2;
                    i17 = i10;
                    sliderColors2 = sliderColorsColors;
                } else {
                    if (i18 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if (i9 != 0) {
                        i10 = 0;
                    }
                    if ((i3 & 128) != 0) {
                        SliderDefaults sliderDefaults117 = SliderDefaults.INSTANCE;
                        i15 = i12 & (-29360129);
                        sliderColorsColors = SliderDefaults.colors(gapComposer);
                    } else {
                        i15 = i12;
                    }
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    i16 = i15;
                    z5 = z2;
                    i17 = i10;
                    sliderColors2 = sliderColorsColors;
                }
                gapComposer.endDefaults();
                if ((i16 & 458752) == 131072) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (((57344 & i16) ^ 24576) > 16384) {
                }
                z7 = z6 | z3;
                objRememberedValue2 = gapComposer.rememberedValue();
                if (z7) {
                    objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                SliderState sliderState15 = (SliderState) objRememberedValue2;
                int i2119 = i17;
                sliderState15.onValueChangeFinishedInternal = null;
                sliderState15.onValueChangeInternal = function1;
                sliderState15.setValue(f);
                byte b15 = 0;
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda119 = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b15), gapComposer);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda1110 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b15), gapComposer);
                int i21110 = i16 >> 3;
                Slider(sliderState15, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda119, composableLambdaImplRememberComposableLambda1110, gapComposer, ((i16 << 6) & 7168) | (i21110 & 112) | 113246208 | (i21110 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
                i13 = i2119;
            } else {
                gapComposer.skipToGroupEnd();
                mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                modifier3 = modifier2;
                z5 = z2;
                i13 = i10;
                sliderColors2 = sliderColorsColors;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        SliderKt.Slider(f, function1, modifier3, z5, closedFloatRange, i13, sliderColors2, mutableInteractionSourceImpl2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i8 |= 196608;
        i10 = i;
        int i116 = i8 | 1572864;
        if ((i3 & 128) == 0) {
            sliderColorsColors = sliderColors;
            if (gapComposer.changed(sliderColorsColors)) {
            }
            i12 = i116 | i20 | 100663296;
            z3 = true;
            if ((i12 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (gapComposer.shouldExecute(i12 & 1, z4)) {
                gapComposer.startDefaults();
                i14 = i2 & 1;
                neverEqualPolicy = Composer.Companion.Empty;
                if (i14 != 0) {
                    if (i18 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if (i9 != 0) {
                        i10 = 0;
                    }
                    if ((i3 & 128) != 0) {
                        SliderDefaults sliderDefaults118 = SliderDefaults.INSTANCE;
                        i15 = i12 & (-29360129);
                        sliderColorsColors = SliderDefaults.colors(gapComposer);
                    } else {
                        i15 = i12;
                    }
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    i16 = i15;
                    z5 = z2;
                    i17 = i10;
                    sliderColors2 = sliderColorsColors;
                } else {
                    if (i18 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if (i9 != 0) {
                        i10 = 0;
                    }
                    if ((i3 & 128) != 0) {
                        SliderDefaults sliderDefaults119 = SliderDefaults.INSTANCE;
                        i15 = i12 & (-29360129);
                        sliderColorsColors = SliderDefaults.colors(gapComposer);
                    } else {
                        i15 = i12;
                    }
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    i16 = i15;
                    z5 = z2;
                    i17 = i10;
                    sliderColors2 = sliderColorsColors;
                }
                gapComposer.endDefaults();
                if ((i16 & 458752) == 131072) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (((57344 & i16) ^ 24576) > 16384) {
                }
                z7 = z6 | z3;
                objRememberedValue2 = gapComposer.rememberedValue();
                if (z7) {
                    objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                SliderState sliderState16 = (SliderState) objRememberedValue2;
                int i21111 = i17;
                sliderState16.onValueChangeFinishedInternal = null;
                sliderState16.onValueChangeInternal = function1;
                sliderState16.setValue(f);
                byte b16 = 0;
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda1111 = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b16), gapComposer);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda1112 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b16), gapComposer);
                int i21112 = i16 >> 3;
                Slider(sliderState16, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda1111, composableLambdaImplRememberComposableLambda1112, gapComposer, ((i16 << 6) & 7168) | (i21112 & 112) | 113246208 | (i21112 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
                i13 = i21111;
            } else {
                gapComposer.skipToGroupEnd();
                mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                modifier3 = modifier2;
                z5 = z2;
                i13 = i10;
                sliderColors2 = sliderColorsColors;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        SliderKt.Slider(f, function1, modifier3, z5, closedFloatRange, i13, sliderColors2, mutableInteractionSourceImpl2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        sliderColorsColors = sliderColors;
        i12 = i116 | i20 | 100663296;
        z3 = true;
        if ((i12 & 38347923) != 38347922) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (gapComposer.shouldExecute(i12 & 1, z4)) {
            gapComposer.startDefaults();
            i14 = i2 & 1;
            neverEqualPolicy = Composer.Companion.Empty;
            if (i14 != 0) {
                if (i18 != 0) {
                    modifier3 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if (i9 != 0) {
                    i10 = 0;
                }
                if ((i3 & 128) != 0) {
                    SliderDefaults sliderDefaults1110 = SliderDefaults.INSTANCE;
                    i15 = i12 & (-29360129);
                    sliderColorsColors = SliderDefaults.colors(gapComposer);
                } else {
                    i15 = i12;
                }
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                }
                mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                i16 = i15;
                z5 = z2;
                i17 = i10;
                sliderColors2 = sliderColorsColors;
            } else {
                if (i18 != 0) {
                    modifier3 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if (i9 != 0) {
                    i10 = 0;
                }
                if ((i3 & 128) != 0) {
                    SliderDefaults sliderDefaults1111 = SliderDefaults.INSTANCE;
                    i15 = i12 & (-29360129);
                    sliderColorsColors = SliderDefaults.colors(gapComposer);
                } else {
                    i15 = i12;
                }
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                }
                mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                i16 = i15;
                z5 = z2;
                i17 = i10;
                sliderColors2 = sliderColorsColors;
            }
            gapComposer.endDefaults();
            if ((i16 & 458752) == 131072) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (((57344 & i16) ^ 24576) > 16384) {
            }
            z7 = z6 | z3;
            objRememberedValue2 = gapComposer.rememberedValue();
            if (z7) {
                objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                gapComposer.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new SliderState(f, i17, closedFloatRange);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            SliderState sliderState17 = (SliderState) objRememberedValue2;
            int i21113 = i17;
            sliderState17.onValueChangeFinishedInternal = null;
            sliderState17.onValueChangeInternal = function1;
            sliderState17.setValue(f);
            byte b17 = 0;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda1113 = Expect_jvmKt.rememberComposableLambda(-1835235136, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColors2, z5, b17), gapComposer);
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda1114 = Expect_jvmKt.rememberComposableLambda(308249025, new SliderKt$$ExternalSyntheticLambda1(z5, sliderColors2, b17), gapComposer);
            int i21114 = i16 >> 3;
            Slider(sliderState17, modifier3, z5, function1, null, sliderColors2, mutableInteractionSourceImpl2, composableLambdaImplRememberComposableLambda1113, composableLambdaImplRememberComposableLambda1114, gapComposer, ((i16 << 6) & 7168) | (i21114 & 112) | 113246208 | (i21114 & 896) | 24576 | ((i16 >> 6) & 458752) | 1572864, 0);
            i13 = i21113;
        } else {
            gapComposer.skipToGroupEnd();
            mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
            modifier3 = modifier2;
            z5 = z2;
            i13 = i10;
            sliderColors2 = sliderColorsColors;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    SliderKt.Slider(f, function1, modifier3, z5, closedFloatRange, i13, sliderColors2, mutableInteractionSourceImpl2, (Composer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void SliderImpl(Modifier modifier, final SliderState sliderState, final boolean z, Function1 function1, Function0 function0, final MutableInteractionSourceImpl mutableInteractionSourceImpl, Function3 function3, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        ComposableLambdaImpl composableLambdaImpl2;
        Function3 function4;
        GapComposer gapComposer;
        boolean z2;
        Modifier suspendPointerInputElement;
        Function3 function5 = function3;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1457062396);
        if ((i & 6) == 0) {
            i2 = (gapComposer2.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer2.changedInstance(sliderState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer2.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer2.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer2.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer2.changed(mutableInteractionSourceImpl) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer2.changedInstance(function5) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= gapComposer2.changedInstance(composableLambdaImpl) ? 8388608 : 4194304;
        }
        int i3 = i2;
        if (gapComposer2.shouldExecute(i3 & 1, (i3 & 4793491) != 4793490)) {
            if (function1 != null) {
                sliderState.onValueChangeInternal = function1;
            }
            if (function0 != null) {
                sliderState.onValueChangeFinishedInternal = function0;
            }
            sliderState.isRtl = gapComposer2.consume(CompositionLocalsKt.LocalLayoutDirection) == LayoutDirection.Rtl;
            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = sliderState.valueState$delegate;
            int i4 = i3 >> 15;
            MutableState mutableStateCollectIsFocusedAsState = DatabaseDao_Impl.AnonymousClass17.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer2, i4 & 14);
            Boolean bool = (Boolean) mutableStateCollectIsFocusedAsState.getValue();
            bool.getClass();
            sliderState.isFocused$delegate.setValue(bool);
            if (sliderState.orientation == Orientation.Horizontal && sliderState.isRtl) {
                z2 = true;
            } else {
                sliderState.isVertical();
                z2 = false;
            }
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (z) {
                PointerInputEventHandler pointerInputEventHandler = new PointerInputEventHandler() { // from class: androidx.compose.material3.SliderKt$sliderTapModifier$1
                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                        Object objCoroutineScope = AwaitKt.coroutineScope(new RealImageLoader.AnonymousClass2(pointerInputScope, mutableInteractionSourceImpl, sliderState, null, (byte) 19, false), continuation);
                        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
                    }
                };
                PointerEvent pointerEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
                suspendPointerInputElement = new SuspendPointerInputElement(sliderState, mutableInteractionSourceImpl, pointerInputEventHandler, 4);
            } else {
                suspendPointerInputElement = companion;
            }
            Orientation orientation = sliderState.orientation;
            boolean zBooleanValue = ((Boolean) sliderState.isDragging$delegate.getValue()).booleanValue();
            SliderState sliderState2 = sliderState.draggableState;
            boolean zChangedInstance = gapComposer2.changedInstance(sliderState);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new InvalidationTracker$createFlow$2(sliderState, null, (byte) 2);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            GapComposer gapComposer3 = gapComposer2;
            byte b = 0;
            Modifier modifierDraggable$default = DraggableKt.draggable$default(companion, sliderState2, orientation, z, mutableInteractionSourceImpl, zBooleanValue, (Function3) objRememberedValue, z2, 32);
            final boolean z3 = z2;
            boolean zIsVertical = sliderState.isVertical();
            SliderComponents sliderComponents = SliderComponents.THUMB;
            Modifier modifierWrapContentHeight$default = zIsVertical ? SizeKt.wrapContentHeight$default(RulerKt.layoutId(companion, sliderComponents)) : SizeKt.wrapContentWidth$default(RulerKt.layoutId(companion, sliderComponents), 3);
            ((RippleThemeConfiguration) gapComposer3.consume(RippleKt.LocalRippleThemeConfiguration)).getClass();
            gapComposer3.startReplaceGroup(-1886324954);
            gapComposer3.end(false);
            Density density = (Density) gapComposer3.consume(CompositionLocalsKt.LocalDensity);
            HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier.then(MinimumInteractiveModifier.INSTANCE).then(new SizeElement(sliderState.isVertical() ? 16.0f : 4.0f, (12 & 2) != 0 ? Float.NaN : sliderState.isVertical() ? 4.0f : 16.0f, (12 & 4) != 0 ? Float.NaN : CropImageView.DEFAULT_ASPECT_RATIO, (12 & 8) != 0 ? Float.NaN : CropImageView.DEFAULT_ASPECT_RATIO, false)), false, new SliderKt$$ExternalSyntheticLambda8(z, sliderState, b));
            boolean zIsVertical2 = sliderState.isVertical();
            ClosedFloatRange closedFloatRange = sliderState.trackRange;
            Modifier modifierThen = modifierSemantics.then(zIsVertical2 ? AccessibilityUtilKt.IncreaseVerticalSemanticsBounds : AccessibilityUtilKt.IncreaseHorizontalSemanticsBounds);
            final float floatValue = parcelableSnapshotMutableFloatState.getFloatValue();
            final ClosedFloatRange closedFloatRange2 = new ClosedFloatRange(closedFloatRange._start, closedFloatRange._endInclusive);
            final int i5 = sliderState.steps;
            Modifier modifierFocusable = ImageKt.focusable(SemanticsModifierKt.semantics(modifierThen, true, new Function1() { // from class: androidx.compose.foundation.ProgressSemanticsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Float fValueOf = Float.valueOf(floatValue);
                    ClosedFloatRange closedFloatRange3 = closedFloatRange2;
                    SemanticsPropertiesKt.setProgressBarRangeInfo((SemanticsPropertyReceiver) obj, new ProgressBarRangeInfo(((Number) UuidKt.coerceIn(fValueOf, closedFloatRange3)).floatValue(), closedFloatRange3, i5));
                    return Unit.INSTANCE;
                }
            }), z, mutableInteractionSourceImpl);
            final int i6 = sliderState.steps;
            final ClosedFloatRange closedFloatRange3 = sliderState.trackRange;
            final float floatValue2 = parcelableSnapshotMutableFloatState.getFloatValue();
            boolean zChangedInstance2 = gapComposer3.changedInstance(sliderState);
            Object objRememberedValue2 = gapComposer3.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new SliderKt$$ExternalSyntheticLambda5(sliderState, (byte) 0);
                gapComposer3.updateRememberedValue(objRememberedValue2);
            }
            final Function1 function2 = (Function1) objRememberedValue2;
            Modifier modifier2 = modifierWrapContentHeight$default;
            final Function0 function6 = sliderState.onValueChangeFinishedInternal;
            final boolean zIsVertical3 = sliderState.isVertical();
            if (i6 < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                return;
            }
            Modifier modifierThen2 = Key.onKeyEvent(modifierFocusable, new Function1() { // from class: androidx.compose.material3.SliderKt$slideOnKeyEvents$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    KeyEvent keyEvent = ((androidx.compose.ui.input.key.KeyEvent) obj).nativeKeyEvent;
                    if (!z) {
                        return Boolean.FALSE;
                    }
                    int iM581getTypeZmokQxo = Key.m581getTypeZmokQxo(keyEvent);
                    boolean z4 = zIsVertical3;
                    if (iM581getTypeZmokQxo != 2) {
                        if (iM581getTypeZmokQxo != 1) {
                            return Boolean.FALSE;
                        }
                        Function0 function7 = function6;
                        if (z4) {
                            long keyCode = ((long) keyEvent.getKeyCode()) << 32;
                            if (!Key.m579equalsimpl0(keyCode, 81604378624L) && !Key.m579equalsimpl0(keyCode, -4294967300294967296L) && !Key.m579equalsimpl0(keyCode, 85899345920L) && !Key.m579equalsimpl0(keyCode, -4294967304589934592L) && !Key.m579equalsimpl0(keyCode, 523986010112L) && !Key.m579equalsimpl0(keyCode, -4294967317474836480L) && !Key.m579equalsimpl0(keyCode, 528280977408L) && !Key.m579equalsimpl0(keyCode, -4294967321769803776L) && !Key.m579equalsimpl0(keyCode, 395136991232L) && !Key.m579equalsimpl0(keyCode, -4294967326064771072L) && !Key.m579equalsimpl0(keyCode, 399431958528L) && !Key.m579equalsimpl0(keyCode, -4294967330359738368L)) {
                                return Boolean.FALSE;
                            }
                            if (function7 != null) {
                                function7.invoke();
                            }
                            return Boolean.TRUE;
                        }
                        long keyCode2 = ((long) keyEvent.getKeyCode()) << 32;
                        if (!Key.m579equalsimpl0(keyCode2, 94489280512L) && !Key.m579equalsimpl0(keyCode2, -4294967313179869184L) && !Key.m579equalsimpl0(keyCode2, 90194313216L) && !Key.m579equalsimpl0(keyCode2, -4294967308884901888L) && !Key.m579equalsimpl0(keyCode2, 523986010112L) && !Key.m579equalsimpl0(keyCode2, -4294967317474836480L) && !Key.m579equalsimpl0(keyCode2, 528280977408L) && !Key.m579equalsimpl0(keyCode2, -4294967321769803776L) && !Key.m579equalsimpl0(keyCode2, 395136991232L) && !Key.m579equalsimpl0(keyCode2, -4294967326064771072L) && !Key.m579equalsimpl0(keyCode2, 399431958528L) && !Key.m579equalsimpl0(keyCode2, -4294967330359738368L)) {
                            return Boolean.FALSE;
                        }
                        if (function7 != null) {
                            function7.invoke();
                        }
                        return Boolean.TRUE;
                    }
                    ClosedFloatRange closedFloatRange4 = closedFloatRange3;
                    float f = closedFloatRange4._endInclusive;
                    float f2 = closedFloatRange4._start;
                    float fAbs = Math.abs(f - f2);
                    int i7 = i6;
                    int i8 = i7 > 0 ? i7 + 1 : 100;
                    float f3 = fAbs / i8;
                    int i9 = z3 ? -1 : 1;
                    boolean zM579equalsimpl0 = Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, 523986010112L);
                    Function1 function8 = function2;
                    if (zM579equalsimpl0 || Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, -4294967317474836480L)) {
                        function8.invoke(Float.valueOf(f2));
                        return Boolean.TRUE;
                    }
                    if (Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, 528280977408L) || Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, -4294967321769803776L)) {
                        function8.invoke(Float.valueOf(closedFloatRange4._endInclusive));
                        return Boolean.TRUE;
                    }
                    float f4 = floatValue2;
                    if (z4) {
                        long keyCode3 = ((long) keyEvent.getKeyCode()) << 32;
                        if (Key.m579equalsimpl0(keyCode3, 81604378624L) || Key.m579equalsimpl0(keyCode3, -4294967300294967296L)) {
                            function8.invoke(UuidKt.coerceIn(Float.valueOf(f4 - (i9 * f3)), closedFloatRange4));
                            return Boolean.TRUE;
                        }
                        if (Key.m579equalsimpl0(keyCode3, 85899345920L) || Key.m579equalsimpl0(keyCode3, -4294967304589934592L)) {
                            function8.invoke(UuidKt.coerceIn(Float.valueOf((i9 * f3) + f4), closedFloatRange4));
                            return Boolean.TRUE;
                        }
                        if (Key.m579equalsimpl0(keyCode3, 395136991232L) || Key.m579equalsimpl0(keyCode3, -4294967326064771072L)) {
                            function8.invoke(UuidKt.coerceIn(Float.valueOf(f4 - ((UuidKt.coerceIn(i8 / 10, 1, 10) * i9) * f3)), closedFloatRange4));
                            return Boolean.TRUE;
                        }
                        if (!Key.m579equalsimpl0(keyCode3, 399431958528L) && !Key.m579equalsimpl0(keyCode3, -4294967330359738368L)) {
                            return Boolean.FALSE;
                        }
                        function8.invoke(UuidKt.coerceIn(Float.valueOf((UuidKt.coerceIn(i8 / 10, 1, 10) * i9 * f3) + f4), closedFloatRange4));
                        return Boolean.TRUE;
                    }
                    long keyCode4 = ((long) keyEvent.getKeyCode()) << 32;
                    if (Key.m579equalsimpl0(keyCode4, 94489280512L) || Key.m579equalsimpl0(keyCode4, -4294967313179869184L)) {
                        function8.invoke(UuidKt.coerceIn(Float.valueOf((i9 * f3) + f4), closedFloatRange4));
                        return Boolean.TRUE;
                    }
                    if (Key.m579equalsimpl0(keyCode4, 90194313216L) || Key.m579equalsimpl0(keyCode4, -4294967308884901888L)) {
                        function8.invoke(UuidKt.coerceIn(Float.valueOf(f4 - (i9 * f3)), closedFloatRange4));
                        return Boolean.TRUE;
                    }
                    if (Key.m579equalsimpl0(keyCode4, 395136991232L) || Key.m579equalsimpl0(keyCode4, -4294967326064771072L)) {
                        function8.invoke(UuidKt.coerceIn(Float.valueOf((UuidKt.coerceIn(i8 / 10, 1, 10) * f3) + f4), closedFloatRange4));
                        return Boolean.TRUE;
                    }
                    if (!Key.m579equalsimpl0(keyCode4, 399431958528L) && !Key.m579equalsimpl0(keyCode4, -4294967330359738368L)) {
                        return Boolean.FALSE;
                    }
                    function8.invoke(UuidKt.coerceIn(Float.valueOf(f4 - (UuidKt.coerceIn(i8 / 10, 1, 10) * f3)), closedFloatRange4));
                    return Boolean.TRUE;
                }
            }).then(suspendPointerInputElement).then(modifierDraggable$default);
            boolean zChanged = gapComposer3.changed(false) | gapComposer3.changed(mutableStateCollectIsFocusedAsState) | gapComposer3.changedInstance(sliderState);
            Object objRememberedValue3 = gapComposer3.rememberedValue();
            if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new SliderKt$SliderImpl$3$1(sliderState, mutableStateCollectIsFocusedAsState);
                gapComposer3.updateRememberedValue(objRememberedValue3);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue3;
            int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, modifierThen2);
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
            Stack.m390setimpl(gapComposer3, measurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer3, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer3);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            Modifier modifierThen3 = modifier2.then(companion);
            boolean zChanged2 = gapComposer3.changed(false) | gapComposer3.changed(mutableStateCollectIsFocusedAsState) | gapComposer3.changed(density) | gapComposer3.changedInstance(sliderState);
            Object objRememberedValue4 = gapComposer3.rememberedValue();
            if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new SliderKt$$ExternalSyntheticLambda5(density, sliderState, mutableStateCollectIsFocusedAsState);
                gapComposer3.updateRememberedValue(objRememberedValue4);
            }
            Modifier modifierOnSizeChanged = RulerKt.onSizeChanged(modifierThen3, (Function1) objRememberedValue4);
            BiasAlignment biasAlignment = Alignment.Companion.TopStart;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierOnSizeChanged);
            gapComposer3.startReusableNode();
            if (gapComposer3.inserting) {
                gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer3.useNode();
            }
            Stack.m390setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            int i7 = (i3 >> 3) & 14;
            Function3 function7 = function3;
            function7.invoke(sliderState, gapComposer3, Integer.valueOf((i4 & 112) | i7));
            gapComposer3.end(true);
            Modifier modifierLayoutId = RulerKt.layoutId(companion, SliderComponents.TRACK);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            int iHashCode3 = Long.hashCode(gapComposer3.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierLayoutId);
            gapComposer3.startReusableNode();
            if (gapComposer3.inserting) {
                gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer3.useNode();
            }
            Stack.m390setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
            ComposableLambdaImpl composableLambdaImpl3 = composableLambdaImpl;
            composableLambdaImpl3.invoke(sliderState, gapComposer3, Integer.valueOf(((i3 >> 18) & 112) | i7));
            gapComposer3.end(true);
            gapComposer3.end(true);
            composableLambdaImpl2 = composableLambdaImpl3;
            gapComposer = gapComposer3;
            function4 = function7;
        } else {
            GapComposer gapComposer4 = gapComposer2;
            composableLambdaImpl2 = composableLambdaImpl;
            gapComposer4.skipToGroupEnd();
            gapComposer = gapComposer4;
            function4 = function5;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MenuKt$$ExternalSyntheticLambda1(modifier, sliderState, z, function1, function0, mutableInteractionSourceImpl, function4, composableLambdaImpl2, i);
        }
    }

    /* JADX INFO: renamed from: ThumbContent-9LiSoMs, reason: not valid java name */
    public static final void m336ThumbContent9LiSoMs(final MutableInteractionSourceImpl mutableInteractionSourceImpl, final Modifier modifier, final SliderColors sliderColors, final boolean z, final long j, Composer composer, final int i) {
        int i2;
        long jFloatToRawIntBits;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1844845435);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(mutableInteractionSourceImpl) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(sliderColors) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(j) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changed(false) ? 131072 : 65536;
        }
        if (gapComposer.shouldExecute(i2 & 1, (74899 & i2) != 74898)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer);
            }
            SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
            boolean z2 = (i2 & 14) == 4;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (z2 || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new SliderState.AnonymousClass2(mutableInteractionSourceImpl, snapshotStateList, null, (byte) 18);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Stack.LaunchedEffect(gapComposer, mutableInteractionSourceImpl, (Function2) objRememberedValue2);
            if (snapshotStateList.isEmpty()) {
                jFloatToRawIntBits = j;
            } else {
                float fM802getWidthD9Ej5fM = DpSize.m802getWidthD9Ej5fM(j) / 2.0f;
                float fM801getHeightD9Ej5fM = CropImageView.DEFAULT_ASPECT_RATIO;
                float fM802getWidthD9Ej5fM2 = fM802getWidthD9Ej5fM + CropImageView.DEFAULT_ASPECT_RATIO;
                if ((2 & 1) != 0) {
                    fM802getWidthD9Ej5fM2 = DpSize.m802getWidthD9Ej5fM(j);
                }
                if ((2 & 2) != 0) {
                    fM801getHeightD9Ej5fM = DpSize.m801getHeightD9Ej5fM(j);
                }
                jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fM801getHeightD9Ej5fM)) & 4294967295L) | (((long) Float.floatToRawIntBits(fM802getWidthD9Ej5fM2)) << 32);
            }
            FillElement fillElement = SizeKt.FillWholeMaxWidth;
            Modifier modifierThen = SizeKt.m152sizeVpY3zN4(modifier, DpSize.m802getWidthD9Ej5fM(j), DpSize.m801getHeightD9Ej5fM(j)).then(new HoverableElement(mutableInteractionSourceImpl));
            PointerIcon.Companion.getClass();
            Modifier modifierThen2 = modifierThen.then(new PointerHoverIconModifierElement(PointerIconKt.pointerIconHand));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen2);
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
            OffsetKt.Spacer(gapComposer, ImageKt.m39backgroundbw27NRU(SizeKt.m152sizeVpY3zN4(Modifier.Companion.$$INSTANCE, DpSize.m802getWidthD9Ej5fM(jFloatToRawIntBits), DpSize.m801getHeightD9Ej5fM(jFloatToRawIntBits)), z ? sliderColors.thumbColor : sliderColors.disabledThumbColor, ShapesKt.getValue(6, gapComposer)));
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    SliderKt.m336ThumbContent9LiSoMs(mutableInteractionSourceImpl, modifier, sliderColors, z, j, (Composer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final float snapValueToTick(float f, float f2, float f3, float[] fArr) {
        Float fValueOf;
        if (fArr.length == 0) {
            fValueOf = null;
        } else {
            float f4 = fArr[0];
            int i = 1;
            int length = fArr.length - 1;
            if (length == 0) {
                fValueOf = Float.valueOf(f4);
            } else {
                float fAbs = Math.abs(LifecyclesKt.lerp(f2, f3, f4) - f);
                if (1 <= length) {
                    while (true) {
                        float f5 = fArr[i];
                        float fAbs2 = Math.abs(LifecyclesKt.lerp(f2, f3, f5) - f);
                        if (Float.compare(fAbs, fAbs2) > 0) {
                            f4 = f5;
                            fAbs = fAbs2;
                        }
                        if (i == length) {
                            break;
                        }
                        i++;
                    }
                }
                fValueOf = Float.valueOf(f4);
            }
        }
        return fValueOf != null ? LifecyclesKt.lerp(f2, f3, fValueOf.floatValue()) : f;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0124  */
    /* JADX WARN: Code duplicated, block: B:105:0x0127  */
    /* JADX WARN: Code duplicated, block: B:107:0x012a  */
    /* JADX WARN: Code duplicated, block: B:110:0x012f  */
    /* JADX WARN: Code duplicated, block: B:112:0x013a  */
    /* JADX WARN: Code duplicated, block: B:114:0x0142  */
    /* JADX WARN: Code duplicated, block: B:117:0x014b  */
    /* JADX WARN: Code duplicated, block: B:120:0x0160  */
    /* JADX WARN: Code duplicated, block: B:121:0x018f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0196  */
    /* JADX WARN: Code duplicated, block: B:126:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0066  */
    /* JADX WARN: Code duplicated, block: B:40:0x006b  */
    /* JADX WARN: Code duplicated, block: B:42:0x006f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0077  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:49:0x0082  */
    /* JADX WARN: Code duplicated, block: B:51:0x0086  */
    /* JADX WARN: Code duplicated, block: B:53:0x008e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0091  */
    /* JADX WARN: Code duplicated, block: B:57:0x0097  */
    /* JADX WARN: Code duplicated, block: B:60:0x009f  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:73:0x00be  */
    /* JADX WARN: Code duplicated, block: B:75:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:77:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:82:0x00da  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:87:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:94:0x0102  */
    /* JADX WARN: Code duplicated, block: B:96:0x010c  */
    public static final void Slider(SliderState sliderState, Modifier modifier, boolean z, Function1 function1, Function0 function0, SliderColors sliderColors, MutableInteractionSourceImpl mutableInteractionSourceImpl, Function3 function3, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i, int i2) {
        int i3;
        Function1 function2;
        int i4;
        Function0 function4;
        int i5;
        SliderColors sliderColorsColors;
        int i6;
        MutableInteractionSourceImpl mutableInteractionSourceImpl2;
        int i7;
        int i8;
        Function3 function3RememberComposableLambda;
        int i9;
        int i10;
        int i11;
        byte b;
        boolean z2;
        Function1 function5;
        Function0 function6;
        SliderColors sliderColors2;
        MutableInteractionSourceImpl mutableInteractionSourceImpl3;
        Function3 function7;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Object objRememberedValue;
        Function1 function8;
        Function0 function9;
        SliderColors sliderColors3;
        MutableInteractionSourceImpl mutableInteractionSourceImpl4;
        Function3 function10;
        int i12;
        int i13;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1063586191);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changedInstance(sliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer.changed(z) ? 256 : 128;
        }
        int i14 = i2 & 8;
        if (i14 == 0) {
            if ((i & 3072) == 0) {
                function2 = function1;
                i3 |= gapComposer.changedInstance(function2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    function4 = function0;
                    if (gapComposer.changedInstance(function4)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        sliderColorsColors = sliderColors;
                        int i15 = gapComposer.changed(sliderColorsColors) ? 131072 : 65536;
                        i3 |= i15;
                    } else {
                        sliderColorsColors = sliderColors;
                    }
                    i3 |= i15;
                } else {
                    sliderColorsColors = sliderColors;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    if ((1572864 & i) == 0) {
                        mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                        if (gapComposer.changed(mutableInteractionSourceImpl2)) {
                            i7 = ByteChannelKt.CHANNEL_MAX_SIZE;
                        } else {
                            i7 = 524288;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 128;
                    if (i8 != 0) {
                        if ((12582912 & i) == 0) {
                            function3RememberComposableLambda = function3;
                            if (gapComposer.changedInstance(function3RememberComposableLambda)) {
                                i9 = 8388608;
                            } else {
                                i9 = 4194304;
                            }
                            i3 |= i9;
                        }
                        i10 = i3;
                        if ((i & 100663296) == 0) {
                            if (gapComposer.changedInstance(composableLambdaImpl)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i11 = i10 | i13;
                        } else {
                            i11 = i10;
                        }
                        b = 1;
                        if ((i11 & 38347923) != 38347922) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (gapComposer.shouldExecute(i11 & 1, z2)) {
                            gapComposer.startDefaults();
                            if ((i & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                                if (i14 != 0) {
                                    function2 = null;
                                }
                                if (i4 != 0) {
                                    function4 = null;
                                }
                                if ((i2 & 32) != 0) {
                                    SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                                    i11 &= -458753;
                                    sliderColorsColors = SliderDefaults.colors(gapComposer);
                                }
                                if (i6 != 0) {
                                    objRememberedValue = gapComposer.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.Empty) {
                                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                                    }
                                    mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                                }
                                if (i8 != 0) {
                                    function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                                }
                            } else {
                                gapComposer.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i11 &= -458753;
                                }
                            }
                            function8 = function2;
                            function9 = function4;
                            sliderColors3 = sliderColorsColors;
                            mutableInteractionSourceImpl4 = mutableInteractionSourceImpl2;
                            function10 = function3RememberComposableLambda;
                            i12 = i11;
                            gapComposer.endDefaults();
                            if (sliderState.steps >= 0) {
                                int i16 = i12 >> 3;
                                SliderImpl(modifier, sliderState, z, function8, function9, mutableInteractionSourceImpl4, function10, composableLambdaImpl, gapComposer, (i12 & 57344) | (i16 & 14) | ((i12 << 3) & 112) | (i12 & 896) | (i12 & 7168) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128));
                                mutableInteractionSourceImpl3 = mutableInteractionSourceImpl4;
                                function6 = function9;
                                function7 = function10;
                                sliderColors2 = sliderColors3;
                                function5 = function8;
                            } else {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                                return;
                            }
                        } else {
                            gapComposer.skipToGroupEnd();
                            function5 = function2;
                            function6 = function4;
                            sliderColors2 = sliderColorsColors;
                            mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                            function7 = function3RememberComposableLambda;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(sliderState, modifier, z, function5, function6, sliderColors2, mutableInteractionSourceImpl3, function7, composableLambdaImpl, i, i2);
                        }
                    }
                    i3 |= 12582912;
                    function3RememberComposableLambda = function3;
                    i10 = i3;
                    if ((i & 100663296) == 0) {
                        if (gapComposer.changedInstance(composableLambdaImpl)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i11 = i10 | i13;
                    } else {
                        i11 = i10;
                    }
                    b = 1;
                    if ((i11 & 38347923) != 38347922) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (gapComposer.shouldExecute(i11 & 1, z2)) {
                        gapComposer.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                function2 = null;
                            }
                            if (i4 != 0) {
                                function4 = null;
                            }
                            if ((i2 & 32) != 0) {
                                SliderDefaults sliderDefaults2 = SliderDefaults.INSTANCE;
                                i11 &= -458753;
                                sliderColorsColors = SliderDefaults.colors(gapComposer);
                            }
                            if (i6 != 0) {
                                objRememberedValue = gapComposer.rememberedValue();
                                if (objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                                }
                                mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                            }
                            if (i8 != 0) {
                                function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                            }
                        } else {
                            if (i14 != 0) {
                                function2 = null;
                            }
                            if (i4 != 0) {
                                function4 = null;
                            }
                            if ((i2 & 32) != 0) {
                                SliderDefaults sliderDefaults3 = SliderDefaults.INSTANCE;
                                i11 &= -458753;
                                sliderColorsColors = SliderDefaults.colors(gapComposer);
                            }
                            if (i6 != 0) {
                                objRememberedValue = gapComposer.rememberedValue();
                                if (objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                                }
                                mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                            }
                            if (i8 != 0) {
                                function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                            }
                        }
                        function8 = function2;
                        function9 = function4;
                        sliderColors3 = sliderColorsColors;
                        mutableInteractionSourceImpl4 = mutableInteractionSourceImpl2;
                        function10 = function3RememberComposableLambda;
                        i12 = i11;
                        gapComposer.endDefaults();
                        if (sliderState.steps >= 0) {
                            int i17 = i12 >> 3;
                            SliderImpl(modifier, sliderState, z, function8, function9, mutableInteractionSourceImpl4, function10, composableLambdaImpl, gapComposer, (i12 & 57344) | (i17 & 14) | ((i12 << 3) & 112) | (i12 & 896) | (i12 & 7168) | (458752 & i17) | (3670016 & i17) | (i17 & 29360128));
                            mutableInteractionSourceImpl3 = mutableInteractionSourceImpl4;
                            function6 = function9;
                            function7 = function10;
                            sliderColors2 = sliderColors3;
                            function5 = function8;
                        } else {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                            return;
                        }
                    } else {
                        gapComposer.skipToGroupEnd();
                        function5 = function2;
                        function6 = function4;
                        sliderColors2 = sliderColorsColors;
                        mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                        function7 = function3RememberComposableLambda;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(sliderState, modifier, z, function5, function6, sliderColors2, mutableInteractionSourceImpl3, function7, composableLambdaImpl, i, i2);
                    }
                }
                i3 |= 1572864;
                mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                i8 = i2 & 128;
                if (i8 != 0) {
                    if ((12582912 & i) == 0) {
                        function3RememberComposableLambda = function3;
                        if (gapComposer.changedInstance(function3RememberComposableLambda)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                        i3 |= i9;
                    }
                    i10 = i3;
                    if ((i & 100663296) == 0) {
                        if (gapComposer.changedInstance(composableLambdaImpl)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i11 = i10 | i13;
                    } else {
                        i11 = i10;
                    }
                    b = 1;
                    if ((i11 & 38347923) != 38347922) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (gapComposer.shouldExecute(i11 & 1, z2)) {
                        gapComposer.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                function2 = null;
                            }
                            if (i4 != 0) {
                                function4 = null;
                            }
                            if ((i2 & 32) != 0) {
                                SliderDefaults sliderDefaults4 = SliderDefaults.INSTANCE;
                                i11 &= -458753;
                                sliderColorsColors = SliderDefaults.colors(gapComposer);
                            }
                            if (i6 != 0) {
                                objRememberedValue = gapComposer.rememberedValue();
                                if (objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                                }
                                mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                            }
                            if (i8 != 0) {
                                function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                            }
                        } else {
                            if (i14 != 0) {
                                function2 = null;
                            }
                            if (i4 != 0) {
                                function4 = null;
                            }
                            if ((i2 & 32) != 0) {
                                SliderDefaults sliderDefaults5 = SliderDefaults.INSTANCE;
                                i11 &= -458753;
                                sliderColorsColors = SliderDefaults.colors(gapComposer);
                            }
                            if (i6 != 0) {
                                objRememberedValue = gapComposer.rememberedValue();
                                if (objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                                }
                                mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                            }
                            if (i8 != 0) {
                                function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                            }
                        }
                        function8 = function2;
                        function9 = function4;
                        sliderColors3 = sliderColorsColors;
                        mutableInteractionSourceImpl4 = mutableInteractionSourceImpl2;
                        function10 = function3RememberComposableLambda;
                        i12 = i11;
                        gapComposer.endDefaults();
                        if (sliderState.steps >= 0) {
                            int i18 = i12 >> 3;
                            SliderImpl(modifier, sliderState, z, function8, function9, mutableInteractionSourceImpl4, function10, composableLambdaImpl, gapComposer, (i12 & 57344) | (i18 & 14) | ((i12 << 3) & 112) | (i12 & 896) | (i12 & 7168) | (458752 & i18) | (3670016 & i18) | (i18 & 29360128));
                            mutableInteractionSourceImpl3 = mutableInteractionSourceImpl4;
                            function6 = function9;
                            function7 = function10;
                            sliderColors2 = sliderColors3;
                            function5 = function8;
                        } else {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                            return;
                        }
                    } else {
                        gapComposer.skipToGroupEnd();
                        function5 = function2;
                        function6 = function4;
                        sliderColors2 = sliderColorsColors;
                        mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                        function7 = function3RememberComposableLambda;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(sliderState, modifier, z, function5, function6, sliderColors2, mutableInteractionSourceImpl3, function7, composableLambdaImpl, i, i2);
                    }
                }
                i3 |= 12582912;
                function3RememberComposableLambda = function3;
                i10 = i3;
                if ((i & 100663296) == 0) {
                    if (gapComposer.changedInstance(composableLambdaImpl)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i11 = i10 | i13;
                } else {
                    i11 = i10;
                }
                b = 1;
                if ((i11 & 38347923) != 38347922) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (gapComposer.shouldExecute(i11 & 1, z2)) {
                    gapComposer.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            function2 = null;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if ((i2 & 32) != 0) {
                            SliderDefaults sliderDefaults6 = SliderDefaults.INSTANCE;
                            i11 &= -458753;
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        }
                        if (i6 != 0) {
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == Composer.Companion.Empty) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        }
                        if (i8 != 0) {
                            function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                        }
                    } else {
                        if (i14 != 0) {
                            function2 = null;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if ((i2 & 32) != 0) {
                            SliderDefaults sliderDefaults7 = SliderDefaults.INSTANCE;
                            i11 &= -458753;
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        }
                        if (i6 != 0) {
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == Composer.Companion.Empty) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        }
                        if (i8 != 0) {
                            function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                        }
                    }
                    function8 = function2;
                    function9 = function4;
                    sliderColors3 = sliderColorsColors;
                    mutableInteractionSourceImpl4 = mutableInteractionSourceImpl2;
                    function10 = function3RememberComposableLambda;
                    i12 = i11;
                    gapComposer.endDefaults();
                    if (sliderState.steps >= 0) {
                        int i19 = i12 >> 3;
                        SliderImpl(modifier, sliderState, z, function8, function9, mutableInteractionSourceImpl4, function10, composableLambdaImpl, gapComposer, (i12 & 57344) | (i19 & 14) | ((i12 << 3) & 112) | (i12 & 896) | (i12 & 7168) | (458752 & i19) | (3670016 & i19) | (i19 & 29360128));
                        mutableInteractionSourceImpl3 = mutableInteractionSourceImpl4;
                        function6 = function9;
                        function7 = function10;
                        sliderColors2 = sliderColors3;
                        function5 = function8;
                    } else {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                        return;
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                    function5 = function2;
                    function6 = function4;
                    sliderColors2 = sliderColorsColors;
                    mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                    function7 = function3RememberComposableLambda;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(sliderState, modifier, z, function5, function6, sliderColors2, mutableInteractionSourceImpl3, function7, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 24576;
            function4 = function0;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    sliderColorsColors = sliderColors;
                    if (gapComposer.changed(sliderColorsColors)) {
                    }
                    i3 |= i15;
                } else {
                    sliderColorsColors = sliderColors;
                }
                i3 |= i15;
            } else {
                sliderColorsColors = sliderColors;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                if ((1572864 & i) == 0) {
                    mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                    if (gapComposer.changed(mutableInteractionSourceImpl2)) {
                        i7 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    if ((12582912 & i) == 0) {
                        function3RememberComposableLambda = function3;
                        if (gapComposer.changedInstance(function3RememberComposableLambda)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                        i3 |= i9;
                    }
                    i10 = i3;
                    if ((i & 100663296) == 0) {
                        if (gapComposer.changedInstance(composableLambdaImpl)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i11 = i10 | i13;
                    } else {
                        i11 = i10;
                    }
                    b = 1;
                    if ((i11 & 38347923) != 38347922) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (gapComposer.shouldExecute(i11 & 1, z2)) {
                        gapComposer.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                function2 = null;
                            }
                            if (i4 != 0) {
                                function4 = null;
                            }
                            if ((i2 & 32) != 0) {
                                SliderDefaults sliderDefaults8 = SliderDefaults.INSTANCE;
                                i11 &= -458753;
                                sliderColorsColors = SliderDefaults.colors(gapComposer);
                            }
                            if (i6 != 0) {
                                objRememberedValue = gapComposer.rememberedValue();
                                if (objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                                }
                                mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                            }
                            if (i8 != 0) {
                                function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                            }
                        } else {
                            if (i14 != 0) {
                                function2 = null;
                            }
                            if (i4 != 0) {
                                function4 = null;
                            }
                            if ((i2 & 32) != 0) {
                                SliderDefaults sliderDefaults9 = SliderDefaults.INSTANCE;
                                i11 &= -458753;
                                sliderColorsColors = SliderDefaults.colors(gapComposer);
                            }
                            if (i6 != 0) {
                                objRememberedValue = gapComposer.rememberedValue();
                                if (objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                                }
                                mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                            }
                            if (i8 != 0) {
                                function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                            }
                        }
                        function8 = function2;
                        function9 = function4;
                        sliderColors3 = sliderColorsColors;
                        mutableInteractionSourceImpl4 = mutableInteractionSourceImpl2;
                        function10 = function3RememberComposableLambda;
                        i12 = i11;
                        gapComposer.endDefaults();
                        if (sliderState.steps >= 0) {
                            int i110 = i12 >> 3;
                            SliderImpl(modifier, sliderState, z, function8, function9, mutableInteractionSourceImpl4, function10, composableLambdaImpl, gapComposer, (i12 & 57344) | (i110 & 14) | ((i12 << 3) & 112) | (i12 & 896) | (i12 & 7168) | (458752 & i110) | (3670016 & i110) | (i110 & 29360128));
                            mutableInteractionSourceImpl3 = mutableInteractionSourceImpl4;
                            function6 = function9;
                            function7 = function10;
                            sliderColors2 = sliderColors3;
                            function5 = function8;
                        } else {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                            return;
                        }
                    } else {
                        gapComposer.skipToGroupEnd();
                        function5 = function2;
                        function6 = function4;
                        sliderColors2 = sliderColorsColors;
                        mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                        function7 = function3RememberComposableLambda;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(sliderState, modifier, z, function5, function6, sliderColors2, mutableInteractionSourceImpl3, function7, composableLambdaImpl, i, i2);
                    }
                }
                i3 |= 12582912;
                function3RememberComposableLambda = function3;
                i10 = i3;
                if ((i & 100663296) == 0) {
                    if (gapComposer.changedInstance(composableLambdaImpl)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i11 = i10 | i13;
                } else {
                    i11 = i10;
                }
                b = 1;
                if ((i11 & 38347923) != 38347922) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (gapComposer.shouldExecute(i11 & 1, z2)) {
                    gapComposer.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            function2 = null;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if ((i2 & 32) != 0) {
                            SliderDefaults sliderDefaults10 = SliderDefaults.INSTANCE;
                            i11 &= -458753;
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        }
                        if (i6 != 0) {
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == Composer.Companion.Empty) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        }
                        if (i8 != 0) {
                            function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                        }
                    } else {
                        if (i14 != 0) {
                            function2 = null;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if ((i2 & 32) != 0) {
                            SliderDefaults sliderDefaults11 = SliderDefaults.INSTANCE;
                            i11 &= -458753;
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        }
                        if (i6 != 0) {
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == Composer.Companion.Empty) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        }
                        if (i8 != 0) {
                            function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                        }
                    }
                    function8 = function2;
                    function9 = function4;
                    sliderColors3 = sliderColorsColors;
                    mutableInteractionSourceImpl4 = mutableInteractionSourceImpl2;
                    function10 = function3RememberComposableLambda;
                    i12 = i11;
                    gapComposer.endDefaults();
                    if (sliderState.steps >= 0) {
                        int i111 = i12 >> 3;
                        SliderImpl(modifier, sliderState, z, function8, function9, mutableInteractionSourceImpl4, function10, composableLambdaImpl, gapComposer, (i12 & 57344) | (i111 & 14) | ((i12 << 3) & 112) | (i12 & 896) | (i12 & 7168) | (458752 & i111) | (3670016 & i111) | (i111 & 29360128));
                        mutableInteractionSourceImpl3 = mutableInteractionSourceImpl4;
                        function6 = function9;
                        function7 = function10;
                        sliderColors2 = sliderColors3;
                        function5 = function8;
                    } else {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                        return;
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                    function5 = function2;
                    function6 = function4;
                    sliderColors2 = sliderColorsColors;
                    mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                    function7 = function3RememberComposableLambda;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(sliderState, modifier, z, function5, function6, sliderColors2, mutableInteractionSourceImpl3, function7, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 1572864;
            mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
            i8 = i2 & 128;
            if (i8 != 0) {
                if ((12582912 & i) == 0) {
                    function3RememberComposableLambda = function3;
                    if (gapComposer.changedInstance(function3RememberComposableLambda)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                i10 = i3;
                if ((i & 100663296) == 0) {
                    if (gapComposer.changedInstance(composableLambdaImpl)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i11 = i10 | i13;
                } else {
                    i11 = i10;
                }
                b = 1;
                if ((i11 & 38347923) != 38347922) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (gapComposer.shouldExecute(i11 & 1, z2)) {
                    gapComposer.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            function2 = null;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if ((i2 & 32) != 0) {
                            SliderDefaults sliderDefaults12 = SliderDefaults.INSTANCE;
                            i11 &= -458753;
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        }
                        if (i6 != 0) {
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == Composer.Companion.Empty) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        }
                        if (i8 != 0) {
                            function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                        }
                    } else {
                        if (i14 != 0) {
                            function2 = null;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if ((i2 & 32) != 0) {
                            SliderDefaults sliderDefaults13 = SliderDefaults.INSTANCE;
                            i11 &= -458753;
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        }
                        if (i6 != 0) {
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == Composer.Companion.Empty) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        }
                        if (i8 != 0) {
                            function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                        }
                    }
                    function8 = function2;
                    function9 = function4;
                    sliderColors3 = sliderColorsColors;
                    mutableInteractionSourceImpl4 = mutableInteractionSourceImpl2;
                    function10 = function3RememberComposableLambda;
                    i12 = i11;
                    gapComposer.endDefaults();
                    if (sliderState.steps >= 0) {
                        int i112 = i12 >> 3;
                        SliderImpl(modifier, sliderState, z, function8, function9, mutableInteractionSourceImpl4, function10, composableLambdaImpl, gapComposer, (i12 & 57344) | (i112 & 14) | ((i12 << 3) & 112) | (i12 & 896) | (i12 & 7168) | (458752 & i112) | (3670016 & i112) | (i112 & 29360128));
                        mutableInteractionSourceImpl3 = mutableInteractionSourceImpl4;
                        function6 = function9;
                        function7 = function10;
                        sliderColors2 = sliderColors3;
                        function5 = function8;
                    } else {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                        return;
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                    function5 = function2;
                    function6 = function4;
                    sliderColors2 = sliderColorsColors;
                    mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                    function7 = function3RememberComposableLambda;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(sliderState, modifier, z, function5, function6, sliderColors2, mutableInteractionSourceImpl3, function7, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 12582912;
            function3RememberComposableLambda = function3;
            i10 = i3;
            if ((i & 100663296) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i11 = i10 | i13;
            } else {
                i11 = i10;
            }
            b = 1;
            if ((i11 & 38347923) != 38347922) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (gapComposer.shouldExecute(i11 & 1, z2)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        function2 = null;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if ((i2 & 32) != 0) {
                        SliderDefaults sliderDefaults14 = SliderDefaults.INSTANCE;
                        i11 &= -458753;
                        sliderColorsColors = SliderDefaults.colors(gapComposer);
                    }
                    if (i6 != 0) {
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == Composer.Companion.Empty) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    }
                    if (i8 != 0) {
                        function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                    }
                } else {
                    if (i14 != 0) {
                        function2 = null;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if ((i2 & 32) != 0) {
                        SliderDefaults sliderDefaults15 = SliderDefaults.INSTANCE;
                        i11 &= -458753;
                        sliderColorsColors = SliderDefaults.colors(gapComposer);
                    }
                    if (i6 != 0) {
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == Composer.Companion.Empty) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    }
                    if (i8 != 0) {
                        function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                    }
                }
                function8 = function2;
                function9 = function4;
                sliderColors3 = sliderColorsColors;
                mutableInteractionSourceImpl4 = mutableInteractionSourceImpl2;
                function10 = function3RememberComposableLambda;
                i12 = i11;
                gapComposer.endDefaults();
                if (sliderState.steps >= 0) {
                    int i113 = i12 >> 3;
                    SliderImpl(modifier, sliderState, z, function8, function9, mutableInteractionSourceImpl4, function10, composableLambdaImpl, gapComposer, (i12 & 57344) | (i113 & 14) | ((i12 << 3) & 112) | (i12 & 896) | (i12 & 7168) | (458752 & i113) | (3670016 & i113) | (i113 & 29360128));
                    mutableInteractionSourceImpl3 = mutableInteractionSourceImpl4;
                    function6 = function9;
                    function7 = function10;
                    sliderColors2 = sliderColors3;
                    function5 = function8;
                } else {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                    return;
                }
            } else {
                gapComposer.skipToGroupEnd();
                function5 = function2;
                function6 = function4;
                sliderColors2 = sliderColorsColors;
                mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                function7 = function3RememberComposableLambda;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(sliderState, modifier, z, function5, function6, sliderColors2, mutableInteractionSourceImpl3, function7, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 3072;
        function2 = function1;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                function4 = function0;
                if (gapComposer.changedInstance(function4)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    sliderColorsColors = sliderColors;
                    if (gapComposer.changed(sliderColorsColors)) {
                    }
                    i3 |= i15;
                } else {
                    sliderColorsColors = sliderColors;
                }
                i3 |= i15;
            } else {
                sliderColorsColors = sliderColors;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                if ((1572864 & i) == 0) {
                    mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                    if (gapComposer.changed(mutableInteractionSourceImpl2)) {
                        i7 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    if ((12582912 & i) == 0) {
                        function3RememberComposableLambda = function3;
                        if (gapComposer.changedInstance(function3RememberComposableLambda)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                        i3 |= i9;
                    }
                    i10 = i3;
                    if ((i & 100663296) == 0) {
                        if (gapComposer.changedInstance(composableLambdaImpl)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i11 = i10 | i13;
                    } else {
                        i11 = i10;
                    }
                    b = 1;
                    if ((i11 & 38347923) != 38347922) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (gapComposer.shouldExecute(i11 & 1, z2)) {
                        gapComposer.startDefaults();
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                function2 = null;
                            }
                            if (i4 != 0) {
                                function4 = null;
                            }
                            if ((i2 & 32) != 0) {
                                SliderDefaults sliderDefaults16 = SliderDefaults.INSTANCE;
                                i11 &= -458753;
                                sliderColorsColors = SliderDefaults.colors(gapComposer);
                            }
                            if (i6 != 0) {
                                objRememberedValue = gapComposer.rememberedValue();
                                if (objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                                }
                                mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                            }
                            if (i8 != 0) {
                                function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                            }
                        } else {
                            if (i14 != 0) {
                                function2 = null;
                            }
                            if (i4 != 0) {
                                function4 = null;
                            }
                            if ((i2 & 32) != 0) {
                                SliderDefaults sliderDefaults17 = SliderDefaults.INSTANCE;
                                i11 &= -458753;
                                sliderColorsColors = SliderDefaults.colors(gapComposer);
                            }
                            if (i6 != 0) {
                                objRememberedValue = gapComposer.rememberedValue();
                                if (objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                                }
                                mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                            }
                            if (i8 != 0) {
                                function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                            }
                        }
                        function8 = function2;
                        function9 = function4;
                        sliderColors3 = sliderColorsColors;
                        mutableInteractionSourceImpl4 = mutableInteractionSourceImpl2;
                        function10 = function3RememberComposableLambda;
                        i12 = i11;
                        gapComposer.endDefaults();
                        if (sliderState.steps >= 0) {
                            int i114 = i12 >> 3;
                            SliderImpl(modifier, sliderState, z, function8, function9, mutableInteractionSourceImpl4, function10, composableLambdaImpl, gapComposer, (i12 & 57344) | (i114 & 14) | ((i12 << 3) & 112) | (i12 & 896) | (i12 & 7168) | (458752 & i114) | (3670016 & i114) | (i114 & 29360128));
                            mutableInteractionSourceImpl3 = mutableInteractionSourceImpl4;
                            function6 = function9;
                            function7 = function10;
                            sliderColors2 = sliderColors3;
                            function5 = function8;
                        } else {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                            return;
                        }
                    } else {
                        gapComposer.skipToGroupEnd();
                        function5 = function2;
                        function6 = function4;
                        sliderColors2 = sliderColorsColors;
                        mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                        function7 = function3RememberComposableLambda;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(sliderState, modifier, z, function5, function6, sliderColors2, mutableInteractionSourceImpl3, function7, composableLambdaImpl, i, i2);
                    }
                }
                i3 |= 12582912;
                function3RememberComposableLambda = function3;
                i10 = i3;
                if ((i & 100663296) == 0) {
                    if (gapComposer.changedInstance(composableLambdaImpl)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i11 = i10 | i13;
                } else {
                    i11 = i10;
                }
                b = 1;
                if ((i11 & 38347923) != 38347922) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (gapComposer.shouldExecute(i11 & 1, z2)) {
                    gapComposer.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            function2 = null;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if ((i2 & 32) != 0) {
                            SliderDefaults sliderDefaults18 = SliderDefaults.INSTANCE;
                            i11 &= -458753;
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        }
                        if (i6 != 0) {
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == Composer.Companion.Empty) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        }
                        if (i8 != 0) {
                            function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                        }
                    } else {
                        if (i14 != 0) {
                            function2 = null;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if ((i2 & 32) != 0) {
                            SliderDefaults sliderDefaults19 = SliderDefaults.INSTANCE;
                            i11 &= -458753;
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        }
                        if (i6 != 0) {
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == Composer.Companion.Empty) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        }
                        if (i8 != 0) {
                            function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                        }
                    }
                    function8 = function2;
                    function9 = function4;
                    sliderColors3 = sliderColorsColors;
                    mutableInteractionSourceImpl4 = mutableInteractionSourceImpl2;
                    function10 = function3RememberComposableLambda;
                    i12 = i11;
                    gapComposer.endDefaults();
                    if (sliderState.steps >= 0) {
                        int i115 = i12 >> 3;
                        SliderImpl(modifier, sliderState, z, function8, function9, mutableInteractionSourceImpl4, function10, composableLambdaImpl, gapComposer, (i12 & 57344) | (i115 & 14) | ((i12 << 3) & 112) | (i12 & 896) | (i12 & 7168) | (458752 & i115) | (3670016 & i115) | (i115 & 29360128));
                        mutableInteractionSourceImpl3 = mutableInteractionSourceImpl4;
                        function6 = function9;
                        function7 = function10;
                        sliderColors2 = sliderColors3;
                        function5 = function8;
                    } else {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                        return;
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                    function5 = function2;
                    function6 = function4;
                    sliderColors2 = sliderColorsColors;
                    mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                    function7 = function3RememberComposableLambda;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(sliderState, modifier, z, function5, function6, sliderColors2, mutableInteractionSourceImpl3, function7, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 1572864;
            mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
            i8 = i2 & 128;
            if (i8 != 0) {
                if ((12582912 & i) == 0) {
                    function3RememberComposableLambda = function3;
                    if (gapComposer.changedInstance(function3RememberComposableLambda)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                i10 = i3;
                if ((i & 100663296) == 0) {
                    if (gapComposer.changedInstance(composableLambdaImpl)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i11 = i10 | i13;
                } else {
                    i11 = i10;
                }
                b = 1;
                if ((i11 & 38347923) != 38347922) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (gapComposer.shouldExecute(i11 & 1, z2)) {
                    gapComposer.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            function2 = null;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if ((i2 & 32) != 0) {
                            SliderDefaults sliderDefaults110 = SliderDefaults.INSTANCE;
                            i11 &= -458753;
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        }
                        if (i6 != 0) {
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == Composer.Companion.Empty) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        }
                        if (i8 != 0) {
                            function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                        }
                    } else {
                        if (i14 != 0) {
                            function2 = null;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if ((i2 & 32) != 0) {
                            SliderDefaults sliderDefaults111 = SliderDefaults.INSTANCE;
                            i11 &= -458753;
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        }
                        if (i6 != 0) {
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == Composer.Companion.Empty) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        }
                        if (i8 != 0) {
                            function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                        }
                    }
                    function8 = function2;
                    function9 = function4;
                    sliderColors3 = sliderColorsColors;
                    mutableInteractionSourceImpl4 = mutableInteractionSourceImpl2;
                    function10 = function3RememberComposableLambda;
                    i12 = i11;
                    gapComposer.endDefaults();
                    if (sliderState.steps >= 0) {
                        int i116 = i12 >> 3;
                        SliderImpl(modifier, sliderState, z, function8, function9, mutableInteractionSourceImpl4, function10, composableLambdaImpl, gapComposer, (i12 & 57344) | (i116 & 14) | ((i12 << 3) & 112) | (i12 & 896) | (i12 & 7168) | (458752 & i116) | (3670016 & i116) | (i116 & 29360128));
                        mutableInteractionSourceImpl3 = mutableInteractionSourceImpl4;
                        function6 = function9;
                        function7 = function10;
                        sliderColors2 = sliderColors3;
                        function5 = function8;
                    } else {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                        return;
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                    function5 = function2;
                    function6 = function4;
                    sliderColors2 = sliderColorsColors;
                    mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                    function7 = function3RememberComposableLambda;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(sliderState, modifier, z, function5, function6, sliderColors2, mutableInteractionSourceImpl3, function7, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 12582912;
            function3RememberComposableLambda = function3;
            i10 = i3;
            if ((i & 100663296) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i11 = i10 | i13;
            } else {
                i11 = i10;
            }
            b = 1;
            if ((i11 & 38347923) != 38347922) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (gapComposer.shouldExecute(i11 & 1, z2)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        function2 = null;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if ((i2 & 32) != 0) {
                        SliderDefaults sliderDefaults112 = SliderDefaults.INSTANCE;
                        i11 &= -458753;
                        sliderColorsColors = SliderDefaults.colors(gapComposer);
                    }
                    if (i6 != 0) {
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == Composer.Companion.Empty) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    }
                    if (i8 != 0) {
                        function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                    }
                } else {
                    if (i14 != 0) {
                        function2 = null;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if ((i2 & 32) != 0) {
                        SliderDefaults sliderDefaults113 = SliderDefaults.INSTANCE;
                        i11 &= -458753;
                        sliderColorsColors = SliderDefaults.colors(gapComposer);
                    }
                    if (i6 != 0) {
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == Composer.Companion.Empty) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    }
                    if (i8 != 0) {
                        function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                    }
                }
                function8 = function2;
                function9 = function4;
                sliderColors3 = sliderColorsColors;
                mutableInteractionSourceImpl4 = mutableInteractionSourceImpl2;
                function10 = function3RememberComposableLambda;
                i12 = i11;
                gapComposer.endDefaults();
                if (sliderState.steps >= 0) {
                    int i117 = i12 >> 3;
                    SliderImpl(modifier, sliderState, z, function8, function9, mutableInteractionSourceImpl4, function10, composableLambdaImpl, gapComposer, (i12 & 57344) | (i117 & 14) | ((i12 << 3) & 112) | (i12 & 896) | (i12 & 7168) | (458752 & i117) | (3670016 & i117) | (i117 & 29360128));
                    mutableInteractionSourceImpl3 = mutableInteractionSourceImpl4;
                    function6 = function9;
                    function7 = function10;
                    sliderColors2 = sliderColors3;
                    function5 = function8;
                } else {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                    return;
                }
            } else {
                gapComposer.skipToGroupEnd();
                function5 = function2;
                function6 = function4;
                sliderColors2 = sliderColorsColors;
                mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                function7 = function3RememberComposableLambda;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(sliderState, modifier, z, function5, function6, sliderColors2, mutableInteractionSourceImpl3, function7, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 24576;
        function4 = function0;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                sliderColorsColors = sliderColors;
                if (gapComposer.changed(sliderColorsColors)) {
                }
                i3 |= i15;
            } else {
                sliderColorsColors = sliderColors;
            }
            i3 |= i15;
        } else {
            sliderColorsColors = sliderColors;
        }
        i6 = i2 & 64;
        if (i6 != 0) {
            if ((1572864 & i) == 0) {
                mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                if (gapComposer.changed(mutableInteractionSourceImpl2)) {
                    i7 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                if ((12582912 & i) == 0) {
                    function3RememberComposableLambda = function3;
                    if (gapComposer.changedInstance(function3RememberComposableLambda)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                i10 = i3;
                if ((i & 100663296) == 0) {
                    if (gapComposer.changedInstance(composableLambdaImpl)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i11 = i10 | i13;
                } else {
                    i11 = i10;
                }
                b = 1;
                if ((i11 & 38347923) != 38347922) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (gapComposer.shouldExecute(i11 & 1, z2)) {
                    gapComposer.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            function2 = null;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if ((i2 & 32) != 0) {
                            SliderDefaults sliderDefaults114 = SliderDefaults.INSTANCE;
                            i11 &= -458753;
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        }
                        if (i6 != 0) {
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == Composer.Companion.Empty) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        }
                        if (i8 != 0) {
                            function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                        }
                    } else {
                        if (i14 != 0) {
                            function2 = null;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        }
                        if ((i2 & 32) != 0) {
                            SliderDefaults sliderDefaults115 = SliderDefaults.INSTANCE;
                            i11 &= -458753;
                            sliderColorsColors = SliderDefaults.colors(gapComposer);
                        }
                        if (i6 != 0) {
                            objRememberedValue = gapComposer.rememberedValue();
                            if (objRememberedValue == Composer.Companion.Empty) {
                                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                            }
                            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                        }
                        if (i8 != 0) {
                            function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                        }
                    }
                    function8 = function2;
                    function9 = function4;
                    sliderColors3 = sliderColorsColors;
                    mutableInteractionSourceImpl4 = mutableInteractionSourceImpl2;
                    function10 = function3RememberComposableLambda;
                    i12 = i11;
                    gapComposer.endDefaults();
                    if (sliderState.steps >= 0) {
                        int i118 = i12 >> 3;
                        SliderImpl(modifier, sliderState, z, function8, function9, mutableInteractionSourceImpl4, function10, composableLambdaImpl, gapComposer, (i12 & 57344) | (i118 & 14) | ((i12 << 3) & 112) | (i12 & 896) | (i12 & 7168) | (458752 & i118) | (3670016 & i118) | (i118 & 29360128));
                        mutableInteractionSourceImpl3 = mutableInteractionSourceImpl4;
                        function6 = function9;
                        function7 = function10;
                        sliderColors2 = sliderColors3;
                        function5 = function8;
                    } else {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                        return;
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                    function5 = function2;
                    function6 = function4;
                    sliderColors2 = sliderColorsColors;
                    mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                    function7 = function3RememberComposableLambda;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(sliderState, modifier, z, function5, function6, sliderColors2, mutableInteractionSourceImpl3, function7, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 12582912;
            function3RememberComposableLambda = function3;
            i10 = i3;
            if ((i & 100663296) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i11 = i10 | i13;
            } else {
                i11 = i10;
            }
            b = 1;
            if ((i11 & 38347923) != 38347922) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (gapComposer.shouldExecute(i11 & 1, z2)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        function2 = null;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if ((i2 & 32) != 0) {
                        SliderDefaults sliderDefaults116 = SliderDefaults.INSTANCE;
                        i11 &= -458753;
                        sliderColorsColors = SliderDefaults.colors(gapComposer);
                    }
                    if (i6 != 0) {
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == Composer.Companion.Empty) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    }
                    if (i8 != 0) {
                        function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                    }
                } else {
                    if (i14 != 0) {
                        function2 = null;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if ((i2 & 32) != 0) {
                        SliderDefaults sliderDefaults117 = SliderDefaults.INSTANCE;
                        i11 &= -458753;
                        sliderColorsColors = SliderDefaults.colors(gapComposer);
                    }
                    if (i6 != 0) {
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == Composer.Companion.Empty) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    }
                    if (i8 != 0) {
                        function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                    }
                }
                function8 = function2;
                function9 = function4;
                sliderColors3 = sliderColorsColors;
                mutableInteractionSourceImpl4 = mutableInteractionSourceImpl2;
                function10 = function3RememberComposableLambda;
                i12 = i11;
                gapComposer.endDefaults();
                if (sliderState.steps >= 0) {
                    int i119 = i12 >> 3;
                    SliderImpl(modifier, sliderState, z, function8, function9, mutableInteractionSourceImpl4, function10, composableLambdaImpl, gapComposer, (i12 & 57344) | (i119 & 14) | ((i12 << 3) & 112) | (i12 & 896) | (i12 & 7168) | (458752 & i119) | (3670016 & i119) | (i119 & 29360128));
                    mutableInteractionSourceImpl3 = mutableInteractionSourceImpl4;
                    function6 = function9;
                    function7 = function10;
                    sliderColors2 = sliderColors3;
                    function5 = function8;
                } else {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                    return;
                }
            } else {
                gapComposer.skipToGroupEnd();
                function5 = function2;
                function6 = function4;
                sliderColors2 = sliderColorsColors;
                mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                function7 = function3RememberComposableLambda;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(sliderState, modifier, z, function5, function6, sliderColors2, mutableInteractionSourceImpl3, function7, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 1572864;
        mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
        i8 = i2 & 128;
        if (i8 != 0) {
            if ((12582912 & i) == 0) {
                function3RememberComposableLambda = function3;
                if (gapComposer.changedInstance(function3RememberComposableLambda)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            i10 = i3;
            if ((i & 100663296) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i11 = i10 | i13;
            } else {
                i11 = i10;
            }
            b = 1;
            if ((i11 & 38347923) != 38347922) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (gapComposer.shouldExecute(i11 & 1, z2)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        function2 = null;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if ((i2 & 32) != 0) {
                        SliderDefaults sliderDefaults118 = SliderDefaults.INSTANCE;
                        i11 &= -458753;
                        sliderColorsColors = SliderDefaults.colors(gapComposer);
                    }
                    if (i6 != 0) {
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == Composer.Companion.Empty) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    }
                    if (i8 != 0) {
                        function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                    }
                } else {
                    if (i14 != 0) {
                        function2 = null;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    }
                    if ((i2 & 32) != 0) {
                        SliderDefaults sliderDefaults119 = SliderDefaults.INSTANCE;
                        i11 &= -458753;
                        sliderColorsColors = SliderDefaults.colors(gapComposer);
                    }
                    if (i6 != 0) {
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == Composer.Companion.Empty) {
                            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                        }
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    }
                    if (i8 != 0) {
                        function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                    }
                }
                function8 = function2;
                function9 = function4;
                sliderColors3 = sliderColorsColors;
                mutableInteractionSourceImpl4 = mutableInteractionSourceImpl2;
                function10 = function3RememberComposableLambda;
                i12 = i11;
                gapComposer.endDefaults();
                if (sliderState.steps >= 0) {
                    int i1110 = i12 >> 3;
                    SliderImpl(modifier, sliderState, z, function8, function9, mutableInteractionSourceImpl4, function10, composableLambdaImpl, gapComposer, (i12 & 57344) | (i1110 & 14) | ((i12 << 3) & 112) | (i12 & 896) | (i12 & 7168) | (458752 & i1110) | (3670016 & i1110) | (i1110 & 29360128));
                    mutableInteractionSourceImpl3 = mutableInteractionSourceImpl4;
                    function6 = function9;
                    function7 = function10;
                    sliderColors2 = sliderColors3;
                    function5 = function8;
                } else {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                    return;
                }
            } else {
                gapComposer.skipToGroupEnd();
                function5 = function2;
                function6 = function4;
                sliderColors2 = sliderColorsColors;
                mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                function7 = function3RememberComposableLambda;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(sliderState, modifier, z, function5, function6, sliderColors2, mutableInteractionSourceImpl3, function7, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 12582912;
        function3RememberComposableLambda = function3;
        i10 = i3;
        if ((i & 100663296) == 0) {
            if (gapComposer.changedInstance(composableLambdaImpl)) {
                i13 = 67108864;
            } else {
                i13 = 33554432;
            }
            i11 = i10 | i13;
        } else {
            i11 = i10;
        }
        b = 1;
        if ((i11 & 38347923) != 38347922) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (gapComposer.shouldExecute(i11 & 1, z2)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    function2 = null;
                }
                if (i4 != 0) {
                    function4 = null;
                }
                if ((i2 & 32) != 0) {
                    SliderDefaults sliderDefaults1110 = SliderDefaults.INSTANCE;
                    i11 &= -458753;
                    sliderColorsColors = SliderDefaults.colors(gapComposer);
                }
                if (i6 != 0) {
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                }
                if (i8 != 0) {
                    function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                }
            } else {
                if (i14 != 0) {
                    function2 = null;
                }
                if (i4 != 0) {
                    function4 = null;
                }
                if ((i2 & 32) != 0) {
                    SliderDefaults sliderDefaults1111 = SliderDefaults.INSTANCE;
                    i11 &= -458753;
                    sliderColorsColors = SliderDefaults.colors(gapComposer);
                }
                if (i6 != 0) {
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                }
                if (i8 != 0) {
                    function3RememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1018759489, new SliderKt$$ExternalSyntheticLambda0(mutableInteractionSourceImpl2, sliderColorsColors, z, b), gapComposer);
                }
            }
            function8 = function2;
            function9 = function4;
            sliderColors3 = sliderColorsColors;
            mutableInteractionSourceImpl4 = mutableInteractionSourceImpl2;
            function10 = function3RememberComposableLambda;
            i12 = i11;
            gapComposer.endDefaults();
            if (sliderState.steps >= 0) {
                int i1111 = i12 >> 3;
                SliderImpl(modifier, sliderState, z, function8, function9, mutableInteractionSourceImpl4, function10, composableLambdaImpl, gapComposer, (i12 & 57344) | (i1111 & 14) | ((i12 << 3) & 112) | (i12 & 896) | (i12 & 7168) | (458752 & i1111) | (3670016 & i1111) | (i1111 & 29360128));
                mutableInteractionSourceImpl3 = mutableInteractionSourceImpl4;
                function6 = function9;
                function7 = function10;
                sliderColors2 = sliderColors3;
                function5 = function8;
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("steps should be >= 0");
                return;
            }
        } else {
            gapComposer.skipToGroupEnd();
            function5 = function2;
            function6 = function4;
            sliderColors2 = sliderColorsColors;
            mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
            function7 = function3RememberComposableLambda;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(sliderState, modifier, z, function5, function6, sliderColors2, mutableInteractionSourceImpl3, function7, composableLambdaImpl, i, i2);
        }
    }
}
