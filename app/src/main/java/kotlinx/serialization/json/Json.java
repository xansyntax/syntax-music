package kotlinx.serialization.json;

import io.ktor.http.LinkHeader;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.internal.CharArrayPool;
import kotlinx.serialization.json.internal.StreamingJsonDecoder;
import kotlinx.serialization.json.internal.StringJsonLexer;
import kotlinx.serialization.json.internal.WriteMode;
import kotlinx.serialization.json.internal.WriteModeKt;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;
import okhttp3.ConnectionPool;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Json implements StringFormat {
    public static final Default Default = new Default(new JsonConfiguration(false, false, false, false, false, true, "    ", LinkHeader.Parameters.Type, false, true, ClassDiscriminatorMode.POLYMORPHIC, true), SerializersModuleKt.EmptySerializersModule);
    public final ConnectionPool _schemaCache = new ConnectionPool((byte) 19);
    public final JsonConfiguration configuration;
    public final SerializersModule serializersModule;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Default extends Json {
    }

    public Json(JsonConfiguration jsonConfiguration, SerializersModule serializersModule) {
        this.configuration = jsonConfiguration;
        this.serializersModule = serializersModule;
    }

    public final Object decodeFromString(DeserializationStrategy deserializationStrategy, String str) {
        deserializationStrategy.getClass();
        str.getClass();
        StringJsonLexer StringJsonLexer = WriteModeKt.StringJsonLexer(this, str);
        Object objDecodeSerializableValue = new StreamingJsonDecoder(this, WriteMode.OBJ, StringJsonLexer, deserializationStrategy.getDescriptor(), null).decodeSerializableValue(deserializationStrategy);
        StringJsonLexer.expectEof();
        return objDecodeSerializableValue;
    }

    public final String encodeToString(SerializationStrategy serializationStrategy, Object obj) {
        serializationStrategy.getClass();
        PriorityQueue priorityQueue = new PriorityQueue((byte) 12, false);
        priorityQueue.array = CharArrayPool.INSTANCE.take(128);
        try {
            WriteModeKt.encodeByWriter(this, priorityQueue, serializationStrategy, obj);
            return priorityQueue.toString();
        } finally {
            CharArrayPool charArrayPool = CharArrayPool.INSTANCE;
            char[] cArr = (char[]) priorityQueue.array;
            charArrayPool.getClass();
            cArr.getClass();
            charArrayPool.releaseImpl(cArr);
        }
    }

    public final JsonElement parseToJsonElement(String str) {
        str.getClass();
        return (JsonElement) decodeFromString(JsonElementSerializer.INSTANCE, str);
    }
}
