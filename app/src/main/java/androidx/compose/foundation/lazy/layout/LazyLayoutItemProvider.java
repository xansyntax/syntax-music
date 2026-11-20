package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface LazyLayoutItemProvider {
    void Item(int i, Object obj, Composer composer, int i2);

    default Object getContentType(int i) {
        return null;
    }

    int getIndex(Object obj);

    int getItemCount();

    Object getKey(int i);
}
