package androidx.compose.foundation.text.input.internal;

import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorKt;
import com.metrolist.music.ui.component.AppNavigationKt$$ExternalSyntheticApiModelOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Api34StartStylusHandwriting {
    public static final void setEditorBoundsInfo(CursorAnchorInfo.Builder builder, Rect rect) {
        builder.setEditorBoundsInfo(AppNavigationKt$$ExternalSyntheticApiModelOutline0.m().setEditorBounds(ColorKt.toAndroidRectF(rect)).setHandwritingBounds(ColorKt.toAndroidRectF(rect)).build());
    }

    public static void startStylusHandwriting(InputMethodManager inputMethodManager, View view) {
        inputMethodManager.startStylusHandwriting(view);
    }
}
