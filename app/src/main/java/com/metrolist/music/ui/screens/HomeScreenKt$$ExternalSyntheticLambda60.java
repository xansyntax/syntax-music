package com.metrolist.music.ui.screens;

import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.grid.LazyGridIntervalContent;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda60 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ ComposableLambdaImpl f$1;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda60(List list, ComposableLambdaImpl composableLambdaImpl, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ComposableLambdaImpl composableLambdaImpl = this.f$1;
        List list = this.f$0;
        switch (b) {
            case 0:
                LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj;
                lazyGridIntervalContent.getClass();
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if (hashSet.add(((LocalItem) obj2).getId())) {
                        arrayList.add(obj2);
                    }
                }
                lazyGridIntervalContent.items(arrayList.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new QueueKt$$ExternalSyntheticLambda4((byte) 17), arrayList, (byte) 16), null, new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList, (byte) 21), new ComposableLambdaImpl(true, -1117249557, new HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(arrayList, composableLambdaImpl, (byte) 7)));
                break;
            case 1:
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                HashSet hashSet2 = new HashSet();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj3 : list) {
                    if (hashSet2.add(((PodcastItem) obj3).id)) {
                        arrayList2.add(obj3);
                    }
                }
                lazyListIntervalContent.items(arrayList2.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new QueueKt$$ExternalSyntheticLambda4((byte) 24), arrayList2, (byte) 6), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList2, (byte) 13), new ComposableLambdaImpl(true, 802480018, new HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(arrayList2, composableLambdaImpl, (byte) 2)));
                break;
            default:
                LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj;
                lazyListIntervalContent2.getClass();
                HashSet hashSet3 = new HashSet();
                ArrayList arrayList3 = new ArrayList();
                for (Object obj4 : list) {
                    if (hashSet3.add(((PlaylistItem) obj4).id)) {
                        arrayList3.add(obj4);
                    }
                }
                lazyListIntervalContent2.items(arrayList3.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new QueueKt$$ExternalSyntheticLambda4((byte) 25), arrayList3, (byte) 8), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList3, (byte) 15), new ComposableLambdaImpl(true, 802480018, new HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(arrayList3, composableLambdaImpl, (byte) 4)));
                break;
        }
        return unit;
    }
}
