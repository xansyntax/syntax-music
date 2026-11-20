package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.grid.GridCells$Fixed;
import androidx.compose.foundation.lazy.grid.LazyGridIntervalContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1;
import androidx.navigation.NavHostController;
import coil3.util.LifecyclesKt;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.pages.MoodAndGenres;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3;
import com.metrolist.music.ui.menu.YouTubePlaylistMenuKt$YouTubePlaylistMenu$lambda$35$0$$inlined$items$default$4;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda44 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ NavHostController f$1;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda44(List list, NavHostController navHostController, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = navHostController;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        final NavHostController navHostController = this.f$1;
        final List list = this.f$0;
        Object[] objArr = 0;
        final byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    GridCells$Fixed gridCells$Fixed = new GridCells$Fixed(4);
                    PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(14.0f, 6.0f, 14.0f, 6.0f);
                    Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(Modifier.Companion.$$INSTANCE, 252.0f);
                    boolean zChangedInstance = gapComposer.changedInstance(list) | gapComposer.changedInstance(navHostController);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        final Object[] objArr2 = objArr == true ? 1 : 0;
                        objRememberedValue = new Function1() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda62
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj4) {
                                byte b3 = objArr2;
                                Unit unit2 = Unit.INSTANCE;
                                byte b4 = 2;
                                NavHostController navHostController2 = navHostController;
                                List list2 = list;
                                switch (b3) {
                                    case 0:
                                        LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj4;
                                        lazyGridIntervalContent.getClass();
                                        HashSet hashSet = new HashSet();
                                        ArrayList arrayList = new ArrayList();
                                        for (Object obj5 : list2) {
                                            MoodAndGenres.Item item = (MoodAndGenres.Item) obj5;
                                            String str = item.title;
                                            BrowseEndpoint browseEndpoint = item.endpoint;
                                            if (hashSet.add(str + "_" + browseEndpoint.browseId + "_" + browseEndpoint.params)) {
                                                arrayList.add(obj5);
                                            }
                                        }
                                        lazyGridIntervalContent.items(arrayList.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new QueueKt$$ExternalSyntheticLambda4((byte) 28), arrayList, (byte) 13), null, new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList, (byte) 20), new ComposableLambdaImpl(true, -1117249557, new YouTubePlaylistMenuKt$YouTubePlaylistMenu$lambda$35$0$$inlined$items$default$4(arrayList, navHostController2, b4)));
                                        break;
                                    default:
                                        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj4;
                                        lazyListIntervalContent.getClass();
                                        lazyListIntervalContent.items(list2.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new HomeScreenKt$$ExternalSyntheticLambda97((byte) 13), list2, (byte) 21), new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list2, (byte) 23), new ComposableLambdaImpl(true, 2039820996, new AccountScreenKt$AccountScreen$lambda$9$0$$inlined$itemsIndexed$default$4(list2, navHostController2, b4)));
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    LifecyclesKt.LazyHorizontalGrid(gridCells$Fixed, modifierM145height3ABfNKs, null, paddingValuesImpl, null, null, null, false, null, null, (Function1) objRememberedValue, gapComposer, 3072, 2036);
                }
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    PaddingValuesImpl paddingValuesImplM127PaddingValuesYgX7TsA$default = OffsetKt.m127PaddingValuesYgX7TsA$default(2, 4.0f);
                    boolean zChangedInstance2 = gapComposer2.changedInstance(list) | gapComposer2.changedInstance(navHostController);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new Function1() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda62
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj4) {
                                byte b3 = b2;
                                Unit unit2 = Unit.INSTANCE;
                                byte b4 = 2;
                                NavHostController navHostController2 = navHostController;
                                List list2 = list;
                                switch (b3) {
                                    case 0:
                                        LazyGridIntervalContent lazyGridIntervalContent = (LazyGridIntervalContent) obj4;
                                        lazyGridIntervalContent.getClass();
                                        HashSet hashSet = new HashSet();
                                        ArrayList arrayList = new ArrayList();
                                        for (Object obj5 : list2) {
                                            MoodAndGenres.Item item = (MoodAndGenres.Item) obj5;
                                            String str = item.title;
                                            BrowseEndpoint browseEndpoint = item.endpoint;
                                            if (hashSet.add(str + "_" + browseEndpoint.browseId + "_" + browseEndpoint.params)) {
                                                arrayList.add(obj5);
                                            }
                                        }
                                        lazyGridIntervalContent.items(arrayList.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new QueueKt$$ExternalSyntheticLambda4((byte) 28), arrayList, (byte) 13), null, new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList, (byte) 20), new ComposableLambdaImpl(true, -1117249557, new YouTubePlaylistMenuKt$YouTubePlaylistMenu$lambda$35$0$$inlined$items$default$4(arrayList, navHostController2, b4)));
                                        break;
                                    default:
                                        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj4;
                                        lazyListIntervalContent.getClass();
                                        lazyListIntervalContent.items(list2.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new HomeScreenKt$$ExternalSyntheticLambda97((byte) 13), list2, (byte) 21), new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list2, (byte) 23), new ComposableLambdaImpl(true, 2039820996, new AccountScreenKt$AccountScreen$lambda$9$0$$inlined$itemsIndexed$default$4(list2, navHostController2, b4)));
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    IntMath.LazyRow(Modifier.Companion.$$INSTANCE, null, paddingValuesImplM127PaddingValuesYgX7TsA$default, null, null, null, false, null, (Function1) objRememberedValue2, gapComposer2, 390, 506);
                }
                break;
        }
        return unit;
    }
}
