package androidx.compose.material3;

import androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Horizontal;
import androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical;
import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.material3.internal.WindowAlignmentMarginPosition$Horizontal;
import androidx.compose.material3.internal.WindowAlignmentMarginPosition$Vertical;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import com.metrolist.music.db.DatabaseDao_Impl;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExposedDropdownMenuPositionProvider implements PopupPositionProvider {
    public final AnchorAlignmentOffsetPosition$Vertical bottomToAnchorTop;
    public final WindowAlignmentMarginPosition$Vertical bottomToWindowBottom;
    public final AnchorAlignmentOffsetPosition$Horizontal endToAnchorEnd;
    public final MutableState keyboardSignalState;
    public final WindowAlignmentMarginPosition$Horizontal leftToWindowLeft;
    public final WindowAlignmentMarginPosition$Horizontal rightToWindowRight;
    public final AnchorAlignmentOffsetPosition$Horizontal startToAnchorStart;
    public final AnchorAlignmentOffsetPosition$Vertical topToAnchorBottom;
    public final WindowAlignmentMarginPosition$Vertical topToWindowTop;
    public final int topWindowInsets;
    public final ParcelableSnapshotMutableState transformOrigin$delegate;
    public final int verticalMargin;

    public ExposedDropdownMenuPositionProvider(Density density, int i, MutableState mutableState) {
        int i2 = MenuKt.$r8$clinit;
        int iMo75roundToPx0680j_4 = density.mo75roundToPx0680j_4(48.0f);
        this.topWindowInsets = i;
        this.keyboardSignalState = mutableState;
        this.verticalMargin = iMo75roundToPx0680j_4;
        this.transformOrigin$delegate = Stack.mutableStateOf$default(new TransformOrigin(ColorKt.TransformOrigin(0.5f, 0.5f)));
        this.startToAnchorStart = MenuPosition.startToAnchorStart;
        this.endToAnchorEnd = MenuPosition.endToAnchorEnd;
        this.leftToWindowLeft = MenuPosition.leftToWindowLeft;
        this.rightToWindowRight = MenuPosition.rightToWindowRight;
        this.topToAnchorBottom = MenuPosition.topToAnchorBottom;
        this.bottomToAnchorTop = MenuPosition.bottomToAnchorTop;
        this.topToWindowTop = MenuPosition.topToWindowTop;
        this.bottomToWindowBottom = MenuPosition.bottomToWindowBottom;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public final long mo210calculatePositionllwVHH4(long j, long j2, IntRect intRect, LayoutDirection layoutDirection) {
        IntRect intRect2;
        char c;
        long j3;
        int iMo365position95KtPRI;
        int i;
        MutableState mutableState = this.keyboardSignalState;
        if (mutableState != null) {
            mutableState.getValue();
        }
        char c2 = ' ';
        long j4 = 4294967295L;
        long j5 = (((long) ((int) (j >> 32))) << 32) | (((long) (((int) (j & 4294967295L)) + this.topWindowInsets)) & 4294967295L);
        int i2 = (int) (j5 >> 32);
        List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new MenuPosition.Horizontal[]{this.startToAnchorStart, this.endToAnchorEnd, ((int) (intRect.m808getCenternOccac() >> 32)) < i2 / 2 ? this.leftToWindowLeft : this.rightToWindowRight});
        int size = listListOf.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                intRect2 = intRect;
                c = c2;
                j3 = j4;
                iMo365position95KtPRI = 0;
                break;
            }
            c = c2;
            j3 = j4;
            int i4 = (int) (j2 >> c);
            int i5 = size;
            int i6 = i3;
            intRect2 = intRect;
            List list = listListOf;
            iMo365position95KtPRI = ((MenuPosition.Horizontal) listListOf.get(i3)).mo365position95KtPRI(intRect2, j5, i4, layoutDirection);
            if (i6 == list.size() - 1 || (iMo365position95KtPRI >= 0 && i4 + iMo365position95KtPRI <= i2)) {
                break;
            }
            i3 = i6 + 1;
            listListOf = list;
            size = i5;
            c2 = c;
            j4 = j3;
        }
        int i7 = (int) (j5 & j3);
        List listListOf2 = CollectionsKt__IterablesKt.listOf((Object[]) new MenuPosition.Vertical[]{this.topToAnchorBottom, this.bottomToAnchorTop, ((int) (intRect2.m808getCenternOccac() & j3)) < i7 / 2 ? this.topToWindowTop : this.bottomToWindowBottom});
        int size2 = listListOf2.size();
        for (int i8 = 0; i8 < size2; i8++) {
            int i9 = (int) (j2 & j3);
            int iMo366positionJVtK1S4 = ((MenuPosition.Vertical) listListOf2.get(i8)).mo366positionJVtK1S4(intRect2, j5, i9);
            if (i8 == listListOf2.size() - 1) {
                int i10 = this.verticalMargin;
                iMo366positionJVtK1S4 = i9 >= i7 - (i10 * 2) ? Math.round(((i7 - i9) / 2.0f) * 1.0f) : UuidKt.coerceIn(iMo366positionJVtK1S4, i10, (i7 - i10) - i9);
            }
            if (i8 == listListOf2.size() - 1 || (iMo366positionJVtK1S4 >= 0 && i9 + iMo366positionJVtK1S4 <= i7)) {
                i = iMo366positionJVtK1S4;
                long j6 = (((long) iMo365position95KtPRI) << c) | (((long) i) & j3);
                this.transformOrigin$delegate.setValue(new TransformOrigin(MenuKt.calculateTransformOrigin(intRect2, DatabaseDao_Impl.AnonymousClass17.m1058IntRectVbeCjmY(j6, j2))));
                return j6;
            }
        }
        i = 0;
        long j7 = (((long) iMo365position95KtPRI) << c) | (((long) i) & j3);
        this.transformOrigin$delegate.setValue(new TransformOrigin(MenuKt.calculateTransformOrigin(intRect2, DatabaseDao_Impl.AnonymousClass17.m1058IntRectVbeCjmY(j7, j2))));
        return j7;
    }
}
