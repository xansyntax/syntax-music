package androidx.compose.ui.layout;

import androidx.collection.MutableIntObjectMap;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.spatial.ThrottledCallbacks;
import androidx.compose.ui.spatial.ThrottledCallbacks.Entry;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.component.ItemsKt$$ExternalSyntheticLambda67;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RulerKt {
    public static final ProvidableModifierLocal ModifierLocalBeyondBoundsLayout = new ProvidableModifierLocal(new TextKt$$ExternalSyntheticLambda3(22));
    public static final ComposableLambdaImpl lambda$641200809 = new ComposableLambdaImpl(false, 641200809, new Updater$$ExternalSyntheticLambda0((byte) 10));
    public static final ComposedModifierKt$$ExternalSyntheticLambda0 DefaultLayerBlock = new ComposedModifierKt$$ExternalSyntheticLambda0(8);
    public static final ContentScale$Companion$Fit$1 ReusedSlotId = new ContentScale$Companion$Fit$1((byte) 4);
    public static final Object UnspecifiedSlotId = new Object();

    public static final void SubcomposeLayout(SubcomposeLayoutState subcomposeLayoutState, Modifier modifier, Function2 function2, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-511989831);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(subcomposeLayoutState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            GapComposer.CompositionContextImpl compositionContextImplRememberCompositionContext = Stack.rememberCompositionContext(gapComposer);
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifier);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, subcomposeLayoutState, subcomposeLayoutState.setRoot);
            Stack.m390setimpl(gapComposer, compositionContextImplRememberCompositionContext, subcomposeLayoutState.setCompositionContext);
            Stack.m390setimpl(gapComposer, function2, subcomposeLayoutState.setMeasurePolicy);
            ComposeUiNode.Companion.getClass();
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            gapComposer.end(true);
            if (gapComposer.getSkipping()) {
                gapComposer.startReplaceGroup(-1259187287);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1259245908);
                boolean zChangedInstance = gapComposer.changedInstance(subcomposeLayoutState);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = new RoomDatabase$$ExternalSyntheticLambda0((byte) 11, subcomposeLayoutState);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Stack.SideEffect((Function0) objRememberedValue, gapComposer);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda0((byte) 11, i, (Object) subcomposeLayoutState, (Object) modifier, (Object) function2);
        }
    }

    public static final Rect boundsInParent(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.localBoundingBoxOf(layoutCoordinates, true) : new Rect(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (int) (layoutCoordinates.mo603getSizeYbymL2g() >> 32), (int) (layoutCoordinates.mo603getSizeYbymL2g() & 4294967295L));
    }

    public static final Rect boundsInWindow(LayoutCoordinates layoutCoordinates, boolean z) {
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = findRootCoordinates(layoutCoordinates);
        float fMo603getSizeYbymL2g = (int) (layoutCoordinatesFindRootCoordinates.mo603getSizeYbymL2g() >> 32);
        float fMo603getSizeYbymL2g2 = (int) (layoutCoordinatesFindRootCoordinates.mo603getSizeYbymL2g() & 4294967295L);
        Rect rectLocalBoundingBoxOf = layoutCoordinatesFindRootCoordinates.localBoundingBoxOf(layoutCoordinates, z);
        float f = rectLocalBoundingBoxOf.left;
        float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
        if (z) {
            if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
                f = 0.0f;
            }
            if (f > fMo603getSizeYbymL2g) {
                f = fMo603getSizeYbymL2g;
            }
        }
        float f3 = rectLocalBoundingBoxOf.top;
        if (z) {
            if (f3 < CropImageView.DEFAULT_ASPECT_RATIO) {
                f3 = 0.0f;
            }
            if (f3 > fMo603getSizeYbymL2g2) {
                f3 = fMo603getSizeYbymL2g2;
            }
        }
        float f4 = rectLocalBoundingBoxOf.right;
        if (z) {
            if (f4 < CropImageView.DEFAULT_ASPECT_RATIO) {
                f4 = 0.0f;
            }
            if (f4 <= fMo603getSizeYbymL2g) {
                fMo603getSizeYbymL2g = f4;
            }
            f4 = fMo603getSizeYbymL2g;
        }
        float f5 = rectLocalBoundingBoxOf.bottom;
        if (z) {
            if (f5 >= CropImageView.DEFAULT_ASPECT_RATIO) {
                f2 = f5;
            }
            if (f2 <= fMo603getSizeYbymL2g2) {
                fMo603getSizeYbymL2g2 = f2;
            }
            f5 = fMo603getSizeYbymL2g2;
        }
        if (f == f4 || f3 == f5) {
            return Rect.Zero;
        }
        long jMo608localToWindowMKHz9U = layoutCoordinatesFindRootCoordinates.mo608localToWindowMKHz9U((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
        long jMo608localToWindowMKHz9U2 = layoutCoordinatesFindRootCoordinates.mo608localToWindowMKHz9U((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
        long jMo608localToWindowMKHz9U3 = layoutCoordinatesFindRootCoordinates.mo608localToWindowMKHz9U((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L));
        long jMo608localToWindowMKHz9U4 = layoutCoordinatesFindRootCoordinates.mo608localToWindowMKHz9U((((long) Float.floatToRawIntBits(f5)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jMo608localToWindowMKHz9U >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jMo608localToWindowMKHz9U2 >> 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jMo608localToWindowMKHz9U4 >> 32));
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jMo608localToWindowMKHz9U3 >> 32));
        float fMin = Math.min(fIntBitsToFloat, Math.min(fIntBitsToFloat2, Math.min(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fMax = Math.max(fIntBitsToFloat, Math.max(fIntBitsToFloat2, Math.max(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fIntBitsToFloat5 = Float.intBitsToFloat((int) (jMo608localToWindowMKHz9U & 4294967295L));
        float fIntBitsToFloat6 = Float.intBitsToFloat((int) (jMo608localToWindowMKHz9U2 & 4294967295L));
        float fIntBitsToFloat7 = Float.intBitsToFloat((int) (jMo608localToWindowMKHz9U4 & 4294967295L));
        float fIntBitsToFloat8 = Float.intBitsToFloat((int) (jMo608localToWindowMKHz9U3 & 4294967295L));
        return new Rect(fMin, Math.min(fIntBitsToFloat5, Math.min(fIntBitsToFloat6, Math.min(fIntBitsToFloat7, fIntBitsToFloat8))), fMax, Math.max(fIntBitsToFloat5, Math.max(fIntBitsToFloat6, Math.max(fIntBitsToFloat7, fIntBitsToFloat8))));
    }

    /* JADX INFO: renamed from: computeFillMinDimension-iLBOSCw, reason: not valid java name */
    public static final float m623computeFillMinDimensioniLBOSCw(long j, long j2) {
        return Math.min(Float.intBitsToFloat((int) (j2 >> 32)) / Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)) / Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m624equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates2 instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates2 : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrappedBy;
        while (true) {
            NodeCoordinator nodeCoordinator3 = nodeCoordinator2;
            NodeCoordinator nodeCoordinator4 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator3;
            if (nodeCoordinator == null) {
                return nodeCoordinator4;
            }
            nodeCoordinator2 = nodeCoordinator.wrappedBy;
        }
    }

    public static final Object getLayoutId(Measurable measurable) {
        Object parentData = measurable.getParentData();
        LayoutIdModifier layoutIdModifier = parentData instanceof LayoutIdModifier ? (LayoutIdModifier) parentData : null;
        if (layoutIdModifier != null) {
            return layoutIdModifier.layoutId;
        }
        return null;
    }

    public static final LookaheadDelegate getRootLookaheadDelegate(LookaheadDelegate lookaheadDelegate) {
        LayoutNode layoutNode = lookaheadDelegate.coordinator.layoutNode;
        while (true) {
            LayoutNode parent$ui = layoutNode.getParent$ui();
            LayoutNode layoutNode2 = null;
            if ((parent$ui != null ? parent$ui.lookaheadRoot : null) == null) {
                LookaheadDelegate lookaheadDelegate2 = ((NodeCoordinator) layoutNode.nodes.outerCoordinator).getLookaheadDelegate();
                lookaheadDelegate2.getClass();
                return lookaheadDelegate2;
            }
            LayoutNode parent$ui2 = layoutNode.getParent$ui();
            if (parent$ui2 != null) {
                layoutNode2 = parent$ui2.lookaheadRoot;
            }
            layoutNode2.getClass();
            LayoutNode parent$ui3 = layoutNode.getParent$ui();
            parent$ui3.getClass();
            layoutNode = parent$ui3.lookaheadRoot;
            layoutNode.getClass();
        }
    }

    public static final Modifier layout(Modifier modifier, Function3 function3) {
        return modifier.then(new LayoutElement(function3));
    }

    public static final Modifier layoutId(Modifier modifier, Object obj) {
        return modifier.then(new LayoutIdElement(obj));
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    public static final float mergeRulerValues(Placeable.PlacementScope placementScope, boolean z, VerticalRuler[] verticalRulerArr, float f) {
        float f2 = Float.NaN;
        for (VerticalRuler verticalRuler : verticalRulerArr) {
            float fCurrent = placementScope.current(verticalRuler, Float.NaN);
            if (Float.isNaN(f2)) {
                f2 = fCurrent;
            } else if (z == (fCurrent > f2)) {
                f2 = fCurrent;
            }
        }
        return Float.isNaN(f2) ? f : f2;
    }

    public static final Modifier onGloballyPositioned(Modifier modifier, Function1 function1) {
        return modifier.then(new OnGloballyPositionedElement(function1));
    }

    public static final Modifier onSizeChanged(Modifier modifier, Function1 function1) {
        return modifier.then(new OnSizeChangedModifier(function1));
    }

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
    public static final ThrottledCallbacks.Entry registerOnLayoutRectChanged(Modifier.Node node, Function1 function1) {
        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(node);
        int i = layoutNodeRequireLayoutNode.semanticsId;
        RectManager rectManager = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeRequireLayoutNode)).getRectManager();
        ThrottledCallbacks throttledCallbacks = rectManager.throttledCallbacks;
        throttledCallbacks.getClass();
        MutableIntObjectMap mutableIntObjectMap = throttledCallbacks.rectChangedMap;
        ThrottledCallbacks.Entry entry = throttledCallbacks.new Entry(i, node, function1);
        Object obj = mutableIntObjectMap.get(i);
        if (obj == null) {
            mutableIntObjectMap.set(i, entry);
            obj = entry;
        }
        ThrottledCallbacks.Entry entry2 = (ThrottledCallbacks.Entry) obj;
        if (entry2 != entry) {
            while (true) {
                ThrottledCallbacks.Entry entry3 = entry2.next;
                if (entry3 == null) {
                    break;
                }
                entry2 = entry3;
            }
            entry2.next = entry;
        }
        LayoutNode layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(node.node);
        if (layoutNodeRequireLayoutNode2.rectListIndex != -4) {
            StatusLine statusLine = rectManager.rects;
            int iIndexInRectList = rectManager.indexInRectList(layoutNodeRequireLayoutNode2);
            long[] jArr = (long[]) statusLine.protocol;
            int i2 = iIndexInRectList + 2;
            jArr[i2] = (jArr[i2] & 8070450532247928831L) | (-8070450532247928832L);
        }
        rectManager.isDirty = true;
        rectManager.scheduleDebounceCallback();
        return entry;
    }

    /* JADX INFO: renamed from: times-UQTWf7w, reason: not valid java name */
    public static final long m625timesUQTWf7w(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) * Float.intBitsToFloat((int) (j >> 32));
        return (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)) * Float.intBitsToFloat((int) (j & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public static final void SubcomposeLayout(Modifier modifier, Function2 function2, Composer composer, int i, int i2) {
        int i3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1298353104);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changedInstance(function2) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 19) != 18)) {
            if (i4 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new SubcomposeLayoutState(ContentScale$Companion$Fit$1.INSTANCE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            SubcomposeLayout((SubcomposeLayoutState) objRememberedValue, modifier, function2, gapComposer, (i3 << 3) & 1008);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ItemsKt$$ExternalSyntheticLambda67(modifier, function2, i, i2);
        }
    }
}
