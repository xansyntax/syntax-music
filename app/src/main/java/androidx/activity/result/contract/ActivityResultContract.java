package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import coil3.Extras;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultContract {
    public abstract Intent createIntent(Context context, Object obj);

    public Extras.Key getSynchronousResult(Context context, Object obj) {
        return null;
    }

    public abstract Object parseResult(Intent intent, int i);
}
