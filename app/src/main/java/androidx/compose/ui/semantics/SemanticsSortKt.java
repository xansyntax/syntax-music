package androidx.compose.ui.semantics;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda1;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.unit.LayoutDirection;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SemanticsSortKt {
    public static final SaversKt$$ExternalSyntheticLambda0 UnmergedConfigComparator;
    public static final Comparator[] semanticComparators;

    static {
        Comparator[] comparatorArr = new Comparator[2];
        int i = 0;
        while (i < 2) {
            comparatorArr[i] = new SemanticsSortKt$special$$inlined$thenBy$1((byte) 1, new SemanticsSortKt$special$$inlined$thenBy$1((byte) 0, i == 0 ? LtrBoundsComparator.INSTANCE$1 : LtrBoundsComparator.INSTANCE));
            i++;
        }
        semanticComparators = comparatorArr;
        UnmergedConfigComparator = new SaversKt$$ExternalSyntheticLambda0((byte) 5);
    }

    public static final void geometryDepthFirstSearch(SemanticsNode semanticsNode, ArrayList arrayList, TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2, ZIndexNode$$ExternalSyntheticLambda0 zIndexNode$$ExternalSyntheticLambda0, MutableIntObjectMap mutableIntObjectMap) {
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        Object obj = semanticsConfiguration.props.get(SemanticsProperties.IsTraversalGroup);
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if ((zBooleanValue || ((Boolean) zIndexNode$$ExternalSyntheticLambda0.invoke(semanticsNode)).booleanValue()) && ((Boolean) textKt$$ExternalSyntheticLambda2.invoke(semanticsNode)).booleanValue()) {
            arrayList.add(semanticsNode);
        }
        if (zBooleanValue) {
            mutableIntObjectMap.set(semanticsNode.id, subtreeSortedByGeometryGrouping(semanticsNode, textKt$$ExternalSyntheticLambda2, zIndexNode$$ExternalSyntheticLambda0, semanticsNode.getChildren$ui((4 & 1) != 0 ? !semanticsNode.mergingEnabled : false, (4 & 2) == 0)));
            return;
        }
        List children$ui = semanticsNode.getChildren$ui((4 & 1) != 0 ? !semanticsNode.mergingEnabled : false, (4 & 2) == 0);
        int size = children$ui.size();
        for (int i = 0; i < size; i++) {
            geometryDepthFirstSearch((SemanticsNode) children$ui.get(i), arrayList, textKt$$ExternalSyntheticLambda2, zIndexNode$$ExternalSyntheticLambda0, mutableIntObjectMap);
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00d5  */
    public static final ArrayList subtreeSortedByGeometryGrouping(SemanticsNode semanticsNode, TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2, ZIndexNode$$ExternalSyntheticLambda0 zIndexNode$$ExternalSyntheticLambda0, List list) {
        int i;
        MutableIntObjectMap mutableIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
        MutableIntObjectMap mutableIntObjectMap2 = new MutableIntObjectMap();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            geometryDepthFirstSearch((SemanticsNode) list.get(i2), arrayList, textKt$$ExternalSyntheticLambda2, zIndexNode$$ExternalSyntheticLambda0, mutableIntObjectMap2);
        }
        int i3 = 1;
        char c = semanticsNode.layoutNode.layoutDirection == LayoutDirection.Rtl ? (char) 1 : (char) 0;
        ArrayList arrayList2 = new ArrayList(arrayList.size() / 2);
        int size2 = arrayList.size() - 1;
        if (size2 >= 0) {
            int i4 = 0;
            while (true) {
                SemanticsNode semanticsNode2 = (SemanticsNode) arrayList.get(i4);
                if (i4 == 0) {
                    i = i3;
                    arrayList2.add(new Pair(semanticsNode2.getBoundsInWindow(), CollectionsKt__IterablesKt.mutableListOf(semanticsNode2)));
                    break;
                }
                float f = semanticsNode2.getBoundsInWindow().top;
                float f2 = semanticsNode2.getBoundsInWindow().bottom;
                int i5 = f >= f2 ? i3 : 0;
                int size3 = arrayList2.size() - i3;
                if (size3 >= 0) {
                    int i6 = 0;
                    while (true) {
                        Rect rect = (Rect) ((Pair) arrayList2.get(i6)).first;
                        float f3 = rect.top;
                        i = i3;
                        float f4 = rect.bottom;
                        int i7 = f3 >= f4 ? i : 0;
                        if (i5 == 0 && i7 == 0 && Math.max(f, f3) < Math.min(f2, f4)) {
                            arrayList2.set(i6, new Pair(new Rect(Math.max(rect.left, CropImageView.DEFAULT_ASPECT_RATIO), Math.max(rect.top, f), Math.min(rect.right, Float.POSITIVE_INFINITY), Math.min(f4, f2)), ((Pair) arrayList2.get(i6)).second));
                            ((List) ((Pair) arrayList2.get(i6)).second).add(semanticsNode2);
                            break;
                        }
                        if (i6 != size3) {
                            i6++;
                            i3 = i;
                        }
                    }
                } else {
                    i = i3;
                }
                arrayList2.add(new Pair(semanticsNode2.getBoundsInWindow(), CollectionsKt__IterablesKt.mutableListOf(semanticsNode2)));
                break;
                if (i4 == size2) {
                    break;
                }
                i4++;
                i3 = i;
            }
        }
        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList2, LtrBoundsComparator.INSTANCE$2);
        ArrayList arrayList3 = new ArrayList();
        Comparator comparator = semanticComparators[c ^ 1];
        int size4 = arrayList2.size();
        for (int i8 = 0; i8 < size4; i8++) {
            Pair pair = (Pair) arrayList2.get(i8);
            CollectionsKt__MutableCollectionsJVMKt.sortWith((List) pair.second, comparator);
            arrayList3.addAll((Collection) pair.second);
        }
        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList3, new LayoutNode$$ExternalSyntheticLambda1((byte) 5));
        int size5 = 0;
        while (size5 <= arrayList3.size() - 1) {
            List list2 = (List) mutableIntObjectMap2.get(((SemanticsNode) arrayList3.get(size5)).id);
            if (list2 != null) {
                if (((Boolean) zIndexNode$$ExternalSyntheticLambda0.invoke(arrayList3.get(size5))).booleanValue()) {
                    size5++;
                } else {
                    arrayList3.remove(size5);
                }
                arrayList3.addAll(size5, list2);
                size5 += list2.size();
            } else {
                size5++;
            }
        }
        return arrayList3;
    }
}
