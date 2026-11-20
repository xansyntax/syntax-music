package io.ktor.util.reflect;

import io.ktor.http.LinkHeader;
import java.lang.reflect.Type;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B)\b\u0007\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB!\b\u0016\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\nB-\b\u0017\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\n\u0010\r\u001a\u00060\u000bj\u0002`\f\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\u000fH\u0096\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u00020\u0015H\u0096\u0080\u0004¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u0005\u0010\u001cR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lio/ktor/util/reflect/TypeInfo;", "", "Lkotlin/reflect/KClass;", LinkHeader.Parameters.Type, "", "isNullable", "Lkotlin/reflect/KType;", "kotlinType", "<init>", "(Lkotlin/reflect/KClass;ZLkotlin/reflect/KType;)V", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KType;)V", "Ljava/lang/reflect/Type;", "Lio/ktor/util/reflect/Type;", "reifiedType", "(Lkotlin/reflect/KClass;Ljava/lang/reflect/Type;Lkotlin/reflect/KType;)V", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "", "toString", "()Ljava/lang/String;", "Lkotlin/reflect/KClass;", "getType", "()Lkotlin/reflect/KClass;", "Z", "()Z", "Lkotlin/reflect/KType;", "getKotlinType", "()Lkotlin/reflect/KType;", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TypeInfo {
    private final boolean isNullable;
    private final KType kotlinType;
    private final KClass<?> type;

    public TypeInfo(KClass<?> kClass, boolean z, KType kType) {
        kClass.getClass();
        this.type = kClass;
        this.isNullable = z;
        this.kotlinType = kType;
        if (z || kType == null || !kType.isMarkedNullable()) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m("TypeInfo for nullable kotlinType ", kType, " must have isNullable set to true");
        throw null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TypeInfo)) {
            return false;
        }
        TypeInfo typeInfo = (TypeInfo) other;
        if (this.isNullable != typeInfo.isNullable) {
            return false;
        }
        KType kType = this.kotlinType;
        return (kType == null && typeInfo.kotlinType == null) ? Intrinsics.areEqual(this.type, typeInfo.type) : Intrinsics.areEqual(kType, typeInfo.kotlinType);
    }

    public final KType getKotlinType() {
        return this.kotlinType;
    }

    public final KClass<?> getType() {
        return this.type;
    }

    public int hashCode() {
        KType kType = this.kotlinType;
        return Boolean.hashCode(this.isNullable) + ((kType != null ? kType.hashCode() : this.type.hashCode()) * 31);
    }

    /* JADX INFO: renamed from: isNullable, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TypeInfo(");
        Object obj = this.kotlinType;
        if (obj == null) {
            obj = this.type;
        }
        sb.append(obj);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ TypeInfo(KClass kClass, boolean z, KType kType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((KClass<?>) kClass, z, (i & 4) != 0 ? null : kType);
    }

    public /* synthetic */ TypeInfo(KClass kClass, KType kType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, (i & 2) != 0 ? null : kType);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TypeInfo(KClass<?> kClass, KType kType) {
        kClass.getClass();
        boolean z = false;
        if (kType != null && kType.isMarkedNullable()) {
            z = true;
        }
        this(kClass, z, kType);
    }

    public /* synthetic */ TypeInfo(KClass kClass, Type type, KType kType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((KClass<?>) kClass, type, (i & 4) != 0 ? null : kType);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public TypeInfo(KClass<?> kClass, Type type, KType kType) {
        this(kClass, kType);
        kClass.getClass();
        type.getClass();
    }
}
