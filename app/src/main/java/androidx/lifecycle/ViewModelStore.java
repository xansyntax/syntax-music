package androidx.lifecycle;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelStore {
    public final LinkedHashMap map = new LinkedHashMap();

    public final void clear() {
        LinkedHashMap linkedHashMap = this.map;
        Map map = MapsKt__MapsKt.toMap(linkedHashMap);
        linkedHashMap.clear();
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((ViewModel) it.next()).clear$lifecycle_viewmodel();
        }
    }

    public final String toString() {
        String simpleName = Reflection.getOrCreateKotlinClass(ViewModelStore.class).getSimpleName();
        if (simpleName == null) {
            simpleName = "ViewModelStore";
        }
        int iHashCode = hashCode();
        CharsKt.checkRadix(16);
        String string = Integer.toString(iHashCode, 16);
        string.getClass();
        return simpleName + "@" + string + "(keys=" + CollectionsKt.toSet(this.map.keySet()) + ")";
    }
}
