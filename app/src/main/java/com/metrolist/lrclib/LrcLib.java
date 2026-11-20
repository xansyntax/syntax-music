package com.metrolist.lrclib;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.lastfm.LastFM$$ExternalSyntheticLambda1;
import com.metrolist.lrclib.models.Track;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.reflect.TypeInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
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
import kotlin.reflect.KTypeProjection;
import kotlin.text.Regex;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LrcLib {
    public static final LrcLib INSTANCE = new LrcLib();
    public static final SynchronizedLazyImpl client$delegate = new SynchronizedLazyImpl(new LastFM$$ExternalSyntheticLambda1((byte) 15));
    public static final List titleCleanupPatterns = CollectionsKt__IterablesKt.listOf((Object[]) new Regex[]{new Regex("\\s*\\(.*?(official|video|audio|lyrics|lyric|visualizer|hd|hq|4k|remaster|remix|live|acoustic|version|edit|extended|radio|clean|explicit).*?\\)", 0), new Regex("\\s*\\[.*?(official|video|audio|lyrics|lyric|visualizer|hd|hq|4k|remaster|remix|live|acoustic|version|edit|extended|radio|clean|explicit).*?\\]", 0), new Regex("\\s*【.*?】"), new Regex("\\s*\\|.*$"), new Regex("\\s*-\\s*(official|video|audio|lyrics|lyric|visualizer).*$", 0), new Regex("\\s*\\(feat\\..*?\\)", 0), new Regex("\\s*\\(ft\\..*?\\)", 0), new Regex("\\s*feat\\..*$", 0), new Regex("\\s*ft\\..*$", 0)});
    public static final List artistSeparators = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{" & ", " and ", ", ", " x ", " X ", " feat. ", " feat ", " ft. ", " ft ", " featuring ", " with "});

    /* JADX INFO: renamed from: com.metrolist.lrclib.LrcLib$getAllLyrics$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int I$0;
        public String L$0;
        public String L$1;
        public Function1 L$3;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LrcLib.this.getAllLyrics(null, null, 0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.lrclib.LrcLib$queryLyrics$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01371 extends ContinuationImpl {
        public String L$0;
        public String L$1;
        public String L$3;
        public String L$4;
        public int label;
        public /* synthetic */ Object result;

        public C01371(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LrcLib.this.queryLyrics(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.lrclib.LrcLib$queryLyricsWithParams$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01381 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01381(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LrcLib.this.queryLyricsWithParams(null, null, null, null, this);
        }
    }

    public static double calculateStringSimilarity(String str, String str2) {
        double d;
        String string = StringsKt.trim(str).toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string.toLowerCase(locale);
        lowerCase.getClass();
        String lowerCase2 = StringsKt.trim(str2).toString().toLowerCase(locale);
        lowerCase2.getClass();
        double d2 = 1.0d;
        if (lowerCase.equals(lowerCase2)) {
            return 1.0d;
        }
        if (lowerCase.length() == 0 || lowerCase2.length() == 0) {
            return 0.0d;
        }
        int i = 0;
        if (StringsKt.contains(lowerCase, lowerCase2, false) || StringsKt.contains(lowerCase2, lowerCase, false)) {
            return 0.8d;
        }
        int iMax = Math.max(lowerCase.length(), lowerCase2.length());
        int length = lowerCase.length();
        int length2 = lowerCase2.length();
        int i2 = length + 1;
        int[][] iArr = new int[i2][];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = new int[length2 + 1];
        }
        if (length >= 0) {
            int i4 = 0;
            while (true) {
                iArr[i4][0] = i4;
                if (i4 == length) {
                    break;
                }
                i4++;
            }
        }
        if (length2 >= 0) {
            int i5 = 0;
            while (true) {
                iArr[0][i5] = i5;
                if (i5 == length2) {
                    break;
                }
                i5++;
            }
        }
        if (1 <= length) {
            int i6 = 1;
            while (true) {
                if (1 <= length2) {
                    int i7 = 1;
                    while (true) {
                        int i8 = i6 - 1;
                        int i9 = i7 - 1;
                        int i10 = lowerCase.charAt(i8) == lowerCase2.charAt(i9) ? i : 1;
                        int[] iArr2 = iArr[i6];
                        int[] iArr3 = iArr[i8];
                        d = d2;
                        iArr2[i7] = Math.min(iArr3[i7] + 1, Math.min(iArr2[i9] + 1, iArr3[i9] + i10));
                        if (i7 == length2) {
                            break;
                        }
                        i7++;
                        d2 = d;
                        i = 0;
                    }
                } else {
                    d = d2;
                }
                if (i6 == length) {
                    break;
                }
                i6++;
                d2 = d;
                i = 0;
            }
        } else {
            d = 1.0d;
        }
        return d - (((double) iArr[length][length2]) / ((double) iMax));
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

    public static /* synthetic */ Object queryLyricsWithParams$default(LrcLib lrcLib, String str, String str2, String str3, String str4, C01371 c01371, int i) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        return lrcLib.queryLyricsWithParams(str, str2, str3, str4, c01371);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getAllLyrics(String str, String str2, final int i, String str3, Function1 function1, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        Serializable serializableQueryLyrics;
        Object obj;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj2 = anonymousClass1.result;
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj2);
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = str2;
            anonymousClass1.L$3 = function1;
            anonymousClass1.I$0 = i;
            anonymousClass1.label = 1;
            serializableQueryLyrics = queryLyrics(str2, str, str3, anonymousClass1);
            Serializable serializable = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (serializableQueryLyrics == serializable) {
                obj = serializableQueryLyrics;
                return serializable;
            }
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = anonymousClass1.I$0;
            function1 = anonymousClass1.L$3;
            str2 = anonymousClass1.L$1;
            str = anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj2);
            obj = obj2;
        }
        obj = serializableQueryLyrics;
        List list = (List) obj;
        int i4 = 0;
        int i5 = 0;
        for (Track track : i == -1 ? CollectionsKt.sortedWith(list, new LrcLib$getAllLyrics$$inlined$sortedByDescending$1((Object) cleanTitle(str), (Object) cleanArtist(str2), (byte) (false ? 1 : 0))) : CollectionsKt.sortedWith(list, new Comparator() { // from class: com.metrolist.lrclib.LrcLib$getAllLyrics$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj3, Object obj4) {
                int i6 = (int) ((Track) obj3).duration;
                int i7 = i;
                return Integer.valueOf(Math.abs(i6 - i7)).compareTo(Integer.valueOf(Math.abs(((int) ((Track) obj4).duration) - i7)));
            }
        })) {
            AwaitKt.ensureActive(anonymousClass1.getContext());
            if (i4 <= 4) {
                String str4 = track.syncedLyrics;
                String str5 = track.plainLyrics;
                double d = track.duration;
                if (str4 == null || i != -1) {
                    if (str4 != null && Math.abs(((int) d) - i) <= 5) {
                        i4++;
                        function1.invoke(track.syncedLyrics);
                    }
                    if (str5 != null && Math.abs(((int) d) - i) <= 5 && i5 == 0) {
                        i4++;
                        i5++;
                        function1.invoke(str5);
                    }
                } else {
                    i4++;
                    function1.invoke(str4);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: getLyrics-yxL6bBk, reason: not valid java name */
    public final Serializable m1054getLyricsyxL6bBk(int i, String str, String str2, String str3, ContinuationImpl continuationImpl) {
        LrcLib$getLyrics$1 lrcLib$getLyrics$1;
        String str4;
        if (continuationImpl instanceof LrcLib$getLyrics$1) {
            lrcLib$getLyrics$1 = (LrcLib$getLyrics$1) continuationImpl;
            int i2 = lrcLib$getLyrics$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                lrcLib$getLyrics$1.label = i2 - Integer.MIN_VALUE;
            } else {
                lrcLib$getLyrics$1 = new LrcLib$getLyrics$1(this, continuationImpl);
            }
        } else {
            lrcLib$getLyrics$1 = new LrcLib$getLyrics$1(this, continuationImpl);
        }
        Object objQueryLyrics = lrcLib$getLyrics$1.result;
        int i3 = lrcLib$getLyrics$1.label;
        String str5 = null;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(objQueryLyrics);
                lrcLib$getLyrics$1.L$0 = str;
                lrcLib$getLyrics$1.L$1 = str2;
                lrcLib$getLyrics$1.L$3 = this;
                lrcLib$getLyrics$1.I$0 = i;
                lrcLib$getLyrics$1.label = 1;
                objQueryLyrics = queryLyrics(str2, str, str3, lrcLib$getLyrics$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objQueryLyrics == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i3 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i = lrcLib$getLyrics$1.I$0;
                this = lrcLib$getLyrics$1.L$3;
                str2 = lrcLib$getLyrics$1.L$1;
                str = lrcLib$getLyrics$1.L$0;
                ResultKt.throwOnFailure(objQueryLyrics);
            }
            List list = (List) objQueryLyrics;
            this.getClass();
            String strCleanTitle = cleanTitle(str);
            String strCleanArtist = cleanArtist(str2);
            if (i == -1) {
                Track trackBestMatchingFor = RegexKt.bestMatchingFor(i, strCleanTitle, strCleanArtist, list);
                if (trackBestMatchingFor != null) {
                    str4 = trackBestMatchingFor.syncedLyrics;
                    if (str4 == null) {
                        str4 = trackBestMatchingFor.plainLyrics;
                    }
                    if (str4 != null) {
                        str5 = str4;
                    }
                }
            } else {
                Track trackBestMatchingForRelaxed = RegexKt.bestMatchingForRelaxed(i, list);
                if (trackBestMatchingForRelaxed != null) {
                    str4 = trackBestMatchingForRelaxed.syncedLyrics;
                    if (str4 == null) {
                        str4 = trackBestMatchingForRelaxed.plainLyrics;
                    }
                    if (str4 != null) {
                        str5 = str4;
                    }
                }
            }
            if (str5 != null) {
                return str5;
            }
            throw new IllegalStateException("Lyrics unavailable");
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x019c A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x0157 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0059 A[PHI: r0 r1 r12 r15
      0x0059: PHI (r0v16 java.lang.Object) = (r0v15 java.lang.Object), (r0v1 java.lang.Object) binds: [B:56:0x0133, B:20:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x0059: PHI (r1v7 java.lang.String) = (r1v6 java.lang.String), (r1v15 java.lang.String) binds: [B:56:0x0133, B:20:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x0059: PHI (r12v3 java.lang.String) = (r12v2 java.lang.String), (r12v5 java.lang.String) binds: [B:56:0x0133, B:20:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x0059: PHI (r15v3 java.lang.String) = (r15v2 java.lang.String), (r15v6 java.lang.String) binds: [B:56:0x0133, B:20:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:47:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:54:0x0118 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x0119  */
    /* JADX WARN: Code duplicated, block: B:61:0x0148  */
    /* JADX WARN: Code duplicated, block: B:63:0x0153  */
    /* JADX WARN: Code duplicated, block: B:68:0x0161 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:69:0x0162  */
    /* JADX WARN: Code duplicated, block: B:72:0x0179  */
    /* JADX WARN: Code duplicated, block: B:76:0x018d  */
    /* JADX WARN: Code duplicated, block: B:78:0x0198  */
    /* JADX WARN: Code duplicated, block: B:84:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01d9, code lost:
    
        if (r0 == r14) goto L88;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable queryLyrics(String str, String str2, String str3, ContinuationImpl continuationImpl) {
        C01371 c01371;
        LrcLib lrcLib;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        ArrayList arrayList;
        Track track;
        String str11;
        ArrayList arrayList2;
        String str12;
        String str13;
        String str14;
        Track track2;
        ArrayList arrayList3;
        Track track3;
        if (continuationImpl instanceof C01371) {
            c01371 = (C01371) continuationImpl;
            int i = c01371.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01371.label = i - Integer.MIN_VALUE;
                lrcLib = this;
            } else {
                lrcLib = this;
                c01371 = lrcLib.new C01371(continuationImpl);
            }
        } else {
            lrcLib = this;
            c01371 = lrcLib.new C01371(continuationImpl);
        }
        C01371 c01372 = c01371;
        Object objQueryLyricsWithParams$default = c01372.result;
        int i2 = c01372.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objQueryLyricsWithParams$default);
            String strCleanTitle = cleanTitle(str2);
            String strCleanArtist = cleanArtist(str);
            str4 = str;
            c01372.L$0 = str4;
            str5 = str2;
            c01372.L$1 = str5;
            c01372.L$3 = strCleanTitle;
            c01372.L$4 = strCleanArtist;
            c01372.label = 1;
            str6 = strCleanTitle;
            objQueryLyricsWithParams$default = queryLyricsWithParams$default(lrcLib, str6, strCleanArtist, str3, null, c01372, 8);
            if (objQueryLyricsWithParams$default != coroutineSingletons) {
                str7 = strCleanArtist;
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            String str15 = c01372.L$4;
            str6 = c01372.L$3;
            String str16 = c01372.L$1;
            String str17 = c01372.L$0;
            ResultKt.throwOnFailure(objQueryLyricsWithParams$default);
            str7 = str15;
            str5 = str16;
            str4 = str17;
        } else {
            if (i2 == 2) {
                String str18 = c01372.L$4;
                str6 = c01372.L$3;
                String str19 = c01372.L$1;
                String str20 = c01372.L$0;
                ResultKt.throwOnFailure(objQueryLyricsWithParams$default);
                str8 = str18;
                str5 = str19;
                str9 = str20;
                str10 = str6;
                arrayList = new ArrayList();
                for (Object obj : (Iterable) objQueryLyricsWithParams$default) {
                    track = (Track) obj;
                    if (track.syncedLyrics == null || track.plainLyrics != null) {
                        arrayList.add(obj);
                    }
                }
                if (!arrayList.isEmpty()) {
                    return arrayList;
                }
                String strM = Fragment$5$$ExternalSyntheticOutline0.m(str8, ServerSentEventKt.SPACE, str10);
                c01372.L$0 = str9;
                c01372.L$1 = str5;
                c01372.L$3 = str10;
                c01372.L$4 = null;
                c01372.label = 3;
                objQueryLyricsWithParams$default = queryLyricsWithParams$default(this, null, null, null, strM, c01372, 7);
                if (objQueryLyricsWithParams$default != coroutineSingletons) {
                    str11 = str10;
                    arrayList2 = new ArrayList();
                    for (Object obj2 : (Iterable) objQueryLyricsWithParams$default) {
                        track2 = (Track) obj2;
                        if (track2.syncedLyrics == null) {
                        }
                        arrayList2.add(obj2);
                    }
                    if (!arrayList2.isEmpty()) {
                        return arrayList2;
                    }
                    c01372.L$0 = str9;
                    c01372.L$1 = str5;
                    c01372.L$3 = str11;
                    c01372.L$4 = null;
                    c01372.label = 4;
                    objQueryLyricsWithParams$default = queryLyricsWithParams$default(this, null, null, null, str11, c01372, 7);
                    if (objQueryLyricsWithParams$default != coroutineSingletons) {
                        str12 = str11;
                        str13 = str9;
                        str14 = str5;
                        arrayList3 = new ArrayList();
                        for (Object obj3 : (Iterable) objQueryLyricsWithParams$default) {
                            track3 = (Track) obj3;
                            if (track3.syncedLyrics == null) {
                            }
                            arrayList3.add(obj3);
                        }
                        if (!arrayList3.isEmpty()) {
                            String string = StringsKt.trim(str14).toString();
                            String string2 = StringsKt.trim(str13).toString();
                            c01372.L$0 = null;
                            c01372.L$1 = null;
                            c01372.L$3 = null;
                            c01372.L$4 = null;
                            c01372.label = 5;
                            objQueryLyricsWithParams$default = queryLyricsWithParams$default(this, string, string2, null, null, c01372, 12);
                        }
                        return arrayList3;
                    }
                }
                return coroutineSingletons;
            }
            if (i2 == 3) {
                str10 = c01372.L$3;
                String str21 = c01372.L$1;
                String str22 = c01372.L$0;
                ResultKt.throwOnFailure(objQueryLyricsWithParams$default);
                str5 = str21;
                str9 = str22;
                str11 = str10;
                arrayList2 = new ArrayList();
                while (r0.hasNext()) {
                    track2 = (Track) obj2;
                    if (track2.syncedLyrics == null || track2.plainLyrics != null) {
                        arrayList2.add(obj2);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    return arrayList2;
                }
                c01372.L$0 = str9;
                c01372.L$1 = str5;
                c01372.L$3 = str11;
                c01372.L$4 = null;
                c01372.label = 4;
                objQueryLyricsWithParams$default = queryLyricsWithParams$default(this, null, null, null, str11, c01372, 7);
                if (objQueryLyricsWithParams$default != coroutineSingletons) {
                    str12 = str11;
                    str13 = str9;
                    str14 = str5;
                    arrayList3 = new ArrayList();
                    while (r0.hasNext()) {
                        track3 = (Track) obj3;
                        if (track3.syncedLyrics == null) {
                        }
                        arrayList3.add(obj3);
                    }
                    if (!arrayList3.isEmpty()) {
                        String string3 = StringsKt.trim(str14).toString();
                        String string4 = StringsKt.trim(str13).toString();
                        c01372.L$0 = null;
                        c01372.L$1 = null;
                        c01372.L$3 = null;
                        c01372.L$4 = null;
                        c01372.label = 5;
                        objQueryLyricsWithParams$default = queryLyricsWithParams$default(this, string3, string4, null, null, c01372, 12);
                    }
                    return arrayList3;
                }
                return coroutineSingletons;
            }
            if (i2 == 4) {
                str12 = c01372.L$3;
                str14 = c01372.L$1;
                str13 = c01372.L$0;
                ResultKt.throwOnFailure(objQueryLyricsWithParams$default);
                arrayList3 = new ArrayList();
                while (r0.hasNext()) {
                    track3 = (Track) obj3;
                    if (track3.syncedLyrics == null || track3.plainLyrics != null) {
                        arrayList3.add(obj3);
                    }
                }
                if (!arrayList3.isEmpty() || Intrinsics.areEqual(str12, StringsKt.trim(str14).toString())) {
                    return arrayList3;
                }
                String string5 = StringsKt.trim(str14).toString();
                String string6 = StringsKt.trim(str13).toString();
                c01372.L$0 = null;
                c01372.L$1 = null;
                c01372.L$3 = null;
                c01372.L$4 = null;
                c01372.label = 5;
                objQueryLyricsWithParams$default = queryLyricsWithParams$default(this, string5, string6, null, null, c01372, 12);
            } else {
                if (i2 != 5) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objQueryLyricsWithParams$default);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : (Iterable) objQueryLyricsWithParams$default) {
            Track track4 = (Track) obj4;
            if (track4.syncedLyrics != null || track4.plainLyrics != null) {
                arrayList4.add(obj4);
            }
        }
        return arrayList4;
        ArrayList arrayList5 = new ArrayList();
        for (Object obj5 : (Iterable) objQueryLyricsWithParams$default) {
            Track track5 = (Track) obj5;
            if (track5.syncedLyrics != null || track5.plainLyrics != null) {
                arrayList5.add(obj5);
            }
        }
        if (!arrayList5.isEmpty()) {
            return arrayList5;
        }
        c01372.L$0 = str4;
        c01372.L$1 = str5;
        c01372.L$3 = str6;
        c01372.L$4 = str7;
        c01372.label = 2;
        String str23 = str7;
        Object objQueryLyricsWithParams$default2 = queryLyricsWithParams$default(this, str6, null, null, null, c01372, 14);
        if (objQueryLyricsWithParams$default2 != coroutineSingletons) {
            str8 = str23;
            str9 = str4;
            objQueryLyricsWithParams$default = objQueryLyricsWithParams$default2;
            str10 = str6;
            arrayList = new ArrayList();
            while (r0.hasNext()) {
                track = (Track) obj;
                if (track.syncedLyrics == null) {
                }
                arrayList.add(obj);
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            String strM2 = Fragment$5$$ExternalSyntheticOutline0.m(str8, ServerSentEventKt.SPACE, str10);
            c01372.L$0 = str9;
            c01372.L$1 = str5;
            c01372.L$3 = str10;
            c01372.L$4 = null;
            c01372.label = 3;
            objQueryLyricsWithParams$default = queryLyricsWithParams$default(this, null, null, null, strM2, c01372, 7);
            if (objQueryLyricsWithParams$default != coroutineSingletons) {
                str11 = str10;
                arrayList2 = new ArrayList();
                while (r0.hasNext()) {
                    track2 = (Track) obj2;
                    if (track2.syncedLyrics == null) {
                    }
                    arrayList2.add(obj2);
                }
                if (!arrayList2.isEmpty()) {
                    return arrayList2;
                }
                c01372.L$0 = str9;
                c01372.L$1 = str5;
                c01372.L$3 = str11;
                c01372.L$4 = null;
                c01372.label = 4;
                objQueryLyricsWithParams$default = queryLyricsWithParams$default(this, null, null, null, str11, c01372, 7);
                if (objQueryLyricsWithParams$default != coroutineSingletons) {
                    str12 = str11;
                    str13 = str9;
                    str14 = str5;
                    arrayList3 = new ArrayList();
                    while (r0.hasNext()) {
                        track3 = (Track) obj3;
                        if (track3.syncedLyrics == null) {
                        }
                        arrayList3.add(obj3);
                    }
                    if (!arrayList3.isEmpty()) {
                        String string7 = StringsKt.trim(str14).toString();
                        String string8 = StringsKt.trim(str13).toString();
                        c01372.L$0 = null;
                        c01372.L$1 = null;
                        c01372.L$3 = null;
                        c01372.L$4 = null;
                        c01372.label = 5;
                        objQueryLyricsWithParams$default = queryLyricsWithParams$default(this, string7, string8, null, null, c01372, 12);
                    }
                    return arrayList3;
                }
            }
        }
        return coroutineSingletons;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a1, code lost:
    
        if (r6 == r4) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object queryLyricsWithParams(String str, String str2, String str3, String str4, ContinuationImpl continuationImpl) {
        C01381 c01381;
        Object failure;
        if (continuationImpl instanceof C01381) {
            c01381 = (C01381) continuationImpl;
            int i = c01381.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01381.label = i - Integer.MIN_VALUE;
            } else {
                c01381 = new C01381(continuationImpl);
            }
        } else {
            c01381 = new C01381(continuationImpl);
        }
        Object objExecute = c01381.result;
        int i2 = c01381.label;
        TypeReference typeReferenceTypeOf = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
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
                    if (objExecute == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.metrolist.lrclib.models.Track>");
                    }
                    failure = (List) objExecute;
                    return failure instanceof Result.Failure ? EmptyList.INSTANCE : failure;
                }
                ResultKt.throwOnFailure(objExecute);
                HttpClient httpClient = (HttpClient) client$delegate.getValue();
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder, "/api/search");
                if (str4 != null) {
                    UtilsKt.parameter(httpRequestBuilder, "q", str4);
                }
                if (str != null) {
                    UtilsKt.parameter(httpRequestBuilder, "track_name", str);
                }
                if (str2 != null) {
                    UtilsKt.parameter(httpRequestBuilder, "artist_name", str2);
                }
                if (str3 != null) {
                    UtilsKt.parameter(httpRequestBuilder, "album_name", str3);
                }
                httpRequestBuilder.setMethod(HttpMethod.Get);
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                c01381.label = 1;
                objExecute = httpStatement.execute(c01381);
                if (objExecute == coroutineSingletons) {
                }
                return coroutineSingletons;
                typeReferenceTypeOf = Reflection.typeOf(List.class, KTypeProjection.invariant(Reflection.typeOf(Track.class)));
            } catch (Throwable unused) {
            }
            HttpClientCall call = ((HttpResponse) objExecute).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(List.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            c01381.label = 2;
            objExecute = call.bodyNullable(typeInfo, c01381);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
    }
}
