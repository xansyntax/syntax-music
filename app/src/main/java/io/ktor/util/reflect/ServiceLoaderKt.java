package io.ktor.util.reflect;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\b\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "T", "Lkotlin/sequences/Sequence;", "loadServicesAsSequence", "()Lkotlin/sequences/Sequence;", "", "loadServices", "()Ljava/util/List;", "loadServiceOrNull", "()Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ServiceLoaderKt {
    @Deprecated
    public static final <T> T loadServiceOrNull() {
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    public static final <T> List<T> loadServices() {
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    public static final <T> Sequence loadServicesAsSequence() {
        Intrinsics.throwUndefinedForReified();
        throw null;
    }
}
