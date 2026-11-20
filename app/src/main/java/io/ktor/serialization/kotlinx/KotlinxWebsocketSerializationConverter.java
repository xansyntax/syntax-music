package io.ktor.serialization.kotlinx;

import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketConverterNotFoundException;
import io.ktor.serialization.WebsocketDeserializeException;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.Frame;
import io.ktor.websocket.FrameCommonKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\u000e\u001a\u00020\r2\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u0019\u001a\u00020\r2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/ktor/serialization/kotlinx/KotlinxWebsocketSerializationConverter;", "Lio/ktor/serialization/WebsocketContentConverter;", "Lkotlinx/serialization/SerialFormat;", "format", "<init>", "(Lkotlinx/serialization/SerialFormat;)V", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "", "value", "Lio/ktor/websocket/Frame;", "serialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "content", "deserialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "frame", "", "isApplicable", "(Lio/ktor/websocket/Frame;)Z", "Lkotlinx/serialization/KSerializer;", "serializer", "serializeContent", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/SerialFormat;Ljava/lang/Object;)Lio/ktor/websocket/Frame;", "Lkotlinx/serialization/SerialFormat;", "ktor-serialization-kotlinx"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KotlinxWebsocketSerializationConverter implements WebsocketContentConverter {
    private final SerialFormat format;

    public KotlinxWebsocketSerializationConverter(SerialFormat serialFormat) {
        serialFormat.getClass();
        this.format = serialFormat;
        if (serialFormat instanceof StringFormat) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m("Only binary and string formats are supported, ", serialFormat, " is not supported.");
        throw null;
    }

    private final Frame serializeContent(KSerializer serializer, SerialFormat format, Object value) {
        if (!(format instanceof StringFormat)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3(format, "Unsupported format ");
            return null;
        }
        serializer.getClass();
        return new Frame.Text(((Json) ((StringFormat) format)).encodeToString(serializer, value));
    }

    @Override // io.ktor.serialization.WebsocketContentConverter
    public Object deserialize(Charset charset, TypeInfo typeInfo, Frame frame, Continuation continuation) throws WebsocketDeserializeException, WebsocketConverterNotFoundException {
        if (!isApplicable(frame)) {
            throw new WebsocketConverterNotFoundException("Unsupported frame " + frame.getFrameType().name(), null, 2, null);
        }
        KSerializer kSerializerSerializerForTypeInfo = SerializerLookupKt.serializerForTypeInfo(((Json) this.format).serializersModule, typeInfo);
        SerialFormat serialFormat = this.format;
        if (!(serialFormat instanceof StringFormat)) {
            PathKt$$ExternalSyntheticBUOutline0.m((Object) this.format, "Unsupported format ");
            return null;
        }
        if (frame instanceof Frame.Text) {
            return ((Json) ((StringFormat) serialFormat)).decodeFromString(kSerializerSerializerForTypeInfo, FrameCommonKt.readText((Frame.Text) frame));
        }
        StringBuilder sb = new StringBuilder("Unsupported format ");
        sb.append(this.format);
        String strName = frame.getFrameType().name();
        sb.append(" for ");
        sb.append(strName);
        throw new WebsocketDeserializeException(sb.toString(), null, frame, 2, null);
    }

    @Override // io.ktor.serialization.WebsocketContentConverter
    public boolean isApplicable(Frame frame) {
        frame.getClass();
        return (frame instanceof Frame.Text) || (frame instanceof Frame.Binary);
    }

    @Override // io.ktor.serialization.WebsocketContentConverter
    public Object serialize(Charset charset, TypeInfo typeInfo, Object obj, Continuation continuation) {
        KSerializer kSerializerGuessSerializer;
        try {
            kSerializerGuessSerializer = SerializerLookupKt.serializerForTypeInfo(((Json) this.format).serializersModule, typeInfo);
        } catch (SerializationException unused) {
            kSerializerGuessSerializer = SerializerLookupKt.guessSerializer(obj, ((Json) this.format).serializersModule);
        }
        return serializeContent(kSerializerGuessSerializer, this.format, obj);
    }
}
