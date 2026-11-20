package io.ktor.http.content;

import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\",\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lio/ktor/util/AttributeKey;", "Lio/ktor/http/content/CachingOptions;", "CachingProperty", "Lio/ktor/util/AttributeKey;", "getCachingProperty", "()Lio/ktor/util/AttributeKey;", "Lio/ktor/http/content/OutgoingContent;", "value", "getCaching", "(Lio/ktor/http/content/OutgoingContent;)Lio/ktor/http/content/CachingOptions;", "setCaching", "(Lio/ktor/http/content/OutgoingContent;Lio/ktor/http/content/CachingOptions;)V", "caching", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CachingOptionsKt {
    private static final AttributeKey<CachingOptions> CachingProperty;

    static {
        TypeReference typeReferenceTypeOf;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(CachingOptions.class);
        try {
            typeReferenceTypeOf = Reflection.typeOf(CachingOptions.class);
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        CachingProperty = new AttributeKey<>("Caching", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
    }

    public static final CachingOptions getCaching(OutgoingContent outgoingContent) {
        outgoingContent.getClass();
        return (CachingOptions) outgoingContent.getProperty(CachingProperty);
    }

    public static final AttributeKey<CachingOptions> getCachingProperty() {
        return CachingProperty;
    }

    public static final void setCaching(OutgoingContent outgoingContent, CachingOptions cachingOptions) {
        outgoingContent.getClass();
        outgoingContent.setProperty(CachingProperty, cachingOptions);
    }
}
