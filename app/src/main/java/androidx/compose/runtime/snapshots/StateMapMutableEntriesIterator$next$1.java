package androidx.compose.runtime.snapshots;

import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import java.util.Map;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StateMapMutableEntriesIterator$next$1 implements Map.Entry, KMutableMap.Entry {
    public final Object key;
    public final /* synthetic */ StateMapMutableKeysIterator this$0;
    public Object value;

    public StateMapMutableEntriesIterator$next$1(StateMapMutableKeysIterator stateMapMutableKeysIterator) {
        this.this$0 = stateMapMutableKeysIterator;
        Map.Entry entry = (Map.Entry) stateMapMutableKeysIterator.peekedString;
        entry.getClass();
        this.key = entry.getKey();
        Map.Entry entry2 = (Map.Entry) stateMapMutableKeysIterator.peekedString;
        entry2.getClass();
        this.value = entry2.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        StateMapMutableKeysIterator stateMapMutableKeysIterator = this.this$0;
        SnapshotStateMap snapshotStateMap = (SnapshotStateMap) stateMapMutableKeysIterator.configuration;
        if (snapshotStateMap.getReadable$runtime().modification != stateMapMutableKeysIterator.currentPosition) {
            MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
            return null;
        }
        Object obj2 = this.value;
        snapshotStateMap.put(this.key, obj);
        this.value = obj;
        return obj2;
    }
}
