package androidx.compose.material3.ripple;

import android.content.Context;
import android.view.ViewGroup;
import androidx.core.provider.CallbackWrapper;
import com.yalantis.ucrop.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RippleContainer extends ViewGroup {
    public final byte MaxRippleHosts;
    public int nextHostIndex;
    public final CallbackWrapper rippleHostMap;
    public final ArrayList rippleHosts;
    public final ArrayList unusedRippleHosts;

    public RippleContainer(Context context) {
        super(context);
        this.MaxRippleHosts = (byte) 5;
        ArrayList arrayList = new ArrayList();
        this.rippleHosts = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.unusedRippleHosts = arrayList2;
        this.rippleHostMap = new CallbackWrapper((byte) 5);
        setClipChildren(false);
        RippleHostView rippleHostView = new RippleHostView(context);
        addView(rippleHostView);
        arrayList.add(rippleHostView);
        arrayList2.add(rippleHostView);
        this.nextHostIndex = 1;
        setTag(R.id.hide_in_inspector_tag, Boolean.TRUE);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }
}
