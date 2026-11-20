package androidx.compose.ui.platform;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyWindowInfo implements WindowInfo {
    public ParcelableSnapshotMutableState _containerSize;
    public final ParcelableSnapshotMutableState isWindowFocused$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
    public Function0 onInitializeContainerSize;

    /* JADX INFO: renamed from: getContainerDpSize-MYxV2XQ, reason: not valid java name */
    public final long m714getContainerDpSizeMYxV2XQ() {
        DerivedSize derivedSize;
        ParcelableSnapshotMutableState parcelableSnapshotMutableStateMutableStateOf$default = this._containerSize;
        if (parcelableSnapshotMutableStateMutableStateOf$default == null) {
            Function0 function0 = this.onInitializeContainerSize;
            if (function0 == null || (derivedSize = (DerivedSize) function0.invoke()) == null) {
                derivedSize = DerivedSize.Zero;
            }
            parcelableSnapshotMutableStateMutableStateOf$default = Stack.mutableStateOf$default(derivedSize);
            this._containerSize = parcelableSnapshotMutableStateMutableStateOf$default;
            this.onInitializeContainerSize = null;
        }
        return ((DerivedSize) parcelableSnapshotMutableStateMutableStateOf$default.getValue()).dpSize;
    }

    /* JADX INFO: renamed from: getContainerSize-YbymL2g, reason: not valid java name */
    public final long m715getContainerSizeYbymL2g() {
        DerivedSize derivedSize;
        ParcelableSnapshotMutableState parcelableSnapshotMutableStateMutableStateOf$default = this._containerSize;
        if (parcelableSnapshotMutableStateMutableStateOf$default == null) {
            Function0 function0 = this.onInitializeContainerSize;
            if (function0 == null || (derivedSize = (DerivedSize) function0.invoke()) == null) {
                derivedSize = DerivedSize.Zero;
            }
            parcelableSnapshotMutableStateMutableStateOf$default = Stack.mutableStateOf$default(derivedSize);
            this._containerSize = parcelableSnapshotMutableStateMutableStateOf$default;
            this.onInitializeContainerSize = null;
        }
        return ((DerivedSize) parcelableSnapshotMutableStateMutableStateOf$default.getValue()).pxSize;
    }

    public final boolean isWindowFocused() {
        return ((Boolean) this.isWindowFocused$delegate.getValue()).booleanValue();
    }
}
