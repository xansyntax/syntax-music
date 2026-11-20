package androidx.compose.animation;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.TransformOrigin;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TransformScopeImpl {
    public final ParcelableSnapshotMutableFloatState _alpha;
    public final ParcelableSnapshotMutableFloatState _scale;
    public final ParcelableSnapshotMutableState _transformOrigin;
    public final ParcelableSnapshotMutableState _veil;
    public final ParcelableSnapshotMutableState isAlphaMutated$delegate;
    public final ParcelableSnapshotMutableState isScaleMutated$delegate;
    public final ParcelableSnapshotMutableState isTransformOriginMutated$delegate;
    public final ParcelableSnapshotMutableState isVeilMutated$delegate;

    public TransformScopeImpl() {
        Boolean bool = Boolean.FALSE;
        this.isAlphaMutated$delegate = Stack.mutableStateOf$default(bool);
        this._alpha = new ParcelableSnapshotMutableFloatState(1.0f);
        this.isScaleMutated$delegate = Stack.mutableStateOf$default(bool);
        this._scale = new ParcelableSnapshotMutableFloatState(1.0f);
        this.isTransformOriginMutated$delegate = Stack.mutableStateOf$default(bool);
        this._transformOrigin = Stack.mutableStateOf$default(new TransformOrigin(ColorKt.TransformOrigin(0.5f, 0.5f)));
        this.isVeilMutated$delegate = Stack.mutableStateOf$default(bool);
        this._veil = Stack.mutableStateOf$default(new Color(0L));
    }

    public final boolean isAlphaMutated() {
        return ((Boolean) this.isAlphaMutated$delegate.getValue()).booleanValue();
    }

    public final boolean isScaleMutated() {
        return ((Boolean) this.isScaleMutated$delegate.getValue()).booleanValue();
    }

    public final boolean isVeilMutated() {
        return ((Boolean) this.isVeilMutated$delegate.getValue()).booleanValue();
    }

    public final void reset() {
        this._alpha.setFloatValue(1.0f);
        Boolean bool = Boolean.FALSE;
        this.isAlphaMutated$delegate.setValue(bool);
        this._scale.setFloatValue(1.0f);
        this.isScaleMutated$delegate.setValue(bool);
        this._transformOrigin.setValue(new TransformOrigin(ColorKt.TransformOrigin(0.5f, 0.5f)));
        this.isTransformOriginMutated$delegate.setValue(bool);
        this._veil.setValue(new Color(0L));
        this.isVeilMutated$delegate.setValue(bool);
    }
}
