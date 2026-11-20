package androidx.activity.result;

import android.os.Bundle;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.foundation.lazy.LazyListMeasuredItem;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import coil3.util.LifecyclesKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ActivityResultRegistry$$ExternalSyntheticLambda1 implements LifecycleEventObserver {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ ActivityResultRegistry$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, Object obj4, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        byte b = this.$r8$classId;
        Object obj = this.f$3;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                ActivityResultRegistry activityResultRegistry = (ActivityResultRegistry) obj4;
                LinkedHashMap linkedHashMap = activityResultRegistry.keyToCallback;
                String str = (String) obj3;
                ActivityResultCallback activityResultCallback = (ActivityResultCallback) obj2;
                ActivityResultContract activityResultContract = (ActivityResultContract) obj;
                if (Lifecycle.Event.ON_START == event) {
                    Bundle bundle = activityResultRegistry.pendingResults;
                    LinkedHashMap linkedHashMap2 = activityResultRegistry.parsedPendingResults;
                    linkedHashMap.put(str, new ActivityResultRegistry.CallbackAndContract(activityResultContract, activityResultCallback));
                    if (linkedHashMap2.containsKey(str)) {
                        Object obj5 = linkedHashMap2.get(str);
                        linkedHashMap2.remove(str);
                        activityResultCallback.onActivityResult(obj5);
                    }
                    ActivityResult activityResult = (ActivityResult) LifecyclesKt.getParcelable(bundle, str, ActivityResult.class);
                    if (activityResult != null) {
                        bundle.remove(str);
                        activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.data, activityResult.resultCode));
                    }
                } else if (Lifecycle.Event.ON_STOP == event) {
                    linkedHashMap.remove(str);
                } else if (Lifecycle.Event.ON_DESTROY == event) {
                    activityResultRegistry.unregister$activity(str);
                }
                break;
            default:
                LazyListState lazyListState = (LazyListState) obj4;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) obj3;
                MutableState mutableState = (MutableState) obj2;
                MutableState mutableState2 = (MutableState) obj;
                if (event == Lifecycle.Event.ON_STOP) {
                    List list = lazyListState.getLayoutInfo().visibleItemsInfo;
                    if (!list.isEmpty()) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            if (((LazyListMeasuredItem) it.next()).index == parcelableSnapshotMutableIntState.getIntValue()) {
                                mutableState.setValue(Boolean.FALSE);
                            }
                        }
                    }
                    mutableState2.setValue(Boolean.TRUE);
                } else if (event == Lifecycle.Event.ON_START) {
                    mutableState2.setValue(Boolean.FALSE);
                }
                break;
        }
    }
}
