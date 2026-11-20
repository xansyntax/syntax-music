package androidx.compose.material3;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.CrossAxisAlignment$HorizontalCrossAxisAlignment;
import androidx.compose.foundation.layout.RowColumnParentData;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.layout.BeyondBoundsLayout$BeyondBoundsScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.LayoutDirection;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.size.SizeKt;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExposedDropdownMenuKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ ExposedDropdownMenuKt$$ExternalSyntheticLambda1(WindowBoundsCalculator windowBoundsCalculator, int i, MutableState mutableState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2) {
        this.f$0 = windowBoundsCalculator;
        this.f$1 = i;
        this.f$2 = mutableState;
        this.f$3 = parcelableSnapshotMutableIntState;
        this.f$4 = parcelableSnapshotMutableIntState2;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00f6  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int iRoundToInt;
        int iAlign;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = 0;
        Object obj2 = this.f$4;
        int i2 = this.f$1;
        Object obj3 = this.f$3;
        Object obj4 = this.f$2;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                MutableState mutableState = (MutableState) obj4;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) obj2;
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) obj;
                mutableState.setValue(layoutCoordinates);
                ((ParcelableSnapshotMutableIntState) obj3).setIntValue((int) (layoutCoordinates.mo603getSizeYbymL2g() >> 32));
                View view = ((WindowBoundsCalculator) obj5).view;
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                int i3 = rect.top;
                int i4 = rect.bottom;
                LayoutCoordinates layoutCoordinates2 = (LayoutCoordinates) mutableState.getValue();
                androidx.compose.ui.geometry.Rect rectM896Recttz77jQw = (layoutCoordinates2 == null || !layoutCoordinates2.isAttached$1()) ? androidx.compose.ui.geometry.Rect.Zero : IntMath.m896Recttz77jQw(layoutCoordinates2.mo608localToWindowMKHz9U(0L), SizeKt.m876toSizeozmzZPI(layoutCoordinates2.mo603getSizeYbymL2g()));
                int i5 = i3 + i2;
                int i6 = i4 - i2;
                float f = rectM896Recttz77jQw.top;
                if (f <= i4) {
                    float f2 = rectM896Recttz77jQw.bottom;
                    if (f2 < i3) {
                        iRoundToInt = i6 - i5;
                    } else {
                        iRoundToInt = MathKt.roundToInt(Math.max(f - i5, i6 - f2));
                    }
                } else {
                    iRoundToInt = i6 - i5;
                }
                parcelableSnapshotMutableIntState.setIntValue(Math.max(iRoundToInt, 0));
                return unit;
            case 1:
                Placeable[] placeableArr = (Placeable[]) obj5;
                ColumnMeasurePolicy columnMeasurePolicy = (ColumnMeasurePolicy) obj4;
                MeasureScope measureScope = (MeasureScope) obj3;
                int[] iArr = (int[]) obj2;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                int length = placeableArr.length;
                int i7 = 0;
                while (i < length) {
                    Placeable placeable = placeableArr[i];
                    int i8 = i7 + 1;
                    placeable.getClass();
                    Object parentData = placeable.getParentData();
                    RowColumnParentData rowColumnParentData = parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null;
                    LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                    CrossAxisAlignment$HorizontalCrossAxisAlignment crossAxisAlignment$HorizontalCrossAxisAlignment = rowColumnParentData != null ? rowColumnParentData.crossAxisAlignment : null;
                    if (crossAxisAlignment$HorizontalCrossAxisAlignment != null) {
                        iAlign = crossAxisAlignment$HorizontalCrossAxisAlignment.horizontal.align(placeable.width, i2, layoutDirection);
                    } else {
                        iAlign = columnMeasurePolicy.horizontalAlignment.align(placeable.width, i2, layoutDirection);
                    }
                    placementScope.place(placeable, iAlign, iArr[i7], CropImageView.DEFAULT_ASPECT_RATIO);
                    i++;
                    i7 = i8;
                }
                return unit;
            default:
                FocusTargetNode focusTargetNode = (FocusTargetNode) obj4;
                androidx.compose.ui.geometry.Rect rect2 = (androidx.compose.ui.geometry.Rect) obj3;
                UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0 = (UtilsKt$$ExternalSyntheticLambda0) obj2;
                BeyondBoundsLayout$BeyondBoundsScope beyondBoundsLayout$BeyondBoundsScope = (BeyondBoundsLayout$BeyondBoundsScope) obj;
                if (((FocusTargetNode) obj5) != ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner()).getActiveFocusTargetNode()) {
                    return Boolean.TRUE;
                }
                boolean zM429searchChildren4C6V_qg = FocusTraversalKt.m429searchChildren4C6V_qg(i2, focusTargetNode, rect2, utilsKt$$ExternalSyntheticLambda0);
                Boolean boolValueOf = Boolean.valueOf(zM429searchChildren4C6V_qg);
                if (zM429searchChildren4C6V_qg || !beyondBoundsLayout$BeyondBoundsScope.getHasMoreContent()) {
                    return boolValueOf;
                }
                return null;
        }
    }

    public /* synthetic */ ExposedDropdownMenuKt$$ExternalSyntheticLambda1(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, androidx.compose.ui.geometry.Rect rect, int i, UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0) {
        this.f$0 = focusTargetNode;
        this.f$2 = focusTargetNode2;
        this.f$3 = rect;
        this.f$1 = i;
        this.f$4 = utilsKt$$ExternalSyntheticLambda0;
    }

    public /* synthetic */ ExposedDropdownMenuKt$$ExternalSyntheticLambda1(Placeable[] placeableArr, ColumnMeasurePolicy columnMeasurePolicy, int i, MeasureScope measureScope, int[] iArr) {
        this.f$0 = placeableArr;
        this.f$2 = columnMeasurePolicy;
        this.f$1 = i;
        this.f$3 = measureScope;
        this.f$4 = iArr;
    }
}
