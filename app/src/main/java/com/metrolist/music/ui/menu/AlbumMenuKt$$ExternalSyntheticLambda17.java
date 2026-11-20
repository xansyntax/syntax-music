package com.metrolist.music.ui.menu;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda11;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.music.constants.SongSortType;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.viewmodels.LibrarySongsViewModel;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumMenuKt$$ExternalSyntheticLambda17 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 4;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ MutableState f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ Object f$8;

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda17(LibrarySongsViewModel librarySongsViewModel, MutableState mutableState, SoftwareKeyboardController softwareKeyboardController, State state, SongSortType songSortType, boolean z, Function1 function1, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, ArrayList arrayList) {
        this.f$1 = librarySongsViewModel;
        this.f$3 = mutableState;
        this.f$2 = softwareKeyboardController;
        this.f$5 = state;
        this.f$8 = songSortType;
        this.f$0 = z;
        this.f$4 = function1;
        this.f$6 = mimesKt$$ExternalSyntheticLambda0;
        this.f$7 = arrayList;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Material3MenuItemData material3MenuItemData;
        Material3MenuItemData material3MenuItemData2;
        GapComposer gapComposer;
        ArrayList arrayList;
        Function0 function0;
        PlayerConnection playerConnection;
        Function0 function1;
        Material3MenuItemData material3MenuItemData3;
        Material3MenuItemData material3MenuItemData4;
        final PlaylistItem playlistItem;
        Material3MenuItemData material3MenuItemData5;
        GapComposer gapComposer2;
        Material3MenuItemData material3MenuItemData6;
        byte b = this.$r8$classId;
        MutableState mutableState = this.f$3;
        boolean z = this.f$0;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Object obj4 = this.f$7;
        Object obj5 = this.f$6;
        Object obj6 = this.f$4;
        Object obj7 = this.f$8;
        Object obj8 = this.f$5;
        Object obj9 = this.f$2;
        Object obj10 = this.f$1;
        switch (b) {
            case 0:
                Function0 function2 = (Function0) obj10;
                PlayerConnection playerConnection2 = (PlayerConnection) obj9;
                CoroutineScope coroutineScope = (CoroutineScope) obj6;
                State state = (State) obj8;
                MusicDatabase musicDatabase = (MusicDatabase) obj5;
                Album album = (Album) obj4;
                MutableState mutableState2 = (MutableState) obj7;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer;
                if (!gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    if (z) {
                        gapComposer3.startReplaceGroup(1672158577);
                        gapComposer3.end(false);
                        material3MenuItemData = null;
                    } else {
                        gapComposer3.startReplaceGroup(1671341603);
                        ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.lambda$2008912225;
                        ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.lambda$6600896;
                        ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.f163lambda$1995710433;
                        boolean zChanged = gapComposer3.changed(function2) | gapComposer3.changedInstance(playerConnection2);
                        Object objRememberedValue = gapComposer3.rememberedValue();
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new AlbumMenuKt$$ExternalSyntheticLambda32(function2, playerConnection2, mutableState2, (byte) 0);
                            gapComposer3.updateRememberedValue(objRememberedValue);
                        }
                        Material3MenuItemData material3MenuItemData7 = new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, composableLambdaImpl3, (Function0) objRememberedValue, null, null, 48);
                        gapComposer3.end(false);
                        material3MenuItemData = material3MenuItemData7;
                    }
                    if (z) {
                        gapComposer3.startReplaceGroup(1673104945);
                        gapComposer3.end(false);
                        material3MenuItemData2 = null;
                    } else {
                        gapComposer3.startReplaceGroup(1672282205);
                        ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.f278lambda$940300864;
                        ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.lambda$1352355103;
                        ComposableLambdaImpl composableLambdaImpl6 = AlbumMenuKt.f243lambda$649956226;
                        boolean zChanged2 = gapComposer3.changed(function2) | gapComposer3.changedInstance(playerConnection2);
                        Object objRememberedValue2 = gapComposer3.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new AlbumMenuKt$$ExternalSyntheticLambda32(function2, playerConnection2, mutableState2, (byte) 1);
                            gapComposer3.updateRememberedValue(objRememberedValue2);
                        }
                        Material3MenuItemData material3MenuItemData8 = new Material3MenuItemData(composableLambdaImpl4, composableLambdaImpl5, composableLambdaImpl6, (Function0) objRememberedValue2, null, null, 48);
                        gapComposer3.end(false);
                        material3MenuItemData2 = material3MenuItemData8;
                    }
                    ComposableLambdaImpl composableLambdaImpl7 = AlbumMenuKt.lambda$260703130;
                    ComposableLambdaImpl composableLambdaImpl8 = AlbumMenuKt.f262lambda$82180679;
                    ComposableLambdaImpl composableLambdaImpl9 = AlbumMenuKt.f205lambda$425064488;
                    boolean zChanged3 = gapComposer3.changed(mutableState);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState, (byte) 15);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    Material3MenuItemData material3MenuItemData9 = new Material3MenuItemData(composableLambdaImpl7, composableLambdaImpl8, composableLambdaImpl9, (Function0) objRememberedValue3, null, null, 48);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1606457337, new ListItemKt$$ExternalSyntheticLambda11(state, (byte) 3), gapComposer3);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(1263573528, new ListItemKt$$ExternalSyntheticLambda11(state, (byte) 4), gapComposer3);
                    boolean zChangedInstance = gapComposer3.changedInstance(coroutineScope) | gapComposer3.changed(state) | gapComposer3.changedInstance(musicDatabase) | gapComposer3.changed(album) | gapComposer3.changed(function2);
                    Object objRememberedValue4 = gapComposer3.rememberedValue();
                    if (zChangedInstance || objRememberedValue4 == neverEqualPolicy) {
                        SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda40 = new SongMenuKt$$ExternalSyntheticLambda40((Object) coroutineScope, function2, (Object) musicDatabase, (Object) album, (Object) state, (byte) 4);
                        gapComposer3.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda40);
                        objRememberedValue4 = songMenuKt$$ExternalSyntheticLambda40;
                    }
                    MenuKt.Material3MenuGroup(ArraysKt.filterNotNull(new Material3MenuItemData[]{material3MenuItemData, material3MenuItemData2, material3MenuItemData9, new Material3MenuItemData(composableLambdaImplRememberComposableLambda, composableLambdaImplRememberComposableLambda2, null, (Function0) objRememberedValue4, null, null, 52)}), gapComposer3, 0);
                }
                break;
            case 1:
                Function0 function3 = (Function0) obj10;
                PlayerConnection playerConnection3 = (PlayerConnection) obj9;
                ArrayList arrayList2 = (ArrayList) obj8;
                Function0 function4 = (Function0) obj4;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj5;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj6;
                MutableState mutableState3 = (MutableState) obj7;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer2;
                if (!gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    gapComposer4.startReplaceGroup(167959190);
                    ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                    if (z) {
                        gapComposer = gapComposer4;
                        mutableState3 = mutableState3;
                        arrayList = arrayList2;
                        gapComposer.startReplaceGroup(79119052);
                        gapComposer.end(false);
                    } else {
                        gapComposer4.startReplaceGroup(75946791);
                        ComposableLambdaImpl composableLambdaImpl10 = AlbumMenuKt.lambda$1413914079;
                        ComposableLambdaImpl composableLambdaImpl11 = AlbumMenuKt.f98lambda$1443000352;
                        ComposableLambdaImpl composableLambdaImpl12 = AlbumMenuKt.f215lambda$4947487;
                        boolean zChanged4 = gapComposer4.changed(function3) | gapComposer4.changedInstance(playerConnection3) | gapComposer4.changedInstance(arrayList2) | gapComposer4.changed(function4);
                        Object objRememberedValue5 = gapComposer4.rememberedValue();
                        if (zChanged4 || objRememberedValue5 == neverEqualPolicy) {
                            arrayList = arrayList2;
                            function0 = function4;
                            playerConnection = playerConnection3;
                            function1 = function3;
                            gapComposer = gapComposer4;
                            SelectionSongsMenuKt$$ExternalSyntheticLambda40 selectionSongsMenuKt$$ExternalSyntheticLambda40 = new SelectionSongsMenuKt$$ExternalSyntheticLambda40(function1, playerConnection, arrayList, function0, (byte) 0);
                            gapComposer.updateRememberedValue(selectionSongsMenuKt$$ExternalSyntheticLambda40);
                            objRememberedValue5 = selectionSongsMenuKt$$ExternalSyntheticLambda40;
                        } else {
                            function1 = function3;
                            gapComposer = gapComposer4;
                            arrayList = arrayList2;
                            playerConnection = playerConnection3;
                            function0 = function4;
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl10, composableLambdaImpl11, composableLambdaImpl12, (Function0) objRememberedValue5, null, null, 48));
                        ComposableLambdaImpl composableLambdaImpl13 = AlbumMenuKt.f202lambda$413186616;
                        ComposableLambdaImpl composableLambdaImpl14 = AlbumMenuKt.f94lambda$1423852663;
                        ComposableLambdaImpl composableLambdaImpl15 = AlbumMenuKt.lambda$1860448586;
                        boolean zChanged5 = gapComposer.changed(function1) | gapComposer.changedInstance(playerConnection) | gapComposer.changedInstance(arrayList) | gapComposer.changed(function0);
                        Object objRememberedValue6 = gapComposer.rememberedValue();
                        if (zChanged5 || objRememberedValue6 == neverEqualPolicy) {
                            objRememberedValue6 = new SelectionSongsMenuKt$$ExternalSyntheticLambda40(function1, playerConnection, arrayList, function0, (byte) 1);
                            gapComposer.updateRememberedValue(objRememberedValue6);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl13, composableLambdaImpl14, composableLambdaImpl15, (Function0) objRememberedValue6, null, null, 48));
                        ComposableLambdaImpl composableLambdaImpl16 = AlbumMenuKt.f204lambda$420566937;
                        ComposableLambdaImpl composableLambdaImpl17 = AlbumMenuKt.f96lambda$1431232984;
                        ComposableLambdaImpl composableLambdaImpl18 = AlbumMenuKt.lambda$1853068265;
                        boolean zChanged6 = gapComposer.changed(function1) | gapComposer.changedInstance(playerConnection) | gapComposer.changedInstance(arrayList) | gapComposer.changed(function0);
                        Object objRememberedValue7 = gapComposer.rememberedValue();
                        if (zChanged6 || objRememberedValue7 == neverEqualPolicy) {
                            objRememberedValue7 = new SelectionSongsMenuKt$$ExternalSyntheticLambda40(function1, playerConnection, arrayList, function0, (byte) 2);
                            gapComposer.updateRememberedValue(objRememberedValue7);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl16, composableLambdaImpl17, composableLambdaImpl18, (Function0) objRememberedValue7, null, null, 48));
                        gapComposer.end(false);
                    }
                    ComposableLambdaImpl composableLambdaImpl19 = AlbumMenuKt.f234lambda$575097766;
                    ComposableLambdaImpl composableLambdaImpl20 = AlbumMenuKt.f209lambda$46857317;
                    ComposableLambdaImpl composableLambdaImpl21 = AlbumMenuKt.lambda$481383132;
                    boolean zChanged7 = gapComposer.changed(mutableState);
                    Object objRememberedValue8 = gapComposer.rememberedValue();
                    if (zChanged7 || objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState, (byte) 26);
                        gapComposer.updateRememberedValue(objRememberedValue8);
                    }
                    listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl19, composableLambdaImpl20, composableLambdaImpl21, (Function0) objRememberedValue8, null, null, 48));
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Expect_jvmKt.rememberComposableLambda(-1505920125, new SongMenuKt$$ExternalSyntheticLambda37(mutableState3, (byte) 19), gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda4 = Expect_jvmKt.rememberComposableLambda(-672989564, new SongMenuKt$$ExternalSyntheticLambda37(mutableState3, (byte) 20), gapComposer);
                    boolean zChangedInstance2 = gapComposer.changedInstance(musicDatabase2) | gapComposer.changedInstance(arrayList) | gapComposer.changedInstance(coroutineScope2);
                    Object objRememberedValue9 = gapComposer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new SongMenuKt$$ExternalSyntheticLambda63(musicDatabase2, coroutineScope2, mutableState3, arrayList);
                        gapComposer.updateRememberedValue(objRememberedValue9);
                    }
                    listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda3, composableLambdaImplRememberComposableLambda4, null, (Function0) objRememberedValue9, null, null, 52));
                    ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                    gapComposer.end(false);
                    MenuKt.Material3MenuGroup(listBuilderBuild, gapComposer, 0);
                }
                break;
            case 2:
                PlayerConnection playerConnection4 = (PlayerConnection) obj9;
                Function0 function5 = (Function0) obj10;
                MutableState mutableState4 = (MutableState) obj7;
                CoroutineScope coroutineScope3 = (CoroutineScope) obj6;
                State state2 = (State) obj8;
                MusicDatabase musicDatabase3 = (MusicDatabase) obj5;
                AlbumItem albumItem = (AlbumItem) obj4;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer3;
                if (!gapComposer5.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    if (z) {
                        gapComposer5.startReplaceGroup(-880405262);
                        gapComposer5.end(false);
                        material3MenuItemData3 = null;
                    } else {
                        gapComposer5.startReplaceGroup(-881353893);
                        ComposableLambdaImpl composableLambdaImpl22 = AlbumMenuKt.f143lambda$184095392;
                        ComposableLambdaImpl composableLambdaImpl23 = AlbumMenuKt.f162lambda$1995662593;
                        ComposableLambdaImpl composableLambdaImpl24 = AlbumMenuKt.lambda$487737502;
                        boolean zChanged8 = gapComposer5.changed(mutableState) | gapComposer5.changedInstance(playerConnection4) | gapComposer5.changed(function5);
                        Object objRememberedValue10 = gapComposer5.rememberedValue();
                        if (zChanged8 || objRememberedValue10 == neverEqualPolicy) {
                            objRememberedValue10 = new AlbumMenuKt$$ExternalSyntheticLambda32(playerConnection4, function5, mutableState, (byte) 3);
                            gapComposer5.updateRememberedValue(objRememberedValue10);
                        }
                        Material3MenuItemData material3MenuItemData10 = new Material3MenuItemData(composableLambdaImpl22, composableLambdaImpl23, composableLambdaImpl24, (Function0) objRememberedValue10, null, null, 48);
                        gapComposer5.end(false);
                        material3MenuItemData3 = material3MenuItemData10;
                    }
                    if (z) {
                        gapComposer5.startReplaceGroup(-879322990);
                        gapComposer5.end(false);
                        material3MenuItemData4 = null;
                    } else {
                        gapComposer5.startReplaceGroup(-880277387);
                        ComposableLambdaImpl composableLambdaImpl25 = AlbumMenuKt.f70lambda$1233467393;
                        ComposableLambdaImpl composableLambdaImpl26 = AlbumMenuKt.lambda$1249932702;
                        ComposableLambdaImpl composableLambdaImpl27 = AlbumMenuKt.f230lambda$561634499;
                        boolean zChanged9 = gapComposer5.changed(mutableState) | gapComposer5.changedInstance(playerConnection4) | gapComposer5.changed(function5);
                        Object objRememberedValue11 = gapComposer5.rememberedValue();
                        if (zChanged9 || objRememberedValue11 == neverEqualPolicy) {
                            objRememberedValue11 = new AlbumMenuKt$$ExternalSyntheticLambda32(playerConnection4, function5, mutableState, (byte) 4);
                            gapComposer5.updateRememberedValue(objRememberedValue11);
                        }
                        Material3MenuItemData material3MenuItemData11 = new Material3MenuItemData(composableLambdaImpl25, composableLambdaImpl26, composableLambdaImpl27, (Function0) objRememberedValue11, null, null, 48);
                        gapComposer5.end(false);
                        material3MenuItemData4 = material3MenuItemData11;
                    }
                    ComposableLambdaImpl composableLambdaImpl28 = AlbumMenuKt.lambda$1548395353;
                    ComposableLambdaImpl composableLambdaImpl29 = AlbumMenuKt.f48lambda$1069548616;
                    ComposableLambdaImpl composableLambdaImpl30 = AlbumMenuKt.lambda$607474711;
                    boolean zChanged10 = gapComposer5.changed(mutableState4);
                    Object objRememberedValue12 = gapComposer5.rememberedValue();
                    if (zChanged10 || objRememberedValue12 == neverEqualPolicy) {
                        objRememberedValue12 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState4, (byte) 7);
                        gapComposer5.updateRememberedValue(objRememberedValue12);
                    }
                    Material3MenuItemData material3MenuItemData12 = new Material3MenuItemData(composableLambdaImpl28, composableLambdaImpl29, composableLambdaImpl30, (Function0) objRememberedValue12, null, null, 48);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda5 = Expect_jvmKt.rememberComposableLambda(499023352, new ListItemKt$$ExternalSyntheticLambda11(state2, (byte) 18), gapComposer5);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda6 = Expect_jvmKt.rememberComposableLambda(-2118920617, new ListItemKt$$ExternalSyntheticLambda11(state2, (byte) 19), gapComposer5);
                    boolean zChangedInstance3 = gapComposer5.changedInstance(coroutineScope3) | gapComposer5.changed(state2) | gapComposer5.changedInstance(musicDatabase3) | gapComposer5.changedInstance(albumItem) | gapComposer5.changed(function5);
                    Object objRememberedValue13 = gapComposer5.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue13 == neverEqualPolicy) {
                        objRememberedValue13 = new SongMenuKt$$ExternalSyntheticLambda40((Object) coroutineScope3, function5, (Object) musicDatabase3, (Object) albumItem, (Object) state2, (byte) 11);
                        gapComposer5.updateRememberedValue(objRememberedValue13);
                    }
                    MenuKt.Material3MenuGroup(ArraysKt.filterNotNull(new Material3MenuItemData[]{material3MenuItemData3, material3MenuItemData4, material3MenuItemData12, new Material3MenuItemData(composableLambdaImplRememberComposableLambda5, composableLambdaImplRememberComposableLambda6, null, (Function0) objRememberedValue13, null, null, 52)}), gapComposer5, 0);
                }
                break;
            case 3:
                final List list = (List) obj7;
                final CoroutineScope coroutineScope4 = (CoroutineScope) obj6;
                final PlaylistItem playlistItem2 = (PlaylistItem) obj4;
                final PlayerConnection playerConnection5 = (PlayerConnection) obj9;
                final Function0 function6 = (Function0) obj10;
                State state3 = (State) obj8;
                MusicDatabase musicDatabase4 = (MusicDatabase) obj5;
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer4;
                if (!gapComposer6.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    if (z) {
                        playlistItem = playlistItem2;
                        gapComposer6.startReplaceGroup(1032891525);
                        gapComposer6.end(false);
                        material3MenuItemData5 = null;
                    } else {
                        gapComposer6.startReplaceGroup(1030887716);
                        ComposableLambdaImpl composableLambdaImpl31 = AlbumMenuKt.f206lambda$436320811;
                        ComposableLambdaImpl composableLambdaImpl32 = AlbumMenuKt.f260lambda$812154282;
                        ComposableLambdaImpl composableLambdaImpl33 = AlbumMenuKt.f64lambda$1187987753;
                        boolean zChangedInstance4 = gapComposer6.changedInstance(coroutineScope4) | gapComposer6.changedInstance(list) | gapComposer6.changedInstance(playlistItem2) | gapComposer6.changedInstance(playerConnection5) | gapComposer6.changed(function6);
                        Object objRememberedValue14 = gapComposer6.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue14 == neverEqualPolicy) {
                            final byte b2 = 0;
                            objRememberedValue14 = new Function0() { // from class: com.metrolist.music.ui.menu.YouTubePlaylistMenuKt$$ExternalSyntheticLambda26
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b3 = b2;
                                    Unit unit2 = Unit.INSTANCE;
                                    Function0 function7 = function6;
                                    CoroutineScope coroutineScope5 = coroutineScope4;
                                    switch (b3) {
                                        case 0:
                                            AwaitKt.launch$default(coroutineScope5, null, null, new YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1(list, playlistItem2, playerConnection5, null, (byte) 0), 3);
                                            function7.invoke();
                                            break;
                                        default:
                                            AwaitKt.launch$default(coroutineScope5, null, null, new YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1(list, playlistItem2, playerConnection5, null, (byte) 1), 3);
                                            function7.invoke();
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            playlistItem = playlistItem2;
                            gapComposer6.updateRememberedValue(objRememberedValue14);
                        } else {
                            playlistItem = playlistItem2;
                        }
                        Material3MenuItemData material3MenuItemData13 = new Material3MenuItemData(composableLambdaImpl31, composableLambdaImpl32, composableLambdaImpl33, (Function0) objRememberedValue14, null, null, 48);
                        gapComposer6.end(false);
                        material3MenuItemData5 = material3MenuItemData13;
                    }
                    if (z) {
                        gapComposer2 = gapComposer6;
                        gapComposer2.startReplaceGroup(1034685061);
                        gapComposer2.end(false);
                        material3MenuItemData6 = null;
                    } else {
                        gapComposer6.startReplaceGroup(1033041627);
                        ComposableLambdaImpl composableLambdaImpl34 = AlbumMenuKt.lambda$786281814;
                        ComposableLambdaImpl composableLambdaImpl35 = AlbumMenuKt.lambda$410448343;
                        ComposableLambdaImpl composableLambdaImpl36 = AlbumMenuKt.lambda$34614872;
                        boolean zChangedInstance5 = gapComposer6.changedInstance(coroutineScope4) | gapComposer6.changedInstance(list) | gapComposer6.changedInstance(playlistItem) | gapComposer6.changedInstance(playerConnection5) | gapComposer6.changed(function6);
                        Object objRememberedValue15 = gapComposer6.rememberedValue();
                        if (zChangedInstance5 || objRememberedValue15 == neverEqualPolicy) {
                            final byte b3 = 1;
                            gapComposer2 = gapComposer6;
                            Function0 function7 = new Function0() { // from class: com.metrolist.music.ui.menu.YouTubePlaylistMenuKt$$ExternalSyntheticLambda26
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b4 = b3;
                                    Unit unit2 = Unit.INSTANCE;
                                    Function0 function8 = function6;
                                    CoroutineScope coroutineScope5 = coroutineScope4;
                                    switch (b4) {
                                        case 0:
                                            AwaitKt.launch$default(coroutineScope5, null, null, new YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1(list, playlistItem, playerConnection5, null, (byte) 0), 3);
                                            function8.invoke();
                                            break;
                                        default:
                                            AwaitKt.launch$default(coroutineScope5, null, null, new YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$1$1$1(list, playlistItem, playerConnection5, null, (byte) 1), 3);
                                            function8.invoke();
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            coroutineScope4 = coroutineScope4;
                            gapComposer2.updateRememberedValue(function7);
                            objRememberedValue15 = function7;
                        } else {
                            gapComposer2 = gapComposer6;
                        }
                        Material3MenuItemData material3MenuItemData14 = new Material3MenuItemData(composableLambdaImpl34, composableLambdaImpl35, composableLambdaImpl36, (Function0) objRememberedValue15, null, null, 48);
                        gapComposer2.end(false);
                        material3MenuItemData6 = material3MenuItemData14;
                    }
                    ComposableLambdaImpl composableLambdaImpl37 = AlbumMenuKt.lambda$1994744508;
                    ComposableLambdaImpl composableLambdaImpl38 = AlbumMenuKt.f66lambda$1205396355;
                    ComposableLambdaImpl composableLambdaImpl39 = AlbumMenuKt.f53lambda$110569922;
                    boolean zChanged11 = gapComposer2.changed(mutableState);
                    Object objRememberedValue16 = gapComposer2.rememberedValue();
                    if (zChanged11 || objRememberedValue16 == neverEqualPolicy) {
                        objRememberedValue16 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState, (byte) 14);
                        gapComposer2.updateRememberedValue(objRememberedValue16);
                    }
                    Material3MenuItemData material3MenuItemData15 = new Material3MenuItemData(composableLambdaImpl37, composableLambdaImpl38, composableLambdaImpl39, (Function0) objRememberedValue16, null, null, 48);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda7 = Expect_jvmKt.rememberComposableLambda(-1077620163, new ListItemKt$$ExternalSyntheticLambda11(state3, (byte) 24), gapComposer2);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda8 = Expect_jvmKt.rememberComposableLambda(17206270, new ListItemKt$$ExternalSyntheticLambda11(state3, (byte) 25), gapComposer2);
                    boolean zChangedInstance6 = gapComposer2.changedInstance(coroutineScope4) | gapComposer2.changed(state3) | gapComposer2.changedInstance(musicDatabase4) | gapComposer2.changedInstance(playlistItem) | gapComposer2.changed(function6);
                    Object objRememberedValue17 = gapComposer2.rememberedValue();
                    if (zChangedInstance6 || objRememberedValue17 == neverEqualPolicy) {
                        objRememberedValue17 = new SongMenuKt$$ExternalSyntheticLambda40((Object) coroutineScope4, function6, (Object) musicDatabase4, (Object) playlistItem, (Object) state3, (byte) 12);
                        gapComposer2.updateRememberedValue(objRememberedValue17);
                    }
                    MenuKt.Material3MenuGroup(ArraysKt.filterNotNull(new Material3MenuItemData[]{material3MenuItemData5, material3MenuItemData6, material3MenuItemData15, new Material3MenuItemData(composableLambdaImplRememberComposableLambda7, composableLambdaImplRememberComposableLambda8, null, (Function0) objRememberedValue17, null, null, 52)}), gapComposer2, 0);
                }
                break;
            default:
                LibrarySongsViewModel librarySongsViewModel = (LibrarySongsViewModel) obj10;
                SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) obj9;
                State state4 = (State) obj8;
                SongSortType songSortType = (SongSortType) obj7;
                Function1 function8 = (Function1) obj6;
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) obj5;
                ArrayList arrayList3 = (ArrayList) obj4;
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer5;
                if (!gapComposer7.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    MutableState mutableState5 = this.f$3;
                    boolean zBooleanValue = ((Boolean) mutableState5.getValue()).booleanValue();
                    String str = (String) state4.getValue();
                    boolean zChangedInstance7 = gapComposer7.changedInstance(librarySongsViewModel);
                    Object objRememberedValue18 = gapComposer7.rememberedValue();
                    if (zChangedInstance7 || objRememberedValue18 == neverEqualPolicy) {
                        objRememberedValue18 = new JobKt__JobKt$invokeOnCompletion$1(1, librarySongsViewModel, LibrarySongsViewModel.class, "updateSearchQuery", "updateSearchQuery(Ljava/lang/String;)V", 0, (byte) 3);
                        gapComposer7.updateRememberedValue(objRememberedValue18);
                    }
                    Function1 function9 = (Function1) ((KFunction) objRememberedValue18);
                    boolean zChanged12 = gapComposer7.changed(mutableState5) | gapComposer7.changedInstance(librarySongsViewModel);
                    Object objRememberedValue19 = gapComposer7.rememberedValue();
                    if (zChanged12 || objRememberedValue19 == neverEqualPolicy) {
                        objRememberedValue19 = new QueueKt$$ExternalSyntheticLambda16(librarySongsViewModel, mutableState5, (byte) 16);
                        gapComposer7.updateRememberedValue(objRememberedValue19);
                    }
                    MenuKt.LibrarySearchHeader(zBooleanValue, str, function9, (Function0) objRememberedValue19, softwareKeyboardController, OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14), Expect_jvmKt.rememberComposableLambda(-725544272, new AlbumMenuKt$$ExternalSyntheticLambda16(songSortType, this.f$0, function8, mimesKt$$ExternalSyntheticLambda0, arrayList3, mutableState5), gapComposer7), gapComposer7, 1769472);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda17(boolean z, MutableState mutableState, PlayerConnection playerConnection, Function0 function0, MutableState mutableState2, CoroutineScope coroutineScope, State state, MusicDatabase musicDatabase, AlbumItem albumItem) {
        this.f$0 = z;
        this.f$3 = mutableState;
        this.f$2 = playerConnection;
        this.f$1 = function0;
        this.f$8 = mutableState2;
        this.f$4 = coroutineScope;
        this.f$5 = state;
        this.f$6 = musicDatabase;
        this.f$7 = albumItem;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda17(boolean z, List list, CoroutineScope coroutineScope, PlaylistItem playlistItem, PlayerConnection playerConnection, Function0 function0, MutableState mutableState, State state, MusicDatabase musicDatabase) {
        this.f$0 = z;
        this.f$8 = list;
        this.f$4 = coroutineScope;
        this.f$7 = playlistItem;
        this.f$2 = playerConnection;
        this.f$1 = function0;
        this.f$3 = mutableState;
        this.f$5 = state;
        this.f$6 = musicDatabase;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda17(boolean z, Function0 function0, PlayerConnection playerConnection, MutableState mutableState, CoroutineScope coroutineScope, State state, MusicDatabase musicDatabase, Album album, MutableState mutableState2) {
        this.f$0 = z;
        this.f$1 = function0;
        this.f$2 = playerConnection;
        this.f$3 = mutableState;
        this.f$4 = coroutineScope;
        this.f$5 = state;
        this.f$6 = musicDatabase;
        this.f$7 = album;
        this.f$8 = mutableState2;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda17(boolean z, Function0 function0, PlayerConnection playerConnection, ArrayList arrayList, Function0 function1, MutableState mutableState, MusicDatabase musicDatabase, CoroutineScope coroutineScope, MutableState mutableState2) {
        this.f$0 = z;
        this.f$1 = function0;
        this.f$2 = playerConnection;
        this.f$5 = arrayList;
        this.f$7 = function1;
        this.f$3 = mutableState;
        this.f$6 = musicDatabase;
        this.f$4 = coroutineScope;
        this.f$8 = mutableState2;
    }
}
