package io.ktor.serialization.kotlinx.json;

import dagger.hilt.EntryPoints;
import io.ktor.http.ContentType;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.content.ChannelWriterContent;
import io.ktor.serialization.ContentConverter;
import io.ktor.serialization.JsonConvertException;
import io.ktor.serialization.kotlinx.SerializerLookupKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.io.Buffer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.internal.WriteModeKt;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/serialization/kotlinx/json/ExperimentalJsonConverter;", "Lio/ktor/serialization/ContentConverter;", "Lkotlinx/serialization/json/Json;", "format", "<init>", "(Lkotlinx/serialization/json/Json;)V", "Lio/ktor/http/ContentType;", "contentType", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "", "value", "Lio/ktor/http/content/OutgoingContent;", "serialize", "(Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "content", "deserialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/serialization/json/Json;", "ktor-serialization-kotlinx-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExperimentalJsonConverter implements ContentConverter {
    private final Json format;

    /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.json.ExperimentalJsonConverter$deserialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.json.ExperimentalJsonConverter", f = "ExperimentalJsonConverter.kt", l = {58}, m = "deserialize", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExperimentalJsonConverter.this.deserialize(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.serialization.kotlinx.json.ExperimentalJsonConverter$serialize$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ByteWriteChannel;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.json.ExperimentalJsonConverter$serialize$2", f = "ExperimentalJsonConverter.kt", l = {}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ Buffer $buffer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Buffer buffer, Continuation continuation) {
            super(2, continuation);
            this.$buffer = buffer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$buffer, continuation);
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
            if (this.label != 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            byteWriteChannel.getWriteBuffer().transferFrom(this.$buffer.copy());
            return Unit.INSTANCE;
        }
    }

    public ExperimentalJsonConverter(Json json) {
        json.getClass();
        this.format = json;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // io.ktor.serialization.ContentConverter
    public Object deserialize(Charset charset, TypeInfo typeInfo, ByteReadChannel byteReadChannel, Continuation continuation) throws JsonConvertException {
        AnonymousClass1 anonymousClass1;
        KSerializer kSerializerSerializerForTypeInfo;
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
        Object buffer = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(buffer);
            kSerializerSerializerForTypeInfo = SerializerLookupKt.serializerForTypeInfo(this.format.serializersModule, typeInfo);
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = null;
            anonymousClass1.L$3 = kSerializerSerializerForTypeInfo;
            anonymousClass1.label = 1;
            buffer = ByteReadChannelOperationsKt.readBuffer(byteReadChannel, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (buffer == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            kSerializerSerializerForTypeInfo = (KSerializer) anonymousClass1.L$3;
            ResultKt.throwOnFailure(buffer);
        }
        try {
            return EntryPoints.decodeFromSource(this.format, kSerializerSerializerForTypeInfo, (Buffer) buffer);
        } catch (Throwable th) {
            throw new JsonConvertException("Illegal input: " + th.getMessage(), th);
        }
    }

    @Override // io.ktor.serialization.ContentConverter
    public Object serialize(ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj, Continuation continuation) {
        KSerializer kSerializerGuessSerializer;
        try {
            kSerializerGuessSerializer = SerializerLookupKt.serializerForTypeInfo(this.format.serializersModule, typeInfo);
        } catch (SerializationException unused) {
            kSerializerGuessSerializer = SerializerLookupKt.guessSerializer(obj, this.format.serializersModule);
        }
        Buffer buffer = new Buffer();
        Json json = this.format;
        kSerializerGuessSerializer.getClass();
        json.getClass();
        WriteModeKt.encodeByWriter(json, new ConnectionPool(buffer), kSerializerGuessSerializer, obj);
        return new ChannelWriterContent(new AnonymousClass2(buffer, null), contentType, null, new Long(ByteReadPacketKt.getRemaining(buffer)), 4, null);
    }
}
