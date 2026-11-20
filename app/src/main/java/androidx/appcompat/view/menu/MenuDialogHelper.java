package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.ListMenuPresenter.MenuAdapter;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MenuDialogHelper implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback {
    public AlertDialog mDialog;
    public MenuBuilder mMenu;
    public ListMenuPresenter mPresenter;

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        MenuBuilder menuBuilder = this.mMenu;
        ListMenuPresenter listMenuPresenter = this.mPresenter;
        ListMenuPresenter.MenuAdapter menuAdapter = listMenuPresenter.mAdapter;
        if (menuAdapter == null) {
            menuAdapter = listMenuPresenter.new MenuAdapter();
            listMenuPresenter.mAdapter = menuAdapter;
        }
        menuBuilder.performItemAction(menuAdapter.getItem(i), null, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        AlertDialog alertDialog;
        if ((z || menuBuilder == this.mMenu) && (alertDialog = this.mDialog) != null) {
            alertDialog.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.mPresenter.onCloseMenu(this.mMenu, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        MenuBuilder menuBuilder = this.mMenu;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.mDialog.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.mDialog.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                menuBuilder.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return menuBuilder.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public final boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        return false;
    }
}
