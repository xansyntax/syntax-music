package kotlin.time;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.openapi.Responses;
import io.ktor.openapi.Server;
import io.ktor.openapi.Servers;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.ContentConverter;
import io.ktor.serialization.kotlinx.SerializerLookupKt;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.collections.MapDelegatesKt;
import io.ktor.util.collections.TreeLike;
import io.ktor.utils.io.LookAheadSuspendSession;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketDeflateExtension;
import io.ktor.websocket.WebSocketExtensionHeader;
import io.ktor.websocket.WebSocketExtensionsConfig;
import java.util.List;
import java.util.Map;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.sequences.Sequence;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.io.Source;
import kotlinx.io.SourcesJvmKt$$ExternalSyntheticLambda0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.internal.StringOpsKt;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class InstantKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ InstantKt$$ExternalSyntheticLambda0(TypeReference typeReference) {
        this.$r8$classId = (byte) 16;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean z = false;
        switch (this.$r8$classId) {
            case 0:
                return Boolean.valueOf(((Character) obj).charValue() == '-');
            case 1:
                return Boolean.valueOf(Responses.Companion.Serializer._init_$lambda$0((String) obj));
            case 2:
                return Boolean.valueOf(Responses.Companion.Serializer._init_$lambda$1((String) obj));
            case 3:
                return Servers.Builder.server$lambda$0((Server.Builder) obj);
            case 4:
                return Configuration.register$lambda$0((ContentConverter) obj);
            case 5:
                return SerializerLookupKt.checkTypeParameters$lambda$1((KType) obj);
            case 6:
                return JsonSupportKt.DefaultJson$lambda$0((JsonBuilder) obj);
            case 7:
                return MapDelegatesKt.asPresenceBoolean$lambda$0((Boolean) obj);
            case 8:
                return MapDelegatesKt.asPresenceBoolean$lambda$1((String) obj);
            case 9:
                return TreeLike.lineage$lambda$0((TreeLike) obj);
            case 10:
                return TreeLike.descendants$lambda$0((TreeLike) obj);
            case 11:
                return LookAheadSuspendSession.request$lambda$0((Source) obj);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return WebSocketDeflateExtension.Config.manualConfig$lambda$0((List) obj);
            case 13:
                return Boolean.valueOf(WebSocketDeflateExtension.Config.compressCondition$lambda$0((Frame) obj));
            case 14:
                return WebSocketExtensionHeader.parseParameters$lambda$0((String) obj);
            case 15:
                return WebSocketExtensionsConfig.install$lambda$0(obj);
            case 16:
                KTypeProjection kTypeProjection = (KTypeProjection) obj;
                kTypeProjection.getClass();
                if (kTypeProjection.getVariance() == null) {
                    return "*";
                }
                KType type = kTypeProjection.getType();
                TypeReference typeReference = type instanceof TypeReference ? (TypeReference) type : null;
                String strAsString = typeReference != null ? typeReference.asString(true) : String.valueOf(kTypeProjection.getType());
                int i = TypeReference.WhenMappings.$EnumSwitchMapping$0[kTypeProjection.getVariance().ordinal()];
                if (i == 1) {
                    return strAsString;
                }
                if (i == 2) {
                    return "in ".concat(strAsString);
                }
                if (i == 3) {
                    return "out ".concat(strAsString);
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            case 17:
                Sequence sequence = (Sequence) obj;
                sequence.getClass();
                return sequence.iterator();
            case 18:
                return obj;
            case 19:
                return Boolean.valueOf(obj == null);
            case 20:
                return Boolean.valueOf(((Character) obj).charValue() == '-');
            case 21:
                char cCharValue = ((Character) obj).charValue();
                return Boolean.valueOf(cCharValue == 'T' || cCharValue == 't');
            case 22:
                return Boolean.valueOf(((Character) obj).charValue() == ':');
            case 23:
                return Boolean.valueOf(((Character) obj).charValue() == ':');
            case 24:
                char cCharValue2 = ((Character) obj).charValue();
                if ('0' <= cCharValue2 && cCharValue2 < ':') {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 25:
                CoroutineContext.Element element = (CoroutineContext.Element) obj;
                if (element instanceof CoroutineDispatcher) {
                    return (CoroutineDispatcher) element;
                }
                return null;
            case 26:
                KClass kClass = (KClass) obj;
                kClass.getClass();
                KSerializer kSerializerSerializerOrNull = CharsKt.serializerOrNull(kClass);
                if (kSerializerSerializerOrNull != null) {
                    return kSerializerSerializerOrNull;
                }
                if (Okio__OkioKt.getJavaClass(kClass).isInterface()) {
                    return new PolymorphicSerializer(kClass);
                }
                return null;
            case 27:
                KClass kClass2 = (KClass) obj;
                kClass2.getClass();
                KSerializer kSerializerSerializerOrNull2 = CharsKt.serializerOrNull(kClass2);
                if (kSerializerSerializerOrNull2 == null) {
                    kSerializerSerializerOrNull2 = Okio__OkioKt.getJavaClass(kClass2).isInterface() ? new PolymorphicSerializer(kClass2) : null;
                }
                if (kSerializerSerializerOrNull2 != null) {
                    return HexFormatKt.getNullable(kSerializerSerializerOrNull2);
                }
                return null;
            case 28:
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder = (ClassSerialDescriptorBuilder) obj;
                classSerialDescriptorBuilder.getClass();
                final SourcesJvmKt$$ExternalSyntheticLambda0 sourcesJvmKt$$ExternalSyntheticLambda0 = new SourcesJvmKt$$ExternalSyntheticLambda0((byte) 5);
                classSerialDescriptorBuilder.element("JsonPrimitive", new SerialDescriptor(sourcesJvmKt$$ExternalSyntheticLambda0) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1
                    public final SynchronizedLazyImpl original$delegate;

                    {
                        this.original$delegate = new SynchronizedLazyImpl(sourcesJvmKt$$ExternalSyntheticLambda0);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final List getElementAnnotations(int i2) {
                        return getOriginal().getElementAnnotations(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final SerialDescriptor getElementDescriptor(int i2) {
                        return getOriginal().getElementDescriptor(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementIndex(String str) {
                        str.getClass();
                        return getOriginal().getElementIndex(str);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getElementName(int i2) {
                        return getOriginal().getElementName(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementsCount() {
                        return getOriginal().getElementsCount();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final Okio__OkioKt getKind() {
                        return getOriginal().getKind();
                    }

                    public final SerialDescriptor getOriginal() {
                        return (SerialDescriptor) this.original$delegate.getValue();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getSerialName() {
                        return getOriginal().getSerialName();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isElementOptional(int i2) {
                        return getOriginal().isElementOptional(i2);
                    }
                });
                final SourcesJvmKt$$ExternalSyntheticLambda0 sourcesJvmKt$$ExternalSyntheticLambda1 = new SourcesJvmKt$$ExternalSyntheticLambda0((byte) 6);
                classSerialDescriptorBuilder.element("JsonNull", new SerialDescriptor(sourcesJvmKt$$ExternalSyntheticLambda1) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1
                    public final SynchronizedLazyImpl original$delegate;

                    {
                        this.original$delegate = new SynchronizedLazyImpl(sourcesJvmKt$$ExternalSyntheticLambda1);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final List getElementAnnotations(int i2) {
                        return getOriginal().getElementAnnotations(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final SerialDescriptor getElementDescriptor(int i2) {
                        return getOriginal().getElementDescriptor(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementIndex(String str) {
                        str.getClass();
                        return getOriginal().getElementIndex(str);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getElementName(int i2) {
                        return getOriginal().getElementName(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementsCount() {
                        return getOriginal().getElementsCount();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final Okio__OkioKt getKind() {
                        return getOriginal().getKind();
                    }

                    public final SerialDescriptor getOriginal() {
                        return (SerialDescriptor) this.original$delegate.getValue();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getSerialName() {
                        return getOriginal().getSerialName();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isElementOptional(int i2) {
                        return getOriginal().isElementOptional(i2);
                    }
                });
                final SourcesJvmKt$$ExternalSyntheticLambda0 sourcesJvmKt$$ExternalSyntheticLambda2 = new SourcesJvmKt$$ExternalSyntheticLambda0((byte) 7);
                classSerialDescriptorBuilder.element("JsonLiteral", new SerialDescriptor(sourcesJvmKt$$ExternalSyntheticLambda2) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1
                    public final SynchronizedLazyImpl original$delegate;

                    {
                        this.original$delegate = new SynchronizedLazyImpl(sourcesJvmKt$$ExternalSyntheticLambda2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final List getElementAnnotations(int i2) {
                        return getOriginal().getElementAnnotations(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final SerialDescriptor getElementDescriptor(int i2) {
                        return getOriginal().getElementDescriptor(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementIndex(String str) {
                        str.getClass();
                        return getOriginal().getElementIndex(str);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getElementName(int i2) {
                        return getOriginal().getElementName(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementsCount() {
                        return getOriginal().getElementsCount();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final Okio__OkioKt getKind() {
                        return getOriginal().getKind();
                    }

                    public final SerialDescriptor getOriginal() {
                        return (SerialDescriptor) this.original$delegate.getValue();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getSerialName() {
                        return getOriginal().getSerialName();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isElementOptional(int i2) {
                        return getOriginal().isElementOptional(i2);
                    }
                });
                final SourcesJvmKt$$ExternalSyntheticLambda0 sourcesJvmKt$$ExternalSyntheticLambda3 = new SourcesJvmKt$$ExternalSyntheticLambda0((byte) 8);
                classSerialDescriptorBuilder.element("JsonObject", new SerialDescriptor(sourcesJvmKt$$ExternalSyntheticLambda3) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1
                    public final SynchronizedLazyImpl original$delegate;

                    {
                        this.original$delegate = new SynchronizedLazyImpl(sourcesJvmKt$$ExternalSyntheticLambda3);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final List getElementAnnotations(int i2) {
                        return getOriginal().getElementAnnotations(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final SerialDescriptor getElementDescriptor(int i2) {
                        return getOriginal().getElementDescriptor(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementIndex(String str) {
                        str.getClass();
                        return getOriginal().getElementIndex(str);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getElementName(int i2) {
                        return getOriginal().getElementName(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementsCount() {
                        return getOriginal().getElementsCount();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final Okio__OkioKt getKind() {
                        return getOriginal().getKind();
                    }

                    public final SerialDescriptor getOriginal() {
                        return (SerialDescriptor) this.original$delegate.getValue();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getSerialName() {
                        return getOriginal().getSerialName();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isElementOptional(int i2) {
                        return getOriginal().isElementOptional(i2);
                    }
                });
                final SourcesJvmKt$$ExternalSyntheticLambda0 sourcesJvmKt$$ExternalSyntheticLambda4 = new SourcesJvmKt$$ExternalSyntheticLambda0((byte) 9);
                classSerialDescriptorBuilder.element("JsonArray", new SerialDescriptor(sourcesJvmKt$$ExternalSyntheticLambda4) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1
                    public final SynchronizedLazyImpl original$delegate;

                    {
                        this.original$delegate = new SynchronizedLazyImpl(sourcesJvmKt$$ExternalSyntheticLambda4);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final List getElementAnnotations(int i2) {
                        return getOriginal().getElementAnnotations(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final SerialDescriptor getElementDescriptor(int i2) {
                        return getOriginal().getElementDescriptor(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementIndex(String str) {
                        str.getClass();
                        return getOriginal().getElementIndex(str);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getElementName(int i2) {
                        return getOriginal().getElementName(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementsCount() {
                        return getOriginal().getElementsCount();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final Okio__OkioKt getKind() {
                        return getOriginal().getKind();
                    }

                    public final SerialDescriptor getOriginal() {
                        return (SerialDescriptor) this.original$delegate.getValue();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getSerialName() {
                        return getOriginal().getSerialName();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isElementOptional(int i2) {
                        return getOriginal().isElementOptional(i2);
                    }
                });
                return Unit.INSTANCE;
            default:
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                String str = (String) entry.getKey();
                JsonElement jsonElement = (JsonElement) entry.getValue();
                StringBuilder sb = new StringBuilder();
                StringOpsKt.printQuoted(sb, str);
                sb.append(':');
                sb.append(jsonElement);
                return sb.toString();
        }
    }

    public /* synthetic */ InstantKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }
}
