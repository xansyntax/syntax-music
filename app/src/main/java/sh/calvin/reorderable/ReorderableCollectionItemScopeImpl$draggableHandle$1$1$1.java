package sh.calvin.reorderable;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSize;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReorderableCollectionItemScopeImpl$draggableHandle$1$1$1 extends Lambda implements Function1 {
    public final /* synthetic */ Object $handleOffset$delegate;
    public final /* synthetic */ Object $handleSize$delegate;
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReorderableCollectionItemScopeImpl$draggableHandle$1$1$1(Object obj, Object obj2, byte b) {
        super(1);
        this.$r8$classId = b;
        this.$handleOffset$delegate = obj;
        this.$handleSize$delegate = obj2;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0065  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean z;
        byte b = this.$r8$classId;
        Object obj2 = this.$handleOffset$delegate;
        Object obj3 = this.$handleSize$delegate;
        switch (b) {
            case 0:
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) obj;
                layoutCoordinates.getClass();
                ((MutableState) obj2).setValue(new Offset(layoutCoordinates.mo606localToRootMKHz9U(0L)));
                ((MutableState) obj3).setValue(new IntSize(layoutCoordinates.mo603getSizeYbymL2g()));
                return Unit.INSTANCE;
            default:
                ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$1 = (ReorderableLazyListKt$toLazyCollectionItemInfo$1) obj;
                ReorderableLazyListKt$toLazyCollectionItemInfo$1 reorderableLazyListKt$toLazyCollectionItemInfo$2 = (ReorderableLazyListKt$toLazyCollectionItemInfo$1) obj3;
                reorderableLazyListKt$toLazyCollectionItemInfo$1.getClass();
                ReorderableLazyListState reorderableLazyListState = (ReorderableLazyListState) obj2;
                if (reorderableLazyListState.reorderableKeys.contains(reorderableLazyListKt$toLazyCollectionItemInfo$1.$this_toLazyCollectionItemInfo.key)) {
                    int iOrdinal = reorderableLazyListState.scrollMoveMode.ordinal();
                    z = true;
                    if (iOrdinal == 0) {
                        int iOrdinal2 = reorderableLazyListState.getOrientation$reorderable_release().ordinal();
                        if (iOrdinal2 != 0) {
                            if (iOrdinal2 != 1) {
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return null;
                            }
                            if (((int) (reorderableLazyListKt$toLazyCollectionItemInfo$1.m1920getOffsetnOccac() & 4294967295L)) != ((int) (reorderableLazyListKt$toLazyCollectionItemInfo$2.m1920getOffsetnOccac() & 4294967295L))) {
                                z = false;
                            }
                        } else if (((int) (reorderableLazyListKt$toLazyCollectionItemInfo$1.m1920getOffsetnOccac() >> 32)) != ((int) (reorderableLazyListKt$toLazyCollectionItemInfo$2.m1920getOffsetnOccac() >> 32))) {
                            z = false;
                        }
                    } else if (iOrdinal != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
        }
    }
}
