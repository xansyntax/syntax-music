package io.ktor.openapi;

import io.ktor.http.LinkHeader;
import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ReflectionFactory;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u001a9\u0010\n\u001a\u00020\t*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\f*\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\r\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u000e\u001a\u00020\t*\u00020\t2\u0006\u0010\r\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u0010\u001a\u001b\u0010\u000e\u001a\u00020\u0012*\u00020\u00112\u0006\u0010\r\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u0013\u001aí\u0001\u0010'\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001c\u0010\u0017\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f0\u00152\u0006\u0010\u0018\u001a\u00020\u00122\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f2\u001c\b\u0002\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0012\b\u0002\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\u0016\b\u0002\u0010&\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f\u0018\u00010\u0003H\u0007¢\u0006\u0004\b'\u0010(\u001a(\u0010*\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010)\u0018\u0001*\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082\b¢\u0006\u0004\b*\u0010+\u001a \u0010.\u001a\u00020\t\"\n\b\u0000\u0010)\u0018\u0001*\u00020,*\u00020-H\u0086\b¢\u0006\u0004\b.\u0010/\"%\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00158\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0011\u00106\u001a\u00020-8F¢\u0006\u0006\u001a\u0004\b4\u00105\"\u0018\u00109\u001a\u00020\u0007*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "includeTitle", "", "", "includeAnnotations", "", "", "visiting", "Lio/ktor/openapi/JsonSchema;", "buildJsonSchema", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ZLjava/util/List;Ljava/util/Set;)Lio/ktor/openapi/JsonSchema;", "Lio/ktor/openapi/ReferenceOr;", "isNullable", "wrapIfNullable", "(Lio/ktor/openapi/ReferenceOr;Z)Lio/ktor/openapi/ReferenceOr;", "(Lio/ktor/openapi/JsonSchema;Z)Lio/ktor/openapi/JsonSchema;", "Lio/ktor/openapi/JsonType;", "Lio/ktor/openapi/JsonSchema$SchemaType;", "(Lio/ktor/openapi/JsonType;Z)Lio/ktor/openapi/JsonSchema$SchemaType;", "annotations", "Lkotlin/Function1;", "Lkotlin/reflect/KClass;", "reflectSchema", LinkHeader.Parameters.Type, LinkHeader.Parameters.Title, "required", "items", "", "properties", "Lio/ktor/openapi/AdditionalProperties;", "additionalProperties", "Lio/ktor/openapi/GenericElement;", "enum", "const", "format", "Lio/ktor/openapi/JsonSchemaDiscriminator;", "discriminator", "oneOf", "jsonSchemaFromAnnotations", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lio/ktor/openapi/JsonSchema$SchemaType;Ljava/lang/String;Ljava/util/List;Lio/ktor/openapi/ReferenceOr;Ljava/util/Map;Lio/ktor/openapi/AdditionalProperties;Ljava/util/List;Lio/ktor/openapi/GenericElement;Ljava/lang/String;Lio/ktor/openapi/JsonSchemaDiscriminator;Ljava/util/List;)Lio/ktor/openapi/JsonSchema;", "T", "firstInstanceOf", "(Ljava/util/List;)Ljava/lang/annotation/Annotation;", "", "Lio/ktor/openapi/JsonSchemaInference;", "jsonSchema", "(Lio/ktor/openapi/JsonSchemaInference;)Lio/ktor/openapi/JsonSchema;", "KotlinxSerializerDefaultFormats", "Lkotlin/jvm/functions/Function1;", "getKotlinxSerializerDefaultFormats", "()Lkotlin/jvm/functions/Function1;", "getKotlinxJsonSchemaInference", "()Lio/ktor/openapi/JsonSchemaInference;", "KotlinxJsonSchemaInference", "getNonNullSerialName", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/lang/String;", "nonNullSerialName", "ktor-openapi-schema"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JsonSchemaInferenceKt {
    private static final Function1 KotlinxSerializerDefaultFormats = new URLUtilsKt$$ExternalSyntheticLambda0(21);

    /* JADX INFO: Access modifiers changed from: private */
    public static final String KotlinxSerializerDefaultFormats$lambda$0(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        switch (getNonNullSerialName(serialDescriptor)) {
            case "kotlin.uuid.Uuid":
                return "uuid";
            case "kotlinx.datetime.Instant":
                return "date-time";
            case "kotlinx.datetime.LocalDate":
                return "date";
            case "kotlinx.datetime.LocalTime":
                return "time";
            case "kotlin.time.Duration":
                return "duration";
            case "kotlinx.datetime.UtcOffset":
                return "utc-offset";
            case "kotlin.time.Instant":
                return "date-time";
            case "kotlinx.datetime.TimeZone":
                return "time-zone";
            case "kotlinx.datetime.DatePeriod":
                return "duration";
            case "kotlinx.datetime.LocalDateTime":
                return "date-time";
            case "kotlinx.datetime.DateTimePeriod":
                return "duration";
            default:
                return null;
        }
    }

    public static final JsonSchema buildJsonSchema(SerialDescriptor serialDescriptor, boolean z, List<? extends Annotation> list, Set<String> set) {
        serialDescriptor.getClass();
        list.getClass();
        set.getClass();
        return KotlinxSerializerJsonSchemaInference.buildSchemaFromDescriptor$ktor_openapi_schema$default(KotlinxSerializerJsonSchemaInference.INSTANCE.getDefault(), serialDescriptor, z, list, set, null, null, null, 112, null);
    }

    public static /* synthetic */ JsonSchema buildJsonSchema$default(SerialDescriptor serialDescriptor, boolean z, List list, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            list = EmptyList.INSTANCE;
        }
        return buildJsonSchema(serialDescriptor, z, list, set);
    }

    private static final <T extends Annotation> T firstInstanceOf(List<? extends Annotation> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        if (!it.hasNext()) {
            return (T) CollectionsKt.firstOrNull((List) arrayList);
        }
        it.next();
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    public static final JsonSchemaInference getKotlinxJsonSchemaInference() {
        return KotlinxSerializerJsonSchemaInference.INSTANCE.getDefault();
    }

    public static final Function1 getKotlinxSerializerDefaultFormats() {
        return KotlinxSerializerDefaultFormats;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getNonNullSerialName(SerialDescriptor serialDescriptor) {
        CharSequence charSequenceSubSequence;
        String serialName = serialDescriptor.getSerialName();
        char[] cArr = {'?'};
        serialName.getClass();
        int length = serialName.length() - 1;
        if (length < 0) {
            charSequenceSubSequence = "";
            break;
        }
        while (true) {
            int i = length - 1;
            if (!ArraysKt.contains(cArr, serialName.charAt(length))) {
                charSequenceSubSequence = serialName.subSequence(0, length + 1);
                break;
            }
            if (i < 0) {
                charSequenceSubSequence = "";
                break;
            }
            length = i;
        }
        return charSequenceSubSequence.toString();
    }

    public static final <T> JsonSchema jsonSchema(JsonSchemaInference jsonSchemaInference) {
        jsonSchemaInference.getClass();
        try {
            Intrinsics.throwUndefinedForReified();
            throw null;
        } catch (SerializationException unused) {
            JsonType.Companion companion = JsonType.INSTANCE;
            Intrinsics.throwUndefinedForReified();
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:131:0x023a  */
    /* JADX WARN: Code duplicated, block: B:136:0x0250  */
    /* JADX WARN: Code duplicated, block: B:138:0x0261  */
    /* JADX WARN: Code duplicated, block: B:141:0x026b A[LOOP:11: B:140:0x0269->B:141:0x026b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:143:0x0295  */
    /* JADX WARN: Code duplicated, block: B:147:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:152:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:153:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:157:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:162:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:163:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:167:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:172:0x0310  */
    /* JADX WARN: Code duplicated, block: B:173:0x0315  */
    /* JADX WARN: Code duplicated, block: B:177:0x0326  */
    /* JADX WARN: Code duplicated, block: B:182:0x033c  */
    /* JADX WARN: Code duplicated, block: B:183:0x0347  */
    /* JADX WARN: Code duplicated, block: B:187:0x0358  */
    /* JADX WARN: Code duplicated, block: B:192:0x036e  */
    /* JADX WARN: Code duplicated, block: B:193:0x0379  */
    /* JADX WARN: Code duplicated, block: B:197:0x038a  */
    /* JADX WARN: Code duplicated, block: B:205:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:209:0x03be  */
    /* JADX WARN: Code duplicated, block: B:218:0x03de  */
    /* JADX WARN: Code duplicated, block: B:222:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:231:0x0419  */
    /* JADX WARN: Code duplicated, block: B:235:0x042a  */
    /* JADX WARN: Code duplicated, block: B:240:0x0440  */
    /* JADX WARN: Code duplicated, block: B:242:0x0449  */
    /* JADX WARN: Code duplicated, block: B:243:0x044c  */
    /* JADX WARN: Code duplicated, block: B:245:0x0451 A[LOOP:43: B:244:0x044f->B:245:0x0451, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:248:0x045f  */
    /* JADX WARN: Code duplicated, block: B:250:0x0469 A[LOOP:21: B:249:0x0467->B:250:0x0469, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:253:0x0481  */
    /* JADX WARN: Code duplicated, block: B:254:0x0484  */
    /* JADX WARN: Code duplicated, block: B:258:0x0495  */
    /* JADX WARN: Code duplicated, block: B:263:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:266:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:268:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:269:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:273:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:278:0x04e7  */
    /* JADX WARN: Code duplicated, block: B:281:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:283:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:284:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:288:0x050d  */
    /* JADX WARN: Code duplicated, block: B:293:0x0523  */
    /* JADX WARN: Code duplicated, block: B:296:0x052a  */
    /* JADX WARN: Code duplicated, block: B:298:0x052d  */
    /* JADX WARN: Code duplicated, block: B:299:0x0538  */
    /* JADX WARN: Code duplicated, block: B:303:0x0549  */
    /* JADX WARN: Code duplicated, block: B:308:0x055f  */
    /* JADX WARN: Code duplicated, block: B:311:0x0566  */
    /* JADX WARN: Code duplicated, block: B:313:0x0569  */
    /* JADX WARN: Code duplicated, block: B:314:0x0574  */
    /* JADX WARN: Code duplicated, block: B:318:0x0585  */
    /* JADX WARN: Code duplicated, block: B:323:0x059b  */
    /* JADX WARN: Code duplicated, block: B:324:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:328:0x05b7  */
    /* JADX WARN: Code duplicated, block: B:333:0x05cd  */
    /* JADX WARN: Code duplicated, block: B:334:0x05d8  */
    /* JADX WARN: Code duplicated, block: B:338:0x05e9  */
    /* JADX WARN: Code duplicated, block: B:343:0x05ff  */
    /* JADX WARN: Code duplicated, block: B:344:0x0606  */
    /* JADX WARN: Code duplicated, block: B:348:0x0617  */
    /* JADX WARN: Code duplicated, block: B:353:0x062d  */
    /* JADX WARN: Code duplicated, block: B:354:0x0638  */
    /* JADX WARN: Code duplicated, block: B:358:0x0649  */
    /* JADX WARN: Code duplicated, block: B:363:0x065f  */
    /* JADX WARN: Code duplicated, block: B:364:0x066a  */
    /* JADX WARN: Code duplicated, block: B:368:0x067b  */
    /* JADX WARN: Code duplicated, block: B:373:0x0691  */
    /* JADX WARN: Code duplicated, block: B:374:0x0696  */
    /* JADX WARN: Code duplicated, block: B:378:0x06a7  */
    /* JADX WARN: Code duplicated, block: B:394:0x06e6  */
    /* JADX WARN: Code duplicated, block: B:398:0x06f7  */
    /* JADX WARN: Code duplicated, block: B:408:0x071c  */
    /* JADX WARN: Code duplicated, block: B:412:0x072d  */
    /* JADX WARN: Code duplicated, block: B:417:0x0743  */
    /* JADX WARN: Code duplicated, block: B:418:0x074e  */
    /* JADX WARN: Code duplicated, block: B:422:0x075f  */
    /* JADX WARN: Code duplicated, block: B:427:0x0775  */
    /* JADX WARN: Code duplicated, block: B:428:0x077c  */
    /* JADX WARN: Code duplicated, block: B:432:0x078d  */
    /* JADX WARN: Code duplicated, block: B:437:0x07a3  */
    /* JADX WARN: Code duplicated, block: B:438:0x07aa  */
    /* JADX WARN: Code duplicated, block: B:442:0x07bb  */
    /* JADX WARN: Code duplicated, block: B:447:0x07d1  */
    /* JADX WARN: Code duplicated, block: B:449:0x07db  */
    /* JADX WARN: Code duplicated, block: B:450:0x07de  */
    /* JADX WARN: Code duplicated, block: B:454:0x07ef  */
    /* JADX WARN: Code duplicated, block: B:470:0x0834  */
    /* JADX WARN: Code duplicated, block: B:474:0x0845  */
    /* JADX WARN: Code duplicated, block: B:492:0x088b  */
    /* JADX WARN: Code duplicated, block: B:538:0x0242 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:540:0x0234 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:544:0x02ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:546:0x02a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:549:0x02d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:551:0x02ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:554:0x0302 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:556:0x02f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:559:0x032e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:561:0x0320 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:564:0x0360 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:566:0x0352 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:569:0x0392 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:571:0x0384 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:574:0x03c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:576:0x03b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:579:0x03f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:581:0x03e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:584:0x0432 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:586:0x0424 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:590:0x049d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:592:0x048f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:595:0x04d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:0x04cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:0x0515 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:602:0x0507 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:0x0551 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:0x0543 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x058d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:0x057f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x05bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x05b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:0x05f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:0x05e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:0x061f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:0x0611 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:630:0x0651 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:0x0643 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:0x0683 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x0675 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:640:0x06af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:642:0x06a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:0x06ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:0x06f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:0x0735 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x0727 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x0767 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x0759 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:660:0x0795 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:663:0x0787 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:0x07c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:668:0x07b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:671:0x07f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:673:0x07e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:677:0x084d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:679:0x083f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x011d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0185  */
    /* JADX WARN: Instruction removed from duplicated block: B:141:0x026b, please report this as an issue */
    public static final JsonSchema jsonSchemaFromAnnotations(List<? extends Annotation> list, Function1 function1, JsonSchema.SchemaType schemaType, String str, List<String> list2, ReferenceOr<JsonSchema> referenceOr, Map<String, ? extends ReferenceOr<JsonSchema>> map, AdditionalProperties additionalProperties, List<? extends GenericElement> list3, GenericElement genericElement, String str2, JsonSchemaDiscriminator jsonSchemaDiscriminator, List<? extends ReferenceOr<JsonSchema>> list4) {
        List<String> list5;
        ArrayList arrayList;
        List list6;
        AdditionalProperties additionalProperties2;
        AdditionalProperties additionalPropertiesM1733boximpl;
        ArrayList arrayList2;
        JsonSchema.Discriminator discriminator;
        JsonSchemaDiscriminator jsonSchemaDiscriminator2;
        ArrayList arrayList3;
        Boolean bool;
        ArrayList arrayList4;
        Boolean bool2;
        ArrayList arrayList5;
        Boolean bool3;
        ArrayList arrayList6;
        JsonSchema.MaxProperties maxProperties;
        Integer numValueOf;
        ArrayList arrayList7;
        JsonSchema.MinProperties minProperties;
        Integer numValueOf2;
        ArrayList arrayList8;
        JsonSchema.Default r1;
        GenericElement genericElementJsonSchemaFromAnnotations$parseJsonLiteralToGenericElement;
        ArrayList arrayList9;
        JsonSchema.Format format;
        String str3;
        ArrayList arrayList10;
        JsonSchema.ItemsRef itemsRef;
        ReferenceOr<JsonSchema> referenceOr2;
        ArrayList arrayList11;
        JsonSchema.PrefixItemsRef prefixItemsRef;
        ArrayList arrayList12;
        ArrayList arrayList13;
        JsonSchema.Maximum maximum;
        Double dValueOf;
        ArrayList arrayList14;
        JsonSchema.Maximum maximum2;
        Double dValueOf2;
        ArrayList arrayList15;
        JsonSchema.Minimum minimum;
        Double dValueOf3;
        ArrayList arrayList16;
        JsonSchema.Minimum minimum2;
        Double dValueOf4;
        ArrayList arrayList17;
        JsonSchema.MaxLength maxLength;
        Integer numValueOf3;
        ArrayList arrayList18;
        JsonSchema.MinLength minLength;
        Integer numValueOf4;
        ArrayList arrayList19;
        JsonSchema.Pattern pattern;
        String strValue;
        ArrayList arrayList20;
        JsonSchema.MaxItems maxItems;
        Integer numValueOf5;
        ArrayList arrayList21;
        JsonSchema.MinItems minItems;
        Integer numValueOf6;
        ArrayList arrayList22;
        Boolean bool4;
        ArrayList arrayList23;
        JsonSchema.Enum r0;
        List list7;
        ArrayList arrayList24;
        JsonSchema.Const r2;
        GenericElement genericElement2;
        ArrayList arrayList25;
        JsonSchema.MultipleOf multipleOf;
        Double dValueOf5;
        ArrayList arrayList26;
        JsonSchema.Id id;
        String strValue2;
        ArrayList arrayList27;
        JsonSchema.Anchor anchor;
        String strValue3;
        ArrayList arrayList28;
        JsonSchema.Anchor anchor2;
        Boolean bool5;
        ArrayList arrayList29;
        JsonSchema.Example example;
        GenericElement genericElement3;
        ArrayList arrayList30;
        JsonSchema.Example example2;
        ArrayList arrayList31;
        String[] strArrValue;
        String[] strArrValue2;
        boolean zDynamic;
        Boolean boolValueOf;
        String strValue4;
        GenericElement genericElementJsonSchemaFromAnnotations$parseJsonLiteralToGenericElement2;
        String[] strArrValue3;
        Class<?>[] clsArrValue;
        int length;
        KClass[] kClassArr;
        int i;
        KClass[] kClassArr2;
        ArrayList arrayList32;
        int length2;
        int i2;
        ReferenceOr<JsonSchema> referenceOr3;
        String strValue5;
        String strValue6;
        JsonSchema.Discriminator.Mapping[] mappingArrMapping;
        int iMapCapacity;
        LinkedHashMap linkedHashMap;
        int length3;
        int i3;
        KClass[] kClassArr3;
        String[] strArrValue4;
        String[] strArrValue5;
        String strValue7;
        JsonType jsonTypeValue;
        list.getClass();
        function1.getClass();
        schemaType.getClass();
        ArrayList arrayList33 = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof JsonSchema.Type) {
                arrayList33.add(obj);
            }
        }
        JsonSchema.Type type = (JsonSchema.Type) ((Annotation) CollectionsKt.firstOrNull((List) arrayList33));
        JsonSchema.SchemaType schemaType2 = (type == null || (jsonTypeValue = type.value()) == null) ? schemaType : jsonTypeValue;
        ArrayList arrayList34 = new ArrayList();
        for (Object obj2 : list) {
            if (obj2 instanceof JsonSchema.Title) {
                arrayList34.add(obj2);
            }
        }
        JsonSchema.Title title = (JsonSchema.Title) ((Annotation) CollectionsKt.firstOrNull((List) arrayList34));
        String str4 = (title == null || (strValue7 = title.value()) == null) ? str : strValue7;
        ArrayList arrayList35 = new ArrayList();
        for (Object obj3 : list) {
            if (obj3 instanceof JsonSchema.Description) {
                arrayList35.add(obj3);
            }
        }
        JsonSchema.Description description = (JsonSchema.Description) ((Annotation) CollectionsKt.firstOrNull((List) arrayList35));
        String strValue8 = description != null ? description.value() : null;
        ArrayList arrayList36 = new ArrayList();
        for (Object obj4 : list) {
            if (obj4 instanceof JsonSchema.Required) {
                arrayList36.add(obj4);
            }
        }
        JsonSchema.Required required = (JsonSchema.Required) ((Annotation) CollectionsKt.firstOrNull((List) arrayList36));
        if (required == null || (strArrValue5 = required.value()) == null) {
            list5 = list2;
        } else {
            List<String> list8 = ArraysKt.toList(strArrValue5);
            if (list8.isEmpty()) {
                list8 = null;
            }
            if (list8 == null) {
                list5 = list2;
            } else {
                list5 = list8;
            }
        }
        ArrayList arrayList37 = new ArrayList();
        for (Object obj5 : list) {
            if (obj5 instanceof JsonSchema.AnyOfRefs) {
                arrayList37.add(obj5);
            }
        }
        JsonSchema.AnyOfRefs anyOfRefs = (JsonSchema.AnyOfRefs) ((Annotation) CollectionsKt.firstOrNull((List) arrayList37));
        if (anyOfRefs == null || (strArrValue4 = anyOfRefs.value()) == null) {
            arrayList = null;
        } else {
            ArrayList arrayList38 = new ArrayList(strArrValue4.length);
            for (String str5 : strArrValue4) {
                arrayList38.add(jsonSchemaFromAnnotations$refFromString(str5));
            }
            if (arrayList38.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = arrayList38;
            }
        }
        ArrayList arrayList39 = new ArrayList();
        for (Object obj6 : list) {
            if (obj6 instanceof JsonSchema.OneOf) {
                arrayList39.add(obj6);
            }
        }
        JsonSchema.OneOf oneOf = (JsonSchema.OneOf) ((Annotation) CollectionsKt.firstOrNull((List) arrayList39));
        if (oneOf != null) {
            Class<?>[] clsArrValue2 = oneOf.value();
            ReflectionFactory reflectionFactory = Reflection.factory;
            int length4 = clsArrValue2.length;
            if (length4 == 0) {
                kClassArr3 = Reflection.EMPTY_K_CLASS_ARRAY;
            } else {
                KClass[] kClassArr4 = new KClass[length4];
                for (int i4 = 0; i4 < length4; i4++) {
                    kClassArr4[i4] = Reflection.getOrCreateKotlinClass(clsArrValue2[i4]);
                }
                kClassArr3 = kClassArr4;
            }
            if (kClassArr3 != null) {
                ArrayList arrayList40 = new ArrayList(kClassArr3.length);
                for (KClass kClass : kClassArr3) {
                    arrayList40.add((ReferenceOr) function1.invoke(kClass));
                }
                boolean zIsEmpty = arrayList40.isEmpty();
                list6 = arrayList40;
                if (zIsEmpty) {
                    list6 = null;
                }
                if (list6 == null) {
                    list6 = list4;
                }
            } else {
                list6 = list4;
            }
        } else {
            list6 = list4;
        }
        ArrayList arrayList41 = new ArrayList();
        for (Object obj7 : list) {
            if (obj7 instanceof JsonSchema.Not) {
                arrayList41.add(obj7);
            }
        }
        JsonSchema.Not not = (JsonSchema.Not) ((Annotation) CollectionsKt.firstOrNull((List) arrayList41));
        ReferenceOr referenceOr4 = not != null ? (ReferenceOr) function1.invoke(Reflection.getOrCreateKotlinClass(not.value())) : null;
        ArrayList arrayList42 = new ArrayList();
        for (Object obj8 : list) {
            if (obj8 instanceof JsonSchema.AdditionalPropertiesRef) {
                arrayList42.add(obj8);
            }
        }
        JsonSchema.AdditionalPropertiesRef additionalPropertiesRef = (JsonSchema.AdditionalPropertiesRef) ((Annotation) CollectionsKt.firstOrNull((List) arrayList42));
        if (additionalPropertiesRef == null) {
            ArrayList arrayList43 = new ArrayList();
            for (Object obj9 : list) {
                if (obj9 instanceof JsonSchema.AdditionalPropertiesAllowed) {
                    arrayList43.add(obj9);
                }
            }
            if (((JsonSchema.AdditionalPropertiesAllowed) ((Annotation) CollectionsKt.firstOrNull((List) arrayList43))) != null) {
                additionalPropertiesM1733boximpl = AdditionalProperties.Allowed.m1733boximpl(AdditionalProperties.Allowed.m1734constructorimpl(true));
            } else {
                additionalProperties2 = additionalProperties;
            }
            arrayList2 = new ArrayList();
            for (Object obj10 : list) {
                if (obj10 instanceof JsonSchema.Discriminator) {
                    arrayList2.add(obj10);
                }
            }
            discriminator = (JsonSchema.Discriminator) ((Annotation) CollectionsKt.firstOrNull((List) arrayList2));
            if (discriminator != null) {
                String strProperty = discriminator.property();
                mappingArrMapping = discriminator.mapping();
                iMapCapacity = MapsKt__MapsKt.mapCapacity(mappingArrMapping.length);
                if (iMapCapacity < 16) {
                    iMapCapacity = 16;
                }
                linkedHashMap = new LinkedHashMap(iMapCapacity);
                length3 = mappingArrMapping.length;
                i3 = 0;
                while (i3 < length3) {
                    JsonSchema.Discriminator.Mapping mapping = mappingArrMapping[i3];
                    linkedHashMap.put(mapping.key(), "#/components/schemas/" + JsonSchemaInference_jvmKt.typeName(mapping));
                    i3++;
                    mappingArrMapping = mappingArrMapping;
                }
                jsonSchemaDiscriminator2 = new JsonSchemaDiscriminator(strProperty, linkedHashMap);
            } else {
                jsonSchemaDiscriminator2 = jsonSchemaDiscriminator;
            }
            arrayList3 = new ArrayList();
            for (Object obj11 : list) {
                if (obj11 instanceof JsonSchema.ReadOnly) {
                    arrayList3.add(obj11);
                }
            }
            if (((JsonSchema.ReadOnly) ((Annotation) CollectionsKt.firstOrNull((List) arrayList3))) != null) {
                bool = Boolean.TRUE;
            } else {
                bool = null;
            }
            arrayList4 = new ArrayList();
            for (Object obj12 : list) {
                if (obj12 instanceof JsonSchema.WriteOnly) {
                    arrayList4.add(obj12);
                }
            }
            if (((JsonSchema.WriteOnly) ((Annotation) CollectionsKt.firstOrNull((List) arrayList4))) != null) {
                bool2 = Boolean.TRUE;
            } else {
                bool2 = null;
            }
            arrayList5 = new ArrayList();
            for (Object obj13 : list) {
                if (obj13 instanceof JsonSchema.DeprecatedSchema) {
                    arrayList5.add(obj13);
                }
            }
            if (((JsonSchema.DeprecatedSchema) ((Annotation) CollectionsKt.firstOrNull((List) arrayList5))) != null) {
                bool3 = Boolean.TRUE;
            } else {
                bool3 = null;
            }
            arrayList6 = new ArrayList();
            for (Object obj14 : list) {
                if (obj14 instanceof JsonSchema.MaxProperties) {
                    arrayList6.add(obj14);
                }
            }
            maxProperties = (JsonSchema.MaxProperties) ((Annotation) CollectionsKt.firstOrNull((List) arrayList6));
            if (maxProperties != null) {
                numValueOf = Integer.valueOf(maxProperties.value());
            } else {
                numValueOf = null;
            }
            arrayList7 = new ArrayList();
            for (Object obj15 : list) {
                if (obj15 instanceof JsonSchema.MinProperties) {
                    arrayList7.add(obj15);
                }
            }
            minProperties = (JsonSchema.MinProperties) ((Annotation) CollectionsKt.firstOrNull((List) arrayList7));
            if (minProperties != null) {
                numValueOf2 = Integer.valueOf(minProperties.value());
            } else {
                numValueOf2 = null;
            }
            arrayList8 = new ArrayList();
            for (Object obj16 : list) {
                if (obj16 instanceof JsonSchema.Default) {
                    arrayList8.add(obj16);
                }
            }
            r1 = (JsonSchema.Default) ((Annotation) CollectionsKt.firstOrNull((List) arrayList8));
            if (r1 != null || (strValue6 = r1.value()) == null) {
                genericElementJsonSchemaFromAnnotations$parseJsonLiteralToGenericElement = null;
            } else {
                genericElementJsonSchemaFromAnnotations$parseJsonLiteralToGenericElement = jsonSchemaFromAnnotations$parseJsonLiteralToGenericElement(strValue6);
            }
            arrayList9 = new ArrayList();
            for (Object obj17 : list) {
                if (obj17 instanceof JsonSchema.Format) {
                    arrayList9.add(obj17);
                }
            }
            format = (JsonSchema.Format) ((Annotation) CollectionsKt.firstOrNull((List) arrayList9));
            if (format != null || (strValue5 = format.value()) == null) {
                str3 = str2;
            } else {
                str3 = strValue5;
            }
            arrayList10 = new ArrayList();
            for (Object obj18 : list) {
                if (obj18 instanceof JsonSchema.ItemsRef) {
                    arrayList10.add(obj18);
                }
            }
            itemsRef = (JsonSchema.ItemsRef) ((Annotation) CollectionsKt.firstOrNull((List) arrayList10));
            if (itemsRef != null || (referenceOr3 = (ReferenceOr) function1.invoke(Reflection.getOrCreateKotlinClass(itemsRef.value()))) == null) {
                referenceOr2 = referenceOr;
            } else {
                referenceOr2 = referenceOr3;
            }
            arrayList11 = new ArrayList();
            for (Object obj19 : list) {
                if (obj19 instanceof JsonSchema.PrefixItemsRef) {
                    arrayList11.add(obj19);
                }
            }
            prefixItemsRef = (JsonSchema.PrefixItemsRef) ((Annotation) CollectionsKt.firstOrNull((List) arrayList11));
            if (prefixItemsRef != null) {
                clsArrValue = prefixItemsRef.value();
                ReflectionFactory reflectionFactory2 = Reflection.factory;
                length = clsArrValue.length;
                if (length == 0) {
                    kClassArr2 = Reflection.EMPTY_K_CLASS_ARRAY;
                } else {
                    kClassArr = new KClass[length];
                    for (i = 0; i < length; i++) {
                        kClassArr[i] = Reflection.getOrCreateKotlinClass(clsArrValue[i]);
                    }
                    kClassArr2 = kClassArr;
                }
                if (kClassArr2 != null) {
                    arrayList32 = new ArrayList(kClassArr2.length);
                    length2 = kClassArr2.length;
                    i2 = 0;
                    while (i2 < length2) {
                        KClass[] kClassArr5 = kClassArr2;
                        arrayList32.add((ReferenceOr) function1.invoke(kClassArr5[i2]));
                        i2++;
                        kClassArr2 = kClassArr5;
                    }
                    if (arrayList32.isEmpty()) {
                        arrayList12 = null;
                    } else {
                        arrayList12 = arrayList32;
                    }
                } else {
                    arrayList12 = null;
                }
            } else {
                arrayList12 = null;
            }
            arrayList13 = new ArrayList();
            for (Object obj20 : list) {
                if (obj20 instanceof JsonSchema.Maximum) {
                    arrayList13.add(obj20);
                }
            }
            maximum = (JsonSchema.Maximum) ((Annotation) CollectionsKt.firstOrNull((List) arrayList13));
            if (maximum == null) {
                dValueOf = null;
            } else {
                if (maximum.exclusive()) {
                    maximum = null;
                }
                if (maximum != null) {
                    dValueOf = Double.valueOf(maximum.value());
                } else {
                    dValueOf = null;
                }
            }
            arrayList14 = new ArrayList();
            for (Object obj21 : list) {
                if (obj21 instanceof JsonSchema.Maximum) {
                    arrayList14.add(obj21);
                }
            }
            maximum2 = (JsonSchema.Maximum) ((Annotation) CollectionsKt.firstOrNull((List) arrayList14));
            if (maximum2 == null) {
                dValueOf2 = null;
            } else {
                if (!maximum2.exclusive()) {
                    maximum2 = null;
                }
                if (maximum2 != null) {
                    dValueOf2 = Double.valueOf(maximum2.value());
                } else {
                    dValueOf2 = null;
                }
            }
            arrayList15 = new ArrayList();
            for (Object obj22 : list) {
                if (obj22 instanceof JsonSchema.Minimum) {
                    arrayList15.add(obj22);
                }
            }
            minimum = (JsonSchema.Minimum) ((Annotation) CollectionsKt.firstOrNull((List) arrayList15));
            if (minimum == null) {
                dValueOf3 = null;
            } else {
                if (minimum.exclusive()) {
                    minimum = null;
                }
                if (minimum != null) {
                    dValueOf3 = Double.valueOf(minimum.value());
                } else {
                    dValueOf3 = null;
                }
            }
            arrayList16 = new ArrayList();
            for (Object obj23 : list) {
                if (obj23 instanceof JsonSchema.Minimum) {
                    arrayList16.add(obj23);
                }
            }
            minimum2 = (JsonSchema.Minimum) ((Annotation) CollectionsKt.firstOrNull((List) arrayList16));
            if (minimum2 == null) {
                dValueOf4 = null;
            } else {
                if (!minimum2.exclusive()) {
                    minimum2 = null;
                }
                if (minimum2 != null) {
                    dValueOf4 = Double.valueOf(minimum2.value());
                } else {
                    dValueOf4 = null;
                }
            }
            arrayList17 = new ArrayList();
            for (Object obj24 : list) {
                if (obj24 instanceof JsonSchema.MaxLength) {
                    arrayList17.add(obj24);
                }
            }
            maxLength = (JsonSchema.MaxLength) ((Annotation) CollectionsKt.firstOrNull((List) arrayList17));
            if (maxLength != null) {
                numValueOf3 = Integer.valueOf(maxLength.value());
            } else {
                numValueOf3 = null;
            }
            arrayList18 = new ArrayList();
            for (Object obj25 : list) {
                if (obj25 instanceof JsonSchema.MinLength) {
                    arrayList18.add(obj25);
                }
            }
            minLength = (JsonSchema.MinLength) ((Annotation) CollectionsKt.firstOrNull((List) arrayList18));
            if (minLength != null) {
                numValueOf4 = Integer.valueOf(minLength.value());
            } else {
                numValueOf4 = null;
            }
            arrayList19 = new ArrayList();
            for (Object obj26 : list) {
                if (obj26 instanceof JsonSchema.Pattern) {
                    arrayList19.add(obj26);
                }
            }
            pattern = (JsonSchema.Pattern) ((Annotation) CollectionsKt.firstOrNull((List) arrayList19));
            if (pattern != null) {
                strValue = pattern.value();
            } else {
                strValue = null;
            }
            arrayList20 = new ArrayList();
            for (Object obj27 : list) {
                if (obj27 instanceof JsonSchema.MaxItems) {
                    arrayList20.add(obj27);
                }
            }
            maxItems = (JsonSchema.MaxItems) ((Annotation) CollectionsKt.firstOrNull((List) arrayList20));
            if (maxItems != null) {
                numValueOf5 = Integer.valueOf(maxItems.value());
            } else {
                numValueOf5 = null;
            }
            arrayList21 = new ArrayList();
            for (Object obj28 : list) {
                if (obj28 instanceof JsonSchema.MinItems) {
                    arrayList21.add(obj28);
                }
            }
            minItems = (JsonSchema.MinItems) ((Annotation) CollectionsKt.firstOrNull((List) arrayList21));
            if (minItems != null) {
                numValueOf6 = Integer.valueOf(minItems.value());
            } else {
                numValueOf6 = null;
            }
            arrayList22 = new ArrayList();
            for (Object obj29 : list) {
                if (obj29 instanceof JsonSchema.UniqueItems) {
                    arrayList22.add(obj29);
                }
            }
            if (((JsonSchema.UniqueItems) ((Annotation) CollectionsKt.firstOrNull((List) arrayList22))) != null) {
                bool4 = Boolean.TRUE;
            } else {
                bool4 = null;
            }
            arrayList23 = new ArrayList();
            for (Object obj30 : list) {
                if (obj30 instanceof JsonSchema.Enum) {
                    arrayList23.add(obj30);
                }
            }
            r0 = (JsonSchema.Enum) ((Annotation) CollectionsKt.firstOrNull((List) arrayList23));
            if (r0 != null || (strArrValue3 = r0.value()) == null) {
                list7 = list3;
            } else {
                ArrayList arrayList44 = new ArrayList(strArrValue3.length);
                for (String str6 : strArrValue3) {
                    arrayList44.add(jsonSchemaFromAnnotations$parseJsonLiteralOrUseString(str6));
                }
                if (arrayList44.isEmpty()) {
                    arrayList44 = null;
                }
                if (arrayList44 != null) {
                    list7 = arrayList44;
                } else {
                    list7 = list3;
                }
            }
            arrayList24 = new ArrayList();
            for (Object obj31 : list) {
                if (obj31 instanceof JsonSchema.Const) {
                    arrayList24.add(obj31);
                }
            }
            r2 = (JsonSchema.Const) ((Annotation) CollectionsKt.firstOrNull((List) arrayList24));
            if (r2 != null || (strValue4 = r2.value()) == null || (genericElementJsonSchemaFromAnnotations$parseJsonLiteralToGenericElement2 = jsonSchemaFromAnnotations$parseJsonLiteralToGenericElement(strValue4)) == null) {
                genericElement2 = genericElement;
            } else {
                genericElement2 = genericElementJsonSchemaFromAnnotations$parseJsonLiteralToGenericElement2;
            }
            arrayList25 = new ArrayList();
            for (Object obj32 : list) {
                if (obj32 instanceof JsonSchema.MultipleOf) {
                    arrayList25.add(obj32);
                }
            }
            multipleOf = (JsonSchema.MultipleOf) ((Annotation) CollectionsKt.firstOrNull((List) arrayList25));
            if (multipleOf != null) {
                dValueOf5 = Double.valueOf(multipleOf.value());
            } else {
                dValueOf5 = null;
            }
            arrayList26 = new ArrayList();
            for (Object obj33 : list) {
                if (obj33 instanceof JsonSchema.Id) {
                    arrayList26.add(obj33);
                }
            }
            id = (JsonSchema.Id) ((Annotation) CollectionsKt.firstOrNull((List) arrayList26));
            if (id != null) {
                strValue2 = id.value();
            } else {
                strValue2 = null;
            }
            arrayList27 = new ArrayList();
            for (Object obj34 : list) {
                if (obj34 instanceof JsonSchema.Anchor) {
                    arrayList27.add(obj34);
                }
            }
            anchor = (JsonSchema.Anchor) ((Annotation) CollectionsKt.firstOrNull((List) arrayList27));
            if (anchor != null) {
                strValue3 = anchor.value();
            } else {
                strValue3 = null;
            }
            arrayList28 = new ArrayList();
            for (Object obj35 : list) {
                if (obj35 instanceof JsonSchema.Anchor) {
                    arrayList28.add(obj35);
                }
            }
            anchor2 = (JsonSchema.Anchor) ((Annotation) CollectionsKt.firstOrNull((List) arrayList28));
            if (anchor2 != null) {
                zDynamic = anchor2.dynamic();
                boolValueOf = Boolean.valueOf(zDynamic);
                if (zDynamic) {
                    bool5 = boolValueOf;
                } else {
                    bool5 = null;
                }
            } else {
                bool5 = null;
            }
            arrayList29 = new ArrayList();
            for (Object obj36 : list) {
                if (obj36 instanceof JsonSchema.Example) {
                    arrayList29.add(obj36);
                }
            }
            example = (JsonSchema.Example) ((Annotation) CollectionsKt.firstOrNull((List) arrayList29));
            if (example != null || (strArrValue2 = example.value()) == null) {
                genericElement3 = null;
            } else {
                ArrayList arrayList45 = new ArrayList(strArrValue2.length);
                for (String str7 : strArrValue2) {
                    arrayList45.add(jsonSchemaFromAnnotations$parseJsonLiteralToGenericElement(str7));
                }
                if (arrayList45.isEmpty()) {
                    arrayList45 = null;
                }
                if (arrayList45 != null) {
                    genericElement3 = (GenericElement) CollectionsKt.singleOrNull(arrayList45);
                } else {
                    genericElement3 = null;
                }
            }
            arrayList30 = new ArrayList();
            for (Object obj37 : list) {
                if (obj37 instanceof JsonSchema.Example) {
                    arrayList30.add(obj37);
                }
            }
            example2 = (JsonSchema.Example) ((Annotation) CollectionsKt.firstOrNull((List) arrayList30));
            if (example2 != null || (strArrValue = example2.value()) == null) {
                arrayList31 = null;
            } else {
                ArrayList arrayList46 = new ArrayList(strArrValue.length);
                for (String str8 : strArrValue) {
                    arrayList46.add(jsonSchemaFromAnnotations$parseJsonLiteralToGenericElement(str8));
                }
                if (arrayList46.isEmpty()) {
                    arrayList46 = null;
                }
                if (arrayList46 == null || arrayList46.size() <= 1) {
                    arrayList31 = null;
                } else {
                    arrayList31 = arrayList46;
                }
            }
            return new JsonSchema(schemaType2, str4, strValue8, list5, (List) null, list6, referenceOr4, arrayList, map, additionalProperties2, jsonSchemaDiscriminator2, bool, bool2, (Xml) null, (ExternalDocs) null, genericElement3, arrayList31, bool3, numValueOf, numValueOf2, genericElementJsonSchemaFromAnnotations$parseJsonLiteralToGenericElement, str3, referenceOr2, arrayList12, dValueOf, dValueOf2, dValueOf3, dValueOf4, numValueOf3, numValueOf4, strValue, numValueOf5, numValueOf6, bool4, list7, genericElement2, dValueOf5, strValue2, strValue3, bool5, 24592, 0, (DefaultConstructorMarker) null);
        }
        additionalPropertiesM1733boximpl = AdditionalProperties.PSchema.m1740boximpl(AdditionalProperties.PSchema.m1741constructorimpl((ReferenceOr) function1.invoke(Reflection.getOrCreateKotlinClass(additionalPropertiesRef.value()))));
        additionalProperties2 = additionalPropertiesM1733boximpl;
        arrayList2 = new ArrayList();
        while (r13.hasNext()) {
            if (obj10 instanceof JsonSchema.Discriminator) {
                arrayList2.add(obj10);
            }
        }
        discriminator = (JsonSchema.Discriminator) ((Annotation) CollectionsKt.firstOrNull((List) arrayList2));
        if (discriminator != null) {
            String strProperty2 = discriminator.property();
            mappingArrMapping = discriminator.mapping();
            iMapCapacity = MapsKt__MapsKt.mapCapacity(mappingArrMapping.length);
            if (iMapCapacity < 16) {
                iMapCapacity = 16;
            }
            linkedHashMap = new LinkedHashMap(iMapCapacity);
            length3 = mappingArrMapping.length;
            i3 = 0;
            while (i3 < length3) {
                JsonSchema.Discriminator.Mapping mapping2 = mappingArrMapping[i3];
                linkedHashMap.put(mapping2.key(), "#/components/schemas/" + JsonSchemaInference_jvmKt.typeName(mapping2));
                i3++;
                mappingArrMapping = mappingArrMapping;
            }
            jsonSchemaDiscriminator2 = new JsonSchemaDiscriminator(strProperty2, linkedHashMap);
        } else {
            jsonSchemaDiscriminator2 = jsonSchemaDiscriminator;
        }
        arrayList3 = new ArrayList();
        while (r2.hasNext()) {
            if (obj11 instanceof JsonSchema.ReadOnly) {
                arrayList3.add(obj11);
            }
        }
        if (((JsonSchema.ReadOnly) ((Annotation) CollectionsKt.firstOrNull((List) arrayList3))) != null) {
            bool = Boolean.TRUE;
        } else {
            bool = null;
        }
        arrayList4 = new ArrayList();
        while (r2.hasNext()) {
            if (obj12 instanceof JsonSchema.WriteOnly) {
                arrayList4.add(obj12);
            }
        }
        if (((JsonSchema.WriteOnly) ((Annotation) CollectionsKt.firstOrNull((List) arrayList4))) != null) {
            bool2 = Boolean.TRUE;
        } else {
            bool2 = null;
        }
        arrayList5 = new ArrayList();
        while (r2.hasNext()) {
            if (obj13 instanceof JsonSchema.DeprecatedSchema) {
                arrayList5.add(obj13);
            }
        }
        if (((JsonSchema.DeprecatedSchema) ((Annotation) CollectionsKt.firstOrNull((List) arrayList5))) != null) {
            bool3 = Boolean.TRUE;
        } else {
            bool3 = null;
        }
        arrayList6 = new ArrayList();
        while (r2.hasNext()) {
            if (obj14 instanceof JsonSchema.MaxProperties) {
                arrayList6.add(obj14);
            }
        }
        maxProperties = (JsonSchema.MaxProperties) ((Annotation) CollectionsKt.firstOrNull((List) arrayList6));
        if (maxProperties != null) {
            numValueOf = Integer.valueOf(maxProperties.value());
        } else {
            numValueOf = null;
        }
        arrayList7 = new ArrayList();
        while (r2.hasNext()) {
            if (obj15 instanceof JsonSchema.MinProperties) {
                arrayList7.add(obj15);
            }
        }
        minProperties = (JsonSchema.MinProperties) ((Annotation) CollectionsKt.firstOrNull((List) arrayList7));
        if (minProperties != null) {
            numValueOf2 = Integer.valueOf(minProperties.value());
        } else {
            numValueOf2 = null;
        }
        arrayList8 = new ArrayList();
        while (r2.hasNext()) {
            if (obj16 instanceof JsonSchema.Default) {
                arrayList8.add(obj16);
            }
        }
        r1 = (JsonSchema.Default) ((Annotation) CollectionsKt.firstOrNull((List) arrayList8));
        if (r1 != null) {
            genericElementJsonSchemaFromAnnotations$parseJsonLiteralToGenericElement = null;
        } else {
            genericElementJsonSchemaFromAnnotations$parseJsonLiteralToGenericElement = null;
        }
        arrayList9 = new ArrayList();
        while (r2.hasNext()) {
            if (obj17 instanceof JsonSchema.Format) {
                arrayList9.add(obj17);
            }
        }
        format = (JsonSchema.Format) ((Annotation) CollectionsKt.firstOrNull((List) arrayList9));
        if (format != null) {
            str3 = str2;
        } else {
            str3 = str2;
        }
        arrayList10 = new ArrayList();
        while (r2.hasNext()) {
            if (obj18 instanceof JsonSchema.ItemsRef) {
                arrayList10.add(obj18);
            }
        }
        itemsRef = (JsonSchema.ItemsRef) ((Annotation) CollectionsKt.firstOrNull((List) arrayList10));
        if (itemsRef != null) {
            referenceOr2 = referenceOr;
        } else {
            referenceOr2 = referenceOr;
        }
        arrayList11 = new ArrayList();
        while (r2.hasNext()) {
            if (obj19 instanceof JsonSchema.PrefixItemsRef) {
                arrayList11.add(obj19);
            }
        }
        prefixItemsRef = (JsonSchema.PrefixItemsRef) ((Annotation) CollectionsKt.firstOrNull((List) arrayList11));
        if (prefixItemsRef != null) {
            clsArrValue = prefixItemsRef.value();
            ReflectionFactory reflectionFactory3 = Reflection.factory;
            length = clsArrValue.length;
            if (length == 0) {
                kClassArr2 = Reflection.EMPTY_K_CLASS_ARRAY;
            } else {
                kClassArr = new KClass[length];
                while (i < length) {
                    kClassArr[i] = Reflection.getOrCreateKotlinClass(clsArrValue[i]);
                }
                kClassArr2 = kClassArr;
            }
            if (kClassArr2 != null) {
                arrayList32 = new ArrayList(kClassArr2.length);
                length2 = kClassArr2.length;
                i2 = 0;
                while (i2 < length2) {
                    KClass[] kClassArr6 = kClassArr2;
                    arrayList32.add((ReferenceOr) function1.invoke(kClassArr6[i2]));
                    i2++;
                    kClassArr2 = kClassArr6;
                }
                if (arrayList32.isEmpty()) {
                    arrayList12 = arrayList32;
                } else {
                    arrayList12 = null;
                }
            } else {
                arrayList12 = null;
            }
        } else {
            arrayList12 = null;
        }
        arrayList13 = new ArrayList();
        while (r1.hasNext()) {
            if (obj20 instanceof JsonSchema.Maximum) {
                arrayList13.add(obj20);
            }
        }
        maximum = (JsonSchema.Maximum) ((Annotation) CollectionsKt.firstOrNull((List) arrayList13));
        if (maximum == null) {
            dValueOf = null;
        } else {
            if (maximum.exclusive()) {
                maximum = null;
            }
            if (maximum != null) {
                dValueOf = Double.valueOf(maximum.value());
            } else {
                dValueOf = null;
            }
        }
        arrayList14 = new ArrayList();
        while (r1.hasNext()) {
            if (obj21 instanceof JsonSchema.Maximum) {
                arrayList14.add(obj21);
            }
        }
        maximum2 = (JsonSchema.Maximum) ((Annotation) CollectionsKt.firstOrNull((List) arrayList14));
        if (maximum2 == null) {
            dValueOf2 = null;
        } else {
            if (!maximum2.exclusive()) {
                maximum2 = null;
            }
            if (maximum2 != null) {
                dValueOf2 = Double.valueOf(maximum2.value());
            } else {
                dValueOf2 = null;
            }
        }
        arrayList15 = new ArrayList();
        while (r1.hasNext()) {
            if (obj22 instanceof JsonSchema.Minimum) {
                arrayList15.add(obj22);
            }
        }
        minimum = (JsonSchema.Minimum) ((Annotation) CollectionsKt.firstOrNull((List) arrayList15));
        if (minimum == null) {
            dValueOf3 = null;
        } else {
            if (minimum.exclusive()) {
                minimum = null;
            }
            if (minimum != null) {
                dValueOf3 = Double.valueOf(minimum.value());
            } else {
                dValueOf3 = null;
            }
        }
        arrayList16 = new ArrayList();
        while (r1.hasNext()) {
            if (obj23 instanceof JsonSchema.Minimum) {
                arrayList16.add(obj23);
            }
        }
        minimum2 = (JsonSchema.Minimum) ((Annotation) CollectionsKt.firstOrNull((List) arrayList16));
        if (minimum2 == null) {
            dValueOf4 = null;
        } else {
            if (!minimum2.exclusive()) {
                minimum2 = null;
            }
            if (minimum2 != null) {
                dValueOf4 = Double.valueOf(minimum2.value());
            } else {
                dValueOf4 = null;
            }
        }
        arrayList17 = new ArrayList();
        while (r1.hasNext()) {
            if (obj24 instanceof JsonSchema.MaxLength) {
                arrayList17.add(obj24);
            }
        }
        maxLength = (JsonSchema.MaxLength) ((Annotation) CollectionsKt.firstOrNull((List) arrayList17));
        if (maxLength != null) {
            numValueOf3 = Integer.valueOf(maxLength.value());
        } else {
            numValueOf3 = null;
        }
        arrayList18 = new ArrayList();
        while (r1.hasNext()) {
            if (obj25 instanceof JsonSchema.MinLength) {
                arrayList18.add(obj25);
            }
        }
        minLength = (JsonSchema.MinLength) ((Annotation) CollectionsKt.firstOrNull((List) arrayList18));
        if (minLength != null) {
            numValueOf4 = Integer.valueOf(minLength.value());
        } else {
            numValueOf4 = null;
        }
        arrayList19 = new ArrayList();
        while (r1.hasNext()) {
            if (obj26 instanceof JsonSchema.Pattern) {
                arrayList19.add(obj26);
            }
        }
        pattern = (JsonSchema.Pattern) ((Annotation) CollectionsKt.firstOrNull((List) arrayList19));
        if (pattern != null) {
            strValue = pattern.value();
        } else {
            strValue = null;
        }
        arrayList20 = new ArrayList();
        while (r1.hasNext()) {
            if (obj27 instanceof JsonSchema.MaxItems) {
                arrayList20.add(obj27);
            }
        }
        maxItems = (JsonSchema.MaxItems) ((Annotation) CollectionsKt.firstOrNull((List) arrayList20));
        if (maxItems != null) {
            numValueOf5 = Integer.valueOf(maxItems.value());
        } else {
            numValueOf5 = null;
        }
        arrayList21 = new ArrayList();
        while (r1.hasNext()) {
            if (obj28 instanceof JsonSchema.MinItems) {
                arrayList21.add(obj28);
            }
        }
        minItems = (JsonSchema.MinItems) ((Annotation) CollectionsKt.firstOrNull((List) arrayList21));
        if (minItems != null) {
            numValueOf6 = Integer.valueOf(minItems.value());
        } else {
            numValueOf6 = null;
        }
        arrayList22 = new ArrayList();
        while (r1.hasNext()) {
            if (obj29 instanceof JsonSchema.UniqueItems) {
                arrayList22.add(obj29);
            }
        }
        if (((JsonSchema.UniqueItems) ((Annotation) CollectionsKt.firstOrNull((List) arrayList22))) != null) {
            bool4 = Boolean.TRUE;
        } else {
            bool4 = null;
        }
        arrayList23 = new ArrayList();
        while (r1.hasNext()) {
            if (obj30 instanceof JsonSchema.Enum) {
                arrayList23.add(obj30);
            }
        }
        r0 = (JsonSchema.Enum) ((Annotation) CollectionsKt.firstOrNull((List) arrayList23));
        if (r0 != null) {
            list7 = list3;
        } else {
            list7 = list3;
        }
        arrayList24 = new ArrayList();
        while (r1.hasNext()) {
            if (obj31 instanceof JsonSchema.Const) {
                arrayList24.add(obj31);
            }
        }
        r2 = (JsonSchema.Const) ((Annotation) CollectionsKt.firstOrNull((List) arrayList24));
        if (r2 != null) {
            genericElement2 = genericElement;
        } else {
            genericElement2 = genericElement;
        }
        arrayList25 = new ArrayList();
        while (r1.hasNext()) {
            if (obj32 instanceof JsonSchema.MultipleOf) {
                arrayList25.add(obj32);
            }
        }
        multipleOf = (JsonSchema.MultipleOf) ((Annotation) CollectionsKt.firstOrNull((List) arrayList25));
        if (multipleOf != null) {
            dValueOf5 = Double.valueOf(multipleOf.value());
        } else {
            dValueOf5 = null;
        }
        arrayList26 = new ArrayList();
        while (r1.hasNext()) {
            if (obj33 instanceof JsonSchema.Id) {
                arrayList26.add(obj33);
            }
        }
        id = (JsonSchema.Id) ((Annotation) CollectionsKt.firstOrNull((List) arrayList26));
        if (id != null) {
            strValue2 = id.value();
        } else {
            strValue2 = null;
        }
        arrayList27 = new ArrayList();
        while (r1.hasNext()) {
            if (obj34 instanceof JsonSchema.Anchor) {
                arrayList27.add(obj34);
            }
        }
        anchor = (JsonSchema.Anchor) ((Annotation) CollectionsKt.firstOrNull((List) arrayList27));
        if (anchor != null) {
            strValue3 = anchor.value();
        } else {
            strValue3 = null;
        }
        arrayList28 = new ArrayList();
        while (r1.hasNext()) {
            if (obj35 instanceof JsonSchema.Anchor) {
                arrayList28.add(obj35);
            }
        }
        anchor2 = (JsonSchema.Anchor) ((Annotation) CollectionsKt.firstOrNull((List) arrayList28));
        if (anchor2 != null) {
            zDynamic = anchor2.dynamic();
            boolValueOf = Boolean.valueOf(zDynamic);
            if (zDynamic) {
                bool5 = boolValueOf;
            } else {
                bool5 = null;
            }
        } else {
            bool5 = null;
        }
        arrayList29 = new ArrayList();
        while (r1.hasNext()) {
            if (obj36 instanceof JsonSchema.Example) {
                arrayList29.add(obj36);
            }
        }
        example = (JsonSchema.Example) ((Annotation) CollectionsKt.firstOrNull((List) arrayList29));
        if (example != null) {
            genericElement3 = null;
        } else {
            genericElement3 = null;
        }
        arrayList30 = new ArrayList();
        while (r1.hasNext()) {
            if (obj37 instanceof JsonSchema.Example) {
                arrayList30.add(obj37);
            }
        }
        example2 = (JsonSchema.Example) ((Annotation) CollectionsKt.firstOrNull((List) arrayList30));
        if (example2 != null) {
            arrayList31 = null;
        } else {
            arrayList31 = null;
        }
        return new JsonSchema(schemaType2, str4, strValue8, list5, (List) null, list6, referenceOr4, arrayList, map, additionalProperties2, jsonSchemaDiscriminator2, bool, bool2, (Xml) null, (ExternalDocs) null, genericElement3, arrayList31, bool3, numValueOf, numValueOf2, genericElementJsonSchemaFromAnnotations$parseJsonLiteralToGenericElement, str3, referenceOr2, arrayList12, dValueOf, dValueOf2, dValueOf3, dValueOf4, numValueOf3, numValueOf4, strValue, numValueOf5, numValueOf6, bool4, list7, genericElement2, dValueOf5, strValue2, strValue3, bool5, 24592, 0, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ JsonSchema jsonSchemaFromAnnotations$default(List list, Function1 function1, JsonSchema.SchemaType schemaType, String str, List list2, ReferenceOr referenceOr, Map map, AdditionalProperties additionalProperties, List list3, GenericElement genericElement, String str2, JsonSchemaDiscriminator jsonSchemaDiscriminator, List list4, int i, Object obj) {
        if ((i & 8) != 0) {
            str = null;
        }
        if ((i & 16) != 0) {
            list2 = null;
        }
        if ((i & 32) != 0) {
            referenceOr = null;
        }
        if ((i & 64) != 0) {
            map = null;
        }
        if ((i & 128) != 0) {
            additionalProperties = null;
        }
        if ((i & 256) != 0) {
            list3 = null;
        }
        if ((i & 512) != 0) {
            genericElement = null;
        }
        if ((i & 1024) != 0) {
            str2 = null;
        }
        if ((i & 2048) != 0) {
            jsonSchemaDiscriminator = null;
        }
        if ((i & 4096) != 0) {
            list4 = null;
        }
        return jsonSchemaFromAnnotations(list, function1, schemaType, str, list2, referenceOr, map, additionalProperties, list3, genericElement, str2, jsonSchemaDiscriminator, list4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final GenericElement jsonSchemaFromAnnotations$parseJsonLiteralOrUseString(String str) {
        try {
            Json.Default r0 = Json.Default;
            return new JsonGenericElement(r0.parseToJsonElement(str), r0, JsonElement.INSTANCE.serializer());
        } catch (Exception unused) {
            if (str instanceof GenericElement) {
                return (GenericElement) str;
            }
            return str != 0 ? new GenericElementString(str, null, 2, null) : new GenericElementWrapper(str, StringSerializer.INSTANCE);
        }
    }

    private static final GenericElement jsonSchemaFromAnnotations$parseJsonLiteralToGenericElement(String str) {
        Json.Default r0 = Json.Default;
        return new JsonGenericElement(r0.parseToJsonElement(str), r0, JsonElement.INSTANCE.serializer());
    }

    private static final ReferenceOr<JsonSchema> jsonSchemaFromAnnotations$refFromString(String str) {
        String string = StringsKt.trim(str).toString();
        return (StringsKt__StringsJVMKt.startsWith(string, "#/", false) || StringsKt__StringsJVMKt.startsWith(string, "http://", false) || StringsKt__StringsJVMKt.startsWith(string, "https://", false)) ? new ReferenceOr.Reference(string, false, 2, null) : ReferenceOr.Companion.schema$default(ReferenceOr.INSTANCE, string, false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final JsonSchema wrapIfNullable(JsonSchema jsonSchema, boolean z) {
        jsonSchema.getClass();
        if (z) {
            JsonSchema.SchemaType type = jsonSchema.getType();
            if (type instanceof JsonType) {
                return jsonSchema.copy(((-265) & 1) != 0 ? jsonSchema.type : wrapIfNullable((JsonType) type, true), ((-265) & 2) != 0 ? jsonSchema.title : null, ((-265) & 4) != 0 ? jsonSchema.description : null, ((-265) & 8) != 0 ? jsonSchema.required : null, ((-265) & 16) != 0 ? jsonSchema.allOf : null, ((-265) & 32) != 0 ? jsonSchema.oneOf : null, ((-265) & 64) != 0 ? jsonSchema.not : null, ((-265) & 128) != 0 ? jsonSchema.anyOf : null, ((-265) & 256) != 0 ? jsonSchema.properties : null, ((-265) & 512) != 0 ? jsonSchema.additionalProperties : null, ((-265) & 1024) != 0 ? jsonSchema.discriminator : null, ((-265) & 2048) != 0 ? jsonSchema.readOnly : null, ((-265) & 4096) != 0 ? jsonSchema.writeOnly : null, ((-265) & 8192) != 0 ? jsonSchema.xml : null, ((-265) & 16384) != 0 ? jsonSchema.externalDocs : null, ((-265) & 32768) != 0 ? jsonSchema.example : null, ((-265) & 65536) != 0 ? jsonSchema.examples : null, ((-265) & 131072) != 0 ? jsonSchema.deprecated : null, ((-265) & 262144) != 0 ? jsonSchema.maxProperties : null, ((-265) & 524288) != 0 ? jsonSchema.minProperties : null, ((-265) & ByteChannelKt.CHANNEL_MAX_SIZE) != 0 ? jsonSchema.default : null, ((-265) & 2097152) != 0 ? jsonSchema.format : null, ((-265) & 4194304) != 0 ? jsonSchema.items : null, ((-265) & 8388608) != 0 ? jsonSchema.prefixItems : null, ((-265) & 16777216) != 0 ? jsonSchema.maximum : null, ((-265) & 33554432) != 0 ? jsonSchema.exclusiveMaximum : null, ((-265) & 67108864) != 0 ? jsonSchema.minimum : null, ((-265) & 134217728) != 0 ? jsonSchema.exclusiveMinimum : null, ((-265) & WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE) != 0 ? jsonSchema.maxLength : null, ((-265) & 536870912) != 0 ? jsonSchema.minLength : null, ((-265) & 1073741824) != 0 ? jsonSchema.pattern : null, ((-265) & Integer.MIN_VALUE) != 0 ? jsonSchema.maxItems : null, (255 & 1) != 0 ? jsonSchema.minItems : null, (255 & 2) != 0 ? jsonSchema.uniqueItems : null, (255 & 4) != 0 ? jsonSchema.enum : null, (255 & 8) != 0 ? jsonSchema.const : null, (255 & 16) != 0 ? jsonSchema.multipleOf : null, (255 & 32) != 0 ? jsonSchema.id : null, (255 & 64) != 0 ? jsonSchema.anchor : null, (255 & 128) != 0 ? jsonSchema.dynamicAnchor : null);
            }
            if (!(type instanceof JsonSchema.SchemaType.AnyOf)) {
                if (type != null) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                String str = null;
                String str2 = null;
                List list = null;
                List list2 = null;
                List list3 = null;
                ReferenceOr referenceOr = null;
                List list4 = null;
                Map map = null;
                AdditionalProperties additionalProperties = null;
                JsonSchemaDiscriminator jsonSchemaDiscriminator = null;
                Boolean bool = null;
                Boolean bool2 = null;
                Xml xml = null;
                ExternalDocs externalDocs = null;
                GenericElement genericElement = null;
                List list5 = null;
                Boolean bool3 = null;
                Integer num = null;
                Integer num2 = null;
                GenericElement genericElement2 = null;
                String str3 = null;
                ReferenceOr referenceOr2 = null;
                List list6 = null;
                Double d = null;
                Double d2 = null;
                Double d3 = null;
                Double d4 = null;
                Integer num3 = null;
                Integer num4 = null;
                String str4 = null;
                Integer num5 = null;
                Integer num6 = null;
                Boolean bool4 = null;
                List list7 = null;
                GenericElement genericElement3 = null;
                Double d5 = null;
                String str5 = null;
                String str6 = null;
                Boolean bool5 = null;
                int i = -2;
                int i2 = -33;
                return new JsonSchema((JsonSchema.SchemaType) null, (String) null, str, (List) (0 == true ? 1 : 0), list, CollectionsKt__IterablesKt.listOf((Object[]) new ReferenceOr.Value[]{ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(jsonSchema)), ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(new JsonSchema(JsonType.NULL, str, str2, list, list2, list3, referenceOr, list4, map, additionalProperties, jsonSchemaDiscriminator, bool, bool2, xml, externalDocs, genericElement, list5, bool3, num, num2, genericElement2, str3, referenceOr2, list6, d, d2, d3, d4, num3, num4, str4, num5, num6, bool4, list7, genericElement3, d5, str5, str6, bool5, i, 255, (DefaultConstructorMarker) null)))}), (ReferenceOr) (0 == true ? 1 : 0), (List) (0 == true ? 1 : 0), (Map) (0 == true ? 1 : 0), (AdditionalProperties) (0 == true ? 1 : 0), (JsonSchemaDiscriminator) (0 == true ? 1 : 0), (Boolean) (0 == true ? 1 : 0), bool, (Xml) (0 == true ? 1 : 0), (ExternalDocs) (0 == true ? 1 : 0), (GenericElement) (0 == true ? 1 : 0), (List) (0 == true ? 1 : 0), (Boolean) (0 == true ? 1 : 0), (Integer) (0 == true ? 1 : 0), num, (GenericElement) (0 == true ? 1 : 0), (String) (0 == true ? 1 : 0), (ReferenceOr) (0 == true ? 1 : 0), (List) (0 == true ? 1 : 0), (Double) (0 == true ? 1 : 0), d, d2, d3, (Integer) (0 == true ? 1 : 0), num3, (String) (0 == true ? 1 : 0), (Integer) (0 == true ? 1 : 0), num5, (Boolean) (0 == true ? 1 : 0), (List) (0 == true ? 1 : 0), (GenericElement) (0 == true ? 1 : 0), (Double) (0 == true ? 1 : 0), (String) (0 == true ? 1 : 0), str5, (Boolean) (0 == true ? 1 : 0), i2, 255, (DefaultConstructorMarker) null);
            }
            JsonSchema.SchemaType.AnyOf anyOf = (JsonSchema.SchemaType.AnyOf) type;
            List<JsonType> types = anyOf.getTypes();
            JsonType jsonType = JsonType.NULL;
            if (!types.contains(jsonType)) {
                return jsonSchema.copy(((-265) & 1) != 0 ? jsonSchema.type : new JsonSchema.SchemaType.AnyOf(CollectionsKt.plus(jsonType, anyOf.getTypes())), ((-265) & 2) != 0 ? jsonSchema.title : null, ((-265) & 4) != 0 ? jsonSchema.description : null, ((-265) & 8) != 0 ? jsonSchema.required : null, ((-265) & 16) != 0 ? jsonSchema.allOf : null, ((-265) & 32) != 0 ? jsonSchema.oneOf : null, ((-265) & 64) != 0 ? jsonSchema.not : null, ((-265) & 128) != 0 ? jsonSchema.anyOf : null, ((-265) & 256) != 0 ? jsonSchema.properties : null, ((-265) & 512) != 0 ? jsonSchema.additionalProperties : null, ((-265) & 1024) != 0 ? jsonSchema.discriminator : null, ((-265) & 2048) != 0 ? jsonSchema.readOnly : null, ((-265) & 4096) != 0 ? jsonSchema.writeOnly : null, ((-265) & 8192) != 0 ? jsonSchema.xml : null, ((-265) & 16384) != 0 ? jsonSchema.externalDocs : null, ((-265) & 32768) != 0 ? jsonSchema.example : null, ((-265) & 65536) != 0 ? jsonSchema.examples : null, ((-265) & 131072) != 0 ? jsonSchema.deprecated : null, ((-265) & 262144) != 0 ? jsonSchema.maxProperties : null, ((-265) & 524288) != 0 ? jsonSchema.minProperties : null, ((-265) & ByteChannelKt.CHANNEL_MAX_SIZE) != 0 ? jsonSchema.default : null, ((-265) & 2097152) != 0 ? jsonSchema.format : null, ((-265) & 4194304) != 0 ? jsonSchema.items : null, ((-265) & 8388608) != 0 ? jsonSchema.prefixItems : null, ((-265) & 16777216) != 0 ? jsonSchema.maximum : null, ((-265) & 33554432) != 0 ? jsonSchema.exclusiveMaximum : null, ((-265) & 67108864) != 0 ? jsonSchema.minimum : null, ((-265) & 134217728) != 0 ? jsonSchema.exclusiveMinimum : null, ((-265) & WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE) != 0 ? jsonSchema.maxLength : null, ((-265) & 536870912) != 0 ? jsonSchema.minLength : null, ((-265) & 1073741824) != 0 ? jsonSchema.pattern : null, ((-265) & Integer.MIN_VALUE) != 0 ? jsonSchema.maxItems : null, (255 & 1) != 0 ? jsonSchema.minItems : null, (255 & 2) != 0 ? jsonSchema.uniqueItems : null, (255 & 4) != 0 ? jsonSchema.enum : null, (255 & 8) != 0 ? jsonSchema.const : null, (255 & 16) != 0 ? jsonSchema.multipleOf : null, (255 & 32) != 0 ? jsonSchema.id : null, (255 & 64) != 0 ? jsonSchema.anchor : null, (255 & 128) != 0 ? jsonSchema.dynamicAnchor : null);
            }
        }
        return jsonSchema;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ReferenceOr<JsonSchema> wrapIfNullable(ReferenceOr<JsonSchema> referenceOr, boolean z) {
        referenceOr.getClass();
        if (!z) {
            return referenceOr;
        }
        List list = null;
        Boolean bool = null;
        Integer num = null;
        Double d = null;
        Double d2 = null;
        Double d3 = null;
        Integer num2 = null;
        Integer num3 = null;
        String str = null;
        return ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(new JsonSchema((JsonSchema.SchemaType) null, (String) null, (String) null, (List) (0 == true ? 1 : 0), list, CollectionsKt__IterablesKt.listOf((Object[]) new ReferenceOr[]{referenceOr, ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(new JsonSchema(JsonType.NULL, (String) null, (String) null, list, (List) null, (List) null, (ReferenceOr) null, (List) null, (Map) null, (AdditionalProperties) null, (JsonSchemaDiscriminator) null, bool, (Boolean) null, (Xml) null, (ExternalDocs) null, (GenericElement) null, (List) null, (Boolean) null, num, (Integer) null, (GenericElement) null, (String) null, (ReferenceOr) null, (List) null, d, d2, d3, (Double) null, num2, (Integer) null, (String) null, num3, (Integer) null, (Boolean) null, (List) null, (GenericElement) null, (Double) null, str, (String) null, (Boolean) null, -2, 255, (DefaultConstructorMarker) null)))}), (ReferenceOr) (0 == true ? 1 : 0), (List) (0 == true ? 1 : 0), (Map) (0 == true ? 1 : 0), (AdditionalProperties) (0 == true ? 1 : 0), (JsonSchemaDiscriminator) (0 == true ? 1 : 0), (Boolean) (0 == true ? 1 : 0), bool, (Xml) (0 == true ? 1 : 0), (ExternalDocs) (0 == true ? 1 : 0), (GenericElement) (0 == true ? 1 : 0), (List) (0 == true ? 1 : 0), (Boolean) (0 == true ? 1 : 0), (Integer) (0 == true ? 1 : 0), num, (GenericElement) (0 == true ? 1 : 0), (String) (0 == true ? 1 : 0), (ReferenceOr) (0 == true ? 1 : 0), (List) (0 == true ? 1 : 0), (Double) (0 == true ? 1 : 0), d, d2, d3, (Integer) (0 == true ? 1 : 0), num2, (String) (0 == true ? 1 : 0), (Integer) (0 == true ? 1 : 0), num3, (Boolean) (0 == true ? 1 : 0), (List) (0 == true ? 1 : 0), (GenericElement) (0 == true ? 1 : 0), (Double) (0 == true ? 1 : 0), (String) (0 == true ? 1 : 0), str, (Boolean) (0 == true ? 1 : 0), -33, 255, (DefaultConstructorMarker) null)));
    }

    public static final JsonSchema.SchemaType wrapIfNullable(JsonType jsonType, boolean z) {
        jsonType.getClass();
        return z ? new JsonSchema.SchemaType.AnyOf(CollectionsKt__IterablesKt.listOf((Object[]) new JsonType[]{jsonType, JsonType.NULL})) : jsonType;
    }
}
