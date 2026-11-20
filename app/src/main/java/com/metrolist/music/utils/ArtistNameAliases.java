package com.metrolist.music.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.room.RoomDatabase$createConnectionManager$2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.function.BiConsumer;
import kotlin.Pair;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistNameAliases {
    public static final ArtistNameAliases INSTANCE = new ArtistNameAliases();
    public static final StateFlowImpl _aliases;
    public static final ReadonlyStateFlow aliases;
    public static volatile SharedPreferences preferences;

    static {
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(EmptyMap.INSTANCE);
        _aliases = stateFlowImplMutableStateFlow;
        aliases = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
    }

    public static String resolve(String str, String str2, Map map) {
        String str3;
        map.getClass();
        str2.getClass();
        if ((str != null && (str3 = (String) map.get(str)) != null) || (str3 = (String) map.get("name:".concat(str2))) != null) {
            str2 = str3;
        }
        String str4 = (String) map.get("name:".concat(str2));
        if (str4 == null) {
            return str2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(1));
        linkedHashSet.add(new String[]{str2}[0]);
        do {
            String str5 = str2;
            str2 = str4;
            if (!linkedHashSet.add(str2)) {
                return str5;
            }
            str4 = (String) map.get("name:".concat(str2));
        } while (str4 != null);
        return str2;
    }

    public final void initialize(Context context) {
        if (preferences != null) {
            return;
        }
        synchronized (this) {
            try {
                if (preferences != null) {
                    return;
                }
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("artist_name_aliases", 0);
                StateFlowImpl stateFlowImpl = _aliases;
                Map<String, ?> all = sharedPreferences.getAll();
                all.getClass();
                ArrayList arrayList = new ArrayList();
                Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        Map map = MapsKt__MapsKt.toMap(arrayList);
                        stateFlowImpl.getClass();
                        stateFlowImpl.updateState(null, map);
                        preferences = sharedPreferences;
                        return;
                    }
                    Map.Entry<String, ?> next = it.next();
                    String key = next.getKey();
                    Object value = next.getValue();
                    String str = value instanceof String ? (String) value : null;
                    Pair pair = str != null ? new Pair(key, str) : null;
                    if (pair != null) {
                        arrayList.add(pair);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void restore(Context context, Map map) {
        SharedPreferences.Editor editorEdit;
        initialize(context);
        SharedPreferences sharedPreferences = preferences;
        if (sharedPreferences != null && (editorEdit = sharedPreferences.edit()) != null) {
            editorEdit.clear();
            final RoomDatabase$createConnectionManager$2 roomDatabase$createConnectionManager$2 = new RoomDatabase$createConnectionManager$2(2, editorEdit, SharedPreferences.Editor.class, "putString", "putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;", 0, (byte) 4);
            map.forEach(new BiConsumer() { // from class: com.metrolist.music.utils.ArtistNameAliases$$ExternalSyntheticLambda0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    roomDatabase$createConnectionManager$2.invoke(obj, obj2);
                }
            });
            editorEdit.commit();
        }
        StateFlowImpl stateFlowImpl = _aliases;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, map);
    }

    public static String resolve(String str, String str2) {
        str2.getClass();
        return resolve(str, str2, (Map) _aliases.getValue());
    }
}
