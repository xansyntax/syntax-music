package androidx.compose.foundation;

import android.view.View;
import androidx.compose.ui.unit.Density;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface PlatformMagnifierFactory {
    /* JADX INFO: renamed from: create-nHHXs2Y, reason: not valid java name */
    PlatformMagnifier mo54createnHHXs2Y(View view, boolean z, long j, float f, float f2, boolean z2, Density density, float f3);

    boolean getCanUpdateZoom();
}
