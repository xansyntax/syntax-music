package androidx.compose.foundation.text;

import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda3;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextRange;
import androidx.core.provider.CallbackWrapper;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldScrollerPosition {
    public static final CallbackWrapper Saver = SaverKt.listSaver(new ScrollState$$ExternalSyntheticLambda3(8), new ChipKt$$ExternalSyntheticLambda3((byte) 7));
    public final ParcelableSnapshotMutableFloatState offset$delegate;
    public final ParcelableSnapshotMutableState orientation$delegate;
    public final ParcelableSnapshotMutableFloatState maximum$delegate = new ParcelableSnapshotMutableFloatState(CropImageView.DEFAULT_ASPECT_RATIO);
    public final ParcelableSnapshotMutableIntState viewportSize$delegate = new ParcelableSnapshotMutableIntState(0);
    public Rect previousCursorRect = Rect.Zero;
    public long previousSelection = TextRange.Zero;

    public TextFieldScrollerPosition(Orientation orientation, float f) {
        this.offset$delegate = new ParcelableSnapshotMutableFloatState(f);
        this.orientation$delegate = new ParcelableSnapshotMutableState(orientation, NeverEqualPolicy.INSTANCE$3);
    }

    public final void update(Orientation orientation, Rect rect, int i, int i2) {
        float f;
        float f2 = i2 - i;
        this.maximum$delegate.setFloatValue(f2);
        float f3 = rect.left;
        float f4 = rect.top;
        Rect rect2 = this.previousCursorRect;
        float f5 = rect2.left;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.offset$delegate;
        if (f3 != f5 || f4 != rect2.top) {
            boolean z = orientation == Orientation.Vertical;
            if (z) {
                f3 = f4;
            }
            float f6 = z ? rect.bottom : rect.right;
            float floatValue = parcelableSnapshotMutableFloatState.getFloatValue();
            float f7 = i;
            float f8 = floatValue + f7;
            if (f6 <= f8 && (f3 >= floatValue || f6 - f3 <= f7)) {
                f = (f3 >= floatValue || f6 - f3 > f7) ? 0.0f : f3 - floatValue;
            } else {
                f = f6 - f8;
            }
            parcelableSnapshotMutableFloatState.setFloatValue(parcelableSnapshotMutableFloatState.getFloatValue() + f);
            this.previousCursorRect = rect;
        }
        parcelableSnapshotMutableFloatState.setFloatValue(UuidKt.coerceIn(parcelableSnapshotMutableFloatState.getFloatValue(), CropImageView.DEFAULT_ASPECT_RATIO, f2));
        this.viewportSize$delegate.setIntValue(i);
    }
}
