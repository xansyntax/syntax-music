package com.metrolist.music.ui.screens;

import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.db.entities.LocalItem;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4 implements Function4 {
    public final /* synthetic */ ArrayList $items;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ComposableLambdaImpl $ytGridItem$inlined;

    public HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(ComposableLambdaImpl composableLambdaImpl, ArrayList arrayList) {
        this.$r8$classId = (byte) 8;
        this.$ytGridItem$inlined = composableLambdaImpl;
        this.$items = arrayList;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ArrayList arrayList = this.$items;
        ComposableLambdaImpl composableLambdaImpl = this.$ytGridItem$inlined;
        switch (b) {
            case 0:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                Composer composer = (Composer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                int i = (iIntValue2 & 6) == 0 ? iIntValue2 | (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2) : iIntValue2;
                if ((iIntValue2 & 48) == 0) {
                    i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    PodcastItem podcastItem = (PodcastItem) arrayList.get(iIntValue);
                    gapComposer.startReplaceGroup(1497689136);
                    composableLambdaImpl.invoke((Object) podcastItem, (Object) gapComposer, (Object) 48);
                    gapComposer.end(false);
                }
                break;
            case 1:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                int i2 = (iIntValue4 & 6) == 0 ? iIntValue4 | (((GapComposer) composer2).changed(lazyItemScopeImpl2) ? 4 : 2) : iIntValue4;
                if ((iIntValue4 & 48) == 0) {
                    i2 |= ((GapComposer) composer2).changed(iIntValue3) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    SongItem songItem = (SongItem) arrayList.get(iIntValue3);
                    gapComposer2.startReplaceGroup(599037630);
                    composableLambdaImpl.invoke((Object) songItem, (Object) gapComposer2, (Object) 48);
                    gapComposer2.end(false);
                }
                break;
            case 2:
                LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj;
                int iIntValue5 = ((Number) obj2).intValue();
                Composer composer3 = (Composer) obj3;
                int iIntValue6 = ((Number) obj4).intValue();
                int i3 = (iIntValue6 & 6) == 0 ? iIntValue6 | (((GapComposer) composer3).changed(lazyItemScopeImpl3) ? 4 : 2) : iIntValue6;
                if ((iIntValue6 & 48) == 0) {
                    i3 |= ((GapComposer) composer3).changed(iIntValue5) ? 32 : 16;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    PodcastItem podcastItem2 = (PodcastItem) arrayList.get(iIntValue5);
                    gapComposer3.startReplaceGroup(-208612888);
                    composableLambdaImpl.invoke((Object) podcastItem2, (Object) gapComposer3, (Object) 48);
                    gapComposer3.end(false);
                }
                break;
            case 3:
                LazyItemScopeImpl lazyItemScopeImpl4 = (LazyItemScopeImpl) obj;
                int iIntValue7 = ((Number) obj2).intValue();
                Composer composer4 = (Composer) obj3;
                int iIntValue8 = ((Number) obj4).intValue();
                int i4 = (iIntValue8 & 6) == 0 ? iIntValue8 | (((GapComposer) composer4).changed(lazyItemScopeImpl4) ? 4 : 2) : iIntValue8;
                if ((iIntValue8 & 48) == 0) {
                    i4 |= ((GapComposer) composer4).changed(iIntValue7) ? 32 : 16;
                }
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    YTItem yTItem = (YTItem) arrayList.get(iIntValue7);
                    gapComposer4.startReplaceGroup(-634991639);
                    composableLambdaImpl.invoke((Object) yTItem, (Object) gapComposer4, (Object) 48);
                    gapComposer4.end(false);
                }
                break;
            case 4:
                LazyItemScopeImpl lazyItemScopeImpl5 = (LazyItemScopeImpl) obj;
                int iIntValue9 = ((Number) obj2).intValue();
                Composer composer5 = (Composer) obj3;
                int iIntValue10 = ((Number) obj4).intValue();
                int i5 = (iIntValue10 & 6) == 0 ? iIntValue10 | (((GapComposer) composer5).changed(lazyItemScopeImpl5) ? 4 : 2) : iIntValue10;
                if ((iIntValue10 & 48) == 0) {
                    i5 |= ((GapComposer) composer5).changed(iIntValue9) ? 32 : 16;
                }
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(i5 & 1, (i5 & 147) != 146)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    PlaylistItem playlistItem = (PlaylistItem) arrayList.get(iIntValue9);
                    gapComposer5.startReplaceGroup(-1163371041);
                    composableLambdaImpl.invoke((Object) playlistItem, (Object) gapComposer5, (Object) 48);
                    gapComposer5.end(false);
                }
                break;
            case 5:
                LazyItemScopeImpl lazyItemScopeImpl6 = (LazyItemScopeImpl) obj;
                int iIntValue11 = ((Number) obj2).intValue();
                Composer composer6 = (Composer) obj3;
                int iIntValue12 = ((Number) obj4).intValue();
                int i6 = (iIntValue12 & 6) == 0 ? iIntValue12 | (((GapComposer) composer6).changed(lazyItemScopeImpl6) ? 4 : 2) : iIntValue12;
                if ((iIntValue12 & 48) == 0) {
                    i6 |= ((GapComposer) composer6).changed(iIntValue11) ? 32 : 16;
                }
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(i6 & 1, (i6 & 147) != 146)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    YTItem yTItem2 = (YTItem) arrayList.get(iIntValue11);
                    gapComposer6.startReplaceGroup(-1283913696);
                    composableLambdaImpl.invoke((Object) yTItem2, (Object) gapComposer6, (Object) 48);
                    gapComposer6.end(false);
                }
                break;
            case 6:
                LazyItemScopeImpl lazyItemScopeImpl7 = (LazyItemScopeImpl) obj;
                int iIntValue13 = ((Number) obj2).intValue();
                Composer composer7 = (Composer) obj3;
                int iIntValue14 = ((Number) obj4).intValue();
                int i7 = (iIntValue14 & 6) == 0 ? iIntValue14 | (((GapComposer) composer7).changed(lazyItemScopeImpl7) ? 4 : 2) : iIntValue14;
                if ((iIntValue14 & 48) == 0) {
                    i7 |= ((GapComposer) composer7).changed(iIntValue13) ? 32 : 16;
                }
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(i7 & 1, (i7 & 147) != 146)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    YTItem yTItem3 = (YTItem) arrayList.get(iIntValue13);
                    gapComposer7.startReplaceGroup(1964467341);
                    composableLambdaImpl.invoke((Object) yTItem3, (Object) gapComposer7, (Object) 48);
                    gapComposer7.end(false);
                }
                break;
            case 7:
                LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj;
                int iIntValue15 = ((Number) obj2).intValue();
                Composer composer8 = (Composer) obj3;
                int iIntValue16 = ((Number) obj4).intValue();
                int i8 = (iIntValue16 & 6) == 0 ? iIntValue16 | (((GapComposer) composer8).changed(lazyGridItemScopeImpl) ? 4 : 2) : iIntValue16;
                if ((iIntValue16 & 48) == 0) {
                    i8 |= ((GapComposer) composer8).changed(iIntValue15) ? 32 : 16;
                }
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(i8 & 1, (i8 & 147) != 146)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    LocalItem localItem = (LocalItem) arrayList.get(iIntValue15);
                    gapComposer8.startReplaceGroup(-477568544);
                    composableLambdaImpl.invoke((Object) localItem, (Object) gapComposer8, (Object) 56);
                    gapComposer8.end(false);
                }
                break;
            default:
                LazyItemScopeImpl lazyItemScopeImpl8 = (LazyItemScopeImpl) obj;
                int iIntValue17 = ((Number) obj2).intValue();
                Composer composer9 = (Composer) obj3;
                int iIntValue18 = ((Number) obj4).intValue();
                int i9 = (iIntValue18 & 6) == 0 ? iIntValue18 | (((GapComposer) composer9).changed(lazyItemScopeImpl8) ? 4 : 2) : iIntValue18;
                if ((iIntValue18 & 48) == 0) {
                    i9 |= ((GapComposer) composer9).changed(iIntValue17) ? 32 : 16;
                }
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(i9 & 1, (i9 & 147) != 146)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    composableLambdaImpl.invoke(lazyItemScopeImpl8, arrayList.get(iIntValue17), gapComposer9, Integer.valueOf(i9 & 14));
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(ArrayList arrayList, ComposableLambdaImpl composableLambdaImpl, byte b) {
        this.$r8$classId = b;
        this.$items = arrayList;
        this.$ytGridItem$inlined = composableLambdaImpl;
    }
}
