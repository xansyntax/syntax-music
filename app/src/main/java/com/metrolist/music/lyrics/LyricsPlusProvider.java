package com.metrolist.music.lyrics;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.metrolist.music.constants.PreferenceKeysKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.client.utils.CIOKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.http.LinkHeader;
import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
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
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsPlusProvider implements LyricsProvider {
    public static final LyricsPlusProvider INSTANCE = new LyricsPlusProvider();
    public static final SynchronizedLazyImpl ISRC_REGEX$delegate = new SynchronizedLazyImpl(new LyricLine$$ExternalSyntheticLambda0((byte) 10));
    public static final List baseUrls = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"https://lyricsplus.binimum.org", "https://lyricsplus.atomix.one/", "https://lyricsplus.prjktla.my.id", "https://lyricsplus-seven.vercel.app"});
    public static final SynchronizedLazyImpl client$delegate = new SynchronizedLazyImpl(new LyricLine$$ExternalSyntheticLambda0((byte) 11));
    public static volatile String lastWorkingServer;

    /* JADX INFO: renamed from: com.metrolist.music.lyrics.LyricsPlusProvider$fetchBinimumLyricsApi$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public String L$1;
        public String L$2;
        public String L$3;
        public Object L$8;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LyricsPlusProvider.this.fetchBinimumLyricsApi(0, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.lyrics.LyricsPlusProvider$fetchFromUrl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01571 extends ContinuationImpl {
        public int I$0;
        public int label;
        public /* synthetic */ Object result;

        public C01571(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LyricsPlusProvider.this.fetchFromUrl(0, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.lyrics.LyricsPlusProvider$fetchLyrics$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01581 extends ContinuationImpl {
        public int I$0;
        public String L$0;
        public String L$1;
        public String L$2;
        public Iterator L$3;
        public String L$4;
        public int label;
        public /* synthetic */ Object result;

        public C01581(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LyricsPlusProvider.this.fetchLyrics(0, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.lyrics.LyricsPlusProvider$getAllLyrics$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01591 extends ContinuationImpl {
        public Function1 L$5;
        public int label;
        public /* synthetic */ Object result;

        public C01591(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LyricsPlusProvider.this.getAllLyrics(null, null, null, null, 0, null, null, this);
        }
    }

    public static void appendLrcLine(StringBuilder sb, long j, String str, String str2) {
        long j2 = j / 60000;
        long j3 = (j % 60000) / 1000;
        long j4 = (j % 1000) / 10;
        StringBuilder sb2 = new StringBuilder("[");
        if (j2 < 10) {
            sb2.append('0');
        }
        sb2.append(j2);
        sb2.append(':');
        if (j3 < 10) {
            sb2.append('0');
        }
        sb2.append(j3);
        sb2.append('.');
        if (j4 < 10) {
            sb2.append('0');
        }
        sb2.append(j4);
        sb2.append(']');
        sb.append(sb2.toString());
        sb.append(str);
        sb.append(str2);
        sb.append('\n');
    }

    public static void appendWordBlock(StringBuilder sb, List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!StringsKt.isBlank(((LyricWord) obj).text)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        sb.append('<');
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            LyricWord lyricWord = (LyricWord) obj2;
            long j = lyricWord.time;
            double d = j / 1000.0d;
            double d2 = (j + lyricWord.duration) / 1000.0d;
            sb.append(StringsKt.trim(lyricWord.text).toString());
            sb.append(':');
            sb.append(d);
            sb.append(':');
            sb.append(d2);
            if (i < arrayList.size() - 1) {
                sb.append('|');
            }
            i = i3;
        }
        sb.append(">\n");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x007a, code lost:
    
        r8 = r3.values();
        r8.getClass();
        r8 = kotlin.collections.CollectionsKt.toSet(r8);
        r9 = kotlin.collections.CollectionsKt__IterablesKt.listOf((java.lang.Object[]) new java.lang.String[]{"v1", "v2"}).iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0097, code lost:
    
        if (r9.hasNext() == false) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0099, code lost:
    
        r10 = r9.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a4, code lost:
    
        if (r8.contains((java.lang.String) r10) != false) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a7, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a8, code lost:
    
        r10 = (java.lang.String) r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00aa, code lost:
    
        if (r10 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ad, code lost:
    
        r7 = r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3, types: [java.lang.Iterable, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.Collection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String convertToLrc(LyricsPlusResponse lyricsPlusResponse) {
        List<LyricLine> list;
        List list2;
        ?? arrayList;
        List list3;
        String string;
        String lowerCase;
        String str;
        String str2;
        if (lyricsPlusResponse != null && (list = lyricsPlusResponse.lyrics) != null) {
            if (list.isEmpty()) {
                list = null;
            }
            if (list != null) {
                boolean z = true;
                boolean zEquals = StringsKt__StringsJVMKt.equals(lyricsPlusResponse.type, "Word", true);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator it = list.iterator();
                while (true) {
                    String str3 = "v1";
                    if (!it.hasNext()) {
                        break;
                    }
                    LineElement lineElement = ((LyricLine) it.next()).element;
                    if (lineElement != null && (str2 = lineElement.singer) != null) {
                        String lowerCase2 = str2.toLowerCase(Locale.ROOT);
                        lowerCase2.getClass();
                        if (!linkedHashMap.containsKey(lowerCase2)) {
                            str3 = (r8 = lowerCase2.hashCode()) != 3707 ? lowerCase2 : lowerCase2;
                            linkedHashMap.put(lowerCase2, str3);
                        }
                    }
                }
                byte b = 0;
                boolean z2 = linkedHashMap.size() > 1 || (linkedHashMap.size() == 1 && !linkedHashMap.containsKey("v1"));
                StringBuilder sb = new StringBuilder(list.size() * 128);
                boolean z3 = false;
                for (LyricLine lyricLine : list) {
                    List list4 = lyricLine.syllabus;
                    String str4 = lyricLine.text;
                    EmptyList emptyList = EmptyList.INSTANCE;
                    if (list4 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : list4) {
                            if (!((LyricWord) obj).isBackground) {
                                arrayList2.add(obj);
                            }
                        }
                        list2 = arrayList2;
                    } else {
                        list2 = emptyList;
                    }
                    if (list4 != null) {
                        arrayList = new ArrayList();
                        for (Object obj2 : list4) {
                            if (((LyricWord) obj2).isBackground) {
                                arrayList.add(obj2);
                            }
                        }
                    } else {
                        arrayList = emptyList;
                    }
                    boolean z4 = (list4 == null || !list2.isEmpty() || arrayList.isEmpty()) ? false : z;
                    if (!zEquals || list2.isEmpty()) {
                        list3 = list2;
                        string = z4 ? "" : StringsKt.trim(str4).toString();
                    } else {
                        list3 = list2;
                        string = StringsKt.trim(CollectionsKt.joinToString$default(list2, "", null, null, new LyricsPlusProvider$$ExternalSyntheticLambda6(b), 30)).toString();
                    }
                    if (!StringsKt.isBlank(string)) {
                        LineElement lineElement2 = lyricLine.element;
                        if (lineElement2 == null || (str = lineElement2.singer) == null) {
                            lowerCase = null;
                        } else {
                            lowerCase = str.toLowerCase(Locale.ROOT);
                            lowerCase.getClass();
                        }
                        String str5 = (String) linkedHashMap.get(lowerCase);
                        appendLrcLine(sb, lyricLine.time, (!z2 || str5 == null) ? "" : IntIntPair$$ExternalSyntheticOutline0.m("{agent:", str5, "}"), string);
                        if (zEquals && !list3.isEmpty()) {
                            appendWordBlock(sb, list3);
                        }
                        z3 = false;
                    }
                    ?? r17 = !arrayList.isEmpty() ? arrayList : emptyList;
                    if (!r17.isEmpty()) {
                        String string2 = zEquals ? StringsKt.trim(CollectionsKt.joinToString$default(r17, "", null, null, new LyricsPlusProvider$$ExternalSyntheticLambda6(b), 30)).toString() : StringsKt.trim(str4).toString();
                        if (!StringsKt.isBlank(string2)) {
                            Iterator it2 = r17.iterator();
                            if (!it2.hasNext()) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                                return null;
                            }
                            long j = ((LyricWord) it2.next()).time;
                            while (it2.hasNext()) {
                                long j2 = ((LyricWord) it2.next()).time;
                                if (j > j2) {
                                    j = j2;
                                }
                            }
                            appendLrcLine(sb, j, z3 ? "" : "{bg}", string2);
                            if (zEquals) {
                                appendWordBlock(sb, r17);
                            }
                            z = true;
                            z3 = true;
                        }
                    }
                    z = true;
                }
                String string3 = StringsKt.trimEnd(sb.toString()).toString();
                if (StringsKt.isBlank(string3)) {
                    return null;
                }
                return string3;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object fetchBinimumLyricsApi$requestByIsrc(String str, ContinuationImpl continuationImpl) {
        LyricsPlusProvider$fetchBinimumLyricsApi$requestByIsrc$1 lyricsPlusProvider$fetchBinimumLyricsApi$requestByIsrc$1;
        Object failure;
        if (continuationImpl instanceof LyricsPlusProvider$fetchBinimumLyricsApi$requestByIsrc$1) {
            lyricsPlusProvider$fetchBinimumLyricsApi$requestByIsrc$1 = (LyricsPlusProvider$fetchBinimumLyricsApi$requestByIsrc$1) continuationImpl;
            int i = lyricsPlusProvider$fetchBinimumLyricsApi$requestByIsrc$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                lyricsPlusProvider$fetchBinimumLyricsApi$requestByIsrc$1.label = i - Integer.MIN_VALUE;
            } else {
                lyricsPlusProvider$fetchBinimumLyricsApi$requestByIsrc$1 = new LyricsPlusProvider$fetchBinimumLyricsApi$requestByIsrc$1(continuationImpl);
            }
        } else {
            lyricsPlusProvider$fetchBinimumLyricsApi$requestByIsrc$1 = new LyricsPlusProvider$fetchBinimumLyricsApi$requestByIsrc$1(continuationImpl);
        }
        Object objExecute = lyricsPlusProvider$fetchBinimumLyricsApi$requestByIsrc$1.result;
        int i2 = lyricsPlusProvider$fetchBinimumLyricsApi$requestByIsrc$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute);
                HttpClient httpClient = (HttpClient) client$delegate.getValue();
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder, "https://lyrics-api.binimum.org/");
                UtilsKt.parameter(httpRequestBuilder, "isrc", str);
                httpRequestBuilder.setMethod(HttpMethod.Get);
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                lyricsPlusProvider$fetchBinimumLyricsApi$requestByIsrc$1.label = 1;
                objExecute = httpStatement.execute(lyricsPlusProvider$fetchBinimumLyricsApi$requestByIsrc$1);
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
            failure = (HttpResponse) objExecute;
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (failure instanceof Result.Failure) {
            return null;
        }
        return failure;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object fetchBinimumLyricsApi$requestByTrackMetadata(int i, String str, String str2, String str3, ContinuationImpl continuationImpl) {
        LyricsPlusProvider$fetchBinimumLyricsApi$requestByTrackMetadata$1 lyricsPlusProvider$fetchBinimumLyricsApi$requestByTrackMetadata$1;
        Object failure;
        if (continuationImpl instanceof LyricsPlusProvider$fetchBinimumLyricsApi$requestByTrackMetadata$1) {
            lyricsPlusProvider$fetchBinimumLyricsApi$requestByTrackMetadata$1 = (LyricsPlusProvider$fetchBinimumLyricsApi$requestByTrackMetadata$1) continuationImpl;
            int i2 = lyricsPlusProvider$fetchBinimumLyricsApi$requestByTrackMetadata$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                lyricsPlusProvider$fetchBinimumLyricsApi$requestByTrackMetadata$1.label = i2 - Integer.MIN_VALUE;
            } else {
                lyricsPlusProvider$fetchBinimumLyricsApi$requestByTrackMetadata$1 = new LyricsPlusProvider$fetchBinimumLyricsApi$requestByTrackMetadata$1(continuationImpl);
            }
        } else {
            lyricsPlusProvider$fetchBinimumLyricsApi$requestByTrackMetadata$1 = new LyricsPlusProvider$fetchBinimumLyricsApi$requestByTrackMetadata$1(continuationImpl);
        }
        Object objExecute = lyricsPlusProvider$fetchBinimumLyricsApi$requestByTrackMetadata$1.result;
        int i3 = lyricsPlusProvider$fetchBinimumLyricsApi$requestByTrackMetadata$1.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(objExecute);
                HttpClient httpClient = (HttpClient) client$delegate.getValue();
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder, "https://lyrics-api.binimum.org/");
                UtilsKt.parameter(httpRequestBuilder, "track", str);
                UtilsKt.parameter(httpRequestBuilder, "artist", str2);
                if (str3 != null && !StringsKt.isBlank(str3)) {
                    UtilsKt.parameter(httpRequestBuilder, "album", str3);
                }
                if (i > 0) {
                    UtilsKt.parameter(httpRequestBuilder, "duration", new Integer(i));
                }
                httpRequestBuilder.setMethod(HttpMethod.Get);
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                lyricsPlusProvider$fetchBinimumLyricsApi$requestByTrackMetadata$1.label = 1;
                objExecute = httpStatement.execute(lyricsPlusProvider$fetchBinimumLyricsApi$requestByTrackMetadata$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objExecute == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i3 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objExecute);
            }
            failure = (HttpResponse) objExecute;
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (failure instanceof Result.Failure) {
            return null;
        }
        return failure;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01db  */
    /* JADX WARN: Code duplicated, block: B:101:0x01dc A[Catch: all -> 0x0047, PHI: r8 r9 r10 r11 r12
      0x01dc: PHI (r8v28 java.lang.Object) = (r8v18 java.lang.Object), (r8v1 java.lang.Object) binds: [B:99:0x01d9, B:18:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x01dc: PHI (r9v5 int) = (r9v34 int), (r9v35 int) binds: [B:99:0x01d9, B:18:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x01dc: PHI (r10v7 ??) = (r10v36 ??), (r10v37 ??) binds: [B:99:0x01d9, B:18:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x01dc: PHI (r11v5 ??) = (r11v22 ??), (r11v23 ??) binds: [B:99:0x01d9, B:18:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x01dc: PHI (r12v12 ??) = (r12v28 ??), (r12v29 ??) binds: [B:99:0x01d9, B:18:0x0042] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #3 {all -> 0x0047, blocks: (B:18:0x0042, B:101:0x01dc, B:98:0x01aa), top: B:167:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:109:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:111:0x0203 A[Catch: all -> 0x0035, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0035, blocks: (B:13:0x0030, B:119:0x0232, B:120:0x0235, B:121:0x023c, B:111:0x0203, B:115:0x0213), top: B:167:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x024c  */
    /* JADX WARN: Code duplicated, block: B:135:0x0261  */
    /* JADX WARN: Code duplicated, block: B:138:0x026f  */
    /* JADX WARN: Code duplicated, block: B:141:0x0274  */
    /* JADX WARN: Code duplicated, block: B:144:0x027b  */
    /* JADX WARN: Code duplicated, block: B:152:0x0297  */
    /* JADX WARN: Code duplicated, block: B:155:0x029c  */
    /* JADX WARN: Code duplicated, block: B:158:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:160:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:165:0x024f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x027e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x019d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x0196 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x0185 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:57:0x0113  */
    /* JADX WARN: Code duplicated, block: B:59:0x011e  */
    /* JADX WARN: Code duplicated, block: B:62:0x012a A[Catch: all -> 0x0059, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x0059, blocks: (B:23:0x0054, B:70:0x015a, B:71:0x015d, B:72:0x0164, B:62:0x012a, B:66:0x013a), top: B:167:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0156  */
    /* JADX WARN: Code duplicated, block: B:69:0x0158 A[DONT_INVERT, PHI: r8 r9 r10 r11
      0x0158: PHI (r8v77 java.lang.Object) = (r8v72 java.lang.Object), (r8v1 java.lang.Object) binds: [B:67:0x0154, B:23:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x0158: PHI (r9v23 int) = (r9v36 int), (r9v37 int) binds: [B:67:0x0154, B:23:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x0158: PHI (r10v33 boolean) = (r10v38 boolean), (r10v39 boolean) binds: [B:67:0x0154, B:23:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x0158: PHI (r11v19 int) = (r11v24 int), (r11v25 int) binds: [B:67:0x0154, B:23:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:70:0x015a A[Catch: all -> 0x0059, TryCatch #5 {all -> 0x0059, blocks: (B:23:0x0054, B:70:0x015a, B:71:0x015d, B:72:0x0164, B:62:0x012a, B:66:0x013a), top: B:167:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x015d A[Catch: all -> 0x0059, TryCatch #5 {all -> 0x0059, blocks: (B:23:0x0054, B:70:0x015a, B:71:0x015d, B:72:0x0164, B:62:0x012a, B:66:0x013a), top: B:167:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0170  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:80:0x0177  */
    /* JADX WARN: Code duplicated, block: B:83:0x0181  */
    /* JADX WARN: Code duplicated, block: B:86:0x018b  */
    /* JADX WARN: Code duplicated, block: B:95:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:97:0x01a8  */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x022d, code lost:
    
        if (r8 == r5) goto L117;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v3, types: [int] */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v11, types: [int] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.metrolist.music.lyrics.BinimumLyricsResult] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchBinimumLyricsApi(int i, String str, String str2, String str3, String str4, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        Object failure;
        int i2;
        ?? r9;
        ?? r12;
        boolean z;
        Object obj;
        Object failure2;
        ?? r11;
        ?? r10;
        int i3;
        boolean z2;
        Object obj2;
        BinimumLyricsApiResponse binimumLyricsApiResponse;
        List list;
        Iterator it;
        Object next;
        BinimumLyricsResult binimumLyricsResult;
        String str5;
        String str6;
        boolean z3;
        Object obj3;
        HttpResponse httpResponse;
        String str7;
        TypeReference typeReferenceTypeOf;
        ?? r13;
        Object failure3;
        List list2;
        Object failure4;
        boolean z4;
        Object obj4;
        String str8;
        ?? r14;
        ?? r15;
        boolean zMatches;
        int i4;
        int i5;
        int i6;
        ?? r16;
        ?? r17;
        boolean z5;
        int i7;
        HttpResponse httpResponse2;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z6;
        boolean z7;
        TypeReference typeReferenceTypeOf2;
        boolean z8;
        int i12;
        boolean z9;
        int i13;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i14 = anonymousClass1.label;
            if ((i14 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i14 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objExecute = anonymousClass1.result;
        int i15 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                try {
                    switch (i15) {
                        case 0:
                            ResultKt.throwOnFailure(objExecute);
                            String upperCase = StringsKt.trim(str).toString().toUpperCase(Locale.ROOT);
                            upperCase.getClass();
                            zMatches = ((Regex) ISRC_REGEX$delegate.getValue()).matches(upperCase);
                            i4 = (StringsKt.isBlank(str2) || StringsKt.isBlank(str3)) ? 0 : 1;
                            if (zMatches || i4 != 0) {
                                if (zMatches) {
                                    anonymousClass1.L$1 = str2;
                                    anonymousClass1.L$2 = str3;
                                    anonymousClass1.L$3 = str4;
                                    anonymousClass1.I$0 = i;
                                    anonymousClass1.Z$0 = zMatches;
                                    anonymousClass1.I$1 = i4;
                                    anonymousClass1.label = 1;
                                    objExecute = fetchBinimumLyricsApi$requestByIsrc(upperCase, anonymousClass1);
                                    if (objExecute != coroutineSingletons) {
                                        i7 = i;
                                        z5 = zMatches;
                                        r17 = str2;
                                        r16 = str3;
                                        httpResponse2 = (HttpResponse) objExecute;
                                        if (httpResponse2 != null) {
                                            anonymousClass1.L$1 = null;
                                            anonymousClass1.L$2 = null;
                                            anonymousClass1.L$3 = null;
                                            anonymousClass1.I$0 = i7;
                                            anonymousClass1.Z$0 = z5;
                                            anonymousClass1.I$1 = i4;
                                            anonymousClass1.label = 2;
                                            objExecute = fetchBinimumLyricsApi$requestByTrackMetadata(i7, r17, r16, str4, anonymousClass1);
                                            if (objExecute != coroutineSingletons) {
                                                i10 = i7;
                                                i11 = i4;
                                                z6 = z5;
                                                httpResponse2 = (HttpResponse) objExecute;
                                                i9 = i11;
                                                z7 = z6;
                                                i8 = i10;
                                                if (httpResponse2 == null) {
                                                    z7 = z5;
                                                    Timber.Forest.tag("LyricsPlus");
                                                    ConnectionPool.w(new Object[0]);
                                                    return null;
                                                }
                                                z7 = z5;
                                                if (HttpStatusCodeKt.isSuccess(httpResponse2.getStatus())) {
                                                    HttpClientCall call = httpResponse2.getCall();
                                                    ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BinimumLyricsApiResponse.class);
                                                    try {
                                                        typeReferenceTypeOf2 = Reflection.typeOf(BinimumLyricsApiResponse.class);
                                                    } catch (Throwable unused) {
                                                        typeReferenceTypeOf2 = null;
                                                    }
                                                    TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf2);
                                                    anonymousClass1.L$1 = null;
                                                    anonymousClass1.L$2 = null;
                                                    anonymousClass1.L$3 = null;
                                                    anonymousClass1.L$8 = null;
                                                    anonymousClass1.I$0 = i8;
                                                    anonymousClass1.Z$0 = z7;
                                                    anonymousClass1.I$1 = i9;
                                                    anonymousClass1.label = 4;
                                                    objExecute = call.bodyNullable(typeInfo, anonymousClass1);
                                                    i13 = i9;
                                                    z9 = z7;
                                                    i12 = i8;
                                                    if (objExecute != coroutineSingletons) {
                                                        if (objExecute != null) {
                                                            throw new NullPointerException("null cannot be cast to non-null type com.metrolist.music.lyrics.BinimumLyricsApiResponse");
                                                        }
                                                        failure = (BinimumLyricsApiResponse) objExecute;
                                                        i3 = i13;
                                                        r10 = z9;
                                                        r11 = i12;
                                                        z2 = failure instanceof Result.Failure;
                                                        obj2 = failure;
                                                        if (z2) {
                                                            obj2 = null;
                                                        }
                                                        binimumLyricsApiResponse = (BinimumLyricsApiResponse) obj2;
                                                        if (binimumLyricsApiResponse != null) {
                                                            list = binimumLyricsApiResponse.results;
                                                            if (!list.isEmpty()) {
                                                                it = list.iterator();
                                                                while (true) {
                                                                    if (it.hasNext()) {
                                                                        next = it.next();
                                                                        str6 = ((BinimumLyricsResult) next).lyricsUrl;
                                                                        if (str6 != null || StringsKt.isBlank(str6)) {
                                                                        }
                                                                    } else {
                                                                        next = null;
                                                                    }
                                                                }
                                                                binimumLyricsResult = (BinimumLyricsResult) next;
                                                                if (binimumLyricsResult != null) {
                                                                    str5 = binimumLyricsResult.lyricsUrl;
                                                                    if (str5 == null) {
                                                                        str5 = "";
                                                                    }
                                                                    HttpClient httpClient = (HttpClient) client$delegate.getValue();
                                                                    HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                                                                    HttpRequestKt.url(httpRequestBuilder, str5);
                                                                    httpRequestBuilder.setMethod(HttpMethod.Get);
                                                                    HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                                                                    anonymousClass1.L$1 = null;
                                                                    anonymousClass1.L$2 = null;
                                                                    anonymousClass1.L$3 = null;
                                                                    anonymousClass1.L$8 = binimumLyricsResult;
                                                                    anonymousClass1.I$0 = r11;
                                                                    anonymousClass1.Z$0 = r10;
                                                                    anonymousClass1.I$1 = i3;
                                                                    anonymousClass1.label = 5;
                                                                    objExecute = httpStatement.execute(anonymousClass1);
                                                                    i = i3;
                                                                    str = r10;
                                                                    str2 = r11;
                                                                    str3 = binimumLyricsResult;
                                                                    if (objExecute == coroutineSingletons) {
                                                                        HttpResponse httpResponse3 = (HttpResponse) objExecute;
                                                                        ?? r7 = str;
                                                                        i2 = i;
                                                                        r9 = str3;
                                                                        r12 = str2;
                                                                        z = r7 == true ? 1 : 0;
                                                                        obj = httpResponse3;
                                                                        z3 = obj instanceof Result.Failure;
                                                                        obj3 = obj;
                                                                        if (z3) {
                                                                            obj3 = null;
                                                                        }
                                                                        httpResponse = (HttpResponse) obj3;
                                                                        if (httpResponse != null) {
                                                                            if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                                                                                HttpClientCall call2 = httpResponse.getCall();
                                                                                ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                                                                                try {
                                                                                    typeReferenceTypeOf = Reflection.typeOf(String.class);
                                                                                } catch (Throwable unused2) {
                                                                                    typeReferenceTypeOf = null;
                                                                                }
                                                                                TypeInfo typeInfo2 = new TypeInfo((KClass<?>) orCreateKotlinClass2, false, (KType) typeReferenceTypeOf);
                                                                                anonymousClass1.L$1 = null;
                                                                                anonymousClass1.L$2 = null;
                                                                                anonymousClass1.L$3 = null;
                                                                                anonymousClass1.L$8 = r9;
                                                                                anonymousClass1.I$0 = r12;
                                                                                anonymousClass1.Z$0 = z;
                                                                                anonymousClass1.I$1 = i2;
                                                                                anonymousClass1.label = 6;
                                                                                objExecute = call2.bodyNullable(typeInfo2, anonymousClass1);
                                                                                r15 = r9;
                                                                            } else {
                                                                                str7 = null;
                                                                            }
                                                                            if (str7 != null) {
                                                                                try {
                                                                                    r13 = r9;
                                                                                    failure3 = StringsKt__IndentKt.parseTTML(str7);
                                                                                } catch (Throwable th) {
                                                                                    failure3 = new Result.Failure(th);
                                                                                }
                                                                                if (Result.m1866exceptionOrNullimpl(failure3) != null) {
                                                                                    Timber.Forest.tag("LyricsPlus");
                                                                                    ConnectionPool.w$1(new Object[0]);
                                                                                }
                                                                                if (failure3 instanceof Result.Failure) {
                                                                                    failure3 = null;
                                                                                }
                                                                                list2 = (List) failure3;
                                                                                if (list2 != null) {
                                                                                    if (list2.isEmpty()) {
                                                                                        list2 = null;
                                                                                    }
                                                                                    if (list2 != null) {
                                                                                        try {
                                                                                            failure4 = StringsKt.trim(StringsKt__IndentKt.toLRC(list2)).toString();
                                                                                        } catch (Throwable th2) {
                                                                                            failure4 = new Result.Failure(th2);
                                                                                        }
                                                                                        z4 = failure4 instanceof Result.Failure;
                                                                                        obj4 = failure4;
                                                                                        if (z4) {
                                                                                            obj4 = null;
                                                                                        }
                                                                                        str8 = (String) obj4;
                                                                                        if (str8 != null) {
                                                                                            if (StringsKt.isBlank(str8)) {
                                                                                                str8 = null;
                                                                                            }
                                                                                            if (str8 != null) {
                                                                                                return new BinimumLyricsFetchResult(str8, StringsKt__StringsJVMKt.equals(r13.timing_type, "word", true));
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            break;
                                        } else {
                                            i8 = i7;
                                            i9 = i4;
                                            if (httpResponse2 == null) {
                                                z7 = z5;
                                                Timber.Forest.tag("LyricsPlus");
                                                ConnectionPool.w(new Object[0]);
                                                return null;
                                            }
                                            z7 = z5;
                                            if (HttpStatusCodeKt.isSuccess(httpResponse2.getStatus())) {
                                                HttpClientCall call3 = httpResponse2.getCall();
                                                ClassReference orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(BinimumLyricsApiResponse.class);
                                                typeReferenceTypeOf2 = Reflection.typeOf(BinimumLyricsApiResponse.class);
                                                TypeInfo typeInfo3 = new TypeInfo((KClass<?>) orCreateKotlinClass3, false, (KType) typeReferenceTypeOf2);
                                                anonymousClass1.L$1 = null;
                                                anonymousClass1.L$2 = null;
                                                anonymousClass1.L$3 = null;
                                                anonymousClass1.L$8 = null;
                                                anonymousClass1.I$0 = i8;
                                                anonymousClass1.Z$0 = z7;
                                                anonymousClass1.I$1 = i9;
                                                anonymousClass1.label = 4;
                                                objExecute = call3.bodyNullable(typeInfo3, anonymousClass1);
                                                i13 = i9;
                                                z9 = z7;
                                                i12 = i8;
                                                if (objExecute != coroutineSingletons) {
                                                    if (objExecute != null) {
                                                        throw new NullPointerException("null cannot be cast to non-null type com.metrolist.music.lyrics.BinimumLyricsApiResponse");
                                                    }
                                                    failure = (BinimumLyricsApiResponse) objExecute;
                                                    i3 = i13;
                                                    r10 = z9;
                                                    r11 = i12;
                                                    z2 = failure instanceof Result.Failure;
                                                    obj2 = failure;
                                                    if (z2) {
                                                        obj2 = null;
                                                    }
                                                    binimumLyricsApiResponse = (BinimumLyricsApiResponse) obj2;
                                                    if (binimumLyricsApiResponse != null) {
                                                        list = binimumLyricsApiResponse.results;
                                                        if (!list.isEmpty()) {
                                                            it = list.iterator();
                                                            while (true) {
                                                                if (it.hasNext()) {
                                                                    next = it.next();
                                                                    str6 = ((BinimumLyricsResult) next).lyricsUrl;
                                                                    if (str6 != null) {
                                                                    }
                                                                } else {
                                                                    next = null;
                                                                }
                                                            }
                                                            binimumLyricsResult = (BinimumLyricsResult) next;
                                                            if (binimumLyricsResult != null) {
                                                                str5 = binimumLyricsResult.lyricsUrl;
                                                                if (str5 == null) {
                                                                    str5 = "";
                                                                }
                                                                HttpClient httpClient2 = (HttpClient) client$delegate.getValue();
                                                                HttpRequestBuilder httpRequestBuilder2 = new HttpRequestBuilder();
                                                                HttpRequestKt.url(httpRequestBuilder2, str5);
                                                                httpRequestBuilder2.setMethod(HttpMethod.Get);
                                                                HttpStatement httpStatement2 = new HttpStatement(httpRequestBuilder2, httpClient2);
                                                                anonymousClass1.L$1 = null;
                                                                anonymousClass1.L$2 = null;
                                                                anonymousClass1.L$3 = null;
                                                                anonymousClass1.L$8 = binimumLyricsResult;
                                                                anonymousClass1.I$0 = r11;
                                                                anonymousClass1.Z$0 = r10;
                                                                anonymousClass1.I$1 = i3;
                                                                anonymousClass1.label = 5;
                                                                objExecute = httpStatement2.execute(anonymousClass1);
                                                                i = i3;
                                                                str = r10;
                                                                str2 = r11;
                                                                str3 = binimumLyricsResult;
                                                                if (objExecute == coroutineSingletons) {
                                                                    HttpResponse httpResponse4 = (HttpResponse) objExecute;
                                                                    ?? r8 = str;
                                                                    i2 = i;
                                                                    r9 = str3;
                                                                    r12 = str2;
                                                                    z = r8 == true ? 1 : 0;
                                                                    obj = httpResponse4;
                                                                    z3 = obj instanceof Result.Failure;
                                                                    obj3 = obj;
                                                                    if (z3) {
                                                                        obj3 = null;
                                                                    }
                                                                    httpResponse = (HttpResponse) obj3;
                                                                    if (httpResponse != null) {
                                                                        if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                                                                            HttpClientCall call4 = httpResponse.getCall();
                                                                            ClassReference orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                                                                            typeReferenceTypeOf = Reflection.typeOf(String.class);
                                                                            TypeInfo typeInfo4 = new TypeInfo((KClass<?>) orCreateKotlinClass4, false, (KType) typeReferenceTypeOf);
                                                                            anonymousClass1.L$1 = null;
                                                                            anonymousClass1.L$2 = null;
                                                                            anonymousClass1.L$3 = null;
                                                                            anonymousClass1.L$8 = r9;
                                                                            anonymousClass1.I$0 = r12;
                                                                            anonymousClass1.Z$0 = z;
                                                                            anonymousClass1.I$1 = i2;
                                                                            anonymousClass1.label = 6;
                                                                            objExecute = call4.bodyNullable(typeInfo4, anonymousClass1);
                                                                            r15 = r9;
                                                                        } else {
                                                                            str7 = null;
                                                                        }
                                                                        if (str7 != null) {
                                                                            r13 = r9;
                                                                            failure3 = StringsKt__IndentKt.parseTTML(str7);
                                                                            if (Result.m1866exceptionOrNullimpl(failure3) != null) {
                                                                                Timber.Forest.tag("LyricsPlus");
                                                                                ConnectionPool.w$1(new Object[0]);
                                                                            }
                                                                            if (failure3 instanceof Result.Failure) {
                                                                                failure3 = null;
                                                                            }
                                                                            list2 = (List) failure3;
                                                                            if (list2 != null) {
                                                                                if (list2.isEmpty()) {
                                                                                    list2 = null;
                                                                                }
                                                                                if (list2 != null) {
                                                                                    failure4 = StringsKt.trim(StringsKt__IndentKt.toLRC(list2)).toString();
                                                                                    z4 = failure4 instanceof Result.Failure;
                                                                                    obj4 = failure4;
                                                                                    if (z4) {
                                                                                        obj4 = null;
                                                                                    }
                                                                                    str8 = (String) obj4;
                                                                                    if (str8 != null) {
                                                                                        if (StringsKt.isBlank(str8)) {
                                                                                            str8 = null;
                                                                                        }
                                                                                        if (str8 != null) {
                                                                                            return new BinimumLyricsFetchResult(str8, StringsKt__StringsJVMKt.equals(r13.timing_type, "word", true));
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    anonymousClass1.L$1 = null;
                                    anonymousClass1.L$2 = null;
                                    anonymousClass1.L$3 = null;
                                    anonymousClass1.I$0 = i;
                                    anonymousClass1.Z$0 = zMatches;
                                    anonymousClass1.I$1 = i4;
                                    anonymousClass1.label = 3;
                                    objExecute = fetchBinimumLyricsApi$requestByTrackMetadata(i, str2, str3, str4, anonymousClass1);
                                    if (objExecute != coroutineSingletons) {
                                        i5 = i;
                                        i6 = i4;
                                        z8 = zMatches;
                                        httpResponse2 = (HttpResponse) objExecute;
                                        i9 = i6;
                                        z7 = z8;
                                        i8 = i5;
                                        if (httpResponse2 == null) {
                                            z7 = z5;
                                            Timber.Forest.tag("LyricsPlus");
                                            ConnectionPool.w(new Object[0]);
                                            return null;
                                        }
                                        z7 = z5;
                                        if (HttpStatusCodeKt.isSuccess(httpResponse2.getStatus())) {
                                            HttpClientCall call5 = httpResponse2.getCall();
                                            ClassReference orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(BinimumLyricsApiResponse.class);
                                            typeReferenceTypeOf2 = Reflection.typeOf(BinimumLyricsApiResponse.class);
                                            TypeInfo typeInfo5 = new TypeInfo((KClass<?>) orCreateKotlinClass5, false, (KType) typeReferenceTypeOf2);
                                            anonymousClass1.L$1 = null;
                                            anonymousClass1.L$2 = null;
                                            anonymousClass1.L$3 = null;
                                            anonymousClass1.L$8 = null;
                                            anonymousClass1.I$0 = i8;
                                            anonymousClass1.Z$0 = z7;
                                            anonymousClass1.I$1 = i9;
                                            anonymousClass1.label = 4;
                                            objExecute = call5.bodyNullable(typeInfo5, anonymousClass1);
                                            i13 = i9;
                                            z9 = z7;
                                            i12 = i8;
                                            if (objExecute != coroutineSingletons) {
                                                if (objExecute != null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.music.lyrics.BinimumLyricsApiResponse");
                                                }
                                                failure = (BinimumLyricsApiResponse) objExecute;
                                                i3 = i13;
                                                r10 = z9;
                                                r11 = i12;
                                                z2 = failure instanceof Result.Failure;
                                                obj2 = failure;
                                                if (z2) {
                                                    obj2 = null;
                                                }
                                                binimumLyricsApiResponse = (BinimumLyricsApiResponse) obj2;
                                                if (binimumLyricsApiResponse != null) {
                                                    list = binimumLyricsApiResponse.results;
                                                    if (!list.isEmpty()) {
                                                        it = list.iterator();
                                                        while (true) {
                                                            if (it.hasNext()) {
                                                                next = it.next();
                                                                str6 = ((BinimumLyricsResult) next).lyricsUrl;
                                                                if (str6 != null) {
                                                                }
                                                            } else {
                                                                next = null;
                                                            }
                                                        }
                                                        binimumLyricsResult = (BinimumLyricsResult) next;
                                                        if (binimumLyricsResult != null) {
                                                            str5 = binimumLyricsResult.lyricsUrl;
                                                            if (str5 == null) {
                                                                str5 = "";
                                                            }
                                                            HttpClient httpClient3 = (HttpClient) client$delegate.getValue();
                                                            HttpRequestBuilder httpRequestBuilder3 = new HttpRequestBuilder();
                                                            HttpRequestKt.url(httpRequestBuilder3, str5);
                                                            httpRequestBuilder3.setMethod(HttpMethod.Get);
                                                            HttpStatement httpStatement3 = new HttpStatement(httpRequestBuilder3, httpClient3);
                                                            anonymousClass1.L$1 = null;
                                                            anonymousClass1.L$2 = null;
                                                            anonymousClass1.L$3 = null;
                                                            anonymousClass1.L$8 = binimumLyricsResult;
                                                            anonymousClass1.I$0 = r11;
                                                            anonymousClass1.Z$0 = r10;
                                                            anonymousClass1.I$1 = i3;
                                                            anonymousClass1.label = 5;
                                                            objExecute = httpStatement3.execute(anonymousClass1);
                                                            i = i3;
                                                            str = r10;
                                                            str2 = r11;
                                                            str3 = binimumLyricsResult;
                                                            if (objExecute == coroutineSingletons) {
                                                                HttpResponse httpResponse5 = (HttpResponse) objExecute;
                                                                ?? r18 = str;
                                                                i2 = i;
                                                                r9 = str3;
                                                                r12 = str2;
                                                                z = r18 == true ? 1 : 0;
                                                                obj = httpResponse5;
                                                                z3 = obj instanceof Result.Failure;
                                                                obj3 = obj;
                                                                if (z3) {
                                                                    obj3 = null;
                                                                }
                                                                httpResponse = (HttpResponse) obj3;
                                                                if (httpResponse != null) {
                                                                    if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                                                                        HttpClientCall call6 = httpResponse.getCall();
                                                                        ClassReference orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(String.class);
                                                                        typeReferenceTypeOf = Reflection.typeOf(String.class);
                                                                        TypeInfo typeInfo6 = new TypeInfo((KClass<?>) orCreateKotlinClass6, false, (KType) typeReferenceTypeOf);
                                                                        anonymousClass1.L$1 = null;
                                                                        anonymousClass1.L$2 = null;
                                                                        anonymousClass1.L$3 = null;
                                                                        anonymousClass1.L$8 = r9;
                                                                        anonymousClass1.I$0 = r12;
                                                                        anonymousClass1.Z$0 = z;
                                                                        anonymousClass1.I$1 = i2;
                                                                        anonymousClass1.label = 6;
                                                                        objExecute = call6.bodyNullable(typeInfo6, anonymousClass1);
                                                                        r15 = r9;
                                                                    } else {
                                                                        str7 = null;
                                                                    }
                                                                    if (str7 != null) {
                                                                        r13 = r9;
                                                                        failure3 = StringsKt__IndentKt.parseTTML(str7);
                                                                        if (Result.m1866exceptionOrNullimpl(failure3) != null) {
                                                                            Timber.Forest.tag("LyricsPlus");
                                                                            ConnectionPool.w$1(new Object[0]);
                                                                        }
                                                                        if (failure3 instanceof Result.Failure) {
                                                                            failure3 = null;
                                                                        }
                                                                        list2 = (List) failure3;
                                                                        if (list2 != null) {
                                                                            if (list2.isEmpty()) {
                                                                                list2 = null;
                                                                            }
                                                                            if (list2 != null) {
                                                                                failure4 = StringsKt.trim(StringsKt__IndentKt.toLRC(list2)).toString();
                                                                                z4 = failure4 instanceof Result.Failure;
                                                                                obj4 = failure4;
                                                                                if (z4) {
                                                                                    obj4 = null;
                                                                                }
                                                                                str8 = (String) obj4;
                                                                                if (str8 != null) {
                                                                                    if (StringsKt.isBlank(str8)) {
                                                                                        str8 = null;
                                                                                    }
                                                                                    if (str8 != null) {
                                                                                        return new BinimumLyricsFetchResult(str8, StringsKt__StringsJVMKt.equals(r13.timing_type, "word", true));
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                i7 = i;
                                z5 = zMatches;
                                r17 = str2;
                                r16 = str3;
                                return coroutineSingletons;
                            }
                            r13 = r9;
                            return null;
                        case 1:
                            int i16 = anonymousClass1.I$1;
                            boolean z10 = anonymousClass1.Z$0;
                            int i17 = anonymousClass1.I$0;
                            str4 = anonymousClass1.L$3;
                            String str9 = anonymousClass1.L$2;
                            String str10 = anonymousClass1.L$1;
                            ResultKt.throwOnFailure(objExecute);
                            i4 = i16;
                            i7 = i17;
                            r17 = str10;
                            z5 = z10;
                            r16 = str9;
                            i7 = i;
                            z5 = zMatches;
                            r17 = str2;
                            r16 = str3;
                            httpResponse2 = (HttpResponse) objExecute;
                            if (httpResponse2 != null) {
                                i8 = i7;
                                i9 = i4;
                                if (httpResponse2 == null) {
                                    z7 = z5;
                                    Timber.Forest.tag("LyricsPlus");
                                    ConnectionPool.w(new Object[0]);
                                    return null;
                                }
                                z7 = z5;
                                if (HttpStatusCodeKt.isSuccess(httpResponse2.getStatus())) {
                                    HttpClientCall call7 = httpResponse2.getCall();
                                    ClassReference orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(BinimumLyricsApiResponse.class);
                                    typeReferenceTypeOf2 = Reflection.typeOf(BinimumLyricsApiResponse.class);
                                    TypeInfo typeInfo7 = new TypeInfo((KClass<?>) orCreateKotlinClass7, false, (KType) typeReferenceTypeOf2);
                                    anonymousClass1.L$1 = null;
                                    anonymousClass1.L$2 = null;
                                    anonymousClass1.L$3 = null;
                                    anonymousClass1.L$8 = null;
                                    anonymousClass1.I$0 = i8;
                                    anonymousClass1.Z$0 = z7;
                                    anonymousClass1.I$1 = i9;
                                    anonymousClass1.label = 4;
                                    objExecute = call7.bodyNullable(typeInfo7, anonymousClass1);
                                    i13 = i9;
                                    z9 = z7;
                                    i12 = i8;
                                    if (objExecute != coroutineSingletons) {
                                        if (objExecute != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type com.metrolist.music.lyrics.BinimumLyricsApiResponse");
                                        }
                                        failure = (BinimumLyricsApiResponse) objExecute;
                                        i3 = i13;
                                        r10 = z9;
                                        r11 = i12;
                                        z2 = failure instanceof Result.Failure;
                                        obj2 = failure;
                                        if (z2) {
                                            obj2 = null;
                                        }
                                        binimumLyricsApiResponse = (BinimumLyricsApiResponse) obj2;
                                        if (binimumLyricsApiResponse != null) {
                                            list = binimumLyricsApiResponse.results;
                                            if (!list.isEmpty()) {
                                                it = list.iterator();
                                                while (true) {
                                                    if (it.hasNext()) {
                                                        next = it.next();
                                                        str6 = ((BinimumLyricsResult) next).lyricsUrl;
                                                        if (str6 != null) {
                                                        }
                                                    } else {
                                                        next = null;
                                                    }
                                                }
                                                binimumLyricsResult = (BinimumLyricsResult) next;
                                                if (binimumLyricsResult != null) {
                                                    str5 = binimumLyricsResult.lyricsUrl;
                                                    if (str5 == null) {
                                                        str5 = "";
                                                    }
                                                    HttpClient httpClient4 = (HttpClient) client$delegate.getValue();
                                                    HttpRequestBuilder httpRequestBuilder4 = new HttpRequestBuilder();
                                                    HttpRequestKt.url(httpRequestBuilder4, str5);
                                                    httpRequestBuilder4.setMethod(HttpMethod.Get);
                                                    HttpStatement httpStatement4 = new HttpStatement(httpRequestBuilder4, httpClient4);
                                                    anonymousClass1.L$1 = null;
                                                    anonymousClass1.L$2 = null;
                                                    anonymousClass1.L$3 = null;
                                                    anonymousClass1.L$8 = binimumLyricsResult;
                                                    anonymousClass1.I$0 = r11;
                                                    anonymousClass1.Z$0 = r10;
                                                    anonymousClass1.I$1 = i3;
                                                    anonymousClass1.label = 5;
                                                    objExecute = httpStatement4.execute(anonymousClass1);
                                                    i = i3;
                                                    str = r10;
                                                    str2 = r11;
                                                    str3 = binimumLyricsResult;
                                                    if (objExecute == coroutineSingletons) {
                                                        HttpResponse httpResponse6 = (HttpResponse) objExecute;
                                                        ?? r19 = str;
                                                        i2 = i;
                                                        r9 = str3;
                                                        r12 = str2;
                                                        z = r19 == true ? 1 : 0;
                                                        obj = httpResponse6;
                                                        z3 = obj instanceof Result.Failure;
                                                        obj3 = obj;
                                                        if (z3) {
                                                            obj3 = null;
                                                        }
                                                        httpResponse = (HttpResponse) obj3;
                                                        if (httpResponse != null) {
                                                            if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                                                                HttpClientCall call8 = httpResponse.getCall();
                                                                ClassReference orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(String.class);
                                                                typeReferenceTypeOf = Reflection.typeOf(String.class);
                                                                TypeInfo typeInfo8 = new TypeInfo((KClass<?>) orCreateKotlinClass8, false, (KType) typeReferenceTypeOf);
                                                                anonymousClass1.L$1 = null;
                                                                anonymousClass1.L$2 = null;
                                                                anonymousClass1.L$3 = null;
                                                                anonymousClass1.L$8 = r9;
                                                                anonymousClass1.I$0 = r12;
                                                                anonymousClass1.Z$0 = z;
                                                                anonymousClass1.I$1 = i2;
                                                                anonymousClass1.label = 6;
                                                                objExecute = call8.bodyNullable(typeInfo8, anonymousClass1);
                                                                r15 = r9;
                                                            } else {
                                                                str7 = null;
                                                            }
                                                            if (str7 != null) {
                                                                r13 = r9;
                                                                failure3 = StringsKt__IndentKt.parseTTML(str7);
                                                                if (Result.m1866exceptionOrNullimpl(failure3) != null) {
                                                                    Timber.Forest.tag("LyricsPlus");
                                                                    ConnectionPool.w$1(new Object[0]);
                                                                }
                                                                if (failure3 instanceof Result.Failure) {
                                                                    failure3 = null;
                                                                }
                                                                list2 = (List) failure3;
                                                                if (list2 != null) {
                                                                    if (list2.isEmpty()) {
                                                                        list2 = null;
                                                                    }
                                                                    if (list2 != null) {
                                                                        failure4 = StringsKt.trim(StringsKt__IndentKt.toLRC(list2)).toString();
                                                                        z4 = failure4 instanceof Result.Failure;
                                                                        obj4 = failure4;
                                                                        if (z4) {
                                                                            obj4 = null;
                                                                        }
                                                                        str8 = (String) obj4;
                                                                        if (str8 != null) {
                                                                            if (StringsKt.isBlank(str8)) {
                                                                                str8 = null;
                                                                            }
                                                                            if (str8 != null) {
                                                                                return new BinimumLyricsFetchResult(str8, StringsKt__StringsJVMKt.equals(r13.timing_type, "word", true));
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                r13 = r9;
                                return null;
                            }
                            anonymousClass1.L$1 = null;
                            anonymousClass1.L$2 = null;
                            anonymousClass1.L$3 = null;
                            anonymousClass1.I$0 = i7;
                            anonymousClass1.Z$0 = z5;
                            anonymousClass1.I$1 = i4;
                            anonymousClass1.label = 2;
                            objExecute = fetchBinimumLyricsApi$requestByTrackMetadata(i7, r17, r16, str4, anonymousClass1);
                            if (objExecute != coroutineSingletons) {
                                i10 = i7;
                                i11 = i4;
                                z6 = z5;
                                httpResponse2 = (HttpResponse) objExecute;
                                i9 = i11;
                                z7 = z6;
                                i8 = i10;
                                if (httpResponse2 == null) {
                                    z7 = z5;
                                    Timber.Forest.tag("LyricsPlus");
                                    ConnectionPool.w(new Object[0]);
                                    return null;
                                }
                                z7 = z5;
                                if (HttpStatusCodeKt.isSuccess(httpResponse2.getStatus())) {
                                    HttpClientCall call9 = httpResponse2.getCall();
                                    ClassReference orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(BinimumLyricsApiResponse.class);
                                    typeReferenceTypeOf2 = Reflection.typeOf(BinimumLyricsApiResponse.class);
                                    TypeInfo typeInfo9 = new TypeInfo((KClass<?>) orCreateKotlinClass9, false, (KType) typeReferenceTypeOf2);
                                    anonymousClass1.L$1 = null;
                                    anonymousClass1.L$2 = null;
                                    anonymousClass1.L$3 = null;
                                    anonymousClass1.L$8 = null;
                                    anonymousClass1.I$0 = i8;
                                    anonymousClass1.Z$0 = z7;
                                    anonymousClass1.I$1 = i9;
                                    anonymousClass1.label = 4;
                                    objExecute = call9.bodyNullable(typeInfo9, anonymousClass1);
                                    i13 = i9;
                                    z9 = z7;
                                    i12 = i8;
                                    if (objExecute != coroutineSingletons) {
                                        if (objExecute != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type com.metrolist.music.lyrics.BinimumLyricsApiResponse");
                                        }
                                        failure = (BinimumLyricsApiResponse) objExecute;
                                        i3 = i13;
                                        r10 = z9;
                                        r11 = i12;
                                        z2 = failure instanceof Result.Failure;
                                        obj2 = failure;
                                        if (z2) {
                                            obj2 = null;
                                        }
                                        binimumLyricsApiResponse = (BinimumLyricsApiResponse) obj2;
                                        if (binimumLyricsApiResponse != null) {
                                            list = binimumLyricsApiResponse.results;
                                            if (!list.isEmpty()) {
                                                it = list.iterator();
                                                while (true) {
                                                    if (it.hasNext()) {
                                                        next = it.next();
                                                        str6 = ((BinimumLyricsResult) next).lyricsUrl;
                                                        if (str6 != null) {
                                                        }
                                                    } else {
                                                        next = null;
                                                    }
                                                }
                                                binimumLyricsResult = (BinimumLyricsResult) next;
                                                if (binimumLyricsResult != null) {
                                                    str5 = binimumLyricsResult.lyricsUrl;
                                                    if (str5 == null) {
                                                        str5 = "";
                                                    }
                                                    HttpClient httpClient5 = (HttpClient) client$delegate.getValue();
                                                    HttpRequestBuilder httpRequestBuilder5 = new HttpRequestBuilder();
                                                    HttpRequestKt.url(httpRequestBuilder5, str5);
                                                    httpRequestBuilder5.setMethod(HttpMethod.Get);
                                                    HttpStatement httpStatement5 = new HttpStatement(httpRequestBuilder5, httpClient5);
                                                    anonymousClass1.L$1 = null;
                                                    anonymousClass1.L$2 = null;
                                                    anonymousClass1.L$3 = null;
                                                    anonymousClass1.L$8 = binimumLyricsResult;
                                                    anonymousClass1.I$0 = r11;
                                                    anonymousClass1.Z$0 = r10;
                                                    anonymousClass1.I$1 = i3;
                                                    anonymousClass1.label = 5;
                                                    objExecute = httpStatement5.execute(anonymousClass1);
                                                    i = i3;
                                                    str = r10;
                                                    str2 = r11;
                                                    str3 = binimumLyricsResult;
                                                    if (objExecute == coroutineSingletons) {
                                                        HttpResponse httpResponse7 = (HttpResponse) objExecute;
                                                        ?? r110 = str;
                                                        i2 = i;
                                                        r9 = str3;
                                                        r12 = str2;
                                                        z = r110 == true ? 1 : 0;
                                                        obj = httpResponse7;
                                                        z3 = obj instanceof Result.Failure;
                                                        obj3 = obj;
                                                        if (z3) {
                                                            obj3 = null;
                                                        }
                                                        httpResponse = (HttpResponse) obj3;
                                                        if (httpResponse != null) {
                                                            if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                                                                HttpClientCall call10 = httpResponse.getCall();
                                                                ClassReference orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(String.class);
                                                                typeReferenceTypeOf = Reflection.typeOf(String.class);
                                                                TypeInfo typeInfo10 = new TypeInfo((KClass<?>) orCreateKotlinClass10, false, (KType) typeReferenceTypeOf);
                                                                anonymousClass1.L$1 = null;
                                                                anonymousClass1.L$2 = null;
                                                                anonymousClass1.L$3 = null;
                                                                anonymousClass1.L$8 = r9;
                                                                anonymousClass1.I$0 = r12;
                                                                anonymousClass1.Z$0 = z;
                                                                anonymousClass1.I$1 = i2;
                                                                anonymousClass1.label = 6;
                                                                objExecute = call10.bodyNullable(typeInfo10, anonymousClass1);
                                                                r15 = r9;
                                                            } else {
                                                                str7 = null;
                                                            }
                                                            if (str7 != null) {
                                                                r13 = r9;
                                                                failure3 = StringsKt__IndentKt.parseTTML(str7);
                                                                if (Result.m1866exceptionOrNullimpl(failure3) != null) {
                                                                    Timber.Forest.tag("LyricsPlus");
                                                                    ConnectionPool.w$1(new Object[0]);
                                                                }
                                                                if (failure3 instanceof Result.Failure) {
                                                                    failure3 = null;
                                                                }
                                                                list2 = (List) failure3;
                                                                if (list2 != null) {
                                                                    if (list2.isEmpty()) {
                                                                        list2 = null;
                                                                    }
                                                                    if (list2 != null) {
                                                                        failure4 = StringsKt.trim(StringsKt__IndentKt.toLRC(list2)).toString();
                                                                        z4 = failure4 instanceof Result.Failure;
                                                                        obj4 = failure4;
                                                                        if (z4) {
                                                                            obj4 = null;
                                                                        }
                                                                        str8 = (String) obj4;
                                                                        if (str8 != null) {
                                                                            if (StringsKt.isBlank(str8)) {
                                                                                str8 = null;
                                                                            }
                                                                            if (str8 != null) {
                                                                                return new BinimumLyricsFetchResult(str8, StringsKt__StringsJVMKt.equals(r13.timing_type, "word", true));
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                r13 = r9;
                                return null;
                            }
                            i7 = i;
                            z5 = zMatches;
                            r17 = str2;
                            r16 = str3;
                            return coroutineSingletons;
                        case 2:
                            int i18 = anonymousClass1.I$1;
                            boolean z11 = anonymousClass1.Z$0;
                            int i19 = anonymousClass1.I$0;
                            ResultKt.throwOnFailure(objExecute);
                            i11 = i18;
                            z6 = z11;
                            i10 = i19;
                            httpResponse2 = (HttpResponse) objExecute;
                            i9 = i11;
                            z7 = z6;
                            i8 = i10;
                            if (httpResponse2 == null) {
                                z7 = z5;
                                Timber.Forest.tag("LyricsPlus");
                                ConnectionPool.w(new Object[0]);
                                return null;
                            }
                            z7 = z5;
                            if (HttpStatusCodeKt.isSuccess(httpResponse2.getStatus())) {
                                HttpClientCall call11 = httpResponse2.getCall();
                                ClassReference orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(BinimumLyricsApiResponse.class);
                                typeReferenceTypeOf2 = Reflection.typeOf(BinimumLyricsApiResponse.class);
                                TypeInfo typeInfo11 = new TypeInfo((KClass<?>) orCreateKotlinClass11, false, (KType) typeReferenceTypeOf2);
                                anonymousClass1.L$1 = null;
                                anonymousClass1.L$2 = null;
                                anonymousClass1.L$3 = null;
                                anonymousClass1.L$8 = null;
                                anonymousClass1.I$0 = i8;
                                anonymousClass1.Z$0 = z7;
                                anonymousClass1.I$1 = i9;
                                anonymousClass1.label = 4;
                                objExecute = call11.bodyNullable(typeInfo11, anonymousClass1);
                                i13 = i9;
                                z9 = z7;
                                i12 = i8;
                                if (objExecute != coroutineSingletons) {
                                    if (objExecute != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type com.metrolist.music.lyrics.BinimumLyricsApiResponse");
                                    }
                                    failure = (BinimumLyricsApiResponse) objExecute;
                                    i3 = i13;
                                    r10 = z9;
                                    r11 = i12;
                                    z2 = failure instanceof Result.Failure;
                                    obj2 = failure;
                                    if (z2) {
                                        obj2 = null;
                                    }
                                    binimumLyricsApiResponse = (BinimumLyricsApiResponse) obj2;
                                    if (binimumLyricsApiResponse != null) {
                                        list = binimumLyricsApiResponse.results;
                                        if (!list.isEmpty()) {
                                            it = list.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    next = it.next();
                                                    str6 = ((BinimumLyricsResult) next).lyricsUrl;
                                                    if (str6 != null) {
                                                    }
                                                } else {
                                                    next = null;
                                                }
                                            }
                                            binimumLyricsResult = (BinimumLyricsResult) next;
                                            if (binimumLyricsResult != null) {
                                                str5 = binimumLyricsResult.lyricsUrl;
                                                if (str5 == null) {
                                                    str5 = "";
                                                }
                                                HttpClient httpClient6 = (HttpClient) client$delegate.getValue();
                                                HttpRequestBuilder httpRequestBuilder6 = new HttpRequestBuilder();
                                                HttpRequestKt.url(httpRequestBuilder6, str5);
                                                httpRequestBuilder6.setMethod(HttpMethod.Get);
                                                HttpStatement httpStatement6 = new HttpStatement(httpRequestBuilder6, httpClient6);
                                                anonymousClass1.L$1 = null;
                                                anonymousClass1.L$2 = null;
                                                anonymousClass1.L$3 = null;
                                                anonymousClass1.L$8 = binimumLyricsResult;
                                                anonymousClass1.I$0 = r11;
                                                anonymousClass1.Z$0 = r10;
                                                anonymousClass1.I$1 = i3;
                                                anonymousClass1.label = 5;
                                                objExecute = httpStatement6.execute(anonymousClass1);
                                                i = i3;
                                                str = r10;
                                                str2 = r11;
                                                str3 = binimumLyricsResult;
                                                if (objExecute == coroutineSingletons) {
                                                    HttpResponse httpResponse8 = (HttpResponse) objExecute;
                                                    ?? r111 = str;
                                                    i2 = i;
                                                    r9 = str3;
                                                    r12 = str2;
                                                    z = r111 == true ? 1 : 0;
                                                    obj = httpResponse8;
                                                    z3 = obj instanceof Result.Failure;
                                                    obj3 = obj;
                                                    if (z3) {
                                                        obj3 = null;
                                                    }
                                                    httpResponse = (HttpResponse) obj3;
                                                    if (httpResponse != null) {
                                                        if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                                                            HttpClientCall call12 = httpResponse.getCall();
                                                            ClassReference orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(String.class);
                                                            typeReferenceTypeOf = Reflection.typeOf(String.class);
                                                            TypeInfo typeInfo12 = new TypeInfo((KClass<?>) orCreateKotlinClass12, false, (KType) typeReferenceTypeOf);
                                                            anonymousClass1.L$1 = null;
                                                            anonymousClass1.L$2 = null;
                                                            anonymousClass1.L$3 = null;
                                                            anonymousClass1.L$8 = r9;
                                                            anonymousClass1.I$0 = r12;
                                                            anonymousClass1.Z$0 = z;
                                                            anonymousClass1.I$1 = i2;
                                                            anonymousClass1.label = 6;
                                                            objExecute = call12.bodyNullable(typeInfo12, anonymousClass1);
                                                            r15 = r9;
                                                        } else {
                                                            str7 = null;
                                                        }
                                                        if (str7 != null) {
                                                            r13 = r9;
                                                            failure3 = StringsKt__IndentKt.parseTTML(str7);
                                                            if (Result.m1866exceptionOrNullimpl(failure3) != null) {
                                                                Timber.Forest.tag("LyricsPlus");
                                                                ConnectionPool.w$1(new Object[0]);
                                                            }
                                                            if (failure3 instanceof Result.Failure) {
                                                                failure3 = null;
                                                            }
                                                            list2 = (List) failure3;
                                                            if (list2 != null) {
                                                                if (list2.isEmpty()) {
                                                                    list2 = null;
                                                                }
                                                                if (list2 != null) {
                                                                    failure4 = StringsKt.trim(StringsKt__IndentKt.toLRC(list2)).toString();
                                                                    z4 = failure4 instanceof Result.Failure;
                                                                    obj4 = failure4;
                                                                    if (z4) {
                                                                        obj4 = null;
                                                                    }
                                                                    str8 = (String) obj4;
                                                                    if (str8 != null) {
                                                                        if (StringsKt.isBlank(str8)) {
                                                                            str8 = null;
                                                                        }
                                                                        if (str8 != null) {
                                                                            return new BinimumLyricsFetchResult(str8, StringsKt__StringsJVMKt.equals(r13.timing_type, "word", true));
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                                i7 = i;
                                z5 = zMatches;
                                r17 = str2;
                                r16 = str3;
                                return coroutineSingletons;
                            }
                            r13 = r9;
                            return null;
                        case 3:
                            int i20 = anonymousClass1.I$1;
                            boolean z12 = anonymousClass1.Z$0;
                            int i21 = anonymousClass1.I$0;
                            ResultKt.throwOnFailure(objExecute);
                            i6 = i20;
                            z8 = z12;
                            i5 = i21;
                            httpResponse2 = (HttpResponse) objExecute;
                            i9 = i6;
                            z7 = z8;
                            i8 = i5;
                            if (httpResponse2 == null) {
                                z7 = z5;
                                Timber.Forest.tag("LyricsPlus");
                                ConnectionPool.w(new Object[0]);
                                return null;
                            }
                            z7 = z5;
                            if (HttpStatusCodeKt.isSuccess(httpResponse2.getStatus())) {
                                HttpClientCall call13 = httpResponse2.getCall();
                                ClassReference orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(BinimumLyricsApiResponse.class);
                                typeReferenceTypeOf2 = Reflection.typeOf(BinimumLyricsApiResponse.class);
                                TypeInfo typeInfo13 = new TypeInfo((KClass<?>) orCreateKotlinClass13, false, (KType) typeReferenceTypeOf2);
                                anonymousClass1.L$1 = null;
                                anonymousClass1.L$2 = null;
                                anonymousClass1.L$3 = null;
                                anonymousClass1.L$8 = null;
                                anonymousClass1.I$0 = i8;
                                anonymousClass1.Z$0 = z7;
                                anonymousClass1.I$1 = i9;
                                anonymousClass1.label = 4;
                                objExecute = call13.bodyNullable(typeInfo13, anonymousClass1);
                                i13 = i9;
                                z9 = z7;
                                i12 = i8;
                                if (objExecute != coroutineSingletons) {
                                    if (objExecute != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type com.metrolist.music.lyrics.BinimumLyricsApiResponse");
                                    }
                                    failure = (BinimumLyricsApiResponse) objExecute;
                                    i3 = i13;
                                    r10 = z9;
                                    r11 = i12;
                                    z2 = failure instanceof Result.Failure;
                                    obj2 = failure;
                                    if (z2) {
                                        obj2 = null;
                                    }
                                    binimumLyricsApiResponse = (BinimumLyricsApiResponse) obj2;
                                    if (binimumLyricsApiResponse != null) {
                                        list = binimumLyricsApiResponse.results;
                                        if (!list.isEmpty()) {
                                            it = list.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    next = it.next();
                                                    str6 = ((BinimumLyricsResult) next).lyricsUrl;
                                                    if (str6 != null) {
                                                    }
                                                } else {
                                                    next = null;
                                                }
                                            }
                                            binimumLyricsResult = (BinimumLyricsResult) next;
                                            if (binimumLyricsResult != null) {
                                                str5 = binimumLyricsResult.lyricsUrl;
                                                if (str5 == null) {
                                                    str5 = "";
                                                }
                                                HttpClient httpClient7 = (HttpClient) client$delegate.getValue();
                                                HttpRequestBuilder httpRequestBuilder7 = new HttpRequestBuilder();
                                                HttpRequestKt.url(httpRequestBuilder7, str5);
                                                httpRequestBuilder7.setMethod(HttpMethod.Get);
                                                HttpStatement httpStatement7 = new HttpStatement(httpRequestBuilder7, httpClient7);
                                                anonymousClass1.L$1 = null;
                                                anonymousClass1.L$2 = null;
                                                anonymousClass1.L$3 = null;
                                                anonymousClass1.L$8 = binimumLyricsResult;
                                                anonymousClass1.I$0 = r11;
                                                anonymousClass1.Z$0 = r10;
                                                anonymousClass1.I$1 = i3;
                                                anonymousClass1.label = 5;
                                                objExecute = httpStatement7.execute(anonymousClass1);
                                                i = i3;
                                                str = r10;
                                                str2 = r11;
                                                str3 = binimumLyricsResult;
                                                if (objExecute == coroutineSingletons) {
                                                    HttpResponse httpResponse9 = (HttpResponse) objExecute;
                                                    ?? r112 = str;
                                                    i2 = i;
                                                    r9 = str3;
                                                    r12 = str2;
                                                    z = r112 == true ? 1 : 0;
                                                    obj = httpResponse9;
                                                    z3 = obj instanceof Result.Failure;
                                                    obj3 = obj;
                                                    if (z3) {
                                                        obj3 = null;
                                                    }
                                                    httpResponse = (HttpResponse) obj3;
                                                    if (httpResponse != null) {
                                                        if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                                                            HttpClientCall call14 = httpResponse.getCall();
                                                            ClassReference orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(String.class);
                                                            typeReferenceTypeOf = Reflection.typeOf(String.class);
                                                            TypeInfo typeInfo14 = new TypeInfo((KClass<?>) orCreateKotlinClass14, false, (KType) typeReferenceTypeOf);
                                                            anonymousClass1.L$1 = null;
                                                            anonymousClass1.L$2 = null;
                                                            anonymousClass1.L$3 = null;
                                                            anonymousClass1.L$8 = r9;
                                                            anonymousClass1.I$0 = r12;
                                                            anonymousClass1.Z$0 = z;
                                                            anonymousClass1.I$1 = i2;
                                                            anonymousClass1.label = 6;
                                                            objExecute = call14.bodyNullable(typeInfo14, anonymousClass1);
                                                            r15 = r9;
                                                        } else {
                                                            str7 = null;
                                                        }
                                                        if (str7 != null) {
                                                            r13 = r9;
                                                            failure3 = StringsKt__IndentKt.parseTTML(str7);
                                                            if (Result.m1866exceptionOrNullimpl(failure3) != null) {
                                                                Timber.Forest.tag("LyricsPlus");
                                                                ConnectionPool.w$1(new Object[0]);
                                                            }
                                                            if (failure3 instanceof Result.Failure) {
                                                                failure3 = null;
                                                            }
                                                            list2 = (List) failure3;
                                                            if (list2 != null) {
                                                                if (list2.isEmpty()) {
                                                                    list2 = null;
                                                                }
                                                                if (list2 != null) {
                                                                    failure4 = StringsKt.trim(StringsKt__IndentKt.toLRC(list2)).toString();
                                                                    z4 = failure4 instanceof Result.Failure;
                                                                    obj4 = failure4;
                                                                    if (z4) {
                                                                        obj4 = null;
                                                                    }
                                                                    str8 = (String) obj4;
                                                                    if (str8 != null) {
                                                                        if (StringsKt.isBlank(str8)) {
                                                                            str8 = null;
                                                                        }
                                                                        if (str8 != null) {
                                                                            return new BinimumLyricsFetchResult(str8, StringsKt__StringsJVMKt.equals(r13.timing_type, "word", true));
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                                i7 = i;
                                z5 = zMatches;
                                r17 = str2;
                                r16 = str3;
                                return coroutineSingletons;
                            }
                            r13 = r9;
                            return null;
                        case 4:
                            int i22 = anonymousClass1.I$1;
                            boolean z13 = anonymousClass1.Z$0;
                            int i23 = anonymousClass1.I$0;
                            ResultKt.throwOnFailure(objExecute);
                            i13 = i22;
                            z9 = z13;
                            i12 = i23;
                            if (objExecute != null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.metrolist.music.lyrics.BinimumLyricsApiResponse");
                            }
                            failure = (BinimumLyricsApiResponse) objExecute;
                            i3 = i13;
                            r10 = z9;
                            r11 = i12;
                            z2 = failure instanceof Result.Failure;
                            obj2 = failure;
                            if (z2) {
                                obj2 = null;
                            }
                            binimumLyricsApiResponse = (BinimumLyricsApiResponse) obj2;
                            if (binimumLyricsApiResponse != null) {
                                list = binimumLyricsApiResponse.results;
                                if (!list.isEmpty()) {
                                    it = list.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            next = it.next();
                                            str6 = ((BinimumLyricsResult) next).lyricsUrl;
                                            if (str6 != null) {
                                            }
                                        } else {
                                            next = null;
                                        }
                                    }
                                    binimumLyricsResult = (BinimumLyricsResult) next;
                                    if (binimumLyricsResult != null) {
                                        str5 = binimumLyricsResult.lyricsUrl;
                                        if (str5 == null) {
                                            str5 = "";
                                        }
                                        HttpClient httpClient8 = (HttpClient) client$delegate.getValue();
                                        HttpRequestBuilder httpRequestBuilder8 = new HttpRequestBuilder();
                                        HttpRequestKt.url(httpRequestBuilder8, str5);
                                        httpRequestBuilder8.setMethod(HttpMethod.Get);
                                        HttpStatement httpStatement8 = new HttpStatement(httpRequestBuilder8, httpClient8);
                                        anonymousClass1.L$1 = null;
                                        anonymousClass1.L$2 = null;
                                        anonymousClass1.L$3 = null;
                                        anonymousClass1.L$8 = binimumLyricsResult;
                                        anonymousClass1.I$0 = r11;
                                        anonymousClass1.Z$0 = r10;
                                        anonymousClass1.I$1 = i3;
                                        anonymousClass1.label = 5;
                                        objExecute = httpStatement8.execute(anonymousClass1);
                                        i = i3;
                                        str = r10;
                                        str2 = r11;
                                        str3 = binimumLyricsResult;
                                        if (objExecute == coroutineSingletons) {
                                            HttpResponse httpResponse10 = (HttpResponse) objExecute;
                                            ?? r113 = str;
                                            i2 = i;
                                            r9 = str3;
                                            r12 = str2;
                                            z = r113 == true ? 1 : 0;
                                            obj = httpResponse10;
                                            z3 = obj instanceof Result.Failure;
                                            obj3 = obj;
                                            if (z3) {
                                                obj3 = null;
                                            }
                                            httpResponse = (HttpResponse) obj3;
                                            if (httpResponse != null) {
                                                if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                                                    HttpClientCall call15 = httpResponse.getCall();
                                                    ClassReference orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(String.class);
                                                    typeReferenceTypeOf = Reflection.typeOf(String.class);
                                                    TypeInfo typeInfo15 = new TypeInfo((KClass<?>) orCreateKotlinClass15, false, (KType) typeReferenceTypeOf);
                                                    anonymousClass1.L$1 = null;
                                                    anonymousClass1.L$2 = null;
                                                    anonymousClass1.L$3 = null;
                                                    anonymousClass1.L$8 = r9;
                                                    anonymousClass1.I$0 = r12;
                                                    anonymousClass1.Z$0 = z;
                                                    anonymousClass1.I$1 = i2;
                                                    anonymousClass1.label = 6;
                                                    objExecute = call15.bodyNullable(typeInfo15, anonymousClass1);
                                                    r15 = r9;
                                                } else {
                                                    str7 = null;
                                                }
                                                if (str7 != null) {
                                                    r13 = r9;
                                                    failure3 = StringsKt__IndentKt.parseTTML(str7);
                                                    if (Result.m1866exceptionOrNullimpl(failure3) != null) {
                                                        Timber.Forest.tag("LyricsPlus");
                                                        ConnectionPool.w$1(new Object[0]);
                                                    }
                                                    if (failure3 instanceof Result.Failure) {
                                                        failure3 = null;
                                                    }
                                                    list2 = (List) failure3;
                                                    if (list2 != null) {
                                                        if (list2.isEmpty()) {
                                                            list2 = null;
                                                        }
                                                        if (list2 != null) {
                                                            failure4 = StringsKt.trim(StringsKt__IndentKt.toLRC(list2)).toString();
                                                            z4 = failure4 instanceof Result.Failure;
                                                            obj4 = failure4;
                                                            if (z4) {
                                                                obj4 = null;
                                                            }
                                                            str8 = (String) obj4;
                                                            if (str8 != null) {
                                                                if (StringsKt.isBlank(str8)) {
                                                                    str8 = null;
                                                                }
                                                                if (str8 != null) {
                                                                    return new BinimumLyricsFetchResult(str8, StringsKt__StringsJVMKt.equals(r13.timing_type, "word", true));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        i7 = i;
                                        z5 = zMatches;
                                        r17 = str2;
                                        r16 = str3;
                                        return coroutineSingletons;
                                    }
                                }
                            }
                            r13 = r9;
                            return null;
                        case 5:
                            int i24 = anonymousClass1.I$1;
                            boolean z14 = anonymousClass1.Z$0;
                            int i25 = anonymousClass1.I$0;
                            BinimumLyricsResult binimumLyricsResult2 = (BinimumLyricsResult) anonymousClass1.L$8;
                            ResultKt.throwOnFailure(objExecute);
                            i = i24;
                            str = z14;
                            str2 = i25;
                            str3 = binimumLyricsResult2;
                            HttpResponse httpResponse11 = (HttpResponse) objExecute;
                            ?? r114 = str;
                            i2 = i;
                            r9 = str3;
                            r12 = str2;
                            z = r114 == true ? 1 : 0;
                            obj = httpResponse11;
                            z3 = obj instanceof Result.Failure;
                            obj3 = obj;
                            if (z3) {
                                obj3 = null;
                            }
                            httpResponse = (HttpResponse) obj3;
                            if (httpResponse != null) {
                                if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                                    HttpClientCall call16 = httpResponse.getCall();
                                    ClassReference orCreateKotlinClass16 = Reflection.getOrCreateKotlinClass(String.class);
                                    typeReferenceTypeOf = Reflection.typeOf(String.class);
                                    TypeInfo typeInfo16 = new TypeInfo((KClass<?>) orCreateKotlinClass16, false, (KType) typeReferenceTypeOf);
                                    anonymousClass1.L$1 = null;
                                    anonymousClass1.L$2 = null;
                                    anonymousClass1.L$3 = null;
                                    anonymousClass1.L$8 = r9;
                                    anonymousClass1.I$0 = r12;
                                    anonymousClass1.Z$0 = z;
                                    anonymousClass1.I$1 = i2;
                                    anonymousClass1.label = 6;
                                    objExecute = call16.bodyNullable(typeInfo16, anonymousClass1);
                                    r15 = r9;
                                } else {
                                    str7 = null;
                                }
                                if (str7 != null) {
                                    r13 = r9;
                                    failure3 = StringsKt__IndentKt.parseTTML(str7);
                                    if (Result.m1866exceptionOrNullimpl(failure3) != null) {
                                        Timber.Forest.tag("LyricsPlus");
                                        ConnectionPool.w$1(new Object[0]);
                                    }
                                    if (failure3 instanceof Result.Failure) {
                                        failure3 = null;
                                    }
                                    list2 = (List) failure3;
                                    if (list2 != null) {
                                        if (list2.isEmpty()) {
                                            list2 = null;
                                        }
                                        if (list2 != null) {
                                            failure4 = StringsKt.trim(StringsKt__IndentKt.toLRC(list2)).toString();
                                            z4 = failure4 instanceof Result.Failure;
                                            obj4 = failure4;
                                            if (z4) {
                                                obj4 = null;
                                            }
                                            str8 = (String) obj4;
                                            if (str8 != null) {
                                                if (StringsKt.isBlank(str8)) {
                                                    str8 = null;
                                                }
                                                if (str8 != null) {
                                                    return new BinimumLyricsFetchResult(str8, StringsKt__StringsJVMKt.equals(r13.timing_type, "word", true));
                                                }
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                            r13 = r9;
                            return null;
                        case 6:
                            BinimumLyricsResult binimumLyricsResult3 = (BinimumLyricsResult) anonymousClass1.L$8;
                            ResultKt.throwOnFailure(objExecute);
                            r15 = binimumLyricsResult3;
                            if (objExecute == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            failure2 = (String) objExecute;
                            r14 = r15;
                            boolean z15 = failure2 instanceof Result.Failure;
                            Object obj5 = failure2;
                            if (z15) {
                                obj5 = null;
                            }
                            str7 = (String) obj5;
                            r13 = r14;
                            if (str7 != null) {
                                r13 = r9;
                                failure3 = StringsKt__IndentKt.parseTTML(str7);
                                if (Result.m1866exceptionOrNullimpl(failure3) != null) {
                                    Timber.Forest.tag("LyricsPlus");
                                    ConnectionPool.w$1(new Object[0]);
                                }
                                if (failure3 instanceof Result.Failure) {
                                    failure3 = null;
                                }
                                list2 = (List) failure3;
                                if (list2 != null) {
                                    if (list2.isEmpty()) {
                                        list2 = null;
                                    }
                                    if (list2 != null) {
                                        failure4 = StringsKt.trim(StringsKt__IndentKt.toLRC(list2)).toString();
                                        z4 = failure4 instanceof Result.Failure;
                                        obj4 = failure4;
                                        if (z4) {
                                            obj4 = null;
                                        }
                                        str8 = (String) obj4;
                                        if (str8 != null) {
                                            if (StringsKt.isBlank(str8)) {
                                                str8 = null;
                                            }
                                            if (str8 != null) {
                                                return new BinimumLyricsFetchResult(str8, StringsKt__StringsJVMKt.equals(r13.timing_type, "word", true));
                                            }
                                        }
                                    }
                                }
                            }
                            r13 = r9;
                            return null;
                        default:
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                    }
                } catch (Throwable th3) {
                    failure2 = new Result.Failure(th3);
                    r14 = i;
                }
            } catch (Throwable th4) {
                Result.Failure failure5 = new Result.Failure(th4);
                ?? r20 = str;
                i2 = i;
                r9 = str3;
                r12 = str2;
                z = r20 == true ? 1 : 0;
                obj = failure5;
            }
        } catch (Throwable th5) {
            failure = new Result.Failure(th5);
            i3 = i;
            r10 = str;
            r11 = str2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cb, code lost:
    
        if (r5 == r4) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchFromUrl(int i, String str, String str2, String str3, String str4, ContinuationImpl continuationImpl) {
        C01571 c01571;
        Object failure;
        TypeReference typeReferenceTypeOf;
        if (continuationImpl instanceof C01571) {
            c01571 = (C01571) continuationImpl;
            int i2 = c01571.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c01571.label = i2 - Integer.MIN_VALUE;
            } else {
                c01571 = new C01571(continuationImpl);
            }
        } else {
            c01571 = new C01571(continuationImpl);
        }
        Object objExecute = c01571.result;
        int i3 = c01571.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    i = c01571.I$0;
                    ResultKt.throwOnFailure(objExecute);
                } else {
                    if (i3 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objExecute);
                }
                if (objExecute == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.music.lyrics.LyricsPlusResponse");
                }
                failure = (LyricsPlusResponse) objExecute;
                if (failure instanceof Result.Failure) {
                    return null;
                }
                return failure;
            }
            ResultKt.throwOnFailure(objExecute);
            HttpClient httpClient = (HttpClient) client$delegate.getValue();
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            HttpRequestKt.url(httpRequestBuilder, str + "/v2/lyrics/get");
            UtilsKt.parameter(httpRequestBuilder, LinkHeader.Parameters.Title, str2);
            UtilsKt.parameter(httpRequestBuilder, "artist", str3);
            if (i > 0) {
                UtilsKt.parameter(httpRequestBuilder, "duration", new Integer(i / CIOKt.DEFAULT_HTTP_POOL_SIZE));
            }
            if (str4 != null && !StringsKt.isBlank(str4)) {
                UtilsKt.parameter(httpRequestBuilder, "album", str4);
            }
            httpRequestBuilder.setMethod(HttpMethod.Get);
            HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
            c01571.I$0 = i;
            c01571.label = 1;
            objExecute = httpStatement.execute(c01571);
            if (objExecute == coroutineSingletons) {
            }
            return coroutineSingletons;
            HttpResponse httpResponse = (HttpResponse) objExecute;
            if (Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getOK())) {
                HttpClientCall call = httpResponse.getCall();
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LyricsPlusResponse.class);
                try {
                    typeReferenceTypeOf = Reflection.typeOf(LyricsPlusResponse.class);
                } catch (Throwable unused) {
                    typeReferenceTypeOf = null;
                }
                TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
                c01571.I$0 = i;
                c01571.label = 2;
                objExecute = call.bodyNullable(typeInfo, c01571);
            } else {
                failure = null;
            }
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (failure instanceof Result.Failure) {
            return null;
        }
        return failure;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0094  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ce A[Catch: Exception -> 0x00dc, TryCatch #1 {Exception -> 0x00dc, blocks: (B:43:0x00ca, B:45:0x00ce, B:47:0x00d2, B:50:0x00d9), top: B:61:0x00ca }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00c6 -> B:61:0x00ca). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object fetchLyrics(int r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, kotlin.coroutines.jvm.internal.ContinuationImpl r20) {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.lyrics.LyricsPlusProvider.fetchLyrics(int, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    @Override // com.metrolist.music.lyrics.LyricsProvider
    public final Object getAllLyrics(Context context, String str, String str2, String str3, int i, String str4, Function1 function1, Continuation continuation) {
        C01591 c01591;
        Object objMo1450getLyricsbMdYcbs;
        Function1 function2;
        if (continuation instanceof C01591) {
            c01591 = (C01591) continuation;
            int i2 = c01591.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c01591.label = i2 - Integer.MIN_VALUE;
            } else {
                c01591 = new C01591((ContinuationImpl) continuation);
            }
        } else {
            c01591 = new C01591((ContinuationImpl) continuation);
        }
        C01591 c01592 = c01591;
        Object obj = c01592.result;
        int i3 = c01592.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            c01592.L$5 = function1;
            c01592.label = 1;
            objMo1450getLyricsbMdYcbs = mo1450getLyricsbMdYcbs(context, str, str2, str3, i, str4, c01592);
            Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objMo1450getLyricsbMdYcbs == obj2) {
                return obj2;
            }
            function2 = function1;
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            function2 = c01592.L$5;
            ResultKt.throwOnFailure(obj);
            objMo1450getLyricsbMdYcbs = ((Result) obj).value;
        }
        if (!(objMo1450getLyricsbMdYcbs instanceof Result.Failure)) {
            function2.invoke((String) objMo1450getLyricsbMdYcbs);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00b0 A[Catch: all -> 0x00cf, TryCatch #0 {all -> 0x00cf, blocks: (B:14:0x002f, B:36:0x009f, B:38:0x00aa, B:41:0x00b0, B:42:0x00b2, B:45:0x00bc, B:47:0x00c2, B:50:0x00c7, B:51:0x00ce, B:19:0x0044, B:26:0x0075, B:28:0x007a, B:30:0x007e, B:32:0x0081, B:22:0x0052), top: B:55:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00c2 A[Catch: all -> 0x00cf, TryCatch #0 {all -> 0x00cf, blocks: (B:14:0x002f, B:36:0x009f, B:38:0x00aa, B:41:0x00b0, B:42:0x00b2, B:45:0x00bc, B:47:0x00c2, B:50:0x00c7, B:51:0x00ce, B:19:0x0044, B:26:0x0075, B:28:0x007a, B:30:0x007e, B:32:0x0081, B:22:0x0052), top: B:55:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00c6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c7 A[Catch: all -> 0x00cf, TryCatch #0 {all -> 0x00cf, blocks: (B:14:0x002f, B:36:0x009f, B:38:0x00aa, B:41:0x00b0, B:42:0x00b2, B:45:0x00bc, B:47:0x00c2, B:50:0x00c7, B:51:0x00ce, B:19:0x0044, B:26:0x0075, B:28:0x007a, B:30:0x007e, B:32:0x0081, B:22:0x0052), top: B:55:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    @Override // com.metrolist.music.lyrics.LyricsProvider
    /* JADX INFO: renamed from: getLyrics-bMdYcbs */
    public final Object mo1450getLyricsbMdYcbs(Context context, String str, String str2, String str3, int i, String str4, ContinuationImpl continuationImpl) {
        LyricsPlusProvider$getLyrics$1 lyricsPlusProvider$getLyrics$1;
        String str5;
        String str6;
        int i2;
        String str7;
        LyricsPlusProvider lyricsPlusProvider;
        BinimumLyricsFetchResult binimumLyricsFetchResult;
        LyricsPlusResponse lyricsPlusResponse;
        String strConvertToLrc;
        if (continuationImpl instanceof LyricsPlusProvider$getLyrics$1) {
            lyricsPlusProvider$getLyrics$1 = (LyricsPlusProvider$getLyrics$1) continuationImpl;
            int i3 = lyricsPlusProvider$getLyrics$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                lyricsPlusProvider$getLyrics$1.label = i3 - Integer.MIN_VALUE;
            } else {
                lyricsPlusProvider$getLyrics$1 = new LyricsPlusProvider$getLyrics$1(this, continuationImpl);
            }
        } else {
            lyricsPlusProvider$getLyrics$1 = new LyricsPlusProvider$getLyrics$1(this, continuationImpl);
        }
        LyricsPlusProvider$getLyrics$1 lyricsPlusProvider$getLyrics$2 = lyricsPlusProvider$getLyrics$1;
        Object objFetchBinimumLyricsApi = lyricsPlusProvider$getLyrics$2.result;
        int i4 = lyricsPlusProvider$getLyrics$2.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i4 == 0) {
                ResultKt.throwOnFailure(objFetchBinimumLyricsApi);
                lyricsPlusProvider$getLyrics$2.L$2 = str2;
                lyricsPlusProvider$getLyrics$2.L$3 = str3;
                lyricsPlusProvider$getLyrics$2.L$4 = str4;
                lyricsPlusProvider$getLyrics$2.L$5 = this;
                lyricsPlusProvider$getLyrics$2.I$0 = i;
                lyricsPlusProvider$getLyrics$2.label = 1;
                objFetchBinimumLyricsApi = fetchBinimumLyricsApi(i, str, str2, str3, str4, lyricsPlusProvider$getLyrics$2);
                if (objFetchBinimumLyricsApi != coroutineSingletons) {
                    str5 = str2;
                    str6 = str3;
                    i2 = i;
                    str7 = str4;
                }
                return coroutineSingletons;
            }
            if (i4 == 1) {
                int i5 = lyricsPlusProvider$getLyrics$2.I$0;
                LyricsPlusProvider lyricsPlusProvider2 = lyricsPlusProvider$getLyrics$2.L$5;
                String str8 = lyricsPlusProvider$getLyrics$2.L$4;
                str6 = lyricsPlusProvider$getLyrics$2.L$3;
                String str9 = lyricsPlusProvider$getLyrics$2.L$2;
                ResultKt.throwOnFailure(objFetchBinimumLyricsApi);
                i2 = i5;
                this = lyricsPlusProvider2;
                str5 = str9;
                str7 = str8;
            } else {
                if (i4 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                binimumLyricsFetchResult = lyricsPlusProvider$getLyrics$2.L$6;
                lyricsPlusProvider = lyricsPlusProvider$getLyrics$2.L$5;
                ResultKt.throwOnFailure(objFetchBinimumLyricsApi);
            }
            lyricsPlusResponse = (LyricsPlusResponse) objFetchBinimumLyricsApi;
            lyricsPlusProvider.getClass();
            strConvertToLrc = convertToLrc(lyricsPlusResponse);
            if (binimumLyricsFetchResult != null && !binimumLyricsFetchResult.isWordSync) {
                if (StringsKt__StringsJVMKt.equals(lyricsPlusResponse != null ? lyricsPlusResponse.type : null, "Word", true) || strConvertToLrc == null || StringsKt.isBlank(strConvertToLrc)) {
                    strConvertToLrc = binimumLyricsFetchResult.lrc;
                }
            }
            if (strConvertToLrc != null) {
                return strConvertToLrc;
            }
            throw new IllegalStateException("Lyrics unavailable");
            BinimumLyricsFetchResult binimumLyricsFetchResult2 = (BinimumLyricsFetchResult) objFetchBinimumLyricsApi;
            if (binimumLyricsFetchResult2 != null && binimumLyricsFetchResult2.isWordSync) {
                return binimumLyricsFetchResult2.lrc;
            }
            lyricsPlusProvider$getLyrics$2.L$2 = null;
            lyricsPlusProvider$getLyrics$2.L$3 = null;
            lyricsPlusProvider$getLyrics$2.L$4 = null;
            lyricsPlusProvider$getLyrics$2.L$5 = this;
            lyricsPlusProvider$getLyrics$2.L$6 = binimumLyricsFetchResult2;
            lyricsPlusProvider$getLyrics$2.I$0 = i2;
            lyricsPlusProvider$getLyrics$2.label = 2;
            objFetchBinimumLyricsApi = this.fetchLyrics(i2, str5, str6, str7, lyricsPlusProvider$getLyrics$2);
            if (objFetchBinimumLyricsApi != coroutineSingletons) {
                lyricsPlusProvider = this;
                binimumLyricsFetchResult = binimumLyricsFetchResult2;
                lyricsPlusResponse = (LyricsPlusResponse) objFetchBinimumLyricsApi;
                lyricsPlusProvider.getClass();
                strConvertToLrc = convertToLrc(lyricsPlusResponse);
                if (binimumLyricsFetchResult != null) {
                    if (StringsKt__StringsJVMKt.equals(lyricsPlusResponse != null ? lyricsPlusResponse.type : null, "Word", true)) {
                        strConvertToLrc = binimumLyricsFetchResult.lrc;
                    } else {
                        strConvertToLrc = binimumLyricsFetchResult.lrc;
                    }
                }
                if (strConvertToLrc != null) {
                    return strConvertToLrc;
                }
                throw new IllegalStateException("Lyrics unavailable");
            }
            return coroutineSingletons;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    @Override // com.metrolist.music.lyrics.LyricsProvider
    public final String getName() {
        return "LyricsPlus";
    }

    @Override // com.metrolist.music.lyrics.LyricsProvider
    public final boolean isEnabled(Context context) {
        Boolean bool = (Boolean) com.metrolist.music.utils.UtilsKt.get(com.metrolist.music.utils.UtilsKt.getDataStore(context), PreferenceKeysKt.EnableLyricsPlus);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
