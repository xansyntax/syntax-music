package com.metrolist.music.ui.screens.playlist;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.PlaylistSongMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OnlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1 implements Function0 {
    public final /* synthetic */ List $filteredSongs;
    public final /* synthetic */ HapticFeedback $haptic;
    public final /* synthetic */ MutableState $inSelectMode$delegate;
    public final /* synthetic */ int $index;
    public final /* synthetic */ Function1 $onCheckedChange;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SnapshotStateList $selection;
    public final /* synthetic */ MutableState $selectionAnchorSongId$delegate;
    public final /* synthetic */ Object $songItem;

    public /* synthetic */ OnlinePlaylistScreenKt$OnlinePlaylistScreen$4$1$1$2$4$1$1(HapticFeedback hapticFeedback, Function1 function1, Object obj, int i, List list, SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, byte b) {
        this.$r8$classId = b;
        this.$haptic = hapticFeedback;
        this.$onCheckedChange = function1;
        this.$songItem = obj;
        this.$index = i;
        this.$filteredSongs = list;
        this.$selection = snapshotStateList;
        this.$inSelectMode$delegate = mutableState;
        this.$selectionAnchorSongId$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        HapticFeedback hapticFeedback = this.$haptic;
        MutableState mutableState = this.$inSelectMode$delegate;
        MutableState mutableState2 = this.$selectionAnchorSongId$delegate;
        int i = this.$index;
        int i2 = 0;
        Function1 function1 = this.$onCheckedChange;
        Object obj = this.$songItem;
        List list = this.$filteredSongs;
        SnapshotStateList snapshotStateList = this.$selection;
        switch (b) {
            case 0:
                String str = ((SongItem) obj).id;
                if (!TopPlaylistScreenKt.OnlinePlaylistScreen$lambda$20(mutableState)) {
                    ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                    Boolean bool = Boolean.TRUE;
                    mutableState.setValue(bool);
                    function1.invoke(bool);
                    mutableState2.setValue(str);
                } else {
                    String str2 = (String) mutableState2.getValue();
                    if (str2 != null) {
                        Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i2 = -1;
                            } else if (!Intrinsics.areEqual(((SongItem) ((Pair) it.next()).second).id, str2)) {
                                i2++;
                            }
                        }
                    } else {
                        i2 = -1;
                    }
                    if (i2 != -1) {
                        IntProgression intRange = i2 <= i ? new IntRange(i2, i, 1) : new IntProgression(i, i2, 1);
                        int i3 = intRange.first;
                        int i4 = intRange.last;
                        if (i3 <= i4) {
                            while (true) {
                                String str3 = ((SongItem) ((Pair) list.get(i3)).second).id;
                                if (!snapshotStateList.contains(str3)) {
                                    snapshotStateList.add(str3);
                                }
                                if (i3 != i4) {
                                    i3++;
                                }
                            }
                        }
                    } else {
                        function1.invoke(Boolean.TRUE);
                        mutableState2.setValue(str);
                    }
                }
                break;
            default:
                PlaylistSongMap playlistSongMap = ((PlaylistSong) obj).map;
                if (!LocalPlaylistScreenKt.LocalPlaylistScreen$lambda$21(mutableState)) {
                    ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                    Boolean bool2 = Boolean.TRUE;
                    mutableState.setValue(bool2);
                    function1.invoke(bool2);
                    mutableState2.setValue(Integer.valueOf(playlistSongMap.id));
                } else {
                    Integer num = (Integer) mutableState2.getValue();
                    if (num != null) {
                        int iIntValue = num.intValue();
                        Iterator it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                i2 = -1;
                            } else if (((PlaylistSong) it2.next()).map.id != iIntValue) {
                                i2++;
                            }
                        }
                    } else {
                        i2 = -1;
                    }
                    if (i2 != -1) {
                        IntProgression intRange2 = i2 <= i ? new IntRange(i2, i, 1) : new IntProgression(i, i2, 1);
                        int i5 = intRange2.first;
                        int i6 = intRange2.last;
                        if (i5 <= i6) {
                            while (true) {
                                int i7 = ((PlaylistSong) list.get(i5)).map.id;
                                if (!snapshotStateList.contains(Integer.valueOf(i7))) {
                                    snapshotStateList.add(Integer.valueOf(i7));
                                }
                                if (i5 != i6) {
                                    i5++;
                                }
                            }
                        }
                    } else {
                        function1.invoke(Boolean.TRUE);
                        mutableState2.setValue(Integer.valueOf(playlistSongMap.id));
                    }
                }
                break;
        }
        return unit;
    }
}
