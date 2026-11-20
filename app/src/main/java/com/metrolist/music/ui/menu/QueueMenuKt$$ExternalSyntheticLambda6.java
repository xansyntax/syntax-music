package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.RippleNodeFactory;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.metrolist.music.constants.AlbumSortType;
import com.metrolist.music.constants.ArtistSortType;
import com.metrolist.music.constants.LibraryViewType;
import com.metrolist.music.constants.MixSortType;
import com.metrolist.music.constants.PlaylistSongSortType;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.NewAction;
import com.metrolist.music.ui.component.SortHeaderKt$SortHeader$1$2$1;
import com.metrolist.music.ui.component.SortHeaderKt$SortHeader$1$5;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda39;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda56;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda57;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueMenuKt$$ExternalSyntheticLambda6 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ MutableState f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ boolean f$6;

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda6(AlbumSortType albumSortType, boolean z, Function1 function1, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, List list, MutableState mutableState, MutableState mutableState2) {
        this.$r8$classId = (byte) 4;
        this.f$0 = albumSortType;
        this.f$6 = z;
        this.f$1 = function1;
        this.f$3 = mimesKt$$ExternalSyntheticLambda0;
        this.f$4 = list;
        this.f$2 = mutableState;
        this.f$5 = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        boolean zBooleanValue;
        boolean z;
        final Function0 function0;
        NewAction newAction;
        boolean z2;
        Modifier.Companion companion;
        GapComposer gapComposer;
        Modifier modifierM137paddingVpY3zN4$default;
        int i;
        float f;
        Modifier.Companion companion2;
        GapComposer gapComposer2;
        Modifier modifierM137paddingVpY3zN4$default2;
        int i2;
        float f2;
        Modifier.Companion companion3;
        GapComposer gapComposer3;
        Modifier modifierM137paddingVpY3zN4$default3;
        int i3;
        float f3;
        LibraryViewType libraryViewType;
        byte b;
        byte b2 = this.$r8$classId;
        MutableState mutableState = this.f$2;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        boolean z3 = this.f$6;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.f$5;
        Object obj5 = this.f$4;
        Object obj6 = this.f$3;
        Object obj7 = this.f$1;
        Object obj8 = this.f$0;
        switch (b2) {
            case 0:
                CoroutineScope coroutineScope = (CoroutineScope) obj8;
                MusicDatabase musicDatabase = (MusicDatabase) obj7;
                MediaMetadata mediaMetadata = (MediaMetadata) obj6;
                Context context = (Context) obj5;
                SyncUtils syncUtils = (SyncUtils) obj4;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer;
                if (gapComposer4.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    boolean zChangedInstance = gapComposer4.changedInstance(coroutineScope) | gapComposer4.changedInstance(musicDatabase);
                    MutableState mutableState2 = this.f$2;
                    boolean zChanged = zChangedInstance | gapComposer4.changed(mutableState2) | gapComposer4.changed(mediaMetadata) | gapComposer4.changedInstance(context) | gapComposer4.changedInstance(syncUtils);
                    Object objRememberedValue = gapComposer4.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda73 = new SongMenuKt$$ExternalSyntheticLambda73(coroutineScope, musicDatabase, mediaMetadata, mutableState2, syncUtils, context);
                        gapComposer4.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda73);
                        objRememberedValue = songMenuKt$$ExternalSyntheticLambda73;
                    }
                    CardKt.IconButton((Function0) objRememberedValue, null, false, null, null, Expect_jvmKt.rememberComposableLambda(-1357973080, new SongMenuKt$$ExternalSyntheticLambda26((byte) 7, z3), gapComposer4), gapComposer4, 1572864, 62);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 1:
                Function0 function1 = (Function0) obj8;
                List list = (List) obj7;
                Function1 function2 = (Function1) obj6;
                Function1 function3 = (Function1) obj5;
                Function1 function4 = (Function1) obj4;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer2;
                if (gapComposer5.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    Modifier modifierM1481glassTintedFNF3uiM = Modifier.Companion.$$INSTANCE;
                    CardKt.TextButton(function1, DialogKt.pressScale(modifierM1481glassTintedFNF3uiM, 0.94f), false, null, null, null, DialogKt.f17lambda$1300370856, gapComposer5, 805306368, 508);
                    MutableState mutableState3 = this.f$2;
                    if (list == null) {
                        zBooleanValue = ((Boolean) function2.invoke(((TextFieldValue) mutableState3.getValue()).annotatedString.text)).booleanValue();
                    } else if (list.isEmpty()) {
                        zBooleanValue = true;
                    } else {
                        Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                zBooleanValue = true;
                            } else if (!((Boolean) function2.invoke(((TextFieldValue) ((Pair) it.next()).second).annotatedString.text)).booleanValue()) {
                                zBooleanValue = false;
                            }
                        }
                    }
                    boolean z4 = zBooleanValue;
                    Modifier modifierPressScale = DialogKt.pressScale(modifierM1481glassTintedFNF3uiM, 0.94f);
                    if (UiStyleKt.isGlassStyle(gapComposer5)) {
                        gapComposer5.startReplaceGroup(-102801907);
                        modifierM1481glassTintedFNF3uiM = GlassComponentsKt.m1481glassTintedFNF3uiM(modifierM1481glassTintedFNF3uiM, RoundedCornerShapeKt.CircleShape, gapComposer5);
                        z = false;
                    } else {
                        z = false;
                        gapComposer5.startReplaceGroup(-102800963);
                    }
                    gapComposer5.end(z);
                    Modifier modifierThen = modifierPressScale.then(modifierM1481glassTintedFNF3uiM);
                    ButtonColors buttonColorsDialogConfirmColors = DialogKt.dialogConfirmColors(gapComposer5);
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = UiStyleKt.isGlassStyle(gapComposer5) ? RoundedCornerShapeKt.CircleShape : RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                    boolean z5 = this.f$6;
                    boolean zChanged2 = gapComposer5.changed(z5) | gapComposer5.changed(function1) | gapComposer5.changedInstance(list) | gapComposer5.changed(function4) | gapComposer5.changed(function3);
                    Object objRememberedValue2 = gapComposer5.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        SongMenuKt$$ExternalSyntheticLambda25 songMenuKt$$ExternalSyntheticLambda25 = new SongMenuKt$$ExternalSyntheticLambda25((byte) 1, function1, list, function4, function3, mutableState3, z5);
                        gapComposer5.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda25);
                        objRememberedValue2 = songMenuKt$$ExternalSyntheticLambda25;
                    }
                    CardKt.Button((Function0) objRememberedValue2, modifierThen, z4, roundedCornerShapeM185RoundedCornerShape0680j_4, buttonColorsDialogConfirmColors, null, null, null, null, DialogKt.f20lambda$1495682491, gapComposer5, 805306368, 480);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 2:
                Function0 function5 = (Function0) obj8;
                final PlayerConnection playerConnection = (PlayerConnection) obj7;
                final Playlist playlist = (Playlist) obj6;
                Context context2 = (Context) obj5;
                State state = (State) obj4;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer3;
                if (gapComposer6.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    if (z3) {
                        function0 = function5;
                        gapComposer6.startReplaceGroup(-139616035);
                        gapComposer6.end(false);
                        newAction = null;
                    } else {
                        gapComposer6.startReplaceGroup(-142001361);
                        String strStringResource = MathKt.stringResource(R.string.play, gapComposer6);
                        final byte b3 = 0;
                        final MutableState mutableState4 = this.f$2;
                        function0 = function5;
                        Expect_jvmKt.rememberComposableLambda(-1235833275, new Function2() { // from class: com.metrolist.music.ui.menu.PlaylistMenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj9, Object obj10) {
                                byte b4 = b3;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState5 = mutableState4;
                                Playlist playlist2 = playlist;
                                PlayerConnection playerConnection2 = playerConnection;
                                Function0 function6 = function0;
                                int i4 = 0;
                                switch (b4) {
                                    case 0:
                                        Composer composer4 = (Composer) obj9;
                                        int iIntValue4 = ((Integer) obj10).intValue();
                                        GapComposer gapComposer7 = (GapComposer) composer4;
                                        if (!gapComposer7.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                                            gapComposer7.skipToGroupEnd();
                                        } else {
                                            function6.invoke();
                                            if (!((List) mutableState5.getValue()).isEmpty()) {
                                                String str = playlist2.playlist.name;
                                                List list2 = (List) mutableState5.getValue();
                                                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                                                Iterator it2 = list2.iterator();
                                                while (it2.hasNext()) {
                                                    arrayList.add(UuidKt.toMediaItem((Song) it2.next()));
                                                }
                                                playerConnection2.playQueue(new ListQueue(str, arrayList, 0, 0L, 12, null));
                                            }
                                        }
                                        break;
                                    default:
                                        Composer composer5 = (Composer) obj9;
                                        int iIntValue5 = ((Integer) obj10).intValue();
                                        GapComposer gapComposer8 = (GapComposer) composer5;
                                        if (!gapComposer8.shouldExecute(1 & iIntValue5, (iIntValue5 & 3) != 2)) {
                                            gapComposer8.skipToGroupEnd();
                                        } else {
                                            function6.invoke();
                                            if (!((List) mutableState5.getValue()).isEmpty()) {
                                                String str2 = playlist2.playlist.name;
                                                List listShuffled = CollectionsKt__IterablesKt.shuffled((List) mutableState5.getValue());
                                                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listShuffled, 10));
                                                ArrayList arrayList3 = (ArrayList) listShuffled;
                                                int size = arrayList3.size();
                                                while (i4 < size) {
                                                    Object obj11 = arrayList3.get(i4);
                                                    i4++;
                                                    arrayList2.add(UuidKt.toMediaItem((Song) obj11));
                                                }
                                                playerConnection2.playQueue(new ListQueue(str2, arrayList2, 0, 0L, 12, null));
                                            }
                                        }
                                        break;
                                }
                                return unit2;
                            }
                        }, gapComposer6);
                        Rgb rgb = ColorSpaces.Unspecified;
                        ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
                        ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
                        strStringResource.getClass();
                        final byte b4 = 1;
                        newAction = new NewAction(AlbumMenuKt.lambda$654915120, MathKt.stringResource(R.string.shuffle, gapComposer6), Expect_jvmKt.rememberComposableLambda(2119266030, new Function2() { // from class: com.metrolist.music.ui.menu.PlaylistMenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj9, Object obj10) {
                                byte b5 = b4;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState5 = mutableState4;
                                Playlist playlist2 = playlist;
                                PlayerConnection playerConnection2 = playerConnection;
                                Function0 function6 = function0;
                                int i4 = 0;
                                switch (b5) {
                                    case 0:
                                        Composer composer4 = (Composer) obj9;
                                        int iIntValue4 = ((Integer) obj10).intValue();
                                        GapComposer gapComposer7 = (GapComposer) composer4;
                                        if (!gapComposer7.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                                            gapComposer7.skipToGroupEnd();
                                        } else {
                                            function6.invoke();
                                            if (!((List) mutableState5.getValue()).isEmpty()) {
                                                String str = playlist2.playlist.name;
                                                List list2 = (List) mutableState5.getValue();
                                                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                                                Iterator it2 = list2.iterator();
                                                while (it2.hasNext()) {
                                                    arrayList.add(UuidKt.toMediaItem((Song) it2.next()));
                                                }
                                                playerConnection2.playQueue(new ListQueue(str, arrayList, 0, 0L, 12, null));
                                            }
                                        }
                                        break;
                                    default:
                                        Composer composer5 = (Composer) obj9;
                                        int iIntValue5 = ((Integer) obj10).intValue();
                                        GapComposer gapComposer8 = (GapComposer) composer5;
                                        if (!gapComposer8.shouldExecute(1 & iIntValue5, (iIntValue5 & 3) != 2)) {
                                            gapComposer8.skipToGroupEnd();
                                        } else {
                                            function6.invoke();
                                            if (!((List) mutableState5.getValue()).isEmpty()) {
                                                String str2 = playlist2.playlist.name;
                                                List listShuffled = CollectionsKt__IterablesKt.shuffled((List) mutableState5.getValue());
                                                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listShuffled, 10));
                                                ArrayList arrayList3 = (ArrayList) listShuffled;
                                                int size = arrayList3.size();
                                                while (i4 < size) {
                                                    Object obj11 = arrayList3.get(i4);
                                                    i4++;
                                                    arrayList2.add(UuidKt.toMediaItem((Song) obj11));
                                                }
                                                playerConnection2.playQueue(new ListQueue(str2, arrayList2, 0, 0L, 12, null));
                                            }
                                        }
                                        break;
                                }
                                return unit2;
                            }
                        }, gapComposer6));
                        gapComposer6.end(false);
                    }
                    MenuKt.NewActionGrid(ArraysKt.filterNotNull(new NewAction[]{newAction, new NewAction(AlbumMenuKt.f168lambda$2053765023, MathKt.stringResource(R.string.share, gapComposer6), Expect_jvmKt.rememberComposableLambda(-1227952609, new MainActivity$$ExternalSyntheticLambda9(function0, context2, state, (byte) 26), gapComposer6))}), OffsetKt.m136paddingVpY3zN4(Modifier.Companion.$$INSTANCE, 4.0f, 16.0f), z3 ? 2 : 3, gapComposer6, 48, 0);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 3:
                List list2 = (List) obj8;
                Function0 function6 = (Function0) obj7;
                PlayerConnection playerConnection2 = (PlayerConnection) obj6;
                Function0 function7 = (Function0) obj5;
                List list3 = (List) obj4;
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer4;
                if (gapComposer7.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    gapComposer7.startReplaceGroup(1894099843);
                    ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                    if (list2.isEmpty() || z3) {
                        gapComposer7.startReplaceGroup(2055287509);
                        gapComposer7.end(false);
                    } else {
                        gapComposer7.startReplaceGroup(2053933460);
                        ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.f105lambda$1522855196;
                        ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.f281lambda$951625853;
                        boolean zChanged3 = gapComposer7.changed(function6) | gapComposer7.changedInstance(list2) | gapComposer7.changedInstance(playerConnection2) | gapComposer7.changed(function7);
                        Object objRememberedValue3 = gapComposer7.rememberedValue();
                        if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new SelectionSongsMenuKt$$ExternalSyntheticLambda30(function6, list2, function7, playerConnection2);
                            gapComposer7.updateRememberedValue(objRememberedValue3);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, null, (Function0) objRememberedValue3, null, null, 52));
                        gapComposer7.end(false);
                    }
                    if (z3) {
                        gapComposer7.startReplaceGroup(2058665269);
                        gapComposer7.end(false);
                    } else {
                        gapComposer7.startReplaceGroup(2055430543);
                        ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.lambda$1475588251;
                        ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.lambda$671172986;
                        boolean zChanged4 = gapComposer7.changed(function6) | gapComposer7.changedInstance(playerConnection2) | gapComposer7.changedInstance(list3) | gapComposer7.changed(function7);
                        Object objRememberedValue4 = gapComposer7.rememberedValue();
                        if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                            objRememberedValue4 = new SelectionSongsMenuKt$$ExternalSyntheticLambda30(function6, playerConnection2, list3, function7, (byte) 1);
                            gapComposer7.updateRememberedValue(objRememberedValue4);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl3, composableLambdaImpl4, null, (Function0) objRememberedValue4, null, null, 52));
                        ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.f116lambda$1610101102;
                        ComposableLambdaImpl composableLambdaImpl6 = AlbumMenuKt.f108lambda$1559057487;
                        boolean zChanged5 = gapComposer7.changed(function6) | gapComposer7.changedInstance(playerConnection2) | gapComposer7.changedInstance(list3) | gapComposer7.changed(function7);
                        Object objRememberedValue5 = gapComposer7.rememberedValue();
                        if (zChanged5 || objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = new SelectionSongsMenuKt$$ExternalSyntheticLambda30(function6, playerConnection2, list3, function7, (byte) 2);
                            gapComposer7.updateRememberedValue(objRememberedValue5);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl5, composableLambdaImpl6, null, (Function0) objRememberedValue5, null, null, 52));
                        if (z3) {
                            z2 = false;
                            gapComposer7.startReplaceGroup(2058639477);
                            gapComposer7.end(false);
                        } else {
                            gapComposer7.startReplaceGroup(2057690970);
                            ComposableLambdaImpl composableLambdaImpl7 = AlbumMenuKt.f75lambda$1289553994;
                            ComposableLambdaImpl composableLambdaImpl8 = AlbumMenuKt.lambda$340411861;
                            boolean zChanged6 = gapComposer7.changed(function6) | gapComposer7.changedInstance(playerConnection2) | gapComposer7.changedInstance(list3) | gapComposer7.changed(function7);
                            Object objRememberedValue6 = gapComposer7.rememberedValue();
                            if (zChanged6 || objRememberedValue6 == neverEqualPolicy) {
                                objRememberedValue6 = new SelectionSongsMenuKt$$ExternalSyntheticLambda30(function6, playerConnection2, list3, function7, (byte) 3);
                                gapComposer7.updateRememberedValue(objRememberedValue6);
                            }
                            listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl7, composableLambdaImpl8, null, (Function0) objRememberedValue6, null, null, 52));
                            z2 = false;
                            gapComposer7.end(false);
                        }
                        gapComposer7.end(z2);
                    }
                    ComposableLambdaImpl composableLambdaImpl9 = AlbumMenuKt.f279lambda$942261431;
                    ComposableLambdaImpl composableLambdaImpl10 = AlbumMenuKt.f119lambda$1647121752;
                    boolean zChanged7 = gapComposer7.changed(mutableState);
                    Object objRememberedValue7 = gapComposer7.rememberedValue();
                    if (zChanged7 || objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState, (byte) 22);
                        gapComposer7.updateRememberedValue(objRememberedValue7);
                    }
                    listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl9, composableLambdaImpl10, null, (Function0) objRememberedValue7, null, null, 52));
                    ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                    gapComposer7.end(false);
                    MenuKt.Material3MenuGroup(listBuilderBuild, gapComposer7, 0);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 4:
                AlbumSortType albumSortType = (AlbumSortType) obj8;
                Function1 function8 = (Function1) obj7;
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) obj6;
                List list4 = (List) obj5;
                MutableState mutableState5 = (MutableState) obj4;
                RowScope rowScope = (RowScope) obj;
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                rowScope.getClass();
                if ((iIntValue5 & 6) == 0) {
                    iIntValue5 |= ((GapComposer) composer5).changed(rowScope) ? 4 : 2;
                }
                GapComposer gapComposer8 = (GapComposer) composer5;
                if (gapComposer8.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                    Object objRememberedValue8 = gapComposer8.rememberedValue();
                    if (objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer8.updateRememberedValue(objRememberedValue8);
                    }
                    MutableState mutableState6 = (MutableState) objRememberedValue8;
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Modifier.Companion companion4 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM137paddingVpY3zN4$default4 = OffsetKt.m137paddingVpY3zN4$default(companion4, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
                    if (UiStyleKt.isGlassStyle(gapComposer8)) {
                        gapComposer8.startReplaceGroup(-2138758585);
                        companion = companion4;
                        gapComposer = gapComposer8;
                        modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(GlassComponentsKt.glass(companion, RoundedCornerShapeKt.RoundedCornerShape(50), false, gapComposer8, 6, 2), 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                        gapComposer.end(false);
                    } else {
                        companion = companion4;
                        gapComposer = gapComposer8;
                        gapComposer.startReplaceGroup(-2138602190);
                        gapComposer.end(false);
                        modifierM137paddingVpY3zN4$default = companion;
                    }
                    Modifier modifierThen2 = modifierM137paddingVpY3zN4$default4.then(modifierM137paddingVpY3zN4$default);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 48);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    switch (albumSortType.ordinal()) {
                        case 0:
                            i = R.string.sort_by_create_date;
                            break;
                        case 1:
                            i = R.string.sort_by_name;
                            break;
                        case 2:
                            i = R.string.sort_by_artist;
                            break;
                        case 3:
                            i = R.string.sort_by_year;
                            break;
                        case 4:
                            i = R.string.sort_by_song_count;
                            break;
                        case 5:
                            i = R.string.sort_by_length;
                            break;
                        case 6:
                            i = R.string.sort_by_play_time;
                            break;
                        default:
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                    }
                    String upperCase = MathKt.stringResource(i, gapComposer).toUpperCase(Locale.ROOT);
                    upperCase.getClass();
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    long j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.labelMedium;
                    FontWeight fontWeight = UiStyleKt.isGlassStyle(gapComposer) ? FontWeight.Bold : null;
                    Object objRememberedValue9 = gapComposer.rememberedValue();
                    if (objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue9;
                    RippleNodeFactory rippleNodeFactoryM313rippleOu1YvPQ$default = RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, null, 254);
                    Object objRememberedValue10 = gapComposer.rememberedValue();
                    if (objRememberedValue10 == neverEqualPolicy) {
                        objRememberedValue10 = new SortHeaderKt$SortHeader$1$2$1(mutableState6, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue10);
                    }
                    GapComposer gapComposer9 = gapComposer;
                    Modifier.Companion companion5 = companion;
                    TextKt.m352TextNvy7gAk(upperCase, OffsetKt.m136paddingVpY3zN4(ImageKt.m45clickableO2vRcR0$default(companion, mutableInteractionSourceImpl, rippleNodeFactoryM313rippleOu1YvPQ$default, false, null, (Function0) objRememberedValue10, 28), 4.0f, 8.0f), j, 0L, null, fontWeight, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer9, 0, 0, 131000);
                    boolean zM1492SortHeader$lambda1 = MenuKt.m1492SortHeader$lambda1(mutableState6);
                    Object objRememberedValue11 = gapComposer9.rememberedValue();
                    if (objRememberedValue11 == neverEqualPolicy) {
                        objRememberedValue11 = new SortHeaderKt$SortHeader$1$2$1(mutableState6, (byte) 1);
                        gapComposer9.updateRememberedValue(objRememberedValue11);
                    }
                    CardKt.m256DropdownMenuIlH_yew(zM1492SortHeader$lambda1, (Function0) objRememberedValue11, SizeKt.m157widthInVpY3zN4$default(companion5, 172.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, null, null, null, 0L, CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(-1229424361, new LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1((byte) 2, mutableState6, albumSortType, function8), gapComposer9), gapComposer9, 432, 2040);
                    if (albumSortType != PlaylistSongSortType.CUSTOM) {
                        gapComposer9.startReplaceGroup(-413182842);
                        f = 8.0f;
                        MenuKt.m1491ResizableIconButtonFU0evQE(z3 ? R.drawable.arrow_downward : R.drawable.arrow_upward, OffsetKt.m135padding3ABfNKs(SizeKt.m151size3ABfNKs(companion5, 32.0f), 8.0f), ((MaterialTheme$Values) gapComposer9.consume(staticProvidableCompositionLocal)).colorScheme.primary, false, new SortHeaderKt$SortHeader$1$5(mimesKt$$ExternalSyntheticLambda0, z3), gapComposer9, 48);
                        gapComposer9.end(false);
                    } else {
                        f = 8.0f;
                        gapComposer9.startReplaceGroup(-412803898);
                        gapComposer9.end(false);
                    }
                    gapComposer9.end(true);
                    OffsetKt.Spacer(gapComposer9, rowScope.weight(companion5, 1.0f, true));
                    TextKt.m352TextNvy7gAk(MathKt.pluralStringResource(R.plurals.n_album, list4.size(), new Object[]{Integer.valueOf(list4.size())}, gapComposer9), null, ((MaterialTheme$Values) gapComposer9.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer9.consume(staticProvidableCompositionLocal)).typography.titleSmall, gapComposer9, 0, 0, 131066);
                    boolean zChanged8 = gapComposer9.changed(mutableState);
                    Object objRememberedValue12 = gapComposer9.rememberedValue();
                    if (zChanged8 || objRememberedValue12 == neverEqualPolicy) {
                        objRememberedValue12 = new PlayerKt$$ExternalSyntheticLambda7(mutableState, (byte) 21);
                        gapComposer9.updateRememberedValue(objRememberedValue12);
                    }
                    CardKt.IconButton((Function0) objRememberedValue12, SizeKt.m151size3ABfNKs(OffsetKt.m139paddingqDBjuR0$default(companion5, f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14), 40.0f), false, null, null, LibraryScreenKt.lambda$306992480, gapComposer9, 1572912, 60);
                    boolean zChanged9 = gapComposer9.changed(mutableState5);
                    Object objRememberedValue13 = gapComposer9.rememberedValue();
                    if (zChanged9 || objRememberedValue13 == neverEqualPolicy) {
                        objRememberedValue13 = new PlayerKt$$ExternalSyntheticLambda7(mutableState5, (byte) 22);
                        gapComposer9.updateRememberedValue(objRememberedValue13);
                    }
                    CardKt.IconButton((Function0) objRememberedValue13, SizeKt.m151size3ABfNKs(OffsetKt.m139paddingqDBjuR0$default(companion5, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, CropImageView.DEFAULT_ASPECT_RATIO, 11), 40.0f), false, null, null, Expect_jvmKt.rememberComposableLambda(-1115071159, new QueueKt$$ExternalSyntheticLambda39(mutableState5, (byte) 8), gapComposer9), gapComposer9, 1572912, 60);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 5:
                ArtistSortType artistSortType = (ArtistSortType) obj8;
                Function1 function9 = (Function1) obj7;
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1 = (MimesKt$$ExternalSyntheticLambda0) obj6;
                MutableState mutableState7 = (MutableState) obj5;
                State state2 = (State) obj4;
                RowScope rowScope2 = (RowScope) obj;
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                rowScope2.getClass();
                if ((iIntValue6 & 6) == 0) {
                    iIntValue6 |= ((GapComposer) composer6).changed(rowScope2) ? 4 : 2;
                }
                GapComposer gapComposer10 = (GapComposer) composer6;
                if (gapComposer10.shouldExecute(iIntValue6 & 1, (iIntValue6 & 19) != 18)) {
                    Object objRememberedValue14 = gapComposer10.rememberedValue();
                    if (objRememberedValue14 == neverEqualPolicy) {
                        objRememberedValue14 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer10.updateRememberedValue(objRememberedValue14);
                    }
                    MutableState mutableState8 = (MutableState) objRememberedValue14;
                    BiasAlignment.Vertical vertical2 = Alignment.Companion.CenterVertically;
                    Modifier.Companion companion6 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM137paddingVpY3zN4$default5 = OffsetKt.m137paddingVpY3zN4$default(companion6, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
                    if (UiStyleKt.isGlassStyle(gapComposer10)) {
                        gapComposer10.startReplaceGroup(-2138758585);
                        companion2 = companion6;
                        gapComposer2 = gapComposer10;
                        modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(GlassComponentsKt.glass(companion2, RoundedCornerShapeKt.RoundedCornerShape(50), false, gapComposer10, 6, 2), 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                        gapComposer2.end(false);
                    } else {
                        companion2 = companion6;
                        gapComposer2 = gapComposer10;
                        gapComposer2.startReplaceGroup(-2138602190);
                        gapComposer2.end(false);
                        modifierM137paddingVpY3zN4$default2 = companion2;
                    }
                    Modifier modifierThen3 = modifierM137paddingVpY3zN4$default5.then(modifierM137paddingVpY3zN4$default2);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical2, gapComposer2, 48);
                    int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierThen3);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                    int iOrdinal = artistSortType.ordinal();
                    if (iOrdinal == 0) {
                        i2 = R.string.sort_by_create_date;
                    } else if (iOrdinal == 1) {
                        i2 = R.string.sort_by_name;
                    } else if (iOrdinal == 2) {
                        i2 = R.string.sort_by_song_count;
                    } else {
                        if (iOrdinal != 3) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i2 = R.string.sort_by_play_time;
                    }
                    String upperCase2 = MathKt.stringResource(i2, gapComposer2).toUpperCase(Locale.ROOT);
                    upperCase2.getClass();
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    long j2 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.primary;
                    TextStyle textStyle2 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).typography.labelMedium;
                    FontWeight fontWeight2 = UiStyleKt.isGlassStyle(gapComposer2) ? FontWeight.Bold : null;
                    Object objRememberedValue15 = gapComposer2.rememberedValue();
                    if (objRememberedValue15 == neverEqualPolicy) {
                        objRememberedValue15 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
                    }
                    MutableInteractionSourceImpl mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue15;
                    RippleNodeFactory rippleNodeFactoryM313rippleOu1YvPQ$default2 = RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, null, 254);
                    Object objRememberedValue16 = gapComposer2.rememberedValue();
                    if (objRememberedValue16 == neverEqualPolicy) {
                        objRememberedValue16 = new SortHeaderKt$SortHeader$1$2$1(mutableState8, (byte) 0);
                        gapComposer2.updateRememberedValue(objRememberedValue16);
                    }
                    GapComposer gapComposer11 = gapComposer2;
                    Modifier.Companion companion7 = companion2;
                    TextKt.m352TextNvy7gAk(upperCase2, OffsetKt.m136paddingVpY3zN4(ImageKt.m45clickableO2vRcR0$default(companion2, mutableInteractionSourceImpl2, rippleNodeFactoryM313rippleOu1YvPQ$default2, false, null, (Function0) objRememberedValue16, 28), 4.0f, 8.0f), j2, 0L, null, fontWeight2, null, 0L, null, 0L, 0, false, 0, 0, textStyle2, gapComposer11, 0, 0, 131000);
                    boolean zM1492SortHeader$lambda2 = MenuKt.m1492SortHeader$lambda1(mutableState8);
                    Object objRememberedValue17 = gapComposer11.rememberedValue();
                    if (objRememberedValue17 == neverEqualPolicy) {
                        objRememberedValue17 = new SortHeaderKt$SortHeader$1$2$1(mutableState8, (byte) 1);
                        gapComposer11.updateRememberedValue(objRememberedValue17);
                    }
                    CardKt.m256DropdownMenuIlH_yew(zM1492SortHeader$lambda2, (Function0) objRememberedValue17, SizeKt.m157widthInVpY3zN4$default(companion7, 172.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, null, null, null, 0L, CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(-1229424361, new LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1((byte) 3, mutableState8, artistSortType, function9), gapComposer11), gapComposer11, 432, 2040);
                    if (artistSortType != PlaylistSongSortType.CUSTOM) {
                        gapComposer11.startReplaceGroup(-413182842);
                        f2 = 8.0f;
                        MenuKt.m1491ResizableIconButtonFU0evQE(z3 ? R.drawable.arrow_downward : R.drawable.arrow_upward, OffsetKt.m135padding3ABfNKs(SizeKt.m151size3ABfNKs(companion7, 32.0f), 8.0f), ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal2)).colorScheme.primary, false, new SortHeaderKt$SortHeader$1$5(mimesKt$$ExternalSyntheticLambda1, z3), gapComposer11, 48);
                        gapComposer11.end(false);
                    } else {
                        f2 = 8.0f;
                        gapComposer11.startReplaceGroup(-412803898);
                        gapComposer11.end(false);
                    }
                    gapComposer11.end(true);
                    OffsetKt.Spacer(gapComposer11, rowScope2.weight(companion7, 1.0f, true));
                    TextKt.m352TextNvy7gAk(MathKt.pluralStringResource(R.plurals.n_artist, ((List) state2.getValue()).size(), new Object[]{Integer.valueOf(((List) state2.getValue()).size())}, gapComposer11), null, ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal2)).typography.titleSmall, gapComposer11, 0, 0, 131066);
                    boolean zChanged10 = gapComposer11.changed(mutableState);
                    Object objRememberedValue18 = gapComposer11.rememberedValue();
                    if (zChanged10 || objRememberedValue18 == neverEqualPolicy) {
                        objRememberedValue18 = new PlayerKt$$ExternalSyntheticLambda7(mutableState, (byte) 23);
                        gapComposer11.updateRememberedValue(objRememberedValue18);
                    }
                    CardKt.IconButton((Function0) objRememberedValue18, SizeKt.m151size3ABfNKs(OffsetKt.m139paddingqDBjuR0$default(companion7, f2, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14), 40.0f), false, null, null, LibraryScreenKt.lambda$138781026, gapComposer11, 1572912, 60);
                    boolean zChanged11 = gapComposer11.changed(mutableState7);
                    Object objRememberedValue19 = gapComposer11.rememberedValue();
                    if (zChanged11 || objRememberedValue19 == neverEqualPolicy) {
                        objRememberedValue19 = new PlayerKt$$ExternalSyntheticLambda7(mutableState7, (byte) 24);
                        gapComposer11.updateRememberedValue(objRememberedValue19);
                    }
                    CardKt.IconButton((Function0) objRememberedValue19, SizeKt.m151size3ABfNKs(OffsetKt.m139paddingqDBjuR0$default(companion7, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f2, CropImageView.DEFAULT_ASPECT_RATIO, 11), 40.0f), false, null, null, Expect_jvmKt.rememberComposableLambda(998319321, new QueueKt$$ExternalSyntheticLambda39(mutableState7, (byte) 9), gapComposer11), gapComposer11, 1572912, 60);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            default:
                MixSortType mixSortType = (MixSortType) obj8;
                Function1 function10 = (Function1) obj7;
                Function1 function11 = (Function1) obj6;
                Function1 function12 = (Function1) obj5;
                LibraryViewType libraryViewType2 = (LibraryViewType) obj4;
                RowScope rowScope3 = (RowScope) obj;
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                rowScope3.getClass();
                if ((iIntValue7 & 6) == 0) {
                    iIntValue7 |= ((GapComposer) composer7).changed(rowScope3) ? 4 : 2;
                }
                GapComposer gapComposer12 = (GapComposer) composer7;
                if (gapComposer12.shouldExecute(iIntValue7 & 1, (iIntValue7 & 19) != 18)) {
                    Object objRememberedValue20 = gapComposer12.rememberedValue();
                    if (objRememberedValue20 == neverEqualPolicy) {
                        objRememberedValue20 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer12.updateRememberedValue(objRememberedValue20);
                    }
                    MutableState mutableState9 = (MutableState) objRememberedValue20;
                    BiasAlignment.Vertical vertical3 = Alignment.Companion.CenterVertically;
                    Modifier.Companion companion8 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM137paddingVpY3zN4$default6 = OffsetKt.m137paddingVpY3zN4$default(companion8, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
                    if (UiStyleKt.isGlassStyle(gapComposer12)) {
                        gapComposer12.startReplaceGroup(-2138758585);
                        companion3 = companion8;
                        gapComposer3 = gapComposer12;
                        modifierM137paddingVpY3zN4$default3 = OffsetKt.m137paddingVpY3zN4$default(GlassComponentsKt.glass(companion3, RoundedCornerShapeKt.RoundedCornerShape(50), false, gapComposer12, 6, 2), 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                        gapComposer3.end(false);
                    } else {
                        companion3 = companion8;
                        gapComposer3 = gapComposer12;
                        gapComposer3.startReplaceGroup(-2138602190);
                        gapComposer3.end(false);
                        modifierM137paddingVpY3zN4$default3 = companion3;
                    }
                    Modifier modifierThen4 = modifierM137paddingVpY3zN4$default6.then(modifierM137paddingVpY3zN4$default3);
                    RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical3, gapComposer3, 48);
                    int iHashCode3 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierThen4);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, rowMeasurePolicy3, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
                    int iOrdinal2 = mixSortType.ordinal();
                    if (iOrdinal2 == 0) {
                        i3 = R.string.sort_by_create_date;
                    } else if (iOrdinal2 == 1) {
                        i3 = R.string.sort_by_name;
                    } else {
                        if (iOrdinal2 != 2) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i3 = R.string.sort_by_last_updated;
                    }
                    String upperCase3 = MathKt.stringResource(i3, gapComposer3).toUpperCase(Locale.ROOT);
                    upperCase3.getClass();
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    long j3 = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal3)).colorScheme.primary;
                    TextStyle textStyle3 = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal3)).typography.labelMedium;
                    FontWeight fontWeight3 = UiStyleKt.isGlassStyle(gapComposer3) ? FontWeight.Bold : null;
                    Object objRememberedValue21 = gapComposer3.rememberedValue();
                    if (objRememberedValue21 == neverEqualPolicy) {
                        objRememberedValue21 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer3);
                    }
                    MutableInteractionSourceImpl mutableInteractionSourceImpl3 = (MutableInteractionSourceImpl) objRememberedValue21;
                    RippleNodeFactory rippleNodeFactoryM313rippleOu1YvPQ$default3 = RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, null, 254);
                    Object objRememberedValue22 = gapComposer3.rememberedValue();
                    if (objRememberedValue22 == neverEqualPolicy) {
                        objRememberedValue22 = new SortHeaderKt$SortHeader$1$2$1(mutableState9, (byte) 0);
                        gapComposer3.updateRememberedValue(objRememberedValue22);
                    }
                    Modifier.Companion companion9 = companion3;
                    GapComposer gapComposer13 = gapComposer3;
                    TextKt.m352TextNvy7gAk(upperCase3, OffsetKt.m136paddingVpY3zN4(ImageKt.m45clickableO2vRcR0$default(companion3, mutableInteractionSourceImpl3, rippleNodeFactoryM313rippleOu1YvPQ$default3, false, null, (Function0) objRememberedValue22, 28), 4.0f, 8.0f), j3, 0L, null, fontWeight3, null, 0L, null, 0L, 0, false, 0, 0, textStyle3, gapComposer13, 0, 0, 131000);
                    boolean zM1492SortHeader$lambda3 = MenuKt.m1492SortHeader$lambda1(mutableState9);
                    Object objRememberedValue23 = gapComposer13.rememberedValue();
                    if (objRememberedValue23 == neverEqualPolicy) {
                        objRememberedValue23 = new SortHeaderKt$SortHeader$1$2$1(mutableState9, (byte) 1);
                        gapComposer13.updateRememberedValue(objRememberedValue23);
                    }
                    CardKt.m256DropdownMenuIlH_yew(zM1492SortHeader$lambda3, (Function0) objRememberedValue23, SizeKt.m157widthInVpY3zN4$default(companion9, 172.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, null, null, null, 0L, CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(-1229424361, new LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1((byte) 0, mutableState9, mixSortType, function10), gapComposer13), gapComposer13, 432, 2040);
                    if (mixSortType != PlaylistSongSortType.CUSTOM) {
                        gapComposer13.startReplaceGroup(-413182842);
                        f3 = 8.0f;
                        MenuKt.m1491ResizableIconButtonFU0evQE(z3 ? R.drawable.arrow_downward : R.drawable.arrow_upward, OffsetKt.m135padding3ABfNKs(SizeKt.m151size3ABfNKs(companion9, 32.0f), 8.0f), ((MaterialTheme$Values) gapComposer13.consume(staticProvidableCompositionLocal3)).colorScheme.primary, false, new SortHeaderKt$SortHeader$1$5(function11, z3), gapComposer13, 48);
                        gapComposer13.end(false);
                    } else {
                        f3 = 8.0f;
                        gapComposer13.startReplaceGroup(-412803898);
                        gapComposer13.end(false);
                    }
                    gapComposer13.end(true);
                    OffsetKt.Spacer(gapComposer13, rowScope3.weight(companion9, 1.0f, true));
                    boolean zChanged12 = gapComposer13.changed(mutableState);
                    Object objRememberedValue24 = gapComposer13.rememberedValue();
                    if (zChanged12 || objRememberedValue24 == neverEqualPolicy) {
                        objRememberedValue24 = new PlayerKt$$ExternalSyntheticLambda7(mutableState, (byte) 26);
                        gapComposer13.updateRememberedValue(objRememberedValue24);
                    }
                    CardKt.IconButton((Function0) objRememberedValue24, SizeKt.m151size3ABfNKs(OffsetKt.m139paddingqDBjuR0$default(companion9, f3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14), 40.0f), false, null, null, LibraryScreenKt.lambda$1841139844, gapComposer13, 1572912, 60);
                    boolean zChanged13 = gapComposer13.changed(function12) | gapComposer13.changed(libraryViewType2.ordinal());
                    Object objRememberedValue25 = gapComposer13.rememberedValue();
                    if (zChanged13 || objRememberedValue25 == neverEqualPolicy) {
                        libraryViewType = libraryViewType2;
                        b = 0;
                        objRememberedValue25 = new LibraryMixScreenKt$$ExternalSyntheticLambda56(function12, libraryViewType, (byte) 0);
                        gapComposer13.updateRememberedValue(objRememberedValue25);
                    } else {
                        b = 0;
                        libraryViewType = libraryViewType2;
                    }
                    CardKt.IconButton((Function0) objRememberedValue25, SizeKt.m151size3ABfNKs(OffsetKt.m139paddingqDBjuR0$default(companion9, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f3, CropImageView.DEFAULT_ASPECT_RATIO, 11), 40.0f), false, null, null, Expect_jvmKt.rememberComposableLambda(-1982603525, new LibraryMixScreenKt$$ExternalSyntheticLambda57(libraryViewType, b), gapComposer13), gapComposer13, 1572912, 60);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda6(Enum r1, boolean z, Function1 function1, Function1 function2, MutableState mutableState, Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = r1;
        this.f$6 = z;
        this.f$1 = function1;
        this.f$3 = function2;
        this.f$2 = mutableState;
        this.f$4 = obj;
        this.f$5 = obj2;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda6(List list, boolean z, Function0 function0, PlayerConnection playerConnection, Function0 function1, List list2, MutableState mutableState) {
        this.$r8$classId = (byte) 3;
        this.f$0 = list;
        this.f$6 = z;
        this.f$1 = function0;
        this.f$3 = playerConnection;
        this.f$4 = function1;
        this.f$5 = list2;
        this.f$2 = mutableState;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda6(Function0 function0, List list, Function1 function1, MutableState mutableState, Function1 function2, boolean z, Function1 function3) {
        this.$r8$classId = (byte) 1;
        this.f$0 = function0;
        this.f$1 = list;
        this.f$3 = function1;
        this.f$2 = mutableState;
        this.f$4 = function2;
        this.f$6 = z;
        this.f$5 = function3;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda6(CoroutineScope coroutineScope, MusicDatabase musicDatabase, MutableState mutableState, MediaMetadata mediaMetadata, Context context, SyncUtils syncUtils, boolean z) {
        this.$r8$classId = (byte) 0;
        this.f$0 = coroutineScope;
        this.f$1 = musicDatabase;
        this.f$2 = mutableState;
        this.f$3 = mediaMetadata;
        this.f$4 = context;
        this.f$5 = syncUtils;
        this.f$6 = z;
    }

    public /* synthetic */ QueueMenuKt$$ExternalSyntheticLambda6(boolean z, Function0 function0, PlayerConnection playerConnection, Playlist playlist, MutableState mutableState, Context context, State state) {
        this.$r8$classId = (byte) 2;
        this.f$6 = z;
        this.f$0 = function0;
        this.f$1 = playerConnection;
        this.f$3 = playlist;
        this.f$2 = mutableState;
        this.f$4 = context;
        this.f$5 = state;
    }
}
