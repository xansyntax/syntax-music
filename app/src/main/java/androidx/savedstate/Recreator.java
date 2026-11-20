package androidx.savedstate;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandlesProvider;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Recreator implements LifecycleEventObserver {
    public final /* synthetic */ byte $r8$classId;
    public final Object owner;

    public /* synthetic */ Recreator(byte b, Object obj) {
        this.$r8$classId = b;
        this.owner = obj;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        byte b = this.$r8$classId;
        Object obj = this.owner;
        switch (b) {
            case 0:
                SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) obj;
                if (event != Lifecycle.Event.ON_CREATE) {
                    throw new AssertionError("Next event must be ON_CREATE");
                }
                lifecycleOwner.getLifecycle().removeObserver(this);
                Bundle bundleConsumeRestoredStateForKey = savedStateRegistryOwner.getSavedStateRegistry().consumeRestoredStateForKey("androidx.savedstate.Restarter");
                if (bundleConsumeRestoredStateForKey == null) {
                    return;
                }
                ArrayList<String> stringArrayList = bundleConsumeRestoredStateForKey.getStringArrayList("classes_to_restore");
                if (stringArrayList == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
                    return;
                }
                int size = stringArrayList.size();
                int i = 0;
                while (i < size) {
                    String str = stringArrayList.get(i);
                    i++;
                    String str2 = str;
                    try {
                        Class<? extends U> clsAsSubclass = Class.forName(str2, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
                        clsAsSubclass.getClass();
                        try {
                            Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                            declaredConstructor.setAccessible(true);
                            try {
                                Object objNewInstance = declaredConstructor.newInstance(null);
                                objNewInstance.getClass();
                                if (!(savedStateRegistryOwner instanceof ViewModelStoreOwner)) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$2(savedStateRegistryOwner, "Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner. Received owner: ");
                                    return;
                                }
                                ViewModelStore viewModelStore = ((ViewModelStoreOwner) savedStateRegistryOwner).getViewModelStore();
                                SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
                                LinkedHashMap linkedHashMap = viewModelStore.map;
                                LinkedHashMap linkedHashMap2 = viewModelStore.map;
                                Iterator it = CollectionsKt.toSet(linkedHashMap.keySet()).iterator();
                                while (it.hasNext()) {
                                    ViewModel viewModel = (ViewModel) linkedHashMap2.get(it.next());
                                    if (viewModel != null) {
                                        ViewModelKt.attachHandleIfNeeded(viewModel, savedStateRegistry, savedStateRegistryOwner.getLifecycle());
                                    }
                                }
                                if (!CollectionsKt.toSet(linkedHashMap2.keySet()).isEmpty()) {
                                    savedStateRegistry.runOnNextRecreation();
                                }
                            } catch (Exception e) {
                                PathKt$$ExternalSyntheticBUOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m("Failed to instantiate ", str2), (Throwable) e);
                                return;
                            }
                        } catch (NoSuchMethodException e2) {
                            throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
                        }
                    } catch (ClassNotFoundException e3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("Class ", str2, " wasn't found"), (Throwable) e3);
                        return;
                    }
                }
                return;
            case 1:
                ComponentActivity componentActivity = (ComponentActivity) obj;
                ComponentActivity.access$ensureViewModelStore(componentActivity);
                componentActivity.getLifecycle().removeObserver(this);
                return;
            case 2:
                new HashMap();
                GeneratedAdapter[] generatedAdapterArr = (GeneratedAdapter[]) obj;
                if (generatedAdapterArr.length > 0) {
                    GeneratedAdapter generatedAdapter = generatedAdapterArr[0];
                    throw null;
                }
                if (generatedAdapterArr.length <= 0) {
                    return;
                }
                GeneratedAdapter generatedAdapter2 = generatedAdapterArr[0];
                throw null;
            default:
                if (event != Lifecycle.Event.ON_CREATE) {
                    PathKt$$ExternalSyntheticBUOutline0.m$2(event, "Next event must be ON_CREATE, it was ");
                    return;
                } else {
                    lifecycleOwner.getLifecycle().removeObserver(this);
                    ((SavedStateHandlesProvider) obj).performRestore();
                    return;
                }
        }
    }
}
