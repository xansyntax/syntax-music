package com.metrolist.music.ui.menu;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import com.metrolist.music.models.MediaMetadata;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueMenuKt$$ExternalSyntheticLambda22 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaMetadata f$0;

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda22(MediaMetadata mediaMetadata, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaMetadata;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        MediaMetadata mediaMetadata = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    List list = mediaMetadata.artists;
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new SongMenuKt$$ExternalSyntheticLambda16((byte) 8);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    TextKt.m352TextNvy7gAk(CollectionsKt.joinToString$default(list, null, null, null, (Function1) objRememberedValue, 31), null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer, 0, 24960, 241662);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    List list2 = mediaMetadata.artists;
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 3);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    TextKt.m352TextNvy7gAk(CollectionsKt.joinToString$default(list2, null, null, null, (Function1) objRememberedValue2, 31), null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer2, 0, 24960, 241662);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(mediaMetadata.album.title, null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer3, 0, 24960, 241662);
                }
                break;
            default:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(mediaMetadata.album.title, null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer4, 0, 24960, 241662);
                }
                break;
        }
        return unit;
    }
}
