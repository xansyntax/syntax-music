package androidx.appcompat.app;

import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.ViewCompat;
import androidx.media3.common.FlagSet;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ToolbarActionBar extends ActionBar {
    public final ToolbarWidgetWrapper mDecorToolbar;
    public boolean mLastMenuVisibility;
    public final AnonymousClass2 mMenuCallback;
    public boolean mMenuCallbackSet;
    public boolean mToolbarMenuPrepared;
    public final Window.Callback mWindowCallback;
    public final ArrayList mMenuVisibilityListeners = new ArrayList();
    public final Toolbar.AnonymousClass2 mMenuInvalidator = new Toolbar.AnonymousClass2(1, this);

    /* JADX INFO: renamed from: androidx.appcompat.app.ToolbarActionBar$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements Toolbar.OnMenuItemClickListener, MenuBuilder.Callback {
        public /* synthetic */ AnonymousClass2() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            boolean zIsOverflowMenuShowing = toolbarActionBar.mDecorToolbar.mToolbar.isOverflowMenuShowing();
            Window.Callback callback = toolbarActionBar.mWindowCallback;
            if (zIsOverflowMenuShowing) {
                callback.onPanelClosed(108, menuBuilder);
            } else if (callback.onPreparePanel(0, null, menuBuilder)) {
                callback.onMenuOpened(108, menuBuilder);
            }
        }
    }

    public ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, AppCompatDelegateImpl.AppCompatWindowCallback appCompatWindowCallback) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        ToolbarWidgetWrapper toolbarWidgetWrapper = new ToolbarWidgetWrapper(toolbar, false);
        this.mDecorToolbar = toolbarWidgetWrapper;
        appCompatWindowCallback.getClass();
        this.mWindowCallback = appCompatWindowCallback;
        toolbarWidgetWrapper.mWindowCallback = appCompatWindowCallback;
        toolbar.setOnMenuItemClickListener(anonymousClass2);
        boolean z = toolbarWidgetWrapper.mTitleSet;
        if (!z) {
            toolbarWidgetWrapper.mTitle = charSequence;
            if ((toolbarWidgetWrapper.mDisplayOpts & 8) != 0) {
                toolbar.setTitle(charSequence);
                if (z) {
                    ViewCompat.setAccessibilityPaneTitle(toolbar.getRootView(), charSequence);
                }
            }
        }
        this.mMenuCallback = new AnonymousClass2();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean closeOptionsMenu() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.mDecorToolbar.mToolbar.mMenuView;
        return (actionMenuView == null || (actionMenuPresenter = actionMenuView.mPresenter) == null || !actionMenuPresenter.hideOverflowMenu()) ? false : true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean collapseActionView() {
        MenuItemImpl menuItemImpl;
        Toolbar.ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mDecorToolbar.mToolbar.mExpandedMenuPresenter;
        if (expandedActionViewMenuPresenter == null || (menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem) == null) {
            return false;
        }
        if (expandedActionViewMenuPresenter == null) {
            menuItemImpl = null;
        }
        if (menuItemImpl == null) {
            return true;
        }
        menuItemImpl.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void dispatchMenuVisibilityChanged(boolean z) {
        if (z == this.mLastMenuVisibility) {
            return;
        }
        this.mLastMenuVisibility = z;
        ArrayList arrayList = this.mMenuVisibilityListeners;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        PathKt$$ExternalSyntheticBUOutline0.m();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final int getDisplayOptions() {
        return this.mDecorToolbar.mDisplayOpts;
    }

    public final Menu getMenu() {
        boolean z = this.mMenuCallbackSet;
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.mDecorToolbar;
        if (!z) {
            FlagSet.Builder builder = new FlagSet.Builder();
            builder.flags = this;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2();
            Toolbar toolbar = toolbarWidgetWrapper.mToolbar;
            toolbar.mActionMenuPresenterCallback = builder;
            toolbar.mMenuBuilderCallback = anonymousClass2;
            ActionMenuView actionMenuView = toolbar.mMenuView;
            if (actionMenuView != null) {
                actionMenuView.mActionMenuPresenterCallback = builder;
                actionMenuView.mMenuBuilderCallback = anonymousClass2;
            }
            this.mMenuCallbackSet = true;
        }
        return toolbarWidgetWrapper.mToolbar.getMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final Context getThemedContext() {
        return this.mDecorToolbar.mToolbar.getContext();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean invalidateOptionsMenu() {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.mDecorToolbar;
        Toolbar toolbar = toolbarWidgetWrapper.mToolbar;
        Toolbar.AnonymousClass2 anonymousClass2 = this.mMenuInvalidator;
        toolbar.removeCallbacks(anonymousClass2);
        Toolbar toolbar2 = toolbarWidgetWrapper.mToolbar;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        toolbar2.postOnAnimation(anonymousClass2);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void onDestroy() {
        this.mDecorToolbar.mToolbar.removeCallbacks(this.mMenuInvalidator);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu menu = getMenu();
        if (menu == null) {
            return false;
        }
        menu.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
        return menu.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean onMenuKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            openOptionsMenu();
        }
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean openOptionsMenu() {
        return this.mDecorToolbar.mToolbar.showOverflowMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setDisplayShowTitleEnabled() {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.mDecorToolbar;
        toolbarWidgetWrapper.setDisplayOptions(toolbarWidgetWrapper.mDisplayOpts & (-9));
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setWindowTitle(CharSequence charSequence) {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.mDecorToolbar;
        if (toolbarWidgetWrapper.mTitleSet) {
            return;
        }
        Toolbar toolbar = toolbarWidgetWrapper.mToolbar;
        toolbarWidgetWrapper.mTitle = charSequence;
        if ((toolbarWidgetWrapper.mDisplayOpts & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (toolbarWidgetWrapper.mTitleSet) {
                ViewCompat.setAccessibilityPaneTitle(toolbar.getRootView(), charSequence);
            }
        }
    }
}
