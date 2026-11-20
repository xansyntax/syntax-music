package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.media3.exoplayer.offline.DownloadService;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumMenuKt$$ExternalSyntheticLambda18 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ DownloadUtil f$1;
    public final /* synthetic */ ParcelableSnapshotMutableIntState f$2;
    public final /* synthetic */ MutableState f$3;

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda18(Context context, DownloadUtil downloadUtil, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState) {
        this.f$0 = context;
        this.f$1 = downloadUtil;
        this.f$2 = parcelableSnapshotMutableIntState;
        this.f$3 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Material3MenuItemData material3MenuItemData;
        Material3MenuItemData material3MenuItemData2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.f$2;
        DownloadUtil downloadUtil = this.f$1;
        final Context context = this.f$0;
        final MutableState mutableState = this.f$3;
        final byte b2 = 3;
        final byte b3 = 1;
        final byte b4 = 2;
        final byte b5 = 0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    int intValue = parcelableSnapshotMutableIntState.getIntValue();
                    if (intValue == 0 || intValue == 2) {
                        gapComposer.startReplaceGroup(-691100626);
                        ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.f128lambda$1749818088;
                        ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.f160lambda$1991515401;
                        boolean zChangedInstance = gapComposer.changedInstance(context);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b6 = b3;
                                    Unit unit2 = Unit.INSTANCE;
                                    Context context2 = context;
                                    MutableState mutableState2 = mutableState;
                                    switch (b6) {
                                        case 0:
                                            Iterator it = ((List) mutableState2.getValue()).iterator();
                                            while (it.hasNext()) {
                                                DownloadService.sendRemoveDownload(context2, ((Song) it.next()).song.id);
                                            }
                                            break;
                                        case 1:
                                            Iterator it2 = ((List) mutableState2.getValue()).iterator();
                                            while (it2.hasNext()) {
                                                DownloadService.sendRemoveDownload(context2, ((Song) it2.next()).song.id);
                                            }
                                            break;
                                        case 2:
                                            AlbumWithSongs albumWithSongs = (AlbumWithSongs) mutableState2.getValue();
                                            if (albumWithSongs != null) {
                                                Iterator it3 = albumWithSongs.songs.iterator();
                                                while (it3.hasNext()) {
                                                    DownloadService.sendRemoveDownload(context2, ((Song) it3.next()).song.id);
                                                }
                                            }
                                            break;
                                        default:
                                            AlbumWithSongs albumWithSongs2 = (AlbumWithSongs) mutableState2.getValue();
                                            if (albumWithSongs2 != null) {
                                                Iterator it4 = albumWithSongs2.songs.iterator();
                                                while (it4.hasNext()) {
                                                    DownloadService.sendRemoveDownload(context2, ((Song) it4.next()).song.id);
                                                }
                                            }
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        material3MenuItemData = new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, null, (Function0) objRememberedValue, null, null, 52);
                        gapComposer.end(false);
                    } else if (intValue != 3) {
                        gapComposer.startReplaceGroup(-689959733);
                        ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.lambda$1845118840;
                        ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.f54lambda$1111356201;
                        ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.lambda$227136054;
                        boolean zChangedInstance2 = gapComposer.changedInstance(downloadUtil);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new AlbumMenuKt$$ExternalSyntheticLambda31(mutableState, downloadUtil, (byte) 0);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        material3MenuItemData = new Material3MenuItemData(composableLambdaImpl3, composableLambdaImpl4, composableLambdaImpl5, (Function0) objRememberedValue2, null, null, 48);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-692437625);
                        ComposableLambdaImpl composableLambdaImpl6 = AlbumMenuKt.f133lambda$177213983;
                        ComposableLambdaImpl composableLambdaImpl7 = AlbumMenuKt.lambda$1918621568;
                        boolean zChangedInstance3 = gapComposer.changedInstance(context);
                        Object objRememberedValue3 = gapComposer.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new Function0() { // from class: com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b6 = b5;
                                    Unit unit2 = Unit.INSTANCE;
                                    Context context2 = context;
                                    MutableState mutableState2 = mutableState;
                                    switch (b6) {
                                        case 0:
                                            Iterator it = ((List) mutableState2.getValue()).iterator();
                                            while (it.hasNext()) {
                                                DownloadService.sendRemoveDownload(context2, ((Song) it.next()).song.id);
                                            }
                                            break;
                                        case 1:
                                            Iterator it2 = ((List) mutableState2.getValue()).iterator();
                                            while (it2.hasNext()) {
                                                DownloadService.sendRemoveDownload(context2, ((Song) it2.next()).song.id);
                                            }
                                            break;
                                        case 2:
                                            AlbumWithSongs albumWithSongs = (AlbumWithSongs) mutableState2.getValue();
                                            if (albumWithSongs != null) {
                                                Iterator it3 = albumWithSongs.songs.iterator();
                                                while (it3.hasNext()) {
                                                    DownloadService.sendRemoveDownload(context2, ((Song) it3.next()).song.id);
                                                }
                                            }
                                            break;
                                        default:
                                            AlbumWithSongs albumWithSongs2 = (AlbumWithSongs) mutableState2.getValue();
                                            if (albumWithSongs2 != null) {
                                                Iterator it4 = albumWithSongs2.songs.iterator();
                                                while (it4.hasNext()) {
                                                    DownloadService.sendRemoveDownload(context2, ((Song) it4.next()).song.id);
                                                }
                                            }
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        }
                        material3MenuItemData = new Material3MenuItemData(composableLambdaImpl6, composableLambdaImpl7, null, (Function0) objRememberedValue3, null, null, 52);
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
                    int intValue2 = parcelableSnapshotMutableIntState.getIntValue();
                    if (intValue2 == 0 || intValue2 == 2) {
                        gapComposer2.startReplaceGroup(1491793127);
                        ComposableLambdaImpl composableLambdaImpl8 = AlbumMenuKt.f166lambda$2047188649;
                        ComposableLambdaImpl composableLambdaImpl9 = AlbumMenuKt.lambda$1775781238;
                        boolean zChanged = gapComposer2.changed(mutableState) | gapComposer2.changedInstance(context);
                        Object objRememberedValue4 = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                            objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b6 = b2;
                                    Unit unit2 = Unit.INSTANCE;
                                    Context context2 = context;
                                    MutableState mutableState2 = mutableState;
                                    switch (b6) {
                                        case 0:
                                            Iterator it = ((List) mutableState2.getValue()).iterator();
                                            while (it.hasNext()) {
                                                DownloadService.sendRemoveDownload(context2, ((Song) it.next()).song.id);
                                            }
                                            break;
                                        case 1:
                                            Iterator it2 = ((List) mutableState2.getValue()).iterator();
                                            while (it2.hasNext()) {
                                                DownloadService.sendRemoveDownload(context2, ((Song) it2.next()).song.id);
                                            }
                                            break;
                                        case 2:
                                            AlbumWithSongs albumWithSongs = (AlbumWithSongs) mutableState2.getValue();
                                            if (albumWithSongs != null) {
                                                Iterator it3 = albumWithSongs.songs.iterator();
                                                while (it3.hasNext()) {
                                                    DownloadService.sendRemoveDownload(context2, ((Song) it3.next()).song.id);
                                                }
                                            }
                                            break;
                                        default:
                                            AlbumWithSongs albumWithSongs2 = (AlbumWithSongs) mutableState2.getValue();
                                            if (albumWithSongs2 != null) {
                                                Iterator it4 = albumWithSongs2.songs.iterator();
                                                while (it4.hasNext()) {
                                                    DownloadService.sendRemoveDownload(context2, ((Song) it4.next()).song.id);
                                                }
                                            }
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue4);
                        }
                        material3MenuItemData2 = new Material3MenuItemData(composableLambdaImpl8, composableLambdaImpl9, null, (Function0) objRememberedValue4, null, null, 52);
                        gapComposer2.end(false);
                    } else if (intValue2 != 3) {
                        gapComposer2.startReplaceGroup(1492941956);
                        ComposableLambdaImpl composableLambdaImpl10 = AlbumMenuKt.f181lambda$267326537;
                        ComposableLambdaImpl composableLambdaImpl11 = AlbumMenuKt.f191lambda$343165098;
                        ComposableLambdaImpl composableLambdaImpl12 = AlbumMenuKt.f203lambda$419003659;
                        boolean zChanged2 = gapComposer2.changed(mutableState) | gapComposer2.changedInstance(downloadUtil);
                        Object objRememberedValue5 = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = new AlbumMenuKt$$ExternalSyntheticLambda31(mutableState, downloadUtil, (byte) 2);
                            gapComposer2.updateRememberedValue(objRememberedValue5);
                        }
                        material3MenuItemData2 = new Material3MenuItemData(composableLambdaImpl10, composableLambdaImpl11, composableLambdaImpl12, (Function0) objRememberedValue5, null, null, 48);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(1490430336);
                        ComposableLambdaImpl composableLambdaImpl13 = AlbumMenuKt.lambda$982198752;
                        ComposableLambdaImpl composableLambdaImpl14 = AlbumMenuKt.lambda$1115785663;
                        boolean zChanged3 = gapComposer2.changed(mutableState) | gapComposer2.changedInstance(context);
                        Object objRememberedValue6 = gapComposer2.rememberedValue();
                        if (zChanged3 || objRememberedValue6 == neverEqualPolicy) {
                            objRememberedValue6 = new Function0() { // from class: com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b6 = b4;
                                    Unit unit2 = Unit.INSTANCE;
                                    Context context2 = context;
                                    MutableState mutableState2 = mutableState;
                                    switch (b6) {
                                        case 0:
                                            Iterator it = ((List) mutableState2.getValue()).iterator();
                                            while (it.hasNext()) {
                                                DownloadService.sendRemoveDownload(context2, ((Song) it.next()).song.id);
                                            }
                                            break;
                                        case 1:
                                            Iterator it2 = ((List) mutableState2.getValue()).iterator();
                                            while (it2.hasNext()) {
                                                DownloadService.sendRemoveDownload(context2, ((Song) it2.next()).song.id);
                                            }
                                            break;
                                        case 2:
                                            AlbumWithSongs albumWithSongs = (AlbumWithSongs) mutableState2.getValue();
                                            if (albumWithSongs != null) {
                                                Iterator it3 = albumWithSongs.songs.iterator();
                                                while (it3.hasNext()) {
                                                    DownloadService.sendRemoveDownload(context2, ((Song) it3.next()).song.id);
                                                }
                                            }
                                            break;
                                        default:
                                            AlbumWithSongs albumWithSongs2 = (AlbumWithSongs) mutableState2.getValue();
                                            if (albumWithSongs2 != null) {
                                                Iterator it4 = albumWithSongs2.songs.iterator();
                                                while (it4.hasNext()) {
                                                    DownloadService.sendRemoveDownload(context2, ((Song) it4.next()).song.id);
                                                }
                                            }
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue6);
                        }
                        material3MenuItemData2 = new Material3MenuItemData(composableLambdaImpl13, composableLambdaImpl14, null, (Function0) objRememberedValue6, null, null, 52);
                        gapComposer2.end(false);
                    }
                    MenuKt.Material3MenuGroup(CollectionsKt__IterablesKt.listOf(material3MenuItemData2), gapComposer2, 0);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda18(MutableState mutableState, Context context, DownloadUtil downloadUtil, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState) {
        this.f$3 = mutableState;
        this.f$0 = context;
        this.f$1 = downloadUtil;
        this.f$2 = parcelableSnapshotMutableIntState;
    }
}
