package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.media3.exoplayer.offline.Download;
import androidx.media3.exoplayer.offline.DownloadService;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueMenuKt$$ExternalSyntheticLambda11 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ MediaMetadata f$1;
    public final /* synthetic */ DownloadUtil f$2;
    public final /* synthetic */ State f$3;

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda11(Context context, MediaMetadata mediaMetadata, DownloadUtil downloadUtil, State state, byte b) {
        this.$r8$classId = b;
        this.f$0 = context;
        this.f$1 = mediaMetadata;
        this.f$2 = downloadUtil;
        this.f$3 = state;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Integer numValueOf;
        Material3MenuItemData material3MenuItemData;
        Material3MenuItemData material3MenuItemData2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        State state = this.f$3;
        final DownloadUtil downloadUtil = this.f$2;
        final MediaMetadata mediaMetadata = this.f$1;
        final Context context = this.f$0;
        final byte b2 = 2;
        final byte b3 = 3;
        final byte b4 = 0;
        final byte b5 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Download download = (Download) state.getValue();
                    numValueOf = download != null ? Integer.valueOf(download.state) : null;
                    if (numValueOf != null && numValueOf.intValue() == 3) {
                        gapComposer.startReplaceGroup(-2096312473);
                        ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.f185lambda$302641954;
                        ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.lambda$1857914591;
                        boolean zChangedInstance = gapComposer.changedInstance(context) | gapComposer.changed(mediaMetadata);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda26
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b6 = b4;
                                    Unit unit2 = Unit.INSTANCE;
                                    MediaMetadata mediaMetadata2 = mediaMetadata;
                                    Context context2 = context;
                                    switch (b6) {
                                        case 0:
                                            DownloadService.sendRemoveDownload(context2, mediaMetadata2.id);
                                            break;
                                        case 1:
                                            DownloadService.sendRemoveDownload(context2, mediaMetadata2.id);
                                            break;
                                        case 2:
                                            DownloadService.sendRemoveDownload(context2, mediaMetadata2.id);
                                            break;
                                        default:
                                            DownloadService.sendRemoveDownload(context2, mediaMetadata2.id);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        material3MenuItemData = new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, null, (Function0) objRememberedValue, null, null, 52);
                        gapComposer.end(false);
                    } else if ((numValueOf != null && numValueOf.intValue() == 0) || (numValueOf != null && numValueOf.intValue() == 2)) {
                        gapComposer.startReplaceGroup(-2095176168);
                        ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.f285lambda$976498105;
                        ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.lambda$849137672;
                        boolean zChangedInstance2 = gapComposer.changedInstance(context) | gapComposer.changed(mediaMetadata);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda26
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b6 = b3;
                                    Unit unit2 = Unit.INSTANCE;
                                    MediaMetadata mediaMetadata2 = mediaMetadata;
                                    Context context2 = context;
                                    switch (b6) {
                                        case 0:
                                            DownloadService.sendRemoveDownload(context2, mediaMetadata2.id);
                                            break;
                                        case 1:
                                            DownloadService.sendRemoveDownload(context2, mediaMetadata2.id);
                                            break;
                                        case 2:
                                            DownloadService.sendRemoveDownload(context2, mediaMetadata2.id);
                                            break;
                                        default:
                                            DownloadService.sendRemoveDownload(context2, mediaMetadata2.id);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        material3MenuItemData = new Material3MenuItemData(composableLambdaImpl3, composableLambdaImpl4, null, (Function0) objRememberedValue2, null, null, 52);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-2094226390);
                        ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.lambda$1695503335;
                        ComposableLambdaImpl composableLambdaImpl6 = AlbumMenuKt.lambda$1371494952;
                        ComposableLambdaImpl composableLambdaImpl7 = AlbumMenuKt.lambda$1047486569;
                        boolean zChangedInstance3 = gapComposer.changedInstance(downloadUtil) | gapComposer.changed(mediaMetadata);
                        Object objRememberedValue3 = gapComposer.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new Function0() { // from class: com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda28
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b6 = b4;
                                    Unit unit2 = Unit.INSTANCE;
                                    MediaMetadata mediaMetadata2 = mediaMetadata;
                                    DownloadUtil downloadUtil2 = downloadUtil;
                                    switch (b6) {
                                        case 0:
                                            downloadUtil2.download(mediaMetadata2);
                                            break;
                                        default:
                                            downloadUtil2.download(mediaMetadata2);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        }
                        material3MenuItemData = new Material3MenuItemData(composableLambdaImpl5, composableLambdaImpl6, composableLambdaImpl7, (Function0) objRememberedValue3, null, null, 48);
                        gapComposer.end(false);
                    }
                    MenuKt.Material3MenuGroup(CollectionsKt__IterablesKt.listOf(material3MenuItemData), gapComposer, 0);
                }
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Download download2 = (Download) state.getValue();
                    numValueOf = download2 != null ? Integer.valueOf(download2.state) : null;
                    if (numValueOf != null && numValueOf.intValue() == 3) {
                        gapComposer2.startReplaceGroup(-989755192);
                        ComposableLambdaImpl composableLambdaImpl8 = AlbumMenuKt.lambda$230401328;
                        ComposableLambdaImpl composableLambdaImpl9 = AlbumMenuKt.lambda$332878321;
                        boolean zChangedInstance4 = gapComposer2.changedInstance(context) | gapComposer2.changed(mediaMetadata);
                        Object objRememberedValue4 = gapComposer2.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue4 == neverEqualPolicy) {
                            objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda26
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b6 = b5;
                                    Unit unit2 = Unit.INSTANCE;
                                    MediaMetadata mediaMetadata2 = mediaMetadata;
                                    Context context2 = context;
                                    switch (b6) {
                                        case 0:
                                            DownloadService.sendRemoveDownload(context2, mediaMetadata2.id);
                                            break;
                                        case 1:
                                            DownloadService.sendRemoveDownload(context2, mediaMetadata2.id);
                                            break;
                                        case 2:
                                            DownloadService.sendRemoveDownload(context2, mediaMetadata2.id);
                                            break;
                                        default:
                                            DownloadService.sendRemoveDownload(context2, mediaMetadata2.id);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue4);
                        }
                        material3MenuItemData2 = new Material3MenuItemData(composableLambdaImpl8, composableLambdaImpl9, null, (Function0) objRememberedValue4, null, null, 52);
                        gapComposer2.end(false);
                    } else if ((numValueOf != null && numValueOf.intValue() == 0) || (numValueOf != null && numValueOf.intValue() == 2)) {
                        gapComposer2.startReplaceGroup(-988446372);
                        ComposableLambdaImpl composableLambdaImpl10 = AlbumMenuKt.f184lambda$290686119;
                        ComposableLambdaImpl composableLambdaImpl11 = AlbumMenuKt.f236lambda$594543654;
                        boolean zChangedInstance5 = gapComposer2.changedInstance(context) | gapComposer2.changed(mediaMetadata);
                        Object objRememberedValue5 = gapComposer2.rememberedValue();
                        if (zChangedInstance5 || objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = new Function0() { // from class: com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda26
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b6 = b2;
                                    Unit unit2 = Unit.INSTANCE;
                                    MediaMetadata mediaMetadata2 = mediaMetadata;
                                    Context context2 = context;
                                    switch (b6) {
                                        case 0:
                                            DownloadService.sendRemoveDownload(context2, mediaMetadata2.id);
                                            break;
                                        case 1:
                                            DownloadService.sendRemoveDownload(context2, mediaMetadata2.id);
                                            break;
                                        case 2:
                                            DownloadService.sendRemoveDownload(context2, mediaMetadata2.id);
                                            break;
                                        default:
                                            DownloadService.sendRemoveDownload(context2, mediaMetadata2.id);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue5);
                        }
                        material3MenuItemData2 = new Material3MenuItemData(composableLambdaImpl10, composableLambdaImpl11, null, (Function0) objRememberedValue5, null, null, 52);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(-987422907);
                        ComposableLambdaImpl composableLambdaImpl12 = AlbumMenuKt.f214lambda$483232519;
                        ComposableLambdaImpl composableLambdaImpl13 = AlbumMenuKt.f232lambda$568041990;
                        boolean zChangedInstance6 = gapComposer2.changedInstance(downloadUtil) | gapComposer2.changed(mediaMetadata);
                        Object objRememberedValue6 = gapComposer2.rememberedValue();
                        if (zChangedInstance6 || objRememberedValue6 == neverEqualPolicy) {
                            objRememberedValue6 = new Function0() { // from class: com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda28
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b6 = b5;
                                    Unit unit2 = Unit.INSTANCE;
                                    MediaMetadata mediaMetadata2 = mediaMetadata;
                                    DownloadUtil downloadUtil2 = downloadUtil;
                                    switch (b6) {
                                        case 0:
                                            downloadUtil2.download(mediaMetadata2);
                                            break;
                                        default:
                                            downloadUtil2.download(mediaMetadata2);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue6);
                        }
                        material3MenuItemData2 = new Material3MenuItemData(composableLambdaImpl12, composableLambdaImpl13, null, (Function0) objRememberedValue6, null, null, 52);
                        gapComposer2.end(false);
                    }
                    MenuKt.Material3MenuGroup(CollectionsKt__IterablesKt.listOf(material3MenuItemData2), gapComposer2, 0);
                }
                break;
        }
        return unit;
    }
}
