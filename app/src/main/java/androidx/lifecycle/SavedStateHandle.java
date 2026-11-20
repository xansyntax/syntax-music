package androidx.lifecycle;

import androidx.lifecycle.internal.SavedStateHandleImpl_androidKt;
import coil3.ImageLoader$Builder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.collections.EmptyMap;
import kotlin.collections.builders.MapBuilder;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandle {
    public final ImageLoader$Builder impl;
    public final LinkedHashMap liveDatas;

    public SavedStateHandle() {
        this.liveDatas = new LinkedHashMap();
        this.impl = new ImageLoader$Builder(EmptyMap.INSTANCE);
    }

    public final Object get(String str) {
        Object value;
        ImageLoader$Builder imageLoader$Builder = this.impl;
        LinkedHashMap linkedHashMap = (LinkedHashMap) imageLoader$Builder.application;
        LinkedHashMap linkedHashMap2 = (LinkedHashMap) imageLoader$Builder.diskCacheLazy;
        try {
            MutableStateFlow mutableStateFlow = (MutableStateFlow) linkedHashMap2.get(str);
            if (mutableStateFlow != null && (value = ((StateFlowImpl) mutableStateFlow).getValue()) != null) {
                return value;
            }
            return linkedHashMap.get(str);
        } catch (ClassCastException unused) {
            linkedHashMap.remove(str);
            ((LinkedHashMap) imageLoader$Builder.memoryCacheLazy).remove(str);
            linkedHashMap2.remove(str);
            return null;
        }
    }

    public final ReadonlyStateFlow getStateFlow(Object obj, String str) {
        ImageLoader$Builder imageLoader$Builder = this.impl;
        LinkedHashMap linkedHashMap = (LinkedHashMap) imageLoader$Builder.diskCacheLazy;
        boolean zContainsKey = linkedHashMap.containsKey(str);
        LinkedHashMap linkedHashMap2 = (LinkedHashMap) imageLoader$Builder.application;
        if (zContainsKey) {
            Object objMutableStateFlow = linkedHashMap.get(str);
            if (objMutableStateFlow == null) {
                if (!linkedHashMap2.containsKey(str)) {
                    linkedHashMap2.put(str, obj);
                }
                objMutableStateFlow = StateFlowKt.MutableStateFlow(linkedHashMap2.get(str));
                linkedHashMap.put(str, objMutableStateFlow);
            }
            return StateFlowKt.asStateFlow((MutableStateFlow) objMutableStateFlow);
        }
        LinkedHashMap linkedHashMap3 = (LinkedHashMap) imageLoader$Builder.memoryCacheLazy;
        Object objMutableStateFlow2 = linkedHashMap3.get(str);
        if (objMutableStateFlow2 == null) {
            if (!linkedHashMap2.containsKey(str)) {
                linkedHashMap2.put(str, obj);
            }
            objMutableStateFlow2 = StateFlowKt.MutableStateFlow(linkedHashMap2.get(str));
            linkedHashMap3.put(str, objMutableStateFlow2);
        }
        return StateFlowKt.asStateFlow((MutableStateFlow) objMutableStateFlow2);
    }

    public final void set(Object obj, String str) {
        Object obj2;
        if (obj != null) {
            ArrayList arrayList = SavedStateHandleImpl_androidKt.ACCEPTABLE_CLASSES;
            if (arrayList == null || !arrayList.isEmpty()) {
                int size = arrayList.size();
                int i = 0;
                do {
                    if (i < size) {
                        obj2 = arrayList.get(i);
                        i++;
                    }
                } while (!((Class) obj2).isInstance(obj));
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m("Can't put value with type ", obj.getClass(), " into saved state");
            return;
        }
        ArrayList arrayList2 = SavedStateHandleImpl_androidKt.ACCEPTABLE_CLASSES;
        Object obj3 = this.liveDatas.get(str);
        MutableLiveData mutableLiveData = obj3 instanceof MutableLiveData ? (MutableLiveData) obj3 : null;
        if (mutableLiveData != null) {
            mutableLiveData.setValue(obj);
        }
        this.impl.set(obj, str);
    }

    public SavedStateHandle(MapBuilder mapBuilder) {
        this.liveDatas = new LinkedHashMap();
        this.impl = new ImageLoader$Builder(mapBuilder);
    }
}
