package com.metrolist.music.ui.menu;

import androidx.activity.result.ActivityResult;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.models.MediaMetadata;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda16 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda16(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                String str = (String) obj;
                str.getClass();
                int length = str.length();
                return new TextFieldValue(4, TextRangeKt.TextRange(length, length), str);
            case 1:
                MediaMetadata.Artist artist = (MediaMetadata.Artist) obj;
                artist.getClass();
                return artist.name;
            case 2:
                ((ActivityResult) obj).getClass();
                return unit;
            case 3:
                MediaMetadata.Artist artist2 = (MediaMetadata.Artist) obj;
                artist2.getClass();
                return artist2.name;
            case 4:
                return "x" + ((Float) obj).floatValue();
            case 5:
                return "x" + ((Float) obj).floatValue();
            case 6:
                int iIntValue = ((Integer) obj).intValue();
                return IntIntPair$$ExternalSyntheticOutline0.m(iIntValue, iIntValue > 0 ? "+" : "");
            case 7:
                PlaylistSong playlistSong = (PlaylistSong) obj;
                playlistSong.getClass();
                return playlistSong.song.song.title;
            case 8:
                MediaMetadata.Artist artist3 = (MediaMetadata.Artist) obj;
                artist3.getClass();
                return artist3.name;
            case 9:
                ArtistEntity artistEntity = (ArtistEntity) obj;
                artistEntity.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("menu_song_artist_", artistEntity.id);
            case 10:
                ArtistEntity artistEntity2 = (ArtistEntity) obj;
                artistEntity2.getClass();
                return artistEntity2.name;
            case 11:
                ArtistEntity artistEntity3 = (ArtistEntity) obj;
                artistEntity3.getClass();
                return artistEntity3.name;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ArtistEntity artistEntity4 = (ArtistEntity) obj;
                artistEntity4.getClass();
                return artistEntity4.name;
            case 13:
                ArtistEntity artistEntity5 = (ArtistEntity) obj;
                artistEntity5.getClass();
                return artistEntity5.name;
            case 14:
                return ((ArtistEntity) obj).name;
            case 15:
                return ((ArtistEntity) obj).id;
            case 16:
                ArtistEntity artistEntity6 = (ArtistEntity) obj;
                artistEntity6.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("menu_yt_album_artist_", artistEntity6.id);
            case 17:
                ((Boolean) obj).getClass();
                return unit;
            case 18:
                ((Integer) obj).getClass();
                return unit;
            case 19:
                MediaMetadata.Artist artist4 = (MediaMetadata.Artist) obj;
                artist4.getClass();
                return artist4.name;
            case 20:
                MediaMetadata.Artist artist5 = (MediaMetadata.Artist) obj;
                artist5.getClass();
                return artist5.name;
            case 21:
                MediaMetadata.Artist artist6 = (MediaMetadata.Artist) obj;
                artist6.getClass();
                return artist6.name;
            case 22:
                ((AnimatedContentTransitionScope) obj).getClass();
                return CrossfadeKt.togetherWith(EnterExitTransitionKt.fadeIn$default(ArcSplineKt.tween$default(140, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2).plus(EnterExitTransitionKt.m15scaleInL8ZKhE$default(ArcSplineKt.tween$default(180, 0, null, 6), 0.6f, 4)), EnterExitTransitionKt.fadeOut$default(ArcSplineKt.tween$default(90, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2).plus(EnterExitTransitionKt.m16scaleOutL8ZKhE$default(ArcSplineKt.tween$default(120, 0, null, 6), 0.6f, 4)));
            case 23:
                Throwable th = (Throwable) obj;
                th.getClass();
                String simpleName = th.getClass().getSimpleName();
                return StringsKt.isBlank(simpleName) ? th.getClass().getName() : simpleName;
            case 24:
                Throwable th2 = (Throwable) obj;
                th2.getClass();
                return th2.getCause();
            case 25:
                MediaMetadata.Artist artist7 = (MediaMetadata.Artist) obj;
                artist7.getClass();
                return artist7.name;
            case 26:
                ((AnimatedContentTransitionScope) obj).getClass();
                return CrossfadeKt.togetherWith(EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3), EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3));
            case 27:
                ((AnimatedContentTransitionScope) obj).getClass();
                return CrossfadeKt.togetherWith(EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3), EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3));
            case 28:
                ((AnimatedContentTransitionScope) obj).getClass();
                return CrossfadeKt.togetherWith(EnterExitTransitionKt.fadeIn$default(ArcSplineKt.tween$default(150, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2).plus(EnterExitTransitionKt.m15scaleInL8ZKhE$default(ArcSplineKt.tween$default(150, 0, null, 6), 0.8f, 4)), EnterExitTransitionKt.fadeOut$default(ArcSplineKt.tween$default(150, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2).plus(EnterExitTransitionKt.m16scaleOutL8ZKhE$default(ArcSplineKt.tween$default(150, 0, null, 6), 0.8f, 4)));
            default:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope.getClass();
                reusableGraphicsLayerScope.setScaleX(1.35f);
                reusableGraphicsLayerScope.setScaleY(1.35f);
                return unit;
        }
    }
}
