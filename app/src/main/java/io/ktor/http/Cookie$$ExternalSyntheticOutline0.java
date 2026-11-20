package io.ktor.http;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpStatement;
import java.util.Map;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class Cookie$$ExternalSyntheticOutline0 {
    public static /* synthetic */ byte getLevelInt(int i) {
        if (i == 1) {
            return (byte) 0;
        }
        if (i == 2) {
            return (byte) 1;
        }
        if (i == 3) {
            return (byte) 2;
        }
        if (i == 4) {
            return (byte) 3;
        }
        throw null;
    }

    public static String m(StringBuilder sb, Map map, char c) {
        sb.append(map);
        sb.append(c);
        return sb.toString();
    }

    public static Object m(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }
}
