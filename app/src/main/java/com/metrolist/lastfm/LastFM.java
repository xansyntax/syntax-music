package com.metrolist.lastfm;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.kugou.KuGouKt$$ExternalSyntheticLambda0;
import com.metrolist.lastfm.models.Authentication;
import com.metrolist.lastfm.models.LastFmError;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.request.forms.FormDataContent;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.builders.MapBuilder;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LastFM {
    public static String sessionKey;
    public static final LastFM INSTANCE = new LastFM();
    public static final JsonImpl json = UuidKt.Json$default(new KuGouKt$$ExternalSyntheticLambda0(6));
    public static final SynchronizedLazyImpl client$delegate = new SynchronizedLazyImpl(new LastFM$$ExternalSyntheticLambda1((byte) 0));
    public static String API_KEY = "";
    public static String SECRET = "";

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LastFmException extends Exception {
        public final int code;
        public final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LastFmException(int i, String str) {
            super(str);
            str.getClass();
            this.code = i;
            this.message = str;
        }

        @Override // java.lang.Throwable
        public final String getMessage() {
            return this.message;
        }

        @Override // java.lang.Throwable
        public final String toString() {
            return "LastFmException(code=" + this.code + ", message=" + this.message + ")";
        }
    }

    public static void lastfmParams$default(LastFM lastFM, HttpRequestBuilder httpRequestBuilder, String str, String str2, String str3, String str4, Map map, int i) throws NoSuchAlgorithmException {
        if ((i & 8) != 0) {
            str4 = null;
        }
        HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getFormUrlEncoded());
        HttpMessagePropertiesKt.userAgent(httpRequestBuilder, "Metrolist (https://github.com/MetrolistGroup/Metrolist)");
        Pair[] pairArr = {new Pair("method", str), new Pair("api_key", str2)};
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(2));
        MapsKt__MapsKt.putAll(linkedHashMap, pairArr);
        if (str4 != null) {
        }
        linkedHashMap.putAll(map);
        Set setEntrySet = new TreeMap(linkedHashMap).entrySet();
        setEntrySet.getClass();
        String strM = Fragment$5$$ExternalSyntheticOutline0.m(CollectionsKt.joinToString$default(setEntrySet, "", null, null, new KuGouKt$$ExternalSyntheticLambda0((byte) 10), 30), str3);
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = strM.getBytes(Charsets.UTF_8);
        bytes.getClass();
        byte[] bArrDigest = messageDigest.digest(bytes);
        bArrDigest.getClass();
        String strJoinToString$default = ArraysKt.joinToString$default(bArrDigest, "", new KuGouKt$$ExternalSyntheticLambda0((byte) 11), 30);
        Parameters.Companion companion = Parameters.INSTANCE;
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            parametersBuilderParametersBuilder$default.append((String) entry.getKey(), (String) entry.getValue());
        }
        parametersBuilderParametersBuilder$default.append("api_sig", strJoinToString$default);
        parametersBuilderParametersBuilder$default.append("format", "json");
        httpRequestBuilder.setBody(new FormDataContent(parametersBuilderParametersBuilder$default.build()));
        httpRequestBuilder.setBodyType(null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0097, code lost:
    
        if (r0 == r13) goto L24;
     */
    /* JADX INFO: renamed from: getMobileSession-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1050getMobileSession0E7RQCE(String str, String str2, ContinuationImpl continuationImpl) {
        LastFM$getMobileSession$1 lastFM$getMobileSession$1;
        LastFM lastFM;
        if (continuationImpl instanceof LastFM$getMobileSession$1) {
            lastFM$getMobileSession$1 = (LastFM$getMobileSession$1) continuationImpl;
            int i = lastFM$getMobileSession$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                lastFM$getMobileSession$1.label = i - Integer.MIN_VALUE;
                lastFM = this;
            } else {
                lastFM = this;
                lastFM$getMobileSession$1 = new LastFM$getMobileSession$1(lastFM, continuationImpl);
            }
        } else {
            lastFM = this;
            lastFM$getMobileSession$1 = new LastFM$getMobileSession$1(lastFM, continuationImpl);
        }
        Object objExecute = lastFM$getMobileSession$1.result;
        int i2 = lastFM$getMobileSession$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute);
                HttpClient httpClient = (HttpClient) client$delegate.getValue();
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpMethod httpMethod = HttpMethod.Post;
                httpRequestBuilder.setMethod(httpMethod);
                lastfmParams$default(lastFM, httpRequestBuilder, "auth.getMobileSession", API_KEY, SECRET, null, MapsKt__MapsKt.mapOf(new Pair("username", str), new Pair("password", str2)), 40);
                UtilsKt.parameter(httpRequestBuilder, "format", "json");
                httpRequestBuilder.setMethod(httpMethod);
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                lastFM$getMobileSession$1.label = 1;
                objExecute = httpStatement.execute(lastFM$getMobileSession$1);
                if (objExecute == coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i2 == 1) {
                ResultKt.throwOnFailure(objExecute);
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objExecute);
            }
            String str3 = (String) objExecute;
            boolean zContains = StringsKt.contains(str3, "\"error\"", false);
            JsonImpl jsonImpl = json;
            if (!zContains) {
                jsonImpl.getClass();
                return (Authentication) jsonImpl.decodeFromString(Authentication.INSTANCE.serializer(), str3);
            }
            jsonImpl.getClass();
            LastFmError lastFmError = (LastFmError) jsonImpl.decodeFromString(LastFmError.INSTANCE.serializer(), str3);
            throw new LastFmException(lastFmError.error, lastFmError.message);
            lastFM$getMobileSession$1.label = 2;
            objExecute = HttpResponseKt.bodyAsText$default((HttpResponse) objExecute, null, lastFM$getMobileSession$1, 1, null);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX INFO: renamed from: scrobble-bMdYcbs, reason: not valid java name */
    public final Object m1051scrobblebMdYcbs(String str, String str2, long j, String str3, Integer num, ContinuationImpl continuationImpl) {
        LastFM$scrobble$1 lastFM$scrobble$1;
        if (continuationImpl instanceof LastFM$scrobble$1) {
            lastFM$scrobble$1 = (LastFM$scrobble$1) continuationImpl;
            int i = lastFM$scrobble$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                lastFM$scrobble$1.label = i - Integer.MIN_VALUE;
            } else {
                lastFM$scrobble$1 = new LastFM$scrobble$1(this, continuationImpl);
            }
        } else {
            lastFM$scrobble$1 = new LastFM$scrobble$1(this, continuationImpl);
        }
        Object objExecute = lastFM$scrobble$1.result;
        int i2 = lastFM$scrobble$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute);
                HttpClient httpClient = (HttpClient) client$delegate.getValue();
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpMethod httpMethod = HttpMethod.Post;
                httpRequestBuilder.setMethod(httpMethod);
                String str4 = API_KEY;
                String str5 = SECRET;
                String str6 = sessionKey;
                str6.getClass();
                MapBuilder mapBuilder = new MapBuilder();
                mapBuilder.put("artist[0]", str);
                mapBuilder.put("track[0]", str2);
                mapBuilder.put("timestamp[0]", String.valueOf(j));
                if (str3 != null) {
                }
                if (num != null) {
                    mapBuilder.put("duration[0]", String.valueOf(num.intValue()));
                }
                lastfmParams$default(this, httpRequestBuilder, "track.scrobble", str4, str5, str6, mapBuilder.build(), 32);
                UtilsKt.parameter(httpRequestBuilder, "format", "json");
                httpRequestBuilder.setMethod(httpMethod);
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                lastFM$scrobble$1.label = 1;
                objExecute = httpStatement.execute(lastFM$scrobble$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objExecute == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objExecute);
            }
            return (HttpResponse) objExecute;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: setLoveStatus-BWLJW6A, reason: not valid java name */
    public final Object m1052setLoveStatusBWLJW6A(String str, String str2, boolean z, ContinuationImpl continuationImpl) {
        LastFM$setLoveStatus$1 lastFM$setLoveStatus$1;
        if (continuationImpl instanceof LastFM$setLoveStatus$1) {
            lastFM$setLoveStatus$1 = (LastFM$setLoveStatus$1) continuationImpl;
            int i = lastFM$setLoveStatus$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                lastFM$setLoveStatus$1.label = i - Integer.MIN_VALUE;
            } else {
                lastFM$setLoveStatus$1 = new LastFM$setLoveStatus$1(this, continuationImpl);
            }
        } else {
            lastFM$setLoveStatus$1 = new LastFM$setLoveStatus$1(this, continuationImpl);
        }
        Object objExecute = lastFM$setLoveStatus$1.result;
        int i2 = lastFM$setLoveStatus$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute);
                String str3 = z ? "track.love" : "track.unlove";
                HttpClient httpClient = (HttpClient) client$delegate.getValue();
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpMethod httpMethod = HttpMethod.Post;
                httpRequestBuilder.setMethod(httpMethod);
                String str4 = API_KEY;
                String str5 = SECRET;
                String str6 = sessionKey;
                str6.getClass();
                MapBuilder mapBuilder = new MapBuilder();
                mapBuilder.put("artist", str);
                mapBuilder.put("track", str2);
                lastfmParams$default(this, httpRequestBuilder, str3, str4, str5, str6, mapBuilder.build(), 32);
                UtilsKt.parameter(httpRequestBuilder, "format", "json");
                httpRequestBuilder.setMethod(httpMethod);
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                lastFM$setLoveStatus$1.label = 1;
                objExecute = httpStatement.execute(lastFM$setLoveStatus$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objExecute == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objExecute);
            }
            return (HttpResponse) objExecute;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX INFO: renamed from: updateNowPlaying-hUnOzRk, reason: not valid java name */
    public final Object m1053updateNowPlayinghUnOzRk(String str, String str2, String str3, Integer num, ContinuationImpl continuationImpl) {
        LastFM$updateNowPlaying$1 lastFM$updateNowPlaying$1;
        if (continuationImpl instanceof LastFM$updateNowPlaying$1) {
            lastFM$updateNowPlaying$1 = (LastFM$updateNowPlaying$1) continuationImpl;
            int i = lastFM$updateNowPlaying$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                lastFM$updateNowPlaying$1.label = i - Integer.MIN_VALUE;
            } else {
                lastFM$updateNowPlaying$1 = new LastFM$updateNowPlaying$1(this, continuationImpl);
            }
        } else {
            lastFM$updateNowPlaying$1 = new LastFM$updateNowPlaying$1(this, continuationImpl);
        }
        Object objExecute = lastFM$updateNowPlaying$1.result;
        int i2 = lastFM$updateNowPlaying$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute);
                HttpClient httpClient = (HttpClient) client$delegate.getValue();
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpMethod httpMethod = HttpMethod.Post;
                httpRequestBuilder.setMethod(httpMethod);
                String str4 = API_KEY;
                String str5 = SECRET;
                String str6 = sessionKey;
                str6.getClass();
                MapBuilder mapBuilder = new MapBuilder();
                mapBuilder.put("artist", str);
                mapBuilder.put("track", str2);
                if (str3 != null) {
                }
                if (num != null) {
                    mapBuilder.put("duration", String.valueOf(num.intValue()));
                }
                lastfmParams$default(this, httpRequestBuilder, "track.updateNowPlaying", str4, str5, str6, mapBuilder.build(), 32);
                UtilsKt.parameter(httpRequestBuilder, "format", "json");
                httpRequestBuilder.setMethod(httpMethod);
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                lastFM$updateNowPlaying$1.label = 1;
                objExecute = httpStatement.execute(lastFM$updateNowPlaying$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objExecute == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objExecute);
            }
            return (HttpResponse) objExecute;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }
}
