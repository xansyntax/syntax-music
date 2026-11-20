package androidx.activity;

import android.os.Bundle;
import androidx.compose.runtime.saveable.SaveableStateRegistryImpl;
import androidx.compose.ui.platform.ParcelableMapHolder;
import androidx.savedstate.SavedStateRegistry;
import coil3.ImageLoader$Builder;
import coil3.util.UtilsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda5 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda5(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        Pair[] pairArr;
        byte b = this.$r8$classId;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                return ComponentActivity._init_$lambda$3((ComponentActivity) obj);
            case 1:
                Map mapPerformSave = ((SaveableStateRegistryImpl) obj).performSave();
                Bundle bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                bundleBundleOf.putParcelable("androidx.compose.ui.platform.DisposableSaveableStateRegistry", new ParcelableMapHolder(mapPerformSave));
                return bundleBundleOf;
            default:
                ImageLoader$Builder imageLoader$Builder = (ImageLoader$Builder) obj;
                for (Map.Entry entry : MapsKt__MapsKt.toMap((LinkedHashMap) imageLoader$Builder.diskCacheLazy).entrySet()) {
                    imageLoader$Builder.set(((StateFlowImpl) ((MutableStateFlow) entry.getValue())).getValue(), (String) entry.getKey());
                }
                for (Map.Entry entry2 : MapsKt__MapsKt.toMap((LinkedHashMap) imageLoader$Builder.defaults).entrySet()) {
                    imageLoader$Builder.set(((SavedStateRegistry.SavedStateProvider) entry2.getValue()).saveState(), (String) entry2.getKey());
                }
                LinkedHashMap linkedHashMap = (LinkedHashMap) imageLoader$Builder.application;
                if (linkedHashMap.isEmpty()) {
                    pairArr = new Pair[0];
                } else {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                        arrayList.add(new Pair((String) entry3.getKey(), entry3.getValue()));
                    }
                    pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
                }
                return UtilsKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        }
    }
}
