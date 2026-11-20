package kotlinx.serialization.json;

import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface JsonDecoder extends Decoder, CompositeDecoder {
    JsonElement decodeJsonElement();

    Json getJson();
}
