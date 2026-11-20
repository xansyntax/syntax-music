package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.ui.Modifier;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongWithStats;
import com.yalantis.ucrop.R;
import java.time.LocalDateTime;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda97 implements Function2 {
    public final /* synthetic */ byte $r8$classId;

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((Integer) obj).intValue();
                Song song = (Song) obj2;
                song.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("home_quickpick_", song.song.id);
            case 1:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.search, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer, 0, 0, 131070);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 2:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.close, 0, gapComposer2), "Clear Artists", (Modifier) null, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface, gapComposer2, 56, 4);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 3:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.close, 0, gapComposer3), "Select Button", (Modifier) null, 0L, gapComposer3, 56, 12);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 4:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer4), "Back Button", (Modifier) null, 0L, gapComposer4, 56, 12);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 5:
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer5), "More Button", (Modifier) null, 0L, gapComposer5, 56, 12);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 6:
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.search, 0, gapComposer6), "Search Button", (Modifier) null, 0L, gapComposer6, 56, 12);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 7:
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.sync, 0, gapComposer7), "Time Transfer", (Modifier) null, 0L, gapComposer7, 56, 12);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 8:
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer8), (String) null, (Modifier) null, 0L, gapComposer8, 56, 12);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 9:
                List list = (List) obj2;
                ((SaveableHolder) obj).getClass();
                list.getClass();
                return CollectionsKt.toList(list);
            case 10:
                ((Integer) obj2).getClass();
                ListenTogetherScreenKt.NotConfiguredContent(Stack.updateChangedFlags(1), (Composer) obj);
                return unit;
            case 11:
                Integer num = (Integer) obj;
                num.intValue();
                LocalDateTime localDateTime = (LocalDateTime) obj2;
                localDateTime.getClass();
                return new Pair(num, String.valueOf(localDateTime.getYear()));
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                List list2 = (List) obj2;
                ((SaveableHolder) obj).getClass();
                list2.getClass();
                return CollectionsKt.toList(list2);
            case 13:
                ((Integer) obj).getClass();
                Playlist playlist = (Playlist) obj2;
                playlist.getClass();
                return playlist.playlist.id;
            case 14:
                ((Integer) obj).getClass();
                Artist artist = (Artist) obj2;
                artist.getClass();
                return artist.artist.id;
            case 15:
                ((Integer) obj).getClass();
                Album album = (Album) obj2;
                album.getClass();
                return album.album.id;
            case 16:
                int iIntValue9 = ((Integer) obj).intValue();
                SongWithStats songWithStats = (SongWithStats) obj2;
                songWithStats.getClass();
                return songWithStats.id + "_" + iIntValue9;
            case 17:
                List list3 = (List) obj2;
                ((SaveableHolder) obj).getClass();
                list3.getClass();
                return CollectionsKt.toList(list3);
            case 18:
                int iIntValue10 = ((Integer) obj).intValue();
                Song song2 = (Song) obj2;
                song2.getClass();
                return "local_song_" + song2.song.id + "_" + iIntValue10;
            case 19:
                int iIntValue11 = ((Integer) obj).intValue();
                Song song3 = (Song) obj2;
                song3.getClass();
                return song3.song.id + "_" + iIntValue11;
            case 20:
                Composer composer9 = (Composer) obj;
                int iIntValue12 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue12 & 1, (iIntValue12 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer9), (String) null, (Modifier) null, 0L, gapComposer9, 56, 12);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 21:
                Composer composer10 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue13 & 1, (iIntValue13 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer10), (String) null, (Modifier) null, 0L, gapComposer10, 56, 12);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 22:
                Composer composer11 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue14 & 1, (iIntValue14 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer11), (String) null, (Modifier) null, 0L, gapComposer11, 56, 12);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 23:
                Composer composer12 = (Composer) obj;
                int iIntValue15 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (gapComposer12.shouldExecute(iIntValue15 & 1, (iIntValue15 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer12), (String) null, (Modifier) null, 0L, gapComposer12, 56, 12);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case 24:
                Composer composer13 = (Composer) obj;
                int iIntValue16 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (gapComposer13.shouldExecute(iIntValue16 & 1, (iIntValue16 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer13), (String) null, (Modifier) null, 0L, gapComposer13, 56, 12);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 25:
                Composer composer14 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (gapComposer14.shouldExecute(iIntValue17 & 1, (iIntValue17 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.play, 0, gapComposer14), "Play All", (Modifier) null, 0L, gapComposer14, 56, 12);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 26:
                Composer composer15 = (Composer) obj;
                int iIntValue18 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (gapComposer15.shouldExecute(iIntValue18 & 1, (iIntValue18 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.play, 0, gapComposer15), "Play All", SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 32.0f), 0L, gapComposer15, 440, 8);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 27:
                Composer composer16 = (Composer) obj;
                int iIntValue19 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (gapComposer16.shouldExecute(iIntValue19 & 1, (iIntValue19 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.arrow_back, 0, gapComposer16), (String) null, (Modifier) null, 0L, gapComposer16, 56, 12);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 28:
                Composer composer17 = (Composer) obj;
                int iIntValue20 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (gapComposer17.shouldExecute(iIntValue20 & 1, (iIntValue20 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.link, 0, gapComposer17), (String) null, (Modifier) null, 0L, gapComposer17, 56, 12);
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer18 = (Composer) obj;
                int iIntValue21 = ((Integer) obj2).intValue();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (gapComposer18.shouldExecute(iIntValue21 & 1, (iIntValue21 & 3) != 2)) {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_vert, 0, gapComposer18), (String) null, (Modifier) null, 0L, gapComposer18, 56, 12);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda97(byte b) {
        this.$r8$classId = b;
    }
}
