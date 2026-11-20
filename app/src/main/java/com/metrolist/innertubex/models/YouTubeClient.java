package com.metrolist.innertubex.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.lastfm.LastFM$$ExternalSyntheticLambda1;
import io.ktor.utils.io.ByteChannelKt;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/YouTubeClient;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class YouTubeClient {
    public static final YouTubeClient ANDROID;
    public static final YouTubeClient ANDROID_CREATOR;
    public static final YouTubeClient ANDROID_KIDS;
    public static final YouTubeClient ANDROID_MUSIC;
    public static final YouTubeClient ANDROID_PRODUCER;
    public static final YouTubeClient ANDROID_SABR;
    public static final YouTubeClient ANDROID_VR_1_43_32;
    public static final YouTubeClient ANDROID_VR_1_61_48;
    public static final YouTubeClient ANDROID_VR_1_65_10;
    public static final YouTubeClient ANDROID_VR_NO_AUTH;
    public static final YouTubeClient ANDROID_VR_SABR;
    public static final YouTubeClient IOS;
    public static final YouTubeClient IOS_MUSIC;
    public static final YouTubeClient IOS_SABR;
    public static final YouTubeClient IPADOS;
    public static final YouTubeClient MEDIA_CONNECT_FRONTEND;
    public static final YouTubeClient MWEB;
    public static final YouTubeClient MWEB_SABR;
    public static final YouTubeClient TVHTML5;
    public static final YouTubeClient TVHTML5_DOWNGRADED;
    public static final YouTubeClient TVHTML5_SABR;
    public static final YouTubeClient TVHTML5_SIMPLY;
    public static final YouTubeClient TVHTML5_SIMPLY_EMBEDDED_PLAYER;
    public static final YouTubeClient TVHTML5_SIMPLY_SABR;
    public static final YouTubeClient VISIONOS;
    public static final YouTubeClient VISIONOS_0_1;
    public static final YouTubeClient VISIONOS_SABR;
    public static final YouTubeClient WEB;
    public static final YouTubeClient WEB_CREATOR;
    public static final YouTubeClient WEB_EMBEDDED_PLAYER;
    public static final YouTubeClient WEB_KIDS;
    public static final YouTubeClient WEB_REMIX;
    public static final YouTubeClient WEB_REMIX_SABR;
    public static final YouTubeClient WEB_SABR;
    public static final YouTubeClient WEB_SAFARI;
    public static final YouTubeClient WEB_SAFARI_SABR;
    public final String androidSdkVersion;
    public final String buildId;
    public final String clientId;
    public final String clientName;
    public final String clientVersion;
    public final String cronetVersion;
    public final String deviceMake;
    public final String deviceModel;
    public final String friendlyName;
    public final boolean includeUserAgentInContext;
    public final boolean isEmbedded;
    public final boolean loginRequired;
    public final boolean loginSupported;
    public final String osName;
    public final String osVersion;
    public final String packageName;
    public final String platform;
    public final PoTokenBinding poTokenBinding;
    public final boolean requirePoToken;
    public final boolean skipPlayerResponseValidation;
    public final boolean useMusicPlayerEndpoint;
    public final boolean useSabr;
    public final boolean useSignatureTimestamp;
    public final boolean useWebPoTokens;
    public final String userAgent;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LastFM$$ExternalSyntheticLambda1(4)), null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/metrolist/innertubex/models/YouTubeClient$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/YouTubeClient;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "USER_AGENT_WEB", "Ljava/lang/String;", "ORIGIN_YOUTUBE_MUSIC", "REFERER_YOUTUBE_MUSIC", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return YouTubeClient$$serializer.INSTANCE;
        }
    }

    static {
        boolean z = true;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        YouTubeClient youTubeClient = new YouTubeClient("WEB_REMIX", "1.20260707.12.00", "67", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0", null, str, str2, str3, str4, str5, str6, str7, str8, true, z, 33210352);
        WEB_REMIX = youTubeClient;
        boolean z2 = true;
        String str9 = null;
        WEB_CREATOR = new YouTubeClient("WEB_CREATOR", "1.20260708.06.00", "62", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0", str, str2, str3, str4, str5, str6, str7, str8, str9, z, z2, 33177584);
        String str10 = "Mozilla/5.0 (ChromiumStylePlatform) Cobalt/25.lts.30.1034943-gold (unlike Gecko), Unknown_TV_Unknown_0/Unknown (Unknown, Unknown)";
        YouTubeClient youTubeClient2 = new YouTubeClient("TVHTML5", "7.20260707.07.00", "7", str10, str2, str3, str4, str5, str6, str7, str8, str9, null, z2, true, 31113200);
        TVHTML5 = youTubeClient2;
        boolean z3 = false;
        boolean z4 = false;
        YouTubeClient youTubeClient3 = new YouTubeClient("VISIONOS", "1.02", "101", "Mozilla/5.0 (Macintosh; Intel Mac OS X 15_7_3) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/26.0 Safari/605.1.15", "visionOS", "26.5.23O471", "Apple", "RealityDevice17,1", str5, str6, str7, str8, "visionOS", z4, z3, 25075456);
        VISIONOS = youTubeClient3;
        VISIONOS_0_1 = new YouTubeClient("VISIONOS", "0.1", "101", "Mozilla/5.0 (Macintosh; Intel Mac OS X 14_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.5 Safari/605.1.15", "VISION_OS", "1.3", "Apple", "RealityDevice14,1", str5, str6, str7, str8, "visionOS 0.1", z4, z3, 8297728);
        String str11 = null;
        YouTubeClient youTubeClient4 = new YouTubeClient("ANDROID_VR", "1.65.10", "28", "com.google.android.apps.youtube.vr.oculus/1.65.10 (Linux; U; Android 12L; eureka-user Build/SQ3A.220605.009.A1) gzip", "Android", "12L", "Oculus", "Quest 3", "32", str7, str8, str11, "Android VR 1.65", z3, false, 22978048);
        ANDROID_VR_1_65_10 = youTubeClient4;
        ANDROID_VR_NO_AUTH = new YouTubeClient("ANDROID_VR", "1.61.48", "28", "com.google.android.apps.youtube.vr.oculus/1.61.48 (Linux; U; Android 12; en_US; Oculus Quest 3; Build/SQ3A.220605.009.A1; Cronet/132.0.6808.3)", null, null, null, null, null, null, str7, str8, str11, false, z3, 22986736);
        boolean z5 = false;
        ANDROID_VR_1_61_48 = new YouTubeClient("ANDROID_VR", "1.61.48", "28", "com.google.android.apps.youtube.vr.oculus/1.61.48 (Linux; U; Android 12; en_US; Quest 3; Build/SQ3A.220605.009.A1; Cronet/132.0.6808.3)", "Android", "12", "Oculus", "Quest 3", "32", "SQ3A.220605.009.A1", "132.0.6808.3", "com.google.android.apps.youtube.vr.oculus", "Android VR 1.61", z3, z5, 22970880);
        ANDROID_VR_1_43_32 = new YouTubeClient("ANDROID_VR", "1.43.32", "28", "com.google.android.apps.youtube.vr.oculus/1.43.32 (Linux; U; Android 12; en_US; Quest 3; Build/SQ3A.220605.009.A1; Cronet/107.0.5284.2)", "Android", "12", "Oculus", "Quest 3", "32", "SQ3A.220605.009.A1", "107.0.5284.2", "com.google.android.apps.youtube.vr.oculus", "Android VR 1.43", z5, false, 22970880);
        PoTokenBinding poTokenBinding = PoTokenBinding.VISITOR_DATA;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        String str18 = null;
        String str19 = null;
        boolean z6 = false;
        boolean z7 = true;
        YouTubeClient youTubeClient5 = new YouTubeClient("TVHTML5_SIMPLY", "1.0", "75", str10, str12, str13, str14, str15, str16, str17, str18, str19, null, z6, z7, 23265264);
        TVHTML5_SIMPLY = youTubeClient5;
        TVHTML5_SIMPLY_EMBEDDED_PLAYER = new YouTubeClient("TVHTML5_SIMPLY_EMBEDDED_PLAYER", "2.0", "85", str10, str12, str13, str14, str15, str16, str17, str18, str19, "TVHTML5 Simply Embedded", z6, z7, 31514608);
        boolean z8 = true;
        String str20 = null;
        String str21 = null;
        YouTubeClient youTubeClient6 = new YouTubeClient("WEB", "2.20260708.00.00", "1", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0", str13, str14, str15, str16, str17, str18, str19, str20, str21, z7, z8, 33210352);
        WEB = youTubeClient6;
        YouTubeClient youTubeClientCopy$default = copy$default(youTubeClient6, null, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.5 Safari/605.1.15,gzip(gfe)", "Web Safari", null, 33546231);
        WEB_SAFARI = youTubeClientCopy$default;
        boolean z9 = true;
        YouTubeClient youTubeClient7 = new YouTubeClient("MWEB", "2.20260708.05.00", "2", "Mozilla/5.0 (iPad; CPU OS 16_7_10 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.6 Mobile/15E148 Safari/604.1,gzip(gfe)", str14, str15, str16, str17, str18, str19, str20, str21, "Mobile Web", z8, z9, 31105008);
        MWEB = youTubeClient7;
        String str22 = null;
        WEB_EMBEDDED_PLAYER = new YouTubeClient("WEB_EMBEDDED_PLAYER", "2.20260708.00.00", "56", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0", str15, str16, str17, str18, str19, str20, str21, str22, "Web Embedded", z9, true, 33333232);
        boolean z10 = false;
        String str23 = null;
        YouTubeClient youTubeClient8 = new YouTubeClient("IOS", "21.26.4", "5", "com.google.ios.youtube/21.26.4 (iPhone16,2; U; CPU iOS 18_3_2 like Mac OS X;)", "iPhone", "18.3.2.22D82", "Apple", "iPhone16,2", str20, str21, str22, str23, "iOS", false, z10, 31448832);
        IOS = youTubeClient8;
        IPADOS = copy$default(youTubeClient8, null, "com.google.ios.youtube/21.26.4 (iPad7,6; U; CPU iPadOS 17_7_10 like Mac OS X; en-US)", "iPadOS", null, 33546055);
        String str24 = null;
        WEB_KIDS = new YouTubeClient("WEB_KIDS", "2.20260205.00.00", "76", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0", null, null, null, str20, str21, str22, str23, str24, "Web Kids", z10, true, 33480688);
        ANDROID_MUSIC = new YouTubeClient("ANDROID_MUSIC", "5.34.51", "21", "com.google.android.apps.youtube.music/5.34.51 (Linux; U; Android 11) gzip", "Android", "11", str20, str21, "30", str23, str24, null, "Android Music", false, false, 31448768);
        ANDROID_CREATOR = new YouTubeClient("ANDROID_CREATOR", "25.03.101", "14", "com.google.android.apps.youtube.creator/25.03.101 (Linux; U; Android 15; en_US; Pixel 9 Pro Fold; Build/AP3A.241005.015.A2; Cronet/132.0.6779.0)", "Android", "15", "Google", "Pixel 9 Pro Fold", "35", "AP3A.241005.015.A2", "132.0.6779.0", "com.google.android.apps.youtube.creator", "Android Studio", true, true, 31326720);
        YouTubeClient youTubeClient9 = new YouTubeClient("ANDROID", "21.26.364", "3", "com.google.android.youtube/21.26.364 (Linux; U; Android 11) gzip", "Android", "11", null, null, "30", null, null, null, "Android", false, false, 31366848);
        ANDROID = youTubeClient9;
        ANDROID_SABR = copy$default(youTubeClient9, null, null, "Android SABR", null, 29351935);
        WEB_REMIX_SABR = copy$default(youTubeClient, null, null, "Web Remix SABR", poTokenBinding, 27779071);
        ANDROID_VR_SABR = copy$default(youTubeClient4, null, null, "Android VR SABR", null, 29351935);
        VISIONOS_SABR = copy$default(youTubeClient3, null, null, "visionOS SABR", null, 29351935);
        String str25 = null;
        TVHTML5_SIMPLY_SABR = copy$default(youTubeClient5, null, null, "TV HTML5 Simply SABR", null, 29351935);
        PoTokenBinding poTokenBinding2 = PoTokenBinding.VIDEO_ID;
        WEB_SABR = copy$default(youTubeClient6, null, null, "Web SABR", poTokenBinding2, 28303359);
        WEB_SAFARI_SABR = copy$default(youTubeClientCopy$default, null, null, "Web Safari SABR", poTokenBinding2, 28303359);
        MWEB_SABR = copy$default(youTubeClient7, null, null, "Mobile Web SABR", poTokenBinding2, 28303359);
        TVHTML5_SABR = copy$default(youTubeClient2, null, null, "TV HTML5 SABR", null, 29351935);
        String str26 = null;
        IOS_SABR = copy$default(youTubeClient8, null, null, "iOS SABR", null, 29351935);
        String str27 = null;
        TVHTML5_DOWNGRADED = new YouTubeClient("TVHTML5", "5.20260707", "7", "Mozilla/5.0 (ChromiumStylePlatform) Cobalt/Version", null, null, null, null, null, str25, str26, str27, "TV HTML5 Downgraded", true, true, 31367152);
        boolean z11 = false;
        String str28 = null;
        IOS_MUSIC = new YouTubeClient("IOS_MUSIC", "7.27.0", "26", "com.google.ios.youtubemusic/7.27.0 (iPhone16,2; U; CPU iOS 18_1_0 like Mac OS X;)", "iPhone", "18.1.0.22B83", "Apple", "iPhone16,2", str25, str26, str27, str28, "iOS Music probe", false, z11, 33545472);
        boolean z12 = false;
        String str29 = null;
        ANDROID_KIDS = new YouTubeClient("ANDROID_KIDS", "7.36.1", "18", "com.google.android.apps.youtube.kids/7.36.1 (Linux; U; Android 11) gzip", "Android", "11", null, str25, "30", str27, str28, str29, "Android Kids probe", z11, z12, 33545920);
        boolean z13 = false;
        String str30 = null;
        String str31 = null;
        ANDROID_PRODUCER = new YouTubeClient("ANDROID_PRODUCER", "0.111.1", "91", "com.google.android.apps.youtube.producer/0.111.1 (Linux; U; Android 11) gzip", "Android", "11", str25, str30, "30", str28, str29, str31, "Android Producer probe", z12, z13, 33545920);
        MEDIA_CONNECT_FRONTEND = new YouTubeClient("MEDIA_CONNECT_FRONTEND", "0.1", "95", "Mozilla/5.0", null, str25, str30, null, str28, str29, str31, null, "Media Connect probe", z13, false, 33546224);
    }

    public /* synthetic */ YouTubeClient(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, PoTokenBinding poTokenBinding, boolean z7, boolean z8, boolean z9, boolean z10) {
        if (15 != (i & 15)) {
            EnumsKt.throwMissingFieldException(YouTubeClient$$serializer.INSTANCE.getDescriptor(), i, 15);
            throw null;
        }
        this.clientName = str;
        this.clientVersion = str2;
        this.clientId = str3;
        this.userAgent = str4;
        if ((i & 16) == 0) {
            this.osName = null;
        } else {
            this.osName = str5;
        }
        if ((i & 32) == 0) {
            this.osVersion = null;
        } else {
            this.osVersion = str6;
        }
        if ((i & 64) == 0) {
            this.deviceMake = null;
        } else {
            this.deviceMake = str7;
        }
        if ((i & 128) == 0) {
            this.deviceModel = null;
        } else {
            this.deviceModel = str8;
        }
        if ((i & 256) == 0) {
            this.androidSdkVersion = null;
        } else {
            this.androidSdkVersion = str9;
        }
        if ((i & 512) == 0) {
            this.platform = null;
        } else {
            this.platform = str10;
        }
        if ((i & 1024) == 0) {
            this.buildId = null;
        } else {
            this.buildId = str11;
        }
        if ((i & 2048) == 0) {
            this.cronetVersion = null;
        } else {
            this.cronetVersion = str12;
        }
        if ((i & 4096) == 0) {
            this.packageName = null;
        } else {
            this.packageName = str13;
        }
        if ((i & 8192) == 0) {
            this.friendlyName = null;
        } else {
            this.friendlyName = str14;
        }
        if ((i & 16384) == 0) {
            this.loginSupported = false;
        } else {
            this.loginSupported = z;
        }
        if ((32768 & i) == 0) {
            this.loginRequired = false;
        } else {
            this.loginRequired = z2;
        }
        if ((65536 & i) == 0) {
            this.useSignatureTimestamp = false;
        } else {
            this.useSignatureTimestamp = z3;
        }
        if ((131072 & i) == 0) {
            this.isEmbedded = false;
        } else {
            this.isEmbedded = z4;
        }
        if ((262144 & i) == 0) {
            this.useWebPoTokens = false;
        } else {
            this.useWebPoTokens = z5;
        }
        if ((524288 & i) == 0) {
            this.requirePoToken = false;
        } else {
            this.requirePoToken = z6;
        }
        this.poTokenBinding = (1048576 & i) == 0 ? PoTokenBinding.VIDEO_ID : poTokenBinding;
        if ((2097152 & i) == 0) {
            this.includeUserAgentInContext = false;
        } else {
            this.includeUserAgentInContext = z7;
        }
        if ((4194304 & i) == 0) {
            this.useSabr = false;
        } else {
            this.useSabr = z8;
        }
        if ((8388608 & i) == 0) {
            this.useMusicPlayerEndpoint = false;
        } else {
            this.useMusicPlayerEndpoint = z9;
        }
        if ((i & 16777216) == 0) {
            this.skipPlayerResponseValidation = false;
        } else {
            this.skipPlayerResponseValidation = z10;
        }
    }

    public static YouTubeClient copy$default(YouTubeClient youTubeClient, String str, String str2, String str3, PoTokenBinding poTokenBinding, int i) {
        String str4 = youTubeClient.clientName;
        String str5 = (i & 2) != 0 ? youTubeClient.clientVersion : str;
        String str6 = youTubeClient.clientId;
        String str7 = (i & 8) != 0 ? youTubeClient.userAgent : str2;
        String str8 = (i & 16) != 0 ? youTubeClient.osName : "iPadOS";
        String str9 = (i & 32) != 0 ? youTubeClient.osVersion : "17.7.10.21H450";
        String str10 = youTubeClient.deviceMake;
        String str11 = (i & 128) != 0 ? youTubeClient.deviceModel : "iPad7,6";
        String str12 = youTubeClient.androidSdkVersion;
        String str13 = str5;
        String str14 = str7;
        String str15 = str8;
        String str16 = str9;
        String str17 = str11;
        String str18 = youTubeClient.platform;
        String str19 = youTubeClient.buildId;
        String str20 = youTubeClient.cronetVersion;
        String str21 = youTubeClient.packageName;
        String str22 = (i & 8192) != 0 ? youTubeClient.friendlyName : str3;
        boolean z = youTubeClient.loginSupported;
        boolean z2 = youTubeClient.loginRequired;
        boolean z3 = youTubeClient.useSignatureTimestamp;
        boolean z4 = youTubeClient.isEmbedded;
        boolean z5 = youTubeClient.useWebPoTokens;
        boolean z6 = (i & 524288) != 0 ? youTubeClient.requirePoToken : true;
        PoTokenBinding poTokenBinding2 = (i & ByteChannelKt.CHANNEL_MAX_SIZE) != 0 ? youTubeClient.poTokenBinding : poTokenBinding;
        boolean z7 = youTubeClient.includeUserAgentInContext;
        boolean z8 = (i & 4194304) != 0 ? youTubeClient.useSabr : true;
        boolean z9 = youTubeClient.useMusicPlayerEndpoint;
        boolean z10 = youTubeClient.skipPlayerResponseValidation;
        youTubeClient.getClass();
        str4.getClass();
        str13.getClass();
        str6.getClass();
        str14.getClass();
        poTokenBinding2.getClass();
        return new YouTubeClient(str4, str13, str6, str14, str15, str16, str10, str17, str12, str18, str19, str20, str21, str22, z, z2, z3, z4, z5, z6, poTokenBinding2, z7, z8, z9, z10);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YouTubeClient)) {
            return false;
        }
        YouTubeClient youTubeClient = (YouTubeClient) obj;
        return Intrinsics.areEqual(this.clientName, youTubeClient.clientName) && Intrinsics.areEqual(this.clientVersion, youTubeClient.clientVersion) && Intrinsics.areEqual(this.clientId, youTubeClient.clientId) && Intrinsics.areEqual(this.userAgent, youTubeClient.userAgent) && Intrinsics.areEqual(this.osName, youTubeClient.osName) && Intrinsics.areEqual(this.osVersion, youTubeClient.osVersion) && Intrinsics.areEqual(this.deviceMake, youTubeClient.deviceMake) && Intrinsics.areEqual(this.deviceModel, youTubeClient.deviceModel) && Intrinsics.areEqual(this.androidSdkVersion, youTubeClient.androidSdkVersion) && Intrinsics.areEqual(this.platform, youTubeClient.platform) && Intrinsics.areEqual(this.buildId, youTubeClient.buildId) && Intrinsics.areEqual(this.cronetVersion, youTubeClient.cronetVersion) && Intrinsics.areEqual(this.packageName, youTubeClient.packageName) && Intrinsics.areEqual(this.friendlyName, youTubeClient.friendlyName) && this.loginSupported == youTubeClient.loginSupported && this.loginRequired == youTubeClient.loginRequired && this.useSignatureTimestamp == youTubeClient.useSignatureTimestamp && this.isEmbedded == youTubeClient.isEmbedded && this.useWebPoTokens == youTubeClient.useWebPoTokens && this.requirePoToken == youTubeClient.requirePoToken && this.poTokenBinding == youTubeClient.poTokenBinding && this.includeUserAgentInContext == youTubeClient.includeUserAgentInContext && this.useSabr == youTubeClient.useSabr && this.useMusicPlayerEndpoint == youTubeClient.useMusicPlayerEndpoint && this.skipPlayerResponseValidation == youTubeClient.skipPlayerResponseValidation;
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.clientName.hashCode() * 31, 31, this.clientVersion), 31, this.clientId), 31, this.userAgent);
        String str = this.osName;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.osVersion;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deviceMake;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.deviceModel;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.androidSdkVersion;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.platform;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.buildId;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.cronetVersion;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.packageName;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.friendlyName;
        return Boolean.hashCode(this.skipPlayerResponseValidation) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((this.poTokenBinding.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iHashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31, this.loginSupported, 31), this.loginRequired, 31), this.useSignatureTimestamp, 31), this.isEmbedded, 31), this.useWebPoTokens, 31), this.requirePoToken, 31)) * 31, this.includeUserAgentInContext, 31), this.useSabr, 31), this.useMusicPlayerEndpoint, 31);
    }

    public final Context toContext(YouTubeLocale youTubeLocale, String str, String str2) {
        youTubeLocale.getClass();
        return new Context(new Context.Client(this.clientName, this.clientVersion, this.includeUserAgentInContext ? this.userAgent : null, this.osName, this.osVersion, this.deviceMake, this.deviceModel, this.androidSdkVersion, this.platform, youTubeLocale.gl, youTubeLocale.hl, str), this.isEmbedded ? new Context.ThirdParty() : null, new Context.User(this.loginSupported ? str2 : null, 1));
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("YouTubeClient(clientName=", this.clientName, ", clientVersion=", this.clientVersion, ", clientId=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.clientId, ", userAgent=", this.userAgent, ", osName=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.osName, ", osVersion=", this.osVersion, ", deviceMake=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.deviceMake, ", deviceModel=", this.deviceModel, ", androidSdkVersion=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.androidSdkVersion, ", platform=", this.platform, ", buildId=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.buildId, ", cronetVersion=", this.cronetVersion, ", packageName=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.packageName, ", friendlyName=", this.friendlyName, ", loginSupported=");
        Fragment$5$$ExternalSyntheticOutline0.m(sbM, this.loginSupported, ", loginRequired=", this.loginRequired, ", useSignatureTimestamp=");
        Fragment$5$$ExternalSyntheticOutline0.m(sbM, this.useSignatureTimestamp, ", isEmbedded=", this.isEmbedded, ", useWebPoTokens=");
        Fragment$5$$ExternalSyntheticOutline0.m(sbM, this.useWebPoTokens, ", requirePoToken=", this.requirePoToken, ", poTokenBinding=");
        sbM.append(this.poTokenBinding);
        sbM.append(", includeUserAgentInContext=");
        sbM.append(this.includeUserAgentInContext);
        sbM.append(", useSabr=");
        Fragment$5$$ExternalSyntheticOutline0.m(sbM, this.useSabr, ", useMusicPlayerEndpoint=", this.useMusicPlayerEndpoint, ", skipPlayerResponseValidation=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.skipPlayerResponseValidation, ")");
    }

    public YouTubeClient(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, PoTokenBinding poTokenBinding, boolean z7, boolean z8, boolean z9, boolean z10) {
        poTokenBinding.getClass();
        this.clientName = str;
        this.clientVersion = str2;
        this.clientId = str3;
        this.userAgent = str4;
        this.osName = str5;
        this.osVersion = str6;
        this.deviceMake = str7;
        this.deviceModel = str8;
        this.androidSdkVersion = str9;
        this.platform = str10;
        this.buildId = str11;
        this.cronetVersion = str12;
        this.packageName = str13;
        this.friendlyName = str14;
        this.loginSupported = z;
        this.loginRequired = z2;
        this.useSignatureTimestamp = z3;
        this.isEmbedded = z4;
        this.useWebPoTokens = z5;
        this.requirePoToken = z6;
        this.poTokenBinding = poTokenBinding;
        this.includeUserAgentInContext = z7;
        this.useSabr = z8;
        this.useMusicPlayerEndpoint = z9;
        this.skipPlayerResponseValidation = z10;
    }

    public /* synthetic */ YouTubeClient(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, boolean z, boolean z2, int i) {
        this(str, str2, str3, str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : "MOBILE", (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : str11, (i & 4096) != 0 ? null : str12, (i & 8192) != 0 ? null : str13, (i & 16384) != 0 ? false : z, (32768 & i) == 0, (65536 & i) != 0 ? false : z2, (131072 & i) == 0, (262144 & i) == 0, (524288 & i) == 0, (1048576 & i) != 0 ? PoTokenBinding.VIDEO_ID : PoTokenBinding.VISITOR_DATA, (2097152 & i) == 0, false, (8388608 & i) == 0, (i & 16777216) == 0);
    }
}
