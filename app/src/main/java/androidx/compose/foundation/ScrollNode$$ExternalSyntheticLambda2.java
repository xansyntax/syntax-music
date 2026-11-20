package androidx.compose.foundation;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.TextFieldScrollerPosition;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.VerticalScrollLayoutModifier;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionImpl;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.input.TransformedText;
import androidx.media3.common.Timeline;
import androidx.navigation.NavHostController;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.util.FileSystemsKt;
import com.google.common.math.IntMath;
import com.metrolist.innertube.pages.MoodAndGenres;
import com.metrolist.music.db.Converters;
import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.ui.component.HideOnScrollFABKt$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import io.ktor.http.ContentDisposition;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ScrollNode$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ ScrollNode$$ExternalSyntheticLambda2(int i, SnapshotStateList snapshotStateList, List list) {
        this.$r8$classId = (byte) 5;
        this.f$1 = i;
        this.f$0 = snapshotStateList;
        this.f$2 = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        int i;
        int i2;
        int i3;
        Long lValueOf;
        int i4 = 8;
        char c = 7;
        byte b = 2;
        int i5 = 0;
        Object[] objArr = 0;
        switch (this.$r8$classId) {
            case 0:
                Unit unit = Unit.INSTANCE;
                ScrollNode scrollNode = (ScrollNode) this.f$0;
                int i6 = this.f$1;
                Placeable placeable = (Placeable) this.f$2;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                int intValue = scrollNode.state.value$delegate.getIntValue();
                int i7 = intValue < 0 ? 0 : intValue;
                if (i7 <= i6) {
                    i6 = i7;
                }
                int i8 = -i6;
                boolean z = scrollNode.isVertical;
                int i9 = z ? 0 : i8;
                int i10 = z ? i8 : 0;
                placementScope.motionFrameOfReferencePlacement = true;
                Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable, i9, i10, null, 12);
                placementScope.motionFrameOfReferencePlacement = false;
                return unit;
            case 1:
                VerticalScrollLayoutModifier verticalScrollLayoutModifier = (VerticalScrollLayoutModifier) this.f$0;
                Placeable placeable2 = (Placeable) this.f$2;
                int i11 = this.f$1;
                Placeable.PlacementScope placementScope2 = (Placeable.PlacementScope) obj;
                int i12 = verticalScrollLayoutModifier.cursorOffset;
                TextFieldScrollerPosition textFieldScrollerPosition = verticalScrollLayoutModifier.scrollerPosition;
                TransformedText transformedText = verticalScrollLayoutModifier.transformedText;
                TextLayoutResultProxy textLayoutResultProxy = (TextLayoutResultProxy) verticalScrollLayoutModifier.textLayoutResultProvider.invoke();
                textFieldScrollerPosition.update(Orientation.Vertical, BasicTextKt.getCursorRectInScroller(placementScope2, i12, transformedText, textLayoutResultProxy != null ? textLayoutResultProxy.value : null, false, placeable2.width), i11, placeable2.height);
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, 0, Math.round(-textFieldScrollerPosition.offset$delegate.getFloatValue()));
                return Unit.INSTANCE;
            case 2:
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) this.f$0;
                int i13 = this.f$1;
                MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) this.f$2;
                Composition composition = (Composition) obj;
                if (recomposeScopeImpl.currentToken == i13 && Intrinsics.areEqual(mutableObjectIntMap, recomposeScopeImpl.trackedInstances) && (composition instanceof CompositionImpl)) {
                    long[] jArr = mutableObjectIntMap.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i14 = 0;
                        while (true) {
                            long j = jArr[i14];
                            if ((((~j) << c) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i15 = 8 - ((~(i14 - length)) >>> 31);
                                long j2 = j;
                                int i16 = 0;
                                while (i16 < i15) {
                                    if ((255 & j2) < 128) {
                                        int i17 = (i14 << 3) + i16;
                                        Object obj2 = mutableObjectIntMap.keys[i17];
                                        boolean z2 = mutableObjectIntMap.values[i17] != i13;
                                        if (z2) {
                                            CompositionImpl compositionImpl = (CompositionImpl) composition;
                                            i2 = i4;
                                            MutableScatterMap mutableScatterMap = compositionImpl.observations;
                                            IntMath.m902removeimpl(mutableScatterMap, obj2, recomposeScopeImpl);
                                            i3 = i13;
                                            if (obj2 instanceof DerivedSnapshotState) {
                                                DerivedSnapshotState derivedSnapshotState = (DerivedSnapshotState) obj2;
                                                if (!mutableScatterMap.containsKey(derivedSnapshotState)) {
                                                    IntMath.m903removeScopeimpl(compositionImpl.derivedStates, derivedSnapshotState);
                                                }
                                                MutableScatterMap mutableScatterMap2 = recomposeScopeImpl.trackedDependencies;
                                                if (mutableScatterMap2 != null) {
                                                    mutableScatterMap2.remove(obj2);
                                                }
                                            }
                                        } else {
                                            i2 = i4;
                                            i3 = i13;
                                        }
                                        if (z2) {
                                            mutableObjectIntMap.removeValueAt(i17);
                                        }
                                    } else {
                                        i2 = i4;
                                        i3 = i13;
                                    }
                                    j2 >>= i2;
                                    i16++;
                                    i4 = i2;
                                    i13 = i3;
                                }
                                i = i13;
                                if (i15 == i4) {
                                }
                            } else {
                                i = i13;
                            }
                            if (i14 != length) {
                                i14++;
                                i13 = i;
                                c = 7;
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            case 3:
                LocalDateTime localDateTime = (LocalDateTime) this.f$0;
                LocalDateTime localDateTime2 = (LocalDateTime) this.f$2;
                int i18 = this.f$1;
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("\n        SELECT artist.*,\n               (SELECT COUNT(1)\n                FROM song_artist_map\n                         JOIN event ON song_artist_map.songId = event.songId\n                WHERE artistId = artist.id\n                  AND timestamp > ? AND timestamp <= ?) AS songCount,\n               (SELECT SUM(event.playTime)\n                FROM song_artist_map\n                         JOIN event ON song_artist_map.songId = event.songId\n                WHERE artistId = artist.id\n                  AND timestamp > ? AND timestamp <= ?) AS timeListened\n        FROM artist\n                 JOIN(SELECT artistId, SUM(songTotalPlayTime) AS totalPlayTime\n                      FROM song_artist_map\n                               JOIN (SELECT songId, SUM(playTime) AS songTotalPlayTime\n                                     FROM event\n                                     WHERE timestamp > ?\n                                     AND timestamp <= ?\n                                     GROUP BY songId) AS e\n                                    ON song_artist_map.songId = e.songId\n                      GROUP BY artistId\n                      ORDER BY totalPlayTime DESC\n                      LIMIT ?\n                      OFFSET ?)\n                     ON artist.id = artistId\n    ");
                try {
                    Long lDateToTimestamp = Converters.dateToTimestamp(localDateTime);
                    if (lDateToTimestamp == null) {
                        sQLiteStatementPrepare.bindNull(1);
                    } else {
                        sQLiteStatementPrepare.bindLong(1, lDateToTimestamp.longValue());
                    }
                    Long lDateToTimestamp2 = Converters.dateToTimestamp(localDateTime2);
                    if (lDateToTimestamp2 == null) {
                        sQLiteStatementPrepare.bindNull(2);
                    } else {
                        sQLiteStatementPrepare.bindLong(2, lDateToTimestamp2.longValue());
                    }
                    Long lDateToTimestamp3 = Converters.dateToTimestamp(localDateTime);
                    if (lDateToTimestamp3 == null) {
                        sQLiteStatementPrepare.bindNull(3);
                    } else {
                        sQLiteStatementPrepare.bindLong(3, lDateToTimestamp3.longValue());
                    }
                    Long lDateToTimestamp4 = Converters.dateToTimestamp(localDateTime2);
                    if (lDateToTimestamp4 == null) {
                        sQLiteStatementPrepare.bindNull(4);
                    } else {
                        sQLiteStatementPrepare.bindLong(4, lDateToTimestamp4.longValue());
                    }
                    Long lDateToTimestamp5 = Converters.dateToTimestamp(localDateTime);
                    if (lDateToTimestamp5 == null) {
                        sQLiteStatementPrepare.bindNull(5);
                    } else {
                        sQLiteStatementPrepare.bindLong(5, lDateToTimestamp5.longValue());
                    }
                    Long lDateToTimestamp6 = Converters.dateToTimestamp(localDateTime2);
                    if (lDateToTimestamp6 == null) {
                        sQLiteStatementPrepare.bindNull(6);
                    } else {
                        sQLiteStatementPrepare.bindLong(6, lDateToTimestamp6.longValue());
                    }
                    sQLiteStatementPrepare.bindLong(7, i18);
                    sQLiteStatementPrepare.bindLong(8, 0L);
                    int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                    int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, ContentDisposition.Parameters.Name);
                    int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
                    int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "channelId");
                    int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdateTime");
                    int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "bookmarkedAt");
                    int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
                    int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isPodcastChannel");
                    int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "cachedPageJson");
                    int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songCount");
                    int columnIndexOrThrow11 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "timeListened");
                    ArrayList arrayList = new ArrayList();
                    while (sQLiteStatementPrepare.step()) {
                        int i19 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10);
                        Integer numValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow11));
                        String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                        String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                        String text4 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow5)));
                        if (localDateTimeFromTimestamp == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        if (sQLiteStatementPrepare.isNull(columnIndexOrThrow6)) {
                            columnIndexOrThrow6 = columnIndexOrThrow6;
                            lValueOf = null;
                        } else {
                            columnIndexOrThrow6 = columnIndexOrThrow6;
                            lValueOf = Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow6));
                        }
                        int i20 = columnIndexOrThrow5;
                        arrayList.add(new Artist(new ArtistEntity(text, text2, text3, text4, localDateTimeFromTimestamp, Converters.fromTimestamp(lValueOf), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow9)), i19, numValueOf));
                        columnIndexOrThrow5 = i20;
                    }
                    sQLiteStatementPrepare.close();
                    return arrayList;
                } catch (Throwable th) {
                    sQLiteStatementPrepare.close();
                    throw th;
                }
            case 4:
                MediaMetadata mediaMetadata = (MediaMetadata) this.f$0;
                Song song = (Song) this.f$2;
                int i21 = this.f$1;
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                boolean z3 = MusicService.isRunning;
                musicDatabase.getClass();
                if (mediaMetadata != null && (song == null || song.getOrderedArtists().isEmpty())) {
                    musicDatabase.insert(MediaMetadata.copy$default(mediaMetadata, null, i21, null, 131063), new DatabaseDao$$ExternalSyntheticLambda0(objArr == true ? 1 : 0));
                }
                if (song != null) {
                    SongEntity songEntity = song.song;
                    SongEntity songEntityCopy$default = songEntity.duration == -1 ? SongEntity.copy$default(songEntity, null, i21, null, null, null, false, null, null, null, null, null, 0, false, false, false, null, 134217723) : songEntity;
                    if (mediaMetadata != null && songEntity.isVideo != mediaMetadata.isVideoSong()) {
                        songEntityCopy$default = SongEntity.copy$default(songEntityCopy$default, null, 0, null, null, null, false, null, null, null, null, null, 0, false, false, mediaMetadata.isVideoSong(), null, 130023423);
                    }
                    if (!songEntityCopy$default.equals(songEntity)) {
                        musicDatabase.$$delegate_0.update(songEntityCopy$default);
                    }
                }
                return Unit.INSTANCE;
            case 5:
                int i22 = this.f$1;
                SnapshotStateList snapshotStateList = (SnapshotStateList) this.f$0;
                List list = (List) this.f$2;
                ((Boolean) obj).booleanValue();
                if (i22 == snapshotStateList.size()) {
                    list.clear();
                } else {
                    list.clear();
                    Iterator it = snapshotStateList.iterator();
                    while (it.hasNext()) {
                        String str = ((Timeline.Window) it.next()).mediaItem.mediaId;
                        str.getClass();
                        list.add(str);
                    }
                }
                return Unit.INSTANCE;
            default:
                State state = (State) this.f$0;
                int i23 = this.f$1;
                NavHostController navHostController = (NavHostController) this.f$2;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                if (((List) state.getValue()) == null) {
                    LazyListIntervalContent.item$default(lazyListIntervalContent, "mood_and_genres_shimmer", null, AlbumScreenKt.f319lambda$263250395, 2);
                }
                List list2 = (List) state.getValue();
                if (list2 != null) {
                    for (Object obj3 : list2) {
                        int i24 = i5 + 1;
                        if (i5 < 0) {
                            CollectionsKt__IterablesKt.throwIndexOverflow();
                            throw null;
                        }
                        LazyListIntervalContent.item$default(lazyListIntervalContent, IntIntPair$$ExternalSyntheticOutline0.m(i5, "mood_and_genres_section_"), null, new ComposableLambdaImpl(true, -1876610870, new HideOnScrollFABKt$$ExternalSyntheticLambda1((MoodAndGenres) obj3, i23, navHostController, b)), 2);
                        i5 = i24;
                    }
                }
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ ScrollNode$$ExternalSyntheticLambda2(DatabaseDao_Impl databaseDao_Impl, LocalDateTime localDateTime, LocalDateTime localDateTime2, int i) {
        this.$r8$classId = (byte) 3;
        this.f$0 = localDateTime;
        this.f$2 = localDateTime2;
        this.f$1 = i;
    }

    public /* synthetic */ ScrollNode$$ExternalSyntheticLambda2(Object obj, int i, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = i;
        this.f$2 = obj2;
    }

    public /* synthetic */ ScrollNode$$ExternalSyntheticLambda2(Object obj, Object obj2, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$2 = obj2;
        this.f$1 = i;
    }
}
