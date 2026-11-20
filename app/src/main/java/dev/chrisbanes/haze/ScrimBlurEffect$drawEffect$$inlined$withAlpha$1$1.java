package dev.chrisbanes.haze;

import androidx.compose.material3.Shapes;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda0;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.theme.ThemeKt;
import com.metrolist.music.utils.InnerTubeXPlayer$$ExternalSyntheticLambda3;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.List;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $scrimTint$inlined;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.$scrimTint$inlined = obj;
        this.this$0 = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.this$0;
        Object obj3 = this.$scrimTint$inlined;
        switch (b) {
            case 0:
                DrawScope drawScope = (DrawScope) obj;
                drawScope.getClass();
                CanvasKt.m1540drawScrimDBWKusU(drawScope, (HazeTint) obj3, ((ScrimBlurEffect) obj2).node, 0L, drawScope.mo556getSizeNHjbRc());
                return unit;
            case 1:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                MutableState mutableState = (MutableState) obj2;
                musicDatabase.move(((PlaylistSong) mutableState.getValue()).map.position, Integer.MAX_VALUE, (String) obj3);
                musicDatabase.$$delegate_0.delete(PlaylistSongMap.copy$default(((PlaylistSong) mutableState.getValue()).map, Integer.MAX_VALUE, null, 23));
                return unit;
            case 2:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj3;
                PlaylistSongMap playlistSongMap = ((PlaylistSong) obj2).map;
                if (zBooleanValue) {
                    snapshotStateList.add(Integer.valueOf(playlistSongMap.id));
                } else {
                    snapshotStateList.remove(Integer.valueOf(playlistSongMap.id));
                }
                return unit;
            case 3:
                int iIntValue = ((Number) obj).intValue();
                return ((TopPlaylistScreenKt$$ExternalSyntheticLambda8) obj3).invoke(Integer.valueOf(iIntValue), ((List) obj2).get(iIntValue));
            case 4:
                SongItem songItem = (SongItem) obj2;
                SnapshotStateList snapshotStateList2 = (SnapshotStateList) obj3;
                if (((Boolean) obj).booleanValue()) {
                    snapshotStateList2.add(songItem.id);
                } else {
                    snapshotStateList2.remove(songItem.id);
                }
                return unit;
            case 5:
                int iIntValue2 = ((Number) obj).intValue();
                return ((TopPlaylistScreenKt$$ExternalSyntheticLambda8) obj3).invoke(Integer.valueOf(iIntValue2), ((List) obj2).get(iIntValue2));
            case 6:
                int iIntValue3 = ((Number) obj).intValue();
                return ((TopPlaylistScreenKt$$ExternalSyntheticLambda8) obj3).invoke(Integer.valueOf(iIntValue3), ((List) obj2).get(iIntValue3));
            case 7:
                int iIntValue4 = ((Number) obj).intValue();
                return ((TopPlaylistScreenKt$$ExternalSyntheticLambda8) obj3).invoke(Integer.valueOf(iIntValue4), ((List) obj2).get(iIntValue4));
            case 8:
                return ((LocalSearchScreenKt$$ExternalSyntheticLambda5) obj3).invoke(((List) obj2).get(((Number) obj).intValue()));
            case 9:
                return ((LocalSearchScreenKt$$ExternalSyntheticLambda5) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
            case 10:
                ((LocalSearchScreenKt$$ExternalSyntheticLambda5) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
                return 1;
            case 11:
                return ((LocalSearchScreenKt$$ExternalSyntheticLambda5) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((LocalSearchScreenKt$$ExternalSyntheticLambda5) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
                return "result_item";
            case 13:
                int iIntValue5 = ((Number) obj).intValue();
                return ((MainActivity$$ExternalSyntheticLambda0) obj3).invoke(Integer.valueOf(iIntValue5), ((List) obj2).get(iIntValue5));
            case 14:
                return ((LocalSearchScreenKt$$ExternalSyntheticLambda5) obj3).invoke(((List) obj2).get(((Number) obj).intValue()));
            case 15:
                ((LocalSearchScreenKt$$ExternalSyntheticLambda5) obj3).invoke(((List) obj2).get(((Number) obj).intValue()));
                return "suggestion";
            case 16:
                return ((LocalSearchScreenKt$$ExternalSyntheticLambda5) obj3).invoke(((List) obj2).get(((Number) obj).intValue()));
            case 17:
                ((InnerTubeXPlayer$$ExternalSyntheticLambda3) obj3).invoke(((List) obj2).get(((Number) obj).intValue()));
                return "suggestion";
            case 18:
                return ((InnerTubeXPlayer$$ExternalSyntheticLambda3) obj3).invoke(((List) obj2).get(((Number) obj).intValue()));
            case 19:
                ((InnerTubeXPlayer$$ExternalSyntheticLambda3) obj3).invoke(((List) obj2).get(((Number) obj).intValue()));
                return "result_item";
            case 20:
                return ((InnerTubeXPlayer$$ExternalSyntheticLambda3) obj3).invoke(((List) obj2).get(((Number) obj).intValue()));
            case 21:
                return ((InnerTubeXPlayer$$ExternalSyntheticLambda3) obj3).invoke(((List) obj2).get(((Number) obj).intValue()));
            case 22:
                return ((InnerTubeXPlayer$$ExternalSyntheticLambda3) obj3).invoke(((List) obj2).get(((Number) obj).intValue()));
            default:
                long j = ((Color) obj).value;
                ((MimesKt$$ExternalSyntheticLambda0) obj3).invoke(Integer.valueOf(ColorKt.m498toArgb8_81llA(j)));
                Shapes shapes = ThemeKt.EditorialShapes;
                ((MimesKt$$ExternalSyntheticLambda0) obj2).invoke(Boolean.valueOf(ULong.m1869equalsimpl0(j, -17343425833598976L)));
                return unit;
        }
    }
}
