package androidx.compose.material3;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableIntList;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda3;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.AspectRatioElement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import coil3.compose.AsyncImageKt;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda31;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.metrolist.music.constants.LibraryViewType;
import com.metrolist.music.constants.PlaylistSongSortType;
import com.metrolist.music.constants.PlaylistSortType;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.NewAction;
import com.metrolist.music.ui.component.SortHeaderKt$SortHeader$1$2$1;
import com.metrolist.music.ui.component.SortHeaderKt$SortHeader$1$5;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda37;
import com.metrolist.music.ui.menu.YouTubeArtistMenuKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda92;
import com.metrolist.music.ui.screens.AlbumScreenKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda56;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$$ExternalSyntheticLambda57;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.metrolist.music.ui.screens.library.VisiblePlaylistItem;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.ui.utils.YouTubeUtilsKt;
import com.metrolist.music.viewmodels.ArtistViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimePickerKt$$ExternalSyntheticLambda8 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda8(AnalogTimePickerState analogTimePickerState, TimePickerColors timePickerColors, FocusRequester focusRequester, FocusRequester focusRequester2, boolean z, FocusOwner focusOwner, FocusRequester focusRequester3, FocusRequester focusRequester4) {
        this.$r8$classId = (byte) 0;
        this.f$0 = analogTimePickerState;
        this.f$1 = timePickerColors;
        this.f$2 = focusRequester;
        this.f$3 = focusRequester2;
        this.f$4 = z;
        this.f$5 = focusOwner;
        this.f$6 = focusRequester3;
        this.f$7 = focusRequester4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v50 */
    /* JADX WARN: Type inference failed for: r10v51, types: [boolean, byte] */
    /* JADX WARN: Type inference failed for: r10v52 */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        final Function0 function0;
        boolean z;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        boolean z5;
        String str;
        long j;
        Modifier modifierM1481glassTintedFNF3uiM;
        boolean z6;
        BorderStroke borderStrokeM38BorderStrokecXLIe8U;
        final PlayerConnection playerConnection;
        boolean z7;
        Object obj4;
        boolean z8;
        BorderStroke borderStrokeM38BorderStrokecXLIe8U2;
        final ?? r10;
        BorderStroke borderStrokeM38BorderStrokecXLIe8U3;
        Brush solidColor;
        boolean z9;
        Modifier.Companion companion;
        GapComposer gapComposer;
        Modifier modifierM137paddingVpY3zN4$default;
        int i5;
        float f;
        int i6;
        int i7;
        LibraryViewType libraryViewType;
        byte b;
        byte b2 = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
        boolean z10 = this.f$4;
        Unit unit = Unit.INSTANCE;
        Object obj5 = this.f$5;
        Object obj6 = this.f$7;
        Object obj7 = this.f$6;
        Object obj8 = this.f$3;
        Object obj9 = this.f$2;
        Object obj10 = this.f$1;
        Object obj11 = this.f$0;
        switch (b2) {
            case 0:
                final AnalogTimePickerState analogTimePickerState = (AnalogTimePickerState) obj11;
                final TimePickerColors timePickerColors = (TimePickerColors) obj10;
                final FocusRequester focusRequester = (FocusRequester) obj9;
                final FocusRequester focusRequester2 = (FocusRequester) obj8;
                final FocusOwner focusOwner = (FocusOwner) obj5;
                final FocusRequester focusRequester3 = (FocusRequester) obj7;
                final FocusRequester focusRequester4 = (FocusRequester) obj6;
                final MutableIntList mutableIntList = (MutableIntList) obj;
                Composer composer = (Composer) obj2;
                ((Integer) obj3).getClass();
                MutableIntList mutableIntList2 = analogTimePickerState.state.mo241getSelectionyecRtBI() == 1 ? TimePickerKt.Minutes : TimePickerKt.Hours;
                TimePickerState timePickerState = analogTimePickerState.state;
                final boolean z11 = mutableIntList == mutableIntList2;
                final boolean z12 = timePickerState.mo241getSelectionyecRtBI() == 1;
                final boolean z13 = timePickerState.is24hour() && timePickerState.mo241getSelectionyecRtBI() == 0;
                Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion2, 256.0f);
                GapComposer gapComposer2 = (GapComposer) composer;
                Object objRememberedValue = gapComposer2.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 7);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierM151size3ABfNKs, false, (Function1) objRememberedValue);
                final boolean z14 = this.f$4;
                TimePickerKt.CircularLayout(modifierSemantics, 0.39453125f, Expect_jvmKt.rememberComposableLambda(-99063847, new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj12, Object obj13) {
                        Composer composer2 = (Composer) obj12;
                        int iIntValue = ((Integer) obj13).intValue();
                        GapComposer gapComposer3 = (GapComposer) composer2;
                        if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            Stack.CompositionLocalProvider(Fragment$5$$ExternalSyntheticOutline0.m(timePickerColors.clockDialContentColor, ContentColorKt.LocalContentColor), Expect_jvmKt.rememberComposableLambda(-596940007, new MainActivity$$ExternalSyntheticLambda31(mutableIntList, z13, analogTimePickerState, z12, focusRequester, focusRequester2, z14, focusOwner, z11, focusRequester3, focusRequester4), gapComposer3), gapComposer3, 56);
                        } else {
                            gapComposer3.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer2), gapComposer2, 384);
                return unit;
            case 1:
                final Artist artist = (Artist) obj11;
                final CoroutineScope coroutineScope = (CoroutineScope) obj10;
                final MusicDatabase musicDatabase = (MusicDatabase) obj9;
                final PlayerConnection playerConnection2 = (PlayerConnection) obj8;
                Function0 function1 = (Function0) obj7;
                State state = (State) obj6;
                Context context = (Context) obj5;
                Composer composer2 = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer2;
                if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer3.startReplaceGroup(-55659288);
                    ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                    if (z10) {
                        function0 = function1;
                        gapComposer3.startReplaceGroup(1989918785);
                        gapComposer3.end(false);
                    } else {
                        gapComposer3.startReplaceGroup(1986338099);
                        if (artist.songCount > 0) {
                            gapComposer3.startReplaceGroup(1986387389);
                            final byte b3 = 0;
                            function0 = function1;
                            listBuilderCreateListBuilder.add(new NewAction(AlbumMenuKt.f71lambda$1235480145, MathKt.stringResource(R.string.play, gapComposer3), Expect_jvmKt.rememberComposableLambda(-1513050959, new Function2() { // from class: com.metrolist.music.ui.menu.ArtistMenuKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj12, Object obj13) {
                                    byte b4 = b3;
                                    Unit unit2 = Unit.INSTANCE;
                                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                    Function0 function2 = function0;
                                    CoroutineScope coroutineScope2 = coroutineScope;
                                    switch (b4) {
                                        case 0:
                                            Composer composer3 = (Composer) obj12;
                                            int iIntValue2 = ((Integer) obj13).intValue();
                                            GapComposer gapComposer4 = (GapComposer) composer3;
                                            if (!gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                                gapComposer4.skipToGroupEnd();
                                            } else {
                                                MusicDatabase musicDatabase2 = musicDatabase;
                                                boolean zChangedInstance = gapComposer4.changedInstance(musicDatabase2);
                                                Artist artist2 = artist;
                                                boolean zChanged = zChangedInstance | gapComposer4.changed(artist2);
                                                PlayerConnection playerConnection3 = playerConnection2;
                                                boolean zChangedInstance2 = gapComposer4.changedInstance(playerConnection3) | zChanged;
                                                Object objRememberedValue2 = gapComposer4.rememberedValue();
                                                if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy2) {
                                                    ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1 artistMenuKt$ArtistMenu$1$1$1$1$1$1$1 = new ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1(playerConnection3, artist2, musicDatabase2, null, (byte) 0);
                                                    gapComposer4.updateRememberedValue(artistMenuKt$ArtistMenu$1$1$1$1$1$1$1);
                                                    objRememberedValue2 = artistMenuKt$ArtistMenu$1$1$1$1$1$1$1;
                                                }
                                                AwaitKt.launch$default(coroutineScope2, null, null, (Function2) objRememberedValue2, 3);
                                                function2.invoke();
                                            }
                                            break;
                                        default:
                                            Composer composer4 = (Composer) obj12;
                                            int iIntValue3 = ((Integer) obj13).intValue();
                                            GapComposer gapComposer5 = (GapComposer) composer4;
                                            if (!gapComposer5.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                                                gapComposer5.skipToGroupEnd();
                                            } else {
                                                MusicDatabase musicDatabase3 = musicDatabase;
                                                boolean zChangedInstance3 = gapComposer5.changedInstance(musicDatabase3);
                                                Artist artist3 = artist;
                                                boolean zChanged2 = zChangedInstance3 | gapComposer5.changed(artist3);
                                                PlayerConnection playerConnection4 = playerConnection2;
                                                boolean zChangedInstance4 = gapComposer5.changedInstance(playerConnection4) | zChanged2;
                                                Object objRememberedValue3 = gapComposer5.rememberedValue();
                                                if (zChangedInstance4 || objRememberedValue3 == neverEqualPolicy2) {
                                                    ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1 artistMenuKt$ArtistMenu$1$1$1$1$1$1$2 = new ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1(playerConnection4, artist3, musicDatabase3, null, (byte) 1);
                                                    gapComposer5.updateRememberedValue(artistMenuKt$ArtistMenu$1$1$1$1$1$1$2);
                                                    objRememberedValue3 = artistMenuKt$ArtistMenu$1$1$1$1$1$1$2;
                                                }
                                                AwaitKt.launch$default(coroutineScope2, null, null, (Function2) objRememberedValue3, 3);
                                                function2.invoke();
                                            }
                                            break;
                                    }
                                    return unit2;
                                }
                            }, gapComposer3)));
                            final byte b4 = 1;
                            listBuilderCreateListBuilder.add(new NewAction(AlbumMenuKt.lambda$329023768, MathKt.stringResource(R.string.shuffle, gapComposer3), Expect_jvmKt.rememberComposableLambda(-128556134, new Function2() { // from class: com.metrolist.music.ui.menu.ArtistMenuKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj12, Object obj13) {
                                    byte b5 = b4;
                                    Unit unit2 = Unit.INSTANCE;
                                    NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                    Function0 function2 = function0;
                                    CoroutineScope coroutineScope2 = coroutineScope;
                                    switch (b5) {
                                        case 0:
                                            Composer composer3 = (Composer) obj12;
                                            int iIntValue2 = ((Integer) obj13).intValue();
                                            GapComposer gapComposer4 = (GapComposer) composer3;
                                            if (!gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                                gapComposer4.skipToGroupEnd();
                                            } else {
                                                MusicDatabase musicDatabase2 = musicDatabase;
                                                boolean zChangedInstance = gapComposer4.changedInstance(musicDatabase2);
                                                Artist artist2 = artist;
                                                boolean zChanged = zChangedInstance | gapComposer4.changed(artist2);
                                                PlayerConnection playerConnection3 = playerConnection2;
                                                boolean zChangedInstance2 = gapComposer4.changedInstance(playerConnection3) | zChanged;
                                                Object objRememberedValue2 = gapComposer4.rememberedValue();
                                                if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy2) {
                                                    ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1 artistMenuKt$ArtistMenu$1$1$1$1$1$1$1 = new ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1(playerConnection3, artist2, musicDatabase2, null, (byte) 0);
                                                    gapComposer4.updateRememberedValue(artistMenuKt$ArtistMenu$1$1$1$1$1$1$1);
                                                    objRememberedValue2 = artistMenuKt$ArtistMenu$1$1$1$1$1$1$1;
                                                }
                                                AwaitKt.launch$default(coroutineScope2, null, null, (Function2) objRememberedValue2, 3);
                                                function2.invoke();
                                            }
                                            break;
                                        default:
                                            Composer composer4 = (Composer) obj12;
                                            int iIntValue3 = ((Integer) obj13).intValue();
                                            GapComposer gapComposer5 = (GapComposer) composer4;
                                            if (!gapComposer5.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                                                gapComposer5.skipToGroupEnd();
                                            } else {
                                                MusicDatabase musicDatabase3 = musicDatabase;
                                                boolean zChangedInstance3 = gapComposer5.changedInstance(musicDatabase3);
                                                Artist artist3 = artist;
                                                boolean zChanged2 = zChangedInstance3 | gapComposer5.changed(artist3);
                                                PlayerConnection playerConnection4 = playerConnection2;
                                                boolean zChangedInstance4 = gapComposer5.changedInstance(playerConnection4) | zChanged2;
                                                Object objRememberedValue3 = gapComposer5.rememberedValue();
                                                if (zChangedInstance4 || objRememberedValue3 == neverEqualPolicy2) {
                                                    ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1 artistMenuKt$ArtistMenu$1$1$1$1$1$1$2 = new ArtistMenuKt$ArtistMenu$1$1$1$1$1$1$1(playerConnection4, artist3, musicDatabase3, null, (byte) 1);
                                                    gapComposer5.updateRememberedValue(artistMenuKt$ArtistMenu$1$1$1$1$1$1$2);
                                                    objRememberedValue3 = artistMenuKt$ArtistMenu$1$1$1$1$1$1$2;
                                                }
                                                AwaitKt.launch$default(coroutineScope2, null, null, (Function2) objRememberedValue3, 3);
                                                function2.invoke();
                                            }
                                            break;
                                    }
                                    return unit2;
                                }
                            }, gapComposer3)));
                            z3 = false;
                            gapComposer3.end(false);
                        } else {
                            function0 = function1;
                            z3 = false;
                            gapComposer3.startReplaceGroup(1989896961);
                            gapComposer3.end(false);
                        }
                        gapComposer3.end(z3);
                    }
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(176953701, new ListItemKt$$ExternalSyntheticLambda11(state, (byte) 5), gapComposer3);
                    if (((Boolean) state.getValue()).booleanValue()) {
                        i = 618399007;
                        i2 = R.string.unpin;
                        z = false;
                    } else {
                        z = false;
                        i = 618400157;
                        i2 = R.string.pin;
                    }
                    listBuilderCreateListBuilder.add(new NewAction(composableLambdaImplRememberComposableLambda, Format$$ExternalSyntheticOutline0.m(gapComposer3, i, i2, gapComposer3, z), Expect_jvmKt.rememberComposableLambda(-1190737561, new PlayerKt$$ExternalSyntheticLambda92((Object) coroutineScope, state, (Object) musicDatabase, (Object) artist, (Object) function0, (byte) 3), gapComposer3)));
                    if (artist.artist.isYouTubeArtist()) {
                        gapComposer3.startReplaceGroup(1991714584);
                        listBuilderCreateListBuilder.add(new NewAction(AlbumMenuKt.f213lambda$482320557, MathKt.stringResource(R.string.share, gapComposer3), Expect_jvmKt.rememberComposableLambda(-1673978795, new MainActivity$$ExternalSyntheticLambda9((Object) function0, (Object) context, (Object) artist, (byte) 21), gapComposer3)));
                        z2 = false;
                        gapComposer3.end(false);
                    } else {
                        z2 = false;
                        gapComposer3.startReplaceGroup(1993045569);
                        gapComposer3.end(false);
                    }
                    ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                    gapComposer3.end(z2);
                    com.metrolist.music.ui.component.MenuKt.NewActionGrid(listBuilderBuild, OffsetKt.m136paddingVpY3zN4(companion2, 4.0f, 16.0f), z10 ? 1 : 3, gapComposer3, 48, 0);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 2:
                Song song = (Song) obj11;
                MutableState mutableState = (MutableState) obj10;
                MutableState mutableState2 = (MutableState) obj9;
                MutableState mutableState3 = (MutableState) obj8;
                MutableState mutableState4 = (MutableState) obj7;
                Function0 function2 = (Function0) obj6;
                Context context2 = (Context) obj5;
                Composer composer3 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer3;
                if (gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    com.metrolist.music.ui.component.MenuKt.NewActionGrid(CollectionsKt__IterablesKt.listOf((Object[]) new NewAction[]{new NewAction(AlbumMenuKt.f219lambda$517777381, MathKt.stringResource(R.string.edit, gapComposer4), Expect_jvmKt.rememberComposableLambda(283154333, new CrossfadeKt$$ExternalSyntheticLambda3(song, mutableState, mutableState2, mutableState3, (byte) 8), gapComposer4)), new NewAction(AlbumMenuKt.f154lambda$1937101412, MathKt.stringResource(R.string.add_to_playlist, gapComposer4), Expect_jvmKt.rememberComposableLambda(-1136169698, new SongMenuKt$$ExternalSyntheticLambda37(mutableState4, (byte) 0), gapComposer4)), new NewAction(AlbumMenuKt.lambda$938541853, MathKt.stringResource(R.string.share, gapComposer4), Expect_jvmKt.rememberComposableLambda(1739473567, new MainActivity$$ExternalSyntheticLambda9((Object) function2, (Object) context2, (Object) song, (byte) 28), gapComposer4))}), OffsetKt.m136paddingVpY3zN4(companion2, 4.0f, 16.0f), z10 ? 2 : 3, gapComposer4, 48, 0);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 3:
                ArtistItem artistItem = (ArtistItem) obj11;
                PlayerConnection playerConnection3 = (PlayerConnection) obj10;
                Function0 function3 = (Function0) obj9;
                State state2 = (State) obj8;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj7;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj6;
                Context context3 = (Context) obj5;
                Composer composer4 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer4;
                if (gapComposer5.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer5.startReplaceGroup(1849734880);
                    ListBuilder listBuilderCreateListBuilder2 = CollectionsKt__IterablesKt.createListBuilder();
                    if (z10) {
                        gapComposer5.startReplaceGroup(36281662);
                        gapComposer5.end(false);
                    } else {
                        gapComposer5.startReplaceGroup(-137408846);
                        WatchEndpoint watchEndpoint = artistItem.radioEndpoint;
                        if (watchEndpoint == null) {
                            gapComposer5.startReplaceGroup(35293071);
                            z5 = false;
                            gapComposer5.end(false);
                        } else {
                            z5 = false;
                            gapComposer5.startReplaceGroup(35293072);
                            listBuilderCreateListBuilder2.add(new NewAction(AlbumMenuKt.lambda$639453150, MathKt.stringResource(R.string.start_radio, gapComposer5), Expect_jvmKt.rememberComposableLambda(372045024, new YouTubeArtistMenuKt$$ExternalSyntheticLambda5(playerConnection3, watchEndpoint, function3, false ? 1 : 0), gapComposer5)));
                            gapComposer5.end(false);
                        }
                        gapComposer5.end(z5);
                    }
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(1468457792, new ListItemKt$$ExternalSyntheticLambda11(state2, (byte) 21), gapComposer5);
                    if (((Boolean) state2.getValue()).booleanValue()) {
                        i3 = -137358206;
                        i4 = R.string.unpin;
                        z4 = false;
                    } else {
                        z4 = false;
                        i3 = -137357056;
                        i4 = R.string.pin;
                    }
                    listBuilderCreateListBuilder2.add(new NewAction(composableLambdaImplRememberComposableLambda2, Format$$ExternalSyntheticOutline0.m(gapComposer5, i3, i4, gapComposer5, z4), Expect_jvmKt.rememberComposableLambda(-1362158594, new PlayerKt$$ExternalSyntheticLambda92((Object) coroutineScope2, state2, (Object) musicDatabase2, (Object) artistItem, (Object) function3, (byte) 6), gapComposer5)));
                    listBuilderCreateListBuilder2.add(new NewAction(AlbumMenuKt.f49lambda$1082511177, MathKt.stringResource(R.string.share, gapComposer5), Expect_jvmKt.rememberComposableLambda(1704407541, new AlbumScreenKt$$ExternalSyntheticLambda8((Object) context3, (Object) function3, (Object) artistItem, (byte) 1), gapComposer5)));
                    ListBuilder listBuilderBuild2 = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder2);
                    gapComposer5.end(false);
                    com.metrolist.music.ui.component.MenuKt.NewActionGrid(listBuilderBuild2, OffsetKt.m136paddingVpY3zN4(companion2, 4.0f, 16.0f), z10 ? 1 : 3, gapComposer5, 48, 0);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 4:
                ArtistPage artistPage = (ArtistPage) obj11;
                MutableState mutableState5 = (MutableState) obj10;
                String str2 = (String) obj9;
                final ArtistViewModel artistViewModel = (ArtistViewModel) obj8;
                State state3 = (State) obj7;
                MutableState mutableState6 = (MutableState) obj6;
                PlayerConnection playerConnection4 = (PlayerConnection) obj5;
                Composer composer5 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer5;
                if (gapComposer6.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    if (artistPage == null || (str = artistPage.artist.thumbnail) == null) {
                        Artist artist2 = (Artist) mutableState5.getValue();
                        str = artist2 != null ? artist2.artist.thumbnailUrl : null;
                    }
                    Modifier.Companion companion3 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(DialogKt.m1476riseInwH6b6FI$default(companion3, 0), 1.0f), 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 5);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer6, 0);
                    String str3 = str2;
                    int iHashCode = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer6, modifierM139paddingqDBjuR0$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer6.startReusableNode();
                    boolean z15 = gapComposer6.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (z15) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Stack.m390setimpl(gapComposer6, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer6, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer6);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    if (str != null) {
                        gapComposer6.startReplaceGroup(18595490);
                        String strResize = YouTubeUtilsKt.resize(str, 600, 600);
                        Modifier modifierM = Format$$ExternalSyntheticOutline0.m(24.0f, 8.0f, gapComposer6, SizeKt.fillMaxWidth(companion3, 1.0f).then(new AspectRatioElement(1.0f)));
                        if (UiStyleKt.isGlassStyle(gapComposer6)) {
                            gapComposer6.startReplaceGroup(1663185608);
                            solidColor = GlassComponentsKt.glassRim(gapComposer6);
                            z9 = false;
                            gapComposer6.end(false);
                        } else {
                            gapComposer6.startReplaceGroup(1663186162);
                            solidColor = new SolidColor(((MaterialTheme$Values) gapComposer6.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant);
                            z9 = false;
                            gapComposer6.end(false);
                        }
                        AsyncImageKt.m849AsyncImage10Xjiaw(strResize, ImageKt.m43borderziNgDLE(modifierM, 1.0f, solidColor, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(24.0f, 8.0f, gapComposer6))), ContentScale.Companion.Crop, gapComposer6, 1572912, 1976);
                        OffsetKt.Spacer(gapComposer6, SizeKt.m145height3ABfNKs(companion3, 20.0f));
                        gapComposer6.end(z9);
                    } else {
                        str3 = str3;
                        playerConnection4 = playerConnection4;
                        gapComposer6.startReplaceGroup(19366212);
                        gapComposer6.end(false);
                    }
                    DialogKt.m1469MicroLabelFNF3uiM(MathKt.stringResource(R.string.artists, gapComposer6), null, CardKt.getColorScheme(gapComposer6).primary, gapComposer6, 0, 2);
                    OffsetKt.Spacer(gapComposer6, SizeKt.m145height3ABfNKs(companion3, 4.0f));
                    TextKt.m352TextNvy7gAk(str3 == null ? "Unknown" : str3, OffsetKt.m139paddingqDBjuR0$default(companion3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 7), CardKt.getColorScheme(gapComposer6).onSurface, 0L, null, null, null, 0L, null, 0L, 2, false, 2, 0, CardKt.getTypography(gapComposer6).headlineLarge, gapComposer6, 48, 24960, 110584);
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion3, 1.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterVertically, gapComposer6, 54);
                    int iHashCode2 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierFillMaxWidth);
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer6, updater$$ExternalSyntheticLambda2, gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    if (((Boolean) state3.getValue()).booleanValue()) {
                        gapComposer6.startReplaceGroup(1367472216);
                        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer6));
                        if (UiStyleKt.isGlassStyle(gapComposer6)) {
                            gapComposer6.startReplaceGroup(-925712552);
                            borderStrokeM38BorderStrokecXLIe8U3 = new BorderStroke(1.0f, GlassComponentsKt.glassRim(gapComposer6));
                            r10 = 0;
                        } else {
                            r10 = 0;
                            gapComposer6.startReplaceGroup(-925711370);
                            borderStrokeM38BorderStrokecXLIe8U3 = ImageKt.m38BorderStrokecXLIe8U(CardKt.getColorScheme(gapComposer6).outlineVariant, 1.0f);
                        }
                        gapComposer6.end(r10);
                        BorderStroke borderStroke = borderStrokeM38BorderStrokecXLIe8U3;
                        Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(companion3, 44.0f);
                        boolean zChangedInstance = gapComposer6.changedInstance(artistViewModel);
                        Object objRememberedValue2 = gapComposer6.rememberedValue();
                        Object obj12 = objRememberedValue2;
                        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                            Function0 function4 = new Function0() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$$ExternalSyntheticLambda25
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b5 = r10;
                                    Unit unit2 = Unit.INSTANCE;
                                    ArtistViewModel artistViewModel2 = artistViewModel;
                                    switch (b5) {
                                        case 0:
                                            artistViewModel2.toggleChannelSubscription();
                                            break;
                                        default:
                                            artistViewModel2.toggleChannelSubscription();
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer6.updateRememberedValue(function4);
                            obj12 = function4;
                        }
                        CardKt.OutlinedButton((Function0) obj12, modifierM145height3ABfNKs, false, roundedCornerShapeM185RoundedCornerShape0680j_4, null, borderStroke, null, ArtistItemsScreenKt.lambda$185065037, gapComposer6, 805306416, 436);
                        gapComposer6.end(r10);
                    } else {
                        gapComposer6.startReplaceGroup(1368422335);
                        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer6));
                        PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                        if (UiStyleKt.isGlassStyle(gapComposer6)) {
                            gapComposer6.startReplaceGroup(-925677147);
                            gapComposer6.end(false);
                            j = 0;
                        } else {
                            gapComposer6.startReplaceGroup(-925675775);
                            j = CardKt.getColorScheme(gapComposer6).primary;
                            gapComposer6.end(false);
                        }
                        ButtonColors buttonColorsM247buttonColorsro_MJ88 = ButtonDefaults.m247buttonColorsro_MJ88(j, CardKt.getColorScheme(gapComposer6).onPrimary, 0L, gapComposer6, 12);
                        Modifier modifierM145height3ABfNKs2 = SizeKt.m145height3ABfNKs(companion3, 44.0f);
                        if (UiStyleKt.isGlassStyle(gapComposer6)) {
                            gapComposer6.startReplaceGroup(-925667745);
                            modifierM1481glassTintedFNF3uiM = GlassComponentsKt.m1481glassTintedFNF3uiM(companion3, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer6)), gapComposer6);
                            gapComposer6.end(false);
                        } else {
                            gapComposer6.startReplaceGroup(-925666398);
                            gapComposer6.end(false);
                            modifierM1481glassTintedFNF3uiM = companion3;
                        }
                        Modifier modifierThen = modifierM145height3ABfNKs2.then(modifierM1481glassTintedFNF3uiM);
                        boolean zChangedInstance2 = gapComposer6.changedInstance(artistViewModel);
                        Object objRememberedValue3 = gapComposer6.rememberedValue();
                        Object obj13 = objRememberedValue3;
                        if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                            final byte b5 = 1;
                            Function0 function5 = new Function0() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$$ExternalSyntheticLambda25
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b6 = b5;
                                    Unit unit2 = Unit.INSTANCE;
                                    ArtistViewModel artistViewModel2 = artistViewModel;
                                    switch (b6) {
                                        case 0:
                                            artistViewModel2.toggleChannelSubscription();
                                            break;
                                        default:
                                            artistViewModel2.toggleChannelSubscription();
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer6.updateRememberedValue(function5);
                            obj13 = function5;
                        }
                        CardKt.Button((Function0) obj13, modifierThen, false, roundedCornerShapeM185RoundedCornerShape0680j_5, buttonColorsM247buttonColorsro_MJ88, null, null, null, null, ArtistItemsScreenKt.lambda$327652006, gapComposer6, 805306368, 484);
                        gapComposer6.end(false);
                    }
                    if (ArtistScreenKt.ArtistScreen$lambda$14(mutableState6) || z10) {
                        gapComposer6.startReplaceGroup(1372473384);
                        gapComposer6.end(false);
                    } else {
                        gapComposer6.startReplaceGroup(1369684562);
                        final WatchEndpoint watchEndpoint2 = artistPage != null ? artistPage.artist.radioEndpoint : null;
                        if (watchEndpoint2 == null) {
                            gapComposer6.startReplaceGroup(1369710694);
                            z7 = false;
                            gapComposer6.end(false);
                            playerConnection = playerConnection4;
                        } else {
                            gapComposer6.startReplaceGroup(1369710695);
                            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_6 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer6));
                            if (UiStyleKt.isGlassStyle(gapComposer6)) {
                                gapComposer6.startReplaceGroup(90635751);
                                borderStrokeM38BorderStrokecXLIe8U = new BorderStroke(1.0f, GlassComponentsKt.glassRim(gapComposer6));
                                z6 = false;
                            } else {
                                z6 = false;
                                gapComposer6.startReplaceGroup(90636933);
                                borderStrokeM38BorderStrokecXLIe8U = ImageKt.m38BorderStrokecXLIe8U(CardKt.getColorScheme(gapComposer6).outlineVariant, 1.0f);
                            }
                            gapComposer6.end(z6);
                            BorderStroke borderStroke2 = borderStrokeM38BorderStrokecXLIe8U;
                            Modifier modifierM145height3ABfNKs3 = SizeKt.m145height3ABfNKs(companion3, 44.0f);
                            playerConnection = playerConnection4;
                            boolean zChangedInstance3 = gapComposer6.changedInstance(playerConnection) | gapComposer6.changedInstance(watchEndpoint2);
                            Object objRememberedValue4 = gapComposer6.rememberedValue();
                            if (zChangedInstance3 || objRememberedValue4 == neverEqualPolicy) {
                                z7 = false;
                                final boolean z16 = false ? 1 : 0;
                                Function0 function6 = new Function0() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$$ExternalSyntheticLambda27
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        byte b6 = z16;
                                        Unit unit2 = Unit.INSTANCE;
                                        WatchEndpoint watchEndpoint3 = watchEndpoint2;
                                        PlayerConnection playerConnection5 = playerConnection;
                                        switch (b6) {
                                            case 0:
                                                playerConnection5.playQueue(new YouTubeQueue(watchEndpoint3, null, 2, null));
                                                break;
                                            default:
                                                playerConnection5.playQueue(new YouTubeQueue(watchEndpoint3, null, 2, null));
                                                break;
                                        }
                                        return unit2;
                                    }
                                };
                                gapComposer6.updateRememberedValue(function6);
                                obj4 = function6;
                            } else {
                                z7 = false;
                                obj4 = objRememberedValue4;
                            }
                            CardKt.OutlinedButton((Function0) obj4, modifierM145height3ABfNKs3, false, roundedCornerShapeM185RoundedCornerShape0680j_6, null, borderStroke2, null, ArtistItemsScreenKt.lambda$1391529335, gapComposer6, 805306416, 436);
                            gapComposer6.end(z7);
                        }
                        final WatchEndpoint watchEndpoint3 = artistPage != null ? artistPage.artist.shuffleEndpoint : null;
                        if (watchEndpoint3 == null) {
                            gapComposer6.startReplaceGroup(1371295228);
                            gapComposer6.end(z7);
                        } else {
                            gapComposer6.startReplaceGroup(1371295229);
                            RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_7 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer6));
                            if (UiStyleKt.isGlassStyle(gapComposer6)) {
                                gapComposer6.startReplaceGroup(1468628688);
                                borderStrokeM38BorderStrokecXLIe8U2 = new BorderStroke(1.0f, GlassComponentsKt.glassRim(gapComposer6));
                                z8 = false;
                            } else {
                                z8 = false;
                                gapComposer6.startReplaceGroup(1468629870);
                                borderStrokeM38BorderStrokecXLIe8U2 = ImageKt.m38BorderStrokecXLIe8U(CardKt.getColorScheme(gapComposer6).outlineVariant, 1.0f);
                            }
                            gapComposer6.end(z8);
                            BorderStroke borderStroke3 = borderStrokeM38BorderStrokecXLIe8U2;
                            PaddingValuesImpl paddingValuesImpl2 = new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                            Modifier modifierM151size3ABfNKs2 = SizeKt.m151size3ABfNKs(companion3, 44.0f);
                            boolean zChangedInstance4 = gapComposer6.changedInstance(playerConnection) | gapComposer6.changedInstance(watchEndpoint3);
                            Object objRememberedValue5 = gapComposer6.rememberedValue();
                            Object obj14 = objRememberedValue5;
                            if (zChangedInstance4 || objRememberedValue5 == neverEqualPolicy) {
                                final byte b6 = 1;
                                Function0 function7 = new Function0() { // from class: com.metrolist.music.ui.screens.artist.ArtistScreenKt$$ExternalSyntheticLambda27
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        byte b7 = b6;
                                        Unit unit2 = Unit.INSTANCE;
                                        WatchEndpoint watchEndpoint4 = watchEndpoint3;
                                        PlayerConnection playerConnection5 = playerConnection;
                                        switch (b7) {
                                            case 0:
                                                playerConnection5.playQueue(new YouTubeQueue(watchEndpoint4, null, 2, null));
                                                break;
                                            default:
                                                playerConnection5.playQueue(new YouTubeQueue(watchEndpoint4, null, 2, null));
                                                break;
                                        }
                                        return unit2;
                                    }
                                };
                                gapComposer6.updateRememberedValue(function7);
                                obj14 = function7;
                            }
                            CardKt.OutlinedButton((Function0) obj14, modifierM151size3ABfNKs2, false, roundedCornerShapeM185RoundedCornerShape0680j_7, null, borderStroke3, paddingValuesImpl2, ArtistItemsScreenKt.lambda$1998895264, gapComposer6, 817889328, 308);
                            z7 = false;
                            gapComposer6.end(false);
                        }
                        gapComposer6.end(z7);
                    }
                    gapComposer6.end(true);
                    gapComposer6.end(true);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            default:
                PlaylistSortType playlistSortType = (PlaylistSortType) obj11;
                Function1 function8 = (Function1) obj10;
                Function1 function9 = (Function1) obj9;
                List list = (List) obj8;
                MutableState mutableState7 = (MutableState) obj7;
                Function1 function10 = (Function1) obj6;
                LibraryViewType libraryViewType2 = (LibraryViewType) obj5;
                RowScope rowScope = (RowScope) obj;
                Composer composer6 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                rowScope.getClass();
                if ((iIntValue5 & 6) == 0) {
                    iIntValue5 |= ((GapComposer) composer6).changed(rowScope) ? 4 : 2;
                }
                GapComposer gapComposer7 = (GapComposer) composer6;
                if (gapComposer7.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                    Object objRememberedValue6 = gapComposer7.rememberedValue();
                    if (objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer7.updateRememberedValue(objRememberedValue6);
                    }
                    MutableState mutableState8 = (MutableState) objRememberedValue6;
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Modifier.Companion companion4 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(companion4, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
                    if (UiStyleKt.isGlassStyle(gapComposer7)) {
                        gapComposer7.startReplaceGroup(-2138758585);
                        companion = companion4;
                        gapComposer = gapComposer7;
                        modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(GlassComponentsKt.glass(companion, RoundedCornerShapeKt.RoundedCornerShape(50), false, gapComposer7, 6, 2), 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                        gapComposer.end(false);
                    } else {
                        companion = companion4;
                        gapComposer = gapComposer7;
                        gapComposer.startReplaceGroup(-2138602190);
                        gapComposer.end(false);
                        modifierM137paddingVpY3zN4$default = companion;
                    }
                    Modifier modifierThen2 = modifierM137paddingVpY3zN4$default2.then(modifierM137paddingVpY3zN4$default);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 48);
                    int iHashCode3 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
                    int iOrdinal = playlistSortType.ordinal();
                    if (iOrdinal == 0) {
                        i5 = R.string.sort_by_create_date;
                    } else if (iOrdinal == 1) {
                        i5 = R.string.sort_by_name;
                    } else if (iOrdinal == 2) {
                        i5 = R.string.sort_by_song_count;
                    } else {
                        if (iOrdinal != 3) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i5 = R.string.sort_by_last_updated;
                    }
                    String upperCase = MathKt.stringResource(i5, gapComposer).toUpperCase(Locale.ROOT);
                    upperCase.getClass();
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    long j2 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.labelMedium;
                    FontWeight fontWeight = UiStyleKt.isGlassStyle(gapComposer) ? FontWeight.Bold : null;
                    Object objRememberedValue7 = gapComposer.rememberedValue();
                    if (objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue7;
                    RippleNodeFactory rippleNodeFactoryM313rippleOu1YvPQ$default = RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, null, 254);
                    Object objRememberedValue8 = gapComposer.rememberedValue();
                    if (objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new SortHeaderKt$SortHeader$1$2$1(mutableState8, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue8);
                    }
                    GapComposer gapComposer8 = gapComposer;
                    Modifier.Companion companion5 = companion;
                    TextKt.m352TextNvy7gAk(upperCase, OffsetKt.m136paddingVpY3zN4(ImageKt.m45clickableO2vRcR0$default(companion, mutableInteractionSourceImpl, rippleNodeFactoryM313rippleOu1YvPQ$default, false, null, (Function0) objRememberedValue8, 28), 4.0f, 8.0f), j2, 0L, null, fontWeight, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer8, 0, 0, 131000);
                    boolean zM1492SortHeader$lambda1 = com.metrolist.music.ui.component.MenuKt.m1492SortHeader$lambda1(mutableState8);
                    Object objRememberedValue9 = gapComposer8.rememberedValue();
                    if (objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new SortHeaderKt$SortHeader$1$2$1(mutableState8, (byte) 1);
                        gapComposer8.updateRememberedValue(objRememberedValue9);
                    }
                    CardKt.m256DropdownMenuIlH_yew(zM1492SortHeader$lambda1, (Function0) objRememberedValue9, SizeKt.m157widthInVpY3zN4$default(companion5, 172.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, null, null, null, 0L, CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(-1229424361, new LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1((byte) 4, mutableState8, playlistSortType, function8), gapComposer8), gapComposer8, 432, 2040);
                    if (playlistSortType != PlaylistSongSortType.CUSTOM) {
                        gapComposer8.startReplaceGroup(-413182842);
                        f = 8.0f;
                        com.metrolist.music.ui.component.MenuKt.m1491ResizableIconButtonFU0evQE(z10 ? R.drawable.arrow_downward : R.drawable.arrow_upward, OffsetKt.m135padding3ABfNKs(SizeKt.m151size3ABfNKs(companion5, 32.0f), 8.0f), ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal)).colorScheme.primary, false, new SortHeaderKt$SortHeader$1$5(function9, z10), gapComposer8, 48);
                        gapComposer8.end(false);
                    } else {
                        f = 8.0f;
                        gapComposer8.startReplaceGroup(-412803898);
                        gapComposer8.end(false);
                    }
                    gapComposer8.end(true);
                    OffsetKt.Spacer(gapComposer8, rowScope.weight(companion5, 1.0f, true));
                    if (list == null || !list.isEmpty()) {
                        Iterator it = list.iterator();
                        i6 = 0;
                        while (it.hasNext()) {
                            if (!((VisiblePlaylistItem) it.next()).autoPlaylist && (i6 = i6 + 1) < 0) {
                                CollectionsKt__IterablesKt.throwCountOverflow();
                                throw null;
                            }
                        }
                    } else {
                        i6 = 0;
                    }
                    if (list == null || !list.isEmpty()) {
                        Iterator it2 = list.iterator();
                        i7 = 0;
                        while (it2.hasNext()) {
                            if (!((VisiblePlaylistItem) it2.next()).autoPlaylist && (i7 = i7 + 1) < 0) {
                                CollectionsKt__IterablesKt.throwCountOverflow();
                                throw null;
                            }
                        }
                    } else {
                        i7 = 0;
                    }
                    String strPluralStringResource = MathKt.pluralStringResource(R.plurals.n_playlist, i6, new Object[]{Integer.valueOf(i7)}, gapComposer8);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strPluralStringResource, null, ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal2)).typography.titleSmall, gapComposer8, 0, 0, 131066);
                    boolean zChanged = gapComposer8.changed(mutableState7);
                    Object objRememberedValue10 = gapComposer8.rememberedValue();
                    if (zChanged || objRememberedValue10 == neverEqualPolicy) {
                        objRememberedValue10 = new PlayerKt$$ExternalSyntheticLambda7(mutableState7, (byte) 28);
                        gapComposer8.updateRememberedValue(objRememberedValue10);
                    }
                    CardKt.IconButton((Function0) objRememberedValue10, SizeKt.m151size3ABfNKs(OffsetKt.m139paddingqDBjuR0$default(companion5, f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14), 40.0f), false, null, null, LibraryScreenKt.f373lambda$1801157478, gapComposer8, 1572912, 60);
                    boolean zChanged2 = gapComposer8.changed(function10) | gapComposer8.changed(libraryViewType2.ordinal());
                    Object objRememberedValue11 = gapComposer8.rememberedValue();
                    if (zChanged2 || objRememberedValue11 == neverEqualPolicy) {
                        libraryViewType = libraryViewType2;
                        b = 1;
                        objRememberedValue11 = new LibraryMixScreenKt$$ExternalSyntheticLambda56(function10, libraryViewType, (byte) 1);
                        gapComposer8.updateRememberedValue(objRememberedValue11);
                    } else {
                        libraryViewType = libraryViewType2;
                        b = 1;
                    }
                    CardKt.IconButton((Function0) objRememberedValue11, SizeKt.m151size3ABfNKs(OffsetKt.m139paddingqDBjuR0$default(companion5, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, CropImageView.DEFAULT_ASPECT_RATIO, 11), 40.0f), false, null, null, Expect_jvmKt.rememberComposableLambda(-355196669, new LibraryMixScreenKt$$ExternalSyntheticLambda57(libraryViewType, b), gapComposer8), gapComposer8, 1572912, 60);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda8(ArtistPage artistPage, MutableState mutableState, String str, ArtistViewModel artistViewModel, boolean z, State state, MutableState mutableState2, PlayerConnection playerConnection) {
        this.$r8$classId = (byte) 4;
        this.f$0 = artistPage;
        this.f$1 = mutableState;
        this.f$2 = str;
        this.f$3 = artistViewModel;
        this.f$4 = z;
        this.f$6 = state;
        this.f$7 = mutableState2;
        this.f$5 = playerConnection;
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda8(PlaylistSortType playlistSortType, boolean z, Function1 function1, Function1 function2, List list, MutableState mutableState, Function1 function3, LibraryViewType libraryViewType) {
        this.$r8$classId = (byte) 5;
        this.f$0 = playlistSortType;
        this.f$4 = z;
        this.f$1 = function1;
        this.f$2 = function2;
        this.f$3 = list;
        this.f$6 = mutableState;
        this.f$7 = function3;
        this.f$5 = libraryViewType;
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda8(boolean z, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Context context, byte b) {
        this.$r8$classId = b;
        this.f$4 = z;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$6 = obj5;
        this.f$7 = obj6;
        this.f$5 = context;
    }
}
