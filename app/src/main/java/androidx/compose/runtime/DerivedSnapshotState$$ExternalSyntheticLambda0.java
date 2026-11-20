package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.CrossAxisAlignment$HorizontalCrossAxisAlignment;
import androidx.compose.foundation.layout.RowColumnParentData;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.lazy.layout.CacheWindowScope;
import androidx.compose.foundation.lazy.layout.MultiLaneCacheWindow;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier;
import androidx.compose.foundation.text.TextFieldScrollerPosition;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.unit.LayoutDirection;
import com.metrolist.music.utils.InnerTubeXPlayer$$ExternalSyntheticLambda3;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DerivedSnapshotState$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ DerivedSnapshotState$$ExternalSyntheticLambda0(SnapshotStateList snapshotStateList, int i, String str, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0) {
        this.$r8$classId = (byte) 4;
        this.f$0 = snapshotStateList;
        this.f$3 = i;
        this.f$1 = str;
        this.f$2 = mimesKt$$ExternalSyntheticLambda0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int iAlign;
        byte b = this.$r8$classId;
        int i = 0;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        int i2 = this.f$3;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                IntRef intRef = (IntRef) obj3;
                MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) obj2;
                if (obj == ((DerivedSnapshotState) obj4)) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("A derived state calculation cannot read itself");
                    return null;
                }
                if (obj instanceof StateObject) {
                    int i3 = intRef.element - i2;
                    int iFindKeyIndex = mutableObjectIntMap.findKeyIndex(obj);
                    mutableObjectIntMap.set(Math.min(i3, iFindKeyIndex >= 0 ? mutableObjectIntMap.values[iFindKeyIndex] : Integer.MAX_VALUE), obj);
                }
                return unit;
            case 1:
                Placeable[] placeableArr = (Placeable[]) obj4;
                RowMeasurePolicy rowMeasurePolicy = (RowMeasurePolicy) obj3;
                int[] iArr = (int[]) obj2;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                int length = placeableArr.length;
                int i4 = 0;
                while (i < length) {
                    Placeable placeable = placeableArr[i];
                    int i5 = i4 + 1;
                    placeable.getClass();
                    Object parentData = placeable.getParentData();
                    RowColumnParentData rowColumnParentData = parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null;
                    CrossAxisAlignment$HorizontalCrossAxisAlignment crossAxisAlignment$HorizontalCrossAxisAlignment = rowColumnParentData != null ? rowColumnParentData.crossAxisAlignment : null;
                    if (crossAxisAlignment$HorizontalCrossAxisAlignment != null) {
                        iAlign = crossAxisAlignment$HorizontalCrossAxisAlignment.horizontal.align(placeable.height, i2, LayoutDirection.Ltr);
                    } else {
                        iAlign = rowMeasurePolicy.verticalAlignment.align(placeable.height, i2);
                    }
                    placementScope.place(placeable, iArr[i4], iAlign, CropImageView.DEFAULT_ASPECT_RATIO);
                    i++;
                    i4 = i5;
                }
                return unit;
            case 2:
                ((MultiLaneCacheWindow) obj4).onItemPrefetched((CacheWindowScope) obj3, ((Ref$IntRef) obj2).element, i2, ((Integer) obj).intValue());
                return unit;
            case 3:
                HorizontalScrollLayoutModifier horizontalScrollLayoutModifier = (HorizontalScrollLayoutModifier) obj4;
                MeasureScope measureScope = (MeasureScope) obj3;
                Placeable placeable2 = (Placeable) obj2;
                Placeable.PlacementScope placementScope2 = (Placeable.PlacementScope) obj;
                int i6 = horizontalScrollLayoutModifier.cursorOffset;
                TextFieldScrollerPosition textFieldScrollerPosition = horizontalScrollLayoutModifier.scrollerPosition;
                TransformedText transformedText = horizontalScrollLayoutModifier.transformedText;
                TextLayoutResultProxy textLayoutResultProxy = (TextLayoutResultProxy) horizontalScrollLayoutModifier.textLayoutResultProvider.invoke();
                textFieldScrollerPosition.update(Orientation.Horizontal, BasicTextKt.getCursorRectInScroller(placementScope2, i6, transformedText, textLayoutResultProxy != null ? textLayoutResultProxy.value : null, measureScope.getLayoutDirection() == LayoutDirection.Rtl, placeable2.width), i2, placeable2.width);
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, Math.round(-textFieldScrollerPosition.offset$delegate.getFloatValue()), 0);
                return unit;
            default:
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj4;
                Boolean bool = (Boolean) obj;
                bool.getClass();
                snapshotStateList.set(i2, new Pair((String) obj3, bool));
                ((MimesKt$$ExternalSyntheticLambda0) obj2).invoke(CollectionsKt.joinToString$default(snapshotStateList, ",", null, null, new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 16), 30));
                return unit;
        }
    }

    public /* synthetic */ DerivedSnapshotState$$ExternalSyntheticLambda0(byte b, int i, Object obj, Object obj2, Object obj3) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = i;
    }

    public /* synthetic */ DerivedSnapshotState$$ExternalSyntheticLambda0(Placeable[] placeableArr, RowMeasurePolicy rowMeasurePolicy, int i, int[] iArr) {
        this.$r8$classId = (byte) 1;
        this.f$0 = placeableArr;
        this.f$1 = rowMeasurePolicy;
        this.f$3 = i;
        this.f$2 = iArr;
    }
}
