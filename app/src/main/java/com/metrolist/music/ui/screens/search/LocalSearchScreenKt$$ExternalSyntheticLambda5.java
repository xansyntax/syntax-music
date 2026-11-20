package com.metrolist.music.ui.screens.search;

import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.Transition$animateTo$lambda$2$0$$inlined$onDispose$1;
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.Stack;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.RecognitionHistory;
import com.metrolist.music.db.entities.SearchHistory;
import com.metrolist.music.ui.screens.library.VisiblePlaylistItem;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LocalSearchScreenKt$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ LocalSearchScreenKt$$ExternalSyntheticLambda5(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                LocalItem localItem = (LocalItem) obj;
                localItem.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("search_local_", localItem.getId());
            case 1:
                ((Artist) obj).getClass();
                return 3;
            case 2:
                Artist artist = (Artist) obj;
                artist.getClass();
                return artist.artist.id;
            case 3:
                LocalItem localItem2 = (LocalItem) obj;
                localItem2.getClass();
                return localItem2.getId();
            case 4:
                ((LocalItem) obj).getClass();
                return 5;
            case 5:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 6:
                LocalItem localItem3 = (LocalItem) obj;
                localItem3.getClass();
                return localItem3.getId();
            case 7:
                ((LocalItem) obj).getClass();
                return 5;
            case 8:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 9:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 10:
                VisiblePlaylistItem visiblePlaylistItem = (VisiblePlaylistItem) obj;
                visiblePlaylistItem.getClass();
                return visiblePlaylistItem.key;
            case 11:
                ((VisiblePlaylistItem) obj).getClass();
                return 5;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 13:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 14:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 15:
                VisiblePlaylistItem visiblePlaylistItem2 = (VisiblePlaylistItem) obj;
                visiblePlaylistItem2.getClass();
                return visiblePlaylistItem2.key;
            case 16:
                ((VisiblePlaylistItem) obj).getClass();
                return 5;
            case 17:
                List list = (List) obj;
                list.getClass();
                return Stack.toMutableStateList(list);
            case 18:
                List list2 = (List) obj;
                list2.getClass();
                return Stack.toMutableStateList(list2);
            case 19:
                List list3 = (List) obj;
                list3.getClass();
                return Stack.toMutableStateList(list3);
            case 20:
                RecognitionHistory recognitionHistory = (RecognitionHistory) obj;
                recognitionHistory.getClass();
                return Format$$ExternalSyntheticOutline0.m(recognitionHistory.id, "recognition_");
            case 21:
                ((MusicDatabase) obj).clearRecognitionHistory();
                return Unit.INSTANCE;
            case 22:
                ((DisposableEffectScope) obj).getClass();
                return new Transition$animateTo$lambda$2$0$$inlined$onDispose$1((byte) 1);
            case 23:
                ((AnimatedContentTransitionScope) obj).getClass();
                return CrossfadeKt.togetherWith(EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3), EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3));
            case 24:
                ((LocalItem) obj).getClass();
                return 1;
            case 25:
                YTItem yTItem = (YTItem) obj;
                yTItem.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("filtered_", yTItem.getId());
            case 26:
                ((YTItem) obj).getClass();
                return "result_item";
            case 27:
                SearchHistory searchHistory = (SearchHistory) obj;
                searchHistory.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("history_", searchHistory.query);
            case 28:
                ((SearchHistory) obj).getClass();
                return "suggestion";
            default:
                String str = (String) obj;
                str.getClass();
                return "suggestion_".concat(str);
        }
    }
}
