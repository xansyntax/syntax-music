package com.metrolist.innertubex.extraction;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.snapshots.SnapshotApplyConflictException;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavDeepLinkRequest;
import coil3.intercept.EngineInterceptor;
import coil3.network.NetworkFetcher$doFetch$fetchResult$1;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda2;
import com.metrolist.innertubex.InnerTube;
import com.metrolist.innertubex.InnerTube$playerWithSessionBound$3;
import com.metrolist.innertubex.extraction.strategy.ClientFallbackStrategy;
import com.metrolist.innertubex.extraction.strategy.ClientHealthMonitor;
import com.metrolist.innertubex.extraction.strategy.ClientPoTokenCapabilities;
import com.metrolist.innertubex.extraction.strategy.ContentAwareFallbackStrategy;
import com.metrolist.innertubex.extraction.strategy.PlaybackClientCatalog;
import com.metrolist.innertubex.extraction.strategy.PlaybackClientManifest;
import com.metrolist.innertubex.extraction.strategy.PoTokenProviderKind;
import com.metrolist.innertubex.extraction.strategy.PoTokenRequirement;
import com.metrolist.innertubex.extraction.strategy.PoTokenRule;
import com.metrolist.innertubex.extraction.strategy.SelectedClient;
import com.metrolist.innertubex.models.PoTokenBinding;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.innertubex.models.response.PlayerResponse;
import com.metrolist.music.App;
import com.metrolist.music.utils.potoken.PoTokenGenerator;
import dagger.hilt.EntryPoints;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.InstantJvmKt;
import kotlin.time.InstantKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonImpl;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerClientDirector {
    public final ClientFallbackStrategy fallbackStrategy;
    public final InnerTube innerTube;
    public final JsonImpl json;
    public final PathKt$$ExternalSyntheticBUOutline0 logger;
    public final int maxPlayerRequests;
    public final TokenProvider tokenProvider;
    public final boolean usesAutomaticCatalog;
    public static final int DEFAULT_MAX_PLAYER_REQUESTS = PlaybackClientCatalog.automaticManifests.size() * 2;
    public static final Regex N_PARAMETER_REGEX = new Regex("[?&]n=[^&]+", 0);
    public static final Regex UNSAFE_PROFILE_CHARACTERS = new Regex("[^A-Za-z0-9_.-]");
    public static final Set DYNAMIC_WEB_VERSION_CLIENT_NAMES = ArraysKt.toSet(new String[]{"WEB", "WEB_EMBEDDED_PLAYER"});
    public static final Set TRANSPORT_PROBE_CLIENT_NAMES = ArraysKt.toSet(new String[]{"IOS_MUSIC", "ANDROID_KIDS", "ANDROID_PRODUCER", "MEDIA_CONNECT_FRONTEND"});
    public static final Set KNOWN_DRM_KEYS = ArraysKt.toSet(new String[]{"contentprotection", "contentprotectionids", "drmfamilies", "drmfamily", "drmparameters", "drmparams", "drmtracktype", "fairplay", "licenseinfo", "licenseinfos", "licenseurl", "playready", "widevine"});

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ClientAttempt {
        public final PlayerResponse response;
        public final String streamingDataPoToken;
        public final boolean usedPoToken;

        public ClientAttempt(PlayerResponse playerResponse, boolean z, String str) {
            this.response = playerResponse;
            this.usedPoToken = z;
            this.streamingDataPoToken = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClientAttempt)) {
                return false;
            }
            ClientAttempt clientAttempt = (ClientAttempt) obj;
            return Intrinsics.areEqual(this.response, clientAttempt.response) && this.usedPoToken == clientAttempt.usedPoToken && Intrinsics.areEqual(this.streamingDataPoToken, clientAttempt.streamingDataPoToken);
        }

        public final int hashCode() {
            int iM = IntIntPair$$ExternalSyntheticOutline0.m(this.response.hashCode() * 31, this.usedPoToken, 31);
            String str = this.streamingDataPoToken;
            return iM + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("ClientAttempt(response=");
            sb.append(this.response);
            sb.append(", usedPoToken=");
            sb.append(this.usedPoToken);
            sb.append(", streamingDataPoToken=");
            return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.streamingDataPoToken, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ClientAttemptResult {
        public final ClientAttempt attempt;
        public final PlayabilityFailure failure;
        public final PlayerResponse observedResponse;
        public final Throwable requestFailure;
        public final boolean tokenFetchUnavailable;
        public final boolean tokenUnavailable;

        public ClientAttemptResult(ClientAttempt clientAttempt, PlayabilityFailure playabilityFailure, Exception exc, boolean z, PlayerResponse playerResponse, int i) {
            exc = (i & 4) != 0 ? null : exc;
            z = (i & 8) != 0 ? false : z;
            boolean z2 = (i & 16) == 0;
            playerResponse = (i & 32) != 0 ? null : playerResponse;
            this.attempt = clientAttempt;
            this.failure = playabilityFailure;
            this.requestFailure = exc;
            this.tokenUnavailable = z;
            this.tokenFetchUnavailable = z2;
            this.observedResponse = playerResponse;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClientAttemptResult)) {
                return false;
            }
            ClientAttemptResult clientAttemptResult = (ClientAttemptResult) obj;
            return Intrinsics.areEqual(this.attempt, clientAttemptResult.attempt) && Intrinsics.areEqual(this.failure, clientAttemptResult.failure) && Intrinsics.areEqual(this.requestFailure, clientAttemptResult.requestFailure) && this.tokenUnavailable == clientAttemptResult.tokenUnavailable && this.tokenFetchUnavailable == clientAttemptResult.tokenFetchUnavailable && Intrinsics.areEqual(this.observedResponse, clientAttemptResult.observedResponse);
        }

        public final int hashCode() {
            ClientAttempt clientAttempt = this.attempt;
            int iHashCode = (clientAttempt == null ? 0 : clientAttempt.hashCode()) * 31;
            PlayabilityFailure playabilityFailure = this.failure;
            int iHashCode2 = (iHashCode + (playabilityFailure == null ? 0 : playabilityFailure.hashCode())) * 31;
            Throwable th = this.requestFailure;
            int iM = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iHashCode2 + (th == null ? 0 : th.hashCode())) * 31, this.tokenUnavailable, 31), this.tokenFetchUnavailable, 31);
            PlayerResponse playerResponse = this.observedResponse;
            return iM + (playerResponse != null ? playerResponse.hashCode() : 0);
        }

        public final String toString() {
            return "ClientAttemptResult(attempt=" + this.attempt + ", failure=" + this.failure + ", requestFailure=" + this.requestFailure + ", tokenUnavailable=" + this.tokenUnavailable + ", tokenFetchUnavailable=" + this.tokenFetchUnavailable + ", observedResponse=" + this.observedResponse + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TokenPlan {
        public final PoTokenBinding gvsBinding;
        public final boolean gvsRequired;
        public final PoTokenBinding playerBinding;
        public final boolean playerRequired;

        public TokenPlan(PoTokenBinding poTokenBinding, PoTokenBinding poTokenBinding2, boolean z, boolean z2) {
            this.playerBinding = poTokenBinding;
            this.gvsBinding = poTokenBinding2;
            this.playerRequired = z;
            this.gvsRequired = z2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TokenPlan)) {
                return false;
            }
            TokenPlan tokenPlan = (TokenPlan) obj;
            return this.playerBinding == tokenPlan.playerBinding && this.gvsBinding == tokenPlan.gvsBinding && this.playerRequired == tokenPlan.playerRequired && this.gvsRequired == tokenPlan.gvsRequired;
        }

        public final boolean getCanMint() {
            return (this.playerBinding == null && this.gvsBinding == null) ? false : true;
        }

        public final int hashCode() {
            PoTokenBinding poTokenBinding = this.playerBinding;
            int iHashCode = (poTokenBinding == null ? 0 : poTokenBinding.hashCode()) * 31;
            PoTokenBinding poTokenBinding2 = this.gvsBinding;
            return Boolean.hashCode(this.gvsRequired) + IntIntPair$$ExternalSyntheticOutline0.m((iHashCode + (poTokenBinding2 != null ? poTokenBinding2.hashCode() : 0)) * 31, this.playerRequired, 31);
        }

        public final String toString() {
            return "TokenPlan(playerBinding=" + this.playerBinding + ", gvsBinding=" + this.gvsBinding + ", playerRequired=" + this.playerRequired + ", gvsRequired=" + this.gvsRequired + ")";
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.PlayerClientDirector$requestPlayer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public YouTubeClient L$0;
        public NavDeepLinkRequest L$6;
        public PlayerRequestKey L$8;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayerClientDirector.this.requestPlayer(null, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.PlayerClientDirector$requestPlayerWithoutTimeout$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01261 extends ContinuationImpl {
        public long J$0;
        public YouTubeClient L$0;
        public String L$1;
        public String L$6;
        public int label;
        public /* synthetic */ Object result;

        public C01261(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayerClientDirector.this.requestPlayerWithoutTimeout(null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.PlayerClientDirector$tryPlayer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01271 extends ContinuationImpl {
        public SelectedClient L$0;
        public String L$1;
        public PlayerConfig L$2;
        public ContentHints L$3;
        public InnerTube.SessionSnapshot L$4;
        public NavDeepLinkRequest L$5;
        public Deferred L$6;
        public YouTubeClient L$7;
        public TokenPlan L$8;
        public boolean Z$0;
        public boolean Z$1;
        public boolean Z$2;
        public boolean Z$3;
        public int label;
        public /* synthetic */ Object result;

        public C01271(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayerClientDirector.this.tryPlayer(null, null, null, null, false, false, false, null, null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertubex.extraction.PlayerClientDirector$tryTokenizedPlayer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01281 extends ContinuationImpl {
        public long J$0;
        public SelectedClient L$0;
        public TokenPlan L$1;
        public InnerTube.SessionSnapshot L$10;
        public String L$11;
        public String L$13;
        public String L$14;
        public String L$2;
        public PlayerConfig L$3;
        public InnerTube.SessionSnapshot L$4;
        public PlayabilityFailure L$5;
        public PlayerResponse L$6;
        public NavDeepLinkRequest L$7;
        public Deferred L$8;
        public YouTubeClient L$9;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C01281(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayerClientDirector.this.tryTokenizedPlayer(null, null, null, null, null, null, null, null, false, null, this);
        }
    }

    public PlayerClientDirector(InnerTube innerTube, ClientFallbackStrategy clientFallbackStrategy, TokenProvider tokenProvider, ClientHealthMonitor clientHealthMonitor, PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0) {
        innerTube.getClass();
        this.innerTube = innerTube;
        this.fallbackStrategy = clientFallbackStrategy;
        this.tokenProvider = tokenProvider;
        this.logger = pathKt$$ExternalSyntheticBUOutline0;
        this.maxPlayerRequests = DEFAULT_MAX_PLAYER_REQUESTS;
        this.json = UuidKt.Json$default(new YouTube$$ExternalSyntheticLambda2((byte) 22));
        this.usesAutomaticCatalog = clientFallbackStrategy instanceof ContentAwareFallbackStrategy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean hasDrmValue(JsonElement jsonElement) {
        if (jsonElement instanceof JsonObject) {
            if (!((Map) jsonElement).isEmpty()) {
                return true;
            }
        } else if (jsonElement instanceof JsonArray) {
            Iterable<JsonElement> iterable = (Iterable) jsonElement;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                for (JsonElement jsonElement2 : iterable) {
                    if (jsonElement2 != null) {
                        if ((jsonElement2 instanceof JsonObject) || (jsonElement2 instanceof JsonArray)) {
                            return true;
                        }
                        if (jsonElement2 instanceof JsonPrimitive) {
                            String contentOrNull = JsonElementKt.getContentOrNull((JsonPrimitive) jsonElement2);
                            if (contentOrNull != null && !StringsKt.isBlank(contentOrNull) && !contentOrNull.equals("false") && !contentOrNull.equals("0")) {
                                return true;
                            }
                        }
                    }
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return false;
                }
            }
        } else {
            if (!(jsonElement instanceof JsonPrimitive)) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return false;
            }
            String contentOrNull2 = JsonElementKt.getContentOrNull((JsonPrimitive) jsonElement);
            if (contentOrNull2 != null && !StringsKt.isBlank(contentOrNull2) && !contentOrNull2.equals("false") && !contentOrNull2.equals("0")) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasUsableSabrAudio(PlayerResponse playerResponse) {
        String str;
        PlayerResponse.PlayerConfig.MediaCommonConfig mediaCommonConfig;
        PlayerResponse.PlayerConfig.MediaCommonConfig.MediaUstreamerRequestConfig mediaUstreamerRequestConfig;
        PlayerResponse.StreamingData streamingData = playerResponse.streamingData;
        if (streamingData == null || (str = streamingData.serverAbrStreamingUrl) == null || StringsKt.isBlank(str)) {
            return false;
        }
        PlayerResponse.PlayerConfig playerConfig = playerResponse.playerConfig;
        String str2 = (playerConfig == null || (mediaCommonConfig = playerConfig.mediaCommonConfig) == null || (mediaUstreamerRequestConfig = mediaCommonConfig.mediaUstreamerRequestConfig) == null) ? null : mediaUstreamerRequestConfig.videoPlaybackUstreamerConfig;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return false;
        }
        List<PlayerResponse.StreamingData.Format> list = streamingData.adaptiveFormats;
        if (list != null && list.isEmpty()) {
            return false;
        }
        for (PlayerResponse.StreamingData.Format format : list) {
            if (format.isAudio() && format.itag > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0067 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    public static boolean isPlayable(PlayerResponse playerResponse, YouTubeClient youTubeClient) {
        String str;
        boolean zHasUsableSabrAudio;
        String str2;
        String str3;
        String str4;
        PlayerResponse.PlayabilityStatus playabilityStatus = playerResponse.playabilityStatus;
        PlayerResponse.StreamingData streamingData = playerResponse.streamingData;
        if (Intrinsics.areEqual(playabilityStatus.status, "OK") || youTubeClient.skipPlayerResponseValidation) {
            if (youTubeClient.useSabr) {
                zHasUsableSabrAudio = hasUsableSabrAudio(playerResponse);
            } else if (streamingData != null) {
                Collection collection = streamingData.formats;
                if (collection == null) {
                    collection = EmptyList.INSTANCE;
                }
                ArrayList arrayListPlus = CollectionsKt.plus((Iterable) streamingData.adaptiveFormats, collection);
                if (arrayListPlus.isEmpty()) {
                    if (streamingData != null) {
                        str = streamingData.hlsManifestUrl;
                    } else {
                        str = null;
                    }
                    zHasUsableSabrAudio = str == null && !StringsKt.isBlank(str);
                } else {
                    int size = arrayListPlus.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            Object obj = arrayListPlus.get(i);
                            i++;
                            PlayerResponse.StreamingData.Format format = (PlayerResponse.StreamingData.Format) obj;
                            if (!format.isAudio() || (((str2 = format.url) == null || StringsKt.isBlank(str2)) && (((str3 = format.signatureCipher) == null || StringsKt.isBlank(str3)) && ((str4 = format.cipher) == null || StringsKt.isBlank(str4))))) {
                            }
                        } else {
                            if (streamingData != null) {
                                str = streamingData.hlsManifestUrl;
                            } else {
                                str = null;
                            }
                            if (str == null) {
                            }
                        }
                    }
                }
            } else {
                if (streamingData != null) {
                    str = streamingData.hlsManifestUrl;
                } else {
                    str = null;
                }
                if (str == null) {
                }
            }
            if (zHasUsableSabrAudio) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSatisfiedByPremium(PoTokenRule poTokenRule, boolean z) {
        if (poTokenRule.requirement == PoTokenRequirement.REQUIRED) {
            return z && poTokenRule.premiumMayBypass;
        }
        return true;
    }

    public static JsonElement knownDrmValue(JsonObject jsonObject, String str) {
        Object next;
        String lowerCase;
        Iterator it = jsonObject.content.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            lowerCase = ((String) ((Map.Entry) next).getKey()).toLowerCase(Locale.ROOT);
            lowerCase.getClass();
        } while (!lowerCase.equals(str));
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (JsonElement) entry.getValue();
        }
        return null;
    }

    public static String legacyProfileId(YouTubeClient youTubeClient, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(youTubeClient.clientName);
        sb.append('_');
        String str = youTubeClient.friendlyName;
        if (str == null) {
            str = youTubeClient.clientVersion;
        }
        sb.append(str);
        if (youTubeClient.isEmbedded) {
            sb.append("_embedded");
        }
        return IntIntPair$$ExternalSyntheticOutline0.m(UNSAFE_PROFILE_CHARACTERS.replace(sb.toString(), "_"), "_", z ? "po" : "nopo");
    }

    public static String profileId(SelectedClient selectedClient, boolean z) {
        PlaybackClientManifest playbackClientManifest = selectedClient.manifest;
        if (playbackClientManifest != null) {
            return IntIntPair$$ExternalSyntheticOutline0.m(playbackClientManifest.id, "__", z ? "po" : "nopo");
        }
        return legacyProfileId(selectedClient.client, z);
    }

    public static Set profileIds(SelectedClient selectedClient, boolean z) {
        PlaybackClientManifest playbackClientManifest = selectedClient.manifest;
        if (playbackClientManifest == null) {
            return CharsKt.setOf(legacyProfileId(selectedClient.client, z));
        }
        PlaybackClientCatalog playbackClientCatalog = PlaybackClientCatalog.INSTANCE;
        return PlaybackClientCatalog.profileIds(playbackClientManifest, z);
    }

    public static String responseTransportOutcome(PlayerResponse playerResponse) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        PlayerResponse.StreamingData streamingData = playerResponse.streamingData;
        List list = streamingData != null ? streamingData.adaptiveFormats : null;
        List list2 = EmptyList.INSTANCE;
        if (list == null) {
            list = list2;
        }
        List list3 = streamingData != null ? streamingData.formats : null;
        if (list3 != null) {
            list2 = list3;
        }
        StringBuilder sb = new StringBuilder("response_shape:adaptive_direct=");
        String str7 = "absent";
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = "absent";
                    break;
                }
                String str8 = ((PlayerResponse.StreamingData.Format) it.next()).url;
                if (str8 != null && (!StringsKt.isBlank(str8))) {
                    str = "present";
                    break;
                }
            }
        } else {
            str = "absent";
            break;
        }
        sb.append(str);
        sb.append(",adaptive_cipher=");
        if (list.isEmpty()) {
            str2 = "absent";
        } else {
            Iterator it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    PlayerResponse.StreamingData.Format format = (PlayerResponse.StreamingData.Format) it2.next();
                    String str9 = format.signatureCipher;
                    if ((str9 != null && !StringsKt.isBlank(str9)) || ((str6 = format.cipher) != null && !StringsKt.isBlank(str6))) {
                        str2 = "present";
                    }
                } else {
                    str2 = "absent";
                }
            }
        }
        sb.append(str2);
        sb.append(",progressive_direct=");
        if (!list2.isEmpty()) {
            Iterator it3 = list2.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    str3 = "absent";
                    break;
                }
                String str10 = ((PlayerResponse.StreamingData.Format) it3.next()).url;
                if (str10 != null && (!StringsKt.isBlank(str10))) {
                    str3 = "present";
                    break;
                }
            }
        } else {
            str3 = "absent";
            break;
        }
        sb.append(str3);
        sb.append(",progressive_cipher=");
        if (list2.isEmpty()) {
            str4 = "absent";
        } else {
            Iterator it4 = list2.iterator();
            while (true) {
                if (it4.hasNext()) {
                    PlayerResponse.StreamingData.Format format2 = (PlayerResponse.StreamingData.Format) it4.next();
                    String str11 = format2.signatureCipher;
                    if ((str11 != null && !StringsKt.isBlank(str11)) || ((str5 = format2.cipher) != null && !StringsKt.isBlank(str5))) {
                        str4 = "present";
                    }
                } else {
                    str4 = "absent";
                }
            }
        }
        sb.append(str4);
        sb.append(",hls=");
        String str12 = streamingData != null ? streamingData.hlsManifestUrl : null;
        sb.append((str12 == null || StringsKt.isBlank(str12)) ? "absent" : "present");
        sb.append(",dash=");
        String str13 = streamingData != null ? streamingData.dashManifestUrl : null;
        sb.append((str13 == null || StringsKt.isBlank(str13)) ? "absent" : "present");
        sb.append(",sabr=");
        String str14 = streamingData != null ? streamingData.serverAbrStreamingUrl : null;
        if (str14 != null && !StringsKt.isBlank(str14)) {
            str7 = "present";
        }
        sb.append(str7);
        return sb.toString();
    }

    public static final PoTokenBinding tokenPlan$compatibleBinding(PlayerClientDirector playerClientDirector, PoTokenRule poTokenRule) {
        PoTokenBinding poTokenBinding = poTokenRule.binding;
        if (poTokenBinding == null || poTokenRule.requirement == PoTokenRequirement.NONE) {
            return null;
        }
        Set set = poTokenRule.providers;
        if ((set instanceof Collection) && set.isEmpty()) {
            return null;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (playerClientDirector.tokenProvider.getCapabilities().providers.contains((PoTokenProviderKind) it.next())) {
                return poTokenBinding;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:113:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:133:0x042b  */
    /* JADX WARN: Code duplicated, block: B:141:0x043c  */
    /* JADX WARN: Code duplicated, block: B:180:0x04eb  */
    /* JADX WARN: Code duplicated, block: B:380:0x04fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:381:0x04f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:382:? A[LOOP:1: B:178:0x04e5->B:382:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x014b A[PHI: r4
      0x014b: PHI (r4v7 java.lang.String) = (r4v6 java.lang.String), (r4v24 java.lang.String), (r4v25 java.lang.String) binds: [B:28:0x0130, B:35:0x013f, B:39:0x0149] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11, types: [int] */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r1v123 */
    /* JADX WARN: Type inference failed for: r1v71, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v75 */
    /* JADX WARN: Type inference failed for: r23v8 */
    /* JADX WARN: Type inference failed for: r50v0 */
    /* JADX WARN: Type inference failed for: r50v1, types: [int] */
    /* JADX WARN: Type inference failed for: r50v2 */
    /* JADX WARN: Type inference failed for: r56v1 */
    /* JADX WARN: Type inference failed for: r56v11 */
    /* JADX WARN: Type inference failed for: r56v2 */
    /* JADX WARN: Type inference failed for: r56v6 */
    /* JADX WARN: Type inference failed for: r56v7 */
    /* JADX WARN: Type inference failed for: r56v8 */
    /* JADX WARN: Type inference failed for: r57v3 */
    /* JADX WARN: Type inference failed for: r57v4 */
    /* JADX WARN: Type inference failed for: r62v1 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:222:0x061f -> B:223:0x0638). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object fetchPlayerResponses$com_github_MetrolistGroup_innertubex(java.lang.String r55, com.metrolist.innertubex.extraction.PlayerConfig r56, com.metrolist.innertubex.extraction.ContentHints r57, java.util.Set r58, boolean r59, boolean r60, boolean r61, androidx.navigation.NavDeepLinkRequest r62, kotlinx.coroutines.Deferred r63, kotlin.coroutines.jvm.internal.ContinuationImpl r64) {
        /*
            Method dump skipped, instruction units count: 2648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.innertubex.extraction.PlayerClientDirector.fetchPlayerResponses$com_github_MetrolistGroup_innertubex(java.lang.String, com.metrolist.innertubex.extraction.PlayerConfig, com.metrolist.innertubex.extraction.ContentHints, java.util.Set, boolean, boolean, boolean, androidx.navigation.NavDeepLinkRequest, kotlinx.coroutines.Deferred, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    public final Object requestPlayer(YouTubeClient youTubeClient, String str, Integer num, String str2, InnerTube.SessionSnapshot sessionSnapshot, String str3, NavDeepLinkRequest navDeepLinkRequest, ContinuationImpl continuationImpl) throws SnapshotApplyConflictException, IOException {
        AnonymousClass1 anonymousClass1;
        YouTubeClient youTubeClient2;
        PlayerRequestKey playerRequestKey;
        TimeoutCancellationException e;
        PlayerClientDirector playerClientDirector = this;
        NavDeepLinkRequest navDeepLinkRequest2 = navDeepLinkRequest;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = playerClientDirector.new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = playerClientDirector.new AnonymousClass1(continuationImpl);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objWithTimeout = anonymousClass2.result;
        int i2 = anonymousClass2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithTimeout);
            PlayerRequestKey playerRequestKey2 = new PlayerRequestKey(youTubeClient, str, youTubeClient.useSignatureTimestamp ? num : null, str2, sessionSnapshot, youTubeClient.isEmbedded ? str3 : null);
            youTubeClient2 = youTubeClient;
            navDeepLinkRequest2.getClass();
            LinkedHashMap linkedHashMap = (LinkedHashMap) navDeepLinkRequest2.uri;
            if (linkedHashMap.containsKey(playerRequestKey2)) {
                Map mapSingletonMap = Collections.singletonMap("client", youTubeClient2.clientName);
                mapSingletonMap.getClass();
                EntryPoints.d$default(playerClientDirector.logger, "PlayerClientDirector", "player response reused", mapSingletonMap, 4);
                return (PlayerResponse) linkedHashMap.get(playerRequestKey2);
            }
            AtomicInteger atomicInteger = (AtomicInteger) navDeepLinkRequest2.mimeType;
            while (true) {
                int i3 = atomicInteger.get();
                if (i3 <= 0) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Player request budget exhausted");
                    return null;
                }
                if (atomicInteger.compareAndSet(i3, i3 - 1)) {
                    try {
                        Path.Companion companion = Duration.Companion;
                        long duration = InstantKt.toDuration(PoTokenGenerator.POTOKEN_TIMEOUT_MS, DurationUnit.MILLISECONDS);
                        EngineInterceptor.AnonymousClass2 anonymousClass3 = new EngineInterceptor.AnonymousClass2(playerClientDirector, youTubeClient2, str, num, str2, sessionSnapshot, str3, null, (byte) 2);
                        anonymousClass2.L$0 = youTubeClient2;
                        anonymousClass2.L$6 = navDeepLinkRequest2;
                        anonymousClass2.L$8 = playerRequestKey2;
                        anonymousClass2.label = 1;
                        objWithTimeout = AwaitKt.withTimeout(AwaitKt.m1898toDelayMillisLRDsOJo(duration), anonymousClass3, anonymousClass2);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objWithTimeout != coroutineSingletons) {
                            playerRequestKey = playerRequestKey2;
                            break;
                        }
                        return coroutineSingletons;
                    } catch (TimeoutCancellationException e2) {
                        e = e2;
                        String str4 = youTubeClient2.clientName;
                        str4.getClass();
                        throw new SnapshotApplyConflictException("Player request for " + str4 + " exceeded 8000ms", e);
                    }
                }
                playerClientDirector = this;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            playerRequestKey = anonymousClass2.L$8;
            NavDeepLinkRequest navDeepLinkRequest3 = anonymousClass2.L$6;
            YouTubeClient youTubeClient3 = anonymousClass2.L$0;
            try {
                ResultKt.throwOnFailure(objWithTimeout);
                navDeepLinkRequest2 = navDeepLinkRequest3;
                youTubeClient2 = youTubeClient3;
            } catch (TimeoutCancellationException e3) {
                e = e3;
                youTubeClient2 = youTubeClient3;
                String str5 = youTubeClient2.clientName;
                str5.getClass();
                throw new SnapshotApplyConflictException("Player request for " + str5 + " exceeded 8000ms", e);
            }
        }
        PlayerResponse playerResponse = (PlayerResponse) objWithTimeout;
        if (playerRequestKey != null) {
            navDeepLinkRequest2.getClass();
            ((LinkedHashMap) navDeepLinkRequest2.uri).put(playerRequestKey, playerResponse);
        }
        return playerResponse;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0200  */
    /* JADX WARN: Code duplicated, block: B:114:0x021f  */
    /* JADX WARN: Code duplicated, block: B:117:0x0227 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:124:0x023e  */
    /* JADX WARN: Code duplicated, block: B:128:0x0272  */
    /* JADX WARN: Code duplicated, block: B:129:0x027a  */
    /* JADX WARN: Code duplicated, block: B:131:0x0283  */
    /* JADX WARN: Code duplicated, block: B:132:0x028a  */
    /* JADX WARN: Code duplicated, block: B:133:0x0291  */
    /* JADX WARN: Code duplicated, block: B:135:0x0297  */
    /* JADX WARN: Code duplicated, block: B:143:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:145:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:146:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:148:0x02db  */
    /* JADX WARN: Code duplicated, block: B:151:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:153:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:154:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:156:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:159:0x02ff A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:160:0x0301  */
    /* JADX WARN: Code duplicated, block: B:161:0x0304  */
    /* JADX WARN: Code duplicated, block: B:163:0x0308  */
    /* JADX WARN: Code duplicated, block: B:165:0x030c  */
    /* JADX WARN: Code duplicated, block: B:166:0x030f  */
    /* JADX WARN: Code duplicated, block: B:169:0x0314  */
    /* JADX WARN: Code duplicated, block: B:172:0x032b  */
    /* JADX WARN: Code duplicated, block: B:173:0x032d  */
    /* JADX WARN: Code duplicated, block: B:176:0x0338  */
    /* JADX WARN: Code duplicated, block: B:187:0x0364  */
    /* JADX WARN: Code duplicated, block: B:188:0x0366  */
    /* JADX WARN: Code duplicated, block: B:191:0x0371  */
    /* JADX WARN: Code duplicated, block: B:193:0x037b  */
    /* JADX WARN: Code duplicated, block: B:195:0x0381  */
    /* JADX WARN: Code duplicated, block: B:207:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:209:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:212:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:214:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:223:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:224:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:227:0x0403  */
    /* JADX WARN: Code duplicated, block: B:229:0x040f  */
    /* JADX WARN: Code duplicated, block: B:231:0x0415  */
    /* JADX WARN: Code duplicated, block: B:243:0x0438  */
    /* JADX WARN: Code duplicated, block: B:244:0x043b  */
    /* JADX WARN: Code duplicated, block: B:246:0x043f  */
    /* JADX WARN: Code duplicated, block: B:251:0x044a  */
    /* JADX WARN: Code duplicated, block: B:254:0x045e  */
    /* JADX WARN: Code duplicated, block: B:255:0x0461  */
    /* JADX WARN: Code duplicated, block: B:257:0x0465  */
    /* JADX WARN: Code duplicated, block: B:262:0x0470  */
    /* JADX WARN: Code duplicated, block: B:265:0x0484  */
    /* JADX WARN: Code duplicated, block: B:266:0x0487  */
    /* JADX WARN: Code duplicated, block: B:268:0x048b  */
    /* JADX WARN: Code duplicated, block: B:273:0x0496  */
    /* JADX WARN: Code duplicated, block: B:276:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:281:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:283:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:288:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:290:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:293:0x0502  */
    /* JADX WARN: Code duplicated, block: B:294:0x0504  */
    /* JADX WARN: Code duplicated, block: B:298:0x053d  */
    /* JADX WARN: Code duplicated, block: B:300:0x0229 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:304:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:313:0x03de A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:325:0x0342 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:330:0x0332 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:333:0x014f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:335:0x017c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:70:0x0153  */
    /* JADX WARN: Code duplicated, block: B:73:0x015d  */
    /* JADX WARN: Code duplicated, block: B:75:0x016d  */
    /* JADX WARN: Code duplicated, block: B:76:0x0170  */
    /* JADX WARN: Code duplicated, block: B:78:0x0174  */
    /* JADX WARN: Code duplicated, block: B:82:0x0180  */
    /* JADX WARN: Code duplicated, block: B:85:0x018a  */
    /* JADX WARN: Code duplicated, block: B:87:0x0196  */
    /* JADX WARN: Code duplicated, block: B:88:0x0199  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v26, types: [java.lang.Iterable, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r14v33 */
    /* JADX WARN: Type inference failed for: r14v35 */
    /* JADX WARN: Type inference failed for: r16v1, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r16v4, types: [java.lang.Iterable, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v64 */
    /* JADX WARN: Type inference failed for: r5v65 */
    /* JADX WARN: Type inference failed for: r5v66 */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Iterable, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public final Object requestPlayerWithoutTimeout(YouTubeClient youTubeClient, String str, Integer num, String str2, InnerTube.SessionSnapshot sessionSnapshot, String str3, ContinuationImpl continuationImpl) throws Throwable {
        C01261 c01261;
        YouTubeClient youTubeClient2;
        String str4;
        String str5;
        long j;
        YouTubeClient youTubeClient3;
        String str6;
        String str7;
        YouTubeClient youTubeClient4;
        long j2;
        boolean z;
        JsonImpl jsonImpl;
        Object failure;
        JsonObject jsonObject;
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0;
        ?? r16;
        long j3;
        Throwable th;
        Object failure2;
        PlayerResponse playerResponse;
        PlayerResponse.StreamingData streamingData;
        PlayerResponse.VideoDetails videoDetails;
        boolean zEquals;
        long epochMilliseconds;
        int size;
        ?? r9;
        int size2;
        long j4;
        Map mapMapOf;
        boolean z2;
        ?? r8;
        Object obj;
        Iterator it;
        int i;
        String str8;
        int i2;
        String str9;
        String str10;
        Iterator it2;
        int i3;
        String str11;
        Iterator it3;
        int i4;
        String str12;
        String str13;
        ?? r5;
        boolean z3;
        ?? r6;
        boolean z4;
        ?? r7;
        boolean z5;
        PlayerResponse.PlayerConfig playerConfig;
        ?? r3;
        boolean z6;
        PlayerResponse.PlayerConfig.MediaCommonConfig mediaCommonConfig;
        PlayerResponse.PlayerConfig.MediaCommonConfig.MediaUstreamerRequestConfig mediaUstreamerRequestConfig;
        String str14;
        String str15;
        String str16;
        String str17;
        List list;
        List list2;
        List list3;
        String str18;
        Object obj2;
        Object failure3;
        Map mapMapOf2;
        List listListOf;
        Iterator it4;
        Object obj3;
        ?? r14;
        Iterator it5;
        JsonElement jsonElement;
        JsonObject jsonObject2;
        JsonArray jsonArray;
        if (continuationImpl instanceof C01261) {
            c01261 = (C01261) continuationImpl;
            int i5 = c01261.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c01261.label = i5 - Integer.MIN_VALUE;
            } else {
                c01261 = new C01261(continuationImpl);
            }
        } else {
            c01261 = new C01261(continuationImpl);
        }
        C01261 c01262 = c01261;
        Object objWithSessionBoundRequest = c01262.result;
        int i6 = c01262.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i6 == 0) {
            ResultKt.throwOnFailure(objWithSessionBoundRequest);
            long epochMilliseconds2 = InstantJvmKt.systemClock.now().toEpochMilliseconds();
            String str19 = sessionSnapshot.visitorData;
            c01262.L$0 = youTubeClient;
            c01262.L$1 = str;
            c01262.L$6 = null;
            c01262.J$0 = epochMilliseconds2;
            c01262.label = 2;
            InnerTube innerTube = this.innerTube;
            innerTube.getClass();
            objWithSessionBoundRequest = innerTube.withSessionBoundRequest(sessionSnapshot, new InnerTube$playerWithSessionBound$3(innerTube, youTubeClient, str, num, str2, str19, sessionSnapshot, str3, null), c01262);
            if (objWithSessionBoundRequest != coroutineSingletons) {
                youTubeClient2 = youTubeClient;
                str4 = str;
                str5 = null;
                j = epochMilliseconds2;
            }
            return coroutineSingletons;
        }
        if (i6 != 1) {
            if (i6 == 2) {
                j = c01262.J$0;
                str5 = c01262.L$6;
                str4 = c01262.L$1;
                youTubeClient2 = c01262.L$0;
                ResultKt.throwOnFailure(objWithSessionBoundRequest);
            } else {
                if (i6 != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                j = c01262.J$0;
                str5 = c01262.L$6;
                str4 = c01262.L$1;
                youTubeClient3 = c01262.L$0;
                ResultKt.throwOnFailure(objWithSessionBoundRequest);
            }
            str6 = (String) objWithSessionBoundRequest;
        } else {
            j = c01262.J$0;
            str5 = c01262.L$6;
            str4 = c01262.L$1;
            youTubeClient3 = c01262.L$0;
            ResultKt.throwOnFailure(objWithSessionBoundRequest);
            str6 = (String) objWithSessionBoundRequest;
            if (str6 == null) {
                return null;
            }
        }
        str7 = str6;
        youTubeClient4 = youTubeClient3;
        j2 = j;
        if (str5 != null) {
            z = true;
        } else {
            z = false;
        }
        jsonImpl = this.json;
        if (z) {
            try {
                failure = JsonElementKt.getJsonObject(jsonImpl.parseToJsonElement(str7));
            } catch (Throwable th2) {
                failure = new Result.Failure(th2);
            }
            if (failure instanceof Result.Failure) {
                failure = null;
            }
            jsonObject = (JsonObject) failure;
        } else {
            jsonObject = null;
        }
        pathKt$$ExternalSyntheticBUOutline0 = this.logger;
        r16 = EmptyList.INSTANCE;
        if (z || jsonObject == null) {
            j3 = j2;
            th = null;
            try {
                failure2 = (PlayerResponse) jsonImpl.decodeFromString(PlayerResponse.INSTANCE.serializer(), str7);
            } catch (Throwable th3) {
                failure2 = new Result.Failure(th3);
            }
            if (failure2 instanceof Result.Failure) {
                failure2 = th;
            }
            playerResponse = (PlayerResponse) failure2;
            if (playerResponse == null) {
                if (jsonObject == null) {
                    try {
                        failure3 = JsonElementKt.getJsonObject(jsonImpl.parseToJsonElement(str7));
                    } catch (Throwable th4) {
                        failure3 = new Result.Failure(th4);
                    }
                    if (failure3 instanceof Result.Failure) {
                        failure3 = th;
                    }
                    jsonObject = (JsonObject) failure3;
                }
                mapMapOf2 = MapsKt__MapsKt.mapOf(new Pair("client", youTubeClient4.clientName), new Pair("httpStatus", "200"), new Pair("elapsedMs", String.valueOf(InstantJvmKt.systemClock.now().toEpochMilliseconds() - j3)));
                if (jsonObject == null) {
                    EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "invalid player response", mapMapOf2, 4);
                } else if (jsonObject.containsKey("playabilityStatus")) {
                    EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "player response decode failed", mapMapOf2, 4);
                } else {
                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "player response missing status", mapMapOf2, 4);
                }
            } else {
                streamingData = playerResponse.streamingData;
                videoDetails = playerResponse.videoDetails;
                if (videoDetails != null || (str18 = videoDetails.videoId) == null) {
                    zEquals = true;
                } else {
                    if (StringsKt.isBlank(str18)) {
                        obj2 = str18;
                        obj2 = th;
                    }
                    if (obj2 != null) {
                        zEquals = obj2.equals(str4);
                    } else {
                        zEquals = true;
                    }
                }
                if (zEquals) {
                    epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds() - j3;
                    if (streamingData != null || (list3 = streamingData.formats) == null) {
                        size = 0;
                    } else {
                        size = list3.size();
                    }
                    if (streamingData != null) {
                        list2 = streamingData.adaptiveFormats;
                    } else {
                        r9 = th;
                    }
                    if (r9 == 0) {
                        r9 = list2;
                        r9 = r16;
                    }
                    r9 = list2;
                    size2 = r9.size() + size;
                    if (TRANSPORT_PROBE_CLIENT_NAMES.contains(youTubeClient4.clientName)) {
                        if (streamingData != null) {
                            list = streamingData.adaptiveFormats;
                        } else {
                            r8 = th;
                        }
                        if (r8 == 0) {
                            r8 = list;
                            r8 = r16;
                        }
                        if (streamingData != null) {
                            obj = streamingData.formats;
                        } else {
                            obj = th;
                        }
                        if (obj != null) {
                            r16 = obj;
                        }
                        Pair pair = new Pair("adaptiveFormatCount", String.valueOf(r8.size()));
                        if (r8.isEmpty()) {
                            i = 0;
                        } else {
                            it = r8.iterator();
                            i = 0;
                            while (it.hasNext()) {
                                str8 = ((PlayerResponse.StreamingData.Format) it.next()).url;
                                if (str8 == null && (!StringsKt.isBlank(str8)) && (i = i + 1) < 0) {
                                    CollectionsKt__IterablesKt.throwCountOverflow();
                                    throw th;
                                }
                            }
                        }
                        Pair pair2 = new Pair("adaptiveDirectCount", String.valueOf(i));
                        if (r8.isEmpty()) {
                            i2 = 0;
                        } else {
                            i2 = 0;
                            for (PlayerResponse.StreamingData.Format format : r8) {
                                str9 = format.signatureCipher;
                                if ((str9 == null && !StringsKt.isBlank(str9)) || ((str10 = format.cipher) != null && !StringsKt.isBlank(str10))) {
                                    i2++;
                                    if (i2 < 0) {
                                        CollectionsKt__IterablesKt.throwCountOverflow();
                                        throw th;
                                    }
                                }
                            }
                        }
                        Pair pair3 = new Pair("adaptiveCipherCount", String.valueOf(i2));
                        Pair pair4 = new Pair("progressiveFormatCount", String.valueOf(r16.size()));
                        if (r16.isEmpty()) {
                            i3 = 0;
                        } else {
                            it2 = r16.iterator();
                            i3 = 0;
                            while (it2.hasNext()) {
                                long j5 = epochMilliseconds;
                                str11 = ((PlayerResponse.StreamingData.Format) it2.next()).url;
                                if (str11 == null && (!StringsKt.isBlank(str11)) && (i3 = i3 + 1) < 0) {
                                    CollectionsKt__IterablesKt.throwCountOverflow();
                                    throw th;
                                }
                                epochMilliseconds = j5;
                            }
                        }
                        j4 = epochMilliseconds;
                        Pair pair5 = new Pair("progressiveDirectCount", String.valueOf(i3));
                        if (r16.isEmpty()) {
                            i4 = 0;
                        } else {
                            it3 = r16.iterator();
                            i4 = 0;
                            while (it3.hasNext()) {
                                PlayerResponse.StreamingData.Format format2 = (PlayerResponse.StreamingData.Format) it3.next();
                                Iterator it6 = it3;
                                str12 = format2.signatureCipher;
                                if (((str12 == null && !StringsKt.isBlank(str12)) || ((str13 = format2.cipher) != null && !StringsKt.isBlank(str13))) && (i4 = i4 + 1) < 0) {
                                    CollectionsKt__IterablesKt.throwCountOverflow();
                                    throw th;
                                }
                                it3 = it6;
                            }
                        }
                        Pair pair6 = new Pair("progressiveCipherCount", String.valueOf(i4));
                        if (streamingData != null) {
                            str17 = streamingData.hlsManifestUrl;
                        } else {
                            r5 = th;
                        }
                        if (r5 != 0 || StringsKt.isBlank(r5)) {
                            r5 = str17;
                            r5 = str17;
                            z3 = true;
                        } else {
                            r5 = str17;
                            z3 = false;
                        }
                        Pair pair7 = new Pair("hlsPresent", String.valueOf(!z3));
                        if (streamingData != null) {
                            str16 = streamingData.dashManifestUrl;
                        } else {
                            r6 = th;
                        }
                        if (r6 != 0 || StringsKt.isBlank(r6)) {
                            r6 = str16;
                            r6 = str16;
                            z4 = true;
                        } else {
                            r6 = str16;
                            z4 = false;
                        }
                        Pair pair8 = new Pair("dashPresent", String.valueOf(!z4));
                        if (streamingData != null) {
                            str15 = streamingData.serverAbrStreamingUrl;
                        } else {
                            r7 = th;
                        }
                        if (r7 != 0 || StringsKt.isBlank(r7)) {
                            r7 = str15;
                            r7 = str15;
                            z5 = true;
                        } else {
                            r7 = str15;
                            z5 = false;
                        }
                        Pair pair9 = new Pair("sabrPresent", String.valueOf(!z5));
                        playerConfig = playerResponse.playerConfig;
                        if (playerConfig != null || (mediaCommonConfig = playerConfig.mediaCommonConfig) == null || (mediaUstreamerRequestConfig = mediaCommonConfig.mediaUstreamerRequestConfig) == null) {
                            r3 = th;
                        } else {
                            str14 = mediaUstreamerRequestConfig.videoPlaybackUstreamerConfig;
                        }
                        if (r3 != 0 || StringsKt.isBlank(r3)) {
                            r3 = str14;
                            r3 = str14;
                            z6 = true;
                        } else {
                            r3 = str14;
                            z6 = false;
                        }
                        mapMapOf = MapsKt__MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, new Pair("sabrConfigPresent", String.valueOf(!z6)));
                    } else {
                        j4 = epochMilliseconds;
                        mapMapOf = EmptyMap.INSTANCE;
                    }
                    Pair pair10 = new Pair("client", youTubeClient4.clientName);
                    if (streamingData != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "player response decoded", MapsKt__MapsKt.plus(MapsKt__MapsKt.mapOf(pair10, new Pair("streamingPresent", String.valueOf(z2)), new Pair("formatCount", String.valueOf(size2)), new Pair("elapsedMs", String.valueOf(j4))), mapMapOf), 4);
                    if (size2 <= 2048) {
                        return playerResponse;
                    }
                } else {
                    EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "player response rejected", MapsKt__MapsKt.mapOf(new Pair("client", youTubeClient4.clientName), new Pair("reason", "video_identity")), 4);
                }
            }
        } else {
            Object obj4 = jsonObject.get("streamingData");
            JsonObject jsonObject3 = obj4 instanceof JsonObject ? (JsonObject) obj4 : null;
            if (jsonObject3 == null) {
                j3 = j2;
                th = null;
            } else {
                Set set = KNOWN_DRM_KEYS;
                th = null;
                boolean z7 = set instanceof Collection;
                if (z7 && set.isEmpty()) {
                    listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"formats", "adaptiveFormats"});
                    if (!listListOf.isEmpty()) {
                        it4 = listListOf.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                obj3 = jsonObject3.get((String) it4.next());
                                JsonObject jsonObject4 = jsonObject3;
                                if (obj3 instanceof JsonArray) {
                                    jsonArray = (JsonArray) obj3;
                                } else {
                                    r14 = 0;
                                }
                                if (r14 == 0) {
                                    r14 = jsonArray;
                                    r14 = r16;
                                }
                                r14 = jsonArray;
                                if (!r14.isEmpty()) {
                                    it5 = r14.iterator();
                                    while (true) {
                                        if (it5.hasNext()) {
                                            jsonElement = (JsonElement) it5.next();
                                            Iterator it7 = it5;
                                            if (jsonElement instanceof JsonObject) {
                                                jsonObject2 = (JsonObject) jsonElement;
                                            } else {
                                                jsonObject2 = null;
                                            }
                                            if (jsonObject2 == null) {
                                            }
                                            it5 = it7;
                                            j2 = j2;
                                        }
                                    }
                                }
                                jsonObject3 = jsonObject4;
                                j2 = j2;
                            }
                        }
                    }
                    j3 = j2;
                } else {
                    Iterator it8 = set.iterator();
                    while (true) {
                        if (it8.hasNext()) {
                            JsonElement jsonElementKnownDrmValue = knownDrmValue(jsonObject3, (String) it8.next());
                            if (jsonElementKnownDrmValue == null || !hasDrmValue(jsonElementKnownDrmValue)) {
                            }
                        } else {
                            listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"formats", "adaptiveFormats"});
                            if (!listListOf.isEmpty()) {
                                it4 = listListOf.iterator();
                                while (true) {
                                    if (it4.hasNext()) {
                                        obj3 = jsonObject3.get((String) it4.next());
                                        JsonObject jsonObject5 = jsonObject3;
                                        if (obj3 instanceof JsonArray) {
                                            jsonArray = (JsonArray) obj3;
                                        } else {
                                            r14 = 0;
                                        }
                                        if (r14 == 0) {
                                            r14 = jsonArray;
                                            r14 = r16;
                                        }
                                        r14 = jsonArray;
                                        if (!r14.isEmpty()) {
                                            it5 = r14.iterator();
                                            while (true) {
                                                if (it5.hasNext()) {
                                                    jsonElement = (JsonElement) it5.next();
                                                    Iterator it9 = it5;
                                                    if (jsonElement instanceof JsonObject) {
                                                        jsonObject2 = (JsonObject) jsonElement;
                                                    } else {
                                                        jsonObject2 = null;
                                                    }
                                                    if (jsonObject2 == null && (!z7 || !set.isEmpty())) {
                                                        Iterator it10 = set.iterator();
                                                        while (true) {
                                                            if (it10.hasNext()) {
                                                                Iterator it11 = it10;
                                                                JsonElement jsonElementKnownDrmValue2 = knownDrmValue(jsonObject2, (String) it10.next());
                                                                if (jsonElementKnownDrmValue2 != null && hasDrmValue(jsonElementKnownDrmValue2)) {
                                                                }
                                                                it10 = it11;
                                                                j2 = j2;
                                                            } else {
                                                                continue;
                                                            }
                                                        }
                                                    }
                                                    it5 = it9;
                                                    j2 = j2;
                                                }
                                            }
                                        }
                                        jsonObject3 = jsonObject5;
                                        j2 = j2;
                                    }
                                }
                            }
                            j3 = j2;
                        }
                    }
                }
                EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "bearer player response rejected", MapsKt__MapsKt.mapOf(new Pair("client", youTubeClient4.clientName), new Pair("reason", "drm")), 4);
            }
            failure2 = (PlayerResponse) jsonImpl.decodeFromString(PlayerResponse.INSTANCE.serializer(), str7);
            if (failure2 instanceof Result.Failure) {
                failure2 = th;
            }
            playerResponse = (PlayerResponse) failure2;
            if (playerResponse == null) {
                if (jsonObject == null) {
                    failure3 = JsonElementKt.getJsonObject(jsonImpl.parseToJsonElement(str7));
                    if (failure3 instanceof Result.Failure) {
                        failure3 = th;
                    }
                    jsonObject = (JsonObject) failure3;
                }
                mapMapOf2 = MapsKt__MapsKt.mapOf(new Pair("client", youTubeClient4.clientName), new Pair("httpStatus", "200"), new Pair("elapsedMs", String.valueOf(InstantJvmKt.systemClock.now().toEpochMilliseconds() - j3)));
                if (jsonObject == null) {
                    EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "invalid player response", mapMapOf2, 4);
                } else if (jsonObject.containsKey("playabilityStatus")) {
                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "player response missing status", mapMapOf2, 4);
                } else {
                    EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "player response decode failed", mapMapOf2, 4);
                }
            } else {
                streamingData = playerResponse.streamingData;
                videoDetails = playerResponse.videoDetails;
                if (videoDetails != null) {
                    zEquals = true;
                } else {
                    zEquals = true;
                }
                if (zEquals) {
                    EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "player response rejected", MapsKt__MapsKt.mapOf(new Pair("client", youTubeClient4.clientName), new Pair("reason", "video_identity")), 4);
                } else {
                    epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds() - j3;
                    if (streamingData != null) {
                        size = 0;
                    } else {
                        size = 0;
                    }
                    if (streamingData != null) {
                        list2 = streamingData.adaptiveFormats;
                    } else {
                        r9 = th;
                    }
                    if (r9 == 0) {
                        r9 = list2;
                        r9 = r16;
                    }
                    r9 = list2;
                    size2 = r9.size() + size;
                    if (TRANSPORT_PROBE_CLIENT_NAMES.contains(youTubeClient4.clientName)) {
                        if (streamingData != null) {
                            list = streamingData.adaptiveFormats;
                        } else {
                            r8 = th;
                        }
                        if (r8 == 0) {
                            r8 = list;
                            r8 = r16;
                        }
                        if (streamingData != null) {
                            obj = streamingData.formats;
                        } else {
                            obj = th;
                        }
                        if (obj != null) {
                            r16 = obj;
                        }
                        Pair pair11 = new Pair("adaptiveFormatCount", String.valueOf(r8.size()));
                        if (r8.isEmpty()) {
                            i = 0;
                        } else {
                            it = r8.iterator();
                            i = 0;
                            while (it.hasNext()) {
                                str8 = ((PlayerResponse.StreamingData.Format) it.next()).url;
                                if (str8 == null) {
                                }
                            }
                        }
                        Pair pair12 = new Pair("adaptiveDirectCount", String.valueOf(i));
                        if (r8.isEmpty()) {
                            i2 = 0;
                        } else {
                            i2 = 0;
                            while (r8.hasNext()) {
                                str9 = format.signatureCipher;
                                if (str9 == null) {
                                }
                            }
                        }
                        Pair pair13 = new Pair("adaptiveCipherCount", String.valueOf(i2));
                        Pair pair14 = new Pair("progressiveFormatCount", String.valueOf(r16.size()));
                        if (r16.isEmpty()) {
                            i3 = 0;
                        } else {
                            it2 = r16.iterator();
                            i3 = 0;
                            while (it2.hasNext()) {
                                long j6 = epochMilliseconds;
                                str11 = ((PlayerResponse.StreamingData.Format) it2.next()).url;
                                if (str11 == null) {
                                }
                                epochMilliseconds = j6;
                            }
                        }
                        j4 = epochMilliseconds;
                        Pair pair15 = new Pair("progressiveDirectCount", String.valueOf(i3));
                        if (r16.isEmpty()) {
                            i4 = 0;
                        } else {
                            it3 = r16.iterator();
                            i4 = 0;
                            while (it3.hasNext()) {
                                PlayerResponse.StreamingData.Format format3 = (PlayerResponse.StreamingData.Format) it3.next();
                                Iterator it12 = it3;
                                str12 = format3.signatureCipher;
                                if (str12 == null) {
                                }
                                it3 = it12;
                            }
                        }
                        Pair pair16 = new Pair("progressiveCipherCount", String.valueOf(i4));
                        if (streamingData != null) {
                            str17 = streamingData.hlsManifestUrl;
                        } else {
                            r5 = th;
                        }
                        if (r5 != 0) {
                            r5 = str17;
                            r5 = str17;
                            z3 = true;
                        } else {
                            r5 = str17;
                            r5 = str17;
                            z3 = true;
                        }
                        Pair pair17 = new Pair("hlsPresent", String.valueOf(!z3));
                        if (streamingData != null) {
                            str16 = streamingData.dashManifestUrl;
                        } else {
                            r6 = th;
                        }
                        if (r6 != 0) {
                            r6 = str16;
                            r6 = str16;
                            z4 = true;
                        } else {
                            r6 = str16;
                            r6 = str16;
                            z4 = true;
                        }
                        Pair pair18 = new Pair("dashPresent", String.valueOf(!z4));
                        if (streamingData != null) {
                            str15 = streamingData.serverAbrStreamingUrl;
                        } else {
                            r7 = th;
                        }
                        if (r7 != 0) {
                            r7 = str15;
                            r7 = str15;
                            z5 = true;
                        } else {
                            r7 = str15;
                            r7 = str15;
                            z5 = true;
                        }
                        Pair pair19 = new Pair("sabrPresent", String.valueOf(!z5));
                        playerConfig = playerResponse.playerConfig;
                        if (playerConfig != null) {
                            r3 = th;
                        } else {
                            r3 = th;
                        }
                        if (r3 != 0) {
                            r3 = str14;
                            r3 = str14;
                            z6 = true;
                        } else {
                            r3 = str14;
                            r3 = str14;
                            z6 = true;
                        }
                        mapMapOf = MapsKt__MapsKt.mapOf(pair11, pair12, pair13, pair14, pair15, pair16, pair17, pair18, pair19, new Pair("sabrConfigPresent", String.valueOf(!z6)));
                    } else {
                        j4 = epochMilliseconds;
                        mapMapOf = EmptyMap.INSTANCE;
                    }
                    Pair pair110 = new Pair("client", youTubeClient4.clientName);
                    if (streamingData != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "player response decoded", MapsKt__MapsKt.plus(MapsKt__MapsKt.mapOf(pair110, new Pair("streamingPresent", String.valueOf(z2)), new Pair("formatCount", String.valueOf(size2)), new Pair("elapsedMs", String.valueOf(j4))), mapMapOf), 4);
                    if (size2 <= 2048) {
                        return playerResponse;
                    }
                }
            }
        }
        return th;
        c01262.L$0 = youTubeClient2;
        c01262.L$1 = str4;
        c01262.L$6 = str5;
        c01262.J$0 = j;
        c01262.label = 3;
        objWithSessionBoundRequest = CollectionsKt__IterablesKt.bodyAsTextLimited((HttpResponse) objWithSessionBoundRequest, 4194304, null, c01262);
        if (objWithSessionBoundRequest != coroutineSingletons) {
            youTubeClient3 = youTubeClient2;
            str6 = (String) objWithSessionBoundRequest;
            str7 = str6;
            youTubeClient4 = youTubeClient3;
            j2 = j;
            if (str5 != null) {
                z = true;
            } else {
                z = false;
            }
            jsonImpl = this.json;
            if (z) {
                failure = JsonElementKt.getJsonObject(jsonImpl.parseToJsonElement(str7));
                if (failure instanceof Result.Failure) {
                    failure = null;
                }
                jsonObject = (JsonObject) failure;
            } else {
                jsonObject = null;
            }
            pathKt$$ExternalSyntheticBUOutline0 = this.logger;
            r16 = EmptyList.INSTANCE;
            if (z) {
                j3 = j2;
                th = null;
                failure2 = (PlayerResponse) jsonImpl.decodeFromString(PlayerResponse.INSTANCE.serializer(), str7);
                if (failure2 instanceof Result.Failure) {
                    failure2 = th;
                }
                playerResponse = (PlayerResponse) failure2;
                if (playerResponse == null) {
                    if (jsonObject == null) {
                        failure3 = JsonElementKt.getJsonObject(jsonImpl.parseToJsonElement(str7));
                        if (failure3 instanceof Result.Failure) {
                            failure3 = th;
                        }
                        jsonObject = (JsonObject) failure3;
                    }
                    mapMapOf2 = MapsKt__MapsKt.mapOf(new Pair("client", youTubeClient4.clientName), new Pair("httpStatus", "200"), new Pair("elapsedMs", String.valueOf(InstantJvmKt.systemClock.now().toEpochMilliseconds() - j3)));
                    if (jsonObject == null) {
                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "invalid player response", mapMapOf2, 4);
                    } else if (jsonObject.containsKey("playabilityStatus")) {
                        EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "player response missing status", mapMapOf2, 4);
                    } else {
                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "player response decode failed", mapMapOf2, 4);
                    }
                } else {
                    streamingData = playerResponse.streamingData;
                    videoDetails = playerResponse.videoDetails;
                    if (videoDetails != null) {
                        zEquals = true;
                    } else {
                        zEquals = true;
                    }
                    if (zEquals) {
                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "player response rejected", MapsKt__MapsKt.mapOf(new Pair("client", youTubeClient4.clientName), new Pair("reason", "video_identity")), 4);
                    } else {
                        epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds() - j3;
                        if (streamingData != null) {
                            size = 0;
                        } else {
                            size = 0;
                        }
                        if (streamingData != null) {
                            list2 = streamingData.adaptiveFormats;
                        } else {
                            r9 = th;
                        }
                        if (r9 == 0) {
                            r9 = list2;
                            r9 = r16;
                        }
                        r9 = list2;
                        size2 = r9.size() + size;
                        if (TRANSPORT_PROBE_CLIENT_NAMES.contains(youTubeClient4.clientName)) {
                            if (streamingData != null) {
                                list = streamingData.adaptiveFormats;
                            } else {
                                r8 = th;
                            }
                            if (r8 == 0) {
                                r8 = list;
                                r8 = r16;
                            }
                            if (streamingData != null) {
                                obj = streamingData.formats;
                            } else {
                                obj = th;
                            }
                            if (obj != null) {
                                r16 = obj;
                            }
                            Pair pair111 = new Pair("adaptiveFormatCount", String.valueOf(r8.size()));
                            if (r8.isEmpty()) {
                                i = 0;
                            } else {
                                it = r8.iterator();
                                i = 0;
                                while (it.hasNext()) {
                                    str8 = ((PlayerResponse.StreamingData.Format) it.next()).url;
                                    if (str8 == null) {
                                    }
                                }
                            }
                            Pair pair112 = new Pair("adaptiveDirectCount", String.valueOf(i));
                            if (r8.isEmpty()) {
                                i2 = 0;
                            } else {
                                i2 = 0;
                                while (r8.hasNext()) {
                                    str9 = format.signatureCipher;
                                    if (str9 == null) {
                                    }
                                }
                            }
                            Pair pair113 = new Pair("adaptiveCipherCount", String.valueOf(i2));
                            Pair pair114 = new Pair("progressiveFormatCount", String.valueOf(r16.size()));
                            if (r16.isEmpty()) {
                                i3 = 0;
                            } else {
                                it2 = r16.iterator();
                                i3 = 0;
                                while (it2.hasNext()) {
                                    long j7 = epochMilliseconds;
                                    str11 = ((PlayerResponse.StreamingData.Format) it2.next()).url;
                                    if (str11 == null) {
                                    }
                                    epochMilliseconds = j7;
                                }
                            }
                            j4 = epochMilliseconds;
                            Pair pair115 = new Pair("progressiveDirectCount", String.valueOf(i3));
                            if (r16.isEmpty()) {
                                i4 = 0;
                            } else {
                                it3 = r16.iterator();
                                i4 = 0;
                                while (it3.hasNext()) {
                                    PlayerResponse.StreamingData.Format format4 = (PlayerResponse.StreamingData.Format) it3.next();
                                    Iterator it13 = it3;
                                    str12 = format4.signatureCipher;
                                    if (str12 == null) {
                                    }
                                    it3 = it13;
                                }
                            }
                            Pair pair116 = new Pair("progressiveCipherCount", String.valueOf(i4));
                            if (streamingData != null) {
                                str17 = streamingData.hlsManifestUrl;
                            } else {
                                r5 = th;
                            }
                            if (r5 != 0) {
                                r5 = str17;
                                r5 = str17;
                                z3 = true;
                            } else {
                                r5 = str17;
                                r5 = str17;
                                z3 = true;
                            }
                            Pair pair117 = new Pair("hlsPresent", String.valueOf(!z3));
                            if (streamingData != null) {
                                str16 = streamingData.dashManifestUrl;
                            } else {
                                r6 = th;
                            }
                            if (r6 != 0) {
                                r6 = str16;
                                r6 = str16;
                                z4 = true;
                            } else {
                                r6 = str16;
                                r6 = str16;
                                z4 = true;
                            }
                            Pair pair118 = new Pair("dashPresent", String.valueOf(!z4));
                            if (streamingData != null) {
                                str15 = streamingData.serverAbrStreamingUrl;
                            } else {
                                r7 = th;
                            }
                            if (r7 != 0) {
                                r7 = str15;
                                r7 = str15;
                                z5 = true;
                            } else {
                                r7 = str15;
                                r7 = str15;
                                z5 = true;
                            }
                            Pair pair119 = new Pair("sabrPresent", String.valueOf(!z5));
                            playerConfig = playerResponse.playerConfig;
                            if (playerConfig != null) {
                                r3 = th;
                            } else {
                                r3 = th;
                            }
                            if (r3 != 0) {
                                r3 = str14;
                                r3 = str14;
                                z6 = true;
                            } else {
                                r3 = str14;
                                r3 = str14;
                                z6 = true;
                            }
                            mapMapOf = MapsKt__MapsKt.mapOf(pair111, pair112, pair113, pair114, pair115, pair116, pair117, pair118, pair119, new Pair("sabrConfigPresent", String.valueOf(!z6)));
                        } else {
                            j4 = epochMilliseconds;
                            mapMapOf = EmptyMap.INSTANCE;
                        }
                        Pair pair1110 = new Pair("client", youTubeClient4.clientName);
                        if (streamingData != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "player response decoded", MapsKt__MapsKt.plus(MapsKt__MapsKt.mapOf(pair1110, new Pair("streamingPresent", String.valueOf(z2)), new Pair("formatCount", String.valueOf(size2)), new Pair("elapsedMs", String.valueOf(j4))), mapMapOf), 4);
                        if (size2 <= 2048) {
                            return playerResponse;
                        }
                    }
                }
            } else {
                j3 = j2;
                th = null;
                failure2 = (PlayerResponse) jsonImpl.decodeFromString(PlayerResponse.INSTANCE.serializer(), str7);
                if (failure2 instanceof Result.Failure) {
                    failure2 = th;
                }
                playerResponse = (PlayerResponse) failure2;
                if (playerResponse == null) {
                    if (jsonObject == null) {
                        failure3 = JsonElementKt.getJsonObject(jsonImpl.parseToJsonElement(str7));
                        if (failure3 instanceof Result.Failure) {
                            failure3 = th;
                        }
                        jsonObject = (JsonObject) failure3;
                    }
                    mapMapOf2 = MapsKt__MapsKt.mapOf(new Pair("client", youTubeClient4.clientName), new Pair("httpStatus", "200"), new Pair("elapsedMs", String.valueOf(InstantJvmKt.systemClock.now().toEpochMilliseconds() - j3)));
                    if (jsonObject == null) {
                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "invalid player response", mapMapOf2, 4);
                    } else if (jsonObject.containsKey("playabilityStatus")) {
                        EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "player response missing status", mapMapOf2, 4);
                    } else {
                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "player response decode failed", mapMapOf2, 4);
                    }
                } else {
                    streamingData = playerResponse.streamingData;
                    videoDetails = playerResponse.videoDetails;
                    if (videoDetails != null) {
                        zEquals = true;
                    } else {
                        zEquals = true;
                    }
                    if (zEquals) {
                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "player response rejected", MapsKt__MapsKt.mapOf(new Pair("client", youTubeClient4.clientName), new Pair("reason", "video_identity")), 4);
                    } else {
                        epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds() - j3;
                        if (streamingData != null) {
                            size = 0;
                        } else {
                            size = 0;
                        }
                        if (streamingData != null) {
                            list2 = streamingData.adaptiveFormats;
                        } else {
                            r9 = th;
                        }
                        if (r9 == 0) {
                            r9 = list2;
                            r9 = r16;
                        }
                        r9 = list2;
                        size2 = r9.size() + size;
                        if (TRANSPORT_PROBE_CLIENT_NAMES.contains(youTubeClient4.clientName)) {
                            if (streamingData != null) {
                                list = streamingData.adaptiveFormats;
                            } else {
                                r8 = th;
                            }
                            if (r8 == 0) {
                                r8 = list;
                                r8 = r16;
                            }
                            if (streamingData != null) {
                                obj = streamingData.formats;
                            } else {
                                obj = th;
                            }
                            if (obj != null) {
                                r16 = obj;
                            }
                            Pair pair1111 = new Pair("adaptiveFormatCount", String.valueOf(r8.size()));
                            if (r8.isEmpty()) {
                                i = 0;
                            } else {
                                it = r8.iterator();
                                i = 0;
                                while (it.hasNext()) {
                                    str8 = ((PlayerResponse.StreamingData.Format) it.next()).url;
                                    if (str8 == null) {
                                    }
                                }
                            }
                            Pair pair1112 = new Pair("adaptiveDirectCount", String.valueOf(i));
                            if (r8.isEmpty()) {
                                i2 = 0;
                            } else {
                                i2 = 0;
                                while (r8.hasNext()) {
                                    str9 = format.signatureCipher;
                                    if (str9 == null) {
                                    }
                                }
                            }
                            Pair pair1113 = new Pair("adaptiveCipherCount", String.valueOf(i2));
                            Pair pair1114 = new Pair("progressiveFormatCount", String.valueOf(r16.size()));
                            if (r16.isEmpty()) {
                                i3 = 0;
                            } else {
                                it2 = r16.iterator();
                                i3 = 0;
                                while (it2.hasNext()) {
                                    long j8 = epochMilliseconds;
                                    str11 = ((PlayerResponse.StreamingData.Format) it2.next()).url;
                                    if (str11 == null) {
                                    }
                                    epochMilliseconds = j8;
                                }
                            }
                            j4 = epochMilliseconds;
                            Pair pair1115 = new Pair("progressiveDirectCount", String.valueOf(i3));
                            if (r16.isEmpty()) {
                                i4 = 0;
                            } else {
                                it3 = r16.iterator();
                                i4 = 0;
                                while (it3.hasNext()) {
                                    PlayerResponse.StreamingData.Format format5 = (PlayerResponse.StreamingData.Format) it3.next();
                                    Iterator it14 = it3;
                                    str12 = format5.signatureCipher;
                                    if (str12 == null) {
                                    }
                                    it3 = it14;
                                }
                            }
                            Pair pair1116 = new Pair("progressiveCipherCount", String.valueOf(i4));
                            if (streamingData != null) {
                                str17 = streamingData.hlsManifestUrl;
                            } else {
                                r5 = th;
                            }
                            if (r5 != 0) {
                                r5 = str17;
                                r5 = str17;
                                z3 = true;
                            } else {
                                r5 = str17;
                                r5 = str17;
                                z3 = true;
                            }
                            Pair pair1117 = new Pair("hlsPresent", String.valueOf(!z3));
                            if (streamingData != null) {
                                str16 = streamingData.dashManifestUrl;
                            } else {
                                r6 = th;
                            }
                            if (r6 != 0) {
                                r6 = str16;
                                r6 = str16;
                                z4 = true;
                            } else {
                                r6 = str16;
                                r6 = str16;
                                z4 = true;
                            }
                            Pair pair1118 = new Pair("dashPresent", String.valueOf(!z4));
                            if (streamingData != null) {
                                str15 = streamingData.serverAbrStreamingUrl;
                            } else {
                                r7 = th;
                            }
                            if (r7 != 0) {
                                r7 = str15;
                                r7 = str15;
                                z5 = true;
                            } else {
                                r7 = str15;
                                r7 = str15;
                                z5 = true;
                            }
                            Pair pair1119 = new Pair("sabrPresent", String.valueOf(!z5));
                            playerConfig = playerResponse.playerConfig;
                            if (playerConfig != null) {
                                r3 = th;
                            } else {
                                r3 = th;
                            }
                            if (r3 != 0) {
                                r3 = str14;
                                r3 = str14;
                                z6 = true;
                            } else {
                                r3 = str14;
                                r3 = str14;
                                z6 = true;
                            }
                            mapMapOf = MapsKt__MapsKt.mapOf(pair1111, pair1112, pair1113, pair1114, pair1115, pair1116, pair1117, pair1118, pair1119, new Pair("sabrConfigPresent", String.valueOf(!z6)));
                        } else {
                            j4 = epochMilliseconds;
                            mapMapOf = EmptyMap.INSTANCE;
                        }
                        Pair pair11110 = new Pair("client", youTubeClient4.clientName);
                        if (streamingData != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "player response decoded", MapsKt__MapsKt.plus(MapsKt__MapsKt.mapOf(pair11110, new Pair("streamingPresent", String.valueOf(z2)), new Pair("formatCount", String.valueOf(size2)), new Pair("elapsedMs", String.valueOf(j4))), mapMapOf), 4);
                        if (size2 <= 2048) {
                            return playerResponse;
                        }
                    }
                }
            }
            return th;
        }
        return coroutineSingletons;
    }

    public final TokenPlan tokenPlan(SelectedClient selectedClient, boolean z) {
        PlaybackClientManifest playbackClientManifest = selectedClient.manifest;
        if (playbackClientManifest != null) {
            ClientPoTokenCapabilities clientPoTokenCapabilities = playbackClientManifest.poTokens;
            PoTokenRule poTokenRule = clientPoTokenCapabilities.player;
            PoTokenRule poTokenRule2 = clientPoTokenCapabilities.gvs;
            return new TokenPlan(tokenPlan$compatibleBinding(this, poTokenRule), tokenPlan$compatibleBinding(this, poTokenRule2), !isSatisfiedByPremium(clientPoTokenCapabilities.player, z), !isSatisfiedByPremium(poTokenRule2, z));
        }
        YouTubeClient youTubeClient = selectedClient.client;
        PoTokenBinding poTokenBinding = youTubeClient.poTokenBinding;
        boolean z2 = youTubeClient.useWebPoTokens;
        if (!z2) {
            poTokenBinding = null;
        }
        return new TokenPlan(poTokenBinding, z2 ? PoTokenBinding.VIDEO_ID : null, youTubeClient.requirePoToken, z2);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0231  */
    /* JADX WARN: Code duplicated, block: B:107:0x023e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x0240  */
    /* JADX WARN: Code duplicated, block: B:109:0x0243  */
    /* JADX WARN: Code duplicated, block: B:112:0x025c  */
    /* JADX WARN: Code duplicated, block: B:114:0x0264 A[Catch: Exception -> 0x012d, CancellationException -> 0x0392, TryCatch #2 {Exception -> 0x012d, blocks: (B:92:0x01f1, B:105:0x0238, B:110:0x0244, B:114:0x0264, B:116:0x026e, B:122:0x027e, B:126:0x02b6, B:134:0x02e2, B:97:0x01fe, B:100:0x0212, B:54:0x0124), top: B:173:0x0039 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0279  */
    /* JADX WARN: Code duplicated, block: B:126:0x02b6 A[Catch: Exception -> 0x012d, CancellationException -> 0x0392, TryCatch #2 {Exception -> 0x012d, blocks: (B:92:0x01f1, B:105:0x0238, B:110:0x0244, B:114:0x0264, B:116:0x026e, B:122:0x027e, B:126:0x02b6, B:134:0x02e2, B:97:0x01fe, B:100:0x0212, B:54:0x0124), top: B:173:0x0039 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:129:0x02db  */
    /* JADX WARN: Code duplicated, block: B:130:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:132:0x02df  */
    /* JADX WARN: Code duplicated, block: B:133:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:158:0x033a  */
    /* JADX WARN: Code duplicated, block: B:159:0x033d  */
    /* JADX WARN: Code duplicated, block: B:161:0x0340  */
    /* JADX WARN: Code duplicated, block: B:165:0x0349  */
    /* JADX WARN: Code duplicated, block: B:168:0x035e  */
    /* JADX WARN: Code duplicated, block: B:185:0x01c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0197 A[Catch: Exception -> 0x01a9, CancellationException -> 0x0392, TryCatch #4 {Exception -> 0x01a9, blocks: (B:70:0x0191, B:72:0x0197, B:76:0x01ad, B:90:0x01e0), top: B:178:0x0191 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x01ad A[Catch: Exception -> 0x01a9, CancellationException -> 0x0392, TRY_LEAVE, TryCatch #4 {Exception -> 0x01a9, blocks: (B:70:0x0191, B:72:0x0197, B:76:0x01ad, B:90:0x01e0), top: B:178:0x0191 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:8:0x0022  */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0312, code lost:
    
        if (r3 == r12) goto L141;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object tryPlayer(SelectedClient selectedClient, String str, PlayerConfig playerConfig, ContentHints contentHints, boolean z, boolean z2, boolean z3, InnerTube.SessionSnapshot sessionSnapshot, NavDeepLinkRequest navDeepLinkRequest, boolean z4, Deferred deferred, ContinuationImpl continuationImpl) throws IOException {
        C01271 c01271;
        String str2;
        boolean z5;
        PlaybackClientManifest playbackClientManifest;
        String str3;
        boolean z6;
        String strM;
        String str4;
        Deferred deferred2;
        boolean z7;
        InnerTube.SessionSnapshot sessionSnapshot2;
        NavDeepLinkRequest navDeepLinkRequest2;
        YouTubeClient youTubeClient;
        Object obj;
        boolean z8;
        TokenPlan tokenPlan;
        ContentHints contentHints2;
        boolean z9;
        String str5;
        PlayerConfig playerConfig2;
        PlayerResponse playerResponse;
        boolean zIsPlayable;
        String str6;
        NavDeepLinkRequest navDeepLinkRequest3;
        InnerTube.SessionSnapshot sessionSnapshot3;
        Deferred deferred3;
        PlayabilityFailure playabilityFailure;
        boolean z10;
        PlayerResponse playerResponse2;
        boolean z11;
        PlayabilityFailure playabilityFailure2;
        SelectedClient selectedClient2;
        Boolean bool;
        Boolean bool2;
        PlayabilityFailure playabilityFailure3;
        SelectedClient selectedClient3 = selectedClient;
        boolean z12 = z3;
        if (continuationImpl instanceof C01271) {
            c01271 = (C01271) continuationImpl;
            int i = c01271.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01271.label = i - Integer.MIN_VALUE;
            } else {
                c01271 = new C01271(continuationImpl);
            }
        } else {
            c01271 = new C01271(continuationImpl);
        }
        C01271 c01272 = c01271;
        Object objTryTokenizedPlayer = c01272.result;
        int i2 = c01272.label;
        String str7 = "PlayerClientDirector";
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0 = this.logger;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(objTryTokenizedPlayer);
                        try {
                            YouTubeClient youTubeClient2 = selectedClient3.client;
                            TokenPlan tokenPlan2 = tokenPlan(selectedClient3, z2);
                            boolean z13 = tokenPlan2.playerRequired;
                            if (z4) {
                                if ((z13 || tokenPlan2.gvsRequired) && !z) {
                                    return new ClientAttemptResult(null, null, null, true, null, 36);
                                }
                            }
                            if ((z12 || z13) && tokenPlan2.getCanMint()) {
                                try {
                                    Map mapSingletonMap = Collections.singletonMap("client", youTubeClient2.clientName);
                                    mapSingletonMap.getClass();
                                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "PlayerClientDirector", "tokenized request selected", mapSingletonMap, 4);
                                    c01272.L$0 = selectedClient3;
                                    c01272.L$1 = null;
                                    c01272.L$2 = null;
                                    c01272.L$3 = null;
                                    c01272.L$4 = null;
                                    c01272.L$5 = null;
                                    c01272.L$6 = null;
                                    c01272.L$7 = null;
                                    c01272.L$8 = null;
                                    c01272.Z$0 = z;
                                    c01272.Z$1 = z2;
                                    c01272.Z$2 = z12;
                                    c01272.Z$3 = z4;
                                    try {
                                        c01272.label = 1;
                                        Object objTryTokenizedPlayer2 = tryTokenizedPlayer(selectedClient3, tokenPlan2, str, playerConfig, sessionSnapshot, null, null, navDeepLinkRequest, z4, deferred, c01272);
                                        if (objTryTokenizedPlayer2 != obj2) {
                                            return objTryTokenizedPlayer2;
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        z5 = true;
                                        str2 = null;
                                        Pair pair = new Pair("client", selectedClient3.client.clientName);
                                        playbackClientManifest = selectedClient3.manifest;
                                        if (playbackClientManifest != null) {
                                            str3 = playbackClientManifest.id;
                                        } else {
                                            str3 = str2;
                                        }
                                        if (str3 != null) {
                                            z6 = z5;
                                        } else {
                                            z6 = z5;
                                        }
                                        Pair pair2 = new Pair("profilePresent", String.valueOf(!z6));
                                        strM = Format$$ExternalSyntheticOutline0.m(e);
                                        if (strM == null) {
                                            strM = "unknown";
                                        }
                                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, str7, "player request failed", MapsKt__MapsKt.mapOf(pair, pair2, new Pair("exceptionType", strM)), 4);
                                        return new ClientAttemptResult(null, null, e, false, null, 56);
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    z5 = true;
                                }
                            } else {
                                z5 = true;
                                try {
                                    Integer num = playerConfig.signatureTimestamp;
                                    String str8 = playerConfig.encryptedHostFlags;
                                    c01272.L$0 = selectedClient3;
                                    c01272.L$1 = str;
                                    c01272.L$2 = playerConfig;
                                    str4 = "PlayerClientDirector";
                                    try {
                                        c01272.L$3 = contentHints;
                                        c01272.L$4 = sessionSnapshot;
                                        c01272.L$5 = navDeepLinkRequest;
                                        deferred2 = deferred;
                                        c01272.L$6 = deferred2;
                                        c01272.L$7 = youTubeClient2;
                                        c01272.L$8 = tokenPlan2;
                                        c01272.Z$0 = z;
                                        c01272.Z$1 = z2;
                                        c01272.Z$2 = z12;
                                        c01272.Z$3 = z4;
                                        c01272.label = 2;
                                        Object objRequestPlayer = requestPlayer(youTubeClient2, str, num, null, sessionSnapshot, str8, navDeepLinkRequest, c01272);
                                        if (objRequestPlayer != obj2) {
                                            z7 = z;
                                            sessionSnapshot2 = sessionSnapshot;
                                            navDeepLinkRequest2 = navDeepLinkRequest;
                                            youTubeClient = youTubeClient2;
                                            obj = objRequestPlayer;
                                            z8 = z2;
                                            tokenPlan = tokenPlan2;
                                            selectedClient3 = selectedClient;
                                            contentHints2 = contentHints;
                                            z9 = z4;
                                            str5 = str;
                                            playerConfig2 = playerConfig;
                                            playerResponse = (PlayerResponse) obj;
                                            if (playerResponse == null) {
                                                return new ClientAttemptResult(null, null, null, false, null, 60);
                                            }
                                            zIsPlayable = isPlayable(playerResponse, youTubeClient);
                                            str6 = youTubeClient.clientName;
                                            navDeepLinkRequest3 = navDeepLinkRequest2;
                                            PlayerResponse.PlayabilityStatus playabilityStatus = playerResponse.playabilityStatus;
                                            sessionSnapshot3 = sessionSnapshot2;
                                            deferred3 = deferred2;
                                            playabilityFailure = new PlayabilityFailure(playabilityStatus.status, playabilityStatus.reason);
                                            if (zIsPlayable) {
                                                if (tokenPlan.playerRequired) {
                                                    z10 = z5;
                                                } else {
                                                    z10 = z5;
                                                }
                                                if (z10) {
                                                }
                                                str7 = str4;
                                                if (tokenPlan.getCanMint()) {
                                                    Map mapSingletonMap2 = Collections.singletonMap("client", str6);
                                                    mapSingletonMap2.getClass();
                                                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, str7, "untokenized response accepted", mapSingletonMap2, 4);
                                                }
                                                return new ClientAttemptResult(new ClientAttempt(playerResponse, false, null), null, null, false, null, 60);
                                            }
                                            str7 = str4;
                                            if (!tokenPlan.getCanMint()) {
                                                if (zIsPlayable) {
                                                    playabilityFailure3 = null;
                                                } else {
                                                    playabilityFailure3 = playabilityFailure;
                                                }
                                                return new ClientAttemptResult(null, playabilityFailure3, null, zIsPlayable, playerResponse, 20);
                                            }
                                            playerResponse2 = playerResponse;
                                            if (zIsPlayable) {
                                                z11 = false;
                                            } else {
                                                bool = contentHints2.isUploaded;
                                                bool2 = Boolean.TRUE;
                                                if (Intrinsics.areEqual(bool, bool2)) {
                                                }
                                                z11 = z5;
                                            }
                                            if (zIsPlayable) {
                                            }
                                            playabilityFailure2 = playabilityFailure;
                                            if (z11) {
                                                EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, str7, "token fetch retried", MapsKt__MapsKt.mapOf(new Pair("client", str6), new Pair("restrictedContent", "true")), 4);
                                            }
                                            if (r2 == 0) {
                                                playabilityFailure2 = null;
                                            }
                                            if (zIsPlayable) {
                                                playerResponse2 = null;
                                            }
                                            c01272.L$0 = selectedClient3;
                                            str2 = null;
                                            c01272.L$1 = null;
                                            c01272.L$2 = null;
                                            c01272.L$3 = null;
                                            c01272.L$4 = null;
                                            c01272.L$5 = null;
                                            c01272.L$6 = null;
                                            c01272.L$7 = null;
                                            c01272.L$8 = null;
                                            c01272.Z$0 = z7;
                                            c01272.Z$1 = z8;
                                            c01272.Z$2 = z12;
                                            c01272.Z$3 = z9;
                                            c01272.label = 3;
                                            selectedClient2 = selectedClient3;
                                            objTryTokenizedPlayer = tryTokenizedPlayer(selectedClient2, tokenPlan, str5, playerConfig2, sessionSnapshot3, playabilityFailure2, playerResponse2, navDeepLinkRequest3, z9, deferred3, c01272);
                                            selectedClient3 = selectedClient2;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        str7 = str4;
                                        str2 = null;
                                        selectedClient3 = selectedClient;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                }
                            }
                            return obj2;
                        } catch (Exception e5) {
                            e = e5;
                            str2 = null;
                            z5 = true;
                        }
                    } else {
                        if (i2 == 1) {
                            SelectedClient selectedClient4 = c01272.L$0;
                            ResultKt.throwOnFailure(objTryTokenizedPlayer);
                            return objTryTokenizedPlayer;
                        }
                        if (i2 == 2) {
                            boolean z14 = c01272.Z$3;
                            boolean z15 = c01272.Z$2;
                            z8 = c01272.Z$1;
                            z7 = c01272.Z$0;
                            tokenPlan = c01272.L$8;
                            YouTubeClient youTubeClient3 = c01272.L$7;
                            Deferred deferred4 = c01272.L$6;
                            navDeepLinkRequest2 = c01272.L$5;
                            sessionSnapshot2 = c01272.L$4;
                            ContentHints contentHints3 = c01272.L$3;
                            playerConfig = c01272.L$2;
                            str5 = c01272.L$1;
                            selectedClient3 = c01272.L$0;
                            ResultKt.throwOnFailure(objTryTokenizedPlayer);
                            obj = objTryTokenizedPlayer;
                            youTubeClient = youTubeClient3;
                            str4 = "PlayerClientDirector";
                            z5 = true;
                            z9 = z14;
                            contentHints2 = contentHints3;
                            deferred2 = deferred4;
                            z12 = z15;
                            playerConfig2 = playerConfig;
                            try {
                                playerResponse = (PlayerResponse) obj;
                                if (playerResponse == null) {
                                    return new ClientAttemptResult(null, null, null, false, null, 60);
                                }
                                zIsPlayable = isPlayable(playerResponse, youTubeClient);
                                str6 = youTubeClient.clientName;
                                navDeepLinkRequest3 = navDeepLinkRequest2;
                                PlayerResponse.PlayabilityStatus playabilityStatus2 = playerResponse.playabilityStatus;
                                sessionSnapshot3 = sessionSnapshot2;
                                deferred3 = deferred2;
                                playabilityFailure = new PlayabilityFailure(playabilityStatus2.status, playabilityStatus2.reason);
                                if (zIsPlayable) {
                                    try {
                                        if (tokenPlan.playerRequired || tokenPlan.gvsRequired) {
                                            z10 = z5;
                                        } else {
                                            z10 = false;
                                        }
                                        if (z10 || z7) {
                                            str7 = str4;
                                            try {
                                                if (tokenPlan.getCanMint() && z7) {
                                                    Map mapSingletonMap3 = Collections.singletonMap("client", str6);
                                                    mapSingletonMap3.getClass();
                                                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, str7, "untokenized response accepted", mapSingletonMap3, 4);
                                                }
                                                return new ClientAttemptResult(new ClientAttempt(playerResponse, false, null), null, null, false, null, 60);
                                            } catch (Exception e6) {
                                                e = e6;
                                                str2 = null;
                                                Pair pair3 = new Pair("client", selectedClient3.client.clientName);
                                                playbackClientManifest = selectedClient3.manifest;
                                                if (playbackClientManifest != null) {
                                                    str3 = playbackClientManifest.id;
                                                } else {
                                                    str3 = str2;
                                                }
                                                if (str3 != null) {
                                                    z6 = z5;
                                                } else {
                                                    z6 = z5;
                                                }
                                                Pair pair4 = new Pair("profilePresent", String.valueOf(!z6));
                                                strM = Format$$ExternalSyntheticOutline0.m(e);
                                                if (strM == null) {
                                                    strM = "unknown";
                                                }
                                                EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, str7, "player request failed", MapsKt__MapsKt.mapOf(pair3, pair4, new Pair("exceptionType", strM)), 4);
                                                return new ClientAttemptResult(null, null, e, false, null, 56);
                                            }
                                        }
                                        Map mapSingletonMap4 = Collections.singletonMap("client", str6);
                                        mapSingletonMap4.getClass();
                                        str7 = str4;
                                        EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, str7, "token required for playback stability", mapSingletonMap4, 4);
                                    } catch (Exception e7) {
                                        e = e7;
                                        str7 = str4;
                                    }
                                } else {
                                    str7 = str4;
                                }
                                if (!tokenPlan.getCanMint()) {
                                    if (zIsPlayable) {
                                        playabilityFailure3 = playabilityFailure;
                                    } else {
                                        playabilityFailure3 = null;
                                    }
                                    return new ClientAttemptResult(null, playabilityFailure3, null, zIsPlayable, playerResponse, 20);
                                }
                                playerResponse2 = playerResponse;
                                if (zIsPlayable) {
                                    bool = contentHints2.isUploaded;
                                    bool2 = Boolean.TRUE;
                                    if (!Intrinsics.areEqual(bool, bool2) || Intrinsics.areEqual(contentHints2.isAgeRestricted, bool2)) {
                                        z11 = z5;
                                    } else {
                                        z11 = false;
                                    }
                                } else {
                                    z11 = false;
                                }
                                if (zIsPlayable && !z11) {
                                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, str7, "token fetch skipped", MapsKt__MapsKt.mapOf(new Pair("client", str6), new Pair("playable", "false")), 4);
                                    return new ClientAttemptResult(null, playabilityFailure, null, false, playerResponse2, 28);
                                }
                                playabilityFailure2 = playabilityFailure;
                                if (z11) {
                                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, str7, "token fetch retried", MapsKt__MapsKt.mapOf(new Pair("client", str6), new Pair("restrictedContent", "true")), 4);
                                }
                                if (r2 == 0) {
                                    playabilityFailure2 = null;
                                }
                                if (zIsPlayable) {
                                    playerResponse2 = null;
                                }
                                c01272.L$0 = selectedClient3;
                                str2 = null;
                                try {
                                    c01272.L$1 = null;
                                    c01272.L$2 = null;
                                    c01272.L$3 = null;
                                    c01272.L$4 = null;
                                    c01272.L$5 = null;
                                    c01272.L$6 = null;
                                    c01272.L$7 = null;
                                    c01272.L$8 = null;
                                    c01272.Z$0 = z7;
                                    c01272.Z$1 = z8;
                                    c01272.Z$2 = z12;
                                    c01272.Z$3 = z9;
                                    c01272.label = 3;
                                    selectedClient2 = selectedClient3;
                                    try {
                                        objTryTokenizedPlayer = tryTokenizedPlayer(selectedClient2, tokenPlan, str5, playerConfig2, sessionSnapshot3, playabilityFailure2, playerResponse2, navDeepLinkRequest3, z9, deferred3, c01272);
                                        selectedClient3 = selectedClient2;
                                    } catch (Exception e8) {
                                        e = e8;
                                        selectedClient3 = selectedClient2;
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                }
                            } catch (Exception e10) {
                                e = e10;
                                str7 = str4;
                            }
                        } else {
                            if (i2 != 3) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            selectedClient3 = c01272.L$0;
                            try {
                                ResultKt.throwOnFailure(objTryTokenizedPlayer);
                                z5 = true;
                                str2 = null;
                                return (ClientAttemptResult) objTryTokenizedPlayer;
                            } catch (Exception e11) {
                                e = e11;
                                z5 = true;
                                str2 = null;
                            }
                        }
                    }
                } catch (Exception e12) {
                    e = e12;
                    str2 = null;
                    z5 = true;
                }
            } catch (Exception e13) {
                e = e13;
            }
        } catch (CancellationException e14) {
            throw e14;
        }
        Pair pair5 = new Pair("client", selectedClient3.client.clientName);
        playbackClientManifest = selectedClient3.manifest;
        if (playbackClientManifest != null) {
            str3 = playbackClientManifest.id;
        } else {
            str3 = str2;
        }
        if (str3 != null || StringsKt.isBlank(str3)) {
            z6 = z5;
        } else {
            z6 = false;
        }
        Pair pair6 = new Pair("profilePresent", String.valueOf(!z6));
        strM = Format$$ExternalSyntheticOutline0.m(e);
        if (strM == null) {
            strM = "unknown";
        }
        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, str7, "player request failed", MapsKt__MapsKt.mapOf(pair5, pair6, new Pair("exceptionType", strM)), 4);
        return new ClientAttemptResult(null, null, e, false, null, 56);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02da  */
    /* JADX WARN: Code duplicated, block: B:103:0x02e6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:140:0x0410  */
    /* JADX WARN: Code duplicated, block: B:44:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:47:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:50:0x0225  */
    /* JADX WARN: Code duplicated, block: B:51:0x0227  */
    /* JADX WARN: Code duplicated, block: B:54:0x025c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:63:0x0273  */
    /* JADX WARN: Code duplicated, block: B:66:0x0278 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:75:0x028f  */
    /* JADX WARN: Code duplicated, block: B:78:0x0294 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    /* JADX WARN: Code duplicated, block: B:82:0x029d  */
    /* JADX WARN: Code duplicated, block: B:90:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:92:0x02b4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:99:0x02c2  */
    public final Object tryTokenizedPlayer(SelectedClient selectedClient, TokenPlan tokenPlan, String str, PlayerConfig playerConfig, InnerTube.SessionSnapshot sessionSnapshot, PlayabilityFailure playabilityFailure, PlayerResponse playerResponse, NavDeepLinkRequest navDeepLinkRequest, boolean z, Deferred deferred, ContinuationImpl continuationImpl) throws SnapshotApplyConflictException, IOException {
        C01281 c01281;
        String str2;
        TokenPlan tokenPlan2;
        String str3;
        PlayerResponse playerResponse2;
        Deferred deferred2;
        Object obj;
        YouTubeClient youTubeClient;
        long j;
        PlayabilityFailure playabilityFailure2;
        NavDeepLinkRequest navDeepLinkRequest2;
        boolean z2;
        InnerTube.SessionSnapshot sessionSnapshot2;
        PlayerConfig playerConfig2;
        Deferred deferred3;
        SelectedClient selectedClient2;
        long j2;
        YouTubeClient youTubeClient2;
        InnerTube.SessionSnapshot sessionSnapshot3;
        PlayerConfig playerConfig3;
        String str4;
        InnerTube.SessionSnapshot sessionSnapshot4;
        Object objM1899withTimeoutOrNullKLykuaI;
        PlayerConfig playerConfig4;
        long j3;
        String str5;
        boolean z3;
        PoTokenResult poTokenResult;
        boolean z4;
        PlayabilityFailure playabilityFailure3;
        Object obj2;
        String str6;
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0;
        PoTokenBinding poTokenBinding;
        String str7;
        PoTokenBinding poTokenBinding2;
        String str8;
        boolean z5;
        boolean z6;
        YouTubeClient youTubeClient3;
        String str9;
        PlayabilityFailure playabilityFailure4;
        String str10;
        if (continuationImpl instanceof C01281) {
            c01281 = (C01281) continuationImpl;
            int i = c01281.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01281.label = i - Integer.MIN_VALUE;
            } else {
                c01281 = new C01281(continuationImpl);
            }
        } else {
            c01281 = new C01281(continuationImpl);
        }
        Object obj3 = c01281.result;
        int i2 = c01281.label;
        DurationUnit durationUnit = DurationUnit.MILLISECONDS;
        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline1 = this.logger;
        Continuation continuation = null;
        Object obj4 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj3);
            if (z) {
                return new ClientAttemptResult(null, playabilityFailure, null, true, null, 36);
            }
            YouTubeClient youTubeClient4 = selectedClient.client;
            long epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds();
            String str11 = sessionSnapshot.visitorData;
            if (str11 == null || StringsKt.isBlank(str11)) {
                Map mapSingletonMap = Collections.singletonMap("client", youTubeClient4.clientName);
                mapSingletonMap.getClass();
                EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline1, "PlayerClientDirector", "visitor data requested", mapSingletonMap, 4);
                Path.Companion companion = Duration.Companion;
                long duration = InstantKt.toDuration(PoTokenGenerator.POTOKEN_TIMEOUT_MS, durationUnit);
                str2 = "PlayerClientDirector";
                App.C01391 c01391 = new App.C01391(this, sessionSnapshot, continuation, (byte) 14);
                c01281.L$0 = selectedClient;
                tokenPlan2 = tokenPlan;
                c01281.L$1 = tokenPlan2;
                str3 = str;
                c01281.L$2 = str3;
                c01281.L$3 = playerConfig;
                c01281.L$4 = sessionSnapshot;
                c01281.L$5 = playabilityFailure;
                c01281.L$6 = playerResponse;
                c01281.L$7 = navDeepLinkRequest;
                c01281.L$8 = deferred;
                c01281.L$9 = youTubeClient4;
                c01281.Z$0 = z;
                c01281.J$0 = epochMilliseconds;
                c01281.label = 1;
                Object objM1899withTimeoutOrNullKLykuaI2 = AwaitKt.m1899withTimeoutOrNullKLykuaI(duration, c01391, c01281);
                if (objM1899withTimeoutOrNullKLykuaI2 != obj4) {
                    playerResponse2 = playerResponse;
                    deferred2 = deferred;
                    obj = objM1899withTimeoutOrNullKLykuaI2;
                    youTubeClient = youTubeClient4;
                    j = epochMilliseconds;
                    playabilityFailure2 = playabilityFailure;
                    navDeepLinkRequest2 = navDeepLinkRequest;
                    z2 = z;
                    sessionSnapshot2 = sessionSnapshot;
                    playerConfig2 = playerConfig;
                }
            } else {
                tokenPlan2 = tokenPlan;
                playerResponse2 = playerResponse;
                deferred3 = deferred;
                selectedClient2 = selectedClient;
                str2 = "PlayerClientDirector";
                pathKt$$ExternalSyntheticBUOutline1 = pathKt$$ExternalSyntheticBUOutline1;
                j2 = epochMilliseconds;
                str3 = str;
                playabilityFailure2 = playabilityFailure;
                navDeepLinkRequest2 = navDeepLinkRequest;
                youTubeClient2 = youTubeClient4;
                z2 = z;
                sessionSnapshot3 = sessionSnapshot;
                playerConfig3 = playerConfig;
                str4 = sessionSnapshot3.visitorData;
                if (str4 != null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Required value was null.");
                    return null;
                }
                Path.Companion companion2 = Duration.Companion;
                long duration2 = InstantKt.toDuration(18000L, durationUnit);
                InnerTube.SessionSnapshot sessionSnapshot5 = sessionSnapshot3;
                NetworkFetcher$doFetch$fetchResult$1 networkFetcher$doFetch$fetchResult$1 = new NetworkFetcher$doFetch$fetchResult$1(deferred3, this, str3, str4, sessionSnapshot5, selectedClient2, null, (byte) 2);
                sessionSnapshot4 = sessionSnapshot5;
                c01281.L$0 = null;
                c01281.L$1 = tokenPlan2;
                c01281.L$2 = str3;
                c01281.L$3 = playerConfig3;
                c01281.L$4 = null;
                c01281.L$5 = playabilityFailure2;
                c01281.L$6 = playerResponse2;
                c01281.L$7 = navDeepLinkRequest2;
                c01281.L$8 = null;
                c01281.L$9 = youTubeClient2;
                c01281.L$10 = sessionSnapshot4;
                c01281.L$11 = str4;
                c01281.Z$0 = z2;
                c01281.J$0 = j2;
                c01281.label = 2;
                objM1899withTimeoutOrNullKLykuaI = AwaitKt.m1899withTimeoutOrNullKLykuaI(duration2, networkFetcher$doFetch$fetchResult$1, c01281);
                if (objM1899withTimeoutOrNullKLykuaI != obj4) {
                    obj4 = obj4;
                    long j4 = j2;
                    playerConfig4 = playerConfig3;
                    j3 = j4;
                    boolean z7 = z2;
                    str5 = str4;
                    z3 = z7;
                    poTokenResult = (PoTokenResult) objM1899withTimeoutOrNullKLykuaI;
                    long epochMilliseconds2 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - j3;
                    InnerTube.SessionSnapshot sessionSnapshot6 = sessionSnapshot4;
                    String str12 = str3;
                    Pair pair = new Pair("client", youTubeClient2.clientName);
                    if (poTokenResult != null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    NavDeepLinkRequest navDeepLinkRequest3 = navDeepLinkRequest2;
                    playabilityFailure3 = playabilityFailure2;
                    obj2 = "client";
                    Map mapMapOf = MapsKt__MapsKt.mapOf(pair, new Pair("tokenPresent", String.valueOf(z4)), new Pair("elapsedMs", String.valueOf(epochMilliseconds2)));
                    str6 = str2;
                    pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
                    EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, str6, "token fetch completed", mapMapOf, 4);
                    poTokenBinding = tokenPlan2.playerBinding;
                    if (poTokenBinding != null) {
                        str7 = null;
                    } else {
                        str7 = null;
                    }
                    poTokenBinding2 = tokenPlan2.gvsBinding;
                    if (poTokenBinding2 != null) {
                        str8 = null;
                    } else {
                        str8 = null;
                    }
                    if (tokenPlan2.playerRequired) {
                    }
                    if (str7 != null) {
                    }
                    if (poTokenResult == null) {
                        return new ClientAttemptResult(null, playabilityFailure3, null, true, null, 36);
                    }
                    boolean z8 = z5;
                    if (Intrinsics.areEqual(poTokenResult.visitorData, str5)) {
                    }
                    Map mapSingletonMap2 = Collections.singletonMap(obj2, youTubeClient2.clientName);
                    mapSingletonMap2.getClass();
                    EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, str6, "token binding rejected", mapSingletonMap2, 4);
                    return new ClientAttemptResult(null, playabilityFailure3, null, true, null, 52);
                }
            }
            obj4 = obj4;
            return obj4;
        }
        if (i2 == 1) {
            long j5 = c01281.J$0;
            boolean z9 = c01281.Z$0;
            YouTubeClient youTubeClient5 = c01281.L$9;
            deferred2 = c01281.L$8;
            navDeepLinkRequest2 = c01281.L$7;
            playerResponse2 = c01281.L$6;
            playabilityFailure2 = c01281.L$5;
            InnerTube.SessionSnapshot sessionSnapshot7 = c01281.L$4;
            playerConfig2 = c01281.L$3;
            String str13 = c01281.L$2;
            TokenPlan tokenPlan3 = c01281.L$1;
            SelectedClient selectedClient3 = c01281.L$0;
            ResultKt.throwOnFailure(obj3);
            j = j5;
            selectedClient = selectedClient3;
            youTubeClient = youTubeClient5;
            str2 = "PlayerClientDirector";
            str3 = str13;
            z2 = z9;
            obj = obj3;
            sessionSnapshot2 = sessionSnapshot7;
            tokenPlan2 = tokenPlan3;
        } else {
            if (i2 == 2) {
                long j6 = c01281.J$0;
                z3 = c01281.Z$0;
                str5 = c01281.L$11;
                sessionSnapshot4 = c01281.L$10;
                YouTubeClient youTubeClient6 = c01281.L$9;
                navDeepLinkRequest2 = c01281.L$7;
                playerResponse2 = c01281.L$6;
                PlayabilityFailure playabilityFailure5 = c01281.L$5;
                PlayerConfig playerConfig5 = c01281.L$3;
                String str14 = c01281.L$2;
                TokenPlan tokenPlan4 = c01281.L$1;
                ResultKt.throwOnFailure(obj3);
                playerConfig4 = playerConfig5;
                str2 = "PlayerClientDirector";
                pathKt$$ExternalSyntheticBUOutline1 = pathKt$$ExternalSyntheticBUOutline1;
                youTubeClient2 = youTubeClient6;
                str3 = str14;
                playabilityFailure2 = playabilityFailure5;
                objM1899withTimeoutOrNullKLykuaI = obj3;
                tokenPlan2 = tokenPlan4;
                j3 = j6;
                poTokenResult = (PoTokenResult) objM1899withTimeoutOrNullKLykuaI;
                long epochMilliseconds3 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - j3;
                InnerTube.SessionSnapshot sessionSnapshot8 = sessionSnapshot4;
                String str15 = str3;
                Pair pair2 = new Pair("client", youTubeClient2.clientName);
                if (poTokenResult != null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                NavDeepLinkRequest navDeepLinkRequest4 = navDeepLinkRequest2;
                playabilityFailure3 = playabilityFailure2;
                obj2 = "client";
                Map mapMapOf2 = MapsKt__MapsKt.mapOf(pair2, new Pair("tokenPresent", String.valueOf(z4)), new Pair("elapsedMs", String.valueOf(epochMilliseconds3)));
                str6 = str2;
                pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
                EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, str6, "token fetch completed", mapMapOf2, 4);
                poTokenBinding = tokenPlan2.playerBinding;
                if (poTokenBinding != null || poTokenResult == null) {
                    str7 = null;
                } else {
                    int iOrdinal = poTokenBinding.ordinal();
                    if (iOrdinal == 0) {
                        str7 = poTokenResult.streamingDataToken;
                    } else {
                        if (iOrdinal != 1) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        str7 = poTokenResult.playerRequestToken;
                    }
                }
                poTokenBinding2 = tokenPlan2.gvsBinding;
                if (poTokenBinding2 != null || poTokenResult == null) {
                    str8 = null;
                } else {
                    int iOrdinal2 = poTokenBinding2.ordinal();
                    if (iOrdinal2 == 0) {
                        str8 = poTokenResult.streamingDataToken;
                    } else {
                        if (iOrdinal2 != 1) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        str8 = poTokenResult.playerRequestToken;
                    }
                }
                z5 = (!tokenPlan2.playerRequired && (str7 == null || StringsKt.isBlank(str7))) || (tokenPlan2.gvsRequired && (str8 == null || StringsKt.isBlank(str8)));
                boolean z10 = (str7 != null || StringsKt.isBlank(str7)) && (str8 == null || StringsKt.isBlank(str8));
                if (poTokenResult == null) {
                    return new ClientAttemptResult(null, playabilityFailure3, null, true, null, 36);
                }
                boolean z11 = z5;
                if (Intrinsics.areEqual(poTokenResult.visitorData, str5) || z11 || z10) {
                    Map mapSingletonMap3 = Collections.singletonMap(obj2, youTubeClient2.clientName);
                    mapSingletonMap3.getClass();
                    EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, str6, "token binding rejected", mapSingletonMap3, 4);
                    return new ClientAttemptResult(null, playabilityFailure3, null, true, null, 52);
                }
                if (playerResponse2 != null && (str7 == null || StringsKt.isBlank(str7))) {
                    return new ClientAttemptResult(new ClientAttempt(playerResponse2, true, str8), null, null, false, null, 60);
                }
                z6 = true;
                Integer num = playerConfig4.signatureTimestamp;
                String str16 = playerConfig4.encryptedHostFlags;
                c01281.L$0 = null;
                c01281.L$1 = null;
                c01281.L$2 = null;
                c01281.L$3 = null;
                c01281.L$4 = null;
                c01281.L$5 = playabilityFailure3;
                c01281.L$6 = null;
                c01281.L$7 = null;
                c01281.L$8 = null;
                c01281.L$9 = youTubeClient2;
                c01281.L$10 = null;
                c01281.L$11 = null;
                c01281.L$13 = str7;
                c01281.L$14 = str8;
                c01281.Z$0 = z3;
                c01281.J$0 = j3;
                c01281.label = 3;
                String str17 = str7;
                YouTubeClient youTubeClient7 = youTubeClient2;
                Object objRequestPlayer = requestPlayer(youTubeClient7, str15, num, str17, sessionSnapshot8, str16, navDeepLinkRequest4, c01281);
                youTubeClient3 = youTubeClient7;
                str9 = str17;
                if (objRequestPlayer != obj4) {
                    playabilityFailure4 = playabilityFailure3;
                    obj3 = objRequestPlayer;
                    str10 = str8;
                }
                obj4 = obj4;
                return obj4;
            }
            if (i2 != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str10 = c01281.L$14;
            str9 = c01281.L$13;
            youTubeClient3 = c01281.L$9;
            playabilityFailure4 = c01281.L$5;
            ResultKt.throwOnFailure(obj3);
            pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
            obj2 = "client";
            z6 = true;
            str6 = "PlayerClientDirector";
        }
        PlayerResponse playerResponse3 = (PlayerResponse) obj3;
        if (playerResponse3 == null) {
            return new ClientAttemptResult(null, playabilityFailure4, null, false, null, 60);
        }
        PlayerResponse.PlayabilityStatus playabilityStatus = playerResponse3.playabilityStatus;
        String str18 = playabilityStatus.status;
        if (isPlayable(playerResponse3, youTubeClient3)) {
            return new ClientAttemptResult(new ClientAttempt(playerResponse3, ((str9 == null || StringsKt.isBlank(str9)) && (str10 == null || StringsKt.isBlank(str10))) ? false : z6, str10), null, null, false, null, 60);
        }
        Map mapSingletonMap4 = Collections.singletonMap(obj2, youTubeClient3.clientName);
        mapSingletonMap4.getClass();
        EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, str6, "tokenized response unavailable", mapSingletonMap4, 4);
        return new ClientAttemptResult(null, new PlayabilityFailure(str18, playabilityStatus.reason), null, false, null, 60);
        String str19 = (String) obj;
        if (str19 == null || StringsKt.isBlank(str19)) {
            String str20 = str2;
            Map mapSingletonMap5 = Collections.singletonMap("client", youTubeClient.clientName);
            mapSingletonMap5.getClass();
            EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline1, str20, "visitor data unavailable", mapSingletonMap5, 4);
            return new ClientAttemptResult(null, playabilityFailure2, null, true, null, 52);
        }
        PlayerConfig playerConfig6 = playerConfig2;
        InnerTube.SessionSnapshot sessionSnapshotSessionSnapshotWithVisitorData = this.innerTube.sessionSnapshotWithVisitorData(sessionSnapshot2, str19);
        if (sessionSnapshotSessionSnapshotWithVisitorData == null) {
            return new ClientAttemptResult(null, playabilityFailure2, null, true, null, 52);
        }
        selectedClient2 = selectedClient;
        youTubeClient2 = youTubeClient;
        sessionSnapshot3 = sessionSnapshotSessionSnapshotWithVisitorData;
        j2 = j;
        playerConfig3 = playerConfig6;
        deferred3 = deferred2;
        str4 = sessionSnapshot3.visitorData;
        if (str4 != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Required value was null.");
            return null;
        }
        Path.Companion companion3 = Duration.Companion;
        long duration3 = InstantKt.toDuration(18000L, durationUnit);
        InnerTube.SessionSnapshot sessionSnapshot9 = sessionSnapshot3;
        NetworkFetcher$doFetch$fetchResult$1 networkFetcher$doFetch$fetchResult$2 = new NetworkFetcher$doFetch$fetchResult$1(deferred3, this, str3, str4, sessionSnapshot9, selectedClient2, null, (byte) 2);
        sessionSnapshot4 = sessionSnapshot9;
        c01281.L$0 = null;
        c01281.L$1 = tokenPlan2;
        c01281.L$2 = str3;
        c01281.L$3 = playerConfig3;
        c01281.L$4 = null;
        c01281.L$5 = playabilityFailure2;
        c01281.L$6 = playerResponse2;
        c01281.L$7 = navDeepLinkRequest2;
        c01281.L$8 = null;
        c01281.L$9 = youTubeClient2;
        c01281.L$10 = sessionSnapshot4;
        c01281.L$11 = str4;
        c01281.Z$0 = z2;
        c01281.J$0 = j2;
        c01281.label = 2;
        objM1899withTimeoutOrNullKLykuaI = AwaitKt.m1899withTimeoutOrNullKLykuaI(duration3, networkFetcher$doFetch$fetchResult$2, c01281);
        if (objM1899withTimeoutOrNullKLykuaI != obj4) {
            obj4 = obj4;
            long j7 = j2;
            playerConfig4 = playerConfig3;
            j3 = j7;
            boolean z12 = z2;
            str5 = str4;
            z3 = z12;
            poTokenResult = (PoTokenResult) objM1899withTimeoutOrNullKLykuaI;
            long epochMilliseconds4 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - j3;
            InnerTube.SessionSnapshot sessionSnapshot10 = sessionSnapshot4;
            String str110 = str3;
            Pair pair3 = new Pair("client", youTubeClient2.clientName);
            if (poTokenResult != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            NavDeepLinkRequest navDeepLinkRequest5 = navDeepLinkRequest2;
            playabilityFailure3 = playabilityFailure2;
            obj2 = "client";
            Map mapMapOf3 = MapsKt__MapsKt.mapOf(pair3, new Pair("tokenPresent", String.valueOf(z4)), new Pair("elapsedMs", String.valueOf(epochMilliseconds4)));
            str6 = str2;
            pathKt$$ExternalSyntheticBUOutline0 = pathKt$$ExternalSyntheticBUOutline1;
            EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, str6, "token fetch completed", mapMapOf3, 4);
            poTokenBinding = tokenPlan2.playerBinding;
            if (poTokenBinding != null) {
                str7 = null;
            } else {
                str7 = null;
            }
            poTokenBinding2 = tokenPlan2.gvsBinding;
            if (poTokenBinding2 != null) {
                str8 = null;
            } else {
                str8 = null;
            }
            if (tokenPlan2.playerRequired) {
            }
            if (str7 != null) {
            }
            if (poTokenResult == null) {
                return new ClientAttemptResult(null, playabilityFailure3, null, true, null, 36);
            }
            boolean z13 = z5;
            if (Intrinsics.areEqual(poTokenResult.visitorData, str5)) {
            }
            Map mapSingletonMap6 = Collections.singletonMap(obj2, youTubeClient2.clientName);
            mapSingletonMap6.getClass();
            EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, str6, "token binding rejected", mapSingletonMap6, 4);
            return new ClientAttemptResult(null, playabilityFailure3, null, true, null, 52);
        }
        obj4 = obj4;
        return obj4;
    }
}
