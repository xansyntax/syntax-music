package androidx.navigation.compose;

import androidx.collection.MutableObjectFloatMap;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.SizeTransformImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import androidx.compose.runtime.Latch$await$2$2;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.ChartsPage;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.models.ItemsPage;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.ItemsKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.LyricsMenuKt$LyricsMenu$lambda$39$0$$inlined$itemsIndexed$default$3;
import com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda12;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3;
import com.metrolist.music.ui.menu.YouTubeSongMenuKt$YouTubeSongMenu$lambda$16$0$$inlined$items$default$4;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda21;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda97;
import com.metrolist.music.ui.screens.NewReleaseScreenKt$NewReleaseScreen$lambda$6$0$$inlined$items$default$4;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.screens.StatsScreenKt$StatsScreen$6$1$1$10$2$1$1;
import com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1;
import com.metrolist.music.viewmodels.LyricsMenuViewModel;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NavHostKt$$ExternalSyntheticLambda12 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ State f$5;
    public final /* synthetic */ Object f$6;

    public /* synthetic */ NavHostKt$$ExternalSyntheticLambda12(List list, ComposableLambdaImpl composableLambdaImpl, ComposableLambdaImpl composableLambdaImpl2, MutableState mutableState, MenuState menuState, MutableState mutableState2, MutableState mutableState3) {
        this.$r8$classId = (byte) 8;
        this.f$0 = list;
        this.f$1 = composableLambdaImpl;
        this.f$2 = composableLambdaImpl2;
        this.f$6 = mutableState;
        this.f$3 = menuState;
        this.f$5 = mutableState2;
        this.f$4 = mutableState3;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x02e3  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        float f;
        Object obj2;
        ChartsPage.ChartSection chartSection;
        byte b = this.$r8$classId;
        byte b2 = 8;
        State state = this.f$5;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$4;
        Object obj4 = this.f$3;
        Object obj5 = this.f$6;
        Object obj6 = this.f$2;
        Object obj7 = this.f$1;
        Object obj8 = this.f$0;
        switch (b) {
            case 0:
                MutableObjectFloatMap mutableObjectFloatMap = (MutableObjectFloatMap) obj8;
                ComposeNavigator composeNavigator = (ComposeNavigator) obj7;
                Function1 function1 = (Function1) obj6;
                Function1 function2 = (Function1) obj4;
                Function1 function3 = (Function1) obj3;
                MutableState mutableState = (MutableState) obj5;
                AnimatedContentTransitionScope animatedContentTransitionScope = (AnimatedContentTransitionScope) obj;
                if (!((List) state.getValue()).contains(animatedContentTransitionScope.getInitialState())) {
                    return CrossfadeKt.togetherWith(EnterTransitionImpl.None, ExitTransitionImpl.None);
                }
                String str = ((NavBackStackEntry) animatedContentTransitionScope.getInitialState()).id;
                int iFindKeyIndex = mutableObjectFloatMap.findKeyIndex(str);
                if (iFindKeyIndex >= 0) {
                    f = mutableObjectFloatMap.values[iFindKeyIndex];
                } else {
                    mutableObjectFloatMap.set(str, CropImageView.DEFAULT_ASPECT_RATIO);
                    f = 0.0f;
                }
                if (!((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).id.equals(((NavBackStackEntry) animatedContentTransitionScope.getInitialState()).id)) {
                    f = (((Boolean) composeNavigator.isPop.getValue()).booleanValue() || ((Boolean) mutableState.getValue()).booleanValue()) ? f - 1.0f : f + 1.0f;
                }
                mutableObjectFloatMap.set(((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).id, f);
                return new ContentTransform((EnterTransitionImpl) function1.invoke(animatedContentTransitionScope), (ExitTransitionImpl) function2.invoke(animatedContentTransitionScope), f, (SizeTransformImpl) function3.invoke(animatedContentTransitionScope));
            case 1:
                State state2 = (State) obj5;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                List list = (List) state.getValue();
                lazyListIntervalContent.items(list.size(), null, new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list, (byte) 7), new ComposableLambdaImpl(true, 2039820996, new LyricsMenuKt$LyricsMenu$lambda$39$0$$inlined$itemsIndexed$default$3(list, (LyricsMenuViewModel) obj8, (Function0) obj7, (MusicDatabase) obj6, (MediaMetadata) obj4, (ParcelableSnapshotMutableIntState) obj3, (byte) 0)));
                if (((Boolean) state2.getValue()).booleanValue()) {
                    LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1549568103, 3);
                }
                if (!((Boolean) state2.getValue()).booleanValue() && ((List) state.getValue()).isEmpty()) {
                    LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1373841040, 3);
                }
                return unit;
            case 2:
                final HapticFeedback hapticFeedback = (HapticFeedback) obj8;
                final MenuState menuState = (MenuState) obj7;
                final NavHostController navHostController = (NavHostController) obj6;
                final CoroutineScope coroutineScope = (CoroutineScope) obj4;
                final State state3 = (State) obj3;
                final State state4 = (State) obj5;
                LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj;
                lazyListIntervalContent2.getClass();
                List list2 = (List) state.getValue();
                HashSet hashSet = new HashSet();
                final ArrayList arrayList = new ArrayList();
                for (Object obj9 : list2) {
                    if (hashSet.add(((AlbumItem) obj9).id)) {
                        arrayList.add(obj9);
                    }
                }
                final byte b3 = 0;
                lazyListIntervalContent2.items(arrayList.size(), new Latch$await$2$2(new QueueKt$$ExternalSyntheticLambda4((byte) 11), arrayList, (byte) 25), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList, (byte) 8), new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.screens.AlbumScreenKt$AlbumScreen$lambda$22$0$4$0$0$$inlined$items$default$4
                    /* JADX WARN: Failed to calculate best type for var: r13v2 ??
                    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v2 ??, new type: androidx.compose.runtime.GapComposer
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
                    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
                    	... 7 more
                     */
                    /* JADX WARN: Failed to calculate best type for var: r9v1 ??
                    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v1 ??, new type: boolean
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
                    	... 6 more
                     */
                    /* JADX WARN: Failed to calculate best type for var: r9v1 ??
                    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v1 ??, new type: boolean
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
                    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
                    	... 7 more
                     */
                    /* JADX WARN: Failed to calculate best type for var: r9v2 ??
                    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v2 ??, new type: boolean
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
                    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
                    	... 7 more
                     */
                    /* JADX WARN: Failed to calculate best type for var: r9v4 ??
                    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v4 ??, new type: boolean
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
                    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
                    	... 7 more
                     */
                    /*  JADX ERROR: Types fix failed
                        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v1 ??, new type: boolean
                        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
                        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
                        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
                        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
                        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
                        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
                        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
                        	... 5 more
                        */
                    @Override // kotlin.jvm.functions.Function4
                    public final java.lang.Object invoke(java.lang.Object r33, java.lang.Object r34, java.lang.Object r35, java.lang.Object r36) {
                        /*
                            Method dump skipped, instruction units count: 500
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.screens.AlbumScreenKt$AlbumScreen$lambda$22$0$4$0$0$$inlined$items$default$4.invoke(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
                    }
                }));
                return unit;
            case 3:
                HapticFeedback hapticFeedback2 = (HapticFeedback) obj7;
                MenuState menuState2 = (MenuState) obj6;
                PlayerConnection playerConnection = (PlayerConnection) obj4;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj3;
                State state5 = (State) obj5;
                LazyListIntervalContent lazyListIntervalContent3 = (LazyListIntervalContent) obj;
                lazyListIntervalContent3.getClass();
                ArrayList arrayList2 = ((ChartsPage.ChartSection) obj8).items;
                ArrayList arrayList3 = new ArrayList();
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj10 = arrayList2.get(i);
                    i++;
                    if (obj10 instanceof SongItem) {
                        arrayList3.add(obj10);
                    }
                }
                HashSet hashSet2 = new HashSet();
                ArrayList arrayList4 = new ArrayList();
                int size2 = arrayList3.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj11 = arrayList3.get(i2);
                    i2++;
                    if (hashSet2.add(((SongItem) obj11).id)) {
                        arrayList4.add(obj11);
                    }
                }
                lazyListIntervalContent3.items(arrayList4.size(), new Latch$await$2$2(new QueueKt$$ExternalSyntheticLambda4((byte) 15), arrayList4, (byte) 29), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList4, (byte) 10), new ComposableLambdaImpl(true, 802480018, new NewReleaseScreenKt$NewReleaseScreen$lambda$6$0$$inlined$items$default$4(arrayList4, hapticFeedback2, menuState2, this.f$5, playerConnection, coroutineScope2, state5)));
                return unit;
            case 4:
                State state6 = (State) obj8;
                State state7 = (State) obj7;
                HapticFeedback hapticFeedback3 = (HapticFeedback) obj6;
                MenuState menuState3 = (MenuState) obj4;
                PlayerConnection playerConnection2 = (PlayerConnection) obj3;
                CoroutineScope coroutineScope3 = (CoroutineScope) obj5;
                LazyListIntervalContent lazyListIntervalContent4 = (LazyListIntervalContent) obj;
                lazyListIntervalContent4.getClass();
                ChartsPage chartsPage = (ChartsPage) state.getValue();
                if (chartsPage != null) {
                    ArrayList arrayList5 = chartsPage.sections;
                    ArrayList arrayList6 = new ArrayList();
                    int size3 = arrayList5.size();
                    int i3 = 0;
                    while (i3 < size3) {
                        Object obj12 = arrayList5.get(i3);
                        i3++;
                        if (!Intrinsics.areEqual(((ChartsPage.ChartSection) obj12).title, "Top music videos")) {
                            arrayList6.add(obj12);
                        }
                    }
                    int size4 = arrayList6.size();
                    int i4 = 0;
                    while (i4 < size4) {
                        Object obj13 = arrayList6.get(i4);
                        i4++;
                        ChartsPage.ChartSection chartSection2 = (ChartsPage.ChartSection) obj13;
                        LazyListIntervalContent.item$default(lazyListIntervalContent4, Fragment$5$$ExternalSyntheticOutline0.m("section_title_", chartSection2.title), null, new ComposableLambdaImpl(true, 1116878313, new ListItemKt$$ExternalSyntheticLambda17((byte) 12, (Object) chartSection2)), 2);
                        String strM = Fragment$5$$ExternalSyntheticOutline0.m("section_content_", chartSection2.title);
                        PlayerConnection playerConnection3 = playerConnection2;
                        MenuState menuState4 = menuState3;
                        HapticFeedback hapticFeedback4 = hapticFeedback3;
                        State state8 = state7;
                        State state9 = state6;
                        QueueMenuKt$$ExternalSyntheticLambda12 queueMenuKt$$ExternalSyntheticLambda12 = new QueueMenuKt$$ExternalSyntheticLambda12((Object) chartSection2, (Object) state9, (Object) state8, (Object) hapticFeedback4, (Object) menuState4, (Object) playerConnection3, (byte) 4);
                        state6 = state9;
                        state7 = state8;
                        hapticFeedback3 = hapticFeedback4;
                        menuState3 = menuState4;
                        playerConnection2 = playerConnection3;
                        LazyListIntervalContent.item$default(lazyListIntervalContent4, strM, null, new ComposableLambdaImpl(true, -301543648, queueMenuKt$$ExternalSyntheticLambda12), 2);
                    }
                }
                ChartsPage chartsPage2 = (ChartsPage) state.getValue();
                if (chartsPage2 != null) {
                    ArrayList arrayList7 = chartsPage2.sections;
                    int size5 = arrayList7.size();
                    int i5 = 0;
                    do {
                        if (i5 < size5) {
                            obj2 = arrayList7.get(i5);
                            i5++;
                        } else {
                            obj2 = null;
                        }
                        chartSection = (ChartsPage.ChartSection) obj2;
                        if (chartSection != null) {
                            LazyListIntervalContent.item$default(lazyListIntervalContent4, "top_videos_title", null, AlbumScreenKt.f322lambda$358711871, 2);
                            LazyListIntervalContent.item$default(lazyListIntervalContent4, "top_videos_content", null, new ComposableLambdaImpl(true, -771360584, new SongMenuKt$$ExternalSyntheticLambda8(chartSection, state6, state7, hapticFeedback3, menuState3, playerConnection2, coroutineScope3, (byte) 8)), 2);
                        }
                    } while (!Intrinsics.areEqual(((ChartsPage.ChartSection) obj2).title, "Top music videos"));
                    chartSection = (ChartsPage.ChartSection) obj2;
                    if (chartSection != null) {
                        LazyListIntervalContent.item$default(lazyListIntervalContent4, "top_videos_title", null, AlbumScreenKt.f322lambda$358711871, 2);
                        LazyListIntervalContent.item$default(lazyListIntervalContent4, "top_videos_content", null, new ComposableLambdaImpl(true, -771360584, new SongMenuKt$$ExternalSyntheticLambda8(chartSection, state6, state7, hapticFeedback3, menuState3, playerConnection2, coroutineScope3, (byte) 8)), 2);
                    }
                }
                return unit;
            case 5:
                LazyListIntervalContent lazyListIntervalContent5 = (LazyListIntervalContent) obj;
                lazyListIntervalContent5.getClass();
                List list3 = (List) ((MutableState) obj5).getValue();
                lazyListIntervalContent5.items(list3.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new HomeScreenKt$$ExternalSyntheticLambda97((byte) 16), list3, (byte) 22), new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list3, (byte) 24), new ComposableLambdaImpl(true, 2039820996, new NewReleaseScreenKt$NewReleaseScreen$lambda$6$0$$inlined$items$default$4(list3, (MutableState) obj8, (HapticFeedback) obj7, (MenuState) obj6, this.f$5, (PlayerConnection) obj4, (State) obj3)));
                return unit;
            case 6:
                MutableState mutableState2 = (MutableState) obj5;
                PlayerConnection playerConnection4 = (PlayerConnection) obj8;
                NavHostController navHostController2 = (NavHostController) obj7;
                State state10 = (State) obj6;
                MenuState menuState5 = (MenuState) obj4;
                CoroutineScope coroutineScope4 = (CoroutineScope) obj3;
                LazyListIntervalContent lazyListIntervalContent6 = (LazyListIntervalContent) obj;
                lazyListIntervalContent6.getClass();
                ItemsPage itemsPage = (ItemsPage) mutableState2.getValue();
                List list4 = itemsPage != null ? itemsPage.items : null;
                if (list4 == null) {
                    list4 = EmptyList.INSTANCE;
                }
                HashSet hashSet3 = new HashSet();
                ArrayList arrayList8 = new ArrayList();
                for (Object obj14 : list4) {
                    if (hashSet3.add(((YTItem) obj14).getId())) {
                        arrayList8.add(obj14);
                    }
                }
                lazyListIntervalContent6.items(arrayList8.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 7), arrayList8, (byte) 29), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList8, (byte) 22), new ComposableLambdaImpl(true, 802480018, new NewReleaseScreenKt$NewReleaseScreen$lambda$6$0$$inlined$items$default$4(arrayList8, this.f$5, playerConnection4, navHostController2, state10, menuState5, coroutineScope4)));
                ItemsPage itemsPage2 = (ItemsPage) mutableState2.getValue();
                if ((itemsPage2 != null ? itemsPage2.continuation : null) != null) {
                    LazyListIntervalContent.item$default(lazyListIntervalContent6, "loading", null, ArtistItemsScreenKt.f341lambda$1544137819, 2);
                }
                return unit;
            case 7:
                final HapticFeedback hapticFeedback5 = (HapticFeedback) obj7;
                final MenuState menuState6 = (MenuState) obj6;
                final NavHostController navHostController3 = (NavHostController) obj4;
                final CoroutineScope coroutineScope5 = (CoroutineScope) obj3;
                final State state11 = (State) obj5;
                LazyListIntervalContent lazyListIntervalContent7 = (LazyListIntervalContent) obj;
                lazyListIntervalContent7.getClass();
                HashSet hashSet4 = new HashSet();
                final ArrayList arrayList9 = new ArrayList();
                for (Object obj15 : (List) obj8) {
                    if (hashSet4.add(((Album) obj15).album.id)) {
                        arrayList9.add(obj15);
                    }
                }
                StatsScreenKt$$ExternalSyntheticLambda9 statsScreenKt$$ExternalSyntheticLambda9 = new StatsScreenKt$$ExternalSyntheticLambda9((byte) 13);
                int size6 = arrayList9.size();
                ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 = new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(statsScreenKt$$ExternalSyntheticLambda9, arrayList9, (byte) 3);
                AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3 anonymousClass3 = new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList9, (byte) 24);
                final byte b4 = 1;
                final State state12 = this.f$5;
                lazyListIntervalContent7.items(size6, artistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1, anonymousClass3, new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.screens.AlbumScreenKt$AlbumScreen$lambda$22$0$4$0$0$$inlined$items$default$4
                    /* JADX WARN: Failed to calculate best type for var: r13v2 ??
                    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v2 ??, new type: androidx.compose.runtime.GapComposer
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
                    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
                    	... 7 more
                     */
                    /* JADX WARN: Failed to calculate best type for var: r9v1 ??
                    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v1 ??, new type: boolean
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
                    	... 6 more
                     */
                    /* JADX WARN: Failed to calculate best type for var: r9v1 ??
                    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v1 ??, new type: boolean
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
                    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
                    	... 7 more
                     */
                    /* JADX WARN: Failed to calculate best type for var: r9v2 ??
                    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v2 ??, new type: boolean
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
                    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
                    	... 7 more
                     */
                    /* JADX WARN: Failed to calculate best type for var: r9v4 ??
                    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v4 ??, new type: boolean
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
                    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
                    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
                    	... 7 more
                     */
                    /*  JADX ERROR: Types fix failed
                        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v1 ??, new type: boolean
                        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
                        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
                        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
                        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
                        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
                        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
                        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
                        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
                        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
                        	... 4 more
                        */
                    @Override // kotlin.jvm.functions.Function4
                    public final java.lang.Object invoke(java.lang.Object r33, java.lang.Object r34, java.lang.Object r35, java.lang.Object r36) {
                        /*
                            Method dump skipped, instruction units count: 500
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.screens.AlbumScreenKt$AlbumScreen$lambda$22$0$4$0$0$$inlined$items$default$4.invoke(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
                    }
                }));
                return unit;
            default:
                List list5 = (List) obj8;
                MutableState mutableState3 = (MutableState) obj5;
                MenuState menuState7 = (MenuState) obj4;
                State state13 = (State) obj3;
                LazyListIntervalContent lazyListIntervalContent8 = (LazyListIntervalContent) obj;
                lazyListIntervalContent8.getClass();
                lazyListIntervalContent8.item("filter", 0, new ComposableLambdaImpl(true, 1374819766, new ItemsKt$$ExternalSyntheticLambda9((ComposableLambdaImpl) obj7, b2)));
                lazyListIntervalContent8.item("header", 0, new ComposableLambdaImpl(true, 510566047, new ItemsKt$$ExternalSyntheticLambda9((ComposableLambdaImpl) obj6, (byte) 9)));
                if (list5.isEmpty()) {
                    LazyListIntervalContent.item$default(lazyListIntervalContent8, "empty_placeholder", null, new ComposableLambdaImpl(true, -664611227, new QueueKt$$ExternalSyntheticLambda21(mutableState3, (byte) 19)), 2);
                }
                lazyListIntervalContent8.items(list5.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 23), list5, (byte) 8), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new StatsScreenKt$$ExternalSyntheticLambda9((byte) 24), list5, (byte) 9), new ComposableLambdaImpl(true, 802480018, new YouTubeSongMenuKt$YouTubeSongMenu$lambda$16$0$$inlined$items$default$4(list5, menuState7, this.f$5, state13, (byte) 2)));
                return unit;
        }
    }

    public /* synthetic */ NavHostKt$$ExternalSyntheticLambda12(MutableState mutableState, MutableState mutableState2, PlayerConnection playerConnection, NavHostController navHostController, MutableState mutableState3, MenuState menuState, CoroutineScope coroutineScope) {
        this.$r8$classId = (byte) 6;
        this.f$6 = mutableState;
        this.f$5 = mutableState2;
        this.f$0 = playerConnection;
        this.f$1 = navHostController;
        this.f$2 = mutableState3;
        this.f$3 = menuState;
        this.f$4 = coroutineScope;
    }

    public /* synthetic */ NavHostKt$$ExternalSyntheticLambda12(State state, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, byte b) {
        this.$r8$classId = b;
        this.f$5 = state;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = obj5;
        this.f$6 = obj6;
    }

    public /* synthetic */ NavHostKt$$ExternalSyntheticLambda12(ChartsPage.ChartSection chartSection, HapticFeedback hapticFeedback, MenuState menuState, State state, PlayerConnection playerConnection, CoroutineScope coroutineScope, State state2) {
        this.$r8$classId = (byte) 3;
        this.f$0 = chartSection;
        this.f$1 = hapticFeedback;
        this.f$2 = menuState;
        this.f$5 = state;
        this.f$3 = playerConnection;
        this.f$4 = coroutineScope;
        this.f$6 = state2;
    }

    public /* synthetic */ NavHostKt$$ExternalSyntheticLambda12(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, State state, State state2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = obj5;
        this.f$5 = state;
        this.f$6 = state2;
    }

    public /* synthetic */ NavHostKt$$ExternalSyntheticLambda12(MutableState mutableState, MutableState mutableState2, HapticFeedback hapticFeedback, MenuState menuState, State state, PlayerConnection playerConnection, State state2) {
        this.$r8$classId = (byte) 5;
        this.f$6 = mutableState;
        this.f$0 = mutableState2;
        this.f$1 = hapticFeedback;
        this.f$2 = menuState;
        this.f$5 = state;
        this.f$3 = playerConnection;
        this.f$4 = state2;
    }
}
