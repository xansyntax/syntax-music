package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda6;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupLayout;
import com.metrolist.music.ui.screens.AlbumScreenKt$$ExternalSyntheticLambda13;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextMeasurePolicy implements MeasurePolicy {
    public final /* synthetic */ byte $r8$classId;
    public final Object placements;
    public final Object shouldMeasureLinks;

    public /* synthetic */ TextMeasurePolicy(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.shouldMeasureLinks = obj;
        this.placements = obj2;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
        ArrayList arrayList;
        int i;
        Pair pair;
        byte b = this.$r8$classId;
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        int i2 = 0;
        Object obj = this.placements;
        Object obj2 = this.shouldMeasureLinks;
        switch (b) {
            case 0:
                ArrayList arrayList2 = new ArrayList(list.size());
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Object obj3 = list.get(i3);
                    if (!(((Measurable) obj3).getParentData() instanceof TextRangeLayoutModifier)) {
                        arrayList2.add(obj3);
                    }
                }
                List list2 = (List) ((Function0) obj).invoke();
                if (list2 != null) {
                    ArrayList arrayList3 = new ArrayList(list2.size());
                    int size2 = list2.size();
                    int i4 = 0;
                    while (i4 < size2) {
                        Rect rect = (Rect) list2.get(i4);
                        if (rect != null) {
                            float f = rect.top;
                            float f2 = rect.left;
                            Measurable measurable = (Measurable) arrayList2.get(i4);
                            int iFloor = (int) Math.floor(rect.right - f2);
                            int iFloor2 = (int) Math.floor(rect.bottom - f);
                            i = 0;
                            Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(ConstraintsKt.Constraints$default(0, iFloor, 0, iFloor2, 5));
                            int iRound = Math.round(f2);
                            pair = new Pair(placeableMo598measureBRTryo0, new IntOffset((((long) Math.round(f)) & 4294967295L) | (((long) iRound) << 32)));
                        } else {
                            i = i2;
                            pair = null;
                        }
                        if (pair != null) {
                            arrayList3.add(pair);
                        }
                        i4++;
                        i2 = i;
                        list2 = list2;
                    }
                    arrayList = arrayList3;
                } else {
                    arrayList = null;
                }
                ArrayList arrayList4 = new ArrayList(list.size());
                int size3 = list.size();
                for (int i5 = i2; i5 < size3; i5++) {
                    Object obj4 = list.get(i5);
                    if (((Measurable) obj4).getParentData() instanceof TextRangeLayoutModifier) {
                        arrayList4.add(obj4);
                    }
                }
                return measureScope.layout(Constraints.m784getMaxWidthimpl(j), Constraints.m783getMaxHeightimpl(j), emptyMap, new AlbumScreenKt$$ExternalSyntheticLambda13(arrayList, BasicTextKt.measureWithTextRangeMeasureConstraints((Function0) obj2, arrayList4), (byte) 1));
            default:
                ((PopupLayout) obj2).setParentLayoutDirection((LayoutDirection) obj);
                return measureScope.layout(0, 0, emptyMap, new SaversKt$$ExternalSyntheticLambda6((byte) 27));
        }
    }
}
