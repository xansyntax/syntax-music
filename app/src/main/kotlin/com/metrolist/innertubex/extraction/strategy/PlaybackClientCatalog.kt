package com.metrolist.innertubex.extraction.strategy

import com.metrolist.innertubex.models.PoTokenBinding
import com.metrolist.innertubex.models.YouTubeClient

object PlaybackClientCatalog {
    val manifests: List<PlaybackClientManifest>
    val automaticManifests: List<PlaybackClientManifest>
    val options: List<PlaybackClientOption>

    init {
        val webBotguard = PoTokenProviderKind.WEB_BOTGUARD
        val webpageAttestation = PoTokenProviderKind.WEBPAGE_ATTESTATION
        val external = PoTokenProviderKind.EXTERNAL
        val webProviders = setOf(webBotguard, webpageAttestation, external)
        val webpageProviders = setOf(webpageAttestation, external)
        val androidProviders = setOf(PoTokenProviderKind.ANDROID_DROIDGUARD, external)
        val iosProviders = setOf(PoTokenProviderKind.IOS_ATTESTATION, external)

        val emptyRule = PoTokenRule()
        val videoIdBinding = PoTokenBinding.VIDEO_ID
        require(webProviders.isNotEmpty()) { "A PO token rule must declare at least one compatible provider" }
        val visitorDataBinding = PoTokenBinding.VISITOR_DATA
        val required = PoTokenRequirement.REQUIRED
        val webVisitorRule = PoTokenRule(required, visitorDataBinding, webProviders)
        val webVideoRequiredRule = PoTokenRule(required, videoIdBinding, webProviders, premiumMayBypass = true)
        val optional = PoTokenRequirement.OPTIONAL
        val webVideoOptionalRule = PoTokenRule(optional, videoIdBinding, webProviders)
        val webpageVisitorRule = PoTokenRule(required, visitorDataBinding, webpageProviders)
        val webpageVideoRequiredRule = PoTokenRule(required, videoIdBinding, webpageProviders)
        val webpageVideoOptionalRule = PoTokenRule(optional, videoIdBinding, webpageProviders)
        val androidVisitorOptionalRule = PoTokenRule(optional, visitorDataBinding, androidProviders)
        require(androidProviders.isNotEmpty()) { "A PO token rule must declare at least one compatible provider" }
        val androidVisitorRequiredRule = PoTokenRule(required, visitorDataBinding, androidProviders)
        val androidVideoRequiredRule = PoTokenRule(required, videoIdBinding, androidProviders)
        val iosVisitorOptionalRule = PoTokenRule(optional, visitorDataBinding, iosProviders)
        val iosVideoRequiredRule = PoTokenRule(required, videoIdBinding, iosProviders)

        val standardRequestCapabilities = ClientRequestCapabilities(
            signatureTimestamp = true,
            cookies = true,
        )

        val supported = CapabilitySupport.SUPPORTED
        val limited = CapabilitySupport.LIMITED
        val unsupported = CapabilitySupport.UNSUPPORTED
        val unknown = CapabilitySupport.UNKNOWN

        val contentCapsAllSupported = ClientContentCapabilities(
            normal = supported,
            explicit = supported,
            kids = limited,
            ageRestricted = supported,
            live = supported,
        )
        val contentCapsCopyDefault = contentCapsAllSupported.copy(
            normal = limited,
            explicit = contentCapsAllSupported.explicit,
            kids = contentCapsAllSupported.kids,
            ageRestricted = supported,
            live = contentCapsAllSupported.live,
            uploads = contentCapsAllSupported.uploads,
        )
        val contentCapsLimitedLive = ClientContentCapabilities(
            normal = supported,
            explicit = supported,
            kids = supported,
            ageRestricted = unknown,
            live = supported,
        )

        val directOnly = setOf(PlaybackTransport.DIRECT)
        val directAndHls = setOf(PlaybackTransport.DIRECT, PlaybackTransport.HLS)
        val sabrOnly = setOf(PlaybackTransport.SABR)

        val visionOsContent = ClientContentCapabilities(
            normal = limited,
            explicit = unsupported,
            kids = unsupported,
            ageRestricted = unknown,
            live = unsupported,
        )
        val visionOsBenchmarkEvidence = setOf("Android playback benchmark (2026-08-13)", "Playback live matrix", "yt-dlp client inventory")
        val unreleased = ClientLifecycle.UNRELEASED
        val probeOnly = ClientSelectionMode.PROBE_ONLY
        val visionOsManifest = manifest(
            priority = 100,
            lifecycle = unreleased,
            selectionMode = probeOnly,
            transports = directOnly,
            content = visionOsContent,
            evidence = visionOsBenchmarkEvidence,
            client = YouTubeClient.VISIONOS,
            id = "VISIONOS",
            displayName = "visionOS 1.02",
            notes = "Passed normal playback with backward and forward seeks on an authenticated device, but clean Android sessions can stall before receiving media. Internal/unreleased; made-for-kids and age-restricted media were rejected.",
        )

        val visionOs01Content = ClientContentCapabilities(
            normal = supported,
            explicit = limited,
            kids = unsupported,
            ageRestricted = supported,
            live = unknown,
            uploads = unknown,
        )
        val visionOs01Evidence = setOf("Android playback benchmark (2026-08-13)", "Playback live matrix")
        val deprecated = ClientLifecycle.DEPRECATED
        val visionOs01Manifest = manifest(
            priority = 100,
            lifecycle = deprecated,
            selectionMode = probeOnly,
            transports = directOnly,
            content = visionOs01Content,
            evidence = visionOs01Evidence,
            client = YouTubeClient.VISIONOS_0_1,
            id = "VISIONOS_0_1",
            displayName = "visionOS 0.1",
            notes = "September 2026 capture: two anonymous normal audio requests without visitorData were UNPLAYABLE; the same requests with watch-config visitorData returned direct audio (one complete file, one initial range). One anonymous desktop normal sample passed 90-second decoded playback with backward and forward seeks. Public selection stays probe-only without visitor context; internal automatic extraction tries visitor-backed normal audio only. Earlier HTTP 400 reports and other content remain unverified.",
        )

        val vrContent = ClientContentCapabilities(
            normal = unsupported,
            explicit = unsupported,
            kids = unsupported,
            ageRestricted = limited,
            live = unsupported,
        )
        val vrEvidence = setOf("Android playback benchmark (2026-08-13)", "Playback live matrix", "yt-dlp client inventory", "YouTube.js client constants")
        val stable = ClientLifecycle.STABLE
        val androidVr16510Manifest = manifest(
            priority = 40,
            lifecycle = stable,
            selectionMode = probeOnly,
            transports = directOnly,
            content = vrContent,
            benchmarkContent = globallyUnusableContent(),
            evidence = vrEvidence,
            client = YouTubeClient.ANDROID_VR_1_65_10,
            id = "ANDROID_VR_1_65_10",
            displayName = "Android VR 1.65.10",
            notes = "A live anonymous visitor request resolved, but every audio itag reached a CDN 403 after 1 MiB. Kept for explicit benchmark probing only.",
        )

        val androidVr14332Manifest = manifest(
            priority = 82,
            lifecycle = deprecated,
            selectionMode = probeOnly,
            transports = directOnly,
            content = ClientContentCapabilities(
                normal = unsupported,
                explicit = unsupported,
                kids = unsupported,
                ageRestricted = limited,
                live = unsupported,
            ),
            benchmarkContent = globallyUnusableContent(),
            evidence = setOf("Android playback benchmark (2026-08-13)", "Playback live matrix"),
            client = YouTubeClient.ANDROID_VR_1_43_32,
            id = "ANDROID_VR_1_43_32",
            displayName = "Android VR 1.43.32",
            notes = "Player requests resolve, but sustained media reaches the same later-range authorization boundary as other Android VR profiles. Retained for benchmark comparison only.",
        )

        val androidVrNoAuthManifest = manifest(
            priority = 60,
            lifecycle = deprecated,
            selectionMode = probeOnly,
            transports = directOnly,
            content = ClientContentCapabilities(
                normal = unknown,
                explicit = unsupported,
                kids = unknown,
                ageRestricted = limited,
                live = unknown,
            ),
            benchmarkContent = globallyUnusableContent(),
            evidence = setOf("Android playback benchmark (2026-08-13)", "Playback live matrix"),
            client = YouTubeClient.ANDROID_VR_NO_AUTH,
            id = "ANDROID_VR_NO_AUTH",
            displayName = "Android VR 1.61.48 (minimal)",
            notes = "Player requests resolve, but sustained media reaches a later-range authorization boundary. Retained for benchmark comparison only.",
        )

        val androidVr16148Manifest = manifest(
            priority = 64,
            lifecycle = deprecated,
            selectionMode = probeOnly,
            transports = directOnly,
            content = ClientContentCapabilities(
                normal = unknown,
                explicit = unsupported,
                kids = unknown,
                ageRestricted = limited,
                live = unknown,
            ),
            benchmarkContent = globallyUnusableContent(),
            evidence = setOf("Android playback benchmark (2026-08-13)", "Playback live matrix"),
            client = YouTubeClient.ANDROID_VR_1_61_48,
            id = "ANDROID_VR_1_61_48",
            displayName = "Android VR 1.61.48",
            notes = "Player requests resolve, but sustained media reaches a later-range authorization boundary. Retained for benchmark comparison only.",
        )

        val experimental = ClientLifecycle.EXPERIMENTAL
        val authOptional = AuthenticationPolicy.OPTIONAL
        val tvDowngradedRequestCaps = ClientRequestCapabilities(
            signatureTimestamp = true,
            webView = WebViewRequirement.NONE,
            cookies = false,
        )
        val tvDowngradedContentCaps = ClientContentCapabilities(
            normal = unknown,
            explicit = supported,
            kids = supported,
            ageRestricted = unknown,
            live = unknown,
            uploads = supported,
        )
        val tvDowngradedManifest = manifest(
            priority = 70,
            authentication = authOptional,
            lifecycle = experimental,
            selectionMode = probeOnly,
            transports = directAndHls,
            request = tvDowngradedRequestCaps,
            content = tvDowngradedContentCaps,
            benchmarkContent = globallyUnusableContent(),
            evidence = setOf("Android playback benchmark (2026-08-13)", "Playback live matrix", "yt-dlp client inventory"),
            client = YouTubeClient.TVHTML5_DOWNGRADED,
            id = "TVHTML5_DOWNGRADED",
            displayName = "TV HTML5 Downgraded",
            notes = "Matches the current yt-dlp profile but YouTube returned UNPLAYABLE in August 2026 probes. Retained for explicit compatibility testing only.",
        )

        val automatic = ClientSelectionMode.AUTOMATIC
        val webRemixPoTokens = ClientPoTokenCapabilities(emptyRule, webVideoRequiredRule)
        val webRemixEvidence = setOf("Android playback benchmark (2026-08-13)", "Playback live matrix", "yt-dlp client inventory", "YouTube.js client constants")
        val webRemixManifest = manifest(
            priority = 70,
            authentication = authOptional,
            lifecycle = stable,
            selectionMode = automatic,
            transports = directAndHls,
            poTokens = webRemixPoTokens,
            request = standardRequestCapabilities,
            content = contentCapsCopyDefault,
            evidence = webRemixEvidence,
            client = YouTubeClient.WEB_REMIX,
            id = "WEB_REMIX",
            displayName = "Web Remix",
            notes = "Passed normal, made-for-kids, and age-restricted playback with backward and forward seeks.",
        )

        val authRequired = AuthenticationPolicy.REQUIRED
        val webCreatorPoTokens = ClientPoTokenCapabilities(emptyRule, webVideoRequiredRule)
        val webCreatorEvidence = setOf("Android playback benchmark (2026-08-13)", "Playback live matrix", "yt-dlp client inventory", "YouTube.js client constants")
        val webCreatorManifest = manifest(
            priority = 55,
            authentication = authRequired,
            lifecycle = stable,
            selectionMode = automatic,
            transports = directAndHls,
            poTokens = webCreatorPoTokens,
            request = standardRequestCapabilities,
            content = contentCapsCopyDefault,
            evidence = webCreatorEvidence,
            client = YouTubeClient.WEB_CREATOR,
            id = "WEB_CREATOR",
            displayName = "Web Creator",
            notes = "Passed normal, made-for-kids, and age-restricted playback with backward and forward seeks. Requires a signed-in account.",
        )

        val tvSimplyPoTokens = ClientPoTokenCapabilities(webVisitorRule, webVideoRequiredRule)
        val tvSimplyRequestCaps = standardRequestCapabilities.copy(
            webView = WebViewRequirement.REQUIRED_TOKEN_MINTING,
        )
        val tvSimplyContent = ClientContentCapabilities(
            normal = unsupported,
            explicit = supported,
            kids = unsupported,
            ageRestricted = unknown,
            live = unsupported,
        )
        val tvSimplyBenchmarkContent = ClientContentCapabilities(
            normal = limited,
            explicit = supported,
            kids = unknown,
            ageRestricted = unknown,
            live = unknown,
        )
        val tvSimplyEvidence = setOf("Android playback benchmark (2026-08-13)", "Playback live matrix", "yt-dlp client inventory", "YouTube.js client constants")
        val tvSimplyManifest = manifest(
            priority = 42,
            lifecycle = experimental,
            selectionMode = automatic,
            transports = directAndHls,
            poTokens = tvSimplyPoTokens,
            request = tvSimplyRequestCaps,
            content = tvSimplyContent,
            benchmarkContent = tvSimplyBenchmarkContent,
            evidence = tvSimplyEvidence,
            client = YouTubeClient.TVHTML5_SIMPLY,
            id = "TVHTML5_SIMPLY",
            displayName = "TV HTML5 Simply",
            notes = "The two-token HLS path passed both normal samples, both made-for-kids samples, and one explicit sample with sustained playback and bidirectional seeks.",
        )

        val webEmbeddedRequestCaps = standardRequestCapabilities.copy(
            webView = WebViewRequirement.NONE,
            embedded = true,
            encryptedHostFlags = true,
        )
        val webEmbeddedContent = ClientContentCapabilities(
            normal = supported,
            explicit = unknown,
            kids = supported,
            ageRestricted = unsupported,
            live = unsupported,
            uploads = unsupported,
        )
        val webEmbeddedBenchmarkContent = ClientContentCapabilities(
            normal = unsupported,
            explicit = supported,
            kids = unknown,
            ageRestricted = unknown,
            live = unknown,
        )
        val webEmbeddedEvidence = setOf("Android playback benchmark (2026-08-13)", "Playback live matrix", "yt-dlp client inventory", "YouTube.js client constants")
        val webEmbeddedManifest = manifest(
            priority = 65,
            authentication = authOptional,
            lifecycle = stable,
            selectionMode = automatic,
            transports = directAndHls,
            request = webEmbeddedRequestCaps,
            content = webEmbeddedContent,
            benchmarkContent = webEmbeddedBenchmarkContent,
            evidence = webEmbeddedEvidence,
            client = YouTubeClient.WEB_EMBEDDED_PLAYER,
            id = "WEB_EMBEDDED_PLAYER",
            displayName = "Web Embedded",
            notes = "Normal and made-for-kids playback passed sustained playback and both seek directions after fetching per-video encryptedHostFlags; age-restricted media was rejected.",
        )

        val androidVrSabrPoTokens = ClientPoTokenCapabilities(androidVisitorOptionalRule, androidVideoRequiredRule)
        val androidVrSabrContent = ClientContentCapabilities(
            normal = unsupported,
            explicit = unsupported,
            kids = unsupported,
            ageRestricted = unsupported,
            live = unsupported,
        )
        val androidVrSabrEvidence = setOf("Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "Playback live matrix", "yt-dlp client inventory")
        val androidVrSabrManifest = manifest(
            priority = 68,
            lifecycle = experimental,
            selectionMode = probeOnly,
            transports = sabrOnly,
            poTokens = androidVrSabrPoTokens,
            content = androidVrSabrContent,
            benchmarkContent = globallyUnusableContent(),
            evidence = androidVrSabrEvidence,
            client = YouTubeClient.ANDROID_VR_SABR,
            id = "ANDROID_VR_SABR",
            displayName = "Android VR 1.65.10 (SABR)",
            notes = "Passed 0 of 6 current benchmark cases. Normal responses reached media but did not advance; explicit and made-for-kids samples were rejected or failed media without DroidGuard.",
        )

        val webRemixSabrContent = ClientContentCapabilities(
            normal = unknown,
            explicit = supported,
            kids = supported,
            ageRestricted = unknown,
            live = supported,
        )
        val webRemixSabrBenchmarkContent = ClientContentCapabilities(
            normal = supported,
            explicit = supported,
            kids = unknown,
            ageRestricted = unknown,
            live = unknown,
        )
        val webRemixSabrPoTokens = ClientPoTokenCapabilities(emptyRule, webpageVideoOptionalRule)
        val webRemixSabrEvidence = setOf("Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "Playback live matrix")
        val webRemixSabrManifest = manifest(
            priority = 52,
            authentication = authOptional,
            lifecycle = experimental,
            selectionMode = automatic,
            transports = sabrOnly,
            poTokens = webRemixSabrPoTokens,
            request = standardRequestCapabilities,
            content = webRemixSabrContent,
            benchmarkContent = webRemixSabrBenchmarkContent,
            evidence = webRemixSabrEvidence,
            client = YouTubeClient.WEB_REMIX_SABR,
            id = "WEB_REMIX_SABR",
            displayName = "Web Remix (SABR)",
            notes = "Passed all 6 current normal, explicit, and made-for-kids cases with 90-second playback, bidirectional seeks, and complete telemetry without a PO token.",
        )

        val webSabrPoTokens = ClientPoTokenCapabilities(emptyRule, webpageVideoRequiredRule)
        val webSabrRequestCaps = standardRequestCapabilities.copy(
            webView = WebViewRequirement.REQUIRED_TOKEN_MINTING,
        )
        val webSabrEvidence = setOf("Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "Playback live matrix", "yt-dlp client inventory")
        val webSabrManifest = manifest(
            priority = 44,
            authentication = authOptional,
            lifecycle = experimental,
            selectionMode = automatic,
            transports = sabrOnly,
            poTokens = webSabrPoTokens,
            request = webSabrRequestCaps,
            content = contentCapsLimitedLive,
            evidence = webSabrEvidence,
            client = YouTubeClient.WEB_SABR,
            id = "WEB_SABR",
            displayName = "Web (SABR)",
            notes = "Page-bound GVS tokens passed all 6 current normal, explicit, and made-for-kids cases with 90-second playback, bidirectional seeks, and complete telemetry.",
        )

        val tvSimplySabrPoTokens = ClientPoTokenCapabilities(webpageVisitorRule, webpageVideoRequiredRule)
        val tvSimplySabrRequestCaps = standardRequestCapabilities.copy(
            webView = WebViewRequirement.REQUIRED_TOKEN_MINTING,
        )
        val tvSimplySabrContent = ClientContentCapabilities(
            normal = unsupported,
            explicit = supported,
            kids = unsupported,
            ageRestricted = unknown,
            live = unsupported,
        )
        val tvSimplySabrBenchmarkContent = ClientContentCapabilities(
            normal = limited,
            explicit = supported,
            kids = unsupported,
            ageRestricted = unknown,
            live = unsupported,
        )
        val tvSimplySabrEvidence = setOf("Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "Playback live matrix")
        val tvSimplySabrManifest = manifest(
            priority = 36,
            lifecycle = experimental,
            selectionMode = automatic,
            transports = sabrOnly,
            poTokens = tvSimplySabrPoTokens,
            request = tvSimplySabrRequestCaps,
            content = tvSimplySabrContent,
            benchmarkContent = tvSimplySabrBenchmarkContent,
            evidence = tvSimplySabrEvidence,
            client = YouTubeClient.TVHTML5_SIMPLY_SABR,
            id = "TVHTML5_SIMPLY_SABR",
            displayName = "TV HTML5 Simply (SABR)",
            notes = "Passed both normal and both made-for-kids samples with 90-second playback, bidirectional seeks, and complete telemetry. One of two explicit samples passed; explicit content remains excluded from automatic selection.",
        )

        val mwebPoTokens = ClientPoTokenCapabilities(emptyRule, webpageVideoRequiredRule)
        val mwebEvidence = setOf("Android playback benchmark (2026-08-13)", "Playback live matrix", "yt-dlp client inventory", "YouTube.js client constants")
        val mwebManifest = manifest(
            priority = 38,
            authentication = authOptional,
            lifecycle = experimental,
            selectionMode = probeOnly,
            transports = directAndHls,
            poTokens = mwebPoTokens,
            request = standardRequestCapabilities,
            content = contentCapsLimitedLive,
            evidence = mwebEvidence,
            client = YouTubeClient.MWEB,
            id = "MWEB",
            displayName = "Mobile Web",
            notes = "Page-bound GVS tokens passed normal, made-for-kids, and age-restricted playback. Fresh tokenized URLs can return several transient HTTP 403 responses before becoming usable.",
        )

        val mwebSabrPoTokens = ClientPoTokenCapabilities(emptyRule, webpageVideoRequiredRule)
        val mwebSabrRequestCaps = standardRequestCapabilities.copy(
            webView = WebViewRequirement.REQUIRED_TOKEN_MINTING,
        )
        val mwebSabrBenchmarkContent = contentCapsLimitedLive.copy(
            normal = limited,
        )
        val mwebSabrEvidence = setOf("Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "Playback live matrix", "yt-dlp client inventory")
        val mwebSabrManifest = manifest(
            priority = 32,
            authentication = authOptional,
            lifecycle = experimental,
            selectionMode = automatic,
            transports = sabrOnly,
            poTokens = mwebSabrPoTokens,
            request = mwebSabrRequestCaps,
            content = contentCapsLimitedLive,
            benchmarkContent = mwebSabrBenchmarkContent,
            evidence = mwebSabrEvidence,
            client = YouTubeClient.MWEB_SABR,
            id = "MWEB_SABR",
            displayName = "Mobile Web (SABR)",
            notes = "Passed 5 of 6 current cases with 90-second playback and bidirectional seeks. One explicit sample had a media failure; runtime health fallback remains enabled.",
        )

        val webSafariSabrPoTokens = ClientPoTokenCapabilities(emptyRule, webpageVideoRequiredRule)
        val webSafariSabrRequestCaps = standardRequestCapabilities.copy(
            webView = WebViewRequirement.REQUIRED_TOKEN_MINTING,
        )
        val webSafariSabrEvidence = setOf("Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "Playback live matrix", "yt-dlp client inventory")
        val webSafariSabrManifest = manifest(
            priority = 28,
            authentication = authOptional,
            lifecycle = experimental,
            selectionMode = automatic,
            transports = sabrOnly,
            poTokens = webSafariSabrPoTokens,
            request = webSafariSabrRequestCaps,
            content = contentCapsLimitedLive,
            evidence = webSafariSabrEvidence,
            client = YouTubeClient.WEB_SAFARI_SABR,
            id = "WEB_SAFARI_SABR",
            displayName = "Web Safari (SABR)",
            notes = "Page-bound GVS tokens passed all 6 current normal, explicit, and made-for-kids cases with 90-second playback, bidirectional seeks, and complete telemetry.",
        )

        val webKidsRequestCaps = standardRequestCapabilities.copy(
            webView = WebViewRequirement.NONE,
        )
        val webKidsContent = ClientContentCapabilities(
            normal = unsupported,
            explicit = unsupported,
            kids = supported,
            ageRestricted = unsupported,
            live = unsupported,
            uploads = unsupported,
        )
        val webKidsEvidence = setOf("Android playback benchmark (2026-08-13)", "YouTube.js client constants")
        val webKidsManifest = manifest(
            priority = 55,
            lifecycle = experimental,
            selectionMode = automatic,
            transports = directOnly,
            request = webKidsRequestCaps,
            content = webKidsContent,
            evidence = webKidsEvidence,
            client = YouTubeClient.WEB_KIDS,
            id = "WEB_KIDS",
            displayName = "Web Kids",
            notes = "Made-for-kids playback passed 70 seconds plus backward and forward seeks; normal and age-restricted playback are unavailable.",
        )

        val broken = ClientLifecycle.BROKEN
        val tvHtml5PoTokens = ClientPoTokenCapabilities(emptyRule, webVideoOptionalRule)
        val tvHtml5Evidence = setOf("Android playback benchmark (2026-08-13)", "yt-dlp client inventory")
        val tvHtml5Manifest = manifest(
            priority = 0,
            authentication = authOptional,
            lifecycle = broken,
            selectionMode = probeOnly,
            transports = directAndHls,
            poTokens = tvHtml5PoTokens,
            request = standardRequestCapabilities,
            content = contentCapsAllSupported,
            evidence = tvHtml5Evidence,
            client = YouTubeClient.TVHTML5,
            id = "TVHTML5",
            displayName = "TV HTML5",
            notes = "Previous probes returned no direct or HLS audio; retained for benchmark regression checks.",
        )

        val webSafariPoTokens = ClientPoTokenCapabilities(emptyRule, webVideoRequiredRule)
        val webSafariEvidence = setOf("Android playback benchmark (2026-08-13)", "yt-dlp client inventory")
        val webSafariManifest = manifest(
            priority = 0,
            authentication = authOptional,
            lifecycle = broken,
            selectionMode = probeOnly,
            transports = directAndHls,
            poTokens = webSafariPoTokens,
            request = standardRequestCapabilities,
            content = globallyUnusableContent(),
            evidence = webSafariEvidence,
            client = YouTubeClient.WEB_SAFARI,
            id = "WEB_SAFARI",
            displayName = "Web Safari",
            notes = "Previous responses exposed SABR-only media; retained to detect direct-stream regressions.",
        )

        val visionOsSabrContent = ClientContentCapabilities(
            normal = supported,
            explicit = limited,
            kids = unsupported,
            ageRestricted = supported,
            live = unknown,
            uploads = unknown,
        )
        val visionOsSabrEvidence = setOf("Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "Playback live matrix", "yt-dlp client inventory")
        val visionOsSabrManifest = manifest(
            priority = 0,
            lifecycle = unreleased,
            selectionMode = automatic,
            transports = sabrOnly,
            content = visionOsSabrContent,
            evidence = visionOsSabrEvidence,
            client = YouTubeClient.VISIONOS_SABR,
            id = "VISIONOS_SABR",
            displayName = "visionOS 1.02 (SABR)",
            notes = "Passed both normal samples and one non-age-gated explicit audio sample with 90-second playback and bidirectional seeks. Kids and age-gated media were rejected; explicit support remains limited to reflect the single successful sample.",
        )

        val tvHtml5SabrPoTokens = ClientPoTokenCapabilities(emptyRule, webVideoOptionalRule)
        val tvHtml5SabrEvidence = setOf("Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "yt-dlp client inventory")
        val tvHtml5SabrManifest = manifest(
            priority = 0,
            authentication = authOptional,
            lifecycle = broken,
            selectionMode = probeOnly,
            transports = sabrOnly,
            poTokens = tvHtml5SabrPoTokens,
            request = standardRequestCapabilities,
            content = contentCapsAllSupported,
            evidence = tvHtml5SabrEvidence,
            client = YouTubeClient.TVHTML5_SABR,
            id = "TVHTML5_SABR",
            displayName = "TV HTML5 (SABR)",
            notes = "Passed 0 of 6 current cases; every player request was rejected. Retained for regression checks.",
        )

        val androidPoTokens = ClientPoTokenCapabilities(androidVisitorOptionalRule, androidVideoRequiredRule)
        val androidContent = ClientContentCapabilities(
            normal = unknown,
            explicit = unsupported,
            kids = unsupported,
            ageRestricted = unknown,
            live = unknown,
        )
        val androidEvidence = setOf("Android playback benchmark (2026-08-13)", "yt-dlp client inventory", "YouTube.js client constants")
        val androidManifest = manifest(
            priority = 0,
            lifecycle = broken,
            selectionMode = probeOnly,
            transports = directAndHls,
            poTokens = androidPoTokens,
            content = androidContent,
            evidence = androidEvidence,
            client = YouTubeClient.ANDROID,
            id = "ANDROID",
            displayName = "Android 21.26.364",
            notes = "Previous responses exposed SABR-only media and require unavailable DroidGuard attestation.",
        )

        val androidSabrContent = ClientContentCapabilities(
            normal = unknown,
            explicit = unknown,
            kids = unknown,
            ageRestricted = unknown,
            live = unknown,
        )
        val androidSabrEvidence = setOf("Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "yt-dlp client inventory")
        val androidSabrManifest = manifest(
            priority = 0,
            lifecycle = broken,
            selectionMode = probeOnly,
            transports = sabrOnly,
            poTokens = androidPoTokens,
            content = androidSabrContent,
            benchmarkContent = globallyUnusableContent().copy(normal = limited),
            evidence = androidSabrEvidence,
            client = YouTubeClient.ANDROID_SABR,
            id = "ANDROID_SABR",
            displayName = "Android 21.26.364 (SABR)",
            notes = "Passed 1 of 2 normal cases but failed the other 5 current cases. No DroidGuard-compatible token provider is available, so this remains probe-only.",
        )

        val iosPoTokens = ClientPoTokenCapabilities(iosVisitorOptionalRule, iosVideoRequiredRule)
        val iosContent = ClientContentCapabilities(
            normal = unknown,
            explicit = unsupported,
            kids = unsupported,
            ageRestricted = unknown,
            live = unknown,
        )
        val iosEvidence = setOf("yt-dlp client inventory", "YouTube.js client constants")
        val iosManifest = manifest(
            priority = 0,
            lifecycle = broken,
            selectionMode = probeOnly,
            transports = directAndHls,
            poTokens = iosPoTokens,
            content = iosContent,
            evidence = iosEvidence,
            client = YouTubeClient.IOS,
            id = "IOS",
            displayName = "iOS 21.26.4",
            notes = "Previous responses exposed SABR-only media and require unavailable iOS attestation.",
        )

        val iosSabrEvidence = setOf("Android SABR benchmark (2026-08-20)", "yt-dlp client inventory")
        val iosSabrManifest = manifest(
            priority = 0,
            lifecycle = broken,
            selectionMode = probeOnly,
            transports = sabrOnly,
            poTokens = iosPoTokens,
            content = ClientContentCapabilities(),
            evidence = iosSabrEvidence,
            client = YouTubeClient.IOS_SABR,
            id = "IOS_SABR",
            displayName = "iOS 21.26.4 (SABR)",
            notes = "Passed 0 of 6 current cases. No iOS-compatible token provider is available.",
        )

        val ipadosManifest = manifest(
            priority = 0,
            lifecycle = broken,
            selectionMode = probeOnly,
            transports = directAndHls,
            poTokens = iosPoTokens,
            content = iosContent,
            evidence = setOf("Playback live matrix"),
            client = YouTubeClient.IPADOS,
            id = "IPADOS",
            displayName = "iPadOS 17.7.10",
            notes = "Previous responses exposed SABR-only media and require unavailable iOS attestation.",
        )

        val tvSimplyEmbeddedPoTokens = ClientPoTokenCapabilities(webVisitorRule, webVideoRequiredRule)
        val tvSimplyEmbeddedRequestCaps = standardRequestCapabilities.copy(
            webView = WebViewRequirement.REQUIRED_TOKEN_MINTING,
        )
        val tvSimplyEmbeddedManifest = manifest(
            priority = 0,
            lifecycle = broken,
            selectionMode = probeOnly,
            transports = directOnly,
            poTokens = tvSimplyEmbeddedPoTokens,
            request = tvSimplyEmbeddedRequestCaps,
            content = globallyUnusableContent(),
            evidence = setOf("YouTube.js client constants"),
            client = YouTubeClient.TVHTML5_SIMPLY_EMBEDDED_PLAYER,
            id = "TVHTML5_SIMPLY_EMBEDDED_PLAYER",
            displayName = "TV HTML5 Simply Embedded",
            notes = "YouTube previously reported this application and device as unsupported.",
        )

        val androidMusicPoTokens = ClientPoTokenCapabilities(androidVisitorRequiredRule, androidVideoRequiredRule)
        val androidMusicManifest = manifest(
            priority = 0,
            lifecycle = broken,
            selectionMode = probeOnly,
            transports = directOnly,
            poTokens = androidMusicPoTokens,
            content = globallyUnusableContent(),
            evidence = setOf("YouTube.js client constants"),
            client = YouTubeClient.ANDROID_MUSIC,
            id = "ANDROID_MUSIC",
            displayName = "Android Music 5.34.51",
            notes = "Previous player requests returned HTTP 400 FAILED_PRECONDITION.",
        )

        val androidCreatorManifest = manifest(
            priority = 0,
            authentication = authRequired,
            lifecycle = broken,
            selectionMode = probeOnly,
            transports = directOnly,
            content = globallyUnusableContent(),
            evidence = setOf("YouTube.js client constants"),
            client = YouTubeClient.ANDROID_CREATOR,
            id = "ANDROID_CREATOR",
            displayName = "Android Studio 25.03.101",
            notes = "Previous player requests returned HTTP 400 INVALID_ARGUMENT.",
        )

        val probeUnknownContent = ClientContentCapabilities(
            normal = unknown,
            explicit = unknown,
            kids = unknown,
            ageRestricted = unknown,
            live = unknown,
            uploads = unknown,
        )
        val historicalEvidence = setOf("pytubefix innertube.py (b6521f09)", "YouTube-Internal-Clients survey (2022)")
        val iosMusicManifest = manifest(
            priority = 0,
            lifecycle = experimental,
            selectionMode = probeOnly,
            transports = directOnly,
            content = probeUnknownContent,
            evidence = historicalEvidence,
            client = YouTubeClient.IOS_MUSIC,
            id = "IOS_MUSIC",
            displayName = "iOS Music probe",
            notes = "Historical iOS Music identity and app fields; playback and transport support are unverified.",
        )

        val androidKidsManifest = manifest(
            priority = 0,
            lifecycle = experimental,
            selectionMode = probeOnly,
            transports = directOnly,
            content = probeUnknownContent,
            evidence = historicalEvidence,
            client = YouTubeClient.ANDROID_KIDS,
            id = "ANDROID_KIDS",
            displayName = "Android Kids probe",
            notes = "Historical Android Kids identity and app fields; playback and transport support are unverified.",
        )

        val androidProducerManifest = manifest(
            priority = 0,
            lifecycle = experimental,
            selectionMode = probeOnly,
            transports = directOnly,
            content = probeUnknownContent,
            evidence = setOf("pytubefix innertube.py (b6521f09)"),
            client = YouTubeClient.ANDROID_PRODUCER,
            id = "ANDROID_PRODUCER",
            displayName = "Android Producer probe",
            notes = "Android Producer identity and app fields from the pinned source; playback is unverified.",
        )

        val mediaConnectFrontendManifest = manifest(
            priority = 0,
            lifecycle = experimental,
            selectionMode = probeOnly,
            transports = directOnly,
            content = probeUnknownContent,
            evidence = historicalEvidence,
            client = YouTubeClient.MEDIA_CONNECT_FRONTEND,
            id = "MEDIA_CONNECT_FRONTEND",
            displayName = "Media Connect Frontend probe",
            notes = "Historical Media Connect identity and app fields; playback and transport support are unverified.",
        )

        val webApiPoTokens = ClientPoTokenCapabilities(emptyRule, webVideoRequiredRule)
        val apiOnly = ClientSelectionMode.API_ONLY
        val webApiEvidence = setOf("yt-dlp client inventory", "YouTube.js client constants")
        val webApiManifest = manifest(
            priority = 0,
            authentication = authOptional,
            lifecycle = stable,
            selectionMode = apiOnly,
            transports = emptySet(),
            poTokens = webApiPoTokens,
            request = standardRequestCapabilities,
            content = contentCapsAllSupported,
            evidence = webApiEvidence,
            client = YouTubeClient.WEB,
            id = "WEB",
            displayName = "Web API",
            notes = "Used for metadata/transcript calls. Playback uses the explicit WEB_SABR profile.",
        )

        val allManifests = listOf(
            visionOsManifest,
            visionOs01Manifest,
            androidVr16510Manifest,
            androidVr14332Manifest,
            androidVrNoAuthManifest,
            androidVr16148Manifest,
            tvDowngradedManifest,
            webRemixManifest,
            webCreatorManifest,
            tvSimplyManifest,
            webEmbeddedManifest,
            androidVrSabrManifest,
            webRemixSabrManifest,
            webSabrManifest,
            tvSimplySabrManifest,
            mwebManifest,
            mwebSabrManifest,
            webSafariSabrManifest,
            webKidsManifest,
            tvHtml5Manifest,
            webSafariManifest,
            visionOsSabrManifest,
            tvHtml5SabrManifest,
            androidManifest,
            androidSabrManifest,
            iosManifest,
            iosSabrManifest,
            ipadosManifest,
            tvSimplyEmbeddedManifest,
            androidMusicManifest,
            androidCreatorManifest,
            iosMusicManifest,
            androidKidsManifest,
            androidProducerManifest,
            mediaConnectFrontendManifest,
            webApiManifest,
        )

        val ids = allManifests.map { it.id }
        require(ids.toSet().size == allManifests.size) {
            "Playback client manifest IDs must be unique"
        }
        val clientProfiles = allManifests.map { it.client }
        require(clientProfiles.toSet().size == allManifests.size) {
            "Every manifest must have a distinguishable YouTubeClient request profile"
        }

        manifests = allManifests
        options = allManifests
            .filter { it.selectionMode !in setOf(ClientSelectionMode.DISABLED, ClientSelectionMode.API_ONLY) }
            .map { PlaybackClientOption(it.id, it.displayName, it.client, it) }
        automaticManifests = allManifests
            .filter { it.selectionMode == ClientSelectionMode.AUTOMATIC }
    }

    fun find(id: String): PlaybackClientOption? {
        return options.firstOrNull { it.id == id }
    }

    fun findManifest(id: String): PlaybackClientManifest? {
        return manifests.firstOrNull { it.id == id }
    }

    fun globallyUnusableContent(): ClientContentCapabilities {
        val unsupported = CapabilitySupport.UNSUPPORTED
        return ClientContentCapabilities(
            normal = unsupported,
            explicit = unsupported,
            kids = unsupported,
            ageRestricted = unsupported,
            live = unsupported,
            uploads = unsupported,
        )
    }

    fun manifest(
        priority: Int,
        authentication: AuthenticationPolicy = AuthenticationPolicy.UNSUPPORTED,
        content: ClientContentCapabilities,
        benchmarkContent: ClientContentCapabilities? = null,
        lifecycle: ClientLifecycle,
        poTokens: ClientPoTokenCapabilities = ClientPoTokenCapabilities(),
        request: ClientRequestCapabilities? = null,
        selectionMode: ClientSelectionMode,
        client: YouTubeClient,
        id: String,
        displayName: String,
        notes: String,
        transports: Set<PlaybackTransport>,
        evidence: Set<String>,
    ): PlaybackClientManifest {
        val req = request ?: ClientRequestCapabilities(
            signatureTimestamp = client.useSignatureTimestamp,
            embedded = client.isEmbedded,
        )
        val benchContent = benchmarkContent ?: if (lifecycle == ClientLifecycle.BROKEN) {
            globallyUnusableContent()
        } else {
            content
        }
        return PlaybackClientManifest(
            id = id,
            displayName = displayName,
            client = client,
            lifecycle = lifecycle,
            selectionMode = selectionMode,
            authentication = authentication,
            transports = transports,
            poTokens = poTokens,
            request = req,
            content = content,
            benchmarkContent = benchContent,
            priority = priority.toByte(),
            evidence = evidence,
            notes = notes,
        )
    }

    fun profileIds(playbackClientManifest: PlaybackClientManifest, includePo: Boolean): Set<String> {
        val strM = "${playbackClientManifest.id}__${if (includePo) "po" else "nopo"}"
        val youTubeClient = playbackClientManifest.client
        val sb = StringBuilder()
        sb.append(youTubeClient.clientName)
        sb.append('_')
        sb.append(youTubeClient.friendlyName ?: youTubeClient.clientVersion)
        if (youTubeClient.isEmbedded) {
            sb.append("_embedded")
        }
        val string = sb.toString()
        val strReplaceAll = Regex("[^A-Za-z0-9_.-]").replace(string, "_")
        return setOf(strM, "${strReplaceAll}_${if (includePo) "po" else "nopo"}")
    }
}
