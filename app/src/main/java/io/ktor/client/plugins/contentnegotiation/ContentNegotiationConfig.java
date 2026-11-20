package io.ktor.client.plugins.contentnegotiation;

import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypeMatcher;
import io.ktor.http.LinkHeader;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.ContentConverter;
import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@KtorDsl
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ=\u0010\u0010\u001a\u00020\u000e\"\b\b\u0000\u0010\n*\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00028\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011JC\u0010\u0010\u001a\u00020\u000e\"\b\b\u0000\u0010\n*\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00062\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u000e\"\u0006\b\u0000\u0010\n\u0018\u0001H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0003J\u0018\u0010\u0016\u001a\u00020\u000e\"\u0006\b\u0000\u0010\n\u0018\u0001H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0003J\u0019\u0010\u0016\u001a\u00020\u000e2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017¢\u0006\u0004\b\u0016\u0010\u0019J\u0019\u0010\u0015\u001a\u00020\u000e2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017¢\u0006\u0004\b\u0015\u0010\u0019J\r\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u0003R$\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u001b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR \u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00065"}, d2 = {"Lio/ktor/client/plugins/contentnegotiation/ContentNegotiationConfig;", "Lio/ktor/serialization/Configuration;", "<init>", "()V", "Lio/ktor/http/ContentType;", "pattern", "Lio/ktor/http/ContentTypeMatcher;", "defaultMatcher", "(Lio/ktor/http/ContentType;)Lio/ktor/http/ContentTypeMatcher;", "Lio/ktor/serialization/ContentConverter;", "T", "contentType", "converter", "Lkotlin/Function1;", "", "configuration", "register", "(Lio/ktor/http/ContentType;Lio/ktor/serialization/ContentConverter;Lkotlin/jvm/functions/Function1;)V", "contentTypeToSend", "contentTypeMatcher", "(Lio/ktor/http/ContentType;Lio/ktor/serialization/ContentConverter;Lio/ktor/http/ContentTypeMatcher;Lkotlin/jvm/functions/Function1;)V", "ignoreType", "removeIgnoredType", "Lkotlin/reflect/KClass;", LinkHeader.Parameters.Type, "(Lkotlin/reflect/KClass;)V", "clearIgnoredTypes", "", "ignoredTypes", "Ljava/util/Set;", "getIgnoredTypes$ktor_client_content_negotiation", "()Ljava/util/Set;", "", "Lio/ktor/client/plugins/contentnegotiation/ContentNegotiationConfig$ConverterRegistration;", "registrations", "Ljava/util/List;", "getRegistrations$ktor_client_content_negotiation", "()Ljava/util/List;", "", "defaultAcceptHeaderQValue", "Ljava/lang/Double;", "getDefaultAcceptHeaderQValue", "()Ljava/lang/Double;", "setDefaultAcceptHeaderQValue", "(Ljava/lang/Double;)V", "Lio/ktor/client/plugins/contentnegotiation/ContentTypeMergeStrategy;", "acceptHeaderMergeStrategy", "Lio/ktor/client/plugins/contentnegotiation/ContentTypeMergeStrategy;", "getAcceptHeaderMergeStrategy", "()Lio/ktor/client/plugins/contentnegotiation/ContentTypeMergeStrategy;", "setAcceptHeaderMergeStrategy", "(Lio/ktor/client/plugins/contentnegotiation/ContentTypeMergeStrategy;)V", "ConverterRegistration", "ktor-client-content-negotiation"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContentNegotiationConfig implements Configuration {
    private Double defaultAcceptHeaderQValue;
    private final Set<KClass<?>> ignoredTypes = CollectionsKt.toMutableSet(SetsKt.plus((Set) DefaultIgnoredTypesJvmKt.getDefaultIgnoredTypes(), (Iterable) ContentNegotiationKt.getDefaultCommonIgnoredTypes()));
    private final List<ConverterRegistration> registrations = new ArrayList();
    private ContentTypeMergeStrategy acceptHeaderMergeStrategy = ContentTypeMergeStrategy.INSTANCE.getDefault();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/client/plugins/contentnegotiation/ContentNegotiationConfig$ConverterRegistration;", "", "Lio/ktor/serialization/ContentConverter;", "converter", "Lio/ktor/http/ContentType;", "contentTypeToSend", "Lio/ktor/http/ContentTypeMatcher;", "contentTypeMatcher", "<init>", "(Lio/ktor/serialization/ContentConverter;Lio/ktor/http/ContentType;Lio/ktor/http/ContentTypeMatcher;)V", "Lio/ktor/serialization/ContentConverter;", "getConverter", "()Lio/ktor/serialization/ContentConverter;", "Lio/ktor/http/ContentType;", "getContentTypeToSend", "()Lio/ktor/http/ContentType;", "Lio/ktor/http/ContentTypeMatcher;", "getContentTypeMatcher", "()Lio/ktor/http/ContentTypeMatcher;", "ktor-client-content-negotiation"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ConverterRegistration {
        private final ContentTypeMatcher contentTypeMatcher;
        private final ContentType contentTypeToSend;
        private final ContentConverter converter;

        public ConverterRegistration(ContentConverter contentConverter, ContentType contentType, ContentTypeMatcher contentTypeMatcher) {
            contentConverter.getClass();
            contentType.getClass();
            contentTypeMatcher.getClass();
            this.converter = contentConverter;
            this.contentTypeToSend = contentType;
            this.contentTypeMatcher = contentTypeMatcher;
        }

        public final ContentTypeMatcher getContentTypeMatcher() {
            return this.contentTypeMatcher;
        }

        public final ContentType getContentTypeToSend() {
            return this.contentTypeToSend;
        }

        public final ContentConverter getConverter() {
            return this.converter;
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig$defaultMatcher$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"io/ktor/client/plugins/contentnegotiation/ContentNegotiationConfig$defaultMatcher$1", "Lio/ktor/http/ContentTypeMatcher;", "Lio/ktor/http/ContentType;", "contentType", "", "contains", "(Lio/ktor/http/ContentType;)Z", "", "subtypeSuffix$delegate", "Lkotlin/Lazy;", "getSubtypeSuffix", "()Ljava/lang/String;", "subtypeSuffix", "ktor-client-content-negotiation"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 implements ContentTypeMatcher {
        final /* synthetic */ ContentType $pattern;

        /* JADX INFO: renamed from: subtypeSuffix$delegate, reason: from kotlin metadata */
        private final Lazy subtypeSuffix;

        public AnonymousClass1(ContentType contentType) {
            this.$pattern = contentType;
            this.subtypeSuffix = new SynchronizedLazyImpl(new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 24, contentType));
        }

        private final String getSubtypeSuffix() {
            return (String) this.subtypeSuffix.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String subtypeSuffix_delegate$lambda$0(ContentType contentType) {
            String str = (String) ContentNegotiationKt.supportedSuffixTypes.get(contentType.withoutParameters());
            if (str != null) {
                return "+".concat(str);
            }
            return null;
        }

        @Override // io.ktor.http.ContentTypeMatcher
        public boolean contains(ContentType contentType) {
            contentType.getClass();
            if (contentType.match(this.$pattern)) {
                return true;
            }
            String subtypeSuffix = getSubtypeSuffix();
            if (subtypeSuffix == null) {
                return false;
            }
            return StringsKt__StringsJVMKt.endsWith(contentType.getContentSubtype(), subtypeSuffix, true);
        }
    }

    private final ContentTypeMatcher defaultMatcher(ContentType pattern) {
        return new AnonymousClass1(pattern);
    }

    public final void clearIgnoredTypes() {
        this.ignoredTypes.clear();
    }

    public final ContentTypeMergeStrategy getAcceptHeaderMergeStrategy() {
        return this.acceptHeaderMergeStrategy;
    }

    public final Double getDefaultAcceptHeaderQValue() {
        return this.defaultAcceptHeaderQValue;
    }

    public final Set<KClass<?>> getIgnoredTypes$ktor_client_content_negotiation() {
        return this.ignoredTypes;
    }

    public final List<ConverterRegistration> getRegistrations$ktor_client_content_negotiation() {
        return this.registrations;
    }

    public final void ignoreType(KClass<?> type) {
        type.getClass();
        this.ignoredTypes.add(type);
    }

    public final <T extends ContentConverter> void register(ContentType contentTypeToSend, T converter, ContentTypeMatcher contentTypeMatcher, Function1 configuration) {
        contentTypeToSend.getClass();
        converter.getClass();
        contentTypeMatcher.getClass();
        configuration.getClass();
        configuration.invoke(converter);
        this.registrations.add(new ConverterRegistration(converter, contentTypeToSend, contentTypeMatcher));
    }

    public final void removeIgnoredType(KClass<?> type) {
        type.getClass();
        this.ignoredTypes.remove(type);
    }

    public final void setAcceptHeaderMergeStrategy(ContentTypeMergeStrategy contentTypeMergeStrategy) {
        contentTypeMergeStrategy.getClass();
        this.acceptHeaderMergeStrategy = contentTypeMergeStrategy;
    }

    public final void setDefaultAcceptHeaderQValue(Double d) {
        this.defaultAcceptHeaderQValue = d;
    }

    public final <T> void ignoreType() {
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    public final <T> void removeIgnoredType() {
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    @Override // io.ktor.serialization.Configuration
    public <T extends ContentConverter> void register(ContentType contentType, T converter, Function1 configuration) {
        contentType.getClass();
        converter.getClass();
        configuration.getClass();
        register(contentType, converter, defaultMatcher(contentType), configuration);
    }
}
