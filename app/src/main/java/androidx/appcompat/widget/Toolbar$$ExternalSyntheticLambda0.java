package androidx.appcompat.widget;

import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Toolbar$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Toolbar f$0;

    public /* synthetic */ Toolbar$$ExternalSyntheticLambda0(Toolbar toolbar, byte b) {
        this.$r8$classId = b;
        this.f$0 = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        Toolbar toolbar = this.f$0;
        switch (b) {
            case 0:
                Toolbar.ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = toolbar.mExpandedMenuPresenter;
                MenuItemImpl menuItemImpl = expandedActionViewMenuPresenter == null ? null : expandedActionViewMenuPresenter.mCurrentExpandedItem;
                if (menuItemImpl != null) {
                    menuItemImpl.collapseActionView();
                }
                break;
            default:
                toolbar.invalidateMenu();
                break;
        }
    }
}
