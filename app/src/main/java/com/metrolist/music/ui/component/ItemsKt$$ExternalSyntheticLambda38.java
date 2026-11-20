package com.metrolist.music.ui.component;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.TextStyle;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.exoplayer.offline.Download;
import coil3.util.FileSystemsKt;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.playback.DownloadUtil;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ItemsKt$$ExternalSyntheticLambda38 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Playlist f$0;

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda38(Playlist playlist, byte b) {
        this.$r8$classId = b;
        this.f$0 = playlist;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0254  */
    /* JADX WARN: Code duplicated, block: B:96:0x037c  */
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
        Object obj5;
        byte b = this.$r8$classId;
        Icon icon = Icon.INSTANCE;
        EmptyList emptyList = EmptyList.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Continuation continuation = null;
        int i = 3;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        Playlist playlist = this.f$0;
        byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    DownloadUtil downloadUtil = (DownloadUtil) gapComposer.consume(MainActivityKt.LocalDownloadUtil);
                    MusicDatabase musicDatabase = (MusicDatabase) gapComposer.consume(MainActivityKt.LocalDatabase);
                    String str = playlist.playlist.id;
                    boolean zChangedInstance = gapComposer.changedInstance(musicDatabase) | gapComposer.changed(playlist);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        obj4 = objRememberedValue;
                        ItemsKt$PlaylistGridItem$1$songs$2$1 itemsKt$PlaylistGridItem$1$songs$2$1 = new ItemsKt$PlaylistGridItem$1$songs$2$1(musicDatabase, playlist, continuation, b2);
                        gapComposer.updateRememberedValue(itemsKt$PlaylistGridItem$1$songs$2$1);
                        obj4 = itemsKt$PlaylistGridItem$1$songs$2$1;
                    }
                    MutableState mutableStateProduceState = Stack.produceState(emptyList, str, (Function2) obj4, gapComposer);
                    MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(downloadUtil.downloads, gapComposer);
                    boolean zChanged = gapComposer.changed((List) mutableStateProduceState.getValue()) | gapComposer.changed((Map) mutableStateCollectAsStateWithLifecycle.getValue());
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    Object objM = objRememberedValue2;
                    if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                        if (((List) mutableStateProduceState.getValue()).isEmpty()) {
                            i = 1;
                        } else {
                            List list = (List) mutableStateProduceState.getValue();
                            if (list == null || !list.isEmpty()) {
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    Download download = (Download) ((Map) mutableStateCollectAsStateWithLifecycle.getValue()).get(((Song) it.next()).song.id);
                                    if (download == null || download.state != 3) {
                                        List list2 = (List) mutableStateProduceState.getValue();
                                        if (list2 == null || !list2.isEmpty()) {
                                            Iterator it2 = list2.iterator();
                                            while (true) {
                                                if (it2.hasNext()) {
                                                    Song song = (Song) it2.next();
                                                    List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Integer[]{0, 2});
                                                    Download download2 = (Download) ((Map) mutableStateCollectAsStateWithLifecycle.getValue()).get(song.song.id);
                                                    if (CollectionsKt.contains(listListOf, download2 != null ? Integer.valueOf(download2.state) : null)) {
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
                                }
                            }
                        }
                        objM = Fragment$5$$ExternalSyntheticOutline0.m(i, gapComposer);
                    }
                    icon.Download(Integer.valueOf(((ParcelableSnapshotMutableIntState) objM).getIntValue()), gapComposer, 48);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    DownloadUtil downloadUtil2 = (DownloadUtil) gapComposer2.consume(MainActivityKt.LocalDownloadUtil);
                    MusicDatabase musicDatabase2 = (MusicDatabase) gapComposer2.consume(MainActivityKt.LocalDatabase);
                    String str2 = playlist.playlist.id;
                    boolean zChangedInstance2 = gapComposer2.changedInstance(musicDatabase2) | gapComposer2.changed(playlist);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                        obj5 = objRememberedValue3;
                        ItemsKt$PlaylistGridItem$1$songs$2$1 itemsKt$PlaylistGridItem$1$songs$2$2 = new ItemsKt$PlaylistGridItem$1$songs$2$1(musicDatabase2, playlist, continuation, false ? (byte) 1 : (byte) 0);
                        gapComposer2.updateRememberedValue(itemsKt$PlaylistGridItem$1$songs$2$2);
                        obj5 = itemsKt$PlaylistGridItem$1$songs$2$2;
                    }
                    MutableState mutableStateProduceState2 = Stack.produceState(emptyList, str2, (Function2) obj5, gapComposer2);
                    MutableState mutableStateCollectAsStateWithLifecycle2 = FileSystemsKt.collectAsStateWithLifecycle(downloadUtil2.downloads, gapComposer2);
                    boolean zChanged2 = gapComposer2.changed((List) mutableStateProduceState2.getValue()) | gapComposer2.changed((Map) mutableStateCollectAsStateWithLifecycle2.getValue());
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    Object objM2 = objRememberedValue4;
                    if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                        if (((List) mutableStateProduceState2.getValue()).isEmpty()) {
                            i = 1;
                        } else {
                            List list3 = (List) mutableStateProduceState2.getValue();
                            if (list3 == null || !list3.isEmpty()) {
                                Iterator it3 = list3.iterator();
                                while (it3.hasNext()) {
                                    Download download3 = (Download) ((Map) mutableStateCollectAsStateWithLifecycle2.getValue()).get(((Song) it3.next()).song.id);
                                    if (download3 == null || download3.state != 3) {
                                        List list4 = (List) mutableStateProduceState2.getValue();
                                        if (list4 == null || !list4.isEmpty()) {
                                            Iterator it4 = list4.iterator();
                                            while (true) {
                                                if (it4.hasNext()) {
                                                    Song song2 = (Song) it4.next();
                                                    List listListOf2 = CollectionsKt__IterablesKt.listOf((Object[]) new Integer[]{0, 2});
                                                    Download download4 = (Download) ((Map) mutableStateCollectAsStateWithLifecycle2.getValue()).get(song2.song.id);
                                                    if (CollectionsKt.contains(listListOf2, download4 != null ? Integer.valueOf(download4.state) : null)) {
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
                                }
                            }
                        }
                        objM2 = Fragment$5$$ExternalSyntheticOutline0.m(i, gapComposer2);
                    }
                    icon.Download(Integer.valueOf(((ParcelableSnapshotMutableIntState) objM2).getIntValue()), gapComposer2, 48);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.remove_download_playlist_confirm, new Object[]{playlist.playlist.name}, gapComposer3), OffsetKt.m137paddingVpY3zN4$default(companion, 18.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer3, 48, 0, 131068);
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.delete_playlist_confirm, new Object[]{playlist.playlist.name}, gapComposer4), OffsetKt.m137paddingVpY3zN4$default(companion, 18.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer4, 48, 0, 131068);
                }
                break;
            default:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    if (playlist.playlist.browseId != null) {
                        gapComposer5.startReplaceGroup(637567119);
                        TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.edit_playlist_cover_note, gapComposer5), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer5.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer5, 0, 0, 131070);
                        OffsetKt.Spacer(gapComposer5, SizeKt.m145height3ABfNKs(companion, 8.0f));
                        gapComposer5.end(false);
                    } else {
                        gapComposer5.startReplaceGroup(637824667);
                        gapComposer5.end(false);
                    }
                    String strStringResource = MathKt.stringResource(R.string.edit_playlist_cover_note_wait, gapComposer5);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).typography.bodySmall;
                    long j = ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).colorScheme.onSurface;
                    TextKt.m352TextNvy7gAk(strStringResource, null, ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.7f, Color.m483getColorSpaceimpl(j)), 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer5, 0, 0, 131066);
                }
                break;
        }
        return unit;
    }
}
