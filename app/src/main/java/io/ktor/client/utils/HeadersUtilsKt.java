package io.ktor.client.utils;

import io.ktor.http.Cookie$$ExternalSyntheticLambda1;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a-\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\" \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/http/HeadersBuilder;", "Lio/ktor/http/HttpMethod;", "method", "Lio/ktor/util/Attributes;", "attributes", "", "alwaysRemove", "", "dropCompressionHeaders", "(Lio/ktor/http/HeadersBuilder;Lio/ktor/http/HttpMethod;Lio/ktor/util/Attributes;Z)V", "Lio/ktor/util/AttributeKey;", "", "", "DecompressionListAttribute", "Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HeadersUtilsKt {
    private static final AttributeKey<List<String>> DecompressionListAttribute;

    static {
        TypeReference typeReference;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(List.class);
        try {
            TypeReference typeReferenceTypeOf = Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
            Reflection.factory.getClass();
            typeReference = new TypeReference(typeReferenceTypeOf.classifier, typeReferenceTypeOf.arguments, typeReferenceTypeOf.flags | 2);
        } catch (Throwable unused) {
            typeReference = null;
        }
        DecompressionListAttribute = new AttributeKey<>("DecompressionListAttribute", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReference));
    }

    public static final void dropCompressionHeaders(HeadersBuilder headersBuilder, HttpMethod httpMethod, Attributes attributes, boolean z) {
        headersBuilder.getClass();
        httpMethod.getClass();
        attributes.getClass();
        if (httpMethod.equals(HttpMethod.Head) || httpMethod.equals(HttpMethod.Options)) {
            return;
        }
        String str = headersBuilder.get(HttpHeaders.ContentEncoding);
        if (str != null) {
            ((List) attributes.computeIfAbsent(DecompressionListAttribute, new Cookie$$ExternalSyntheticLambda1((byte) 7))).add(str);
        } else if (!z) {
            return;
        }
        headersBuilder.remove(HttpHeaders.ContentEncoding);
        headersBuilder.remove(HttpHeaders.ContentLength);
    }

    public static /* synthetic */ void dropCompressionHeaders$default(HeadersBuilder headersBuilder, HttpMethod httpMethod, Attributes attributes, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        dropCompressionHeaders(headersBuilder, httpMethod, attributes, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List dropCompressionHeaders$lambda$0() {
        return new ArrayList();
    }
}
