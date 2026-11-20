package com.metrolist.kugou;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.kugou.models.DownloadLyricsResponse;
import com.metrolist.kugou.models.Keyword;
import com.metrolist.kugou.models.SearchLyricsResponse;
import com.metrolist.kugou.models.SearchSongResponse;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.client.utils.CIOKt;
import io.ktor.http.CodecsKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.reflect.TypeInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class KuGou {
    public static final KuGou INSTANCE = new KuGou();
    public static final Regex ACCEPTED_REGEX = new Regex("\\[(\\d\\d):(\\d\\d)\\.(\\d{2,3})\\].*");
    public static final Regex BANNED_REGEX = new Regex(".+].+[:：].+");

    /* JADX INFO: renamed from: com.metrolist.kugou.KuGou$downloadLyrics$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public long J$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KuGou.this.downloadLyrics(0L, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.kugou.KuGou$getAllPossibleLyricsOptions$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01321 extends ContinuationImpl {
        public int I$0;
        public Object L$10;
        public KuGou L$11;
        public Function1 L$3;
        public Keyword L$4;
        public Iterator L$6;
        public Base64.Default L$9;
        public int label;
        public /* synthetic */ Object result;

        public C01321(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KuGou.this.getAllPossibleLyricsOptions(null, null, 0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.kugou.KuGou$getLyricsCandidate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01331 extends ContinuationImpl {
        public int I$0;
        public Keyword L$0;
        public Iterator L$2;
        public int label;
        public /* synthetic */ Object result;

        public C01331(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KuGou.this.getLyricsCandidate(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.kugou.KuGou$searchLyricsByHash$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01341 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01341(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KuGou.this.searchLyricsByHash(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.kugou.KuGou$searchLyricsByKeyword$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01351 extends ContinuationImpl {
        public int I$0;
        public int label;
        public /* synthetic */ Object result;

        public C01351(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KuGou.this.searchLyricsByKeyword(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.kugou.KuGou$searchSongs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01361 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01361(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KuGou.this.searchSongs(null, this);
        }
    }

    public static Keyword generateKeyword(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        Pattern patternCompile = Pattern.compile("\\(.*\\)");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(str).replaceAll("");
        strReplaceAll.getClass();
        Pattern patternCompile2 = Pattern.compile("（.*）");
        patternCompile2.getClass();
        String strReplaceAll2 = patternCompile2.matcher(strReplaceAll).replaceAll("");
        strReplaceAll2.getClass();
        Pattern patternCompile3 = Pattern.compile("「.*」");
        patternCompile3.getClass();
        String strReplaceAll3 = patternCompile3.matcher(strReplaceAll2).replaceAll("");
        strReplaceAll3.getClass();
        Pattern patternCompile4 = Pattern.compile("『.*』");
        patternCompile4.getClass();
        String strReplaceAll4 = patternCompile4.matcher(strReplaceAll3).replaceAll("");
        strReplaceAll4.getClass();
        Pattern patternCompile5 = Pattern.compile("<.*>");
        patternCompile5.getClass();
        String strReplaceAll5 = patternCompile5.matcher(strReplaceAll4).replaceAll("");
        strReplaceAll5.getClass();
        Pattern patternCompile6 = Pattern.compile("《.*》");
        patternCompile6.getClass();
        String strReplaceAll6 = patternCompile6.matcher(strReplaceAll5).replaceAll("");
        strReplaceAll6.getClass();
        Pattern patternCompile7 = Pattern.compile("〈.*〉");
        patternCompile7.getClass();
        String strReplaceAll7 = patternCompile7.matcher(strReplaceAll6).replaceAll("");
        strReplaceAll7.getClass();
        Pattern patternCompile8 = Pattern.compile("＜.*＞");
        patternCompile8.getClass();
        String strReplaceAll8 = patternCompile8.matcher(strReplaceAll7).replaceAll("");
        strReplaceAll8.getClass();
        String strReplace = StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(str2, ", ", "、", false), " & ", "、", false), ".", "", false), "和", "、", false);
        Pattern patternCompile9 = Pattern.compile("\\(.*\\)");
        patternCompile9.getClass();
        String strReplaceAll9 = patternCompile9.matcher(strReplace).replaceAll("");
        strReplaceAll9.getClass();
        Pattern patternCompile10 = Pattern.compile("（.*）");
        patternCompile10.getClass();
        String strReplaceAll10 = patternCompile10.matcher(strReplaceAll9).replaceAll("");
        strReplaceAll10.getClass();
        return new Keyword(strReplaceAll8, strReplaceAll10, str3);
    }

    public static String normalize(String str) {
        Regex regex;
        int i;
        int i2;
        List listLines = StringsKt.lines(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listLines) {
            if (ACCEPTED_REGEX.matches((String) obj)) {
                arrayList.add(obj);
            }
        }
        int iMin = Integer.min(30, arrayList.size() - 1);
        while (true) {
            regex = BANNED_REGEX;
            i = 0;
            if (-1 >= iMin) {
                i2 = 0;
                break;
            }
            if (regex.matches((CharSequence) arrayList.get(iMin))) {
                i2 = iMin + 1;
                break;
            }
            iMin--;
        }
        List listDrop = CollectionsKt.drop(arrayList, i2);
        for (int iMin2 = Integer.min(arrayList.size() - 30, arrayList.size() - 1); -1 < iMin2; iMin2--) {
            if (regex.matches((CharSequence) arrayList.get((arrayList.size() - 1) - iMin2))) {
                i = iMin2 + 1;
                break;
            }
        }
        return CollectionsKt.joinToString$default(CollectionsKt.dropLast(i, listDrop), "\n", null, null, null, 62);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a8, code lost:
    
        if (r7 == r4) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object downloadLyrics(long j, String str, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        TypeReference typeReferenceTypeOf;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objExecute = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    j = anonymousClass1.J$0;
                    ResultKt.throwOnFailure(objExecute);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objExecute);
                }
                if (objExecute != null) {
                    return (DownloadLyricsResponse) objExecute;
                }
                PathKt$$ExternalSyntheticBUOutline0.m("null cannot be cast to non-null type com.metrolist.kugou.models.DownloadLyricsResponse");
                return null;
            }
            ResultKt.throwOnFailure(objExecute);
            HttpClient httpClient = KuGouKt.client;
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            HttpRequestKt.url(httpRequestBuilder, "https://lyrics.kugou.com/download");
            UtilsKt.parameter(httpRequestBuilder, "fmt", "lrc");
            UtilsKt.parameter(httpRequestBuilder, HttpAuthHeader.Parameters.Charset, "utf8");
            UtilsKt.parameter(httpRequestBuilder, "client", "pc");
            UtilsKt.parameter(httpRequestBuilder, "ver", new Integer(1));
            UtilsKt.parameter(httpRequestBuilder, "id", new Long(j));
            UtilsKt.parameter(httpRequestBuilder, "accesskey", str);
            HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
            anonymousClass1.J$0 = j;
            anonymousClass1.label = 1;
            objExecute = httpStatementM.execute(anonymousClass1);
            if (objExecute != coroutineSingletons) {
            }
            return coroutineSingletons;
            typeReferenceTypeOf = Reflection.typeOf(DownloadLyricsResponse.class);
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        HttpClientCall call = ((HttpResponse) objExecute).getCall();
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DownloadLyricsResponse.class);
        TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
        anonymousClass1.J$0 = j;
        anonymousClass1.label = 2;
        objExecute = call.bodyNullable(typeInfo, anonymousClass1);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:30:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:38:0x0101  */
    /* JADX WARN: Code duplicated, block: B:41:0x011f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00d6 -> B:44:0x0138). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00ff -> B:43:0x0136). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x011f -> B:42:0x0120). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x018a -> B:56:0x018b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object getAllPossibleLyricsOptions(java.lang.String r18, java.lang.String r19, int r20, java.lang.String r21, kotlin.jvm.functions.Function1 r22, kotlin.coroutines.jvm.internal.ContinuationImpl r23) {
        /*
            Method dump skipped, instruction units count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.kugou.KuGou.getAllPossibleLyricsOptions(java.lang.String, java.lang.String, int, java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: getLyrics-yxL6bBk, reason: not valid java name */
    public final Serializable m1049getLyricsyxL6bBk(int i, String str, String str2, String str3, ContinuationImpl continuationImpl) {
        KuGou$getLyrics$1 kuGou$getLyrics$1;
        Base64.Default r7;
        if (continuationImpl instanceof KuGou$getLyrics$1) {
            kuGou$getLyrics$1 = (KuGou$getLyrics$1) continuationImpl;
            int i2 = kuGou$getLyrics$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                kuGou$getLyrics$1.label = i2 - Integer.MIN_VALUE;
            } else {
                kuGou$getLyrics$1 = new KuGou$getLyrics$1(this, continuationImpl);
            }
        } else {
            kuGou$getLyrics$1 = new KuGou$getLyrics$1(this, continuationImpl);
        }
        Object lyricsCandidate = kuGou$getLyrics$1.result;
        int i3 = kuGou$getLyrics$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(lyricsCandidate);
                Keyword keywordGenerateKeyword = generateKeyword(str, str2, str3);
                kuGou$getLyrics$1.L$3 = this;
                kuGou$getLyrics$1.I$0 = i;
                kuGou$getLyrics$1.label = 1;
                lyricsCandidate = getLyricsCandidate(keywordGenerateKeyword, i, kuGou$getLyrics$1);
                if (lyricsCandidate == coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i3 == 1) {
                i = kuGou$getLyrics$1.I$0;
                this = kuGou$getLyrics$1.L$3;
                ResultKt.throwOnFailure(lyricsCandidate);
            } else {
                if (i3 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                this = kuGou$getLyrics$1.L$7;
                r7 = kuGou$getLyrics$1.L$6;
                ResultKt.throwOnFailure(lyricsCandidate);
            }
            String strDecodeToString = StringsKt__StringsJVMKt.decodeToString(Base64.decode$default(r7, ((DownloadLyricsResponse) lyricsCandidate).content, 0, 6));
            this.getClass();
            return normalize(strDecodeToString);
            SearchLyricsResponse.Candidate candidate = (SearchLyricsResponse.Candidate) lyricsCandidate;
            if (candidate == null) {
                throw new IllegalStateException("No lyrics candidate");
            }
            Base64.Default r8 = Base64.Default;
            long j = candidate.id;
            String str4 = candidate.accesskey;
            kuGou$getLyrics$1.L$3 = null;
            kuGou$getLyrics$1.L$6 = r8;
            kuGou$getLyrics$1.L$7 = this;
            kuGou$getLyrics$1.I$0 = i;
            kuGou$getLyrics$1.label = 2;
            lyricsCandidate = this.downloadLyrics(j, str4, kuGou$getLyrics$1);
            if (lyricsCandidate != coroutineSingletons) {
                r7 = r8;
                String strDecodeToString2 = StringsKt__StringsJVMKt.decodeToString(Base64.decode$default(r7, ((DownloadLyricsResponse) lyricsCandidate).content, 0, 6));
                this.getClass();
                return normalize(strDecodeToString2);
            }
            return coroutineSingletons;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006a  */
    /* JADX WARN: Code duplicated, block: B:26:0x0073  */
    /* JADX WARN: Code duplicated, block: B:39:0x009e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x007e A[REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
    
        if (r11 == r6) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008e, code lost:
    
        if (r11 == r6) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00aa, code lost:
    
        if (r11 == r6) goto L36;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008e -> B:31:0x0091). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getLyricsCandidate(Keyword keyword, int i, ContinuationImpl continuationImpl) {
        C01331 c01331;
        Keyword keyword2;
        int i2;
        Iterator it;
        SearchSongResponse.Data.Info info;
        if (continuationImpl instanceof C01331) {
            c01331 = (C01331) continuationImpl;
            int i3 = c01331.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c01331.label = i3 - Integer.MIN_VALUE;
            } else {
                c01331 = new C01331(continuationImpl);
            }
        } else {
            c01331 = new C01331(continuationImpl);
        }
        Object objSearchSongs = c01331.result;
        int i4 = c01331.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i4 != 0) {
            if (i4 == 1) {
                i = c01331.I$0;
                keyword = c01331.L$0;
                ResultKt.throwOnFailure(objSearchSongs);
            } else if (i4 == 2) {
                i2 = c01331.I$0;
                it = c01331.L$2;
                keyword2 = c01331.L$0;
                ResultKt.throwOnFailure(objSearchSongs);
                SearchLyricsResponse.Candidate candidate = (SearchLyricsResponse.Candidate) CollectionsKt.firstOrNull(((SearchLyricsResponse) objSearchSongs).candidates);
                if (candidate != null) {
                    return candidate;
                }
                do {
                    if (it.hasNext()) {
                        info = (SearchSongResponse.Data.Info) it.next();
                        if (i2 != -1) {
                        }
                        String str = info.hash;
                        c01331.L$0 = keyword2;
                        c01331.L$2 = it;
                        c01331.I$0 = i2;
                        c01331.label = 2;
                        objSearchSongs = INSTANCE.searchLyricsByHash(str, c01331);
                    } else {
                        c01331.L$0 = null;
                        c01331.L$2 = null;
                        c01331.I$0 = i2;
                        c01331.label = 3;
                        objSearchSongs = searchLyricsByKeyword(keyword2, i2, c01331);
                    }
                    return obj;
                } while (Math.abs(info.duration - i2) > 8);
                String str2 = info.hash;
                c01331.L$0 = keyword2;
                c01331.L$2 = it;
                c01331.I$0 = i2;
                c01331.label = 2;
                objSearchSongs = INSTANCE.searchLyricsByHash(str2, c01331);
            } else {
                if (i4 != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objSearchSongs);
            }
            return CollectionsKt.firstOrNull(((SearchLyricsResponse) objSearchSongs).candidates);
        }
        ResultKt.throwOnFailure(objSearchSongs);
        c01331.L$0 = keyword;
        c01331.I$0 = i;
        c01331.label = 1;
        objSearchSongs = searchSongs(keyword, c01331);
        keyword2 = keyword;
        i2 = i;
        it = ((SearchSongResponse) objSearchSongs).data.info.iterator();
        do {
            if (it.hasNext()) {
                info = (SearchSongResponse.Data.Info) it.next();
                if (i2 != -1) {
                }
                String str3 = info.hash;
                c01331.L$0 = keyword2;
                c01331.L$2 = it;
                c01331.I$0 = i2;
                c01331.label = 2;
                objSearchSongs = INSTANCE.searchLyricsByHash(str3, c01331);
            } else {
                c01331.L$0 = null;
                c01331.L$2 = null;
                c01331.I$0 = i2;
                c01331.label = 3;
                objSearchSongs = searchLyricsByKeyword(keyword2, i2, c01331);
            }
            return obj;
        } while (Math.abs(info.duration - i2) > 8);
        String str4 = info.hash;
        c01331.L$0 = keyword2;
        c01331.L$2 = it;
        c01331.I$0 = i2;
        c01331.label = 2;
        objSearchSongs = INSTANCE.searchLyricsByHash(str4, c01331);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
    
        if (r7 == r4) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object searchLyricsByHash(String str, ContinuationImpl continuationImpl) {
        C01341 c01341;
        TypeReference typeReferenceTypeOf;
        if (continuationImpl instanceof C01341) {
            c01341 = (C01341) continuationImpl;
            int i = c01341.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01341.label = i - Integer.MIN_VALUE;
            } else {
                c01341 = new C01341(continuationImpl);
            }
        } else {
            c01341 = new C01341(continuationImpl);
        }
        Object objExecute = c01341.result;
        int i2 = c01341.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objExecute);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objExecute);
                }
                if (objExecute != null) {
                    return (SearchLyricsResponse) objExecute;
                }
                PathKt$$ExternalSyntheticBUOutline0.m("null cannot be cast to non-null type com.metrolist.kugou.models.SearchLyricsResponse");
                return null;
            }
            ResultKt.throwOnFailure(objExecute);
            HttpClient httpClient = KuGouKt.client;
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            HttpRequestKt.url(httpRequestBuilder, "https://lyrics.kugou.com/search");
            UtilsKt.parameter(httpRequestBuilder, "ver", new Integer(1));
            UtilsKt.parameter(httpRequestBuilder, "man", "yes");
            UtilsKt.parameter(httpRequestBuilder, "client", "pc");
            UtilsKt.parameter(httpRequestBuilder, "hash", str);
            HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
            c01341.label = 1;
            objExecute = httpStatementM.execute(c01341);
            if (objExecute != coroutineSingletons) {
            }
            return coroutineSingletons;
            typeReferenceTypeOf = Reflection.typeOf(SearchLyricsResponse.class);
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        HttpClientCall call = ((HttpResponse) objExecute).getCall();
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SearchLyricsResponse.class);
        TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
        c01341.label = 2;
        objExecute = call.bodyNullable(typeInfo, c01341);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ee, code lost:
    
        if (r9 == r5) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object searchLyricsByKeyword(Keyword keyword, int i, ContinuationImpl continuationImpl) {
        C01351 c01351;
        TypeReference typeReferenceTypeOf;
        if (continuationImpl instanceof C01351) {
            c01351 = (C01351) continuationImpl;
            int i2 = c01351.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c01351.label = i2 - Integer.MIN_VALUE;
            } else {
                c01351 = new C01351(continuationImpl);
            }
        } else {
            c01351 = new C01351(continuationImpl);
        }
        Object objExecute = c01351.result;
        int i3 = c01351.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    i = c01351.I$0;
                    ResultKt.throwOnFailure(objExecute);
                } else {
                    if (i3 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objExecute);
                }
                if (objExecute != null) {
                    return (SearchLyricsResponse) objExecute;
                }
                PathKt$$ExternalSyntheticBUOutline0.m("null cannot be cast to non-null type com.metrolist.kugou.models.SearchLyricsResponse");
                return null;
            }
            ResultKt.throwOnFailure(objExecute);
            HttpClient httpClient = KuGouKt.client;
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            HttpRequestKt.url(httpRequestBuilder, "https://lyrics.kugou.com/search");
            UtilsKt.parameter(httpRequestBuilder, "ver", new Integer(1));
            UtilsKt.parameter(httpRequestBuilder, "man", "yes");
            UtilsKt.parameter(httpRequestBuilder, "client", "pc");
            Integer num = new Integer(i);
            if (num.intValue() == -1) {
                num = null;
            }
            UtilsKt.parameter(httpRequestBuilder, "duration", num != null ? new Integer(num.intValue() * CIOKt.DEFAULT_HTTP_POOL_SIZE) : null);
            String str = keyword.title;
            String str2 = keyword.album;
            StringBuilder sb = new StringBuilder(str);
            sb.append(" - ");
            sb.append(keyword.artist);
            if (str2 != null && !StringsKt.isBlank(str2)) {
                sb.append(ServerSentEventKt.SPACE);
                sb.append(str2);
            }
            httpRequestBuilder.getUrl().getEncodedParameters().append("keyword", CodecsKt.encodeURLParameter(sb.toString(), false));
            HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
            c01351.I$0 = i;
            c01351.label = 1;
            objExecute = httpStatementM.execute(c01351);
            if (objExecute != coroutineSingletons) {
            }
            return coroutineSingletons;
            typeReferenceTypeOf = Reflection.typeOf(SearchLyricsResponse.class);
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        HttpClientCall call = ((HttpResponse) objExecute).getCall();
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SearchLyricsResponse.class);
        TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
        c01351.I$0 = i;
        c01351.label = 2;
        objExecute = call.bodyNullable(typeInfo, c01351);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00da, code lost:
    
        if (r9 == r5) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object searchSongs(Keyword keyword, ContinuationImpl continuationImpl) {
        C01361 c01361;
        TypeReference typeReferenceTypeOf;
        if (continuationImpl instanceof C01361) {
            c01361 = (C01361) continuationImpl;
            int i = c01361.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01361.label = i - Integer.MIN_VALUE;
            } else {
                c01361 = new C01361(continuationImpl);
            }
        } else {
            c01361 = new C01361(continuationImpl);
        }
        Object objExecute = c01361.result;
        int i2 = c01361.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objExecute);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objExecute);
                }
                if (objExecute != null) {
                    return (SearchSongResponse) objExecute;
                }
                PathKt$$ExternalSyntheticBUOutline0.m("null cannot be cast to non-null type com.metrolist.kugou.models.SearchSongResponse");
                return null;
            }
            ResultKt.throwOnFailure(objExecute);
            HttpClient httpClient = KuGouKt.client;
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            HttpRequestKt.url(httpRequestBuilder, "https://mobileservice.kugou.com/api/v3/search/song");
            UtilsKt.parameter(httpRequestBuilder, "version", new Integer(9108));
            UtilsKt.parameter(httpRequestBuilder, "plat", new Integer(0));
            UtilsKt.parameter(httpRequestBuilder, "pagesize", new Integer(8));
            UtilsKt.parameter(httpRequestBuilder, "showtype", new Integer(0));
            String str = keyword.title;
            String str2 = keyword.album;
            StringBuilder sb = new StringBuilder(str);
            sb.append(" - ");
            sb.append(keyword.artist);
            if (str2 != null && !StringsKt.isBlank(str2)) {
                sb.append(ServerSentEventKt.SPACE);
                sb.append(str2);
            }
            httpRequestBuilder.getUrl().getEncodedParameters().append("keyword", CodecsKt.encodeURLParameter(sb.toString(), false));
            HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
            c01361.label = 1;
            objExecute = httpStatementM.execute(c01361);
            if (objExecute != coroutineSingletons) {
            }
            return coroutineSingletons;
            typeReferenceTypeOf = Reflection.typeOf(SearchSongResponse.class);
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        HttpClientCall call = ((HttpResponse) objExecute).getCall();
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SearchSongResponse.class);
        TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
        c01361.label = 2;
        objExecute = call.bodyNullable(typeInfo, c01361);
    }
}
