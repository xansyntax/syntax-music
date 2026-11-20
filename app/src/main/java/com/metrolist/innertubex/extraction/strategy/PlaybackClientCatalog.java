package com.metrolist.innertubex.extraction.strategy;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.PoTokenBinding;
import com.metrolist.innertubex.models.YouTubeClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptySet;
import kotlin.text.CharsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaybackClientCatalog {
    public static final PlaybackClientCatalog INSTANCE = new PlaybackClientCatalog();
    public static final ArrayList automaticManifests;
    public static final List manifests;
    public static final ArrayList options;

    static {
        PoTokenProviderKind poTokenProviderKind = PoTokenProviderKind.WEB_BOTGUARD;
        PoTokenProviderKind poTokenProviderKind2 = PoTokenProviderKind.WEBPAGE_ATTESTATION;
        PoTokenProviderKind poTokenProviderKind3 = PoTokenProviderKind.EXTERNAL;
        Set set = ArraysKt.toSet(new PoTokenProviderKind[]{poTokenProviderKind, poTokenProviderKind2, poTokenProviderKind3});
        Set set2 = ArraysKt.toSet(new PoTokenProviderKind[]{poTokenProviderKind2, poTokenProviderKind3});
        Set set3 = ArraysKt.toSet(new PoTokenProviderKind[]{PoTokenProviderKind.ANDROID_DROIDGUARD, poTokenProviderKind3});
        Set set4 = ArraysKt.toSet(new PoTokenProviderKind[]{PoTokenProviderKind.IOS_ATTESTATION, poTokenProviderKind3});
        PoTokenRule poTokenRule = new PoTokenRule((PoTokenRequirement) null, (PoTokenBinding) null, (Set) null, 15);
        PoTokenBinding poTokenBinding = PoTokenBinding.VIDEO_ID;
        if (set.isEmpty()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("A PO token rule must declare at least one compatible provider");
            return;
        }
        PoTokenBinding poTokenBinding2 = PoTokenBinding.VISITOR_DATA;
        PoTokenRequirement poTokenRequirement = PoTokenRequirement.REQUIRED;
        PoTokenRule poTokenRule2 = new PoTokenRule(poTokenRequirement, poTokenBinding2, set, 8);
        PoTokenRule poTokenRule3 = new PoTokenRule(poTokenRequirement, poTokenBinding, set, true);
        PoTokenRequirement poTokenRequirement2 = PoTokenRequirement.OPTIONAL;
        PoTokenRule poTokenRule4 = new PoTokenRule(poTokenRequirement2, poTokenBinding, set, 8);
        PoTokenRule poTokenRule5 = new PoTokenRule(poTokenRequirement, poTokenBinding2, set2, 8);
        PoTokenRule poTokenRule6 = new PoTokenRule(poTokenRequirement, poTokenBinding, set2, 8);
        PoTokenRule poTokenRule7 = new PoTokenRule(poTokenRequirement2, poTokenBinding, set2, 8);
        PoTokenRule poTokenRule8 = new PoTokenRule(poTokenRequirement2, poTokenBinding2, set3, 8);
        if (set3.isEmpty()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("A PO token rule must declare at least one compatible provider");
            return;
        }
        PoTokenRule poTokenRule9 = new PoTokenRule(poTokenRequirement, poTokenBinding2, set3, 8);
        PoTokenRule poTokenRule10 = new PoTokenRule(poTokenRequirement, poTokenBinding, set3, 8);
        PoTokenRule poTokenRule11 = new PoTokenRule(poTokenRequirement2, poTokenBinding2, set4, 8);
        PoTokenRule poTokenRule12 = new PoTokenRule(poTokenRequirement, poTokenBinding, set4, 8);
        ClientRequestCapabilities clientRequestCapabilities = new ClientRequestCapabilities(96, true, false);
        CapabilitySupport capabilitySupport = CapabilitySupport.SUPPORTED;
        CapabilitySupport capabilitySupport2 = CapabilitySupport.LIMITED;
        ClientContentCapabilities clientContentCapabilities = new ClientContentCapabilities(capabilitySupport, capabilitySupport, capabilitySupport2, capabilitySupport, capabilitySupport, 1);
        ClientContentCapabilities clientContentCapabilitiesCopy$default = ClientContentCapabilities.copy$default(clientContentCapabilities, 55);
        ClientContentCapabilities clientContentCapabilities2 = new ClientContentCapabilities(capabilitySupport, capabilitySupport, capabilitySupport, (CapabilitySupport) null, capabilitySupport, 17);
        YouTubeClient.INSTANCE.getClass();
        YouTubeClient youTubeClient = YouTubeClient.VISIONOS;
        PlaybackTransport playbackTransport = PlaybackTransport.DIRECT;
        Set of = CharsKt.setOf(playbackTransport);
        CapabilitySupport capabilitySupport3 = CapabilitySupport.UNSUPPORTED;
        CapabilitySupport capabilitySupport4 = CapabilitySupport.UNKNOWN;
        ClientContentCapabilities clientContentCapabilities3 = new ClientContentCapabilities(capabilitySupport2, capabilitySupport3, capabilitySupport3, capabilitySupport4, capabilitySupport3, 1);
        Set set5 = ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Playback live matrix", "yt-dlp client inventory"});
        ClientLifecycle clientLifecycle = ClientLifecycle.UNRELEASED;
        ClientSelectionMode clientSelectionMode = ClientSelectionMode.PROBE_ONLY;
        PlaybackClientManifest playbackClientManifestManifest$default = manifest$default("VISIONOS", youTubeClient, "visionOS 1.02", clientLifecycle, clientSelectionMode, null, of, null, null, clientContentCapabilities3, null, 100, set5, "Passed normal playback with backward and forward seeks on an authenticated device, but clean Android sessions can stall before receiving media. Internal/unreleased; made-for-kids and age-restricted media were rejected.", 1440);
        YouTubeClient youTubeClient2 = YouTubeClient.VISIONOS_0_1;
        Set of2 = CharsKt.setOf(playbackTransport);
        CapabilitySupport capabilitySupport5 = true & true ? capabilitySupport : capabilitySupport3;
        CapabilitySupport capabilitySupport6 = (1 & 2) != 0 ? capabilitySupport4 : capabilitySupport3;
        ClientContentCapabilities clientContentCapabilities4 = new ClientContentCapabilities((61 & 1) != 0 ? capabilitySupport5 : capabilitySupport2, (61 & 2) != 0 ? capabilitySupport6 : capabilitySupport2, (1 & 4) != 0 ? capabilitySupport4 : capabilitySupport3, (61 & 8) != 0 ? (1 & 8) != 0 ? capabilitySupport4 : capabilitySupport3 : capabilitySupport, (1 & 16) != 0 ? capabilitySupport4 : capabilitySupport3, (1 & 32) != 0 ? capabilitySupport4 : capabilitySupport3);
        Set set6 = ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Playback live matrix"});
        ClientLifecycle clientLifecycle2 = ClientLifecycle.DEPRECATED;
        PlaybackClientManifest playbackClientManifestManifest$default2 = manifest$default("VISIONOS_0_1", youTubeClient2, "visionOS 0.1", clientLifecycle2, clientSelectionMode, null, of2, null, null, clientContentCapabilities4, null, 100, set6, "September 2026 capture: two anonymous normal audio requests without visitorData were UNPLAYABLE; the same requests with watch-config visitorData returned direct audio (one complete file, one initial range). One anonymous desktop normal sample passed 90-second decoded playback with backward and forward seeks. Public selection stays probe-only without visitor context; internal automatic extraction tries visitor-backed normal audio only. Earlier HTTP 400 reports and other content remain unverified.", 1440);
        YouTubeClient youTubeClient3 = YouTubeClient.ANDROID_VR_1_65_10;
        Set of3 = CharsKt.setOf(playbackTransport);
        ClientContentCapabilities clientContentCapabilities5 = new ClientContentCapabilities(capabilitySupport3, capabilitySupport3, capabilitySupport3, capabilitySupport2, capabilitySupport3, 1);
        ClientContentCapabilities clientContentCapabilitiesGloballyUnusableContent = globallyUnusableContent();
        Set set7 = ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Playback live matrix", "yt-dlp client inventory", "YouTube.js client constants"});
        ClientLifecycle clientLifecycle3 = ClientLifecycle.STABLE;
        PlaybackClientManifest playbackClientManifestManifest$default3 = manifest$default("ANDROID_VR_1_65_10", youTubeClient3, "Android VR 1.65.10", clientLifecycle3, clientSelectionMode, null, of3, null, null, clientContentCapabilities5, clientContentCapabilitiesGloballyUnusableContent, 40, set7, "A live anonymous visitor request resolved, but every audio itag reached a CDN 403 after 1 MiB. Kept for explicit benchmark probing only.", 416);
        PlaybackClientManifest playbackClientManifestManifest$default4 = manifest$default("ANDROID_VR_1_43_32", YouTubeClient.ANDROID_VR_1_43_32, "Android VR 1.43.32", clientLifecycle2, clientSelectionMode, null, CharsKt.setOf(playbackTransport), null, null, new ClientContentCapabilities(capabilitySupport3, capabilitySupport3, capabilitySupport3, capabilitySupport2, capabilitySupport3, 1), globallyUnusableContent(), 82, ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Playback live matrix"}), "Player requests resolve, but sustained media reaches the same later-range authorization boundary as other Android VR profiles. Retained for benchmark comparison only.", 416);
        PlaybackClientManifest playbackClientManifestManifest$default5 = manifest$default("ANDROID_VR_NO_AUTH", YouTubeClient.ANDROID_VR_NO_AUTH, "Android VR 1.61.48 (minimal)", clientLifecycle2, clientSelectionMode, null, CharsKt.setOf(playbackTransport), null, null, new ClientContentCapabilities(capabilitySupport4, capabilitySupport3, capabilitySupport4, capabilitySupport2, capabilitySupport4, 1), globallyUnusableContent(), 60, ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Playback live matrix"}), "Player requests resolve, but sustained media reaches a later-range authorization boundary. Retained for benchmark comparison only.", 416);
        PlaybackClientManifest playbackClientManifestManifest$default6 = manifest$default("ANDROID_VR_1_61_48", YouTubeClient.ANDROID_VR_1_61_48, "Android VR 1.61.48", clientLifecycle2, clientSelectionMode, null, CharsKt.setOf(playbackTransport), null, null, new ClientContentCapabilities(capabilitySupport4, capabilitySupport3, capabilitySupport4, capabilitySupport2, capabilitySupport4, 1), globallyUnusableContent(), 64, ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Playback live matrix"}), "Player requests resolve, but sustained media reaches a later-range authorization boundary. Retained for benchmark comparison only.", 416);
        YouTubeClient youTubeClient4 = YouTubeClient.TVHTML5_DOWNGRADED;
        PlaybackTransport playbackTransport2 = PlaybackTransport.HLS;
        Set set8 = ArraysKt.toSet(new PlaybackTransport[]{playbackTransport, playbackTransport2});
        ClientRequestCapabilities clientRequestCapabilities2 = new ClientRequestCapabilities(106, true, false);
        ClientContentCapabilities clientContentCapabilities6 = new ClientContentCapabilities(capabilitySupport4, capabilitySupport, capabilitySupport, (CapabilitySupport) null, (CapabilitySupport) null, 49);
        ClientContentCapabilities clientContentCapabilitiesGloballyUnusableContent2 = globallyUnusableContent();
        Set set9 = ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Playback live matrix", "yt-dlp client inventory"});
        ClientLifecycle clientLifecycle4 = ClientLifecycle.EXPERIMENTAL;
        AuthenticationPolicy authenticationPolicy = AuthenticationPolicy.OPTIONAL;
        PlaybackClientManifest playbackClientManifestManifest$default7 = manifest$default("TVHTML5_DOWNGRADED", youTubeClient4, "TV HTML5 Downgraded", clientLifecycle4, clientSelectionMode, authenticationPolicy, set8, null, clientRequestCapabilities2, clientContentCapabilities6, clientContentCapabilitiesGloballyUnusableContent2, 70, set9, "Matches the current yt-dlp profile but YouTube returned UNPLAYABLE in August 2026 probes. Retained for explicit compatibility testing only.", 128);
        YouTubeClient youTubeClient5 = YouTubeClient.WEB_REMIX;
        Set set10 = ArraysKt.toSet(new PlaybackTransport[]{playbackTransport, playbackTransport2});
        ClientPoTokenCapabilities clientPoTokenCapabilities = new ClientPoTokenCapabilities(poTokenRule, poTokenRule3, 4);
        Set set11 = ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Playback live matrix", "yt-dlp client inventory", "YouTube.js client constants"});
        ClientSelectionMode clientSelectionMode2 = ClientSelectionMode.AUTOMATIC;
        PlaybackClientManifest playbackClientManifestManifest$default8 = manifest$default("WEB_REMIX", youTubeClient5, "Web Remix", clientLifecycle3, clientSelectionMode2, authenticationPolicy, set10, clientPoTokenCapabilities, clientRequestCapabilities, clientContentCapabilitiesCopy$default, null, 70, set11, "Passed normal, made-for-kids, and age-restricted playback with backward and forward seeks.", 1024);
        YouTubeClient youTubeClient6 = YouTubeClient.WEB_CREATOR;
        Set set12 = ArraysKt.toSet(new PlaybackTransport[]{playbackTransport, playbackTransport2});
        ClientPoTokenCapabilities clientPoTokenCapabilities2 = new ClientPoTokenCapabilities(poTokenRule, poTokenRule3, 4);
        Set set13 = ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Playback live matrix", "yt-dlp client inventory", "YouTube.js client constants"});
        AuthenticationPolicy authenticationPolicy2 = AuthenticationPolicy.REQUIRED;
        PlaybackClientManifest playbackClientManifestManifest$default9 = manifest$default("WEB_CREATOR", youTubeClient6, "Web Creator", clientLifecycle3, clientSelectionMode2, authenticationPolicy2, set12, clientPoTokenCapabilities2, clientRequestCapabilities, clientContentCapabilitiesCopy$default, null, 55, set13, "Passed normal, made-for-kids, and age-restricted playback with backward and forward seeks. Requires a signed-in account.", 1024);
        YouTubeClient youTubeClient7 = YouTubeClient.TVHTML5_SIMPLY;
        Set set14 = ArraysKt.toSet(new PlaybackTransport[]{playbackTransport, playbackTransport2});
        ClientPoTokenCapabilities clientPoTokenCapabilities3 = new ClientPoTokenCapabilities(poTokenRule2, poTokenRule3, 4);
        WebViewRequirement webViewRequirement = WebViewRequirement.REQUIRED_TOKEN_MINTING;
        PlaybackClientManifest playbackClientManifestManifest$default10 = manifest$default("TVHTML5_SIMPLY", youTubeClient7, "TV HTML5 Simply", clientLifecycle4, clientSelectionMode2, null, set14, clientPoTokenCapabilities3, ClientRequestCapabilities.copy$default(clientRequestCapabilities, webViewRequirement, 103), new ClientContentCapabilities(capabilitySupport3, capabilitySupport, capabilitySupport3, capabilitySupport4, capabilitySupport3, 1), new ClientContentCapabilities(capabilitySupport2, capabilitySupport, (CapabilitySupport) null, (CapabilitySupport) null, (CapabilitySupport) null, 57), 42, ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Playback live matrix", "yt-dlp client inventory", "YouTube.js client constants"}), "The two-token HLS path passed both normal samples, both made-for-kids samples, and one explicit sample with sustained playback and bidirectional seeks.", 32);
        PlaybackClientManifest playbackClientManifestManifest$default11 = manifest$default("WEB_EMBEDDED_PLAYER", YouTubeClient.WEB_EMBEDDED_PLAYER, "Web Embedded", clientLifecycle3, clientSelectionMode2, authenticationPolicy, ArraysKt.toSet(new PlaybackTransport[]{playbackTransport, playbackTransport2}), null, ClientRequestCapabilities.copy$default(clientRequestCapabilities, WebViewRequirement.NONE, 23), new ClientContentCapabilities(capabilitySupport, capabilitySupport4, capabilitySupport, capabilitySupport3, capabilitySupport3, capabilitySupport3), new ClientContentCapabilities(capabilitySupport3, capabilitySupport, (CapabilitySupport) null, (CapabilitySupport) null, (CapabilitySupport) null, 57), 65, ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Playback live matrix", "yt-dlp client inventory", "YouTube.js client constants"}), "Normal and made-for-kids playback passed sustained playback and both seek directions after fetching per-video encryptedHostFlags; age-restricted media was rejected.", 128);
        YouTubeClient youTubeClient8 = YouTubeClient.ANDROID_VR_SABR;
        PlaybackTransport playbackTransport3 = PlaybackTransport.SABR;
        PlaybackClientManifest playbackClientManifestManifest$default12 = manifest$default("ANDROID_VR_SABR", youTubeClient8, "Android VR 1.65.10 (SABR)", clientLifecycle4, clientSelectionMode, null, CharsKt.setOf(playbackTransport3), new ClientPoTokenCapabilities(poTokenRule8, poTokenRule10, 4), null, new ClientContentCapabilities(capabilitySupport3, capabilitySupport3, capabilitySupport3, capabilitySupport3, capabilitySupport3, 1), globallyUnusableContent(), 68, ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "Playback live matrix", "yt-dlp client inventory"}), "Passed 0 of 6 current benchmark cases. Normal responses reached media but did not advance; explicit and made-for-kids samples were rejected or failed media without DroidGuard.", 288);
        PlaybackClientManifest playbackClientManifestManifest = manifest(52, authenticationPolicy, new ClientContentCapabilities(capabilitySupport4, capabilitySupport, capabilitySupport, (CapabilitySupport) null, capabilitySupport, 17), new ClientContentCapabilities(capabilitySupport, capabilitySupport, (CapabilitySupport) null, (CapabilitySupport) null, (CapabilitySupport) null, 57), clientLifecycle4, new ClientPoTokenCapabilities(poTokenRule, poTokenRule7, 4), clientRequestCapabilities, clientSelectionMode2, YouTubeClient.WEB_REMIX_SABR, "WEB_REMIX_SABR", "Web Remix (SABR)", "Passed all 6 current normal, explicit, and made-for-kids cases with 90-second playback, bidirectional seeks, and complete telemetry without a PO token.", CharsKt.setOf(playbackTransport3), ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "Playback live matrix"}));
        PlaybackClientManifest playbackClientManifestManifest$default13 = manifest$default("WEB_SABR", YouTubeClient.WEB_SABR, "Web (SABR)", clientLifecycle4, clientSelectionMode2, authenticationPolicy, CharsKt.setOf(playbackTransport3), new ClientPoTokenCapabilities(poTokenRule, poTokenRule6, 4), ClientRequestCapabilities.copy$default(clientRequestCapabilities, webViewRequirement, 119), clientContentCapabilities2, null, 44, ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "Playback live matrix", "yt-dlp client inventory"}), "Page-bound GVS tokens passed all 6 current normal, explicit, and made-for-kids cases with 90-second playback, bidirectional seeks, and complete telemetry.", 1024);
        PlaybackClientManifest playbackClientManifestManifest$default14 = manifest$default("TVHTML5_SIMPLY_SABR", YouTubeClient.TVHTML5_SIMPLY_SABR, "TV HTML5 Simply (SABR)", clientLifecycle4, clientSelectionMode2, null, CharsKt.setOf(playbackTransport3), new ClientPoTokenCapabilities(poTokenRule5, poTokenRule6, 4), ClientRequestCapabilities.copy$default(clientRequestCapabilities, webViewRequirement, 103), new ClientContentCapabilities(capabilitySupport3, capabilitySupport, capabilitySupport3, (CapabilitySupport) null, capabilitySupport3, 17), new ClientContentCapabilities(capabilitySupport2, capabilitySupport, capabilitySupport3, (CapabilitySupport) null, capabilitySupport3, 17), 36, ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "Playback live matrix"}), "Passed both normal and both made-for-kids samples with 90-second playback, bidirectional seeks, and complete telemetry. One of two explicit samples passed; explicit content remains excluded from automatic selection.", 32);
        PlaybackClientManifest playbackClientManifestManifest$default15 = manifest$default("MWEB", YouTubeClient.MWEB, "Mobile Web", clientLifecycle4, clientSelectionMode, authenticationPolicy, ArraysKt.toSet(new PlaybackTransport[]{playbackTransport, playbackTransport2}), new ClientPoTokenCapabilities(poTokenRule, poTokenRule6, 4), clientRequestCapabilities, clientContentCapabilities2, null, 38, ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Playback live matrix", "yt-dlp client inventory", "YouTube.js client constants"}), "Page-bound GVS tokens passed normal, made-for-kids, and age-restricted playback. Fresh tokenized URLs can return several transient HTTP 403 responses before becoming usable.", 1024);
        PlaybackClientManifest playbackClientManifestManifest2 = manifest(32, authenticationPolicy, clientContentCapabilities2, ClientContentCapabilities.copy$default(clientContentCapabilities2, 61), clientLifecycle4, new ClientPoTokenCapabilities(poTokenRule, poTokenRule6, 4), ClientRequestCapabilities.copy$default(clientRequestCapabilities, webViewRequirement, 119), clientSelectionMode2, YouTubeClient.MWEB_SABR, "MWEB_SABR", "Mobile Web (SABR)", "Passed 5 of 6 current cases with 90-second playback and bidirectional seeks. One explicit sample had a media failure; runtime health fallback remains enabled.", CharsKt.setOf(playbackTransport3), ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "Playback live matrix", "yt-dlp client inventory"}));
        PlaybackClientManifest playbackClientManifestManifest$default16 = manifest$default("WEB_SAFARI_SABR", YouTubeClient.WEB_SAFARI_SABR, "Web Safari (SABR)", clientLifecycle4, clientSelectionMode2, authenticationPolicy, CharsKt.setOf(playbackTransport3), new ClientPoTokenCapabilities(poTokenRule, poTokenRule6, 4), ClientRequestCapabilities.copy$default(clientRequestCapabilities, webViewRequirement, 119), clientContentCapabilities2, null, 28, ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "Playback live matrix", "yt-dlp client inventory"}), "Page-bound GVS tokens passed all 6 current normal, explicit, and made-for-kids cases with 90-second playback, bidirectional seeks, and complete telemetry.", 1024);
        PlaybackClientManifest playbackClientManifestManifest$default17 = manifest$default("WEB_KIDS", YouTubeClient.WEB_KIDS, "Web Kids", clientLifecycle4, clientSelectionMode2, null, CharsKt.setOf(playbackTransport), null, ClientRequestCapabilities.copy$default(clientRequestCapabilities, null, 111), new ClientContentCapabilities(capabilitySupport3, capabilitySupport3, capabilitySupport, capabilitySupport3, capabilitySupport3, capabilitySupport3), null, 55, ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "YouTube.js client constants"}), "Made-for-kids playback passed 70 seconds plus backward and forward seeks; normal and age-restricted playback are unavailable.", 1184);
        YouTubeClient youTubeClient9 = YouTubeClient.TVHTML5;
        Set set15 = ArraysKt.toSet(new PlaybackTransport[]{playbackTransport, playbackTransport2});
        ClientPoTokenCapabilities clientPoTokenCapabilities4 = new ClientPoTokenCapabilities(poTokenRule, poTokenRule4, 4);
        Set set16 = ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "yt-dlp client inventory"});
        ClientLifecycle clientLifecycle5 = ClientLifecycle.BROKEN;
        PlaybackClientManifest playbackClientManifestManifest$default18 = manifest$default("TVHTML5", youTubeClient9, "TV HTML5", clientLifecycle5, clientSelectionMode, authenticationPolicy, set15, clientPoTokenCapabilities4, clientRequestCapabilities, clientContentCapabilities, null, 0, set16, "Previous probes returned no direct or HLS audio; retained for benchmark regression checks.", 1024);
        PlaybackClientManifest playbackClientManifestManifest$default19 = manifest$default("WEB_SAFARI", YouTubeClient.WEB_SAFARI, "Web Safari", clientLifecycle5, clientSelectionMode, authenticationPolicy, ArraysKt.toSet(new PlaybackTransport[]{playbackTransport, playbackTransport2}), new ClientPoTokenCapabilities(poTokenRule, poTokenRule3, 4), clientRequestCapabilities, globallyUnusableContent(), null, 0, ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "yt-dlp client inventory"}), "Previous responses exposed SABR-only media; retained to detect direct-stream regressions.", 1024);
        YouTubeClient youTubeClient10 = YouTubeClient.VISIONOS_SABR;
        Set of4 = CharsKt.setOf(playbackTransport3);
        CapabilitySupport capabilitySupport7 = true & true ? capabilitySupport : capabilitySupport3;
        CapabilitySupport capabilitySupport8 = (1 & 2) != 0 ? capabilitySupport4 : capabilitySupport3;
        PlaybackClientManifest playbackClientManifestManifest$default20 = manifest$default("VISIONOS_SABR", youTubeClient10, "visionOS 1.02 (SABR)", clientLifecycle, clientSelectionMode2, null, of4, null, null, new ClientContentCapabilities((61 & 1) != 0 ? capabilitySupport7 : capabilitySupport2, (61 & 2) != 0 ? capabilitySupport8 : capabilitySupport2, (1 & 4) != 0 ? capabilitySupport4 : capabilitySupport3, (61 & 8) != 0 ? (1 & 8) != 0 ? capabilitySupport4 : capabilitySupport3 : capabilitySupport, (1 & 16) != 0 ? capabilitySupport4 : capabilitySupport3, (1 & 32) != 0 ? capabilitySupport4 : capabilitySupport3), null, 0, ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "Playback live matrix", "yt-dlp client inventory"}), "Passed both normal samples and one non-age-gated explicit audio sample with 90-second playback and bidirectional seeks. Kids and age-gated media were rejected; explicit support remains limited to reflect the single successful sample.", 1440);
        PlaybackClientManifest playbackClientManifestManifest$default21 = manifest$default("TVHTML5_SABR", YouTubeClient.TVHTML5_SABR, "TV HTML5 (SABR)", clientLifecycle5, clientSelectionMode, authenticationPolicy, CharsKt.setOf(playbackTransport3), new ClientPoTokenCapabilities(poTokenRule, poTokenRule4, 4), clientRequestCapabilities, clientContentCapabilities, null, 0, ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "yt-dlp client inventory"}), "Passed 0 of 6 current cases; every player request was rejected. Retained for regression checks.", 1024);
        PlaybackClientManifest playbackClientManifestManifest$default22 = manifest$default("ANDROID", YouTubeClient.ANDROID, "Android 21.26.364", clientLifecycle5, clientSelectionMode, null, ArraysKt.toSet(new PlaybackTransport[]{playbackTransport, playbackTransport2}), new ClientPoTokenCapabilities(poTokenRule8, poTokenRule10, 4), null, new ClientContentCapabilities((CapabilitySupport) null, capabilitySupport3, capabilitySupport3, (CapabilitySupport) null, (CapabilitySupport) null, 50), null, 0, ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "yt-dlp client inventory", "YouTube.js client constants"}), "Previous responses exposed SABR-only media and require unavailable DroidGuard attestation.", 1312);
        PlaybackClientManifest playbackClientManifestManifest$default23 = manifest$default("ANDROID_SABR", YouTubeClient.ANDROID_SABR, "Android 21.26.364 (SABR)", clientLifecycle5, clientSelectionMode, null, CharsKt.setOf(playbackTransport3), new ClientPoTokenCapabilities(poTokenRule8, poTokenRule10, 4), null, new ClientContentCapabilities(capabilitySupport4, capabilitySupport4, (CapabilitySupport) null, (CapabilitySupport) null, (CapabilitySupport) null, 57), ClientContentCapabilities.copy$default(globallyUnusableContent(), 62), 0, ArraysKt.toSet(new String[]{"Android playback benchmark (2026-08-13)", "Android SABR benchmark (2026-08-20)", "yt-dlp client inventory"}), "Passed 1 of 2 normal cases but failed the other 5 current cases. No DroidGuard-compatible token provider is available, so this remains probe-only.", 288);
        PlaybackClientManifest playbackClientManifestManifest$default24 = manifest$default("IOS", YouTubeClient.IOS, "iOS 21.26.4", clientLifecycle5, clientSelectionMode, null, ArraysKt.toSet(new PlaybackTransport[]{playbackTransport, playbackTransport2}), new ClientPoTokenCapabilities(poTokenRule11, poTokenRule12, 4), null, new ClientContentCapabilities((CapabilitySupport) null, capabilitySupport3, capabilitySupport3, (CapabilitySupport) null, (CapabilitySupport) null, 50), null, 0, ArraysKt.toSet(new String[]{"yt-dlp client inventory", "YouTube.js client constants"}), "Previous responses exposed SABR-only media and require unavailable iOS attestation.", 1312);
        PlaybackClientManifest playbackClientManifestManifest$default25 = manifest$default("IOS_SABR", YouTubeClient.IOS_SABR, "iOS 21.26.4 (SABR)", clientLifecycle5, clientSelectionMode, null, CharsKt.setOf(playbackTransport3), new ClientPoTokenCapabilities(poTokenRule11, poTokenRule12, 4), null, new ClientContentCapabilities((CapabilitySupport) null, (CapabilitySupport) null, (CapabilitySupport) null, (CapabilitySupport) null, (CapabilitySupport) null, 63), null, 0, ArraysKt.toSet(new String[]{"Android SABR benchmark (2026-08-20)", "yt-dlp client inventory"}), "Passed 0 of 6 current cases. No iOS-compatible token provider is available.", 1312);
        PlaybackClientManifest playbackClientManifestManifest$default26 = manifest$default("IPADOS", YouTubeClient.IPADOS, "iPadOS 17.7.10", clientLifecycle5, clientSelectionMode, null, ArraysKt.toSet(new PlaybackTransport[]{playbackTransport, playbackTransport2}), new ClientPoTokenCapabilities(poTokenRule11, poTokenRule12, 4), null, new ClientContentCapabilities((CapabilitySupport) null, capabilitySupport3, capabilitySupport3, (CapabilitySupport) null, (CapabilitySupport) null, 50), null, 0, CharsKt.setOf("Playback live matrix"), "Previous responses exposed SABR-only media and require unavailable iOS attestation.", 1312);
        PlaybackClientManifest playbackClientManifestManifest$default27 = manifest$default("TVHTML5_SIMPLY_EMBEDDED_PLAYER", YouTubeClient.TVHTML5_SIMPLY_EMBEDDED_PLAYER, "TV HTML5 Simply Embedded", clientLifecycle5, clientSelectionMode, null, CharsKt.setOf(playbackTransport), new ClientPoTokenCapabilities(poTokenRule2, poTokenRule3, 4), ClientRequestCapabilities.copy$default(clientRequestCapabilities, webViewRequirement, 71), globallyUnusableContent(), null, 0, CharsKt.setOf("YouTube.js client constants"), "YouTube previously reported this application and device as unsupported.", 1056);
        PlaybackClientManifest playbackClientManifestManifest$default28 = manifest$default("ANDROID_MUSIC", YouTubeClient.ANDROID_MUSIC, "Android Music 5.34.51", clientLifecycle5, clientSelectionMode, null, CharsKt.setOf(playbackTransport), new ClientPoTokenCapabilities(poTokenRule9, poTokenRule10, 4), null, globallyUnusableContent(), null, 0, CharsKt.setOf("YouTube.js client constants"), "Previous player requests returned HTTP 400 FAILED_PRECONDITION.", 1312);
        PlaybackClientManifest playbackClientManifestManifest$default29 = manifest$default("ANDROID_CREATOR", YouTubeClient.ANDROID_CREATOR, "Android Studio 25.03.101", clientLifecycle5, clientSelectionMode, authenticationPolicy2, CharsKt.setOf(playbackTransport), null, null, globallyUnusableContent(), null, 0, CharsKt.setOf("YouTube.js client constants"), "Previous player requests returned HTTP 400 INVALID_ARGUMENT.", 1408);
        PlaybackClientManifest playbackClientManifestManifest$default30 = manifest$default("IOS_MUSIC", YouTubeClient.IOS_MUSIC, "iOS Music probe", clientLifecycle4, clientSelectionMode, null, CharsKt.setOf(playbackTransport), null, null, new ClientContentCapabilities(capabilitySupport4, capabilitySupport4, capabilitySupport4, capabilitySupport4, capabilitySupport4, capabilitySupport4), null, 0, ArraysKt.toSet(new String[]{"pytubefix innertube.py (b6521f09)", "YouTube-Internal-Clients survey (2022)"}), "Historical iOS Music identity and app fields; playback and transport support are unverified.", 1440);
        PlaybackClientManifest playbackClientManifestManifest$default31 = manifest$default("ANDROID_KIDS", YouTubeClient.ANDROID_KIDS, "Android Kids probe", clientLifecycle4, clientSelectionMode, null, CharsKt.setOf(playbackTransport), null, null, new ClientContentCapabilities(capabilitySupport4, capabilitySupport4, capabilitySupport4, capabilitySupport4, capabilitySupport4, capabilitySupport4), null, 0, ArraysKt.toSet(new String[]{"pytubefix innertube.py (b6521f09)", "YouTube-Internal-Clients survey (2022)"}), "Historical Android Kids identity and app fields; playback and transport support are unverified.", 1440);
        PlaybackClientManifest playbackClientManifestManifest$default32 = manifest$default("ANDROID_PRODUCER", YouTubeClient.ANDROID_PRODUCER, "Android Producer probe", clientLifecycle4, clientSelectionMode, null, CharsKt.setOf(playbackTransport), null, null, new ClientContentCapabilities(capabilitySupport4, capabilitySupport4, capabilitySupport4, capabilitySupport4, capabilitySupport4, capabilitySupport4), null, 0, CharsKt.setOf("pytubefix innertube.py (b6521f09)"), "Android Producer identity and app fields from the pinned source; playback is unverified.", 1440);
        PlaybackClientManifest playbackClientManifestManifest$default33 = manifest$default("MEDIA_CONNECT_FRONTEND", YouTubeClient.MEDIA_CONNECT_FRONTEND, "Media Connect Frontend probe", clientLifecycle4, clientSelectionMode, null, CharsKt.setOf(playbackTransport), null, null, new ClientContentCapabilities(capabilitySupport4, capabilitySupport4, capabilitySupport4, capabilitySupport4, capabilitySupport4, capabilitySupport4), null, 0, ArraysKt.toSet(new String[]{"pytubefix innertube.py (b6521f09)", "YouTube-Internal-Clients survey (2022)"}), "Historical Media Connect identity and app fields; playback and transport support are unverified.", 1440);
        YouTubeClient youTubeClient11 = YouTubeClient.WEB;
        ClientPoTokenCapabilities clientPoTokenCapabilities5 = new ClientPoTokenCapabilities(poTokenRule, poTokenRule3, 4);
        Set set17 = ArraysKt.toSet(new String[]{"yt-dlp client inventory", "YouTube.js client constants"});
        ClientSelectionMode clientSelectionMode3 = ClientSelectionMode.API_ONLY;
        List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new PlaybackClientManifest[]{playbackClientManifestManifest$default, playbackClientManifestManifest$default2, playbackClientManifestManifest$default3, playbackClientManifestManifest$default4, playbackClientManifestManifest$default5, playbackClientManifestManifest$default6, playbackClientManifestManifest$default7, playbackClientManifestManifest$default8, playbackClientManifestManifest$default9, playbackClientManifestManifest$default10, playbackClientManifestManifest$default11, playbackClientManifestManifest$default12, playbackClientManifestManifest, playbackClientManifestManifest$default13, playbackClientManifestManifest$default14, playbackClientManifestManifest$default15, playbackClientManifestManifest2, playbackClientManifestManifest$default16, playbackClientManifestManifest$default17, playbackClientManifestManifest$default18, playbackClientManifestManifest$default19, playbackClientManifestManifest$default20, playbackClientManifestManifest$default21, playbackClientManifestManifest$default22, playbackClientManifestManifest$default23, playbackClientManifestManifest$default24, playbackClientManifestManifest$default25, playbackClientManifestManifest$default26, playbackClientManifestManifest$default27, playbackClientManifestManifest$default28, playbackClientManifestManifest$default29, playbackClientManifestManifest$default30, playbackClientManifestManifest$default31, playbackClientManifestManifest$default32, playbackClientManifestManifest$default33, manifest$default("WEB", youTubeClient11, "Web API", clientLifecycle3, clientSelectionMode3, authenticationPolicy, EmptySet.INSTANCE, clientPoTokenCapabilities5, clientRequestCapabilities, clientContentCapabilities, null, 0, set17, "Used for metadata/transcript calls. Playback uses the explicit WEB_SABR profile.", 1024)});
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listListOf, 10));
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(((PlaybackClientManifest) it.next()).id);
        }
        if (CollectionsKt.toList(CollectionsKt.toMutableSet(arrayList)).size() != listListOf.size()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Playback client manifest IDs must be unique");
            return;
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listListOf, 10));
        Iterator it2 = listListOf.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((PlaybackClientManifest) it2.next()).client);
        }
        if (CollectionsKt.toList(CollectionsKt.toMutableSet(arrayList2)).size() != listListOf.size()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Every manifest must have a distinguishable YouTubeClient request profile");
            return;
        }
        manifests = listListOf;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : listListOf) {
            if (!ArraysKt.toSet(new ClientSelectionMode[]{ClientSelectionMode.DISABLED, clientSelectionMode3}).contains(((PlaybackClientManifest) obj).selectionMode)) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
        int size = arrayList3.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList3.get(i);
            i++;
            PlaybackClientManifest playbackClientManifest = (PlaybackClientManifest) obj2;
            arrayList4.add(new PlaybackClientOption(playbackClientManifest.id, playbackClientManifest.displayName, playbackClientManifest.client, playbackClientManifest));
        }
        options = arrayList4;
        List list = manifests;
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : list) {
            if (((PlaybackClientManifest) obj3).selectionMode != clientSelectionMode3) {
                arrayList5.add(obj3);
            }
        }
        ArrayList arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10));
        int size2 = arrayList5.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj4 = arrayList5.get(i2);
            i2++;
            PlaybackClientManifest playbackClientManifest2 = (PlaybackClientManifest) obj4;
            arrayList6.add(new PlaybackClientOption(playbackClientManifest2.id, playbackClientManifest2.displayName, playbackClientManifest2.client, playbackClientManifest2));
        }
        ArrayList arrayList7 = options;
        ArrayList arrayList8 = new ArrayList();
        int size3 = arrayList7.size();
        int i3 = 0;
        while (i3 < size3) {
            Object obj5 = arrayList7.get(i3);
            i3++;
            if (((PlaybackClientOption) obj5).manifest.selectionMode != clientSelectionMode) {
                arrayList8.add(obj5);
            }
        }
        List list2 = manifests;
        ArrayList arrayList9 = new ArrayList();
        for (Object obj6 : list2) {
            if (((PlaybackClientManifest) obj6).selectionMode == clientSelectionMode2) {
                arrayList9.add(obj6);
            }
        }
        automaticManifests = arrayList9;
    }

    public static PlaybackClientOption find(String str) {
        Object obj;
        str.getClass();
        ArrayList arrayList = options;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            obj = arrayList.get(i);
            i++;
            if (((PlaybackClientOption) obj).id.equals(str)) {
                return (PlaybackClientOption) obj;
            }
        }
        obj = null;
        return (PlaybackClientOption) obj;
    }

    public static PlaybackClientManifest findManifest(String str) {
        Object next;
        str.getClass();
        Iterator it = manifests.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((PlaybackClientManifest) next).id.equals(str)) {
                return (PlaybackClientManifest) next;
            }
        }
        next = null;
        return (PlaybackClientManifest) next;
    }

    public static ClientContentCapabilities globallyUnusableContent() {
        CapabilitySupport capabilitySupport = CapabilitySupport.UNSUPPORTED;
        return new ClientContentCapabilities(capabilitySupport, capabilitySupport, capabilitySupport, capabilitySupport, capabilitySupport, capabilitySupport);
    }

    public static PlaybackClientManifest manifest(int i, AuthenticationPolicy authenticationPolicy, ClientContentCapabilities clientContentCapabilities, ClientContentCapabilities clientContentCapabilities2, ClientLifecycle clientLifecycle, ClientPoTokenCapabilities clientPoTokenCapabilities, ClientRequestCapabilities clientRequestCapabilities, ClientSelectionMode clientSelectionMode, YouTubeClient youTubeClient, String str, String str2, String str3, Set set, Set set2) {
        ClientContentCapabilities clientContentCapabilities3;
        ClientContentCapabilities clientContentCapabilitiesGloballyUnusableContent;
        ClientLifecycle clientLifecycle2;
        if (clientContentCapabilities2 == null) {
            clientLifecycle2 = clientLifecycle;
            if (clientLifecycle2 == ClientLifecycle.BROKEN) {
                authenticationPolicy = authenticationPolicy;
                clientContentCapabilities3 = clientContentCapabilities;
                clientContentCapabilitiesGloballyUnusableContent = globallyUnusableContent();
                i = i;
            } else {
                clientContentCapabilities3 = clientContentCapabilities;
                clientContentCapabilitiesGloballyUnusableContent = clientContentCapabilities3;
            }
            return new PlaybackClientManifest(i, authenticationPolicy, clientContentCapabilities3, clientContentCapabilitiesGloballyUnusableContent, clientLifecycle2, clientPoTokenCapabilities, clientRequestCapabilities, clientSelectionMode, youTubeClient, str, str2, str3, set, set2);
        }
        clientContentCapabilities3 = clientContentCapabilities;
        clientContentCapabilitiesGloballyUnusableContent = clientContentCapabilities2;
        clientLifecycle2 = clientLifecycle;
        return new PlaybackClientManifest(i, authenticationPolicy, clientContentCapabilities3, clientContentCapabilitiesGloballyUnusableContent, clientLifecycle2, clientPoTokenCapabilities, clientRequestCapabilities, clientSelectionMode, youTubeClient, str, str2, str3, set, set2);
    }

    public static PlaybackClientManifest manifest$default(String str, YouTubeClient youTubeClient, String str2, ClientLifecycle clientLifecycle, ClientSelectionMode clientSelectionMode, AuthenticationPolicy authenticationPolicy, Set set, ClientPoTokenCapabilities clientPoTokenCapabilities, ClientRequestCapabilities clientRequestCapabilities, ClientContentCapabilities clientContentCapabilities, ClientContentCapabilities clientContentCapabilities2, int i, Set set2, String str3, int i2) {
        return manifest(i, (i2 & 32) != 0 ? AuthenticationPolicy.UNSUPPORTED : authenticationPolicy, clientContentCapabilities, (i2 & 1024) == 0 ? clientContentCapabilities2 : null, clientLifecycle, (i2 & 128) != 0 ? new ClientPoTokenCapabilities(null, null, 7) : clientPoTokenCapabilities, (i2 & 256) != 0 ? new ClientRequestCapabilities(94, youTubeClient.useSignatureTimestamp, youTubeClient.isEmbedded) : clientRequestCapabilities, clientSelectionMode, youTubeClient, str, str2, str3, set, set2);
    }

    public static Set profileIds(PlaybackClientManifest playbackClientManifest, boolean z) {
        playbackClientManifest.getClass();
        String strM = IntIntPair$$ExternalSyntheticOutline0.m(playbackClientManifest.id, "__", z ? "po" : "nopo");
        YouTubeClient youTubeClient = playbackClientManifest.client;
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
        String string = sb.toString();
        Pattern patternCompile = Pattern.compile("[^A-Za-z0-9_.-]");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(string).replaceAll("_");
        strReplaceAll.getClass();
        return ArraysKt.toSet(new String[]{strM, IntIntPair$$ExternalSyntheticOutline0.m(strReplaceAll, "_", z ? "po" : "nopo")});
    }
}
