package okhttp3.internal.cache;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Latch;
import androidx.room.concurrent.FileLock;
import dagger.hilt.EntryPoints;
import io.ktor.http.HttpHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.ResponseBody$Companion$asResponseBody$1;
import okhttp3.TrailersSource;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http.DateFormattingKt;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSink;
import okio.Okio__OkioKt;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class CacheInterceptor implements Interceptor {
    /* JADX WARN: Code duplicated, block: B:109:0x0295  */
    /* JADX WARN: Code duplicated, block: B:112:0x029d  */
    /* JADX WARN: Code duplicated, block: B:115:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:116:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:122:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:125:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:127:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:129:0x02db  */
    /* JADX WARN: Code duplicated, block: B:137:0x031d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:138:0x031f  */
    /* JADX WARN: Code duplicated, block: B:139:0x0323 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:140:0x0325  */
    /* JADX WARN: Code duplicated, block: B:142:0x032a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x032c  */
    /* JADX WARN: Code duplicated, block: B:145:0x0352  */
    /* JADX WARN: Code duplicated, block: B:155:0x037e  */
    /* JADX WARN: Code duplicated, block: B:240:0x057d  */
    /* JADX WARN: Code duplicated, block: B:259:0x05d4  */
    /* JADX WARN: Code duplicated, block: B:261:0x0609  */
    /* JADX WARN: Code duplicated, block: B:34:0x010c  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) {
        Response response;
        int i;
        long j;
        long time;
        Date httpDateOrNull;
        Date httpDateOrNull2;
        Date httpDateOrNull3;
        String str;
        String str2;
        String str3;
        FileLock fileLock;
        long j2;
        long time2;
        String string;
        int i2;
        int i3;
        long millis;
        long millis2;
        String str4;
        String str5;
        long j3;
        Response.Builder builderNewBuilder;
        int i4;
        Response response2;
        final Cache.RealCacheRequest realCacheRequest;
        Latch latchEdit;
        Latch latchEdit2;
        Cache cache = realInterceptorChain.cache;
        if (cache != null) {
            Request request = realInterceptorChain.request;
            request.getClass();
            HttpUrl httpUrl = request.url;
            try {
                DiskLruCache.Snapshot snapshot = cache.cache.get(CharsKt.key(httpUrl));
                if (snapshot == null) {
                    response = null;
                } else {
                    try {
                        Cache.Entry entry = new Cache.Entry((Source) snapshot.sources.get(0));
                        String str6 = entry.requestMethod;
                        Headers headers = entry.varyHeaders;
                        HttpUrl httpUrl2 = entry.url;
                        Headers headers2 = entry.responseHeaders;
                        String str7 = headers2.get(HttpHeaders.ContentType);
                        String str8 = headers2.get(HttpHeaders.ContentLength);
                        httpUrl2.getClass();
                        headers.getClass();
                        str6.getClass();
                        Request.Builder builder = new Request.Builder();
                        builder.url = httpUrl2;
                        builder.headers = EntryPoints.commonNewBuilder(headers);
                        builder.method(!str6.equals("\u0000") ? str6 : "GET", null);
                        Request request2 = new Request(builder);
                        ResponseBody$Companion$asResponseBody$1 responseBody$Companion$asResponseBody$1 = ResponseBody.EMPTY;
                        Protocol.Companion companion = TrailersSource.EMPTY;
                        new Headers.Builder((byte) 0);
                        Protocol protocol = entry.protocol;
                        protocol.getClass();
                        int i5 = entry.code;
                        String str9 = entry.message;
                        str9.getClass();
                        Headers.Builder builderCommonNewBuilder = EntryPoints.commonNewBuilder(headers2);
                        Cache.CacheResponseBody cacheResponseBody = new Cache.CacheResponseBody(snapshot, str7, str8);
                        Handshake handshake = entry.handshake;
                        long j4 = entry.sentRequestMillis;
                        long j5 = entry.receivedResponseMillis;
                        if (i5 < 0) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) IntIntPair$$ExternalSyntheticOutline0.m(i5, "code < 0: "));
                            return null;
                        }
                        response = new Response(request2, protocol, str9, i5, handshake, EntryPoints.commonBuild(builderCommonNewBuilder), cacheResponseBody, null, null, null, null, j4, j5, null, companion);
                        if (httpUrl2.equals(httpUrl) && str6.equals(request.method)) {
                            Set setVaryFields = CharsKt.varyFields(response.headers);
                            if (!(setVaryFields instanceof Collection) || !setVaryFields.isEmpty()) {
                                Iterator it = setVaryFields.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        String str10 = (String) it.next();
                                        if (!headers.values(str10).equals(request.headers.values(str10))) {
                                        }
                                    }
                                }
                            }
                        }
                        _UtilCommonKt.closeQuietly(response.body);
                        response = null;
                    } catch (IOException unused) {
                        _UtilCommonKt.closeQuietly(snapshot);
                    }
                }
            } catch (IOException unused2) {
            }
        } else {
            response = null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Request request3 = realInterceptorChain.request;
        request3.getClass();
        if (response != null) {
            j = response.sentRequestAtMillis;
            time = response.receivedResponseAtMillis;
            Headers headers3 = response.headers;
            int size = headers3.size();
            httpDateOrNull = null;
            httpDateOrNull2 = null;
            httpDateOrNull3 = null;
            str = null;
            str2 = null;
            str3 = null;
            int nonNegativeInt = -1;
            for (int i6 = 0; i6 < size; i6++) {
                String strCommonName = EntryPoints.commonName(headers3, i6);
                String strCommonValue = EntryPoints.commonValue(headers3, i6);
                if (strCommonName.equalsIgnoreCase(HttpHeaders.Date)) {
                    httpDateOrNull3 = DateFormattingKt.toHttpDateOrNull(strCommonValue);
                    str3 = strCommonValue;
                } else if (strCommonName.equalsIgnoreCase(HttpHeaders.Expires)) {
                    httpDateOrNull = DateFormattingKt.toHttpDateOrNull(strCommonValue);
                } else if (strCommonName.equalsIgnoreCase(HttpHeaders.LastModified)) {
                    httpDateOrNull2 = DateFormattingKt.toHttpDateOrNull(strCommonValue);
                    str2 = strCommonValue;
                } else if (strCommonName.equalsIgnoreCase(HttpHeaders.ETag)) {
                    str = strCommonValue;
                } else if (strCommonName.equalsIgnoreCase(HttpHeaders.Age)) {
                    nonNegativeInt = _UtilCommonKt.toNonNegativeInt(-1, strCommonValue);
                }
            }
            i = nonNegativeInt;
        } else {
            i = -1;
            j = 0;
            time = 0;
            httpDateOrNull = null;
            httpDateOrNull2 = null;
            httpDateOrNull3 = null;
            str = null;
            str2 = null;
            str3 = null;
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        if (response == null) {
            fileLock = new FileLock(request3, (Object) null);
        } else {
            HttpUrl httpUrl3 = request3.url;
            Headers headers4 = request3.headers;
            if (!(httpUrl3.isHttps() && response.handshake == null) && HexFormatKt.isCacheable(response, request3)) {
                CacheControl cacheControl = request3.lazyCacheControl;
                if (cacheControl == null) {
                    int i7 = CacheControl.$r8$clinit;
                    cacheControl = HexFormatKt.parse(request3.headers);
                    request3.lazyCacheControl = cacheControl;
                }
                if (!cacheControl.noCache && headers4.get(HttpHeaders.IfModifiedSince) == null && headers4.get(HttpHeaders.IfNoneMatch) == null) {
                    CacheControl cacheControl2 = response.cacheControl();
                    long jMax = httpDateOrNull3 != null ? Math.max(0L, time - httpDateOrNull3.getTime()) : 0L;
                    if (i != -1) {
                        jMax = Math.max(jMax, timeUnit.toMillis(i));
                    }
                    long jMax2 = jMax + Math.max(0L, time - j) + Math.max(0L, jCurrentTimeMillis - time);
                    int i8 = response.cacheControl().maxAgeSeconds;
                    if (i8 != -1) {
                        time2 = timeUnit.toMillis(i8);
                    } else {
                        if (httpDateOrNull != null) {
                            if (httpDateOrNull3 != null) {
                                time = httpDateOrNull3.getTime();
                            }
                            time2 = httpDateOrNull.getTime() - time;
                            if (time2 <= 0) {
                                time2 = 0;
                            }
                        } else if (httpDateOrNull2 == null) {
                            j2 = 0;
                            time2 = j2;
                        } else {
                            List list = response.request.url.queryNamesAndValues;
                            if (list == null) {
                                string = null;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                Okio__OkioKt.toQueryString(sb, list);
                                string = sb.toString();
                            }
                            if (string == null) {
                                long time3 = (httpDateOrNull3 != null ? httpDateOrNull3.getTime() : j) - httpDateOrNull2.getTime();
                                j2 = 0;
                                if (time3 > 0) {
                                    time2 = time3 / 10;
                                }
                            } else {
                                j2 = 0;
                            }
                            time2 = j2;
                        }
                        i2 = cacheControl.maxAgeSeconds;
                        if (i2 != -1) {
                            time2 = Math.min(time2, timeUnit.toMillis(i2));
                        }
                        i3 = cacheControl.minFreshSeconds;
                        if (i3 != -1) {
                            millis = timeUnit.toMillis(i3);
                        } else {
                            millis = j2;
                        }
                        if (!cacheControl2.mustRevalidate || (i4 = cacheControl.maxStaleSeconds) == -1) {
                            millis2 = j2;
                        } else {
                            millis2 = timeUnit.toMillis(i4);
                        }
                        if (cacheControl2.noCache) {
                            if (str != null) {
                                str5 = HttpHeaders.IfNoneMatch;
                                str4 = str;
                            } else {
                                if (httpDateOrNull2 != null) {
                                    str4 = str2;
                                } else if (httpDateOrNull3 != null) {
                                    str4 = str3;
                                } else {
                                    fileLock = new FileLock(request3, (Object) null);
                                }
                                str5 = HttpHeaders.IfModifiedSince;
                            }
                            Headers.Builder builderCommonNewBuilder2 = EntryPoints.commonNewBuilder(headers4);
                            str4.getClass();
                            EntryPoints.commonAddLenient(builderCommonNewBuilder2, str5, str4);
                            Request.Builder builderNewBuilder2 = request3.newBuilder();
                            builderNewBuilder2.headers = EntryPoints.commonNewBuilder(EntryPoints.commonBuild(builderCommonNewBuilder2));
                            fileLock = new FileLock(new Request(builderNewBuilder2), response);
                        } else {
                            j3 = jMax2 + millis;
                            if (j3 < millis2 + time2) {
                                builderNewBuilder = response.newBuilder();
                                if (j3 >= time2) {
                                    Headers.Builder builder2 = builderNewBuilder.headers;
                                    builder2.getClass();
                                    EntryPoints.headersCheckName(HttpHeaders.Warning);
                                    EntryPoints.headersCheckValue("110 HttpURLConnection \"Response is stale\"", HttpHeaders.Warning);
                                    EntryPoints.commonAddLenient(builder2, HttpHeaders.Warning, "110 HttpURLConnection \"Response is stale\"");
                                }
                                if (jMax2 > 86400000 && response.cacheControl().maxAgeSeconds == -1 && httpDateOrNull == null) {
                                    Headers.Builder builder3 = builderNewBuilder.headers;
                                    builder3.getClass();
                                    EntryPoints.headersCheckName(HttpHeaders.Warning);
                                    EntryPoints.headersCheckValue("113 HttpURLConnection \"Heuristic expiration\"", HttpHeaders.Warning);
                                    EntryPoints.commonAddLenient(builder3, HttpHeaders.Warning, "113 HttpURLConnection \"Heuristic expiration\"");
                                }
                                fileLock = new FileLock((Object) null, builderNewBuilder.build());
                            } else {
                                if (str != null) {
                                    str5 = HttpHeaders.IfNoneMatch;
                                    str4 = str;
                                } else {
                                    if (httpDateOrNull2 != null) {
                                        str4 = str2;
                                    } else if (httpDateOrNull3 != null) {
                                        str4 = str3;
                                    } else {
                                        fileLock = new FileLock(request3, (Object) null);
                                    }
                                    str5 = HttpHeaders.IfModifiedSince;
                                }
                                Headers.Builder builderCommonNewBuilder3 = EntryPoints.commonNewBuilder(headers4);
                                str4.getClass();
                                EntryPoints.commonAddLenient(builderCommonNewBuilder3, str5, str4);
                                Request.Builder builderNewBuilder3 = request3.newBuilder();
                                builderNewBuilder3.headers = EntryPoints.commonNewBuilder(EntryPoints.commonBuild(builderCommonNewBuilder3));
                                fileLock = new FileLock(new Request(builderNewBuilder3), response);
                            }
                        }
                    }
                    j2 = 0;
                    i2 = cacheControl.maxAgeSeconds;
                    if (i2 != -1) {
                        time2 = Math.min(time2, timeUnit.toMillis(i2));
                    }
                    i3 = cacheControl.minFreshSeconds;
                    if (i3 != -1) {
                        millis = timeUnit.toMillis(i3);
                    } else {
                        millis = j2;
                    }
                    if (cacheControl2.mustRevalidate) {
                        millis2 = j2;
                    } else {
                        millis2 = j2;
                    }
                    if (cacheControl2.noCache) {
                        j3 = jMax2 + millis;
                        if (j3 < millis2 + time2) {
                            builderNewBuilder = response.newBuilder();
                            if (j3 >= time2) {
                                Headers.Builder builder4 = builderNewBuilder.headers;
                                builder4.getClass();
                                EntryPoints.headersCheckName(HttpHeaders.Warning);
                                EntryPoints.headersCheckValue("110 HttpURLConnection \"Response is stale\"", HttpHeaders.Warning);
                                EntryPoints.commonAddLenient(builder4, HttpHeaders.Warning, "110 HttpURLConnection \"Response is stale\"");
                            }
                            if (jMax2 > 86400000) {
                                Headers.Builder builder5 = builderNewBuilder.headers;
                                builder5.getClass();
                                EntryPoints.headersCheckName(HttpHeaders.Warning);
                                EntryPoints.headersCheckValue("113 HttpURLConnection \"Heuristic expiration\"", HttpHeaders.Warning);
                                EntryPoints.commonAddLenient(builder5, HttpHeaders.Warning, "113 HttpURLConnection \"Heuristic expiration\"");
                            }
                            fileLock = new FileLock((Object) null, builderNewBuilder.build());
                        } else {
                            if (str != null) {
                                str5 = HttpHeaders.IfNoneMatch;
                                str4 = str;
                            } else {
                                if (httpDateOrNull2 != null) {
                                    str4 = str2;
                                } else if (httpDateOrNull3 != null) {
                                    str4 = str3;
                                } else {
                                    fileLock = new FileLock(request3, (Object) null);
                                }
                                str5 = HttpHeaders.IfModifiedSince;
                            }
                            Headers.Builder builderCommonNewBuilder4 = EntryPoints.commonNewBuilder(headers4);
                            str4.getClass();
                            EntryPoints.commonAddLenient(builderCommonNewBuilder4, str5, str4);
                            Request.Builder builderNewBuilder4 = request3.newBuilder();
                            builderNewBuilder4.headers = EntryPoints.commonNewBuilder(EntryPoints.commonBuild(builderCommonNewBuilder4));
                            fileLock = new FileLock(new Request(builderNewBuilder4), response);
                        }
                    } else {
                        if (str != null) {
                            str5 = HttpHeaders.IfNoneMatch;
                            str4 = str;
                        } else {
                            if (httpDateOrNull2 != null) {
                                str4 = str2;
                            } else if (httpDateOrNull3 != null) {
                                str4 = str3;
                            } else {
                                fileLock = new FileLock(request3, (Object) null);
                            }
                            str5 = HttpHeaders.IfModifiedSince;
                        }
                        Headers.Builder builderCommonNewBuilder5 = EntryPoints.commonNewBuilder(headers4);
                        str4.getClass();
                        EntryPoints.commonAddLenient(builderCommonNewBuilder5, str5, str4);
                        Request.Builder builderNewBuilder5 = request3.newBuilder();
                        builderNewBuilder5.headers = EntryPoints.commonNewBuilder(EntryPoints.commonBuild(builderCommonNewBuilder5));
                        fileLock = new FileLock(new Request(builderNewBuilder5), response);
                    }
                } else {
                    fileLock = new FileLock(request3, (Object) null);
                }
            } else {
                fileLock = new FileLock(request3, (Object) null);
            }
        }
        if (((Request) fileLock.lockFilename) == null) {
            response2 = null;
        } else {
            CacheControl cacheControl3 = request3.lazyCacheControl;
            if (cacheControl3 == null) {
                int i9 = CacheControl.$r8$clinit;
                cacheControl3 = HexFormatKt.parse(request3.headers);
                request3.lazyCacheControl = cacheControl3;
            }
            if (cacheControl3.onlyIfCached) {
                response2 = null;
                fileLock = new FileLock((Object) null, (Object) null);
            } else {
                response2 = null;
            }
        }
        Request request4 = (Request) fileLock.lockFilename;
        Response response3 = (Response) fileLock.lockChannel;
        if (cache != null) {
            synchronized (cache) {
            }
        }
        if (response != null && response3 == null) {
            _UtilCommonKt.closeQuietly(response.body);
        }
        if (request4 == null && response3 == null) {
            ResponseBody$Companion$asResponseBody$1 responseBody$Companion$asResponseBody$2 = ResponseBody.EMPTY;
            Protocol.Companion companion2 = TrailersSource.EMPTY;
            ArrayList arrayList = new ArrayList(20);
            Request request5 = realInterceptorChain.request;
            request5.getClass();
            Response response4 = new Response(request5, Protocol.HTTP_1_1, "Unsatisfiable Request (only-if-cached)", 504, null, new Headers((String[]) arrayList.toArray(new String[0])), responseBody$Companion$asResponseBody$2, null, null, null, null, -1L, System.currentTimeMillis(), null, companion2);
            realInterceptorChain.call.eventListener.getClass();
            return response4;
        }
        if (request4 == null) {
            response3.getClass();
            Response.Builder builderNewBuilder6 = response3.newBuilder();
            Response responseStripBody = UuidKt.stripBody(response3);
            Response.Builder.checkSupportResponse("cacheResponse", responseStripBody);
            builderNewBuilder6.cacheResponse = responseStripBody;
            Response responseBuild = builderNewBuilder6.build();
            realInterceptorChain.call.eventListener.getClass();
            return responseBuild;
        }
        if (response3 != null || cache != null) {
            realInterceptorChain.call.eventListener.getClass();
        }
        try {
            Response responseProceed = realInterceptorChain.proceed(request4);
            if (response3 != null) {
                if (responseProceed.code == 304) {
                    Response.Builder builderNewBuilder7 = response3.newBuilder();
                    Headers headers5 = response3.headers;
                    Headers headers6 = responseProceed.headers;
                    ArrayList arrayList2 = new ArrayList(20);
                    int size2 = headers5.size();
                    for (int i10 = 0; i10 < size2; i10++) {
                        String strCommonName2 = EntryPoints.commonName(headers5, i10);
                        String strCommonValue2 = EntryPoints.commonValue(headers5, i10);
                        if ((!HttpHeaders.Warning.equalsIgnoreCase(strCommonName2) || !StringsKt__StringsJVMKt.startsWith(strCommonValue2, "1", false)) && (HttpHeaders.ContentLength.equalsIgnoreCase(strCommonName2) || HttpHeaders.ContentEncoding.equalsIgnoreCase(strCommonName2) || HttpHeaders.ContentType.equalsIgnoreCase(strCommonName2) || !CharsKt.isEndToEnd(strCommonName2) || headers6.get(strCommonName2) == null)) {
                            arrayList2.add(strCommonName2);
                            arrayList2.add(StringsKt.trim(strCommonValue2).toString());
                        }
                    }
                    int size3 = headers6.size();
                    for (int i11 = 0; i11 < size3; i11++) {
                        String strCommonName3 = EntryPoints.commonName(headers6, i11);
                        if (!HttpHeaders.ContentLength.equalsIgnoreCase(strCommonName3) && !HttpHeaders.ContentEncoding.equalsIgnoreCase(strCommonName3) && !HttpHeaders.ContentType.equalsIgnoreCase(strCommonName3) && CharsKt.isEndToEnd(strCommonName3)) {
                            String strCommonValue3 = EntryPoints.commonValue(headers6, i11);
                            arrayList2.add(strCommonName3);
                            arrayList2.add(StringsKt.trim(strCommonValue3).toString());
                        }
                    }
                    builderNewBuilder7.headers = EntryPoints.commonNewBuilder(new Headers((String[]) arrayList2.toArray(new String[0])));
                    builderNewBuilder7.sentRequestAtMillis = responseProceed.sentRequestAtMillis;
                    builderNewBuilder7.receivedResponseAtMillis = responseProceed.receivedResponseAtMillis;
                    Response responseStripBody2 = UuidKt.stripBody(response3);
                    Response.Builder.checkSupportResponse("cacheResponse", responseStripBody2);
                    builderNewBuilder7.cacheResponse = responseStripBody2;
                    Response responseStripBody3 = UuidKt.stripBody(responseProceed);
                    Response.Builder.checkSupportResponse("networkResponse", responseStripBody3);
                    builderNewBuilder7.networkResponse = responseStripBody3;
                    Response responseBuild2 = builderNewBuilder7.build();
                    responseProceed.body.close();
                    cache.getClass();
                    synchronized (cache) {
                    }
                    Cache.Entry entry2 = new Cache.Entry(responseBuild2);
                    ResponseBody responseBody = response3.body;
                    responseBody.getClass();
                    DiskLruCache.Snapshot snapshot2 = ((Cache.CacheResponseBody) responseBody).snapshot;
                    try {
                        latchEdit2 = snapshot2.this$0.edit(snapshot2.sequenceNumber, snapshot2.key);
                        if (latchEdit2 != 0) {
                            try {
                                entry2.writeTo(latchEdit2);
                                latchEdit2.commit();
                            } catch (IOException unused3) {
                                if (latchEdit2 != 0) {
                                    try {
                                        latchEdit2.abort();
                                    } catch (IOException unused4) {
                                    }
                                }
                            }
                        }
                    } catch (IOException unused5) {
                        latchEdit2 = response2;
                    }
                    realInterceptorChain.call.eventListener.getClass();
                    return responseBuild2;
                }
                _UtilCommonKt.closeQuietly(response3.body);
            }
            Response.Builder builderNewBuilder8 = responseProceed.newBuilder();
            Response responseStripBody4 = response3 != null ? UuidKt.stripBody(response3) : response2;
            Response.Builder.checkSupportResponse("cacheResponse", responseStripBody4);
            builderNewBuilder8.cacheResponse = responseStripBody4;
            Response responseStripBody5 = UuidKt.stripBody(responseProceed);
            Response.Builder.checkSupportResponse("networkResponse", responseStripBody5);
            builderNewBuilder8.networkResponse = responseStripBody5;
            Response responseBuild3 = builderNewBuilder8.build();
            if (cache != null) {
                if (okhttp3.internal.http.HttpHeaders.promisesBody(responseBuild3) && HexFormatKt.isCacheable(responseBuild3, request4)) {
                    Response.Builder builderNewBuilder9 = responseBuild3.newBuilder();
                    builderNewBuilder9.request = request4;
                    Response responseBuild4 = builderNewBuilder9.build();
                    Request request6 = responseBuild4.request;
                    String str11 = request6.method;
                    try {
                        if (!Okio__OkioKt.invalidatesCache(str11)) {
                            if (str11.equals("GET") && !CharsKt.varyFields(responseBuild4.headers).contains("*")) {
                                Cache.Entry entry3 = new Cache.Entry(responseBuild4);
                                try {
                                    DiskLruCache diskLruCache = cache.cache;
                                    String strKey = CharsKt.key(request6.url);
                                    Regex regex = DiskLruCache.LEGAL_KEY_PATTERN;
                                    latchEdit = diskLruCache.edit(-1L, strKey);
                                    if (latchEdit == 0) {
                                        realCacheRequest = response2;
                                    } else {
                                        try {
                                            entry3.writeTo(latchEdit);
                                            Cache.RealCacheRequest realCacheRequest2 = new Cache.RealCacheRequest();
                                            realCacheRequest2.this$0 = cache;
                                            realCacheRequest2.editor = latchEdit;
                                            Sink sinkNewSink = latchEdit.newSink(1);
                                            realCacheRequest2.cacheOut = sinkNewSink;
                                            realCacheRequest2.body = new ForwardingSink(sinkNewSink) { // from class: okhttp3.Cache.RealCacheRequest.1
                                                public final /* synthetic */ RealCacheRequest this$1;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                public AnonymousClass1(Sink sinkNewSink2) {
                                                    super(sinkNewSink2);
                                                    realCacheRequest = realCacheRequest2;
                                                }

                                                @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                                                public final void close() {
                                                    Cache cache2 = cache;
                                                    RealCacheRequest realCacheRequest3 = realCacheRequest;
                                                    synchronized (cache2) {
                                                        if (realCacheRequest3.done) {
                                                            return;
                                                        }
                                                        realCacheRequest3.done = true;
                                                        super.close();
                                                        ((Latch) realCacheRequest.editor).commit();
                                                    }
                                                }
                                            };
                                            realCacheRequest = realCacheRequest2;
                                        } catch (IOException unused6) {
                                            if (latchEdit != 0) {
                                                latchEdit.abort();
                                            }
                                            realCacheRequest = response2;
                                        }
                                    }
                                } catch (IOException unused7) {
                                    latchEdit = response2;
                                }
                            } else {
                                realCacheRequest = response2;
                            }
                            if (realCacheRequest != 0) {
                                Cache.RealCacheRequest.AnonymousClass1 anonymousClass1 = (Cache.RealCacheRequest.AnonymousClass1) realCacheRequest.body;
                                final BufferedSource bufferedSourceSource = responseBuild3.body.source();
                                final RealBufferedSink realBufferedSinkBuffer = Okio__OkioKt.buffer(anonymousClass1);
                                Source source = new Source() { // from class: okhttp3.internal.cache.CacheInterceptor$cacheWritingResponse$cacheWritingSource$1
                                    public boolean cacheRequestClosed;

                                    @Override // java.io.Closeable, java.lang.AutoCloseable
                                    public final void close() throws IOException {
                                        boolean zSkipAll;
                                        if (!this.cacheRequestClosed) {
                                            TimeZone timeZone = _UtilJvmKt.UTC;
                                            TimeUnit.MILLISECONDS.getClass();
                                            try {
                                                zSkipAll = _UtilJvmKt.skipAll(this, 100);
                                            } catch (IOException unused8) {
                                                zSkipAll = false;
                                            }
                                            if (!zSkipAll) {
                                                this.cacheRequestClosed = true;
                                                realCacheRequest.abort();
                                            }
                                        }
                                        bufferedSourceSource.close();
                                    }

                                    @Override // okio.Source
                                    public final long read(Buffer buffer, long j6) throws IOException {
                                        buffer.getClass();
                                        try {
                                            long j7 = bufferedSourceSource.read(buffer, j6);
                                            RealBufferedSink realBufferedSink = realBufferedSinkBuffer;
                                            if (j7 != -1) {
                                                buffer.copyTo(realBufferedSink.bufferField, buffer.size - j7, j7);
                                                realBufferedSink.emitCompleteSegments();
                                                return j7;
                                            }
                                            if (!this.cacheRequestClosed) {
                                                this.cacheRequestClosed = true;
                                                realBufferedSink.close();
                                            }
                                            return -1L;
                                        } catch (IOException e) {
                                            if (this.cacheRequestClosed) {
                                                throw e;
                                            }
                                            this.cacheRequestClosed = true;
                                            realCacheRequest.abort();
                                            throw e;
                                        }
                                    }

                                    @Override // okio.Source
                                    public final Timeout timeout() {
                                        return bufferedSourceSource.timeout();
                                    }
                                };
                                String strHeader$default = Response.header$default(HttpHeaders.ContentType, responseBuild3);
                                long jContentLength = responseBuild3.body.contentLength();
                                Response.Builder builderNewBuilder10 = responseBuild3.newBuilder();
                                builderNewBuilder10.body = new RealResponseBody(strHeader$default, jContentLength, new RealBufferedSource(source));
                                responseBuild3 = builderNewBuilder10.build();
                            }
                            if (response3 != null) {
                                realInterceptorChain.call.eventListener.getClass();
                            }
                            return responseBuild3;
                        }
                        cache.remove$okhttp(request6);
                    } catch (IOException unused8) {
                    }
                    realCacheRequest = response2;
                    if (realCacheRequest != 0) {
                        Cache.RealCacheRequest.AnonymousClass1 anonymousClass2 = (Cache.RealCacheRequest.AnonymousClass1) realCacheRequest.body;
                        final BufferedSource bufferedSourceSource2 = responseBuild3.body.source();
                        final RealBufferedSink realBufferedSinkBuffer2 = Okio__OkioKt.buffer(anonymousClass2);
                        Source source2 = new Source() { // from class: okhttp3.internal.cache.CacheInterceptor$cacheWritingResponse$cacheWritingSource$1
                            public boolean cacheRequestClosed;

                            @Override // java.io.Closeable, java.lang.AutoCloseable
                            public final void close() throws IOException {
                                boolean zSkipAll;
                                if (!this.cacheRequestClosed) {
                                    TimeZone timeZone = _UtilJvmKt.UTC;
                                    TimeUnit.MILLISECONDS.getClass();
                                    try {
                                        zSkipAll = _UtilJvmKt.skipAll(this, 100);
                                    } catch (IOException unused9) {
                                        zSkipAll = false;
                                    }
                                    if (!zSkipAll) {
                                        this.cacheRequestClosed = true;
                                        realCacheRequest.abort();
                                    }
                                }
                                bufferedSourceSource2.close();
                            }

                            @Override // okio.Source
                            public final long read(Buffer buffer, long j6) throws IOException {
                                buffer.getClass();
                                try {
                                    long j7 = bufferedSourceSource2.read(buffer, j6);
                                    RealBufferedSink realBufferedSink = realBufferedSinkBuffer2;
                                    if (j7 != -1) {
                                        buffer.copyTo(realBufferedSink.bufferField, buffer.size - j7, j7);
                                        realBufferedSink.emitCompleteSegments();
                                        return j7;
                                    }
                                    if (!this.cacheRequestClosed) {
                                        this.cacheRequestClosed = true;
                                        realBufferedSink.close();
                                    }
                                    return -1L;
                                } catch (IOException e) {
                                    if (this.cacheRequestClosed) {
                                        throw e;
                                    }
                                    this.cacheRequestClosed = true;
                                    realCacheRequest.abort();
                                    throw e;
                                }
                            }

                            @Override // okio.Source
                            public final Timeout timeout() {
                                return bufferedSourceSource2.timeout();
                            }
                        };
                        String strHeader$default2 = Response.header$default(HttpHeaders.ContentType, responseBuild3);
                        long jContentLength2 = responseBuild3.body.contentLength();
                        Response.Builder builderNewBuilder11 = responseBuild3.newBuilder();
                        builderNewBuilder11.body = new RealResponseBody(strHeader$default2, jContentLength2, new RealBufferedSource(source2));
                        responseBuild3 = builderNewBuilder11.build();
                    }
                    if (response3 != null) {
                        realInterceptorChain.call.eventListener.getClass();
                    }
                    return responseBuild3;
                }
                if (Okio__OkioKt.invalidatesCache(request4.method)) {
                    try {
                        cache.remove$okhttp(request4);
                    } catch (IOException unused9) {
                    }
                }
            }
            return responseBuild3;
        } catch (Throwable th) {
            if (response != null) {
                _UtilCommonKt.closeQuietly(response.body);
            }
            throw th;
        }
    }
}
