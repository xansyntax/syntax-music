package com.metrolist.innertubex.cipher;

import android.content.SharedPreferences;
import androidx.compose.material3.IconKt$$ExternalSyntheticLambda1;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import coil3.network.HttpException;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda2;
import com.metrolist.innertube.models.response.BrowseResponse$$ExternalSyntheticLambda0;
import com.metrolist.music.utils.InnerTubeXPlayer;
import dagger.hilt.EntryPoints;
import io.ktor.client.HttpClient;
import io.ktor.http.HttpHeaders;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.HexFormatKt;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RemotePlayerConfigStore {
    public volatile long configEpoch;
    public volatile String configSourceUrl;
    public volatile Map configs;
    public final HttpClient httpClient;
    public volatile long lastRefreshAttemptAtMs;
    public volatile String lastRefreshAttemptSourceUrl;
    public volatile long lastStreamRejectionRefreshAtMs;
    public volatile String lastStreamRejectionRefreshSourceUrl;
    public volatile long lastUnknownHashRefreshAtMs;
    public volatile String lastUnknownHashRefreshSourceUrl;
    public final LinkedHashMap legacyTimestampCache;
    public final PathKt$$ExternalSyntheticBUOutline0 logger;
    public final MutexImpl mutex;
    public final BrowseResponse$$ExternalSyntheticLambda0 nowMs;
    public final MutexImpl refreshMutex;
    public final InnerTubeXPlayer.AndroidPlayerConfigRepository repository;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CachedLegacyTimestamp {
        public final long fetchedAtMs;
        public final Integer value;

        public CachedLegacyTimestamp(Integer num, long j) {
            this.value = num;
            this.fetchedAtMs = j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CachedLegacyTimestamp)) {
                return false;
            }
            CachedLegacyTimestamp cachedLegacyTimestamp = (CachedLegacyTimestamp) obj;
            return Intrinsics.areEqual(this.value, cachedLegacyTimestamp.value) && this.fetchedAtMs == cachedLegacyTimestamp.fetchedAtMs;
        }

        public final int hashCode() {
            Integer num = this.value;
            return Long.hashCode(this.fetchedAtMs) + ((num == null ? 0 : num.hashCode()) * 31);
        }

        public final String toString() {
            return "CachedLegacyTimestamp(value=" + this.value + ", fetchedAtMs=" + this.fetchedAtMs + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RefreshResult {
        public final boolean changed;
        public final boolean requestAttempted;

        public RefreshResult(boolean z, boolean z2) {
            this.changed = z;
            this.requestAttempted = z2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RefreshResult)) {
                return false;
            }
            RefreshResult refreshResult = (RefreshResult) obj;
            return this.changed == refreshResult.changed && this.requestAttempted == refreshResult.requestAttempted;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.requestAttempted) + (Boolean.hashCode(this.changed) * 31);
        }

        public final String toString() {
            return "RefreshResult(changed=" + this.changed + ", requestAttempted=" + this.requestAttempted + ")";
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.RemotePlayerConfigStore$getLegacySignatureTimestamp$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public long J$0;
        public String L$1;
        public String L$2;
        public Object L$3;
        public MutexImpl L$4;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemotePlayerConfigStore.this.getLegacySignatureTimestamp(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.RemotePlayerConfigStore$getSignatureTimestamp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00991 extends ContinuationImpl {
        public String L$0;
        public int label;
        public /* synthetic */ Object result;

        public C00991(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemotePlayerConfigStore.this.getSignatureTimestamp(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.RemotePlayerConfigStore$isKnownHash$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01001 extends ContinuationImpl {
        public String L$0;
        public String L$1;
        public MutexImpl L$2;
        public int label;
        public /* synthetic */ Object result;

        public C01001(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemotePlayerConfigStore.this.isKnownHash(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.RemotePlayerConfigStore$refresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01011 extends ContinuationImpl {
        public long J$0;
        public String L$0;
        public Mutex L$1;
        public MutexImpl L$2;
        public MutexImpl L$3;
        public RestrictedTextResponse L$4;
        public boolean Z$0;
        public boolean Z$1;
        public int label;
        public /* synthetic */ Object result;

        public C01011(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemotePlayerConfigStore.this.refresh(null, false, false, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.RemotePlayerConfigStore$releaseStreamRejectionRefresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01021 extends ContinuationImpl {
        public long J$0;
        public String L$0;
        public MutexImpl L$1;
        public int label;
        public /* synthetic */ Object result;

        public C01021(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemotePlayerConfigStore.this.releaseStreamRejectionRefresh(0L, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.RemotePlayerConfigStore$releaseUnknownHashRefresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01031 extends ContinuationImpl {
        public long J$0;
        public String L$0;
        public MutexImpl L$1;
        public int label;
        public /* synthetic */ Object result;

        public C01031(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemotePlayerConfigStore.this.releaseUnknownHashRefresh(0L, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.RemotePlayerConfigStore$reserveStreamRejectionRefresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01041 extends ContinuationImpl {
        public String L$0;
        public MutexImpl L$1;
        public int label;
        public /* synthetic */ Object result;

        public C01041(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemotePlayerConfigStore.this.reserveStreamRejectionRefresh(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.cipher.RemotePlayerConfigStore$reserveUnknownHashRefresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01051 extends ContinuationImpl {
        public String L$0;
        public MutexImpl L$1;
        public int label;
        public /* synthetic */ Object result;

        public C01051(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemotePlayerConfigStore.this.reserveUnknownHashRefresh(null, this);
        }
    }

    public RemotePlayerConfigStore(HttpClient httpClient, InnerTubeXPlayer.AndroidPlayerConfigRepository androidPlayerConfigRepository, PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0) {
        httpClient.getClass();
        androidPlayerConfigRepository.getClass();
        pathKt$$ExternalSyntheticBUOutline0.getClass();
        BrowseResponse$$ExternalSyntheticLambda0 browseResponse$$ExternalSyntheticLambda0 = new BrowseResponse$$ExternalSyntheticLambda0((byte) 26);
        this.httpClient = httpClient;
        this.repository = androidPlayerConfigRepository;
        this.logger = pathKt$$ExternalSyntheticBUOutline0;
        this.nowMs = browseResponse$$ExternalSyntheticLambda0;
        this.mutex = new MutexImpl();
        this.refreshMutex = new MutexImpl();
        this.legacyTimestampCache = new LinkedHashMap();
        this.configs = EmptyMap.INSTANCE;
    }

    public static Url validatedSourceUrlOrNull$com_github_MetrolistGroup_innertubex(String str) {
        Object failure;
        str.getClass();
        try {
            failure = URLUtilsKt.Url(str);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (failure instanceof Result.Failure) {
            failure = null;
        }
        Url url = (Url) failure;
        if (url == null || !Intrinsics.areEqual(url.getProtocol().getName(), "https")) {
            return null;
        }
        String host = url.getHost();
        int iHashCode = host.hashCode();
        boolean zStartsWith = false;
        if (iHashCode != -1860764461) {
            if (iHashCode != 1367311960) {
                if (iHashCode == 1985010934 && host.equals("github.com")) {
                    zStartsWith = StringsKt__StringsJVMKt.startsWith(url.getEncodedPath(), "/MetrolistGroup/faraday/releases/download/", false);
                }
            } else if (host.equals("raw.githubusercontent.com")) {
                zStartsWith = StringsKt__StringsJVMKt.startsWith(url.getEncodedPath(), "/MetrolistGroup/faraday/", false);
            }
        } else if (host.equals("cdn.jsdelivr.net")) {
            zStartsWith = StringsKt__StringsJVMKt.startsWith(url.getEncodedPath(), "/gh/MetrolistGroup/faraday@", false);
        }
        if (zStartsWith) {
            return url;
        }
        return null;
    }

    public final boolean applyConfigs(String str, LinkedHashMap linkedHashMap) {
        boolean z = (Intrinsics.areEqual(this.configSourceUrl, str) && this.configs.equals(linkedHashMap)) ? false : true;
        this.configs = linkedHashMap;
        this.configSourceUrl = str;
        if (z) {
            this.configEpoch++;
        }
        return z;
    }

    public final String configuredUrl() {
        this.repository.getClass();
        String str = "https://raw.githubusercontent.com/ZemerTeam/zemer-cipher/master/library/src/main/assets/player_configs.json";
        String string = StringsKt.trim("https://raw.githubusercontent.com/ZemerTeam/zemer-cipher/master/library/src/main/assets/player_configs.json").toString();
        if (StringsKt.isBlank(string)) {
            string = null;
        }
        if (string != null) {
            if (!string.equals("https://github.com/MetrolistGroup/faraday/releases/download/{playerTag}/{playerHash}.json")) {
                str = StringsKt__StringsJVMKt.endsWith(StringsKt.substringBefore$default(string, '?'), "/player_configs.json", false) ? string : null;
            }
            if (str != null && validatedSourceUrlOrNull$com_github_MetrolistGroup_innertubex(str) != null) {
                return str;
            }
        }
        return null;
    }

    public final void ensureLoadedFromCache(String str) throws IOException {
        if (!Intrinsics.areEqual(this.configSourceUrl, str) || this.configs.isEmpty()) {
            String string = this.repository.preferences.getString("source_url", "");
            if (string == null) {
                string = "";
            }
            if (string.equals(str)) {
                String string2 = this.repository.preferences.getString("json", "");
                String str2 = string2 != null ? string2 : "";
                if (StringsKt.isBlank(str2)) {
                    return;
                }
                HexFormatKt hexFormatKt = RemotePlayerConfigParser.parse(str2);
                if (hexFormatKt instanceof RemotePlayerConfigParser$ParseResult$Success) {
                    applyConfigs(str, ((RemotePlayerConfigParser$ParseResult$Success) hexFormatKt).configs);
                } else if (hexFormatKt instanceof RemotePlayerConfigParser$ParseResult$Failure) {
                    EntryPoints.w$default(this.logger, "RemotePlayerConfigStore", "Cached remote player configs rejected: ".concat(((RemotePlayerConfigParser$ParseResult$Failure) hexFormatKt).reason), null, 12);
                } else {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:49:0x00be  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00df A[Catch: CancellationException -> 0x0062, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0062, blocks: (B:25:0x005d, B:57:0x00d8, B:59:0x00df), top: B:75:0x005d }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0118  */
    /* JADX WARN: Code duplicated, block: B:73:0x011a  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009a, code lost:
    
        if (r3 == r11) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ed, code lost:
    
        if (releaseUnknownHashRefresh(r5, r3, r7) == r11) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object forceRefresh$com_github_MetrolistGroup_innertubex(String str, ContinuationImpl continuationImpl) throws Throwable {
        RemotePlayerConfigStore$forceRefresh$1 remotePlayerConfigStore$forceRefresh$1;
        String strConfiguredUrl;
        Object objIsKnownHash;
        Object objReserveUnknownHashRefresh;
        String str2;
        String str3;
        Long l;
        long jLongValue;
        boolean z;
        CancellationException cancellationException;
        String str4;
        long j;
        String str5;
        long j2;
        RefreshResult refreshResult;
        String str6;
        NonCancellable nonCancellable;
        RemotePlayerConfigStore$forceRefresh$2 remotePlayerConfigStore$forceRefresh$2;
        String str7 = str;
        if (continuationImpl instanceof RemotePlayerConfigStore$forceRefresh$1) {
            remotePlayerConfigStore$forceRefresh$1 = (RemotePlayerConfigStore$forceRefresh$1) continuationImpl;
            int i = remotePlayerConfigStore$forceRefresh$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                remotePlayerConfigStore$forceRefresh$1.label = i - Integer.MIN_VALUE;
            } else {
                remotePlayerConfigStore$forceRefresh$1 = new RemotePlayerConfigStore$forceRefresh$1(this, continuationImpl);
            }
        } else {
            remotePlayerConfigStore$forceRefresh$1 = new RemotePlayerConfigStore$forceRefresh$1(this, continuationImpl);
        }
        RemotePlayerConfigStore$forceRefresh$1 remotePlayerConfigStore$forceRefresh$3 = remotePlayerConfigStore$forceRefresh$1;
        Object objRefresh = remotePlayerConfigStore$forceRefresh$3.result;
        int i2 = remotePlayerConfigStore$forceRefresh$3.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objRefresh);
            this.repository.getClass();
            strConfiguredUrl = configuredUrl();
            if (strConfiguredUrl == null) {
                return Boolean.FALSE;
            }
            if (str7 != null) {
                remotePlayerConfigStore$forceRefresh$3.L$0 = str7;
                remotePlayerConfigStore$forceRefresh$3.L$1 = strConfiguredUrl;
                remotePlayerConfigStore$forceRefresh$3.label = 1;
                objIsKnownHash = isKnownHash(str7, strConfiguredUrl, remotePlayerConfigStore$forceRefresh$3);
            } else {
                remotePlayerConfigStore$forceRefresh$3.L$0 = str7;
                remotePlayerConfigStore$forceRefresh$3.L$1 = strConfiguredUrl;
                remotePlayerConfigStore$forceRefresh$3.label = 2;
                objReserveUnknownHashRefresh = reserveUnknownHashRefresh(strConfiguredUrl, remotePlayerConfigStore$forceRefresh$3);
                if (objReserveUnknownHashRefresh != obj) {
                    str2 = strConfiguredUrl;
                    objRefresh = objReserveUnknownHashRefresh;
                    str3 = str7;
                    l = (Long) objRefresh;
                    if (l == null) {
                        return Boolean.FALSE;
                    }
                    jLongValue = l.longValue();
                    if (str3 != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    remotePlayerConfigStore$forceRefresh$3.L$0 = null;
                    remotePlayerConfigStore$forceRefresh$3.L$1 = str2;
                    remotePlayerConfigStore$forceRefresh$3.J$0 = jLongValue;
                    remotePlayerConfigStore$forceRefresh$3.label = 3;
                    objRefresh = refresh(str2, true, z, remotePlayerConfigStore$forceRefresh$3);
                    if (objRefresh != obj) {
                        str5 = str2;
                        j2 = jLongValue;
                        refreshResult = (RefreshResult) objRefresh;
                        if (!refreshResult.requestAttempted) {
                            remotePlayerConfigStore$forceRefresh$3.L$0 = null;
                            remotePlayerConfigStore$forceRefresh$3.L$1 = str5;
                            remotePlayerConfigStore$forceRefresh$3.L$2 = refreshResult;
                            remotePlayerConfigStore$forceRefresh$3.J$0 = j2;
                            remotePlayerConfigStore$forceRefresh$3.label = 4;
                        }
                        long j3 = j2;
                        str6 = str5;
                        j = j3;
                        return Boolean.valueOf(refreshResult.changed);
                    }
                }
            }
            return obj;
        }
        if (i2 == 1) {
            String str8 = remotePlayerConfigStore$forceRefresh$3.L$1;
            String str9 = remotePlayerConfigStore$forceRefresh$3.L$0;
            ResultKt.throwOnFailure(objRefresh);
            strConfiguredUrl = str8;
            str7 = str9;
            objIsKnownHash = objRefresh;
        } else {
            if (i2 == 2) {
                String str10 = remotePlayerConfigStore$forceRefresh$3.L$1;
                str3 = remotePlayerConfigStore$forceRefresh$3.L$0;
                ResultKt.throwOnFailure(objRefresh);
                str2 = str10;
                l = (Long) objRefresh;
                if (l == null) {
                    return Boolean.FALSE;
                }
                jLongValue = l.longValue();
                if (str3 != null) {
                    z = true;
                } else {
                    z = false;
                }
                try {
                    remotePlayerConfigStore$forceRefresh$3.L$0 = null;
                    remotePlayerConfigStore$forceRefresh$3.L$1 = str2;
                    remotePlayerConfigStore$forceRefresh$3.J$0 = jLongValue;
                    remotePlayerConfigStore$forceRefresh$3.label = 3;
                    objRefresh = refresh(str2, true, z, remotePlayerConfigStore$forceRefresh$3);
                    if (objRefresh != obj) {
                        str5 = str2;
                        j2 = jLongValue;
                        refreshResult = (RefreshResult) objRefresh;
                        if (!refreshResult.requestAttempted) {
                            remotePlayerConfigStore$forceRefresh$3.L$0 = null;
                            remotePlayerConfigStore$forceRefresh$3.L$1 = str5;
                            remotePlayerConfigStore$forceRefresh$3.L$2 = refreshResult;
                            remotePlayerConfigStore$forceRefresh$3.J$0 = j2;
                            remotePlayerConfigStore$forceRefresh$3.label = 4;
                        }
                        long j4 = j2;
                        str6 = str5;
                        j = j4;
                        return Boolean.valueOf(refreshResult.changed);
                    }
                } catch (CancellationException e) {
                    cancellationException = e;
                    str4 = str2;
                    j = jLongValue;
                    nonCancellable = NonCancellable.INSTANCE;
                    remotePlayerConfigStore$forceRefresh$2 = new RemotePlayerConfigStore$forceRefresh$2(this, str4, j, null, (byte) 0);
                    remotePlayerConfigStore$forceRefresh$3.L$0 = null;
                    remotePlayerConfigStore$forceRefresh$3.L$1 = null;
                    remotePlayerConfigStore$forceRefresh$3.L$2 = cancellationException;
                    remotePlayerConfigStore$forceRefresh$3.J$0 = j;
                    remotePlayerConfigStore$forceRefresh$3.label = 5;
                    if (AwaitKt.withContext(nonCancellable, remotePlayerConfigStore$forceRefresh$2, remotePlayerConfigStore$forceRefresh$3) != obj) {
                        throw cancellationException;
                    }
                }
                return obj;
            }
            if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    CancellationException cancellationException2 = (CancellationException) remotePlayerConfigStore$forceRefresh$3.L$2;
                    ResultKt.throwOnFailure(objRefresh);
                    throw cancellationException2;
                }
                j = remotePlayerConfigStore$forceRefresh$3.J$0;
                refreshResult = (RefreshResult) remotePlayerConfigStore$forceRefresh$3.L$2;
                str6 = remotePlayerConfigStore$forceRefresh$3.L$1;
                try {
                    ResultKt.throwOnFailure(objRefresh);
                    return Boolean.valueOf(refreshResult.changed);
                } catch (CancellationException e2) {
                    cancellationException = e2;
                    str4 = str6;
                    nonCancellable = NonCancellable.INSTANCE;
                    remotePlayerConfigStore$forceRefresh$2 = new RemotePlayerConfigStore$forceRefresh$2(this, str4, j, null, (byte) 0);
                    remotePlayerConfigStore$forceRefresh$3.L$0 = null;
                    remotePlayerConfigStore$forceRefresh$3.L$1 = null;
                    remotePlayerConfigStore$forceRefresh$3.L$2 = cancellationException;
                    remotePlayerConfigStore$forceRefresh$3.J$0 = j;
                    remotePlayerConfigStore$forceRefresh$3.label = 5;
                    if (AwaitKt.withContext(nonCancellable, remotePlayerConfigStore$forceRefresh$2, remotePlayerConfigStore$forceRefresh$3) != obj) {
                        throw cancellationException;
                    }
                    return obj;
                }
            }
            j2 = remotePlayerConfigStore$forceRefresh$3.J$0;
            str5 = remotePlayerConfigStore$forceRefresh$3.L$1;
            try {
                ResultKt.throwOnFailure(objRefresh);
                refreshResult = (RefreshResult) objRefresh;
                if (!refreshResult.requestAttempted) {
                    remotePlayerConfigStore$forceRefresh$3.L$0 = null;
                    remotePlayerConfigStore$forceRefresh$3.L$1 = str5;
                    remotePlayerConfigStore$forceRefresh$3.L$2 = refreshResult;
                    remotePlayerConfigStore$forceRefresh$3.J$0 = j2;
                    remotePlayerConfigStore$forceRefresh$3.label = 4;
                }
                long j5 = j2;
                str6 = str5;
                j = j5;
                return Boolean.valueOf(refreshResult.changed);
            } catch (CancellationException e3) {
                cancellationException = e3;
                str4 = str5;
                j = j2;
                nonCancellable = NonCancellable.INSTANCE;
                remotePlayerConfigStore$forceRefresh$2 = new RemotePlayerConfigStore$forceRefresh$2(this, str4, j, null, (byte) 0);
                remotePlayerConfigStore$forceRefresh$3.L$0 = null;
                remotePlayerConfigStore$forceRefresh$3.L$1 = null;
                remotePlayerConfigStore$forceRefresh$3.L$2 = cancellationException;
                remotePlayerConfigStore$forceRefresh$3.J$0 = j;
                remotePlayerConfigStore$forceRefresh$3.label = 5;
                if (AwaitKt.withContext(nonCancellable, remotePlayerConfigStore$forceRefresh$2, remotePlayerConfigStore$forceRefresh$3) != obj) {
                    throw cancellationException;
                }
            }
        }
        if (((Boolean) objIsKnownHash).booleanValue()) {
            return Boolean.FALSE;
        }
        remotePlayerConfigStore$forceRefresh$3.L$0 = str7;
        remotePlayerConfigStore$forceRefresh$3.L$1 = strConfiguredUrl;
        remotePlayerConfigStore$forceRefresh$3.label = 2;
        objReserveUnknownHashRefresh = reserveUnknownHashRefresh(strConfiguredUrl, remotePlayerConfigStore$forceRefresh$3);
        if (objReserveUnknownHashRefresh != obj) {
            str2 = strConfiguredUrl;
            objRefresh = objReserveUnknownHashRefresh;
            str3 = str7;
            l = (Long) objRefresh;
            if (l == null) {
                return Boolean.FALSE;
            }
            jLongValue = l.longValue();
            if (str3 != null) {
                z = true;
            } else {
                z = false;
            }
            remotePlayerConfigStore$forceRefresh$3.L$0 = null;
            remotePlayerConfigStore$forceRefresh$3.L$1 = str2;
            remotePlayerConfigStore$forceRefresh$3.J$0 = jLongValue;
            remotePlayerConfigStore$forceRefresh$3.label = 3;
            objRefresh = refresh(str2, true, z, remotePlayerConfigStore$forceRefresh$3);
            if (objRefresh != obj) {
                str5 = str2;
                j2 = jLongValue;
                refreshResult = (RefreshResult) objRefresh;
                if (!refreshResult.requestAttempted) {
                    remotePlayerConfigStore$forceRefresh$3.L$0 = null;
                    remotePlayerConfigStore$forceRefresh$3.L$1 = str5;
                    remotePlayerConfigStore$forceRefresh$3.L$2 = refreshResult;
                    remotePlayerConfigStore$forceRefresh$3.J$0 = j2;
                    remotePlayerConfigStore$forceRefresh$3.label = 4;
                }
                long j6 = j2;
                str6 = str5;
                j = j6;
                return Boolean.valueOf(refreshResult.changed);
            }
        }
        return obj;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getConfig$com_github_MetrolistGroup_innertubex(String str, ContinuationImpl continuationImpl) {
        RemotePlayerConfigStore$getConfig$1 remotePlayerConfigStore$getConfig$1;
        String strConfiguredUrl;
        String str2;
        String str3;
        if (continuationImpl instanceof RemotePlayerConfigStore$getConfig$1) {
            remotePlayerConfigStore$getConfig$1 = (RemotePlayerConfigStore$getConfig$1) continuationImpl;
            int i = remotePlayerConfigStore$getConfig$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                remotePlayerConfigStore$getConfig$1.label = i - Integer.MIN_VALUE;
            } else {
                remotePlayerConfigStore$getConfig$1 = new RemotePlayerConfigStore$getConfig$1(this, continuationImpl);
            }
        } else {
            remotePlayerConfigStore$getConfig$1 = new RemotePlayerConfigStore$getConfig$1(this, continuationImpl);
        }
        Object obj = remotePlayerConfigStore$getConfig$1.result;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = remotePlayerConfigStore$getConfig$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            this.repository.getClass();
            String strExtractPlayerHash = RemotePlayerConfigParser.extractPlayerHash(str);
            if (strExtractPlayerHash != null && (strConfiguredUrl = configuredUrl()) != null) {
                remotePlayerConfigStore$getConfig$1.L$1 = strExtractPlayerHash;
                remotePlayerConfigStore$getConfig$1.L$2 = strConfiguredUrl;
                remotePlayerConfigStore$getConfig$1.label = 1;
                if (refreshIfStale$com_github_MetrolistGroup_innertubex(remotePlayerConfigStore$getConfig$1) == obj2) {
                    return obj2;
                }
                str2 = strExtractPlayerHash;
                str3 = strConfiguredUrl;
            }
            return null;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        str3 = remotePlayerConfigStore$getConfig$1.L$2;
        str2 = remotePlayerConfigStore$getConfig$1.L$1;
        ResultKt.throwOnFailure(obj);
        Map map = this.configs;
        if (!Intrinsics.areEqual(this.configSourceUrl, str3)) {
            map = null;
        }
        if (map != null) {
            return (RemotePlayerConfigParser.HardcodedPlayerConfig) map.get(str2);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:115:0x01b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x00be  */
    /* JADX WARN: Code duplicated, block: B:65:0x0142 A[Catch: Exception -> 0x0147, CancellationException -> 0x01c5, TRY_LEAVE, TryCatch #2 {Exception -> 0x0147, blocks: (B:63:0x013c, B:65:0x0142), top: B:105:0x013c }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0149  */
    /* JADX WARN: Code duplicated, block: B:77:0x015c  */
    /* JADX WARN: Code duplicated, block: B:82:0x0194  */
    /* JADX WARN: Code duplicated, block: B:86:0x01a5 A[Catch: all -> 0x01bb, TryCatch #4 {all -> 0x01bb, blocks: (B:83:0x0195, B:84:0x019d, B:86:0x01a5, B:89:0x01b7), top: B:109:0x0195 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x01b7 A[Catch: all -> 0x01bb, TRY_LEAVE, TryCatch #4 {all -> 0x01bb, blocks: (B:83:0x0195, B:84:0x019d, B:86:0x01a5, B:89:0x01b7), top: B:109:0x0195 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object getLegacySignatureTimestamp(String str, ContinuationImpl continuationImpl) throws IOException {
        AnonymousClass1 anonymousClass1;
        String strReplace;
        String str2;
        long j;
        Mutex mutex;
        String str3;
        long j2;
        String str4;
        String str5;
        long j3;
        String str6;
        HttpClient httpClient;
        Url Url;
        YouTube$$ExternalSyntheticLambda2 youTube$$ExternalSyntheticLambda2;
        String strM;
        long j4;
        Integer num;
        MutexImpl mutexImpl;
        MutexImpl mutexImpl2;
        String str7;
        Integer legacySignatureTimestamp$com_github_MetrolistGroup_innertubex;
        String str8;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object textWithoutRedirects = anonymousClass2.result;
        int i2 = anonymousClass2.label;
        MutexImpl mutexImpl3 = this.mutex;
        LinkedHashMap linkedHashMap = this.legacyTimestampCache;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                try {
                    try {
                        if (i2 == 0) {
                            ResultKt.throwOnFailure(textWithoutRedirects);
                            this.repository.getClass();
                            String strExtractPlayerHash = RemotePlayerConfigParser.extractPlayerHash(str);
                            if (strExtractPlayerHash != null) {
                                String string = StringsKt.trim("https://raw.githubusercontent.com/ZemerTeam/zemer-cipher/master/library/src/main/assets/player_configs.json").toString();
                                if (StringsKt.isBlank(string) || string.equals("https://github.com/MetrolistGroup/faraday/releases/download/{playerTag}/{playerHash}.json") || StringsKt__StringsJVMKt.endsWith(StringsKt.substringBefore$default(string, '?'), "/player_configs.json", false)) {
                                    strReplace = null;
                                } else {
                                    strReplace = StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(string, "{playerHash}", strExtractPlayerHash, false), "{playerTag}", "player-".concat(strExtractPlayerHash), false);
                                    if (validatedSourceUrlOrNull$com_github_MetrolistGroup_innertubex(strReplace) == null) {
                                        strReplace = null;
                                    }
                                }
                                if (strReplace != null) {
                                    long jLongValue = ((Number) this.nowMs.invoke()).longValue();
                                    anonymousClass2.L$1 = strExtractPlayerHash;
                                    anonymousClass2.L$2 = strReplace;
                                    anonymousClass2.L$3 = mutexImpl3;
                                    anonymousClass2.J$0 = jLongValue;
                                    anonymousClass2.label = 1;
                                    if (mutexImpl3.lock(anonymousClass2) != coroutineSingletons) {
                                        str2 = strReplace;
                                        j = jLongValue;
                                        mutex = mutexImpl3;
                                        str3 = strExtractPlayerHash;
                                    }
                                    return coroutineSingletons;
                                }
                            }
                            return null;
                        }
                        if (i2 == 1) {
                            j = anonymousClass2.J$0;
                            mutex = (Mutex) anonymousClass2.L$3;
                            String str9 = anonymousClass2.L$2;
                            String str10 = anonymousClass2.L$1;
                            ResultKt.throwOnFailure(textWithoutRedirects);
                            str2 = str9;
                            str3 = str10;
                        } else {
                            if (i2 == 2) {
                                j3 = anonymousClass2.J$0;
                                str6 = anonymousClass2.L$2;
                                str5 = anonymousClass2.L$1;
                                try {
                                    ResultKt.throwOnFailure(textWithoutRedirects);
                                    mutexImpl3 = mutexImpl3;
                                    try {
                                        str7 = ((RestrictedTextResponse) textWithoutRedirects).body;
                                        if (str7 != null) {
                                            legacySignatureTimestamp$com_github_MetrolistGroup_innertubex = RemotePlayerConfigParser.parseLegacySignatureTimestamp$com_github_MetrolistGroup_innertubex(str7, str5);
                                        } else {
                                            legacySignatureTimestamp$com_github_MetrolistGroup_innertubex = null;
                                        }
                                        j4 = j3;
                                        num = legacySignatureTimestamp$com_github_MetrolistGroup_innertubex;
                                    } catch (Exception e) {
                                        e = e;
                                        strM = Format$$ExternalSyntheticOutline0.m(e);
                                        if (strM == null) {
                                            strM = "Exception";
                                        }
                                        EntryPoints.d$default(this.logger, "RemotePlayerConfigStore", "Legacy player config timestamp unavailable hash=" + str5 + " type=" + strM, null, 12);
                                        j4 = j3;
                                        num = null;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    mutexImpl3 = mutexImpl3;
                                    strM = Format$$ExternalSyntheticOutline0.m(e);
                                    if (strM == null) {
                                        strM = "Exception";
                                    }
                                    EntryPoints.d$default(this.logger, "RemotePlayerConfigStore", "Legacy player config timestamp unavailable hash=" + str5 + " type=" + strM, null, 12);
                                    j4 = j3;
                                    num = null;
                                    anonymousClass2.L$1 = null;
                                    anonymousClass2.L$2 = str6;
                                    anonymousClass2.L$3 = num;
                                    mutexImpl = mutexImpl3;
                                    anonymousClass2.L$4 = mutexImpl;
                                    anonymousClass2.J$0 = j4;
                                    anonymousClass2.label = 3;
                                    if (mutexImpl.lock(anonymousClass2) != coroutineSingletons) {
                                        mutexImpl2 = mutexImpl;
                                        linkedHashMap.put(str6, new CachedLegacyTimestamp(num, j4));
                                        while (linkedHashMap.size() > 16) {
                                            Set setKeySet = linkedHashMap.keySet();
                                            setKeySet.getClass();
                                            str8 = (String) CollectionsKt.firstOrNull(setKeySet);
                                            if (str8 == null) {
                                                break;
                                            }
                                            linkedHashMap.remove(str8);
                                        }
                                        mutexImpl2.unlock(null);
                                        return num;
                                    }
                                    return coroutineSingletons;
                                }
                                anonymousClass2.L$1 = null;
                                anonymousClass2.L$2 = str6;
                                anonymousClass2.L$3 = num;
                                mutexImpl = mutexImpl3;
                                anonymousClass2.L$4 = mutexImpl;
                                anonymousClass2.J$0 = j4;
                                anonymousClass2.label = 3;
                                if (mutexImpl.lock(anonymousClass2) != coroutineSingletons) {
                                    mutexImpl2 = mutexImpl;
                                }
                                return coroutineSingletons;
                            }
                            if (i2 != 3) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            j4 = anonymousClass2.J$0;
                            mutexImpl2 = anonymousClass2.L$4;
                            num = (Integer) anonymousClass2.L$3;
                            str6 = anonymousClass2.L$2;
                            ResultKt.throwOnFailure(textWithoutRedirects);
                        }
                        try {
                            linkedHashMap.put(str6, new CachedLegacyTimestamp(num, j4));
                            while (linkedHashMap.size() > 16) {
                                Set setKeySet2 = linkedHashMap.keySet();
                                setKeySet2.getClass();
                                str8 = (String) CollectionsKt.firstOrNull(setKeySet2);
                                if (str8 == null) {
                                    break;
                                    break;
                                }
                                linkedHashMap.remove(str8);
                            }
                            mutexImpl2.unlock(null);
                            return num;
                        } catch (Throwable th) {
                            mutexImpl2.unlock(null);
                            throw th;
                        }
                        textWithoutRedirects = RegexKt.getTextWithoutRedirects(httpClient, Url, 4194304, null, youTube$$ExternalSyntheticLambda2, anonymousClass2);
                        if (textWithoutRedirects != coroutineSingletons) {
                            str5 = str4;
                            j3 = j2;
                            str6 = str2;
                            str7 = ((RestrictedTextResponse) textWithoutRedirects).body;
                            if (str7 != null) {
                                legacySignatureTimestamp$com_github_MetrolistGroup_innertubex = RemotePlayerConfigParser.parseLegacySignatureTimestamp$com_github_MetrolistGroup_innertubex(str7, str5);
                            } else {
                                legacySignatureTimestamp$com_github_MetrolistGroup_innertubex = null;
                            }
                            j4 = j3;
                            num = legacySignatureTimestamp$com_github_MetrolistGroup_innertubex;
                            anonymousClass2.L$1 = null;
                            anonymousClass2.L$2 = str6;
                            anonymousClass2.L$3 = num;
                            mutexImpl = mutexImpl3;
                            anonymousClass2.L$4 = mutexImpl;
                            anonymousClass2.J$0 = j4;
                            anonymousClass2.label = 3;
                            if (mutexImpl.lock(anonymousClass2) != coroutineSingletons) {
                                mutexImpl2 = mutexImpl;
                                linkedHashMap.put(str6, new CachedLegacyTimestamp(num, j4));
                                while (linkedHashMap.size() > 16) {
                                    Set setKeySet3 = linkedHashMap.keySet();
                                    setKeySet3.getClass();
                                    str8 = (String) CollectionsKt.firstOrNull(setKeySet3);
                                    if (str8 == null) {
                                        break;
                                        break;
                                    }
                                    linkedHashMap.remove(str8);
                                }
                                mutexImpl2.unlock(null);
                                return num;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str5 = str4;
                        j3 = j2;
                        str6 = str2;
                        strM = Format$$ExternalSyntheticOutline0.m(e);
                        if (strM == null) {
                            strM = "Exception";
                        }
                        EntryPoints.d$default(this.logger, "RemotePlayerConfigStore", "Legacy player config timestamp unavailable hash=" + str5 + " type=" + strM, null, 12);
                        j4 = j3;
                        num = null;
                        anonymousClass2.L$1 = null;
                        anonymousClass2.L$2 = str6;
                        anonymousClass2.L$3 = num;
                        mutexImpl = mutexImpl3;
                        anonymousClass2.L$4 = mutexImpl;
                        anonymousClass2.J$0 = j4;
                        anonymousClass2.label = 3;
                        if (mutexImpl.lock(anonymousClass2) != coroutineSingletons) {
                            mutexImpl2 = mutexImpl;
                            linkedHashMap.put(str6, new CachedLegacyTimestamp(num, j4));
                            while (linkedHashMap.size() > 16) {
                                Set setKeySet4 = linkedHashMap.keySet();
                                setKeySet4.getClass();
                                str8 = (String) CollectionsKt.firstOrNull(setKeySet4);
                                if (str8 == null) {
                                    break;
                                    break;
                                }
                                linkedHashMap.remove(str8);
                            }
                            mutexImpl2.unlock(null);
                            return num;
                        }
                        return coroutineSingletons;
                    }
                    httpClient = this.httpClient;
                    Url = URLUtilsKt.Url(str2);
                    youTube$$ExternalSyntheticLambda2 = new YouTube$$ExternalSyntheticLambda2((byte) 16);
                    anonymousClass2.L$1 = str3;
                    anonymousClass2.L$2 = str2;
                    anonymousClass2.L$3 = null;
                    anonymousClass2.J$0 = j;
                    anonymousClass2.label = 2;
                    long j5 = j;
                    str4 = str3;
                    j2 = j5;
                } catch (Exception e4) {
                    e = e4;
                    j2 = j;
                    str4 = str3;
                }
                CachedLegacyTimestamp cachedLegacyTimestamp = (CachedLegacyTimestamp) linkedHashMap.remove(str2);
                if (cachedLegacyTimestamp != null) {
                    if (j - cachedLegacyTimestamp.fetchedAtMs >= 21600000) {
                        cachedLegacyTimestamp = null;
                    }
                    if (cachedLegacyTimestamp != null) {
                        linkedHashMap.put(str2, cachedLegacyTimestamp);
                        Integer num2 = cachedLegacyTimestamp.value;
                        mutex.unlock(null);
                        return num2;
                    }
                }
                mutex.unlock(null);
                return coroutineSingletons;
            } catch (Throwable th2) {
                mutex.unlock(null);
                throw th2;
            }
        } catch (CancellationException e5) {
            throw e5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getSignatureTimestamp(String str, ContinuationImpl continuationImpl) throws IOException {
        C00991 c00991;
        if (continuationImpl instanceof C00991) {
            c00991 = (C00991) continuationImpl;
            int i = c00991.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00991.label = i - Integer.MIN_VALUE;
            } else {
                c00991 = new C00991(continuationImpl);
            }
        } else {
            c00991 = new C00991(continuationImpl);
        }
        Object config$com_github_MetrolistGroup_innertubex = c00991.result;
        int i2 = c00991.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(config$com_github_MetrolistGroup_innertubex);
            c00991.L$0 = str;
            c00991.label = 1;
            config$com_github_MetrolistGroup_innertubex = getConfig$com_github_MetrolistGroup_innertubex(str, c00991);
            if (config$com_github_MetrolistGroup_innertubex != obj) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(config$com_github_MetrolistGroup_innertubex);
                return config$com_github_MetrolistGroup_innertubex;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        str = c00991.L$0;
        ResultKt.throwOnFailure(config$com_github_MetrolistGroup_innertubex);
        RemotePlayerConfigParser.HardcodedPlayerConfig hardcodedPlayerConfig = (RemotePlayerConfigParser.HardcodedPlayerConfig) config$com_github_MetrolistGroup_innertubex;
        if (hardcodedPlayerConfig != null) {
            return new Integer(hardcodedPlayerConfig.signatureTimestamp);
        }
        c00991.L$0 = null;
        c00991.label = 2;
        Object legacySignatureTimestamp = getLegacySignatureTimestamp(str, c00991);
        return legacySignatureTimestamp == obj ? obj : legacySignatureTimestamp;
    }

    public final boolean hasFreshCache(long j, String str) {
        InnerTubeXPlayer.AndroidPlayerConfigRepository androidPlayerConfigRepository = this.repository;
        SharedPreferences sharedPreferences = androidPlayerConfigRepository.preferences;
        SharedPreferences sharedPreferences2 = androidPlayerConfigRepository.preferences;
        String string = sharedPreferences.getString("json", "");
        if (string == null) {
            string = "";
        }
        if (StringsKt.isBlank(string)) {
            return false;
        }
        String string2 = sharedPreferences2.getString("source_url", "");
        return (string2 != null ? string2 : "").equals(str) && j - sharedPreferences2.getLong("cached_at_ms", 0L) < 21600000;
    }

    public final boolean hasRecentRefreshAttempt(long j, String str) {
        if (!Intrinsics.areEqual(this.lastRefreshAttemptSourceUrl, str)) {
            return false;
        }
        long j2 = j - this.lastRefreshAttemptAtMs;
        return 0 <= j2 && j2 < 60000;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object isKnownHash(String str, String str2, ContinuationImpl continuationImpl) {
        C01001 c01001;
        String str3;
        MutexImpl mutexImpl;
        if (continuationImpl instanceof C01001) {
            c01001 = (C01001) continuationImpl;
            int i = c01001.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01001.label = i - Integer.MIN_VALUE;
            } else {
                c01001 = new C01001(continuationImpl);
            }
        } else {
            c01001 = new C01001(continuationImpl);
        }
        Object obj = c01001.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = c01001.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            MutexImpl mutexImpl2 = this.mutex;
            c01001.L$0 = str;
            c01001.L$1 = str2;
            c01001.L$2 = mutexImpl2;
            c01001.label = 1;
            if (mutexImpl2.lock(c01001) == coroutineSingletons) {
                return coroutineSingletons;
            }
            str3 = str;
            mutexImpl = mutexImpl2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            mutexImpl = c01001.L$2;
            str2 = c01001.L$1;
            str3 = c01001.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            ensureLoadedFromCache(str2);
            mutexImpl.unlock(null);
            Map map = Intrinsics.areEqual(this.configSourceUrl, str2) ? this.configs : null;
            return Boolean.valueOf(map != null && map.containsKey(str3));
        } catch (Throwable th) {
            mutexImpl.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:164:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:170:0x0301  */
    /* JADX WARN: Code duplicated, block: B:173:0x030d A[Catch: all -> 0x0317, TryCatch #24 {all -> 0x0317, blocks: (B:171:0x0303, B:173:0x030d, B:179:0x031e, B:180:0x0328, B:183:0x033c, B:185:0x0359, B:188:0x0360, B:189:0x0372, B:194:0x0392, B:196:0x0396, B:197:0x039e, B:207:0x03b4, B:208:0x03cf, B:209:0x03d4, B:210:0x03d5, B:212:0x0424, B:213:0x0436, B:200:0x03a8, B:214:0x046e), top: B:258:0x0303, outer: #9 }] */
    /* JADX WARN: Code duplicated, block: B:177:0x031b  */
    /* JADX WARN: Code duplicated, block: B:179:0x031e A[Catch: all -> 0x0317, TryCatch #24 {all -> 0x0317, blocks: (B:171:0x0303, B:173:0x030d, B:179:0x031e, B:180:0x0328, B:183:0x033c, B:185:0x0359, B:188:0x0360, B:189:0x0372, B:194:0x0392, B:196:0x0396, B:197:0x039e, B:207:0x03b4, B:208:0x03cf, B:209:0x03d4, B:210:0x03d5, B:212:0x0424, B:213:0x0436, B:200:0x03a8, B:214:0x046e), top: B:258:0x0303, outer: #9 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x0328 A[Catch: all -> 0x0317, TRY_LEAVE, TryCatch #24 {all -> 0x0317, blocks: (B:171:0x0303, B:173:0x030d, B:179:0x031e, B:180:0x0328, B:183:0x033c, B:185:0x0359, B:188:0x0360, B:189:0x0372, B:194:0x0392, B:196:0x0396, B:197:0x039e, B:207:0x03b4, B:208:0x03cf, B:209:0x03d4, B:210:0x03d5, B:212:0x0424, B:213:0x0436, B:200:0x03a8, B:214:0x046e), top: B:258:0x0303, outer: #9 }] */
    /* JADX WARN: Code duplicated, block: B:183:0x033c A[Catch: all -> 0x0317, TRY_ENTER, TryCatch #24 {all -> 0x0317, blocks: (B:171:0x0303, B:173:0x030d, B:179:0x031e, B:180:0x0328, B:183:0x033c, B:185:0x0359, B:188:0x0360, B:189:0x0372, B:194:0x0392, B:196:0x0396, B:197:0x039e, B:207:0x03b4, B:208:0x03cf, B:209:0x03d4, B:210:0x03d5, B:212:0x0424, B:213:0x0436, B:200:0x03a8, B:214:0x046e), top: B:258:0x0303, outer: #9 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x0359 A[Catch: all -> 0x0317, TryCatch #24 {all -> 0x0317, blocks: (B:171:0x0303, B:173:0x030d, B:179:0x031e, B:180:0x0328, B:183:0x033c, B:185:0x0359, B:188:0x0360, B:189:0x0372, B:194:0x0392, B:196:0x0396, B:197:0x039e, B:207:0x03b4, B:208:0x03cf, B:209:0x03d4, B:210:0x03d5, B:212:0x0424, B:213:0x0436, B:200:0x03a8, B:214:0x046e), top: B:258:0x0303, outer: #9 }] */
    /* JADX WARN: Code duplicated, block: B:190:0x0388  */
    /* JADX WARN: Code duplicated, block: B:192:0x038e  */
    /* JADX WARN: Code duplicated, block: B:8:0x0022  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v134 */
    /* JADX WARN: Type inference failed for: r0v78 */
    /* JADX WARN: Type inference failed for: r0v80, types: [com.metrolist.innertubex.cipher.RestrictedTextResponse] */
    /* JADX WARN: Type inference failed for: r12v16, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23, types: [com.metrolist.innertubex.cipher.RestrictedTextResponse] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v7, types: [kotlinx.coroutines.sync.Mutex] */
    public final Object refresh(String str, boolean z, boolean z2, ContinuationImpl continuationImpl) throws Throwable {
        C01011 c01011;
        Map map;
        ?? r7;
        String str2;
        boolean z3;
        boolean z4;
        Mutex mutex;
        Mutex mutex2;
        Mutex mutex3;
        Mutex mutex4;
        MutexImpl mutexImpl;
        String str3;
        String str4;
        MutexImpl mutexImpl2;
        String str5;
        String str6;
        String str7;
        boolean z5;
        String str8;
        boolean z6;
        long j;
        RefreshResult refreshResult;
        Object obj;
        Mutex mutex5;
        Object obj2;
        Object obj3;
        String simpleName;
        ?? r0;
        Mutex mutex6;
        String str9;
        MutexImpl mutexImpl3;
        ?? r2;
        ?? r12;
        int value;
        String str10;
        String str11;
        byte b;
        String str12 = "";
        if (continuationImpl instanceof C01011) {
            c01011 = (C01011) continuationImpl;
            int i = c01011.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01011.label = i - Integer.MIN_VALUE;
            } else {
                c01011 = new C01011(continuationImpl);
            }
        } else {
            c01011 = new C01011(continuationImpl);
        }
        C01011 c01012 = c01011;
        Object textWithoutRedirects = c01012.result;
        Object obj4 = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = c01012.label;
        String str13 = "RemotePlayerConfigStore";
        try {
            try {
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(textWithoutRedirects);
                        MutexImpl mutexImpl4 = this.refreshMutex;
                        str2 = str;
                        c01012.L$0 = str2;
                        c01012.L$1 = mutexImpl4;
                        z3 = z;
                        c01012.Z$0 = z3;
                        z4 = z2;
                        c01012.Z$1 = z4;
                        c01012.label = 1;
                        if (mutexImpl4.lock(c01012) != obj4) {
                            mutex = mutexImpl4;
                        }
                        return obj4;
                    }
                    if (i2 != 1) {
                        if (i2 == 2) {
                            mutexImpl = c01012.L$2;
                            Mutex mutex7 = c01012.L$1;
                            str3 = c01012.L$0;
                            ResultKt.throwOnFailure(textWithoutRedirects);
                            obj4 = mutex7;
                            try {
                                ensureLoadedFromCache(str3);
                                mutexImpl.unlock(null);
                                refreshResult = new RefreshResult(false, false);
                                obj3 = obj4;
                                obj = obj3;
                                obj2 = null;
                                r12 = obj;
                                r12.unlock(obj2);
                                return refreshResult;
                            } catch (Throwable th) {
                                mutexImpl.unlock(null);
                                throw th;
                            }
                        }
                        if (i2 == 3) {
                            mutexImpl2 = c01012.L$2;
                            Mutex mutex8 = c01012.L$1;
                            str5 = c01012.L$0;
                            ResultKt.throwOnFailure(textWithoutRedirects);
                            obj4 = mutex8;
                            try {
                                ensureLoadedFromCache(str5);
                                mutexImpl2.unlock(null);
                                refreshResult = new RefreshResult(false, false);
                                obj3 = obj4;
                                obj = obj3;
                                obj2 = null;
                                r12 = obj;
                                r12.unlock(obj2);
                                return refreshResult;
                            } catch (Throwable th2) {
                                mutexImpl2.unlock(null);
                                throw th2;
                            }
                        }
                        if (i2 != 4) {
                            if (i2 != 5) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            RestrictedTextResponse restrictedTextResponse = c01012.L$4;
                            mutexImpl3 = c01012.L$3;
                            Mutex mutex9 = c01012.L$1;
                            str9 = c01012.L$0;
                            try {
                                ResultKt.throwOnFailure(textWithoutRedirects);
                                str7 = "Remote player configs applied (";
                                str4 = "Remote player configs HTTP ";
                                r2 = restrictedTextResponse;
                                obj4 = mutex9;
                                try {
                                    if (!Intrinsics.areEqual(configuredUrl(), str9)) {
                                        refreshResult = new RefreshResult(false, true);
                                    } else if (r2 == 0) {
                                        ensureLoadedFromCache(str9);
                                        refreshResult = new RefreshResult(false, true);
                                    } else {
                                        value = r2.status.getValue();
                                        str10 = r2.headers.get(HttpHeaders.ETag);
                                        if (value == 304) {
                                            str11 = str13;
                                            if (200 <= value || value >= 300) {
                                                obj2 = null;
                                                EntryPoints.w$default(this.logger, str11, str4 + value, null, 12);
                                                ensureLoadedFromCache(str9);
                                                refreshResult = new RefreshResult(false, true);
                                            } else {
                                                String str14 = r2.body;
                                                if (str14 == null) {
                                                    refreshResult = new RefreshResult(false, true);
                                                } else {
                                                    HexFormatKt hexFormatKt = RemotePlayerConfigParser.parse(str14);
                                                    if (hexFormatKt instanceof RemotePlayerConfigParser$ParseResult$Success) {
                                                        b = 0;
                                                    } else {
                                                        b = hexFormatKt instanceof RemotePlayerConfigParser$ParseResult$Failure ? (byte) 1 : (byte) -2;
                                                    }
                                                    if (b == 0) {
                                                        boolean zApplyConfigs = applyConfigs(str9, ((RemotePlayerConfigParser$ParseResult$Success) hexFormatKt).configs);
                                                        InnerTubeXPlayer.AndroidPlayerConfigRepository androidPlayerConfigRepository = this.repository;
                                                        androidPlayerConfigRepository.getClass();
                                                        androidPlayerConfigRepository.preferences.edit().putString("json", str14).apply();
                                                        this.repository.preferences.edit().putLong("cached_at_ms", ((Number) this.nowMs.invoke()).longValue()).apply();
                                                        InnerTubeXPlayer.AndroidPlayerConfigRepository androidPlayerConfigRepository2 = this.repository;
                                                        androidPlayerConfigRepository2.getClass();
                                                        str9.getClass();
                                                        androidPlayerConfigRepository2.preferences.edit().putString("source_url", str9).apply();
                                                        if (str10 != null) {
                                                            InnerTubeXPlayer.AndroidPlayerConfigRepository androidPlayerConfigRepository3 = this.repository;
                                                            androidPlayerConfigRepository3.getClass();
                                                            androidPlayerConfigRepository3.preferences.edit().putString("etag", str10).apply();
                                                        }
                                                        EntryPoints.d$default(this.logger, str11, str7 + ((RemotePlayerConfigParser$ParseResult$Success) hexFormatKt).configs.size() + " entries) changed=" + zApplyConfigs + " epoch=" + this.configEpoch, null, 12);
                                                        refreshResult = new RefreshResult(zApplyConfigs, true);
                                                    } else {
                                                        if (b != 1) {
                                                            throw new HttpException();
                                                        }
                                                        EntryPoints.w$default(this.logger, str11, "Remote player configs rejected: ".concat(((RemotePlayerConfigParser$ParseResult$Failure) hexFormatKt).reason), null, 12);
                                                        ensureLoadedFromCache(str9);
                                                        refreshResult = new RefreshResult(false, true);
                                                    }
                                                }
                                            }
                                            mutexImpl3.unlock(obj2);
                                            r12 = obj4;
                                            r12.unlock(obj2);
                                            return refreshResult;
                                        }
                                        this.repository.preferences.edit().putLong("cached_at_ms", ((Number) this.nowMs.invoke()).longValue()).apply();
                                        if (str10 != null && !StringsKt.isBlank(str10)) {
                                            InnerTubeXPlayer.AndroidPlayerConfigRepository androidPlayerConfigRepository4 = this.repository;
                                            androidPlayerConfigRepository4.getClass();
                                            androidPlayerConfigRepository4.preferences.edit().putString("etag", str10).apply();
                                        }
                                        ensureLoadedFromCache(str9);
                                        EntryPoints.d$default(this.logger, str13, "Remote player configs unchanged (304)", null, 12);
                                        refreshResult = new RefreshResult(false, true);
                                    }
                                    obj2 = null;
                                    mutexImpl3.unlock(obj2);
                                    r12 = obj4;
                                    r12.unlock(obj2);
                                    return refreshResult;
                                } catch (Throwable th3) {
                                    mutexImpl3.unlock(null);
                                    throw th3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                map = null;
                                r7 = mutex9;
                                r7.unlock(map);
                                throw th;
                            }
                        }
                        j = c01012.J$0;
                        z6 = c01012.Z$1;
                        boolean z7 = c01012.Z$0;
                        mutex5 = c01012.L$1;
                        str8 = c01012.L$0;
                        try {
                            try {
                                ResultKt.throwOnFailure(textWithoutRedirects);
                                z3 = z7;
                                str7 = "Remote player configs applied (";
                                str4 = "Remote player configs HTTP ";
                                str13 = str13;
                                map = null;
                                mutex5 = mutex5;
                                try {
                                    r0 = (RestrictedTextResponse) textWithoutRedirects;
                                    mutex6 = mutex5;
                                } catch (Exception e) {
                                    e = e;
                                    mutex2 = mutex5;
                                    try {
                                        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0 = this.logger;
                                        simpleName = Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName();
                                        if (simpleName == null) {
                                            simpleName = "Exception";
                                        }
                                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, str13, "Remote player config refresh failed (" + simpleName + ")", map, 12);
                                        r0 = map;
                                        mutex6 = mutex2;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        obj4 = mutex2;
                                        map = null;
                                        r7 = obj4;
                                        r7.unlock(map);
                                        throw th;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    r7 = mutex5;
                                    r7.unlock(map);
                                    throw th;
                                }
                            } catch (CancellationException e2) {
                                throw e2;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            z3 = z7;
                            str7 = "Remote player configs applied (";
                            str4 = "Remote player configs HTTP ";
                            mutex2 = mutex5;
                            str13 = str13;
                            map = null;
                        }
                        long j2 = j;
                        str9 = str8;
                        boolean z8 = z3;
                        this.lastRefreshAttemptSourceUrl = str9;
                        str13 = str13;
                        this.lastRefreshAttemptAtMs = ((Number) this.nowMs.invoke()).longValue();
                        mutexImpl3 = this.mutex;
                        c01012.L$0 = str9;
                        c01012.L$1 = mutex6;
                        c01012.L$2 = null;
                        c01012.L$3 = mutexImpl3;
                        c01012.L$4 = r0;
                        c01012.Z$0 = z8;
                        c01012.Z$1 = z6;
                        c01012.J$0 = j2;
                        c01012.label = 5;
                        if (mutexImpl3.lock(c01012) != obj4) {
                            r2 = r0;
                            obj4 = mutex6;
                            if (!Intrinsics.areEqual(configuredUrl(), str9)) {
                                refreshResult = new RefreshResult(false, true);
                            } else if (r2 == 0) {
                                ensureLoadedFromCache(str9);
                                refreshResult = new RefreshResult(false, true);
                            } else {
                                value = r2.status.getValue();
                                str10 = r2.headers.get(HttpHeaders.ETag);
                                if (value == 304) {
                                    str11 = str13;
                                    if (200 <= value) {
                                    }
                                    obj2 = null;
                                    EntryPoints.w$default(this.logger, str11, str4 + value, null, 12);
                                    ensureLoadedFromCache(str9);
                                    refreshResult = new RefreshResult(false, true);
                                    mutexImpl3.unlock(obj2);
                                    r12 = obj4;
                                    r12.unlock(obj2);
                                    return refreshResult;
                                }
                                this.repository.preferences.edit().putLong("cached_at_ms", ((Number) this.nowMs.invoke()).longValue()).apply();
                                if (str10 != null) {
                                    InnerTubeXPlayer.AndroidPlayerConfigRepository androidPlayerConfigRepository5 = this.repository;
                                    androidPlayerConfigRepository5.getClass();
                                    androidPlayerConfigRepository5.preferences.edit().putString("etag", str10).apply();
                                }
                                ensureLoadedFromCache(str9);
                                EntryPoints.d$default(this.logger, str13, "Remote player configs unchanged (304)", null, 12);
                                refreshResult = new RefreshResult(false, true);
                            }
                            obj2 = null;
                            mutexImpl3.unlock(obj2);
                            r12 = obj4;
                            r12.unlock(obj2);
                            return refreshResult;
                        }
                        return obj4;
                    }
                    boolean z9 = c01012.Z$1;
                    boolean z10 = c01012.Z$0;
                    Mutex mutex10 = c01012.L$1;
                    String str15 = c01012.L$0;
                    ResultKt.throwOnFailure(textWithoutRedirects);
                    z4 = z9;
                    str2 = str15;
                    z3 = z10;
                    mutex = mutex10;
                    if (Intrinsics.areEqual(configuredUrl(), str2)) {
                        Mutex mutex11 = mutex;
                        try {
                            long jLongValue = ((Number) this.nowMs.invoke()).longValue();
                            try {
                                try {
                                    try {
                                        try {
                                            if (!z3) {
                                                try {
                                                    if (hasFreshCache(jLongValue, str2)) {
                                                        try {
                                                            mutexImpl = this.mutex;
                                                            c01012.L$0 = str2;
                                                            mutex4 = mutex11;
                                                            try {
                                                                c01012.L$1 = mutex4;
                                                                c01012.L$2 = mutexImpl;
                                                                c01012.L$3 = null;
                                                                c01012.Z$0 = z3;
                                                                c01012.Z$1 = z4;
                                                                c01012.J$0 = jLongValue;
                                                                c01012.label = 2;
                                                                if (mutexImpl.lock(c01012) != obj4) {
                                                                    obj4 = mutex4;
                                                                    str3 = str2;
                                                                    ensureLoadedFromCache(str3);
                                                                    mutexImpl.unlock(null);
                                                                    refreshResult = new RefreshResult(false, false);
                                                                    obj3 = obj4;
                                                                    obj = obj3;
                                                                }
                                                            } catch (Throwable th7) {
                                                                th = th7;
                                                                obj4 = mutex4;
                                                                map = null;
                                                                r7 = obj4;
                                                                r7.unlock(map);
                                                                throw th;
                                                            }
                                                        } catch (Throwable th8) {
                                                            th = th8;
                                                            mutex4 = mutex11;
                                                        }
                                                    }
                                                    return obj4;
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    mutex3 = mutex11;
                                                    obj4 = mutex3;
                                                    map = null;
                                                    r7 = obj4;
                                                    r7.unlock(map);
                                                    throw th;
                                                }
                                            }
                                            if (!z3 || z4) {
                                                try {
                                                    if (hasRecentRefreshAttempt(jLongValue, str2)) {
                                                        mutexImpl2 = this.mutex;
                                                        c01012.L$0 = str2;
                                                        c01012.L$1 = mutex3;
                                                        c01012.L$2 = mutexImpl2;
                                                        c01012.L$3 = null;
                                                        c01012.Z$0 = z3;
                                                        c01012.Z$1 = z4;
                                                        c01012.J$0 = jLongValue;
                                                        c01012.label = 3;
                                                        if (mutexImpl2.lock(c01012) != obj4) {
                                                            obj4 = mutex3;
                                                            str5 = str2;
                                                            ensureLoadedFromCache(str5);
                                                            mutexImpl2.unlock(null);
                                                            refreshResult = new RefreshResult(false, false);
                                                            obj3 = obj4;
                                                            obj = obj3;
                                                        }
                                                    }
                                                    return obj4;
                                                } catch (Throwable th10) {
                                                    th = th10;
                                                    mutex2 = mutex3;
                                                    obj4 = mutex2;
                                                    map = null;
                                                    r7 = obj4;
                                                    r7.unlock(map);
                                                    throw th;
                                                }
                                            }
                                            Url urlValidatedSourceUrlOrNull$com_github_MetrolistGroup_innertubex = validatedSourceUrlOrNull$com_github_MetrolistGroup_innertubex(str2);
                                            if (urlValidatedSourceUrlOrNull$com_github_MetrolistGroup_innertubex == null) {
                                                try {
                                                    try {
                                                        try {
                                                            refreshResult = new RefreshResult(false, false);
                                                            obj = mutex3;
                                                        } catch (Exception e4) {
                                                            e = e4;
                                                            str7 = "Remote player configs applied (";
                                                            mutex2 = mutex3;
                                                            z3 = z3;
                                                            str13 = str13;
                                                            map = null;
                                                            boolean z11 = z4;
                                                            str8 = str2;
                                                            j = jLongValue;
                                                            z6 = z11;
                                                            PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline1 = this.logger;
                                                            simpleName = Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName();
                                                            if (simpleName == null) {
                                                                simpleName = "Exception";
                                                            }
                                                            EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, str13, "Remote player config refresh failed (" + simpleName + ")", map, 12);
                                                            r0 = map;
                                                            mutex6 = mutex2;
                                                            long j3 = j;
                                                            str9 = str8;
                                                            boolean z12 = z3;
                                                            this.lastRefreshAttemptSourceUrl = str9;
                                                            str13 = str13;
                                                            this.lastRefreshAttemptAtMs = ((Number) this.nowMs.invoke()).longValue();
                                                            mutexImpl3 = this.mutex;
                                                            c01012.L$0 = str9;
                                                            c01012.L$1 = mutex6;
                                                            c01012.L$2 = null;
                                                            c01012.L$3 = mutexImpl3;
                                                            c01012.L$4 = r0;
                                                            c01012.Z$0 = z12;
                                                            c01012.Z$1 = z6;
                                                            c01012.J$0 = j3;
                                                            c01012.label = 5;
                                                            if (mutexImpl3.lock(c01012) != obj4) {
                                                                r2 = r0;
                                                                obj4 = mutex6;
                                                                if (!Intrinsics.areEqual(configuredUrl(), str9)) {
                                                                    refreshResult = new RefreshResult(false, true);
                                                                } else if (r2 == 0) {
                                                                    ensureLoadedFromCache(str9);
                                                                    refreshResult = new RefreshResult(false, true);
                                                                } else {
                                                                    value = r2.status.getValue();
                                                                    str10 = r2.headers.get(HttpHeaders.ETag);
                                                                    if (value == 304) {
                                                                        this.repository.preferences.edit().putLong("cached_at_ms", ((Number) this.nowMs.invoke()).longValue()).apply();
                                                                        if (str10 != null) {
                                                                            InnerTubeXPlayer.AndroidPlayerConfigRepository androidPlayerConfigRepository6 = this.repository;
                                                                            androidPlayerConfigRepository6.getClass();
                                                                            androidPlayerConfigRepository6.preferences.edit().putString("etag", str10).apply();
                                                                        }
                                                                        ensureLoadedFromCache(str9);
                                                                        EntryPoints.d$default(this.logger, str13, "Remote player configs unchanged (304)", null, 12);
                                                                        refreshResult = new RefreshResult(false, true);
                                                                    } else {
                                                                        str11 = str13;
                                                                        if (200 <= value) {
                                                                        }
                                                                        obj2 = null;
                                                                        EntryPoints.w$default(this.logger, str11, str4 + value, null, 12);
                                                                        ensureLoadedFromCache(str9);
                                                                        refreshResult = new RefreshResult(false, true);
                                                                        mutexImpl3.unlock(obj2);
                                                                        r12 = obj4;
                                                                    }
                                                                }
                                                                obj2 = null;
                                                                mutexImpl3.unlock(obj2);
                                                                r12 = obj4;
                                                            }
                                                            return obj4;
                                                        }
                                                    } catch (CancellationException e5) {
                                                        throw e5;
                                                    }
                                                } catch (Exception e6) {
                                                    e = e6;
                                                }
                                            } else {
                                                try {
                                                    HttpClient httpClient = this.httpClient;
                                                    str7 = "Remote player configs applied (";
                                                    try {
                                                        IconKt$$ExternalSyntheticLambda1 iconKt$$ExternalSyntheticLambda1 = new IconKt$$ExternalSyntheticLambda1(str6, (byte) 13);
                                                        c01012.L$0 = str2;
                                                        c01012.L$1 = mutex3;
                                                        map = null;
                                                        try {
                                                            c01012.L$2 = null;
                                                            c01012.L$3 = null;
                                                            c01012.Z$0 = z3;
                                                            c01012.Z$1 = z4;
                                                            c01012.J$0 = jLongValue;
                                                            c01012.label = 4;
                                                            jLongValue = jLongValue;
                                                            mutex3 = mutex3;
                                                            z3 = z3;
                                                            str13 = str13;
                                                            str2 = str2;
                                                            z5 = z4;
                                                            try {
                                                                textWithoutRedirects = RegexKt.getTextWithoutRedirects(httpClient, urlValidatedSourceUrlOrNull$com_github_MetrolistGroup_innertubex, 4194304, null, iconKt$$ExternalSyntheticLambda1, c01012);
                                                                if (textWithoutRedirects != obj4) {
                                                                    str8 = str2;
                                                                    z6 = z5;
                                                                    mutex5 = mutex3;
                                                                    j = jLongValue;
                                                                    r0 = (RestrictedTextResponse) textWithoutRedirects;
                                                                    mutex6 = mutex5;
                                                                    long j4 = j;
                                                                    str9 = str8;
                                                                    boolean z13 = z3;
                                                                    this.lastRefreshAttemptSourceUrl = str9;
                                                                    str13 = str13;
                                                                    this.lastRefreshAttemptAtMs = ((Number) this.nowMs.invoke()).longValue();
                                                                    mutexImpl3 = this.mutex;
                                                                    c01012.L$0 = str9;
                                                                    c01012.L$1 = mutex6;
                                                                    c01012.L$2 = null;
                                                                    c01012.L$3 = mutexImpl3;
                                                                    c01012.L$4 = r0;
                                                                    c01012.Z$0 = z13;
                                                                    c01012.Z$1 = z6;
                                                                    c01012.J$0 = j4;
                                                                    c01012.label = 5;
                                                                    if (mutexImpl3.lock(c01012) != obj4) {
                                                                        r2 = r0;
                                                                        obj4 = mutex6;
                                                                        if (!Intrinsics.areEqual(configuredUrl(), str9)) {
                                                                            refreshResult = new RefreshResult(false, true);
                                                                        } else if (r2 == 0) {
                                                                            ensureLoadedFromCache(str9);
                                                                            refreshResult = new RefreshResult(false, true);
                                                                        } else {
                                                                            value = r2.status.getValue();
                                                                            str10 = r2.headers.get(HttpHeaders.ETag);
                                                                            if (value == 304) {
                                                                                str11 = str13;
                                                                                if (200 <= value) {
                                                                                }
                                                                                obj2 = null;
                                                                                EntryPoints.w$default(this.logger, str11, str4 + value, null, 12);
                                                                                ensureLoadedFromCache(str9);
                                                                                refreshResult = new RefreshResult(false, true);
                                                                                mutexImpl3.unlock(obj2);
                                                                                r12 = obj4;
                                                                                r12.unlock(obj2);
                                                                                return refreshResult;
                                                                            }
                                                                            this.repository.preferences.edit().putLong("cached_at_ms", ((Number) this.nowMs.invoke()).longValue()).apply();
                                                                            if (str10 != null) {
                                                                                InnerTubeXPlayer.AndroidPlayerConfigRepository androidPlayerConfigRepository7 = this.repository;
                                                                                androidPlayerConfigRepository7.getClass();
                                                                                androidPlayerConfigRepository7.preferences.edit().putString("etag", str10).apply();
                                                                            }
                                                                            ensureLoadedFromCache(str9);
                                                                            EntryPoints.d$default(this.logger, str13, "Remote player configs unchanged (304)", null, 12);
                                                                            refreshResult = new RefreshResult(false, true);
                                                                        }
                                                                        obj2 = null;
                                                                        mutexImpl3.unlock(obj2);
                                                                        r12 = obj4;
                                                                        r12.unlock(obj2);
                                                                        return refreshResult;
                                                                    }
                                                                }
                                                            } catch (CancellationException e7) {
                                                                e = e7;
                                                                throw e;
                                                            } catch (Exception e8) {
                                                                e = e8;
                                                                str8 = str2;
                                                                z6 = z5;
                                                                j = jLongValue;
                                                                mutex2 = mutex3;
                                                            } catch (Throwable th11) {
                                                                th = th11;
                                                                r7 = mutex3;
                                                                r7.unlock(map);
                                                                throw th;
                                                            }
                                                        } catch (Exception e9) {
                                                            e = e9;
                                                            z5 = z4;
                                                        } catch (Throwable th12) {
                                                            th = th12;
                                                            mutex3 = mutex3;
                                                        }
                                                    } catch (Exception e10) {
                                                        e = e10;
                                                        map = null;
                                                    }
                                                    return obj4;
                                                } catch (CancellationException e11) {
                                                    e = e11;
                                                    mutex3 = mutex3;
                                                }
                                            }
                                        } catch (Exception e12) {
                                            e = e12;
                                            str7 = "Remote player configs applied (";
                                        }
                                        long j5 = j;
                                        str9 = str8;
                                        boolean z14 = z3;
                                        this.lastRefreshAttemptSourceUrl = str9;
                                        str13 = str13;
                                        this.lastRefreshAttemptAtMs = ((Number) this.nowMs.invoke()).longValue();
                                        mutexImpl3 = this.mutex;
                                        c01012.L$0 = str9;
                                        c01012.L$1 = mutex6;
                                        c01012.L$2 = null;
                                        c01012.L$3 = mutexImpl3;
                                        c01012.L$4 = r0;
                                        c01012.Z$0 = z14;
                                        c01012.Z$1 = z6;
                                        c01012.J$0 = j5;
                                        c01012.label = 5;
                                        if (mutexImpl3.lock(c01012) != obj4) {
                                            r2 = r0;
                                            obj4 = mutex6;
                                            if (!Intrinsics.areEqual(configuredUrl(), str9)) {
                                                refreshResult = new RefreshResult(false, true);
                                            } else if (r2 == 0) {
                                                ensureLoadedFromCache(str9);
                                                refreshResult = new RefreshResult(false, true);
                                            } else {
                                                value = r2.status.getValue();
                                                str10 = r2.headers.get(HttpHeaders.ETag);
                                                if (value == 304) {
                                                    str11 = str13;
                                                    if (200 <= value) {
                                                    }
                                                    obj2 = null;
                                                    EntryPoints.w$default(this.logger, str11, str4 + value, null, 12);
                                                    ensureLoadedFromCache(str9);
                                                    refreshResult = new RefreshResult(false, true);
                                                    mutexImpl3.unlock(obj2);
                                                    r12 = obj4;
                                                    r12.unlock(obj2);
                                                    return refreshResult;
                                                }
                                                this.repository.preferences.edit().putLong("cached_at_ms", ((Number) this.nowMs.invoke()).longValue()).apply();
                                                if (str10 != null) {
                                                    InnerTubeXPlayer.AndroidPlayerConfigRepository androidPlayerConfigRepository8 = this.repository;
                                                    androidPlayerConfigRepository8.getClass();
                                                    androidPlayerConfigRepository8.preferences.edit().putString("etag", str10).apply();
                                                }
                                                ensureLoadedFromCache(str9);
                                                EntryPoints.d$default(this.logger, str13, "Remote player configs unchanged (304)", null, 12);
                                                refreshResult = new RefreshResult(false, true);
                                            }
                                            obj2 = null;
                                            mutexImpl3.unlock(obj2);
                                            r12 = obj4;
                                            r12.unlock(obj2);
                                            return refreshResult;
                                        }
                                        return obj4;
                                    } catch (Throwable th13) {
                                        th = th13;
                                        mutex3 = mutex3;
                                        map = null;
                                    }
                                } catch (CancellationException e13) {
                                    e = e13;
                                    mutex3 = mutex3;
                                }
                                String string = this.repository.preferences.getString("etag", "");
                                String str16 = string == null ? "" : string;
                                String string2 = this.repository.preferences.getString("source_url", "");
                                if (string2 != null) {
                                    str12 = string2;
                                }
                                str6 = str12.equals(str2) ? str16 : null;
                                if (str6 == null || StringsKt.isBlank(str6)) {
                                    str6 = null;
                                }
                                map = null;
                                z5 = z4;
                                str8 = str2;
                                z6 = z5;
                                j = jLongValue;
                                mutex2 = mutex3;
                            } catch (Throwable th14) {
                                th = th14;
                                obj4 = mutex3;
                                map = null;
                                r7 = obj4;
                                r7.unlock(map);
                                throw th;
                            }
                            str4 = "Remote player configs HTTP ";
                            mutex3 = mutex11;
                        } catch (Throwable th15) {
                            th = th15;
                            mutex2 = mutex11;
                        }
                        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline2 = this.logger;
                        simpleName = Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName();
                        if (simpleName == null) {
                            simpleName = "Exception";
                        }
                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline2, str13, "Remote player config refresh failed (" + simpleName + ")", map, 12);
                        r0 = map;
                        mutex6 = mutex2;
                    } else {
                        refreshResult = new RefreshResult(false, false);
                        obj = mutex;
                    }
                    obj2 = null;
                    r12 = obj;
                    r12.unlock(obj2);
                    return refreshResult;
                } catch (Throwable th16) {
                    th = th16;
                    mutex2 = mutex;
                }
            } catch (Throwable th17) {
                th = th17;
                map = null;
                r7 = obj4;
                r7.unlock(map);
                throw th;
            }
        } catch (Throwable th18) {
            th = th18;
            obj4 = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00a3 A[Catch: CancellationException -> 0x005b, TRY_LEAVE, TryCatch #1 {CancellationException -> 0x005b, blocks: (B:24:0x0057, B:44:0x009d, B:46:0x00a3), top: B:66:0x0057 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:60:0x00de  */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    public final Object refreshAfterStreamRejection$com_github_MetrolistGroup_innertubex(ContinuationImpl continuationImpl) throws Throwable {
        RemotePlayerConfigStore$refreshAfterStreamRejection$1 remotePlayerConfigStore$refreshAfterStreamRejection$1;
        String str;
        long j;
        CancellationException cancellationException;
        long j2;
        RefreshResult refreshResult;
        String str2;
        long j3;
        RefreshResult refreshResult2;
        NonCancellable nonCancellable;
        RemotePlayerConfigStore$forceRefresh$2 remotePlayerConfigStore$forceRefresh$2;
        if (continuationImpl instanceof RemotePlayerConfigStore$refreshAfterStreamRejection$1) {
            remotePlayerConfigStore$refreshAfterStreamRejection$1 = (RemotePlayerConfigStore$refreshAfterStreamRejection$1) continuationImpl;
            int i = remotePlayerConfigStore$refreshAfterStreamRejection$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                remotePlayerConfigStore$refreshAfterStreamRejection$1.label = i - Integer.MIN_VALUE;
            } else {
                remotePlayerConfigStore$refreshAfterStreamRejection$1 = new RemotePlayerConfigStore$refreshAfterStreamRejection$1(this, continuationImpl);
            }
        } else {
            remotePlayerConfigStore$refreshAfterStreamRejection$1 = new RemotePlayerConfigStore$refreshAfterStreamRejection$1(this, continuationImpl);
        }
        RemotePlayerConfigStore$refreshAfterStreamRejection$1 remotePlayerConfigStore$refreshAfterStreamRejection$2 = remotePlayerConfigStore$refreshAfterStreamRejection$1;
        Object objRefresh = remotePlayerConfigStore$refreshAfterStreamRejection$2.result;
        int i2 = remotePlayerConfigStore$refreshAfterStreamRejection$2.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objRefresh);
            this.repository.getClass();
            String strConfiguredUrl = configuredUrl();
            if (strConfiguredUrl == null) {
                return Boolean.FALSE;
            }
            remotePlayerConfigStore$refreshAfterStreamRejection$2.L$0 = strConfiguredUrl;
            remotePlayerConfigStore$refreshAfterStreamRejection$2.label = 1;
            Object objReserveStreamRejectionRefresh = reserveStreamRejectionRefresh(strConfiguredUrl, remotePlayerConfigStore$refreshAfterStreamRejection$2);
            if (objReserveStreamRejectionRefresh != obj) {
                str = strConfiguredUrl;
                objRefresh = objReserveStreamRejectionRefresh;
            }
            return obj;
        }
        if (i2 == 1) {
            str = remotePlayerConfigStore$refreshAfterStreamRejection$2.L$0;
            ResultKt.throwOnFailure(objRefresh);
        } else {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    CancellationException cancellationException2 = (CancellationException) remotePlayerConfigStore$refreshAfterStreamRejection$2.L$1;
                    ResultKt.throwOnFailure(objRefresh);
                    throw cancellationException2;
                }
                j3 = remotePlayerConfigStore$refreshAfterStreamRejection$2.J$0;
                refreshResult2 = (RefreshResult) remotePlayerConfigStore$refreshAfterStreamRejection$2.L$1;
                str2 = remotePlayerConfigStore$refreshAfterStreamRejection$2.L$0;
                try {
                    ResultKt.throwOnFailure(objRefresh);
                    refreshResult = refreshResult2;
                    return Boolean.valueOf(refreshResult.changed);
                } catch (CancellationException e) {
                    cancellationException = e;
                    j = j3;
                    str = str2;
                    nonCancellable = NonCancellable.INSTANCE;
                    remotePlayerConfigStore$forceRefresh$2 = new RemotePlayerConfigStore$forceRefresh$2(this, str, j, null, (byte) 1);
                    remotePlayerConfigStore$refreshAfterStreamRejection$2.L$0 = null;
                    remotePlayerConfigStore$refreshAfterStreamRejection$2.L$1 = cancellationException;
                    remotePlayerConfigStore$refreshAfterStreamRejection$2.J$0 = j;
                    remotePlayerConfigStore$refreshAfterStreamRejection$2.label = 4;
                    if (AwaitKt.withContext(nonCancellable, remotePlayerConfigStore$forceRefresh$2, remotePlayerConfigStore$refreshAfterStreamRejection$2) != obj) {
                        throw cancellationException;
                    }
                    return obj;
                }
            }
            j2 = remotePlayerConfigStore$refreshAfterStreamRejection$2.J$0;
            str = remotePlayerConfigStore$refreshAfterStreamRejection$2.L$0;
            try {
                ResultKt.throwOnFailure(objRefresh);
                refreshResult = (RefreshResult) objRefresh;
                if (!refreshResult.requestAttempted) {
                    remotePlayerConfigStore$refreshAfterStreamRejection$2.L$0 = str;
                    remotePlayerConfigStore$refreshAfterStreamRejection$2.L$1 = refreshResult;
                    remotePlayerConfigStore$refreshAfterStreamRejection$2.J$0 = j2;
                    remotePlayerConfigStore$refreshAfterStreamRejection$2.label = 3;
                    if (releaseStreamRejectionRefresh(j2, str, remotePlayerConfigStore$refreshAfterStreamRejection$2) != obj) {
                        str2 = str;
                        j3 = j2;
                        refreshResult2 = refreshResult;
                        refreshResult = refreshResult2;
                    }
                    return obj;
                }
                str2 = str;
                j3 = j2;
                return Boolean.valueOf(refreshResult.changed);
            } catch (CancellationException e2) {
                cancellationException = e2;
                j = j2;
                nonCancellable = NonCancellable.INSTANCE;
                remotePlayerConfigStore$forceRefresh$2 = new RemotePlayerConfigStore$forceRefresh$2(this, str, j, null, (byte) 1);
                remotePlayerConfigStore$refreshAfterStreamRejection$2.L$0 = null;
                remotePlayerConfigStore$refreshAfterStreamRejection$2.L$1 = cancellationException;
                remotePlayerConfigStore$refreshAfterStreamRejection$2.J$0 = j;
                remotePlayerConfigStore$refreshAfterStreamRejection$2.label = 4;
                if (AwaitKt.withContext(nonCancellable, remotePlayerConfigStore$forceRefresh$2, remotePlayerConfigStore$refreshAfterStreamRejection$2) != obj) {
                    throw cancellationException;
                }
            }
        }
        Long l = (Long) objRefresh;
        if (l == null) {
            return Boolean.FALSE;
        }
        long jLongValue = l.longValue();
        try {
            remotePlayerConfigStore$refreshAfterStreamRejection$2.L$0 = str;
            remotePlayerConfigStore$refreshAfterStreamRejection$2.J$0 = jLongValue;
            remotePlayerConfigStore$refreshAfterStreamRejection$2.label = 2;
            objRefresh = refresh(str, true, false, remotePlayerConfigStore$refreshAfterStreamRejection$2);
            if (objRefresh != obj) {
                j2 = jLongValue;
                refreshResult = (RefreshResult) objRefresh;
                if (!refreshResult.requestAttempted) {
                    remotePlayerConfigStore$refreshAfterStreamRejection$2.L$0 = str;
                    remotePlayerConfigStore$refreshAfterStreamRejection$2.L$1 = refreshResult;
                    remotePlayerConfigStore$refreshAfterStreamRejection$2.J$0 = j2;
                    remotePlayerConfigStore$refreshAfterStreamRejection$2.label = 3;
                    if (releaseStreamRejectionRefresh(j2, str, remotePlayerConfigStore$refreshAfterStreamRejection$2) != obj) {
                        str2 = str;
                        j3 = j2;
                        refreshResult2 = refreshResult;
                        refreshResult = refreshResult2;
                    }
                } else {
                    str2 = str;
                    j3 = j2;
                }
                return Boolean.valueOf(refreshResult.changed);
            }
        } catch (CancellationException e3) {
            j = jLongValue;
            cancellationException = e3;
            nonCancellable = NonCancellable.INSTANCE;
            remotePlayerConfigStore$forceRefresh$2 = new RemotePlayerConfigStore$forceRefresh$2(this, str, j, null, (byte) 1);
            remotePlayerConfigStore$refreshAfterStreamRejection$2.L$0 = null;
            remotePlayerConfigStore$refreshAfterStreamRejection$2.L$1 = cancellationException;
            remotePlayerConfigStore$refreshAfterStreamRejection$2.J$0 = j;
            remotePlayerConfigStore$refreshAfterStreamRejection$2.label = 4;
            if (AwaitKt.withContext(nonCancellable, remotePlayerConfigStore$forceRefresh$2, remotePlayerConfigStore$refreshAfterStreamRejection$2) != obj) {
                throw cancellationException;
            }
        }
        return obj;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object refreshIfStale$com_github_MetrolistGroup_innertubex(ContinuationImpl continuationImpl) {
        RemotePlayerConfigStore$refreshIfStale$1 remotePlayerConfigStore$refreshIfStale$1;
        String str;
        MutexImpl mutexImpl;
        String str2;
        MutexImpl mutexImpl2;
        if (continuationImpl instanceof RemotePlayerConfigStore$refreshIfStale$1) {
            remotePlayerConfigStore$refreshIfStale$1 = (RemotePlayerConfigStore$refreshIfStale$1) continuationImpl;
            int i = remotePlayerConfigStore$refreshIfStale$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                remotePlayerConfigStore$refreshIfStale$1.label = i - Integer.MIN_VALUE;
            } else {
                remotePlayerConfigStore$refreshIfStale$1 = new RemotePlayerConfigStore$refreshIfStale$1(this, continuationImpl);
            }
        } else {
            remotePlayerConfigStore$refreshIfStale$1 = new RemotePlayerConfigStore$refreshIfStale$1(this, continuationImpl);
        }
        Object obj = remotePlayerConfigStore$refreshIfStale$1.result;
        int i2 = remotePlayerConfigStore$refreshIfStale$1.label;
        Unit unit = Unit.INSTANCE;
        if (i2 != 0) {
            if (i2 == 1) {
                mutexImpl2 = remotePlayerConfigStore$refreshIfStale$1.L$1;
                str2 = remotePlayerConfigStore$refreshIfStale$1.L$0;
                ResultKt.throwOnFailure(obj);
                try {
                    ensureLoadedFromCache(str2);
                    return unit;
                } finally {
                    mutexImpl2.unlock(null);
                }
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            mutexImpl = remotePlayerConfigStore$refreshIfStale$1.L$1;
            str = remotePlayerConfigStore$refreshIfStale$1.L$0;
            ResultKt.throwOnFailure(obj);
            try {
                ensureLoadedFromCache(str);
                return unit;
            } finally {
                mutexImpl.unlock(null);
            }
        }
        ResultKt.throwOnFailure(obj);
        this.repository.getClass();
        long jLongValue = ((Number) this.nowMs.invoke()).longValue();
        String strConfiguredUrl = configuredUrl();
        if (strConfiguredUrl != null) {
            boolean zHasFreshCache = hasFreshCache(jLongValue, strConfiguredUrl);
            MutexImpl mutexImpl3 = this.mutex;
            Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (zHasFreshCache) {
                remotePlayerConfigStore$refreshIfStale$1.L$0 = strConfiguredUrl;
                remotePlayerConfigStore$refreshIfStale$1.L$1 = mutexImpl3;
                remotePlayerConfigStore$refreshIfStale$1.label = 1;
                if (mutexImpl3.lock(remotePlayerConfigStore$refreshIfStale$1) != obj2) {
                    str2 = strConfiguredUrl;
                    mutexImpl2 = mutexImpl3;
                    ensureLoadedFromCache(str2);
                    return unit;
                }
            } else if (hasRecentRefreshAttempt(jLongValue, strConfiguredUrl)) {
                remotePlayerConfigStore$refreshIfStale$1.L$0 = strConfiguredUrl;
                remotePlayerConfigStore$refreshIfStale$1.L$1 = mutexImpl3;
                remotePlayerConfigStore$refreshIfStale$1.label = 2;
                if (mutexImpl3.lock(remotePlayerConfigStore$refreshIfStale$1) != obj2) {
                    str = strConfiguredUrl;
                    mutexImpl = mutexImpl3;
                    ensureLoadedFromCache(str);
                    return unit;
                }
            } else {
                remotePlayerConfigStore$refreshIfStale$1.L$0 = null;
                remotePlayerConfigStore$refreshIfStale$1.label = 3;
                if (refresh(strConfiguredUrl, false, false, remotePlayerConfigStore$refreshIfStale$1) == obj2) {
                }
            }
            return obj2;
        }
        return unit;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object releaseStreamRejectionRefresh(long j, String str, ContinuationImpl continuationImpl) {
        C01021 c01021;
        MutexImpl mutexImpl;
        if (continuationImpl instanceof C01021) {
            c01021 = (C01021) continuationImpl;
            int i = c01021.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01021.label = i - Integer.MIN_VALUE;
            } else {
                c01021 = new C01021(continuationImpl);
            }
        } else {
            c01021 = new C01021(continuationImpl);
        }
        Object obj = c01021.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = c01021.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mutexImpl = this.mutex;
            c01021.L$0 = str;
            c01021.L$1 = mutexImpl;
            c01021.J$0 = j;
            c01021.label = 1;
            if (mutexImpl.lock(c01021) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = c01021.J$0;
            MutexImpl mutexImpl2 = c01021.L$1;
            String str2 = c01021.L$0;
            ResultKt.throwOnFailure(obj);
            mutexImpl = mutexImpl2;
            str = str2;
        }
        try {
            if (Intrinsics.areEqual(this.lastStreamRejectionRefreshSourceUrl, str) && this.lastStreamRejectionRefreshAtMs == j) {
                this.lastStreamRejectionRefreshSourceUrl = null;
                this.lastStreamRejectionRefreshAtMs = 0L;
            }
            return Unit.INSTANCE;
        } finally {
            mutexImpl.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object releaseUnknownHashRefresh(long j, String str, ContinuationImpl continuationImpl) {
        C01031 c01031;
        MutexImpl mutexImpl;
        if (continuationImpl instanceof C01031) {
            c01031 = (C01031) continuationImpl;
            int i = c01031.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01031.label = i - Integer.MIN_VALUE;
            } else {
                c01031 = new C01031(continuationImpl);
            }
        } else {
            c01031 = new C01031(continuationImpl);
        }
        Object obj = c01031.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = c01031.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mutexImpl = this.mutex;
            c01031.L$0 = str;
            c01031.L$1 = mutexImpl;
            c01031.J$0 = j;
            c01031.label = 1;
            if (mutexImpl.lock(c01031) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = c01031.J$0;
            MutexImpl mutexImpl2 = c01031.L$1;
            String str2 = c01031.L$0;
            ResultKt.throwOnFailure(obj);
            mutexImpl = mutexImpl2;
            str = str2;
        }
        try {
            if (Intrinsics.areEqual(this.lastUnknownHashRefreshSourceUrl, str) && this.lastUnknownHashRefreshAtMs == j) {
                this.lastUnknownHashRefreshSourceUrl = null;
                this.lastUnknownHashRefreshAtMs = 0L;
            }
            return Unit.INSTANCE;
        } finally {
            mutexImpl.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object reserveStreamRejectionRefresh(String str, ContinuationImpl continuationImpl) {
        C01041 c01041;
        MutexImpl mutexImpl;
        Long l;
        if (continuationImpl instanceof C01041) {
            c01041 = (C01041) continuationImpl;
            int i = c01041.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01041.label = i - Integer.MIN_VALUE;
            } else {
                c01041 = new C01041(continuationImpl);
            }
        } else {
            c01041 = new C01041(continuationImpl);
        }
        Object obj = c01041.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = c01041.label;
        boolean z = true;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mutexImpl = this.mutex;
            c01041.L$0 = str;
            c01041.L$1 = mutexImpl;
            c01041.label = 1;
            if (mutexImpl.lock(c01041) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            MutexImpl mutexImpl2 = c01041.L$1;
            String str2 = c01041.L$0;
            ResultKt.throwOnFailure(obj);
            mutexImpl = mutexImpl2;
            str = str2;
        }
        try {
            long jLongValue = ((Number) this.nowMs.invoke()).longValue();
            String str3 = this.lastStreamRejectionRefreshSourceUrl;
            long j = this.lastStreamRejectionRefreshAtMs;
            if (!Intrinsics.areEqual(str3, str) || (jLongValue > j && jLongValue - j >= 300000)) {
                z = false;
            }
            if (z) {
                l = null;
            } else {
                this.lastStreamRejectionRefreshSourceUrl = str;
                this.lastStreamRejectionRefreshAtMs = jLongValue;
                l = new Long(jLongValue);
            }
            return l;
        } finally {
            mutexImpl.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object reserveUnknownHashRefresh(String str, ContinuationImpl continuationImpl) {
        C01051 c01051;
        MutexImpl mutexImpl;
        Long l;
        if (continuationImpl instanceof C01051) {
            c01051 = (C01051) continuationImpl;
            int i = c01051.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01051.label = i - Integer.MIN_VALUE;
            } else {
                c01051 = new C01051(continuationImpl);
            }
        } else {
            c01051 = new C01051(continuationImpl);
        }
        Object obj = c01051.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = c01051.label;
        boolean z = true;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mutexImpl = this.mutex;
            c01051.L$0 = str;
            c01051.L$1 = mutexImpl;
            c01051.label = 1;
            if (mutexImpl.lock(c01051) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            MutexImpl mutexImpl2 = c01051.L$1;
            String str2 = c01051.L$0;
            ResultKt.throwOnFailure(obj);
            mutexImpl = mutexImpl2;
            str = str2;
        }
        try {
            long jLongValue = ((Number) this.nowMs.invoke()).longValue();
            String str3 = this.lastUnknownHashRefreshSourceUrl;
            long j = this.lastUnknownHashRefreshAtMs;
            if (!Intrinsics.areEqual(str3, str) || (jLongValue > j && jLongValue - j >= 300000)) {
                z = false;
            }
            if (z) {
                l = null;
            } else {
                this.lastUnknownHashRefreshSourceUrl = str;
                this.lastUnknownHashRefreshAtMs = jLongValue;
                l = new Long(jLongValue);
            }
            return l;
        } finally {
            mutexImpl.unlock(null);
        }
    }
}
