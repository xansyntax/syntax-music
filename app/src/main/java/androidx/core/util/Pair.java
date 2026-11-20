package androidx.core.util;

import io.ktor.sse.ServerSentEventKt;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Pair {
    public final Object first;
    public final Object second;

    public Pair(Object obj, Object obj2) {
        this.first = obj;
        this.second = obj2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return Objects.equals(pair.first, this.first) && Objects.equals(pair.second, this.second);
    }

    public final int hashCode() {
        Object obj = this.first;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.second;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "Pair{" + this.first + ServerSentEventKt.SPACE + this.second + "}";
    }
}
