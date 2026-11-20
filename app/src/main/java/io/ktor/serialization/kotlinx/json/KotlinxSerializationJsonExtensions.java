package io.ktor.serialization.kotlinx.json;

import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.content.ChannelWriterContent;
import io.ktor.serialization.JsonConvertException;
import io.ktor.serialization.kotlinx.KotlinxSerializationExtension;
import io.ktor.serialization.kotlinx.SerializerLookupKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import kotlinx.coroutines.flow.Flow;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J8\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015JB\u0010\u0010\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0082@¢\u0006\u0004\b\u0010\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR$\u0010!\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lio/ktor/serialization/kotlinx/json/KotlinxSerializationJsonExtensions;", "Lio/ktor/serialization/kotlinx/KotlinxSerializationExtension;", "Lkotlinx/serialization/json/Json;", "format", "<init>", "(Lkotlinx/serialization/json/Json;)V", "Lio/ktor/http/ContentType;", "contentType", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "", "value", "Lio/ktor/http/content/OutgoingContent;", "serialize", "(Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "content", "deserialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/serialization/KSerializer;", "serializer", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/serialization/KSerializer;Ljava/nio/charset/Charset;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/serialization/json/Json;", "", "Lio/ktor/serialization/kotlinx/json/JsonArraySymbols;", "jsonArraySymbolsMap", "Ljava/util/Map;", "ktor-serialization-kotlinx-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KotlinxSerializationJsonExtensions implements KotlinxSerializationExtension {
    private final Json format;
    private final Map<Charset, JsonArraySymbols> jsonArraySymbolsMap;

    /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$deserialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions", f = "KotlinxSerializationJsonExtensions.kt", l = {70}, m = "deserialize", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinxSerializationJsonExtensions.this.deserialize(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ByteWriteChannel;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$2", f = "KotlinxSerializationJsonExtensions.kt", l = {55}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ Charset $charset;
        final /* synthetic */ KSerializer $serializer;
        final /* synthetic */ Object $value;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object obj, KSerializer kSerializer, Charset charset, Continuation continuation) {
            super(2, continuation);
            this.$value = obj;
            this.$serializer = kSerializer;
            this.$charset = charset;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = KotlinxSerializationJsonExtensions.this.new AnonymousClass2(this.$value, this.$serializer, this.$charset, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ByteWriteChannel byteWriteChannel, Continuation continuation) {
            return ((AnonymousClass2) create(byteWriteChannel, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ByteWriteChannel byteWriteChannel = (ByteWriteChannel) this.L$0;
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions = KotlinxSerializationJsonExtensions.this;
                Object obj2 = this.$value;
                obj2.getClass();
                KSerializer kSerializer = this.$serializer;
                kSerializer.getClass();
                Charset charset = this.$charset;
                this.L$0 = null;
                this.label = 1;
                Object objSerialize = kotlinxSerializationJsonExtensions.serialize((Flow) obj2, kSerializer, charset, byteWriteChannel, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objSerialize == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions", f = "KotlinxSerializationJsonExtensions.kt", l = {83, 124, 92}, m = "serialize", v = 1)
    public static final class AnonymousClass3<T> extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinxSerializationJsonExtensions.this.serialize((Flow) null, (KSerializer) null, (Charset) null, (ByteWriteChannel) null, this);
        }
    }

    public KotlinxSerializationJsonExtensions(Json json) {
        json.getClass();
        this.format = json;
        this.jsonArraySymbolsMap = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0108, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeFully$default(r3, r4, 0, 0, r8, 6, null) == r14) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object serialize(Flow flow, KSerializer kSerializer, Charset charset, ByteWriteChannel byteWriteChannel, Continuation continuation) {
        AnonymousClass3 anonymousClass3;
        AnonymousClass3 anonymousClass4;
        Charset charset2;
        Flow flow2;
        KSerializer kSerializer2;
        JsonArraySymbols jsonArraySymbols;
        ByteWriteChannel byteWriteChannel2;
        ByteWriteChannel byteWriteChannel3;
        JsonArraySymbols jsonArraySymbols2;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            int i = anonymousClass3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        } else {
            anonymousClass3 = new AnonymousClass3(continuation);
        }
        AnonymousClass3 anonymousClass5 = anonymousClass3;
        Object obj = anonymousClass5.result;
        int i2 = anonymousClass5.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Map<Charset, JsonArraySymbols> map = this.jsonArraySymbolsMap;
            JsonArraySymbols jsonArraySymbols3 = map.get(charset);
            if (jsonArraySymbols3 == null) {
                jsonArraySymbols3 = new JsonArraySymbols(charset);
                map.put(charset, jsonArraySymbols3);
            }
            JsonArraySymbols jsonArraySymbols4 = jsonArraySymbols3;
            byte[] beginArray = jsonArraySymbols4.getBeginArray();
            anonymousClass5.L$0 = flow;
            anonymousClass5.L$1 = kSerializer;
            anonymousClass5.L$2 = charset;
            anonymousClass5.L$3 = byteWriteChannel;
            anonymousClass5.L$4 = jsonArraySymbols4;
            anonymousClass5.label = 1;
            anonymousClass4 = anonymousClass5;
            if (ByteWriteChannelOperationsKt.writeFully$default(byteWriteChannel, beginArray, 0, 0, anonymousClass4, 6, null) != coroutineSingletons) {
                charset2 = charset;
                flow2 = flow;
                kSerializer2 = kSerializer;
                jsonArraySymbols = jsonArraySymbols4;
                byteWriteChannel2 = byteWriteChannel;
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            JsonArraySymbols jsonArraySymbols5 = (JsonArraySymbols) anonymousClass5.L$4;
            ByteWriteChannel byteWriteChannel4 = (ByteWriteChannel) anonymousClass5.L$3;
            Charset charset3 = (Charset) anonymousClass5.L$2;
            KSerializer kSerializer3 = (KSerializer) anonymousClass5.L$1;
            flow2 = (Flow) anonymousClass5.L$0;
            ResultKt.throwOnFailure(obj);
            charset2 = charset3;
            kSerializer2 = kSerializer3;
            byteWriteChannel2 = byteWriteChannel4;
            anonymousClass4 = anonymousClass5;
            jsonArraySymbols = jsonArraySymbols5;
        } else if (i2 == 2) {
            jsonArraySymbols2 = (JsonArraySymbols) anonymousClass5.L$4;
            ByteWriteChannel byteWriteChannel5 = (ByteWriteChannel) anonymousClass5.L$3;
            ResultKt.throwOnFailure(obj);
            byteWriteChannel3 = byteWriteChannel5;
            anonymousClass4 = anonymousClass5;
            byte[] endArray = jsonArraySymbols2.getEndArray();
            anonymousClass4.L$0 = null;
            anonymousClass4.L$1 = null;
            anonymousClass4.L$2 = null;
            anonymousClass4.L$3 = null;
            anonymousClass4.L$4 = null;
            anonymousClass4.L$5 = null;
            anonymousClass4.label = 3;
        } else {
            if (i2 != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 = new KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1(byteWriteChannel2, jsonArraySymbols, this, kSerializer2, charset2);
        anonymousClass4.L$0 = null;
        anonymousClass4.L$1 = null;
        anonymousClass4.L$2 = null;
        anonymousClass4.L$3 = byteWriteChannel2;
        anonymousClass4.L$4 = jsonArraySymbols;
        anonymousClass4.L$5 = null;
        anonymousClass4.I$0 = 0;
        anonymousClass4.label = 2;
        if (flow2.collect(kotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1, anonymousClass4) != coroutineSingletons) {
            byteWriteChannel3 = byteWriteChannel2;
            jsonArraySymbols2 = jsonArraySymbols;
            byte[] endArray2 = jsonArraySymbols2.getEndArray();
            anonymousClass4.L$0 = null;
            anonymousClass4.L$1 = null;
            anonymousClass4.L$2 = null;
            anonymousClass4.L$3 = null;
            anonymousClass4.L$4 = null;
            anonymousClass4.L$5 = null;
            anonymousClass4.label = 3;
        }
        return coroutineSingletons;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // io.ktor.serialization.kotlinx.KotlinxSerializationExtension
    public Object deserialize(Charset charset, TypeInfo typeInfo, ByteReadChannel byteReadChannel, Continuation continuation) throws JsonConvertException {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        try {
            if (i2 != 0) {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            if (!Intrinsics.areEqual(charset, Charsets.UTF_8) || !Intrinsics.areEqual(typeInfo.getType(), Reflection.getOrCreateKotlinClass(Sequence.class))) {
                return null;
            }
            Json json = this.format;
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = null;
            anonymousClass1.label = 1;
            Object objDeserializeSequence = JsonExtensionsJvmKt.deserializeSequence(json, byteReadChannel, typeInfo, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return objDeserializeSequence == coroutineSingletons ? coroutineSingletons : objDeserializeSequence;
        } catch (Throwable th) {
            throw new JsonConvertException("Illegal input: " + th.getMessage(), th);
        }
    }

    @Override // io.ktor.serialization.kotlinx.KotlinxSerializationExtension
    public Object serialize(ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj, Continuation continuation) {
        if (!Intrinsics.areEqual(charset, Charsets.UTF_8) || !Intrinsics.areEqual(typeInfo.getType(), Reflection.getOrCreateKotlinClass(Flow.class))) {
            return null;
        }
        return new ChannelWriterContent(new AnonymousClass2(obj, SerializerLookupKt.serializerForTypeInfo(this.format.serializersModule, KotlinxSerializationJsonExtensionsKt.argumentTypeInfo(typeInfo)), charset, null), ContentTypesKt.withCharsetIfNeeded(contentType, charset), null, null, 12, null);
    }
}
