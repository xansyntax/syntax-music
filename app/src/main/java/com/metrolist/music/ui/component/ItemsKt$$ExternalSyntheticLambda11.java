package com.metrolist.music.ui.component;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.media3.exoplayer.offline.Download;
import coil3.util.FileSystemsKt;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.playback.DownloadUtil;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ItemsKt$$ExternalSyntheticLambda11 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ YTItem f$0;

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda11(YTItem yTItem, byte b) {
        this.$r8$classId = b;
        this.f$0 = yTItem;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:79:0x01a4  */
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
        Song song;
        SongEntity songEntity;
        Song song2;
        SongEntity songEntity2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Icon icon = Icon.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        YTItem yTItem = this.f$0;
        RowScope rowScope = (RowScope) obj;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        switch (b) {
            case 0:
                rowScope.getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    MusicDatabase musicDatabase = (MusicDatabase) gapComposer.consume(MainActivityKt.LocalDatabase);
                    String id = yTItem.getId();
                    boolean zChangedInstance = gapComposer.changedInstance(yTItem) | gapComposer.changedInstance(musicDatabase);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new ItemsKt$YouTubeGridItem$1$song$2$1(yTItem, musicDatabase, null, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    MutableState mutableStateProduceState = Stack.produceState(null, id, (Function2) objRememberedValue, gapComposer);
                    String id2 = yTItem.getId();
                    boolean zChangedInstance2 = gapComposer.changedInstance(yTItem) | gapComposer.changedInstance(musicDatabase);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new ItemsKt$YouTubeGridItem$1$song$2$1(yTItem, musicDatabase, null, (byte) 1);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    MutableState mutableStateProduceState2 = Stack.produceState(null, id2, (Function2) objRememberedValue2, gapComposer);
                    boolean z = yTItem instanceof SongItem;
                    if (!z || (song = (Song) mutableStateProduceState.getValue()) == null || (songEntity = song.song) == null || !songEntity.liked) {
                        if (yTItem instanceof AlbumItem) {
                            Album album = (Album) mutableStateProduceState2.getValue();
                            if ((album != null ? album.album.bookmarkedAt : null) != null) {
                                gapComposer.startReplaceGroup(225225364);
                                icon.Favorite(6, gapComposer);
                                gapComposer.end(false);
                            }
                        }
                        gapComposer.startReplaceGroup(225262843);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(225225364);
                        icon.Favorite(6, gapComposer);
                        gapComposer.end(false);
                    }
                    if (yTItem.getExplicit()) {
                        gapComposer.startReplaceGroup(-269827055);
                        icon.Explicit(6, gapComposer);
                    } else {
                        gapComposer.startReplaceGroup(225305499);
                    }
                    gapComposer.end(false);
                    if (!z) {
                        gapComposer.startReplaceGroup(225578299);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(225421656);
                        Download download = (Download) FileSystemsKt.collectAsStateWithLifecycle(((DownloadUtil) gapComposer.consume(MainActivityKt.LocalDownloadUtil)).getDownload(((SongItem) yTItem).id), null, gapComposer, 48).getValue();
                        icon.Download(download != null ? Integer.valueOf(download.state) : null, gapComposer, 48);
                        gapComposer.end(false);
                    }
                }
                break;
            default:
                rowScope.getClass();
                GapComposer gapComposer2 = (GapComposer) composer;
                if (!gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    MusicDatabase musicDatabase2 = (MusicDatabase) gapComposer2.consume(MainActivityKt.LocalDatabase);
                    String id3 = yTItem.getId();
                    boolean zChangedInstance3 = gapComposer2.changedInstance(yTItem) | gapComposer2.changedInstance(musicDatabase2);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new ItemsKt$YouTubeGridItem$1$song$2$1(yTItem, musicDatabase2, null, (byte) 3);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    MutableState mutableStateProduceState3 = Stack.produceState(null, id3, (Function2) objRememberedValue3, gapComposer2);
                    String id4 = yTItem.getId();
                    boolean zChangedInstance4 = gapComposer2.changedInstance(yTItem) | gapComposer2.changedInstance(musicDatabase2);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new ItemsKt$YouTubeGridItem$1$song$2$1(yTItem, musicDatabase2, null, (byte) 2);
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    MutableState mutableStateProduceState4 = Stack.produceState(null, id4, (Function2) objRememberedValue4, gapComposer2);
                    boolean z2 = yTItem instanceof SongItem;
                    if (!z2 || (song2 = (Song) mutableStateProduceState3.getValue()) == null || (songEntity2 = song2.song) == null || !songEntity2.liked) {
                        if (yTItem instanceof AlbumItem) {
                            Album album2 = (Album) mutableStateProduceState4.getValue();
                            if ((album2 != null ? album2.album.bookmarkedAt : null) != null) {
                                gapComposer2.startReplaceGroup(185880208);
                                icon.Favorite(6, gapComposer2);
                                gapComposer2.end(false);
                            }
                        }
                        gapComposer2.startReplaceGroup(185917687);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(185880208);
                        icon.Favorite(6, gapComposer2);
                        gapComposer2.end(false);
                    }
                    if (yTItem.getExplicit()) {
                        gapComposer2.startReplaceGroup(-1795116907);
                        icon.Explicit(6, gapComposer2);
                    } else {
                        gapComposer2.startReplaceGroup(185960343);
                    }
                    gapComposer2.end(false);
                    if (!z2) {
                        gapComposer2.startReplaceGroup(186262903);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(186106260);
                        Download download2 = (Download) FileSystemsKt.collectAsStateWithLifecycle(((DownloadUtil) gapComposer2.consume(MainActivityKt.LocalDownloadUtil)).getDownload(((SongItem) yTItem).id), null, gapComposer2, 48).getValue();
                        icon.Download(download2 != null ? Integer.valueOf(download2.state) : null, gapComposer2, 48);
                        gapComposer2.end(false);
                    }
                }
                break;
        }
        return unit;
    }
}
