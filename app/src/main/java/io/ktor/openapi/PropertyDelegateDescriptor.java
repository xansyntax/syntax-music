package io.ktor.openapi;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ4\u0010\u000e\u001a\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u00020\u0013HÖ\u0081\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u000bR#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\r¨\u0006\u001c"}, d2 = {"Lio/ktor/openapi/PropertyDelegateDescriptor;", "", "Lkotlinx/serialization/KSerializer;", "serializer", "Lkotlin/Function1;", "", "", "keyMatcher", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function1;)V", "component1", "()Lkotlinx/serialization/KSerializer;", "component2", "()Lkotlin/jvm/functions/Function1;", "copy", "(Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function1;)Lio/ktor/openapi/PropertyDelegateDescriptor;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Lkotlinx/serialization/KSerializer;", "getSerializer", "Lkotlin/jvm/functions/Function1;", "getKeyMatcher", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PropertyDelegateDescriptor {
    private final Function1 keyMatcher;
    private final KSerializer serializer;

    public PropertyDelegateDescriptor(KSerializer kSerializer, Function1 function1) {
        kSerializer.getClass();
        function1.getClass();
        this.serializer = kSerializer;
        this.keyMatcher = function1;
    }

    public static /* synthetic */ PropertyDelegateDescriptor copy$default(PropertyDelegateDescriptor propertyDelegateDescriptor, KSerializer kSerializer, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            kSerializer = propertyDelegateDescriptor.serializer;
        }
        if ((i & 2) != 0) {
            function1 = propertyDelegateDescriptor.keyMatcher;
        }
        return propertyDelegateDescriptor.copy(kSerializer, function1);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final KSerializer getSerializer() {
        return this.serializer;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Function1 getKeyMatcher() {
        return this.keyMatcher;
    }

    public final PropertyDelegateDescriptor copy(KSerializer serializer, Function1 keyMatcher) {
        serializer.getClass();
        keyMatcher.getClass();
        return new PropertyDelegateDescriptor(serializer, keyMatcher);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PropertyDelegateDescriptor)) {
            return false;
        }
        PropertyDelegateDescriptor propertyDelegateDescriptor = (PropertyDelegateDescriptor) other;
        return Intrinsics.areEqual(this.serializer, propertyDelegateDescriptor.serializer) && Intrinsics.areEqual(this.keyMatcher, propertyDelegateDescriptor.keyMatcher);
    }

    public final Function1 getKeyMatcher() {
        return this.keyMatcher;
    }

    public final KSerializer getSerializer() {
        return this.serializer;
    }

    public int hashCode() {
        return this.keyMatcher.hashCode() + (this.serializer.hashCode() * 31);
    }

    public String toString() {
        return "PropertyDelegateDescriptor(serializer=" + this.serializer + ", keyMatcher=" + this.keyMatcher + ')';
    }
}
