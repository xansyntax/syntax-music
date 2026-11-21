package com.metrolist.innertubex.models

import kotlinx.serialization.Serializable

@Serializable
data class YouTubeClient(
    val clientName: String,
    val clientVersion: String,
    val clientId: String,
    val userAgent: String,
    val osName: String? = null,
    val osVersion: String? = null,
    val deviceMake: String? = null,
    val deviceModel: String? = null,
    val androidSdkVersion: String? = null,
    val platform: String? = "MOBILE",
    val buildId: String? = null,
    val cronetVersion: String? = null,
    val packageName: String? = null,
    val friendlyName: String? = null,
    val loginSupported: Boolean = false,
    val loginRequired: Boolean = false,
    val useSignatureTimestamp: Boolean = false,
    val isEmbedded: Boolean = false,
    val useWebPoTokens: Boolean = false,
    val requirePoToken: Boolean = false,
    val poTokenBinding: PoTokenBinding = PoTokenBinding.VIDEO_ID,
    val includeUserAgentInContext: Boolean = false,
    val useSabr: Boolean = false,
    val useMusicPlayerEndpoint: Boolean = false,
    val skipPlayerResponseValidation: Boolean = false,
) {
    fun toContext(locale: YouTubeLocale, visitorData: String?, dataSyncId: String?): Context =
        Context(
            client = Context.Client(
                clientName = clientName,
                clientVersion = clientVersion,
                userAgent = if (includeUserAgentInContext) userAgent else null,
                osName = osName,
                osVersion = osVersion,
                deviceMake = deviceMake,
                deviceModel = deviceModel,
                androidSdkVersion = androidSdkVersion,
                platform = platform,
                gl = locale.gl.orEmpty(),
                hl = locale.hl.orEmpty(),
                visitorData = visitorData,
            ),
            thirdParty = if (isEmbedded) Context.ThirdParty() else null,
            user = Context.User(onBehalfOfUser = if (loginSupported) dataSyncId else null),
        )

    companion object {
        const val USER_AGENT_WEB = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0"
        const val ORIGIN_YOUTUBE_MUSIC = "https://music.youtube.com"
        const val REFERER_YOUTUBE_MUSIC = "https://music.youtube.com/"

        val WEB_REMIX = YouTubeClient(
            clientName = "WEB_REMIX",
            clientVersion = "1.20260707.12.00",
            clientId = "67",
            userAgent = USER_AGENT_WEB,
            platform = null,
            loginSupported = true,
            useSignatureTimestamp = true,
            useWebPoTokens = true,
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
            useMusicPlayerEndpoint = true,
        )
        val WEB_CREATOR = YouTubeClient(
            clientName = "WEB_CREATOR",
            clientVersion = "1.20260708.06.00",
            clientId = "62",
            userAgent = USER_AGENT_WEB,
            platform = null,
            loginSupported = true,
            loginRequired = true,
            useSignatureTimestamp = true,
            useWebPoTokens = true,
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val TVHTML5 = YouTubeClient(
            clientName = "TVHTML5",
            clientVersion = "7.20260707.07.00",
            clientId = "7",
            userAgent = "Mozilla/5.0 (ChromiumStylePlatform) Cobalt/25.lts.30.1034943-gold (unlike Gecko), Unknown_TV_Unknown_0/Unknown (Unknown, Unknown)",
            platform = null,
            loginSupported = true,
            useSignatureTimestamp = true,
            useWebPoTokens = true,
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val VISIONOS = YouTubeClient(
            clientName = "VISIONOS",
            clientVersion = "1.02",
            clientId = "101",
            userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 15_7_3) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/26.0 Safari/605.1.15",
            osName = "visionOS",
            osVersion = "26.5.23O471",
            deviceMake = "Apple",
            deviceModel = "RealityDevice17,1",
            friendlyName = "visionOS",
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val VISIONOS_0_1 = YouTubeClient(
            clientName = "VISIONOS",
            clientVersion = "0.1",
            clientId = "101",
            userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 14_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.5 Safari/605.1.15",
            osName = "VISION_OS",
            osVersion = "1.3",
            deviceMake = "Apple",
            deviceModel = "RealityDevice14,1",
            friendlyName = "visionOS 0.1",
            includeUserAgentInContext = true,
        )
        val ANDROID_VR_1_65_10 = YouTubeClient(
            clientName = "ANDROID_VR",
            clientVersion = "1.65.10",
            clientId = "28",
            userAgent = "com.google.android.apps.youtube.vr.oculus/1.65.10 (Linux; U; Android 12L; eureka-user Build/SQ3A.220605.009.A1) gzip",
            osName = "Android",
            osVersion = "12L",
            deviceMake = "Oculus",
            deviceModel = "Quest 3",
            androidSdkVersion = "32",
            friendlyName = "Android VR 1.65",
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val ANDROID_VR_NO_AUTH = YouTubeClient(
            clientName = "ANDROID_VR",
            clientVersion = "1.61.48",
            clientId = "28",
            userAgent = "com.google.android.apps.youtube.vr.oculus/1.61.48 (Linux; U; Android 12; en_US; Oculus Quest 3; Build/SQ3A.220605.009.A1; Cronet/132.0.6808.3)",
            platform = null,
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val ANDROID_VR_1_61_48 = YouTubeClient(
            clientName = "ANDROID_VR",
            clientVersion = "1.61.48",
            clientId = "28",
            userAgent = "com.google.android.apps.youtube.vr.oculus/1.61.48 (Linux; U; Android 12; en_US; Quest 3; Build/SQ3A.220605.009.A1; Cronet/132.0.6808.3)",
            osName = "Android",
            osVersion = "12",
            deviceMake = "Oculus",
            deviceModel = "Quest 3",
            androidSdkVersion = "32",
            buildId = "SQ3A.220605.009.A1",
            cronetVersion = "132.0.6808.3",
            packageName = "com.google.android.apps.youtube.vr.oculus",
            friendlyName = "Android VR 1.61",
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val ANDROID_VR_1_43_32 = YouTubeClient(
            clientName = "ANDROID_VR",
            clientVersion = "1.43.32",
            clientId = "28",
            userAgent = "com.google.android.apps.youtube.vr.oculus/1.43.32 (Linux; U; Android 12; en_US; Quest 3; Build/SQ3A.220605.009.A1; Cronet/107.0.5284.2)",
            osName = "Android",
            osVersion = "12",
            deviceMake = "Oculus",
            deviceModel = "Quest 3",
            androidSdkVersion = "32",
            buildId = "SQ3A.220605.009.A1",
            cronetVersion = "107.0.5284.2",
            packageName = "com.google.android.apps.youtube.vr.oculus",
            friendlyName = "Android VR 1.43",
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val TVHTML5_SIMPLY = YouTubeClient(
            clientName = "TVHTML5_SIMPLY",
            clientVersion = "1.0",
            clientId = "75",
            userAgent = "Mozilla/5.0 (ChromiumStylePlatform) Cobalt/25.lts.30.1034943-gold (unlike Gecko), Unknown_TV_Unknown_0/Unknown (Unknown, Unknown)",
            platform = null,
            useSignatureTimestamp = true,
            useWebPoTokens = true,
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val TVHTML5_SIMPLY_EMBEDDED_PLAYER = YouTubeClient(
            clientName = "TVHTML5_SIMPLY_EMBEDDED_PLAYER",
            clientVersion = "2.0",
            clientId = "85",
            userAgent = "Mozilla/5.0 (ChromiumStylePlatform) Cobalt/25.lts.30.1034943-gold (unlike Gecko), Unknown_TV_Unknown_0/Unknown (Unknown, Unknown)",
            platform = null,
            friendlyName = "TVHTML5 Simply Embedded",
            useSignatureTimestamp = true,
            isEmbedded = true,
            useWebPoTokens = true,
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val WEB = YouTubeClient(
            clientName = "WEB",
            clientVersion = "2.20260708.00.00",
            clientId = "1",
            userAgent = USER_AGENT_WEB,
            platform = null,
            loginSupported = true,
            useSignatureTimestamp = true,
            useWebPoTokens = true,
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
            useMusicPlayerEndpoint = true,
        )
        val WEB_SAFARI = WEB.copy(
            userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.5 Safari/605.1.15,gzip(gfe)",
            friendlyName = "Web Safari",
        )
        val MWEB = YouTubeClient(
            clientName = "MWEB",
            clientVersion = "2.20260708.05.00",
            clientId = "2",
            userAgent = "Mozilla/5.0 (iPad; CPU OS 16_7_10 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.6 Mobile/15E148 Safari/604.1,gzip(gfe)",
            platform = null,
            friendlyName = "Mobile Web",
            loginSupported = true,
            useSignatureTimestamp = true,
            useWebPoTokens = true,
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val WEB_EMBEDDED_PLAYER = YouTubeClient(
            clientName = "WEB_EMBEDDED_PLAYER",
            clientVersion = "2.20260708.00.00",
            clientId = "56",
            userAgent = USER_AGENT_WEB,
            platform = null,
            friendlyName = "Web Embedded",
            loginSupported = true,
            useSignatureTimestamp = true,
            isEmbedded = true,
            useWebPoTokens = true,
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val IOS = YouTubeClient(
            clientName = "IOS",
            clientVersion = "21.26.4",
            clientId = "5",
            userAgent = "com.google.ios.youtube/21.26.4 (iPhone16,2; U; CPU iOS 18_3_2 like Mac OS X;)",
            osName = "iPhone",
            osVersion = "18.3.2.22D82",
            deviceMake = "Apple",
            deviceModel = "iPhone16,2",
            friendlyName = "iOS",
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val IPADOS = IOS.copy(
            userAgent = "com.google.ios.youtube/21.26.4 (iPad7,6; U; CPU iPadOS 17_7_10 like Mac OS X; en-US)",
            osName = "iPadOS",
            osVersion = "17.7.10.21H450",
            deviceModel = "iPad7,6",
            friendlyName = "iPadOS",
        )
        val WEB_KIDS = YouTubeClient(
            clientName = "WEB_KIDS",
            clientVersion = "2.20260205.00.00",
            clientId = "76",
            userAgent = USER_AGENT_WEB,
            platform = null,
            friendlyName = "Web Kids",
            useSignatureTimestamp = true,
            useWebPoTokens = true,
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val ANDROID_MUSIC = YouTubeClient(
            clientName = "ANDROID_MUSIC",
            clientVersion = "5.34.51",
            clientId = "21",
            userAgent = "com.google.android.apps.youtube.music/5.34.51 (Linux; U; Android 11) gzip",
            osName = "Android",
            osVersion = "11",
            androidSdkVersion = "30",
            friendlyName = "Android Music",
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val ANDROID_CREATOR = YouTubeClient(
            clientName = "ANDROID_CREATOR",
            clientVersion = "25.03.101",
            clientId = "14",
            userAgent = "com.google.android.apps.youtube.creator/25.03.101 (Linux; U; Android 15; en_US; Pixel 9 Pro Fold; Build/AP3A.241005.015.A2; Cronet/132.0.6779.0)",
            osName = "Android",
            osVersion = "15",
            deviceMake = "Google",
            deviceModel = "Pixel 9 Pro Fold",
            androidSdkVersion = "35",
            buildId = "AP3A.241005.015.A2",
            cronetVersion = "132.0.6779.0",
            packageName = "com.google.android.apps.youtube.creator",
            friendlyName = "Android Studio",
            loginSupported = true,
            loginRequired = true,
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val ANDROID = YouTubeClient(
            clientName = "ANDROID",
            clientVersion = "21.26.364",
            clientId = "3",
            userAgent = "com.google.android.youtube/21.26.364 (Linux; U; Android 11) gzip",
            osName = "Android",
            osVersion = "11",
            androidSdkVersion = "30",
            friendlyName = "Android",
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val ANDROID_SABR = ANDROID.copy(friendlyName = "Android SABR", requirePoToken = true, useSabr = true)
        val WEB_REMIX_SABR = WEB_REMIX.copy(friendlyName = "Web Remix SABR", requirePoToken = true, poTokenBinding = PoTokenBinding.VISITOR_DATA, useSabr = true)
        val ANDROID_VR_SABR = ANDROID_VR_1_65_10.copy(friendlyName = "Android VR SABR", requirePoToken = true, useSabr = true)
        val VISIONOS_SABR = VISIONOS.copy(friendlyName = "visionOS SABR", requirePoToken = true, useSabr = true)
        val TVHTML5_SIMPLY_SABR = TVHTML5_SIMPLY.copy(friendlyName = "TV HTML5 Simply SABR", requirePoToken = true, useSabr = true)
        val WEB_SABR = WEB.copy(friendlyName = "Web SABR", requirePoToken = true, poTokenBinding = PoTokenBinding.VIDEO_ID, useSabr = true)
        val WEB_SAFARI_SABR = WEB_SAFARI.copy(friendlyName = "Web Safari SABR", requirePoToken = true, poTokenBinding = PoTokenBinding.VIDEO_ID, useSabr = true)
        val MWEB_SABR = MWEB.copy(friendlyName = "Mobile Web SABR", requirePoToken = true, poTokenBinding = PoTokenBinding.VIDEO_ID, useSabr = true)
        val TVHTML5_SABR = TVHTML5.copy(friendlyName = "TV HTML5 SABR", requirePoToken = true, useSabr = true)
        val IOS_SABR = IOS.copy(friendlyName = "iOS SABR", requirePoToken = true, useSabr = true)
        val TVHTML5_DOWNGRADED = YouTubeClient(
            clientName = "TVHTML5",
            clientVersion = "5.20260707",
            clientId = "7",
            userAgent = "Mozilla/5.0 (ChromiumStylePlatform) Cobalt/Version",
            platform = null,
            friendlyName = "TV HTML5 Downgraded",
            loginSupported = true,
            useSignatureTimestamp = true,
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val IOS_MUSIC = YouTubeClient(
            clientName = "IOS_MUSIC",
            clientVersion = "7.27.0",
            clientId = "26",
            userAgent = "com.google.ios.youtubemusic/7.27.0 (iPhone16,2; U; CPU iOS 18_1_0 like Mac OS X;)",
            osName = "iPhone",
            osVersion = "18.1.0.22B83",
            deviceMake = "Apple",
            deviceModel = "iPhone16,2",
            friendlyName = "iOS Music probe",
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val ANDROID_KIDS = YouTubeClient(
            clientName = "ANDROID_KIDS",
            clientVersion = "7.36.1",
            clientId = "18",
            userAgent = "com.google.android.apps.youtube.kids/7.36.1 (Linux; U; Android 11) gzip",
            osName = "Android",
            osVersion = "11",
            androidSdkVersion = "30",
            friendlyName = "Android Kids probe",
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val ANDROID_PRODUCER = YouTubeClient(
            clientName = "ANDROID_PRODUCER",
            clientVersion = "0.111.1",
            clientId = "91",
            userAgent = "com.google.android.apps.youtube.producer/0.111.1 (Linux; U; Android 11) gzip",
            osName = "Android",
            osVersion = "11",
            androidSdkVersion = "30",
            friendlyName = "Android Producer probe",
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
        val MEDIA_CONNECT_FRONTEND = YouTubeClient(
            clientName = "MEDIA_CONNECT_FRONTEND",
            clientVersion = "0.1",
            clientId = "95",
            userAgent = "Mozilla/5.0",
            platform = null,
            friendlyName = "Media Connect probe",
            poTokenBinding = PoTokenBinding.VISITOR_DATA,
        )
    }
}
