package coil3.network;

import android.util.Log;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import androidx.media3.extractor.ChunkIndex;
import androidx.room.migration.Migration;
import coil3.util.UtilsKt;
import io.ktor.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NetworkHeaders {
    public static final NetworkHeaders EMPTY = new NetworkHeaders(MapsKt__MapsKt.toMap(new LinkedHashMap()));
    public final Map data;

    public NetworkHeaders(Map map) {
        this.data = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NetworkHeaders) && this.data.equals(((NetworkHeaders) obj).data);
    }

    public final String get() {
        String lowerCase = HttpHeaders.ContentType.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        List list = (List) this.data.get(lowerCase);
        if (list != null) {
            return (String) CollectionsKt.lastOrNull(list);
        }
        return null;
    }

    public final int hashCode() {
        return this.data.hashCode();
    }

    public final String toString() {
        return "NetworkHeaders(data=" + this.data + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public final LinkedHashMap data;

        public Builder(byte b) {
            switch (b) {
                case 2:
                    this.data = new LinkedHashMap();
                    break;
                case 3:
                    this.data = new LinkedHashMap();
                    break;
                case 4:
                    this.data = new LinkedHashMap();
                    break;
                default:
                    this.data = new LinkedHashMap(0, 0.75f, true);
                    break;
            }
        }

        public void add(ChunkIndex chunkIndex) {
            long[] jArr = chunkIndex.timesUs;
            if (jArr.length > 0) {
                Long lValueOf = Long.valueOf(jArr[0]);
                LinkedHashMap linkedHashMap = this.data;
                if (linkedHashMap.containsKey(lValueOf)) {
                    return;
                }
                linkedHashMap.put(Long.valueOf(chunkIndex.timesUs[0]), chunkIndex);
            }
        }

        public void addInitializer(ClassReference classReference, Function1 function1) {
            function1.getClass();
            LinkedHashMap linkedHashMap = this.data;
            if (linkedHashMap.containsKey(classReference)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("A `initializer` with the same `clazz` has already been added: ", classReference.getQualifiedName(), "."));
            } else {
                linkedHashMap.put(classReference, new ViewModelInitializer(classReference, function1));
            }
        }

        public void addMigration(Migration migration) {
            migration.getClass();
            byte b = migration.startVersion;
            byte b2 = migration.endVersion;
            Integer numValueOf = Integer.valueOf(b);
            LinkedHashMap linkedHashMap = this.data;
            Object treeMap = linkedHashMap.get(numValueOf);
            if (treeMap == null) {
                treeMap = new TreeMap();
                linkedHashMap.put(numValueOf, treeMap);
            }
            TreeMap treeMap2 = (TreeMap) treeMap;
            if (treeMap2.containsKey(Integer.valueOf(b2))) {
                Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(b2)) + " with " + migration);
            }
            treeMap2.put(Integer.valueOf(b2), migration);
        }

        public InitializerViewModelFactory build() {
            Collection collectionValues = this.data.values();
            collectionValues.getClass();
            ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) collectionValues.toArray(new ViewModelInitializer[0]);
            return new InitializerViewModelFactory((byte) 0, (ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
        }

        public ChunkIndex merge() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (ChunkIndex chunkIndex : this.data.values()) {
                arrayList.add(chunkIndex.sizes);
                arrayList2.add(chunkIndex.offsets);
                arrayList3.add(chunkIndex.durationsUs);
                arrayList4.add(chunkIndex.timesUs);
            }
            int[][] iArr = (int[][]) arrayList.toArray(new int[arrayList.size()][]);
            long length = 0;
            for (int[] iArr2 : iArr) {
                length += (long) iArr2.length;
            }
            int i = (int) length;
            UtilsKt.checkArgument(length, "the total number of elements (%s) in the arrays must fit in an int", length == ((long) i));
            int[] iArr3 = new int[i];
            int length2 = 0;
            for (int[] iArr4 : iArr) {
                System.arraycopy(iArr4, 0, iArr3, length2, iArr4.length);
                length2 += iArr4.length;
            }
            return new ChunkIndex(iArr3, Okio__OkioKt.concat((long[][]) arrayList2.toArray(new long[arrayList2.size()][])), Okio__OkioKt.concat((long[][]) arrayList3.toArray(new long[arrayList3.size()][])), Okio__OkioKt.concat((long[][]) arrayList4.toArray(new long[arrayList4.size()][])));
        }

        public void set(String str) {
            String lowerCase = HttpHeaders.CacheControl.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            this.data.put(lowerCase, CollectionsKt__IterablesKt.mutableListOf(str));
        }

        public Builder(NetworkHeaders networkHeaders) {
            Map map = networkHeaders.data;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), CollectionsKt.toMutableList((Collection) entry.getValue()));
            }
            this.data = linkedHashMap;
        }
    }
}
