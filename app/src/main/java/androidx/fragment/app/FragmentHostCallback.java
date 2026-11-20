package androidx.fragment.app;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentHostCallback extends FragmentContainer {
    public final FragmentActivity mActivity;
    public final Context mContext;
    public final FragmentManagerImpl mFragmentManager;
    public final Handler mHandler;

    public FragmentHostCallback(FragmentActivity fragmentActivity) {
        Handler handler = new Handler();
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = fragmentActivity;
        this.mContext = fragmentActivity;
        this.mHandler = handler;
    }
}
