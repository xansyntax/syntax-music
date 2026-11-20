package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewStructure;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Api23Impl {
    public static final void setClassName(ViewStructure viewStructure, View view) {
        viewStructure.setClassName(view.getAccessibilityClassName().toString());
    }
}
