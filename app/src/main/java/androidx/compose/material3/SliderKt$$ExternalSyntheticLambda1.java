package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Constraints;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.exoplayer.offline.Download;
import coil3.util.FileSystemsKt;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.listentogether.ListenTogetherServer;
import com.metrolist.music.lyrics.LyricsUtils$$ExternalSyntheticLambda0;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.ui.component.Icon;
import com.metrolist.music.ui.component.ItemsKt$AlbumGridItem$1$songs$2$1;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SliderKt$$ExternalSyntheticLambda1 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ SliderKt$$ExternalSyntheticLambda1(Object obj, boolean z, byte b) {
        this.$r8$classId = b;
        this.f$1 = obj;
        this.f$0 = z;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0217  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Object obj4;
        int i;
        byte b = this.$r8$classId;
        Icon icon = Icon.INSTANCE;
        Unit unit = Unit.INSTANCE;
        byte b2 = 1;
        final boolean z = this.f$0;
        Object obj5 = this.f$1;
        switch (b) {
            case 0:
                SliderDefaults.INSTANCE.m333Track4EFweAY((SliderState) obj, null, this.f$0, (SliderColors) obj5, null, null, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (Composer) obj2, (((Integer) obj3).intValue() & 14) | 100663296);
                return unit;
            case 1:
                Placeable placeableMo598measureBRTryo0 = ((Measurable) obj2).mo598measureBRTryo0(((Constraints) obj3).value);
                return ((MeasureScope) obj).layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new LyricsUtils$$ExternalSyntheticLambda0(obj5, z, (Object) placeableMo598measureBRTryo0, (byte) 2));
            case 2:
                Song song = (Song) obj5;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    if (song.song.liked) {
                        gapComposer.startReplaceGroup(-1588707333);
                        icon.Favorite(6, gapComposer);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-1588669854);
                        gapComposer.end(false);
                    }
                    if (!z || song.song.inLibrary == null) {
                        gapComposer.startReplaceGroup(-1588569662);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-1588606180);
                        icon.Library(6, gapComposer);
                        gapComposer.end(false);
                    }
                    gapComposer.startReplaceGroup(-1588533392);
                    Download download = (Download) FileSystemsKt.collectAsStateWithLifecycle(((DownloadUtil) gapComposer.consume(MainActivityKt.LocalDownloadUtil)).getDownload(song.song.id), null, gapComposer, 48).getValue();
                    icon.Download(download != null ? Integer.valueOf(download.state) : null, gapComposer, 48);
                    gapComposer.end(false);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 3:
                final Playlist playlist = (Playlist) obj5;
                BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                boxWithConstraintsScopeImpl.getClass();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= ((GapComposer) composer2).changed(boxWithConstraintsScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    final float fM118getMaxWidthD9Ej5fM = boxWithConstraintsScopeImpl.m118getMaxWidthD9Ej5fM();
                    List thumbnails = playlist.getThumbnails();
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(194284718, new Function2() { // from class: com.metrolist.music.ui.component.ItemsKt$$ExternalSyntheticLambda85
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj6, Object obj7) throws XmlPullParserException, IOException {
                            int i2;
                            Composer composer3 = (Composer) obj6;
                            int iIntValue3 = ((Integer) obj7).intValue();
                            GapComposer gapComposer3 = (GapComposer) composer3;
                            if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                                String str = playlist.playlist.name;
                                gapComposer3.startReplaceGroup(2024021818);
                                if (Intrinsics.areEqual(str, MathKt.stringResource(R.string.liked, gapComposer3))) {
                                    i2 = R.drawable.favorite_border;
                                } else if (Intrinsics.areEqual(str, MathKt.stringResource(R.string.offline, gapComposer3))) {
                                    i2 = R.drawable.offline;
                                } else if (Intrinsics.areEqual(str, MathKt.stringResource(R.string.cached_playlist, gapComposer3))) {
                                    i2 = R.drawable.cached;
                                } else if (Intrinsics.areEqual(str, MathKt.stringResource(R.string.uploaded_playlist, gapComposer3))) {
                                    i2 = R.drawable.backup;
                                } else {
                                    i2 = z ? R.drawable.trending_up : R.drawable.queue_music;
                                }
                                gapComposer3.end(false);
                                BiasAlignment biasAlignment = Alignment.Companion.Center;
                                FillElement fillElement = SizeKt.FillWholeMaxSize;
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                                int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, fillElement);
                                ComposeUiNode.Companion.getClass();
                                gapComposer3.startReusableNode();
                                if (gapComposer3.inserting) {
                                    gapComposer3.createNode(LayoutNode.Constructor);
                                } else {
                                    gapComposer3.useNode();
                                }
                                Stack.m390setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                                Stack.m389reconcileimpl(gapComposer3);
                                Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                Painter painterPainterResource = IntMath.painterResource(i2, 0, gapComposer3);
                                long j = ((Color) gapComposer3.consume(ContentColorKt.LocalContentColor)).value;
                                IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, (fM118getMaxWidthD9Ej5fM / 2.0f) + CropImageView.DEFAULT_ASPECT_RATIO), ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.8f, Color.m483getColorSpaceimpl(j)), gapComposer3, 56, 0);
                                gapComposer3.end(true);
                            } else {
                                gapComposer3.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer2);
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    com.metrolist.music.ui.component.MenuKt.m1490PlaylistThumbnailEUb7tLY(thumbnails, fM118getMaxWidthD9Ej5fM, composableLambdaImplRememberComposableLambda, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(18.0f, 10.0f, gapComposer2)), gapComposer2, 384);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 4:
                Album album = (Album) obj5;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    DownloadUtil downloadUtil = (DownloadUtil) gapComposer3.consume(MainActivityKt.LocalDownloadUtil);
                    MusicDatabase musicDatabase = (MusicDatabase) gapComposer3.consume(MainActivityKt.LocalDatabase);
                    AlbumEntity albumEntity = album.album;
                    String str = albumEntity.id;
                    boolean zChangedInstance = gapComposer3.changedInstance(musicDatabase) | gapComposer3.changed(album);
                    Object objRememberedValue = gapComposer3.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        obj4 = objRememberedValue;
                        ItemsKt$AlbumGridItem$1$songs$2$1 itemsKt$AlbumGridItem$1$songs$2$1 = new ItemsKt$AlbumGridItem$1$songs$2$1(musicDatabase, album, false ? 1 : 0, b2);
                        gapComposer3.updateRememberedValue(itemsKt$AlbumGridItem$1$songs$2$1);
                        obj4 = itemsKt$AlbumGridItem$1$songs$2$1;
                    }
                    MutableState mutableStateProduceState = Stack.produceState(EmptyList.INSTANCE, str, (Function2) obj4, gapComposer3);
                    MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(downloadUtil.downloads, gapComposer3);
                    boolean zChanged = gapComposer3.changed((List) mutableStateProduceState.getValue()) | gapComposer3.changed((Map) mutableStateCollectAsStateWithLifecycle.getValue());
                    Object objRememberedValue2 = gapComposer3.rememberedValue();
                    Object objM = objRememberedValue2;
                    if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                        if (((List) mutableStateProduceState.getValue()).isEmpty()) {
                            i = 1;
                        } else {
                            List list = (List) mutableStateProduceState.getValue();
                            if (list == null || !list.isEmpty()) {
                                Iterator it = list.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        Download download2 = (Download) ((Map) mutableStateCollectAsStateWithLifecycle.getValue()).get(((Song) it.next()).song.id);
                                        if (download2 == null || download2.state != 3) {
                                            List list2 = (List) mutableStateProduceState.getValue();
                                            if (list2 == null || !list2.isEmpty()) {
                                                Iterator it2 = list2.iterator();
                                                while (true) {
                                                    if (it2.hasNext()) {
                                                        Song song2 = (Song) it2.next();
                                                        List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Integer[]{0, 2});
                                                        Download download3 = (Download) ((Map) mutableStateCollectAsStateWithLifecycle.getValue()).get(song2.song.id);
                                                        if (CollectionsKt.contains(listListOf, download3 != null ? Integer.valueOf(download3.state) : null)) {
                                                            i = 2;
                                                        }
                                                    } else {
                                                        i = 1;
                                                    }
                                                }
                                            } else {
                                                i = 1;
                                            }
                                        }
                                    } else {
                                        i = 3;
                                    }
                                }
                            } else {
                                i = 3;
                            }
                        }
                        objM = Fragment$5$$ExternalSyntheticOutline0.m(i, gapComposer3);
                    }
                    ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objM;
                    if (!z || albumEntity.bookmarkedAt == null) {
                        gapComposer3.startReplaceGroup(10619150);
                        gapComposer3.end(false);
                    } else {
                        gapComposer3.startReplaceGroup(10581671);
                        icon.Favorite(6, gapComposer3);
                        gapComposer3.end(false);
                    }
                    if (albumEntity.explicit) {
                        gapComposer3.startReplaceGroup(10655079);
                        icon.Explicit(6, gapComposer3);
                        gapComposer3.end(false);
                    } else {
                        gapComposer3.startReplaceGroup(10692558);
                        gapComposer3.end(false);
                    }
                    icon.Download(Integer.valueOf(parcelableSnapshotMutableIntState.getIntValue()), gapComposer3, 48);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            default:
                ListenTogetherServer listenTogetherServer = (ListenTogetherServer) obj5;
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 12.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer4, 48);
                    int iHashCode = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer4.startReusableNode();
                    boolean z2 = gapComposer4.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (z2) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Stack.m390setimpl(gapComposer4, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer4, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer4);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer4, 0);
                    int iHashCode2 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer4, layoutWeightElement);
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m390setimpl(gapComposer4, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer4, updater$$ExternalSyntheticLambda2, gapComposer4);
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    String str2 = listenTogetherServer.name;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(str2, null, 0L, 0L, null, FontWeight.SemiBold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).typography.titleSmall, gapComposer4, 1572864, 0, 131006);
                    TextKt.m352TextNvy7gAk(Fragment$5$$ExternalSyntheticOutline0.m(listenTogetherServer.location, " - ", listenTogetherServer.operator), null, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer4, 0, 0, 131066);
                    TextKt.m352TextNvy7gAk(listenTogetherServer.url, null, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).typography.labelSmall, gapComposer4, 0, 24960, 110586);
                    gapComposer4.end(true);
                    if (z) {
                        gapComposer4.startReplaceGroup(1693722546);
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.done, 0, gapComposer4), (String) null, (Modifier) null, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer4, 56, 4);
                        gapComposer4.end(false);
                    } else {
                        gapComposer4.startReplaceGroup(1694010846);
                        gapComposer4.end(false);
                    }
                    gapComposer4.end(true);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ SliderKt$$ExternalSyntheticLambda1(boolean z, Object obj, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = obj;
    }
}
