package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.unit.LayoutDirection;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScaffoldKt$ScaffoldLayout$contentPadding$1$1 implements PaddingValues {
    public final ParcelableSnapshotMutableState paddingHolder$delegate = Stack.mutableStateOf$default(new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO));

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
    public final float mo122calculateBottomPaddingD9Ej5fM() {
        return ((PaddingValues) this.paddingHolder$delegate.getValue()).mo122calculateBottomPaddingD9Ej5fM();
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
    public final float mo123calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
        return ((PaddingValues) this.paddingHolder$delegate.getValue()).mo123calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    public final float mo124calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
        return ((PaddingValues) this.paddingHolder$delegate.getValue()).mo124calculateRightPaddingu2uoSUM(layoutDirection);
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
    public final float mo125calculateTopPaddingD9Ej5fM() {
        return ((PaddingValues) this.paddingHolder$delegate.getValue()).mo125calculateTopPaddingD9Ej5fM();
    }
}
