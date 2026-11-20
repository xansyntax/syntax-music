package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.runtime.ParcelableSnapshotMutableState;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ListItemDefaults {
    public static final PaddingValuesImpl ContentPadding;

    static {
        float f = ListItemKt.InteractiveListVerticalAlignmentBreakpoint;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = PrecisionPointer.shouldUsePrecisionPointerComponentSizing;
        ContentPadding = new PaddingValuesImpl(16.0f, ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue() ? 12.0f : 10.0f, 16.0f, ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue() ? 12.0f : 10.0f);
    }
}
