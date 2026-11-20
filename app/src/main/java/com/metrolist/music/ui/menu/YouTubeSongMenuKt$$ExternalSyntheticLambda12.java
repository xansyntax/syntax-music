package com.metrolist.music.ui.menu;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda40;
import com.metrolist.music.utils.UtilsKt;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class YouTubeSongMenuKt$$ExternalSyntheticLambda12 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SongItem f$0;
    public final /* synthetic */ Map f$1;

    public /* synthetic */ YouTubeSongMenuKt$$ExternalSyntheticLambda12(SongItem songItem, Map map, byte b) {
        this.$r8$classId = b;
        this.f$0 = songItem;
        this.f$1 = map;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws IOException {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Map map = this.f$1;
        SongItem songItem = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    List list = songItem.artists;
                    boolean zChangedInstance = gapComposer.changedInstance(map);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new QueueKt$$ExternalSyntheticLambda40(map, (byte) 9);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    String strJoinToString$default = CollectionsKt.joinToString$default(list, null, null, null, (Function1) objRememberedValue, 31);
                    Integer num = songItem.duration;
                    TextKt.m352TextNvy7gAk(UtilsKt.joinByBullet(strJoinToString$default, num != null ? UtilsKt.makeTimeString(Long.valueOf(((long) num.intValue()) * 1000)) : null), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                }
                break;
            default:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    List list2 = songItem.artists;
                    boolean zChangedInstance2 = gapComposer2.changedInstance(map);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new QueueKt$$ExternalSyntheticLambda40(map, (byte) 10);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    TextKt.m352TextNvy7gAk(CollectionsKt.joinToString$default(list2, null, null, null, (Function1) objRememberedValue2, 31), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262142);
                }
                break;
        }
        return unit;
    }
}
