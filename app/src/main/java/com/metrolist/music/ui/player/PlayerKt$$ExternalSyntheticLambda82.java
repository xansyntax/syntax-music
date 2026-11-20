package com.metrolist.music.ui.player;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda11;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TimePickerState;
import androidx.compose.material3.carousel.CarouselItemScopeImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.ArtistSection;
import com.metrolist.innertube.pages.HomePage;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda2;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda21;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda59;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda6;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.models.SimilarRecommendation;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda6;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.screens.LoginScreenKt$LoginScreen$1$3$2$1;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.metrolist.music.ui.screens.recognition.RecognitionHistoryScreenKt;
import com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.screens.settings.AiSettingsKt$$ExternalSyntheticLambda3;
import com.metrolist.music.ui.screens.settings.ContentSettingsKt$$ExternalSyntheticLambda110;
import com.metrolist.music.ui.screens.settings.PlayerSettingsKt$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.screens.settings.StorageSettingsKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.metrolist.music.utils.InnerTubeXPlayer$$ExternalSyntheticLambda3;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.ArtistViewModel;
import com.metrolist.music.viewmodels.HomeViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannelKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.selects.SelectImplementation;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda82 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda82(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$ContentSettingsKt$$ExternalSyntheticLambda89(Object obj, Object obj2, Object obj3) {
        Proxy.Type type = (Proxy.Type) this.f$0;
        MutableState mutableState = (MutableState) this.f$1;
        Function1 function1 = (Function1) this.f$2;
        ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 = (ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) obj;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1.getClass();
        if ((iIntValue & 6) == 0) {
            iIntValue |= (iIntValue & 8) == 0 ? ((GapComposer) composer).changed(exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) : ((GapComposer) composer).changedInstance(exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) ? 4 : 2;
        }
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
            String strName = type.name();
            long value = ColorSchemeKt.getValue(17, gapComposer);
            long value2 = ColorSchemeKt.getValue(17, gapComposer);
            long value3 = ColorSchemeKt.getValue(17, gapComposer);
            long jColor = ColorKt.Color(Color.m485getRedimpl(value3), Color.m484getGreenimpl(value3), Color.m482getBlueimpl(value3), 0.38f, Color.m483getColorSpaceimpl(value3));
            long value4 = ColorSchemeKt.getValue(17, gapComposer);
            long value5 = ColorSchemeKt.getValue(25, gapComposer);
            long value6 = ColorSchemeKt.getValue(1, gapComposer);
            TextSelectionColors textSelectionColors = (TextSelectionColors) gapComposer.consume(TextSelectionColorsKt.LocalTextSelectionColors);
            long value7 = ColorSchemeKt.getValue(25, gapComposer);
            long value8 = ColorSchemeKt.getValue(23, gapComposer);
            long value9 = ColorSchemeKt.getValue(17, gapComposer);
            long jColor2 = ColorKt.Color(Color.m485getRedimpl(value9), Color.m484getGreenimpl(value9), Color.m482getBlueimpl(value9), 0.12f, Color.m483getColorSpaceimpl(value9));
            long value10 = ColorSchemeKt.getValue(1, gapComposer);
            long value11 = ColorSchemeKt.getValue(18, gapComposer);
            long value12 = ColorSchemeKt.getValue(18, gapComposer);
            long value13 = ColorSchemeKt.getValue(17, gapComposer);
            long jColor3 = ColorKt.Color(Color.m485getRedimpl(value13), Color.m484getGreenimpl(value13), Color.m482getBlueimpl(value13), 0.38f, Color.m483getColorSpaceimpl(value13));
            long value14 = ColorSchemeKt.getValue(18, gapComposer);
            long value15 = ColorSchemeKt.getValue(18, gapComposer);
            long value16 = ColorSchemeKt.getValue(18, gapComposer);
            long value17 = ColorSchemeKt.getValue(17, gapComposer);
            long jColor4 = ColorKt.Color(Color.m485getRedimpl(value17), Color.m484getGreenimpl(value17), Color.m482getBlueimpl(value17), 0.38f, Color.m483getColorSpaceimpl(value17));
            long value18 = ColorSchemeKt.getValue(1, gapComposer);
            long value19 = ColorSchemeKt.getValue(25, gapComposer);
            long value20 = ColorSchemeKt.getValue(18, gapComposer);
            long value21 = ColorSchemeKt.getValue(17, gapComposer);
            long jColor5 = ColorKt.Color(Color.m485getRedimpl(value21), Color.m484getGreenimpl(value21), Color.m482getBlueimpl(value21), 0.38f, Color.m483getColorSpaceimpl(value21));
            long value22 = ColorSchemeKt.getValue(1, gapComposer);
            long value23 = ColorSchemeKt.getValue(18, gapComposer);
            long value24 = ColorSchemeKt.getValue(18, gapComposer);
            long value25 = ColorSchemeKt.getValue(17, gapComposer);
            long jColor6 = ColorKt.Color(Color.m485getRedimpl(value25), Color.m484getGreenimpl(value25), Color.m482getBlueimpl(value25), 0.38f, Color.m483getColorSpaceimpl(value25));
            long value26 = ColorSchemeKt.getValue(18, gapComposer);
            long value27 = ColorSchemeKt.getValue(18, gapComposer);
            long value28 = ColorSchemeKt.getValue(18, gapComposer);
            long value29 = ColorSchemeKt.getValue(17, gapComposer);
            long jColor7 = ColorKt.Color(Color.m485getRedimpl(value29), Color.m484getGreenimpl(value29), Color.m482getBlueimpl(value29), 0.38f, Color.m483getColorSpaceimpl(value29));
            long value30 = ColorSchemeKt.getValue(18, gapComposer);
            long value31 = ColorSchemeKt.getValue(18, gapComposer);
            long value32 = ColorSchemeKt.getValue(18, gapComposer);
            long value33 = ColorSchemeKt.getValue(17, gapComposer);
            TextFieldColors textFieldColorsM347colors0hiis_0 = TextFieldDefaults.m347colors0hiis_0(value, value2, jColor, value4, 0L, 0L, value5, value6, textSelectionColors, value7, value8, jColor2, value10, value11, value12, jColor3, value14, value15, value16, jColor4, value18, value19, value20, jColor5, value22, value23, value24, jColor6, value26, value27, value28, jColor7, value30, value31, value32, ColorKt.Color(Color.m485getRedimpl(value33), Color.m484getGreenimpl(value33), Color.m482getBlueimpl(value33), 0.38f, Color.m483getColorSpaceimpl(value33)), ColorSchemeKt.getValue(18, gapComposer), gapComposer, 3072, 0, 15);
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1.m286menuAnchor2Hz36ac$default(exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1), 1.0f);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 12);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            ScrimKt.OutlinedTextField(strName, (Function1) objRememberedValue, modifierFillMaxWidth, false, true, null, AiSettingsKt.f455lambda$1221693852, null, null, Expect_jvmKt.rememberComposableLambda(1752655553, new StorageSettingsKt$$ExternalSyntheticLambda8(mutableState, (byte) 2), gapComposer), null, null, null, null, false, 0, 0, null, textFieldColorsM347colors0hiis_0, gapComposer, 806903856, 0, 4193704);
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new PlayerSettingsKt$$ExternalSyntheticLambda0(mutableState, (byte) 6);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            CardKt.m257ExposedDropdownMenukbRbctU(exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1, zBooleanValue, (Function0) objRememberedValue2, null, null, false, null, 0L, CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(1646985992, new ContentSettingsKt$$ExternalSyntheticLambda110(function1, mutableState, (byte) 0), gapComposer), gapComposer, 384 | (iIntValue & 14));
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$integrations$ListenTogetherSettingsKt$$ExternalSyntheticLambda54(Object obj, Object obj2, Object obj3) {
        Set set = (Set) this.f$0;
        LazyListState lazyListState = (LazyListState) this.f$1;
        Function1 function1 = (Function1) this.f$2;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((ColumnScopeInstance) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 280.0f);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM145height3ABfNKs);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            if (set.isEmpty()) {
                gapComposer.startReplaceGroup(-812107395);
                FillElement fillElement = SizeKt.FillWholeMaxSize;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, fillElement);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.listen_together_no_blocked_users, gapComposer), null, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262138);
                gapComposer.end(true);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-811636784);
                FillElement fillElement2 = SizeKt.FillWholeMaxSize;
                Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
                boolean zChangedInstance = gapComposer.changedInstance(set) | gapComposer.changed(function1);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = new SongMenuKt$$ExternalSyntheticLambda4((Object) set, (Object) function1, (byte) 29);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                IntMath.LazyColumn(fillElement2, lazyListState, null, arrangement$SpacedAligned, null, null, false, null, (Function1) objRememberedValue, gapComposer, 24582, 492);
                gapComposer.end(false);
            }
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v22, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v27, types: [java.util.ArrayList] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
        ?? arrayList;
        List<HomePage.Chip> list;
        Function0 function0;
        String str;
        SongEntity songEntity;
        String str2;
        String str3;
        byte b = this.$r8$classId;
        byte b2 = 9;
        byte b3 = 22;
        byte b4 = 18;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        byte b5 = 2;
        byte b6 = 14;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.f$2;
        Object obj5 = this.f$1;
        Object obj6 = this.f$0;
        switch (b) {
            case 0:
                ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = (ParcelableSnapshotMutableLongState) obj6;
                ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2 = (ParcelableSnapshotMutableLongState) obj5;
                BottomSheetState bottomSheetState = (BottomSheetState) obj4;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((BoxScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    boolean zChanged = gapComposer.changed(bottomSheetState);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new PlayerKt$$ExternalSyntheticLambda0(bottomSheetState, (byte) 7);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    QueueKt.MiniPlayer(parcelableSnapshotMutableLongState, parcelableSnapshotMutableLongState2, null, (Function0) objRememberedValue, gapComposer, 54);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                AndroidPath androidPath = (AndroidPath) obj;
                Rect rectIntersect = ((CarouselItemScopeImpl) obj6).itemInfo.getMaskRect().intersect(IntMath.m896Recttz77jQw(0L, ((Size) obj2).packedValue));
                ColorKt.addOutline(androidPath, ((RoundedCornerShape) obj5).mo56createOutlinePq9zytI(rectIntersect.m444getSizeNHjbRc(), (LayoutDirection) obj3, (Density) obj4));
                androidPath.m472translatek4lQ0M((((long) Float.floatToRawIntBits(rectIntersect.left)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(rectIntersect.top))));
                return unit;
            case 2:
                Integer num = (Integer) obj6;
                YTItem yTItem = (YTItem) obj5;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj4;
                RowScope rowScope = (RowScope) obj;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                rowScope.getClass();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= ((GapComposer) composer2).changed(rowScope) ? 4 : 2;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    if (num == null || !(yTItem instanceof SongItem)) {
                        gapComposer2.startReplaceGroup(-1935607999);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(-1935899740);
                        Integer num2 = ((SongItem) yTItem).duration;
                        String strMakeTimeString = UtilsKt.makeTimeString(num2 != null ? Long.valueOf(((long) num2.intValue()) * 1000) : null);
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                        TextKt.m352TextNvy7gAk(strMakeTimeString, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer2, 0, 24576, 114682);
                        gapComposer2.end(false);
                    }
                    composableLambdaImpl.invoke(rowScope, gapComposer2, Integer.valueOf(iIntValue2 & 14));
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 3:
                Integer num3 = (Integer) obj6;
                Song song = (Song) obj5;
                Function3 function3 = (Function3) obj4;
                RowScope rowScope2 = (RowScope) obj;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                rowScope2.getClass();
                if (num3 != null) {
                    GapComposer gapComposer3 = (GapComposer) composer3;
                    gapComposer3.startReplaceGroup(1604846059);
                    String strMakeTimeString2 = UtilsKt.makeTimeString(Long.valueOf(((long) song.song.duration) * 1000));
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strMakeTimeString2, null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 1, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal2)).typography.bodySmall, gapComposer3, 0, 24576, 114682);
                    gapComposer3.end(false);
                } else {
                    GapComposer gapComposer4 = (GapComposer) composer3;
                    gapComposer4.startReplaceGroup(1605142636);
                    gapComposer4.end(false);
                }
                function3.invoke(rowScope2, composer3, Integer.valueOf(iIntValue3 & 14));
                return unit;
            case 4:
                Function0 function1 = (Function0) obj6;
                TimePickerState timePickerState = (TimePickerState) obj5;
                Function1 function2 = (Function1) obj4;
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer4;
                if (gapComposer5.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    CardKt.TextButton(function1, null, false, null, null, null, DialogKt.f16lambda$1295239762, gapComposer5, 805306368, 510);
                    boolean zChangedInstance = gapComposer5.changedInstance(timePickerState) | gapComposer5.changed(function2);
                    Object objRememberedValue2 = gapComposer5.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) timePickerState, (Object) function2, (byte) 13);
                        gapComposer5.updateRememberedValue(objRememberedValue2);
                    }
                    CardKt.Button((Function0) objRememberedValue2, null, false, null, null, null, null, null, null, DialogKt.lambda$1716948769, gapComposer5, 805306368, 510);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 5:
                Album album = (Album) obj6;
                Context context = (Context) obj5;
                MutableState mutableState = (MutableState) obj4;
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer5;
                if (gapComposer6.shouldExecute(1 & iIntValue5, (iIntValue5 & 17) != 16)) {
                    Object objRememberedValue3 = gapComposer6.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer6.updateRememberedValue(objRememberedValue3);
                    }
                    MutableState mutableState2 = (MutableState) objRememberedValue3;
                    ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.f271lambda$881023849;
                    ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.f178lambda$222640970;
                    Object objRememberedValue4 = gapComposer6.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState2, (byte) 16);
                        gapComposer6.updateRememberedValue(objRememberedValue4);
                    }
                    MenuKt.Material3MenuGroup(CollectionsKt__IterablesKt.listOf(new Material3MenuItemData(composableLambdaImpl2, composableLambdaImpl3, null, (Function0) objRememberedValue4, null, null, 52)), gapComposer6, 0);
                    String strStringResource = MathKt.stringResource(R.string.export_playlist, gapComposer6);
                    if (((Boolean) mutableState2.getValue()).booleanValue()) {
                        gapComposer6.startReplaceGroup(1239471317);
                        Object objRememberedValue5 = gapComposer6.rememberedValue();
                        if (objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState2, (byte) 17);
                            gapComposer6.updateRememberedValue(objRememberedValue5);
                        }
                        Function0 function4 = (Function0) objRememberedValue5;
                        boolean zChanged2 = gapComposer6.changed(album) | gapComposer6.changedInstance(context) | gapComposer6.changed(strStringResource);
                        Object objRememberedValue6 = gapComposer6.rememberedValue();
                        if (zChanged2 || objRememberedValue6 == neverEqualPolicy) {
                            AlbumMenuKt$$ExternalSyntheticLambda40 albumMenuKt$$ExternalSyntheticLambda40 = new AlbumMenuKt$$ExternalSyntheticLambda40((Object) context, (Object) album, mutableState, strStringResource, (Object) mutableState2, (byte) 0);
                            mutableState2 = mutableState2;
                            gapComposer6.updateRememberedValue(albumMenuKt$$ExternalSyntheticLambda40);
                            objRememberedValue6 = albumMenuKt$$ExternalSyntheticLambda40;
                        }
                        Function1 function5 = (Function1) objRememberedValue6;
                        boolean zChanged3 = gapComposer6.changed(album) | gapComposer6.changedInstance(context);
                        Object objRememberedValue7 = gapComposer6.rememberedValue();
                        if (zChanged3 || objRememberedValue7 == neverEqualPolicy) {
                            objRememberedValue7 = new MainActivity$$ExternalSyntheticLambda59((Object) context, (Object) album, (Object) mutableState, (Object) mutableState2, (byte) 13);
                            gapComposer6.updateRememberedValue(objRememberedValue7);
                        }
                        AlbumMenuKt.ExportDialog(function4, null, function5, (Function1) objRememberedValue7, gapComposer6, 6);
                        gapComposer6.end(false);
                    } else {
                        gapComposer6.startReplaceGroup(1243495985);
                        gapComposer6.end(false);
                    }
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 6:
                Playlist playlist = (Playlist) obj6;
                MusicDatabase musicDatabase = (MusicDatabase) obj5;
                State state = (State) obj4;
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer6;
                if (!gapComposer7.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    gapComposer7.skipToGroupEnd();
                } else if (!playlist.playlist.isEditable) {
                    gapComposer7.startReplaceGroup(-2010877183);
                    boolean zChangedInstance2 = gapComposer7.changedInstance(musicDatabase) | gapComposer7.changed(state);
                    Object objRememberedValue8 = gapComposer7.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) musicDatabase, (Object) state, (byte) 21);
                        gapComposer7.updateRememberedValue(objRememberedValue8);
                    }
                    CardKt.IconButton((Function0) objRememberedValue8, null, false, null, null, Expect_jvmKt.rememberComposableLambda(339985751, new ListItemKt$$ExternalSyntheticLambda11(state, (byte) 11), gapComposer7), gapComposer7, 1572864, 62);
                    gapComposer7.end(false);
                } else {
                    gapComposer7.startReplaceGroup(-2009723022);
                    gapComposer7.end(false);
                }
                return unit;
            case 7:
                MusicDatabase musicDatabase2 = (MusicDatabase) obj6;
                State state2 = (State) obj5;
                ArtistItem artistItem = (ArtistItem) obj4;
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer7;
                if (gapComposer8.shouldExecute(1 & iIntValue7, (iIntValue7 & 17) != 16)) {
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(-1185406260, new ListItemKt$$ExternalSyntheticLambda11(state2, b3), gapComposer8);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(643800077, new ListItemKt$$ExternalSyntheticLambda11(state2, (byte) 20), gapComposer8);
                    boolean zChangedInstance3 = gapComposer8.changedInstance(musicDatabase2) | gapComposer8.changed(state2) | gapComposer8.changedInstance(artistItem);
                    Object objRememberedValue9 = gapComposer8.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new GapComposer$$ExternalSyntheticLambda0(musicDatabase2, artistItem, state2, (byte) 27);
                        gapComposer8.updateRememberedValue(objRememberedValue9);
                    }
                    MenuKt.Material3MenuGroup(CollectionsKt__IterablesKt.listOf(new Material3MenuItemData(composableLambdaImplRememberComposableLambda, composableLambdaImplRememberComposableLambda2, null, (Function0) objRememberedValue9, null, null, 52)), gapComposer8, 0);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 8:
                LocalItem localItem = (LocalItem) obj6;
                CoroutineScope coroutineScope = (CoroutineScope) obj5;
                MenuState menuState = (MenuState) obj4;
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer8;
                if (gapComposer9.shouldExecute(1 & iIntValue8, (iIntValue8 & 17) != 16)) {
                    Artist artist = (Artist) localItem;
                    boolean zChanged4 = gapComposer9.changed(menuState);
                    Object objRememberedValue10 = gapComposer9.rememberedValue();
                    if (zChanged4 || objRememberedValue10 == neverEqualPolicy) {
                        objRememberedValue10 = new LoginScreenKt$LoginScreen$1$3$2$1(0, menuState, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 3);
                        gapComposer9.updateRememberedValue(objRememberedValue10);
                    }
                    AlbumMenuKt.ArtistMenu(artist, coroutineScope, (Function0) ((KFunction) objRememberedValue10), gapComposer9, 0);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 9:
                HomeViewModel homeViewModel = (HomeViewModel) obj6;
                MutableState mutableState3 = (MutableState) obj5;
                MutableState mutableState4 = (MutableState) obj4;
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer9;
                if (gapComposer10.shouldExecute(1 & iIntValue9, (iIntValue9 & 17) != 16)) {
                    Modifier modifierM1476riseInwH6b6FI$default = DialogKt.m1476riseInwH6b6FI$default(companion, 0);
                    HomePage homePage = (HomePage) mutableState3.getValue();
                    if (homePage == null || (list = homePage.chips) == null) {
                        arrayList = EmptyList.INSTANCE;
                    } else {
                        arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                        for (HomePage.Chip chip : list) {
                            arrayList.add(new Pair(chip, chip.title));
                        }
                    }
                    ?? r19 = arrayList;
                    HomePage.Chip chip2 = (HomePage.Chip) mutableState4.getValue();
                    boolean zChangedInstance4 = gapComposer10.changedInstance(homeViewModel);
                    Object objRememberedValue11 = gapComposer10.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue11 == neverEqualPolicy) {
                        objRememberedValue11 = new MimesKt$$ExternalSyntheticLambda0((byte) 9, homeViewModel);
                        gapComposer10.updateRememberedValue(objRememberedValue11);
                    }
                    DialogKt.m1461ChipsRowyrwZFoE(r19, chip2, (Function1) objRememberedValue11, modifierM1476riseInwH6b6FI$default, 0L, gapComposer10, 0, 16);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 10:
                NavHostController navHostController = (NavHostController) obj6;
                State state3 = (State) obj5;
                String str4 = (String) obj4;
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer11 = (GapComposer) composer10;
                if (gapComposer11.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    Modifier modifierM1473hairlineBottomiJQMabo = DialogKt.m1473hairlineBottomiJQMabo(companion, gapComposer11, 6);
                    String strStringResource2 = MathKt.stringResource(R.string.mixes, gapComposer11);
                    String str5 = (String) state3.getValue();
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Expect_jvmKt.rememberComposableLambda(660510957, new MainActivity$$ExternalSyntheticLambda6(str4, b4), gapComposer11);
                    boolean zChangedInstance5 = gapComposer11.changedInstance(navHostController);
                    Object objRememberedValue12 = gapComposer11.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue12 == neverEqualPolicy) {
                        objRememberedValue12 = new MainActivity$$ExternalSyntheticLambda2(navHostController, (byte) 17);
                        gapComposer11.updateRememberedValue(objRememberedValue12);
                    }
                    MenuKt.NavigationTitle(str5, modifierM1473hairlineBottomiJQMabo, strStringResource2, composableLambdaImplRememberComposableLambda3, (Function0) objRememberedValue12, null, gapComposer11, 3072, 32);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 11:
                PaddingValuesImpl paddingValuesImpl = (PaddingValuesImpl) obj6;
                SimilarRecommendation similarRecommendation = (SimilarRecommendation) obj5;
                ComposableLambdaImpl composableLambdaImpl4 = (ComposableLambdaImpl) obj4;
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer11;
                if (gapComposer12.shouldExecute(iIntValue11 & 1, (iIntValue11 & 17) != 16)) {
                    boolean zChangedInstance6 = gapComposer12.changedInstance(similarRecommendation);
                    Object objRememberedValue13 = gapComposer12.rememberedValue();
                    if (zChangedInstance6 || objRememberedValue13 == neverEqualPolicy) {
                        objRememberedValue13 = new SongMenuKt$$ExternalSyntheticLambda4((Object) similarRecommendation, (Object) composableLambdaImpl4, (byte) 15);
                        gapComposer12.updateRememberedValue(objRememberedValue13);
                    }
                    IntMath.LazyRow(null, null, paddingValuesImpl, null, null, null, false, null, (Function1) objRememberedValue13, gapComposer12, 0, 507);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                PaddingValuesImpl paddingValuesImpl2 = (PaddingValuesImpl) obj6;
                HomePage.Section section = (HomePage.Section) obj5;
                ComposableLambdaImpl composableLambdaImpl5 = (ComposableLambdaImpl) obj4;
                Composer composer12 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer12;
                if (gapComposer13.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    boolean zChangedInstance7 = gapComposer13.changedInstance(section);
                    Object objRememberedValue14 = gapComposer13.rememberedValue();
                    if (zChangedInstance7 || objRememberedValue14 == neverEqualPolicy) {
                        objRememberedValue14 = new SongMenuKt$$ExternalSyntheticLambda4(section, composableLambdaImpl5, b6);
                        gapComposer13.updateRememberedValue(objRememberedValue14);
                    }
                    IntMath.LazyRow(null, null, paddingValuesImpl2, null, null, null, false, null, (Function1) objRememberedValue14, gapComposer13, 0, 507);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 13:
                ArtistSection artistSection = (ArtistSection) obj6;
                ArtistViewModel artistViewModel = (ArtistViewModel) obj5;
                NavHostController navHostController2 = (NavHostController) obj4;
                Composer composer13 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer13;
                if (gapComposer14.shouldExecute(1 & iIntValue13, (iIntValue13 & 17) != 16)) {
                    String str6 = artistSection.title;
                    BrowseEndpoint browseEndpoint = artistSection.moreEndpoint;
                    if (browseEndpoint == null) {
                        gapComposer14.startReplaceGroup(-1814633461);
                        gapComposer14.end(false);
                        function0 = null;
                    } else {
                        gapComposer14.startReplaceGroup(-1814633460);
                        boolean zChangedInstance8 = gapComposer14.changedInstance(navHostController2) | gapComposer14.changedInstance(artistViewModel) | gapComposer14.changedInstance(browseEndpoint);
                        Object objRememberedValue15 = gapComposer14.rememberedValue();
                        if (zChangedInstance8 || objRememberedValue15 == neverEqualPolicy) {
                            objRememberedValue15 = new QueueKt$$ExternalSyntheticLambda24((Object) navHostController2, (Object) artistViewModel, (Object) browseEndpoint, (byte) 4);
                            gapComposer14.updateRememberedValue(objRememberedValue15);
                        }
                        gapComposer14.end(false);
                        function0 = (Function0) objRememberedValue15;
                    }
                    MenuKt.NavigationTitle(str6, Modifier.Companion.$$INSTANCE, null, null, function0, null, gapComposer14, 48, 44);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 14:
                NavHostController navHostController3 = (NavHostController) obj6;
                State state4 = (State) obj5;
                State state5 = (State) obj4;
                Composer composer14 = (Composer) obj2;
                int iIntValue14 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer15 = (GapComposer) composer14;
                if (gapComposer15.shouldExecute(1 & iIntValue14, (iIntValue14 & 17) != 16)) {
                    String strStringResource3 = MathKt.stringResource(R.string.episodes_for_later, gapComposer15);
                    PlaylistItem playlistItem = (PlaylistItem) state4.getValue();
                    if (playlistItem == null || (str = playlistItem.thumbnail) == null) {
                        Song song2 = (Song) CollectionsKt.firstOrNull((List) state5.getValue());
                        if (song2 == null || (songEntity = song2.song) == null) {
                            str = null;
                        } else {
                            String str7 = songEntity.thumbnailUrl;
                            str = str7;
                        }
                    } else {
                        str = str7;
                    }
                    PlaylistItem playlistItem2 = (PlaylistItem) state4.getValue();
                    if (playlistItem2 != null && (str3 = playlistItem2.songCountText) != null) {
                        str2 = str3;
                    } else if (((List) state5.getValue()).isEmpty()) {
                        gapComposer15.startReplaceGroup(-1093729799);
                        gapComposer15.end(false);
                        str2 = null;
                    } else {
                        gapComposer15.startReplaceGroup(-1093885140);
                        String strPluralStringResource = MathKt.pluralStringResource(R.plurals.n_episode, ((List) state5.getValue()).size(), new Object[]{Integer.valueOf(((List) state5.getValue()).size())}, gapComposer15);
                        gapComposer15.end(false);
                        str2 = strPluralStringResource;
                    }
                    boolean zChangedInstance9 = gapComposer15.changedInstance(navHostController3);
                    Object objRememberedValue16 = gapComposer15.rememberedValue();
                    if (zChangedInstance9 || objRememberedValue16 == neverEqualPolicy) {
                        objRememberedValue16 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController3, b5);
                        gapComposer15.updateRememberedValue(objRememberedValue16);
                    }
                    LibraryScreenKt.AutoPlaylistCard(strStringResource3, str, str2, (Function0) objRememberedValue16, null, gapComposer15, 0);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 15:
                List list2 = (List) obj6;
                Context context2 = (Context) obj5;
                MenuState menuState2 = (MenuState) obj4;
                Composer composer15 = (Composer) obj2;
                int iIntValue15 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer16 = (GapComposer) composer15;
                if (gapComposer16.shouldExecute(1 & iIntValue15, (iIntValue15 & 17) != 16)) {
                    TopPlaylistScreenKt.CachePlaylistHeader(list2, context2, menuState2, DialogKt.m1476riseInwH6b6FI$default(companion, 0), gapComposer16, 0);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 16:
                CoroutineScope coroutineScope2 = (CoroutineScope) obj6;
                MusicDatabase musicDatabase3 = (MusicDatabase) obj5;
                MutableState mutableState5 = (MutableState) obj4;
                Composer composer16 = (Composer) obj2;
                int iIntValue16 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer17 = (GapComposer) composer16;
                if (gapComposer17.shouldExecute(iIntValue16 & 1, (iIntValue16 & 17) != 16)) {
                    Object objRememberedValue17 = gapComposer17.rememberedValue();
                    if (objRememberedValue17 == neverEqualPolicy) {
                        objRememberedValue17 = new AiSettingsKt$$ExternalSyntheticLambda3(mutableState5, (byte) 1);
                        gapComposer17.updateRememberedValue(objRememberedValue17);
                    }
                    CardKt.TextButton((Function0) objRememberedValue17, null, false, null, null, null, RecognitionHistoryScreenKt.f427lambda$943563614, gapComposer17, 805306374, 510);
                    boolean zChangedInstance10 = gapComposer17.changedInstance(coroutineScope2) | gapComposer17.changedInstance(musicDatabase3);
                    Object objRememberedValue18 = gapComposer17.rememberedValue();
                    if (zChangedInstance10 || objRememberedValue18 == neverEqualPolicy) {
                        objRememberedValue18 = new QueueKt$$ExternalSyntheticLambda24(coroutineScope2, musicDatabase3, mutableState5, b2);
                        gapComposer17.updateRememberedValue(objRememberedValue18);
                    }
                    CardKt.TextButton((Function0) objRememberedValue18, null, false, null, null, null, RecognitionHistoryScreenKt.f426lambda$942409959, gapComposer17, 805306368, 510);
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            case 17:
                State state6 = (State) obj6;
                NavHostController navHostController4 = (NavHostController) obj5;
                MutableState mutableState6 = (MutableState) obj4;
                PaddingValues paddingValues = (PaddingValues) obj;
                Composer composer17 = (Composer) obj2;
                int iIntValue17 = ((Integer) obj3).intValue();
                paddingValues.getClass();
                if ((iIntValue17 & 6) == 0) {
                    iIntValue17 |= ((GapComposer) composer17).changed(paddingValues) ? 4 : 2;
                }
                GapComposer gapComposer18 = (GapComposer) composer17;
                if (!gapComposer18.shouldExecute(iIntValue17 & 1, (iIntValue17 & 19) != 18)) {
                    gapComposer18.skipToGroupEnd();
                } else if (((List) state6.getValue()).isEmpty()) {
                    gapComposer18.startReplaceGroup(-1820992802);
                    Modifier modifierPadding = OffsetKt.padding(SizeKt.FillWholeMaxSize, paddingValues);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode = Long.hashCode(gapComposer18.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer18.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer18, modifierPadding);
                    ComposeUiNode.Companion.getClass();
                    gapComposer18.startReusableNode();
                    boolean z = gapComposer18.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (z) {
                        gapComposer18.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer18.useNode();
                    }
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Stack.m390setimpl(gapComposer18, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer18, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer18, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer18);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer18, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.CenterHorizontally, gapComposer18, 48);
                    int iHashCode2 = Long.hashCode(gapComposer18.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer18.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer18, companion);
                    gapComposer18.startReusableNode();
                    if (gapComposer18.inserting) {
                        gapComposer18.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer18.useNode();
                    }
                    Stack.m390setimpl(gapComposer18, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer18, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer18, updater$$ExternalSyntheticLambda2, gapComposer18);
                    Stack.m390setimpl(gapComposer18, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    Painter painterPainterResource = IntMath.painterResource(R.drawable.history, 0, gapComposer18);
                    Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 64.0f);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    long j = ((MaterialTheme$Values) gapComposer18.consume(staticProvidableCompositionLocal3)).colorScheme.onSurfaceVariant;
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, modifierM151size3ABfNKs, ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.5f, Color.m483getColorSpaceimpl(j)), gapComposer18, 440, 0);
                    OffsetKt.Spacer(gapComposer18, SizeKt.m145height3ABfNKs(companion, 16.0f));
                    TextKt.m352TextNvy7gAk("No recognition history", null, ((MaterialTheme$Values) gapComposer18.consume(staticProvidableCompositionLocal3)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer18.consume(staticProvidableCompositionLocal3)).typography.bodyLarge, gapComposer18, 6, 0, 131066);
                    Fragment$5$$ExternalSyntheticOutline0.m(gapComposer18, true, true, false);
                } else {
                    gapComposer18.startReplaceGroup(-1819972251);
                    Modifier modifierPadding2 = OffsetKt.padding(SizeKt.FillWholeMaxSize, paddingValues);
                    InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues(new LimitInsets((WindowInsets) gapComposer18.consume(MainActivityKt.LocalPlayerAwareWindowInsets), 32), gapComposer18);
                    boolean zChanged5 = gapComposer18.changed(state6) | gapComposer18.changedInstance(navHostController4);
                    Object objRememberedValue19 = gapComposer18.rememberedValue();
                    if (zChanged5 || objRememberedValue19 == neverEqualPolicy) {
                        objRememberedValue19 = new MainActivity$$ExternalSyntheticLambda21(state6, navHostController4, mutableState6);
                        gapComposer18.updateRememberedValue(objRememberedValue19);
                    }
                    IntMath.LazyColumn(modifierPadding2, null, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue19, gapComposer18, 0, 506);
                    gapComposer18.end(false);
                }
                return unit;
            case 18:
                Function0 function6 = (Function0) obj6;
                Function2 function7 = (Function2) obj5;
                TimePickerState timePickerState2 = (TimePickerState) obj4;
                Composer composer18 = (Composer) obj2;
                int iIntValue18 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer19 = (GapComposer) composer18;
                if (gapComposer19.shouldExecute(iIntValue18 & 1, (iIntValue18 & 17) != 16)) {
                    CardKt.TextButton(function6, null, false, null, null, null, AiSettingsKt.f447lambda$1151893899, gapComposer19, 805306368, 510);
                    boolean zChanged6 = gapComposer19.changed(function7) | gapComposer19.changedInstance(timePickerState2);
                    Object objRememberedValue20 = gapComposer19.rememberedValue();
                    if (zChanged6 || objRememberedValue20 == neverEqualPolicy) {
                        objRememberedValue20 = new QueueKt$$ExternalSyntheticLambda16(function7, timePickerState2, b3);
                        gapComposer19.updateRememberedValue(objRememberedValue20);
                    }
                    CardKt.TextButton((Function0) objRememberedValue20, null, false, null, null, null, AiSettingsKt.f482lambda$1519387092, gapComposer19, 805306368, 510);
                } else {
                    gapComposer19.skipToGroupEnd();
                }
                return unit;
            case 19:
                Locale locale = (Locale) obj6;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) obj5;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) obj4;
                Composer composer19 = (Composer) obj2;
                int iIntValue19 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer20 = (GapComposer) composer19;
                if (gapComposer20.shouldExecute(iIntValue19 & 1, (iIntValue19 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.alarm_time_picker_value, new Object[]{String.format(locale, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(parcelableSnapshotMutableIntState.getIntValue()), Integer.valueOf(parcelableSnapshotMutableIntState2.getIntValue())}, 2))}, gapComposer20), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer20, 0, 0, 262142);
                } else {
                    gapComposer20.skipToGroupEnd();
                }
                return unit;
            case 20:
                return invoke$com$metrolist$music$ui$screens$settings$ContentSettingsKt$$ExternalSyntheticLambda89(obj, obj2, obj3);
            case 21:
                Function0 function8 = (Function0) obj6;
                Function1 function9 = (Function1) obj5;
                MutableState mutableState7 = (MutableState) obj4;
                Composer composer20 = (Composer) obj2;
                int iIntValue20 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer21 = (GapComposer) composer20;
                if (gapComposer21.shouldExecute(1 & iIntValue20, (iIntValue20 & 17) != 16)) {
                    CardKt.TextButton(function8, null, false, null, null, null, LastFMSettingsKt.f598lambda$1123129751, gapComposer21, 805306368, 510);
                    boolean zChanged7 = gapComposer21.changed(function9) | gapComposer21.changed(function8);
                    Object objRememberedValue21 = gapComposer21.rememberedValue();
                    if (zChanged7 || objRememberedValue21 == neverEqualPolicy) {
                        objRememberedValue21 = new QueueKt$$ExternalSyntheticLambda24(function9, function8, mutableState7, b6);
                        gapComposer21.updateRememberedValue(objRememberedValue21);
                    }
                    CardKt.TextButton((Function0) objRememberedValue21, null, false, null, null, null, LastFMSettingsKt.f591lambda$1022751840, gapComposer21, 805306368, 510);
                } else {
                    gapComposer21.skipToGroupEnd();
                }
                return unit;
            case 22:
                return invoke$com$metrolist$music$ui$screens$settings$integrations$ListenTogetherSettingsKt$$ExternalSyntheticLambda54(obj, obj2, obj3);
            default:
                BufferedChannel bufferedChannel = (BufferedChannel) obj5;
                SelectImplementation selectImplementation = (SelectImplementation) obj4;
                if (obj6 != BufferedChannelKt.CHANNEL_CLOSED) {
                    InlineList.callUndeliveredElement(bufferedChannel.onUndeliveredElement, obj6, selectImplementation.context);
                }
                return unit;
        }
    }
}
