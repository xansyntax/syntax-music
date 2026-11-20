package androidx.appcompat.app;

import android.content.Context;
import android.view.KeyEvent;
import androidx.appcompat.view.ActionMode;
import androidx.compose.ui.platform.WeakCache;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ActionBar {
    public boolean closeOptionsMenu() {
        return false;
    }

    public abstract boolean collapseActionView();

    public abstract void dispatchMenuVisibilityChanged(boolean z);

    public abstract int getDisplayOptions();

    public abstract Context getThemedContext();

    public boolean invalidateOptionsMenu() {
        return false;
    }

    public abstract boolean onKeyShortcut(int i, KeyEvent keyEvent);

    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public boolean openOptionsMenu() {
        return false;
    }

    public abstract void setDisplayShowTitleEnabled();

    public abstract void setWindowTitle(CharSequence charSequence);

    public ActionMode startActionMode(WeakCache weakCache) {
        return null;
    }

    public void onConfigurationChanged() {
    }

    public void onDestroy() {
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
    }

    public void setShowHideAnimationEnabled(boolean z) {
    }
}
