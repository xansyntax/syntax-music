package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.tracing.TraceApi29Impl;
import coil3.size.SizeKt;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ListPopupWindow implements ShowableListMenu {
    public static final Method sSetClipToWindowEnabledMethod;
    public static final Method sSetEpicenterBoundsMethod;
    public ListAdapter mAdapter;
    public final Context mContext;
    public View mDropDownAnchorView;
    public int mDropDownHorizontalOffset;
    public DropDownListView mDropDownList;
    public int mDropDownVerticalOffset;
    public boolean mDropDownVerticalOffsetSet;
    public Rect mEpicenterBounds;
    public final Handler mHandler;
    public AdapterView.OnItemClickListener mItemClickListener;
    public boolean mModal;
    public PopupDataSetObserver mObserver;
    public boolean mOverlapAnchor;
    public boolean mOverlapAnchorSet;
    public final AppCompatPopupWindow mPopup;
    public final int mDropDownHeight = -2;
    public int mDropDownWidth = -2;
    public final short mDropDownWindowLayoutType = 1002;
    public int mDropDownGravity = 0;
    public final int mListItemExpandMaximum = Integer.MAX_VALUE;
    public final ListSelectorHider mResizePopupRunnable = new ListSelectorHider(this, 1);
    public final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor();
    public final PopupScrollListener mScrollListener = new PopupScrollListener();
    public final ListSelectorHider mHideSelector = new ListSelectorHider(this, 0);
    public final Rect mTempRect = new Rect();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ListSelectorHider implements Runnable {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ ListPopupWindow this$0;

        public /* synthetic */ ListSelectorHider(ListPopupWindow listPopupWindow, byte b) {
            this.$r8$classId = b;
            this.this$0 = listPopupWindow;
        }

        @Override // java.lang.Runnable
        public final void run() {
            byte b = this.$r8$classId;
            ListPopupWindow listPopupWindow = this.this$0;
            switch (b) {
                case 0:
                    DropDownListView dropDownListView = listPopupWindow.mDropDownList;
                    if (dropDownListView != null) {
                        dropDownListView.setListSelectionHidden(true);
                        dropDownListView.requestLayout();
                    }
                    break;
                default:
                    DropDownListView dropDownListView2 = listPopupWindow.mDropDownList;
                    if (dropDownListView2 != null && dropDownListView2.isAttachedToWindow() && listPopupWindow.mDropDownList.getCount() > listPopupWindow.mDropDownList.getChildCount() && listPopupWindow.mDropDownList.getChildCount() <= listPopupWindow.mListItemExpandMaximum) {
                        listPopupWindow.mPopup.setInputMethodMode(2);
                        listPopupWindow.show();
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PopupDataSetObserver extends DataSetObserver {
        public PopupDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (listPopupWindow.mPopup.isShowing()) {
                listPopupWindow.show();
            }
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PopupTouchInterceptor implements View.OnTouchListener {
        public PopupTouchInterceptor() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            ListSelectorHider listSelectorHider = listPopupWindow.mResizePopupRunnable;
            Handler handler = listPopupWindow.mHandler;
            AppCompatPopupWindow appCompatPopupWindow = listPopupWindow.mPopup;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && appCompatPopupWindow != null && appCompatPopupWindow.isShowing() && x >= 0 && x < appCompatPopupWindow.getWidth() && y >= 0 && y < appCompatPopupWindow.getHeight()) {
                handler.postDelayed(listSelectorHider, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            handler.removeCallbacks(listSelectorHider);
            return false;
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                sSetClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                sSetEpicenterBoundsMethod = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        int resourceId;
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i, 0);
        this.mDropDownHorizontalOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.mDropDownVerticalOffset = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.PopupWindow, i, 0);
        if (typedArrayObtainStyledAttributes2.hasValue(2)) {
            appCompatPopupWindow.setOverlapAnchor(typedArrayObtainStyledAttributes2.getBoolean(2, false));
        }
        appCompatPopupWindow.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(0) : SizeKt.getDrawable(context, resourceId));
        typedArrayObtainStyledAttributes2.recycle();
        this.mPopup = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }

    public DropDownListView createDropDownListView(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void dismiss() {
        AppCompatPopupWindow appCompatPopupWindow = this.mPopup;
        appCompatPopupWindow.dismiss();
        appCompatPopupWindow.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    public final Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public final int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final DropDownListView getListView() {
        return this.mDropDownList;
    }

    public final int getVerticalOffset() {
        if (this.mDropDownVerticalOffsetSet) {
            return this.mDropDownVerticalOffset;
        }
        return 0;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public void setAdapter(ListAdapter listAdapter) {
        PopupDataSetObserver popupDataSetObserver = this.mObserver;
        if (popupDataSetObserver == null) {
            this.mObserver = new PopupDataSetObserver();
        } else {
            ListAdapter listAdapter2 = this.mAdapter;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(popupDataSetObserver);
            }
        }
        this.mAdapter = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.mAdapter);
        }
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.mPopup.setBackgroundDrawable(drawable);
    }

    public final void setContentWidth(int i) {
        Drawable background = this.mPopup.getBackground();
        if (background == null) {
            this.mDropDownWidth = i;
            return;
        }
        Rect rect = this.mTempRect;
        background.getPadding(rect);
        this.mDropDownWidth = rect.left + rect.right + i;
    }

    public final void setHorizontalOffset(int i) {
        this.mDropDownHorizontalOffset = i;
    }

    public final void setVerticalOffset(int i) {
        this.mDropDownVerticalOffset = i;
        this.mDropDownVerticalOffsetSet = true;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void show() {
        int i;
        int iMakeMeasureSpec;
        int paddingBottom;
        DropDownListView dropDownListView;
        DropDownListView dropDownListView2 = this.mDropDownList;
        Context context = this.mContext;
        AppCompatPopupWindow appCompatPopupWindow = this.mPopup;
        if (dropDownListView2 == null) {
            DropDownListView dropDownListViewCreateDropDownListView = createDropDownListView(context, !this.mModal);
            this.mDropDownList = dropDownListViewCreateDropDownListView;
            dropDownListViewCreateDropDownListView.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable(true);
            this.mDropDownList.setFocusableInTouchMode(true);
            this.mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.ListPopupWindow.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onItemSelected(AdapterView adapterView, View view, int i2, long j) {
                    DropDownListView dropDownListView3;
                    if (i2 == -1 || (dropDownListView3 = ListPopupWindow.this.mDropDownList) == null) {
                        return;
                    }
                    dropDownListView3.setListSelectionHidden(false);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onNothingSelected(AdapterView adapterView) {
                }
            });
            this.mDropDownList.setOnScrollListener(this.mScrollListener);
            appCompatPopupWindow.setContentView(this.mDropDownList);
        }
        Drawable background = appCompatPopupWindow.getBackground();
        Rect rect = this.mTempRect;
        if (background != null) {
            background.getPadding(rect);
            int i2 = rect.top;
            i = rect.bottom + i2;
            if (!this.mDropDownVerticalOffsetSet) {
                this.mDropDownVerticalOffset = -i2;
            }
        } else {
            rect.setEmpty();
            i = 0;
        }
        int maxAvailableHeight = appCompatPopupWindow.getMaxAvailableHeight(this.mDropDownAnchorView, this.mDropDownVerticalOffset, appCompatPopupWindow.getInputMethodMode() == 2);
        int i3 = this.mDropDownHeight;
        if (i3 == -1) {
            paddingBottom = maxAvailableHeight + i;
        } else {
            int i4 = this.mDropDownWidth;
            if (i4 != -2) {
                iMakeMeasureSpec = i4 != -1 ? View.MeasureSpec.makeMeasureSpec(i4, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824);
            } else {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE);
            }
            int iMeasureHeightOfChildrenCompat = this.mDropDownList.measureHeightOfChildrenCompat(iMakeMeasureSpec, maxAvailableHeight);
            paddingBottom = iMeasureHeightOfChildrenCompat + (iMeasureHeightOfChildrenCompat > 0 ? this.mDropDownList.getPaddingBottom() + this.mDropDownList.getPaddingTop() + i : 0);
        }
        boolean z = appCompatPopupWindow.getInputMethodMode() == 2;
        appCompatPopupWindow.setWindowLayoutType(this.mDropDownWindowLayoutType);
        if (appCompatPopupWindow.isShowing()) {
            if (this.mDropDownAnchorView.isAttachedToWindow()) {
                int width = this.mDropDownWidth;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.mDropDownAnchorView.getWidth();
                }
                if (i3 == -1) {
                    i3 = z ? paddingBottom : -1;
                    int i5 = this.mDropDownWidth;
                    if (z) {
                        appCompatPopupWindow.setWidth(i5 == -1 ? -1 : 0);
                        appCompatPopupWindow.setHeight(0);
                    } else {
                        appCompatPopupWindow.setWidth(i5 == -1 ? -1 : 0);
                        appCompatPopupWindow.setHeight(-1);
                    }
                } else if (i3 == -2) {
                    i3 = paddingBottom;
                }
                appCompatPopupWindow.setOutsideTouchable(true);
                int i6 = width;
                View view = this.mDropDownAnchorView;
                int i7 = this.mDropDownHorizontalOffset;
                int i8 = this.mDropDownVerticalOffset;
                int i9 = i6 < 0 ? -1 : i6;
                if (i3 < 0) {
                    i3 = -1;
                }
                appCompatPopupWindow.update(view, i7, i8, i9, i3);
                return;
            }
            return;
        }
        int width2 = this.mDropDownWidth;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.mDropDownAnchorView.getWidth();
        }
        if (i3 == -1) {
            i3 = -1;
        } else if (i3 == -2) {
            i3 = paddingBottom;
        }
        appCompatPopupWindow.setWidth(width2);
        appCompatPopupWindow.setHeight(i3);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = sSetClipToWindowEnabledMethod;
            if (method != null) {
                try {
                    method.invoke(appCompatPopupWindow, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            TraceApi29Impl.setIsClippedToScreen(appCompatPopupWindow);
        }
        appCompatPopupWindow.setOutsideTouchable(true);
        appCompatPopupWindow.setTouchInterceptor(this.mTouchInterceptor);
        if (this.mOverlapAnchorSet) {
            appCompatPopupWindow.setOverlapAnchor(this.mOverlapAnchor);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = sSetEpicenterBoundsMethod;
            if (method2 != null) {
                try {
                    method2.invoke(appCompatPopupWindow, this.mEpicenterBounds);
                } catch (Exception e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
        } else {
            TraceApi29Impl.setEpicenterBounds(appCompatPopupWindow, this.mEpicenterBounds);
        }
        appCompatPopupWindow.showAsDropDown(this.mDropDownAnchorView, this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
        this.mDropDownList.setSelection(-1);
        if ((!this.mModal || this.mDropDownList.isInTouchMode()) && (dropDownListView = this.mDropDownList) != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
        if (this.mModal) {
            return;
        }
        this.mHandler.post(this.mHideSelector);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PopupScrollListener implements AbsListView.OnScrollListener {
        public PopupScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            ListSelectorHider listSelectorHider = listPopupWindow.mResizePopupRunnable;
            AppCompatPopupWindow appCompatPopupWindow = listPopupWindow.mPopup;
            if (i != 1 || appCompatPopupWindow.getInputMethodMode() == 2 || appCompatPopupWindow.getContentView() == null) {
                return;
            }
            listPopupWindow.mHandler.removeCallbacks(listSelectorHider);
            listSelectorHider.run();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }
}
