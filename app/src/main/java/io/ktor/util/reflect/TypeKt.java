package io.ktor.util.reflect;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.modules.SerializersModuleKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0002\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004*\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001a\u0010\t\u001a\u0004\u0018\u00010\b\"\u0006\b\u0000\u0010\u0000\u0018\u0001H\u0081\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"T", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "()Lio/ktor/util/reflect/TypeInfo;", "Lkotlinx/serialization/KSerializer;", "", "serializer", "(Lio/ktor/util/reflect/TypeInfo;)Lkotlinx/serialization/KSerializer;", "Lkotlin/reflect/KType;", "typeOfOrNull", "()Lkotlin/reflect/KType;", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TypeKt {
    public static final KSerializer serializer(TypeInfo typeInfo) {
        typeInfo.getClass();
        KType kotlinType = typeInfo.getKotlinType();
        KSerializer kSerializerSerializer = kotlinType != null ? CharsKt.serializer(SerializersModuleKt.EmptySerializersModule, kotlinType) : CharsKt.serializer(typeInfo.getType());
        return typeInfo.getIsNullable() ? HexFormatKt.getNullable(kSerializerSerializer) : kSerializerSerializer;
    }

    public static final <T> TypeInfo typeInfo() {
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    public static final <T> KType typeOfOrNull() {
        try {
            Intrinsics.throwUndefinedForReified();
            throw null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
