package io.ktor.client.engine;

import io.ktor.client.plugins.HttpTimeoutCapability;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ReflectionFactory;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\"0\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"!\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/util/AttributeKey;", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "", "ENGINE_CAPABILITIES_KEY", "Lio/ktor/util/AttributeKey;", "getENGINE_CAPABILITIES_KEY", "()Lio/ktor/util/AttributeKey;", "", "DEFAULT_CAPABILITIES", "Ljava/util/Set;", "getDEFAULT_CAPABILITIES", "()Ljava/util/Set;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpClientEngineCapabilityKt {
    private static final Set<HttpClientEngineCapability<?>> DEFAULT_CAPABILITIES;
    private static final AttributeKey<Map<HttpClientEngineCapability<?>, Object>> ENGINE_CAPABILITIES_KEY;

    static {
        TypeReference typeReference;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Map.class);
        try {
            KTypeProjection.Companion companion = KTypeProjection.INSTANCE;
            KTypeProjection kTypeProjectionInvariant = companion.invariant(Reflection.typeOf(HttpClientEngineCapability.class, companion.getSTAR()));
            KTypeProjection kTypeProjectionInvariant2 = companion.invariant(Reflection.typeOf(Object.class));
            ReflectionFactory reflectionFactory = Reflection.factory;
            ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Map.class);
            List listAsList = Arrays.asList(kTypeProjectionInvariant, kTypeProjectionInvariant2);
            reflectionFactory.getClass();
            listAsList.getClass();
            reflectionFactory.getClass();
            typeReference = new TypeReference(orCreateKotlinClass2, listAsList, 2);
        } catch (Throwable unused) {
            typeReference = null;
        }
        ENGINE_CAPABILITIES_KEY = new AttributeKey<>("EngineCapabilities", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReference));
        DEFAULT_CAPABILITIES = CharsKt.setOf(HttpTimeoutCapability.INSTANCE);
    }

    public static final Set<HttpClientEngineCapability<?>> getDEFAULT_CAPABILITIES() {
        return DEFAULT_CAPABILITIES;
    }

    public static final AttributeKey<Map<HttpClientEngineCapability<?>, Object>> getENGINE_CAPABILITIES_KEY() {
        return ENGINE_CAPABILITIES_KEY;
    }
}
