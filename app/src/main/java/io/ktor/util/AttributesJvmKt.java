package io.ktor.util;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "concurrent", "Lio/ktor/util/Attributes;", "Attributes", "(Z)Lio/ktor/util/Attributes;", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AttributesJvmKt {
    public static final Attributes Attributes(boolean z) {
        return z ? new ConcurrentSafeAttributes() : new HashMapAttributes();
    }

    public static /* synthetic */ Attributes Attributes$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return Attributes(z);
    }
}
