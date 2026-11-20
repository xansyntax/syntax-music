package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface SaveableStateHolder {
    void SaveableStateProvider(Object obj, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i);

    void removeState(Object obj);
}
