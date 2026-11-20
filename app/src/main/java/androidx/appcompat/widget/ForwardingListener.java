package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ShowableListMenu;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {
    public int mActivePointerId;
    public TriggerLongPress mDisallowIntercept;
    public boolean mForwarding;
    public final int mLongPressTimeout;
    public final float mScaledTouchSlop;
    public final View mSrc;
    public final int mTapTimeout;
    public final int[] mTmpLocation = new int[2];
    public TriggerLongPress mTriggerLongPress;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TriggerLongPress implements Runnable {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ ForwardingListener this$0;

        public /* synthetic */ TriggerLongPress(ForwardingListener forwardingListener, byte b) {
            this.$r8$classId = b;
            this.this$0 = forwardingListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            byte b = this.$r8$classId;
            ForwardingListener forwardingListener = this.this$0;
            switch (b) {
                case 0:
                    forwardingListener.clearCallbacks();
                    View view = forwardingListener.mSrc;
                    if (view.isEnabled() && !view.isLongClickable() && forwardingListener.onForwardingStarted()) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0);
                        view.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                        forwardingListener.mForwarding = true;
                        break;
                    }
                    break;
                default:
                    ViewParent parent = forwardingListener.mSrc.getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    break;
            }
        }
    }

    public ForwardingListener(View view) {
        this.mSrc = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.mScaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.mTapTimeout = tapTimeout;
        this.mLongPressTimeout = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void clearCallbacks() {
        TriggerLongPress triggerLongPress = this.mTriggerLongPress;
        View view = this.mSrc;
        if (triggerLongPress != null) {
            view.removeCallbacks(triggerLongPress);
        }
        TriggerLongPress triggerLongPress2 = this.mDisallowIntercept;
        if (triggerLongPress2 != null) {
            view.removeCallbacks(triggerLongPress2);
        }
    }

    public abstract ShowableListMenu getPopup();

    public abstract boolean onForwardingStarted();

    public boolean onForwardingStopped() {
        ShowableListMenu popup = getPopup();
        if (popup == null || !popup.isShowing()) {
            return true;
        }
        popup.dismiss();
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005c  */
    /* JADX WARN: Code duplicated, block: B:24:0x0062  */
    /* JADX WARN: Code duplicated, block: B:25:0x0065  */
    /* JADX WARN: Code duplicated, block: B:50:0x00cb  */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        DropDownListView listView;
        boolean z2 = this.mForwarding;
        View view2 = this.mSrc;
        byte b = 0;
        byte b2 = 1;
        if (z2) {
            ShowableListMenu popup = getPopup();
            if (popup != null && popup.isShowing() && (listView = popup.getListView()) != null && listView.isShown()) {
                MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                int[] iArr = this.mTmpLocation;
                view2.getLocationOnScreen(iArr);
                motionEventObtainNoHistory.offsetLocation(iArr[0], iArr[1]);
                listView.getLocationOnScreen(iArr);
                motionEventObtainNoHistory.offsetLocation(-iArr[0], -iArr[1]);
                boolean zOnForwardedEvent = listView.onForwardedEvent(motionEventObtainNoHistory, this.mActivePointerId);
                motionEventObtainNoHistory.recycle();
                int actionMasked = motionEvent.getActionMasked();
                boolean z3 = (actionMasked == 1 || actionMasked == 3) ? false : true;
                if (zOnForwardedEvent && z3) {
                    z = true;
                } else if (onForwardingStopped()) {
                    z = false;
                } else {
                    z = true;
                }
            } else if (onForwardingStopped()) {
                z = true;
            } else {
                z = false;
            }
        } else {
            if (view2.isEnabled()) {
                int actionMasked2 = motionEvent.getActionMasked();
                if (actionMasked2 == 0) {
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    TriggerLongPress triggerLongPress = this.mDisallowIntercept;
                    if (triggerLongPress == null) {
                        triggerLongPress = new TriggerLongPress(this, b2);
                        this.mDisallowIntercept = triggerLongPress;
                    }
                    view2.postDelayed(triggerLongPress, this.mTapTimeout);
                    TriggerLongPress triggerLongPress2 = this.mTriggerLongPress;
                    if (triggerLongPress2 == null) {
                        triggerLongPress2 = new TriggerLongPress(this, b);
                        this.mTriggerLongPress = triggerLongPress2;
                    }
                    view2.postDelayed(triggerLongPress2, this.mLongPressTimeout);
                } else if (actionMasked2 == 1) {
                    clearCallbacks();
                } else if (actionMasked2 == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (iFindPointerIndex >= 0) {
                        float x = motionEvent.getX(iFindPointerIndex);
                        float y = motionEvent.getY(iFindPointerIndex);
                        float f = this.mScaledTouchSlop;
                        float f2 = -f;
                        if (x < f2 || y < f2 || x >= (view2.getRight() - view2.getLeft()) + f || y >= (view2.getBottom() - view2.getTop()) + f) {
                            clearCallbacks();
                            view2.getParent().requestDisallowInterceptTouchEvent(true);
                            if (onForwardingStarted()) {
                                z = true;
                            }
                        }
                    }
                } else if (actionMasked2 == 3) {
                    clearCallbacks();
                }
                z = false;
            } else {
                z = false;
            }
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0);
                view2.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.mForwarding = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.mForwarding = false;
        this.mActivePointerId = -1;
        TriggerLongPress triggerLongPress = this.mDisallowIntercept;
        if (triggerLongPress != null) {
            this.mSrc.removeCallbacks(triggerLongPress);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
