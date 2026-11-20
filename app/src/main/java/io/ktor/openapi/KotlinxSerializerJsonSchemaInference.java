package io.ktor.openapi;

import com.metrolist.music.lyrics.LyricsUtils$$ExternalSyntheticLambda0;
import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.CharsKt;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PolymorphicKind$OPEN;
import kotlinx.serialization.descriptors.PrimitiveKind$INT;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind$CONTEXTUAL;
import kotlinx.serialization.descriptors.SerialKind$ENUM;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonClassDiscriminator;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010%\n\u0002\b\u0004\u0018\u0000 ?2\u00020\u0001:\u0001?B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\u00020\u0012*\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0014Jg\u0010\"\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00122\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b \u0010!J_\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0&2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\u00020\u0012*\u00020\u0005H\u0002¢\u0006\u0004\b)\u0010\u0014J)\u0010-\u001a\u0004\u0018\u00010\u00062\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010.J7\u00100\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00062\u000e\b\u0002\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cH\u0002¢\u0006\u0004\b0\u00101J'\u00104\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u0010.J_\u00108\u001a\b\u0012\u0004\u0012\u00020\f0&2\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cH\u0002¢\u0006\u0004\b8\u00109R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010:R\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010;R \u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006@"}, d2 = {"Lio/ktor/openapi/KotlinxSerializerJsonSchemaInference;", "Lio/ktor/openapi/JsonSchemaInference;", "Lkotlinx/serialization/modules/SerializersModule;", "module", "Lkotlin/Function1;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "formats", "<init>", "(Lkotlinx/serialization/modules/SerializersModule;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/reflect/KType;", LinkHeader.Parameters.Type, "Lio/ktor/openapi/JsonSchema;", "buildSchema", "(Lkotlin/reflect/KType;)Lio/ktor/openapi/JsonSchema;", "", "includeKType", "(Lkotlin/reflect/KType;)V", "", "isParameterized", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "descriptor", "includeTitle", "", "", "includeAnnotations", "", "visiting", "Lkotlinx/serialization/KSerializer;", "serializer", "titleOverride", "visitingNameOverride", "buildSchemaFromDescriptor$ktor_openapi_schema", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ZLjava/util/List;Ljava/util/Set;Lkotlinx/serialization/KSerializer;Ljava/lang/String;Ljava/lang/String;)Lio/ktor/openapi/JsonSchema;", "buildSchemaFromDescriptor", "referenceName", "annotations", "schemaTitleOverride", "Lio/ktor/openapi/ReferenceOr;", "buildSchemaOrReference", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Ljava/lang/String;Ljava/util/Set;Ljava/util/List;Lkotlinx/serialization/KSerializer;Ljava/lang/String;)Lio/ktor/openapi/ReferenceOr;", "isContainerType", "parentDescriptor", "childDescriptor", "parentReferenceName", "recursiveReferenceName", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/descriptors/SerialDescriptor;Ljava/lang/String;)Ljava/lang/String;", "childSerializer", "referenceNameForChild", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/descriptors/SerialDescriptor;Ljava/lang/String;Lkotlinx/serialization/KSerializer;)Ljava/lang/String;", "subclassDescriptor", "serialName", "fallbackSealedSubclassComponentName", "discriminatorProperty", "discriminatorValue", "componentName", "buildSealedSubclassSchema", "(Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;Ljava/lang/String;Ljava/util/Set;Ljava/util/List;Lkotlinx/serialization/KSerializer;)Lio/ktor/openapi/ReferenceOr;", "Lkotlinx/serialization/modules/SerializersModule;", "Lkotlin/jvm/functions/Function1;", "", "kTypeLookup", "Ljava/util/Map;", "Companion", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KotlinxSerializerJsonSchemaInference implements JsonSchemaInference {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KotlinxSerializerJsonSchemaInference Default = new KotlinxSerializerJsonSchemaInference(SerializersModuleKt.EmptySerializersModule, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
    private final Function1 formats;
    private final Map<String, KType> kTypeLookup;
    private final SerializersModule module;

    public KotlinxSerializerJsonSchemaInference(SerializersModule serializersModule, Function1 function1) {
        serializersModule.getClass();
        function1.getClass();
        this.module = serializersModule;
        this.formats = function1;
        this.kTypeLookup = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JsonSchema buildSchemaFromDescriptor$ktor_openapi_schema$default(KotlinxSerializerJsonSchemaInference kotlinxSerializerJsonSchemaInference, SerialDescriptor serialDescriptor, boolean z, List list, Set set, KSerializer kSerializer, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = !kotlinxSerializerJsonSchemaInference.isParameterized(serialDescriptor);
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            list = EmptyList.INSTANCE;
        }
        return kotlinxSerializerJsonSchemaInference.buildSchemaFromDescriptor$ktor_openapi_schema(serialDescriptor, z2, list, set, (i & 16) != 0 ? null : kSerializer, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReferenceOr buildSchemaFromDescriptor$lambda$0(KotlinxSerializerJsonSchemaInference kotlinxSerializerJsonSchemaInference, boolean z, Set set, KClass kClass) {
        kClass.getClass();
        SerializersModule serializersModule = kotlinxSerializerJsonSchemaInference.module;
        serializersModule.getClass();
        KSerializer kSerializerSerializerOrNull = CharsKt.serializerOrNull(kClass);
        if (kSerializerSerializerOrNull == null) {
            SerializersModule.getContextual$default(serializersModule, kClass);
            kSerializerSerializerOrNull = null;
        }
        KSerializer kSerializer = kSerializerSerializerOrNull != null ? kSerializerSerializerOrNull : null;
        if (kSerializer != null) {
            String strSubclassComponentName = JsonSchemaInference_jvmKt.subclassComponentName(kSerializer);
            return ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(buildSchemaFromDescriptor$ktor_openapi_schema$default(kotlinxSerializerJsonSchemaInference, kSerializer.getDescriptor(), z, null, set, kSerializer, strSubclassComponentName, strSubclassComponentName, 4, null)));
        }
        EnumsKt.serializerNotRegistered(kClass);
        throw null;
    }

    private final ReferenceOr<JsonSchema> buildSchemaOrReference(SerialDescriptor descriptor, String referenceName, Set<String> visiting, List<? extends Annotation> annotations, KSerializer serializer, String schemaTitleOverride) {
        if (!isContainerType(descriptor) && !visiting.add(referenceName)) {
            return JsonSchemaInferenceKt.wrapIfNullable(ReferenceOr.Companion.schema$default(ReferenceOr.INSTANCE, referenceName, false, 2, null), descriptor.isNullable());
        }
        try {
            return ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(buildSchemaFromDescriptor$ktor_openapi_schema$default(this, descriptor, false, annotations, visiting, serializer, schemaTitleOverride, referenceName, 2, null)));
        } finally {
            visiting.remove(referenceName);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReferenceOr buildSchemaOrReference$default(KotlinxSerializerJsonSchemaInference kotlinxSerializerJsonSchemaInference, SerialDescriptor serialDescriptor, String str, Set set, List list, KSerializer kSerializer, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            list = EmptyList.INSTANCE;
        }
        return kotlinxSerializerJsonSchemaInference.buildSchemaOrReference(serialDescriptor, str, set, list, (i & 16) != 0 ? null : kSerializer, (i & 32) != 0 ? null : str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReferenceOr<JsonSchema> buildSealedSubclassSchema(String discriminatorProperty, String discriminatorValue, SerialDescriptor descriptor, String componentName, Set<String> visiting, List<? extends Annotation> annotations, KSerializer serializer) {
        GenericElement genericElementString;
        ReferenceOr<JsonSchema> referenceOrBuildSchemaOrReference = buildSchemaOrReference(descriptor, componentName, visiting, annotations, serializer, componentName);
        if (!(referenceOrBuildSchemaOrReference instanceof ReferenceOr.Value)) {
            return referenceOrBuildSchemaOrReference;
        }
        ReferenceOr.Value value = (ReferenceOr.Value) referenceOrBuildSchemaOrReference;
        JsonSchema jsonSchema = (JsonSchema) value.getValue();
        List listListOf = CollectionsKt__IterablesKt.listOf(discriminatorProperty);
        List<String> required = ((JsonSchema) value.getValue()).getRequired();
        if (required == null) {
            required = EmptyList.INSTANCE;
        }
        List list = CollectionsKt.toList(CollectionsKt.toMutableSet(CollectionsKt.plus((Iterable) required, (Collection) listListOf)));
        JsonType jsonType = JsonType.STRING;
        if (discriminatorValue instanceof GenericElement) {
            genericElementString = (GenericElement) discriminatorValue;
        } else {
            genericElementString = discriminatorValue != 0 ? new GenericElementString(discriminatorValue, null, 2, null) : new GenericElementWrapper(discriminatorValue, StringSerializer.INSTANCE);
        }
        Map mapSingletonMap = Collections.singletonMap(discriminatorProperty, ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(new JsonSchema(jsonType, (String) null, (String) null, (List) null, (List) null, (List) null, (ReferenceOr) null, (List) null, (Map) null, (AdditionalProperties) null, (JsonSchemaDiscriminator) null, (Boolean) null, (Boolean) null, (Xml) null, (ExternalDocs) null, (GenericElement) null, (List) null, (Boolean) null, (Integer) null, (Integer) null, (GenericElement) null, (String) null, (ReferenceOr) null, (List) null, (Double) null, (Double) null, (Double) null, (Double) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (Boolean) null, CollectionsKt__IterablesKt.listOf(genericElementString), (GenericElement) null, (Double) null, (String) null, (String) null, (Boolean) null, -2, 251, (DefaultConstructorMarker) null))));
        mapSingletonMap.getClass();
        Map<String, ReferenceOr<JsonSchema>> properties = ((JsonSchema) value.getValue()).getProperties();
        if (properties == null) {
            properties = EmptyMap.INSTANCE;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(properties);
        linkedHashMap.remove(discriminatorProperty);
        return ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(jsonSchema.copy(((-265) & 1) != 0 ? jsonSchema.type : null, ((-265) & 2) != 0 ? jsonSchema.title : null, ((-265) & 4) != 0 ? jsonSchema.description : null, ((-265) & 8) != 0 ? jsonSchema.required : list, ((-265) & 16) != 0 ? jsonSchema.allOf : null, ((-265) & 32) != 0 ? jsonSchema.oneOf : null, ((-265) & 64) != 0 ? jsonSchema.not : null, ((-265) & 128) != 0 ? jsonSchema.anyOf : null, ((-265) & 256) != 0 ? jsonSchema.properties : MapsKt__MapsKt.plus(mapSingletonMap, MapsKt__MapsKt.optimizeReadOnlyMap(linkedHashMap)), ((-265) & 512) != 0 ? jsonSchema.additionalProperties : null, ((-265) & 1024) != 0 ? jsonSchema.discriminator : null, ((-265) & 2048) != 0 ? jsonSchema.readOnly : null, ((-265) & 4096) != 0 ? jsonSchema.writeOnly : null, ((-265) & 8192) != 0 ? jsonSchema.xml : null, ((-265) & 16384) != 0 ? jsonSchema.externalDocs : null, ((-265) & 32768) != 0 ? jsonSchema.example : null, ((-265) & 65536) != 0 ? jsonSchema.examples : null, ((-265) & 131072) != 0 ? jsonSchema.deprecated : null, ((-265) & 262144) != 0 ? jsonSchema.maxProperties : null, ((-265) & 524288) != 0 ? jsonSchema.minProperties : null, ((-265) & ByteChannelKt.CHANNEL_MAX_SIZE) != 0 ? jsonSchema.default : null, ((-265) & 2097152) != 0 ? jsonSchema.format : null, ((-265) & 4194304) != 0 ? jsonSchema.items : null, ((-265) & 8388608) != 0 ? jsonSchema.prefixItems : null, ((-265) & 16777216) != 0 ? jsonSchema.maximum : null, ((-265) & 33554432) != 0 ? jsonSchema.exclusiveMaximum : null, ((-265) & 67108864) != 0 ? jsonSchema.minimum : null, ((-265) & 134217728) != 0 ? jsonSchema.exclusiveMinimum : null, ((-265) & WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE) != 0 ? jsonSchema.maxLength : null, ((-265) & 536870912) != 0 ? jsonSchema.minLength : null, ((-265) & 1073741824) != 0 ? jsonSchema.pattern : null, ((-265) & Integer.MIN_VALUE) != 0 ? jsonSchema.maxItems : null, (255 & 1) != 0 ? jsonSchema.minItems : null, (255 & 2) != 0 ? jsonSchema.uniqueItems : null, (255 & 4) != 0 ? jsonSchema.enum : null, (255 & 8) != 0 ? jsonSchema.const : null, (255 & 16) != 0 ? jsonSchema.multipleOf : null, (255 & 32) != 0 ? jsonSchema.id : null, (255 & 64) != 0 ? jsonSchema.anchor : null, (255 & 128) != 0 ? jsonSchema.dynamicAnchor : null)));
    }

    private final String fallbackSealedSubclassComponentName(SerialDescriptor descriptor, SerialDescriptor subclassDescriptor, String serialName) {
        String nonNullSerialName = JsonSchemaInferenceKt.getNonNullSerialName(subclassDescriptor);
        if (!Intrinsics.areEqual(nonNullSerialName, serialName)) {
            return nonNullSerialName;
        }
        return JsonSchemaInferenceKt.getNonNullSerialName(descriptor) + '.' + serialName;
    }

    private final void includeKType(KType type) {
        String strSubstringBefore$default = StringsKt.substringBefore$default(type.toString(), '<');
        if (this.kTypeLookup.containsKey(strSubstringBefore$default)) {
            return;
        }
        this.kTypeLookup.put(strSubstringBefore$default, type);
        Iterator<KTypeProjection> it = type.getArguments().iterator();
        while (it.hasNext()) {
            KType type2 = it.next().getType();
            if (type2 != null) {
                includeKType(type2);
            }
        }
    }

    private final boolean isContainerType(SerialDescriptor serialDescriptor) {
        return Intrinsics.areEqual(serialDescriptor.getKind(), StructureKind$MAP.INSTANCE$2) || Intrinsics.areEqual(serialDescriptor.getKind(), StructureKind$MAP.INSTANCE);
    }

    private final boolean isParameterized(SerialDescriptor serialDescriptor) {
        List<KTypeProjection> arguments;
        KType kType = this.kTypeLookup.get(JsonSchemaInferenceKt.getNonNullSerialName(serialDescriptor));
        return (kType == null || (arguments = kType.getArguments()) == null || !(arguments.isEmpty() ^ true)) ? false : true;
    }

    private final String recursiveReferenceName(SerialDescriptor parentDescriptor, SerialDescriptor childDescriptor, String parentReferenceName) {
        if (Intrinsics.areEqual(JsonSchemaInferenceKt.getNonNullSerialName(parentDescriptor), JsonSchemaInferenceKt.getNonNullSerialName(childDescriptor))) {
            return parentReferenceName;
        }
        return null;
    }

    private final String referenceNameForChild(SerialDescriptor parentDescriptor, SerialDescriptor childDescriptor, String parentReferenceName, KSerializer childSerializer) {
        String strSubclassComponentName = JsonSchemaInference_jvmKt.subclassComponentName(childSerializer);
        if (strSubclassComponentName != null) {
            return strSubclassComponentName;
        }
        String strRecursiveReferenceName = recursiveReferenceName(parentDescriptor, childDescriptor, parentReferenceName);
        return strRecursiveReferenceName == null ? JsonSchemaInferenceKt.getNonNullSerialName(childDescriptor) : strRecursiveReferenceName;
    }

    public static /* synthetic */ String referenceNameForChild$default(KotlinxSerializerJsonSchemaInference kotlinxSerializerJsonSchemaInference, SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2, String str, KSerializer kSerializer, int i, Object obj) {
        if ((i & 8) != 0) {
            kSerializer = null;
        }
        return kotlinxSerializerJsonSchemaInference.referenceNameForChild(serialDescriptor, serialDescriptor2, str, kSerializer);
    }

    @Override // io.ktor.openapi.JsonSchemaInference
    public JsonSchema buildSchema(KType type) {
        type.getClass();
        includeKType(type);
        KSerializer kSerializerSerializer = CharsKt.serializer(this.module, type);
        return buildSchemaFromDescriptor$ktor_openapi_schema$default(this, kSerializerSerializer.getDescriptor(), type.getArguments().isEmpty(), null, new LinkedHashSet(), kSerializerSerializer, null, null, 100, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final JsonSchema buildSchemaFromDescriptor$ktor_openapi_schema(SerialDescriptor descriptor, boolean includeTitle, List<? extends Annotation> includeAnnotations, Set<String> visiting, KSerializer serializer, String titleOverride, String visitingNameOverride) {
        String str;
        int i;
        LinkedHashMap linkedHashMap;
        AdditionalProperties additionalPropertiesM1733boximpl;
        String elementName;
        KotlinxSerializerJsonSchemaInference kotlinxSerializerJsonSchemaInference = this;
        SerialDescriptor serialDescriptor = descriptor;
        KSerializer kSerializer = serializer;
        serialDescriptor.getClass();
        includeAnnotations.getClass();
        visiting.getClass();
        LyricsUtils$$ExternalSyntheticLambda0 lyricsUtils$$ExternalSyntheticLambda0 = new LyricsUtils$$ExternalSyntheticLambda0((Object) kotlinxSerializerJsonSchemaInference, includeTitle, (Object) visiting, (byte) 11);
        ArrayList arrayListPlus = CollectionsKt.plus((Iterable) serialDescriptor.getAnnotations(), (Collection) includeAnnotations);
        boolean zIsNullable = serialDescriptor.isNullable();
        int i2 = 0;
        if (serialDescriptor.isInline()) {
            return JsonSchemaInferenceKt.wrapIfNullable(buildSchemaFromDescriptor$ktor_openapi_schema$default(kotlinxSerializerJsonSchemaInference, serialDescriptor.getElementDescriptor(0), false, includeAnnotations, visiting, JsonSchemaInference_jvmKt.nestedSerializerAt(kSerializer, 0), titleOverride, visitingNameOverride, 2, null), zIsNullable);
        }
        Okio__OkioKt kind = serialDescriptor.getKind();
        if (Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE$1) || Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE$3)) {
            String nonNullSerialName = visitingNameOverride == null ? JsonSchemaInferenceKt.getNonNullSerialName(serialDescriptor) : visitingNameOverride;
            Set<String> set = visiting;
            set.add(nonNullSerialName);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            ArrayList arrayList = new ArrayList();
            int elementsCount = serialDescriptor.getElementsCount();
            while (i2 < elementsCount) {
                String elementName2 = serialDescriptor.getElementName(i2);
                SerialDescriptor elementDescriptor = serialDescriptor.getElementDescriptor(i2);
                KSerializer kSerializerNestedSerializerAt = JsonSchemaInference_jvmKt.nestedSerializerAt(kSerializer, i2);
                Set<String> set2 = set;
                String strReferenceNameForChild = kotlinxSerializerJsonSchemaInference.referenceNameForChild(serialDescriptor, elementDescriptor, nonNullSerialName, kSerializerNestedSerializerAt);
                List elementAnnotations = serialDescriptor.getElementAnnotations(i2);
                if (elementAnnotations == null || !elementAnnotations.isEmpty()) {
                    Iterator it = elementAnnotations.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            if (!serialDescriptor.isElementOptional(i2) && !elementDescriptor.isNullable()) {
                                arrayList.add(elementName2);
                            }
                            i = elementsCount;
                            str = nonNullSerialName;
                            linkedHashMap = linkedHashMap2;
                            linkedHashMap.put(elementName2, buildSchemaOrReference$default(kotlinxSerializerJsonSchemaInference, elementDescriptor, strReferenceNameForChild, visiting, serialDescriptor.getElementAnnotations(i2), kSerializerNestedSerializerAt, null, 32, null));
                        } else if (((Annotation) it.next()) instanceof JsonSchema.Ignore) {
                            str = nonNullSerialName;
                            i = elementsCount;
                            linkedHashMap = linkedHashMap2;
                        }
                    }
                } else {
                    if (!serialDescriptor.isElementOptional(i2)) {
                        arrayList.add(elementName2);
                    }
                    i = elementsCount;
                    str = nonNullSerialName;
                    linkedHashMap = linkedHashMap2;
                    linkedHashMap.put(elementName2, buildSchemaOrReference$default(kotlinxSerializerJsonSchemaInference, elementDescriptor, strReferenceNameForChild, visiting, serialDescriptor.getElementAnnotations(i2), kSerializerNestedSerializerAt, null, 32, null));
                }
                i2++;
                kotlinxSerializerJsonSchemaInference = this;
                kSerializer = serializer;
                set = set2;
                linkedHashMap2 = linkedHashMap;
                nonNullSerialName = str;
                arrayList = arrayList;
                elementsCount = i;
                serialDescriptor = descriptor;
            }
            ArrayList arrayList2 = arrayList;
            LinkedHashMap linkedHashMap3 = linkedHashMap2;
            set.remove(nonNullSerialName);
            return JsonSchemaInferenceKt.wrapIfNullable(JsonSchemaInferenceKt.jsonSchemaFromAnnotations$default(arrayListPlus, lyricsUtils$$ExternalSyntheticLambda0, JsonType.OBJECT, titleOverride == null ? includeTitle ? JsonSchemaInferenceKt.getNonNullSerialName(descriptor) : null : titleOverride, !arrayList2.isEmpty() ? arrayList2 : null, null, linkedHashMap3, null, null, null, null, null, null, 8096, null), zIsNullable);
        }
        char c = 2;
        if (!Intrinsics.areEqual(kind, PolymorphicKind$OPEN.INSTANCE$1)) {
            if (Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE$2)) {
                SerialDescriptor elementDescriptor2 = serialDescriptor.getElementDescriptor(0);
                return JsonSchemaInferenceKt.jsonSchemaFromAnnotations$default(arrayListPlus, lyricsUtils$$ExternalSyntheticLambda0, JsonSchemaInferenceKt.wrapIfNullable(JsonType.ARRAY, zIsNullable), null, null, buildSchemaOrReference$default(kotlinxSerializerJsonSchemaInference, elementDescriptor2, kotlinxSerializerJsonSchemaInference.referenceNameForChild(serialDescriptor, elementDescriptor2, visitingNameOverride == null ? JsonSchemaInferenceKt.getNonNullSerialName(serialDescriptor) : visitingNameOverride, JsonSchemaInference_jvmKt.nestedSerializerAt(kSerializer, 0)), visiting, null, JsonSchemaInference_jvmKt.nestedSerializerAt(kSerializer, 0), null, 40, null), null, null, null, null, null, null, null, 8152, null);
            }
            if (Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE)) {
                if (serialDescriptor.getElementsCount() > 1) {
                    SerialDescriptor elementDescriptor3 = serialDescriptor.getElementDescriptor(1);
                    additionalPropertiesM1733boximpl = AdditionalProperties.PSchema.m1740boximpl(AdditionalProperties.PSchema.m1741constructorimpl(buildSchemaOrReference$default(kotlinxSerializerJsonSchemaInference, elementDescriptor3, kotlinxSerializerJsonSchemaInference.referenceNameForChild(serialDescriptor, elementDescriptor3, visitingNameOverride == null ? JsonSchemaInferenceKt.getNonNullSerialName(serialDescriptor) : visitingNameOverride, JsonSchemaInference_jvmKt.nestedSerializerAt(kSerializer, 1)), visiting, null, JsonSchemaInference_jvmKt.nestedSerializerAt(kSerializer, 1), null, 40, null)));
                } else {
                    additionalPropertiesM1733boximpl = AdditionalProperties.Allowed.m1733boximpl(AdditionalProperties.Allowed.m1734constructorimpl(true));
                }
                return JsonSchemaInferenceKt.jsonSchemaFromAnnotations$default(arrayListPlus, lyricsUtils$$ExternalSyntheticLambda0, JsonSchemaInferenceKt.wrapIfNullable(JsonType.OBJECT, zIsNullable), null, null, null, null, additionalPropertiesM1733boximpl, null, null, null, null, null, 8056, null);
            }
            if (Intrinsics.areEqual(kind, PrimitiveKind$INT.INSTANCE$8) || Intrinsics.areEqual(kind, PrimitiveKind$INT.INSTANCE$3)) {
                JsonSchema.SchemaType schemaTypeWrapIfNullable = JsonSchemaInferenceKt.wrapIfNullable(JsonType.STRING, zIsNullable);
                if (Intrinsics.areEqual(JsonSchemaInferenceKt.getNonNullSerialName(serialDescriptor), "kotlin.String")) {
                    serialDescriptor = null;
                }
                return JsonSchemaInferenceKt.jsonSchemaFromAnnotations$default(arrayListPlus, lyricsUtils$$ExternalSyntheticLambda0, schemaTypeWrapIfNullable, null, null, null, null, null, null, null, serialDescriptor != null ? (String) kotlinxSerializerJsonSchemaInference.formats.invoke(serialDescriptor) : null, null, null, 7160, null);
            }
            if (Intrinsics.areEqual(kind, PrimitiveKind$INT.INSTANCE$1)) {
                return JsonSchemaInferenceKt.jsonSchemaFromAnnotations$default(arrayListPlus, lyricsUtils$$ExternalSyntheticLambda0, JsonSchemaInferenceKt.wrapIfNullable(JsonType.BOOLEAN, zIsNullable), null, null, null, null, null, null, null, null, null, null, 8184, null);
            }
            if (Intrinsics.areEqual(kind, PrimitiveKind$INT.INSTANCE$2) || Intrinsics.areEqual(kind, PrimitiveKind$INT.INSTANCE$7) || Intrinsics.areEqual(kind, PrimitiveKind$INT.INSTANCE) || Intrinsics.areEqual(kind, PrimitiveKind$INT.INSTANCE$6)) {
                return JsonSchemaInferenceKt.jsonSchemaFromAnnotations$default(arrayListPlus, lyricsUtils$$ExternalSyntheticLambda0, JsonSchemaInferenceKt.wrapIfNullable(JsonType.INTEGER, zIsNullable), null, null, null, null, null, null, null, null, null, null, 8184, null);
            }
            if (Intrinsics.areEqual(kind, PrimitiveKind$INT.INSTANCE$5) || Intrinsics.areEqual(kind, PrimitiveKind$INT.INSTANCE$4)) {
                return JsonSchemaInferenceKt.jsonSchemaFromAnnotations$default(arrayListPlus, lyricsUtils$$ExternalSyntheticLambda0, JsonSchemaInferenceKt.wrapIfNullable(JsonType.NUMBER, zIsNullable), null, null, null, null, null, null, null, null, null, null, 8184, null);
            }
            if (!Intrinsics.areEqual(kind, SerialKind$ENUM.INSTANCE)) {
                if (Intrinsics.areEqual(kind, SerialKind$CONTEXTUAL.INSTANCE)) {
                    KClass capturedKClass = RegexKt.getCapturedKClass(serialDescriptor);
                    if (capturedKClass != null) {
                        SerializersModule.getContextual$default(kotlinxSerializerJsonSchemaInference.module, capturedKClass);
                    }
                    return JsonSchemaInferenceKt.jsonSchemaFromAnnotations$default(arrayListPlus, lyricsUtils$$ExternalSyntheticLambda0, JsonSchemaInferenceKt.wrapIfNullable(JsonType.OBJECT, zIsNullable), null, null, null, null, null, null, null, null, null, null, 8184, null);
                }
                if (Intrinsics.areEqual(kind, PolymorphicKind$OPEN.INSTANCE)) {
                    return JsonSchemaInferenceKt.jsonSchemaFromAnnotations$default(arrayListPlus, lyricsUtils$$ExternalSyntheticLambda0, JsonSchemaInferenceKt.wrapIfNullable(JsonType.OBJECT, zIsNullable), null, null, null, null, null, null, null, null, null, null, 8184, null);
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            }
            JsonSchema.SchemaType schemaTypeWrapIfNullable2 = JsonSchemaInferenceKt.wrapIfNullable(JsonType.STRING, zIsNullable);
            int elementsCount2 = serialDescriptor.getElementsCount();
            ArrayList arrayList3 = new ArrayList(elementsCount2);
            while (i2 < elementsCount2) {
                String elementName3 = serialDescriptor.getElementName(i2);
                arrayList3.add(elementName3 instanceof GenericElement ? (GenericElement) elementName3 : elementName3 != 0 ? new GenericElementString(elementName3, null, 2, null) : new GenericElementWrapper(elementName3, StringSerializer.INSTANCE));
                i2++;
            }
            return JsonSchemaInferenceKt.jsonSchemaFromAnnotations$default(arrayListPlus, lyricsUtils$$ExternalSyntheticLambda0, schemaTypeWrapIfNullable2, null, null, null, null, null, arrayList3, null, null, null, null, 7928, null);
        }
        if (serialDescriptor.getElementsCount() != 2) {
            JsonSchema.SchemaType schemaTypeWrapIfNullable3 = JsonSchemaInferenceKt.wrapIfNullable(JsonType.OBJECT, zIsNullable);
            String serialName = serialDescriptor.getSerialName();
            if (!includeTitle) {
                serialName = null;
            }
            return JsonSchemaInferenceKt.jsonSchemaFromAnnotations$default(arrayListPlus, lyricsUtils$$ExternalSyntheticLambda0, schemaTypeWrapIfNullable3, serialName, null, null, null, null, null, null, null, null, null, 8176, null);
        }
        List annotations = serialDescriptor.getAnnotations();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : annotations) {
            if (obj instanceof JsonClassDiscriminator) {
                arrayList4.add(obj);
            }
        }
        JsonClassDiscriminator jsonClassDiscriminator = (JsonClassDiscriminator) CollectionsKt.firstOrNull((List) arrayList4);
        if (jsonClassDiscriminator == null || (elementName = jsonClassDiscriminator.discriminator()) == null) {
            elementName = serialDescriptor.getElementName(0);
        }
        SerialDescriptor elementDescriptor4 = serialDescriptor.getElementDescriptor(1);
        Map<String, String> mapSealedSubclassComponentNameMapping = JsonSchemaInference_jvmKt.sealedSubclassComponentNameMapping(kSerializer);
        IntRange intRangeUntil = UuidKt.until(0, elementDescriptor4.getElementsCount());
        ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator it2 = intRangeUntil.iterator();
        while (((IntProgressionIterator) it2).hasNext) {
            int iNextInt = ((IntIterator) it2).nextInt();
            SerialDescriptor elementDescriptor5 = elementDescriptor4.getElementDescriptor(iNextInt);
            String elementName4 = elementDescriptor4.getElementName(iNextInt);
            KSerializer kSerializerNestedSerializerAt2 = JsonSchemaInference_jvmKt.nestedSerializerAt(kSerializer, iNextInt);
            String strSubclassComponentName = JsonSchemaInference_jvmKt.subclassComponentName(kSerializerNestedSerializerAt2);
            if (strSubclassComponentName == null && (strSubclassComponentName = mapSealedSubclassComponentNameMapping.get(elementName4)) == null) {
                strSubclassComponentName = kotlinxSerializerJsonSchemaInference.fallbackSealedSubclassComponentName(serialDescriptor, elementDescriptor5, elementName4);
            }
            arrayList5.add(kotlinxSerializerJsonSchemaInference.buildSealedSubclassSchema(elementName, elementName4, elementDescriptor5, strSubclassComponentName, visiting, elementDescriptor4.getElementAnnotations(iNextInt), kSerializerNestedSerializerAt2));
            elementDescriptor4 = elementDescriptor4;
            mapSealedSubclassComponentNameMapping = mapSealedSubclassComponentNameMapping;
            c = 2;
        }
        SerialDescriptor serialDescriptor2 = elementDescriptor4;
        Map<String, String> map = mapSealedSubclassComponentNameMapping;
        int iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(UuidKt.until(0, serialDescriptor2.getElementsCount()), 10));
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(iMapCapacity);
        for (Iterator it3 = r2.iterator(); ((IntProgressionIterator) it3).hasNext; it3 = it3) {
            int iNextInt2 = ((IntIterator) it3).nextInt();
            SerialDescriptor serialDescriptor3 = serialDescriptor2;
            String elementName5 = serialDescriptor3.getElementName(iNextInt2);
            String strSubclassComponentName2 = JsonSchemaInference_jvmKt.subclassComponentName(JsonSchemaInference_jvmKt.nestedSerializerAt(kSerializer, iNextInt2));
            if (strSubclassComponentName2 == null && (strSubclassComponentName2 = map.get(elementName5)) == null) {
                strSubclassComponentName2 = kotlinxSerializerJsonSchemaInference.fallbackSealedSubclassComponentName(serialDescriptor, serialDescriptor3.getElementDescriptor(iNextInt2), elementName5);
            }
            serialDescriptor2 = serialDescriptor3;
            linkedHashMap4.put(elementName5, ReferenceOr.Companion.schema$default(ReferenceOr.INSTANCE, strSubclassComponentName2, false, 2, null).getRef());
        }
        return JsonSchemaInferenceKt.jsonSchemaFromAnnotations$default(arrayListPlus, lyricsUtils$$ExternalSyntheticLambda0, JsonSchemaInferenceKt.wrapIfNullable(JsonType.OBJECT, zIsNullable), includeTitle ? serialDescriptor.getSerialName() : null, null, null, null, null, null, null, null, new JsonSchemaDiscriminator(elementName, linkedHashMap4), arrayList5, 2032, null);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/openapi/KotlinxSerializerJsonSchemaInference$Companion;", "", "<init>", "()V", "Lio/ktor/openapi/KotlinxSerializerJsonSchemaInference;", "Default", "Lio/ktor/openapi/KotlinxSerializerJsonSchemaInference;", "getDefault", "()Lio/ktor/openapi/KotlinxSerializerJsonSchemaInference;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KotlinxSerializerJsonSchemaInference getDefault() {
            return KotlinxSerializerJsonSchemaInference.Default;
        }

        private Companion() {
        }
    }

    public /* synthetic */ KotlinxSerializerJsonSchemaInference(SerializersModule serializersModule, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(serializersModule, (i & 2) != 0 ? JsonSchemaInferenceKt.getKotlinxSerializerDefaultFormats() : function1);
    }
}
