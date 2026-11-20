package io.ktor.util;

import java.util.Collections;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\u001a#\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"T", "", "unmodifiable", "(Ljava/util/Set;)Ljava/util/Set;", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CollectionsJvmKt {
    public static final <T> Set<T> unmodifiable(Set<? extends T> set) {
        set.getClass();
        Set<T> setUnmodifiableSet = Collections.unmodifiableSet(set);
        setUnmodifiableSet.getClass();
        return setUnmodifiableSet;
    }
}
