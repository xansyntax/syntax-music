package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda130;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SegmentedButtonContentMeasurePolicy implements MultiContentMeasurePolicy {
    public Animatable animatable;
    public final AnimationSpec animationSpec;
    public Integer initialOffset;
    public final CoroutineScope scope;

    public SegmentedButtonContentMeasurePolicy(CoroutineScope coroutineScope, AnimationSpec animationSpec) {
        this.scope = coroutineScope;
        this.animationSpec = animationSpec;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo121measure3p2s80s(MeasureScope measureScope, List list, long j) {
        Object obj;
        Object obj2;
        Object obj3;
        ArrayList arrayList = (ArrayList) list;
        List list2 = (List) arrayList.get(0);
        int i = 1;
        List list3 = (List) arrayList.get(1);
        ArrayList arrayList2 = new ArrayList(list2.size());
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(((Measurable) list2.get(i2)).mo598measureBRTryo0(j));
        }
        if (!arrayList2.isEmpty()) {
            obj = arrayList2.get(0);
            int i3 = ((Placeable) obj).width;
            int size2 = arrayList2.size() - 1;
            if (1 <= size2) {
                int i4 = 1;
                while (true) {
                    Object obj4 = arrayList2.get(i4);
                    int i5 = ((Placeable) obj4).width;
                    if (i3 < i5) {
                        obj = obj4;
                        i3 = i5;
                    }
                    if (i4 == size2) {
                        break;
                    }
                    i4++;
                }
            }
        } else {
            obj = null;
        }
        Placeable placeable = (Placeable) obj;
        int i6 = placeable != null ? placeable.width : 0;
        ArrayList arrayList3 = new ArrayList(list3.size());
        int size3 = list3.size();
        for (int i7 = 0; i7 < size3; i7++) {
            arrayList3.add(((Measurable) list3.get(i7)).mo598measureBRTryo0(j));
        }
        if (!arrayList3.isEmpty()) {
            obj2 = arrayList3.get(0);
            int i8 = ((Placeable) obj2).width;
            int size4 = arrayList3.size() - 1;
            if (1 <= size4) {
                int i9 = 1;
                while (true) {
                    Object obj5 = arrayList3.get(i9);
                    int i10 = ((Placeable) obj5).width;
                    if (i8 < i10) {
                        obj2 = obj5;
                        i8 = i10;
                    }
                    if (i9 == size4) {
                        break;
                    }
                    i9++;
                }
            }
        } else {
            obj2 = null;
        }
        Placeable placeable2 = (Placeable) obj2;
        Integer numValueOf = placeable2 != null ? Integer.valueOf(placeable2.width) : null;
        if (!arrayList3.isEmpty()) {
            obj3 = arrayList3.get(0);
            int i11 = ((Placeable) obj3).height;
            int size5 = arrayList3.size() - 1;
            if (1 <= size5) {
                while (true) {
                    Object obj6 = arrayList3.get(i);
                    int i12 = ((Placeable) obj6).height;
                    if (i11 < i12) {
                        obj3 = obj6;
                        i11 = i12;
                    }
                    if (i == size5) {
                        break;
                    }
                    i++;
                }
            }
        } else {
            obj3 = null;
        }
        Placeable placeable3 = (Placeable) obj3;
        int i13 = placeable3 != null ? placeable3.height : 0;
        SegmentedButtonDefaults segmentedButtonDefaults = SegmentedButtonDefaults.INSTANCE;
        int iIntValue = (numValueOf != null ? numValueOf.intValue() : 0) + measureScope.mo75roundToPx0680j_4(8.0f) + Math.max(measureScope.mo75roundToPx0680j_4(18.0f), i6);
        int i14 = i6 == 0 ? (-(measureScope.mo75roundToPx0680j_4(8.0f) + measureScope.mo75roundToPx0680j_4(18.0f))) / 2 : 0;
        Integer num = this.initialOffset;
        if (num == null) {
            this.initialOffset = Integer.valueOf(i14);
        } else {
            Animatable animatable = this.animatable;
            if (animatable == null) {
                animatable = new Animatable(num, ArcSplineKt.IntToVector, (Object) null, 12);
                this.animatable = animatable;
            }
            if (((Number) animatable.targetValue$delegate.getValue()).intValue() != i14) {
                AwaitKt.launch$default(this.scope, null, null, new LazyListState.AnonymousClass2(animatable, i14, this, (Continuation) null), 3);
            }
        }
        return measureScope.layout(iIntValue, i13, EmptyMap.INSTANCE, new DatabaseDao_Impl$$ExternalSyntheticLambda130(arrayList2, this, i14, arrayList3, i13));
    }
}
