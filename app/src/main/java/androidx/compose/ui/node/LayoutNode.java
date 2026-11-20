package androidx.compose.ui.node;

import androidx.collection.MutableObjectList;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.compose.runtime.tooling.CompositionErrorContextKt;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidAutofillManager;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.GraphicsLayerOwnerLayer;
import androidx.compose.ui.platform.InvertMatrixKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder$$ExternalSyntheticLambda3;
import androidx.compose.ui.viewinterop.AndroidViewHolder$$ExternalSyntheticLambda4;
import androidx.compose.ui.viewinterop.ViewFactoryHolder;
import androidx.core.provider.CallbackWrapper;
import androidx.emoji2.text.EmojiProcessor;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.sqlite.SQLite;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.FileMetadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutNode implements ComposeNodeLifecycleCallback, OwnerScope, ComposeUiNode {
    public final CallbackWrapper _foldedChildren;
    public LayoutNode _foldedParent;
    public NodeCoordinator _innerLayerCoordinator;
    public Modifier _modifier;
    public SemanticsConfiguration _semanticsConfiguration;
    public MutableVector _unfoldedChildren;
    public final MutableVector _zSortedChildren;
    public boolean canMultiMeasure;
    public CompositionLocalMap compositionLocalMap;
    public Density density;
    public int depth;
    public int globallyPositionedObservers;
    public boolean hasPositionalLayerTransformationsInOffsetFromRoot;
    public boolean ignoreRemeasureRequests;
    public boolean innerLayerCoordinatorIsDirty;
    public ViewFactoryHolder interopViewFactoryHolder;
    public WeakCache intrinsicsPolicy;
    public UsageByParent intrinsicsUsageByParent;
    public boolean isCurrentlyCalculatingSemanticsConfiguration;
    public boolean isDeactivated;
    public boolean isSemanticsInvalidated;
    public final boolean isVirtual;
    public final LayoutNodeLayoutDelegate layoutDelegate;
    public LayoutDirection layoutDirection;
    public LayoutNode lookaheadRoot;
    public MeasurePolicy measurePolicy;
    public boolean needsOnGloballyPositionedDispatch;
    public final NodeChain nodes;
    public AndroidViewHolder$$ExternalSyntheticLambda3 onAttach;
    public AndroidViewHolder$$ExternalSyntheticLambda4 onDetach;
    public long outerToInnerOffset;
    public boolean outerToInnerOffsetDirty;
    public Owner owner;
    public Modifier pendingModifier;
    public UsageByParent previousIntrinsicsUsageByParent;
    public boolean rectInParentDirty;
    public int rectListIndex;
    public int semanticsId;
    public LayoutNodeSubcompositionsState subcompositionsState;
    public boolean unfoldedVirtualChildrenListDirty;
    public ViewConfiguration viewConfiguration;
    public int virtualChildrenCount;
    public boolean zSortedChildrenInvalidated;
    public static final LayoutNode$Companion$ErrorMeasurePolicy$1 ErrorMeasurePolicy = new LayoutNode$Companion$ErrorMeasurePolicy$1("Undefined intrinsics block and it is required");
    public static final TextKt$$ExternalSyntheticLambda3 Constructor = new TextKt$$ExternalSyntheticLambda3(25);
    public static final LayoutNode$Companion$DummyViewConfiguration$1 DummyViewConfiguration = new LayoutNode$Companion$DummyViewConfiguration$1();
    public static final LayoutNode$$ExternalSyntheticLambda1 ZComparator = new LayoutNode$$ExternalSyntheticLambda1(0);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LayoutState {
        public static final /* synthetic */ LayoutState[] $VALUES;
        public static final LayoutState Idle;
        public static final LayoutState LayingOut;
        public static final LayoutState LookaheadLayingOut;
        public static final LayoutState LookaheadMeasuring;
        public static final LayoutState Measuring;

        static {
            LayoutState layoutState = new LayoutState("Measuring", 0);
            Measuring = layoutState;
            LayoutState layoutState2 = new LayoutState("LookaheadMeasuring", 1);
            LookaheadMeasuring = layoutState2;
            LayoutState layoutState3 = new LayoutState("LayingOut", 2);
            LayingOut = layoutState3;
            LayoutState layoutState4 = new LayoutState("LookaheadLayingOut", 3);
            LookaheadLayingOut = layoutState4;
            LayoutState layoutState5 = new LayoutState("Idle", 4);
            Idle = layoutState5;
            $VALUES = new LayoutState[]{layoutState, layoutState2, layoutState3, layoutState4, layoutState5};
        }

        public static LayoutState valueOf(String str) {
            return (LayoutState) Enum.valueOf(LayoutState.class, str);
        }

        public static LayoutState[] values() {
            return (LayoutState[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        public final String error;

        public NoIntrinsicsMeasurePolicy(String str) {
            this.error = str;
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            throw new IllegalStateException(this.error.toString());
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            throw new IllegalStateException(this.error.toString());
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            throw new IllegalStateException(this.error.toString());
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            throw new IllegalStateException(this.error.toString());
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UsageByParent {
        public static final /* synthetic */ UsageByParent[] $VALUES;
        public static final UsageByParent InLayoutBlock;
        public static final UsageByParent InMeasureBlock;
        public static final UsageByParent NotUsed;

        static {
            UsageByParent usageByParent = new UsageByParent("InMeasureBlock", 0);
            InMeasureBlock = usageByParent;
            UsageByParent usageByParent2 = new UsageByParent("InLayoutBlock", 1);
            InLayoutBlock = usageByParent2;
            UsageByParent usageByParent3 = new UsageByParent("NotUsed", 2);
            NotUsed = usageByParent3;
            $VALUES = new UsageByParent[]{usageByParent, usageByParent2, usageByParent3};
        }

        public static UsageByParent valueOf(String str) {
            return (UsageByParent) Enum.valueOf(UsageByParent.class, str);
        }

        public static UsageByParent[] values() {
            return (UsageByParent[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutState.values().length];
            try {
                iArr[4] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LayoutNode(boolean z, int i) {
        this.isVirtual = z;
        this.semanticsId = i;
        this.outerToInnerOffset = 9223372034707292159L;
        this.outerToInnerOffsetDirty = true;
        this.rectInParentDirty = true;
        this.rectListIndex = -4;
        this._foldedChildren = new CallbackWrapper(new MutableVector(new LayoutNode[16]), new RoomDatabase$$ExternalSyntheticLambda0((byte) 12, this), (byte) 10);
        this._zSortedChildren = new MutableVector(new LayoutNode[16]);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.density = LayoutNodeKt.DefaultDensity;
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        CompositionLocalMap.Companion.getClass();
        this.compositionLocalMap = CompositionLocalMap.Companion.Empty;
        UsageByParent usageByParent = UsageByParent.NotUsed;
        this.intrinsicsUsageByParent = usageByParent;
        this.previousIntrinsicsUsageByParent = usageByParent;
        this.nodes = new NodeChain(this);
        this.layoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.innerLayerCoordinatorIsDirty = true;
        this._modifier = Modifier.Companion.$$INSTANCE;
    }

    private final String exceptionMessageForParentingOrOwnership(LayoutNode layoutNode) {
        String strDebugTreeToString = debugTreeToString(0);
        LayoutNode layoutNode2 = layoutNode._foldedParent;
        return "Cannot insert " + layoutNode + " because it already has a parent or an owner. This tree: " + strDebugTreeToString + " Other tree: " + (layoutNode2 != null ? layoutNode2.debugTreeToString(0) : null);
    }

    public static void requestLookaheadRemeasure$ui$default(LayoutNode layoutNode, boolean z, int i) {
        LayoutNode parent$ui;
        if ((i & 1) != 0) {
            z = false;
        }
        boolean z2 = (i & 2) != 0;
        boolean z3 = (i & 4) != 0;
        if (layoutNode.lookaheadRoot == null) {
            InlineClassHelperKt.throwIllegalStateException("Lookahead measure cannot be requested on a node that is not a part of the LookaheadScope");
        }
        Owner owner = layoutNode.owner;
        if (owner == null || layoutNode.ignoreRemeasureRequests || layoutNode.isVirtual) {
            return;
        }
        ((AndroidComposeView) owner).onRequestMeasure(layoutNode, true, z, z2);
        if (z3) {
            LookaheadPassDelegate lookaheadPassDelegate = layoutNode.layoutDelegate.lookaheadPassDelegate;
            lookaheadPassDelegate.getClass();
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = lookaheadPassDelegate.layoutNodeLayoutDelegate;
            LayoutNode parent$ui2 = layoutNodeLayoutDelegate.layoutNode.getParent$ui();
            UsageByParent usageByParent = layoutNodeLayoutDelegate.layoutNode.intrinsicsUsageByParent;
            if (parent$ui2 == null || usageByParent == UsageByParent.NotUsed) {
                return;
            }
            while (parent$ui2.intrinsicsUsageByParent == usageByParent && (parent$ui = parent$ui2.getParent$ui()) != null) {
                parent$ui2 = parent$ui;
            }
            int iOrdinal = usageByParent.ordinal();
            if (iOrdinal == 0) {
                if (parent$ui2.lookaheadRoot != null) {
                    requestLookaheadRemeasure$ui$default(parent$ui2, z, 6);
                    return;
                } else {
                    requestRemeasure$ui$default(parent$ui2, z, 6);
                    return;
                }
            }
            if (iOrdinal != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Intrinsics isn't used by the parent");
            } else if (parent$ui2.lookaheadRoot != null) {
                parent$ui2.requestLookaheadRelayout$ui(z);
            } else {
                parent$ui2.requestRelayout$ui(z);
            }
        }
    }

    public static void requestRemeasure$ui$default(LayoutNode layoutNode, boolean z, int i) {
        Owner owner;
        LayoutNode parent$ui;
        if ((i & 1) != 0) {
            z = false;
        }
        boolean z2 = (i & 2) != 0;
        boolean z3 = (i & 4) != 0;
        if (layoutNode.ignoreRemeasureRequests || layoutNode.isVirtual || (owner = layoutNode.owner) == null) {
            return;
        }
        ((AndroidComposeView) owner).onRequestMeasure(layoutNode, false, z, z2);
        if (z3) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate.measurePassDelegate.layoutNodeLayoutDelegate;
            LayoutNode parent$ui2 = layoutNodeLayoutDelegate.layoutNode.getParent$ui();
            UsageByParent usageByParent = layoutNodeLayoutDelegate.layoutNode.intrinsicsUsageByParent;
            if (parent$ui2 == null || usageByParent == UsageByParent.NotUsed) {
                return;
            }
            while (parent$ui2.intrinsicsUsageByParent == usageByParent && (parent$ui = parent$ui2.getParent$ui()) != null) {
                parent$ui2 = parent$ui;
            }
            int iOrdinal = usageByParent.ordinal();
            if (iOrdinal == 0) {
                requestRemeasure$ui$default(parent$ui2, z, 6);
            } else if (iOrdinal == 1) {
                parent$ui2.requestRelayout$ui(z);
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Intrinsics isn't used by the parent");
            }
        }
    }

    public static void rescheduleRemeasureOrRelayout$ui(LayoutNode layoutNode) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        if (WhenMappings.$EnumSwitchMapping$0[layoutNodeLayoutDelegate.layoutState.ordinal()] != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(layoutNodeLayoutDelegate.layoutState, "Unexpected state ");
            return;
        }
        if (layoutNodeLayoutDelegate.lookaheadMeasurePending) {
            requestLookaheadRemeasure$ui$default(layoutNode, true, 6);
            return;
        }
        if (layoutNodeLayoutDelegate.lookaheadLayoutPending) {
            layoutNode.requestLookaheadRelayout$ui(true);
        }
        if (layoutNode.getMeasurePending$ui()) {
            requestRemeasure$ui$default(layoutNode, true, 6);
        } else if (layoutNode.getLayoutPending$ui()) {
            layoutNode.requestRelayout$ui(true);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 6051. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final void applyModifier(androidx.compose.ui.Modifier r24) {
        /*
            Method dump skipped, instruction units count: 605
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.applyModifier(androidx.compose.ui.Modifier):void");
    }

    public final void attach$ui(Owner owner) {
        LayoutNode layoutNode;
        SemanticsConfiguration semanticsConfiguration;
        if (this.owner != null) {
            InlineClassHelperKt.throwIllegalStateException("Cannot attach " + this + " as it already is attached.  Tree: " + debugTreeToString(0));
        }
        LayoutNode layoutNode2 = this._foldedParent;
        if (layoutNode2 != null && !Intrinsics.areEqual(layoutNode2.owner, owner)) {
            LayoutNode parent$ui = getParent$ui();
            Owner owner2 = parent$ui != null ? parent$ui.owner : null;
            String strDebugTreeToString = debugTreeToString(0);
            LayoutNode layoutNode3 = this._foldedParent;
            InlineClassHelperKt.throwIllegalStateException("Attaching to a different owner(" + owner + ") than the parent's owner(" + owner2 + "). This tree: " + strDebugTreeToString + " Parent tree: " + (layoutNode3 != null ? layoutNode3.debugTreeToString(0) : null));
        }
        LayoutNode parent$ui2 = getParent$ui();
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        if (parent$ui2 == null) {
            layoutNodeLayoutDelegate.measurePassDelegate.isPlaced = true;
            ((AndroidComposeView) owner).getRectManager().recalculateRectIfDirty(this);
            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate != null) {
                lookaheadPassDelegate._placedState = LookaheadPassDelegate.PlacedState.IsPlacedInLookahead;
            }
        }
        NodeChain nodeChain = this.nodes;
        ((NodeCoordinator) nodeChain.outerCoordinator).wrappedBy = parent$ui2 != null ? (InnerNodeCoordinator) parent$ui2.nodes.innerCoordinator : null;
        this.owner = owner;
        this.depth = (parent$ui2 != null ? parent$ui2.depth : -1) + 1;
        Modifier modifier = this.pendingModifier;
        if (modifier != null) {
            applyModifier(modifier);
        }
        this.pendingModifier = null;
        ((AndroidComposeView) owner).getLayoutNodes().set(this.semanticsId, this);
        LayoutNode layoutNode4 = this._foldedParent;
        if (layoutNode4 == null || (layoutNode = layoutNode4.lookaheadRoot) == null) {
            layoutNode = this.lookaheadRoot;
        }
        setLookaheadRoot(layoutNode);
        if (this.lookaheadRoot == null && nodeChain.m662hasH91voCI$ui(512)) {
            setLookaheadRoot(this);
        }
        if (!this.isDeactivated) {
            for (Modifier.Node node = (Modifier.Node) nodeChain.head; node != null; node = node.child) {
                node.markAsAttached$ui();
            }
        }
        MutableVector mutableVector = (MutableVector) this._foldedChildren.mCallback;
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((LayoutNode) objArr[i2]).attach$ui(owner);
        }
        if (!this.isDeactivated) {
            nodeChain.runAttachLifecycle();
        }
        invalidateMeasurements$ui();
        if (parent$ui2 != null) {
            parent$ui2.invalidateMeasurements$ui();
        }
        AndroidViewHolder$$ExternalSyntheticLambda3 androidViewHolder$$ExternalSyntheticLambda3 = this.onAttach;
        if (androidViewHolder$$ExternalSyntheticLambda3 != null) {
            androidViewHolder$$ExternalSyntheticLambda3.invoke(owner);
        }
        layoutNodeLayoutDelegate.updateParentData();
        if (!this.isDeactivated && nodeChain.m662hasH91voCI$ui(8)) {
            invalidateSemantics$ui();
        }
        AndroidAutofillManager autofillManager = ((AndroidComposeView) owner).m694getAutofillManager();
        if (autofillManager == null || (semanticsConfiguration = getSemanticsConfiguration()) == null || !semanticsConfiguration.props.contains(SemanticsProperties.ContentType)) {
            return;
        }
        autofillManager.currentlyDisplayedIDs.add(this.semanticsId);
        autofillManager.platformAutofillManager.notifyViewVisibilityChanged(autofillManager.view, this.semanticsId, true);
    }

    public final void clearSubtreeIntrinsicsUsage$ui() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        UsageByParent usageByParent = UsageByParent.NotUsed;
        this.intrinsicsUsageByParent = usageByParent;
        MutableVector mutableVector = get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i2];
            if (layoutNode.intrinsicsUsageByParent != usageByParent) {
                layoutNode.clearSubtreeIntrinsicsUsage$ui();
            }
        }
    }

    public final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector mutableVector = get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i2];
            if (layoutNode.intrinsicsUsageByParent == UsageByParent.InLayoutBlock) {
                layoutNode.clearSubtreePlacementIntrinsicsUsage();
            }
        }
    }

    public final String debugTreeToString(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
        sb.append("|-");
        sb.append(toString());
        sb.append('\n');
        MutableVector mutableVector = get_children$ui();
        Object[] objArr = mutableVector.content;
        int i3 = mutableVector.size;
        for (int i4 = 0; i4 < i3; i4++) {
            sb.append(((LayoutNode) objArr[i4]).debugTreeToString(i + 1));
        }
        String string = sb.toString();
        return i == 0 ? string.substring(0, string.length() - 1) : string;
    }

    public final void detach$ui() {
        LookaheadAlignmentLines lookaheadAlignmentLines;
        Owner owner = this.owner;
        if (owner == null) {
            LayoutNode parent$ui = getParent$ui();
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Cannot detach node that is already detached!  Tree: " + (parent$ui != null ? parent$ui.debugTreeToString(0) : null));
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
            return;
        }
        LayoutNode parent$ui2 = getParent$ui();
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        if (parent$ui2 != null) {
            parent$ui2.invalidateLayer$ui();
            parent$ui2.invalidateMeasurements$ui();
            MeasurePassDelegate measurePassDelegate = layoutNodeLayoutDelegate.measurePassDelegate;
            UsageByParent usageByParent = UsageByParent.NotUsed;
            measurePassDelegate.measuredByParent = usageByParent;
            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate != null) {
                lookaheadPassDelegate.measuredByParent = usageByParent;
            }
        }
        LookaheadAlignmentLines lookaheadAlignmentLines2 = layoutNodeLayoutDelegate.measurePassDelegate.alignmentLines;
        lookaheadAlignmentLines2.dirty = true;
        lookaheadAlignmentLines2.usedDuringParentMeasurement = false;
        lookaheadAlignmentLines2.previousUsedDuringParentLayout = false;
        lookaheadAlignmentLines2.usedDuringParentLayout = false;
        lookaheadAlignmentLines2.usedByModifierMeasurement = false;
        lookaheadAlignmentLines2.usedByModifierLayout = false;
        lookaheadAlignmentLines2.queryOwner = null;
        LookaheadPassDelegate lookaheadPassDelegate2 = layoutNodeLayoutDelegate.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null && (lookaheadAlignmentLines = lookaheadPassDelegate2.alignmentLines) != null) {
            lookaheadAlignmentLines.dirty = true;
            lookaheadAlignmentLines.usedDuringParentMeasurement = false;
            lookaheadAlignmentLines.previousUsedDuringParentLayout = false;
            lookaheadAlignmentLines.usedDuringParentLayout = false;
            lookaheadAlignmentLines.usedByModifierMeasurement = false;
            lookaheadAlignmentLines.usedByModifierLayout = false;
            lookaheadAlignmentLines.queryOwner = null;
        }
        NodeChain nodeChain = this.nodes;
        Modifier.Node node = (TailModifierNode) nodeChain.tail;
        NodeCoordinator nodeCoordinator = ((InnerNodeCoordinator) nodeChain.innerCoordinator).wrapped;
        for (NodeCoordinator nodeCoordinator2 = (NodeCoordinator) nodeChain.outerCoordinator; !Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator) && nodeCoordinator2 != null; nodeCoordinator2 = nodeCoordinator2.wrapped) {
            nodeCoordinator2.releaseLayer();
            if (nodeCoordinator2.layoutNode.isPlaced()) {
                nodeCoordinator2.onUnplaced();
            }
        }
        AndroidViewHolder$$ExternalSyntheticLambda4 androidViewHolder$$ExternalSyntheticLambda4 = this.onDetach;
        if (androidViewHolder$$ExternalSyntheticLambda4 != null) {
            androidViewHolder$$ExternalSyntheticLambda4.invoke(owner);
        }
        for (Modifier.Node node2 = node; node2 != null; node2 = node2.parent) {
            if (node2.isAttached) {
                node2.runDetachLifecycle$ui();
            }
        }
        this.ignoreRemeasureRequests = true;
        MutableVector mutableVector = (MutableVector) this._foldedChildren.mCallback;
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((LayoutNode) objArr[i2]).detach$ui();
        }
        this.ignoreRemeasureRequests = false;
        while (node != null) {
            if (node.isAttached) {
                node.markAsDetached$ui();
            }
            node = node.parent;
        }
        AndroidComposeView androidComposeView = (AndroidComposeView) owner;
        androidComposeView.getLayoutNodes().remove(this.semanticsId);
        FileMetadata fileMetadata = androidComposeView.measureAndLayoutDelegate;
        EmojiProcessor emojiProcessor = (EmojiProcessor) fileMetadata.size;
        ((DrawResult) emojiProcessor.mSpanFactory).remove(this);
        ((DrawResult) emojiProcessor.mMetadataRepo).remove(this);
        ((DrawResult) emojiProcessor.mGlyphChecker).remove(this);
        ((MutableVector) ((WeakCache) fileMetadata.createdAtMillis).values).remove(this);
        androidComposeView.observationClearRequested = true;
        AndroidAutofillManager autofillManager = androidComposeView.m694getAutofillManager();
        if (autofillManager != null && autofillManager.currentlyDisplayedIDs.remove(this.semanticsId)) {
            autofillManager.platformAutofillManager.notifyViewVisibilityChanged(autofillManager.view, this.semanticsId, false);
        }
        androidComposeView.getRectManager().remove(this);
        this.owner = null;
        setLookaheadRoot(null);
        this.depth = 0;
        MeasurePassDelegate measurePassDelegate2 = layoutNodeLayoutDelegate.measurePassDelegate;
        measurePassDelegate2.placeOrder = Integer.MAX_VALUE;
        measurePassDelegate2.previousPlaceOrder = Integer.MAX_VALUE;
        measurePassDelegate2.isPlaced = false;
        LookaheadPassDelegate lookaheadPassDelegate3 = layoutNodeLayoutDelegate.lookaheadPassDelegate;
        if (lookaheadPassDelegate3 != null) {
            lookaheadPassDelegate3.placeOrder = Integer.MAX_VALUE;
            lookaheadPassDelegate3.previousPlaceOrder = Integer.MAX_VALUE;
            lookaheadPassDelegate3._placedState = LookaheadPassDelegate.PlacedState.IsNotPlaced;
        }
        if (nodeChain.m662hasH91voCI$ui(8)) {
            SemanticsConfiguration semanticsConfiguration = this._semanticsConfiguration;
            this._semanticsConfiguration = null;
            this.isSemanticsInvalidated = false;
            androidComposeView.getSemanticsOwner().notifySemanticsChange$ui(this, semanticsConfiguration);
            androidComposeView.onSemanticsChange();
        }
    }

    public final void draw$ui(Canvas canvas, GraphicsLayer graphicsLayer) throws Throwable {
        try {
            ((NodeCoordinator) this.nodes.outerCoordinator).draw(canvas, graphicsLayer);
        } catch (Throwable th) {
            rethrowWithComposeStackTrace(th);
            throw null;
        }
    }

    public final void forceRemeasure() {
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui$default(this, false, 5);
        } else {
            requestRemeasure$ui$default(this, false, 5);
        }
        MeasurePassDelegate measurePassDelegate = this.layoutDelegate.measurePassDelegate;
        Constraints constraints = measurePassDelegate.measuredOnce ? new Constraints(measurePassDelegate.measurementConstraints) : null;
        Owner owner = this.owner;
        if (constraints != null) {
            if (owner != null) {
                ((AndroidComposeView) owner).m687measureAndLayout0kLqBqw(this, constraints.value);
            }
        } else if (owner != null) {
            ((AndroidComposeView) owner).measureAndLayout(true);
        }
    }

    public final List getChildLookaheadMeasurables$ui() {
        LookaheadPassDelegate lookaheadPassDelegate = this.layoutDelegate.lookaheadPassDelegate;
        lookaheadPassDelegate.getClass();
        MutableVector mutableVector = lookaheadPassDelegate._childDelegates;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = lookaheadPassDelegate.layoutNodeLayoutDelegate;
        layoutNodeLayoutDelegate.layoutNode.getChildren$ui();
        if (!lookaheadPassDelegate.childDelegatesDirty) {
            return mutableVector.asMutableList();
        }
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        MutableVector mutableVector2 = layoutNode.get_children$ui();
        Object[] objArr = mutableVector2.content;
        int i = mutableVector2.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            if (mutableVector.size <= i2) {
                LookaheadPassDelegate lookaheadPassDelegate2 = layoutNode2.layoutDelegate.lookaheadPassDelegate;
                lookaheadPassDelegate2.getClass();
                mutableVector.add(lookaheadPassDelegate2);
            } else {
                LookaheadPassDelegate lookaheadPassDelegate3 = layoutNode2.layoutDelegate.lookaheadPassDelegate;
                lookaheadPassDelegate3.getClass();
                Object[] objArr2 = mutableVector.content;
                Object obj = objArr2[i2];
                objArr2[i2] = lookaheadPassDelegate3;
            }
        }
        mutableVector.removeRange(((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui()).objectList).size, mutableVector.size);
        lookaheadPassDelegate.childDelegatesDirty = false;
        return mutableVector.asMutableList();
    }

    public final List getChildMeasurables$ui() {
        return this.layoutDelegate.measurePassDelegate.getChildDelegates$ui();
    }

    public final List getChildren$ui() {
        return get_children$ui().asMutableList();
    }

    public final List getFoldedChildren$ui() {
        return ((MutableVector) this._foldedChildren.mCallback).asMutableList();
    }

    public final boolean getLayoutPending$ui() {
        return this.layoutDelegate.measurePassDelegate.layoutPending;
    }

    public final boolean getMeasurePending$ui() {
        return this.layoutDelegate.measurePassDelegate.measurePending;
    }

    public final UsageByParent getMeasuredByParent$ui() {
        return this.layoutDelegate.measurePassDelegate.measuredByParent;
    }

    public final UsageByParent getMeasuredByParentInLookahead$ui() {
        UsageByParent usageByParent;
        LookaheadPassDelegate lookaheadPassDelegate = this.layoutDelegate.lookaheadPassDelegate;
        return (lookaheadPassDelegate == null || (usageByParent = lookaheadPassDelegate.measuredByParent) == null) ? UsageByParent.NotUsed : usageByParent;
    }

    public final WeakCache getOrCreateIntrinsicsPolicy() {
        WeakCache weakCache = this.intrinsicsPolicy;
        if (weakCache != null) {
            return weakCache;
        }
        WeakCache weakCache2 = new WeakCache(this, this.measurePolicy);
        this.intrinsicsPolicy = weakCache2;
        return weakCache2;
    }

    public final LayoutNode getParent$ui() {
        LayoutNode layoutNode = this._foldedParent;
        while (layoutNode != null && layoutNode.isVirtual) {
            layoutNode = layoutNode._foldedParent;
        }
        return layoutNode;
    }

    public final int getPlaceOrder$ui() {
        return this.layoutDelegate.measurePassDelegate.placeOrder;
    }

    public final SemanticsConfiguration getSemanticsConfiguration() {
        if (isAttached$1() && !this.isDeactivated && this.nodes.m662hasH91voCI$ui(8)) {
            return this._semanticsConfiguration;
        }
        return null;
    }

    public final float getZIndex$1() {
        return this.layoutDelegate.measurePassDelegate.zIndex;
    }

    public final MutableVector getZSortedChildren() {
        boolean z = this.zSortedChildrenInvalidated;
        MutableVector mutableVector = this._zSortedChildren;
        if (z) {
            mutableVector.clear();
            mutableVector.addAll(mutableVector.size, get_children$ui());
            Arrays.sort(mutableVector.content, 0, mutableVector.size, ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return mutableVector;
    }

    public final MutableVector get_children$ui() {
        updateChildrenIfDirty$ui();
        if (this.virtualChildrenCount == 0) {
            return (MutableVector) this._foldedChildren.mCallback;
        }
        MutableVector mutableVector = this._unfoldedChildren;
        mutableVector.getClass();
        return mutableVector;
    }

    /* JADX INFO: renamed from: hitTest-6fMxITs$ui, reason: not valid java name */
    public final void m648hitTest6fMxITs$ui(long j, HitTestResult hitTestResult, int i, boolean z) {
        NodeChain nodeChain = this.nodes;
        NodeCoordinator nodeCoordinator = (NodeCoordinator) nodeChain.outerCoordinator;
        ComposedModifierKt$$ExternalSyntheticLambda0 composedModifierKt$$ExternalSyntheticLambda0 = NodeCoordinator.onCommitAffectingLayerParams;
        ((NodeCoordinator) nodeChain.outerCoordinator).m671hitTestqzLsGqo(NodeCoordinator.PointerInputSource, nodeCoordinator.m666fromParentPosition8S9VItk(j), hitTestResult, i, z);
    }

    public final void insertAt$ui(int i, LayoutNode layoutNode) {
        if (layoutNode._foldedParent != null && layoutNode.owner != null) {
            InlineClassHelperKt.throwIllegalStateException(exceptionMessageForParentingOrOwnership(layoutNode));
        }
        layoutNode._foldedParent = this;
        CallbackWrapper callbackWrapper = this._foldedChildren;
        ((MutableVector) callbackWrapper.mCallback).add(i, layoutNode);
        ((RoomDatabase$$ExternalSyntheticLambda0) callbackWrapper.mExecutor).invoke();
        onZSortedChildrenInvalidated$ui();
        if (layoutNode.isVirtual) {
            this.virtualChildrenCount++;
        }
        invalidateUnfoldedVirtualChildren();
        Owner owner = this.owner;
        if (owner != null) {
            layoutNode.attach$ui(owner);
        }
        if (layoutNode.layoutDelegate.childrenAccessingCoordinatesDuringPlacement > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
            layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.childrenAccessingCoordinatesDuringPlacement + 1);
        }
        if (layoutNode.globallyPositionedObservers > 0) {
            setGloballyPositionedObservers(this.globallyPositionedObservers + 1);
        }
    }

    public final void invalidateLayer$ui() {
        if (this.innerLayerCoordinatorIsDirty) {
            NodeChain nodeChain = this.nodes;
            NodeCoordinator nodeCoordinator = (InnerNodeCoordinator) nodeChain.innerCoordinator;
            NodeCoordinator nodeCoordinator2 = ((NodeCoordinator) nodeChain.outerCoordinator).wrappedBy;
            this._innerLayerCoordinator = null;
            while (!Intrinsics.areEqual(nodeCoordinator, nodeCoordinator2)) {
                if ((nodeCoordinator != null ? nodeCoordinator.layer : null) != null) {
                    this._innerLayerCoordinator = nodeCoordinator;
                    break;
                }
                nodeCoordinator = nodeCoordinator != null ? nodeCoordinator.wrappedBy : null;
            }
            this.innerLayerCoordinatorIsDirty = false;
        }
        NodeCoordinator nodeCoordinator3 = this._innerLayerCoordinator;
        if (nodeCoordinator3 != null && nodeCoordinator3.layer == null) {
            throw Fragment$5$$ExternalSyntheticOutline0.m$2("layer was not set. This error is usually caused by operating off of the UI thread. Did you call invalidate() instead of postInvalidate()?");
        }
        if (nodeCoordinator3 != null) {
            nodeCoordinator3.invalidateLayer();
            return;
        }
        LayoutNode parent$ui = getParent$ui();
        if (parent$ui != null) {
            parent$ui.invalidateLayer$ui();
            return;
        }
        Owner owner = this.owner;
        if (owner != null) {
            ((AndroidComposeView) owner).invalidate();
        }
    }

    public final void invalidateLayers$ui() {
        NodeChain nodeChain = this.nodes;
        NodeCoordinator nodeCoordinator = (NodeCoordinator) nodeChain.outerCoordinator;
        InnerNodeCoordinator innerNodeCoordinator = (InnerNodeCoordinator) nodeChain.innerCoordinator;
        while (nodeCoordinator != innerNodeCoordinator) {
            nodeCoordinator.getClass();
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) nodeCoordinator;
            OwnedLayer ownedLayer = layoutModifierNodeCoordinator.layer;
            if (ownedLayer != null) {
                ((GraphicsLayerOwnerLayer) ownedLayer).invalidate();
            }
            nodeCoordinator = layoutModifierNodeCoordinator.wrapped;
        }
        OwnedLayer ownedLayer2 = innerNodeCoordinator.layer;
        if (ownedLayer2 != null) {
            ((GraphicsLayerOwnerLayer) ownedLayer2).invalidate();
        }
    }

    public final void invalidateMeasurements$ui() {
        if (this.isVirtual) {
            LayoutNode parent$ui = getParent$ui();
            if (parent$ui != null) {
                parent$ui.invalidateMeasurements$ui();
                return;
            }
            return;
        }
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui$default(this, false, 7);
        } else {
            requestRemeasure$ui$default(this, false, 7);
        }
    }

    public final void invalidateSemantics$ui() {
        if (this.isCurrentlyCalculatingSemanticsConfiguration) {
            return;
        }
        if (((NodeChain$sentinelHead$1) this.nodes.sentinelHead).child != null || this.pendingModifier != null) {
            this.isSemanticsInvalidated = true;
            return;
        }
        SemanticsConfiguration semanticsConfiguration = this._semanticsConfiguration;
        this.isCurrentlyCalculatingSemanticsConfiguration = true;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new SemanticsConfiguration();
        OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) LayoutNodeKt.requireOwner(this)).getSnapshotObserver();
        Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda6 = new Recomposer$$ExternalSyntheticLambda6((Object) this, (Object) ref$ObjectRef, (byte) 28);
        snapshotObserver.observer.observeReads(this, snapshotObserver.onCommitAffectingSemantics, recomposer$$ExternalSyntheticLambda6);
        this.isCurrentlyCalculatingSemanticsConfiguration = false;
        this._semanticsConfiguration = (SemanticsConfiguration) ref$ObjectRef.element;
        this.isSemanticsInvalidated = false;
        AndroidComposeView androidComposeView = (AndroidComposeView) LayoutNodeKt.requireOwner(this);
        androidComposeView.getSemanticsOwner().notifySemanticsChange$ui(this, semanticsConfiguration);
        androidComposeView.onSemanticsChange();
    }

    public final void invalidateUnfoldedVirtualChildren() {
        LayoutNode layoutNode;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (!this.isVirtual || (layoutNode = this._foldedParent) == null) {
            return;
        }
        layoutNode.invalidateUnfoldedVirtualChildren();
    }

    public final boolean isAttached$1() {
        return this.owner != null;
    }

    public final boolean isPlaced() {
        return this.layoutDelegate.measurePassDelegate.isPlaced;
    }

    public final Boolean isPlacedInLookahead() {
        LookaheadPassDelegate lookaheadPassDelegate = this.layoutDelegate.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            return Boolean.valueOf(lookaheadPassDelegate._placedState != LookaheadPassDelegate.PlacedState.IsNotPlaced);
        }
        return null;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final boolean isValidOwnerScope() {
        return isAttached$1();
    }

    public final void lookaheadReplace$ui() {
        LayoutNode parent$ui;
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LookaheadPassDelegate lookaheadPassDelegate = this.layoutDelegate.lookaheadPassDelegate;
        lookaheadPassDelegate.getClass();
        boolean z = true;
        try {
            lookaheadPassDelegate.relayoutWithoutParentInProgress = true;
            if (!lookaheadPassDelegate.placedOnce) {
                InlineClassHelperKt.throwIllegalStateException("replace() called on item that was not placed");
            }
            lookaheadPassDelegate.onNodePlacedCalled = false;
            if (lookaheadPassDelegate._placedState == LookaheadPassDelegate.PlacedState.IsNotPlaced) {
                z = false;
            }
            lookaheadPassDelegate.m657placeSelfMLgxB_4$1(lookaheadPassDelegate.lastPosition, lookaheadPassDelegate.lastExplicitLayer, lookaheadPassDelegate.lastLayerBlock);
            if (z && !lookaheadPassDelegate.onNodePlacedCalled && (parent$ui = lookaheadPassDelegate.layoutNodeLayoutDelegate.layoutNode.getParent$ui()) != null) {
                parent$ui.requestLookaheadRelayout$ui(false);
            }
        } finally {
            lookaheadPassDelegate.relayoutWithoutParentInProgress = false;
        }
    }

    public final void move$ui(int i, int i2, int i3) {
        if (i == i2) {
            return;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i > i2 ? i + i4 : i;
            int i6 = i > i2 ? i2 + i4 : (i2 + i3) - 2;
            CallbackWrapper callbackWrapper = this._foldedChildren;
            MutableVector mutableVector = (MutableVector) callbackWrapper.mCallback;
            RoomDatabase$$ExternalSyntheticLambda0 roomDatabase$$ExternalSyntheticLambda0 = (RoomDatabase$$ExternalSyntheticLambda0) callbackWrapper.mExecutor;
            Object objRemoveAt = mutableVector.removeAt(i5);
            roomDatabase$$ExternalSyntheticLambda0.invoke();
            ((MutableVector) callbackWrapper.mCallback).add(i6, (LayoutNode) objRemoveAt);
            roomDatabase$$ExternalSyntheticLambda0.invoke();
        }
        onZSortedChildrenInvalidated$ui();
        invalidateUnfoldedVirtualChildren();
        invalidateMeasurements$ui();
    }

    public final void onChildRemoved(LayoutNode layoutNode) {
        if (layoutNode.layoutDelegate.childrenAccessingCoordinatesDuringPlacement > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
            layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.childrenAccessingCoordinatesDuringPlacement - 1);
        }
        if (this.owner != null) {
            layoutNode.detach$ui();
        }
        layoutNode._foldedParent = null;
        if (layoutNode.globallyPositionedObservers > 0) {
            setGloballyPositionedObservers(this.globallyPositionedObservers - 1);
        }
        ((NodeCoordinator) layoutNode.nodes.outerCoordinator).wrappedBy = null;
        if (layoutNode.isVirtual) {
            this.virtualChildrenCount--;
            MutableVector mutableVector = (MutableVector) layoutNode._foldedChildren.mCallback;
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                ((NodeCoordinator) ((LayoutNode) objArr[i2]).nodes.outerCoordinator).wrappedBy = null;
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated$ui();
    }

    public final void onCoordinatorRectChanged$ui(NodeCoordinator nodeCoordinator) {
        Owner owner = this.owner;
        RectManager rectManager = owner != null ? ((AndroidComposeView) owner).getRectManager() : null;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        boolean z = layoutNodeLayoutDelegate.layoutState != LayoutState.Idle || getMeasurePending$ui() || getLayoutPending$ui();
        if (this.rectListIndex != -4 && rectManager != null) {
            if (nodeCoordinator == ((NodeCoordinator) this.nodes.outerCoordinator)) {
                this.rectInParentDirty = true;
                if (!z) {
                    rectManager.recalculateRectIfDirty(this);
                }
            } else {
                this.outerToInnerOffsetDirty = true;
                MutableVector mutableVector = get_children$ui();
                Object[] objArr = mutableVector.content;
                int i = mutableVector.size;
                for (int i2 = 0; i2 < i; i2++) {
                    LayoutNode layoutNode = (LayoutNode) objArr[i2];
                    layoutNode.rectInParentDirty = true;
                    if (!z) {
                        rectManager.recalculateRectIfDirty(layoutNode);
                    }
                }
                if (this.rectListIndex != -4) {
                    rectManager.isDirty = true;
                    int iIndexInRectList = rectManager.indexInRectList(this);
                    long[] jArr = (long[]) rectManager.rects.protocol;
                    int i3 = iIndexInRectList + 2;
                    long j = jArr[i3];
                    jArr[i3] = j | (((j >> 63) & 1) << 60);
                }
                rectManager.scheduleDebounceCallback();
            }
        }
        layoutNodeLayoutDelegate.measurePassDelegate.requestLayoutIfCoordinatesAreUsedAndNotifyChildren();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void onDeactivate() {
        AndroidAutofillManager autofillManager;
        ViewFactoryHolder viewFactoryHolder = this.interopViewFactoryHolder;
        if (viewFactoryHolder != null) {
            viewFactoryHolder.onDeactivate();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.subcompositionsState;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.markActiveNodesAsReused(true);
        }
        this.isDeactivated = true;
        Modifier.Node node = (TailModifierNode) this.nodes.tail;
        for (Modifier.Node node2 = node; node2 != null; node2 = node2.parent) {
            if (node2.isAttached) {
                node2.reset$ui();
            }
        }
        for (Modifier.Node node3 = node; node3 != null; node3 = node3.parent) {
            if (node3.isAttached) {
                node3.runDetachLifecycle$ui();
            }
        }
        while (node != null) {
            if (node.isAttached) {
                node.markAsDetached$ui();
            }
            node = node.parent;
        }
        if (isAttached$1()) {
            this._semanticsConfiguration = null;
            this.isSemanticsInvalidated = false;
        }
        Owner owner = this.owner;
        if (owner == null || (autofillManager = ((AndroidComposeView) owner).m694getAutofillManager()) == null || !autofillManager.currentlyDisplayedIDs.remove(this.semanticsId)) {
            return;
        }
        autofillManager.platformAutofillManager.notifyViewVisibilityChanged(autofillManager.view, this.semanticsId, false);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void onRelease() {
        ViewFactoryHolder viewFactoryHolder = this.interopViewFactoryHolder;
        if (viewFactoryHolder != null) {
            viewFactoryHolder.onRelease();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.subcompositionsState;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onRelease();
        }
        NodeChain nodeChain = this.nodes;
        NodeCoordinator nodeCoordinator = ((InnerNodeCoordinator) nodeChain.innerCoordinator).wrapped;
        for (NodeCoordinator nodeCoordinator2 = (NodeCoordinator) nodeChain.outerCoordinator; !Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator) && nodeCoordinator2 != null; nodeCoordinator2 = nodeCoordinator2.wrapped) {
            nodeCoordinator2.onRelease();
        }
    }

    public final void onZSortedChildrenInvalidated$ui() {
        if (!this.isVirtual) {
            this.zSortedChildrenInvalidated = true;
            return;
        }
        LayoutNode parent$ui = getParent$ui();
        if (parent$ui != null) {
            parent$ui.onZSortedChildrenInvalidated$ui();
        }
    }

    public final void removeAll$ui() {
        CallbackWrapper callbackWrapper = this._foldedChildren;
        int i = ((MutableVector) callbackWrapper.mCallback).size;
        while (true) {
            i--;
            MutableVector mutableVector = (MutableVector) callbackWrapper.mCallback;
            if (-1 >= i) {
                mutableVector.clear();
                ((RoomDatabase$$ExternalSyntheticLambda0) callbackWrapper.mExecutor).invoke();
                return;
            }
            onChildRemoved((LayoutNode) mutableVector.content[i]);
        }
    }

    public final void removeAt$ui(int i, int i2) {
        if (i2 < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("count (" + i2 + ") must be greater than 0");
        }
        int i3 = (i2 + i) - 1;
        if (i > i3) {
            return;
        }
        while (true) {
            CallbackWrapper callbackWrapper = this._foldedChildren;
            onChildRemoved((LayoutNode) ((MutableVector) callbackWrapper.mCallback).content[i3]);
            Object objRemoveAt = ((MutableVector) callbackWrapper.mCallback).removeAt(i3);
            ((RoomDatabase$$ExternalSyntheticLambda0) callbackWrapper.mExecutor).invoke();
            if (i3 == i) {
                return;
            } else {
                i3--;
            }
        }
    }

    public final void replace$ui() {
        LayoutNode parent$ui;
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        MeasurePassDelegate measurePassDelegate = this.layoutDelegate.measurePassDelegate;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = measurePassDelegate.layoutNodeLayoutDelegate;
        try {
            measurePassDelegate.relayoutWithoutParentInProgress = true;
            if (!measurePassDelegate.placedOnce) {
                InlineClassHelperKt.throwIllegalStateException("replace called on unplaced item");
            }
            boolean z = measurePassDelegate.isPlaced;
            measurePassDelegate.m659placeOuterCoordinatorMLgxB_4(measurePassDelegate.lastPosition, measurePassDelegate.lastZIndex, measurePassDelegate.lastLayerBlock, measurePassDelegate.lastExplicitLayer);
            if (z && !measurePassDelegate.onNodePlacedCalled && (parent$ui = layoutNodeLayoutDelegate.layoutNode.getParent$ui()) != null) {
                parent$ui.requestRelayout$ui(false);
            }
            measurePassDelegate.relayoutWithoutParentInProgress = false;
        } catch (Throwable th) {
            try {
                layoutNodeLayoutDelegate.layoutNode.rethrowWithComposeStackTrace(th);
                throw null;
            } catch (Throwable th2) {
                measurePassDelegate.relayoutWithoutParentInProgress = false;
                throw th2;
            }
        }
    }

    public final void requestLookaheadRelayout$ui(boolean z) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        ((AndroidComposeView) owner).onRequestRelayout(this, true, z);
    }

    public final void requestRelayout$ui(boolean z) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        ((AndroidComposeView) owner).onRequestRelayout(this, false, z);
    }

    public final void resetSubtreeIntrinsicsUsage$ui() {
        MutableVector mutableVector = get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i2];
            UsageByParent usageByParent = layoutNode.previousIntrinsicsUsageByParent;
            layoutNode.intrinsicsUsageByParent = usageByParent;
            if (usageByParent != UsageByParent.NotUsed) {
                layoutNode.resetSubtreeIntrinsicsUsage$ui();
            }
        }
    }

    public final void rethrowWithComposeStackTrace(Throwable th) throws Throwable {
        CompositionLocalMap compositionLocalMap = this.compositionLocalMap;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = CompositionErrorContextKt.LocalCompositionErrorContext;
        PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = (PersistentCompositionLocalHashMap) compositionLocalMap;
        persistentCompositionLocalHashMap.getClass();
        CompositionErrorContextImpl compositionErrorContextImpl = (CompositionErrorContextImpl) Stack.read(persistentCompositionLocalHashMap, staticProvidableCompositionLocal);
        if (compositionErrorContextImpl == null) {
            throw th;
        }
        SQLite.tryAttachComposeStackTrace(new Recomposer$$ExternalSyntheticLambda6((Object) compositionErrorContextImpl, (Object) this, (byte) 24), th);
        throw th;
    }

    public final void setDensity(Density density) {
        if (Intrinsics.areEqual(this.density, density)) {
            return;
        }
        this.density = density;
        invalidateMeasurements$ui();
        LayoutNode parent$ui = getParent$ui();
        if (parent$ui != null) {
            parent$ui.invalidateLayer$ui();
        } else {
            Owner owner = this.owner;
            if (owner != null) {
                ((AndroidComposeView) owner).invalidate();
            }
        }
        invalidateLayers$ui();
        for (Modifier.Node node = (Modifier.Node) this.nodes.head; node != null; node = node.child) {
            node.onDensityChange();
        }
    }

    public final void setGloballyPositionedObservers(int i) {
        LayoutNode parent$ui;
        LayoutNode parent$ui2;
        int i2 = this.globallyPositionedObservers;
        if (i2 != i) {
            if (i > 0 && i2 == 0 && (parent$ui2 = getParent$ui()) != null) {
                parent$ui2.setGloballyPositionedObservers(parent$ui2.globallyPositionedObservers + 1);
            }
            if (i == 0 && this.globallyPositionedObservers > 0 && (parent$ui = getParent$ui()) != null) {
                parent$ui.setGloballyPositionedObservers(parent$ui.globallyPositionedObservers - 1);
            }
            this.globallyPositionedObservers = i;
        }
    }

    public final void setLookaheadRoot(LayoutNode layoutNode) {
        if (Intrinsics.areEqual(layoutNode, this.lookaheadRoot)) {
            return;
        }
        this.lookaheadRoot = layoutNode;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        if (layoutNode != null) {
            if (layoutNodeLayoutDelegate.lookaheadPassDelegate == null) {
                layoutNodeLayoutDelegate.lookaheadPassDelegate = new LookaheadPassDelegate(layoutNodeLayoutDelegate);
            }
            NodeChain nodeChain = this.nodes;
            NodeCoordinator nodeCoordinator = ((InnerNodeCoordinator) nodeChain.innerCoordinator).wrapped;
            for (NodeCoordinator nodeCoordinator2 = (NodeCoordinator) nodeChain.outerCoordinator; !Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator) && nodeCoordinator2 != null; nodeCoordinator2 = nodeCoordinator2.wrapped) {
                nodeCoordinator2.ensureLookaheadDelegateCreated();
            }
        } else {
            layoutNodeLayoutDelegate.lookaheadPassDelegate = null;
            layoutNodeLayoutDelegate.lookaheadLayoutPending = false;
            layoutNodeLayoutDelegate.lookaheadMeasurePending = false;
        }
        invalidateMeasurements$ui();
    }

    public final void setMeasurePolicy(MeasurePolicy measurePolicy) {
        if (Intrinsics.areEqual(this.measurePolicy, measurePolicy)) {
            return;
        }
        this.measurePolicy = measurePolicy;
        WeakCache weakCache = this.intrinsicsPolicy;
        if (weakCache != null) {
            ((ParcelableSnapshotMutableState) weakCache.referenceQueue).setValue(measurePolicy);
        }
        invalidateMeasurements$ui();
    }

    public final void setModifier(Modifier modifier) {
        if (this.isVirtual && this._modifier != Modifier.Companion.$$INSTANCE) {
            InlineClassHelperKt.throwIllegalArgumentException("Modifiers are not supported on virtual LayoutNodes");
        }
        if (this.isDeactivated) {
            InlineClassHelperKt.throwIllegalArgumentException("modifier is updated when deactivated");
        }
        if (!isAttached$1()) {
            this.pendingModifier = modifier;
            return;
        }
        applyModifier(modifier);
        if (this.isSemanticsInvalidated) {
            invalidateSemantics$ui();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final void setViewConfiguration(ViewConfiguration viewConfiguration) {
        if (Intrinsics.areEqual(this.viewConfiguration, viewConfiguration)) {
            return;
        }
        this.viewConfiguration = viewConfiguration;
        Modifier.Node node = (Modifier.Node) this.nodes.head;
        if ((node.aggregateChildKindSet & 16) != 0) {
            while (node != null) {
                if ((node.kindSet & 16) != 0) {
                    ?? Pop = node;
                    ?? mutableVector = 0;
                    while (Pop != 0) {
                        if (Pop instanceof PointerInputModifierNode) {
                            ((PointerInputModifierNode) Pop).onViewConfigurationChange();
                        } else if ((Pop.kindSet & 16) != 0 && (Pop instanceof DelegatingNode)) {
                            Modifier.Node node2 = ((DelegatingNode) Pop).delegate;
                            int i = 0;
                            Pop = Pop;
                            mutableVector = mutableVector;
                            while (node2 != null) {
                                if ((node2.kindSet & 16) != 0) {
                                    i++;
                                    if (i == 1) {
                                        mutableVector = mutableVector;
                                        Pop = node2;
                                    } else {
                                        if (mutableVector == 0) {
                                            mutableVector = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (Pop != 0) {
                                            mutableVector.add(Pop);
                                            Pop = 0;
                                        }
                                        mutableVector.add(node2);
                                    }
                                }
                                node2 = node2.child;
                                Pop = Pop;
                                mutableVector = mutableVector;
                            }
                            if (i == 1) {
                            }
                        }
                        Pop = HitTestResultKt.pop(mutableVector);
                    }
                }
                if ((node.aggregateChildKindSet & 16) == 0) {
                    return;
                } else {
                    node = node.child;
                }
            }
        }
    }

    public final String toString() {
        return InvertMatrixKt.simpleIdentityToString(this) + " children: " + ((MutableVector) ((MutableObjectList.ObjectListMutableList) getChildren$ui()).objectList).size + " measurePolicy: " + this.measurePolicy + " deactivated: " + this.isDeactivated + " isVirtual: " + this.isVirtual + " isPlaced: " + isPlaced();
    }

    public final void updateChildrenIfDirty$ui() {
        if (this.virtualChildrenCount <= 0 || !this.unfoldedVirtualChildrenListDirty) {
            return;
        }
        this.unfoldedVirtualChildrenListDirty = false;
        MutableVector mutableVector = this._unfoldedChildren;
        if (mutableVector == null) {
            mutableVector = new MutableVector(new LayoutNode[16]);
            this._unfoldedChildren = mutableVector;
        }
        mutableVector.clear();
        MutableVector mutableVector2 = (MutableVector) this._foldedChildren.mCallback;
        Object[] objArr = mutableVector2.content;
        int i = mutableVector2.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i2];
            if (layoutNode.isVirtual) {
                mutableVector.addAll(mutableVector.size, layoutNode.get_children$ui());
            } else {
                mutableVector.add(layoutNode);
            }
        }
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        layoutNodeLayoutDelegate.measurePassDelegate.childDelegatesDirty = true;
        LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            lookaheadPassDelegate.childDelegatesDirty = true;
        }
    }

    public LayoutNode(int i) {
        this((i & 1) == 0, SemanticsModifierKt.lastIdentifier.addAndGet(1));
    }
}
