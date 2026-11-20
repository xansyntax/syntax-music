package com.metrolist.music;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda11;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavHostController;
import coil3.util.FileSystemsKt;
import com.metrolist.kugou.KuGouKt$$ExternalSyntheticLambda0;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.ui.component.AppNavigationKt;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda31;
import com.metrolist.music.ui.menu.PlaylistMenuKt$$ExternalSyntheticLambda42;
import com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda2;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.screens.Screens;
import com.metrolist.music.ui.screens.settings.NavigationTab;
import com.metrolist.music.ui.theme.UiStyle;
import com.metrolist.music.ui.utils.AppBarScrollBehavior$nestedScrollConnection$1;
import dev.chrisbanes.haze.HazeSourceElement;
import dev.chrisbanes.haze.HazeState;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda34 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ CoroutineScope f$1;
    public final /* synthetic */ Object f$10;
    public final /* synthetic */ Object f$11;
    public final /* synthetic */ Object f$12;
    public final /* synthetic */ Object f$13;
    public final /* synthetic */ Object f$14;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ boolean f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ State f$8;
    public final /* synthetic */ MutableState f$9;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda34(NavHostController navHostController, CoroutineScope coroutineScope, NavDeepLinkRequest navDeepLinkRequest, BottomSheetState bottomSheetState, boolean z, List list, boolean z2, HazeState hazeState, State state, MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4, NavigationTab navigationTab, NavigationTab navigationTab2, String str, MainActivity mainActivity, SnackbarHostState snackbarHostState) {
        this.f$0 = navHostController;
        this.f$1 = coroutineScope;
        this.f$2 = navDeepLinkRequest;
        this.f$3 = bottomSheetState;
        this.f$4 = z;
        this.f$5 = list;
        this.f$6 = z2;
        this.f$7 = hazeState;
        this.f$8 = state;
        this.f$9 = mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4;
        this.f$10 = navigationTab;
        this.f$11 = navigationTab2;
        this.f$12 = str;
        this.f$13 = mainActivity;
        this.f$14 = snackbarHostState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v36, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v59 */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Screens screens;
        NavHostController navHostController;
        boolean z;
        ?? r4;
        Material3MenuItemData material3MenuItemData;
        boolean z2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj4 = Composer.Companion.Empty;
        Object obj5 = this.f$14;
        Object obj6 = this.f$13;
        Object obj7 = this.f$12;
        Object obj8 = this.f$11;
        Object obj9 = this.f$10;
        MutableState mutableState = this.f$9;
        Object obj10 = this.f$7;
        Object obj11 = this.f$5;
        Object obj12 = this.f$3;
        Object obj13 = this.f$2;
        Object obj14 = this.f$0;
        boolean z3 = this.f$4;
        switch (b) {
            case 0:
                NavHostController navHostController2 = (NavHostController) obj14;
                NavDeepLinkRequest navDeepLinkRequest = (NavDeepLinkRequest) obj13;
                BottomSheetState bottomSheetState = (BottomSheetState) obj12;
                List list = (List) obj11;
                HazeState hazeState = (HazeState) obj10;
                MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4 = (MainActivity$MetrolistApp$$inlined$rememberEnumPreference$4) mutableState;
                NavigationTab navigationTab = (NavigationTab) obj9;
                NavigationTab navigationTab2 = (NavigationTab) obj8;
                String str = (String) obj7;
                MainActivity mainActivity = (MainActivity) obj6;
                SnackbarHostState snackbarHostState = (SnackbarHostState) obj5;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                int i = MainActivity.$r8$clinit;
                ((PaddingValues) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer, 0);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, fillElement);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    boolean z4 = gapComposer.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (z4) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    boolean zChanged = gapComposer.changed(navHostController2);
                    CoroutineScope coroutineScope = this.f$1;
                    boolean zChanged2 = zChanged | gapComposer.changed(coroutineScope) | gapComposer.changed(navDeepLinkRequest) | gapComposer.changed(bottomSheetState);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged2 || objRememberedValue == obj4) {
                        objRememberedValue = new MainActivity$$ExternalSyntheticLambda46(bottomSheetState, navHostController2, coroutineScope, navDeepLinkRequest, (byte) 1);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Function2 function2 = (Function2) objRememberedValue;
                    boolean zChanged3 = gapComposer.changed(navHostController2);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged3 || objRememberedValue2 == obj4) {
                        objRememberedValue2 = new MainActivity$$ExternalSyntheticLambda2(navHostController2, (byte) 6);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    Function0 function0 = (Function0) objRememberedValue2;
                    if (z3) {
                        gapComposer.startReplaceGroup(1885622770);
                        String str2 = (String) this.f$8.getValue();
                        boolean zChangedInstance = gapComposer.changedInstance(navHostController2);
                        Object objRememberedValue3 = gapComposer.rememberedValue();
                        if (zChangedInstance || objRememberedValue3 == obj4) {
                            objRememberedValue3 = new MainActivity$$ExternalSyntheticLambda2(navHostController2, (byte) 7);
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        }
                        AppNavigationKt.AppNavigationRail(list, str2, function2, null, this.f$6, function0, (Function0) objRememberedValue3, gapComposer, 0);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(1886151320);
                        gapComposer.end(false);
                    }
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    UiStyle uiStyle = (UiStyle) mainActivity$MetrolistApp$$inlined$rememberEnumPreference$4.getValue();
                    UiStyle uiStyle2 = UiStyle.GLASS;
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierThen = layoutWeightElement.then(uiStyle == uiStyle2 ? new HazeSourceElement(hazeState) : companion);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    int iOrdinal = (navigationTab == null ? navigationTab2 : navigationTab).ordinal();
                    if (iOrdinal == 0) {
                        screens = Screens.Home.INSTANCE;
                    } else if (iOrdinal == 1) {
                        screens = Screens.Search.INSTANCE;
                    } else {
                        if (iOrdinal != 2) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        screens = Screens.Library.INSTANCE;
                    }
                    String str3 = screens.route;
                    Modifier modifierNestedScroll = NestedScrollModifierKt.nestedScroll(companion, (AppBarScrollBehavior$nestedScrollConnection$1) navDeepLinkRequest.mimeType, null);
                    Object objRememberedValue4 = gapComposer.rememberedValue();
                    if (objRememberedValue4 == obj4) {
                        objRememberedValue4 = new KuGouKt$$ExternalSyntheticLambda0((byte) 17);
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function1 = (Function1) objRememberedValue4;
                    Object objRememberedValue5 = gapComposer.rememberedValue();
                    if (objRememberedValue5 == obj4) {
                        objRememberedValue5 = new KuGouKt$$ExternalSyntheticLambda0((byte) 18);
                        gapComposer.updateRememberedValue(objRememberedValue5);
                    }
                    Function1 function3 = (Function1) objRememberedValue5;
                    Object objRememberedValue6 = gapComposer.rememberedValue();
                    if (objRememberedValue6 == obj4) {
                        objRememberedValue6 = new KuGouKt$$ExternalSyntheticLambda0((byte) 19);
                        gapComposer.updateRememberedValue(objRememberedValue6);
                    }
                    Function1 function4 = (Function1) objRememberedValue6;
                    Object objRememberedValue7 = gapComposer.rememberedValue();
                    if (objRememberedValue7 == obj4) {
                        objRememberedValue7 = new KuGouKt$$ExternalSyntheticLambda0((byte) 20);
                        gapComposer.updateRememberedValue(objRememberedValue7);
                    }
                    Function1 function5 = (Function1) objRememberedValue7;
                    boolean zChangedInstance2 = gapComposer.changedInstance(navHostController2) | gapComposer.changed(navDeepLinkRequest) | gapComposer.changed(str) | gapComposer.changedInstance(mainActivity);
                    Object objRememberedValue8 = gapComposer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue8 == obj4) {
                        MainActivity$$ExternalSyntheticLambda59 mainActivity$$ExternalSyntheticLambda59 = new MainActivity$$ExternalSyntheticLambda59(navHostController2, navDeepLinkRequest, str, mainActivity, snackbarHostState);
                        navHostController = navHostController2;
                        gapComposer.updateRememberedValue(mainActivity$$ExternalSyntheticLambda59);
                        objRememberedValue8 = mainActivity$$ExternalSyntheticLambda59;
                    } else {
                        navHostController = navHostController2;
                    }
                    FileSystemsKt.NavHost(navHostController, str3, modifierNestedScroll, null, function1, function3, function4, function5, (Function1) objRememberedValue8, gapComposer, 115015680);
                    gapComposer.end(true);
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            default:
                Boolean bool = Boolean.FALSE;
                MusicDatabase musicDatabase = (MusicDatabase) obj14;
                Playlist playlist = (Playlist) obj13;
                Function0 function6 = (Function0) obj12;
                DownloadUtil downloadUtil = (DownloadUtil) obj11;
                MutableState mutableState2 = (MutableState) obj10;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) mutableState;
                MutableState mutableState3 = (MutableState) obj9;
                MutableState mutableState4 = (MutableState) obj8;
                MutableState mutableState5 = (MutableState) obj7;
                MutableState mutableState6 = (MutableState) obj6;
                Context context = (Context) obj5;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.startReplaceGroup(672365701);
                    ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                    boolean z5 = this.f$6;
                    if (!z3 || bool.equals(Boolean.TRUE) || z5) {
                        context = context;
                        gapComposer2.startReplaceGroup(497280023);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(496458368);
                        ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.lambda$1917936180;
                        ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.lambda$2139847861;
                        ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.f153lambda$1933207754;
                        Object objRememberedValue9 = gapComposer2.rememberedValue();
                        if (objRememberedValue9 == obj4) {
                            objRememberedValue9 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState2, (byte) 8);
                            gapComposer2.updateRememberedValue(objRememberedValue9);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, composableLambdaImpl3, (Function0) objRememberedValue9, null, null, 48));
                        gapComposer2.end(false);
                    }
                    State state = this.f$8;
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(1714417199, new ListItemKt$$ExternalSyntheticLambda11(state, (byte) 12), gapComposer2);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(-1762654736, new ListItemKt$$ExternalSyntheticLambda11(state, (byte) 13), gapComposer2);
                    CoroutineScope coroutineScope2 = this.f$1;
                    boolean zChangedInstance3 = gapComposer2.changedInstance(coroutineScope2) | gapComposer2.changed(state) | gapComposer2.changedInstance(musicDatabase) | gapComposer2.changed(playlist) | gapComposer2.changed(function6);
                    Object objRememberedValue10 = gapComposer2.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue10 == obj4) {
                        objRememberedValue10 = new SongMenuKt$$ExternalSyntheticLambda40((Object) coroutineScope2, function6, (Object) musicDatabase, (Object) playlist, (Object) state, (byte) 8);
                        gapComposer2.updateRememberedValue(objRememberedValue10);
                    }
                    listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda, composableLambdaImplRememberComposableLambda2, null, (Function0) objRememberedValue10, null, null, 52));
                    Boolean bool2 = Boolean.TRUE;
                    if (bool.equals(bool2)) {
                        gapComposer2.startReplaceGroup(502430487);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(499392766);
                        int intValue = parcelableSnapshotMutableIntState.getIntValue();
                        if (intValue == 0 || intValue == 2) {
                            gapComposer2.startReplaceGroup(500569991);
                            ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.f45lambda$1057231170;
                            ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.lambda$5957439;
                            Object objRememberedValue11 = gapComposer2.rememberedValue();
                            if (objRememberedValue11 == obj4) {
                                objRememberedValue11 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState3, (byte) 10);
                                gapComposer2.updateRememberedValue(objRememberedValue11);
                            }
                            material3MenuItemData = new Material3MenuItemData(composableLambdaImpl4, composableLambdaImpl5, null, (Function0) objRememberedValue11, null, null, 52);
                            z2 = false;
                            gapComposer2.end(false);
                        } else if (intValue != 3) {
                            gapComposer2.startReplaceGroup(501429187);
                            ComposableLambdaImpl composableLambdaImpl6 = AlbumMenuKt.f220lambda$521869218;
                            ComposableLambdaImpl composableLambdaImpl7 = AlbumMenuKt.lambda$1708018015;
                            ComposableLambdaImpl composableLambdaImpl8 = AlbumMenuKt.f192lambda$357062048;
                            boolean zChangedInstance4 = gapComposer2.changedInstance(downloadUtil);
                            Object objRememberedValue12 = gapComposer2.rememberedValue();
                            if (zChangedInstance4 || objRememberedValue12 == obj4) {
                                objRememberedValue12 = new AlbumMenuKt$$ExternalSyntheticLambda31(mutableState4, downloadUtil, (byte) 1);
                                gapComposer2.updateRememberedValue(objRememberedValue12);
                            }
                            material3MenuItemData = new Material3MenuItemData(composableLambdaImpl6, composableLambdaImpl7, composableLambdaImpl8, (Function0) objRememberedValue12, null, null, 48);
                            z2 = false;
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(499479008);
                            ComposableLambdaImpl composableLambdaImpl9 = AlbumMenuKt.f233lambda$569319275;
                            ComposableLambdaImpl composableLambdaImpl10 = AlbumMenuKt.f267lambda$836369066;
                            Object objRememberedValue13 = gapComposer2.rememberedValue();
                            if (objRememberedValue13 == obj4) {
                                objRememberedValue13 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState3, (byte) 9);
                                gapComposer2.updateRememberedValue(objRememberedValue13);
                            }
                            material3MenuItemData = new Material3MenuItemData(composableLambdaImpl9, composableLambdaImpl10, null, (Function0) objRememberedValue13, null, null, 52);
                            z2 = false;
                            gapComposer2.end(false);
                        }
                        listBuilderCreateListBuilder.add(material3MenuItemData);
                        gapComposer2.end(z2);
                    }
                    ComposableLambdaImpl composableLambdaImpl11 = AlbumMenuKt.f145lambda$1853836840;
                    ComposableLambdaImpl composableLambdaImpl12 = AlbumMenuKt.f142lambda$1835410087;
                    Object objRememberedValue14 = gapComposer2.rememberedValue();
                    if (objRememberedValue14 == obj4) {
                        objRememberedValue14 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState5, (byte) 11);
                        gapComposer2.updateRememberedValue(objRememberedValue14);
                    }
                    listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl11, composableLambdaImpl12, null, (Function0) objRememberedValue14, null, null, 52));
                    if (bool.equals(bool2) || z5) {
                        gapComposer2.startReplaceGroup(504009751);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(503172720);
                        ComposableLambdaImpl composableLambdaImpl13 = AlbumMenuKt.lambda$1686506876;
                        ComposableLambdaImpl composableLambdaImpl14 = AlbumMenuKt.lambda$195267517;
                        ComposableLambdaImpl composableLambdaImpl15 = AlbumMenuKt.f76lambda$1295971842;
                        Object objRememberedValue15 = gapComposer2.rememberedValue();
                        if (objRememberedValue15 == obj4) {
                            objRememberedValue15 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState6, (byte) 12);
                            gapComposer2.updateRememberedValue(objRememberedValue15);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl13, composableLambdaImpl14, composableLambdaImpl15, (Function0) objRememberedValue15, null, null, 48));
                        gapComposer2.end(false);
                    }
                    String str4 = playlist.playlist.browseId;
                    String strConcat = str4 != null ? "https://music.youtube.com/playlist?list=".concat(str4) : null;
                    if (strConcat == null) {
                        gapComposer2.startReplaceGroup(504105292);
                        r4 = 0;
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(504105293);
                        ComposableLambdaImpl composableLambdaImpl16 = AlbumMenuKt.f159lambda$1990834203;
                        ComposableLambdaImpl composableLambdaImpl17 = AlbumMenuKt.lambda$2008090308;
                        ComposableLambdaImpl composableLambdaImpl18 = AlbumMenuKt.lambda$1712047523;
                        Context context2 = context;
                        boolean zChanged4 = gapComposer2.changed(strConcat) | gapComposer2.changedInstance(context2) | gapComposer2.changed(function6);
                        Object objRememberedValue16 = gapComposer2.rememberedValue();
                        if (zChanged4 || objRememberedValue16 == obj4) {
                            z = false;
                            objRememberedValue16 = new PlaylistMenuKt$$ExternalSyntheticLambda42(context2, function6, strConcat, (byte) 0);
                            gapComposer2.updateRememberedValue(objRememberedValue16);
                        } else {
                            z = false;
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl16, composableLambdaImpl17, composableLambdaImpl18, (Function0) objRememberedValue16, null, null, 48));
                        gapComposer2.end(z);
                        r4 = z;
                    }
                    ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                    gapComposer2.end(r4);
                    MenuKt.Material3MenuGroup(listBuilderBuild, gapComposer2, r4);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda34(boolean z, boolean z2, CoroutineScope coroutineScope, State state, MusicDatabase musicDatabase, Playlist playlist, Function0 function0, DownloadUtil downloadUtil, MutableState mutableState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, Context context) {
        this.f$4 = z;
        this.f$6 = z2;
        this.f$1 = coroutineScope;
        this.f$8 = state;
        this.f$0 = musicDatabase;
        this.f$2 = playlist;
        this.f$3 = function0;
        this.f$5 = downloadUtil;
        this.f$7 = mutableState;
        this.f$9 = parcelableSnapshotMutableIntState;
        this.f$10 = mutableState2;
        this.f$11 = mutableState3;
        this.f$12 = mutableState4;
        this.f$13 = mutableState5;
        this.f$14 = context;
    }
}
