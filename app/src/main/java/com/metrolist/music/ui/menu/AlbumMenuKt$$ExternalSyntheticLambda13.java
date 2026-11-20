package com.metrolist.music.ui.menu;

import androidx.collection.internal.Lock;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaItem;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.lyrics.LyricsEntry;
import com.metrolist.music.lyrics.LyricsTranslationHelper;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.queues.Queue;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumMenuKt$$ExternalSyntheticLambda13 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda13(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object[] objArr = 0;
        final byte b = 1;
        switch (this.$r8$classId) {
            case 0:
                ArtistEntity artistEntity = (ArtistEntity) obj;
                artistEntity.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("menu_album_artist_", artistEntity.id);
            case 1:
                ArtistEntity artistEntity2 = (ArtistEntity) obj;
                boolean z = MusicService.isRunning;
                artistEntity2.getClass();
                return artistEntity2.name;
            case 2:
                return ((ArtistEntity) obj).name;
            case 3:
                return Boolean.valueOf(Queue.Status.filterVideoSongs$lambda$0((MediaItem) obj));
            case 4:
                return Boolean.valueOf(Queue.Status.filterExplicit$lambda$0((MediaItem) obj));
            case 5:
                ((AnimatedContentTransitionScope) obj).getClass();
                return CrossfadeKt.togetherWith(EnterExitTransitionKt.slideInHorizontally$default(null, 3).plus(EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3)), EnterExitTransitionKt.slideOutHorizontally$default(null, 3).plus(EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3)));
            case 6:
                ((String) obj).getClass();
                return Unit.INSTANCE;
            case 7:
                String str = (String) obj;
                str.getClass();
                return Boolean.valueOf(str.length() > 0);
            case 8:
                return Unit.INSTANCE;
            case 9:
                MediaMetadata.Artist artist = (MediaMetadata.Artist) obj;
                artist.getClass();
                return artist.name;
            case 10:
                ((DisposableEffectScope) obj).getClass();
                LyricsTranslationHelper.isCompositionActive = true;
                return new DisposableEffectResult() { // from class: com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$lambda$32$0$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public final void dispose() {
                        switch (b) {
                            case 0:
                                LyricsTranslationHelper.isCompositionActive = false;
                                LyricsTranslationHelper.cancelTranslation();
                                break;
                            default:
                                LyricsTranslationHelper.isCompositionActive = false;
                                LyricsTranslationHelper.cancelTranslation();
                                break;
                        }
                    }
                };
            case 11:
                ((Long) obj).getClass();
                return Unit.INSTANCE;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.getClass();
                layoutNodeDrawScope.drawContent();
                CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)) / 2.0f)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (canvasDrawScope.mo556getSizeNHjbRc() & 4294967295L)) / 2.0f)));
                Pair[] pairArr = {new Pair(Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO), new Color(ColorKt.Color(Color.m485getRedimpl(-4294967296L), Color.m484getGreenimpl(-4294967296L), Color.m482getBlueimpl(-4294967296L), 0.7f, Color.m483getColorSpaceimpl(-4294967296L)))), new Pair(Float.valueOf(0.6f), new Color(0L))};
                DrawScope.m551drawRoundRectZuiqVtQ$default(layoutNodeDrawScope, Lock.m9linearGradientmHitzGk((Pair[]) Arrays.copyOf(pairArr, pairArr.length), (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L), (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) & 4294967295L)), 0L, 0L, jFloatToRawIntBits, CropImageView.DEFAULT_ASPECT_RATIO, null, 246);
                DrawScope.m552drawRoundRectuAw5IA$default(layoutNodeDrawScope, ColorKt.Color(Color.m485getRedimpl(-72057594037927936L), Color.m484getGreenimpl(-72057594037927936L), Color.m482getBlueimpl(-72057594037927936L), 0.06f, Color.m483getColorSpaceimpl(-72057594037927936L)), 0L, 0L, jFloatToRawIntBits, new Stroke(layoutNodeDrawScope.mo81toPx0680j_4(0.8f), CropImageView.DEFAULT_ASPECT_RATIO, 0, 0, 30), 230);
                return Unit.INSTANCE;
            case 13:
                Integer num = (Integer) obj;
                num.intValue();
                return num;
            case 14:
                ArtistEntity artistEntity3 = (ArtistEntity) obj;
                artistEntity3.getClass();
                return artistEntity3.name;
            case 15:
                ArtistEntity artistEntity4 = (ArtistEntity) obj;
                artistEntity4.getClass();
                return artistEntity4.name;
            case 16:
                ((Integer) obj).getClass();
                return Unit.INSTANCE;
            case 17:
                MediaMetadata.Artist artist2 = (MediaMetadata.Artist) obj;
                artist2.getClass();
                return artist2.name;
            case 18:
                MediaMetadata.Artist artist3 = (MediaMetadata.Artist) obj;
                artist3.getClass();
                return artist3.name;
            case 19:
                ((DisposableEffectScope) obj).getClass();
                LyricsTranslationHelper.isCompositionActive = true;
                final Object[] objArr2 = objArr == true ? 1 : 0;
                return new DisposableEffectResult() { // from class: com.metrolist.music.ui.component.OriginalLyricsKt$OriginalLyrics$lambda$32$0$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public final void dispose() {
                        switch (objArr2) {
                            case 0:
                                LyricsTranslationHelper.isCompositionActive = false;
                                LyricsTranslationHelper.cancelTranslation();
                                break;
                            default:
                                LyricsTranslationHelper.isCompositionActive = false;
                                LyricsTranslationHelper.cancelTranslation();
                                break;
                        }
                    }
                };
            case 20:
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                int iIntValue = ((Number) entry.getKey()).intValue();
                Pair pair = (Pair) entry.getValue();
                return iIntValue + "=" + pair.first + "-" + pair.second;
            case 21:
                ArtistEntity artistEntity5 = (ArtistEntity) obj;
                artistEntity5.getClass();
                return artistEntity5.name;
            case 22:
                Playlist playlist = (Playlist) obj;
                playlist.getClass();
                return playlist.playlist.id;
            case 23:
                ((String) obj).getClass();
                return Unit.INSTANCE;
            case 24:
                Playlist playlist2 = (Playlist) obj;
                playlist2.getClass();
                return playlist2.playlist.id;
            case 25:
                ArtistEntity artistEntity6 = (ArtistEntity) obj;
                artistEntity6.getClass();
                return artistEntity6.name;
            case 26:
                return ((ArtistEntity) obj).name;
            case 27:
                return ((ArtistEntity) obj).id;
            case 28:
                MediaMetadata.Artist artist4 = (MediaMetadata.Artist) obj;
                artist4.getClass();
                return artist4.name;
            default:
                LyricsEntry lyricsEntry = (LyricsEntry) obj;
                lyricsEntry.getClass();
                return lyricsEntry.text;
        }
    }
}
