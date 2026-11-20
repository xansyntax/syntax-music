package io.ktor.client.plugins.contentnegotiation;

import java.io.InputStream;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\"$\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "Lkotlin/reflect/KClass;", "DefaultIgnoredTypes", "Ljava/util/Set;", "getDefaultIgnoredTypes", "()Ljava/util/Set;", "ktor-client-content-negotiation"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DefaultIgnoredTypesJvmKt {
    private static final Set<KClass<?>> DefaultIgnoredTypes;

    static {
        KClass[] kClassArr = {Reflection.getOrCreateKotlinClass(InputStream.class)};
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(1));
        linkedHashSet.add(kClassArr[0]);
        DefaultIgnoredTypes = linkedHashSet;
    }

    public static final Set<KClass<?>> getDefaultIgnoredTypes() {
        return DefaultIgnoredTypes;
    }
}
