package io.ktor.openapi;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\" \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "Lio/ktor/openapi/GenericElementSerialAdapter;", "genericElementSerialAdapters", "Ljava/util/List;", "getGenericElementSerialAdapters", "()Ljava/util/List;", "ktor-openapi-schema"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class GenericElement_jvmKt {
    private static final List<GenericElementSerialAdapter> genericElementSerialAdapters = CollectionsKt__IterablesKt.listOf((Object[]) new GenericElementSerialAdapter[]{GenericElementEncodingAdapter.INSTANCE, JsonElementSerialAdapter.INSTANCE, YamlNodeSerialAdapter.INSTANCE});

    public static final List<GenericElementSerialAdapter> getGenericElementSerialAdapters() {
        return genericElementSerialAdapters;
    }
}
