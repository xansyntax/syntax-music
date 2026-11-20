package com.metrolist.music.ui.screens;

import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.media3.exoplayer.offline.Download;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.models.MediaMetadata;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumScreenKt$AlbumScreen$2$1$1 implements FlowCollector {
    public final /* synthetic */ ParcelableSnapshotMutableIntState $downloadState$delegate;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List $songs;

    public /* synthetic */ AlbumScreenKt$AlbumScreen$2$1$1(List list, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, byte b) {
        this.$r8$classId = b;
        this.$songs = list;
        this.$downloadState$delegate = parcelableSnapshotMutableIntState;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = 1;
        List<String> list = this.$songs;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.$downloadState$delegate;
        switch (b) {
            case 0:
                Map map = (Map) obj;
                if (list == null || !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Download download = (Download) map.get((String) it.next());
                        if (download == null || download.state != 3) {
                            if (list.isEmpty()) {
                                i = 2;
                            } else {
                                for (String str : list) {
                                    Download download2 = (Download) map.get(str);
                                    if (download2 == null || download2.state != 0) {
                                        Download download3 = (Download) map.get(str);
                                        if (download3 == null || download3.state != 2) {
                                            Download download4 = (Download) map.get(str);
                                            if (download4 == null || download4.state != 3) {
                                            }
                                        }
                                    }
                                }
                                i = 2;
                            }
                        }
                    }
                    i = 3;
                } else {
                    i = 3;
                }
                parcelableSnapshotMutableIntState.setIntValue(i);
                break;
            case 1:
                Map map2 = (Map) obj;
                if (list == null || !list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        Download download5 = (Download) map2.get(((MediaMetadata) it2.next()).id);
                        if (download5 == null || download5.state != 3) {
                            if (list.isEmpty()) {
                                i = 2;
                            } else {
                                Iterator it3 = list.iterator();
                                while (it3.hasNext()) {
                                    String str2 = ((MediaMetadata) it3.next()).id;
                                    Download download6 = (Download) map2.get(str2);
                                    if (download6 == null || download6.state != 0) {
                                        Download download7 = (Download) map2.get(str2);
                                        if (download7 == null || download7.state != 2) {
                                            Download download8 = (Download) map2.get(str2);
                                            if (download8 == null || download8.state != 3) {
                                            }
                                        }
                                    }
                                }
                                i = 2;
                            }
                        }
                    }
                    i = 3;
                } else {
                    i = 3;
                }
                parcelableSnapshotMutableIntState.setIntValue(i);
                break;
            case 2:
                Map map3 = (Map) obj;
                if (list == null || !list.isEmpty()) {
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        Download download9 = (Download) map3.get(((SongItem) it4.next()).id);
                        if (download9 == null || download9.state != 3) {
                            if (list.isEmpty()) {
                                i = 2;
                            } else {
                                Iterator it5 = list.iterator();
                                while (it5.hasNext()) {
                                    String str3 = ((SongItem) it5.next()).id;
                                    Download download10 = (Download) map3.get(str3);
                                    if (download10 == null || download10.state != 0) {
                                        Download download11 = (Download) map3.get(str3);
                                        if (download11 == null || download11.state != 2) {
                                            Download download12 = (Download) map3.get(str3);
                                            if (download12 == null || download12.state != 3) {
                                            }
                                        }
                                    }
                                }
                                i = 2;
                            }
                        }
                    }
                    i = 3;
                } else {
                    i = 3;
                }
                parcelableSnapshotMutableIntState.setIntValue(i);
                break;
            default:
                Map map4 = (Map) obj;
                if (list == null || !list.isEmpty()) {
                    Iterator it6 = list.iterator();
                    while (it6.hasNext()) {
                        Download download13 = (Download) map4.get(((PlaylistSong) it6.next()).song.song.id);
                        if (download13 == null || download13.state != 3) {
                            if (list.isEmpty()) {
                                i = 2;
                            } else {
                                Iterator it7 = list.iterator();
                                while (it7.hasNext()) {
                                    SongEntity songEntity = ((PlaylistSong) it7.next()).song.song;
                                    Download download14 = (Download) map4.get(songEntity.id);
                                    if (download14 == null || download14.state != 0) {
                                        Download download15 = (Download) map4.get(songEntity.id);
                                        if (download15 == null || download15.state != 2) {
                                            Download download16 = (Download) map4.get(songEntity.id);
                                            if (download16 == null || download16.state != 3) {
                                            }
                                        }
                                    }
                                }
                                i = 2;
                            }
                        }
                    }
                    i = 3;
                } else {
                    i = 3;
                }
                parcelableSnapshotMutableIntState.setIntValue(i);
                break;
        }
        return unit;
    }
}
