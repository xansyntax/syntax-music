package kotlinx.serialization.json.internal;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class JsonIteratorArrayWrapped implements Iterator, KMappedMarker {
    public final DeserializationStrategy deserializer;
    public boolean finished;
    public boolean first = true;
    public final Json json;
    public final ReaderJsonLexer lexer;

    public JsonIteratorArrayWrapped(Json json, ReaderJsonLexer readerJsonLexer, DeserializationStrategy deserializationStrategy) {
        this.json = json;
        this.lexer = readerJsonLexer;
        this.deserializer = deserializationStrategy;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.finished) {
            return false;
        }
        ReaderJsonLexer readerJsonLexer = this.lexer;
        if (readerJsonLexer.peekNextToken() == 9) {
            this.finished = true;
            readerJsonLexer.consumeNextToken((byte) 9);
            if (readerJsonLexer.peekNextToken() == 10) {
                return false;
            }
            if (readerJsonLexer.peekNextToken() != 8) {
                readerJsonLexer.expectEof();
                return false;
            }
            AbstractJsonLexer.fail$default(readerJsonLexer, "There is a start of the new array after the one parsed to sequence. ARRAY_WRAPPED mode doesn't merge consecutive arrays.\nIf you need to parse a stream of arrays, please use WHITESPACE_SEPARATED mode instead.", 0, null, 6);
            throw null;
        }
        if (readerJsonLexer.peekNextToken() != 10 || this.finished) {
            return true;
        }
        String str = WriteModeKt.tokenDescription((byte) 9);
        int i = readerJsonLexer.currentPosition;
        int i2 = i > 0 ? i - 1 : i;
        ArrayAsSequence arrayAsSequence = readerJsonLexer.source;
        AbstractJsonLexer.fail$default(readerJsonLexer, Fragment$5$$ExternalSyntheticOutline0.m("Expected ", str, ", but had '", (i == arrayAsSequence.length || i2 < 0) ? "EOF" : String.valueOf(arrayAsSequence.buffer[i2]), "' instead"), i2, null, 4);
        throw null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        boolean z = this.first;
        ReaderJsonLexer readerJsonLexer = this.lexer;
        if (z) {
            this.first = false;
        } else {
            readerJsonLexer.consumeNextToken(',');
        }
        DeserializationStrategy deserializationStrategy = this.deserializer;
        return new StreamingJsonDecoder(this.json, WriteMode.OBJ, readerJsonLexer, deserializationStrategy.getDescriptor(), null).decodeSerializableValue(deserializationStrategy);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
