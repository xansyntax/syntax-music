package com.metrolist.music.ui.screens;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.RippleNodeFactory;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.carousel.CarouselItemScopeImpl;
import androidx.compose.material3.carousel.CarouselState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.core.provider.CallbackWrapper;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import coil3.util.LifecyclesKt;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.music.constants.PlaylistSongSortType;
import com.metrolist.music.constants.SongSortType;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.DialogKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.NewAction;
import com.metrolist.music.ui.component.SortHeaderKt$SortHeader$1$2$1;
import com.metrolist.music.ui.component.SortHeaderKt$SortHeader$1$5;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda69;
import com.metrolist.music.ui.menu.YouTubeArtistMenuKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda82;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.viewmodels.DailyDiscoverItem;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import okhttp3.Handshake$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda29 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda29(List list, boolean z, PlayerConnection playerConnection, MutableState mutableState) {
        this.$r8$classId = (byte) 2;
        this.f$0 = list;
        this.f$2 = z;
        this.f$3 = playerConnection;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        boolean z;
        GapComposer gapComposer;
        Modifier modifierM137paddingVpY3zN4$default;
        int i;
        GapComposer gapComposer2;
        Modifier modifierM137paddingVpY3zN4$default2;
        int i2;
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.f$3;
        Object obj5 = this.f$1;
        final boolean z2 = this.f$2;
        Object obj6 = this.f$0;
        switch (b) {
            case 0:
                List list = (List) obj6;
                NavHostController navHostController = (NavHostController) obj5;
                PlayerConnection playerConnection = (PlayerConnection) obj4;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer;
                if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    Modifier modifierM1476riseInwH6b6FI$default = DialogKt.m1476riseInwH6b6FI$default(companion, 100);
                    PaddingValuesImpl paddingValuesImplM127PaddingValuesYgX7TsA$default = OffsetKt.m127PaddingValuesYgX7TsA$default(2, 20.0f);
                    Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(16.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
                    boolean zChangedInstance = gapComposer3.changedInstance(list) | gapComposer3.changedInstance(navHostController) | gapComposer3.changed(z2) | gapComposer3.changedInstance(playerConnection);
                    Object objRememberedValue = gapComposer3.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new DialogKt$$ExternalSyntheticLambda16(list, navHostController, z2, playerConnection);
                        gapComposer3.updateRememberedValue(objRememberedValue);
                    }
                    IntMath.LazyRow(modifierM1476riseInwH6b6FI$default, null, paddingValuesImplM127PaddingValuesYgX7TsA$default, arrangement$SpacedAligned, null, null, false, null, (Function1) objRememberedValue, gapComposer3, 24960, 490);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 1:
                PlaylistItem playlistItem = (PlaylistItem) obj6;
                PlayerConnection playerConnection2 = (PlayerConnection) obj4;
                Function0 function0 = (Function0) obj5;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer2;
                if (gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer4.startReplaceGroup(1536165296);
                    ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                    if (z2) {
                        z = false;
                        gapComposer4.startReplaceGroup(-612452721);
                        gapComposer4.end(false);
                    } else {
                        gapComposer4.startReplaceGroup(-615741263);
                        WatchEndpoint watchEndpoint = playlistItem.playEndpoint;
                        if (watchEndpoint == null) {
                            gapComposer4.startReplaceGroup(-615761569);
                            z = false;
                            gapComposer4.end(false);
                        } else {
                            gapComposer4.startReplaceGroup(-615761568);
                            listBuilderCreateListBuilder.add(new NewAction(AlbumMenuKt.lambda$1083081581, MathKt.stringResource(R.string.play, gapComposer4), Expect_jvmKt.rememberComposableLambda(1859138927, new YouTubeArtistMenuKt$$ExternalSyntheticLambda5(playerConnection2, watchEndpoint, function0, (byte) 1), gapComposer4)));
                            z = false;
                            gapComposer4.end(false);
                        }
                        WatchEndpoint watchEndpoint2 = playlistItem.shuffleEndpoint;
                        if (watchEndpoint2 == null) {
                            gapComposer4.startReplaceGroup(-614644205);
                            gapComposer4.end(z);
                        } else {
                            gapComposer4.startReplaceGroup(-614644204);
                            listBuilderCreateListBuilder.add(new NewAction(AlbumMenuKt.f107lambda$1546986268, MathKt.stringResource(R.string.shuffle, gapComposer4), Expect_jvmKt.rememberComposableLambda(1214781030, new YouTubeArtistMenuKt$$ExternalSyntheticLambda5(playerConnection2, watchEndpoint2, function0, (byte) 2), gapComposer4)));
                            z = false;
                            gapComposer4.end(false);
                        }
                        WatchEndpoint watchEndpoint3 = playlistItem.radioEndpoint;
                        if (watchEndpoint3 == null) {
                            gapComposer4.startReplaceGroup(-613517355);
                            gapComposer4.end(z);
                        } else {
                            gapComposer4.startReplaceGroup(-613517354);
                            listBuilderCreateListBuilder.add(new NewAction(AlbumMenuKt.f60lambda$1168186559, MathKt.stringResource(R.string.start_radio, gapComposer4), Expect_jvmKt.rememberComposableLambda(1073604863, new YouTubeArtistMenuKt$$ExternalSyntheticLambda5(playerConnection2, watchEndpoint3, function0, (byte) 3), gapComposer4)));
                            z = false;
                            gapComposer4.end(false);
                        }
                        gapComposer4.end(z);
                    }
                    ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                    gapComposer4.end(z);
                    MenuKt.NewActionGrid(listBuilderBuild, OffsetKt.m136paddingVpY3zN4(companion, 4.0f, 16.0f), 0, gapComposer4, 48, 4);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 2:
                final List list2 = (List) obj6;
                final PlayerConnection playerConnection3 = (PlayerConnection) obj4;
                final MutableState mutableState = (MutableState) obj5;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer3;
                if (gapComposer5.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    Modifier modifierM137paddingVpY3zN4$default3 = OffsetKt.m137paddingVpY3zN4$default(SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 420.0f), 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode = Long.hashCode(gapComposer5.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer5.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer5, modifierM137paddingVpY3zN4$default3);
                    ComposeUiNode.Companion.getClass();
                    gapComposer5.startReusableNode();
                    if (gapComposer5.inserting) {
                        gapComposer5.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer5.useNode();
                    }
                    Stack.m390setimpl(gapComposer5, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer5, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer5);
                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    boolean zChangedInstance2 = gapComposer5.changedInstance(list2);
                    Object objRememberedValue2 = gapComposer5.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new Url$$ExternalSyntheticLambda0(list2, (byte) 4);
                        gapComposer5.updateRememberedValue(objRememberedValue2);
                    }
                    Function0 function1 = (Function0) objRememberedValue2;
                    Object[] objArr = new Object[0];
                    CallbackWrapper callbackWrapper = CarouselState.Saver;
                    boolean zChanged = gapComposer5.changed(function1) | gapComposer5.changed(0);
                    Object objRememberedValue3 = gapComposer5.rememberedValue();
                    if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new Handshake$$ExternalSyntheticLambda0(function1, (byte) 6);
                        gapComposer5.updateRememberedValue(objRememberedValue3);
                    }
                    CarouselState carouselState = (CarouselState) SaverKt.m393rememberSaveable(objArr, (Saver) callbackWrapper, (Function0) objRememberedValue3, (Composer) gapComposer5, 0);
                    carouselState.pagerState.pageCountState.setValue(function1);
                    LifecyclesKt.m883HorizontalMultiBrowseCarousel3tcCNu0(carouselState, SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 400.0f), 16.0f, null, false, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(-300624375, new Function4() { // from class: com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda71
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj7, Object obj8, Object obj9, Object obj10) throws IOException {
                            int i3;
                            CarouselItemScopeImpl carouselItemScopeImpl = (CarouselItemScopeImpl) obj7;
                            int iIntValue4 = ((Integer) obj8).intValue();
                            Composer composer4 = (Composer) obj9;
                            int iIntValue5 = ((Integer) obj10).intValue();
                            carouselItemScopeImpl.getClass();
                            if ((iIntValue5 & 6) == 0) {
                                i3 = ((iIntValue5 & 8) == 0 ? ((GapComposer) composer4).changed(carouselItemScopeImpl) : ((GapComposer) composer4).changedInstance(carouselItemScopeImpl) ? 4 : 2) | iIntValue5;
                            } else {
                                i3 = iIntValue5;
                            }
                            if ((iIntValue5 & 48) == 0) {
                                i3 |= ((GapComposer) composer4).changed(iIntValue4) ? 32 : 16;
                            }
                            GapComposer gapComposer6 = (GapComposer) composer4;
                            if (gapComposer6.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                                DailyDiscoverItem dailyDiscoverItem = (DailyDiscoverItem) list2.get(iIntValue4);
                                boolean z3 = z2;
                                boolean zChanged2 = gapComposer6.changed(z3) | gapComposer6.changedInstance(dailyDiscoverItem);
                                PlayerConnection playerConnection4 = playerConnection3;
                                boolean zChangedInstance3 = zChanged2 | gapComposer6.changedInstance(playerConnection4);
                                MutableState mutableState2 = mutableState;
                                boolean zChanged3 = gapComposer6.changed(mutableState2) | zChangedInstance3;
                                Object objRememberedValue4 = gapComposer6.rememberedValue();
                                NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
                                if (zChanged3 || objRememberedValue4 == neverEqualPolicy2) {
                                    SongMenuKt$$ExternalSyntheticLambda69 songMenuKt$$ExternalSyntheticLambda69 = new SongMenuKt$$ExternalSyntheticLambda69(z3, dailyDiscoverItem, playerConnection4, mutableState2, (byte) 3);
                                    gapComposer6.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda69);
                                    objRememberedValue4 = songMenuKt$$ExternalSyntheticLambda69;
                                }
                                Function0 function2 = (Function0) objRememberedValue4;
                                RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f);
                                gapComposer6.startReplaceGroup(440683050);
                                gapComposer6.startReplaceGroup(152582312);
                                Density density = (Density) gapComposer6.consume(CompositionLocalsKt.LocalDensity);
                                boolean zChanged4 = gapComposer6.changed(carouselItemScopeImpl.itemInfo) | gapComposer6.changed(density);
                                Object objRememberedValue5 = gapComposer6.rememberedValue();
                                if (zChanged4 || objRememberedValue5 == neverEqualPolicy2) {
                                    objRememberedValue5 = new GenericShape(new PlayerKt$$ExternalSyntheticLambda82(carouselItemScopeImpl, roundedCornerShapeM185RoundedCornerShape0680j_4, density, (byte) 1));
                                    gapComposer6.updateRememberedValue(objRememberedValue5);
                                }
                                gapComposer6.end(false);
                                Modifier modifierClip = ClipKt.clip(Modifier.Companion.$$INSTANCE, (GenericShape) objRememberedValue5);
                                gapComposer6.end(false);
                                HomeScreenKt.DailyDiscoverCard(dailyDiscoverItem, function2, modifierClip, gapComposer6, 8);
                            } else {
                                gapComposer6.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer5), gapComposer5, 805309880);
                    gapComposer5.end(true);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 3:
                ArrayList arrayList = (ArrayList) obj6;
                String str = (String) obj5;
                Function2 function2 = (Function2) obj4;
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer4;
                if (gapComposer6.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 16.0f);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer6, 0);
                    Function2 function3 = function2;
                    int iHashCode2 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer6, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    String str2 = MathKt.stringResource(R.string.connected_users, gapComposer6) + " (" + arrayList.size() + ")";
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(str2, null, ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal)).colorScheme.primary, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal)).typography.titleMedium, gapComposer6, 1572864, 0, 131002);
                    OffsetKt.Spacer(gapComposer6, SizeKt.m145height3ABfNKs(companion, 12.0f));
                    Modifier modifierScroll$default = ImageKt.scroll$default(SizeKt.fillMaxWidth(companion, 1.0f), ImageKt.rememberScrollState(gapComposer6), false);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(16.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Top, gapComposer6, 6);
                    int iHashCode3 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierScroll$default);
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer6, updater$$ExternalSyntheticLambda1, gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    gapComposer6.startReplaceGroup(-1444950433);
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj7 = arrayList.get(i3);
                        i3++;
                        Listentogether.UserInfo userInfo = (Listentogether.UserInfo) obj7;
                        boolean zAreEqual = Intrinsics.areEqual(userInfo.getUserId(), str);
                        boolean z3 = z2 && !Intrinsics.areEqual(userInfo.getUserId(), str);
                        Function2 function4 = function3;
                        boolean zChanged2 = gapComposer6.changed(function4) | gapComposer6.changed(userInfo);
                        Object objRememberedValue4 = gapComposer6.rememberedValue();
                        if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                            objRememberedValue4 = new QueueKt$$ExternalSyntheticLambda16(function4, userInfo, (byte) 8);
                            gapComposer6.updateRememberedValue(objRememberedValue4);
                        }
                        ListenTogetherScreenKt.UserAvatar(userInfo, zAreEqual, z3, (Function0) objRememberedValue4, gapComposer6, 0);
                        function3 = function4;
                    }
                    Fragment$5$$ExternalSyntheticOutline0.m(gapComposer6, false, true, true);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 4:
                SongSortType songSortType = (SongSortType) obj6;
                Function1 function5 = (Function1) obj5;
                Function1 function6 = (Function1) obj4;
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer5;
                if (gapComposer7.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(companion2, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14);
                    Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer7, 48);
                    int iHashCode4 = Long.hashCode(gapComposer7.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer7.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer7, modifierM139paddingqDBjuR0$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer7.startReusableNode();
                    if (gapComposer7.inserting) {
                        gapComposer7.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer7.useNode();
                    }
                    Stack.m390setimpl(gapComposer7, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer7, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer7, Integer.valueOf(iHashCode4), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer7);
                    Stack.m390setimpl(gapComposer7, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    Object objRememberedValue5 = gapComposer7.rememberedValue();
                    if (objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer7.updateRememberedValue(objRememberedValue5);
                    }
                    MutableState mutableState2 = (MutableState) objRememberedValue5;
                    Modifier modifierM137paddingVpY3zN4$default4 = OffsetKt.m137paddingVpY3zN4$default(layoutWeightElement, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
                    if (UiStyleKt.isGlassStyle(gapComposer7)) {
                        gapComposer7.startReplaceGroup(-2138758585);
                        gapComposer = gapComposer7;
                        modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(GlassComponentsKt.glass(companion2, RoundedCornerShapeKt.RoundedCornerShape(50), false, gapComposer7, 6, 2), 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                        gapComposer.end(false);
                    } else {
                        gapComposer = gapComposer7;
                        gapComposer.startReplaceGroup(-2138602190);
                        gapComposer.end(false);
                        modifierM137paddingVpY3zN4$default = companion2;
                    }
                    Modifier modifierThen = modifierM137paddingVpY3zN4$default4.then(modifierM137paddingVpY3zN4$default);
                    RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer, 48);
                    int iHashCode5 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer, updater$$ExternalSyntheticLambda1, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda0);
                    int iOrdinal = songSortType.ordinal();
                    if (iOrdinal == 0) {
                        i = R.string.sort_by_create_date;
                    } else if (iOrdinal == 1) {
                        i = R.string.sort_by_name;
                    } else if (iOrdinal == 2) {
                        i = R.string.sort_by_artist;
                    } else {
                        if (iOrdinal != 3) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i = R.string.sort_by_play_time;
                    }
                    String upperCase = MathKt.stringResource(i, gapComposer).toUpperCase(Locale.ROOT);
                    upperCase.getClass();
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    long j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme.primary;
                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).typography.labelMedium;
                    FontWeight fontWeight = UiStyleKt.isGlassStyle(gapComposer) ? FontWeight.Bold : null;
                    Object objRememberedValue6 = gapComposer.rememberedValue();
                    if (objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                    }
                    MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue6;
                    RippleNodeFactory rippleNodeFactoryM313rippleOu1YvPQ$default = RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, null, 254);
                    Object objRememberedValue7 = gapComposer.rememberedValue();
                    if (objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new SortHeaderKt$SortHeader$1$2$1(mutableState2, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue7);
                    }
                    TextKt.m352TextNvy7gAk(upperCase, OffsetKt.m136paddingVpY3zN4(ImageKt.m45clickableO2vRcR0$default(companion2, mutableInteractionSourceImpl, rippleNodeFactoryM313rippleOu1YvPQ$default, false, null, (Function0) objRememberedValue7, 28), 4.0f, 8.0f), j, 0L, null, fontWeight, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, 0, 0, 131000);
                    boolean zM1492SortHeader$lambda1 = MenuKt.m1492SortHeader$lambda1(mutableState2);
                    Object objRememberedValue8 = gapComposer.rememberedValue();
                    if (objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new SortHeaderKt$SortHeader$1$2$1(mutableState2, (byte) 1);
                        gapComposer.updateRememberedValue(objRememberedValue8);
                    }
                    CardKt.m256DropdownMenuIlH_yew(zM1492SortHeader$lambda1, (Function0) objRememberedValue8, SizeKt.m157widthInVpY3zN4$default(companion2, 172.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, null, null, null, 0L, CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(-1229424361, new LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1((byte) 7, mutableState2, songSortType, function5), gapComposer), gapComposer, 432, 2040);
                    if (songSortType != PlaylistSongSortType.CUSTOM) {
                        gapComposer.startReplaceGroup(-413182842);
                        MenuKt.m1491ResizableIconButtonFU0evQE(z2 ? R.drawable.arrow_downward : R.drawable.arrow_upward, OffsetKt.m135padding3ABfNKs(SizeKt.m151size3ABfNKs(companion2, 32.0f), 8.0f), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme.primary, false, new SortHeaderKt$SortHeader$1$5(function6, z2), gapComposer, 48);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-412803898);
                        gapComposer.end(false);
                    }
                    gapComposer.end(true);
                    gapComposer.end(true);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            default:
                SongSortType songSortType2 = (SongSortType) obj6;
                Function1 function7 = (Function1) obj5;
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) obj4;
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer6;
                if (gapComposer8.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    BiasAlignment.Vertical vertical2 = Alignment.Companion.CenterVertically;
                    Modifier.Companion companion3 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM139paddingqDBjuR0$default2 = OffsetKt.m139paddingqDBjuR0$default(companion3, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14);
                    Arrangement$End$1 arrangement$End$2 = OffsetKt.Start;
                    RowMeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(arrangement$End$2, vertical2, gapComposer8, 48);
                    int iHashCode6 = Long.hashCode(gapComposer8.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer8.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer8, modifierM139paddingqDBjuR0$default2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer8.startReusableNode();
                    if (gapComposer8.inserting) {
                        gapComposer8.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer8.useNode();
                    }
                    Stack.m390setimpl(gapComposer8, rowMeasurePolicy4, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer8, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer8, Integer.valueOf(iHashCode6), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer8);
                    Stack.m390setimpl(gapComposer8, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda0);
                    LayoutWeightElement layoutWeightElement2 = new LayoutWeightElement(1.0f, true);
                    Object objRememberedValue9 = gapComposer8.rememberedValue();
                    if (objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = Stack.mutableStateOf$default(Boolean.FALSE);
                        gapComposer8.updateRememberedValue(objRememberedValue9);
                    }
                    MutableState mutableState3 = (MutableState) objRememberedValue9;
                    Modifier modifierM137paddingVpY3zN4$default5 = OffsetKt.m137paddingVpY3zN4$default(layoutWeightElement2, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
                    if (UiStyleKt.isGlassStyle(gapComposer8)) {
                        gapComposer8.startReplaceGroup(-2138758585);
                        gapComposer2 = gapComposer8;
                        modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(GlassComponentsKt.glass(companion3, RoundedCornerShapeKt.RoundedCornerShape(50), false, gapComposer8, 6, 2), 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2 = gapComposer8;
                        gapComposer2.startReplaceGroup(-2138602190);
                        gapComposer2.end(false);
                        modifierM137paddingVpY3zN4$default2 = companion3;
                    }
                    Modifier modifierThen2 = modifierM137paddingVpY3zN4$default5.then(modifierM137paddingVpY3zN4$default2);
                    RowMeasurePolicy rowMeasurePolicy5 = RowKt.rowMeasurePolicy(arrangement$End$2, vertical2, gapComposer2, 48);
                    int iHashCode7 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope7 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier7 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierThen2);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy5, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope7, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode7, gapComposer2, updater$$ExternalSyntheticLambda1, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier7, updater$$ExternalSyntheticLambda0);
                    int iOrdinal2 = songSortType2.ordinal();
                    if (iOrdinal2 == 0) {
                        i2 = R.string.sort_by_create_date;
                    } else if (iOrdinal2 == 1) {
                        i2 = R.string.sort_by_name;
                    } else if (iOrdinal2 == 2) {
                        i2 = R.string.sort_by_artist;
                    } else {
                        if (iOrdinal2 != 3) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i2 = R.string.sort_by_play_time;
                    }
                    String upperCase2 = MathKt.stringResource(i2, gapComposer2).toUpperCase(Locale.ROOT);
                    upperCase2.getClass();
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    long j2 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).colorScheme.primary;
                    TextStyle textStyle2 = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).typography.labelMedium;
                    FontWeight fontWeight2 = UiStyleKt.isGlassStyle(gapComposer2) ? FontWeight.Bold : null;
                    Object objRememberedValue10 = gapComposer2.rememberedValue();
                    if (objRememberedValue10 == neverEqualPolicy) {
                        objRememberedValue10 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
                    }
                    MutableInteractionSourceImpl mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue10;
                    RippleNodeFactory rippleNodeFactoryM313rippleOu1YvPQ$default2 = RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, null, 254);
                    Object objRememberedValue11 = gapComposer2.rememberedValue();
                    if (objRememberedValue11 == neverEqualPolicy) {
                        objRememberedValue11 = new SortHeaderKt$SortHeader$1$2$1(mutableState3, (byte) 0);
                        gapComposer2.updateRememberedValue(objRememberedValue11);
                    }
                    TextKt.m352TextNvy7gAk(upperCase2, OffsetKt.m136paddingVpY3zN4(ImageKt.m45clickableO2vRcR0$default(companion3, mutableInteractionSourceImpl2, rippleNodeFactoryM313rippleOu1YvPQ$default2, false, null, (Function0) objRememberedValue11, 28), 4.0f, 8.0f), j2, 0L, null, fontWeight2, null, 0L, null, 0L, 0, false, 0, 0, textStyle2, gapComposer2, 0, 0, 131000);
                    boolean zM1492SortHeader$lambda2 = MenuKt.m1492SortHeader$lambda1(mutableState3);
                    Object objRememberedValue12 = gapComposer2.rememberedValue();
                    if (objRememberedValue12 == neverEqualPolicy) {
                        objRememberedValue12 = new SortHeaderKt$SortHeader$1$2$1(mutableState3, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue12);
                    }
                    CardKt.m256DropdownMenuIlH_yew(zM1492SortHeader$lambda2, (Function0) objRememberedValue12, SizeKt.m157widthInVpY3zN4$default(companion3, 172.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, null, null, null, 0L, CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(-1229424361, new LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1((byte) 8, mutableState3, songSortType2, function7), gapComposer2), gapComposer2, 432, 2040);
                    if (songSortType2 != PlaylistSongSortType.CUSTOM) {
                        gapComposer2.startReplaceGroup(-413182842);
                        MenuKt.m1491ResizableIconButtonFU0evQE(z2 ? R.drawable.arrow_downward : R.drawable.arrow_upward, OffsetKt.m135padding3ABfNKs(SizeKt.m151size3ABfNKs(companion3, 32.0f), 8.0f), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).colorScheme.primary, false, new SortHeaderKt$SortHeader$1$5(mimesKt$$ExternalSyntheticLambda0, z2), gapComposer2, 48);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(-412803898);
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(true);
                    gapComposer2.end(true);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda29(List list, Object obj, boolean z, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = obj;
        this.f$2 = z;
        this.f$3 = obj2;
    }

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda29(SongSortType songSortType, boolean z, Function1 function1, Function1 function2, byte b) {
        this.$r8$classId = b;
        this.f$0 = songSortType;
        this.f$2 = z;
        this.f$1 = function1;
        this.f$3 = function2;
    }

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda29(boolean z, PlaylistItem playlistItem, PlayerConnection playerConnection, Function0 function0) {
        this.$r8$classId = (byte) 1;
        this.f$2 = z;
        this.f$0 = playlistItem;
        this.f$3 = playerConnection;
        this.f$1 = function0;
    }
}
