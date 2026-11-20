package androidx.compose.runtime;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface Applier {
    default void apply(Object obj, Function2 function2) {
        function2.invoke(getCurrent(), obj);
    }

    void down(Object obj);

    Object getCurrent();

    void insertBottomUp(int i, Object obj);

    void insertTopDown(int i, Object obj);

    void move(int i, int i2, int i3);

    void remove(int i, int i2);

    void reuse();

    void up();

    default void onEndChanges() {
    }
}
