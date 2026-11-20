package com.metrolist.music.ui.screens.playlist;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$1$1 implements Function0 {
    public final /* synthetic */ List $filteredSongs;
    public final /* synthetic */ HapticFeedback $haptic;
    public final /* synthetic */ MutableState $inSelectMode$delegate;
    public final /* synthetic */ int $index;
    public final /* synthetic */ Function1 $onCheckedChange;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List $selection;
    public final /* synthetic */ MutableState $selectionAnchorSongId$delegate;
    public final /* synthetic */ Song $song;

    public /* synthetic */ TopPlaylistScreenKt$TopPlaylistScreen$8$1$1$4$1$1(HapticFeedback hapticFeedback, Function1 function1, Song song, int i, List list, List list2, MutableState mutableState, MutableState mutableState2, byte b) {
        this.$r8$classId = b;
        this.$haptic = hapticFeedback;
        this.$onCheckedChange = function1;
        this.$song = song;
        this.$index = i;
        this.$filteredSongs = list;
        this.$selection = list2;
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
        Song song = this.$song;
        List list = this.$filteredSongs;
        List list2 = this.$selection;
        switch (b) {
            case 0:
                SongEntity songEntity = song.song;
                if (!TopPlaylistScreenKt.TopPlaylistScreen$lambda$15(mutableState)) {
                    ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                    Boolean bool = Boolean.TRUE;
                    mutableState.setValue(bool);
                    function1.invoke(bool);
                    mutableState2.setValue(songEntity.id);
                } else {
                    String str = (String) mutableState2.getValue();
                    if (str != null) {
                        Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i2 = -1;
                            } else if (!Intrinsics.areEqual(((Song) it.next()).song.id, str)) {
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
                                String str2 = ((Song) list.get(i3)).song.id;
                                if (!list2.contains(str2)) {
                                    list2.add(str2);
                                }
                                if (i3 != i4) {
                                    i3++;
                                }
                            }
                        }
                    } else {
                        function1.invoke(Boolean.TRUE);
                        mutableState2.setValue(songEntity.id);
                    }
                }
                break;
            case 1:
                SongEntity songEntity2 = song.song;
                if (!TopPlaylistScreenKt.AutoPlaylistScreen$lambda$16(mutableState)) {
                    ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                    Boolean bool2 = Boolean.TRUE;
                    mutableState.setValue(bool2);
                    function1.invoke(bool2);
                    mutableState2.setValue(songEntity2.id);
                } else {
                    String str3 = (String) mutableState2.getValue();
                    if (str3 != null) {
                        Iterator it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                i2 = -1;
                            } else if (!Intrinsics.areEqual(((Song) it2.next()).song.id, str3)) {
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
                                String str4 = ((Song) list.get(i5)).song.id;
                                if (!list2.contains(str4)) {
                                    list2.add(str4);
                                }
                                if (i5 != i6) {
                                    i5++;
                                }
                            }
                        }
                    } else {
                        function1.invoke(Boolean.TRUE);
                        mutableState2.setValue(songEntity2.id);
                    }
                }
                break;
            default:
                SongEntity songEntity3 = song.song;
                if (!TopPlaylistScreenKt.CachePlaylistScreen$lambda$7(mutableState)) {
                    ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(0);
                    Boolean bool3 = Boolean.TRUE;
                    mutableState.setValue(bool3);
                    function1.invoke(bool3);
                    mutableState2.setValue(songEntity3.id);
                } else {
                    String str5 = (String) mutableState2.getValue();
                    if (str5 != null) {
                        Iterator it3 = list.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                i2 = -1;
                            } else if (!Intrinsics.areEqual(((Song) it3.next()).song.id, str5)) {
                                i2++;
                            }
                        }
                    } else {
                        i2 = -1;
                    }
                    if (i2 != -1) {
                        IntProgression intRange3 = i2 <= i ? new IntRange(i2, i, 1) : new IntProgression(i, i2, 1);
                        int i7 = intRange3.first;
                        int i8 = intRange3.last;
                        if (i7 <= i8) {
                            while (true) {
                                String str6 = ((Song) list.get(i7)).song.id;
                                if (!list2.contains(str6)) {
                                    list2.add(str6);
                                }
                                if (i7 != i8) {
                                    i7++;
                                }
                            }
                        }
                    } else {
                        function1.invoke(Boolean.TRUE);
                        mutableState2.setValue(songEntity3.id);
                    }
                }
                break;
        }
        return unit;
    }
}
