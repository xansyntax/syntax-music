package io.ktor.serialization.kotlinx;

import com.yalantis.ucrop.UCrop;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.LinkHeader;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.openapi.JsonSchema;
import io.ktor.openapi.JsonSchemaInference;
import io.ktor.openapi.KotlinxSerializerJsonSchemaInference;
import io.ktor.serialization.ContentConverter;
import io.ktor.serialization.JsonConvertException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.StringsKt__Strings_jvmKt;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.reflect.KType;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.io.Buffer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J.\u0010\u001a\u001a\u0004\u0018\u00010\u00132\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJA\u0010\u001f\u001a\u00020\u001e2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001c2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010!R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006("}, d2 = {"Lio/ktor/serialization/kotlinx/KotlinxSerializationConverter;", "Lio/ktor/serialization/ContentConverter;", "Lio/ktor/openapi/JsonSchemaInference;", "Lkotlinx/serialization/SerialFormat;", "format", "<init>", "(Lkotlinx/serialization/SerialFormat;)V", "Lkotlin/reflect/KType;", LinkHeader.Parameters.Type, "Lio/ktor/openapi/JsonSchema;", "buildSchema", "(Lkotlin/reflect/KType;)Lio/ktor/openapi/JsonSchema;", "Lio/ktor/http/ContentType;", "contentType", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "", "value", "Lio/ktor/http/content/OutgoingContent;", "serialize", "(Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "content", "deserialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/serialization/KSerializer;", "serializer", "Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "serializeContent", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/SerialFormat;Ljava/lang/Object;Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;)Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "Lkotlinx/serialization/SerialFormat;", "", "Lio/ktor/serialization/kotlinx/KotlinxSerializationExtension;", "extensions", "Ljava/util/List;", "schemaInference", "Lio/ktor/openapi/JsonSchemaInference;", "ktor-serialization-kotlinx"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KotlinxSerializationConverter implements ContentConverter, JsonSchemaInference {
    private final List<KotlinxSerializationExtension> extensions;
    private final SerialFormat format;
    private final JsonSchemaInference schemaInference;

    /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter", f = "KotlinxSerializationConverter.kt", l = {UCrop.REQUEST_CROP, 72}, m = "deserialize", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinxSerializationConverter.this.deserialize(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter", f = "KotlinxSerializationConverter.kt", l = {56}, m = "serialize", v = 1)
    public static final class C03201 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C03201(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinxSerializationConverter.this.serialize(null, null, null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KotlinxSerializationConverter(SerialFormat serialFormat) {
        serialFormat.getClass();
        this.format = serialFormat;
        this.extensions = ExtensionsKt.extensions(serialFormat);
        this.schemaInference = new KotlinxSerializerJsonSchemaInference(((Json) serialFormat).serializersModule, null, 2, 0 == true ? 1 : 0);
        if (serialFormat instanceof StringFormat) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m("Only binary and string formats are supported, ", serialFormat, " is not supported.");
        throw null;
    }

    private final OutgoingContent.ByteArrayContent serializeContent(KSerializer serializer, SerialFormat format, Object value, ContentType contentType, Charset charset) {
        if (!(format instanceof StringFormat)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3(format, "Unsupported format ");
            return null;
        }
        serializer.getClass();
        return new TextContent(((Json) ((StringFormat) format)).encodeToString(serializer, value), ContentTypesKt.withCharsetIfNeeded(contentType, charset), null, 4, null);
    }

    @Override // io.ktor.openapi.JsonSchemaInference
    public JsonSchema buildSchema(KType type) {
        type.getClass();
        return this.schemaInference.buildSchema(type);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x007e  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b1 A[Catch: all -> 0x00e3, TryCatch #0 {all -> 0x00e3, blocks: (B:29:0x00ab, B:31:0x00b1, B:33:0x00c1, B:34:0x00e2), top: B:38:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00c1 A[Catch: all -> 0x00e3, TryCatch #0 {all -> 0x00e3, blocks: (B:29:0x00ab, B:31:0x00b1, B:33:0x00c1, B:34:0x00e2), top: B:38:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0069, code lost:
    
        if (r11 == r5) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009a, code lost:
    
        if (r11 == r5) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009c, code lost:
    
        return r5;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:33:0x00c1, please report this as an issue */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x009a -> B:25:0x009d). Please report as a decompilation issue!!! */
    @Override // io.ktor.serialization.ContentConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deserialize(Charset charset, TypeInfo typeInfo, ByteReadChannel byteReadChannel, Continuation continuation) throws JsonConvertException {
        AnonymousClass1 anonymousClass1;
        Charset charset2;
        Iterator<KotlinxSerializationExtension> it;
        TypeInfo typeInfo2;
        Buffer buffer;
        KSerializer kSerializerSerializerForTypeInfo;
        SerialFormat serialFormat;
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
        Object buffer2 = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 != 0) {
            if (i2 == 1) {
                typeInfo = (TypeInfo) anonymousClass1.L$1;
                charset = (Charset) anonymousClass1.L$0;
                ResultKt.throwOnFailure(buffer2);
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                it = (Iterator) anonymousClass1.L$4;
                buffer = (Buffer) anonymousClass1.L$3;
                typeInfo2 = (TypeInfo) anonymousClass1.L$1;
                charset2 = (Charset) anonymousClass1.L$0;
                ResultKt.throwOnFailure(buffer2);
            }
            if (buffer2 != null) {
                return buffer2;
            }
            if (it.hasNext()) {
                kSerializerSerializerForTypeInfo = SerializerLookupKt.serializerForTypeInfo(((Json) this.format).serializersModule, typeInfo2);
                try {
                    serialFormat = this.format;
                    if (serialFormat instanceof StringFormat) {
                        return ((Json) ((StringFormat) serialFormat)).decodeFromString(kSerializerSerializerForTypeInfo, StringsKt__Strings_jvmKt.readText$default(buffer, charset2, 0, 2, null));
                    }
                    ByteReadPacketKt.discard$default(buffer, 0L, 1, null);
                    throw new IllegalStateException(("Unsupported format " + this.format).toString());
                } catch (Throwable th) {
                    throw new JsonConvertException("Illegal input: " + th.getMessage(), th);
                }
            }
            KotlinxSerializationExtension next = it.next();
            ByteReadChannel ByteReadChannel = ByteChannelCtorKt.ByteReadChannel(buffer);
            anonymousClass1.L$0 = charset2;
            anonymousClass1.L$1 = typeInfo2;
            anonymousClass1.L$2 = null;
            anonymousClass1.L$3 = buffer;
            anonymousClass1.L$4 = it;
            anonymousClass1.L$5 = null;
            anonymousClass1.label = 2;
            buffer2 = next.deserialize(charset2, typeInfo2, ByteReadChannel, anonymousClass1);
        } else {
            ResultKt.throwOnFailure(buffer2);
            anonymousClass1.L$0 = charset;
            anonymousClass1.L$1 = typeInfo;
            anonymousClass1.L$2 = null;
            anonymousClass1.label = 1;
            buffer2 = ByteReadChannelOperationsKt.readBuffer(byteReadChannel, anonymousClass1);
        }
        charset2 = charset;
        it = this.extensions.iterator();
        typeInfo2 = typeInfo;
        buffer = (Buffer) buffer2;
        if (it.hasNext()) {
            kSerializerSerializerForTypeInfo = SerializerLookupKt.serializerForTypeInfo(((Json) this.format).serializersModule, typeInfo2);
            serialFormat = this.format;
            if (serialFormat instanceof StringFormat) {
                return ((Json) ((StringFormat) serialFormat)).decodeFromString(kSerializerSerializerForTypeInfo, StringsKt__Strings_jvmKt.readText$default(buffer, charset2, 0, 2, null));
            }
            ByteReadPacketKt.discard$default(buffer, 0L, 1, null);
            throw new IllegalStateException(("Unsupported format " + this.format).toString());
        }
        KotlinxSerializationExtension next2 = it.next();
        ByteReadChannel ByteReadChannel2 = ByteChannelCtorKt.ByteReadChannel(buffer);
        anonymousClass1.L$0 = charset2;
        anonymousClass1.L$1 = typeInfo2;
        anonymousClass1.L$2 = null;
        anonymousClass1.L$3 = buffer;
        anonymousClass1.L$4 = it;
        anonymousClass1.L$5 = null;
        anonymousClass1.label = 2;
        buffer2 = next2.deserialize(charset2, typeInfo2, ByteReadChannel2, anonymousClass1);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // io.ktor.serialization.ContentConverter
    public Object serialize(final ContentType contentType, final Charset charset, final TypeInfo typeInfo, final Object obj, Continuation continuation) {
        C03201 c03201;
        ContentType contentType2;
        Charset charset2;
        TypeInfo typeInfo2;
        Object obj2;
        KSerializer kSerializerGuessSerializer;
        if (continuation instanceof C03201) {
            c03201 = (C03201) continuation;
            int i = c03201.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03201.label = i - Integer.MIN_VALUE;
            } else {
                c03201 = new C03201(continuation);
            }
        } else {
            c03201 = new C03201(continuation);
        }
        Object objFirstOrNull = c03201.result;
        int i2 = c03201.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFirstOrNull);
            final SafeFlow safeFlow = new SafeFlow((byte) 3, this.extensions);
            Flow flow = new Flow() { // from class: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1

                /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ Charset $charset$inlined;
                    final /* synthetic */ ContentType $contentType$inlined;
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ TypeInfo $typeInfo$inlined;
                    final /* synthetic */ Object $value$inlined;

                    /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                    @DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$$inlined$map$1$2", f = "KotlinxSerializationConverter.kt", l = {218, 217}, m = "emit", v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        int I$1;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        Object L$5;
                        Object L$6;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj) {
                        this.$this_unsafeFlow = flowCollector;
                        this.$contentType$inlined = contentType;
                        this.$charset$inlined = charset;
                        this.$typeInfo$inlined = typeInfo;
                        this.$value$inlined = obj;
                    }

                    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
                    /* JADX WARN: Code restructure failed: missing block: B:22:0x009a, code lost:
                    
                        if (r12.emit(r13, r6) == r9) goto L23;
                     */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        int i;
                        FlowCollector flowCollector;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            int i2 = anonymousClass1.label;
                            if ((i2 & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i2 - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                        AnonymousClass1 anonymousClass2 = anonymousClass1;
                        Object obj2 = anonymousClass2.result;
                        int i3 = anonymousClass2.label;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (i3 != 0) {
                            if (i3 == 1) {
                                i = anonymousClass2.I$0;
                                flowCollector = (FlowCollector) anonymousClass2.L$4;
                                ResultKt.throwOnFailure(obj2);
                            } else {
                                if (i3 != 2) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                    return null;
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector2 = this.$this_unsafeFlow;
                        ContentType contentType = this.$contentType$inlined;
                        Charset charset = this.$charset$inlined;
                        TypeInfo typeInfo = this.$typeInfo$inlined;
                        Object obj3 = this.$value$inlined;
                        anonymousClass2.L$0 = null;
                        anonymousClass2.L$1 = null;
                        anonymousClass2.L$2 = null;
                        anonymousClass2.L$3 = null;
                        anonymousClass2.L$4 = flowCollector2;
                        anonymousClass2.L$5 = null;
                        anonymousClass2.L$6 = null;
                        i = 0;
                        anonymousClass2.I$0 = 0;
                        anonymousClass2.I$1 = 0;
                        anonymousClass2.label = 1;
                        Object objSerialize = ((KotlinxSerializationExtension) obj).serialize(contentType, charset, typeInfo, obj3, anonymousClass2);
                        if (objSerialize != coroutineSingletons) {
                            obj2 = objSerialize;
                            flowCollector = flowCollector2;
                        }
                        return coroutineSingletons;
                        anonymousClass2.L$0 = null;
                        anonymousClass2.L$1 = null;
                        anonymousClass2.L$2 = null;
                        anonymousClass2.L$3 = null;
                        anonymousClass2.L$4 = null;
                        anonymousClass2.L$5 = null;
                        anonymousClass2.L$6 = null;
                        anonymousClass2.I$0 = i;
                        anonymousClass2.label = 2;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector flowCollector, Continuation continuation2) {
                    Object objCollect = safeFlow.collect(new AnonymousClass2(flowCollector, contentType, charset, typeInfo, obj), continuation2);
                    return objCollect == CoroutineSingletons.COROUTINE_SUSPENDED ? objCollect : Unit.INSTANCE;
                }
            };
            KotlinxSerializationConverter$serialize$fromExtension$2 kotlinxSerializationConverter$serialize$fromExtension$2 = new KotlinxSerializationConverter$serialize$fromExtension$2(null);
            c03201.L$0 = contentType;
            c03201.L$1 = charset;
            c03201.L$2 = typeInfo;
            c03201.L$3 = obj;
            c03201.label = 1;
            objFirstOrNull = StateFlowKt.firstOrNull(flow, kotlinxSerializationConverter$serialize$fromExtension$2, c03201);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objFirstOrNull == coroutineSingletons) {
                return coroutineSingletons;
            }
            contentType2 = contentType;
            charset2 = charset;
            typeInfo2 = typeInfo;
            obj2 = obj;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Object obj3 = c03201.L$3;
            typeInfo2 = (TypeInfo) c03201.L$2;
            Charset charset3 = (Charset) c03201.L$1;
            ContentType contentType3 = (ContentType) c03201.L$0;
            ResultKt.throwOnFailure(objFirstOrNull);
            contentType2 = contentType3;
            charset2 = charset3;
            obj2 = obj3;
        }
        OutgoingContent outgoingContent = (OutgoingContent) objFirstOrNull;
        if (outgoingContent != null) {
            return outgoingContent;
        }
        try {
            kSerializerGuessSerializer = SerializerLookupKt.serializerForTypeInfo(((Json) this.format).serializersModule, typeInfo2);
        } catch (SerializationException unused) {
            kSerializerGuessSerializer = SerializerLookupKt.guessSerializer(obj2, ((Json) this.format).serializersModule);
        }
        return serializeContent(kSerializerGuessSerializer, this.format, obj2, contentType2, charset2);
    }
}
