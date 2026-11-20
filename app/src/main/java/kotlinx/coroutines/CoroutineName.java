package kotlinx.coroutines;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import kotlin.coroutines.AbstractCoroutineContextElement;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class CoroutineName extends AbstractCoroutineContextElement {
    public static final Job.Key Key = new Job.Key();
    public final String name;

    public CoroutineName(String str) {
        super(Key);
        this.name = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CoroutineName) && this.name.equals(((CoroutineName) obj).name);
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final String toString() {
        return Format$$ExternalSyntheticOutline0.m(new StringBuilder("CoroutineName("), this.name, ')');
    }
}
