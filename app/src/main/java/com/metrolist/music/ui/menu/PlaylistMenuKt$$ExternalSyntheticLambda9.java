package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.media3.exoplayer.offline.DownloadService;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlaylistMenuKt$$ExternalSyntheticLambda9 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ MutableState f$2;

    public /* synthetic */ PlaylistMenuKt$$ExternalSyntheticLambda9(Context context, MutableState mutableState, MutableState mutableState2) {
        this.$r8$classId = (byte) 0;
        this.f$0 = context;
        this.f$1 = mutableState;
        this.f$2 = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        final MutableState mutableState = this.f$2;
        final Context context = this.f$0;
        final MutableState mutableState2 = this.f$1;
        boolean z = false;
        final byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState2, (byte) 5);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, AlbumMenuKt.f245lambda$658405995, gapComposer, 805306374, 510);
                    boolean zChangedInstance = gapComposer.changedInstance(context);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                        final byte b3 = z ? (byte) 1 : (byte) 0;
                        objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.menu.PlaylistMenuKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b4 = b3;
                                Unit unit2 = Unit.INSTANCE;
                                Context context2 = context;
                                MutableState mutableState3 = mutableState;
                                MutableState mutableState4 = mutableState2;
                                switch (b4) {
                                    case 0:
                                        mutableState4.setValue(Boolean.FALSE);
                                        Iterator it = ((List) mutableState3.getValue()).iterator();
                                        while (it.hasNext()) {
                                            DownloadService.sendRemoveDownload(context2, ((Song) it.next()).song.id);
                                        }
                                        break;
                                    case 1:
                                        mutableState4.setValue(Boolean.FALSE);
                                        List list = (List) mutableState3.getValue();
                                        list.getClass();
                                        Iterator it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            DownloadService.sendRemoveDownload(context2, ((Song) it2.next()).song.id);
                                        }
                                        break;
                                    default:
                                        mutableState4.setValue(Boolean.FALSE);
                                        List list2 = (List) mutableState3.getValue();
                                        list2.getClass();
                                        Iterator it3 = list2.iterator();
                                        while (it3.hasNext()) {
                                            DownloadService.sendRemoveDownload(context2, ((Song) it3.next()).song.id);
                                        }
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    CardKt.TextButton((Function0) objRememberedValue2, null, false, null, null, null, AlbumMenuKt.f199lambda$385676148, gapComposer, 805306368, 510);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState, (byte) 3);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.TextButton((Function0) objRememberedValue3, null, false, null, null, null, TopPlaylistScreenKt.lambda$1095834797, gapComposer2, 805306374, 510);
                    boolean zChanged = gapComposer2.changed(mutableState2) | gapComposer2.changedInstance(context);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.menu.PlaylistMenuKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b4 = b2;
                                Unit unit2 = Unit.INSTANCE;
                                Context context2 = context;
                                MutableState mutableState3 = mutableState2;
                                MutableState mutableState4 = mutableState;
                                switch (b4) {
                                    case 0:
                                        mutableState4.setValue(Boolean.FALSE);
                                        Iterator it = ((List) mutableState3.getValue()).iterator();
                                        while (it.hasNext()) {
                                            DownloadService.sendRemoveDownload(context2, ((Song) it.next()).song.id);
                                        }
                                        break;
                                    case 1:
                                        mutableState4.setValue(Boolean.FALSE);
                                        List list = (List) mutableState3.getValue();
                                        list.getClass();
                                        Iterator it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            DownloadService.sendRemoveDownload(context2, ((Song) it2.next()).song.id);
                                        }
                                        break;
                                    default:
                                        mutableState4.setValue(Boolean.FALSE);
                                        List list2 = (List) mutableState3.getValue();
                                        list2.getClass();
                                        Iterator it3 = list2.iterator();
                                        while (it3.hasNext()) {
                                            DownloadService.sendRemoveDownload(context2, ((Song) it3.next()).song.id);
                                        }
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    CardKt.TextButton((Function0) objRememberedValue4, null, false, null, null, null, TopPlaylistScreenKt.f398lambda$2138023914, gapComposer2, 805306368, 510);
                }
                break;
            default:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                    if (objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState, (byte) 23);
                        gapComposer3.updateRememberedValue(objRememberedValue5);
                    }
                    CardKt.TextButton((Function0) objRememberedValue5, null, false, null, null, null, TopPlaylistScreenKt.lambda$1675136925, gapComposer3, 805306374, 510);
                    boolean zChanged2 = gapComposer3.changed(mutableState2) | gapComposer3.changedInstance(context);
                    Object objRememberedValue6 = gapComposer3.rememberedValue();
                    if (zChanged2 || objRememberedValue6 == neverEqualPolicy) {
                        final byte b4 = 2;
                        objRememberedValue6 = new Function0() { // from class: com.metrolist.music.ui.menu.PlaylistMenuKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b5 = b4;
                                Unit unit2 = Unit.INSTANCE;
                                Context context2 = context;
                                MutableState mutableState3 = mutableState2;
                                MutableState mutableState4 = mutableState;
                                switch (b5) {
                                    case 0:
                                        mutableState4.setValue(Boolean.FALSE);
                                        Iterator it = ((List) mutableState3.getValue()).iterator();
                                        while (it.hasNext()) {
                                            DownloadService.sendRemoveDownload(context2, ((Song) it.next()).song.id);
                                        }
                                        break;
                                    case 1:
                                        mutableState4.setValue(Boolean.FALSE);
                                        List list = (List) mutableState3.getValue();
                                        list.getClass();
                                        Iterator it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            DownloadService.sendRemoveDownload(context2, ((Song) it2.next()).song.id);
                                        }
                                        break;
                                    default:
                                        mutableState4.setValue(Boolean.FALSE);
                                        List list2 = (List) mutableState3.getValue();
                                        list2.getClass();
                                        Iterator it3 = list2.iterator();
                                        while (it3.hasNext()) {
                                            DownloadService.sendRemoveDownload(context2, ((Song) it3.next()).song.id);
                                        }
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer3.updateRememberedValue(objRememberedValue6);
                    }
                    CardKt.TextButton((Function0) objRememberedValue6, null, false, null, null, null, TopPlaylistScreenKt.lambda$1775514836, gapComposer3, 805306368, 510);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ PlaylistMenuKt$$ExternalSyntheticLambda9(byte b, Context context, MutableState mutableState, MutableState mutableState2) {
        this.$r8$classId = b;
        this.f$1 = mutableState;
        this.f$0 = context;
        this.f$2 = mutableState2;
    }
}
