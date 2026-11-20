package androidx.compose.ui.node;

import android.os.Handler;
import androidx.collection.ArrayMap;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.AnchoredDraggableState$$ExternalSyntheticLambda1;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.DefaultDraggableAnchors;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.GraphicsLayerOwnerLayer;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.ListenerSet$$ExternalSyntheticLambda0;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.StuckPlayerDetector$StuckBufferingDetector;
import androidx.media3.common.util.StuckPlayerDetector$StuckPlayingDetector;
import androidx.media3.common.util.StuckPlayerDetector$StuckPlayingNotEndingDetector;
import androidx.media3.common.util.StuckPlayerDetector$StuckSuppressedDetector;
import androidx.media3.common.util.SystemClock;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda52;
import androidx.media3.session.SequencedFutureManager$SequencedFuture;
import com.dokar.quickjs.QuickJs;
import com.metrolist.innertubex.InnerTube$executeMutation$2$1;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NodeChain {
    public final /* synthetic */ byte $r8$classId;
    public Object buffers;
    public Object cachedDiffer;
    public Object current;
    public Object head;
    public final Object innerCoordinator;
    public Object layoutNode;
    public Object outerCoordinator;
    public final Object sentinelHead;
    public Object stack;
    public final Object tail;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Differ {
        public Object after;
        public int offset;
        public boolean shouldAttachOnInsert;
        public Object this$0;
        public Object node = new Object();
        public Object before = new ArrayMap(0);

        public boolean areItemsTheSame(int i, int i2) {
            Modifier.Element element = (Modifier.Element) ((MutableObjectList) this.before).get(this.offset + i);
            Modifier.Element element2 = (Modifier.Element) ((MutableObjectList) this.after).get(this.offset + i2);
            return Intrinsics.areEqual(element, element2) || element.getClass() == element2.getClass();
        }

        public SequencedFutureManager$SequencedFuture createSequencedFuture(Object obj) {
            SequencedFutureManager$SequencedFuture sequencedFutureManager$SequencedFuture;
            synchronized (this.node) {
                try {
                    int iObtainNextSequenceNumber = obtainNextSequenceNumber();
                    sequencedFutureManager$SequencedFuture = new SequencedFutureManager$SequencedFuture(iObtainNextSequenceNumber, obj);
                    if (this.shouldAttachOnInsert) {
                        sequencedFutureManager$SequencedFuture.setWithTheValueOfResultWhenClosed();
                    } else {
                        ((ArrayMap) this.before).put(Integer.valueOf(iObtainNextSequenceNumber), sequencedFutureManager$SequencedFuture);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return sequencedFutureManager$SequencedFuture;
        }

        public int obtainNextSequenceNumber() {
            int i;
            synchronized (this.node) {
                i = this.offset;
                this.offset = i + 1;
            }
            return i;
        }

        public void release() {
            ArrayList arrayList;
            synchronized (this.node) {
                try {
                    this.shouldAttachOnInsert = true;
                    arrayList = new ArrayList(((ArrayMap) this.before).values());
                    ((ArrayMap) this.before).clear();
                    if (((MediaControllerImplBase$$ExternalSyntheticLambda52) this.after) != null) {
                        Handler handler = (Handler) this.this$0;
                        handler.getClass();
                        handler.post((MediaControllerImplBase$$ExternalSyntheticLambda52) this.after);
                        this.after = null;
                        this.this$0 = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((SequencedFutureManager$SequencedFuture) obj).setWithTheValueOfResultWhenClosed();
            }
        }

        public void setFutureResult(int i, Object obj) {
            synchronized (this.node) {
                try {
                    SequencedFutureManager$SequencedFuture sequencedFutureManager$SequencedFuture = (SequencedFutureManager$SequencedFuture) ((ArrayMap) this.before).remove(Integer.valueOf(i));
                    if (sequencedFutureManager$SequencedFuture != null) {
                        if (sequencedFutureManager$SequencedFuture.resultWhenClosed.getClass() == obj.getClass()) {
                            sequencedFutureManager$SequencedFuture.set(obj);
                        } else {
                            Log.w("SequencedFutureManager", "Type mismatch, expected " + sequencedFutureManager$SequencedFuture.resultWhenClosed.getClass() + ", but was " + obj.getClass());
                        }
                    }
                    if (((MediaControllerImplBase$$ExternalSyntheticLambda52) this.after) != null && ((ArrayMap) this.before).isEmpty()) {
                        release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public NodeChain(Enum r3) {
        this.$r8$classId = (byte) 1;
        this.layoutNode = new BorderKt$$ExternalSyntheticLambda1((byte) 23);
        this.sentinelHead = new MutatorMutex();
        this.innerCoordinator = Stack.mutableStateOf$default(r3);
        this.outerCoordinator = Stack.mutableStateOf$default(r3);
        this.tail = SnapshotStateKt__DerivedStateKt.derivedStateOf(new AnchoredDraggableState$$ExternalSyntheticLambda1(this, (byte) 0));
        this.head = new ParcelableSnapshotMutableFloatState(Float.NaN);
        new AtomicInt(0);
        SnapshotKt.currentSnapshot().getSnapshotId();
        ObjectIntMapKt.EmptyObjectIntMap.getClass();
        this.current = new ParcelableSnapshotMutableFloatState(CropImageView.DEFAULT_ASPECT_RATIO);
        this.buffers = Stack.mutableStateOf$default(null);
        this.stack = Stack.mutableStateOf$default(new DefaultDraggableAnchors(EmptyList.INSTANCE, new float[0]));
        this.cachedDiffer = new AnchoredDraggableState$anchoredDragScope$1(this);
    }

    public static Object anchoredDrag$default(NodeChain nodeChain, Function3 function3, ContinuationImpl continuationImpl) {
        Object objMutate = ((MutatorMutex) nodeChain.sentinelHead).mutate(MutatePriority.Default, new InnerTube$executeMutation$2$1(nodeChain, function3, null, (byte) 1), continuationImpl);
        return objMutate == CoroutineSingletons.COROUTINE_SUSPENDED ? objMutate : Unit.INSTANCE;
    }

    public static Modifier.Node createAndInsertNodeAsChild(Modifier.Element element, Modifier.Node node) {
        Modifier.Node nodeCreate;
        if (element instanceof ModifierNodeElement) {
            nodeCreate = ((ModifierNodeElement) element).create();
            nodeCreate.kindSet = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(nodeCreate);
        } else {
            BackwardsCompatNode backwardsCompatNode = new BackwardsCompatNode();
            backwardsCompatNode.kindSet = NodeKindKt.calculateNodeKindSetFrom(element);
            backwardsCompatNode.element = element;
            new HashSet();
            nodeCreate = backwardsCompatNode;
        }
        if (nodeCreate.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("A ModifierNodeElement cannot return an already attached node from create() ");
        }
        nodeCreate.insertedNodeAwaitingAttachForInvalidation = true;
        Modifier.Node node2 = node.child;
        if (node2 != null) {
            node2.parent = nodeCreate;
            nodeCreate.child = node2;
        }
        node.child = nodeCreate;
        nodeCreate.parent = node;
        return nodeCreate;
    }

    public static Modifier.Node detachAndRemoveNode(Modifier.Node node) {
        boolean z = node.isAttached;
        if (z) {
            MutableObjectIntMap mutableObjectIntMap = NodeKindKt.classToKindSetMap;
            if (!z) {
                InlineClassHelperKt.throwIllegalStateException("autoInvalidateRemovedNode called on unattached node");
            }
            NodeKindKt.autoInvalidateNodeIncludingDelegates(node, -1, 2);
            node.runDetachLifecycle$ui();
            node.markAsDetached$ui();
        }
        Modifier.Node node2 = node.child;
        Modifier.Node node3 = node.parent;
        if (node2 != null) {
            node2.parent = node3;
            node.child = null;
        }
        if (node3 != null) {
            node3.child = node2;
            node.parent = null;
        }
        node3.getClass();
        return node3;
    }

    public static void updateNode(Modifier.Element element, Modifier.Element element2, Modifier.Node node) {
        if ((element instanceof ModifierNodeElement) && (element2 instanceof ModifierNodeElement)) {
            node.getClass();
            ((ModifierNodeElement) element2).update(node);
            if (node.isAttached) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
                return;
            } else {
                node.updatedNodeAwaitingAttachForInvalidation = true;
                return;
            }
        }
        if (!(node instanceof BackwardsCompatNode)) {
            InlineClassHelperKt.throwIllegalStateException("Unknown Modifier.Node type");
            return;
        }
        BackwardsCompatNode backwardsCompatNode = (BackwardsCompatNode) node;
        boolean z = backwardsCompatNode.isAttached;
        if (z) {
            if (!z) {
                InlineClassHelperKt.throwIllegalStateException("unInitializeModifier called on unattached node");
            }
            if ((backwardsCompatNode.kindSet & 8) != 0) {
                ((AndroidComposeView) HitTestResultKt.requireOwner(backwardsCompatNode)).onSemanticsChange();
            }
        }
        backwardsCompatNode.element = element2;
        backwardsCompatNode.kindSet = NodeKindKt.calculateNodeKindSetFrom(element2);
        if (backwardsCompatNode.isAttached) {
            backwardsCompatNode.initializeModifier(false);
        }
        if (node.isAttached) {
            NodeKindKt.autoInvalidateUpdatedNode(node);
        } else {
            node.updatedNodeAwaitingAttachForInvalidation = true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public Object anchoredDrag(Object obj, MutatePriority mutatePriority, Function4 function4, ContinuationImpl continuationImpl) {
        AnchoredDraggableState$anchoredDrag$3 anchoredDraggableState$anchoredDrag$3;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = (ParcelableSnapshotMutableState) this.buffers;
        if (continuationImpl instanceof AnchoredDraggableState$anchoredDrag$3) {
            anchoredDraggableState$anchoredDrag$3 = (AnchoredDraggableState$anchoredDrag$3) continuationImpl;
            int i = anchoredDraggableState$anchoredDrag$3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anchoredDraggableState$anchoredDrag$3.label = i - Integer.MIN_VALUE;
            } else {
                anchoredDraggableState$anchoredDrag$3 = new AnchoredDraggableState$anchoredDrag$3(this, continuationImpl);
            }
        } else {
            anchoredDraggableState$anchoredDrag$3 = new AnchoredDraggableState$anchoredDrag$3(this, continuationImpl);
        }
        Object obj2 = anchoredDraggableState$anchoredDrag$3.result;
        int i2 = anchoredDraggableState$anchoredDrag$3.label;
        Continuation continuation = null;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj2);
                if (getAnchors().hasPositionFor(obj)) {
                    MutatorMutex mutatorMutex = (MutatorMutex) this.sentinelHead;
                    QuickJs.C00594 c00594 = new QuickJs.C00594((Object) this, obj, (Object) function4, continuation, (byte) 1);
                    anchoredDraggableState$anchoredDrag$3.label = 1;
                    Object objMutate = mutatorMutex.mutate(mutatePriority, c00594, anchoredDraggableState$anchoredDrag$3);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objMutate == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else if (((Boolean) ((Function1) this.layoutNode).invoke(obj)).booleanValue()) {
                    ((ParcelableSnapshotMutableState) this.outerCoordinator).setValue(obj);
                    ((ParcelableSnapshotMutableState) this.innerCoordinator).setValue(obj);
                }
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj2);
            parcelableSnapshotMutableState.setValue(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            parcelableSnapshotMutableState.setValue(null);
            throw th;
        }
    }

    public DefaultDraggableAnchors getAnchors() {
        return (DefaultDraggableAnchors) ((ParcelableSnapshotMutableState) this.stack).getValue();
    }

    /* JADX INFO: renamed from: has-H91voCI$ui, reason: not valid java name */
    public boolean m662hasH91voCI$ui(int i) {
        return (((Modifier.Node) this.head).aggregateChildKindSet & i) != 0;
    }

    public float newOffsetForDelta$foundation(float f) {
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) this.head;
        return UuidKt.coerceIn((Float.isNaN(parcelableSnapshotMutableFloatState.getFloatValue()) ? CropImageView.DEFAULT_ASPECT_RATIO : parcelableSnapshotMutableFloatState.getFloatValue()) + f, getAnchors().minPosition(), getAnchors().maxPosition());
    }

    public void propagateCoordinator(Modifier.Node node, NodeCoordinator nodeCoordinator) {
        for (Modifier.Node node2 = node.parent; node2 != null; node2 = node2.parent) {
            if (node2 == ((NodeChain$sentinelHead$1) this.sentinelHead)) {
                LayoutNode parent$ui = ((LayoutNode) this.layoutNode).getParent$ui();
                nodeCoordinator.wrappedBy = parent$ui != null ? (InnerNodeCoordinator) parent$ui.nodes.innerCoordinator : null;
                this.outerCoordinator = nodeCoordinator;
                return;
            } else {
                if ((node2.kindSet & 2) != 0) {
                    return;
                }
                node2.updateCoordinator$ui(nodeCoordinator);
            }
        }
    }

    public float requireOffset() {
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) this.head;
        if (Float.isNaN(parcelableSnapshotMutableFloatState.getFloatValue())) {
            androidx.compose.foundation.internal.InlineClassHelperKt.throwIllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?");
        }
        return parcelableSnapshotMutableFloatState.getFloatValue();
    }

    public void runAttachLifecycle() {
        for (Modifier.Node node = (Modifier.Node) this.head; node != null; node = node.child) {
            node.runAttachLifecycle$ui();
            if (node.insertedNodeAwaitingAttachForInvalidation) {
                MutableObjectIntMap mutableObjectIntMap = NodeKindKt.classToKindSetMap;
                if (!node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("autoInvalidateInsertedNode called on unattached node");
                }
                NodeKindKt.autoInvalidateNodeIncludingDelegates(node, -1, 1);
            }
            if (node.updatedNodeAwaitingAttachForInvalidation) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
            }
            node.insertedNodeAwaitingAttachForInvalidation = false;
            node.updatedNodeAwaitingAttachForInvalidation = false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:174:0x0149 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:34:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:36:0x0101  */
    /* JADX WARN: Code duplicated, block: B:37:0x0104  */
    /* JADX WARN: Code duplicated, block: B:40:0x0112 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:46:0x0125  */
    /* JADX WARN: Code duplicated, block: B:48:0x012f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0147  */
    /* JADX WARN: Code duplicated, block: B:72:0x0191  */
    /* JADX WARN: Code duplicated, block: B:73:0x0194  */
    /* JADX WARN: Code duplicated, block: B:75:0x0198  */
    /* JADX WARN: Code duplicated, block: B:76:0x019b  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:78:0x01a7
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public void structuralUpdate(int r32, androidx.collection.MutableObjectList r33, androidx.collection.MutableObjectList r34, androidx.compose.ui.Modifier.Node r35, boolean r36) {
        /*
            Method dump skipped, instruction units count: 970
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeChain.structuralUpdate(int, androidx.collection.MutableObjectList, androidx.collection.MutableObjectList, androidx.compose.ui.Modifier$Node, boolean):void");
    }

    public void syncCoordinators() {
        LayoutModifierNodeCoordinator layoutModifierNodeCoordinator;
        OwnedLayer ownedLayer;
        LayoutNode layoutNode = (LayoutNode) this.layoutNode;
        NodeCoordinator nodeCoordinator = (InnerNodeCoordinator) this.innerCoordinator;
        for (Modifier.Node node = ((TailModifierNode) this.tail).parent; node != null; node = node.parent) {
            LayoutModifierNode layoutModifierNodeAsLayoutModifierNode = HitTestResultKt.asLayoutModifierNode(node);
            if (layoutModifierNodeAsLayoutModifierNode != null) {
                NodeCoordinator nodeCoordinator2 = node.coordinator;
                if (nodeCoordinator2 != null) {
                    layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) nodeCoordinator2;
                    LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.layoutModifierNode;
                    layoutModifierNodeCoordinator.setLayoutModifierNode$ui(layoutModifierNodeAsLayoutModifierNode);
                    if (layoutModifierNode != node && (ownedLayer = layoutModifierNodeCoordinator.layer) != null) {
                        ((GraphicsLayerOwnerLayer) ownedLayer).invalidate();
                    }
                } else {
                    layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(layoutNode, layoutModifierNodeAsLayoutModifierNode);
                    node.updateCoordinator$ui(layoutModifierNodeCoordinator);
                }
                nodeCoordinator.wrappedBy = layoutModifierNodeCoordinator;
                layoutModifierNodeCoordinator.wrapped = nodeCoordinator;
                nodeCoordinator = layoutModifierNodeCoordinator;
            } else {
                node.updateCoordinator$ui(nodeCoordinator);
            }
        }
        LayoutNode parent$ui = layoutNode.getParent$ui();
        nodeCoordinator.wrappedBy = parent$ui != null ? (InnerNodeCoordinator) parent$ui.nodes.innerCoordinator : null;
        this.outerCoordinator = nodeCoordinator;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                StringBuilder sb = new StringBuilder("[");
                Modifier.Node node = (Modifier.Node) this.head;
                TailModifierNode tailModifierNode = (TailModifierNode) this.tail;
                if (node == tailModifierNode) {
                    sb.append("]");
                } else {
                    while (node != null && node != tailModifierNode) {
                        sb.append(String.valueOf(node));
                        if (node.child == tailModifierNode) {
                            sb.append("]");
                        } else {
                            sb.append(",");
                            node = node.child;
                        }
                    }
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public NodeChain(ExoPlayerImpl exoPlayerImpl, ExoPlayerImpl.ComponentListener componentListener, SystemClock systemClock, int i, int i2) {
        this.$r8$classId = (byte) 2;
        this.layoutNode = exoPlayerImpl;
        this.innerCoordinator = componentListener;
        this.outerCoordinator = systemClock;
        this.tail = new Timeline.Period();
        this.head = systemClock.createHandler(exoPlayerImpl.applicationLooper, new ListenerSet$$ExternalSyntheticLambda0((byte) 1, this));
        this.current = new StuckPlayerDetector$StuckBufferingDetector(this);
        this.buffers = new StuckPlayerDetector$StuckPlayingDetector(this, i);
        this.stack = new StuckPlayerDetector$StuckPlayingNotEndingDetector(this, i2);
        this.cachedDiffer = new StuckPlayerDetector$StuckSuppressedDetector(this);
        Player.Listener listener = new Player.Listener() { // from class: androidx.media3.common.util.StuckPlayerDetector$1
            @Override // androidx.media3.common.Player.Listener
            public final void onEvents(Player player, Player.Events events) {
                NodeChain nodeChain = this.this$0;
                ((StuckPlayerDetector$StuckBufferingDetector) nodeChain.current).update();
                ((StuckPlayerDetector$StuckPlayingDetector) nodeChain.buffers).update();
                ((StuckPlayerDetector$StuckPlayingNotEndingDetector) nodeChain.stack).update();
                ((StuckPlayerDetector$StuckSuppressedDetector) nodeChain.cachedDiffer).update();
            }
        };
        this.sentinelHead = listener;
        exoPlayerImpl.listeners.add(listener);
    }

    public NodeChain(LayoutNode layoutNode) {
        this.$r8$classId = (byte) 0;
        this.layoutNode = layoutNode;
        NodeChain$sentinelHead$1 nodeChain$sentinelHead$1 = new NodeChain$sentinelHead$1();
        nodeChain$sentinelHead$1.aggregateChildKindSet = -1;
        this.sentinelHead = nodeChain$sentinelHead$1;
        InnerNodeCoordinator innerNodeCoordinator = new InnerNodeCoordinator(layoutNode);
        this.innerCoordinator = innerNodeCoordinator;
        this.outerCoordinator = innerNodeCoordinator;
        TailModifierNode tailModifierNode = innerNodeCoordinator.tail;
        this.tail = tailModifierNode;
        this.head = tailModifierNode;
        this.current = new MutableObjectList();
    }
}
