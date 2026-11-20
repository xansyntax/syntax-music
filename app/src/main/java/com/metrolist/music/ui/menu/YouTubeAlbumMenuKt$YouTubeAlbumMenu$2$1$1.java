package com.metrolist.music.ui.menu;

import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.media3.exoplayer.offline.Download;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubeAlbumMenuKt$YouTubeAlbumMenu$2$1$1 implements FlowCollector {
    public final /* synthetic */ ParcelableSnapshotMutableIntState $downloadState$delegate;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ArrayList $songs;

    public /* synthetic */ YouTubeAlbumMenuKt$YouTubeAlbumMenu$2$1$1(ArrayList arrayList, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, byte b) {
        this.$r8$classId = b;
        this.$songs = arrayList;
        this.$downloadState$delegate = parcelableSnapshotMutableIntState;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ArrayList arrayList = this.$songs;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.$downloadState$delegate;
        int i = 3;
        int i2 = 0;
        switch (b) {
            case 0:
                Map map = (Map) obj;
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj2 = arrayList.get(i3);
                        i3++;
                        Download download = (Download) map.get((String) obj2);
                        if (download == null || download.state != 3) {
                            if (arrayList.isEmpty()) {
                                i = 2;
                            } else {
                                int size2 = arrayList.size();
                                while (i2 < size2) {
                                    Object obj3 = arrayList.get(i2);
                                    i2++;
                                    String str = (String) obj3;
                                    Download download2 = (Download) map.get(str);
                                    if (download2 == null || download2.state != 0) {
                                        Download download3 = (Download) map.get(str);
                                        if (download3 == null || download3.state != 2) {
                                            Download download4 = (Download) map.get(str);
                                            if (download4 == null || download4.state != 3) {
                                                i = 1;
                                            }
                                        }
                                    }
                                }
                                i = 2;
                            }
                        }
                    }
                }
                parcelableSnapshotMutableIntState.setIntValue(i);
                break;
            case 1:
                Map map2 = (Map) obj;
                if (!arrayList.isEmpty()) {
                    int size3 = arrayList.size();
                    int i4 = 0;
                    while (i4 < size3) {
                        Object obj4 = arrayList.get(i4);
                        i4++;
                        Download download5 = (Download) map2.get(((Song) obj4).song.id);
                        if (download5 == null || download5.state != 3) {
                            if (arrayList.isEmpty()) {
                                i = 2;
                            } else {
                                int size4 = arrayList.size();
                                while (i2 < size4) {
                                    Object obj5 = arrayList.get(i2);
                                    i2++;
                                    SongEntity songEntity = ((Song) obj5).song;
                                    String str2 = songEntity.id;
                                    String str3 = songEntity.id;
                                    Download download6 = (Download) map2.get(str2);
                                    if (download6 == null || download6.state != 0) {
                                        Download download7 = (Download) map2.get(str3);
                                        if (download7 == null || download7.state != 2) {
                                            Download download8 = (Download) map2.get(str3);
                                            if (download8 == null || download8.state != 3) {
                                                i = 1;
                                            }
                                        }
                                    }
                                }
                                i = 2;
                            }
                        }
                    }
                }
                parcelableSnapshotMutableIntState.setIntValue(i);
                break;
            default:
                Map map3 = (Map) obj;
                if (!arrayList.isEmpty()) {
                    int size5 = arrayList.size();
                    int i5 = 0;
                    while (i5 < size5) {
                        Object obj6 = arrayList.get(i5);
                        i5++;
                        Download download9 = (Download) map3.get(((SongItem) obj6).id);
                        if (download9 == null || download9.state != 3) {
                            if (arrayList.isEmpty()) {
                                i = 2;
                            } else {
                                int size6 = arrayList.size();
                                while (i2 < size6) {
                                    Object obj7 = arrayList.get(i2);
                                    i2++;
                                    String str4 = ((SongItem) obj7).id;
                                    Download download10 = (Download) map3.get(str4);
                                    if (download10 == null || download10.state != 0) {
                                        Download download11 = (Download) map3.get(str4);
                                        if (download11 == null || download11.state != 2) {
                                            Download download12 = (Download) map3.get(str4);
                                            if (download12 == null || download12.state != 3) {
                                                i = 1;
                                            }
                                        }
                                    }
                                }
                                i = 2;
                            }
                        }
                    }
                }
                parcelableSnapshotMutableIntState.setIntValue(i);
                break;
        }
        return unit;
    }
}
