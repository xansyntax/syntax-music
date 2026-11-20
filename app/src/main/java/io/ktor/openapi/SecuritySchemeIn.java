package io.ktor.openapi;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/SecuritySchemeIn;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "QUERY", "HEADER", "COOKIE", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public enum SecuritySchemeIn {
    QUERY,
    HEADER,
    COOKIE;

    private static final /* synthetic */ EnumEntries $ENTRIES = CollectionsKt__IterablesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy $cachedSerializer$delegate = ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Xml$$ExternalSyntheticLambda0(24));

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("io.ktor.openapi.SecuritySchemeIn", values(), new String[]{"query", "header", "cookie"}, new Annotation[][]{null, null, null});
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/SecuritySchemeIn$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/SecuritySchemeIn;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) SecuritySchemeIn.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }
}
