package io.ktor.openapi;

import io.ktor.http.Cookie$$ExternalSyntheticLambda1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0087@\u0018\u0000 \u00142\u00020\u0001:\u0002\u0015\u0014B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u00020\fHÖ\u0081\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u000f\u0010\u0010R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0088\u0001\u0005\u0092\u0001\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¨\u0006\u0016"}, d2 = {"Lio/ktor/openapi/Callback;", "", "", "", "Lio/ktor/openapi/PathItem;", "value", "constructor-impl", "(Ljava/util/Map;)Ljava/util/Map;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/Map;", "getValue", "()Ljava/util/Map;", "Companion", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final class Callback {
    private final Map<String, PathItem> value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Cookie$$ExternalSyntheticLambda1(23))};

    private /* synthetic */ Callback(Map map) {
        this.value = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new HashMapSerializer(StringSerializer.INSTANCE, PathItem.Companion.Serializer.INSTANCE, (byte) 1);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Callback m1749boximpl(Map map) {
        return new Callback(map);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Map<String, ? extends PathItem> m1750constructorimpl(Map<String, PathItem> map) {
        map.getClass();
        return map;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1751equalsimpl(Map<String, ? extends PathItem> map, Object obj) {
        return (obj instanceof Callback) && Intrinsics.areEqual(map, ((Callback) obj).getValue());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1752equalsimpl0(Map<String, ? extends PathItem> map, Map<String, ? extends PathItem> map2) {
        return Intrinsics.areEqual(map, map2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1753hashCodeimpl(Map<String, ? extends PathItem> map) {
        return map.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1754toStringimpl(Map<String, ? extends PathItem> map) {
        return "Callback(value=" + map + ')';
    }

    public boolean equals(Object other) {
        return m1751equalsimpl(this.value, other);
    }

    public final Map<String, PathItem> getValue() {
        return this.value;
    }

    public int hashCode() {
        return m1753hashCodeimpl(this.value);
    }

    public String toString() {
        return m1754toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ Map getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/Callback$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/Callback;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return Callback$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }
}
