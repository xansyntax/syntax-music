package androidx.media3.datasource.cache;

import android.util.SparseArray;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface CachedContentIndex$Storage {
    void delete();

    boolean exists();

    void initialize(long j);

    void load(HashMap map, SparseArray sparseArray);

    void onRemove(CachedContent cachedContent, boolean z);

    void onUpdate(CachedContent cachedContent);

    void storeFully(HashMap map);

    void storeIncremental(HashMap map);
}
