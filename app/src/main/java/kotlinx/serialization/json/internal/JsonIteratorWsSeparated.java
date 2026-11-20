package kotlinx.serialization.json.internal;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class JsonIteratorWsSeparated implements Iterator, KMappedMarker {
    public final DeserializationStrategy deserializer;
    public final Json json;
    public final ReaderJsonLexer lexer;

    public JsonIteratorWsSeparated(Json json, ReaderJsonLexer readerJsonLexer, DeserializationStrategy deserializationStrategy) {
        this.json = json;
        this.lexer = readerJsonLexer;
        this.deserializer = deserializationStrategy;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.lexer.peekNextToken() != 10;
    }

    @Override // java.util.Iterator
    public final Object next() {
        DeserializationStrategy deserializationStrategy = this.deserializer;
        return new StreamingJsonDecoder(this.json, WriteMode.OBJ, this.lexer, deserializationStrategy.getDescriptor(), null).decodeSerializableValue(deserializationStrategy);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
