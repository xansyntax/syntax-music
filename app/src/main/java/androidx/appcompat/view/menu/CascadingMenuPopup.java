package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatPopupWindow;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.compose.ui.draw.DrawResult;
import androidx.tracing.TraceApi29Impl;
import com.yalantis.ucrop.R;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CascadingMenuPopup extends MenuPopup implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public View mAnchorView;
    public final StandardMenuPopup.AnonymousClass2 mAttachStateChangeListener;
    public final Context mContext;
    public final AppCompatSpinner.AnonymousClass2 mGlobalLayoutListener;
    public boolean mHasXOffset;
    public boolean mHasYOffset;
    public int mLastPosition;
    public final int mMenuMaxWidth;
    public PopupWindow.OnDismissListener mOnDismissListener;
    public final boolean mOverflowOnly;
    public final int mPopupStyleAttr;
    public MenuPresenter.Callback mPresenterCallback;
    public boolean mShouldCloseImmediately;
    public boolean mShowTitle;
    public View mShownAnchorView;
    public final Handler mSubMenuHoverHandler;
    public ViewTreeObserver mTreeObserver;
    public int mXOffset;
    public int mYOffset;
    public final ArrayList mPendingMenus = new ArrayList();
    public final ArrayList mShowingMenus = new ArrayList();
    public final DrawResult mMenuItemHoverListener = new DrawResult((byte) 2, (Object) this);
    public int mRawDropDownGravity = 0;
    public int mDropDownGravity = 0;
    public boolean mForceShowIcon = false;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            this.window = menuPopupWindow;
            this.menu = menuBuilder;
            this.position = i;
        }
    }

    public CascadingMenuPopup(Context context, View view, int i, boolean z) {
        byte b = 1;
        this.mGlobalLayoutListener = new AppCompatSpinner.AnonymousClass2(b, this);
        this.mAttachStateChangeListener = new StandardMenuPopup.AnonymousClass2(b, this);
        this.mContext = context;
        this.mAnchorView = view;
        this.mPopupStyleAttr = i;
        this.mOverflowOnly = z;
        this.mLastPosition = view.getLayoutDirection() == 1 ? (byte) 0 : (byte) 1;
        Resources resources = context.getResources();
        this.mMenuMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.mSubMenuHoverHandler = new Handler();
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void addMenu(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.mContext);
        if (isShowing()) {
            showMenu(menuBuilder);
        } else {
            this.mPendingMenus.add(menuBuilder);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void dismiss() {
        ArrayList arrayList = this.mShowingMenus;
        int size = arrayList.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) arrayList.toArray(new CascadingMenuInfo[size]);
            for (int i = size - 1; i >= 0; i--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i];
                if (cascadingMenuInfo.window.mPopup.isShowing()) {
                    cascadingMenuInfo.window.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final DropDownListView getListView() {
        ArrayList arrayList = this.mShowingMenus;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((CascadingMenuInfo) arrayList.get(arrayList.size() - 1)).window.mDropDownList;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final boolean isShowing() {
        ArrayList arrayList = this.mShowingMenus;
        return arrayList.size() > 0 && ((CascadingMenuInfo) arrayList.get(0)).window.mPopup.isShowing();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        ArrayList arrayList = this.mShowingMenus;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (menuBuilder == ((CascadingMenuInfo) arrayList.get(i)).menu) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        int i2 = i + 1;
        if (i2 < arrayList.size()) {
            ((CascadingMenuInfo) arrayList.get(i2)).menu.close(false);
        }
        CascadingMenuInfo cascadingMenuInfo = (CascadingMenuInfo) arrayList.remove(i);
        MenuBuilder menuBuilder2 = cascadingMenuInfo.menu;
        MenuPopupWindow menuPopupWindow = cascadingMenuInfo.window;
        AppCompatPopupWindow appCompatPopupWindow = menuPopupWindow.mPopup;
        menuBuilder2.removeMenuPresenter(this);
        if (this.mShouldCloseImmediately) {
            appCompatPopupWindow.setExitTransition(null);
            appCompatPopupWindow.setAnimationStyle(0);
        }
        menuPopupWindow.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.mLastPosition = ((CascadingMenuInfo) arrayList.get(size2 - 1)).position;
        } else {
            this.mLastPosition = this.mAnchorView.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z) {
                ((CascadingMenuInfo) arrayList.get(0)).menu.close(false);
                return;
            }
            return;
        }
        dismiss();
        MenuPresenter.Callback callback = this.mPresenterCallback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, true);
        }
        ViewTreeObserver viewTreeObserver = this.mTreeObserver;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            }
            this.mTreeObserver = null;
        }
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        this.mOnDismissListener.onDismiss();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        ArrayList arrayList = this.mShowingMenus;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                cascadingMenuInfo = null;
                break;
            }
            cascadingMenuInfo = (CascadingMenuInfo) arrayList.get(i);
            if (!cascadingMenuInfo.window.mPopup.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.menu.close(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        ArrayList arrayList = this.mShowingMenus;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            CascadingMenuInfo cascadingMenuInfo = (CascadingMenuInfo) obj;
            if (subMenuBuilder == cascadingMenuInfo.menu) {
                cascadingMenuInfo.window.mDropDownList.requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        addMenu(subMenuBuilder);
        MenuPresenter.Callback callback = this.mPresenterCallback;
        if (callback != null) {
            callback.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setAnchorView(View view) {
        if (this.mAnchorView != view) {
            this.mAnchorView = view;
            this.mDropDownGravity = Gravity.getAbsoluteGravity(this.mRawDropDownGravity, view.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void setCallback(MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setGravity(int i) {
        if (this.mRawDropDownGravity != i) {
            this.mRawDropDownGravity = i;
            this.mDropDownGravity = Gravity.getAbsoluteGravity(i, this.mAnchorView.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setHorizontalOffset(int i) {
        this.mHasXOffset = true;
        this.mXOffset = i;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setShowTitle(boolean z) {
        this.mShowTitle = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setVerticalOffset(int i) {
        this.mHasYOffset = true;
        this.mYOffset = i;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void show() {
        if (isShowing()) {
            return;
        }
        ArrayList arrayList = this.mPendingMenus;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            showMenu((MenuBuilder) obj);
        }
        arrayList.clear();
        View view = this.mAnchorView;
        this.mShownAnchorView = view;
        if (view != null) {
            boolean z = this.mTreeObserver == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.mTreeObserver = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            }
            this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        }
    }

    /* JADX WARN: Code duplicated, block: B:68:0x0162  */
    /* JADX WARN: Code duplicated, block: B:70:0x0166  */
    public final void showMenu(MenuBuilder menuBuilder) {
        boolean z;
        int i;
        View childAt;
        CascadingMenuInfo cascadingMenuInfo;
        int i2;
        MenuItem item;
        MenuAdapter menuAdapter;
        int headersCount;
        int firstVisiblePosition;
        Context context = this.mContext;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        MenuAdapter menuAdapter2 = new MenuAdapter(menuBuilder, layoutInflaterFrom, this.mOverflowOnly, R.layout.abc_cascading_menu_item_layout);
        if (!isShowing() && this.mForceShowIcon) {
            menuAdapter2.mForceShowIcon = true;
        } else if (isShowing()) {
            int size = menuBuilder.mItems.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                }
                MenuItem item2 = menuBuilder.getItem(i3);
                if (item2.isVisible() && item2.getIcon() != null) {
                    z = true;
                    break;
                }
                i3++;
            }
            menuAdapter2.mForceShowIcon = z;
        }
        int iMeasureIndividualMenuWidth = MenuPopup.measureIndividualMenuWidth(menuAdapter2, context, this.mMenuMaxWidth);
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(context, null, this.mPopupStyleAttr);
        menuPopupWindow.mHoverListener = this.mMenuItemHoverListener;
        menuPopupWindow.mItemClickListener = this;
        AppCompatPopupWindow appCompatPopupWindow = menuPopupWindow.mPopup;
        appCompatPopupWindow.setOnDismissListener(this);
        menuPopupWindow.mDropDownAnchorView = this.mAnchorView;
        menuPopupWindow.mDropDownGravity = this.mDropDownGravity;
        menuPopupWindow.mModal = true;
        appCompatPopupWindow.setFocusable(true);
        appCompatPopupWindow.setInputMethodMode(2);
        menuPopupWindow.setAdapter(menuAdapter2);
        menuPopupWindow.setContentWidth(iMeasureIndividualMenuWidth);
        menuPopupWindow.mDropDownGravity = this.mDropDownGravity;
        ArrayList arrayList = this.mShowingMenus;
        if (arrayList.size() > 0) {
            cascadingMenuInfo = (CascadingMenuInfo) arrayList.get(arrayList.size() - 1);
            MenuBuilder menuBuilder2 = cascadingMenuInfo.menu;
            int size2 = menuBuilder2.mItems.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size2) {
                    i = 0;
                    item = null;
                    break;
                }
                item = menuBuilder2.getItem(i4);
                if (item.hasSubMenu()) {
                    i = 0;
                    if (menuBuilder == item.getSubMenu()) {
                        break;
                    }
                }
                i4++;
            }
            if (item == null) {
                childAt = null;
            } else {
                DropDownListView dropDownListView = cascadingMenuInfo.window.mDropDownList;
                ListAdapter adapter = dropDownListView.getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    menuAdapter = (MenuAdapter) adapter;
                    headersCount = i;
                }
                int count = menuAdapter.getCount();
                int i5 = i;
                while (true) {
                    if (i5 >= count) {
                        i5 = -1;
                        break;
                    } else if (item == menuAdapter.getItem(i5)) {
                        break;
                    } else {
                        i5++;
                    }
                }
                childAt = (i5 != -1 && (firstVisiblePosition = (i5 + headersCount) - dropDownListView.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < dropDownListView.getChildCount()) ? dropDownListView.getChildAt(firstVisiblePosition) : null;
            }
        } else {
            i = 0;
            childAt = null;
            cascadingMenuInfo = null;
        }
        if (childAt != null) {
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = MenuPopupWindow.sSetTouchModalMethod;
                if (method != null) {
                    try {
                        Object[] objArr = new Object[1];
                        objArr[i] = Boolean.FALSE;
                        method.invoke(appCompatPopupWindow, objArr);
                    } catch (Exception unused) {
                        Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                    }
                }
            } else {
                TraceApi29Impl.setTouchModal(appCompatPopupWindow);
            }
            appCompatPopupWindow.setEnterTransition(null);
            DropDownListView dropDownListView2 = ((CascadingMenuInfo) arrayList.get(arrayList.size() - 1)).window.mDropDownList;
            int[] iArr = new int[2];
            dropDownListView2.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            this.mShownAnchorView.getWindowVisibleDisplayFrame(rect);
            if (this.mLastPosition == 1) {
                if (dropDownListView2.getWidth() + iArr[i] + iMeasureIndividualMenuWidth > rect.right) {
                    i2 = i;
                } else {
                    i2 = 1;
                }
            } else if (iArr[i] - iMeasureIndividualMenuWidth < 0) {
                i2 = 1;
            } else {
                i2 = i;
            }
            int i6 = i2 == 1 ? 1 : i;
            this.mLastPosition = i2;
            menuPopupWindow.mDropDownAnchorView = childAt;
            if ((this.mDropDownGravity & 5) != 5) {
                iMeasureIndividualMenuWidth = i6 != 0 ? childAt.getWidth() : 0 - iMeasureIndividualMenuWidth;
            } else if (i6 == 0) {
                iMeasureIndividualMenuWidth = 0 - childAt.getWidth();
            }
            menuPopupWindow.mDropDownHorizontalOffset = iMeasureIndividualMenuWidth;
            menuPopupWindow.mOverlapAnchorSet = true;
            menuPopupWindow.mOverlapAnchor = true;
            menuPopupWindow.setVerticalOffset(i);
        } else {
            if (this.mHasXOffset) {
                menuPopupWindow.mDropDownHorizontalOffset = this.mXOffset;
            }
            if (this.mHasYOffset) {
                menuPopupWindow.setVerticalOffset(this.mYOffset);
            }
            Rect rect2 = this.mEpicenterBounds;
            menuPopupWindow.mEpicenterBounds = rect2 != null ? new Rect(rect2) : null;
        }
        arrayList.add(new CascadingMenuInfo(menuPopupWindow, menuBuilder, this.mLastPosition));
        menuPopupWindow.show();
        DropDownListView dropDownListView3 = menuPopupWindow.mDropDownList;
        dropDownListView3.setOnKeyListener(this);
        if (cascadingMenuInfo == null && this.mShowTitle && menuBuilder.mHeaderTitle != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) dropDownListView3, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(menuBuilder.mHeaderTitle);
            dropDownListView3.addHeaderView(frameLayout, null, false);
            menuPopupWindow.show();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void updateMenuView() {
        ArrayList arrayList = this.mShowingMenus;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ListAdapter adapter = ((CascadingMenuInfo) obj).window.mDropDownList.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((MenuAdapter) adapter).notifyDataSetChanged();
        }
    }
}
