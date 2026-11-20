package com.metrolist.paxsenix;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavDeepLinkRequest;
import androidx.palette.graphics.ColorCutQuantizer;
import com.metrolist.paxsenix.models.AppleMusicArtwork;
import com.metrolist.paxsenix.models.AppleMusicResources;
import com.metrolist.paxsenix.models.AppleMusicSearchResponse;
import com.metrolist.paxsenix.models.AppleMusicSongAttributes;
import com.metrolist.paxsenix.models.AppleMusicSongData;
import com.metrolist.paxsenix.models.AppleMusicSongDetail;
import com.metrolist.paxsenix.models.AppleMusicSongsResult;
import com.metrolist.paxsenix.models.LyricsContent;
import com.metrolist.paxsenix.models.LyricsResponse;
import com.metrolist.paxsenix.models.SearchResult;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClient$$ExternalSyntheticLambda1;
import io.ktor.client.HttpClientKt;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.okhttp.OkHttp;
import io.ktor.client.plugins.ClientRequestException;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.client.utils.CIOKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.reflect.TypeInfo;
import j$.net.URLEncoder;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Paxsenix {
    public static String appVersion = "Unknown";
    public static volatile NavDeepLinkRequest appleTokenManager;
    public static volatile HttpClient client;
    public static final Paxsenix INSTANCE = new Paxsenix();
    public static final JsonImpl appleJson = UuidKt.Json$default(new HttpClient$$ExternalSyntheticLambda1(5));
    public static final List titleCleanupPatterns = CollectionsKt__IterablesKt.listOf((Object[]) new Regex[]{new Regex("\\s*\\(.*?(official|video|audio|lyrics|lyric|visualizer|hd|hq|4k|remaster|remix|live|acoustic|version|edit|extended|radio|clean|explicit).*?\\)", 0), new Regex("\\s*\\[.*?(official|video|audio|lyrics|lyric|visualizer|hd|hq|4k|remaster|remix|live|acoustic|version|edit|extended|radio|clean|explicit).*?\\]", 0), new Regex("\\s*【.*?】"), new Regex("\\s*\\|.*$"), new Regex("\\s*-\\s*(official|video|audio|lyrics|lyric|visualizer).*$", 0), new Regex("\\s*\\(feat\\..*?\\)", 0), new Regex("\\s*\\(ft\\..*?\\)", 0), new Regex("\\s*feat\\..*$", 0), new Regex("\\s*ft\\..*$", 0), new Regex("\\s*\\([^)]*\\d{4}[^)]*\\)", 0)});
    public static final List artistSeparators = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{" & ", " and ", ", ", " x ", " X ", " feat. ", " feat ", " ft. ", " ft ", " featuring ", " with "});

    /* JADX INFO: renamed from: com.metrolist.paxsenix.Paxsenix$getAllLyrics$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int I$0;
        public String L$0;
        public String L$1;
        public Function1 L$3;
        public List L$7;
        public Object L$8;
        public Iterator L$9;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Paxsenix.this.getAllLyrics(null, null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.paxsenix.Paxsenix$search$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02241 extends ContinuationImpl {
        public String L$0;
        public Paxsenix L$1;
        public Paxsenix L$2;
        public int label;
        public /* synthetic */ Object result;

        public C02241(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Paxsenix.this.search(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.paxsenix.Paxsenix$searchWithToken$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02251 extends ContinuationImpl {
        public JsonImpl L$4;
        public int label;
        public /* synthetic */ Object result;

        public C02251(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Paxsenix.this.searchWithToken(null, null, this);
        }
    }

    public static String cleanArtist(String str) {
        String string = StringsKt.trim(str).toString();
        for (String str2 : artistSeparators) {
            if (StringsKt.contains(string, str2, true)) {
                string = (String) StringsKt.split(string, new String[]{str2}, true, 2).get(0);
                break;
            }
        }
        return StringsKt.trim(string).toString();
    }

    public static String cleanTitle(String str) {
        String string = StringsKt.trim(str).toString();
        Iterator it = titleCleanupPatterns.iterator();
        while (it.hasNext()) {
            string = ((Regex) it.next()).replace(string, "");
        }
        return StringsKt.trim(string).toString();
    }

    public static int getQuality(String str) {
        if (StringsKt.isBlank(str)) {
            return 0;
        }
        if (StringsKt.contains(str, "<", false) && StringsKt.contains(str, ">", false) && (StringsKt.contains(str, "|", false) || StringsKt.contains(str, ServerSentEventKt.COLON, false))) {
            return 3;
        }
        Pattern patternCompile = Pattern.compile("<\\d{1,2}:\\d{2}\\.\\d{2,3}>");
        patternCompile.getClass();
        if (patternCompile.matcher(str).find()) {
            return 3;
        }
        Pattern patternCompile2 = Pattern.compile("\\[\\d\\d:\\d\\d\\.\\d{2,3}\\]");
        patternCompile2.getClass();
        if (patternCompile2.matcher(str).find()) {
            return 2;
        }
        Pattern patternCompile3 = Pattern.compile("^\\[bg:.*\\]", 8);
        patternCompile3.getClass();
        return patternCompile3.matcher(str).find() ? 2 : 1;
    }

    public static List scoreAndFilterResults(int i, String str, String str2, List list) {
        double d;
        List listListOf;
        int i2;
        int i3;
        int i4 = i * CIOKt.DEFAULT_HTTP_POOL_SIZE;
        Pattern patternCompile = Pattern.compile("\\s*\\(.*?\\)|\\s*\\[.*?\\]");
        patternCompile.getClass();
        str.getClass();
        String strReplaceAll = patternCompile.matcher(str).replaceAll("");
        strReplaceAll.getClass();
        Locale locale = Locale.ROOT;
        String lowerCase = strReplaceAll.toLowerCase(locale);
        lowerCase.getClass();
        String string = StringsKt.trim(lowerCase).toString();
        String lowerCase2 = cleanArtist(str2).toLowerCase(locale);
        lowerCase2.getClass();
        boolean zContains = StringsKt.contains(str, "mixed", true);
        boolean zContains2 = StringsKt.contains(str, "remix", true);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SearchResult searchResult = (SearchResult) it.next();
            String str3 = searchResult.trackName;
            if (str3 == null && (str3 = searchResult.songName) == null) {
                str3 = "";
            }
            String str4 = searchResult.artistName;
            if (str4 == null) {
                str4 = "";
            }
            Integer num = searchResult.duration;
            if (num != null) {
                int iAbs = Math.abs(num.intValue() - i4);
                if (iAbs <= 2000) {
                    d = 100.0d;
                } else if (iAbs <= 5000) {
                    d = 50.0d;
                } else {
                    d = iAbs <= 10000 ? 10.0d : -50.0d;
                }
            } else {
                d = 0.0d;
            }
            String strReplaceAll2 = patternCompile.matcher(str3).replaceAll("");
            strReplaceAll2.getClass();
            Locale locale2 = Locale.ROOT;
            String lowerCase3 = strReplaceAll2.toLowerCase(locale2);
            lowerCase3.getClass();
            String string2 = StringsKt.trim(lowerCase3).toString();
            boolean z = zContains2;
            if (Intrinsics.areEqual(string2, string)) {
                d += 80.0d;
            } else if (StringsKt.contains(string2, string, false) || StringsKt.contains(string, string2, false)) {
                d += 40.0d;
            }
            boolean zContains3 = StringsKt.contains(str3, "mixed", true);
            boolean zContains4 = StringsKt.contains(str3, "remix", true);
            if (zContains3 && !zContains) {
                d -= 60.0d;
            }
            if (zContains4 && !z) {
                d -= 40.0d;
            }
            String lowerCase4 = str4.toLowerCase(locale2);
            lowerCase4.getClass();
            if (!StringsKt.contains(lowerCase4, lowerCase2, false)) {
                Pattern patternCompile2 = Pattern.compile("\\s+");
                patternCompile2.getClass();
                StringsKt.requireNonNegativeLimit(0);
                Matcher matcher = patternCompile2.matcher(lowerCase2);
                if (matcher.find()) {
                    ArrayList arrayList2 = new ArrayList(10);
                    int iEnd = 0;
                    do {
                        arrayList2.add(lowerCase2.subSequence(iEnd, matcher.start()).toString());
                        iEnd = matcher.end();
                    } while (matcher.find());
                    arrayList2.add(lowerCase2.subSequence(iEnd, lowerCase2.length()).toString());
                    listListOf = arrayList2;
                } else {
                    listListOf = CollectionsKt__IterablesKt.listOf(lowerCase2.toString());
                }
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : listListOf) {
                    int i5 = i4;
                    if (((String) obj).length() > 2) {
                        arrayList3.add(obj);
                    }
                    i4 = i5;
                }
                i2 = i4;
                if (arrayList3.isEmpty()) {
                    i3 = 0;
                    break;
                }
                int size = arrayList3.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size) {
                        i3 = 0;
                        break;
                        break;
                    }
                    Object obj2 = arrayList3.get(i6);
                    i6++;
                    i3 = 0;
                    if (StringsKt.contains(lowerCase4, (String) obj2, false)) {
                        d += 25.0d;
                        break;
                    }
                }
            } else {
                d += 50.0d;
                i3 = 0;
                i2 = i4;
            }
            Timber.Forest.getClass();
            ConnectionPool.v(new Object[i3]);
            arrayList.add(new Pair(searchResult, Double.valueOf(d)));
            i4 = i2;
            zContains2 = z;
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new ColorCutQuantizer.AnonymousClass1((byte) 17));
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : listSortedWith) {
            if (((Number) ((Pair) obj3).second).doubleValue() > 0.0d) {
                arrayList4.add(obj3);
            }
        }
        return CollectionsKt.take(arrayList4, 10);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0092, code lost:
    
        if (r1 == r3) goto L30;
     */
    /* JADX INFO: renamed from: fetchLyricsForTrack-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable m1531fetchLyricsForTrackgIAlus(String str, ContinuationImpl continuationImpl) {
        Paxsenix$fetchLyricsForTrack$1 paxsenix$fetchLyricsForTrack$1;
        String lrc;
        Paxsenix paxsenix = this;
        if (continuationImpl instanceof Paxsenix$fetchLyricsForTrack$1) {
            paxsenix$fetchLyricsForTrack$1 = (Paxsenix$fetchLyricsForTrack$1) continuationImpl;
            int i = paxsenix$fetchLyricsForTrack$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                paxsenix$fetchLyricsForTrack$1.label = i - Integer.MIN_VALUE;
            } else {
                paxsenix$fetchLyricsForTrack$1 = new Paxsenix$fetchLyricsForTrack$1(paxsenix, continuationImpl);
            }
        } else {
            paxsenix$fetchLyricsForTrack$1 = new Paxsenix$fetchLyricsForTrack$1(paxsenix, continuationImpl);
        }
        Object objExecute = paxsenix$fetchLyricsForTrack$1.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = paxsenix$fetchLyricsForTrack$1.label;
        TypeReference typeReferenceTypeOf = null;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objExecute);
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    HttpClient httpClient = client;
                    if (httpClient == null) {
                        throw new IllegalStateException("Paxsenix.init() must be called before using Paxsenix");
                    }
                    HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                    HttpRequestKt.url(httpRequestBuilder, "/apple-music/lyrics");
                    UtilsKt.parameter(httpRequestBuilder, "id", str);
                    httpRequestBuilder.setMethod(HttpMethod.Get);
                    HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                    paxsenix$fetchLyricsForTrack$1.L$1 = paxsenix;
                    paxsenix$fetchLyricsForTrack$1.label = 1;
                    objExecute = httpStatement.execute(paxsenix$fetchLyricsForTrack$1);
                    if (objExecute == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    paxsenix = paxsenix$fetchLyricsForTrack$1.L$1;
                    ResultKt.throwOnFailure(objExecute);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    paxsenix = paxsenix$fetchLyricsForTrack$1.L$1;
                    ResultKt.throwOnFailure(objExecute);
                }
                if (objExecute == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.paxsenix.models.LyricsResponse");
                }
                LyricsResponse lyricsResponse = (LyricsResponse) objExecute;
                String str2 = lyricsResponse.plain;
                String str3 = lyricsResponse.elrc;
                String str4 = lyricsResponse.elrcMultiPerson;
                String str5 = lyricsResponse.ttmlContent;
                List<LyricsContent> list = lyricsResponse.content;
                String str6 = lyricsResponse.type;
                Timber.Forest.getClass();
                ConnectionPool.d(new Object[0]);
                if (str5 != null && !StringsKt.isBlank(str5)) {
                    paxsenix.getClass();
                    try {
                        lrc = StringsKt__IndentKt.toLRC(StringsKt__IndentKt.parseTTML(str5));
                    } catch (Exception e) {
                        ConnectionPool connectionPool = Timber.Forest;
                        e.getMessage();
                        connectionPool.getClass();
                        ConnectionPool.e$1(new Object[0]);
                        lrc = "";
                    }
                    if (lrc.length() > 0) {
                        ConnectionPool.d(new Object[0]);
                        return lrc;
                    }
                }
                if (str4 != null && !StringsKt.isBlank(str4)) {
                    ConnectionPool.d(new Object[0]);
                    return str4;
                }
                if (str3 != null && !StringsKt.isBlank(str3)) {
                    ConnectionPool.d(new Object[0]);
                    return str3;
                }
                if (str2 != null && !StringsKt.isBlank(str2)) {
                    ConnectionPool.d(new Object[0]);
                    return str2;
                }
                if (list.isEmpty()) {
                    throw new IllegalStateException("No lyrics found");
                }
                boolean zAreEqual = Intrinsics.areEqual(str6, "Syllable");
                ConnectionPool.d(new Object[0]);
                byte b = 10;
                if (!zAreEqual) {
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(CollectionsKt.joinToString$default(((LyricsContent) it.next()).text, ServerSentEventKt.SPACE, null, null, new HttpClient$$ExternalSyntheticLambda1(b), 30));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        if (!StringsKt.isBlank((String) obj)) {
                            arrayList2.add(obj);
                        }
                    }
                    String strJoinToString$default = CollectionsKt.joinToString$default(arrayList2, "\n", null, null, null, 62);
                    ConnectionPool connectionPool2 = Timber.Forest;
                    list.size();
                    connectionPool2.getClass();
                    ConnectionPool.d(new Object[0]);
                    return strJoinToString$default;
                }
                StringBuilder sb = new StringBuilder();
                for (LyricsContent lyricsContent : list) {
                    long j = lyricsContent.timestamp;
                    long j2 = (j / 1000) / 60;
                    long j3 = (j / 1000) % 60;
                    long j4 = (j % 1000) / 10;
                    String str7 = lyricsContent.background ? "{bg}" : lyricsContent.oppositeTurn ? "{agent:v2}" : "{agent:v1}";
                    String strJoinToString$default2 = CollectionsKt.joinToString$default(lyricsContent.text, ServerSentEventKt.SPACE, null, null, new HttpClient$$ExternalSyntheticLambda1((byte) 11), 30);
                    if (!StringsKt.isBlank(strJoinToString$default2)) {
                        sb.append(String.format(Locale.US, "[%02d:%02d.%02d]%s%s", Arrays.copyOf(new Object[]{new Long(j2), new Long(j3), new Long(j4), str7, strJoinToString$default2}, 5)));
                        sb.append('\n');
                        if (!lyricsContent.text.isEmpty()) {
                            String strJoinToString$default3 = CollectionsKt.joinToString$default(lyricsContent.text, "|", null, null, new HttpClient$$ExternalSyntheticLambda1((byte) 12), 30);
                            if (strJoinToString$default3.length() > 0) {
                                sb.append("<" + strJoinToString$default3 + ">");
                                sb.append('\n');
                            }
                        }
                    }
                }
                String string = sb.toString();
                ConnectionPool connectionPool3 = Timber.Forest;
                list.size();
                connectionPool3.getClass();
                ConnectionPool.d(new Object[0]);
                return string;
                typeReferenceTypeOf = Reflection.typeOf(LyricsResponse.class);
            } catch (Throwable unused) {
            }
            HttpClientCall call = ((HttpResponse) objExecute).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LyricsResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            paxsenix$fetchLyricsForTrack$1.L$1 = paxsenix;
            paxsenix$fetchLyricsForTrack$1.label = 2;
            objExecute = call.bodyNullable(typeInfo, paxsenix$fetchLyricsForTrack$1);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0087  */
    /* JADX WARN: Code duplicated, block: B:22:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:25:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:27:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:32:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:53:0x0152 A[LOOP:0: B:51:0x014c->B:53:0x0152, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00a5 -> B:23:0x00aa). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0116 -> B:40:0x0119). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object getAllLyrics(java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.functions.Function1 r13, kotlin.coroutines.jvm.internal.ContinuationImpl r14) {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.paxsenix.Paxsenix.getAllLyrics(java.lang.String, java.lang.String, int, kotlin.jvm.functions.Function1, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00e1 A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:13:0x003e, B:48:0x017c, B:51:0x0181, B:43:0x013e, B:45:0x0144, B:64:0x01ac, B:66:0x01b9, B:54:0x0186, B:57:0x018d, B:59:0x01a2, B:18:0x0063, B:36:0x0114, B:38:0x011c, B:28:0x00db, B:30:0x00e1, B:32:0x00ed, B:40:0x0125, B:42:0x012b, B:68:0x01d0, B:69:0x01e1, B:21:0x0071, B:23:0x00a6, B:26:0x00ad, B:27:0x00c8), top: B:73:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:34:0x010f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0111  */
    /* JADX WARN: Code duplicated, block: B:38:0x011c A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:13:0x003e, B:48:0x017c, B:51:0x0181, B:43:0x013e, B:45:0x0144, B:64:0x01ac, B:66:0x01b9, B:54:0x0186, B:57:0x018d, B:59:0x01a2, B:18:0x0063, B:36:0x0114, B:38:0x011c, B:28:0x00db, B:30:0x00e1, B:32:0x00ed, B:40:0x0125, B:42:0x012b, B:68:0x01d0, B:69:0x01e1, B:21:0x0071, B:23:0x00a6, B:26:0x00ad, B:27:0x00c8), top: B:73:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:75:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:? A[LOOP:0: B:28:0x00db->B:77:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0111 -> B:36:0x0114). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0179 -> B:48:0x017c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: getLyrics-yxL6bBk, reason: not valid java name */
    public final java.io.Serializable m1532getLyricsyxL6bBk(int r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, kotlin.coroutines.jvm.internal.ContinuationImpl r21) {
        /*
            Method dump skipped, instruction units count: 489
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.paxsenix.Paxsenix.m1532getLyricsyxL6bBk(int, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.io.Serializable");
    }

    public final NavDeepLinkRequest getTokenManager() {
        NavDeepLinkRequest navDeepLinkRequest;
        NavDeepLinkRequest navDeepLinkRequest2 = appleTokenManager;
        if (navDeepLinkRequest2 != null) {
            return navDeepLinkRequest2;
        }
        synchronized (this) {
            try {
                navDeepLinkRequest = appleTokenManager;
                if (navDeepLinkRequest == null) {
                    HttpClient httpClient = client;
                    if (httpClient == null) {
                        throw new IllegalStateException("Paxsenix.init() must be called before using Paxsenix");
                    }
                    navDeepLinkRequest = new NavDeepLinkRequest(httpClient);
                    appleTokenManager = navDeepLinkRequest;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return navDeepLinkRequest;
    }

    public final void init(Context context) {
        String str;
        context.getClass();
        if (client != null) {
            return;
        }
        synchronized (this) {
            if (client != null) {
                return;
            }
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                if (str == null) {
                    str = "Unknown";
                }
            } catch (Exception unused) {
                Timber.Forest.getClass();
                ConnectionPool.e$1(new Object[0]);
                str = "Unknown";
            }
            appVersion = str;
            Timber.Forest.getClass();
            ConnectionPool.d(new Object[0]);
            client = HttpClientKt.HttpClient(OkHttp.INSTANCE, new HttpClient$$ExternalSyntheticLambda1((byte) 6));
            ConnectionPool.d(new Object[0]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ec, code lost:
    
        if (r12 == r9) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object search(String str, ContinuationImpl continuationImpl) {
        C02241 c02241;
        Object failure;
        Object failure2;
        Throwable thM1866exceptionOrNullimpl;
        Paxsenix paxsenix;
        if (continuationImpl instanceof C02241) {
            c02241 = (C02241) continuationImpl;
            int i = c02241.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02241.label = i - Integer.MIN_VALUE;
            } else {
                c02241 = new C02241(continuationImpl);
            }
        } else {
            c02241 = new C02241(continuationImpl);
        }
        Object token = c02241.result;
        int i2 = c02241.label;
        Object obj = EmptyList.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(token);
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    NavDeepLinkRequest tokenManager = getTokenManager();
                    c02241.L$0 = str;
                    c02241.L$1 = this;
                    c02241.label = 1;
                    token = tokenManager.getToken(c02241);
                    if (token == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    this = c02241.L$1;
                    str = c02241.L$0;
                    ResultKt.throwOnFailure(token);
                } else {
                    if (i2 == 2) {
                        str = c02241.L$0;
                        ResultKt.throwOnFailure(token);
                        failure2 = (List) token;
                        thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(failure2);
                        if (thM1866exceptionOrNullimpl == null) {
                            return failure2;
                        }
                        if (!(thM1866exceptionOrNullimpl instanceof ClientRequestException) && ((ClientRequestException) thM1866exceptionOrNullimpl).getResponse().getStatus().getValue() == 401) {
                            paxsenix = INSTANCE;
                            paxsenix.getTokenManager().action = null;
                            Timber.Forest.getClass();
                            ConnectionPool.d(new Object[0]);
                            NavDeepLinkRequest tokenManager2 = paxsenix.getTokenManager();
                            c02241.L$0 = str;
                            c02241.L$1 = null;
                            c02241.L$2 = paxsenix;
                            c02241.label = 3;
                            token = tokenManager2.getToken(c02241);
                            if (token != coroutineSingletons) {
                                c02241.L$0 = null;
                                c02241.L$1 = null;
                                c02241.L$2 = null;
                                c02241.label = 4;
                                token = paxsenix.searchWithToken((String) token, str, c02241);
                            }
                            return coroutineSingletons;
                        }
                        ConnectionPool connectionPool = Timber.Forest;
                        thM1866exceptionOrNullimpl.getMessage();
                        connectionPool.getClass();
                        ConnectionPool.e$1(new Object[0]);
                        return obj;
                    }
                    if (i2 == 3) {
                        paxsenix = c02241.L$2;
                        str = c02241.L$0;
                        ResultKt.throwOnFailure(token);
                        c02241.L$0 = null;
                        c02241.L$1 = null;
                        c02241.L$2 = null;
                        c02241.label = 4;
                        token = paxsenix.searchWithToken((String) token, str, c02241);
                    } else {
                        if (i2 != 4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(token);
                    }
                }
                failure = (List) token;
                Throwable thM1866exceptionOrNullimpl2 = Result.m1866exceptionOrNullimpl(failure);
                if (thM1866exceptionOrNullimpl2 == null) {
                    obj = failure;
                } else {
                    ConnectionPool connectionPool2 = Timber.Forest;
                    thM1866exceptionOrNullimpl2.getMessage();
                    connectionPool2.getClass();
                    ConnectionPool.e$1(new Object[0]);
                }
                obj = (List) obj;
                return obj;
                c02241.L$0 = str;
                c02241.L$1 = null;
                c02241.L$2 = null;
                c02241.label = 2;
                token = this.searchWithToken((String) token, str, c02241);
                if (token != coroutineSingletons) {
                    failure2 = (List) token;
                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(failure2);
                    if (thM1866exceptionOrNullimpl == null) {
                        return failure2;
                    }
                    if (!(thM1866exceptionOrNullimpl instanceof ClientRequestException)) {
                    }
                    ConnectionPool connectionPool3 = Timber.Forest;
                    thM1866exceptionOrNullimpl.getMessage();
                    connectionPool3.getClass();
                    ConnectionPool.e$1(new Object[0]);
                    return obj;
                }
            } catch (Throwable th) {
                failure2 = new Result.Failure(th);
            }
            return coroutineSingletons;
        } catch (Throwable th2) {
            failure = new Result.Failure(th2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:55:0x0152  */
    /* JADX WARN: Code duplicated, block: B:60:0x016d A[LOOP:1: B:59:0x016b->B:60:0x016d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:69:0x0155 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.Serializable, kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    public final Serializable searchWithToken(String str, String str2, ContinuationImpl continuationImpl) throws UnsupportedEncodingException {
        C02251 c02251;
        JsonImpl jsonImpl;
        AppleMusicSearchResponse appleMusicSearchResponse;
        AppleMusicSongsResult appleMusicSongsResult;
        List<AppleMusicSongData> list;
        int size;
        int i;
        AppleMusicResources appleMusicResources;
        SearchResult searchResult;
        Map map;
        AppleMusicSongDetail appleMusicSongDetail;
        String str3;
        ?? arrayList = EmptyList.INSTANCE;
        if (continuationImpl instanceof C02251) {
            c02251 = (C02251) continuationImpl;
            int i2 = c02251.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c02251.label = i2 - Integer.MIN_VALUE;
            } else {
                c02251 = new C02251(continuationImpl);
            }
        } else {
            c02251 = new C02251(continuationImpl);
        }
        Object objExecute = c02251.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i3 = c02251.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(objExecute);
                String strEncode = URLEncoder.encode(str2, "UTF-8");
                HttpClient httpClient = client;
                if (httpClient == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Paxsenix.init() must be called before using Paxsenix");
                    return null;
                }
                String strM = IntIntPair$$ExternalSyntheticOutline0.m("https://amp-api.music.apple.com/v1/catalog/us/search?term=", strEncode, "&types=songs&limit=25&l=en-US&platform=web&format[resources]=map&include[songs]=artists&extend=artistUrl");
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder, strM);
                UtilsKt.header(httpRequestBuilder, HttpHeaders.Authorization, "Bearer " + str);
                UtilsKt.header(httpRequestBuilder, HttpHeaders.Origin, "https://music.apple.com");
                UtilsKt.header(httpRequestBuilder, HttpHeaders.Referrer, "https://music.apple.com/");
                UtilsKt.header(httpRequestBuilder, HttpHeaders.UserAgent, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:95.0) Gecko/20100101 Firefox/95.0");
                UtilsKt.header(httpRequestBuilder, HttpHeaders.Accept, "application/json");
                UtilsKt.header(httpRequestBuilder, HttpHeaders.AcceptLanguage, "en-US,en;q=0.5");
                UtilsKt.header(httpRequestBuilder, "x-apple-renewal", "true");
                HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
                c02251.L$4 = null;
                c02251.label = 1;
                objExecute = httpStatementM.execute(c02251);
                if (objExecute != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i3 == 1) {
                ResultKt.throwOnFailure(objExecute);
            } else {
                if (i3 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                jsonImpl = c02251.L$4;
                ResultKt.throwOnFailure(objExecute);
            }
            jsonImpl.getClass();
            appleMusicSearchResponse = (AppleMusicSearchResponse) jsonImpl.decodeFromString(AppleMusicSearchResponse.INSTANCE.serializer(), (String) objExecute);
            appleMusicSongsResult = appleMusicSearchResponse.results.songs;
            if (appleMusicSongsResult != null && (list = appleMusicSongsResult.data) != null) {
                arrayList = new ArrayList();
                for (AppleMusicSongData appleMusicSongData : list) {
                    appleMusicResources = appleMusicSearchResponse.resources;
                    if (appleMusicResources != null || (map = appleMusicResources.songs) == null || (appleMusicSongDetail = (AppleMusicSongDetail) map.get(appleMusicSongData.id)) == null) {
                        searchResult = null;
                    } else {
                        AppleMusicSongAttributes appleMusicSongAttributes = appleMusicSongDetail.attributes;
                        String str4 = appleMusicSongData.id;
                        String str5 = appleMusicSongAttributes.name;
                        String str6 = appleMusicSongAttributes.artistName;
                        String str7 = appleMusicSongAttributes.albumName;
                        Long l = appleMusicSongAttributes.durationInMillis;
                        Integer num = l != null ? new Integer(((int) l.longValue()) / CIOKt.DEFAULT_HTTP_POOL_SIZE) : null;
                        AppleMusicArtwork appleMusicArtwork = appleMusicSongAttributes.artwork;
                        searchResult = new SearchResult(str4, str5, str6, str7, num, (appleMusicArtwork == null || (str3 = appleMusicArtwork.url) == null) ? null : StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(str3, "{w}", "100", false), "{h}", "100", false), "{f}", "png", false));
                    }
                    if (searchResult != null) {
                        arrayList.add(searchResult);
                    }
                }
                ConnectionPool connectionPool = Timber.Forest;
                arrayList.size();
                connectionPool.getClass();
                ConnectionPool.d(new Object[0]);
                size = arrayList.size();
                i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ConnectionPool connectionPool2 = Timber.Forest;
                    String str8 = ((SearchResult) obj).trackName;
                    connectionPool2.getClass();
                    ConnectionPool.v(new Object[0]);
                }
            }
            return arrayList;
            HttpResponse httpResponse = (HttpResponse) objExecute;
            JsonImpl jsonImpl2 = appleJson;
            c02251.L$4 = jsonImpl2;
            c02251.label = 2;
            objExecute = HttpResponseKt.bodyAsText$default(httpResponse, null, c02251, 1, null);
            if (objExecute != coroutineSingletons) {
                jsonImpl = jsonImpl2;
                jsonImpl.getClass();
                appleMusicSearchResponse = (AppleMusicSearchResponse) jsonImpl.decodeFromString(AppleMusicSearchResponse.INSTANCE.serializer(), (String) objExecute);
                appleMusicSongsResult = appleMusicSearchResponse.results.songs;
                if (appleMusicSongsResult != null) {
                    arrayList = new ArrayList();
                    while (r2.hasNext()) {
                        appleMusicResources = appleMusicSearchResponse.resources;
                        if (appleMusicResources != null) {
                            searchResult = null;
                        } else {
                            searchResult = null;
                        }
                        if (searchResult != null) {
                            arrayList.add(searchResult);
                        }
                    }
                    ConnectionPool connectionPool3 = Timber.Forest;
                    arrayList.size();
                    connectionPool3.getClass();
                    ConnectionPool.d(new Object[0]);
                    size = arrayList.size();
                    i = 0;
                    while (i < size) {
                        Object obj2 = arrayList.get(i);
                        i++;
                        ConnectionPool connectionPool4 = Timber.Forest;
                        String str9 = ((SearchResult) obj2).trackName;
                        connectionPool4.getClass();
                        ConnectionPool.v(new Object[0]);
                    }
                }
                return arrayList;
            }
            return coroutineSingletons;
        } catch (Exception unused) {
            Timber.Forest.getClass();
            ConnectionPool.e$1(new Object[0]);
            return arrayList;
        }
    }
}
