package androidx.compose.animation;

import androidx.activity.SystemBarStyle$Companion$$ExternalSyntheticLambda0;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.DeferredTransition;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda3;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda7;
import androidx.compose.material3.IconButtonKt$$ExternalSyntheticLambda8;
import androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10;
import androidx.compose.material3.SliderKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda25;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$1$1;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.StateListIterator;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.media3.extractor.flv.TagPayloadReader;
import coil3.RealImageLoader;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda15;
import com.metrolist.music.ui.component.BottomSheetKt$$ExternalSyntheticLambda6;
import com.metrolist.music.ui.component.DialogKt$$ExternalSyntheticLambda6;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda34;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CrossfadeKt {
    public static final ProvidableModifierLocal ModifierLocalSharedMutableTransformState = new ProvidableModifierLocal(new ScrollKt$$ExternalSyntheticLambda0((byte) 6));

    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:41:0x007b  */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:46:0x0088  */
    /* JADX WARN: Code duplicated, block: B:48:0x008e  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:59:? A[RETURN, SYNTHETIC] */
    public static final void AnimatedContent(Object obj, Modifier modifier, Function1 function1, Alignment alignment, String str, Function1 function2, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i, int i2) {
        int i3;
        Function1 function3;
        int i4;
        int i5;
        boolean z;
        Modifier modifier2;
        Alignment alignment2;
        Function1 function4;
        Function1 function5;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        NeverEqualPolicy neverEqualPolicy;
        Object objRememberedValue;
        Object objRememberedValue2;
        int i6;
        int i7;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1501828832);
        byte b = 4;
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? gapComposer.changed(obj) : gapComposer.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i3 | 48;
        int i9 = i2 & 4;
        if (i9 == 0) {
            if ((i & 384) == 0) {
                function3 = function1;
                i8 |= gapComposer.changedInstance(function3) ? 256 : 128;
            }
            i4 = i8 | 3072;
            if ((i & 24576) == 0) {
                if (gapComposer.changed(str)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i4 |= i7;
            }
            i5 = i4 | 196608;
            if ((1572864 & i) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i6 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i6 = 524288;
                }
                i5 |= i6;
            }
            if ((599187 & i5) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i5 & 1, z)) {
                neverEqualPolicy = Composer.Companion.Empty;
                if (i9 != 0) {
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new SystemBarStyle$Companion$$ExternalSyntheticLambda0(b);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    function3 = (Function1) objRememberedValue2;
                }
                Function1 function6 = function3;
                BiasAlignment biasAlignment = Alignment.Companion.TopStart;
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 5);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Function1 function7 = (Function1) objRememberedValue;
                TransitionInstance transitionInstanceUpdateTransition = ArcSplineKt.updateTransition(obj, str, gapComposer, (i5 & 14) | ((i5 >> 9) & 112), 0);
                int i10 = i5 >> 3;
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                AnimatedContent(transitionInstanceUpdateTransition, companion, function6, biasAlignment, function7, composableLambdaImpl, gapComposer, (i5 & 8176) | (57344 & i10) | (i10 & 458752));
                modifier2 = companion;
                function5 = function6;
                alignment2 = biasAlignment;
                function4 = function7;
            } else {
                gapComposer.skipToGroupEnd();
                modifier2 = modifier;
                alignment2 = alignment;
                function4 = function2;
                function5 = function3;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(obj, modifier2, function5, alignment2, str, function4, composableLambdaImpl, i, i2);
            }
        }
        i8 = i3 | 432;
        function3 = function1;
        i4 = i8 | 3072;
        if ((i & 24576) == 0) {
            if (gapComposer.changed(str)) {
                i7 = 16384;
            } else {
                i7 = 8192;
            }
            i4 |= i7;
        }
        i5 = i4 | 196608;
        if ((1572864 & i) == 0) {
            if (gapComposer.changedInstance(composableLambdaImpl)) {
                i6 = ByteChannelKt.CHANNEL_MAX_SIZE;
            } else {
                i6 = 524288;
            }
            i5 |= i6;
        }
        if ((599187 & i5) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i5 & 1, z)) {
            neverEqualPolicy = Composer.Companion.Empty;
            if (i9 != 0) {
                objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new SystemBarStyle$Companion$$ExternalSyntheticLambda0(b);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                function3 = (Function1) objRememberedValue2;
            }
            Function1 function8 = function3;
            BiasAlignment biasAlignment2 = Alignment.Companion.TopStart;
            objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 5);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Function1 function9 = (Function1) objRememberedValue;
            TransitionInstance transitionInstanceUpdateTransition2 = ArcSplineKt.updateTransition(obj, str, gapComposer, (i5 & 14) | ((i5 >> 9) & 112), 0);
            int i11 = i5 >> 3;
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            AnimatedContent(transitionInstanceUpdateTransition2, companion2, function8, biasAlignment2, function9, composableLambdaImpl, gapComposer, (i5 & 8176) | (57344 & i11) | (i11 & 458752));
            modifier2 = companion2;
            function5 = function8;
            alignment2 = biasAlignment2;
            function4 = function9;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            alignment2 = alignment;
            function4 = function2;
            function5 = function3;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new DialogKt$$ExternalSyntheticLambda6(obj, modifier2, function5, alignment2, str, function4, composableLambdaImpl, i, i2);
        }
    }

    public static final void AnimatedContentImpl(final Transition transition, Modifier modifier, Function1 function1, Alignment alignment, final Function1 function2, Function1 function3, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        Function1 function4;
        GapComposer gapComposer;
        TagPayloadReader tagPayloadReader;
        boolean z;
        MutableScatterMap mutableScatterMap;
        AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl;
        NeverEqualPolicy neverEqualPolicy;
        boolean z2;
        Object obj;
        Transition.DeferredAnimation deferredAnimation;
        GapComposer gapComposer2;
        boolean z3;
        int i2;
        int i3;
        Function1 function5 = function1;
        GapComposer gapComposer3 = (GapComposer) composer;
        gapComposer3.startRestartGroup(1935038908);
        int i4 = (i & 6) == 0 ? (gapComposer3.changed(transition) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i4 |= gapComposer3.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= gapComposer3.changedInstance(function5) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= gapComposer3.changed(alignment) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= gapComposer3.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i4 |= gapComposer3.changedInstance(function3) ? 131072 : 65536;
        }
        ComposableLambdaImpl composableLambdaImpl2 = composableLambdaImpl;
        if ((1572864 & i) == 0) {
            i4 |= gapComposer3.changedInstance(composableLambdaImpl2) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        }
        if (gapComposer3.shouldExecute(i4 & 1, (599187 & i4) != 599186)) {
            int i5 = i4 & 14;
            boolean z4 = i5 == 4;
            Object objRememberedValue = gapComposer3.rememberedValue();
            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
            if (z4 || objRememberedValue == neverEqualPolicy2) {
                objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, alignment);
                gapComposer3.updateRememberedValue(objRememberedValue);
            }
            AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl2 = (AnimatedContentTransitionScopeImpl) objRememberedValue;
            boolean z5 = i5 == 4;
            Object objRememberedValue2 = gapComposer3.rememberedValue();
            Object obj2 = objRememberedValue2;
            if (z5 || objRememberedValue2 == neverEqualPolicy2) {
                Object[] objArr = {transition.transitionState.getCurrentState()};
                SnapshotStateList snapshotStateList = new SnapshotStateList();
                snapshotStateList.addAll(ArraysKt.toList(objArr));
                gapComposer3.updateRememberedValue(snapshotStateList);
                obj2 = snapshotStateList;
            }
            SnapshotStateList snapshotStateList2 = (SnapshotStateList) obj2;
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = transition.pendingTargetState$delegate;
            TagPayloadReader tagPayloadReader2 = transition.transitionState;
            int i6 = i4;
            ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = transition.targetState$delegate;
            boolean zChanged = gapComposer3.changed(parcelableSnapshotMutableState.getValue()) | (i5 == 4);
            Object objRememberedValue3 = gapComposer3.rememberedValue();
            if (zChanged || objRememberedValue3 == neverEqualPolicy2) {
                long[] jArr = ScatterMapKt.EmptyGroup;
                objRememberedValue3 = new MutableScatterMap();
                gapComposer3.updateRememberedValue(objRememberedValue3);
            }
            MutableScatterMap mutableScatterMap2 = (MutableScatterMap) objRememberedValue3;
            if (!snapshotStateList2.contains(tagPayloadReader2.getCurrentState())) {
                snapshotStateList2.clear();
                snapshotStateList2.add(tagPayloadReader2.getCurrentState());
            }
            if (Intrinsics.areEqual(tagPayloadReader2.getCurrentState(), parcelableSnapshotMutableState2.getValue()) && parcelableSnapshotMutableState.getValue() == null) {
                if (snapshotStateList2.size() != 1 || !Intrinsics.areEqual(snapshotStateList2.get(0), tagPayloadReader2.getCurrentState())) {
                    snapshotStateList2.clear();
                    snapshotStateList2.add(tagPayloadReader2.getCurrentState());
                }
                if (mutableScatterMap2._size != 1 || mutableScatterMap2.containsKey(tagPayloadReader2.getCurrentState())) {
                    mutableScatterMap2.clear();
                }
                animatedContentTransitionScopeImpl2.contentAlignment = alignment;
            }
            Object value = parcelableSnapshotMutableState.getValue();
            if (value == null || value.equals(tagPayloadReader2.getCurrentState())) {
                tagPayloadReader = tagPayloadReader2;
            } else {
                Object objInvoke = function2.invoke(value);
                tagPayloadReader = tagPayloadReader2;
                if (!Intrinsics.areEqual(objInvoke, function2.invoke(parcelableSnapshotMutableState2.getValue()))) {
                    ListIterator listIterator = snapshotStateList2.listIterator();
                    int i7 = 0;
                    while (true) {
                        StateListIterator stateListIterator = (StateListIterator) listIterator;
                        if (!stateListIterator.hasNext()) {
                            i3 = -1;
                            break;
                        }
                        ListIterator listIterator2 = listIterator;
                        if (Intrinsics.areEqual(function2.invoke(stateListIterator.next()), objInvoke)) {
                            i3 = i7;
                            break;
                        } else {
                            i7++;
                            listIterator = listIterator2;
                        }
                    }
                    if (i3 == -1) {
                        snapshotStateList2.add(value);
                    } else if (!Intrinsics.areEqual(snapshotStateList2.get(i3), value)) {
                        snapshotStateList2.set(i3, value);
                    }
                }
            }
            if (Intrinsics.areEqual(tagPayloadReader.getCurrentState(), parcelableSnapshotMutableState2.getValue())) {
                z = true;
            } else {
                ListIterator listIterator3 = snapshotStateList2.listIterator();
                int i8 = 0;
                while (true) {
                    StateListIterator stateListIterator2 = (StateListIterator) listIterator3;
                    if (!stateListIterator2.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    ListIterator listIterator4 = listIterator3;
                    if (Intrinsics.areEqual(function2.invoke(stateListIterator2.next()), function2.invoke(parcelableSnapshotMutableState2.getValue()))) {
                        i2 = i8;
                        break;
                    } else {
                        i8++;
                        listIterator3 = listIterator4;
                    }
                }
                if (i2 == -1) {
                    snapshotStateList2.add(parcelableSnapshotMutableState2.getValue());
                    z = true;
                } else {
                    if (Intrinsics.areEqual(snapshotStateList2.get(i2), parcelableSnapshotMutableState2.getValue())) {
                        z = true;
                        if (i2 != snapshotStateList2.size() - 1) {
                        }
                    } else {
                        z = true;
                    }
                    Intrinsics.areEqual(parcelableSnapshotMutableState2.getValue(), snapshotStateList2.get(i2));
                    snapshotStateList2.remove(i2);
                    snapshotStateList2.add(parcelableSnapshotMutableState2.getValue());
                }
            }
            Object value2 = parcelableSnapshotMutableState.getValue();
            boolean zChanged2 = gapComposer3.changed(value2);
            Object objRememberedValue4 = gapComposer3.rememberedValue();
            if (zChanged2 || objRememberedValue4 == neverEqualPolicy2) {
                objRememberedValue4 = value2 != null ? new PendingAnimatedContentTransitionScope(animatedContentTransitionScopeImpl2, parcelableSnapshotMutableState2.getValue(), value2) : null;
                gapComposer3.updateRememberedValue(objRememberedValue4);
            }
            PendingAnimatedContentTransitionScope pendingAnimatedContentTransitionScope = (PendingAnimatedContentTransitionScope) objRememberedValue4;
            boolean zChanged3 = gapComposer3.changed(pendingAnimatedContentTransitionScope) | ((i6 & 458752) == 131072 ? z : false);
            Object objRememberedValue5 = gapComposer3.rememberedValue();
            if (zChanged3 || objRememberedValue5 == neverEqualPolicy2) {
                objRememberedValue5 = pendingAnimatedContentTransitionScope != null ? !Intrinsics.areEqual(function2.invoke(pendingAnimatedContentTransitionScope.overrideInitialState), function2.invoke(pendingAnimatedContentTransitionScope.overrideTargetState)) ? (MutableContentTransform) function3.invoke(pendingAnimatedContentTransitionScope) : new MutableContentTransform() : null;
                gapComposer3.updateRememberedValue(objRememberedValue5);
            }
            MutableContentTransform mutableContentTransform = (MutableContentTransform) objRememberedValue5;
            if (mutableScatterMap2.contains(parcelableSnapshotMutableState2.getValue()) && mutableScatterMap2.contains(tagPayloadReader.getCurrentState()) && (value2 == null || mutableScatterMap2.contains(value2))) {
                gapComposer3.startReplaceGroup(-296483994);
                gapComposer3.end(false);
                mutableScatterMap = mutableScatterMap2;
                function4 = function5;
                animatedContentTransitionScopeImpl = animatedContentTransitionScopeImpl2;
                neverEqualPolicy = neverEqualPolicy2;
                z2 = z;
                obj = pendingAnimatedContentTransitionScope;
            } else {
                gapComposer3.startReplaceGroup(-301762767);
                mutableScatterMap2.clear();
                int size = snapshotStateList2.size();
                int i9 = 0;
                while (i9 < size) {
                    final Object obj3 = value2;
                    final Object obj4 = snapshotStateList2.get(i9);
                    MutableScatterMap mutableScatterMap3 = mutableScatterMap2;
                    final MutableContentTransform mutableContentTransform2 = mutableContentTransform;
                    final Function1 function6 = function5;
                    NeverEqualPolicy neverEqualPolicy3 = neverEqualPolicy2;
                    final ComposableLambdaImpl composableLambdaImpl3 = composableLambdaImpl2;
                    final AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl3 = animatedContentTransitionScopeImpl2;
                    final PendingAnimatedContentTransitionScope pendingAnimatedContentTransitionScope2 = pendingAnimatedContentTransitionScope;
                    final SnapshotStateList snapshotStateList3 = snapshotStateList2;
                    snapshotStateList2 = snapshotStateList3;
                    mutableScatterMap3.set(obj4, Expect_jvmKt.rememberComposableLambda(427839334, new Function2() { // from class: androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj5, Object obj6) {
                            ContentTransform contentTransform;
                            ExitTransitionImpl exitTransitionImpl;
                            int iIndexOf;
                            Composer composer2 = (Composer) obj5;
                            int iIntValue = ((Integer) obj6).intValue();
                            GapComposer gapComposer4 = (GapComposer) composer2;
                            if (gapComposer4.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                Transition transition2 = transition;
                                ParcelableSnapshotMutableState parcelableSnapshotMutableState3 = transition2.pendingTargetState$delegate;
                                ParcelableSnapshotMutableState parcelableSnapshotMutableState4 = transition2.targetState$delegate;
                                Object value3 = parcelableSnapshotMutableState3.getValue();
                                Object obj7 = obj4;
                                boolean zChanged4 = gapComposer4.changed(Intrinsics.areEqual(obj7, value3));
                                Object objRememberedValue6 = gapComposer4.rememberedValue();
                                PendingAnimatedContentTransitionScope pendingAnimatedContentTransitionScope3 = pendingAnimatedContentTransitionScope2;
                                Function1 function7 = function6;
                                AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl4 = animatedContentTransitionScopeImpl3;
                                NeverEqualPolicy neverEqualPolicy4 = Composer.Companion.Empty;
                                if (zChanged4 || objRememberedValue6 == neverEqualPolicy4) {
                                    if (!Intrinsics.areEqual(obj7, parcelableSnapshotMutableState3.getValue()) || pendingAnimatedContentTransitionScope3 == null) {
                                        contentTransform = (Intrinsics.areEqual(obj7, transition2.getSegment().getInitialState()) || Intrinsics.areEqual(obj7, transition2.getSegment().getTargetState())) ? (ContentTransform) function7.invoke(animatedContentTransitionScopeImpl4) : (ContentTransform) function7.invoke(new PendingAnimatedContentTransitionScope(animatedContentTransitionScopeImpl4, transition2.getSegment().getInitialState(), obj7));
                                    } else {
                                        contentTransform = (ContentTransform) function7.invoke(pendingAnimatedContentTransitionScope3);
                                    }
                                    objRememberedValue6 = contentTransform;
                                    gapComposer4.updateRememberedValue(objRememberedValue6);
                                }
                                ContentTransform contentTransform2 = (ContentTransform) objRememberedValue6;
                                boolean zChanged5 = gapComposer4.changed(Intrinsics.areEqual(transition2.getSegment().getTargetState(), obj7)) | gapComposer4.changed(Intrinsics.areEqual(obj7, parcelableSnapshotMutableState3.getValue()));
                                Object objRememberedValue7 = gapComposer4.rememberedValue();
                                if (zChanged5 || objRememberedValue7 == neverEqualPolicy4) {
                                    if (Intrinsics.areEqual(transition2.getSegment().getTargetState(), obj7) || (Intrinsics.areEqual(obj7, parcelableSnapshotMutableState3.getValue()) && pendingAnimatedContentTransitionScope3 != null)) {
                                        exitTransitionImpl = ExitTransitionImpl.None;
                                    } else {
                                        exitTransitionImpl = (Intrinsics.areEqual(obj7, transition2.getSegment().getInitialState()) || Intrinsics.areEqual(obj7, transition2.getSegment().getTargetState())) ? ((ContentTransform) function7.invoke(animatedContentTransitionScopeImpl4)).initialContentExit : ((ContentTransform) function7.invoke(new PendingAnimatedContentTransitionScope(animatedContentTransitionScopeImpl4, obj7, transition2.getSegment().getInitialState()))).initialContentExit;
                                    }
                                    objRememberedValue7 = exitTransitionImpl;
                                    gapComposer4.updateRememberedValue(objRememberedValue7);
                                }
                                ExitTransitionImpl exitTransitionImpl2 = (ExitTransitionImpl) objRememberedValue7;
                                Object objRememberedValue8 = gapComposer4.rememberedValue();
                                if (objRememberedValue8 == neverEqualPolicy4) {
                                    objRememberedValue8 = new AnimatedContentTransitionScopeImpl.ChildData(Intrinsics.areEqual(obj7, parcelableSnapshotMutableState4.getValue()));
                                    gapComposer4.updateRememberedValue(objRememberedValue8);
                                }
                                AnimatedContentTransitionScopeImpl.ChildData childData = (AnimatedContentTransitionScopeImpl.ChildData) objRememberedValue8;
                                EnterTransitionImpl enterTransitionImpl = contentTransform2.targetContentEnter;
                                ZIndexModifierElement zIndexModifierElement = new ZIndexModifierElement(contentTransform2.targetContentZIndex$delegate.getFloatValue(), obj7);
                                childData.isTarget$delegate.setValue(Boolean.valueOf(Intrinsics.areEqual(obj7, parcelableSnapshotMutableState4.getValue())));
                                Function1 function8 = function2;
                                Object objInvoke2 = function8.invoke(obj7);
                                Object obj8 = obj3;
                                childData.isPendingTarget$delegate.setValue(Boolean.valueOf((obj8 == null || !Intrinsics.areEqual(objInvoke2, function8.invoke(obj8)) || Intrinsics.areEqual(objInvoke2, function8.invoke(parcelableSnapshotMutableState4.getValue())) || Intrinsics.areEqual(objInvoke2, function8.invoke(transition2.transitionState.getCurrentState()))) ? false : true));
                                Modifier modifierThen = zIndexModifierElement.then(childData);
                                MutableContentTransform mutableContentTransform3 = mutableContentTransform2;
                                MutableTransform mutableTransform = null;
                                if (mutableContentTransform3 != null) {
                                    if (Intrinsics.areEqual(obj7, parcelableSnapshotMutableState3.getValue())) {
                                        mutableTransform = mutableContentTransform3.targetTransform;
                                    } else if (Intrinsics.areEqual(obj7, parcelableSnapshotMutableState4.getValue())) {
                                        mutableTransform = mutableContentTransform3.initialTransform;
                                    }
                                }
                                MutableTransform mutableTransform2 = mutableTransform;
                                boolean z6 = transition2 instanceof DeferredTransition;
                                SnapshotStateList snapshotStateList4 = snapshotStateList3;
                                boolean z7 = z6 && (iIndexOf = snapshotStateList4.indexOf(obj7)) >= 0 && iIndexOf >= snapshotStateList4.size() + (-3);
                                boolean zChangedInstance = gapComposer4.changedInstance(obj7);
                                Object objRememberedValue9 = gapComposer4.rememberedValue();
                                if (zChangedInstance || objRememberedValue9 == neverEqualPolicy4) {
                                    objRememberedValue9 = new CrossfadeKt$$ExternalSyntheticLambda2((byte) 1, obj7);
                                    gapComposer4.updateRememberedValue(objRememberedValue9);
                                }
                                Function1 function9 = (Function1) objRememberedValue9;
                                boolean zChanged6 = gapComposer4.changed(exitTransitionImpl2);
                                Object objRememberedValue10 = gapComposer4.rememberedValue();
                                if (zChanged6 || objRememberedValue10 == neverEqualPolicy4) {
                                    objRememberedValue10 = new ComposerKt$$ExternalSyntheticLambda0((byte) 1, exitTransitionImpl2);
                                    gapComposer4.updateRememberedValue(objRememberedValue10);
                                }
                                CrossfadeKt.AnimatedEnterExitImpl(transition2, function9, modifierThen, enterTransitionImpl, exitTransitionImpl2, (Function2) objRememberedValue10, mutableTransform2, z7, Expect_jvmKt.rememberComposableLambda(-519005224, new SongMenuKt$$ExternalSyntheticLambda34(obj7, snapshotStateList4, animatedContentTransitionScopeImpl4, composableLambdaImpl3, (byte) 1), gapComposer4), gapComposer4, 805306368, 64);
                            } else {
                                gapComposer4.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer3));
                    i9++;
                    mutableScatterMap2 = mutableScatterMap3;
                    mutableContentTransform = mutableContentTransform2;
                    function5 = function6;
                    pendingAnimatedContentTransitionScope = pendingAnimatedContentTransitionScope2;
                    animatedContentTransitionScopeImpl2 = animatedContentTransitionScopeImpl3;
                    neverEqualPolicy2 = neverEqualPolicy3;
                    size = size;
                    value2 = obj3;
                    composableLambdaImpl2 = composableLambdaImpl;
                    z = z;
                }
                mutableScatterMap = mutableScatterMap2;
                function4 = function5;
                animatedContentTransitionScopeImpl = animatedContentTransitionScopeImpl2;
                neverEqualPolicy = neverEqualPolicy2;
                z2 = z;
                obj = pendingAnimatedContentTransitionScope;
                gapComposer3.end(false);
            }
            boolean zChanged4 = gapComposer3.changed(transition.getSegment()) | gapComposer3.changed(obj) | gapComposer3.changed(animatedContentTransitionScopeImpl);
            Object objRememberedValue6 = gapComposer3.rememberedValue();
            if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
                if (obj == null) {
                    obj = animatedContentTransitionScopeImpl;
                }
                objRememberedValue6 = (ContentTransform) function4.invoke(obj);
                gapComposer3.updateRememberedValue(objRememberedValue6);
            }
            ContentTransform contentTransform = (ContentTransform) objRememberedValue6;
            Transition transition2 = animatedContentTransitionScopeImpl.transition;
            boolean zChanged5 = gapComposer3.changed(animatedContentTransitionScopeImpl);
            Object objRememberedValue7 = gapComposer3.rememberedValue();
            if (zChanged5 || objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer3.updateRememberedValue(objRememberedValue7);
            }
            MutableState mutableState = (MutableState) objRememberedValue7;
            MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(contentTransform.sizeTransform, gapComposer3);
            if (Intrinsics.areEqual(transition2.transitionState.getCurrentState(), transition2.targetState$delegate.getValue())) {
                mutableState.setValue(Boolean.FALSE);
            } else if (mutableStateRememberUpdatedState.getValue() != null) {
                mutableState.setValue(Boolean.TRUE);
            }
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            Modifier modifier2 = Modifier.Companion.$$INSTANCE;
            if (zBooleanValue) {
                gapComposer3.startReplaceGroup(1353077497);
                GapComposer gapComposer4 = gapComposer3;
                Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation = ArcSplineKt.createDeferredAnimation(animatedContentTransitionScopeImpl.transition, ArcSplineKt.IntSizeToVector, null, gapComposer4, 0, 2);
                boolean zChanged6 = gapComposer4.changed(deferredAnimationCreateDeferredAnimation);
                Object objRememberedValue8 = gapComposer4.rememberedValue();
                if (zChanged6 || objRememberedValue8 == neverEqualPolicy) {
                    objRememberedValue8 = ClipKt.clipToBounds(modifier2);
                    gapComposer4.updateRememberedValue(objRememberedValue8);
                }
                modifier2 = (Modifier) objRememberedValue8;
                gapComposer4.end(false);
                deferredAnimation = deferredAnimationCreateDeferredAnimation;
                gapComposer2 = gapComposer4;
            } else {
                GapComposer gapComposer5 = gapComposer3;
                gapComposer5.startReplaceGroup(1353343539);
                gapComposer5.end(false);
                deferredAnimation = null;
                gapComposer2 = gapComposer5;
            }
            Modifier modifierThen = modifier.then(modifier2.then(new AnimatedContentTransitionScopeImpl.SizeModifierElement(deferredAnimation, mutableStateRememberUpdatedState, animatedContentTransitionScopeImpl)));
            Object objRememberedValue9 = gapComposer2.rememberedValue();
            if (objRememberedValue9 == neverEqualPolicy) {
                objRememberedValue9 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                gapComposer2.updateRememberedValue(objRememberedValue9);
            }
            AnimatedContentMeasurePolicy animatedContentMeasurePolicy = (AnimatedContentMeasurePolicy) objRememberedValue9;
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierThen);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(LayoutNode.Constructor);
            } else {
                gapComposer2.useNode();
            }
            Stack.m390setimpl(gapComposer2, animatedContentMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m386initimpl(gapComposer2, Integer.valueOf(iHashCode));
            Stack.m389reconcileimpl(gapComposer2);
            Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            gapComposer2.startReplaceGroup(758586195);
            int size2 = snapshotStateList2.size();
            for (int i10 = 0; i10 < size2; i10++) {
                Object obj5 = snapshotStateList2.get(i10);
                gapComposer2.startMovableGroup(1420119555, function2.invoke(obj5));
                Function2 function7 = (Function2) mutableScatterMap.get(obj5);
                if (function7 == null) {
                    gapComposer2.startReplaceGroup(1074069702);
                    z3 = false;
                } else {
                    z3 = false;
                    gapComposer2.startReplaceGroup(1420120731);
                    function7.invoke(gapComposer2, 0);
                }
                gapComposer2.end(z3);
                gapComposer2.end(z3);
            }
            gapComposer2.end(false);
            gapComposer2.end(z2);
            gapComposer = gapComposer2;
        } else {
            function4 = function5;
            GapComposer gapComposer6 = gapComposer3;
            gapComposer6.skipToGroupEnd();
            gapComposer = gapComposer6;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda15(transition, modifier, function4, alignment, function2, function3, composableLambdaImpl, i, (byte) 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0158 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:105:0x015a  */
    /* JADX WARN: Code duplicated, block: B:108:0x0167  */
    /* JADX WARN: Code duplicated, block: B:111:0x0190  */
    /* JADX WARN: Code duplicated, block: B:115:0x019a  */
    /* JADX WARN: Code duplicated, block: B:117:0x01a0 A[PHI: r19
      0x01a0: PHI (r19v2 int) = (r19v0 int), (r19v4 int) binds: [B:116:0x019e, B:114:0x0197] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:118:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:121:0x01a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:122:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:125:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:127:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:133:0x01e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:134:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:137:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:138:0x0202  */
    /* JADX WARN: Code duplicated, block: B:141:0x0212  */
    /* JADX WARN: Code duplicated, block: B:143:0x0220  */
    /* JADX WARN: Code duplicated, block: B:144:0x022c  */
    /* JADX WARN: Code duplicated, block: B:147:0x024f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:151:0x0261  */
    /* JADX WARN: Code duplicated, block: B:154:0x0267  */
    /* JADX WARN: Code duplicated, block: B:157:0x0285  */
    /* JADX WARN: Code duplicated, block: B:160:0x0292 A[LOOP:0: B:159:0x0290->B:160:0x0292, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:163:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:165:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:166:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:169:0x02be A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:170:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:173:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:176:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:179:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:182:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:183:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:186:0x030d  */
    /* JADX WARN: Code duplicated, block: B:188:0x0311 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:189:0x0313  */
    /* JADX WARN: Code duplicated, block: B:191:0x031a  */
    /* JADX WARN: Code duplicated, block: B:193:0x0325  */
    /* JADX WARN: Code duplicated, block: B:194:0x0327  */
    /* JADX WARN: Code duplicated, block: B:197:0x032d  */
    /* JADX WARN: Code duplicated, block: B:199:0x0335  */
    /* JADX WARN: Code duplicated, block: B:202:0x0348  */
    /* JADX WARN: Code duplicated, block: B:204:0x034b  */
    /* JADX WARN: Code duplicated, block: B:205:0x0350  */
    /* JADX WARN: Code duplicated, block: B:209:0x0367  */
    /* JADX WARN: Code duplicated, block: B:211:0x036a  */
    /* JADX WARN: Code duplicated, block: B:212:0x036f  */
    /* JADX WARN: Code duplicated, block: B:216:0x037f  */
    /* JADX WARN: Code duplicated, block: B:218:0x0382  */
    /* JADX WARN: Code duplicated, block: B:222:0x03a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:223:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:226:0x03bf A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:227:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:230:0x03de A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:231:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:234:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:240:0x040d  */
    /* JADX WARN: Code duplicated, block: B:242:0x0413  */
    /* JADX WARN: Code duplicated, block: B:245:0x0436 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:246:0x0438  */
    /* JADX WARN: Code duplicated, block: B:249:0x044f  */
    /* JADX WARN: Code duplicated, block: B:254:0x045e  */
    /* JADX WARN: Code duplicated, block: B:256:0x0467  */
    /* JADX WARN: Code duplicated, block: B:258:0x046d  */
    /* JADX WARN: Code duplicated, block: B:260:0x0474  */
    /* JADX WARN: Code duplicated, block: B:261:0x047d  */
    /* JADX WARN: Code duplicated, block: B:263:0x0491  */
    /* JADX WARN: Code duplicated, block: B:264:0x049b  */
    /* JADX WARN: Code duplicated, block: B:267:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:268:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:271:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:272:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:275:0x04df  */
    /* JADX WARN: Code duplicated, block: B:276:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:279:0x04fe  */
    /* JADX WARN: Code duplicated, block: B:280:0x0514  */
    /* JADX WARN: Code duplicated, block: B:285:0x055e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:286:0x0560  */
    /* JADX WARN: Code duplicated, block: B:289:0x0572  */
    /* JADX WARN: Code duplicated, block: B:292:0x0585 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:295:0x058a  */
    /* JADX WARN: Code duplicated, block: B:298:0x05a1  */
    /* JADX WARN: Code duplicated, block: B:304:0x05c4  */
    /* JADX WARN: Code duplicated, block: B:306:0x05cd  */
    /* JADX WARN: Code duplicated, block: B:307:0x05cf  */
    /* JADX WARN: Code duplicated, block: B:310:0x05d6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:311:0x05d8  */
    /* JADX WARN: Code duplicated, block: B:314:0x05ea  */
    /* JADX WARN: Code duplicated, block: B:317:0x0619  */
    /* JADX WARN: Code duplicated, block: B:324:0x0633  */
    /* JADX WARN: Code duplicated, block: B:328:0x063e  */
    /* JADX WARN: Code duplicated, block: B:334:0x0653  */
    /* JADX WARN: Code duplicated, block: B:337:0x0658  */
    /* JADX WARN: Code duplicated, block: B:341:0x0661  */
    /* JADX WARN: Code duplicated, block: B:343:0x0664  */
    /* JADX WARN: Code duplicated, block: B:345:0x0670  */
    /* JADX WARN: Code duplicated, block: B:347:0x0690  */
    /* JADX WARN: Code duplicated, block: B:349:0x06a5  */
    /* JADX WARN: Code duplicated, block: B:351:0x06b3  */
    /* JADX WARN: Code duplicated, block: B:353:0x06c9  */
    /* JADX WARN: Code duplicated, block: B:355:0x06d7  */
    /* JADX WARN: Code duplicated, block: B:357:0x06e3  */
    /* JADX WARN: Code duplicated, block: B:359:0x06fc  */
    /* JADX WARN: Code duplicated, block: B:361:0x070a  */
    /* JADX WARN: Code duplicated, block: B:364:0x070f  */
    /* JADX WARN: Code duplicated, block: B:373:0x0721  */
    /* JADX WARN: Code duplicated, block: B:375:0x0729 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:376:0x072b  */
    /* JADX WARN: Code duplicated, block: B:377:0x0732  */
    /* JADX WARN: Code duplicated, block: B:379:0x0738  */
    /* JADX WARN: Code duplicated, block: B:380:0x073f  */
    /* JADX WARN: Code duplicated, block: B:382:0x0742  */
    /* JADX WARN: Code duplicated, block: B:384:0x0748  */
    /* JADX WARN: Code duplicated, block: B:385:0x074f  */
    /* JADX WARN: Code duplicated, block: B:387:0x0752  */
    /* JADX WARN: Code duplicated, block: B:390:0x0758  */
    /* JADX WARN: Code duplicated, block: B:392:0x0772  */
    /* JADX WARN: Code duplicated, block: B:394:0x0798  */
    /* JADX WARN: Code duplicated, block: B:396:0x07aa  */
    /* JADX WARN: Code duplicated, block: B:397:0x07ad  */
    /* JADX WARN: Code duplicated, block: B:399:0x07b3  */
    /* JADX WARN: Code duplicated, block: B:400:0x07b6  */
    /* JADX WARN: Code duplicated, block: B:402:0x07ba  */
    /* JADX WARN: Code duplicated, block: B:403:0x07bd  */
    /* JADX WARN: Code duplicated, block: B:405:0x07c0  */
    /* JADX WARN: Code duplicated, block: B:406:0x07c5  */
    /* JADX WARN: Code duplicated, block: B:409:0x07cc  */
    /* JADX WARN: Code duplicated, block: B:414:0x07dc  */
    /* JADX WARN: Code duplicated, block: B:417:0x07e1  */
    /* JADX WARN: Code duplicated, block: B:422:0x07f1  */
    /* JADX WARN: Code duplicated, block: B:424:0x07f4  */
    /* JADX WARN: Code duplicated, block: B:426:0x0800  */
    /* JADX WARN: Code duplicated, block: B:428:0x0816  */
    /* JADX WARN: Code duplicated, block: B:430:0x0824  */
    /* JADX WARN: Code duplicated, block: B:432:0x0830  */
    /* JADX WARN: Code duplicated, block: B:434:0x084a  */
    /* JADX WARN: Code duplicated, block: B:436:0x085c  */
    /* JADX WARN: Code duplicated, block: B:437:0x0878  */
    /* JADX WARN: Code duplicated, block: B:440:0x08ad A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:443:0x08b5  */
    /* JADX WARN: Code duplicated, block: B:446:0x08d3  */
    /* JADX WARN: Code duplicated, block: B:447:0x08d6  */
    /* JADX WARN: Code duplicated, block: B:450:0x08e6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:451:0x08e8  */
    /* JADX WARN: Code duplicated, block: B:454:0x0918  */
    /* JADX WARN: Code duplicated, block: B:455:0x091b  */
    /* JADX WARN: Code duplicated, block: B:458:0x093a  */
    /* JADX WARN: Code duplicated, block: B:461:0x095e  */
    /* JADX WARN: Code duplicated, block: B:462:0x0964  */
    /* JADX WARN: Code duplicated, block: B:466:0x099b  */
    /* JADX WARN: Code duplicated, block: B:469:0x09a6  */
    /* JADX WARN: Code duplicated, block: B:472:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:94:0x0130  */
    /* JADX WARN: Code duplicated, block: B:96:0x0143  */
    /* JADX WARN: Code duplicated, block: B:98:0x0149  */
    /* JADX WARN: Instruction removed from duplicated block: B:122:0x01ab, please report this as an issue */
    public static final void AnimatedEnterExitImpl(Transition transition, Function1 function1, Modifier modifier, EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, Function2 function2, MutableTransform mutableTransform, boolean z, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i, int i2) {
        boolean z2;
        int i3;
        boolean z3;
        Modifier modifier2;
        boolean z4;
        ComposableLambdaImpl composableLambdaImpl2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        boolean z5;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState;
        TagPayloadReader tagPayloadReader;
        int i4;
        boolean z6;
        Object objRememberedValue;
        NeverEqualPolicy neverEqualPolicy;
        EnterExitState enterExitStateTargetEnterExit;
        EnterExitState enterExitStateTargetEnterExit2;
        int i5;
        int i6;
        int i7;
        boolean z7;
        Object objRememberedValue2;
        TransitionInstance transitionInstance;
        boolean zChanged;
        Object objRememberedValue3;
        boolean z8;
        Object objRememberedValue4;
        SharedMutableTransformState sharedMutableTransformState;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState2;
        boolean z9;
        boolean z10;
        MutationPhase mutationPhase$animation;
        MutationPhase mutationPhase;
        MutationPhase mutationPhase2;
        MutationPhase mutationPhase3;
        VelocityTracker velocityTracker;
        float fFloatValue;
        float fFloatValue2;
        float fM819getXimpl;
        Float fValueOf;
        float fFloatValue3;
        float fM820getYimpl;
        Float fValueOf2;
        float fM819getXimpl2;
        Float fValueOf3;
        boolean zChanged2;
        Object objRememberedValue5;
        boolean zChangedInstance;
        Object objRememberedValue6;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState3;
        TagPayloadReader tagPayloadReader2;
        boolean zChanged3;
        Object objRememberedValue7;
        MutableState mutableState;
        Object currentState;
        Object value;
        EnterExitState enterExitState;
        EnterExitState enterExitState2;
        EnterTransitionImpl enterTransitionImpl2;
        boolean zChanged4;
        Object objRememberedValue8;
        MutableState mutableState2;
        FadeConfig fadeConfig;
        FadeConfig fadeConfig2;
        ScaleConfig scaleConfig;
        ScaleConfig scaleConfig2;
        SlideConfig slideConfig;
        SlideConfig slideConfig2;
        ChangeSizeConfig changeSizeConfig;
        ChangeSizeConfig changeSizeConfig2;
        VeilConfig veilConfig;
        VeilConfig veilConfig2;
        ExitTransitionImpl exitTransitionImpl2;
        ExitTransitionImpl exitTransitionImpl3;
        MutableState mutableStateRememberUpdatedState;
        Object objInvoke;
        boolean zChanged5;
        Object objRememberedValue9;
        Function2 function3;
        Object objRememberedValue10;
        MutableState mutableState3;
        boolean zChangedInstance2;
        Object objRememberedValue11;
        boolean z11;
        Object objRememberedValue12;
        AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl;
        TwoWayConverterImpl twoWayConverterImpl;
        Object objRememberedValue13;
        Function0 function0;
        EnterExitTransitionConfig enterExitTransitionConfig;
        ChangeSizeConfig changeSizeConfig3;
        VeilConfig veilConfig3;
        EnterExitTransitionConfig enterExitTransitionConfig2;
        TransitionInstance transitionInstance2;
        ChangeSizeConfig changeSizeConfig4;
        boolean z12;
        EnterExitTransitionConfig enterExitTransitionConfig3;
        SharedMutableTransformState sharedMutableTransformState2;
        boolean z13;
        boolean z14;
        TwoWayConverterImpl twoWayConverterImpl2;
        NeverEqualPolicy neverEqualPolicy2;
        TransitionInstance transitionInstance3;
        Transition.DeferredAnimation deferredAnimation;
        Transition.DeferredAnimation deferredAnimation2;
        Transition.DeferredAnimation deferredAnimation3;
        ChangeSizeConfig changeSizeConfig5;
        boolean z15;
        VeilConfig veilConfig4;
        ColorSpace colorSpaceM483getColorSpaceimpl;
        VeilConfig veilConfig5;
        Modifier.Companion companion;
        ExitTransitionImpl exitTransitionImpl4;
        Modifier.Companion companion2;
        Modifier modifier3;
        VeilConfig veilConfig6;
        Boolean bool;
        boolean zBooleanValue;
        TwoWayConverterImpl twoWayConverterImpl3;
        boolean z16;
        boolean z17;
        Transition.DeferredAnimation deferredAnimation4;
        boolean z18;
        Transition.DeferredAnimation deferredAnimation5;
        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation;
        boolean zChangedInstance3;
        Object objRememberedValue14;
        ExitTransitionImpl exitTransitionImpl5;
        SharedMutableTransformState sharedMutableTransformState3;
        Modifier modifier4;
        boolean zChanged6;
        Object objRememberedValue15;
        Modifier modifier5;
        Object objRememberedValue16;
        boolean z19;
        Object objRememberedValue17;
        Object objRememberedValue18;
        Object objRememberedValue19;
        Object objRememberedValue20;
        Object objRememberedValue21;
        Object objRememberedValue22;
        ComposableLambdaImpl composableLambdaImpl3;
        Object value2;
        EnterExitState enterExitStateTargetEnterExit3;
        TagPayloadReader tagPayloadReader3;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState4;
        Object value3;
        boolean z20;
        SnapshotStateList snapshotStateList;
        int size;
        int i8;
        ComposableLambdaImpl composableLambdaImpl4;
        int i9;
        ComposableLambdaImpl composableLambdaImpl5 = composableLambdaImpl;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(978633943);
        int i10 = (i & 6) == 0 ? (gapComposer.changed(transition) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i10 |= gapComposer.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i10 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i10 |= gapComposer.changed(enterTransitionImpl) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i10 |= gapComposer.changed(exitTransitionImpl) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i10 |= gapComposer.changedInstance(function2) ? 131072 : 65536;
        }
        int i11 = i10 | 1572864;
        if ((12582912 & i) == 0) {
            i11 |= gapComposer.changedInstance(mutableTransform) ? 8388608 : 4194304;
        }
        int i12 = i2 & 256;
        if (i12 == 0) {
            if ((100663296 & i) == 0) {
                z2 = z;
                i11 |= gapComposer.changed(z2) ? 67108864 : 33554432;
            }
            if ((805306368 & i) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl5)) {
                    i9 = 536870912;
                } else {
                    i9 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                }
                i11 |= i9;
            }
            i3 = i11;
            if ((306783379 & i11) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer.shouldExecute(i3 & 1, z3)) {
                if (i12 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                ParcelableSnapshotMutableState parcelableSnapshotMutableState5 = transition.pendingTargetState$delegate;
                parcelableSnapshotMutableState = transition.targetState$delegate;
                tagPayloadReader = transition.transitionState;
                Object value4 = parcelableSnapshotMutableState5.getValue();
                if (!z5 || ((Boolean) function1.invoke(parcelableSnapshotMutableState.getValue())).booleanValue() || ((Boolean) function1.invoke(tagPayloadReader.getCurrentState())).booleanValue() || ((value4 != null && ((Boolean) function1.invoke(value4)).booleanValue()) || transition.isSeeking() || transition.getHasInitialValueAnimations())) {
                    gapComposer.startReplaceGroup(246708267);
                    i4 = i3 & 14;
                    int i13 = i4 | 48;
                    int i14 = i13 & 14;
                    z6 = ((i14 ^ 6) <= 4 && gapComposer.changed(transition)) || (i13 & 6) == 4;
                    objRememberedValue = gapComposer.rememberedValue();
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (z6 || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = tagPayloadReader.getCurrentState();
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    if (transition.isSeeking()) {
                        objRememberedValue = tagPayloadReader.getCurrentState();
                    }
                    gapComposer.startReplaceGroup(-1260162954);
                    enterExitStateTargetEnterExit = targetEnterExit(transition, function1, objRememberedValue, gapComposer);
                    gapComposer.end(false);
                    Object value5 = parcelableSnapshotMutableState.getValue();
                    gapComposer.startReplaceGroup(-1260162954);
                    enterExitStateTargetEnterExit2 = targetEnterExit(transition, function1, value5, gapComposer);
                    gapComposer.end(false);
                    i5 = i14 | 3072;
                    i6 = (i5 & 14) ^ 6;
                    if (i6 > 4 || !gapComposer.changed(transition)) {
                        i7 = i5;
                        if ((i7 & 6) != 4) {
                            z7 = false;
                        }
                        objRememberedValue2 = gapComposer.rememberedValue();
                        if (z7 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new TransitionInstance(new MutableTransitionState(enterExitStateTargetEnterExit), transition, transition.label + " > EnterExitTransition");
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        transitionInstance = (TransitionInstance) objRememberedValue2;
                        zChanged = ((i6 <= 4 && gapComposer.changed(transition)) || (i7 & 6) == 4) | gapComposer.changed(transitionInstance);
                        objRememberedValue3 = gapComposer.rememberedValue();
                        if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new BackHandlerKt$$ExternalSyntheticLambda2(transition, transitionInstance, (byte) 5);
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        }
                        Stack.DisposableEffect(transitionInstance, (Function1) objRememberedValue3, gapComposer);
                        if (transition.isSeeking()) {
                            transitionInstance.seek(enterExitStateTargetEnterExit, enterExitStateTargetEnterExit2);
                        } else {
                            transitionInstance.updateTarget$animation_core(enterExitStateTargetEnterExit2);
                            transitionInstance.isSeeking$delegate.setValue(Boolean.FALSE);
                        }
                        if (transition.isSeeking()) {
                            gapComposer.startReplaceGroup(782538635);
                            gapComposer.end(false);
                        } else {
                            gapComposer.startReplaceGroup(782386797);
                            value2 = transition.pendingTargetState$delegate.getValue();
                            if (value2 == null) {
                                gapComposer.startReplaceGroup(782437481);
                                gapComposer.end(false);
                                enterExitStateTargetEnterExit3 = null;
                            } else {
                                gapComposer.startReplaceGroup(782437482);
                                gapComposer.startReplaceGroup(-1260162954);
                                enterExitStateTargetEnterExit3 = targetEnterExit(transition, function1, value2, gapComposer);
                                gapComposer.end(false);
                                gapComposer.end(false);
                            }
                            tagPayloadReader3 = transitionInstance.transitionState;
                            parcelableSnapshotMutableState4 = transitionInstance.targetState$delegate;
                            ParcelableSnapshotMutableState parcelableSnapshotMutableState6 = transitionInstance.pendingTargetState$delegate;
                            value3 = parcelableSnapshotMutableState6.getValue();
                            if (value3 == null && enterExitStateTargetEnterExit3 == null && Intrinsics.areEqual(parcelableSnapshotMutableState4.getValue(), tagPayloadReader3.getCurrentState())) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            parcelableSnapshotMutableState6.setValue(enterExitStateTargetEnterExit3);
                            if (z20) {
                                transitionInstance.segment$delegate.setValue(new Transition.SegmentImpl(value3, parcelableSnapshotMutableState4.getValue()));
                                tagPayloadReader3.setCurrentState$animation_core(value3);
                                if (transitionInstance.startTimeNanos$delegate.getLongValue() == Long.MIN_VALUE) {
                                    transitionInstance.setUpdateChildrenNeeded(true);
                                }
                                snapshotStateList = transitionInstance._animations;
                                size = snapshotStateList.size();
                                for (i8 = 0; i8 < size; i8++) {
                                    ((Transition.TransitionAnimationState) snapshotStateList.get(i8)).resetSnapValue$delegate.setFloatValue(-2.0f);
                                }
                            }
                            gapComposer.end(false);
                        }
                        if (i4 == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue4 = gapComposer.rememberedValue();
                        if (z8 || objRememberedValue4 == neverEqualPolicy) {
                            objRememberedValue4 = new SharedMutableTransformState();
                            gapComposer.updateRememberedValue(objRememberedValue4);
                        }
                        sharedMutableTransformState = (SharedMutableTransformState) objRememberedValue4;
                        if (mutableTransform != null) {
                            sharedMutableTransformState.getClass();
                        }
                        sharedMutableTransformState.mutableData = mutableTransform;
                        SystemBarStyle$Companion$$ExternalSyntheticLambda0 systemBarStyle$Companion$$ExternalSyntheticLambda0 = EnterExitTransitionKt.NeutralSlideOffset;
                        parcelableSnapshotMutableState2 = sharedMutableTransformState.mutationPhase$delegate;
                        gapComposer.startReplaceGroup(-31257052);
                        gapComposer.end(false);
                        if (transitionInstance.pendingTargetState$delegate.getValue() != null || sharedMutableTransformState.mutableData == null) {
                            z9 = false;
                        } else {
                            z9 = true;
                        }
                        if (transitionInstance.transitionState.getCurrentState() == transitionInstance.targetState$delegate.getValue()) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        mutationPhase$animation = sharedMutableTransformState.getMutationPhase$animation();
                        mutationPhase = MutationPhase.MutatingPendingCatchUp;
                        mutationPhase2 = MutationPhase.Mutating;
                        mutationPhase3 = MutationPhase.Handoff;
                        if (z9) {
                            if (mutationPhase$animation != MutationPhase.Idle || mutationPhase$animation == mutationPhase3) {
                                sharedMutableTransformState.transformScope.reset();
                                if (z10) {
                                    mutationPhase = mutationPhase2;
                                }
                                parcelableSnapshotMutableState2.setValue(mutationPhase);
                                sharedMutableTransformState.scaleHandoffVelocity = null;
                                sharedMutableTransformState.slideHandoffVelocity = null;
                            }
                        } else if (mutationPhase$animation != mutationPhase || mutationPhase$animation == MutationPhase.MutatingCatchingUp || mutationPhase$animation == mutationPhase2) {
                            parcelableSnapshotMutableState2.setValue(mutationPhase3);
                            velocityTracker = sharedMutableTransformState.scaleVelocityTracker;
                            fFloatValue = CropImageView.DEFAULT_ASPECT_RATIO;
                            if (velocityTracker != null) {
                                fM819getXimpl2 = Velocity.m819getXimpl(velocityTracker.m595calculateVelocity9UxMQ8M());
                                fValueOf3 = Float.valueOf(fM819getXimpl2);
                                if (Float.isNaN(fM819getXimpl2)) {
                                    fValueOf3 = null;
                                }
                                if (fValueOf3 != null) {
                                    fFloatValue2 = fValueOf3.floatValue();
                                } else {
                                    fFloatValue2 = 0.0f;
                                }
                            } else {
                                fFloatValue2 = 0.0f;
                            }
                            sharedMutableTransformState.scaleHandoffVelocity = new AnimationVector1D(fFloatValue2);
                            fM819getXimpl = Velocity.m819getXimpl(0L);
                            fValueOf = Float.valueOf(fM819getXimpl);
                            if (Float.isNaN(fM819getXimpl)) {
                                fValueOf = null;
                            }
                            if (fValueOf != null) {
                                fFloatValue3 = fValueOf.floatValue();
                            } else {
                                fFloatValue3 = 0.0f;
                            }
                            fM820getYimpl = Velocity.m820getYimpl(0L);
                            fValueOf2 = Float.valueOf(fM820getYimpl);
                            if (Float.isNaN(fM820getYimpl)) {
                                fValueOf2 = null;
                            }
                            if (fValueOf2 != null) {
                                fFloatValue = fValueOf2.floatValue();
                            }
                            sharedMutableTransformState.slideHandoffVelocity = new AnimationVector2D(fFloatValue3, fFloatValue);
                        }
                        Boolean boolValueOf = Boolean.valueOf(z9);
                        zChanged2 = gapComposer.changed(z9) | gapComposer.changed(z10) | gapComposer.changedInstance(sharedMutableTransformState);
                        objRememberedValue5 = gapComposer.rememberedValue();
                        if (zChanged2 || objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = new EnterExitTransitionKt$trackActiveMutableState$1$1(z9, z10, sharedMutableTransformState, null);
                            gapComposer.updateRememberedValue(objRememberedValue5);
                        }
                        Stack.LaunchedEffect(gapComposer, boolValueOf, (Function2) objRememberedValue5);
                        zChangedInstance = gapComposer.changedInstance(sharedMutableTransformState);
                        objRememberedValue6 = gapComposer.rememberedValue();
                        if (zChangedInstance || objRememberedValue6 == neverEqualPolicy) {
                            objRememberedValue6 = new SliderState$$ExternalSyntheticLambda0((byte) 3, sharedMutableTransformState);
                            gapComposer.updateRememberedValue(objRememberedValue6);
                        }
                        EnterExitTransitionKt.DeferredTransitionCleanupEffect(transitionInstance, (Function0) objRememberedValue6, gapComposer, 0);
                        parcelableSnapshotMutableState3 = transitionInstance.targetState$delegate;
                        tagPayloadReader2 = transitionInstance.transitionState;
                        zChanged3 = gapComposer.changed(transitionInstance);
                        objRememberedValue7 = gapComposer.rememberedValue();
                        if (zChanged3 || objRememberedValue7 == neverEqualPolicy) {
                            objRememberedValue7 = Stack.mutableStateOf$default(enterTransitionImpl);
                            gapComposer.updateRememberedValue(objRememberedValue7);
                        }
                        mutableState = (MutableState) objRememberedValue7;
                        currentState = tagPayloadReader2.getCurrentState();
                        value = parcelableSnapshotMutableState3.getValue();
                        enterExitState = EnterExitState.PostExit;
                        enterExitState2 = EnterExitState.Visible;
                        if (currentState == value || tagPayloadReader2.getCurrentState() != enterExitState2) {
                            if (parcelableSnapshotMutableState3.getValue() != enterExitState) {
                                mutableState.setValue(((EnterTransitionImpl) mutableState.getValue()).plus(EnterTransitionImpl.None.plus(enterTransitionImpl)));
                            }
                        } else if (transitionInstance.isSeeking()) {
                            mutableState.setValue(enterTransitionImpl);
                        } else {
                            mutableState.setValue(EnterTransitionImpl.None);
                        }
                        enterTransitionImpl2 = (EnterTransitionImpl) mutableState.getValue();
                        zChanged4 = gapComposer.changed(transitionInstance);
                        objRememberedValue8 = gapComposer.rememberedValue();
                        if (zChanged4 || objRememberedValue8 == neverEqualPolicy) {
                            objRememberedValue8 = Stack.mutableStateOf$default(exitTransitionImpl);
                            gapComposer.updateRememberedValue(objRememberedValue8);
                        }
                        mutableState2 = (MutableState) objRememberedValue8;
                        if (tagPayloadReader2.getCurrentState() == parcelableSnapshotMutableState3.getValue() || tagPayloadReader2.getCurrentState() != enterExitState2) {
                            if (parcelableSnapshotMutableState3.getValue() != enterExitState2) {
                                if (sharedMutableTransformState.isMutating()) {
                                    exitTransitionImpl2 = (ExitTransitionImpl) mutableState2.getValue();
                                } else {
                                    EnterExitTransitionConfig enterExitTransitionConfig4 = ((ExitTransitionImpl) mutableState2.getValue()).config;
                                    fadeConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.fade;
                                    if (fadeConfig != null) {
                                        fadeConfig2 = new FadeConfig(1.0f, fadeConfig.animationSpec);
                                    } else {
                                        fadeConfig2 = null;
                                    }
                                    scaleConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.scale;
                                    if (scaleConfig != null) {
                                        scaleConfig2 = new ScaleConfig(1.0f, scaleConfig.transformOrigin, scaleConfig.animationSpec);
                                    } else {
                                        scaleConfig2 = null;
                                    }
                                    slideConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.slide;
                                    if (slideConfig != null) {
                                        slideConfig2 = new SlideConfig(EnterExitTransitionKt.NeutralSlideOffset, slideConfig.animationSpec);
                                    } else {
                                        slideConfig2 = null;
                                    }
                                    changeSizeConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.changeSize;
                                    if (changeSizeConfig != null) {
                                        changeSizeConfig2 = new ChangeSizeConfig(changeSizeConfig.alignment, EnterExitTransitionKt.NeutralChangeSize, changeSizeConfig.animationSpec, changeSizeConfig.clip);
                                    } else {
                                        changeSizeConfig2 = null;
                                    }
                                    veilConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.veil;
                                    if (veilConfig != null) {
                                        long j = veilConfig.initialColor;
                                        veilConfig2 = new VeilConfig(j, j, veilConfig.animationSpec, veilConfig.matchParentSize);
                                    } else {
                                        veilConfig2 = null;
                                    }
                                    exitTransitionImpl2 = new ExitTransitionImpl(new EnterExitTransitionConfig(fadeConfig2, slideConfig2, changeSizeConfig2, scaleConfig2, veilConfig2, enterExitTransitionConfig4.hold, enterExitTransitionConfig4.effectsMap));
                                }
                                mutableState2.setValue(exitTransitionImpl2.plus(ExitTransitionImpl.None).plus(exitTransitionImpl));
                            }
                            exitTransitionImpl3 = (ExitTransitionImpl) mutableState2.getValue();
                            mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function2, gapComposer);
                            objInvoke = function2.invoke(tagPayloadReader2.getCurrentState(), parcelableSnapshotMutableState3.getValue());
                            zChanged5 = gapComposer.changed(transitionInstance) | gapComposer.changed(mutableStateRememberUpdatedState);
                            objRememberedValue9 = gapComposer.rememberedValue();
                            if (zChanged5 || objRememberedValue9 == neverEqualPolicy) {
                                objRememberedValue9 = new RealImageLoader.AnonymousClass2(transitionInstance, mutableStateRememberUpdatedState, null, (byte) 1);
                                gapComposer.updateRememberedValue(objRememberedValue9);
                            }
                            function3 = (Function2) objRememberedValue9;
                            objRememberedValue10 = gapComposer.rememberedValue();
                            if (objRememberedValue10 == neverEqualPolicy) {
                                objRememberedValue10 = Stack.mutableStateOf$default(objInvoke);
                                gapComposer.updateRememberedValue(objRememberedValue10);
                            }
                            mutableState3 = (MutableState) objRememberedValue10;
                            zChangedInstance2 = gapComposer.changedInstance(function3);
                            objRememberedValue11 = gapComposer.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue11 == neverEqualPolicy) {
                                objRememberedValue11 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function3, mutableState3, null, (byte) 0);
                                gapComposer.updateRememberedValue(objRememberedValue11);
                            }
                            Stack.LaunchedEffect(gapComposer, Unit.INSTANCE, (Function2) objRememberedValue11);
                            if (tagPayloadReader2.getCurrentState() != enterExitState && parcelableSnapshotMutableState3.getValue() == enterExitState && ((Boolean) mutableState3.getValue()).booleanValue()) {
                                gapComposer.startReplaceGroup(250085035);
                                z19 = false;
                                gapComposer.end(false);
                                modifier2 = modifier;
                                composableLambdaImpl3 = composableLambdaImpl;
                            } else {
                                gapComposer.startReplaceGroup(248647379);
                                if (i4 == 4) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                objRememberedValue12 = gapComposer.rememberedValue();
                                if (z11 || objRememberedValue12 == neverEqualPolicy) {
                                    objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                                    gapComposer.updateRememberedValue(objRememberedValue12);
                                }
                                animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) objRememberedValue12;
                                twoWayConverterImpl = ArcSplineKt.IntOffsetToVector;
                                objRememberedValue13 = gapComposer.rememberedValue();
                                if (objRememberedValue13 == neverEqualPolicy) {
                                    objRememberedValue13 = new ScrollKt$$ExternalSyntheticLambda0((byte) 7);
                                    gapComposer.updateRememberedValue(objRememberedValue13);
                                }
                                function0 = (Function0) objRememberedValue13;
                                gapComposer.startReplaceGroup(1018346543);
                                gapComposer.end(false);
                                gapComposer.startReplaceGroup(1018554181);
                                gapComposer.end(false);
                                gapComposer.startReplaceGroup(1018736678);
                                gapComposer.end(false);
                                enterExitTransitionConfig = enterTransitionImpl2.config;
                                changeSizeConfig3 = enterExitTransitionConfig.changeSize;
                                veilConfig3 = enterExitTransitionConfig.veil;
                                if (veilConfig3 == null || exitTransitionImpl3.config.veil != null) {
                                    enterExitTransitionConfig2 = enterExitTransitionConfig;
                                    transitionInstance2 = transitionInstance;
                                    changeSizeConfig4 = changeSizeConfig3;
                                } else {
                                    enterExitTransitionConfig2 = enterExitTransitionConfig;
                                    transitionInstance2 = transitionInstance;
                                    changeSizeConfig4 = changeSizeConfig3;
                                    if (ULong.m1869equalsimpl0(sharedMutableTransformState.lastVeil, 0L)) {
                                        z12 = false;
                                    }
                                    enterExitTransitionConfig3 = enterExitTransitionConfig2;
                                    if (enterExitTransitionConfig3.slide == null || exitTransitionImpl3.config.slide != null) {
                                        sharedMutableTransformState2 = sharedMutableTransformState;
                                    } else {
                                        sharedMutableTransformState2 = sharedMutableTransformState;
                                        if (IntOffset.m804equalsimpl0(sharedMutableTransformState.lastSlide, 0L)) {
                                            z13 = false;
                                        }
                                        if (changeSizeConfig4 == null || exitTransitionImpl3.config.changeSize != null) {
                                            z14 = true;
                                        } else {
                                            z14 = false;
                                        }
                                        if (z13) {
                                            gapComposer.startReplaceGroup(1019286587);
                                            objRememberedValue22 = gapComposer.rememberedValue();
                                            if (objRememberedValue22 == neverEqualPolicy) {
                                                objRememberedValue22 = "Built-in slide";
                                                gapComposer.updateRememberedValue("Built-in slide");
                                            }
                                            String str = (String) objRememberedValue22;
                                            neverEqualPolicy2 = neverEqualPolicy;
                                            transitionInstance3 = transitionInstance2;
                                            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation2 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl, str, gapComposer, 384, 0);
                                            twoWayConverterImpl2 = twoWayConverterImpl;
                                            gapComposer.end(false);
                                            deferredAnimation = deferredAnimationCreateDeferredAnimation2;
                                        } else {
                                            twoWayConverterImpl2 = twoWayConverterImpl;
                                            neverEqualPolicy2 = neverEqualPolicy;
                                            transitionInstance3 = transitionInstance2;
                                            gapComposer.startReplaceGroup(1019392390);
                                            gapComposer.end(false);
                                            deferredAnimation = null;
                                        }
                                        if (z14) {
                                            gapComposer.startReplaceGroup(1019484181);
                                            TwoWayConverterImpl twoWayConverterImpl4 = ArcSplineKt.IntSizeToVector;
                                            objRememberedValue21 = gapComposer.rememberedValue();
                                            if (objRememberedValue21 == neverEqualPolicy2) {
                                                objRememberedValue21 = "Built-in shrink/expand";
                                                gapComposer.updateRememberedValue("Built-in shrink/expand");
                                            }
                                            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation3 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl4, (String) objRememberedValue21, gapComposer, 384, 0);
                                            gapComposer.end(false);
                                            deferredAnimation2 = deferredAnimationCreateDeferredAnimation3;
                                        } else {
                                            gapComposer.startReplaceGroup(1019595005);
                                            gapComposer.end(false);
                                            deferredAnimation2 = null;
                                        }
                                        if (z14) {
                                            gapComposer.startReplaceGroup(1019668631);
                                            objRememberedValue20 = gapComposer.rememberedValue();
                                            if (objRememberedValue20 == neverEqualPolicy2) {
                                                objRememberedValue20 = "Built-in InterruptionHandlingOffset";
                                                gapComposer.updateRememberedValue("Built-in InterruptionHandlingOffset");
                                            }
                                            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation4 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl2, (String) objRememberedValue20, gapComposer, 384, 0);
                                            gapComposer.end(false);
                                            deferredAnimation3 = deferredAnimationCreateDeferredAnimation4;
                                        } else {
                                            gapComposer.startReplaceGroup(1019839037);
                                            gapComposer.end(false);
                                            deferredAnimation3 = null;
                                        }
                                        z15 = (changeSizeConfig4 == 0 && !changeSizeConfig4.clip) || !(((changeSizeConfig5 = exitTransitionImpl3.config.changeSize) == null || changeSizeConfig5.clip) && z14);
                                        if (veilConfig3 != 0 || (colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.initialColor)) == null) {
                                            if (veilConfig3 != 0) {
                                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                                            } else {
                                                veilConfig4 = exitTransitionImpl3.config.veil;
                                                if (veilConfig4 != null) {
                                                    colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                                                } else {
                                                    colorSpaceM483getColorSpaceimpl = null;
                                                }
                                                if (colorSpaceM483getColorSpaceimpl == null) {
                                                    veilConfig5 = exitTransitionImpl3.config.veil;
                                                    if (veilConfig5 != null) {
                                                        colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                                    } else {
                                                        colorSpaceM483getColorSpaceimpl = null;
                                                    }
                                                    if (colorSpaceM483getColorSpaceimpl == null) {
                                                        colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                                    }
                                                }
                                            }
                                        }
                                        companion = Modifier.Companion.$$INSTANCE;
                                        if (z12) {
                                            gapComposer.startReplaceGroup(1020378035);
                                            CallsKt$await$2$1 callsKt$await$2$1 = new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl);
                                            companion2 = companion;
                                            TwoWayConverterImpl twoWayConverterImpl5 = new TwoWayConverterImpl(ColorVectorConverterKt$ColorToVector$1$1.INSTANCE, callsKt$await$2$1);
                                            objRememberedValue19 = gapComposer.rememberedValue();
                                            if (objRememberedValue19 == neverEqualPolicy2) {
                                                objRememberedValue19 = "Built-in veil";
                                                gapComposer.updateRememberedValue("Built-in veil");
                                            }
                                            VeilModifierElement veilModifierElement = new VeilModifierElement(transitionInstance3, ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl5, (String) objRememberedValue19, gapComposer, 384, 0), enterTransitionImpl2, exitTransitionImpl3, sharedMutableTransformState2);
                                            exitTransitionImpl4 = exitTransitionImpl3;
                                            gapComposer.end(false);
                                            modifier3 = veilModifierElement;
                                        } else {
                                            exitTransitionImpl4 = exitTransitionImpl3;
                                            companion2 = companion;
                                            gapComposer.startReplaceGroup(1020676162);
                                            gapComposer.end(false);
                                            modifier3 = companion2;
                                        }
                                        if (veilConfig3 != 0) {
                                            zBooleanValue = veilConfig3.matchParentSize;
                                        } else {
                                            veilConfig6 = exitTransitionImpl4.config.veil;
                                            if (veilConfig6 != null) {
                                                zBooleanValue = veilConfig6.matchParentSize;
                                            } else {
                                                if (sharedMutableTransformState2.mutableData != null) {
                                                    bool = Boolean.FALSE;
                                                } else {
                                                    bool = null;
                                                }
                                                if (bool != null) {
                                                    zBooleanValue = bool.booleanValue();
                                                } else {
                                                    zBooleanValue = false;
                                                }
                                            }
                                        }
                                        twoWayConverterImpl3 = ArcSplineKt.FloatToVector;
                                        if (enterExitTransitionConfig3.fade != null && exitTransitionImpl4.config.fade == null && sharedMutableTransformState2.lastAlpha == 1.0f) {
                                            z16 = false;
                                        } else {
                                            z16 = true;
                                        }
                                        if (enterExitTransitionConfig3.scale != null && exitTransitionImpl4.config.scale == null && sharedMutableTransformState2.lastScale == 1.0f) {
                                            z17 = false;
                                        } else {
                                            z17 = true;
                                        }
                                        if (z16) {
                                            gapComposer.startReplaceGroup(-1511857635);
                                            objRememberedValue18 = gapComposer.rememberedValue();
                                            if (objRememberedValue18 == neverEqualPolicy2) {
                                                objRememberedValue18 = "Built-in alpha";
                                                gapComposer.updateRememberedValue("Built-in alpha");
                                            }
                                            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation5 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue18, gapComposer, 384, 0);
                                            gapComposer.end(false);
                                            deferredAnimation4 = deferredAnimationCreateDeferredAnimation5;
                                        } else {
                                            gapComposer.startReplaceGroup(-1511688190);
                                            gapComposer.end(false);
                                            deferredAnimation4 = null;
                                        }
                                        if (z17) {
                                            gapComposer.startReplaceGroup(-1511620547);
                                            objRememberedValue17 = gapComposer.rememberedValue();
                                            if (objRememberedValue17 == neverEqualPolicy2) {
                                                objRememberedValue17 = "Built-in scale";
                                                gapComposer.updateRememberedValue("Built-in scale");
                                            }
                                            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation6 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue17, gapComposer, 384, 0);
                                            z18 = false;
                                            gapComposer.end(false);
                                            deferredAnimation5 = deferredAnimationCreateDeferredAnimation6;
                                        } else {
                                            z18 = false;
                                            gapComposer.startReplaceGroup(-1511451102);
                                            gapComposer.end(false);
                                            deferredAnimation5 = null;
                                        }
                                        if (z17) {
                                            gapComposer.startReplaceGroup(-1511373446);
                                            deferredAnimationCreateDeferredAnimation = ArcSplineKt.createDeferredAnimation(transitionInstance3, EnterExitTransitionKt.TransformOriginVectorConverter, "TransformOriginInterruptionHandling", gapComposer, 384, 0);
                                            gapComposer.end(z18);
                                        } else {
                                            gapComposer.startReplaceGroup(-1511201118);
                                            gapComposer.end(z18);
                                            deferredAnimationCreateDeferredAnimation = null;
                                        }
                                        zChangedInstance3 = gapComposer.changedInstance(deferredAnimation4) | gapComposer.changed(enterTransitionImpl2) | gapComposer.changed(exitTransitionImpl4) | gapComposer.changedInstance(sharedMutableTransformState2) | gapComposer.changedInstance(deferredAnimation5) | gapComposer.changed(transitionInstance3) | gapComposer.changedInstance(deferredAnimationCreateDeferredAnimation);
                                        objRememberedValue14 = gapComposer.rememberedValue();
                                        if (!zChangedInstance3 || objRememberedValue14 == neverEqualPolicy2) {
                                            SharedMutableTransformState sharedMutableTransformState4 = sharedMutableTransformState2;
                                            exitTransitionImpl5 = exitTransitionImpl4;
                                            objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState4, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                                            sharedMutableTransformState3 = sharedMutableTransformState4;
                                            gapComposer.updateRememberedValue(objRememberedValue14);
                                        } else {
                                            sharedMutableTransformState3 = sharedMutableTransformState2;
                                            exitTransitionImpl5 = exitTransitionImpl4;
                                        }
                                        EnterExitTransitionKt$$ExternalSyntheticLambda7 enterExitTransitionKt$$ExternalSyntheticLambda7 = (EnterExitTransitionKt$$ExternalSyntheticLambda7) objRememberedValue14;
                                        if (zBooleanValue != 0) {
                                            modifier4 = modifier3;
                                        } else {
                                            modifier4 = companion2;
                                        }
                                        zChanged6 = gapComposer.changed(z15) | gapComposer.changed(function0);
                                        objRememberedValue15 = gapComposer.rememberedValue();
                                        if (zChanged6 || objRememberedValue15 == neverEqualPolicy2) {
                                            objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                                            gapComposer.updateRememberedValue(objRememberedValue15);
                                        }
                                        Modifier modifierThen = modifier4.then(ColorKt.graphicsLayer(companion2, (Function1) objRememberedValue15)).then(new EnterExitTransitionElement(transitionInstance3, deferredAnimation2, deferredAnimation3, deferredAnimation, enterTransitionImpl2, exitTransitionImpl5, sharedMutableTransformState3, function0, enterExitTransitionKt$$ExternalSyntheticLambda7));
                                        if (zBooleanValue) {
                                            modifier5 = companion2;
                                        } else {
                                            modifier5 = modifier3;
                                        }
                                        Modifier modifierThen2 = modifierThen.then(modifier5);
                                        gapComposer.startReplaceGroup(-130485473);
                                        gapComposer.end(false);
                                        modifier2 = modifier;
                                        Modifier modifierThen3 = modifier2.then(modifierThen2.then(companion2));
                                        objRememberedValue16 = gapComposer.rememberedValue();
                                        if (objRememberedValue16 == neverEqualPolicy2) {
                                            objRememberedValue16 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                                            gapComposer.updateRememberedValue(objRememberedValue16);
                                        }
                                        AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy = (AnimatedEnterExitMeasurePolicy) objRememberedValue16;
                                        int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                                        Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen3);
                                        ComposeUiNode.Companion.getClass();
                                        gapComposer.startReusableNode();
                                        if (gapComposer.inserting) {
                                            gapComposer.createNode(LayoutNode.Constructor);
                                        } else {
                                            gapComposer.useNode();
                                        }
                                        Stack.m390setimpl(gapComposer, animatedEnterExitMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                        Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                        Stack.m386initimpl(gapComposer, Integer.valueOf(iHashCode));
                                        Stack.m389reconcileimpl(gapComposer);
                                        Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                        ComposableLambdaImpl composableLambdaImpl6 = composableLambdaImpl;
                                        composableLambdaImpl6.invoke(animatedVisibilityScopeImpl, gapComposer, Integer.valueOf((i3 >> 24) & 112));
                                        gapComposer.end(true);
                                        z19 = false;
                                        gapComposer.end(false);
                                        composableLambdaImpl3 = composableLambdaImpl6;
                                    }
                                    z13 = true;
                                    if (changeSizeConfig4 == null) {
                                        z14 = true;
                                    } else {
                                        z14 = true;
                                    }
                                    if (z13) {
                                        gapComposer.startReplaceGroup(1019286587);
                                        objRememberedValue22 = gapComposer.rememberedValue();
                                        if (objRememberedValue22 == neverEqualPolicy) {
                                            objRememberedValue22 = "Built-in slide";
                                            gapComposer.updateRememberedValue("Built-in slide");
                                        }
                                        String str2 = (String) objRememberedValue22;
                                        neverEqualPolicy2 = neverEqualPolicy;
                                        transitionInstance3 = transitionInstance2;
                                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation7 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl, str2, gapComposer, 384, 0);
                                        twoWayConverterImpl2 = twoWayConverterImpl;
                                        gapComposer.end(false);
                                        deferredAnimation = deferredAnimationCreateDeferredAnimation7;
                                    } else {
                                        twoWayConverterImpl2 = twoWayConverterImpl;
                                        neverEqualPolicy2 = neverEqualPolicy;
                                        transitionInstance3 = transitionInstance2;
                                        gapComposer.startReplaceGroup(1019392390);
                                        gapComposer.end(false);
                                        deferredAnimation = null;
                                    }
                                    if (z14) {
                                        gapComposer.startReplaceGroup(1019484181);
                                        TwoWayConverterImpl twoWayConverterImpl6 = ArcSplineKt.IntSizeToVector;
                                        objRememberedValue21 = gapComposer.rememberedValue();
                                        if (objRememberedValue21 == neverEqualPolicy2) {
                                            objRememberedValue21 = "Built-in shrink/expand";
                                            gapComposer.updateRememberedValue("Built-in shrink/expand");
                                        }
                                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation8 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl6, (String) objRememberedValue21, gapComposer, 384, 0);
                                        gapComposer.end(false);
                                        deferredAnimation2 = deferredAnimationCreateDeferredAnimation8;
                                    } else {
                                        gapComposer.startReplaceGroup(1019595005);
                                        gapComposer.end(false);
                                        deferredAnimation2 = null;
                                    }
                                    if (z14) {
                                        gapComposer.startReplaceGroup(1019668631);
                                        objRememberedValue20 = gapComposer.rememberedValue();
                                        if (objRememberedValue20 == neverEqualPolicy2) {
                                            objRememberedValue20 = "Built-in InterruptionHandlingOffset";
                                            gapComposer.updateRememberedValue("Built-in InterruptionHandlingOffset");
                                        }
                                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation9 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl2, (String) objRememberedValue20, gapComposer, 384, 0);
                                        gapComposer.end(false);
                                        deferredAnimation3 = deferredAnimationCreateDeferredAnimation9;
                                    } else {
                                        gapComposer.startReplaceGroup(1019839037);
                                        gapComposer.end(false);
                                        deferredAnimation3 = null;
                                    }
                                    if (changeSizeConfig4 == 0) {
                                    }
                                    if (veilConfig3 != 0) {
                                        if (veilConfig3 != 0) {
                                            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                                        } else {
                                            veilConfig4 = exitTransitionImpl3.config.veil;
                                            if (veilConfig4 != null) {
                                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                                            } else {
                                                colorSpaceM483getColorSpaceimpl = null;
                                            }
                                            if (colorSpaceM483getColorSpaceimpl == null) {
                                                veilConfig5 = exitTransitionImpl3.config.veil;
                                                if (veilConfig5 != null) {
                                                    colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                                } else {
                                                    colorSpaceM483getColorSpaceimpl = null;
                                                }
                                                if (colorSpaceM483getColorSpaceimpl == null) {
                                                    colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                                }
                                            }
                                        }
                                    } else if (veilConfig3 != 0) {
                                        colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                                    } else {
                                        veilConfig4 = exitTransitionImpl3.config.veil;
                                        if (veilConfig4 != null) {
                                            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                                        } else {
                                            colorSpaceM483getColorSpaceimpl = null;
                                        }
                                        if (colorSpaceM483getColorSpaceimpl == null) {
                                            veilConfig5 = exitTransitionImpl3.config.veil;
                                            if (veilConfig5 != null) {
                                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                            } else {
                                                colorSpaceM483getColorSpaceimpl = null;
                                            }
                                            if (colorSpaceM483getColorSpaceimpl == null) {
                                                colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                            }
                                        }
                                    }
                                    companion = Modifier.Companion.$$INSTANCE;
                                    if (z12) {
                                        gapComposer.startReplaceGroup(1020378035);
                                        CallsKt$await$2$1 callsKt$await$2$2 = new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl);
                                        companion2 = companion;
                                        TwoWayConverterImpl twoWayConverterImpl7 = new TwoWayConverterImpl(ColorVectorConverterKt$ColorToVector$1$1.INSTANCE, callsKt$await$2$2);
                                        objRememberedValue19 = gapComposer.rememberedValue();
                                        if (objRememberedValue19 == neverEqualPolicy2) {
                                            objRememberedValue19 = "Built-in veil";
                                            gapComposer.updateRememberedValue("Built-in veil");
                                        }
                                        VeilModifierElement veilModifierElement2 = new VeilModifierElement(transitionInstance3, ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl7, (String) objRememberedValue19, gapComposer, 384, 0), enterTransitionImpl2, exitTransitionImpl3, sharedMutableTransformState2);
                                        exitTransitionImpl4 = exitTransitionImpl3;
                                        gapComposer.end(false);
                                        modifier3 = veilModifierElement2;
                                    } else {
                                        exitTransitionImpl4 = exitTransitionImpl3;
                                        companion2 = companion;
                                        gapComposer.startReplaceGroup(1020676162);
                                        gapComposer.end(false);
                                        modifier3 = companion2;
                                    }
                                    if (veilConfig3 != 0) {
                                        zBooleanValue = veilConfig3.matchParentSize;
                                    } else {
                                        veilConfig6 = exitTransitionImpl4.config.veil;
                                        if (veilConfig6 != null) {
                                            zBooleanValue = veilConfig6.matchParentSize;
                                        } else {
                                            if (sharedMutableTransformState2.mutableData != null) {
                                                bool = Boolean.FALSE;
                                            } else {
                                                bool = null;
                                            }
                                            if (bool != null) {
                                                zBooleanValue = bool.booleanValue();
                                            } else {
                                                zBooleanValue = false;
                                            }
                                        }
                                    }
                                    twoWayConverterImpl3 = ArcSplineKt.FloatToVector;
                                    if (enterExitTransitionConfig3.fade != null) {
                                        z16 = true;
                                    } else {
                                        z16 = true;
                                    }
                                    if (enterExitTransitionConfig3.scale != null) {
                                        z17 = true;
                                    } else {
                                        z17 = true;
                                    }
                                    if (z16) {
                                        gapComposer.startReplaceGroup(-1511857635);
                                        objRememberedValue18 = gapComposer.rememberedValue();
                                        if (objRememberedValue18 == neverEqualPolicy2) {
                                            objRememberedValue18 = "Built-in alpha";
                                            gapComposer.updateRememberedValue("Built-in alpha");
                                        }
                                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation10 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue18, gapComposer, 384, 0);
                                        gapComposer.end(false);
                                        deferredAnimation4 = deferredAnimationCreateDeferredAnimation10;
                                    } else {
                                        gapComposer.startReplaceGroup(-1511688190);
                                        gapComposer.end(false);
                                        deferredAnimation4 = null;
                                    }
                                    if (z17) {
                                        gapComposer.startReplaceGroup(-1511620547);
                                        objRememberedValue17 = gapComposer.rememberedValue();
                                        if (objRememberedValue17 == neverEqualPolicy2) {
                                            objRememberedValue17 = "Built-in scale";
                                            gapComposer.updateRememberedValue("Built-in scale");
                                        }
                                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation11 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue17, gapComposer, 384, 0);
                                        z18 = false;
                                        gapComposer.end(false);
                                        deferredAnimation5 = deferredAnimationCreateDeferredAnimation11;
                                    } else {
                                        z18 = false;
                                        gapComposer.startReplaceGroup(-1511451102);
                                        gapComposer.end(false);
                                        deferredAnimation5 = null;
                                    }
                                    if (z17) {
                                        gapComposer.startReplaceGroup(-1511373446);
                                        deferredAnimationCreateDeferredAnimation = ArcSplineKt.createDeferredAnimation(transitionInstance3, EnterExitTransitionKt.TransformOriginVectorConverter, "TransformOriginInterruptionHandling", gapComposer, 384, 0);
                                        gapComposer.end(z18);
                                    } else {
                                        gapComposer.startReplaceGroup(-1511201118);
                                        gapComposer.end(z18);
                                        deferredAnimationCreateDeferredAnimation = null;
                                    }
                                    zChangedInstance3 = gapComposer.changedInstance(deferredAnimation4) | gapComposer.changed(enterTransitionImpl2) | gapComposer.changed(exitTransitionImpl4) | gapComposer.changedInstance(sharedMutableTransformState2) | gapComposer.changedInstance(deferredAnimation5) | gapComposer.changed(transitionInstance3) | gapComposer.changedInstance(deferredAnimationCreateDeferredAnimation);
                                    objRememberedValue14 = gapComposer.rememberedValue();
                                    if (zChangedInstance3) {
                                        SharedMutableTransformState sharedMutableTransformState5 = sharedMutableTransformState2;
                                        exitTransitionImpl5 = exitTransitionImpl4;
                                        objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState5, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                                        sharedMutableTransformState3 = sharedMutableTransformState5;
                                        gapComposer.updateRememberedValue(objRememberedValue14);
                                    } else {
                                        SharedMutableTransformState sharedMutableTransformState6 = sharedMutableTransformState2;
                                        exitTransitionImpl5 = exitTransitionImpl4;
                                        objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState6, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                                        sharedMutableTransformState3 = sharedMutableTransformState6;
                                        gapComposer.updateRememberedValue(objRememberedValue14);
                                    }
                                    EnterExitTransitionKt$$ExternalSyntheticLambda7 enterExitTransitionKt$$ExternalSyntheticLambda8 = (EnterExitTransitionKt$$ExternalSyntheticLambda7) objRememberedValue14;
                                    if (zBooleanValue != 0) {
                                        modifier4 = modifier3;
                                    } else {
                                        modifier4 = companion2;
                                    }
                                    zChanged6 = gapComposer.changed(z15) | gapComposer.changed(function0);
                                    objRememberedValue15 = gapComposer.rememberedValue();
                                    if (zChanged6) {
                                        objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                                        gapComposer.updateRememberedValue(objRememberedValue15);
                                    } else {
                                        objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                                        gapComposer.updateRememberedValue(objRememberedValue15);
                                    }
                                    Modifier modifierThen4 = modifier4.then(ColorKt.graphicsLayer(companion2, (Function1) objRememberedValue15)).then(new EnterExitTransitionElement(transitionInstance3, deferredAnimation2, deferredAnimation3, deferredAnimation, enterTransitionImpl2, exitTransitionImpl5, sharedMutableTransformState3, function0, enterExitTransitionKt$$ExternalSyntheticLambda8));
                                    if (zBooleanValue) {
                                        modifier5 = modifier3;
                                    } else {
                                        modifier5 = companion2;
                                    }
                                    Modifier modifierThen5 = modifierThen4.then(modifier5);
                                    gapComposer.startReplaceGroup(-130485473);
                                    gapComposer.end(false);
                                    modifier2 = modifier;
                                    Modifier modifierThen6 = modifier2.then(modifierThen5.then(companion2));
                                    objRememberedValue16 = gapComposer.rememberedValue();
                                    if (objRememberedValue16 == neverEqualPolicy2) {
                                        objRememberedValue16 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                                        gapComposer.updateRememberedValue(objRememberedValue16);
                                    }
                                    AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy2 = (AnimatedEnterExitMeasurePolicy) objRememberedValue16;
                                    int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen6);
                                    ComposeUiNode.Companion.getClass();
                                    gapComposer.startReusableNode();
                                    if (gapComposer.inserting) {
                                        gapComposer.createNode(LayoutNode.Constructor);
                                    } else {
                                        gapComposer.useNode();
                                    }
                                    Stack.m390setimpl(gapComposer, animatedEnterExitMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                    Stack.m386initimpl(gapComposer, Integer.valueOf(iHashCode2));
                                    Stack.m389reconcileimpl(gapComposer);
                                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                                    ComposableLambdaImpl composableLambdaImpl7 = composableLambdaImpl;
                                    composableLambdaImpl7.invoke(animatedVisibilityScopeImpl, gapComposer, Integer.valueOf((i3 >> 24) & 112));
                                    gapComposer.end(true);
                                    z19 = false;
                                    gapComposer.end(false);
                                    composableLambdaImpl3 = composableLambdaImpl7;
                                }
                                z12 = true;
                                enterExitTransitionConfig3 = enterExitTransitionConfig2;
                                if (enterExitTransitionConfig3.slide == null) {
                                    sharedMutableTransformState2 = sharedMutableTransformState;
                                    z13 = true;
                                } else {
                                    sharedMutableTransformState2 = sharedMutableTransformState;
                                    z13 = true;
                                }
                                if (changeSizeConfig4 == null) {
                                    z14 = true;
                                } else {
                                    z14 = true;
                                }
                                if (z13) {
                                    gapComposer.startReplaceGroup(1019286587);
                                    objRememberedValue22 = gapComposer.rememberedValue();
                                    if (objRememberedValue22 == neverEqualPolicy) {
                                        objRememberedValue22 = "Built-in slide";
                                        gapComposer.updateRememberedValue("Built-in slide");
                                    }
                                    String str3 = (String) objRememberedValue22;
                                    neverEqualPolicy2 = neverEqualPolicy;
                                    transitionInstance3 = transitionInstance2;
                                    Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation12 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl, str3, gapComposer, 384, 0);
                                    twoWayConverterImpl2 = twoWayConverterImpl;
                                    gapComposer.end(false);
                                    deferredAnimation = deferredAnimationCreateDeferredAnimation12;
                                } else {
                                    twoWayConverterImpl2 = twoWayConverterImpl;
                                    neverEqualPolicy2 = neverEqualPolicy;
                                    transitionInstance3 = transitionInstance2;
                                    gapComposer.startReplaceGroup(1019392390);
                                    gapComposer.end(false);
                                    deferredAnimation = null;
                                }
                                if (z14) {
                                    gapComposer.startReplaceGroup(1019484181);
                                    TwoWayConverterImpl twoWayConverterImpl8 = ArcSplineKt.IntSizeToVector;
                                    objRememberedValue21 = gapComposer.rememberedValue();
                                    if (objRememberedValue21 == neverEqualPolicy2) {
                                        objRememberedValue21 = "Built-in shrink/expand";
                                        gapComposer.updateRememberedValue("Built-in shrink/expand");
                                    }
                                    Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation13 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl8, (String) objRememberedValue21, gapComposer, 384, 0);
                                    gapComposer.end(false);
                                    deferredAnimation2 = deferredAnimationCreateDeferredAnimation13;
                                } else {
                                    gapComposer.startReplaceGroup(1019595005);
                                    gapComposer.end(false);
                                    deferredAnimation2 = null;
                                }
                                if (z14) {
                                    gapComposer.startReplaceGroup(1019668631);
                                    objRememberedValue20 = gapComposer.rememberedValue();
                                    if (objRememberedValue20 == neverEqualPolicy2) {
                                        objRememberedValue20 = "Built-in InterruptionHandlingOffset";
                                        gapComposer.updateRememberedValue("Built-in InterruptionHandlingOffset");
                                    }
                                    Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation14 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl2, (String) objRememberedValue20, gapComposer, 384, 0);
                                    gapComposer.end(false);
                                    deferredAnimation3 = deferredAnimationCreateDeferredAnimation14;
                                } else {
                                    gapComposer.startReplaceGroup(1019839037);
                                    gapComposer.end(false);
                                    deferredAnimation3 = null;
                                }
                                if (changeSizeConfig4 == 0) {
                                }
                                if (veilConfig3 != 0) {
                                    if (veilConfig3 != 0) {
                                        colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                                    } else {
                                        veilConfig4 = exitTransitionImpl3.config.veil;
                                        if (veilConfig4 != null) {
                                            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                                        } else {
                                            colorSpaceM483getColorSpaceimpl = null;
                                        }
                                        if (colorSpaceM483getColorSpaceimpl == null) {
                                            veilConfig5 = exitTransitionImpl3.config.veil;
                                            if (veilConfig5 != null) {
                                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                            } else {
                                                colorSpaceM483getColorSpaceimpl = null;
                                            }
                                            if (colorSpaceM483getColorSpaceimpl == null) {
                                                colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                            }
                                        }
                                    }
                                } else if (veilConfig3 != 0) {
                                    colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                                } else {
                                    veilConfig4 = exitTransitionImpl3.config.veil;
                                    if (veilConfig4 != null) {
                                        colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                                    } else {
                                        colorSpaceM483getColorSpaceimpl = null;
                                    }
                                    if (colorSpaceM483getColorSpaceimpl == null) {
                                        veilConfig5 = exitTransitionImpl3.config.veil;
                                        if (veilConfig5 != null) {
                                            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                        } else {
                                            colorSpaceM483getColorSpaceimpl = null;
                                        }
                                        if (colorSpaceM483getColorSpaceimpl == null) {
                                            colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                        }
                                    }
                                }
                                companion = Modifier.Companion.$$INSTANCE;
                                if (z12) {
                                    gapComposer.startReplaceGroup(1020378035);
                                    CallsKt$await$2$1 callsKt$await$2$3 = new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl);
                                    companion2 = companion;
                                    TwoWayConverterImpl twoWayConverterImpl9 = new TwoWayConverterImpl(ColorVectorConverterKt$ColorToVector$1$1.INSTANCE, callsKt$await$2$3);
                                    objRememberedValue19 = gapComposer.rememberedValue();
                                    if (objRememberedValue19 == neverEqualPolicy2) {
                                        objRememberedValue19 = "Built-in veil";
                                        gapComposer.updateRememberedValue("Built-in veil");
                                    }
                                    VeilModifierElement veilModifierElement3 = new VeilModifierElement(transitionInstance3, ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl9, (String) objRememberedValue19, gapComposer, 384, 0), enterTransitionImpl2, exitTransitionImpl3, sharedMutableTransformState2);
                                    exitTransitionImpl4 = exitTransitionImpl3;
                                    gapComposer.end(false);
                                    modifier3 = veilModifierElement3;
                                } else {
                                    exitTransitionImpl4 = exitTransitionImpl3;
                                    companion2 = companion;
                                    gapComposer.startReplaceGroup(1020676162);
                                    gapComposer.end(false);
                                    modifier3 = companion2;
                                }
                                if (veilConfig3 != 0) {
                                    zBooleanValue = veilConfig3.matchParentSize;
                                } else {
                                    veilConfig6 = exitTransitionImpl4.config.veil;
                                    if (veilConfig6 != null) {
                                        zBooleanValue = veilConfig6.matchParentSize;
                                    } else {
                                        if (sharedMutableTransformState2.mutableData != null) {
                                            bool = Boolean.FALSE;
                                        } else {
                                            bool = null;
                                        }
                                        if (bool != null) {
                                            zBooleanValue = bool.booleanValue();
                                        } else {
                                            zBooleanValue = false;
                                        }
                                    }
                                }
                                twoWayConverterImpl3 = ArcSplineKt.FloatToVector;
                                if (enterExitTransitionConfig3.fade != null) {
                                    z16 = true;
                                } else {
                                    z16 = true;
                                }
                                if (enterExitTransitionConfig3.scale != null) {
                                    z17 = true;
                                } else {
                                    z17 = true;
                                }
                                if (z16) {
                                    gapComposer.startReplaceGroup(-1511857635);
                                    objRememberedValue18 = gapComposer.rememberedValue();
                                    if (objRememberedValue18 == neverEqualPolicy2) {
                                        objRememberedValue18 = "Built-in alpha";
                                        gapComposer.updateRememberedValue("Built-in alpha");
                                    }
                                    Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation15 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue18, gapComposer, 384, 0);
                                    gapComposer.end(false);
                                    deferredAnimation4 = deferredAnimationCreateDeferredAnimation15;
                                } else {
                                    gapComposer.startReplaceGroup(-1511688190);
                                    gapComposer.end(false);
                                    deferredAnimation4 = null;
                                }
                                if (z17) {
                                    gapComposer.startReplaceGroup(-1511620547);
                                    objRememberedValue17 = gapComposer.rememberedValue();
                                    if (objRememberedValue17 == neverEqualPolicy2) {
                                        objRememberedValue17 = "Built-in scale";
                                        gapComposer.updateRememberedValue("Built-in scale");
                                    }
                                    Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation16 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue17, gapComposer, 384, 0);
                                    z18 = false;
                                    gapComposer.end(false);
                                    deferredAnimation5 = deferredAnimationCreateDeferredAnimation16;
                                } else {
                                    z18 = false;
                                    gapComposer.startReplaceGroup(-1511451102);
                                    gapComposer.end(false);
                                    deferredAnimation5 = null;
                                }
                                if (z17) {
                                    gapComposer.startReplaceGroup(-1511373446);
                                    deferredAnimationCreateDeferredAnimation = ArcSplineKt.createDeferredAnimation(transitionInstance3, EnterExitTransitionKt.TransformOriginVectorConverter, "TransformOriginInterruptionHandling", gapComposer, 384, 0);
                                    gapComposer.end(z18);
                                } else {
                                    gapComposer.startReplaceGroup(-1511201118);
                                    gapComposer.end(z18);
                                    deferredAnimationCreateDeferredAnimation = null;
                                }
                                zChangedInstance3 = gapComposer.changedInstance(deferredAnimation4) | gapComposer.changed(enterTransitionImpl2) | gapComposer.changed(exitTransitionImpl4) | gapComposer.changedInstance(sharedMutableTransformState2) | gapComposer.changedInstance(deferredAnimation5) | gapComposer.changed(transitionInstance3) | gapComposer.changedInstance(deferredAnimationCreateDeferredAnimation);
                                objRememberedValue14 = gapComposer.rememberedValue();
                                if (zChangedInstance3) {
                                    SharedMutableTransformState sharedMutableTransformState7 = sharedMutableTransformState2;
                                    exitTransitionImpl5 = exitTransitionImpl4;
                                    objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState7, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                                    sharedMutableTransformState3 = sharedMutableTransformState7;
                                    gapComposer.updateRememberedValue(objRememberedValue14);
                                } else {
                                    SharedMutableTransformState sharedMutableTransformState8 = sharedMutableTransformState2;
                                    exitTransitionImpl5 = exitTransitionImpl4;
                                    objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState8, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                                    sharedMutableTransformState3 = sharedMutableTransformState8;
                                    gapComposer.updateRememberedValue(objRememberedValue14);
                                }
                                EnterExitTransitionKt$$ExternalSyntheticLambda7 enterExitTransitionKt$$ExternalSyntheticLambda9 = (EnterExitTransitionKt$$ExternalSyntheticLambda7) objRememberedValue14;
                                if (zBooleanValue != 0) {
                                    modifier4 = modifier3;
                                } else {
                                    modifier4 = companion2;
                                }
                                zChanged6 = gapComposer.changed(z15) | gapComposer.changed(function0);
                                objRememberedValue15 = gapComposer.rememberedValue();
                                if (zChanged6) {
                                    objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                                    gapComposer.updateRememberedValue(objRememberedValue15);
                                } else {
                                    objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                                    gapComposer.updateRememberedValue(objRememberedValue15);
                                }
                                Modifier modifierThen7 = modifier4.then(ColorKt.graphicsLayer(companion2, (Function1) objRememberedValue15)).then(new EnterExitTransitionElement(transitionInstance3, deferredAnimation2, deferredAnimation3, deferredAnimation, enterTransitionImpl2, exitTransitionImpl5, sharedMutableTransformState3, function0, enterExitTransitionKt$$ExternalSyntheticLambda9));
                                if (zBooleanValue) {
                                    modifier5 = modifier3;
                                } else {
                                    modifier5 = companion2;
                                }
                                Modifier modifierThen8 = modifierThen7.then(modifier5);
                                gapComposer.startReplaceGroup(-130485473);
                                gapComposer.end(false);
                                modifier2 = modifier;
                                Modifier modifierThen9 = modifier2.then(modifierThen8.then(companion2));
                                objRememberedValue16 = gapComposer.rememberedValue();
                                if (objRememberedValue16 == neverEqualPolicy2) {
                                    objRememberedValue16 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                                    gapComposer.updateRememberedValue(objRememberedValue16);
                                }
                                AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy3 = (AnimatedEnterExitMeasurePolicy) objRememberedValue16;
                                int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen9);
                                ComposeUiNode.Companion.getClass();
                                gapComposer.startReusableNode();
                                if (gapComposer.inserting) {
                                    gapComposer.createNode(LayoutNode.Constructor);
                                } else {
                                    gapComposer.useNode();
                                }
                                Stack.m390setimpl(gapComposer, animatedEnterExitMeasurePolicy3, ComposeUiNode.Companion.SetMeasurePolicy);
                                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                Stack.m386initimpl(gapComposer, Integer.valueOf(iHashCode3));
                                Stack.m389reconcileimpl(gapComposer);
                                Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
                                ComposableLambdaImpl composableLambdaImpl8 = composableLambdaImpl;
                                composableLambdaImpl8.invoke(animatedVisibilityScopeImpl, gapComposer, Integer.valueOf((i3 >> 24) & 112));
                                gapComposer.end(true);
                                z19 = false;
                                gapComposer.end(false);
                                composableLambdaImpl3 = composableLambdaImpl8;
                            }
                            gapComposer.end(z19);
                            composableLambdaImpl4 = composableLambdaImpl3;
                        } else if (transitionInstance.isSeeking()) {
                            mutableState2.setValue(exitTransitionImpl);
                        } else {
                            mutableState2.setValue(ExitTransitionImpl.None);
                        }
                        sharedMutableTransformState = sharedMutableTransformState;
                        exitTransitionImpl3 = (ExitTransitionImpl) mutableState2.getValue();
                        mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function2, gapComposer);
                        objInvoke = function2.invoke(tagPayloadReader2.getCurrentState(), parcelableSnapshotMutableState3.getValue());
                        zChanged5 = gapComposer.changed(transitionInstance) | gapComposer.changed(mutableStateRememberUpdatedState);
                        objRememberedValue9 = gapComposer.rememberedValue();
                        if (zChanged5) {
                            objRememberedValue9 = new RealImageLoader.AnonymousClass2(transitionInstance, mutableStateRememberUpdatedState, null, (byte) 1);
                            gapComposer.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new RealImageLoader.AnonymousClass2(transitionInstance, mutableStateRememberUpdatedState, null, (byte) 1);
                            gapComposer.updateRememberedValue(objRememberedValue9);
                        }
                        function3 = (Function2) objRememberedValue9;
                        objRememberedValue10 = gapComposer.rememberedValue();
                        if (objRememberedValue10 == neverEqualPolicy) {
                            objRememberedValue10 = Stack.mutableStateOf$default(objInvoke);
                            gapComposer.updateRememberedValue(objRememberedValue10);
                        }
                        mutableState3 = (MutableState) objRememberedValue10;
                        zChangedInstance2 = gapComposer.changedInstance(function3);
                        objRememberedValue11 = gapComposer.rememberedValue();
                        if (zChangedInstance2) {
                            objRememberedValue11 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function3, mutableState3, null, (byte) 0);
                            gapComposer.updateRememberedValue(objRememberedValue11);
                        } else {
                            objRememberedValue11 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function3, mutableState3, null, (byte) 0);
                            gapComposer.updateRememberedValue(objRememberedValue11);
                        }
                        Stack.LaunchedEffect(gapComposer, Unit.INSTANCE, (Function2) objRememberedValue11);
                        if (tagPayloadReader2.getCurrentState() != enterExitState) {
                            gapComposer.startReplaceGroup(248647379);
                            if (i4 == 4) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            objRememberedValue12 = gapComposer.rememberedValue();
                            if (z11) {
                                objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                                gapComposer.updateRememberedValue(objRememberedValue12);
                            } else {
                                objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                                gapComposer.updateRememberedValue(objRememberedValue12);
                            }
                            animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) objRememberedValue12;
                            twoWayConverterImpl = ArcSplineKt.IntOffsetToVector;
                            objRememberedValue13 = gapComposer.rememberedValue();
                            if (objRememberedValue13 == neverEqualPolicy) {
                                objRememberedValue13 = new ScrollKt$$ExternalSyntheticLambda0((byte) 7);
                                gapComposer.updateRememberedValue(objRememberedValue13);
                            }
                            function0 = (Function0) objRememberedValue13;
                            gapComposer.startReplaceGroup(1018346543);
                            gapComposer.end(false);
                            gapComposer.startReplaceGroup(1018554181);
                            gapComposer.end(false);
                            gapComposer.startReplaceGroup(1018736678);
                            gapComposer.end(false);
                            enterExitTransitionConfig = enterTransitionImpl2.config;
                            changeSizeConfig3 = enterExitTransitionConfig.changeSize;
                            veilConfig3 = enterExitTransitionConfig.veil;
                            if (veilConfig3 == null) {
                                enterExitTransitionConfig2 = enterExitTransitionConfig;
                                transitionInstance2 = transitionInstance;
                                changeSizeConfig4 = changeSizeConfig3;
                                z12 = true;
                            } else {
                                enterExitTransitionConfig2 = enterExitTransitionConfig;
                                transitionInstance2 = transitionInstance;
                                changeSizeConfig4 = changeSizeConfig3;
                                z12 = true;
                            }
                            enterExitTransitionConfig3 = enterExitTransitionConfig2;
                            if (enterExitTransitionConfig3.slide == null) {
                                sharedMutableTransformState2 = sharedMutableTransformState;
                                z13 = true;
                            } else {
                                sharedMutableTransformState2 = sharedMutableTransformState;
                                z13 = true;
                            }
                            if (changeSizeConfig4 == null) {
                                z14 = true;
                            } else {
                                z14 = true;
                            }
                            if (z13) {
                                gapComposer.startReplaceGroup(1019286587);
                                objRememberedValue22 = gapComposer.rememberedValue();
                                if (objRememberedValue22 == neverEqualPolicy) {
                                    objRememberedValue22 = "Built-in slide";
                                    gapComposer.updateRememberedValue("Built-in slide");
                                }
                                String str4 = (String) objRememberedValue22;
                                neverEqualPolicy2 = neverEqualPolicy;
                                transitionInstance3 = transitionInstance2;
                                Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation17 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl, str4, gapComposer, 384, 0);
                                twoWayConverterImpl2 = twoWayConverterImpl;
                                gapComposer.end(false);
                                deferredAnimation = deferredAnimationCreateDeferredAnimation17;
                            } else {
                                twoWayConverterImpl2 = twoWayConverterImpl;
                                neverEqualPolicy2 = neverEqualPolicy;
                                transitionInstance3 = transitionInstance2;
                                gapComposer.startReplaceGroup(1019392390);
                                gapComposer.end(false);
                                deferredAnimation = null;
                            }
                            if (z14) {
                                gapComposer.startReplaceGroup(1019484181);
                                TwoWayConverterImpl twoWayConverterImpl10 = ArcSplineKt.IntSizeToVector;
                                objRememberedValue21 = gapComposer.rememberedValue();
                                if (objRememberedValue21 == neverEqualPolicy2) {
                                    objRememberedValue21 = "Built-in shrink/expand";
                                    gapComposer.updateRememberedValue("Built-in shrink/expand");
                                }
                                Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation18 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl10, (String) objRememberedValue21, gapComposer, 384, 0);
                                gapComposer.end(false);
                                deferredAnimation2 = deferredAnimationCreateDeferredAnimation18;
                            } else {
                                gapComposer.startReplaceGroup(1019595005);
                                gapComposer.end(false);
                                deferredAnimation2 = null;
                            }
                            if (z14) {
                                gapComposer.startReplaceGroup(1019668631);
                                objRememberedValue20 = gapComposer.rememberedValue();
                                if (objRememberedValue20 == neverEqualPolicy2) {
                                    objRememberedValue20 = "Built-in InterruptionHandlingOffset";
                                    gapComposer.updateRememberedValue("Built-in InterruptionHandlingOffset");
                                }
                                Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation19 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl2, (String) objRememberedValue20, gapComposer, 384, 0);
                                gapComposer.end(false);
                                deferredAnimation3 = deferredAnimationCreateDeferredAnimation19;
                            } else {
                                gapComposer.startReplaceGroup(1019839037);
                                gapComposer.end(false);
                                deferredAnimation3 = null;
                            }
                            if (changeSizeConfig4 == 0) {
                            }
                            if (veilConfig3 != 0) {
                                if (veilConfig3 != 0) {
                                    colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                                } else {
                                    veilConfig4 = exitTransitionImpl3.config.veil;
                                    if (veilConfig4 != null) {
                                        colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                                    } else {
                                        colorSpaceM483getColorSpaceimpl = null;
                                    }
                                    if (colorSpaceM483getColorSpaceimpl == null) {
                                        veilConfig5 = exitTransitionImpl3.config.veil;
                                        if (veilConfig5 != null) {
                                            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                        } else {
                                            colorSpaceM483getColorSpaceimpl = null;
                                        }
                                        if (colorSpaceM483getColorSpaceimpl == null) {
                                            colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                        }
                                    }
                                }
                            } else if (veilConfig3 != 0) {
                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                            } else {
                                veilConfig4 = exitTransitionImpl3.config.veil;
                                if (veilConfig4 != null) {
                                    colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                                } else {
                                    colorSpaceM483getColorSpaceimpl = null;
                                }
                                if (colorSpaceM483getColorSpaceimpl == null) {
                                    veilConfig5 = exitTransitionImpl3.config.veil;
                                    if (veilConfig5 != null) {
                                        colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                    } else {
                                        colorSpaceM483getColorSpaceimpl = null;
                                    }
                                    if (colorSpaceM483getColorSpaceimpl == null) {
                                        colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                    }
                                }
                            }
                            companion = Modifier.Companion.$$INSTANCE;
                            if (z12) {
                                gapComposer.startReplaceGroup(1020378035);
                                CallsKt$await$2$1 callsKt$await$2$4 = new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl);
                                companion2 = companion;
                                TwoWayConverterImpl twoWayConverterImpl11 = new TwoWayConverterImpl(ColorVectorConverterKt$ColorToVector$1$1.INSTANCE, callsKt$await$2$4);
                                objRememberedValue19 = gapComposer.rememberedValue();
                                if (objRememberedValue19 == neverEqualPolicy2) {
                                    objRememberedValue19 = "Built-in veil";
                                    gapComposer.updateRememberedValue("Built-in veil");
                                }
                                VeilModifierElement veilModifierElement4 = new VeilModifierElement(transitionInstance3, ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl11, (String) objRememberedValue19, gapComposer, 384, 0), enterTransitionImpl2, exitTransitionImpl3, sharedMutableTransformState2);
                                exitTransitionImpl4 = exitTransitionImpl3;
                                gapComposer.end(false);
                                modifier3 = veilModifierElement4;
                            } else {
                                exitTransitionImpl4 = exitTransitionImpl3;
                                companion2 = companion;
                                gapComposer.startReplaceGroup(1020676162);
                                gapComposer.end(false);
                                modifier3 = companion2;
                            }
                            if (veilConfig3 != 0) {
                                zBooleanValue = veilConfig3.matchParentSize;
                            } else {
                                veilConfig6 = exitTransitionImpl4.config.veil;
                                if (veilConfig6 != null) {
                                    zBooleanValue = veilConfig6.matchParentSize;
                                } else {
                                    if (sharedMutableTransformState2.mutableData != null) {
                                        bool = Boolean.FALSE;
                                    } else {
                                        bool = null;
                                    }
                                    if (bool != null) {
                                        zBooleanValue = bool.booleanValue();
                                    } else {
                                        zBooleanValue = false;
                                    }
                                }
                            }
                            twoWayConverterImpl3 = ArcSplineKt.FloatToVector;
                            if (enterExitTransitionConfig3.fade != null) {
                                z16 = true;
                            } else {
                                z16 = true;
                            }
                            if (enterExitTransitionConfig3.scale != null) {
                                z17 = true;
                            } else {
                                z17 = true;
                            }
                            if (z16) {
                                gapComposer.startReplaceGroup(-1511857635);
                                objRememberedValue18 = gapComposer.rememberedValue();
                                if (objRememberedValue18 == neverEqualPolicy2) {
                                    objRememberedValue18 = "Built-in alpha";
                                    gapComposer.updateRememberedValue("Built-in alpha");
                                }
                                Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation110 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue18, gapComposer, 384, 0);
                                gapComposer.end(false);
                                deferredAnimation4 = deferredAnimationCreateDeferredAnimation110;
                            } else {
                                gapComposer.startReplaceGroup(-1511688190);
                                gapComposer.end(false);
                                deferredAnimation4 = null;
                            }
                            if (z17) {
                                gapComposer.startReplaceGroup(-1511620547);
                                objRememberedValue17 = gapComposer.rememberedValue();
                                if (objRememberedValue17 == neverEqualPolicy2) {
                                    objRememberedValue17 = "Built-in scale";
                                    gapComposer.updateRememberedValue("Built-in scale");
                                }
                                Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation111 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue17, gapComposer, 384, 0);
                                z18 = false;
                                gapComposer.end(false);
                                deferredAnimation5 = deferredAnimationCreateDeferredAnimation111;
                            } else {
                                z18 = false;
                                gapComposer.startReplaceGroup(-1511451102);
                                gapComposer.end(false);
                                deferredAnimation5 = null;
                            }
                            if (z17) {
                                gapComposer.startReplaceGroup(-1511373446);
                                deferredAnimationCreateDeferredAnimation = ArcSplineKt.createDeferredAnimation(transitionInstance3, EnterExitTransitionKt.TransformOriginVectorConverter, "TransformOriginInterruptionHandling", gapComposer, 384, 0);
                                gapComposer.end(z18);
                            } else {
                                gapComposer.startReplaceGroup(-1511201118);
                                gapComposer.end(z18);
                                deferredAnimationCreateDeferredAnimation = null;
                            }
                            zChangedInstance3 = gapComposer.changedInstance(deferredAnimation4) | gapComposer.changed(enterTransitionImpl2) | gapComposer.changed(exitTransitionImpl4) | gapComposer.changedInstance(sharedMutableTransformState2) | gapComposer.changedInstance(deferredAnimation5) | gapComposer.changed(transitionInstance3) | gapComposer.changedInstance(deferredAnimationCreateDeferredAnimation);
                            objRememberedValue14 = gapComposer.rememberedValue();
                            if (zChangedInstance3) {
                                SharedMutableTransformState sharedMutableTransformState9 = sharedMutableTransformState2;
                                exitTransitionImpl5 = exitTransitionImpl4;
                                objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState9, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                                sharedMutableTransformState3 = sharedMutableTransformState9;
                                gapComposer.updateRememberedValue(objRememberedValue14);
                            } else {
                                SharedMutableTransformState sharedMutableTransformState10 = sharedMutableTransformState2;
                                exitTransitionImpl5 = exitTransitionImpl4;
                                objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState10, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                                sharedMutableTransformState3 = sharedMutableTransformState10;
                                gapComposer.updateRememberedValue(objRememberedValue14);
                            }
                            EnterExitTransitionKt$$ExternalSyntheticLambda7 enterExitTransitionKt$$ExternalSyntheticLambda10 = (EnterExitTransitionKt$$ExternalSyntheticLambda7) objRememberedValue14;
                            if (zBooleanValue != 0) {
                                modifier4 = modifier3;
                            } else {
                                modifier4 = companion2;
                            }
                            zChanged6 = gapComposer.changed(z15) | gapComposer.changed(function0);
                            objRememberedValue15 = gapComposer.rememberedValue();
                            if (zChanged6) {
                                objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                                gapComposer.updateRememberedValue(objRememberedValue15);
                            } else {
                                objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                                gapComposer.updateRememberedValue(objRememberedValue15);
                            }
                            Modifier modifierThen10 = modifier4.then(ColorKt.graphicsLayer(companion2, (Function1) objRememberedValue15)).then(new EnterExitTransitionElement(transitionInstance3, deferredAnimation2, deferredAnimation3, deferredAnimation, enterTransitionImpl2, exitTransitionImpl5, sharedMutableTransformState3, function0, enterExitTransitionKt$$ExternalSyntheticLambda10));
                            if (zBooleanValue) {
                                modifier5 = modifier3;
                            } else {
                                modifier5 = companion2;
                            }
                            Modifier modifierThen11 = modifierThen10.then(modifier5);
                            gapComposer.startReplaceGroup(-130485473);
                            gapComposer.end(false);
                            modifier2 = modifier;
                            Modifier modifierThen12 = modifier2.then(modifierThen11.then(companion2));
                            objRememberedValue16 = gapComposer.rememberedValue();
                            if (objRememberedValue16 == neverEqualPolicy2) {
                                objRememberedValue16 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                                gapComposer.updateRememberedValue(objRememberedValue16);
                            }
                            AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy4 = (AnimatedEnterExitMeasurePolicy) objRememberedValue16;
                            int iHashCode4 = Long.hashCode(gapComposer.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen12);
                            ComposeUiNode.Companion.getClass();
                            gapComposer.startReusableNode();
                            if (gapComposer.inserting) {
                                gapComposer.createNode(LayoutNode.Constructor);
                            } else {
                                gapComposer.useNode();
                            }
                            Stack.m390setimpl(gapComposer, animatedEnterExitMeasurePolicy4, ComposeUiNode.Companion.SetMeasurePolicy);
                            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                            Stack.m386initimpl(gapComposer, Integer.valueOf(iHashCode4));
                            Stack.m389reconcileimpl(gapComposer);
                            Stack.m390setimpl(gapComposer, modifierMaterializeModifier4, ComposeUiNode.Companion.SetModifier);
                            ComposableLambdaImpl composableLambdaImpl9 = composableLambdaImpl;
                            composableLambdaImpl9.invoke(animatedVisibilityScopeImpl, gapComposer, Integer.valueOf((i3 >> 24) & 112));
                            gapComposer.end(true);
                            z19 = false;
                            gapComposer.end(false);
                            composableLambdaImpl3 = composableLambdaImpl9;
                        } else {
                            gapComposer.startReplaceGroup(248647379);
                            if (i4 == 4) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            objRememberedValue12 = gapComposer.rememberedValue();
                            if (z11) {
                                objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                                gapComposer.updateRememberedValue(objRememberedValue12);
                            } else {
                                objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                                gapComposer.updateRememberedValue(objRememberedValue12);
                            }
                            animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) objRememberedValue12;
                            twoWayConverterImpl = ArcSplineKt.IntOffsetToVector;
                            objRememberedValue13 = gapComposer.rememberedValue();
                            if (objRememberedValue13 == neverEqualPolicy) {
                                objRememberedValue13 = new ScrollKt$$ExternalSyntheticLambda0((byte) 7);
                                gapComposer.updateRememberedValue(objRememberedValue13);
                            }
                            function0 = (Function0) objRememberedValue13;
                            gapComposer.startReplaceGroup(1018346543);
                            gapComposer.end(false);
                            gapComposer.startReplaceGroup(1018554181);
                            gapComposer.end(false);
                            gapComposer.startReplaceGroup(1018736678);
                            gapComposer.end(false);
                            enterExitTransitionConfig = enterTransitionImpl2.config;
                            changeSizeConfig3 = enterExitTransitionConfig.changeSize;
                            veilConfig3 = enterExitTransitionConfig.veil;
                            if (veilConfig3 == null) {
                                enterExitTransitionConfig2 = enterExitTransitionConfig;
                                transitionInstance2 = transitionInstance;
                                changeSizeConfig4 = changeSizeConfig3;
                                z12 = true;
                            } else {
                                enterExitTransitionConfig2 = enterExitTransitionConfig;
                                transitionInstance2 = transitionInstance;
                                changeSizeConfig4 = changeSizeConfig3;
                                z12 = true;
                            }
                            enterExitTransitionConfig3 = enterExitTransitionConfig2;
                            if (enterExitTransitionConfig3.slide == null) {
                                sharedMutableTransformState2 = sharedMutableTransformState;
                                z13 = true;
                            } else {
                                sharedMutableTransformState2 = sharedMutableTransformState;
                                z13 = true;
                            }
                            if (changeSizeConfig4 == null) {
                                z14 = true;
                            } else {
                                z14 = true;
                            }
                            if (z13) {
                                gapComposer.startReplaceGroup(1019286587);
                                objRememberedValue22 = gapComposer.rememberedValue();
                                if (objRememberedValue22 == neverEqualPolicy) {
                                    objRememberedValue22 = "Built-in slide";
                                    gapComposer.updateRememberedValue("Built-in slide");
                                }
                                String str5 = (String) objRememberedValue22;
                                neverEqualPolicy2 = neverEqualPolicy;
                                transitionInstance3 = transitionInstance2;
                                Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation112 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl, str5, gapComposer, 384, 0);
                                twoWayConverterImpl2 = twoWayConverterImpl;
                                gapComposer.end(false);
                                deferredAnimation = deferredAnimationCreateDeferredAnimation112;
                            } else {
                                twoWayConverterImpl2 = twoWayConverterImpl;
                                neverEqualPolicy2 = neverEqualPolicy;
                                transitionInstance3 = transitionInstance2;
                                gapComposer.startReplaceGroup(1019392390);
                                gapComposer.end(false);
                                deferredAnimation = null;
                            }
                            if (z14) {
                                gapComposer.startReplaceGroup(1019484181);
                                TwoWayConverterImpl twoWayConverterImpl12 = ArcSplineKt.IntSizeToVector;
                                objRememberedValue21 = gapComposer.rememberedValue();
                                if (objRememberedValue21 == neverEqualPolicy2) {
                                    objRememberedValue21 = "Built-in shrink/expand";
                                    gapComposer.updateRememberedValue("Built-in shrink/expand");
                                }
                                Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation113 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl12, (String) objRememberedValue21, gapComposer, 384, 0);
                                gapComposer.end(false);
                                deferredAnimation2 = deferredAnimationCreateDeferredAnimation113;
                            } else {
                                gapComposer.startReplaceGroup(1019595005);
                                gapComposer.end(false);
                                deferredAnimation2 = null;
                            }
                            if (z14) {
                                gapComposer.startReplaceGroup(1019668631);
                                objRememberedValue20 = gapComposer.rememberedValue();
                                if (objRememberedValue20 == neverEqualPolicy2) {
                                    objRememberedValue20 = "Built-in InterruptionHandlingOffset";
                                    gapComposer.updateRememberedValue("Built-in InterruptionHandlingOffset");
                                }
                                Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation114 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl2, (String) objRememberedValue20, gapComposer, 384, 0);
                                gapComposer.end(false);
                                deferredAnimation3 = deferredAnimationCreateDeferredAnimation114;
                            } else {
                                gapComposer.startReplaceGroup(1019839037);
                                gapComposer.end(false);
                                deferredAnimation3 = null;
                            }
                            if (changeSizeConfig4 == 0) {
                            }
                            if (veilConfig3 != 0) {
                                if (veilConfig3 != 0) {
                                    colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                                } else {
                                    veilConfig4 = exitTransitionImpl3.config.veil;
                                    if (veilConfig4 != null) {
                                        colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                                    } else {
                                        colorSpaceM483getColorSpaceimpl = null;
                                    }
                                    if (colorSpaceM483getColorSpaceimpl == null) {
                                        veilConfig5 = exitTransitionImpl3.config.veil;
                                        if (veilConfig5 != null) {
                                            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                        } else {
                                            colorSpaceM483getColorSpaceimpl = null;
                                        }
                                        if (colorSpaceM483getColorSpaceimpl == null) {
                                            colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                        }
                                    }
                                }
                            } else if (veilConfig3 != 0) {
                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                            } else {
                                veilConfig4 = exitTransitionImpl3.config.veil;
                                if (veilConfig4 != null) {
                                    colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                                } else {
                                    colorSpaceM483getColorSpaceimpl = null;
                                }
                                if (colorSpaceM483getColorSpaceimpl == null) {
                                    veilConfig5 = exitTransitionImpl3.config.veil;
                                    if (veilConfig5 != null) {
                                        colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                    } else {
                                        colorSpaceM483getColorSpaceimpl = null;
                                    }
                                    if (colorSpaceM483getColorSpaceimpl == null) {
                                        colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                    }
                                }
                            }
                            companion = Modifier.Companion.$$INSTANCE;
                            if (z12) {
                                gapComposer.startReplaceGroup(1020378035);
                                CallsKt$await$2$1 callsKt$await$2$5 = new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl);
                                companion2 = companion;
                                TwoWayConverterImpl twoWayConverterImpl13 = new TwoWayConverterImpl(ColorVectorConverterKt$ColorToVector$1$1.INSTANCE, callsKt$await$2$5);
                                objRememberedValue19 = gapComposer.rememberedValue();
                                if (objRememberedValue19 == neverEqualPolicy2) {
                                    objRememberedValue19 = "Built-in veil";
                                    gapComposer.updateRememberedValue("Built-in veil");
                                }
                                VeilModifierElement veilModifierElement5 = new VeilModifierElement(transitionInstance3, ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl13, (String) objRememberedValue19, gapComposer, 384, 0), enterTransitionImpl2, exitTransitionImpl3, sharedMutableTransformState2);
                                exitTransitionImpl4 = exitTransitionImpl3;
                                gapComposer.end(false);
                                modifier3 = veilModifierElement5;
                            } else {
                                exitTransitionImpl4 = exitTransitionImpl3;
                                companion2 = companion;
                                gapComposer.startReplaceGroup(1020676162);
                                gapComposer.end(false);
                                modifier3 = companion2;
                            }
                            if (veilConfig3 != 0) {
                                zBooleanValue = veilConfig3.matchParentSize;
                            } else {
                                veilConfig6 = exitTransitionImpl4.config.veil;
                                if (veilConfig6 != null) {
                                    zBooleanValue = veilConfig6.matchParentSize;
                                } else {
                                    if (sharedMutableTransformState2.mutableData != null) {
                                        bool = Boolean.FALSE;
                                    } else {
                                        bool = null;
                                    }
                                    if (bool != null) {
                                        zBooleanValue = bool.booleanValue();
                                    } else {
                                        zBooleanValue = false;
                                    }
                                }
                            }
                            twoWayConverterImpl3 = ArcSplineKt.FloatToVector;
                            if (enterExitTransitionConfig3.fade != null) {
                                z16 = true;
                            } else {
                                z16 = true;
                            }
                            if (enterExitTransitionConfig3.scale != null) {
                                z17 = true;
                            } else {
                                z17 = true;
                            }
                            if (z16) {
                                gapComposer.startReplaceGroup(-1511857635);
                                objRememberedValue18 = gapComposer.rememberedValue();
                                if (objRememberedValue18 == neverEqualPolicy2) {
                                    objRememberedValue18 = "Built-in alpha";
                                    gapComposer.updateRememberedValue("Built-in alpha");
                                }
                                Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation115 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue18, gapComposer, 384, 0);
                                gapComposer.end(false);
                                deferredAnimation4 = deferredAnimationCreateDeferredAnimation115;
                            } else {
                                gapComposer.startReplaceGroup(-1511688190);
                                gapComposer.end(false);
                                deferredAnimation4 = null;
                            }
                            if (z17) {
                                gapComposer.startReplaceGroup(-1511620547);
                                objRememberedValue17 = gapComposer.rememberedValue();
                                if (objRememberedValue17 == neverEqualPolicy2) {
                                    objRememberedValue17 = "Built-in scale";
                                    gapComposer.updateRememberedValue("Built-in scale");
                                }
                                Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation116 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue17, gapComposer, 384, 0);
                                z18 = false;
                                gapComposer.end(false);
                                deferredAnimation5 = deferredAnimationCreateDeferredAnimation116;
                            } else {
                                z18 = false;
                                gapComposer.startReplaceGroup(-1511451102);
                                gapComposer.end(false);
                                deferredAnimation5 = null;
                            }
                            if (z17) {
                                gapComposer.startReplaceGroup(-1511373446);
                                deferredAnimationCreateDeferredAnimation = ArcSplineKt.createDeferredAnimation(transitionInstance3, EnterExitTransitionKt.TransformOriginVectorConverter, "TransformOriginInterruptionHandling", gapComposer, 384, 0);
                                gapComposer.end(z18);
                            } else {
                                gapComposer.startReplaceGroup(-1511201118);
                                gapComposer.end(z18);
                                deferredAnimationCreateDeferredAnimation = null;
                            }
                            zChangedInstance3 = gapComposer.changedInstance(deferredAnimation4) | gapComposer.changed(enterTransitionImpl2) | gapComposer.changed(exitTransitionImpl4) | gapComposer.changedInstance(sharedMutableTransformState2) | gapComposer.changedInstance(deferredAnimation5) | gapComposer.changed(transitionInstance3) | gapComposer.changedInstance(deferredAnimationCreateDeferredAnimation);
                            objRememberedValue14 = gapComposer.rememberedValue();
                            if (zChangedInstance3) {
                                SharedMutableTransformState sharedMutableTransformState11 = sharedMutableTransformState2;
                                exitTransitionImpl5 = exitTransitionImpl4;
                                objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState11, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                                sharedMutableTransformState3 = sharedMutableTransformState11;
                                gapComposer.updateRememberedValue(objRememberedValue14);
                            } else {
                                SharedMutableTransformState sharedMutableTransformState12 = sharedMutableTransformState2;
                                exitTransitionImpl5 = exitTransitionImpl4;
                                objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState12, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                                sharedMutableTransformState3 = sharedMutableTransformState12;
                                gapComposer.updateRememberedValue(objRememberedValue14);
                            }
                            EnterExitTransitionKt$$ExternalSyntheticLambda7 enterExitTransitionKt$$ExternalSyntheticLambda11 = (EnterExitTransitionKt$$ExternalSyntheticLambda7) objRememberedValue14;
                            if (zBooleanValue != 0) {
                                modifier4 = modifier3;
                            } else {
                                modifier4 = companion2;
                            }
                            zChanged6 = gapComposer.changed(z15) | gapComposer.changed(function0);
                            objRememberedValue15 = gapComposer.rememberedValue();
                            if (zChanged6) {
                                objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                                gapComposer.updateRememberedValue(objRememberedValue15);
                            } else {
                                objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                                gapComposer.updateRememberedValue(objRememberedValue15);
                            }
                            Modifier modifierThen13 = modifier4.then(ColorKt.graphicsLayer(companion2, (Function1) objRememberedValue15)).then(new EnterExitTransitionElement(transitionInstance3, deferredAnimation2, deferredAnimation3, deferredAnimation, enterTransitionImpl2, exitTransitionImpl5, sharedMutableTransformState3, function0, enterExitTransitionKt$$ExternalSyntheticLambda11));
                            if (zBooleanValue) {
                                modifier5 = modifier3;
                            } else {
                                modifier5 = companion2;
                            }
                            Modifier modifierThen14 = modifierThen13.then(modifier5);
                            gapComposer.startReplaceGroup(-130485473);
                            gapComposer.end(false);
                            modifier2 = modifier;
                            Modifier modifierThen15 = modifier2.then(modifierThen14.then(companion2));
                            objRememberedValue16 = gapComposer.rememberedValue();
                            if (objRememberedValue16 == neverEqualPolicy2) {
                                objRememberedValue16 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                                gapComposer.updateRememberedValue(objRememberedValue16);
                            }
                            AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy5 = (AnimatedEnterExitMeasurePolicy) objRememberedValue16;
                            int iHashCode5 = Long.hashCode(gapComposer.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen15);
                            ComposeUiNode.Companion.getClass();
                            gapComposer.startReusableNode();
                            if (gapComposer.inserting) {
                                gapComposer.createNode(LayoutNode.Constructor);
                            } else {
                                gapComposer.useNode();
                            }
                            Stack.m390setimpl(gapComposer, animatedEnterExitMeasurePolicy5, ComposeUiNode.Companion.SetMeasurePolicy);
                            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                            Stack.m386initimpl(gapComposer, Integer.valueOf(iHashCode5));
                            Stack.m389reconcileimpl(gapComposer);
                            Stack.m390setimpl(gapComposer, modifierMaterializeModifier5, ComposeUiNode.Companion.SetModifier);
                            ComposableLambdaImpl composableLambdaImpl10 = composableLambdaImpl;
                            composableLambdaImpl10.invoke(animatedVisibilityScopeImpl, gapComposer, Integer.valueOf((i3 >> 24) & 112));
                            gapComposer.end(true);
                            z19 = false;
                            gapComposer.end(false);
                            composableLambdaImpl3 = composableLambdaImpl10;
                        }
                        gapComposer.end(z19);
                        composableLambdaImpl4 = composableLambdaImpl3;
                    } else {
                        i7 = i5;
                    }
                    z7 = true;
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (z7) {
                        objRememberedValue2 = new TransitionInstance(new MutableTransitionState(enterExitStateTargetEnterExit), transition, transition.label + " > EnterExitTransition");
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new TransitionInstance(new MutableTransitionState(enterExitStateTargetEnterExit), transition, transition.label + " > EnterExitTransition");
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    transitionInstance = (TransitionInstance) objRememberedValue2;
                    zChanged = ((i6 <= 4 && gapComposer.changed(transition)) || (i7 & 6) == 4) | gapComposer.changed(transitionInstance);
                    objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new BackHandlerKt$$ExternalSyntheticLambda2(transition, transitionInstance, (byte) 5);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new BackHandlerKt$$ExternalSyntheticLambda2(transition, transitionInstance, (byte) 5);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    Stack.DisposableEffect(transitionInstance, (Function1) objRememberedValue3, gapComposer);
                    if (transition.isSeeking()) {
                        transitionInstance.seek(enterExitStateTargetEnterExit, enterExitStateTargetEnterExit2);
                    } else {
                        transitionInstance.updateTarget$animation_core(enterExitStateTargetEnterExit2);
                        transitionInstance.isSeeking$delegate.setValue(Boolean.FALSE);
                    }
                    if (transition.isSeeking()) {
                        gapComposer.startReplaceGroup(782386797);
                        value2 = transition.pendingTargetState$delegate.getValue();
                        if (value2 == null) {
                            gapComposer.startReplaceGroup(782437481);
                            gapComposer.end(false);
                            enterExitStateTargetEnterExit3 = null;
                        } else {
                            gapComposer.startReplaceGroup(782437482);
                            gapComposer.startReplaceGroup(-1260162954);
                            enterExitStateTargetEnterExit3 = targetEnterExit(transition, function1, value2, gapComposer);
                            gapComposer.end(false);
                            gapComposer.end(false);
                        }
                        tagPayloadReader3 = transitionInstance.transitionState;
                        parcelableSnapshotMutableState4 = transitionInstance.targetState$delegate;
                        ParcelableSnapshotMutableState parcelableSnapshotMutableState7 = transitionInstance.pendingTargetState$delegate;
                        value3 = parcelableSnapshotMutableState7.getValue();
                        if (value3 == null) {
                            z20 = false;
                        } else {
                            z20 = false;
                        }
                        parcelableSnapshotMutableState7.setValue(enterExitStateTargetEnterExit3);
                        if (z20) {
                            transitionInstance.segment$delegate.setValue(new Transition.SegmentImpl(value3, parcelableSnapshotMutableState4.getValue()));
                            tagPayloadReader3.setCurrentState$animation_core(value3);
                            if (transitionInstance.startTimeNanos$delegate.getLongValue() == Long.MIN_VALUE) {
                                transitionInstance.setUpdateChildrenNeeded(true);
                            }
                            snapshotStateList = transitionInstance._animations;
                            size = snapshotStateList.size();
                            while (i8 < size) {
                                ((Transition.TransitionAnimationState) snapshotStateList.get(i8)).resetSnapValue$delegate.setFloatValue(-2.0f);
                            }
                        }
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(782538635);
                        gapComposer.end(false);
                    }
                    if (i4 == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue4 = gapComposer.rememberedValue();
                    if (z8) {
                        objRememberedValue4 = new SharedMutableTransformState();
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new SharedMutableTransformState();
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    sharedMutableTransformState = (SharedMutableTransformState) objRememberedValue4;
                    if (mutableTransform != null) {
                        sharedMutableTransformState.getClass();
                    }
                    sharedMutableTransformState.mutableData = mutableTransform;
                    SystemBarStyle$Companion$$ExternalSyntheticLambda0 systemBarStyle$Companion$$ExternalSyntheticLambda1 = EnterExitTransitionKt.NeutralSlideOffset;
                    parcelableSnapshotMutableState2 = sharedMutableTransformState.mutationPhase$delegate;
                    gapComposer.startReplaceGroup(-31257052);
                    gapComposer.end(false);
                    if (transitionInstance.pendingTargetState$delegate.getValue() != null) {
                        z9 = false;
                    } else {
                        z9 = false;
                    }
                    if (transitionInstance.transitionState.getCurrentState() == transitionInstance.targetState$delegate.getValue()) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    mutationPhase$animation = sharedMutableTransformState.getMutationPhase$animation();
                    mutationPhase = MutationPhase.MutatingPendingCatchUp;
                    mutationPhase2 = MutationPhase.Mutating;
                    mutationPhase3 = MutationPhase.Handoff;
                    if (z9) {
                        if (mutationPhase$animation != MutationPhase.Idle) {
                            sharedMutableTransformState.transformScope.reset();
                            if (z10) {
                                mutationPhase = mutationPhase2;
                            }
                            parcelableSnapshotMutableState2.setValue(mutationPhase);
                            sharedMutableTransformState.scaleHandoffVelocity = null;
                            sharedMutableTransformState.slideHandoffVelocity = null;
                        } else {
                            sharedMutableTransformState.transformScope.reset();
                            if (z10) {
                                mutationPhase = mutationPhase2;
                            }
                            parcelableSnapshotMutableState2.setValue(mutationPhase);
                            sharedMutableTransformState.scaleHandoffVelocity = null;
                            sharedMutableTransformState.slideHandoffVelocity = null;
                        }
                    } else if (mutationPhase$animation != mutationPhase) {
                        parcelableSnapshotMutableState2.setValue(mutationPhase3);
                        velocityTracker = sharedMutableTransformState.scaleVelocityTracker;
                        fFloatValue = CropImageView.DEFAULT_ASPECT_RATIO;
                        if (velocityTracker != null) {
                            fM819getXimpl2 = Velocity.m819getXimpl(velocityTracker.m595calculateVelocity9UxMQ8M());
                            fValueOf3 = Float.valueOf(fM819getXimpl2);
                            if (Float.isNaN(fM819getXimpl2)) {
                                fValueOf3 = null;
                            }
                            if (fValueOf3 != null) {
                                fFloatValue2 = fValueOf3.floatValue();
                            } else {
                                fFloatValue2 = 0.0f;
                            }
                        } else {
                            fFloatValue2 = 0.0f;
                        }
                        sharedMutableTransformState.scaleHandoffVelocity = new AnimationVector1D(fFloatValue2);
                        fM819getXimpl = Velocity.m819getXimpl(0L);
                        fValueOf = Float.valueOf(fM819getXimpl);
                        if (Float.isNaN(fM819getXimpl)) {
                            fValueOf = null;
                        }
                        if (fValueOf != null) {
                            fFloatValue3 = fValueOf.floatValue();
                        } else {
                            fFloatValue3 = 0.0f;
                        }
                        fM820getYimpl = Velocity.m820getYimpl(0L);
                        fValueOf2 = Float.valueOf(fM820getYimpl);
                        if (Float.isNaN(fM820getYimpl)) {
                            fValueOf2 = null;
                        }
                        if (fValueOf2 != null) {
                            fFloatValue = fValueOf2.floatValue();
                        }
                        sharedMutableTransformState.slideHandoffVelocity = new AnimationVector2D(fFloatValue3, fFloatValue);
                    } else {
                        parcelableSnapshotMutableState2.setValue(mutationPhase3);
                        velocityTracker = sharedMutableTransformState.scaleVelocityTracker;
                        fFloatValue = CropImageView.DEFAULT_ASPECT_RATIO;
                        if (velocityTracker != null) {
                            fM819getXimpl2 = Velocity.m819getXimpl(velocityTracker.m595calculateVelocity9UxMQ8M());
                            fValueOf3 = Float.valueOf(fM819getXimpl2);
                            if (Float.isNaN(fM819getXimpl2)) {
                                fValueOf3 = null;
                            }
                            if (fValueOf3 != null) {
                                fFloatValue2 = fValueOf3.floatValue();
                            } else {
                                fFloatValue2 = 0.0f;
                            }
                        } else {
                            fFloatValue2 = 0.0f;
                        }
                        sharedMutableTransformState.scaleHandoffVelocity = new AnimationVector1D(fFloatValue2);
                        fM819getXimpl = Velocity.m819getXimpl(0L);
                        fValueOf = Float.valueOf(fM819getXimpl);
                        if (Float.isNaN(fM819getXimpl)) {
                            fValueOf = null;
                        }
                        if (fValueOf != null) {
                            fFloatValue3 = fValueOf.floatValue();
                        } else {
                            fFloatValue3 = 0.0f;
                        }
                        fM820getYimpl = Velocity.m820getYimpl(0L);
                        fValueOf2 = Float.valueOf(fM820getYimpl);
                        if (Float.isNaN(fM820getYimpl)) {
                            fValueOf2 = null;
                        }
                        if (fValueOf2 != null) {
                            fFloatValue = fValueOf2.floatValue();
                        }
                        sharedMutableTransformState.slideHandoffVelocity = new AnimationVector2D(fFloatValue3, fFloatValue);
                    }
                    Boolean boolValueOf2 = Boolean.valueOf(z9);
                    zChanged2 = gapComposer.changed(z9) | gapComposer.changed(z10) | gapComposer.changedInstance(sharedMutableTransformState);
                    objRememberedValue5 = gapComposer.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue5 = new EnterExitTransitionKt$trackActiveMutableState$1$1(z9, z10, sharedMutableTransformState, null);
                        gapComposer.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new EnterExitTransitionKt$trackActiveMutableState$1$1(z9, z10, sharedMutableTransformState, null);
                        gapComposer.updateRememberedValue(objRememberedValue5);
                    }
                    Stack.LaunchedEffect(gapComposer, boolValueOf2, (Function2) objRememberedValue5);
                    zChangedInstance = gapComposer.changedInstance(sharedMutableTransformState);
                    objRememberedValue6 = gapComposer.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue6 = new SliderState$$ExternalSyntheticLambda0((byte) 3, sharedMutableTransformState);
                        gapComposer.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new SliderState$$ExternalSyntheticLambda0((byte) 3, sharedMutableTransformState);
                        gapComposer.updateRememberedValue(objRememberedValue6);
                    }
                    EnterExitTransitionKt.DeferredTransitionCleanupEffect(transitionInstance, (Function0) objRememberedValue6, gapComposer, 0);
                    parcelableSnapshotMutableState3 = transitionInstance.targetState$delegate;
                    tagPayloadReader2 = transitionInstance.transitionState;
                    zChanged3 = gapComposer.changed(transitionInstance);
                    objRememberedValue7 = gapComposer.rememberedValue();
                    if (zChanged3) {
                        objRememberedValue7 = Stack.mutableStateOf$default(enterTransitionImpl);
                        gapComposer.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = Stack.mutableStateOf$default(enterTransitionImpl);
                        gapComposer.updateRememberedValue(objRememberedValue7);
                    }
                    mutableState = (MutableState) objRememberedValue7;
                    currentState = tagPayloadReader2.getCurrentState();
                    value = parcelableSnapshotMutableState3.getValue();
                    enterExitState = EnterExitState.PostExit;
                    enterExitState2 = EnterExitState.Visible;
                    if (currentState == value) {
                        if (parcelableSnapshotMutableState3.getValue() != enterExitState) {
                            mutableState.setValue(((EnterTransitionImpl) mutableState.getValue()).plus(EnterTransitionImpl.None.plus(enterTransitionImpl)));
                        }
                    } else if (parcelableSnapshotMutableState3.getValue() != enterExitState) {
                        mutableState.setValue(((EnterTransitionImpl) mutableState.getValue()).plus(EnterTransitionImpl.None.plus(enterTransitionImpl)));
                    }
                    enterTransitionImpl2 = (EnterTransitionImpl) mutableState.getValue();
                    zChanged4 = gapComposer.changed(transitionInstance);
                    objRememberedValue8 = gapComposer.rememberedValue();
                    if (zChanged4) {
                        objRememberedValue8 = Stack.mutableStateOf$default(exitTransitionImpl);
                        gapComposer.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = Stack.mutableStateOf$default(exitTransitionImpl);
                        gapComposer.updateRememberedValue(objRememberedValue8);
                    }
                    mutableState2 = (MutableState) objRememberedValue8;
                    if (tagPayloadReader2.getCurrentState() == parcelableSnapshotMutableState3.getValue()) {
                        if (parcelableSnapshotMutableState3.getValue() != enterExitState2) {
                            if (sharedMutableTransformState.isMutating()) {
                                exitTransitionImpl2 = (ExitTransitionImpl) mutableState2.getValue();
                            } else {
                                EnterExitTransitionConfig enterExitTransitionConfig5 = ((ExitTransitionImpl) mutableState2.getValue()).config;
                                fadeConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.fade;
                                if (fadeConfig != null) {
                                    fadeConfig2 = new FadeConfig(1.0f, fadeConfig.animationSpec);
                                } else {
                                    fadeConfig2 = null;
                                }
                                scaleConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.scale;
                                if (scaleConfig != null) {
                                    scaleConfig2 = new ScaleConfig(1.0f, scaleConfig.transformOrigin, scaleConfig.animationSpec);
                                } else {
                                    scaleConfig2 = null;
                                }
                                slideConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.slide;
                                if (slideConfig != null) {
                                    slideConfig2 = new SlideConfig(EnterExitTransitionKt.NeutralSlideOffset, slideConfig.animationSpec);
                                } else {
                                    slideConfig2 = null;
                                }
                                changeSizeConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.changeSize;
                                if (changeSizeConfig != null) {
                                    changeSizeConfig2 = new ChangeSizeConfig(changeSizeConfig.alignment, EnterExitTransitionKt.NeutralChangeSize, changeSizeConfig.animationSpec, changeSizeConfig.clip);
                                } else {
                                    changeSizeConfig2 = null;
                                }
                                veilConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.veil;
                                if (veilConfig != null) {
                                    long j2 = veilConfig.initialColor;
                                    veilConfig2 = new VeilConfig(j2, j2, veilConfig.animationSpec, veilConfig.matchParentSize);
                                } else {
                                    veilConfig2 = null;
                                }
                                exitTransitionImpl2 = new ExitTransitionImpl(new EnterExitTransitionConfig(fadeConfig2, slideConfig2, changeSizeConfig2, scaleConfig2, veilConfig2, enterExitTransitionConfig5.hold, enterExitTransitionConfig5.effectsMap));
                            }
                            mutableState2.setValue(exitTransitionImpl2.plus(ExitTransitionImpl.None).plus(exitTransitionImpl));
                        } else {
                            sharedMutableTransformState = sharedMutableTransformState;
                        }
                    } else if (parcelableSnapshotMutableState3.getValue() != enterExitState2) {
                        if (sharedMutableTransformState.isMutating()) {
                            exitTransitionImpl2 = (ExitTransitionImpl) mutableState2.getValue();
                        } else {
                            EnterExitTransitionConfig enterExitTransitionConfig6 = ((ExitTransitionImpl) mutableState2.getValue()).config;
                            fadeConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.fade;
                            if (fadeConfig != null) {
                                fadeConfig2 = new FadeConfig(1.0f, fadeConfig.animationSpec);
                            } else {
                                fadeConfig2 = null;
                            }
                            scaleConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.scale;
                            if (scaleConfig != null) {
                                scaleConfig2 = new ScaleConfig(1.0f, scaleConfig.transformOrigin, scaleConfig.animationSpec);
                            } else {
                                scaleConfig2 = null;
                            }
                            slideConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.slide;
                            if (slideConfig != null) {
                                slideConfig2 = new SlideConfig(EnterExitTransitionKt.NeutralSlideOffset, slideConfig.animationSpec);
                            } else {
                                slideConfig2 = null;
                            }
                            changeSizeConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.changeSize;
                            if (changeSizeConfig != null) {
                                changeSizeConfig2 = new ChangeSizeConfig(changeSizeConfig.alignment, EnterExitTransitionKt.NeutralChangeSize, changeSizeConfig.animationSpec, changeSizeConfig.clip);
                            } else {
                                changeSizeConfig2 = null;
                            }
                            veilConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.veil;
                            if (veilConfig != null) {
                                long j3 = veilConfig.initialColor;
                                veilConfig2 = new VeilConfig(j3, j3, veilConfig.animationSpec, veilConfig.matchParentSize);
                            } else {
                                veilConfig2 = null;
                            }
                            exitTransitionImpl2 = new ExitTransitionImpl(new EnterExitTransitionConfig(fadeConfig2, slideConfig2, changeSizeConfig2, scaleConfig2, veilConfig2, enterExitTransitionConfig6.hold, enterExitTransitionConfig6.effectsMap));
                        }
                        mutableState2.setValue(exitTransitionImpl2.plus(ExitTransitionImpl.None).plus(exitTransitionImpl));
                    } else {
                        sharedMutableTransformState = sharedMutableTransformState;
                    }
                    exitTransitionImpl3 = (ExitTransitionImpl) mutableState2.getValue();
                    mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function2, gapComposer);
                    objInvoke = function2.invoke(tagPayloadReader2.getCurrentState(), parcelableSnapshotMutableState3.getValue());
                    zChanged5 = gapComposer.changed(transitionInstance) | gapComposer.changed(mutableStateRememberUpdatedState);
                    objRememberedValue9 = gapComposer.rememberedValue();
                    if (zChanged5) {
                        objRememberedValue9 = new RealImageLoader.AnonymousClass2(transitionInstance, mutableStateRememberUpdatedState, null, (byte) 1);
                        gapComposer.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new RealImageLoader.AnonymousClass2(transitionInstance, mutableStateRememberUpdatedState, null, (byte) 1);
                        gapComposer.updateRememberedValue(objRememberedValue9);
                    }
                    function3 = (Function2) objRememberedValue9;
                    objRememberedValue10 = gapComposer.rememberedValue();
                    if (objRememberedValue10 == neverEqualPolicy) {
                        objRememberedValue10 = Stack.mutableStateOf$default(objInvoke);
                        gapComposer.updateRememberedValue(objRememberedValue10);
                    }
                    mutableState3 = (MutableState) objRememberedValue10;
                    zChangedInstance2 = gapComposer.changedInstance(function3);
                    objRememberedValue11 = gapComposer.rememberedValue();
                    if (zChangedInstance2) {
                        objRememberedValue11 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function3, mutableState3, null, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue11);
                    } else {
                        objRememberedValue11 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function3, mutableState3, null, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue11);
                    }
                    Stack.LaunchedEffect(gapComposer, Unit.INSTANCE, (Function2) objRememberedValue11);
                    if (tagPayloadReader2.getCurrentState() != enterExitState) {
                        gapComposer.startReplaceGroup(248647379);
                        if (i4 == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        objRememberedValue12 = gapComposer.rememberedValue();
                        if (z11) {
                            objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                            gapComposer.updateRememberedValue(objRememberedValue12);
                        } else {
                            objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                            gapComposer.updateRememberedValue(objRememberedValue12);
                        }
                        animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) objRememberedValue12;
                        twoWayConverterImpl = ArcSplineKt.IntOffsetToVector;
                        objRememberedValue13 = gapComposer.rememberedValue();
                        if (objRememberedValue13 == neverEqualPolicy) {
                            objRememberedValue13 = new ScrollKt$$ExternalSyntheticLambda0((byte) 7);
                            gapComposer.updateRememberedValue(objRememberedValue13);
                        }
                        function0 = (Function0) objRememberedValue13;
                        gapComposer.startReplaceGroup(1018346543);
                        gapComposer.end(false);
                        gapComposer.startReplaceGroup(1018554181);
                        gapComposer.end(false);
                        gapComposer.startReplaceGroup(1018736678);
                        gapComposer.end(false);
                        enterExitTransitionConfig = enterTransitionImpl2.config;
                        changeSizeConfig3 = enterExitTransitionConfig.changeSize;
                        veilConfig3 = enterExitTransitionConfig.veil;
                        if (veilConfig3 == null) {
                            enterExitTransitionConfig2 = enterExitTransitionConfig;
                            transitionInstance2 = transitionInstance;
                            changeSizeConfig4 = changeSizeConfig3;
                            z12 = true;
                        } else {
                            enterExitTransitionConfig2 = enterExitTransitionConfig;
                            transitionInstance2 = transitionInstance;
                            changeSizeConfig4 = changeSizeConfig3;
                            z12 = true;
                        }
                        enterExitTransitionConfig3 = enterExitTransitionConfig2;
                        if (enterExitTransitionConfig3.slide == null) {
                            sharedMutableTransformState2 = sharedMutableTransformState;
                            z13 = true;
                        } else {
                            sharedMutableTransformState2 = sharedMutableTransformState;
                            z13 = true;
                        }
                        if (changeSizeConfig4 == null) {
                            z14 = true;
                        } else {
                            z14 = true;
                        }
                        if (z13) {
                            gapComposer.startReplaceGroup(1019286587);
                            objRememberedValue22 = gapComposer.rememberedValue();
                            if (objRememberedValue22 == neverEqualPolicy) {
                                objRememberedValue22 = "Built-in slide";
                                gapComposer.updateRememberedValue("Built-in slide");
                            }
                            String str6 = (String) objRememberedValue22;
                            neverEqualPolicy2 = neverEqualPolicy;
                            transitionInstance3 = transitionInstance2;
                            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation117 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl, str6, gapComposer, 384, 0);
                            twoWayConverterImpl2 = twoWayConverterImpl;
                            gapComposer.end(false);
                            deferredAnimation = deferredAnimationCreateDeferredAnimation117;
                        } else {
                            twoWayConverterImpl2 = twoWayConverterImpl;
                            neverEqualPolicy2 = neverEqualPolicy;
                            transitionInstance3 = transitionInstance2;
                            gapComposer.startReplaceGroup(1019392390);
                            gapComposer.end(false);
                            deferredAnimation = null;
                        }
                        if (z14) {
                            gapComposer.startReplaceGroup(1019484181);
                            TwoWayConverterImpl twoWayConverterImpl14 = ArcSplineKt.IntSizeToVector;
                            objRememberedValue21 = gapComposer.rememberedValue();
                            if (objRememberedValue21 == neverEqualPolicy2) {
                                objRememberedValue21 = "Built-in shrink/expand";
                                gapComposer.updateRememberedValue("Built-in shrink/expand");
                            }
                            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation118 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl14, (String) objRememberedValue21, gapComposer, 384, 0);
                            gapComposer.end(false);
                            deferredAnimation2 = deferredAnimationCreateDeferredAnimation118;
                        } else {
                            gapComposer.startReplaceGroup(1019595005);
                            gapComposer.end(false);
                            deferredAnimation2 = null;
                        }
                        if (z14) {
                            gapComposer.startReplaceGroup(1019668631);
                            objRememberedValue20 = gapComposer.rememberedValue();
                            if (objRememberedValue20 == neverEqualPolicy2) {
                                objRememberedValue20 = "Built-in InterruptionHandlingOffset";
                                gapComposer.updateRememberedValue("Built-in InterruptionHandlingOffset");
                            }
                            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation119 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl2, (String) objRememberedValue20, gapComposer, 384, 0);
                            gapComposer.end(false);
                            deferredAnimation3 = deferredAnimationCreateDeferredAnimation119;
                        } else {
                            gapComposer.startReplaceGroup(1019839037);
                            gapComposer.end(false);
                            deferredAnimation3 = null;
                        }
                        if (changeSizeConfig4 == 0) {
                        }
                        if (veilConfig3 != 0) {
                            if (veilConfig3 != 0) {
                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                            } else {
                                veilConfig4 = exitTransitionImpl3.config.veil;
                                if (veilConfig4 != null) {
                                    colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                                } else {
                                    colorSpaceM483getColorSpaceimpl = null;
                                }
                                if (colorSpaceM483getColorSpaceimpl == null) {
                                    veilConfig5 = exitTransitionImpl3.config.veil;
                                    if (veilConfig5 != null) {
                                        colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                    } else {
                                        colorSpaceM483getColorSpaceimpl = null;
                                    }
                                    if (colorSpaceM483getColorSpaceimpl == null) {
                                        colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                    }
                                }
                            }
                        } else if (veilConfig3 != 0) {
                            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                        } else {
                            veilConfig4 = exitTransitionImpl3.config.veil;
                            if (veilConfig4 != null) {
                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                            } else {
                                colorSpaceM483getColorSpaceimpl = null;
                            }
                            if (colorSpaceM483getColorSpaceimpl == null) {
                                veilConfig5 = exitTransitionImpl3.config.veil;
                                if (veilConfig5 != null) {
                                    colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                } else {
                                    colorSpaceM483getColorSpaceimpl = null;
                                }
                                if (colorSpaceM483getColorSpaceimpl == null) {
                                    colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                }
                            }
                        }
                        companion = Modifier.Companion.$$INSTANCE;
                        if (z12) {
                            gapComposer.startReplaceGroup(1020378035);
                            CallsKt$await$2$1 callsKt$await$2$6 = new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl);
                            companion2 = companion;
                            TwoWayConverterImpl twoWayConverterImpl15 = new TwoWayConverterImpl(ColorVectorConverterKt$ColorToVector$1$1.INSTANCE, callsKt$await$2$6);
                            objRememberedValue19 = gapComposer.rememberedValue();
                            if (objRememberedValue19 == neverEqualPolicy2) {
                                objRememberedValue19 = "Built-in veil";
                                gapComposer.updateRememberedValue("Built-in veil");
                            }
                            VeilModifierElement veilModifierElement6 = new VeilModifierElement(transitionInstance3, ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl15, (String) objRememberedValue19, gapComposer, 384, 0), enterTransitionImpl2, exitTransitionImpl3, sharedMutableTransformState2);
                            exitTransitionImpl4 = exitTransitionImpl3;
                            gapComposer.end(false);
                            modifier3 = veilModifierElement6;
                        } else {
                            exitTransitionImpl4 = exitTransitionImpl3;
                            companion2 = companion;
                            gapComposer.startReplaceGroup(1020676162);
                            gapComposer.end(false);
                            modifier3 = companion2;
                        }
                        if (veilConfig3 != 0) {
                            zBooleanValue = veilConfig3.matchParentSize;
                        } else {
                            veilConfig6 = exitTransitionImpl4.config.veil;
                            if (veilConfig6 != null) {
                                zBooleanValue = veilConfig6.matchParentSize;
                            } else {
                                if (sharedMutableTransformState2.mutableData != null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    bool = null;
                                }
                                if (bool != null) {
                                    zBooleanValue = bool.booleanValue();
                                } else {
                                    zBooleanValue = false;
                                }
                            }
                        }
                        twoWayConverterImpl3 = ArcSplineKt.FloatToVector;
                        if (enterExitTransitionConfig3.fade != null) {
                            z16 = true;
                        } else {
                            z16 = true;
                        }
                        if (enterExitTransitionConfig3.scale != null) {
                            z17 = true;
                        } else {
                            z17 = true;
                        }
                        if (z16) {
                            gapComposer.startReplaceGroup(-1511857635);
                            objRememberedValue18 = gapComposer.rememberedValue();
                            if (objRememberedValue18 == neverEqualPolicy2) {
                                objRememberedValue18 = "Built-in alpha";
                                gapComposer.updateRememberedValue("Built-in alpha");
                            }
                            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation1110 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue18, gapComposer, 384, 0);
                            gapComposer.end(false);
                            deferredAnimation4 = deferredAnimationCreateDeferredAnimation1110;
                        } else {
                            gapComposer.startReplaceGroup(-1511688190);
                            gapComposer.end(false);
                            deferredAnimation4 = null;
                        }
                        if (z17) {
                            gapComposer.startReplaceGroup(-1511620547);
                            objRememberedValue17 = gapComposer.rememberedValue();
                            if (objRememberedValue17 == neverEqualPolicy2) {
                                objRememberedValue17 = "Built-in scale";
                                gapComposer.updateRememberedValue("Built-in scale");
                            }
                            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation1111 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue17, gapComposer, 384, 0);
                            z18 = false;
                            gapComposer.end(false);
                            deferredAnimation5 = deferredAnimationCreateDeferredAnimation1111;
                        } else {
                            z18 = false;
                            gapComposer.startReplaceGroup(-1511451102);
                            gapComposer.end(false);
                            deferredAnimation5 = null;
                        }
                        if (z17) {
                            gapComposer.startReplaceGroup(-1511373446);
                            deferredAnimationCreateDeferredAnimation = ArcSplineKt.createDeferredAnimation(transitionInstance3, EnterExitTransitionKt.TransformOriginVectorConverter, "TransformOriginInterruptionHandling", gapComposer, 384, 0);
                            gapComposer.end(z18);
                        } else {
                            gapComposer.startReplaceGroup(-1511201118);
                            gapComposer.end(z18);
                            deferredAnimationCreateDeferredAnimation = null;
                        }
                        zChangedInstance3 = gapComposer.changedInstance(deferredAnimation4) | gapComposer.changed(enterTransitionImpl2) | gapComposer.changed(exitTransitionImpl4) | gapComposer.changedInstance(sharedMutableTransformState2) | gapComposer.changedInstance(deferredAnimation5) | gapComposer.changed(transitionInstance3) | gapComposer.changedInstance(deferredAnimationCreateDeferredAnimation);
                        objRememberedValue14 = gapComposer.rememberedValue();
                        if (zChangedInstance3) {
                            SharedMutableTransformState sharedMutableTransformState13 = sharedMutableTransformState2;
                            exitTransitionImpl5 = exitTransitionImpl4;
                            objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState13, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                            sharedMutableTransformState3 = sharedMutableTransformState13;
                            gapComposer.updateRememberedValue(objRememberedValue14);
                        } else {
                            SharedMutableTransformState sharedMutableTransformState14 = sharedMutableTransformState2;
                            exitTransitionImpl5 = exitTransitionImpl4;
                            objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState14, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                            sharedMutableTransformState3 = sharedMutableTransformState14;
                            gapComposer.updateRememberedValue(objRememberedValue14);
                        }
                        EnterExitTransitionKt$$ExternalSyntheticLambda7 enterExitTransitionKt$$ExternalSyntheticLambda12 = (EnterExitTransitionKt$$ExternalSyntheticLambda7) objRememberedValue14;
                        if (zBooleanValue != 0) {
                            modifier4 = modifier3;
                        } else {
                            modifier4 = companion2;
                        }
                        zChanged6 = gapComposer.changed(z15) | gapComposer.changed(function0);
                        objRememberedValue15 = gapComposer.rememberedValue();
                        if (zChanged6) {
                            objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                            gapComposer.updateRememberedValue(objRememberedValue15);
                        } else {
                            objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                            gapComposer.updateRememberedValue(objRememberedValue15);
                        }
                        Modifier modifierThen16 = modifier4.then(ColorKt.graphicsLayer(companion2, (Function1) objRememberedValue15)).then(new EnterExitTransitionElement(transitionInstance3, deferredAnimation2, deferredAnimation3, deferredAnimation, enterTransitionImpl2, exitTransitionImpl5, sharedMutableTransformState3, function0, enterExitTransitionKt$$ExternalSyntheticLambda12));
                        if (zBooleanValue) {
                            modifier5 = modifier3;
                        } else {
                            modifier5 = companion2;
                        }
                        Modifier modifierThen17 = modifierThen16.then(modifier5);
                        gapComposer.startReplaceGroup(-130485473);
                        gapComposer.end(false);
                        modifier2 = modifier;
                        Modifier modifierThen18 = modifier2.then(modifierThen17.then(companion2));
                        objRememberedValue16 = gapComposer.rememberedValue();
                        if (objRememberedValue16 == neverEqualPolicy2) {
                            objRememberedValue16 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                            gapComposer.updateRememberedValue(objRememberedValue16);
                        }
                        AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy6 = (AnimatedEnterExitMeasurePolicy) objRememberedValue16;
                        int iHashCode6 = Long.hashCode(gapComposer.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen18);
                        ComposeUiNode.Companion.getClass();
                        gapComposer.startReusableNode();
                        if (gapComposer.inserting) {
                            gapComposer.createNode(LayoutNode.Constructor);
                        } else {
                            gapComposer.useNode();
                        }
                        Stack.m390setimpl(gapComposer, animatedEnterExitMeasurePolicy6, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m386initimpl(gapComposer, Integer.valueOf(iHashCode6));
                        Stack.m389reconcileimpl(gapComposer);
                        Stack.m390setimpl(gapComposer, modifierMaterializeModifier6, ComposeUiNode.Companion.SetModifier);
                        ComposableLambdaImpl composableLambdaImpl11 = composableLambdaImpl;
                        composableLambdaImpl11.invoke(animatedVisibilityScopeImpl, gapComposer, Integer.valueOf((i3 >> 24) & 112));
                        gapComposer.end(true);
                        z19 = false;
                        gapComposer.end(false);
                        composableLambdaImpl3 = composableLambdaImpl11;
                    } else {
                        gapComposer.startReplaceGroup(248647379);
                        if (i4 == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        objRememberedValue12 = gapComposer.rememberedValue();
                        if (z11) {
                            objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                            gapComposer.updateRememberedValue(objRememberedValue12);
                        } else {
                            objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                            gapComposer.updateRememberedValue(objRememberedValue12);
                        }
                        animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) objRememberedValue12;
                        twoWayConverterImpl = ArcSplineKt.IntOffsetToVector;
                        objRememberedValue13 = gapComposer.rememberedValue();
                        if (objRememberedValue13 == neverEqualPolicy) {
                            objRememberedValue13 = new ScrollKt$$ExternalSyntheticLambda0((byte) 7);
                            gapComposer.updateRememberedValue(objRememberedValue13);
                        }
                        function0 = (Function0) objRememberedValue13;
                        gapComposer.startReplaceGroup(1018346543);
                        gapComposer.end(false);
                        gapComposer.startReplaceGroup(1018554181);
                        gapComposer.end(false);
                        gapComposer.startReplaceGroup(1018736678);
                        gapComposer.end(false);
                        enterExitTransitionConfig = enterTransitionImpl2.config;
                        changeSizeConfig3 = enterExitTransitionConfig.changeSize;
                        veilConfig3 = enterExitTransitionConfig.veil;
                        if (veilConfig3 == null) {
                            enterExitTransitionConfig2 = enterExitTransitionConfig;
                            transitionInstance2 = transitionInstance;
                            changeSizeConfig4 = changeSizeConfig3;
                            z12 = true;
                        } else {
                            enterExitTransitionConfig2 = enterExitTransitionConfig;
                            transitionInstance2 = transitionInstance;
                            changeSizeConfig4 = changeSizeConfig3;
                            z12 = true;
                        }
                        enterExitTransitionConfig3 = enterExitTransitionConfig2;
                        if (enterExitTransitionConfig3.slide == null) {
                            sharedMutableTransformState2 = sharedMutableTransformState;
                            z13 = true;
                        } else {
                            sharedMutableTransformState2 = sharedMutableTransformState;
                            z13 = true;
                        }
                        if (changeSizeConfig4 == null) {
                            z14 = true;
                        } else {
                            z14 = true;
                        }
                        if (z13) {
                            gapComposer.startReplaceGroup(1019286587);
                            objRememberedValue22 = gapComposer.rememberedValue();
                            if (objRememberedValue22 == neverEqualPolicy) {
                                objRememberedValue22 = "Built-in slide";
                                gapComposer.updateRememberedValue("Built-in slide");
                            }
                            String str7 = (String) objRememberedValue22;
                            neverEqualPolicy2 = neverEqualPolicy;
                            transitionInstance3 = transitionInstance2;
                            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation1112 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl, str7, gapComposer, 384, 0);
                            twoWayConverterImpl2 = twoWayConverterImpl;
                            gapComposer.end(false);
                            deferredAnimation = deferredAnimationCreateDeferredAnimation1112;
                        } else {
                            twoWayConverterImpl2 = twoWayConverterImpl;
                            neverEqualPolicy2 = neverEqualPolicy;
                            transitionInstance3 = transitionInstance2;
                            gapComposer.startReplaceGroup(1019392390);
                            gapComposer.end(false);
                            deferredAnimation = null;
                        }
                        if (z14) {
                            gapComposer.startReplaceGroup(1019484181);
                            TwoWayConverterImpl twoWayConverterImpl16 = ArcSplineKt.IntSizeToVector;
                            objRememberedValue21 = gapComposer.rememberedValue();
                            if (objRememberedValue21 == neverEqualPolicy2) {
                                objRememberedValue21 = "Built-in shrink/expand";
                                gapComposer.updateRememberedValue("Built-in shrink/expand");
                            }
                            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation1113 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl16, (String) objRememberedValue21, gapComposer, 384, 0);
                            gapComposer.end(false);
                            deferredAnimation2 = deferredAnimationCreateDeferredAnimation1113;
                        } else {
                            gapComposer.startReplaceGroup(1019595005);
                            gapComposer.end(false);
                            deferredAnimation2 = null;
                        }
                        if (z14) {
                            gapComposer.startReplaceGroup(1019668631);
                            objRememberedValue20 = gapComposer.rememberedValue();
                            if (objRememberedValue20 == neverEqualPolicy2) {
                                objRememberedValue20 = "Built-in InterruptionHandlingOffset";
                                gapComposer.updateRememberedValue("Built-in InterruptionHandlingOffset");
                            }
                            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation1114 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl2, (String) objRememberedValue20, gapComposer, 384, 0);
                            gapComposer.end(false);
                            deferredAnimation3 = deferredAnimationCreateDeferredAnimation1114;
                        } else {
                            gapComposer.startReplaceGroup(1019839037);
                            gapComposer.end(false);
                            deferredAnimation3 = null;
                        }
                        if (changeSizeConfig4 == 0) {
                        }
                        if (veilConfig3 != 0) {
                            if (veilConfig3 != 0) {
                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                            } else {
                                veilConfig4 = exitTransitionImpl3.config.veil;
                                if (veilConfig4 != null) {
                                    colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                                } else {
                                    colorSpaceM483getColorSpaceimpl = null;
                                }
                                if (colorSpaceM483getColorSpaceimpl == null) {
                                    veilConfig5 = exitTransitionImpl3.config.veil;
                                    if (veilConfig5 != null) {
                                        colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                    } else {
                                        colorSpaceM483getColorSpaceimpl = null;
                                    }
                                    if (colorSpaceM483getColorSpaceimpl == null) {
                                        colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                    }
                                }
                            }
                        } else if (veilConfig3 != 0) {
                            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                        } else {
                            veilConfig4 = exitTransitionImpl3.config.veil;
                            if (veilConfig4 != null) {
                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                            } else {
                                colorSpaceM483getColorSpaceimpl = null;
                            }
                            if (colorSpaceM483getColorSpaceimpl == null) {
                                veilConfig5 = exitTransitionImpl3.config.veil;
                                if (veilConfig5 != null) {
                                    colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                } else {
                                    colorSpaceM483getColorSpaceimpl = null;
                                }
                                if (colorSpaceM483getColorSpaceimpl == null) {
                                    colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                }
                            }
                        }
                        companion = Modifier.Companion.$$INSTANCE;
                        if (z12) {
                            gapComposer.startReplaceGroup(1020378035);
                            CallsKt$await$2$1 callsKt$await$2$7 = new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl);
                            companion2 = companion;
                            TwoWayConverterImpl twoWayConverterImpl17 = new TwoWayConverterImpl(ColorVectorConverterKt$ColorToVector$1$1.INSTANCE, callsKt$await$2$7);
                            objRememberedValue19 = gapComposer.rememberedValue();
                            if (objRememberedValue19 == neverEqualPolicy2) {
                                objRememberedValue19 = "Built-in veil";
                                gapComposer.updateRememberedValue("Built-in veil");
                            }
                            VeilModifierElement veilModifierElement7 = new VeilModifierElement(transitionInstance3, ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl17, (String) objRememberedValue19, gapComposer, 384, 0), enterTransitionImpl2, exitTransitionImpl3, sharedMutableTransformState2);
                            exitTransitionImpl4 = exitTransitionImpl3;
                            gapComposer.end(false);
                            modifier3 = veilModifierElement7;
                        } else {
                            exitTransitionImpl4 = exitTransitionImpl3;
                            companion2 = companion;
                            gapComposer.startReplaceGroup(1020676162);
                            gapComposer.end(false);
                            modifier3 = companion2;
                        }
                        if (veilConfig3 != 0) {
                            zBooleanValue = veilConfig3.matchParentSize;
                        } else {
                            veilConfig6 = exitTransitionImpl4.config.veil;
                            if (veilConfig6 != null) {
                                zBooleanValue = veilConfig6.matchParentSize;
                            } else {
                                if (sharedMutableTransformState2.mutableData != null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    bool = null;
                                }
                                if (bool != null) {
                                    zBooleanValue = bool.booleanValue();
                                } else {
                                    zBooleanValue = false;
                                }
                            }
                        }
                        twoWayConverterImpl3 = ArcSplineKt.FloatToVector;
                        if (enterExitTransitionConfig3.fade != null) {
                            z16 = true;
                        } else {
                            z16 = true;
                        }
                        if (enterExitTransitionConfig3.scale != null) {
                            z17 = true;
                        } else {
                            z17 = true;
                        }
                        if (z16) {
                            gapComposer.startReplaceGroup(-1511857635);
                            objRememberedValue18 = gapComposer.rememberedValue();
                            if (objRememberedValue18 == neverEqualPolicy2) {
                                objRememberedValue18 = "Built-in alpha";
                                gapComposer.updateRememberedValue("Built-in alpha");
                            }
                            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation1115 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue18, gapComposer, 384, 0);
                            gapComposer.end(false);
                            deferredAnimation4 = deferredAnimationCreateDeferredAnimation1115;
                        } else {
                            gapComposer.startReplaceGroup(-1511688190);
                            gapComposer.end(false);
                            deferredAnimation4 = null;
                        }
                        if (z17) {
                            gapComposer.startReplaceGroup(-1511620547);
                            objRememberedValue17 = gapComposer.rememberedValue();
                            if (objRememberedValue17 == neverEqualPolicy2) {
                                objRememberedValue17 = "Built-in scale";
                                gapComposer.updateRememberedValue("Built-in scale");
                            }
                            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation1116 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue17, gapComposer, 384, 0);
                            z18 = false;
                            gapComposer.end(false);
                            deferredAnimation5 = deferredAnimationCreateDeferredAnimation1116;
                        } else {
                            z18 = false;
                            gapComposer.startReplaceGroup(-1511451102);
                            gapComposer.end(false);
                            deferredAnimation5 = null;
                        }
                        if (z17) {
                            gapComposer.startReplaceGroup(-1511373446);
                            deferredAnimationCreateDeferredAnimation = ArcSplineKt.createDeferredAnimation(transitionInstance3, EnterExitTransitionKt.TransformOriginVectorConverter, "TransformOriginInterruptionHandling", gapComposer, 384, 0);
                            gapComposer.end(z18);
                        } else {
                            gapComposer.startReplaceGroup(-1511201118);
                            gapComposer.end(z18);
                            deferredAnimationCreateDeferredAnimation = null;
                        }
                        zChangedInstance3 = gapComposer.changedInstance(deferredAnimation4) | gapComposer.changed(enterTransitionImpl2) | gapComposer.changed(exitTransitionImpl4) | gapComposer.changedInstance(sharedMutableTransformState2) | gapComposer.changedInstance(deferredAnimation5) | gapComposer.changed(transitionInstance3) | gapComposer.changedInstance(deferredAnimationCreateDeferredAnimation);
                        objRememberedValue14 = gapComposer.rememberedValue();
                        if (zChangedInstance3) {
                            SharedMutableTransformState sharedMutableTransformState15 = sharedMutableTransformState2;
                            exitTransitionImpl5 = exitTransitionImpl4;
                            objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState15, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                            sharedMutableTransformState3 = sharedMutableTransformState15;
                            gapComposer.updateRememberedValue(objRememberedValue14);
                        } else {
                            SharedMutableTransformState sharedMutableTransformState16 = sharedMutableTransformState2;
                            exitTransitionImpl5 = exitTransitionImpl4;
                            objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState16, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                            sharedMutableTransformState3 = sharedMutableTransformState16;
                            gapComposer.updateRememberedValue(objRememberedValue14);
                        }
                        EnterExitTransitionKt$$ExternalSyntheticLambda7 enterExitTransitionKt$$ExternalSyntheticLambda13 = (EnterExitTransitionKt$$ExternalSyntheticLambda7) objRememberedValue14;
                        if (zBooleanValue != 0) {
                            modifier4 = modifier3;
                        } else {
                            modifier4 = companion2;
                        }
                        zChanged6 = gapComposer.changed(z15) | gapComposer.changed(function0);
                        objRememberedValue15 = gapComposer.rememberedValue();
                        if (zChanged6) {
                            objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                            gapComposer.updateRememberedValue(objRememberedValue15);
                        } else {
                            objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                            gapComposer.updateRememberedValue(objRememberedValue15);
                        }
                        Modifier modifierThen19 = modifier4.then(ColorKt.graphicsLayer(companion2, (Function1) objRememberedValue15)).then(new EnterExitTransitionElement(transitionInstance3, deferredAnimation2, deferredAnimation3, deferredAnimation, enterTransitionImpl2, exitTransitionImpl5, sharedMutableTransformState3, function0, enterExitTransitionKt$$ExternalSyntheticLambda13));
                        if (zBooleanValue) {
                            modifier5 = modifier3;
                        } else {
                            modifier5 = companion2;
                        }
                        Modifier modifierThen110 = modifierThen19.then(modifier5);
                        gapComposer.startReplaceGroup(-130485473);
                        gapComposer.end(false);
                        modifier2 = modifier;
                        Modifier modifierThen111 = modifier2.then(modifierThen110.then(companion2));
                        objRememberedValue16 = gapComposer.rememberedValue();
                        if (objRememberedValue16 == neverEqualPolicy2) {
                            objRememberedValue16 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                            gapComposer.updateRememberedValue(objRememberedValue16);
                        }
                        AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy7 = (AnimatedEnterExitMeasurePolicy) objRememberedValue16;
                        int iHashCode7 = Long.hashCode(gapComposer.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope7 = gapComposer.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier7 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen111);
                        ComposeUiNode.Companion.getClass();
                        gapComposer.startReusableNode();
                        if (gapComposer.inserting) {
                            gapComposer.createNode(LayoutNode.Constructor);
                        } else {
                            gapComposer.useNode();
                        }
                        Stack.m390setimpl(gapComposer, animatedEnterExitMeasurePolicy7, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope7, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m386initimpl(gapComposer, Integer.valueOf(iHashCode7));
                        Stack.m389reconcileimpl(gapComposer);
                        Stack.m390setimpl(gapComposer, modifierMaterializeModifier7, ComposeUiNode.Companion.SetModifier);
                        ComposableLambdaImpl composableLambdaImpl12 = composableLambdaImpl;
                        composableLambdaImpl12.invoke(animatedVisibilityScopeImpl, gapComposer, Integer.valueOf((i3 >> 24) & 112));
                        gapComposer.end(true);
                        z19 = false;
                        gapComposer.end(false);
                        composableLambdaImpl3 = composableLambdaImpl12;
                    }
                    gapComposer.end(z19);
                    composableLambdaImpl4 = composableLambdaImpl3;
                } else {
                    gapComposer.startReplaceGroup(250090987);
                    gapComposer.end(false);
                    modifier2 = modifier;
                    composableLambdaImpl4 = composableLambdaImpl5;
                }
                z4 = z5;
                composableLambdaImpl2 = composableLambdaImpl4;
            } else {
                modifier2 = modifier;
                gapComposer.skipToGroupEnd();
                z4 = z2;
                composableLambdaImpl2 = composableLambdaImpl5;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(transition, function1, modifier2, enterTransitionImpl, exitTransitionImpl, function2, mutableTransform, z4, composableLambdaImpl2, i, i2);
            }
        }
        i11 |= 100663296;
        z2 = z;
        if ((805306368 & i) == 0) {
            if (gapComposer.changedInstance(composableLambdaImpl5)) {
                i9 = 536870912;
            } else {
                i9 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
            }
            i11 |= i9;
        }
        i3 = i11;
        if ((306783379 & i11) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (gapComposer.shouldExecute(i3 & 1, z3)) {
            if (i12 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            ParcelableSnapshotMutableState parcelableSnapshotMutableState8 = transition.pendingTargetState$delegate;
            parcelableSnapshotMutableState = transition.targetState$delegate;
            tagPayloadReader = transition.transitionState;
            Object value6 = parcelableSnapshotMutableState8.getValue();
            if (z5) {
                gapComposer.startReplaceGroup(246708267);
                i4 = i3 & 14;
                int i15 = i4 | 48;
                int i16 = i15 & 14;
                if ((i16 ^ 6) <= 4) {
                }
                objRememberedValue = gapComposer.rememberedValue();
                neverEqualPolicy = Composer.Companion.Empty;
                if (z6) {
                    objRememberedValue = tagPayloadReader.getCurrentState();
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = tagPayloadReader.getCurrentState();
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                if (transition.isSeeking()) {
                    objRememberedValue = tagPayloadReader.getCurrentState();
                }
                gapComposer.startReplaceGroup(-1260162954);
                enterExitStateTargetEnterExit = targetEnterExit(transition, function1, objRememberedValue, gapComposer);
                gapComposer.end(false);
                Object value7 = parcelableSnapshotMutableState.getValue();
                gapComposer.startReplaceGroup(-1260162954);
                enterExitStateTargetEnterExit2 = targetEnterExit(transition, function1, value7, gapComposer);
                gapComposer.end(false);
                i5 = i16 | 3072;
                i6 = (i5 & 14) ^ 6;
                if (i6 > 4) {
                    i7 = i5;
                    if ((i7 & 6) != 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                } else {
                    i7 = i5;
                    if ((i7 & 6) != 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                }
                objRememberedValue2 = gapComposer.rememberedValue();
                if (z7) {
                    objRememberedValue2 = new TransitionInstance(new MutableTransitionState(enterExitStateTargetEnterExit), transition, transition.label + " > EnterExitTransition");
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new TransitionInstance(new MutableTransitionState(enterExitStateTargetEnterExit), transition, transition.label + " > EnterExitTransition");
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                transitionInstance = (TransitionInstance) objRememberedValue2;
                zChanged = ((i6 <= 4 && gapComposer.changed(transition)) || (i7 & 6) == 4) | gapComposer.changed(transitionInstance);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new BackHandlerKt$$ExternalSyntheticLambda2(transition, transitionInstance, (byte) 5);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new BackHandlerKt$$ExternalSyntheticLambda2(transition, transitionInstance, (byte) 5);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                Stack.DisposableEffect(transitionInstance, (Function1) objRememberedValue3, gapComposer);
                if (transition.isSeeking()) {
                    transitionInstance.seek(enterExitStateTargetEnterExit, enterExitStateTargetEnterExit2);
                } else {
                    transitionInstance.updateTarget$animation_core(enterExitStateTargetEnterExit2);
                    transitionInstance.isSeeking$delegate.setValue(Boolean.FALSE);
                }
                if (transition.isSeeking()) {
                    gapComposer.startReplaceGroup(782386797);
                    value2 = transition.pendingTargetState$delegate.getValue();
                    if (value2 == null) {
                        gapComposer.startReplaceGroup(782437481);
                        gapComposer.end(false);
                        enterExitStateTargetEnterExit3 = null;
                    } else {
                        gapComposer.startReplaceGroup(782437482);
                        gapComposer.startReplaceGroup(-1260162954);
                        enterExitStateTargetEnterExit3 = targetEnterExit(transition, function1, value2, gapComposer);
                        gapComposer.end(false);
                        gapComposer.end(false);
                    }
                    tagPayloadReader3 = transitionInstance.transitionState;
                    parcelableSnapshotMutableState4 = transitionInstance.targetState$delegate;
                    ParcelableSnapshotMutableState parcelableSnapshotMutableState9 = transitionInstance.pendingTargetState$delegate;
                    value3 = parcelableSnapshotMutableState9.getValue();
                    if (value3 == null) {
                        z20 = false;
                    } else {
                        z20 = false;
                    }
                    parcelableSnapshotMutableState9.setValue(enterExitStateTargetEnterExit3);
                    if (z20) {
                        transitionInstance.segment$delegate.setValue(new Transition.SegmentImpl(value3, parcelableSnapshotMutableState4.getValue()));
                        tagPayloadReader3.setCurrentState$animation_core(value3);
                        if (transitionInstance.startTimeNanos$delegate.getLongValue() == Long.MIN_VALUE) {
                            transitionInstance.setUpdateChildrenNeeded(true);
                        }
                        snapshotStateList = transitionInstance._animations;
                        size = snapshotStateList.size();
                        while (i8 < size) {
                            ((Transition.TransitionAnimationState) snapshotStateList.get(i8)).resetSnapValue$delegate.setFloatValue(-2.0f);
                        }
                    }
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(782538635);
                    gapComposer.end(false);
                }
                if (i4 == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                objRememberedValue4 = gapComposer.rememberedValue();
                if (z8) {
                    objRememberedValue4 = new SharedMutableTransformState();
                    gapComposer.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new SharedMutableTransformState();
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                sharedMutableTransformState = (SharedMutableTransformState) objRememberedValue4;
                if (mutableTransform != null) {
                    sharedMutableTransformState.getClass();
                }
                sharedMutableTransformState.mutableData = mutableTransform;
                SystemBarStyle$Companion$$ExternalSyntheticLambda0 systemBarStyle$Companion$$ExternalSyntheticLambda2 = EnterExitTransitionKt.NeutralSlideOffset;
                parcelableSnapshotMutableState2 = sharedMutableTransformState.mutationPhase$delegate;
                gapComposer.startReplaceGroup(-31257052);
                gapComposer.end(false);
                if (transitionInstance.pendingTargetState$delegate.getValue() != null) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                if (transitionInstance.transitionState.getCurrentState() == transitionInstance.targetState$delegate.getValue()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                mutationPhase$animation = sharedMutableTransformState.getMutationPhase$animation();
                mutationPhase = MutationPhase.MutatingPendingCatchUp;
                mutationPhase2 = MutationPhase.Mutating;
                mutationPhase3 = MutationPhase.Handoff;
                if (z9) {
                    if (mutationPhase$animation != MutationPhase.Idle) {
                        sharedMutableTransformState.transformScope.reset();
                        if (z10) {
                            mutationPhase = mutationPhase2;
                        }
                        parcelableSnapshotMutableState2.setValue(mutationPhase);
                        sharedMutableTransformState.scaleHandoffVelocity = null;
                        sharedMutableTransformState.slideHandoffVelocity = null;
                    } else {
                        sharedMutableTransformState.transformScope.reset();
                        if (z10) {
                            mutationPhase = mutationPhase2;
                        }
                        parcelableSnapshotMutableState2.setValue(mutationPhase);
                        sharedMutableTransformState.scaleHandoffVelocity = null;
                        sharedMutableTransformState.slideHandoffVelocity = null;
                    }
                } else if (mutationPhase$animation != mutationPhase) {
                    parcelableSnapshotMutableState2.setValue(mutationPhase3);
                    velocityTracker = sharedMutableTransformState.scaleVelocityTracker;
                    fFloatValue = CropImageView.DEFAULT_ASPECT_RATIO;
                    if (velocityTracker != null) {
                        fM819getXimpl2 = Velocity.m819getXimpl(velocityTracker.m595calculateVelocity9UxMQ8M());
                        fValueOf3 = Float.valueOf(fM819getXimpl2);
                        if (Float.isNaN(fM819getXimpl2)) {
                            fValueOf3 = null;
                        }
                        if (fValueOf3 != null) {
                            fFloatValue2 = fValueOf3.floatValue();
                        } else {
                            fFloatValue2 = 0.0f;
                        }
                    } else {
                        fFloatValue2 = 0.0f;
                    }
                    sharedMutableTransformState.scaleHandoffVelocity = new AnimationVector1D(fFloatValue2);
                    fM819getXimpl = Velocity.m819getXimpl(0L);
                    fValueOf = Float.valueOf(fM819getXimpl);
                    if (Float.isNaN(fM819getXimpl)) {
                        fValueOf = null;
                    }
                    if (fValueOf != null) {
                        fFloatValue3 = fValueOf.floatValue();
                    } else {
                        fFloatValue3 = 0.0f;
                    }
                    fM820getYimpl = Velocity.m820getYimpl(0L);
                    fValueOf2 = Float.valueOf(fM820getYimpl);
                    if (Float.isNaN(fM820getYimpl)) {
                        fValueOf2 = null;
                    }
                    if (fValueOf2 != null) {
                        fFloatValue = fValueOf2.floatValue();
                    }
                    sharedMutableTransformState.slideHandoffVelocity = new AnimationVector2D(fFloatValue3, fFloatValue);
                } else {
                    parcelableSnapshotMutableState2.setValue(mutationPhase3);
                    velocityTracker = sharedMutableTransformState.scaleVelocityTracker;
                    fFloatValue = CropImageView.DEFAULT_ASPECT_RATIO;
                    if (velocityTracker != null) {
                        fM819getXimpl2 = Velocity.m819getXimpl(velocityTracker.m595calculateVelocity9UxMQ8M());
                        fValueOf3 = Float.valueOf(fM819getXimpl2);
                        if (Float.isNaN(fM819getXimpl2)) {
                            fValueOf3 = null;
                        }
                        if (fValueOf3 != null) {
                            fFloatValue2 = fValueOf3.floatValue();
                        } else {
                            fFloatValue2 = 0.0f;
                        }
                    } else {
                        fFloatValue2 = 0.0f;
                    }
                    sharedMutableTransformState.scaleHandoffVelocity = new AnimationVector1D(fFloatValue2);
                    fM819getXimpl = Velocity.m819getXimpl(0L);
                    fValueOf = Float.valueOf(fM819getXimpl);
                    if (Float.isNaN(fM819getXimpl)) {
                        fValueOf = null;
                    }
                    if (fValueOf != null) {
                        fFloatValue3 = fValueOf.floatValue();
                    } else {
                        fFloatValue3 = 0.0f;
                    }
                    fM820getYimpl = Velocity.m820getYimpl(0L);
                    fValueOf2 = Float.valueOf(fM820getYimpl);
                    if (Float.isNaN(fM820getYimpl)) {
                        fValueOf2 = null;
                    }
                    if (fValueOf2 != null) {
                        fFloatValue = fValueOf2.floatValue();
                    }
                    sharedMutableTransformState.slideHandoffVelocity = new AnimationVector2D(fFloatValue3, fFloatValue);
                }
                Boolean boolValueOf3 = Boolean.valueOf(z9);
                zChanged2 = gapComposer.changed(z9) | gapComposer.changed(z10) | gapComposer.changedInstance(sharedMutableTransformState);
                objRememberedValue5 = gapComposer.rememberedValue();
                if (zChanged2) {
                    objRememberedValue5 = new EnterExitTransitionKt$trackActiveMutableState$1$1(z9, z10, sharedMutableTransformState, null);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new EnterExitTransitionKt$trackActiveMutableState$1$1(z9, z10, sharedMutableTransformState, null);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                }
                Stack.LaunchedEffect(gapComposer, boolValueOf3, (Function2) objRememberedValue5);
                zChangedInstance = gapComposer.changedInstance(sharedMutableTransformState);
                objRememberedValue6 = gapComposer.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue6 = new SliderState$$ExternalSyntheticLambda0((byte) 3, sharedMutableTransformState);
                    gapComposer.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new SliderState$$ExternalSyntheticLambda0((byte) 3, sharedMutableTransformState);
                    gapComposer.updateRememberedValue(objRememberedValue6);
                }
                EnterExitTransitionKt.DeferredTransitionCleanupEffect(transitionInstance, (Function0) objRememberedValue6, gapComposer, 0);
                parcelableSnapshotMutableState3 = transitionInstance.targetState$delegate;
                tagPayloadReader2 = transitionInstance.transitionState;
                zChanged3 = gapComposer.changed(transitionInstance);
                objRememberedValue7 = gapComposer.rememberedValue();
                if (zChanged3) {
                    objRememberedValue7 = Stack.mutableStateOf$default(enterTransitionImpl);
                    gapComposer.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = Stack.mutableStateOf$default(enterTransitionImpl);
                    gapComposer.updateRememberedValue(objRememberedValue7);
                }
                mutableState = (MutableState) objRememberedValue7;
                currentState = tagPayloadReader2.getCurrentState();
                value = parcelableSnapshotMutableState3.getValue();
                enterExitState = EnterExitState.PostExit;
                enterExitState2 = EnterExitState.Visible;
                if (currentState == value) {
                    if (parcelableSnapshotMutableState3.getValue() != enterExitState) {
                        mutableState.setValue(((EnterTransitionImpl) mutableState.getValue()).plus(EnterTransitionImpl.None.plus(enterTransitionImpl)));
                    }
                } else if (parcelableSnapshotMutableState3.getValue() != enterExitState) {
                    mutableState.setValue(((EnterTransitionImpl) mutableState.getValue()).plus(EnterTransitionImpl.None.plus(enterTransitionImpl)));
                }
                enterTransitionImpl2 = (EnterTransitionImpl) mutableState.getValue();
                zChanged4 = gapComposer.changed(transitionInstance);
                objRememberedValue8 = gapComposer.rememberedValue();
                if (zChanged4) {
                    objRememberedValue8 = Stack.mutableStateOf$default(exitTransitionImpl);
                    gapComposer.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = Stack.mutableStateOf$default(exitTransitionImpl);
                    gapComposer.updateRememberedValue(objRememberedValue8);
                }
                mutableState2 = (MutableState) objRememberedValue8;
                if (tagPayloadReader2.getCurrentState() == parcelableSnapshotMutableState3.getValue()) {
                    if (parcelableSnapshotMutableState3.getValue() != enterExitState2) {
                        if (sharedMutableTransformState.isMutating()) {
                            exitTransitionImpl2 = (ExitTransitionImpl) mutableState2.getValue();
                        } else {
                            EnterExitTransitionConfig enterExitTransitionConfig7 = ((ExitTransitionImpl) mutableState2.getValue()).config;
                            fadeConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.fade;
                            if (fadeConfig != null) {
                                fadeConfig2 = new FadeConfig(1.0f, fadeConfig.animationSpec);
                            } else {
                                fadeConfig2 = null;
                            }
                            scaleConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.scale;
                            if (scaleConfig != null) {
                                scaleConfig2 = new ScaleConfig(1.0f, scaleConfig.transformOrigin, scaleConfig.animationSpec);
                            } else {
                                scaleConfig2 = null;
                            }
                            slideConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.slide;
                            if (slideConfig != null) {
                                slideConfig2 = new SlideConfig(EnterExitTransitionKt.NeutralSlideOffset, slideConfig.animationSpec);
                            } else {
                                slideConfig2 = null;
                            }
                            changeSizeConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.changeSize;
                            if (changeSizeConfig != null) {
                                changeSizeConfig2 = new ChangeSizeConfig(changeSizeConfig.alignment, EnterExitTransitionKt.NeutralChangeSize, changeSizeConfig.animationSpec, changeSizeConfig.clip);
                            } else {
                                changeSizeConfig2 = null;
                            }
                            veilConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.veil;
                            if (veilConfig != null) {
                                long j4 = veilConfig.initialColor;
                                veilConfig2 = new VeilConfig(j4, j4, veilConfig.animationSpec, veilConfig.matchParentSize);
                            } else {
                                veilConfig2 = null;
                            }
                            exitTransitionImpl2 = new ExitTransitionImpl(new EnterExitTransitionConfig(fadeConfig2, slideConfig2, changeSizeConfig2, scaleConfig2, veilConfig2, enterExitTransitionConfig7.hold, enterExitTransitionConfig7.effectsMap));
                        }
                        mutableState2.setValue(exitTransitionImpl2.plus(ExitTransitionImpl.None).plus(exitTransitionImpl));
                    } else {
                        sharedMutableTransformState = sharedMutableTransformState;
                    }
                } else if (parcelableSnapshotMutableState3.getValue() != enterExitState2) {
                    if (sharedMutableTransformState.isMutating()) {
                        exitTransitionImpl2 = (ExitTransitionImpl) mutableState2.getValue();
                    } else {
                        EnterExitTransitionConfig enterExitTransitionConfig8 = ((ExitTransitionImpl) mutableState2.getValue()).config;
                        fadeConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.fade;
                        if (fadeConfig != null) {
                            fadeConfig2 = new FadeConfig(1.0f, fadeConfig.animationSpec);
                        } else {
                            fadeConfig2 = null;
                        }
                        scaleConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.scale;
                        if (scaleConfig != null) {
                            scaleConfig2 = new ScaleConfig(1.0f, scaleConfig.transformOrigin, scaleConfig.animationSpec);
                        } else {
                            scaleConfig2 = null;
                        }
                        slideConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.slide;
                        if (slideConfig != null) {
                            slideConfig2 = new SlideConfig(EnterExitTransitionKt.NeutralSlideOffset, slideConfig.animationSpec);
                        } else {
                            slideConfig2 = null;
                        }
                        changeSizeConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.changeSize;
                        if (changeSizeConfig != null) {
                            changeSizeConfig2 = new ChangeSizeConfig(changeSizeConfig.alignment, EnterExitTransitionKt.NeutralChangeSize, changeSizeConfig.animationSpec, changeSizeConfig.clip);
                        } else {
                            changeSizeConfig2 = null;
                        }
                        veilConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.veil;
                        if (veilConfig != null) {
                            long j5 = veilConfig.initialColor;
                            veilConfig2 = new VeilConfig(j5, j5, veilConfig.animationSpec, veilConfig.matchParentSize);
                        } else {
                            veilConfig2 = null;
                        }
                        exitTransitionImpl2 = new ExitTransitionImpl(new EnterExitTransitionConfig(fadeConfig2, slideConfig2, changeSizeConfig2, scaleConfig2, veilConfig2, enterExitTransitionConfig8.hold, enterExitTransitionConfig8.effectsMap));
                    }
                    mutableState2.setValue(exitTransitionImpl2.plus(ExitTransitionImpl.None).plus(exitTransitionImpl));
                } else {
                    sharedMutableTransformState = sharedMutableTransformState;
                }
                exitTransitionImpl3 = (ExitTransitionImpl) mutableState2.getValue();
                mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function2, gapComposer);
                objInvoke = function2.invoke(tagPayloadReader2.getCurrentState(), parcelableSnapshotMutableState3.getValue());
                zChanged5 = gapComposer.changed(transitionInstance) | gapComposer.changed(mutableStateRememberUpdatedState);
                objRememberedValue9 = gapComposer.rememberedValue();
                if (zChanged5) {
                    objRememberedValue9 = new RealImageLoader.AnonymousClass2(transitionInstance, mutableStateRememberUpdatedState, null, (byte) 1);
                    gapComposer.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new RealImageLoader.AnonymousClass2(transitionInstance, mutableStateRememberUpdatedState, null, (byte) 1);
                    gapComposer.updateRememberedValue(objRememberedValue9);
                }
                function3 = (Function2) objRememberedValue9;
                objRememberedValue10 = gapComposer.rememberedValue();
                if (objRememberedValue10 == neverEqualPolicy) {
                    objRememberedValue10 = Stack.mutableStateOf$default(objInvoke);
                    gapComposer.updateRememberedValue(objRememberedValue10);
                }
                mutableState3 = (MutableState) objRememberedValue10;
                zChangedInstance2 = gapComposer.changedInstance(function3);
                objRememberedValue11 = gapComposer.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue11 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function3, mutableState3, null, (byte) 0);
                    gapComposer.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function3, mutableState3, null, (byte) 0);
                    gapComposer.updateRememberedValue(objRememberedValue11);
                }
                Stack.LaunchedEffect(gapComposer, Unit.INSTANCE, (Function2) objRememberedValue11);
                if (tagPayloadReader2.getCurrentState() != enterExitState) {
                    gapComposer.startReplaceGroup(248647379);
                    if (i4 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    objRememberedValue12 = gapComposer.rememberedValue();
                    if (z11) {
                        objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                        gapComposer.updateRememberedValue(objRememberedValue12);
                    } else {
                        objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                        gapComposer.updateRememberedValue(objRememberedValue12);
                    }
                    animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) objRememberedValue12;
                    twoWayConverterImpl = ArcSplineKt.IntOffsetToVector;
                    objRememberedValue13 = gapComposer.rememberedValue();
                    if (objRememberedValue13 == neverEqualPolicy) {
                        objRememberedValue13 = new ScrollKt$$ExternalSyntheticLambda0((byte) 7);
                        gapComposer.updateRememberedValue(objRememberedValue13);
                    }
                    function0 = (Function0) objRememberedValue13;
                    gapComposer.startReplaceGroup(1018346543);
                    gapComposer.end(false);
                    gapComposer.startReplaceGroup(1018554181);
                    gapComposer.end(false);
                    gapComposer.startReplaceGroup(1018736678);
                    gapComposer.end(false);
                    enterExitTransitionConfig = enterTransitionImpl2.config;
                    changeSizeConfig3 = enterExitTransitionConfig.changeSize;
                    veilConfig3 = enterExitTransitionConfig.veil;
                    if (veilConfig3 == null) {
                        enterExitTransitionConfig2 = enterExitTransitionConfig;
                        transitionInstance2 = transitionInstance;
                        changeSizeConfig4 = changeSizeConfig3;
                        z12 = true;
                    } else {
                        enterExitTransitionConfig2 = enterExitTransitionConfig;
                        transitionInstance2 = transitionInstance;
                        changeSizeConfig4 = changeSizeConfig3;
                        z12 = true;
                    }
                    enterExitTransitionConfig3 = enterExitTransitionConfig2;
                    if (enterExitTransitionConfig3.slide == null) {
                        sharedMutableTransformState2 = sharedMutableTransformState;
                        z13 = true;
                    } else {
                        sharedMutableTransformState2 = sharedMutableTransformState;
                        z13 = true;
                    }
                    if (changeSizeConfig4 == null) {
                        z14 = true;
                    } else {
                        z14 = true;
                    }
                    if (z13) {
                        gapComposer.startReplaceGroup(1019286587);
                        objRememberedValue22 = gapComposer.rememberedValue();
                        if (objRememberedValue22 == neverEqualPolicy) {
                            objRememberedValue22 = "Built-in slide";
                            gapComposer.updateRememberedValue("Built-in slide");
                        }
                        String str8 = (String) objRememberedValue22;
                        neverEqualPolicy2 = neverEqualPolicy;
                        transitionInstance3 = transitionInstance2;
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation1117 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl, str8, gapComposer, 384, 0);
                        twoWayConverterImpl2 = twoWayConverterImpl;
                        gapComposer.end(false);
                        deferredAnimation = deferredAnimationCreateDeferredAnimation1117;
                    } else {
                        twoWayConverterImpl2 = twoWayConverterImpl;
                        neverEqualPolicy2 = neverEqualPolicy;
                        transitionInstance3 = transitionInstance2;
                        gapComposer.startReplaceGroup(1019392390);
                        gapComposer.end(false);
                        deferredAnimation = null;
                    }
                    if (z14) {
                        gapComposer.startReplaceGroup(1019484181);
                        TwoWayConverterImpl twoWayConverterImpl18 = ArcSplineKt.IntSizeToVector;
                        objRememberedValue21 = gapComposer.rememberedValue();
                        if (objRememberedValue21 == neverEqualPolicy2) {
                            objRememberedValue21 = "Built-in shrink/expand";
                            gapComposer.updateRememberedValue("Built-in shrink/expand");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation1118 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl18, (String) objRememberedValue21, gapComposer, 384, 0);
                        gapComposer.end(false);
                        deferredAnimation2 = deferredAnimationCreateDeferredAnimation1118;
                    } else {
                        gapComposer.startReplaceGroup(1019595005);
                        gapComposer.end(false);
                        deferredAnimation2 = null;
                    }
                    if (z14) {
                        gapComposer.startReplaceGroup(1019668631);
                        objRememberedValue20 = gapComposer.rememberedValue();
                        if (objRememberedValue20 == neverEqualPolicy2) {
                            objRememberedValue20 = "Built-in InterruptionHandlingOffset";
                            gapComposer.updateRememberedValue("Built-in InterruptionHandlingOffset");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation1119 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl2, (String) objRememberedValue20, gapComposer, 384, 0);
                        gapComposer.end(false);
                        deferredAnimation3 = deferredAnimationCreateDeferredAnimation1119;
                    } else {
                        gapComposer.startReplaceGroup(1019839037);
                        gapComposer.end(false);
                        deferredAnimation3 = null;
                    }
                    if (changeSizeConfig4 == 0) {
                    }
                    if (veilConfig3 != 0) {
                        if (veilConfig3 != 0) {
                            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                        } else {
                            veilConfig4 = exitTransitionImpl3.config.veil;
                            if (veilConfig4 != null) {
                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                            } else {
                                colorSpaceM483getColorSpaceimpl = null;
                            }
                            if (colorSpaceM483getColorSpaceimpl == null) {
                                veilConfig5 = exitTransitionImpl3.config.veil;
                                if (veilConfig5 != null) {
                                    colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                } else {
                                    colorSpaceM483getColorSpaceimpl = null;
                                }
                                if (colorSpaceM483getColorSpaceimpl == null) {
                                    colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                }
                            }
                        }
                    } else if (veilConfig3 != 0) {
                        colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                    } else {
                        veilConfig4 = exitTransitionImpl3.config.veil;
                        if (veilConfig4 != null) {
                            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                        } else {
                            colorSpaceM483getColorSpaceimpl = null;
                        }
                        if (colorSpaceM483getColorSpaceimpl == null) {
                            veilConfig5 = exitTransitionImpl3.config.veil;
                            if (veilConfig5 != null) {
                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                            } else {
                                colorSpaceM483getColorSpaceimpl = null;
                            }
                            if (colorSpaceM483getColorSpaceimpl == null) {
                                colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                            }
                        }
                    }
                    companion = Modifier.Companion.$$INSTANCE;
                    if (z12) {
                        gapComposer.startReplaceGroup(1020378035);
                        CallsKt$await$2$1 callsKt$await$2$8 = new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl);
                        companion2 = companion;
                        TwoWayConverterImpl twoWayConverterImpl19 = new TwoWayConverterImpl(ColorVectorConverterKt$ColorToVector$1$1.INSTANCE, callsKt$await$2$8);
                        objRememberedValue19 = gapComposer.rememberedValue();
                        if (objRememberedValue19 == neverEqualPolicy2) {
                            objRememberedValue19 = "Built-in veil";
                            gapComposer.updateRememberedValue("Built-in veil");
                        }
                        VeilModifierElement veilModifierElement8 = new VeilModifierElement(transitionInstance3, ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl19, (String) objRememberedValue19, gapComposer, 384, 0), enterTransitionImpl2, exitTransitionImpl3, sharedMutableTransformState2);
                        exitTransitionImpl4 = exitTransitionImpl3;
                        gapComposer.end(false);
                        modifier3 = veilModifierElement8;
                    } else {
                        exitTransitionImpl4 = exitTransitionImpl3;
                        companion2 = companion;
                        gapComposer.startReplaceGroup(1020676162);
                        gapComposer.end(false);
                        modifier3 = companion2;
                    }
                    if (veilConfig3 != 0) {
                        zBooleanValue = veilConfig3.matchParentSize;
                    } else {
                        veilConfig6 = exitTransitionImpl4.config.veil;
                        if (veilConfig6 != null) {
                            zBooleanValue = veilConfig6.matchParentSize;
                        } else {
                            if (sharedMutableTransformState2.mutableData != null) {
                                bool = Boolean.FALSE;
                            } else {
                                bool = null;
                            }
                            if (bool != null) {
                                zBooleanValue = bool.booleanValue();
                            } else {
                                zBooleanValue = false;
                            }
                        }
                    }
                    twoWayConverterImpl3 = ArcSplineKt.FloatToVector;
                    if (enterExitTransitionConfig3.fade != null) {
                        z16 = true;
                    } else {
                        z16 = true;
                    }
                    if (enterExitTransitionConfig3.scale != null) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    if (z16) {
                        gapComposer.startReplaceGroup(-1511857635);
                        objRememberedValue18 = gapComposer.rememberedValue();
                        if (objRememberedValue18 == neverEqualPolicy2) {
                            objRememberedValue18 = "Built-in alpha";
                            gapComposer.updateRememberedValue("Built-in alpha");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation11110 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue18, gapComposer, 384, 0);
                        gapComposer.end(false);
                        deferredAnimation4 = deferredAnimationCreateDeferredAnimation11110;
                    } else {
                        gapComposer.startReplaceGroup(-1511688190);
                        gapComposer.end(false);
                        deferredAnimation4 = null;
                    }
                    if (z17) {
                        gapComposer.startReplaceGroup(-1511620547);
                        objRememberedValue17 = gapComposer.rememberedValue();
                        if (objRememberedValue17 == neverEqualPolicy2) {
                            objRememberedValue17 = "Built-in scale";
                            gapComposer.updateRememberedValue("Built-in scale");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation11111 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue17, gapComposer, 384, 0);
                        z18 = false;
                        gapComposer.end(false);
                        deferredAnimation5 = deferredAnimationCreateDeferredAnimation11111;
                    } else {
                        z18 = false;
                        gapComposer.startReplaceGroup(-1511451102);
                        gapComposer.end(false);
                        deferredAnimation5 = null;
                    }
                    if (z17) {
                        gapComposer.startReplaceGroup(-1511373446);
                        deferredAnimationCreateDeferredAnimation = ArcSplineKt.createDeferredAnimation(transitionInstance3, EnterExitTransitionKt.TransformOriginVectorConverter, "TransformOriginInterruptionHandling", gapComposer, 384, 0);
                        gapComposer.end(z18);
                    } else {
                        gapComposer.startReplaceGroup(-1511201118);
                        gapComposer.end(z18);
                        deferredAnimationCreateDeferredAnimation = null;
                    }
                    zChangedInstance3 = gapComposer.changedInstance(deferredAnimation4) | gapComposer.changed(enterTransitionImpl2) | gapComposer.changed(exitTransitionImpl4) | gapComposer.changedInstance(sharedMutableTransformState2) | gapComposer.changedInstance(deferredAnimation5) | gapComposer.changed(transitionInstance3) | gapComposer.changedInstance(deferredAnimationCreateDeferredAnimation);
                    objRememberedValue14 = gapComposer.rememberedValue();
                    if (zChangedInstance3) {
                        SharedMutableTransformState sharedMutableTransformState17 = sharedMutableTransformState2;
                        exitTransitionImpl5 = exitTransitionImpl4;
                        objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState17, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                        sharedMutableTransformState3 = sharedMutableTransformState17;
                        gapComposer.updateRememberedValue(objRememberedValue14);
                    } else {
                        SharedMutableTransformState sharedMutableTransformState18 = sharedMutableTransformState2;
                        exitTransitionImpl5 = exitTransitionImpl4;
                        objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState18, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                        sharedMutableTransformState3 = sharedMutableTransformState18;
                        gapComposer.updateRememberedValue(objRememberedValue14);
                    }
                    EnterExitTransitionKt$$ExternalSyntheticLambda7 enterExitTransitionKt$$ExternalSyntheticLambda14 = (EnterExitTransitionKt$$ExternalSyntheticLambda7) objRememberedValue14;
                    if (zBooleanValue != 0) {
                        modifier4 = modifier3;
                    } else {
                        modifier4 = companion2;
                    }
                    zChanged6 = gapComposer.changed(z15) | gapComposer.changed(function0);
                    objRememberedValue15 = gapComposer.rememberedValue();
                    if (zChanged6) {
                        objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                        gapComposer.updateRememberedValue(objRememberedValue15);
                    } else {
                        objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                        gapComposer.updateRememberedValue(objRememberedValue15);
                    }
                    Modifier modifierThen112 = modifier4.then(ColorKt.graphicsLayer(companion2, (Function1) objRememberedValue15)).then(new EnterExitTransitionElement(transitionInstance3, deferredAnimation2, deferredAnimation3, deferredAnimation, enterTransitionImpl2, exitTransitionImpl5, sharedMutableTransformState3, function0, enterExitTransitionKt$$ExternalSyntheticLambda14));
                    if (zBooleanValue) {
                        modifier5 = modifier3;
                    } else {
                        modifier5 = companion2;
                    }
                    Modifier modifierThen113 = modifierThen112.then(modifier5);
                    gapComposer.startReplaceGroup(-130485473);
                    gapComposer.end(false);
                    modifier2 = modifier;
                    Modifier modifierThen114 = modifier2.then(modifierThen113.then(companion2));
                    objRememberedValue16 = gapComposer.rememberedValue();
                    if (objRememberedValue16 == neverEqualPolicy2) {
                        objRememberedValue16 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                        gapComposer.updateRememberedValue(objRememberedValue16);
                    }
                    AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy8 = (AnimatedEnterExitMeasurePolicy) objRememberedValue16;
                    int iHashCode8 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope8 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier8 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen114);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, animatedEnterExitMeasurePolicy8, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope8, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m386initimpl(gapComposer, Integer.valueOf(iHashCode8));
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier8, ComposeUiNode.Companion.SetModifier);
                    ComposableLambdaImpl composableLambdaImpl13 = composableLambdaImpl;
                    composableLambdaImpl13.invoke(animatedVisibilityScopeImpl, gapComposer, Integer.valueOf((i3 >> 24) & 112));
                    gapComposer.end(true);
                    z19 = false;
                    gapComposer.end(false);
                    composableLambdaImpl3 = composableLambdaImpl13;
                } else {
                    gapComposer.startReplaceGroup(248647379);
                    if (i4 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    objRememberedValue12 = gapComposer.rememberedValue();
                    if (z11) {
                        objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                        gapComposer.updateRememberedValue(objRememberedValue12);
                    } else {
                        objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                        gapComposer.updateRememberedValue(objRememberedValue12);
                    }
                    animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) objRememberedValue12;
                    twoWayConverterImpl = ArcSplineKt.IntOffsetToVector;
                    objRememberedValue13 = gapComposer.rememberedValue();
                    if (objRememberedValue13 == neverEqualPolicy) {
                        objRememberedValue13 = new ScrollKt$$ExternalSyntheticLambda0((byte) 7);
                        gapComposer.updateRememberedValue(objRememberedValue13);
                    }
                    function0 = (Function0) objRememberedValue13;
                    gapComposer.startReplaceGroup(1018346543);
                    gapComposer.end(false);
                    gapComposer.startReplaceGroup(1018554181);
                    gapComposer.end(false);
                    gapComposer.startReplaceGroup(1018736678);
                    gapComposer.end(false);
                    enterExitTransitionConfig = enterTransitionImpl2.config;
                    changeSizeConfig3 = enterExitTransitionConfig.changeSize;
                    veilConfig3 = enterExitTransitionConfig.veil;
                    if (veilConfig3 == null) {
                        enterExitTransitionConfig2 = enterExitTransitionConfig;
                        transitionInstance2 = transitionInstance;
                        changeSizeConfig4 = changeSizeConfig3;
                        z12 = true;
                    } else {
                        enterExitTransitionConfig2 = enterExitTransitionConfig;
                        transitionInstance2 = transitionInstance;
                        changeSizeConfig4 = changeSizeConfig3;
                        z12 = true;
                    }
                    enterExitTransitionConfig3 = enterExitTransitionConfig2;
                    if (enterExitTransitionConfig3.slide == null) {
                        sharedMutableTransformState2 = sharedMutableTransformState;
                        z13 = true;
                    } else {
                        sharedMutableTransformState2 = sharedMutableTransformState;
                        z13 = true;
                    }
                    if (changeSizeConfig4 == null) {
                        z14 = true;
                    } else {
                        z14 = true;
                    }
                    if (z13) {
                        gapComposer.startReplaceGroup(1019286587);
                        objRememberedValue22 = gapComposer.rememberedValue();
                        if (objRememberedValue22 == neverEqualPolicy) {
                            objRememberedValue22 = "Built-in slide";
                            gapComposer.updateRememberedValue("Built-in slide");
                        }
                        String str9 = (String) objRememberedValue22;
                        neverEqualPolicy2 = neverEqualPolicy;
                        transitionInstance3 = transitionInstance2;
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation11112 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl, str9, gapComposer, 384, 0);
                        twoWayConverterImpl2 = twoWayConverterImpl;
                        gapComposer.end(false);
                        deferredAnimation = deferredAnimationCreateDeferredAnimation11112;
                    } else {
                        twoWayConverterImpl2 = twoWayConverterImpl;
                        neverEqualPolicy2 = neverEqualPolicy;
                        transitionInstance3 = transitionInstance2;
                        gapComposer.startReplaceGroup(1019392390);
                        gapComposer.end(false);
                        deferredAnimation = null;
                    }
                    if (z14) {
                        gapComposer.startReplaceGroup(1019484181);
                        TwoWayConverterImpl twoWayConverterImpl110 = ArcSplineKt.IntSizeToVector;
                        objRememberedValue21 = gapComposer.rememberedValue();
                        if (objRememberedValue21 == neverEqualPolicy2) {
                            objRememberedValue21 = "Built-in shrink/expand";
                            gapComposer.updateRememberedValue("Built-in shrink/expand");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation11113 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl110, (String) objRememberedValue21, gapComposer, 384, 0);
                        gapComposer.end(false);
                        deferredAnimation2 = deferredAnimationCreateDeferredAnimation11113;
                    } else {
                        gapComposer.startReplaceGroup(1019595005);
                        gapComposer.end(false);
                        deferredAnimation2 = null;
                    }
                    if (z14) {
                        gapComposer.startReplaceGroup(1019668631);
                        objRememberedValue20 = gapComposer.rememberedValue();
                        if (objRememberedValue20 == neverEqualPolicy2) {
                            objRememberedValue20 = "Built-in InterruptionHandlingOffset";
                            gapComposer.updateRememberedValue("Built-in InterruptionHandlingOffset");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation11114 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl2, (String) objRememberedValue20, gapComposer, 384, 0);
                        gapComposer.end(false);
                        deferredAnimation3 = deferredAnimationCreateDeferredAnimation11114;
                    } else {
                        gapComposer.startReplaceGroup(1019839037);
                        gapComposer.end(false);
                        deferredAnimation3 = null;
                    }
                    if (changeSizeConfig4 == 0) {
                    }
                    if (veilConfig3 != 0) {
                        if (veilConfig3 != 0) {
                            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                        } else {
                            veilConfig4 = exitTransitionImpl3.config.veil;
                            if (veilConfig4 != null) {
                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                            } else {
                                colorSpaceM483getColorSpaceimpl = null;
                            }
                            if (colorSpaceM483getColorSpaceimpl == null) {
                                veilConfig5 = exitTransitionImpl3.config.veil;
                                if (veilConfig5 != null) {
                                    colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                } else {
                                    colorSpaceM483getColorSpaceimpl = null;
                                }
                                if (colorSpaceM483getColorSpaceimpl == null) {
                                    colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                }
                            }
                        }
                    } else if (veilConfig3 != 0) {
                        colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                    } else {
                        veilConfig4 = exitTransitionImpl3.config.veil;
                        if (veilConfig4 != null) {
                            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                        } else {
                            colorSpaceM483getColorSpaceimpl = null;
                        }
                        if (colorSpaceM483getColorSpaceimpl == null) {
                            veilConfig5 = exitTransitionImpl3.config.veil;
                            if (veilConfig5 != null) {
                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                            } else {
                                colorSpaceM483getColorSpaceimpl = null;
                            }
                            if (colorSpaceM483getColorSpaceimpl == null) {
                                colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                            }
                        }
                    }
                    companion = Modifier.Companion.$$INSTANCE;
                    if (z12) {
                        gapComposer.startReplaceGroup(1020378035);
                        CallsKt$await$2$1 callsKt$await$2$9 = new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl);
                        companion2 = companion;
                        TwoWayConverterImpl twoWayConverterImpl111 = new TwoWayConverterImpl(ColorVectorConverterKt$ColorToVector$1$1.INSTANCE, callsKt$await$2$9);
                        objRememberedValue19 = gapComposer.rememberedValue();
                        if (objRememberedValue19 == neverEqualPolicy2) {
                            objRememberedValue19 = "Built-in veil";
                            gapComposer.updateRememberedValue("Built-in veil");
                        }
                        VeilModifierElement veilModifierElement9 = new VeilModifierElement(transitionInstance3, ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl111, (String) objRememberedValue19, gapComposer, 384, 0), enterTransitionImpl2, exitTransitionImpl3, sharedMutableTransformState2);
                        exitTransitionImpl4 = exitTransitionImpl3;
                        gapComposer.end(false);
                        modifier3 = veilModifierElement9;
                    } else {
                        exitTransitionImpl4 = exitTransitionImpl3;
                        companion2 = companion;
                        gapComposer.startReplaceGroup(1020676162);
                        gapComposer.end(false);
                        modifier3 = companion2;
                    }
                    if (veilConfig3 != 0) {
                        zBooleanValue = veilConfig3.matchParentSize;
                    } else {
                        veilConfig6 = exitTransitionImpl4.config.veil;
                        if (veilConfig6 != null) {
                            zBooleanValue = veilConfig6.matchParentSize;
                        } else {
                            if (sharedMutableTransformState2.mutableData != null) {
                                bool = Boolean.FALSE;
                            } else {
                                bool = null;
                            }
                            if (bool != null) {
                                zBooleanValue = bool.booleanValue();
                            } else {
                                zBooleanValue = false;
                            }
                        }
                    }
                    twoWayConverterImpl3 = ArcSplineKt.FloatToVector;
                    if (enterExitTransitionConfig3.fade != null) {
                        z16 = true;
                    } else {
                        z16 = true;
                    }
                    if (enterExitTransitionConfig3.scale != null) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    if (z16) {
                        gapComposer.startReplaceGroup(-1511857635);
                        objRememberedValue18 = gapComposer.rememberedValue();
                        if (objRememberedValue18 == neverEqualPolicy2) {
                            objRememberedValue18 = "Built-in alpha";
                            gapComposer.updateRememberedValue("Built-in alpha");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation11115 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue18, gapComposer, 384, 0);
                        gapComposer.end(false);
                        deferredAnimation4 = deferredAnimationCreateDeferredAnimation11115;
                    } else {
                        gapComposer.startReplaceGroup(-1511688190);
                        gapComposer.end(false);
                        deferredAnimation4 = null;
                    }
                    if (z17) {
                        gapComposer.startReplaceGroup(-1511620547);
                        objRememberedValue17 = gapComposer.rememberedValue();
                        if (objRememberedValue17 == neverEqualPolicy2) {
                            objRememberedValue17 = "Built-in scale";
                            gapComposer.updateRememberedValue("Built-in scale");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation11116 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue17, gapComposer, 384, 0);
                        z18 = false;
                        gapComposer.end(false);
                        deferredAnimation5 = deferredAnimationCreateDeferredAnimation11116;
                    } else {
                        z18 = false;
                        gapComposer.startReplaceGroup(-1511451102);
                        gapComposer.end(false);
                        deferredAnimation5 = null;
                    }
                    if (z17) {
                        gapComposer.startReplaceGroup(-1511373446);
                        deferredAnimationCreateDeferredAnimation = ArcSplineKt.createDeferredAnimation(transitionInstance3, EnterExitTransitionKt.TransformOriginVectorConverter, "TransformOriginInterruptionHandling", gapComposer, 384, 0);
                        gapComposer.end(z18);
                    } else {
                        gapComposer.startReplaceGroup(-1511201118);
                        gapComposer.end(z18);
                        deferredAnimationCreateDeferredAnimation = null;
                    }
                    zChangedInstance3 = gapComposer.changedInstance(deferredAnimation4) | gapComposer.changed(enterTransitionImpl2) | gapComposer.changed(exitTransitionImpl4) | gapComposer.changedInstance(sharedMutableTransformState2) | gapComposer.changedInstance(deferredAnimation5) | gapComposer.changed(transitionInstance3) | gapComposer.changedInstance(deferredAnimationCreateDeferredAnimation);
                    objRememberedValue14 = gapComposer.rememberedValue();
                    if (zChangedInstance3) {
                        SharedMutableTransformState sharedMutableTransformState19 = sharedMutableTransformState2;
                        exitTransitionImpl5 = exitTransitionImpl4;
                        objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState19, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                        sharedMutableTransformState3 = sharedMutableTransformState19;
                        gapComposer.updateRememberedValue(objRememberedValue14);
                    } else {
                        SharedMutableTransformState sharedMutableTransformState110 = sharedMutableTransformState2;
                        exitTransitionImpl5 = exitTransitionImpl4;
                        objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState110, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                        sharedMutableTransformState3 = sharedMutableTransformState110;
                        gapComposer.updateRememberedValue(objRememberedValue14);
                    }
                    EnterExitTransitionKt$$ExternalSyntheticLambda7 enterExitTransitionKt$$ExternalSyntheticLambda15 = (EnterExitTransitionKt$$ExternalSyntheticLambda7) objRememberedValue14;
                    if (zBooleanValue != 0) {
                        modifier4 = modifier3;
                    } else {
                        modifier4 = companion2;
                    }
                    zChanged6 = gapComposer.changed(z15) | gapComposer.changed(function0);
                    objRememberedValue15 = gapComposer.rememberedValue();
                    if (zChanged6) {
                        objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                        gapComposer.updateRememberedValue(objRememberedValue15);
                    } else {
                        objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                        gapComposer.updateRememberedValue(objRememberedValue15);
                    }
                    Modifier modifierThen115 = modifier4.then(ColorKt.graphicsLayer(companion2, (Function1) objRememberedValue15)).then(new EnterExitTransitionElement(transitionInstance3, deferredAnimation2, deferredAnimation3, deferredAnimation, enterTransitionImpl2, exitTransitionImpl5, sharedMutableTransformState3, function0, enterExitTransitionKt$$ExternalSyntheticLambda15));
                    if (zBooleanValue) {
                        modifier5 = modifier3;
                    } else {
                        modifier5 = companion2;
                    }
                    Modifier modifierThen116 = modifierThen115.then(modifier5);
                    gapComposer.startReplaceGroup(-130485473);
                    gapComposer.end(false);
                    modifier2 = modifier;
                    Modifier modifierThen117 = modifier2.then(modifierThen116.then(companion2));
                    objRememberedValue16 = gapComposer.rememberedValue();
                    if (objRememberedValue16 == neverEqualPolicy2) {
                        objRememberedValue16 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                        gapComposer.updateRememberedValue(objRememberedValue16);
                    }
                    AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy9 = (AnimatedEnterExitMeasurePolicy) objRememberedValue16;
                    int iHashCode9 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope9 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier9 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen117);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, animatedEnterExitMeasurePolicy9, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope9, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m386initimpl(gapComposer, Integer.valueOf(iHashCode9));
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier9, ComposeUiNode.Companion.SetModifier);
                    ComposableLambdaImpl composableLambdaImpl14 = composableLambdaImpl;
                    composableLambdaImpl14.invoke(animatedVisibilityScopeImpl, gapComposer, Integer.valueOf((i3 >> 24) & 112));
                    gapComposer.end(true);
                    z19 = false;
                    gapComposer.end(false);
                    composableLambdaImpl3 = composableLambdaImpl14;
                }
                gapComposer.end(z19);
                composableLambdaImpl4 = composableLambdaImpl3;
            } else {
                gapComposer.startReplaceGroup(246708267);
                i4 = i3 & 14;
                int i17 = i4 | 48;
                int i18 = i17 & 14;
                if ((i18 ^ 6) <= 4) {
                }
                objRememberedValue = gapComposer.rememberedValue();
                neverEqualPolicy = Composer.Companion.Empty;
                if (z6) {
                    objRememberedValue = tagPayloadReader.getCurrentState();
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = tagPayloadReader.getCurrentState();
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                if (transition.isSeeking()) {
                    objRememberedValue = tagPayloadReader.getCurrentState();
                }
                gapComposer.startReplaceGroup(-1260162954);
                enterExitStateTargetEnterExit = targetEnterExit(transition, function1, objRememberedValue, gapComposer);
                gapComposer.end(false);
                Object value8 = parcelableSnapshotMutableState.getValue();
                gapComposer.startReplaceGroup(-1260162954);
                enterExitStateTargetEnterExit2 = targetEnterExit(transition, function1, value8, gapComposer);
                gapComposer.end(false);
                i5 = i18 | 3072;
                i6 = (i5 & 14) ^ 6;
                if (i6 > 4) {
                    i7 = i5;
                    if ((i7 & 6) != 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                } else {
                    i7 = i5;
                    if ((i7 & 6) != 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                }
                objRememberedValue2 = gapComposer.rememberedValue();
                if (z7) {
                    objRememberedValue2 = new TransitionInstance(new MutableTransitionState(enterExitStateTargetEnterExit), transition, transition.label + " > EnterExitTransition");
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new TransitionInstance(new MutableTransitionState(enterExitStateTargetEnterExit), transition, transition.label + " > EnterExitTransition");
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                transitionInstance = (TransitionInstance) objRememberedValue2;
                zChanged = ((i6 <= 4 && gapComposer.changed(transition)) || (i7 & 6) == 4) | gapComposer.changed(transitionInstance);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new BackHandlerKt$$ExternalSyntheticLambda2(transition, transitionInstance, (byte) 5);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new BackHandlerKt$$ExternalSyntheticLambda2(transition, transitionInstance, (byte) 5);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                Stack.DisposableEffect(transitionInstance, (Function1) objRememberedValue3, gapComposer);
                if (transition.isSeeking()) {
                    transitionInstance.seek(enterExitStateTargetEnterExit, enterExitStateTargetEnterExit2);
                } else {
                    transitionInstance.updateTarget$animation_core(enterExitStateTargetEnterExit2);
                    transitionInstance.isSeeking$delegate.setValue(Boolean.FALSE);
                }
                if (transition.isSeeking()) {
                    gapComposer.startReplaceGroup(782386797);
                    value2 = transition.pendingTargetState$delegate.getValue();
                    if (value2 == null) {
                        gapComposer.startReplaceGroup(782437481);
                        gapComposer.end(false);
                        enterExitStateTargetEnterExit3 = null;
                    } else {
                        gapComposer.startReplaceGroup(782437482);
                        gapComposer.startReplaceGroup(-1260162954);
                        enterExitStateTargetEnterExit3 = targetEnterExit(transition, function1, value2, gapComposer);
                        gapComposer.end(false);
                        gapComposer.end(false);
                    }
                    tagPayloadReader3 = transitionInstance.transitionState;
                    parcelableSnapshotMutableState4 = transitionInstance.targetState$delegate;
                    ParcelableSnapshotMutableState parcelableSnapshotMutableState10 = transitionInstance.pendingTargetState$delegate;
                    value3 = parcelableSnapshotMutableState10.getValue();
                    if (value3 == null) {
                        z20 = false;
                    } else {
                        z20 = false;
                    }
                    parcelableSnapshotMutableState10.setValue(enterExitStateTargetEnterExit3);
                    if (z20) {
                        transitionInstance.segment$delegate.setValue(new Transition.SegmentImpl(value3, parcelableSnapshotMutableState4.getValue()));
                        tagPayloadReader3.setCurrentState$animation_core(value3);
                        if (transitionInstance.startTimeNanos$delegate.getLongValue() == Long.MIN_VALUE) {
                            transitionInstance.setUpdateChildrenNeeded(true);
                        }
                        snapshotStateList = transitionInstance._animations;
                        size = snapshotStateList.size();
                        while (i8 < size) {
                            ((Transition.TransitionAnimationState) snapshotStateList.get(i8)).resetSnapValue$delegate.setFloatValue(-2.0f);
                        }
                    }
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(782538635);
                    gapComposer.end(false);
                }
                if (i4 == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                objRememberedValue4 = gapComposer.rememberedValue();
                if (z8) {
                    objRememberedValue4 = new SharedMutableTransformState();
                    gapComposer.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new SharedMutableTransformState();
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                sharedMutableTransformState = (SharedMutableTransformState) objRememberedValue4;
                if (mutableTransform != null) {
                    sharedMutableTransformState.getClass();
                }
                sharedMutableTransformState.mutableData = mutableTransform;
                SystemBarStyle$Companion$$ExternalSyntheticLambda0 systemBarStyle$Companion$$ExternalSyntheticLambda3 = EnterExitTransitionKt.NeutralSlideOffset;
                parcelableSnapshotMutableState2 = sharedMutableTransformState.mutationPhase$delegate;
                gapComposer.startReplaceGroup(-31257052);
                gapComposer.end(false);
                if (transitionInstance.pendingTargetState$delegate.getValue() != null) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                if (transitionInstance.transitionState.getCurrentState() == transitionInstance.targetState$delegate.getValue()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                mutationPhase$animation = sharedMutableTransformState.getMutationPhase$animation();
                mutationPhase = MutationPhase.MutatingPendingCatchUp;
                mutationPhase2 = MutationPhase.Mutating;
                mutationPhase3 = MutationPhase.Handoff;
                if (z9) {
                    if (mutationPhase$animation != MutationPhase.Idle) {
                        sharedMutableTransformState.transformScope.reset();
                        if (z10) {
                            mutationPhase = mutationPhase2;
                        }
                        parcelableSnapshotMutableState2.setValue(mutationPhase);
                        sharedMutableTransformState.scaleHandoffVelocity = null;
                        sharedMutableTransformState.slideHandoffVelocity = null;
                    } else {
                        sharedMutableTransformState.transformScope.reset();
                        if (z10) {
                            mutationPhase = mutationPhase2;
                        }
                        parcelableSnapshotMutableState2.setValue(mutationPhase);
                        sharedMutableTransformState.scaleHandoffVelocity = null;
                        sharedMutableTransformState.slideHandoffVelocity = null;
                    }
                } else if (mutationPhase$animation != mutationPhase) {
                    parcelableSnapshotMutableState2.setValue(mutationPhase3);
                    velocityTracker = sharedMutableTransformState.scaleVelocityTracker;
                    fFloatValue = CropImageView.DEFAULT_ASPECT_RATIO;
                    if (velocityTracker != null) {
                        fM819getXimpl2 = Velocity.m819getXimpl(velocityTracker.m595calculateVelocity9UxMQ8M());
                        fValueOf3 = Float.valueOf(fM819getXimpl2);
                        if (Float.isNaN(fM819getXimpl2)) {
                            fValueOf3 = null;
                        }
                        if (fValueOf3 != null) {
                            fFloatValue2 = fValueOf3.floatValue();
                        } else {
                            fFloatValue2 = 0.0f;
                        }
                    } else {
                        fFloatValue2 = 0.0f;
                    }
                    sharedMutableTransformState.scaleHandoffVelocity = new AnimationVector1D(fFloatValue2);
                    fM819getXimpl = Velocity.m819getXimpl(0L);
                    fValueOf = Float.valueOf(fM819getXimpl);
                    if (Float.isNaN(fM819getXimpl)) {
                        fValueOf = null;
                    }
                    if (fValueOf != null) {
                        fFloatValue3 = fValueOf.floatValue();
                    } else {
                        fFloatValue3 = 0.0f;
                    }
                    fM820getYimpl = Velocity.m820getYimpl(0L);
                    fValueOf2 = Float.valueOf(fM820getYimpl);
                    if (Float.isNaN(fM820getYimpl)) {
                        fValueOf2 = null;
                    }
                    if (fValueOf2 != null) {
                        fFloatValue = fValueOf2.floatValue();
                    }
                    sharedMutableTransformState.slideHandoffVelocity = new AnimationVector2D(fFloatValue3, fFloatValue);
                } else {
                    parcelableSnapshotMutableState2.setValue(mutationPhase3);
                    velocityTracker = sharedMutableTransformState.scaleVelocityTracker;
                    fFloatValue = CropImageView.DEFAULT_ASPECT_RATIO;
                    if (velocityTracker != null) {
                        fM819getXimpl2 = Velocity.m819getXimpl(velocityTracker.m595calculateVelocity9UxMQ8M());
                        fValueOf3 = Float.valueOf(fM819getXimpl2);
                        if (Float.isNaN(fM819getXimpl2)) {
                            fValueOf3 = null;
                        }
                        if (fValueOf3 != null) {
                            fFloatValue2 = fValueOf3.floatValue();
                        } else {
                            fFloatValue2 = 0.0f;
                        }
                    } else {
                        fFloatValue2 = 0.0f;
                    }
                    sharedMutableTransformState.scaleHandoffVelocity = new AnimationVector1D(fFloatValue2);
                    fM819getXimpl = Velocity.m819getXimpl(0L);
                    fValueOf = Float.valueOf(fM819getXimpl);
                    if (Float.isNaN(fM819getXimpl)) {
                        fValueOf = null;
                    }
                    if (fValueOf != null) {
                        fFloatValue3 = fValueOf.floatValue();
                    } else {
                        fFloatValue3 = 0.0f;
                    }
                    fM820getYimpl = Velocity.m820getYimpl(0L);
                    fValueOf2 = Float.valueOf(fM820getYimpl);
                    if (Float.isNaN(fM820getYimpl)) {
                        fValueOf2 = null;
                    }
                    if (fValueOf2 != null) {
                        fFloatValue = fValueOf2.floatValue();
                    }
                    sharedMutableTransformState.slideHandoffVelocity = new AnimationVector2D(fFloatValue3, fFloatValue);
                }
                Boolean boolValueOf4 = Boolean.valueOf(z9);
                zChanged2 = gapComposer.changed(z9) | gapComposer.changed(z10) | gapComposer.changedInstance(sharedMutableTransformState);
                objRememberedValue5 = gapComposer.rememberedValue();
                if (zChanged2) {
                    objRememberedValue5 = new EnterExitTransitionKt$trackActiveMutableState$1$1(z9, z10, sharedMutableTransformState, null);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new EnterExitTransitionKt$trackActiveMutableState$1$1(z9, z10, sharedMutableTransformState, null);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                }
                Stack.LaunchedEffect(gapComposer, boolValueOf4, (Function2) objRememberedValue5);
                zChangedInstance = gapComposer.changedInstance(sharedMutableTransformState);
                objRememberedValue6 = gapComposer.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue6 = new SliderState$$ExternalSyntheticLambda0((byte) 3, sharedMutableTransformState);
                    gapComposer.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new SliderState$$ExternalSyntheticLambda0((byte) 3, sharedMutableTransformState);
                    gapComposer.updateRememberedValue(objRememberedValue6);
                }
                EnterExitTransitionKt.DeferredTransitionCleanupEffect(transitionInstance, (Function0) objRememberedValue6, gapComposer, 0);
                parcelableSnapshotMutableState3 = transitionInstance.targetState$delegate;
                tagPayloadReader2 = transitionInstance.transitionState;
                zChanged3 = gapComposer.changed(transitionInstance);
                objRememberedValue7 = gapComposer.rememberedValue();
                if (zChanged3) {
                    objRememberedValue7 = Stack.mutableStateOf$default(enterTransitionImpl);
                    gapComposer.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = Stack.mutableStateOf$default(enterTransitionImpl);
                    gapComposer.updateRememberedValue(objRememberedValue7);
                }
                mutableState = (MutableState) objRememberedValue7;
                currentState = tagPayloadReader2.getCurrentState();
                value = parcelableSnapshotMutableState3.getValue();
                enterExitState = EnterExitState.PostExit;
                enterExitState2 = EnterExitState.Visible;
                if (currentState == value) {
                    if (parcelableSnapshotMutableState3.getValue() != enterExitState) {
                        mutableState.setValue(((EnterTransitionImpl) mutableState.getValue()).plus(EnterTransitionImpl.None.plus(enterTransitionImpl)));
                    }
                } else if (parcelableSnapshotMutableState3.getValue() != enterExitState) {
                    mutableState.setValue(((EnterTransitionImpl) mutableState.getValue()).plus(EnterTransitionImpl.None.plus(enterTransitionImpl)));
                }
                enterTransitionImpl2 = (EnterTransitionImpl) mutableState.getValue();
                zChanged4 = gapComposer.changed(transitionInstance);
                objRememberedValue8 = gapComposer.rememberedValue();
                if (zChanged4) {
                    objRememberedValue8 = Stack.mutableStateOf$default(exitTransitionImpl);
                    gapComposer.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = Stack.mutableStateOf$default(exitTransitionImpl);
                    gapComposer.updateRememberedValue(objRememberedValue8);
                }
                mutableState2 = (MutableState) objRememberedValue8;
                if (tagPayloadReader2.getCurrentState() == parcelableSnapshotMutableState3.getValue()) {
                    if (parcelableSnapshotMutableState3.getValue() != enterExitState2) {
                        if (sharedMutableTransformState.isMutating()) {
                            exitTransitionImpl2 = (ExitTransitionImpl) mutableState2.getValue();
                        } else {
                            EnterExitTransitionConfig enterExitTransitionConfig9 = ((ExitTransitionImpl) mutableState2.getValue()).config;
                            fadeConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.fade;
                            if (fadeConfig != null) {
                                fadeConfig2 = new FadeConfig(1.0f, fadeConfig.animationSpec);
                            } else {
                                fadeConfig2 = null;
                            }
                            scaleConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.scale;
                            if (scaleConfig != null) {
                                scaleConfig2 = new ScaleConfig(1.0f, scaleConfig.transformOrigin, scaleConfig.animationSpec);
                            } else {
                                scaleConfig2 = null;
                            }
                            slideConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.slide;
                            if (slideConfig != null) {
                                slideConfig2 = new SlideConfig(EnterExitTransitionKt.NeutralSlideOffset, slideConfig.animationSpec);
                            } else {
                                slideConfig2 = null;
                            }
                            changeSizeConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.changeSize;
                            if (changeSizeConfig != null) {
                                changeSizeConfig2 = new ChangeSizeConfig(changeSizeConfig.alignment, EnterExitTransitionKt.NeutralChangeSize, changeSizeConfig.animationSpec, changeSizeConfig.clip);
                            } else {
                                changeSizeConfig2 = null;
                            }
                            veilConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.veil;
                            if (veilConfig != null) {
                                long j6 = veilConfig.initialColor;
                                veilConfig2 = new VeilConfig(j6, j6, veilConfig.animationSpec, veilConfig.matchParentSize);
                            } else {
                                veilConfig2 = null;
                            }
                            exitTransitionImpl2 = new ExitTransitionImpl(new EnterExitTransitionConfig(fadeConfig2, slideConfig2, changeSizeConfig2, scaleConfig2, veilConfig2, enterExitTransitionConfig9.hold, enterExitTransitionConfig9.effectsMap));
                        }
                        mutableState2.setValue(exitTransitionImpl2.plus(ExitTransitionImpl.None).plus(exitTransitionImpl));
                    } else {
                        sharedMutableTransformState = sharedMutableTransformState;
                    }
                } else if (parcelableSnapshotMutableState3.getValue() != enterExitState2) {
                    if (sharedMutableTransformState.isMutating()) {
                        exitTransitionImpl2 = (ExitTransitionImpl) mutableState2.getValue();
                    } else {
                        EnterExitTransitionConfig enterExitTransitionConfig10 = ((ExitTransitionImpl) mutableState2.getValue()).config;
                        fadeConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.fade;
                        if (fadeConfig != null) {
                            fadeConfig2 = new FadeConfig(1.0f, fadeConfig.animationSpec);
                        } else {
                            fadeConfig2 = null;
                        }
                        scaleConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.scale;
                        if (scaleConfig != null) {
                            scaleConfig2 = new ScaleConfig(1.0f, scaleConfig.transformOrigin, scaleConfig.animationSpec);
                        } else {
                            scaleConfig2 = null;
                        }
                        slideConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.slide;
                        if (slideConfig != null) {
                            slideConfig2 = new SlideConfig(EnterExitTransitionKt.NeutralSlideOffset, slideConfig.animationSpec);
                        } else {
                            slideConfig2 = null;
                        }
                        changeSizeConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.changeSize;
                        if (changeSizeConfig != null) {
                            changeSizeConfig2 = new ChangeSizeConfig(changeSizeConfig.alignment, EnterExitTransitionKt.NeutralChangeSize, changeSizeConfig.animationSpec, changeSizeConfig.clip);
                        } else {
                            changeSizeConfig2 = null;
                        }
                        veilConfig = ((ExitTransitionImpl) mutableState2.getValue()).config.veil;
                        if (veilConfig != null) {
                            long j7 = veilConfig.initialColor;
                            veilConfig2 = new VeilConfig(j7, j7, veilConfig.animationSpec, veilConfig.matchParentSize);
                        } else {
                            veilConfig2 = null;
                        }
                        exitTransitionImpl2 = new ExitTransitionImpl(new EnterExitTransitionConfig(fadeConfig2, slideConfig2, changeSizeConfig2, scaleConfig2, veilConfig2, enterExitTransitionConfig10.hold, enterExitTransitionConfig10.effectsMap));
                    }
                    mutableState2.setValue(exitTransitionImpl2.plus(ExitTransitionImpl.None).plus(exitTransitionImpl));
                } else {
                    sharedMutableTransformState = sharedMutableTransformState;
                }
                exitTransitionImpl3 = (ExitTransitionImpl) mutableState2.getValue();
                mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function2, gapComposer);
                objInvoke = function2.invoke(tagPayloadReader2.getCurrentState(), parcelableSnapshotMutableState3.getValue());
                zChanged5 = gapComposer.changed(transitionInstance) | gapComposer.changed(mutableStateRememberUpdatedState);
                objRememberedValue9 = gapComposer.rememberedValue();
                if (zChanged5) {
                    objRememberedValue9 = new RealImageLoader.AnonymousClass2(transitionInstance, mutableStateRememberUpdatedState, null, (byte) 1);
                    gapComposer.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new RealImageLoader.AnonymousClass2(transitionInstance, mutableStateRememberUpdatedState, null, (byte) 1);
                    gapComposer.updateRememberedValue(objRememberedValue9);
                }
                function3 = (Function2) objRememberedValue9;
                objRememberedValue10 = gapComposer.rememberedValue();
                if (objRememberedValue10 == neverEqualPolicy) {
                    objRememberedValue10 = Stack.mutableStateOf$default(objInvoke);
                    gapComposer.updateRememberedValue(objRememberedValue10);
                }
                mutableState3 = (MutableState) objRememberedValue10;
                zChangedInstance2 = gapComposer.changedInstance(function3);
                objRememberedValue11 = gapComposer.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue11 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function3, mutableState3, null, (byte) 0);
                    gapComposer.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function3, mutableState3, null, (byte) 0);
                    gapComposer.updateRememberedValue(objRememberedValue11);
                }
                Stack.LaunchedEffect(gapComposer, Unit.INSTANCE, (Function2) objRememberedValue11);
                if (tagPayloadReader2.getCurrentState() != enterExitState) {
                    gapComposer.startReplaceGroup(248647379);
                    if (i4 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    objRememberedValue12 = gapComposer.rememberedValue();
                    if (z11) {
                        objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                        gapComposer.updateRememberedValue(objRememberedValue12);
                    } else {
                        objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                        gapComposer.updateRememberedValue(objRememberedValue12);
                    }
                    animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) objRememberedValue12;
                    twoWayConverterImpl = ArcSplineKt.IntOffsetToVector;
                    objRememberedValue13 = gapComposer.rememberedValue();
                    if (objRememberedValue13 == neverEqualPolicy) {
                        objRememberedValue13 = new ScrollKt$$ExternalSyntheticLambda0((byte) 7);
                        gapComposer.updateRememberedValue(objRememberedValue13);
                    }
                    function0 = (Function0) objRememberedValue13;
                    gapComposer.startReplaceGroup(1018346543);
                    gapComposer.end(false);
                    gapComposer.startReplaceGroup(1018554181);
                    gapComposer.end(false);
                    gapComposer.startReplaceGroup(1018736678);
                    gapComposer.end(false);
                    enterExitTransitionConfig = enterTransitionImpl2.config;
                    changeSizeConfig3 = enterExitTransitionConfig.changeSize;
                    veilConfig3 = enterExitTransitionConfig.veil;
                    if (veilConfig3 == null) {
                        enterExitTransitionConfig2 = enterExitTransitionConfig;
                        transitionInstance2 = transitionInstance;
                        changeSizeConfig4 = changeSizeConfig3;
                        z12 = true;
                    } else {
                        enterExitTransitionConfig2 = enterExitTransitionConfig;
                        transitionInstance2 = transitionInstance;
                        changeSizeConfig4 = changeSizeConfig3;
                        z12 = true;
                    }
                    enterExitTransitionConfig3 = enterExitTransitionConfig2;
                    if (enterExitTransitionConfig3.slide == null) {
                        sharedMutableTransformState2 = sharedMutableTransformState;
                        z13 = true;
                    } else {
                        sharedMutableTransformState2 = sharedMutableTransformState;
                        z13 = true;
                    }
                    if (changeSizeConfig4 == null) {
                        z14 = true;
                    } else {
                        z14 = true;
                    }
                    if (z13) {
                        gapComposer.startReplaceGroup(1019286587);
                        objRememberedValue22 = gapComposer.rememberedValue();
                        if (objRememberedValue22 == neverEqualPolicy) {
                            objRememberedValue22 = "Built-in slide";
                            gapComposer.updateRememberedValue("Built-in slide");
                        }
                        String str10 = (String) objRememberedValue22;
                        neverEqualPolicy2 = neverEqualPolicy;
                        transitionInstance3 = transitionInstance2;
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation11117 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl, str10, gapComposer, 384, 0);
                        twoWayConverterImpl2 = twoWayConverterImpl;
                        gapComposer.end(false);
                        deferredAnimation = deferredAnimationCreateDeferredAnimation11117;
                    } else {
                        twoWayConverterImpl2 = twoWayConverterImpl;
                        neverEqualPolicy2 = neverEqualPolicy;
                        transitionInstance3 = transitionInstance2;
                        gapComposer.startReplaceGroup(1019392390);
                        gapComposer.end(false);
                        deferredAnimation = null;
                    }
                    if (z14) {
                        gapComposer.startReplaceGroup(1019484181);
                        TwoWayConverterImpl twoWayConverterImpl112 = ArcSplineKt.IntSizeToVector;
                        objRememberedValue21 = gapComposer.rememberedValue();
                        if (objRememberedValue21 == neverEqualPolicy2) {
                            objRememberedValue21 = "Built-in shrink/expand";
                            gapComposer.updateRememberedValue("Built-in shrink/expand");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation11118 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl112, (String) objRememberedValue21, gapComposer, 384, 0);
                        gapComposer.end(false);
                        deferredAnimation2 = deferredAnimationCreateDeferredAnimation11118;
                    } else {
                        gapComposer.startReplaceGroup(1019595005);
                        gapComposer.end(false);
                        deferredAnimation2 = null;
                    }
                    if (z14) {
                        gapComposer.startReplaceGroup(1019668631);
                        objRememberedValue20 = gapComposer.rememberedValue();
                        if (objRememberedValue20 == neverEqualPolicy2) {
                            objRememberedValue20 = "Built-in InterruptionHandlingOffset";
                            gapComposer.updateRememberedValue("Built-in InterruptionHandlingOffset");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation11119 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl2, (String) objRememberedValue20, gapComposer, 384, 0);
                        gapComposer.end(false);
                        deferredAnimation3 = deferredAnimationCreateDeferredAnimation11119;
                    } else {
                        gapComposer.startReplaceGroup(1019839037);
                        gapComposer.end(false);
                        deferredAnimation3 = null;
                    }
                    if (changeSizeConfig4 == 0) {
                    }
                    if (veilConfig3 != 0) {
                        if (veilConfig3 != 0) {
                            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                        } else {
                            veilConfig4 = exitTransitionImpl3.config.veil;
                            if (veilConfig4 != null) {
                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                            } else {
                                colorSpaceM483getColorSpaceimpl = null;
                            }
                            if (colorSpaceM483getColorSpaceimpl == null) {
                                veilConfig5 = exitTransitionImpl3.config.veil;
                                if (veilConfig5 != null) {
                                    colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                } else {
                                    colorSpaceM483getColorSpaceimpl = null;
                                }
                                if (colorSpaceM483getColorSpaceimpl == null) {
                                    colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                }
                            }
                        }
                    } else if (veilConfig3 != 0) {
                        colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                    } else {
                        veilConfig4 = exitTransitionImpl3.config.veil;
                        if (veilConfig4 != null) {
                            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                        } else {
                            colorSpaceM483getColorSpaceimpl = null;
                        }
                        if (colorSpaceM483getColorSpaceimpl == null) {
                            veilConfig5 = exitTransitionImpl3.config.veil;
                            if (veilConfig5 != null) {
                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                            } else {
                                colorSpaceM483getColorSpaceimpl = null;
                            }
                            if (colorSpaceM483getColorSpaceimpl == null) {
                                colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                            }
                        }
                    }
                    companion = Modifier.Companion.$$INSTANCE;
                    if (z12) {
                        gapComposer.startReplaceGroup(1020378035);
                        CallsKt$await$2$1 callsKt$await$2$10 = new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl);
                        companion2 = companion;
                        TwoWayConverterImpl twoWayConverterImpl113 = new TwoWayConverterImpl(ColorVectorConverterKt$ColorToVector$1$1.INSTANCE, callsKt$await$2$10);
                        objRememberedValue19 = gapComposer.rememberedValue();
                        if (objRememberedValue19 == neverEqualPolicy2) {
                            objRememberedValue19 = "Built-in veil";
                            gapComposer.updateRememberedValue("Built-in veil");
                        }
                        VeilModifierElement veilModifierElement10 = new VeilModifierElement(transitionInstance3, ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl113, (String) objRememberedValue19, gapComposer, 384, 0), enterTransitionImpl2, exitTransitionImpl3, sharedMutableTransformState2);
                        exitTransitionImpl4 = exitTransitionImpl3;
                        gapComposer.end(false);
                        modifier3 = veilModifierElement10;
                    } else {
                        exitTransitionImpl4 = exitTransitionImpl3;
                        companion2 = companion;
                        gapComposer.startReplaceGroup(1020676162);
                        gapComposer.end(false);
                        modifier3 = companion2;
                    }
                    if (veilConfig3 != 0) {
                        zBooleanValue = veilConfig3.matchParentSize;
                    } else {
                        veilConfig6 = exitTransitionImpl4.config.veil;
                        if (veilConfig6 != null) {
                            zBooleanValue = veilConfig6.matchParentSize;
                        } else {
                            if (sharedMutableTransformState2.mutableData != null) {
                                bool = Boolean.FALSE;
                            } else {
                                bool = null;
                            }
                            if (bool != null) {
                                zBooleanValue = bool.booleanValue();
                            } else {
                                zBooleanValue = false;
                            }
                        }
                    }
                    twoWayConverterImpl3 = ArcSplineKt.FloatToVector;
                    if (enterExitTransitionConfig3.fade != null) {
                        z16 = true;
                    } else {
                        z16 = true;
                    }
                    if (enterExitTransitionConfig3.scale != null) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    if (z16) {
                        gapComposer.startReplaceGroup(-1511857635);
                        objRememberedValue18 = gapComposer.rememberedValue();
                        if (objRememberedValue18 == neverEqualPolicy2) {
                            objRememberedValue18 = "Built-in alpha";
                            gapComposer.updateRememberedValue("Built-in alpha");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation111110 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue18, gapComposer, 384, 0);
                        gapComposer.end(false);
                        deferredAnimation4 = deferredAnimationCreateDeferredAnimation111110;
                    } else {
                        gapComposer.startReplaceGroup(-1511688190);
                        gapComposer.end(false);
                        deferredAnimation4 = null;
                    }
                    if (z17) {
                        gapComposer.startReplaceGroup(-1511620547);
                        objRememberedValue17 = gapComposer.rememberedValue();
                        if (objRememberedValue17 == neverEqualPolicy2) {
                            objRememberedValue17 = "Built-in scale";
                            gapComposer.updateRememberedValue("Built-in scale");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation111111 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue17, gapComposer, 384, 0);
                        z18 = false;
                        gapComposer.end(false);
                        deferredAnimation5 = deferredAnimationCreateDeferredAnimation111111;
                    } else {
                        z18 = false;
                        gapComposer.startReplaceGroup(-1511451102);
                        gapComposer.end(false);
                        deferredAnimation5 = null;
                    }
                    if (z17) {
                        gapComposer.startReplaceGroup(-1511373446);
                        deferredAnimationCreateDeferredAnimation = ArcSplineKt.createDeferredAnimation(transitionInstance3, EnterExitTransitionKt.TransformOriginVectorConverter, "TransformOriginInterruptionHandling", gapComposer, 384, 0);
                        gapComposer.end(z18);
                    } else {
                        gapComposer.startReplaceGroup(-1511201118);
                        gapComposer.end(z18);
                        deferredAnimationCreateDeferredAnimation = null;
                    }
                    zChangedInstance3 = gapComposer.changedInstance(deferredAnimation4) | gapComposer.changed(enterTransitionImpl2) | gapComposer.changed(exitTransitionImpl4) | gapComposer.changedInstance(sharedMutableTransformState2) | gapComposer.changedInstance(deferredAnimation5) | gapComposer.changed(transitionInstance3) | gapComposer.changedInstance(deferredAnimationCreateDeferredAnimation);
                    objRememberedValue14 = gapComposer.rememberedValue();
                    if (zChangedInstance3) {
                        SharedMutableTransformState sharedMutableTransformState111 = sharedMutableTransformState2;
                        exitTransitionImpl5 = exitTransitionImpl4;
                        objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState111, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                        sharedMutableTransformState3 = sharedMutableTransformState111;
                        gapComposer.updateRememberedValue(objRememberedValue14);
                    } else {
                        SharedMutableTransformState sharedMutableTransformState112 = sharedMutableTransformState2;
                        exitTransitionImpl5 = exitTransitionImpl4;
                        objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState112, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                        sharedMutableTransformState3 = sharedMutableTransformState112;
                        gapComposer.updateRememberedValue(objRememberedValue14);
                    }
                    EnterExitTransitionKt$$ExternalSyntheticLambda7 enterExitTransitionKt$$ExternalSyntheticLambda16 = (EnterExitTransitionKt$$ExternalSyntheticLambda7) objRememberedValue14;
                    if (zBooleanValue != 0) {
                        modifier4 = modifier3;
                    } else {
                        modifier4 = companion2;
                    }
                    zChanged6 = gapComposer.changed(z15) | gapComposer.changed(function0);
                    objRememberedValue15 = gapComposer.rememberedValue();
                    if (zChanged6) {
                        objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                        gapComposer.updateRememberedValue(objRememberedValue15);
                    } else {
                        objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                        gapComposer.updateRememberedValue(objRememberedValue15);
                    }
                    Modifier modifierThen118 = modifier4.then(ColorKt.graphicsLayer(companion2, (Function1) objRememberedValue15)).then(new EnterExitTransitionElement(transitionInstance3, deferredAnimation2, deferredAnimation3, deferredAnimation, enterTransitionImpl2, exitTransitionImpl5, sharedMutableTransformState3, function0, enterExitTransitionKt$$ExternalSyntheticLambda16));
                    if (zBooleanValue) {
                        modifier5 = modifier3;
                    } else {
                        modifier5 = companion2;
                    }
                    Modifier modifierThen119 = modifierThen118.then(modifier5);
                    gapComposer.startReplaceGroup(-130485473);
                    gapComposer.end(false);
                    modifier2 = modifier;
                    Modifier modifierThen1110 = modifier2.then(modifierThen119.then(companion2));
                    objRememberedValue16 = gapComposer.rememberedValue();
                    if (objRememberedValue16 == neverEqualPolicy2) {
                        objRememberedValue16 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                        gapComposer.updateRememberedValue(objRememberedValue16);
                    }
                    AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy10 = (AnimatedEnterExitMeasurePolicy) objRememberedValue16;
                    int iHashCode10 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope10 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier10 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen1110);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, animatedEnterExitMeasurePolicy10, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope10, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m386initimpl(gapComposer, Integer.valueOf(iHashCode10));
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier10, ComposeUiNode.Companion.SetModifier);
                    ComposableLambdaImpl composableLambdaImpl15 = composableLambdaImpl;
                    composableLambdaImpl15.invoke(animatedVisibilityScopeImpl, gapComposer, Integer.valueOf((i3 >> 24) & 112));
                    gapComposer.end(true);
                    z19 = false;
                    gapComposer.end(false);
                    composableLambdaImpl3 = composableLambdaImpl15;
                } else {
                    gapComposer.startReplaceGroup(248647379);
                    if (i4 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    objRememberedValue12 = gapComposer.rememberedValue();
                    if (z11) {
                        objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                        gapComposer.updateRememberedValue(objRememberedValue12);
                    } else {
                        objRememberedValue12 = new AnimatedVisibilityScopeImpl();
                        gapComposer.updateRememberedValue(objRememberedValue12);
                    }
                    animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) objRememberedValue12;
                    twoWayConverterImpl = ArcSplineKt.IntOffsetToVector;
                    objRememberedValue13 = gapComposer.rememberedValue();
                    if (objRememberedValue13 == neverEqualPolicy) {
                        objRememberedValue13 = new ScrollKt$$ExternalSyntheticLambda0((byte) 7);
                        gapComposer.updateRememberedValue(objRememberedValue13);
                    }
                    function0 = (Function0) objRememberedValue13;
                    gapComposer.startReplaceGroup(1018346543);
                    gapComposer.end(false);
                    gapComposer.startReplaceGroup(1018554181);
                    gapComposer.end(false);
                    gapComposer.startReplaceGroup(1018736678);
                    gapComposer.end(false);
                    enterExitTransitionConfig = enterTransitionImpl2.config;
                    changeSizeConfig3 = enterExitTransitionConfig.changeSize;
                    veilConfig3 = enterExitTransitionConfig.veil;
                    if (veilConfig3 == null) {
                        enterExitTransitionConfig2 = enterExitTransitionConfig;
                        transitionInstance2 = transitionInstance;
                        changeSizeConfig4 = changeSizeConfig3;
                        z12 = true;
                    } else {
                        enterExitTransitionConfig2 = enterExitTransitionConfig;
                        transitionInstance2 = transitionInstance;
                        changeSizeConfig4 = changeSizeConfig3;
                        z12 = true;
                    }
                    enterExitTransitionConfig3 = enterExitTransitionConfig2;
                    if (enterExitTransitionConfig3.slide == null) {
                        sharedMutableTransformState2 = sharedMutableTransformState;
                        z13 = true;
                    } else {
                        sharedMutableTransformState2 = sharedMutableTransformState;
                        z13 = true;
                    }
                    if (changeSizeConfig4 == null) {
                        z14 = true;
                    } else {
                        z14 = true;
                    }
                    if (z13) {
                        gapComposer.startReplaceGroup(1019286587);
                        objRememberedValue22 = gapComposer.rememberedValue();
                        if (objRememberedValue22 == neverEqualPolicy) {
                            objRememberedValue22 = "Built-in slide";
                            gapComposer.updateRememberedValue("Built-in slide");
                        }
                        String str11 = (String) objRememberedValue22;
                        neverEqualPolicy2 = neverEqualPolicy;
                        transitionInstance3 = transitionInstance2;
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation111112 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl, str11, gapComposer, 384, 0);
                        twoWayConverterImpl2 = twoWayConverterImpl;
                        gapComposer.end(false);
                        deferredAnimation = deferredAnimationCreateDeferredAnimation111112;
                    } else {
                        twoWayConverterImpl2 = twoWayConverterImpl;
                        neverEqualPolicy2 = neverEqualPolicy;
                        transitionInstance3 = transitionInstance2;
                        gapComposer.startReplaceGroup(1019392390);
                        gapComposer.end(false);
                        deferredAnimation = null;
                    }
                    if (z14) {
                        gapComposer.startReplaceGroup(1019484181);
                        TwoWayConverterImpl twoWayConverterImpl114 = ArcSplineKt.IntSizeToVector;
                        objRememberedValue21 = gapComposer.rememberedValue();
                        if (objRememberedValue21 == neverEqualPolicy2) {
                            objRememberedValue21 = "Built-in shrink/expand";
                            gapComposer.updateRememberedValue("Built-in shrink/expand");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation111113 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl114, (String) objRememberedValue21, gapComposer, 384, 0);
                        gapComposer.end(false);
                        deferredAnimation2 = deferredAnimationCreateDeferredAnimation111113;
                    } else {
                        gapComposer.startReplaceGroup(1019595005);
                        gapComposer.end(false);
                        deferredAnimation2 = null;
                    }
                    if (z14) {
                        gapComposer.startReplaceGroup(1019668631);
                        objRememberedValue20 = gapComposer.rememberedValue();
                        if (objRememberedValue20 == neverEqualPolicy2) {
                            objRememberedValue20 = "Built-in InterruptionHandlingOffset";
                            gapComposer.updateRememberedValue("Built-in InterruptionHandlingOffset");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation111114 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl2, (String) objRememberedValue20, gapComposer, 384, 0);
                        gapComposer.end(false);
                        deferredAnimation3 = deferredAnimationCreateDeferredAnimation111114;
                    } else {
                        gapComposer.startReplaceGroup(1019839037);
                        gapComposer.end(false);
                        deferredAnimation3 = null;
                    }
                    if (changeSizeConfig4 == 0) {
                    }
                    if (veilConfig3 != 0) {
                        if (veilConfig3 != 0) {
                            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                        } else {
                            veilConfig4 = exitTransitionImpl3.config.veil;
                            if (veilConfig4 != null) {
                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                            } else {
                                colorSpaceM483getColorSpaceimpl = null;
                            }
                            if (colorSpaceM483getColorSpaceimpl == null) {
                                veilConfig5 = exitTransitionImpl3.config.veil;
                                if (veilConfig5 != null) {
                                    colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                                } else {
                                    colorSpaceM483getColorSpaceimpl = null;
                                }
                                if (colorSpaceM483getColorSpaceimpl == null) {
                                    colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                                }
                            }
                        }
                    } else if (veilConfig3 != 0) {
                        colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig3.targetColor);
                    } else {
                        veilConfig4 = exitTransitionImpl3.config.veil;
                        if (veilConfig4 != null) {
                            colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig4.initialColor);
                        } else {
                            colorSpaceM483getColorSpaceimpl = null;
                        }
                        if (colorSpaceM483getColorSpaceimpl == null) {
                            veilConfig5 = exitTransitionImpl3.config.veil;
                            if (veilConfig5 != null) {
                                colorSpaceM483getColorSpaceimpl = Color.m483getColorSpaceimpl(veilConfig5.targetColor);
                            } else {
                                colorSpaceM483getColorSpaceimpl = null;
                            }
                            if (colorSpaceM483getColorSpaceimpl == null) {
                                colorSpaceM483getColorSpaceimpl = ColorSpaces.Srgb;
                            }
                        }
                    }
                    companion = Modifier.Companion.$$INSTANCE;
                    if (z12) {
                        gapComposer.startReplaceGroup(1020378035);
                        CallsKt$await$2$1 callsKt$await$2$11 = new CallsKt$await$2$1((byte) 1, colorSpaceM483getColorSpaceimpl);
                        companion2 = companion;
                        TwoWayConverterImpl twoWayConverterImpl115 = new TwoWayConverterImpl(ColorVectorConverterKt$ColorToVector$1$1.INSTANCE, callsKt$await$2$11);
                        objRememberedValue19 = gapComposer.rememberedValue();
                        if (objRememberedValue19 == neverEqualPolicy2) {
                            objRememberedValue19 = "Built-in veil";
                            gapComposer.updateRememberedValue("Built-in veil");
                        }
                        VeilModifierElement veilModifierElement11 = new VeilModifierElement(transitionInstance3, ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl115, (String) objRememberedValue19, gapComposer, 384, 0), enterTransitionImpl2, exitTransitionImpl3, sharedMutableTransformState2);
                        exitTransitionImpl4 = exitTransitionImpl3;
                        gapComposer.end(false);
                        modifier3 = veilModifierElement11;
                    } else {
                        exitTransitionImpl4 = exitTransitionImpl3;
                        companion2 = companion;
                        gapComposer.startReplaceGroup(1020676162);
                        gapComposer.end(false);
                        modifier3 = companion2;
                    }
                    if (veilConfig3 != 0) {
                        zBooleanValue = veilConfig3.matchParentSize;
                    } else {
                        veilConfig6 = exitTransitionImpl4.config.veil;
                        if (veilConfig6 != null) {
                            zBooleanValue = veilConfig6.matchParentSize;
                        } else {
                            if (sharedMutableTransformState2.mutableData != null) {
                                bool = Boolean.FALSE;
                            } else {
                                bool = null;
                            }
                            if (bool != null) {
                                zBooleanValue = bool.booleanValue();
                            } else {
                                zBooleanValue = false;
                            }
                        }
                    }
                    twoWayConverterImpl3 = ArcSplineKt.FloatToVector;
                    if (enterExitTransitionConfig3.fade != null) {
                        z16 = true;
                    } else {
                        z16 = true;
                    }
                    if (enterExitTransitionConfig3.scale != null) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    if (z16) {
                        gapComposer.startReplaceGroup(-1511857635);
                        objRememberedValue18 = gapComposer.rememberedValue();
                        if (objRememberedValue18 == neverEqualPolicy2) {
                            objRememberedValue18 = "Built-in alpha";
                            gapComposer.updateRememberedValue("Built-in alpha");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation111115 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue18, gapComposer, 384, 0);
                        gapComposer.end(false);
                        deferredAnimation4 = deferredAnimationCreateDeferredAnimation111115;
                    } else {
                        gapComposer.startReplaceGroup(-1511688190);
                        gapComposer.end(false);
                        deferredAnimation4 = null;
                    }
                    if (z17) {
                        gapComposer.startReplaceGroup(-1511620547);
                        objRememberedValue17 = gapComposer.rememberedValue();
                        if (objRememberedValue17 == neverEqualPolicy2) {
                            objRememberedValue17 = "Built-in scale";
                            gapComposer.updateRememberedValue("Built-in scale");
                        }
                        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation111116 = ArcSplineKt.createDeferredAnimation(transitionInstance3, twoWayConverterImpl3, (String) objRememberedValue17, gapComposer, 384, 0);
                        z18 = false;
                        gapComposer.end(false);
                        deferredAnimation5 = deferredAnimationCreateDeferredAnimation111116;
                    } else {
                        z18 = false;
                        gapComposer.startReplaceGroup(-1511451102);
                        gapComposer.end(false);
                        deferredAnimation5 = null;
                    }
                    if (z17) {
                        gapComposer.startReplaceGroup(-1511373446);
                        deferredAnimationCreateDeferredAnimation = ArcSplineKt.createDeferredAnimation(transitionInstance3, EnterExitTransitionKt.TransformOriginVectorConverter, "TransformOriginInterruptionHandling", gapComposer, 384, 0);
                        gapComposer.end(z18);
                    } else {
                        gapComposer.startReplaceGroup(-1511201118);
                        gapComposer.end(z18);
                        deferredAnimationCreateDeferredAnimation = null;
                    }
                    zChangedInstance3 = gapComposer.changedInstance(deferredAnimation4) | gapComposer.changed(enterTransitionImpl2) | gapComposer.changed(exitTransitionImpl4) | gapComposer.changedInstance(sharedMutableTransformState2) | gapComposer.changedInstance(deferredAnimation5) | gapComposer.changed(transitionInstance3) | gapComposer.changedInstance(deferredAnimationCreateDeferredAnimation);
                    objRememberedValue14 = gapComposer.rememberedValue();
                    if (zChangedInstance3) {
                        SharedMutableTransformState sharedMutableTransformState113 = sharedMutableTransformState2;
                        exitTransitionImpl5 = exitTransitionImpl4;
                        objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState113, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                        sharedMutableTransformState3 = sharedMutableTransformState113;
                        gapComposer.updateRememberedValue(objRememberedValue14);
                    } else {
                        SharedMutableTransformState sharedMutableTransformState114 = sharedMutableTransformState2;
                        exitTransitionImpl5 = exitTransitionImpl4;
                        objRememberedValue14 = new EnterExitTransitionKt$$ExternalSyntheticLambda7(deferredAnimation4, sharedMutableTransformState114, deferredAnimation5, transitionInstance3, enterTransitionImpl2, exitTransitionImpl5, deferredAnimationCreateDeferredAnimation);
                        sharedMutableTransformState3 = sharedMutableTransformState114;
                        gapComposer.updateRememberedValue(objRememberedValue14);
                    }
                    EnterExitTransitionKt$$ExternalSyntheticLambda7 enterExitTransitionKt$$ExternalSyntheticLambda17 = (EnterExitTransitionKt$$ExternalSyntheticLambda7) objRememberedValue14;
                    if (zBooleanValue != 0) {
                        modifier4 = modifier3;
                    } else {
                        modifier4 = companion2;
                    }
                    zChanged6 = gapComposer.changed(z15) | gapComposer.changed(function0);
                    objRememberedValue15 = gapComposer.rememberedValue();
                    if (zChanged6) {
                        objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                        gapComposer.updateRememberedValue(objRememberedValue15);
                    } else {
                        objRememberedValue15 = new NavigationRailKt$$ExternalSyntheticLambda10((byte) 1, function0, z15);
                        gapComposer.updateRememberedValue(objRememberedValue15);
                    }
                    Modifier modifierThen1111 = modifier4.then(ColorKt.graphicsLayer(companion2, (Function1) objRememberedValue15)).then(new EnterExitTransitionElement(transitionInstance3, deferredAnimation2, deferredAnimation3, deferredAnimation, enterTransitionImpl2, exitTransitionImpl5, sharedMutableTransformState3, function0, enterExitTransitionKt$$ExternalSyntheticLambda17));
                    if (zBooleanValue) {
                        modifier5 = modifier3;
                    } else {
                        modifier5 = companion2;
                    }
                    Modifier modifierThen1112 = modifierThen1111.then(modifier5);
                    gapComposer.startReplaceGroup(-130485473);
                    gapComposer.end(false);
                    modifier2 = modifier;
                    Modifier modifierThen1113 = modifier2.then(modifierThen1112.then(companion2));
                    objRememberedValue16 = gapComposer.rememberedValue();
                    if (objRememberedValue16 == neverEqualPolicy2) {
                        objRememberedValue16 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                        gapComposer.updateRememberedValue(objRememberedValue16);
                    }
                    AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy11 = (AnimatedEnterExitMeasurePolicy) objRememberedValue16;
                    int iHashCode11 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope11 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier11 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen1113);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, animatedEnterExitMeasurePolicy11, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope11, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m386initimpl(gapComposer, Integer.valueOf(iHashCode11));
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier11, ComposeUiNode.Companion.SetModifier);
                    ComposableLambdaImpl composableLambdaImpl16 = composableLambdaImpl;
                    composableLambdaImpl16.invoke(animatedVisibilityScopeImpl, gapComposer, Integer.valueOf((i3 >> 24) & 112));
                    gapComposer.end(true);
                    z19 = false;
                    gapComposer.end(false);
                    composableLambdaImpl3 = composableLambdaImpl16;
                }
                gapComposer.end(z19);
                composableLambdaImpl4 = composableLambdaImpl3;
            }
            z4 = z5;
            composableLambdaImpl2 = composableLambdaImpl4;
        } else {
            modifier2 = modifier;
            gapComposer.skipToGroupEnd();
            z4 = z2;
            composableLambdaImpl2 = composableLambdaImpl5;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SliderKt$$ExternalSyntheticLambda4(transition, function1, modifier2, enterTransitionImpl, exitTransitionImpl, function2, mutableTransform, z4, composableLambdaImpl2, i, i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0083  */
    /* JADX WARN: Code duplicated, block: B:47:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x009b  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:58:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
    public static final void AnimatedVisibility(ColumnScopeInstance columnScopeInstance, boolean z, Modifier modifier, EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, String str, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i, int i2) {
        int i3;
        EnterTransitionImpl enterTransitionImplPlus;
        int i4;
        ExitTransitionImpl exitTransitionImplPlus;
        int i5;
        int i6;
        boolean z2;
        Modifier modifier2;
        ExitTransitionImpl exitTransitionImpl2;
        EnterTransitionImpl enterTransitionImpl2;
        String str2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Object objRememberedValue;
        int i7;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1799879339);
        if ((i & 48) == 0) {
            i3 = (gapComposer.changed(z) ? 32 : 16) | i;
        } else {
            i3 = i;
        }
        int i8 = i3 | 384;
        int i9 = i2 & 4;
        if (i9 == 0) {
            if ((i & 3072) == 0) {
                enterTransitionImplPlus = enterTransitionImpl;
                i8 |= gapComposer.changed(enterTransitionImplPlus) ? 2048 : 1024;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    exitTransitionImplPlus = exitTransitionImpl;
                    if (gapComposer.changed(exitTransitionImplPlus)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i8 |= i5;
                }
                i6 = i8 | 196608;
                if ((1572864 & i) == 0) {
                    if (gapComposer.changedInstance(composableLambdaImpl)) {
                        i7 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i7 = 524288;
                    }
                    i6 |= i7;
                }
                if ((599185 & i6) != 599184) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (gapComposer.shouldExecute(i6 & 1, z2)) {
                    if (i9 != 0) {
                        enterTransitionImplPlus = EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3).plus(EnterExitTransitionKt.expandVertically$default(null, 15));
                    }
                    EnterTransitionImpl enterTransitionImpl3 = enterTransitionImplPlus;
                    if (i4 != 0) {
                        exitTransitionImplPlus = EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3).plus(EnterExitTransitionKt.shrinkVertically$default(null, 15));
                    }
                    TransitionInstance transitionInstanceUpdateTransition = ArcSplineKt.updateTransition(Boolean.valueOf(z), "AnimatedVisibility", gapComposer, ((i6 >> 3) & 14) | ((i6 >> 12) & 112), 0);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 6);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    AnimatedVisibilityImpl(transitionInstanceUpdateTransition, (Function1) objRememberedValue, companion, enterTransitionImpl3, exitTransitionImplPlus, composableLambdaImpl, gapComposer, (i6 & 3670016) | (i6 & 896) | 48 | (i6 & 7168) | (57344 & i6));
                    exitTransitionImpl2 = exitTransitionImplPlus;
                    str2 = "AnimatedVisibility";
                    enterTransitionImpl2 = enterTransitionImpl3;
                    modifier2 = companion;
                } else {
                    gapComposer.skipToGroupEnd();
                    modifier2 = modifier;
                    exitTransitionImpl2 = exitTransitionImplPlus;
                    enterTransitionImpl2 = enterTransitionImplPlus;
                    str2 = str;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new BottomSheetKt$$ExternalSyntheticLambda6(columnScopeInstance, z, modifier2, enterTransitionImpl2, exitTransitionImpl2, str2, composableLambdaImpl, i, i2);
                }
            }
            i8 |= 24576;
            exitTransitionImplPlus = exitTransitionImpl;
            i6 = i8 | 196608;
            if ((1572864 & i) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i7 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i7 = 524288;
                }
                i6 |= i7;
            }
            if ((599185 & i6) != 599184) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (gapComposer.shouldExecute(i6 & 1, z2)) {
                if (i9 != 0) {
                    enterTransitionImplPlus = EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3).plus(EnterExitTransitionKt.expandVertically$default(null, 15));
                }
                EnterTransitionImpl enterTransitionImpl4 = enterTransitionImplPlus;
                if (i4 != 0) {
                    exitTransitionImplPlus = EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3).plus(EnterExitTransitionKt.shrinkVertically$default(null, 15));
                }
                TransitionInstance transitionInstanceUpdateTransition2 = ArcSplineKt.updateTransition(Boolean.valueOf(z), "AnimatedVisibility", gapComposer, ((i6 >> 3) & 14) | ((i6 >> 12) & 112), 0);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 6);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                AnimatedVisibilityImpl(transitionInstanceUpdateTransition2, (Function1) objRememberedValue, companion2, enterTransitionImpl4, exitTransitionImplPlus, composableLambdaImpl, gapComposer, (i6 & 3670016) | (i6 & 896) | 48 | (i6 & 7168) | (57344 & i6));
                exitTransitionImpl2 = exitTransitionImplPlus;
                str2 = "AnimatedVisibility";
                enterTransitionImpl2 = enterTransitionImpl4;
                modifier2 = companion2;
            } else {
                gapComposer.skipToGroupEnd();
                modifier2 = modifier;
                exitTransitionImpl2 = exitTransitionImplPlus;
                enterTransitionImpl2 = enterTransitionImplPlus;
                str2 = str;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new BottomSheetKt$$ExternalSyntheticLambda6(columnScopeInstance, z, modifier2, enterTransitionImpl2, exitTransitionImpl2, str2, composableLambdaImpl, i, i2);
            }
        }
        i8 = i3 | 3456;
        enterTransitionImplPlus = enterTransitionImpl;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                exitTransitionImplPlus = exitTransitionImpl;
                if (gapComposer.changed(exitTransitionImplPlus)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i8 |= i5;
            }
            i6 = i8 | 196608;
            if ((1572864 & i) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i7 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i7 = 524288;
                }
                i6 |= i7;
            }
            if ((599185 & i6) != 599184) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (gapComposer.shouldExecute(i6 & 1, z2)) {
                if (i9 != 0) {
                    enterTransitionImplPlus = EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3).plus(EnterExitTransitionKt.expandVertically$default(null, 15));
                }
                EnterTransitionImpl enterTransitionImpl5 = enterTransitionImplPlus;
                if (i4 != 0) {
                    exitTransitionImplPlus = EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3).plus(EnterExitTransitionKt.shrinkVertically$default(null, 15));
                }
                TransitionInstance transitionInstanceUpdateTransition3 = ArcSplineKt.updateTransition(Boolean.valueOf(z), "AnimatedVisibility", gapComposer, ((i6 >> 3) & 14) | ((i6 >> 12) & 112), 0);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 6);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Modifier.Companion companion3 = Modifier.Companion.$$INSTANCE;
                AnimatedVisibilityImpl(transitionInstanceUpdateTransition3, (Function1) objRememberedValue, companion3, enterTransitionImpl5, exitTransitionImplPlus, composableLambdaImpl, gapComposer, (i6 & 3670016) | (i6 & 896) | 48 | (i6 & 7168) | (57344 & i6));
                exitTransitionImpl2 = exitTransitionImplPlus;
                str2 = "AnimatedVisibility";
                enterTransitionImpl2 = enterTransitionImpl5;
                modifier2 = companion3;
            } else {
                gapComposer.skipToGroupEnd();
                modifier2 = modifier;
                exitTransitionImpl2 = exitTransitionImplPlus;
                enterTransitionImpl2 = enterTransitionImplPlus;
                str2 = str;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new BottomSheetKt$$ExternalSyntheticLambda6(columnScopeInstance, z, modifier2, enterTransitionImpl2, exitTransitionImpl2, str2, composableLambdaImpl, i, i2);
            }
        }
        i8 |= 24576;
        exitTransitionImplPlus = exitTransitionImpl;
        i6 = i8 | 196608;
        if ((1572864 & i) == 0) {
            if (gapComposer.changedInstance(composableLambdaImpl)) {
                i7 = ByteChannelKt.CHANNEL_MAX_SIZE;
            } else {
                i7 = 524288;
            }
            i6 |= i7;
        }
        if ((599185 & i6) != 599184) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (gapComposer.shouldExecute(i6 & 1, z2)) {
            if (i9 != 0) {
                enterTransitionImplPlus = EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3).plus(EnterExitTransitionKt.expandVertically$default(null, 15));
            }
            EnterTransitionImpl enterTransitionImpl6 = enterTransitionImplPlus;
            if (i4 != 0) {
                exitTransitionImplPlus = EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3).plus(EnterExitTransitionKt.shrinkVertically$default(null, 15));
            }
            TransitionInstance transitionInstanceUpdateTransition4 = ArcSplineKt.updateTransition(Boolean.valueOf(z), "AnimatedVisibility", gapComposer, ((i6 >> 3) & 14) | ((i6 >> 12) & 112), 0);
            objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 6);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Modifier.Companion companion4 = Modifier.Companion.$$INSTANCE;
            AnimatedVisibilityImpl(transitionInstanceUpdateTransition4, (Function1) objRememberedValue, companion4, enterTransitionImpl6, exitTransitionImplPlus, composableLambdaImpl, gapComposer, (i6 & 3670016) | (i6 & 896) | 48 | (i6 & 7168) | (57344 & i6));
            exitTransitionImpl2 = exitTransitionImplPlus;
            str2 = "AnimatedVisibility";
            enterTransitionImpl2 = enterTransitionImpl6;
            modifier2 = companion4;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            exitTransitionImpl2 = exitTransitionImplPlus;
            enterTransitionImpl2 = enterTransitionImplPlus;
            str2 = str;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new BottomSheetKt$$ExternalSyntheticLambda6(columnScopeInstance, z, modifier2, enterTransitionImpl2, exitTransitionImpl2, str2, composableLambdaImpl, i, i2);
        }
    }

    public static final void AnimatedVisibilityImpl(TransitionInstance transitionInstance, Function1 function1, Modifier modifier, EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        ComposableLambdaImpl composableLambdaImpl2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-497872534);
        byte b = 2;
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(transitionInstance) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(enterTransitionImpl) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(exitTransitionImpl) ? 16384 : 8192;
        }
        int i3 = i2 | 196608;
        if ((1572864 & i) == 0) {
            composableLambdaImpl2 = composableLambdaImpl;
            i3 |= gapComposer.changedInstance(composableLambdaImpl2) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        } else {
            composableLambdaImpl2 = composableLambdaImpl;
        }
        byte b2 = 1;
        if (gapComposer.shouldExecute(i3 & 1, (599187 & i3) != 599186)) {
            int i4 = i3 & 112;
            int i5 = i3 & 14;
            boolean z = (i4 == 32) | (i5 == 4);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new AlbumMenuKt$$ExternalSyntheticLambda11(function1, transitionInstance, b2);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierLayout = RulerKt.layout(modifier, (Function3) objRememberedValue);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new ScrollState$$ExternalSyntheticLambda3(b);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            AnimatedEnterExitImpl(transitionInstance, function1, modifierLayout, enterTransitionImpl, exitTransitionImpl, (Function2) objRememberedValue2, null, false, composableLambdaImpl2, gapComposer, ((i3 << 9) & 1879048192) | i5 | 196608 | i4 | (i3 & 7168) | (57344 & i3) | (29360128 & (i3 << 6)), 320);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda25(transitionInstance, function1, modifier, enterTransitionImpl, exitTransitionImpl, composableLambdaImpl, i);
        }
    }

    public static final void Crossfade(TransitionInstance transitionInstance, Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, Function1 function1, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        ComposableLambdaImpl composableLambdaImpl2;
        Function1 function2;
        TransitionInstance transitionInstance2 = transitionInstance;
        TagPayloadReader tagPayloadReader = transitionInstance2.transitionState;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1877370462);
        int i2 = (i & 6) == 0 ? (gapComposer.changed(transitionInstance2) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(finiteAnimationSpec) ? 256 : 128;
        }
        int i3 = i2 | 3072;
        if ((i & 24576) == 0) {
            composableLambdaImpl2 = composableLambdaImpl;
            i3 |= gapComposer.changedInstance(composableLambdaImpl2) ? 16384 : 8192;
        } else {
            composableLambdaImpl2 = composableLambdaImpl;
        }
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 9363) != 9362)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 5);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Function1 function3 = (Function1) objRememberedValue;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = CollectionsKt__IterablesKt.mutableListOf(tagPayloadReader.getCurrentState());
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            List list = (List) objRememberedValue2;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                long[] jArr = ScatterMapKt.EmptyGroup;
                objRememberedValue3 = new MutableScatterMap();
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            MutableScatterMap mutableScatterMap = (MutableScatterMap) objRememberedValue3;
            Object value = transitionInstance2.targetState$delegate.getValue();
            if (Intrinsics.areEqual(tagPayloadReader.getCurrentState(), value)) {
                gapComposer.startReplaceGroup(321155112);
                if (list.size() == 1 && Intrinsics.areEqual(list.get(0), value)) {
                    gapComposer.startReplaceGroup(321479744);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(321289466);
                    boolean zChangedInstance = gapComposer.changedInstance(value);
                    Object objRememberedValue4 = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new CrossfadeKt$$ExternalSyntheticLambda2((byte) 0, value);
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    CollectionsKt__MutableCollectionsKt.removeAll(list, (Function1) objRememberedValue4);
                    mutableScatterMap.clear();
                    gapComposer.end(false);
                }
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(321485696);
                gapComposer.end(false);
            }
            if (mutableScatterMap.contains(value)) {
                gapComposer.startReplaceGroup(322289216);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(321546363);
                Iterator it = list.iterator();
                int i4 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i4 = -1;
                        break;
                    } else if (Intrinsics.areEqual(function3.invoke(it.next()), function3.invoke(value))) {
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i4 == -1) {
                    list.add(value);
                } else {
                    list.set(i4, value);
                }
                mutableScatterMap.clear();
                int size = list.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = list.get(i5);
                    mutableScatterMap.set(obj, Expect_jvmKt.rememberComposableLambda(-934471669, new CrossfadeKt$$ExternalSyntheticLambda3(transitionInstance2, finiteAnimationSpec, obj, composableLambdaImpl2, (byte) 0), gapComposer));
                    i5++;
                    transitionInstance2 = transitionInstance;
                    composableLambdaImpl2 = composableLambdaImpl;
                }
                gapComposer.end(false);
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifier);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m386initimpl(gapComposer, Integer.valueOf(iHashCode));
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            gapComposer.startReplaceGroup(-1312707512);
            int size2 = list.size();
            for (int i6 = 0; i6 < size2; i6++) {
                Object obj2 = list.get(i6);
                gapComposer.startMovableGroup(1171574969, function3.invoke(obj2));
                Function2 function4 = (Function2) mutableScatterMap.get(obj2);
                if (function4 == null) {
                    gapComposer.startReplaceGroup(1959122128);
                } else {
                    gapComposer.startReplaceGroup(1171576145);
                    function4.invoke(gapComposer, 0);
                }
                gapComposer.end(false);
                gapComposer.end(false);
            }
            gapComposer.end(false);
            gapComposer.end(true);
            function2 = function3;
        } else {
            gapComposer.skipToGroupEnd();
            function2 = function1;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CrossfadeKt$$ExternalSyntheticLambda4((Object) transitionInstance, (Object) modifier, (Object) finiteAnimationSpec, (Object) function2, (Function2) composableLambdaImpl, i, (byte) 0);
        }
    }

    public static Modifier animateContentSize$default(Modifier modifier, SpringSpec springSpec, int i) {
        if ((i & 1) != 0) {
            Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
            springSpec = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new IntSize(4294967297L), 1);
        }
        return ClipKt.clipToBounds(modifier).then(new SizeAnimationModifierElement(springSpec));
    }

    public static final EnterExitState targetEnterExit(Transition transition, Function1 function1, Object obj, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startMovableGroup(-422486566, transition);
        boolean zIsSeeking = transition.isSeeking();
        TagPayloadReader tagPayloadReader = transition.transitionState;
        EnterExitState enterExitState = EnterExitState.PostExit;
        EnterExitState enterExitState2 = EnterExitState.Visible;
        EnterExitState enterExitState3 = EnterExitState.PreEnter;
        if (zIsSeeking) {
            gapComposer.startReplaceGroup(-212166497);
            gapComposer.end(false);
            if (((Boolean) function1.invoke(obj)).booleanValue()) {
                enterExitState = enterExitState2;
            } else if (!((Boolean) function1.invoke(tagPayloadReader.getCurrentState())).booleanValue()) {
                enterExitState = enterExitState3;
            }
        } else {
            gapComposer.startReplaceGroup(-211886815);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            Object value = transition.pendingTargetState$delegate.getValue();
            if (((Boolean) function1.invoke(tagPayloadReader.getCurrentState())).booleanValue() || (value != null && ((Boolean) function1.invoke(value)).booleanValue())) {
                mutableState.setValue(Boolean.TRUE);
            }
            if (((Boolean) function1.invoke(obj)).booleanValue()) {
                enterExitState = enterExitState2;
            } else if ((value != null && ((Boolean) function1.invoke(value)).booleanValue()) || !((Boolean) mutableState.getValue()).booleanValue()) {
                enterExitState = enterExitState3;
            }
            gapComposer.end(false);
        }
        gapComposer.end(false);
        return enterExitState;
    }

    public static final ContentTransform togetherWith(EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl) {
        new ScrollState$$ExternalSyntheticLambda3((byte) 1);
        return new ContentTransform(enterTransitionImpl, exitTransitionImpl, CropImageView.DEFAULT_ASPECT_RATIO, new SizeTransformImpl());
    }

    public static final void AnimatedContent(Transition transition, Modifier modifier, Function1 function1, Alignment alignment, Function1 function2, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(511725103);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(transition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(alignment) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 131072 : 65536;
        }
        if (gapComposer.shouldExecute(i2 & 1, (74899 & i2) != 74898)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            byte b = 3;
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new SystemBarStyle$Companion$$ExternalSyntheticLambda0(b);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            AnimatedContentImpl(transition, modifier, function1, alignment, function2, (Function1) objRememberedValue, composableLambdaImpl, gapComposer, 196608 | (i2 & 14) | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | ((i2 << 3) & 3670016));
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda25(transition, modifier, function1, alignment, function2, composableLambdaImpl, i);
        }
    }

    public static final void AnimatedVisibility(boolean z, Modifier modifier, EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, String str, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        Modifier modifier2;
        String str2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(234057107);
        int i2 = (gapComposer.changed(z) ? 32 : 16) | i | 384;
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(enterTransitionImpl) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(exitTransitionImpl) ? 16384 : 8192;
        }
        int i3 = i2 | 196608;
        if (gapComposer.shouldExecute(i3 & 1, (599185 & i3) != 599184)) {
            str2 = "AnimatedVisibility";
            TransitionInstance transitionInstanceUpdateTransition = ArcSplineKt.updateTransition(Boolean.valueOf(z), "AnimatedVisibility", gapComposer, ((i3 >> 3) & 14) | 48, 0);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 6);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            AnimatedVisibilityImpl(transitionInstanceUpdateTransition, (Function1) objRememberedValue, companion, enterTransitionImpl, exitTransitionImpl, composableLambdaImpl, gapComposer, (i3 & 57344) | (i3 & 7168) | 432 | 1572864);
            modifier2 = companion;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            str2 = str;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new IconButtonKt$$ExternalSyntheticLambda8(z, modifier2, enterTransitionImpl, exitTransitionImpl, str2, composableLambdaImpl, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0045  */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:30:0x0051  */
    /* JADX WARN: Code duplicated, block: B:32:0x0057  */
    /* JADX WARN: Code duplicated, block: B:33:0x005a  */
    /* JADX WARN: Code duplicated, block: B:37:0x0066  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:40:0x006f  */
    /* JADX WARN: Code duplicated, block: B:44:0x007c  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:55:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
    public static final void AnimatedVisibility(boolean z, Modifier modifier, EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, String str, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        String str2;
        Modifier modifier3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier modifier4;
        Object objRememberedValue;
        int i5;
        int i6;
        int i7;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1448730565);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= gapComposer.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (gapComposer.changed(enterTransitionImpl)) {
                    i7 = 256;
                } else {
                    i7 = 128;
                }
                i3 |= i7;
            }
            if ((i & 3072) == 0) {
                if (gapComposer.changed(exitTransitionImpl)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            i4 = i3 | 24576;
            if ((196608 & i) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i4 |= i5;
            }
            if ((74899 & i4) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (gapComposer.shouldExecute(i4 & 1, z2)) {
                if (i8 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                TransitionInstance transitionInstanceUpdateTransition = ArcSplineKt.updateTransition(Boolean.valueOf(z), "AnimatedVisibility", gapComposer, (i4 & 14) | ((i4 >> 9) & 112), 0);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 6);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                int i9 = i4 << 3;
                AnimatedVisibilityImpl(transitionInstanceUpdateTransition, (Function1) objRememberedValue, modifier4, enterTransitionImpl, exitTransitionImpl, composableLambdaImpl, gapComposer, (i9 & 896) | 48 | (i9 & 7168) | (57344 & i9) | (i9 & 3670016));
                str2 = "AnimatedVisibility";
                modifier3 = modifier4;
            } else {
                gapComposer.skipToGroupEnd();
                str2 = str;
                modifier3 = modifier2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new IconButtonKt$$ExternalSyntheticLambda7(z, modifier3, enterTransitionImpl, exitTransitionImpl, str2, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if (gapComposer.changed(enterTransitionImpl)) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i3 |= i7;
        }
        if ((i & 3072) == 0) {
            if (gapComposer.changed(exitTransitionImpl)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        i4 = i3 | 24576;
        if ((196608 & i) == 0) {
            if (gapComposer.changedInstance(composableLambdaImpl)) {
                i5 = 131072;
            } else {
                i5 = 65536;
            }
            i4 |= i5;
        }
        if ((74899 & i4) != 74898) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (gapComposer.shouldExecute(i4 & 1, z2)) {
            if (i8 != 0) {
                modifier4 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            TransitionInstance transitionInstanceUpdateTransition2 = ArcSplineKt.updateTransition(Boolean.valueOf(z), "AnimatedVisibility", gapComposer, (i4 & 14) | ((i4 >> 9) & 112), 0);
            objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new SystemBarStyle$Companion$$ExternalSyntheticLambda0((byte) 6);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            int i10 = i4 << 3;
            AnimatedVisibilityImpl(transitionInstanceUpdateTransition2, (Function1) objRememberedValue, modifier4, enterTransitionImpl, exitTransitionImpl, composableLambdaImpl, gapComposer, (i10 & 896) | 48 | (i10 & 7168) | (57344 & i10) | (i10 & 3670016));
            str2 = "AnimatedVisibility";
            modifier3 = modifier4;
        } else {
            gapComposer.skipToGroupEnd();
            str2 = str;
            modifier3 = modifier2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new IconButtonKt$$ExternalSyntheticLambda7(z, modifier3, enterTransitionImpl, exitTransitionImpl, str2, composableLambdaImpl, i, i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x006f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0075  */
    /* JADX WARN: Code duplicated, block: B:46:0x0078  */
    /* JADX WARN: Code duplicated, block: B:50:0x0082  */
    /* JADX WARN: Code duplicated, block: B:51:0x0084  */
    /* JADX WARN: Code duplicated, block: B:54:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x008f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0094  */
    /* JADX WARN: Code duplicated, block: B:59:0x0097  */
    /* JADX WARN: Code duplicated, block: B:61:0x00af  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:66:? A[RETURN, SYNTHETIC] */
    public static final void Crossfade(final Object obj, Modifier modifier, final FiniteAnimationSpec finiteAnimationSpec, String str, final ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i, final int i2) {
        int i3;
        String str2;
        boolean z;
        final Modifier modifier2;
        final String str3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        String str4;
        int i4;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-513216493);
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? gapComposer.changed(obj) : gapComposer.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer.changedInstance(finiteAnimationSpec) ? 256 : 128;
        }
        int i6 = i2 & 8;
        if (i6 == 0) {
            if ((i & 3072) == 0) {
                str2 = str;
                i3 |= gapComposer.changed(str2) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i4 = 16384;
                } else {
                    i4 = 8192;
                }
                i3 |= i4;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i3 & 1, z)) {
                if (i5 != 0) {
                    modifier = Modifier.Companion.$$INSTANCE;
                }
                Modifier modifier3 = modifier;
                if (i6 != 0) {
                    str4 = "Crossfade";
                } else {
                    str4 = str2;
                }
                Crossfade(ArcSplineKt.updateTransition(obj, str4, gapComposer, (i3 & 14) | ((i3 >> 6) & 112), 0), modifier3, finiteAnimationSpec, null, composableLambdaImpl, gapComposer, i3 & 58352);
                str3 = str4;
                modifier2 = modifier3;
            } else {
                gapComposer.skipToGroupEnd();
                modifier2 = modifier;
                str3 = str2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        ((Integer) obj3).getClass();
                        CrossfadeKt.Crossfade(obj, modifier2, finiteAnimationSpec, str3, composableLambdaImpl, (Composer) obj2, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i3 |= 3072;
        str2 = str;
        if ((i & 24576) == 0) {
            if (gapComposer.changedInstance(composableLambdaImpl)) {
                i4 = 16384;
            } else {
                i4 = 8192;
            }
            i3 |= i4;
        }
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i3 & 1, z)) {
            if (i5 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            Modifier modifier4 = modifier;
            if (i6 != 0) {
                str4 = "Crossfade";
            } else {
                str4 = str2;
            }
            Crossfade(ArcSplineKt.updateTransition(obj, str4, gapComposer, (i3 & 14) | ((i3 >> 6) & 112), 0), modifier4, finiteAnimationSpec, null, composableLambdaImpl, gapComposer, i3 & 58352);
            str3 = str4;
            modifier2 = modifier4;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            str3 = str2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    CrossfadeKt.Crossfade(obj, modifier2, finiteAnimationSpec, str3, composableLambdaImpl, (Composer) obj2, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
