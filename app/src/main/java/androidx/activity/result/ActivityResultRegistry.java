package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import coil3.util.LifecyclesKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.websocket.PingPongKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.SequencesKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultRegistry {
    public final LinkedHashMap rcToKey = new LinkedHashMap();
    public final LinkedHashMap keyToRc = new LinkedHashMap();
    public final LinkedHashMap keyToLifecycleContainers = new LinkedHashMap();
    public final ArrayList launchedKeys = new ArrayList();
    public final transient LinkedHashMap keyToCallback = new LinkedHashMap();
    public final LinkedHashMap parsedPendingResults = new LinkedHashMap();
    public final Bundle pendingResults = new Bundle();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CallbackAndContract {
        public final ActivityResultCallback callback;
        public final ActivityResultContract contract;

        public CallbackAndContract(ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
            activityResultCallback.getClass();
            activityResultContract.getClass();
            this.callback = activityResultCallback;
            this.contract = activityResultContract;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LifecycleContainer {
        public final Lifecycle lifecycle;
        public final ArrayList observers = new ArrayList();

        public LifecycleContainer(Lifecycle lifecycle) {
            this.lifecycle = lifecycle;
        }
    }

    /* JADX INFO: renamed from: androidx.activity.result.ActivityResultRegistry$register$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends ActivityResultLauncher {
        public final /* synthetic */ ActivityResultContract $contract;
        public final /* synthetic */ String $key;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ ActivityResultRegistry this$0;

        public /* synthetic */ AnonymousClass2(ActivityResultRegistry activityResultRegistry, String str, ActivityResultContract activityResultContract, byte b) {
            this.$r8$classId = b;
            this.this$0 = activityResultRegistry;
            this.$key = str;
            this.$contract = activityResultContract;
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public final void launch(Object obj) {
            byte b = this.$r8$classId;
            ActivityResultContract activityResultContract = this.$contract;
            String str = this.$key;
            ActivityResultRegistry activityResultRegistry = this.this$0;
            switch (b) {
                case 0:
                    ArrayList arrayList = activityResultRegistry.launchedKeys;
                    Object obj2 = activityResultRegistry.keyToRc.get(str);
                    if (obj2 == null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m("Attempting to launch an unregistered ActivityResultLauncher with contract ", activityResultContract, " and input ", obj, ". You must ensure the ActivityResultLauncher is registered before calling launch().");
                        return;
                    }
                    int iIntValue = ((Number) obj2).intValue();
                    arrayList.add(str);
                    try {
                        activityResultRegistry.onLaunch(iIntValue, activityResultContract, obj);
                        return;
                    } catch (Exception e) {
                        arrayList.remove(str);
                        throw e;
                    }
                default:
                    ArrayList arrayList2 = activityResultRegistry.launchedKeys;
                    Object obj3 = activityResultRegistry.keyToRc.get(str);
                    if (obj3 == null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m("Attempting to launch an unregistered ActivityResultLauncher with contract ", activityResultContract, " and input ", obj, ". You must ensure the ActivityResultLauncher is registered before calling launch().");
                        return;
                    }
                    int iIntValue2 = ((Number) obj3).intValue();
                    arrayList2.add(str);
                    try {
                        activityResultRegistry.onLaunch(iIntValue2, activityResultContract, obj);
                        return;
                    } catch (Exception e2) {
                        arrayList2.remove(str);
                        throw e2;
                    }
            }
        }

        public void unregister() {
            this.this$0.unregister$activity(this.$key);
        }
    }

    public final boolean dispatchResult(int i, int i2, Intent intent) {
        String str = (String) this.rcToKey.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        CallbackAndContract callbackAndContract = (CallbackAndContract) this.keyToCallback.get(str);
        if ((callbackAndContract != null ? callbackAndContract.callback : null) != null) {
            ArrayList arrayList = this.launchedKeys;
            if (arrayList.contains(str)) {
                callbackAndContract.callback.onActivityResult(callbackAndContract.contract.parseResult(intent, i2));
                arrayList.remove(str);
                return true;
            }
        }
        this.parsedPendingResults.remove(str);
        this.pendingResults.putParcelable(str, new ActivityResult(intent, i2));
        return true;
    }

    public abstract void onLaunch(int i, ActivityResultContract activityResultContract, Object obj);

    public final AnonymousClass2 register(String str, LifecycleOwner lifecycleOwner, ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        str.getClass();
        activityResultContract.getClass();
        activityResultCallback.getClass();
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (((LifecycleRegistry) lifecycle).state.compareTo(Lifecycle.State.STARTED) >= 0) {
            StringBuilder sb = new StringBuilder("LifecycleOwner ");
            sb.append(lifecycleOwner);
            Lifecycle.State state = ((LifecycleRegistry) lifecycle).state;
            sb.append(" is attempting to register while current state is ");
            sb.append(state);
            sb.append(". LifecycleOwners must call register before they are STARTED.");
            throw new IllegalStateException(sb.toString().toString());
        }
        registerKey(str);
        LinkedHashMap linkedHashMap = this.keyToLifecycleContainers;
        LifecycleContainer lifecycleContainer = (LifecycleContainer) linkedHashMap.get(str);
        if (lifecycleContainer == null) {
            lifecycleContainer = new LifecycleContainer(lifecycle);
        }
        ActivityResultRegistry$$ExternalSyntheticLambda1 activityResultRegistry$$ExternalSyntheticLambda1 = new ActivityResultRegistry$$ExternalSyntheticLambda1(this, str, activityResultCallback, activityResultContract, (byte) 0);
        lifecycleContainer.lifecycle.addObserver(activityResultRegistry$$ExternalSyntheticLambda1);
        lifecycleContainer.observers.add(activityResultRegistry$$ExternalSyntheticLambda1);
        linkedHashMap.put(str, lifecycleContainer);
        return new AnonymousClass2(this, str, activityResultContract, (byte) 0);
    }

    public final void registerKey(String str) {
        LinkedHashMap linkedHashMap = this.keyToRc;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        ScrollKt$$ExternalSyntheticLambda0 scrollKt$$ExternalSyntheticLambda0 = new ScrollKt$$ExternalSyntheticLambda0((byte) 5);
        for (Number number : (ConstrainedOnceSequence) SequencesKt.constrainOnce(new GeneratorSequence(scrollKt$$ExternalSyntheticLambda0, new PingPongKt$$ExternalSyntheticLambda0((byte) 6, (Object) scrollKt$$ExternalSyntheticLambda0)))) {
            Integer numValueOf = Integer.valueOf(number.intValue());
            LinkedHashMap linkedHashMap2 = this.rcToKey;
            if (!linkedHashMap2.containsKey(numValueOf)) {
                int iIntValue = number.intValue();
                linkedHashMap2.put(Integer.valueOf(iIntValue), str);
                linkedHashMap.put(str, Integer.valueOf(iIntValue));
                return;
            }
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1("Sequence contains no element matching the predicate.");
    }

    public final void unregister$activity(String str) {
        Integer num;
        str.getClass();
        if (!this.launchedKeys.contains(str) && (num = (Integer) this.keyToRc.remove(str)) != null) {
            this.rcToKey.remove(num);
        }
        this.keyToCallback.remove(str);
        LinkedHashMap linkedHashMap = this.parsedPendingResults;
        if (linkedHashMap.containsKey(str)) {
            StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Dropping pending result for request ", str, ": ");
            sbM4m.append(linkedHashMap.get(str));
            Log.w("ActivityResultRegistry", sbM4m.toString());
            linkedHashMap.remove(str);
        }
        Bundle bundle = this.pendingResults;
        if (bundle.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + ((ActivityResult) LifecyclesKt.getParcelable(bundle, str, ActivityResult.class)));
            bundle.remove(str);
        }
        LinkedHashMap linkedHashMap2 = this.keyToLifecycleContainers;
        LifecycleContainer lifecycleContainer = (LifecycleContainer) linkedHashMap2.get(str);
        if (lifecycleContainer != null) {
            ArrayList arrayList = lifecycleContainer.observers;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                lifecycleContainer.lifecycle.removeObserver((LifecycleEventObserver) obj);
            }
            arrayList.clear();
            linkedHashMap2.remove(str);
        }
    }

    public final AnonymousClass2 register(String str, ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        str.getClass();
        registerKey(str);
        this.keyToCallback.put(str, new CallbackAndContract(activityResultContract, activityResultCallback));
        LinkedHashMap linkedHashMap = this.parsedPendingResults;
        if (linkedHashMap.containsKey(str)) {
            Object obj = linkedHashMap.get(str);
            linkedHashMap.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        Bundle bundle = this.pendingResults;
        ActivityResult activityResult = (ActivityResult) LifecyclesKt.getParcelable(bundle, str, ActivityResult.class);
        if (activityResult != null) {
            bundle.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.data, activityResult.resultCode));
        }
        return new AnonymousClass2(this, str, activityResultContract, (byte) 1);
    }
}
