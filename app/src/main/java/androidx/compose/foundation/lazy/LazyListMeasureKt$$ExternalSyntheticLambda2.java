package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LazyListMeasureKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ ArrayList f$1;
    public final /* synthetic */ List f$2;
    public final /* synthetic */ boolean f$3;

    public /* synthetic */ LazyListMeasureKt$$ExternalSyntheticLambda2(MutableState mutableState, ArrayList arrayList, List list, boolean z, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
        this.f$1 = arrayList;
        this.f$2 = list;
        this.f$3 = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        boolean z = this.f$3;
        List list = this.f$2;
        ArrayList arrayList = this.f$1;
        MutableState mutableState = this.f$0;
        Unit unit = Unit.INSTANCE;
        Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
        switch (b) {
            case 0:
                placementScope.motionFrameOfReferencePlacement = true;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((LazyListMeasuredItem) arrayList.get(i)).place(placementScope, z);
                }
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((LazyListMeasuredItem) list.get(i2)).place(placementScope, z);
                }
                placementScope.motionFrameOfReferencePlacement = false;
                mutableState.getValue();
                break;
            default:
                placementScope.motionFrameOfReferencePlacement = true;
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    ((LazyGridMeasuredItem) arrayList.get(i3)).place(placementScope, z);
                }
                int size4 = list.size();
                for (int i4 = 0; i4 < size4; i4++) {
                    ((LazyGridMeasuredItem) list.get(i4)).place(placementScope, z);
                }
                placementScope.motionFrameOfReferencePlacement = false;
                mutableState.getValue();
                break;
        }
        return unit;
    }
}
