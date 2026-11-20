package com.metrolist.innertubex.extraction;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.gestures.NonTouchScrollingLogicKt$untilNull$1;
import androidx.compose.material3.IconKt$$ExternalSyntheticLambda1;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda2;
import com.metrolist.innertubex.InnerTube;
import com.metrolist.innertubex.cipher.RemotePlayerConfigStore;
import com.metrolist.music.ui.menu.QueueMenuKt$QueueMenu$7$1$1$1;
import dagger.hilt.EntryPoints;
import io.ktor.client.HttpClient;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteChannelKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.ReversedListReadOnly;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.LinesSequence;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YtConfigParserImpl {
    public final HttpClient httpClient;
    public final InnerTube innerTube;
    public final PathKt$$ExternalSyntheticBUOutline0 logger;
    public final RemotePlayerConfigStore remotePlayerConfigStore;
    public static final Set REDIRECT_STATUS_CODES = ArraysKt.toSet(new Integer[]{301, 302, 303, 307, 308});
    public static final Regex SAFE_VIDEO_ID = new Regex("[A-Za-z0-9_-]{1,64}");
    public static final Regex EMBED_PATH = new Regex("/embed/[A-Za-z0-9_-]{1,64}");
    public static final Regex PLAYER_PATH = new Regex("/s/player/[A-Za-z0-9_-]+/.+\\.js");
    public static final List KEYED_PLAYER_URL_PATTERNS = CollectionsKt__IterablesKt.listOf((Object[]) new Regex[]{new Regex("\"PLAYER_JS_URL\":\"([^\"]+)\""), new Regex("\"jsUrl\":\"([^\"]+)\"")});
    public static final Regex LOOSE_PLAYER_URL_PATTERN = new Regex("(?<![A-Za-z0-9:/])(/s/player/[^\"'\\\\]+/[^\"'\\\\]*\\.js[^\"'\\\\]*)");
    public static final Regex PLAYER_ID_REGEX = new Regex("/s/player/([a-zA-Z0-9_-]+)/");
    public static final List STS_PATTERNS = CollectionsKt__IterablesKt.listOf((Object[]) new Regex[]{new Regex("(?:signatureTimestamp|sts)\"?\\s*:\\s*([0-9]{5})"), new Regex("\"STS\":\\s*([0-9]{5})")});
    public static final Regex CLIENT_VERSION_REGEX = new Regex("\"INNERTUBE_CLIENT_VERSION\"\\s*:\\s*\"([^\"]+)\"");
    public static final Regex ENCRYPTED_HOST_FLAGS_REGEX = new Regex("\"encryptedHostFlags\"\\s*:\\s*\"([^\"]+)\"");
    public static final Regex VISITOR_DATA_REGEX = new Regex("\"visitorData\"\\s*:\\s*\"([^\"]+)\"");

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.YtConfigParserImpl$fetchConfigPage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public String L$1;
        public String L$2;
        public String L$3;
        public String L$4;
        public QueueMenuKt$QueueMenu$7$1$1$1 L$7;
        public String L$8;
        public String L$9;
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
            return YtConfigParserImpl.this.fetchConfigPage(false, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.YtConfigParserImpl$fetchIframePlayerUrl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01291 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01291(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YtConfigParserImpl.this.fetchIframePlayerUrl(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.YtConfigParserImpl$fetchPlayerSignatureTimestamp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01301 extends ContinuationImpl {
        public String L$0;
        public int label;
        public /* synthetic */ Object result;

        public C01301(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YtConfigParserImpl.this.fetchPlayerSignatureTimestamp(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.YtConfigParserImpl$getText$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01311 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public int I$2;
        public int I$3;
        public Function2 L$1;
        public Function1 L$2;
        public Ref$ObjectRef L$3;
        public int label;
        public /* synthetic */ Object result;

        public C01311(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YtConfigParserImpl.this.getText(null, 0, null, null, this);
        }
    }

    public YtConfigParserImpl(HttpClient httpClient, InnerTube innerTube, RemotePlayerConfigStore remotePlayerConfigStore, PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0) {
        httpClient.getClass();
        innerTube.getClass();
        pathKt$$ExternalSyntheticBUOutline0.getClass();
        this.httpClient = httpClient;
        this.innerTube = innerTube;
        this.remotePlayerConfigStore = remotePlayerConfigStore;
        this.logger = pathKt$$ExternalSyntheticBUOutline0;
    }

    public static boolean approvedYouTubeHost(String str) {
        return Intrinsics.areEqual(str, "youtube.com") || StringsKt__StringsJVMKt.endsWith(str, ".youtube.com", false) || str.equals("youtube-nocookie.com") || StringsKt__StringsJVMKt.endsWith(str, ".youtube-nocookie.com", false);
    }

    public static String extractPlayerId$com_github_MetrolistGroup_innertubex(String str) {
        str.getClass();
        MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(PLAYER_ID_REGEX, StringsKt__StringsJVMKt.replace(str, "\\/", "/", false));
        if (matcherMatchResultFind$default != null) {
            return (String) ((ReversedListReadOnly) matcherMatchResultFind$default.getGroupValues()).get(1);
        }
        return null;
    }

    public static Integer extractSignatureTimestamp$com_github_MetrolistGroup_innertubex(String str) {
        str.getClass();
        return (Integer) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(STS_PATTERNS), new IconKt$$ExternalSyntheticLambda1(str, (byte) 14)));
    }

    public static String validatePlayerUrl(String str) {
        Object failure;
        try {
            failure = URLUtilsKt.Url(str);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (failure instanceof Result.Failure) {
            failure = null;
        }
        Url url = (Url) failure;
        if (url == null) {
            return null;
        }
        if (!Intrinsics.areEqual(url.getProtocol().getName(), "https") || url.getPort() != 443 || !approvedYouTubeHost(url.getHost()) || url.getUser() != null || url.getPassword() != null || !PLAYER_PATH.matches(url.getEncodedPath())) {
            url = null;
        }
        if (url != null) {
            return url.getUrlString();
        }
        return null;
    }

    public final String extractPlayerUrl$com_github_MetrolistGroup_innertubex(String str) {
        str.getClass();
        return (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.plus(SequencesKt.mapNotNull(CollectionsKt.asSequence(KEYED_PLAYER_URL_PATTERNS), new IconKt$$ExternalSyntheticLambda1((byte) 15, this, str)), new LinesSequence((byte) 3, new NonTouchScrollingLogicKt$untilNull$1(this, str, null))), new YouTube$$ExternalSyntheticLambda2(this)));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x025b  */
    /* JADX WARN: Code duplicated, block: B:102:0x0269  */
    /* JADX WARN: Code duplicated, block: B:105:0x0272  */
    /* JADX WARN: Code duplicated, block: B:106:0x027f  */
    /* JADX WARN: Code duplicated, block: B:110:0x0289  */
    /* JADX WARN: Code duplicated, block: B:113:0x0290  */
    /* JADX WARN: Code duplicated, block: B:114:0x0292  */
    /* JADX WARN: Code duplicated, block: B:116:0x0296  */
    /* JADX WARN: Code duplicated, block: B:117:0x0298  */
    /* JADX WARN: Code duplicated, block: B:119:0x029c  */
    /* JADX WARN: Code duplicated, block: B:120:0x029e  */
    /* JADX WARN: Code duplicated, block: B:123:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:125:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:128:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:49:0x012f  */
    /* JADX WARN: Code duplicated, block: B:67:0x0192  */
    /* JADX WARN: Code duplicated, block: B:69:0x0198  */
    /* JADX WARN: Code duplicated, block: B:73:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:77:0x01db  */
    /* JADX WARN: Code duplicated, block: B:85:0x0200 A[PHI: r0 r1 r2 r3 r6 r7 r9 r14 r15
      0x0200: PHI (r0v31 java.lang.String) = (r0v27 java.lang.String), (r0v34 java.lang.String) binds: [B:76:0x01d9, B:82:0x01f7] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r1v8 com.metrolist.innertubex.extraction.YtConfigParserImpl) = 
      (r1v6 com.metrolist.innertubex.extraction.YtConfigParserImpl)
      (r1v9 com.metrolist.innertubex.extraction.YtConfigParserImpl)
     binds: [B:76:0x01d9, B:82:0x01f7] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r2v29 boolean) = (r2v27 boolean), (r2v30 boolean) binds: [B:76:0x01d9, B:82:0x01f7] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r3v26 java.lang.String) = (r3v24 java.lang.String), (r3v28 java.lang.String) binds: [B:76:0x01d9, B:82:0x01f7] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r6v10 com.metrolist.innertubex.extraction.YtConfigParserImpl$fetchConfigPage$1) = 
      (r6v8 com.metrolist.innertubex.extraction.YtConfigParserImpl$fetchConfigPage$1)
      (r6v11 com.metrolist.innertubex.extraction.YtConfigParserImpl$fetchConfigPage$1)
     binds: [B:76:0x01d9, B:82:0x01f7] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r7v8 java.lang.String) = (r7v6 java.lang.String), (r7v10 java.lang.String) binds: [B:76:0x01d9, B:82:0x01f7] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r9v5 ??) = (r9v16 ??), (r9v7 ??) binds: [B:76:0x01d9, B:82:0x01f7] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r14v10 int) = (r14v8 int), (r14v11 int) binds: [B:76:0x01d9, B:82:0x01f7] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r15v10 kotlin.coroutines.intrinsics.CoroutineSingletons) = (r15v8 kotlin.coroutines.intrinsics.CoroutineSingletons), (r15v11 kotlin.coroutines.intrinsics.CoroutineSingletons) binds: [B:76:0x01d9, B:82:0x01f7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:87:0x0206  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Code duplicated, block: B:90:0x0222  */
    /* JADX WARN: Code duplicated, block: B:93:0x022b  */
    /* JADX WARN: Code duplicated, block: B:96:0x0246  */
    /* JADX WARN: Code duplicated, block: B:98:0x0250  */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01f0, code lost:
    
        if (r0 == r15) goto L95;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.metrolist.music.ui.menu.QueueMenuKt$QueueMenu$7$1$1$1, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v5, types: [com.metrolist.music.ui.menu.QueueMenuKt$QueueMenu$7$1$1$1, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchConfigPage(boolean z, String str, String str2, String str3, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        String str4;
        int i;
        CoroutineSingletons coroutineSingletons;
        QueueMenuKt$QueueMenu$7$1$1$1 queueMenuKt$QueueMenu$7$1$1$1;
        AnonymousClass1 anonymousClass2;
        Exception exc;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z2;
        String str9;
        String str10;
        QueueMenuKt$QueueMenu$7$1$1$1 queueMenuKt$QueueMenu$7$1$1$2;
        String strM;
        Object obj;
        Object text;
        String str11;
        Exception e;
        String str12;
        String str13;
        ?? r9;
        String str14;
        String strExtractPlayerUrl$com_github_MetrolistGroup_innertubex;
        ?? r10;
        Integer numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex;
        Object signatureTimestamp;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        MatcherMatchResult matcherMatchResultFind$default;
        String str21;
        MatcherMatchResult matcherMatchResultFind$default2;
        String str22;
        boolean z3;
        boolean z4;
        boolean z5;
        MatcherMatchResult matcherMatchResultFind$default3;
        String str23;
        YtConfigParserImpl ytConfigParserImpl = this;
        boolean z6 = z;
        String str24 = str3;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = ytConfigParserImpl.new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = ytConfigParserImpl.new AnonymousClass1(continuationImpl);
        }
        AnonymousClass1 anonymousClass3 = anonymousClass1;
        Object text2 = anonymousClass3.result;
        int i3 = anonymousClass3.label;
        byte b = 29;
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0 = ytConfigParserImpl.logger;
        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(text2);
                    String str25 = ((InnerTube.SessionSnapshot) ytConfigParserImpl.innerTube.session.get()).cookie;
                    if (str25 == null) {
                        str4 = null;
                    } else {
                        if (!z6) {
                            str25 = null;
                        }
                        if (str25 != null) {
                            List listSplit$default = StringsKt.split$default(str25, new char[]{';'});
                            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
                            Iterator it = listSplit$default.iterator();
                            while (it.hasNext()) {
                                arrayList.add(StringsKt.trim((String) it.next()).toString());
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int size = arrayList.size();
                            int i4 = 0;
                            while (i4 < size) {
                                Object obj2 = arrayList.get(i4);
                                i4++;
                                String str26 = (String) obj2;
                                if (str26.length() > 0 && !StringsKt__StringsJVMKt.startsWith(str26, "PREF=", true)) {
                                    arrayList2.add(obj2);
                                }
                            }
                            String strJoinToString$default = CollectionsKt.joinToString$default(arrayList2, "; ", null, null, null, 62);
                            if (strJoinToString$default.length() > 0) {
                                str4 = strJoinToString$default;
                            } else {
                                str4 = null;
                            }
                        } else {
                            str4 = null;
                        }
                    }
                    i = 1;
                    coroutineSingletons = coroutineSingletons2;
                    queueMenuKt$QueueMenu$7$1$1$1 = new QueueMenuKt$QueueMenu$7$1$1$1(this, str2, new Ref$ObjectRef(), new Ref$ObjectRef(), null);
                    ytConfigParserImpl = this;
                    try {
                        anonymousClass3.L$1 = str;
                        anonymousClass3.L$2 = str2;
                        anonymousClass3.L$3 = str24;
                        anonymousClass3.L$4 = str4;
                        anonymousClass3.L$7 = queueMenuKt$QueueMenu$7$1$1$1;
                        anonymousClass3.Z$0 = z6;
                        anonymousClass3.label = 1;
                        anonymousClass2 = anonymousClass3;
                        try {
                            text2 = ytConfigParserImpl.getText(URLUtilsKt.Url(str), 4194304, queueMenuKt$QueueMenu$7$1$1$1, new UtilsKt$$ExternalSyntheticLambda0(str24, str4, ytConfigParserImpl, b), anonymousClass2);
                            if (text2 != coroutineSingletons) {
                                str8 = str2;
                                z2 = z6;
                                str9 = str24;
                                str10 = str4;
                                str6 = str;
                                queueMenuKt$QueueMenu$7$1$1$2 = queueMenuKt$QueueMenu$7$1$1$1;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            exc = e;
                            str5 = str4;
                            str6 = str;
                            str7 = str2;
                            if (str5 == null) {
                                throw exc;
                            }
                            strM = Format$$ExternalSyntheticOutline0.m(exc);
                            if (strM == null) {
                                strM = "Exception";
                            }
                            Map mapSingletonMap = Collections.singletonMap("exceptionType", strM);
                            mapSingletonMap.getClass();
                            EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "YtConfigParser", "authenticated config page unavailable; retrying without cookies", mapSingletonMap, 4);
                            obj = null;
                            anonymousClass2.L$1 = null;
                            anonymousClass2.L$2 = str7;
                            anonymousClass2.L$3 = null;
                            anonymousClass2.L$4 = null;
                            anonymousClass2.L$7 = null;
                            anonymousClass2.L$8 = null;
                            anonymousClass2.Z$0 = z6;
                            anonymousClass2.label = 2;
                            text = ytConfigParserImpl.getText(URLUtilsKt.Url(str6), 4194304, queueMenuKt$QueueMenu$7$1$1$1, new UtilsKt$$ExternalSyntheticLambda0((Object) str24, (Object) (false ? 1 : 0), (Object) ytConfigParserImpl, b), anonymousClass2);
                            if (text != coroutineSingletons) {
                                str11 = str7;
                                text2 = text;
                                z2 = z6;
                                str12 = (String) text2;
                                str13 = str11;
                                r9 = obj;
                                str14 = str12;
                                strExtractPlayerUrl$com_github_MetrolistGroup_innertubex = ytConfigParserImpl.extractPlayerUrl$com_github_MetrolistGroup_innertubex(str14);
                                r10 = r9;
                                if (strExtractPlayerUrl$com_github_MetrolistGroup_innertubex == null) {
                                    numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex = extractSignatureTimestamp$com_github_MetrolistGroup_innertubex(str14);
                                    if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex == null) {
                                        anonymousClass2.L$1 = r10;
                                        anonymousClass2.L$2 = str13;
                                        anonymousClass2.L$3 = r10;
                                        anonymousClass2.L$4 = r10;
                                        anonymousClass2.L$7 = r10;
                                        anonymousClass2.L$8 = str14;
                                        anonymousClass2.L$9 = strExtractPlayerUrl$com_github_MetrolistGroup_innertubex;
                                        anonymousClass2.Z$0 = z2;
                                        anonymousClass2.label = 4;
                                        signatureTimestamp = ytConfigParserImpl.remotePlayerConfigStore.getSignatureTimestamp(strExtractPlayerUrl$com_github_MetrolistGroup_innertubex, anonymousClass2);
                                        if (signatureTimestamp != coroutineSingletons) {
                                            str15 = str13;
                                            str16 = str14;
                                            str17 = strExtractPlayerUrl$com_github_MetrolistGroup_innertubex;
                                            text2 = signatureTimestamp;
                                            numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex = (Integer) text2;
                                            if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex == null) {
                                                anonymousClass2.L$1 = null;
                                                anonymousClass2.L$2 = str15;
                                                anonymousClass2.L$3 = null;
                                                anonymousClass2.L$4 = null;
                                                anonymousClass2.L$7 = null;
                                                anonymousClass2.L$8 = str16;
                                                anonymousClass2.L$9 = str17;
                                                anonymousClass2.Z$0 = z2;
                                                anonymousClass2.label = 5;
                                                text2 = ytConfigParserImpl.fetchPlayerSignatureTimestamp(str17, anonymousClass2);
                                                if (text2 != coroutineSingletons) {
                                                    str18 = str17;
                                                    str19 = str16;
                                                    str20 = str15;
                                                    numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex = (Integer) text2;
                                                    strExtractPlayerUrl$com_github_MetrolistGroup_innertubex = str18;
                                                    str13 = str20;
                                                    str14 = str19;
                                                }
                                            } else {
                                                strExtractPlayerUrl$com_github_MetrolistGroup_innertubex = str17;
                                                str14 = str16;
                                                str13 = str15;
                                            }
                                        }
                                    }
                                    matcherMatchResultFind$default = Regex.find$default(VISITOR_DATA_REGEX, str14);
                                    if (matcherMatchResultFind$default != null) {
                                        str21 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default.getGroupValues()).get(i);
                                    } else {
                                        str21 = null;
                                    }
                                    matcherMatchResultFind$default2 = Regex.find$default(ENCRYPTED_HOST_FLAGS_REGEX, str14);
                                    if (matcherMatchResultFind$default2 != null) {
                                        str22 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default2.getGroupValues()).get(i);
                                    } else {
                                        str22 = null;
                                    }
                                    if (!Intrinsics.areEqual(str13, "embed")) {
                                        str22 = null;
                                    }
                                    int length = str14.length();
                                    if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex != null) {
                                        z3 = i;
                                    } else {
                                        z3 = 0;
                                    }
                                    if (str21 != null) {
                                        z4 = i;
                                    } else {
                                        z4 = 0;
                                    }
                                    if (str22 != null) {
                                        z5 = i;
                                    } else {
                                        z5 = 0;
                                    }
                                    StringBuilder sb = new StringBuilder("fetchConfig parsed page=");
                                    sb.append(str13);
                                    sb.append(" htmlSize=");
                                    sb.append(length);
                                    sb.append(" hasSts=");
                                    Fragment$5$$ExternalSyntheticOutline0.m(sb, z3, " hasVisitorData=", z4, " hasEncryptedHostFlags=");
                                    sb.append(z5);
                                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "YtConfigParser", sb.toString(), null, 12);
                                    matcherMatchResultFind$default3 = Regex.find$default(CLIENT_VERSION_REGEX, str14);
                                    if (matcherMatchResultFind$default3 != null) {
                                        str23 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default3.getGroupValues()).get(i);
                                    } else {
                                        str23 = null;
                                    }
                                    return new PlayerConfig(strExtractPlayerUrl$com_github_MetrolistGroup_innertubex, numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex, str21, str23, str22);
                                }
                                anonymousClass2.L$1 = r9;
                                anonymousClass2.L$2 = str13;
                                anonymousClass2.L$3 = r9;
                                anonymousClass2.L$4 = r9;
                                anonymousClass2.L$7 = r9;
                                anonymousClass2.L$8 = str14;
                                anonymousClass2.Z$0 = z2;
                                anonymousClass2.label = 3;
                                text2 = ytConfigParserImpl.fetchIframePlayerUrl(anonymousClass2);
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        anonymousClass2 = anonymousClass3;
                    }
                    return coroutineSingletons;
                }
                if (i3 == 1) {
                    z2 = anonymousClass3.Z$0;
                    queueMenuKt$QueueMenu$7$1$1$2 = anonymousClass3.L$7;
                    str10 = anonymousClass3.L$4;
                    str9 = anonymousClass3.L$3;
                    str8 = anonymousClass3.L$2;
                    str6 = anonymousClass3.L$1;
                    try {
                        ResultKt.throwOnFailure(text2);
                        i = 1;
                        coroutineSingletons = coroutineSingletons2;
                        anonymousClass2 = anonymousClass3;
                    } catch (Exception e4) {
                        e = e4;
                        str24 = str9;
                        str5 = str10;
                        i = 1;
                        coroutineSingletons = coroutineSingletons2;
                        queueMenuKt$QueueMenu$7$1$1$1 = queueMenuKt$QueueMenu$7$1$1$2;
                        anonymousClass2 = anonymousClass3;
                        z6 = z2;
                        exc = e;
                        str7 = str8;
                        if (str5 == null) {
                            throw exc;
                        }
                        strM = Format$$ExternalSyntheticOutline0.m(exc);
                        if (strM == null) {
                            strM = "Exception";
                        }
                        Map mapSingletonMap2 = Collections.singletonMap("exceptionType", strM);
                        mapSingletonMap2.getClass();
                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "YtConfigParser", "authenticated config page unavailable; retrying without cookies", mapSingletonMap2, 4);
                        obj = null;
                        anonymousClass2.L$1 = null;
                        anonymousClass2.L$2 = str7;
                        anonymousClass2.L$3 = null;
                        anonymousClass2.L$4 = null;
                        anonymousClass2.L$7 = null;
                        anonymousClass2.L$8 = null;
                        anonymousClass2.Z$0 = z6;
                        anonymousClass2.label = 2;
                        text = ytConfigParserImpl.getText(URLUtilsKt.Url(str6), 4194304, queueMenuKt$QueueMenu$7$1$1$1, new UtilsKt$$ExternalSyntheticLambda0((Object) str24, (Object) (false ? 1 : 0), (Object) ytConfigParserImpl, b), anonymousClass2);
                        if (text != coroutineSingletons) {
                            str11 = str7;
                            text2 = text;
                            z2 = z6;
                            str12 = (String) text2;
                            str13 = str11;
                            r9 = obj;
                            str14 = str12;
                            strExtractPlayerUrl$com_github_MetrolistGroup_innertubex = ytConfigParserImpl.extractPlayerUrl$com_github_MetrolistGroup_innertubex(str14);
                            r10 = r9;
                            if (strExtractPlayerUrl$com_github_MetrolistGroup_innertubex == null) {
                                numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex = extractSignatureTimestamp$com_github_MetrolistGroup_innertubex(str14);
                                if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex == null) {
                                    anonymousClass2.L$1 = r10;
                                    anonymousClass2.L$2 = str13;
                                    anonymousClass2.L$3 = r10;
                                    anonymousClass2.L$4 = r10;
                                    anonymousClass2.L$7 = r10;
                                    anonymousClass2.L$8 = str14;
                                    anonymousClass2.L$9 = strExtractPlayerUrl$com_github_MetrolistGroup_innertubex;
                                    anonymousClass2.Z$0 = z2;
                                    anonymousClass2.label = 4;
                                    signatureTimestamp = ytConfigParserImpl.remotePlayerConfigStore.getSignatureTimestamp(strExtractPlayerUrl$com_github_MetrolistGroup_innertubex, anonymousClass2);
                                    if (signatureTimestamp != coroutineSingletons) {
                                        str15 = str13;
                                        str16 = str14;
                                        str17 = strExtractPlayerUrl$com_github_MetrolistGroup_innertubex;
                                        text2 = signatureTimestamp;
                                        numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex = (Integer) text2;
                                        if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex == null) {
                                            anonymousClass2.L$1 = null;
                                            anonymousClass2.L$2 = str15;
                                            anonymousClass2.L$3 = null;
                                            anonymousClass2.L$4 = null;
                                            anonymousClass2.L$7 = null;
                                            anonymousClass2.L$8 = str16;
                                            anonymousClass2.L$9 = str17;
                                            anonymousClass2.Z$0 = z2;
                                            anonymousClass2.label = 5;
                                            text2 = ytConfigParserImpl.fetchPlayerSignatureTimestamp(str17, anonymousClass2);
                                            if (text2 != coroutineSingletons) {
                                                str18 = str17;
                                                str19 = str16;
                                                str20 = str15;
                                                numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex = (Integer) text2;
                                                strExtractPlayerUrl$com_github_MetrolistGroup_innertubex = str18;
                                                str13 = str20;
                                                str14 = str19;
                                            }
                                        } else {
                                            strExtractPlayerUrl$com_github_MetrolistGroup_innertubex = str17;
                                            str14 = str16;
                                            str13 = str15;
                                        }
                                    }
                                }
                                matcherMatchResultFind$default = Regex.find$default(VISITOR_DATA_REGEX, str14);
                                if (matcherMatchResultFind$default != null) {
                                    str21 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default.getGroupValues()).get(i);
                                } else {
                                    str21 = null;
                                }
                                matcherMatchResultFind$default2 = Regex.find$default(ENCRYPTED_HOST_FLAGS_REGEX, str14);
                                if (matcherMatchResultFind$default2 != null) {
                                    str22 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default2.getGroupValues()).get(i);
                                } else {
                                    str22 = null;
                                }
                                if (!Intrinsics.areEqual(str13, "embed")) {
                                    str22 = null;
                                }
                                int length2 = str14.length();
                                if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex != null) {
                                    z3 = i;
                                } else {
                                    z3 = 0;
                                }
                                if (str21 != null) {
                                    z4 = i;
                                } else {
                                    z4 = 0;
                                }
                                if (str22 != null) {
                                    z5 = i;
                                } else {
                                    z5 = 0;
                                }
                                StringBuilder sb2 = new StringBuilder("fetchConfig parsed page=");
                                sb2.append(str13);
                                sb2.append(" htmlSize=");
                                sb2.append(length2);
                                sb2.append(" hasSts=");
                                Fragment$5$$ExternalSyntheticOutline0.m(sb2, z3, " hasVisitorData=", z4, " hasEncryptedHostFlags=");
                                sb2.append(z5);
                                EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "YtConfigParser", sb2.toString(), null, 12);
                                matcherMatchResultFind$default3 = Regex.find$default(CLIENT_VERSION_REGEX, str14);
                                if (matcherMatchResultFind$default3 != null) {
                                    str23 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default3.getGroupValues()).get(i);
                                } else {
                                    str23 = null;
                                }
                                return new PlayerConfig(strExtractPlayerUrl$com_github_MetrolistGroup_innertubex, numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex, str21, str23, str22);
                            }
                            anonymousClass2.L$1 = r9;
                            anonymousClass2.L$2 = str13;
                            anonymousClass2.L$3 = r9;
                            anonymousClass2.L$4 = r9;
                            anonymousClass2.L$7 = r9;
                            anonymousClass2.L$8 = str14;
                            anonymousClass2.Z$0 = z2;
                            anonymousClass2.label = 3;
                            text2 = ytConfigParserImpl.fetchIframePlayerUrl(anonymousClass2);
                        }
                        return coroutineSingletons;
                    }
                } else {
                    if (i3 == 2) {
                        z2 = anonymousClass3.Z$0;
                        str11 = anonymousClass3.L$2;
                        ResultKt.throwOnFailure(text2);
                        i = 1;
                        coroutineSingletons = coroutineSingletons2;
                        anonymousClass2 = anonymousClass3;
                        obj = null;
                        str12 = (String) text2;
                        str13 = str11;
                        r9 = obj;
                        str14 = str12;
                        strExtractPlayerUrl$com_github_MetrolistGroup_innertubex = ytConfigParserImpl.extractPlayerUrl$com_github_MetrolistGroup_innertubex(str14);
                        r10 = r9;
                        if (strExtractPlayerUrl$com_github_MetrolistGroup_innertubex == null) {
                            numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex = extractSignatureTimestamp$com_github_MetrolistGroup_innertubex(str14);
                            if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex == null) {
                                anonymousClass2.L$1 = r10;
                                anonymousClass2.L$2 = str13;
                                anonymousClass2.L$3 = r10;
                                anonymousClass2.L$4 = r10;
                                anonymousClass2.L$7 = r10;
                                anonymousClass2.L$8 = str14;
                                anonymousClass2.L$9 = strExtractPlayerUrl$com_github_MetrolistGroup_innertubex;
                                anonymousClass2.Z$0 = z2;
                                anonymousClass2.label = 4;
                                signatureTimestamp = ytConfigParserImpl.remotePlayerConfigStore.getSignatureTimestamp(strExtractPlayerUrl$com_github_MetrolistGroup_innertubex, anonymousClass2);
                                if (signatureTimestamp != coroutineSingletons) {
                                    str15 = str13;
                                    str16 = str14;
                                    str17 = strExtractPlayerUrl$com_github_MetrolistGroup_innertubex;
                                    text2 = signatureTimestamp;
                                    numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex = (Integer) text2;
                                    if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex == null) {
                                        anonymousClass2.L$1 = null;
                                        anonymousClass2.L$2 = str15;
                                        anonymousClass2.L$3 = null;
                                        anonymousClass2.L$4 = null;
                                        anonymousClass2.L$7 = null;
                                        anonymousClass2.L$8 = str16;
                                        anonymousClass2.L$9 = str17;
                                        anonymousClass2.Z$0 = z2;
                                        anonymousClass2.label = 5;
                                        text2 = ytConfigParserImpl.fetchPlayerSignatureTimestamp(str17, anonymousClass2);
                                        if (text2 != coroutineSingletons) {
                                            str18 = str17;
                                            str19 = str16;
                                            str20 = str15;
                                        }
                                    } else {
                                        strExtractPlayerUrl$com_github_MetrolistGroup_innertubex = str17;
                                        str14 = str16;
                                        str13 = str15;
                                    }
                                }
                            }
                            matcherMatchResultFind$default = Regex.find$default(VISITOR_DATA_REGEX, str14);
                            if (matcherMatchResultFind$default != null) {
                                str21 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default.getGroupValues()).get(i);
                            } else {
                                str21 = null;
                            }
                            matcherMatchResultFind$default2 = Regex.find$default(ENCRYPTED_HOST_FLAGS_REGEX, str14);
                            if (matcherMatchResultFind$default2 != null) {
                                str22 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default2.getGroupValues()).get(i);
                            } else {
                                str22 = null;
                            }
                            if (!Intrinsics.areEqual(str13, "embed")) {
                                str22 = null;
                            }
                            int length3 = str14.length();
                            if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex != null) {
                                z3 = i;
                            } else {
                                z3 = 0;
                            }
                            if (str21 != null) {
                                z4 = i;
                            } else {
                                z4 = 0;
                            }
                            if (str22 != null) {
                                z5 = i;
                            } else {
                                z5 = 0;
                            }
                            StringBuilder sb3 = new StringBuilder("fetchConfig parsed page=");
                            sb3.append(str13);
                            sb3.append(" htmlSize=");
                            sb3.append(length3);
                            sb3.append(" hasSts=");
                            Fragment$5$$ExternalSyntheticOutline0.m(sb3, z3, " hasVisitorData=", z4, " hasEncryptedHostFlags=");
                            sb3.append(z5);
                            EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "YtConfigParser", sb3.toString(), null, 12);
                            matcherMatchResultFind$default3 = Regex.find$default(CLIENT_VERSION_REGEX, str14);
                            if (matcherMatchResultFind$default3 != null) {
                                str23 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default3.getGroupValues()).get(i);
                            } else {
                                str23 = null;
                            }
                            return new PlayerConfig(strExtractPlayerUrl$com_github_MetrolistGroup_innertubex, numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex, str21, str23, str22);
                        }
                        anonymousClass2.L$1 = r9;
                        anonymousClass2.L$2 = str13;
                        anonymousClass2.L$3 = r9;
                        anonymousClass2.L$4 = r9;
                        anonymousClass2.L$7 = r9;
                        anonymousClass2.L$8 = str14;
                        anonymousClass2.Z$0 = z2;
                        anonymousClass2.label = 3;
                        text2 = ytConfigParserImpl.fetchIframePlayerUrl(anonymousClass2);
                        return coroutineSingletons;
                    }
                    if (i3 == 3) {
                        z2 = anonymousClass3.Z$0;
                        str14 = anonymousClass3.L$8;
                        str13 = anonymousClass3.L$2;
                        ResultKt.throwOnFailure(text2);
                        i = 1;
                        coroutineSingletons = coroutineSingletons2;
                        anonymousClass2 = anonymousClass3;
                        strExtractPlayerUrl$com_github_MetrolistGroup_innertubex = (String) text2;
                        if (strExtractPlayerUrl$com_github_MetrolistGroup_innertubex == null) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unable to parse YouTube player JavaScript URL");
                            return null;
                        }
                        r10 = 0;
                        numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex = extractSignatureTimestamp$com_github_MetrolistGroup_innertubex(str14);
                        if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex == null) {
                            anonymousClass2.L$1 = r10;
                            anonymousClass2.L$2 = str13;
                            anonymousClass2.L$3 = r10;
                            anonymousClass2.L$4 = r10;
                            anonymousClass2.L$7 = r10;
                            anonymousClass2.L$8 = str14;
                            anonymousClass2.L$9 = strExtractPlayerUrl$com_github_MetrolistGroup_innertubex;
                            anonymousClass2.Z$0 = z2;
                            anonymousClass2.label = 4;
                            signatureTimestamp = ytConfigParserImpl.remotePlayerConfigStore.getSignatureTimestamp(strExtractPlayerUrl$com_github_MetrolistGroup_innertubex, anonymousClass2);
                            if (signatureTimestamp != coroutineSingletons) {
                                str15 = str13;
                                str16 = str14;
                                str17 = strExtractPlayerUrl$com_github_MetrolistGroup_innertubex;
                                text2 = signatureTimestamp;
                                numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex = (Integer) text2;
                                if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex == null) {
                                    anonymousClass2.L$1 = null;
                                    anonymousClass2.L$2 = str15;
                                    anonymousClass2.L$3 = null;
                                    anonymousClass2.L$4 = null;
                                    anonymousClass2.L$7 = null;
                                    anonymousClass2.L$8 = str16;
                                    anonymousClass2.L$9 = str17;
                                    anonymousClass2.Z$0 = z2;
                                    anonymousClass2.label = 5;
                                    text2 = ytConfigParserImpl.fetchPlayerSignatureTimestamp(str17, anonymousClass2);
                                    if (text2 != coroutineSingletons) {
                                        str18 = str17;
                                        str19 = str16;
                                        str20 = str15;
                                    }
                                } else {
                                    strExtractPlayerUrl$com_github_MetrolistGroup_innertubex = str17;
                                    str14 = str16;
                                    str13 = str15;
                                }
                            }
                            return coroutineSingletons;
                        }
                        matcherMatchResultFind$default = Regex.find$default(VISITOR_DATA_REGEX, str14);
                        if (matcherMatchResultFind$default != null) {
                            str21 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default.getGroupValues()).get(i);
                        } else {
                            str21 = null;
                        }
                        matcherMatchResultFind$default2 = Regex.find$default(ENCRYPTED_HOST_FLAGS_REGEX, str14);
                        if (matcherMatchResultFind$default2 != null) {
                            str22 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default2.getGroupValues()).get(i);
                        } else {
                            str22 = null;
                        }
                        if (!Intrinsics.areEqual(str13, "embed")) {
                            str22 = null;
                        }
                        int length4 = str14.length();
                        if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex != null) {
                            z3 = i;
                        } else {
                            z3 = 0;
                        }
                        if (str21 != null) {
                            z4 = i;
                        } else {
                            z4 = 0;
                        }
                        if (str22 != null) {
                            z5 = i;
                        } else {
                            z5 = 0;
                        }
                        StringBuilder sb4 = new StringBuilder("fetchConfig parsed page=");
                        sb4.append(str13);
                        sb4.append(" htmlSize=");
                        sb4.append(length4);
                        sb4.append(" hasSts=");
                        Fragment$5$$ExternalSyntheticOutline0.m(sb4, z3, " hasVisitorData=", z4, " hasEncryptedHostFlags=");
                        sb4.append(z5);
                        EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "YtConfigParser", sb4.toString(), null, 12);
                        matcherMatchResultFind$default3 = Regex.find$default(CLIENT_VERSION_REGEX, str14);
                        if (matcherMatchResultFind$default3 != null) {
                            str23 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default3.getGroupValues()).get(i);
                        } else {
                            str23 = null;
                        }
                        return new PlayerConfig(strExtractPlayerUrl$com_github_MetrolistGroup_innertubex, numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex, str21, str23, str22);
                    }
                    if (i3 == 4) {
                        z2 = anonymousClass3.Z$0;
                        str17 = anonymousClass3.L$9;
                        str16 = anonymousClass3.L$8;
                        str15 = anonymousClass3.L$2;
                        ResultKt.throwOnFailure(text2);
                        i = 1;
                        coroutineSingletons = coroutineSingletons2;
                        anonymousClass2 = anonymousClass3;
                        numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex = (Integer) text2;
                        if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex == null) {
                            anonymousClass2.L$1 = null;
                            anonymousClass2.L$2 = str15;
                            anonymousClass2.L$3 = null;
                            anonymousClass2.L$4 = null;
                            anonymousClass2.L$7 = null;
                            anonymousClass2.L$8 = str16;
                            anonymousClass2.L$9 = str17;
                            anonymousClass2.Z$0 = z2;
                            anonymousClass2.label = 5;
                            text2 = ytConfigParserImpl.fetchPlayerSignatureTimestamp(str17, anonymousClass2);
                            if (text2 != coroutineSingletons) {
                                str18 = str17;
                                str19 = str16;
                                str20 = str15;
                            }
                            return coroutineSingletons;
                        }
                        strExtractPlayerUrl$com_github_MetrolistGroup_innertubex = str17;
                        str14 = str16;
                        str13 = str15;
                        matcherMatchResultFind$default = Regex.find$default(VISITOR_DATA_REGEX, str14);
                        if (matcherMatchResultFind$default != null) {
                            str21 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default.getGroupValues()).get(i);
                        } else {
                            str21 = null;
                        }
                        matcherMatchResultFind$default2 = Regex.find$default(ENCRYPTED_HOST_FLAGS_REGEX, str14);
                        if (matcherMatchResultFind$default2 != null) {
                            str22 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default2.getGroupValues()).get(i);
                        } else {
                            str22 = null;
                        }
                        if (!Intrinsics.areEqual(str13, "embed")) {
                            str22 = null;
                        }
                        int length5 = str14.length();
                        if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex != null) {
                            z3 = i;
                        } else {
                            z3 = 0;
                        }
                        if (str21 != null) {
                            z4 = i;
                        } else {
                            z4 = 0;
                        }
                        if (str22 != null) {
                            z5 = i;
                        } else {
                            z5 = 0;
                        }
                        StringBuilder sb5 = new StringBuilder("fetchConfig parsed page=");
                        sb5.append(str13);
                        sb5.append(" htmlSize=");
                        sb5.append(length5);
                        sb5.append(" hasSts=");
                        Fragment$5$$ExternalSyntheticOutline0.m(sb5, z3, " hasVisitorData=", z4, " hasEncryptedHostFlags=");
                        sb5.append(z5);
                        EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "YtConfigParser", sb5.toString(), null, 12);
                        matcherMatchResultFind$default3 = Regex.find$default(CLIENT_VERSION_REGEX, str14);
                        if (matcherMatchResultFind$default3 != null) {
                            str23 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default3.getGroupValues()).get(i);
                        } else {
                            str23 = null;
                        }
                        return new PlayerConfig(strExtractPlayerUrl$com_github_MetrolistGroup_innertubex, numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex, str21, str23, str22);
                    }
                    if (i3 != 5) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    str18 = anonymousClass3.L$9;
                    str19 = anonymousClass3.L$8;
                    str20 = anonymousClass3.L$2;
                    ResultKt.throwOnFailure(text2);
                    i = 1;
                }
                numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex = (Integer) text2;
                strExtractPlayerUrl$com_github_MetrolistGroup_innertubex = str18;
                str13 = str20;
                str14 = str19;
                matcherMatchResultFind$default = Regex.find$default(VISITOR_DATA_REGEX, str14);
                if (matcherMatchResultFind$default != null) {
                    str21 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default.getGroupValues()).get(i);
                } else {
                    str21 = null;
                }
                matcherMatchResultFind$default2 = Regex.find$default(ENCRYPTED_HOST_FLAGS_REGEX, str14);
                if (matcherMatchResultFind$default2 != null) {
                    str22 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default2.getGroupValues()).get(i);
                } else {
                    str22 = null;
                }
                if (!Intrinsics.areEqual(str13, "embed")) {
                    str22 = null;
                }
                int length6 = str14.length();
                if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex != null) {
                    z3 = i;
                } else {
                    z3 = 0;
                }
                if (str21 != null) {
                    z4 = i;
                } else {
                    z4 = 0;
                }
                if (str22 != null) {
                    z5 = i;
                } else {
                    z5 = 0;
                }
                StringBuilder sb6 = new StringBuilder("fetchConfig parsed page=");
                sb6.append(str13);
                sb6.append(" htmlSize=");
                sb6.append(length6);
                sb6.append(" hasSts=");
                Fragment$5$$ExternalSyntheticOutline0.m(sb6, z3, " hasVisitorData=", z4, " hasEncryptedHostFlags=");
                sb6.append(z5);
                EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "YtConfigParser", sb6.toString(), null, 12);
                matcherMatchResultFind$default3 = Regex.find$default(CLIENT_VERSION_REGEX, str14);
                if (matcherMatchResultFind$default3 != null) {
                    str23 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default3.getGroupValues()).get(i);
                } else {
                    str23 = null;
                }
                return new PlayerConfig(strExtractPlayerUrl$com_github_MetrolistGroup_innertubex, numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex, str21, str23, str22);
                str12 = (String) text2;
                str13 = str8;
                r9 = 0;
            } catch (Exception e5) {
                e = e5;
                String str27 = str10;
                str24 = str9;
                str5 = str27;
                queueMenuKt$QueueMenu$7$1$1$1 = queueMenuKt$QueueMenu$7$1$1$2;
                z6 = z2;
                exc = e;
                str7 = str8;
                if (str5 == null) {
                    throw exc;
                }
                strM = Format$$ExternalSyntheticOutline0.m(exc);
                if (strM == null) {
                    strM = "Exception";
                }
                Map mapSingletonMap3 = Collections.singletonMap("exceptionType", strM);
                mapSingletonMap3.getClass();
                EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "YtConfigParser", "authenticated config page unavailable; retrying without cookies", mapSingletonMap3, 4);
                obj = null;
                anonymousClass2.L$1 = null;
                anonymousClass2.L$2 = str7;
                anonymousClass2.L$3 = null;
                anonymousClass2.L$4 = null;
                anonymousClass2.L$7 = null;
                anonymousClass2.L$8 = null;
                anonymousClass2.Z$0 = z6;
                anonymousClass2.label = 2;
                text = ytConfigParserImpl.getText(URLUtilsKt.Url(str6), 4194304, queueMenuKt$QueueMenu$7$1$1$1, new UtilsKt$$ExternalSyntheticLambda0((Object) str24, (Object) (false ? 1 : 0), (Object) ytConfigParserImpl, b), anonymousClass2);
                if (text != coroutineSingletons) {
                    str11 = str7;
                    text2 = text;
                    z2 = z6;
                    str12 = (String) text2;
                    str13 = str11;
                    r9 = obj;
                }
                return coroutineSingletons;
            }
            str14 = str12;
            strExtractPlayerUrl$com_github_MetrolistGroup_innertubex = ytConfigParserImpl.extractPlayerUrl$com_github_MetrolistGroup_innertubex(str14);
            r10 = r9;
            if (strExtractPlayerUrl$com_github_MetrolistGroup_innertubex == null) {
                numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex = extractSignatureTimestamp$com_github_MetrolistGroup_innertubex(str14);
                if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex == null) {
                    anonymousClass2.L$1 = r10;
                    anonymousClass2.L$2 = str13;
                    anonymousClass2.L$3 = r10;
                    anonymousClass2.L$4 = r10;
                    anonymousClass2.L$7 = r10;
                    anonymousClass2.L$8 = str14;
                    anonymousClass2.L$9 = strExtractPlayerUrl$com_github_MetrolistGroup_innertubex;
                    anonymousClass2.Z$0 = z2;
                    anonymousClass2.label = 4;
                    signatureTimestamp = ytConfigParserImpl.remotePlayerConfigStore.getSignatureTimestamp(strExtractPlayerUrl$com_github_MetrolistGroup_innertubex, anonymousClass2);
                    if (signatureTimestamp != coroutineSingletons) {
                        str15 = str13;
                        str16 = str14;
                        str17 = strExtractPlayerUrl$com_github_MetrolistGroup_innertubex;
                        text2 = signatureTimestamp;
                        numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex = (Integer) text2;
                        if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex == null) {
                            anonymousClass2.L$1 = null;
                            anonymousClass2.L$2 = str15;
                            anonymousClass2.L$3 = null;
                            anonymousClass2.L$4 = null;
                            anonymousClass2.L$7 = null;
                            anonymousClass2.L$8 = str16;
                            anonymousClass2.L$9 = str17;
                            anonymousClass2.Z$0 = z2;
                            anonymousClass2.label = 5;
                            text2 = ytConfigParserImpl.fetchPlayerSignatureTimestamp(str17, anonymousClass2);
                            if (text2 != coroutineSingletons) {
                                str18 = str17;
                                str19 = str16;
                                str20 = str15;
                                numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex = (Integer) text2;
                                strExtractPlayerUrl$com_github_MetrolistGroup_innertubex = str18;
                                str13 = str20;
                                str14 = str19;
                            }
                        } else {
                            strExtractPlayerUrl$com_github_MetrolistGroup_innertubex = str17;
                            str14 = str16;
                            str13 = str15;
                        }
                    }
                }
                matcherMatchResultFind$default = Regex.find$default(VISITOR_DATA_REGEX, str14);
                if (matcherMatchResultFind$default != null) {
                    str21 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default.getGroupValues()).get(i);
                } else {
                    str21 = null;
                }
                matcherMatchResultFind$default2 = Regex.find$default(ENCRYPTED_HOST_FLAGS_REGEX, str14);
                if (matcherMatchResultFind$default2 != null) {
                    str22 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default2.getGroupValues()).get(i);
                } else {
                    str22 = null;
                }
                if (!Intrinsics.areEqual(str13, "embed")) {
                    str22 = null;
                }
                int length7 = str14.length();
                if (numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex != null) {
                    z3 = i;
                } else {
                    z3 = 0;
                }
                if (str21 != null) {
                    z4 = i;
                } else {
                    z4 = 0;
                }
                if (str22 != null) {
                    z5 = i;
                } else {
                    z5 = 0;
                }
                StringBuilder sb7 = new StringBuilder("fetchConfig parsed page=");
                sb7.append(str13);
                sb7.append(" htmlSize=");
                sb7.append(length7);
                sb7.append(" hasSts=");
                Fragment$5$$ExternalSyntheticOutline0.m(sb7, z3, " hasVisitorData=", z4, " hasEncryptedHostFlags=");
                sb7.append(z5);
                EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "YtConfigParser", sb7.toString(), null, 12);
                matcherMatchResultFind$default3 = Regex.find$default(CLIENT_VERSION_REGEX, str14);
                if (matcherMatchResultFind$default3 != null) {
                    str23 = (String) ((ReversedListReadOnly) matcherMatchResultFind$default3.getGroupValues()).get(i);
                } else {
                    str23 = null;
                }
                return new PlayerConfig(strExtractPlayerUrl$com_github_MetrolistGroup_innertubex, numExtractSignatureTimestamp$com_github_MetrolistGroup_innertubex, str21, str23, str22);
            }
            anonymousClass2.L$1 = r9;
            anonymousClass2.L$2 = str13;
            anonymousClass2.L$3 = r9;
            anonymousClass2.L$4 = r9;
            anonymousClass2.L$7 = r9;
            anonymousClass2.L$8 = str14;
            anonymousClass2.Z$0 = z2;
            anonymousClass2.label = 3;
            text2 = ytConfigParserImpl.fetchIframePlayerUrl(anonymousClass2);
            return coroutineSingletons;
        } catch (CancellationException e6) {
            throw e6;
        }
    }

    public final Object fetchEmbeddedConfig(String str, ContinuationImpl continuationImpl) {
        if (SAFE_VIDEO_ID.matches(str)) {
            return fetchConfigPage(false, IntIntPair$$ExternalSyntheticOutline0.m("https://www.youtube.com/embed/", str, "?html5=1"), "embed", "https://www.reddit.com/", continuationImpl);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Invalid video ID");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x007f  */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    public final Object fetchIframePlayerUrl(ContinuationImpl continuationImpl) throws IOException {
        C01291 c01291;
        YtConfigParserImpl ytConfigParserImpl;
        Exception exc;
        String strM;
        if (continuationImpl instanceof C01291) {
            c01291 = (C01291) continuationImpl;
            int i = c01291.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01291.label = i - Integer.MIN_VALUE;
            } else {
                c01291 = new C01291(continuationImpl);
            }
        } else {
            c01291 = new C01291(continuationImpl);
        }
        C01291 c01292 = c01291;
        Object text = c01292.result;
        int i2 = c01292.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(text);
                try {
                    Url Url = URLUtilsKt.Url("https://www.youtube.com/iframe_api");
                    YouTube$$ExternalSyntheticLambda2 youTube$$ExternalSyntheticLambda2 = new YouTube$$ExternalSyntheticLambda2((byte) 25);
                    c01292.label = 1;
                    ytConfigParserImpl = this;
                    try {
                        text = ytConfigParserImpl.getText(Url, ByteChannelKt.CHANNEL_MAX_SIZE, null, youTube$$ExternalSyntheticLambda2, c01292);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (text == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } catch (Exception e) {
                        e = e;
                        exc = e;
                        strM = Format$$ExternalSyntheticOutline0.m(exc);
                        if (strM == null) {
                            strM = "Exception";
                        }
                        EntryPoints.d$default(ytConfigParserImpl.logger, "YtConfigParser", "iframe player URL unavailable type=".concat(strM), null, 12);
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    ytConfigParserImpl = this;
                    exc = e;
                    strM = Format$$ExternalSyntheticOutline0.m(exc);
                    if (strM == null) {
                        strM = "Exception";
                    }
                    EntryPoints.d$default(ytConfigParserImpl.logger, "YtConfigParser", "iframe player URL unavailable type=".concat(strM), null, 12);
                    return null;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                try {
                    ResultKt.throwOnFailure(text);
                    ytConfigParserImpl = this;
                } catch (Exception e3) {
                    exc = e3;
                    ytConfigParserImpl = this;
                    strM = Format$$ExternalSyntheticOutline0.m(exc);
                    if (strM == null) {
                        strM = "Exception";
                    }
                    EntryPoints.d$default(ytConfigParserImpl.logger, "YtConfigParser", "iframe player URL unavailable type=".concat(strM), null, 12);
                    return null;
                }
            }
            String strExtractPlayerId$com_github_MetrolistGroup_innertubex = extractPlayerId$com_github_MetrolistGroup_innertubex((String) text);
            if (strExtractPlayerId$com_github_MetrolistGroup_innertubex == null) {
                return null;
            }
            return validatePlayerUrl("https://www.youtube.com/s/player/" + strExtractPlayerId$com_github_MetrolistGroup_innertubex + "/player_ias.vflset/en_GB/base.js");
        } catch (CancellationException e4) {
            throw e4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0074  */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object fetchPlayerSignatureTimestamp(String str, ContinuationImpl continuationImpl) throws IOException {
        C01301 c01301;
        YtConfigParserImpl ytConfigParserImpl;
        Url Url;
        YouTube$$ExternalSyntheticLambda2 youTube$$ExternalSyntheticLambda2;
        Exception exc;
        String strM;
        String str2;
        if (continuationImpl instanceof C01301) {
            c01301 = (C01301) continuationImpl;
            int i = c01301.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01301.label = i - Integer.MIN_VALUE;
            } else {
                c01301 = new C01301(continuationImpl);
            }
        } else {
            c01301 = new C01301(continuationImpl);
        }
        C01301 c01302 = c01301;
        Object text = c01302.result;
        int i2 = c01302.label;
        try {
            try {
                try {
                    if (i2 != 0) {
                        try {
                            if (i2 == 1) {
                                str = c01302.L$0;
                                ResultKt.throwOnFailure(text);
                                str2 = (String) text;
                                if (str2 != null) {
                                    ytConfigParserImpl = this;
                                }
                            } else {
                                if (i2 != 2) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                    return null;
                                }
                                ResultKt.throwOnFailure(text);
                                ytConfigParserImpl = this;
                                str2 = (String) text;
                            }
                            return extractSignatureTimestamp$com_github_MetrolistGroup_innertubex(str2);
                        } catch (Exception e) {
                            exc = e;
                            ytConfigParserImpl = this;
                            strM = Format$$ExternalSyntheticOutline0.m(exc);
                            if (strM == null) {
                                strM = "Exception";
                            }
                            EntryPoints.d$default(ytConfigParserImpl.logger, "YtConfigParser", "player JS timestamp unavailable type=".concat(strM), null, 12);
                            return null;
                        }
                    }
                    ResultKt.throwOnFailure(text);
                    text = ytConfigParserImpl.getText(Url, 8388608, null, youTube$$ExternalSyntheticLambda2, c01302);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (text == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    str2 = (String) text;
                    return extractSignatureTimestamp$com_github_MetrolistGroup_innertubex(str2);
                } catch (Exception e2) {
                    e = e2;
                    exc = e;
                    strM = Format$$ExternalSyntheticOutline0.m(exc);
                    if (strM == null) {
                        strM = "Exception";
                    }
                    EntryPoints.d$default(ytConfigParserImpl.logger, "YtConfigParser", "player JS timestamp unavailable type=".concat(strM), null, 12);
                    return null;
                }
                Url = URLUtilsKt.Url(str);
                youTube$$ExternalSyntheticLambda2 = new YouTube$$ExternalSyntheticLambda2((byte) 24);
                c01302.L$0 = null;
                c01302.label = 2;
                ytConfigParserImpl = this;
            } catch (Exception e3) {
                e = e3;
                ytConfigParserImpl = this;
                exc = e;
                strM = Format$$ExternalSyntheticOutline0.m(exc);
                if (strM == null) {
                    strM = "Exception";
                }
                EntryPoints.d$default(ytConfigParserImpl.logger, "YtConfigParser", "player JS timestamp unavailable type=".concat(strM), null, 12);
                return null;
            }
        } catch (CancellationException e4) {
            throw e4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004f  */
    /* JADX WARN: Code duplicated, block: B:18:0x006e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x006f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0085  */
    /* JADX WARN: Code duplicated, block: B:29:0x008f  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:47:0x00da  */
    /* JADX WARN: Code duplicated, block: B:64:0x0129  */
    /* JADX WARN: Code duplicated, block: B:66:0x012c  */
    /* JADX WARN: Code duplicated, block: B:71:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006f -> B:20:0x0070). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object getText(io.ktor.http.Url r11, int r12, kotlin.jvm.functions.Function2 r13, kotlin.jvm.functions.Function1 r14, kotlin.coroutines.jvm.internal.ContinuationImpl r15) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.innertubex.extraction.YtConfigParserImpl.getText(io.ktor.http.Url, int, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
