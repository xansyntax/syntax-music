package com.metrolist.music.ui.menu;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda40;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.R;
import io.ktor.sse.ServerSentEventKt;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda48 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Song f$0;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda48(Song song, byte b) {
        this.$r8$classId = b;
        this.f$0 = song;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Song song = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(song.song.inLibrary == null ? R.drawable.library_add : R.drawable.library_add_check, 0, gapComposer), (String) null, (Modifier) null, 0L, gapComposer, 56, 12);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Map map = (Map) gapComposer2.consume(MainActivityKt.LocalArtistNameAliases);
                    List orderedArtists = song.getOrderedArtists();
                    String strM = IntIntPair$$ExternalSyntheticOutline0.m(ServerSentEventKt.SPACE, MathKt.stringResource(R.string.and, gapComposer2), ServerSentEventKt.SPACE);
                    boolean zChangedInstance = gapComposer2.changedInstance(map);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new QueueKt$$ExternalSyntheticLambda40(map, (byte) 5);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    String strJoinByBullet = UtilsKt.joinByBullet(UtilsKt.joinToArtistString(orderedArtists, strM, (Function1) objRememberedValue), UtilsKt.makeTimeString(Long.valueOf(((long) song.song.duration) * 1000)));
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strJoinByBullet, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer2, 0, 24960, 110586);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(song.song.inLibrary == null ? R.string.add_to_library : R.string.remove_from_library, gapComposer3), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    List orderedArtists2 = song.getOrderedArtists();
                    Object objRememberedValue2 = gapComposer4.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 12);
                        gapComposer4.updateRememberedValue(objRememberedValue2);
                    }
                    TextKt.m352TextNvy7gAk(CollectionsKt.joinToString$default(orderedArtists2, null, null, null, (Function1) objRememberedValue2, 31), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                }
                break;
            case 4:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    String str = song.song.albumName;
                    if (str != null) {
                        gapComposer5.startReplaceGroup(921988629);
                        TextKt.m352TextNvy7gAk(str, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262142);
                        gapComposer5.end(false);
                    } else {
                        gapComposer5.startReplaceGroup(921988628);
                        gapComposer5.end(false);
                    }
                }
                break;
            default:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    String str2 = song.song.albumName;
                    if (str2 != null) {
                        gapComposer6.startReplaceGroup(-224303237);
                        TextKt.m352TextNvy7gAk(str2, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 0, 0, 262142);
                        gapComposer6.end(false);
                    } else {
                        gapComposer6.startReplaceGroup(-224303238);
                        gapComposer6.end(false);
                    }
                }
                break;
        }
        return unit;
    }
}
