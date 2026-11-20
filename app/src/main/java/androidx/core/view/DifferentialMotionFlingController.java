package androidx.core.view;

import android.content.Context;
import android.view.VelocityTracker;
import androidx.datastore.core.AtomicInt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DifferentialMotionFlingController {
    public final Context mContext;
    public float mLastFlingVelocity;
    public final AtomicInt mTarget;
    public VelocityTracker mVelocityTracker;
    public int mLastProcessedAxis = -1;
    public int mLastProcessedSource = -1;
    public int mLastProcessedDeviceId = -1;
    public final int[] mFlingVelocityThresholds = {Integer.MAX_VALUE, 0};

    public DifferentialMotionFlingController(Context context, AtomicInt atomicInt) {
        this.mContext = context;
        this.mTarget = atomicInt;
    }
}
