package androidx.activity.compose;

import androidx.appcompat.view.menu.BaseMenuWrapper;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeBackHandler extends BaseMenuWrapper {
    public Function0 currentOnBackCompleted;

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final void onBackCompleted() {
        this.currentOnBackCompleted.invoke();
    }
}
