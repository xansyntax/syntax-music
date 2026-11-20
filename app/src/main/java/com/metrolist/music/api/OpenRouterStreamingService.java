package com.metrolist.music.api;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.kugou.KuGouKt$$ExternalSyntheticLambda0;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.text.Regex;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OpenRouterStreamingService {
    public static final OkHttpClient client;
    public static final JsonImpl json;
    public static final MediaType jsonMediaType;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface StreamChunk {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Complete implements StreamChunk {
            public final List translatedLines;

            public Complete(List list) {
                this.translatedLines = list;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Complete) && this.translatedLines.equals(((Complete) obj).translatedLines);
            }

            public final int hashCode() {
                return this.translatedLines.hashCode();
            }

            public final String toString() {
                return Fragment$5$$ExternalSyntheticOutline0.m("Complete(translatedLines=", ")", this.translatedLines);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Content implements StreamChunk {
            public final String text;

            public Content(String str) {
                this.text = str;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Content) && this.text.equals(((Content) obj).text);
            }

            public final int hashCode() {
                return this.text.hashCode();
            }

            public final String toString() {
                return IntIntPair$$ExternalSyntheticOutline0.m("Content(text=", this.text, ")");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Error implements StreamChunk {
            public final String message;

            public Error(String str) {
                this.message = str;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Error) && this.message.equals(((Error) obj).message);
            }

            public final int hashCode() {
                return this.message.hashCode();
            }

            public final String toString() {
                return IntIntPair$$ExternalSyntheticOutline0.m("Error(message=", this.message, ")");
            }
        }
    }

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(30L, timeUnit);
        builder.readTimeout(120L, timeUnit);
        builder.writeTimeout(30L, timeUnit);
        client = new OkHttpClient(builder);
        Regex regex = MediaType.TYPE_SUBTYPE;
        jsonMediaType = CollectionsKt__IterablesKt.get("application/json; charset=utf-8");
        json = UuidKt.Json$default(new KuGouKt$$ExternalSyntheticLambda0((byte) 28));
    }
}
