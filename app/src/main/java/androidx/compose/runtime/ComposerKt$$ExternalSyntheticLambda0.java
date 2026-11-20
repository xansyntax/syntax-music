package androidx.compose.runtime;

import android.app.RemoteAction;
import android.graphics.RectF;
import android.view.textclassifier.TextClassification;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.animation.EnterExitState;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.foundation.gestures.AbstractScrollableNode$setScrollSemanticsActions$1$1;
import androidx.compose.foundation.gestures.DefaultDraggableAnchors;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.ScrollableNode;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextLinkScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda14;
import androidx.compose.material3.ClockDialNode;
import androidx.compose.material3.ClockDialNode$pointerInputTapNode$1$2$1;
import androidx.compose.material3.ModalBottomSheetDialogLayout;
import androidx.compose.material3.SegmentedButtonDefaults;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SheetValue;
import androidx.compose.material3.SwipeToDismissBoxState;
import androidx.compose.material3.SwipeToDismissBoxValue;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.ComposedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.DialogLayout;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComposerKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ComposerKt$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    /* JADX WARN: Code duplicated, block: B:152:0x02d5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:153:0x02d7 A[Catch: all -> 0x02f4, LOOP:7: B:143:0x02ab->B:153:0x02d7, LOOP_END, TryCatch #0 {, blocks: (B:140:0x0296, B:143:0x02ab, B:145:0x02b7, B:147:0x02c1, B:149:0x02c7, B:150:0x02cf, B:153:0x02d7, B:154:0x02da, B:156:0x02e0, B:158:0x02e6), top: B:265:0x0296 }] */
    /* JADX WARN: Code duplicated, block: B:206:0x0430  */
    /* JADX WARN: Code duplicated, block: B:276:0x01b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:295:0x02da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x01ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x01af A[LOOP:2: B:69:0x0179->B:82:0x01af, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        char c;
        char c2;
        Object objPlus;
        boolean zOverlaps;
        char c3 = 7;
        CancellableContinuation cancellableContinuationDeriveStateLocked = null;
        sendChannel = null;
        sendChannel = null;
        sendChannel = null;
        SendChannel sendChannel = null;
        boolean z = false;
        z = false;
        z = false;
        byte b = 1;
        switch (this.$r8$classId) {
            case 0:
                RememberEventDispatcher rememberEventDispatcher = (RememberEventDispatcher) this.f$0;
                ((Integer) obj).getClass();
                if (obj2 instanceof ComposeNodeLifecycleCallback) {
                    ComposeNodeLifecycleCallback composeNodeLifecycleCallback = (ComposeNodeLifecycleCallback) obj2;
                    MutableScatterSet mutableScatterSet = rememberEventDispatcher.releasing;
                    if (mutableScatterSet == null) {
                        MutableScatterSet mutableScatterSet2 = ScatterSetKt.EmptyScatterSet;
                        mutableScatterSet = new MutableScatterSet();
                        rememberEventDispatcher.releasing = mutableScatterSet;
                    }
                    mutableScatterSet.plusAssign(composeNodeLifecycleCallback);
                    rememberEventDispatcher.leaving.add(composeNodeLifecycleCallback);
                }
                if (obj2 instanceof RememberObserverHolder) {
                    rememberEventDispatcher.forgetting((RememberObserverHolder) obj2);
                }
                if (obj2 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj2).release();
                }
                return Unit.INSTANCE;
            case 1:
                ExitTransitionImpl exitTransitionImpl = (ExitTransitionImpl) this.f$0;
                EnterExitState enterExitState = (EnterExitState) obj;
                EnterExitState enterExitState2 = (EnterExitState) obj2;
                EnterExitState enterExitState3 = EnterExitState.PostExit;
                if (enterExitState == enterExitState3 && enterExitState2 == enterExitState3 && !exitTransitionImpl.config.hold) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 2:
                ((Integer) obj2).getClass();
                ((InfiniteTransition) this.f$0).run$animation_core(Stack.updateChangedFlags(1), (Composer) obj);
                return Unit.INSTANCE;
            case 3:
                ScrollableNode scrollableNode = (ScrollableNode) this.f$0;
                AwaitKt.launch$default(scrollableNode.getCoroutineScope(), null, null, new AbstractScrollableNode$setScrollSemanticsActions$1$1(scrollableNode, ((Float) obj).floatValue(), ((Float) obj2).floatValue(), null), 3);
                return Boolean.TRUE;
            case 4:
                return new IntOffset(((long) ((Alignment.Horizontal) this.f$0).align(0, (int) (((IntSize) obj).packedValue >> 32), (LayoutDirection) obj2)) << 32);
            case 5:
                return new IntOffset(((long) ((BiasAlignment.Vertical) this.f$0).align(0, (int) (((IntSize) obj).packedValue & 4294967295L))) & 4294967295L);
            case 6:
                return new IntOffset(((BiasAlignment) this.f$0).mo397alignKFBX0sM(0L, ((IntSize) obj).packedValue, (LayoutDirection) obj2));
            case 7:
                ((Integer) obj2).getClass();
                BasicTextKt.TextFieldCursorHandle((TextFieldSelectionManager) this.f$0, (Composer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 8:
                ((TextDragObserver) this.f$0).mo201onDragk4lQ0M(((Offset) obj2).packedValue);
                return Unit.INSTANCE;
            case 9:
                ((Integer) obj2).getClass();
                ((TextLinkScope) this.f$0).LinksComposables(Stack.updateChangedFlags(1), (Composer) obj);
                return Unit.INSTANCE;
            case 10:
                TextContextMenuItem textContextMenuItem = (TextContextMenuItem) this.f$0;
                ((Integer) obj2).getClass();
                GapComposer gapComposer = (GapComposer) ((Composer) obj);
                gapComposer.startReplaceGroup(666084174);
                String str = textContextMenuItem.label;
                gapComposer.end(false);
                return str;
            case 11:
                TextClassification textClassification = (TextClassification) this.f$0;
                ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) ((Composer) obj);
                gapComposer2.startReplaceGroup(950061013);
                String strValueOf = String.valueOf(textClassification.getLabel());
                gapComposer2.end(false);
                return strValueOf;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                RemoteAction remoteAction = (RemoteAction) this.f$0;
                ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) ((Composer) obj);
                gapComposer3.startReplaceGroup(-1376593684);
                String string = remoteAction.getTitle().toString();
                gapComposer3.end(false);
                return string;
            case 13:
                Ref$LongRef ref$LongRef = (Ref$LongRef) this.f$0;
                ((PointerInputChange) obj).consume();
                ref$LongRef.element = ((Offset) obj2).packedValue;
                return Unit.INSTANCE;
            case 14:
                SheetValue sheetValue = SheetValue.Hidden;
                SheetValue sheetValue2 = SheetValue.Expanded;
                SheetState sheetState = (SheetState) this.f$0;
                DefaultDraggableAnchors defaultDraggableAnchorsDraggableAnchors = ScrollableKt.DraggableAnchors(new BottomSheetKt$$ExternalSyntheticLambda14(Constraints.m783getMaxHeightimpl(((Constraints) obj2).value), sheetState, (int) (((IntSize) obj).packedValue & 4294967295L)));
                NodeChain nodeChain = sheetState.anchoredDraggableState;
                int iOrdinal = ((SheetValue) ((DerivedSnapshotState) nodeChain.tail).getValue()).ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        if (iOrdinal != 2) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        DefaultDraggableAnchors anchors = nodeChain.getAnchors();
                        SheetValue sheetValue3 = SheetValue.PartiallyExpanded;
                        if (anchors.hasPositionFor(sheetValue3) && anchors.hasPositionFor(sheetValue2) && anchors.positionOf(sheetValue3) == anchors.positionOf(sheetValue2) && defaultDraggableAnchorsDraggableAnchors.hasPositionFor(sheetValue2)) {
                            sheetValue = sheetValue2;
                        } else if (defaultDraggableAnchorsDraggableAnchors.hasPositionFor(sheetValue3)) {
                            sheetValue = sheetValue3;
                        } else if (defaultDraggableAnchorsDraggableAnchors.hasPositionFor(sheetValue2)) {
                            sheetValue = sheetValue2;
                        }
                    } else if (defaultDraggableAnchorsDraggableAnchors.hasPositionFor(sheetValue2)) {
                        sheetValue = sheetValue2;
                    }
                }
                return new Pair(defaultDraggableAnchorsDraggableAnchors, sheetValue);
            case 15:
                ClockDialNode clockDialNode = (ClockDialNode) this.f$0;
                AwaitKt.launch$default(clockDialNode.getCoroutineScope(), null, null, new ClockDialNode$pointerInputTapNode$1$2$1(clockDialNode, (Offset) obj2, cancellableContinuationDeriveStateLocked, b), 3);
                return Unit.INSTANCE;
            case 16:
                ((Integer) obj2).getClass();
                ((ModalBottomSheetDialogLayout) this.f$0).Content(Stack.updateChangedFlags(1), (Composer) obj);
                return Unit.INSTANCE;
            case 17:
                ((Integer) obj2).getClass();
                ((SegmentedButtonDefaults) this.f$0).ActiveIcon(Stack.updateChangedFlags(7), (Composer) obj);
                return Unit.INSTANCE;
            case 18:
                SwipeToDismissBoxState swipeToDismissBoxState = (SwipeToDismissBoxState) this.f$0;
                DraggableAnchorsConfig draggableAnchorsConfig = new DraggableAnchorsConfig();
                float f = (int) (((IntSize) obj).packedValue >> 32);
                SwipeToDismissBoxValue swipeToDismissBoxValue = SwipeToDismissBoxValue.Settled;
                draggableAnchorsConfig.at(CropImageView.DEFAULT_ASPECT_RATIO, swipeToDismissBoxValue);
                draggableAnchorsConfig.at(f, SwipeToDismissBoxValue.StartToEnd);
                draggableAnchorsConfig.at(-f, SwipeToDismissBoxValue.EndToStart);
                ArrayList arrayList = draggableAnchorsConfig.keys;
                float[] fArr = draggableAnchorsConfig.positions;
                int size = arrayList.size();
                Okio__OkioKt.copyOfRangeToIndexCheck(size, fArr.length);
                float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, 0, size);
                fArrCopyOfRange.getClass();
                DefaultDraggableAnchors defaultDraggableAnchors = new DefaultDraggableAnchors(arrayList, fArrCopyOfRange);
                NodeChain nodeChain2 = swipeToDismissBoxState.anchoredDraggableState;
                boolean z2 = nodeChain2.getAnchors().size > 0;
                SwipeToDismissBoxValue currentValue = swipeToDismissBoxState.getCurrentValue();
                SwipeToDismissBoxValue swipeToDismissBoxValue2 = (SwipeToDismissBoxValue) ((DerivedSnapshotState) nodeChain2.tail).getValue();
                if (!z2 && defaultDraggableAnchors.hasPositionFor(currentValue)) {
                    swipeToDismissBoxValue = currentValue;
                } else if (defaultDraggableAnchors.hasPositionFor(swipeToDismissBoxValue2)) {
                    swipeToDismissBoxValue = swipeToDismissBoxValue2;
                }
                return new Pair(defaultDraggableAnchors, swipeToDismissBoxValue);
            case 19:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer;
                if (gapComposer4.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    throw null;
                }
                gapComposer4.skipToGroupEnd();
                return Unit.INSTANCE;
            case 20:
                MultiSubscriptionSnapshotFlowManager multiSubscriptionSnapshotFlowManager = (MultiSubscriptionSnapshotFlowManager) this.f$0;
                Set set = (Set) obj;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                synchronized (multiSubscriptionSnapshotFlowManager.output) {
                    MutableScatterMap mutableScatterMap = multiSubscriptionSnapshotFlowManager.subscriptions;
                    UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0 = new UtilsKt$$ExternalSyntheticLambda0((Object) set, (Object) multiSubscriptionSnapshotFlowManager, (Object) ref$ObjectRef, (byte) 20);
                    TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, utilsKt$$ExternalSyntheticLambda0);
                    Object[] objArr = mutableScatterMap.keys;
                    long[] jArr = mutableScatterMap.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i = 0;
                        while (true) {
                            long j = jArr[i];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i2 = 8 - ((~(i - length)) >>> 31);
                                for (int i3 = 0; i3 < i2; i3++) {
                                    if ((j & 255) < 128) {
                                        utilsKt$$ExternalSyntheticLambda0.invoke(objArr[(i << 3) + i3]);
                                    }
                                    j >>= 8;
                                }
                                if (i2 == 8) {
                                    if (i != length) {
                                        i++;
                                    }
                                }
                            } else if (i != length) {
                                i++;
                            }
                        }
                    }
                    List list = (List) ref$ObjectRef.element;
                    if (list != null) {
                        int size2 = list.size();
                        for (int i4 = 0; i4 < size2; i4++) {
                            ((SendChannel) list.get(i4)).mo1712trySendJP2dKIU(Unit.INSTANCE);
                        }
                    }
                }
                return Unit.INSTANCE;
            case 21:
                Recomposer recomposer = (Recomposer) this.f$0;
                Set set2 = (Set) obj;
                synchronized (recomposer.stateLock) {
                    try {
                        if (((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.Idle) >= 0) {
                            MutableScatterSet mutableScatterSet3 = recomposer.snapshotInvalidations;
                            if (set2 instanceof ScatterSetWrapper) {
                                MutableScatterSet mutableScatterSet4 = ((ScatterSetWrapper) set2).set;
                                Object[] objArr2 = mutableScatterSet4.elements;
                                long[] jArr2 = mutableScatterSet4.metadata;
                                int length2 = jArr2.length - 2;
                                if (length2 >= 0) {
                                    int i5 = 0;
                                    while (true) {
                                        long j2 = jArr2[i5];
                                        if ((((~j2) << c3) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i6 = 8 - ((~(i5 - length2)) >>> 31);
                                            int i7 = 0;
                                            while (i7 < i6) {
                                                if ((j2 & 255) < 128) {
                                                    Object obj3 = objArr2[(i5 << 3) + i7];
                                                    c2 = c3;
                                                    if (!(obj3 instanceof StateObjectImpl) || ((StateObjectImpl) obj3).m395isReadInh_f27i8$runtime(1)) {
                                                        mutableScatterSet3.add(obj3);
                                                    }
                                                } else {
                                                    c2 = c3;
                                                }
                                                j2 >>= 8;
                                                i7++;
                                                c3 = c2;
                                            }
                                            c = c3;
                                            if (i6 == 8) {
                                            }
                                        } else {
                                            c = c3;
                                        }
                                        if (i5 != length2) {
                                            i5++;
                                            c3 = c;
                                        }
                                    }
                                }
                            } else {
                                for (Object obj4 : set2) {
                                    if (!(obj4 instanceof StateObjectImpl) || ((StateObjectImpl) obj4).m395isReadInh_f27i8$runtime(1)) {
                                        mutableScatterSet3.add(obj4);
                                    }
                                }
                            }
                            cancellableContinuationDeriveStateLocked = recomposer.deriveStateLocked();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                if (cancellableContinuationDeriveStateLocked != null) {
                    ((CancellableContinuationImpl) cancellableContinuationDeriveStateLocked).resumeWith(Unit.INSTANCE);
                }
                return Unit.INSTANCE;
            case 22:
                SingleSubscriptionSnapshotFlowManager singleSubscriptionSnapshotFlowManager = (SingleSubscriptionSnapshotFlowManager) this.f$0;
                Set set3 = (Set) obj;
                synchronized (singleSubscriptionSnapshotFlowManager.output) {
                    try {
                        MutableScatterSet mutableScatterSet5 = singleSubscriptionSnapshotFlowManager.watchSet;
                        if (mutableScatterSet5 != null) {
                            Object[] objArr3 = mutableScatterSet5.elements;
                            long[] jArr3 = mutableScatterSet5.metadata;
                            int length3 = jArr3.length - 2;
                            if (length3 >= 0) {
                                int i8 = 0;
                                while (true) {
                                    long j3 = jArr3[i8];
                                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i9 = 8 - ((~(i8 - length3)) >>> 31);
                                        int i10 = 0;
                                        while (true) {
                                            if (i10 < i9) {
                                                if ((j3 & 255) >= 128 || !set3.contains(objArr3[(i8 << 3) + i10])) {
                                                    j3 >>= 8;
                                                    i10++;
                                                } else {
                                                    sendChannel = singleSubscriptionSnapshotFlowManager.subscribedChannel;
                                                }
                                            } else if (i9 == 8) {
                                                if (i8 != length3) {
                                                    i8++;
                                                }
                                            }
                                        }
                                    } else if (i8 != length3) {
                                        i8++;
                                    }
                                }
                            }
                        } else if (CollectionsKt.contains(set3, singleSubscriptionSnapshotFlowManager.soleWatchedObject)) {
                            sendChannel = singleSubscriptionSnapshotFlowManager.subscribedChannel;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (sendChannel != null) {
                    sendChannel.mo1712trySendJP2dKIU(Unit.INSTANCE);
                }
                return Unit.INSTANCE;
            case 23:
                Saver saver = (Saver) this.f$0;
                SaveableHolder saveableHolder = (SaveableHolder) obj;
                MutableState mutableState = (MutableState) obj2;
                if (!(mutableState instanceof SnapshotMutableState)) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("If you use a custom MutableState implementation you have to write a custom Saver and pass it as a saver param to rememberSaveable()");
                    return null;
                }
                SnapshotMutableState snapshotMutableState = (SnapshotMutableState) mutableState;
                Object objSave = saver.save(saveableHolder, snapshotMutableState.getValue());
                if (objSave == null) {
                    return null;
                }
                NeverEqualPolicy policy = snapshotMutableState.getPolicy();
                policy.getClass();
                return new ParcelableSnapshotMutableState(objSave, policy);
            case 24:
                SnapshotStateObserver snapshotStateObserver = (SnapshotStateObserver) this.f$0;
                Set set4 = (Set) obj;
                AtomicReference atomicReference = snapshotStateObserver.pendingChanges;
                while (true) {
                    Object obj5 = atomicReference.get();
                    if (obj5 == null) {
                        objPlus = set4;
                    } else if (obj5 instanceof Set) {
                        objPlus = CollectionsKt__IterablesKt.listOf((Object[]) new Set[]{obj5, set4});
                    } else {
                        if (!(obj5 instanceof List)) {
                            ComposerKt.composeRuntimeError("Unexpected notification");
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                            return null;
                        }
                        objPlus = CollectionsKt.plus((Iterable) CollectionsKt__IterablesKt.listOf(set4), (Collection) obj5);
                    }
                    do {
                        if (atomicReference.compareAndSet(obj5, objPlus)) {
                            if (snapshotStateObserver.drainChanges()) {
                                snapshotStateObserver.onChangedExecutor.invoke(new RoomDatabase$$ExternalSyntheticLambda0((byte) 5, snapshotStateObserver));
                            }
                            return Unit.INSTANCE;
                        }
                    } while (atomicReference.get() == obj5);
                }
                break;
            case 25:
                Composer composer2 = (Composer) this.f$0;
                Modifier modifier = (Modifier) obj;
                Modifier modifierMaterializeImpl = (Modifier.Element) obj2;
                if (modifierMaterializeImpl instanceof ComposedModifier) {
                    Function3 function3 = ((ComposedModifier) modifierMaterializeImpl).factory;
                    TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, function3);
                    modifierMaterializeImpl = ZIndexModifierKt.materializeImpl(composer2, (Modifier) function3.invoke(Modifier.Companion.$$INSTANCE, composer2, 0));
                }
                return modifier.then(modifierMaterializeImpl);
            case 26:
                AbstractComposeView abstractComposeView = (AbstractComposeView) this.f$0;
                Composer composer3 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer3;
                if (gapComposer5.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    abstractComposeView.Content(0, gapComposer5);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 27:
                ((Integer) obj2).getClass();
                ((ComposeView) this.f$0).Content(Stack.updateChangedFlags(1), (Composer) obj);
                return Unit.INSTANCE;
            case 28:
                ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 = (ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0) this.f$0;
                Rect composeRect = ColorKt.toComposeRect((RectF) obj);
                Rect composeRect2 = ColorKt.toComposeRect((RectF) obj2);
                switch (viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0.$r8$classId) {
                    case 24:
                        zOverlaps = composeRect.overlaps(composeRect2);
                        break;
                    default:
                        zOverlaps = composeRect2.m442containsk4lQ0M(composeRect.m443getCenterF1C5BW0());
                        break;
                }
                return Boolean.valueOf(zOverlaps);
            default:
                ((Integer) obj2).getClass();
                ((DialogLayout) this.f$0).Content(Stack.updateChangedFlags(1), (Composer) obj);
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ ComposerKt$$ExternalSyntheticLambda0(Object obj, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }
}
