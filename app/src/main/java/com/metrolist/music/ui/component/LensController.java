package com.metrolist.music.ui.component;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda13;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LensController {
    public final ParcelableSnapshotMutableState dragging$delegate;
    public final HapticFeedback haptics;
    public final int n;
    public final DerivedSnapshotState nearest$delegate;
    public Function1 onSelect;
    public final Animatable pos;
    public final Animatable press;
    public final CoroutineScope scope;
    public final ParcelableSnapshotMutableIntState selected$delegate;
    public final Animatable stretch;

    public LensController(int i, CoroutineScope coroutineScope, HapticFeedback hapticFeedback, int i2) {
        coroutineScope.getClass();
        hapticFeedback.getClass();
        this.n = i;
        this.scope = coroutineScope;
        this.haptics = hapticFeedback;
        this.pos = ArcSplineKt.Animatable$default(i2);
        this.press = ArcSplineKt.Animatable$default(CropImageView.DEFAULT_ASPECT_RATIO);
        this.stretch = ArcSplineKt.Animatable$default(CropImageView.DEFAULT_ASPECT_RATIO);
        this.dragging$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
        this.selected$delegate = new ParcelableSnapshotMutableIntState(i2);
        this.onSelect = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 16);
        this.nearest$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 9, this));
    }

    public final boolean getDragging() {
        return ((Boolean) this.dragging$delegate.getValue()).booleanValue();
    }

    public final int getNearest() {
        return ((Number) this.nearest$delegate.getValue()).intValue();
    }
}
