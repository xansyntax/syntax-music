package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidContentDataType;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKindKt;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Updater$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ Updater$$ExternalSyntheticLambda0(AndroidComposeView.RootModifierNode rootModifierNode) {
        this.$r8$classId = (byte) 15;
    }

    /* JADX WARN: Code duplicated, block: B:128:0x023d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:129:0x023f A[LOOP:4: B:119:0x0202->B:129:0x023f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:182:0x0242 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v56, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v57, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r1v61 */
    /* JADX WARN: Type inference failed for: r1v96 */
    /* JADX WARN: Type inference failed for: r1v97 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v10 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion.invoke(obj);
                return unit;
            case 1:
                return Integer.valueOf(((Measurable) obj).minIntrinsicHeight(((Integer) obj2).intValue()));
            case 2:
                return Integer.valueOf(((Measurable) obj).minIntrinsicWidth(((Integer) obj2).intValue()));
            case 3:
                return Integer.valueOf(((Measurable) obj).maxIntrinsicWidth(((Integer) obj2).intValue()));
            case 4:
                return (Float) ((PullToRefreshStateImpl) obj2).anim.getValue();
            case 5:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 6:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 7:
                SaveableStateHolderImpl saveableStateHolderImpl = (SaveableStateHolderImpl) obj2;
                MutableScatterMap mutableScatterMap = saveableStateHolderImpl.registries;
                Map map = saveableStateHolderImpl.savedStates;
                Object[] objArr = mutableScatterMap.keys;
                Object[] objArr2 = mutableScatterMap.values;
                long[] jArr = mutableScatterMap.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128) {
                                    int i4 = (i << 3) + i3;
                                    map.put(objArr[i4], ((SaveableStateRegistry) objArr2[i4]).performSave());
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
                Collection collectionValues = map.values();
                collectionValues.getClass();
                Iterator it = collectionValues.iterator();
                while (it.hasNext()) {
                    if (((Map) it.next()).isEmpty()) {
                        it.remove();
                    }
                }
                if (map.isEmpty()) {
                    return null;
                }
                return map;
            case 8:
                return obj2;
            case 9:
                StringBuilder sb = (StringBuilder) obj;
                Modifier.Element element = (Modifier.Element) obj2;
                if (sb.length() > 1) {
                    sb.append(", ");
                }
                sb.append(element);
                return sb;
            case 10:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 11:
                ((LayoutNode) ((ComposeUiNode) obj)).setModifier((Modifier) obj2);
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                CompositionLocalMap compositionLocalMap = (CompositionLocalMap) obj2;
                LayoutNode layoutNode = (LayoutNode) ((ComposeUiNode) obj);
                layoutNode.compositionLocalMap = compositionLocalMap;
                NodeChain nodeChain = layoutNode.nodes;
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = CompositionLocalsKt.LocalDensity;
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = (PersistentCompositionLocalHashMap) compositionLocalMap;
                persistentCompositionLocalHashMap.getClass();
                layoutNode.setDensity((Density) Stack.read(persistentCompositionLocalHashMap, staticProvidableCompositionLocal));
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMap2 = (PersistentCompositionLocalHashMap) compositionLocalMap;
                LayoutDirection layoutDirection = (LayoutDirection) Stack.read(persistentCompositionLocalHashMap2, CompositionLocalsKt.LocalLayoutDirection);
                if (layoutNode.layoutDirection != layoutDirection) {
                    layoutNode.layoutDirection = layoutDirection;
                    layoutNode.invalidateMeasurements$ui();
                    LayoutNode parent$ui = layoutNode.getParent$ui();
                    if (parent$ui != null) {
                        parent$ui.invalidateLayer$ui();
                    } else {
                        Owner owner = layoutNode.owner;
                        if (owner != null) {
                            ((AndroidComposeView) owner).invalidate();
                        }
                    }
                    layoutNode.invalidateLayers$ui();
                    for (Modifier.Node node = (Modifier.Node) nodeChain.head; node != null; node = node.child) {
                        node.onLayoutDirectionChange();
                    }
                }
                layoutNode.setViewConfiguration((ViewConfiguration) Stack.read(persistentCompositionLocalHashMap2, CompositionLocalsKt.LocalViewConfiguration));
                Modifier.Node node2 = (Modifier.Node) nodeChain.head;
                if ((node2.aggregateChildKindSet & 32768) != 0) {
                    while (node2 != null) {
                        if ((node2.kindSet & 32768) != 0) {
                            ?? Pop = node2;
                            ?? mutableVector = 0;
                            while (Pop != 0) {
                                if (Pop instanceof CompositionLocalConsumerModifierNode) {
                                    Modifier.Node node3 = ((Modifier.Node) ((CompositionLocalConsumerModifierNode) Pop)).node;
                                    if (node3.isAttached) {
                                        NodeKindKt.autoInvalidateUpdatedNode(node3);
                                    } else {
                                        node3.updatedNodeAwaitingAttachForInvalidation = true;
                                    }
                                } else if ((Pop.kindSet & 32768) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node node4 = ((DelegatingNode) Pop).delegate;
                                    int i5 = 0;
                                    while (node4 != null) {
                                        if ((node4.kindSet & 32768) != 0) {
                                            i5++;
                                            if (i5 == 1) {
                                                Pop = Pop;
                                                mutableVector = mutableVector;
                                                mutableVector = mutableVector;
                                                Pop = node4;
                                            } else {
                                                if (mutableVector == 0) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (Pop != 0) {
                                                    mutableVector.add(Pop);
                                                    Pop = 0;
                                                }
                                                mutableVector.add(node4);
                                            }
                                        } else {
                                            Pop = Pop;
                                            mutableVector = mutableVector;
                                        }
                                        node4 = node4.child;
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    }
                                    if (i5 == 1) {
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    } else {
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    }
                                }
                                Pop = HitTestResultKt.pop(mutableVector);
                            }
                        }
                        if ((node2.aggregateChildKindSet & 32768) != 0) {
                            node2 = node2.child;
                        }
                    }
                }
                return unit;
            case 13:
                ((LayoutNode) ((ComposeUiNode) obj)).setMeasurePolicy((MeasurePolicy) obj2);
                return unit;
            case 14:
                ((Integer) obj2).getClass();
                ((LayoutNode) ((ComposeUiNode) obj)).getClass();
                return unit;
            case 15:
                return unit;
            case 16:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 17:
                Collection collection = (List) obj;
                List list = (List) obj2;
                if (collection == null) {
                    collection = EmptyList.INSTANCE;
                }
                return CollectionsKt.plus((Iterable) list, collection);
            case 18:
                List list2 = (List) obj;
                List list3 = (List) obj2;
                if (list2 == null) {
                    return list3;
                }
                ArrayList arrayList = new ArrayList(list2);
                arrayList.addAll(list3);
                return arrayList;
            case 19:
                Float f = (Float) obj;
                ((Float) obj2).getClass();
                return f;
            case 20:
                throw new IllegalStateException("merge function called on unmergeable property IsPopup. A popup should not be a child of a clickable/focusable node.");
            case 21:
                throw new IllegalStateException("merge function called on unmergeable property IsDialog. A dialog should not be a child of a clickable/focusable node.");
            case 22:
                return (Role) obj;
            case 23:
                return (String) obj;
            case 24:
                return (Unit) obj;
            case 25:
                List list4 = (List) obj;
                List list5 = (List) obj2;
                if (list4 == null) {
                    return list5;
                }
                ArrayList arrayList2 = new ArrayList(list4);
                arrayList2.addAll(list5);
                return arrayList2;
            case 26:
                return (Shape) obj;
            case 27:
                throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
            case 28:
                return (ContentType) obj;
            default:
                return (AndroidContentDataType) obj;
        }
    }

    public /* synthetic */ Updater$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }
}
