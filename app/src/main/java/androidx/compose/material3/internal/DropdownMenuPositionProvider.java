package androidx.compose.material3.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableIntList;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda3;
import androidx.compose.material3.MenuAnchorPosition;
import androidx.compose.material3.MenuKt;
import androidx.compose.material3.MenuPositionScopeImpl;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DropdownMenuPositionProvider implements PopupPositionProvider {
    public final long contentOffset;
    public final Density density;
    public final ScrollState$$ExternalSyntheticLambda3 onPositionCalculated;
    public final ParcelableSnapshotMutableState transformOrigin$delegate;
    public final int verticalMargin;

    public DropdownMenuPositionProvider(long j, Density density) {
        int i = MenuKt.$r8$clinit;
        int iMo75roundToPx0680j_4 = density.mo75roundToPx0680j_4(48.0f);
        ScrollState$$ExternalSyntheticLambda3 scrollState$$ExternalSyntheticLambda3 = new ScrollState$$ExternalSyntheticLambda3((byte) 24);
        this.contentOffset = j;
        this.density = density;
        this.verticalMargin = iMo75roundToPx0680j_4;
        this.onPositionCalculated = scrollState$$ExternalSyntheticLambda3;
        this.transformOrigin$delegate = Stack.mutableStateOf$default(new TransformOrigin(ColorKt.TransformOrigin(0.5f, 0.5f)));
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00ba A[LOOP:1: B:32:0x00ba->B:46:0x00f9, LOOP_START, PHI: r3 r7
      0x00ba: PHI (r3v6 int) = (r3v3 int), (r3v9 int) binds: [B:31:0x00b8, B:46:0x00f9] A[DONT_GENERATE, DONT_INLINE]
      0x00ba: PHI (r7v2 long) = (r7v1 long), (r7v5 long) binds: [B:31:0x00b8, B:46:0x00f9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:34:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x00f9 A[LOOP:1: B:32:0x00ba->B:46:0x00f9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:54:0x0101 A[EDGE_INSN: B:54:0x0101->B:49:0x0101 BREAK  A[LOOP:1: B:32:0x00ba->B:46:0x00f9], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0100 A[SYNTHETIC] */
    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public final long mo210calculatePositionllwVHH4(long j, long j2, IntRect intRect, LayoutDirection layoutDirection) {
        int i;
        float f;
        float f2;
        int i2;
        int i3;
        int i4;
        long j3;
        long j4;
        int i5;
        int i6;
        int i7;
        int i8;
        int iCoerceIn;
        int i9;
        int iCoerceIn2;
        MenuPositionScopeImpl menuPositionScopeImpl = new MenuPositionScopeImpl(j, j2, intRect, layoutDirection);
        MenuAnchorPosition menuAnchorPosition = MenuAnchorPosition.Below;
        MutableIntList mutableIntList = (MutableIntList) menuAnchorPosition.xCandidates.invoke(menuPositionScopeImpl);
        MutableIntList mutableIntList2 = (MutableIntList) menuAnchorPosition.yCandidates.invoke(menuPositionScopeImpl);
        long j5 = this.contentOffset;
        float fM798getXD9Ej5fM = DpOffset.m798getXD9Ej5fM(j5);
        Density density = this.density;
        int iMo75roundToPx0680j_4 = density.mo75roundToPx0680j_4(fM798getXD9Ej5fM);
        LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
        int i10 = iMo75roundToPx0680j_4 * (layoutDirection == layoutDirection2 ? 1 : -1);
        int iMo75roundToPx0680j_5 = density.mo75roundToPx0680j_4(DpOffset.m799getYD9Ej5fM(j5));
        IntRange intRangeUntil = UuidKt.until(0, mutableIntList._size);
        int i11 = intRangeUntil.first;
        int i12 = intRangeUntil.last;
        if (i11 <= i12) {
            while (true) {
                int i13 = mutableIntList.get(i11) + i10;
                if (i13 >= 0) {
                    f = 1.0f;
                    f2 = 2.0f;
                    i9 = i13;
                    if (((int) (j2 >> 32)) + i13 <= ((int) (j >> 32))) {
                        i2 = i9;
                        i = 0;
                        break;
                    }
                } else {
                    i9 = i13;
                    f = 1.0f;
                    f2 = 2.0f;
                }
                if (i11 == mutableIntList._size - 1) {
                    int i14 = (int) (j2 >> 32);
                    int i15 = (int) (j >> 32);
                    if (i14 >= i15) {
                        iCoerceIn2 = Math.round((f + (layoutDirection == layoutDirection2 ? CropImageView.DEFAULT_ASPECT_RATIO : -0.0f)) * ((i15 - i14) / f2));
                        i = 0;
                    } else {
                        i = 0;
                        iCoerceIn2 = UuidKt.coerceIn(i9, 0, i15 - i14);
                    }
                    i2 = iCoerceIn2;
                    break;
                }
                i = 0;
                if (i11 != i12) {
                    i11++;
                }
            }
            IntRange intRangeUntil2 = UuidKt.until(i, mutableIntList2._size);
            i3 = intRangeUntil2.first;
            i4 = intRangeUntil2.last;
            j3 = 4294967295L;
            if (i3 <= i4) {
                while (true) {
                    i5 = mutableIntList2.get(i3) + iMo75roundToPx0680j_5;
                    i6 = this.verticalMargin;
                    if (i5 >= i6) {
                        j4 = j3;
                        if (((int) (j2 & j3)) + i5 <= ((int) (j & j4)) - i6) {
                            break;
                        }
                        break;
                    }
                    j4 = j3;
                    if (i3 == mutableIntList2._size - 1) {
                        i7 = (int) (j2 & j4);
                        i8 = (int) (j & j4);
                        if (i7 >= i8 - (i6 * 2)) {
                            iCoerceIn = Math.round(((i8 - i7) / f2) * f);
                        } else {
                            iCoerceIn = UuidKt.coerceIn(i5, i6, (i8 - i6) - i7);
                        }
                        i5 = iCoerceIn;
                        break;
                    }
                    if (i3 != i4) {
                        i3++;
                        j3 = j4;
                    }
                }
                long j6 = (((long) i2) << 32) | (((long) i5) & j4);
                this.transformOrigin$delegate.setValue(new TransformOrigin(MenuKt.calculateTransformOrigin(intRect, DatabaseDao_Impl.AnonymousClass17.m1058IntRectVbeCjmY(j6, j2))));
                return j6;
            }
            j4 = 4294967295L;
            i5 = i;
            long j7 = (((long) i2) << 32) | (((long) i5) & j4);
            this.transformOrigin$delegate.setValue(new TransformOrigin(MenuKt.calculateTransformOrigin(intRect, DatabaseDao_Impl.AnonymousClass17.m1058IntRectVbeCjmY(j7, j2))));
            return j7;
        }
        i = 0;
        f = 1.0f;
        f2 = 2.0f;
        i2 = i;
        IntRange intRangeUntil3 = UuidKt.until(i, mutableIntList2._size);
        i3 = intRangeUntil3.first;
        i4 = intRangeUntil3.last;
        j3 = 4294967295L;
        if (i3 <= i4) {
            while (true) {
                i5 = mutableIntList2.get(i3) + iMo75roundToPx0680j_5;
                i6 = this.verticalMargin;
                if (i5 >= i6) {
                    j4 = j3;
                    if (((int) (j2 & j3)) + i5 <= ((int) (j & j4)) - i6) {
                        break;
                    }
                    break;
                    break;
                }
                j4 = j3;
                if (i3 == mutableIntList2._size - 1) {
                    i7 = (int) (j2 & j4);
                    i8 = (int) (j & j4);
                    if (i7 >= i8 - (i6 * 2)) {
                        iCoerceIn = Math.round(((i8 - i7) / f2) * f);
                    } else {
                        iCoerceIn = UuidKt.coerceIn(i5, i6, (i8 - i6) - i7);
                    }
                    i5 = iCoerceIn;
                    break;
                }
                if (i3 != i4) {
                    i3++;
                    j3 = j4;
                }
            }
            long j8 = (((long) i2) << 32) | (((long) i5) & j4);
            this.transformOrigin$delegate.setValue(new TransformOrigin(MenuKt.calculateTransformOrigin(intRect, DatabaseDao_Impl.AnonymousClass17.m1058IntRectVbeCjmY(j8, j2))));
            return j8;
        }
        j4 = 4294967295L;
        i5 = i;
        long j9 = (((long) i2) << 32) | (((long) i5) & j4);
        this.transformOrigin$delegate.setValue(new TransformOrigin(MenuKt.calculateTransformOrigin(intRect, DatabaseDao_Impl.AnonymousClass17.m1058IntRectVbeCjmY(j9, j2))));
        return j9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DropdownMenuPositionProvider) {
            DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) obj;
            return this.contentOffset == dropdownMenuPositionProvider.contentOffset && Intrinsics.areEqual(this.density, dropdownMenuPositionProvider.density) && this.verticalMargin == dropdownMenuPositionProvider.verticalMargin && this.onPositionCalculated == dropdownMenuPositionProvider.onPositionCalculated;
        }
        return false;
    }

    public final int hashCode() {
        return this.onPositionCalculated.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(0, IntIntPair$$ExternalSyntheticOutline0.m(this.verticalMargin, (MenuAnchorPosition.Below.hashCode() + ((this.density.hashCode() + (Long.hashCode(this.contentOffset) * 31)) * 31)) * 31, 31), 31);
    }

    public final String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + DpOffset.m800toStringimpl(this.contentOffset) + ", density=" + this.density + ", dropdownMenuAnchorPosition=" + MenuAnchorPosition.Below + ", verticalMargin=" + this.verticalMargin + ", horizontalMargin=0, onPositionCalculated=" + this.onPositionCalculated + ")";
    }
}
