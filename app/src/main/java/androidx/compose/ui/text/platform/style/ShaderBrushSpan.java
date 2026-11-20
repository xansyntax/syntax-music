package androidx.compose.ui.text.platform.style;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.text.platform.AndroidTextPaint_androidKt;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ShaderBrushSpan extends CharacterStyle implements UpdateAppearance {
    public final float alpha;
    public final ShaderBrush shaderBrush;
    public final ParcelableSnapshotMutableState size$delegate = Stack.mutableStateOf$default(new Size(9205357640488583168L));
    public final DerivedSnapshotState shaderState = SnapshotStateKt__DerivedStateKt.derivedStateOf(new RoomDatabase$$ExternalSyntheticLambda0((byte) 20, this));

    public ShaderBrushSpan(ShaderBrush shaderBrush, float f) {
        this.shaderBrush = shaderBrush;
        this.alpha = f;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        AndroidTextPaint_androidKt.setAlpha(textPaint, this.alpha);
        textPaint.setShader((Shader) this.shaderState.getValue());
    }
}
