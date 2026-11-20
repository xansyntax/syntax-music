package io.ktor.util.reflect;

import io.ktor.http.ContentType;
import io.ktor.http.LinkHeader;
import java.lang.reflect.Type;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\b\u001a\u00020\u00072\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001d\u0010\r\u001a\u00020\f*\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\r\u0010\u000e\"\u001b\u0010\u0002\u001a\u00020\u0000*\u00020\u00078F¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\"\"\u0010\u0017\u001a\u00060\u0000j\u0002`\u0001*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014*\u001a\b\u0007\u0010\u001b\"\u00020\u00002\u00020\u0000B\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a¨\u0006\u001c"}, d2 = {"Ljava/lang/reflect/Type;", "Lio/ktor/util/reflect/Type;", "reifiedType", "Lkotlin/reflect/KClass;", "kClass", "Lkotlin/reflect/KType;", "kType", "Lio/ktor/util/reflect/TypeInfo;", "typeInfoImpl", "(Ljava/lang/reflect/Type;Lkotlin/reflect/KClass;Lkotlin/reflect/KType;)Lio/ktor/util/reflect/TypeInfo;", "", LinkHeader.Parameters.Type, "", "instanceOf", "(Ljava/lang/Object;Lkotlin/reflect/KClass;)Z", "getReifiedType", "(Lio/ktor/util/reflect/TypeInfo;)Ljava/lang/reflect/Type;", "getReifiedType$annotations", "(Lio/ktor/util/reflect/TypeInfo;)V", "getPlatformType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "getPlatformType$annotations", "(Lkotlin/reflect/KType;)V", "platformType", "Lkotlin/Deprecated;", ContentType.Message.TYPE, "Not used anymore in common code as it was needed only for JVM target.", "Type", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TypeInfoJvmKt {
    public static final Type getPlatformType(KType kType) {
        kType.getClass();
        return TypesJVMKt.getJavaType(kType);
    }

    public static final Type getReifiedType(TypeInfo typeInfo) {
        Type javaType;
        typeInfo.getClass();
        KType kotlinType = typeInfo.getKotlinType();
        return (kotlinType == null || (javaType = TypesJVMKt.getJavaType(kotlinType)) == null) ? Okio__OkioKt.getJavaClass(typeInfo.getType()) : javaType;
    }

    public static final boolean instanceOf(Object obj, KClass<?> kClass) {
        obj.getClass();
        kClass.getClass();
        return Okio__OkioKt.getJavaClass(kClass).isInstance(obj);
    }

    @Deprecated
    public static final TypeInfo typeInfoImpl(Type type, KClass<?> kClass, KType kType) {
        type.getClass();
        kClass.getClass();
        return new TypeInfo(kClass, kType);
    }

    @Deprecated
    public static /* synthetic */ void Type$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getPlatformType$annotations(KType kType) {
    }

    public static /* synthetic */ void getReifiedType$annotations(TypeInfo typeInfo) {
    }
}
