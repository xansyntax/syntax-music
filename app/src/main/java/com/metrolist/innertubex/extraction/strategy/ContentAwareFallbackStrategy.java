package com.metrolist.innertubex.extraction.strategy;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.semantics.SemanticsSortKt$special$$inlined$thenBy$1;
import com.metrolist.innertubex.extraction.ContentHints;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.lrclib.LrcLib$getAllLyrics$$inlined$sortedByDescending$1;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentAwareFallbackStrategy implements ClientFallbackStrategy {
    public static ListBuilder hardRejectionReasons(PlaybackClientManifest playbackClientManifest, ClientSelectionRequest clientSelectionRequest, boolean z) {
        PoTokenRequirement poTokenRequirement;
        boolean z2 = clientSelectionRequest.authenticated;
        ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
        ClientLifecycle clientLifecycle = playbackClientManifest.lifecycle;
        ClientPoTokenCapabilities clientPoTokenCapabilities = playbackClientManifest.poTokens;
        String str = playbackClientManifest.id;
        ClientRequestCapabilities clientRequestCapabilities = playbackClientManifest.request;
        if (clientLifecycle == ClientLifecycle.BROKEN) {
            listBuilderCreateListBuilder.add("client marked broken");
        }
        if (playbackClientManifest.authentication == AuthenticationPolicy.REQUIRED && !z2) {
            listBuilderCreateListBuilder.add("login required");
        }
        ContentHints contentHints = clientSelectionRequest.hints;
        boolean z3 = clientSelectionRequest.javaScriptRuntimeAvailable;
        Boolean bool = contentHints.isUploaded;
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2) && !z2) {
            listBuilderCreateListBuilder.add("uploads require login");
        }
        CapabilitySupport capabilitySupportSupportFor = playbackClientManifest.content.supportFor(contentHints);
        if (z && capabilitySupportSupportFor == CapabilitySupport.UNSUPPORTED) {
            listBuilderCreateListBuilder.add("content type unsupported");
        }
        if (z && str.equals("VISIONOS_0_1") && capabilitySupportSupportFor != CapabilitySupport.SUPPORTED) {
            listBuilderCreateListBuilder.add("legacy direct playback verified for normal audio only");
        }
        if (ArraysKt.toSet(new String[]{"VISIONOS_0_1", "VISIONOS_SABR"}).contains(str)) {
            Intrinsics.areEqual(contentHints.isExplicit, bool2);
        }
        JavaScriptRequirement javaScriptRequirement = JavaScriptRequirement.REQUIRED;
        if (!z3 && clientRequestCapabilities.signatureCipher == javaScriptRequirement) {
            listBuilderCreateListBuilder.add("signature transform unavailable");
        }
        if (!z3 && clientRequestCapabilities.nTransform == javaScriptRequirement) {
            listBuilderCreateListBuilder.add("n-transform unavailable");
        }
        if (clientRequestCapabilities.webView == WebViewRequirement.FULL_PLAYER && !clientSelectionRequest.webViewAvailable) {
            listBuilderCreateListBuilder.add("full WebView runtime unavailable");
        }
        PoTokenRule poTokenRule = clientPoTokenCapabilities.player;
        PoTokenRule poTokenRule2 = clientPoTokenCapabilities.gvs;
        List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Pair[]{new Pair("player", poTokenRule), new Pair("GVS", poTokenRule2)});
        ArrayList arrayList = new ArrayList();
        Iterator it = listListOf.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            poTokenRequirement = PoTokenRequirement.REQUIRED;
            if (!zHasNext) {
                break;
            }
            Object next = it.next();
            PoTokenRule poTokenRule3 = (PoTokenRule) ((Pair) next).second;
            if (poTokenRule3.requirement == poTokenRequirement) {
                Set set = poTokenRule3.providers;
                if (!(set instanceof Collection) || !set.isEmpty()) {
                    Iterator it2 = set.iterator();
                    do {
                        if (it2.hasNext()) {
                        }
                    } while (!clientSelectionRequest.availablePoTokenProviders.contains((PoTokenProviderKind) it2.next()));
                }
                arrayList.add(next);
                break;
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add((String) ((Pair) obj).first);
        }
        if (!arrayList2.isEmpty()) {
            listBuilderCreateListBuilder.add(CollectionsKt.joinToString$default(arrayList2, "+", null, null, null, 62).concat(" PO-token provider unavailable"));
        }
        if (clientSelectionRequest.fastPathOnly) {
            if (clientRequestCapabilities.signatureTimestamp) {
                listBuilderCreateListBuilder.add("watch config excluded from fast path");
            }
            List listListOf2 = CollectionsKt__IterablesKt.listOf((Object[]) new PoTokenRule[]{clientPoTokenCapabilities.player, poTokenRule2});
            if (!listListOf2.isEmpty()) {
                Iterator it3 = listListOf2.iterator();
                while (it3.hasNext()) {
                    if (((PoTokenRule) it3.next()).requirement == poTokenRequirement) {
                        listBuilderCreateListBuilder.add("token generation excluded from fast path");
                        break;
                    }
                }
            }
            if (clientRequestCapabilities.signatureCipher == javaScriptRequirement) {
                listBuilderCreateListBuilder.add("signature transform excluded from fast path");
            }
            if (clientRequestCapabilities.nTransform == javaScriptRequirement) {
                listBuilderCreateListBuilder.add("n-transform excluded from fast path");
            }
        }
        return CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
    }

    public static final void score$adjust(Ref$IntRef ref$IntRef, ArrayList arrayList, int i, String str) {
        ref$IntRef.element += i;
        arrayList.add(str + "=" + (i >= 0 ? "+" : "") + i);
    }

    public final boolean isExcluded(PlaybackClientManifest playbackClientManifest, Set set, Set set2, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (!set.contains(playbackClientManifest.client.clientName) && !set.contains(playbackClientManifest.id)) {
            Set setProfileIds = PlaybackClientCatalog.profileIds(playbackClientManifest, false);
            if (!(setProfileIds instanceof Collection) || !setProfileIds.isEmpty()) {
                Iterator it = setProfileIds.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    if (set.contains((String) it.next())) {
                        z2 = true;
                        break;
                    }
                }
            } else {
                z2 = false;
                break;
            }
            Set setProfileIds2 = PlaybackClientCatalog.profileIds(playbackClientManifest, true);
            if (!(setProfileIds2 instanceof Collection) || !setProfileIds2.isEmpty()) {
                Iterator it2 = setProfileIds2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z3 = false;
                        break;
                    }
                    if (set.contains((String) it2.next())) {
                        z3 = true;
                        break;
                    }
                }
            } else {
                z3 = false;
                break;
            }
            ClientPoTokenCapabilities clientPoTokenCapabilities = playbackClientManifest.poTokens;
            List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new PoTokenRule[]{clientPoTokenCapabilities.player, clientPoTokenCapabilities.gvs});
            if (!listListOf.isEmpty()) {
                Iterator it3 = listListOf.iterator();
                loop1: while (true) {
                    if (!it3.hasNext()) {
                        z4 = false;
                        break;
                    }
                    PoTokenRule poTokenRule = (PoTokenRule) it3.next();
                    if (poTokenRule.requirement != PoTokenRequirement.NONE) {
                        Set set3 = poTokenRule.providers;
                        if (!(set3 instanceof Collection) || !set3.isEmpty()) {
                            Iterator it4 = set3.iterator();
                            while (it4.hasNext()) {
                                if (set2.contains((PoTokenProviderKind) it4.next())) {
                                    z4 = true;
                                    break loop1;
                                }
                            }
                        }
                    }
                }
            } else {
                z4 = false;
                break;
            }
            if (listListOf.isEmpty()) {
                z5 = false;
            } else {
                Iterator it5 = listListOf.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        PoTokenRule poTokenRule2 = (PoTokenRule) it5.next();
                        if (poTokenRule2.requirement == PoTokenRequirement.REQUIRED && (!z || !poTokenRule2.premiumMayBypass)) {
                            z5 = true;
                        }
                    } else {
                        z5 = false;
                    }
                }
            }
            if ((!z2 || !z3) && ((z4 || !z2) && (!z5 || !z3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00a2  */
    public final ClientSelectionResult selectClients$com_github_MetrolistGroup_innertubex(ClientSelectionRequest clientSelectionRequest, boolean z, boolean z2) {
        PlaybackClientManifest playbackClientManifest;
        int i;
        int i2;
        int i3;
        PlaybackClientOption playbackClientOptionFind;
        List listListOf;
        ContentAwareFallbackStrategy contentAwareFallbackStrategy = this;
        Set set = clientSelectionRequest.availablePoTokenProviders;
        Set set2 = clientSelectionRequest.excludedClients;
        ArrayList arrayList = new ArrayList();
        ContentHints contentHints = clientSelectionRequest.hints;
        String str = contentHints.playbackClientOverrideId;
        boolean z3 = false;
        if (str != null && (playbackClientOptionFind = PlaybackClientCatalog.find(str)) != null) {
            PlaybackClientManifest playbackClientManifest2 = playbackClientOptionFind.manifest;
            ListBuilder listBuilderHardRejectionReasons = hardRejectionReasons(playbackClientManifest2, clientSelectionRequest, false);
            if (contentAwareFallbackStrategy.isExcluded(playbackClientManifest2, set2, set, false)) {
                if (listBuilderHardRejectionReasons.isEmpty()) {
                    listListOf = listBuilderHardRejectionReasons;
                    listListOf = CollectionsKt__IterablesKt.listOf("manual override recently failed");
                }
                listListOf = listBuilderHardRejectionReasons;
                arrayList.add(new RejectedClient(playbackClientManifest2, listListOf));
            } else {
                YouTubeClient youTubeClient = playbackClientOptionFind.client;
                List listListOf2 = CollectionsKt__IterablesKt.listOf("manual override");
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listBuilderHardRejectionReasons, 10));
                ListIterator listIterator = listBuilderHardRejectionReasons.listIterator(0);
                while (true) {
                    ListBuilder.Itr itr = (ListBuilder.Itr) listIterator;
                    if (!itr.hasNext()) {
                        return new ClientSelectionResult(CollectionsKt__IterablesKt.listOf(new SelectedClient(youTubeClient, playbackClientManifest2, Integer.MAX_VALUE, CollectionsKt.plus((Iterable) arrayList2, (Collection) listListOf2))), EmptyList.INSTANCE);
                    }
                    arrayList2.add("ignored: " + ((String) itr.next()));
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        PlaybackClientOption playbackClientOptionFind2 = PlaybackClientCatalog.find("VISIONOS_0_1");
        if (playbackClientOptionFind2 != null) {
            playbackClientManifest = playbackClientOptionFind2.manifest;
            if (!z2 || playbackClientManifest.selectionMode != ClientSelectionMode.PROBE_ONLY) {
                playbackClientManifest = null;
            }
        } else {
            playbackClientManifest = null;
        }
        ArrayList arrayListPlus = CollectionsKt.plus((Iterable) CollectionsKt__IterablesKt.listOfNotNull(playbackClientManifest), (Collection) PlaybackClientCatalog.automaticManifests);
        int size = arrayListPlus.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayListPlus.get(i4);
            int i5 = i4 + 1;
            PlaybackClientManifest playbackClientManifest3 = (PlaybackClientManifest) obj;
            boolean zIsExcluded = contentAwareFallbackStrategy.isExcluded(playbackClientManifest3, set2, set, z3);
            YouTubeClient youTubeClient2 = playbackClientManifest3.client;
            if (zIsExcluded) {
                i = i5;
            } else {
                ListBuilder listBuilderHardRejectionReasons2 = hardRejectionReasons(playbackClientManifest3, clientSelectionRequest, true);
                if (listBuilderHardRejectionReasons2.isEmpty()) {
                    Ref$IntRef ref$IntRef = new Ref$IntRef();
                    byte b = playbackClientManifest3.priority;
                    AuthenticationPolicy authenticationPolicy = playbackClientManifest3.authentication;
                    String str2 = playbackClientManifest3.id;
                    ClientRequestCapabilities clientRequestCapabilities = playbackClientManifest3.request;
                    Set set3 = playbackClientManifest3.transports;
                    ref$IntRef.element = b;
                    ArrayList arrayListMutableListOf = CollectionsKt__IterablesKt.mutableListOf(IntIntPair$$ExternalSyntheticOutline0.m(b, "base="));
                    ClientContentCapabilities clientContentCapabilities = playbackClientManifest3.content;
                    boolean z4 = clientSelectionRequest.authenticated;
                    int iOrdinal = clientContentCapabilities.supportFor(contentHints).ordinal();
                    if (iOrdinal != 0) {
                        i = i5;
                        if (iOrdinal == 1) {
                            score$adjust(ref$IntRef, arrayListMutableListOf, -12, "content-limited");
                        } else if (iOrdinal == 2) {
                            score$adjust(ref$IntRef, arrayListMutableListOf, -4, "content-unknown");
                        } else if (iOrdinal != 3) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                    } else {
                        i = i5;
                        score$adjust(ref$IntRef, arrayListMutableListOf, 25, "content");
                    }
                    if (str2.equals("VISIONOS_SABR")) {
                        score$adjust(ref$IntRef, arrayListMutableListOf, 80, "sabr-audio-playback");
                    }
                    Boolean bool = contentHints.isExplicit;
                    Boolean bool2 = Boolean.TRUE;
                    if ((Intrinsics.areEqual(bool, bool2) || Intrinsics.areEqual(contentHints.isKidsContent, bool2) || Intrinsics.areEqual(contentHints.isAgeRestricted, bool2) || Intrinsics.areEqual(contentHints.isUploaded, bool2)) && authenticationPolicy == AuthenticationPolicy.OPTIONAL) {
                        score$adjust(ref$IntRef, arrayListMutableListOf, z4 ? 18 : -18, z4 ? "authenticated" : "signed-out");
                    }
                    if (authenticationPolicy == AuthenticationPolicy.REQUIRED) {
                        score$adjust(ref$IntRef, arrayListMutableListOf, 8, "auth-specialist");
                    }
                    int iOrdinal2 = clientSelectionRequest.transportPreference.ordinal();
                    PlaybackTransport playbackTransport = PlaybackTransport.DIRECT;
                    if (iOrdinal2 != 0) {
                        if (iOrdinal2 == 1) {
                            score$adjust(ref$IntRef, arrayListMutableListOf, set3.contains(playbackTransport) ? 30 : -30, "direct-preference");
                        } else if (iOrdinal2 == 2) {
                            score$adjust(ref$IntRef, arrayListMutableListOf, set3.contains(PlaybackTransport.SABR) ? 30 : -30, "sabr-preference");
                        } else {
                            if (iOrdinal2 != 3) {
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return null;
                            }
                            score$adjust(ref$IntRef, arrayListMutableListOf, set3.contains(PlaybackTransport.HLS) ? 30 : -30, "hls-preference");
                        }
                    } else if (set3.contains(playbackTransport)) {
                        score$adjust(ref$IntRef, arrayListMutableListOf, 10, "direct-fast-path");
                    }
                    int iOrdinal3 = playbackClientManifest3.lifecycle.ordinal();
                    if (iOrdinal3 != 0) {
                        if (iOrdinal3 == 1) {
                            score$adjust(ref$IntRef, arrayListMutableListOf, -15, "canary");
                        } else if (iOrdinal3 == 2) {
                            score$adjust(ref$IntRef, arrayListMutableListOf, -10, "experimental");
                        } else if (iOrdinal3 == 3) {
                            score$adjust(ref$IntRef, arrayListMutableListOf, -5, "unreleased");
                        } else if (iOrdinal3 == 4) {
                            score$adjust(ref$IntRef, arrayListMutableListOf, -20, "deprecated");
                        } else {
                            if (iOrdinal3 != 5) {
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return null;
                            }
                            score$adjust(ref$IntRef, arrayListMutableListOf, -100, "broken");
                        }
                    }
                    ClientPoTokenCapabilities clientPoTokenCapabilities = playbackClientManifest3.poTokens;
                    List listListOf3 = CollectionsKt__IterablesKt.listOf((Object[]) new PoTokenRule[]{clientPoTokenCapabilities.player, clientPoTokenCapabilities.gvs});
                    if (listListOf3.isEmpty()) {
                        i2 = 0;
                    } else {
                        Iterator it = listListOf3.iterator();
                        i2 = 0;
                        while (it.hasNext()) {
                            if (((PoTokenRule) it.next()).requirement == PoTokenRequirement.REQUIRED && (i2 = i2 + 1) < 0) {
                                CollectionsKt__IterablesKt.throwCountOverflow();
                                throw null;
                            }
                        }
                    }
                    if (listListOf3.isEmpty()) {
                        i3 = 0;
                    } else {
                        Iterator it2 = listListOf3.iterator();
                        i3 = 0;
                        while (it2.hasNext()) {
                            if (((PoTokenRule) it2.next()).requirement == PoTokenRequirement.OPTIONAL && (i3 = i3 + 1) < 0) {
                                CollectionsKt__IterablesKt.throwCountOverflow();
                                throw null;
                            }
                        }
                    }
                    if (i2 > 0) {
                        score$adjust(ref$IntRef, arrayListMutableListOf, i2 * (-12), "required-token");
                    }
                    if (i3 > 0) {
                        score$adjust(ref$IntRef, arrayListMutableListOf, i3 * (-4), "optional-token");
                    }
                    JavaScriptRequirement javaScriptRequirement = clientRequestCapabilities.nTransform;
                    JavaScriptRequirement javaScriptRequirement2 = JavaScriptRequirement.RESPONSE_DEPENDENT;
                    if (javaScriptRequirement == javaScriptRequirement2) {
                        score$adjust(ref$IntRef, arrayListMutableListOf, -4, "possible-n-transform");
                    }
                    if (clientRequestCapabilities.signatureCipher == javaScriptRequirement2) {
                        score$adjust(ref$IntRef, arrayListMutableListOf, -3, "possible-cipher");
                    }
                    int iOrdinal4 = clientRequestCapabilities.webView.ordinal();
                    if (iOrdinal4 != 0) {
                        if (iOrdinal4 == 1) {
                            score$adjust(ref$IntRef, arrayListMutableListOf, -2, "optional-web-runtime");
                        } else if (iOrdinal4 == 2) {
                            score$adjust(ref$IntRef, arrayListMutableListOf, -8, "token-web-runtime");
                        } else {
                            if (iOrdinal4 != 3) {
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                                return null;
                            }
                            score$adjust(ref$IntRef, arrayListMutableListOf, -25, "full-webview");
                        }
                    }
                    ClientHealthScope.INSTANCE.getClass();
                    ClientHealthScope.Companion.from(contentHints, z4);
                    arrayList3.add(new SelectedClient(youTubeClient2, playbackClientManifest3, Integer.valueOf(ref$IntRef.element).intValue(), arrayListMutableListOf));
                } else {
                    arrayList.add(new RejectedClient(playbackClientManifest3, listBuilderHardRejectionReasons2));
                    i = i5;
                }
            }
            contentAwareFallbackStrategy = this;
            set = set;
            set2 = set2;
            arrayListPlus = arrayListPlus;
            size = size;
            i4 = i;
            z3 = false;
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList3, new SemanticsSortKt$special$$inlined$thenBy$1((byte) 9, new SemanticsSortKt$special$$inlined$thenBy$1((byte) 10, new LrcLib$getAllLyrics$$inlined$sortedByDescending$1(new SemanticsSortKt$special$$inlined$thenBy$1((byte) 8, clientSelectionRequest), clientSelectionRequest, z))));
        HashSet hashSet = new HashSet();
        ArrayList arrayList4 = new ArrayList();
        int size2 = arrayList.size();
        int i6 = 0;
        while (i6 < size2) {
            Object obj2 = arrayList.get(i6);
            i6++;
            if (hashSet.add(((RejectedClient) obj2).manifest.id)) {
                arrayList4.add(obj2);
            }
        }
        return new ClientSelectionResult(listSortedWith, CollectionsKt.sortedWith(arrayList4, new ContentAwareFallbackStrategy$selectClients$$inlined$sortedBy$1()));
    }
}
