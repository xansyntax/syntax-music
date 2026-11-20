package com.metrolist.music.ui.screens;

import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.runtime.Stack;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda13;
import com.yalantis.ucrop.view.CropImageView;
import java.time.LocalDateTime;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StatsScreenKt$$ExternalSyntheticLambda9 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ StatsScreenKt$$ExternalSyntheticLambda9(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                localDateTime.getClass();
                return localDateTime.minusMonths(1L);
            case 1:
                YTItem yTItem = (YTItem) obj;
                yTItem.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("yt_browse_", yTItem.getId());
            case 2:
                ((YTItem) obj).getClass();
                return "grid_item";
            case 3:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 4:
                Album album = (Album) obj;
                album.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("artist_albums_", album.album.id);
            case 5:
                ((Album) obj).getClass();
                return 4;
            case 6:
                List list = (List) obj;
                list.getClass();
                return Stack.toMutableStateList(list);
            case 7:
                YTItem yTItem2 = (YTItem) obj;
                yTItem2.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("artist_items_list_", yTItem2.getId());
            case 8:
                YTItem yTItem3 = (YTItem) obj;
                yTItem3.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("artist_items_grid_", yTItem3.getId());
            case 9:
                YTItem yTItem4 = (YTItem) obj;
                yTItem4.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("youtube_song_", yTItem4.getId());
            case 10:
                ((YTItem) obj).getClass();
                return "youtube_song";
            case 11:
                YTItem yTItem5 = (YTItem) obj;
                yTItem5.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("youtube_album_", yTItem5.getId());
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((YTItem) obj).getClass();
                return "youtube_grid";
            case 13:
                Album album2 = (Album) obj;
                album2.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("local_album_", album2.album.id);
            case 14:
                return Integer.valueOf(((Integer) obj).intValue() * 2);
            case 15:
                return Integer.valueOf(((Integer) obj).intValue() * 2);
            case 16:
                ((AnimatedContentTransitionScope) obj).getClass();
                return CrossfadeKt.togetherWith(EnterExitTransitionKt.slideInHorizontally$default(new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 13), 1).plus(EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3)), EnterExitTransitionKt.slideOutHorizontally$default(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 17), 1).plus(EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3)));
            case 17:
                return Integer.valueOf(-((Integer) obj).intValue());
            case 18:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 19:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 20:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 21:
                Album album3 = (Album) obj;
                album3.getClass();
                return album3.album.id;
            case 22:
                ((Album) obj).getClass();
                return 4;
            case 23:
                Album album4 = (Album) obj;
                album4.getClass();
                return album4.album.id;
            case 24:
                ((Album) obj).getClass();
                return 4;
            case 25:
                ((Artist) obj).getClass();
                return 3;
            case 26:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 27:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 28:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            default:
                Artist artist = (Artist) obj;
                artist.getClass();
                return artist.artist.id;
        }
    }
}
