package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface MenuItemHoverListener {
    void onItemHoverEnter(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);

    void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem);
}
