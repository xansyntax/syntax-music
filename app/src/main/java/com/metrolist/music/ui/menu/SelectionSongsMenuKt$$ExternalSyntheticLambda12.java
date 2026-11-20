package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.media3.exoplayer.offline.DownloadService;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.entities.Song;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SelectionSongsMenuKt$$ExternalSyntheticLambda12 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ArrayList f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ MutableState f$2;

    public /* synthetic */ SelectionSongsMenuKt$$ExternalSyntheticLambda12(byte b, Context context, MutableState mutableState, ArrayList arrayList) {
        this.$r8$classId = b;
        this.f$0 = arrayList;
        this.f$1 = context;
        this.f$2 = mutableState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        final MutableState mutableState = this.f$2;
        final Context context = this.f$1;
        final ArrayList arrayList = this.f$0;
        Object[] objArr = 0;
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
                        objRememberedValue = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState, (byte) 20);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, AlbumMenuKt.lambda$507556107, gapComposer, 805306374, 510);
                    boolean zChangedInstance = gapComposer.changedInstance(arrayList) | gapComposer.changedInstance(context);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                        final Object[] objArr2 = objArr == true ? 1 : 0;
                        objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.menu.SelectionSongsMenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b3 = objArr2;
                                Unit unit2 = Unit.INSTANCE;
                                int i = 0;
                                Context context2 = context;
                                MutableState mutableState2 = mutableState;
                                ArrayList arrayList2 = arrayList;
                                switch (b3) {
                                    case 0:
                                        mutableState2.setValue(Boolean.FALSE);
                                        int size = arrayList2.size();
                                        while (i < size) {
                                            Object obj4 = arrayList2.get(i);
                                            i++;
                                            DownloadService.sendRemoveDownload(context2, ((Song) obj4).song.id);
                                        }
                                        break;
                                    default:
                                        mutableState2.setValue(Boolean.FALSE);
                                        int size2 = arrayList2.size();
                                        while (i < size2) {
                                            Object obj5 = arrayList2.get(i);
                                            i++;
                                            DownloadService.sendRemoveDownload(context2, ((SongItem) obj5).id);
                                        }
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    CardKt.TextButton((Function0) objRememberedValue2, null, false, null, null, null, AlbumMenuKt.lambda$607934018, gapComposer, 805306368, 510);
                }
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState, (byte) 25);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.TextButton((Function0) objRememberedValue3, null, false, null, null, null, AlbumMenuKt.lambda$234798380, gapComposer2, 805306374, 510);
                    boolean zChangedInstance2 = gapComposer2.changedInstance(arrayList) | gapComposer2.changedInstance(context);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new Function0() { // from class: com.metrolist.music.ui.menu.SelectionSongsMenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b3 = b2;
                                Unit unit2 = Unit.INSTANCE;
                                int i = 0;
                                Context context2 = context;
                                MutableState mutableState2 = mutableState;
                                ArrayList arrayList2 = arrayList;
                                switch (b3) {
                                    case 0:
                                        mutableState2.setValue(Boolean.FALSE);
                                        int size = arrayList2.size();
                                        while (i < size) {
                                            Object obj4 = arrayList2.get(i);
                                            i++;
                                            DownloadService.sendRemoveDownload(context2, ((Song) obj4).song.id);
                                        }
                                        break;
                                    default:
                                        mutableState2.setValue(Boolean.FALSE);
                                        int size2 = arrayList2.size();
                                        while (i < size2) {
                                            Object obj5 = arrayList2.get(i);
                                            i++;
                                            DownloadService.sendRemoveDownload(context2, ((SongItem) obj5).id);
                                        }
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    CardKt.TextButton((Function0) objRememberedValue4, null, false, null, null, null, AlbumMenuKt.f254lambda$738841821, gapComposer2, 805306368, 510);
                }
                break;
        }
        return unit;
    }
}
