package io.ktor.serialization.kotlinx.json;

import io.ktor.serialization.kotlinx.SerializerLookupKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.InputStream;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1;
import kotlin.text.Charsets;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.DecodeSequenceMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.internal.CharsetReader;
import kotlinx.serialization.json.internal.JsonIteratorArrayWrapped;
import kotlinx.serialization.json.internal.JsonIteratorWsSeparated;
import kotlinx.serialization.json.internal.ReaderJsonLexer;
import kotlinx.serialization.json.internal.WriteModeKt;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a2\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0080@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/serialization/json/Json;", "format", "Lio/ktor/utils/io/ByteReadChannel;", "content", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "Lkotlin/sequences/Sequence;", "", "deserializeSequence", "(Lkotlinx/serialization/json/Json;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/util/reflect/TypeInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-serialization-kotlinx-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JsonExtensionsJvmKt {
    public static final Object deserializeSequence(Json json, ByteReadChannel byteReadChannel, TypeInfo typeInfo, Continuation continuation) {
        DecodeSequenceMode decodeSequenceMode;
        Iterator jsonIteratorWsSeparated;
        InputStream inputStream$default = BlockingKt.toInputStream$default(byteReadChannel, null, 1, null);
        KSerializer kSerializerSerializerForTypeInfo = SerializerLookupKt.serializerForTypeInfo(json.serializersModule, KotlinxSerializationJsonExtensionsKt.argumentTypeInfo(typeInfo));
        inputStream$default.getClass();
        kSerializerSerializerForTypeInfo.getClass();
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.delegate = new CharsetReader(inputStream$default, Charsets.UTF_8);
        ReaderJsonLexer ReaderJsonLexer = WriteModeKt.ReaderJsonLexer(json, connectionPool, new char[16384]);
        if (ReaderJsonLexer.peekNextToken() == 8) {
            ReaderJsonLexer.consumeNextToken((byte) 8);
            decodeSequenceMode = DecodeSequenceMode.ARRAY_WRAPPED;
        } else {
            decodeSequenceMode = DecodeSequenceMode.WHITESPACE_SEPARATED;
        }
        int iOrdinal = decodeSequenceMode.ordinal();
        if (iOrdinal == 0) {
            jsonIteratorWsSeparated = new JsonIteratorWsSeparated(json, ReaderJsonLexer, kSerializerSerializerForTypeInfo);
        } else {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("AbstractJsonLexer.determineFormat must be called beforehand.");
                return null;
            }
            jsonIteratorWsSeparated = new JsonIteratorArrayWrapped(json, ReaderJsonLexer, kSerializerSerializerForTypeInfo);
        }
        return SequencesKt.constrainOnce(new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(jsonIteratorWsSeparated, (byte) 1));
    }
}
