package com.metrolist.music.ui.screens.library;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.AlbumSortType;
import com.metrolist.music.constants.ArtistSongSortType;
import com.metrolist.music.constants.ArtistSortType;
import com.metrolist.music.constants.MixSortType;
import com.metrolist.music.constants.MyTopFilter;
import com.metrolist.music.constants.PlaylistSongSortType;
import com.metrolist.music.constants.PlaylistSortType;
import com.metrolist.music.constants.SongSortType;
import com.yalantis.ucrop.R;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1 implements Function3 {
    public final /* synthetic */ MutableState $menuExpanded$delegate;
    public final /* synthetic */ Function1 $onSortTypeChange;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Enum $sortType;

    /* JADX INFO: renamed from: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Enum $type;

        public /* synthetic */ AnonymousClass1(Enum r1, byte b) {
            this.$r8$classId = b;
            this.$type = r1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            int i;
            byte b = this.$r8$classId;
            int i2 = R.string.sort_by_last_updated;
            int i3 = R.string.sort_by_song_count;
            int i4 = R.string.sort_by_artist;
            int i5 = R.string.sort_by_play_time;
            Unit unit = Unit.INSTANCE;
            Enum r0 = this.$type;
            switch (b) {
                case 0:
                    Composer composer = (Composer) obj;
                    int iIntValue = ((Number) obj2).intValue();
                    GapComposer gapComposer = (GapComposer) composer;
                    if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        gapComposer.skipToGroupEnd();
                        return unit;
                    }
                    int iOrdinal = ((MixSortType) r0).ordinal();
                    if (iOrdinal == 0) {
                        i2 = R.string.sort_by_create_date;
                    } else if (iOrdinal == 1) {
                        i2 = R.string.sort_by_name;
                    } else if (iOrdinal != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(i2, gapComposer), null, 0L, IntMath.getSp(16), null, FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 1597440, 0, 262062);
                    return unit;
                case 1:
                    Composer composer2 = (Composer) obj;
                    int iIntValue2 = ((Number) obj2).intValue();
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                        gapComposer2.skipToGroupEnd();
                        return unit;
                    }
                    int iOrdinal2 = ((ArtistSongSortType) r0).ordinal();
                    if (iOrdinal2 == 0) {
                        i5 = R.string.sort_by_create_date;
                    } else if (iOrdinal2 == 1) {
                        i5 = R.string.sort_by_name;
                    } else if (iOrdinal2 != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(i5, gapComposer2), null, 0L, IntMath.getSp(16), null, FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 1597440, 0, 262062);
                    return unit;
                case 2:
                    Composer composer3 = (Composer) obj;
                    int iIntValue3 = ((Number) obj2).intValue();
                    GapComposer gapComposer3 = (GapComposer) composer3;
                    if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                        gapComposer3.skipToGroupEnd();
                        return unit;
                    }
                    switch (((AlbumSortType) r0).ordinal()) {
                        case 0:
                            i3 = R.string.sort_by_create_date;
                            break;
                        case 1:
                            i3 = R.string.sort_by_name;
                            break;
                        case 2:
                            i3 = R.string.sort_by_artist;
                            break;
                        case 3:
                            i3 = R.string.sort_by_year;
                            break;
                        case 4:
                            break;
                        case 5:
                            i3 = R.string.sort_by_length;
                            break;
                        case 6:
                            i3 = R.string.sort_by_play_time;
                            break;
                        default:
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                    }
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(i3, gapComposer3), null, 0L, IntMath.getSp(16), null, FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 1597440, 0, 262062);
                    return unit;
                case 3:
                    Composer composer4 = (Composer) obj;
                    int iIntValue4 = ((Number) obj2).intValue();
                    GapComposer gapComposer4 = (GapComposer) composer4;
                    if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                        gapComposer4.skipToGroupEnd();
                        return unit;
                    }
                    int iOrdinal3 = ((ArtistSortType) r0).ordinal();
                    if (iOrdinal3 == 0) {
                        i3 = R.string.sort_by_create_date;
                    } else if (iOrdinal3 == 1) {
                        i3 = R.string.sort_by_name;
                    } else if (iOrdinal3 != 2) {
                        if (iOrdinal3 != 3) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i3 = R.string.sort_by_play_time;
                    }
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(i3, gapComposer4), null, 0L, IntMath.getSp(16), null, FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 1597440, 0, 262062);
                    return unit;
                case 4:
                    Composer composer5 = (Composer) obj;
                    int iIntValue5 = ((Number) obj2).intValue();
                    GapComposer gapComposer5 = (GapComposer) composer5;
                    if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                        gapComposer5.skipToGroupEnd();
                        return unit;
                    }
                    int iOrdinal4 = ((PlaylistSortType) r0).ordinal();
                    if (iOrdinal4 == 0) {
                        i2 = R.string.sort_by_create_date;
                    } else if (iOrdinal4 == 1) {
                        i2 = R.string.sort_by_name;
                    } else if (iOrdinal4 == 2) {
                        i2 = R.string.sort_by_song_count;
                    } else if (iOrdinal4 != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(i2, gapComposer5), null, 0L, IntMath.getSp(16), null, FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 1597440, 0, 262062);
                    return unit;
                case 5:
                    Composer composer6 = (Composer) obj;
                    int iIntValue6 = ((Number) obj2).intValue();
                    GapComposer gapComposer6 = (GapComposer) composer6;
                    if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                        gapComposer6.skipToGroupEnd();
                        return unit;
                    }
                    int iOrdinal5 = ((SongSortType) r0).ordinal();
                    if (iOrdinal5 == 0) {
                        i4 = R.string.sort_by_create_date;
                    } else if (iOrdinal5 == 1) {
                        i4 = R.string.sort_by_name;
                    } else if (iOrdinal5 != 2) {
                        if (iOrdinal5 != 3) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i4 = R.string.sort_by_play_time;
                    }
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(i4, gapComposer6), null, 0L, IntMath.getSp(16), null, FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 1597440, 0, 262062);
                    return unit;
                case 6:
                    Composer composer7 = (Composer) obj;
                    int iIntValue7 = ((Number) obj2).intValue();
                    GapComposer gapComposer7 = (GapComposer) composer7;
                    if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                        gapComposer7.skipToGroupEnd();
                        return unit;
                    }
                    int iOrdinal6 = ((SongSortType) r0).ordinal();
                    if (iOrdinal6 == 0) {
                        i4 = R.string.sort_by_create_date;
                    } else if (iOrdinal6 == 1) {
                        i4 = R.string.sort_by_name;
                    } else if (iOrdinal6 != 2) {
                        if (iOrdinal6 != 3) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i4 = R.string.sort_by_play_time;
                    }
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(i4, gapComposer7), null, 0L, IntMath.getSp(16), null, FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 1597440, 0, 262062);
                    return unit;
                case 7:
                    Composer composer8 = (Composer) obj;
                    int iIntValue8 = ((Number) obj2).intValue();
                    GapComposer gapComposer8 = (GapComposer) composer8;
                    if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                        gapComposer8.skipToGroupEnd();
                        return unit;
                    }
                    int iOrdinal7 = ((SongSortType) r0).ordinal();
                    if (iOrdinal7 == 0) {
                        i4 = R.string.sort_by_create_date;
                    } else if (iOrdinal7 == 1) {
                        i4 = R.string.sort_by_name;
                    } else if (iOrdinal7 != 2) {
                        if (iOrdinal7 != 3) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i4 = R.string.sort_by_play_time;
                    }
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(i4, gapComposer8), null, 0L, IntMath.getSp(16), null, FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer8, 1597440, 0, 262062);
                    return unit;
                case 8:
                    Composer composer9 = (Composer) obj;
                    int iIntValue9 = ((Number) obj2).intValue();
                    GapComposer gapComposer9 = (GapComposer) composer9;
                    if (!gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                        gapComposer9.skipToGroupEnd();
                        return unit;
                    }
                    int iOrdinal8 = ((SongSortType) r0).ordinal();
                    if (iOrdinal8 == 0) {
                        i4 = R.string.sort_by_create_date;
                    } else if (iOrdinal8 == 1) {
                        i4 = R.string.sort_by_name;
                    } else if (iOrdinal8 != 2) {
                        if (iOrdinal8 != 3) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i4 = R.string.sort_by_play_time;
                    }
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(i4, gapComposer9), null, 0L, IntMath.getSp(16), null, FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer9, 1597440, 0, 262062);
                    return unit;
                case 9:
                    Composer composer10 = (Composer) obj;
                    int iIntValue10 = ((Number) obj2).intValue();
                    GapComposer gapComposer10 = (GapComposer) composer10;
                    if (!gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                        gapComposer10.skipToGroupEnd();
                        return unit;
                    }
                    int iOrdinal9 = ((PlaylistSongSortType) r0).ordinal();
                    if (iOrdinal9 == 0) {
                        i4 = R.string.sort_by_custom;
                    } else if (iOrdinal9 == 1) {
                        i4 = R.string.sort_by_create_date;
                    } else if (iOrdinal9 == 2) {
                        i4 = R.string.sort_by_name;
                    } else if (iOrdinal9 != 3) {
                        if (iOrdinal9 != 4) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i4 = R.string.sort_by_play_time;
                    }
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(i4, gapComposer10), null, 0L, IntMath.getSp(16), null, FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer10, 1597440, 0, 262062);
                    return unit;
                default:
                    Composer composer11 = (Composer) obj;
                    int iIntValue11 = ((Number) obj2).intValue();
                    GapComposer gapComposer11 = (GapComposer) composer11;
                    if (!gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 3) != 2)) {
                        gapComposer11.skipToGroupEnd();
                        return unit;
                    }
                    int iOrdinal10 = ((MyTopFilter) r0).ordinal();
                    if (iOrdinal10 == 0) {
                        i = R.string.all_time;
                    } else if (iOrdinal10 == 1) {
                        i = R.string.past_24_hours;
                    } else if (iOrdinal10 == 2) {
                        i = R.string.past_week;
                    } else if (iOrdinal10 == 3) {
                        i = R.string.past_month;
                    } else {
                        if (iOrdinal10 != 4) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i = R.string.past_year;
                    }
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(i, gapComposer11), null, 0L, IntMath.getSp(16), null, FontWeight.Normal, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer11, 1597440, 0, 262062);
                    return unit;
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass3 implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Enum $sortType;
        public final /* synthetic */ Enum $type;

        public /* synthetic */ AnonymousClass3(Enum r1, Enum r2, byte b) {
            this.$r8$classId = b;
            this.$sortType = r1;
            this.$type = r2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            int i = R.drawable.radio_button_unchecked;
            Enum r5 = this.$type;
            Enum r0 = this.$sortType;
            switch (b) {
                case 0:
                    Composer composer = (Composer) obj;
                    int iIntValue = ((Number) obj2).intValue();
                    GapComposer gapComposer = (GapComposer) composer;
                    if (!gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 3) != 2)) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        if (r0.equals(r5)) {
                            i = R.drawable.radio_button_checked;
                        }
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer), (String) null, (Modifier) null, 0L, gapComposer, 56, 12);
                    }
                    break;
                case 1:
                    Composer composer2 = (Composer) obj;
                    int iIntValue2 = ((Number) obj2).intValue();
                    GapComposer gapComposer2 = (GapComposer) composer2;
                    if (!gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        if (Intrinsics.areEqual(r0, r5)) {
                            i = R.drawable.radio_button_checked;
                        }
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer2), (String) null, (Modifier) null, 0L, gapComposer2, 56, 12);
                    }
                    break;
                case 2:
                    Composer composer3 = (Composer) obj;
                    int iIntValue3 = ((Number) obj2).intValue();
                    GapComposer gapComposer3 = (GapComposer) composer3;
                    if (!gapComposer3.shouldExecute(1 & iIntValue3, (iIntValue3 & 3) != 2)) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        if (Intrinsics.areEqual(r0, r5)) {
                            i = R.drawable.radio_button_checked;
                        }
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer3), (String) null, (Modifier) null, 0L, gapComposer3, 56, 12);
                    }
                    break;
                case 3:
                    Composer composer4 = (Composer) obj;
                    int iIntValue4 = ((Number) obj2).intValue();
                    GapComposer gapComposer4 = (GapComposer) composer4;
                    if (!gapComposer4.shouldExecute(1 & iIntValue4, (iIntValue4 & 3) != 2)) {
                        gapComposer4.skipToGroupEnd();
                    } else {
                        if (Intrinsics.areEqual(r0, r5)) {
                            i = R.drawable.radio_button_checked;
                        }
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer4), (String) null, (Modifier) null, 0L, gapComposer4, 56, 12);
                    }
                    break;
                case 4:
                    Composer composer5 = (Composer) obj;
                    int iIntValue5 = ((Number) obj2).intValue();
                    GapComposer gapComposer5 = (GapComposer) composer5;
                    if (!gapComposer5.shouldExecute(1 & iIntValue5, (iIntValue5 & 3) != 2)) {
                        gapComposer5.skipToGroupEnd();
                    } else {
                        if (Intrinsics.areEqual(r0, r5)) {
                            i = R.drawable.radio_button_checked;
                        }
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer5), (String) null, (Modifier) null, 0L, gapComposer5, 56, 12);
                    }
                    break;
                case 5:
                    Composer composer6 = (Composer) obj;
                    int iIntValue6 = ((Number) obj2).intValue();
                    GapComposer gapComposer6 = (GapComposer) composer6;
                    if (!gapComposer6.shouldExecute(1 & iIntValue6, (iIntValue6 & 3) != 2)) {
                        gapComposer6.skipToGroupEnd();
                    } else {
                        if (Intrinsics.areEqual(r0, r5)) {
                            i = R.drawable.radio_button_checked;
                        }
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer6), (String) null, (Modifier) null, 0L, gapComposer6, 56, 12);
                    }
                    break;
                case 6:
                    Composer composer7 = (Composer) obj;
                    int iIntValue7 = ((Number) obj2).intValue();
                    GapComposer gapComposer7 = (GapComposer) composer7;
                    if (!gapComposer7.shouldExecute(1 & iIntValue7, (iIntValue7 & 3) != 2)) {
                        gapComposer7.skipToGroupEnd();
                    } else {
                        if (Intrinsics.areEqual(r0, r5)) {
                            i = R.drawable.radio_button_checked;
                        }
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer7), (String) null, (Modifier) null, 0L, gapComposer7, 56, 12);
                    }
                    break;
                case 7:
                    Composer composer8 = (Composer) obj;
                    int iIntValue8 = ((Number) obj2).intValue();
                    GapComposer gapComposer8 = (GapComposer) composer8;
                    if (!gapComposer8.shouldExecute(1 & iIntValue8, (iIntValue8 & 3) != 2)) {
                        gapComposer8.skipToGroupEnd();
                    } else {
                        if (Intrinsics.areEqual(r0, r5)) {
                            i = R.drawable.radio_button_checked;
                        }
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer8), (String) null, (Modifier) null, 0L, gapComposer8, 56, 12);
                    }
                    break;
                case 8:
                    Composer composer9 = (Composer) obj;
                    int iIntValue9 = ((Number) obj2).intValue();
                    GapComposer gapComposer9 = (GapComposer) composer9;
                    if (!gapComposer9.shouldExecute(1 & iIntValue9, (iIntValue9 & 3) != 2)) {
                        gapComposer9.skipToGroupEnd();
                    } else {
                        if (Intrinsics.areEqual(r0, r5)) {
                            i = R.drawable.radio_button_checked;
                        }
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer9), (String) null, (Modifier) null, 0L, gapComposer9, 56, 12);
                    }
                    break;
                case 9:
                    Composer composer10 = (Composer) obj;
                    int iIntValue10 = ((Number) obj2).intValue();
                    GapComposer gapComposer10 = (GapComposer) composer10;
                    if (!gapComposer10.shouldExecute(1 & iIntValue10, (iIntValue10 & 3) != 2)) {
                        gapComposer10.skipToGroupEnd();
                    } else {
                        if (Intrinsics.areEqual(r0, r5)) {
                            i = R.drawable.radio_button_checked;
                        }
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer10), (String) null, (Modifier) null, 0L, gapComposer10, 56, 12);
                    }
                    break;
                default:
                    Composer composer11 = (Composer) obj;
                    int iIntValue11 = ((Number) obj2).intValue();
                    GapComposer gapComposer11 = (GapComposer) composer11;
                    if (!gapComposer11.shouldExecute(1 & iIntValue11, (iIntValue11 & 3) != 2)) {
                        gapComposer11.skipToGroupEnd();
                    } else {
                        if (Intrinsics.areEqual(r0, r5)) {
                            i = R.drawable.radio_button_checked;
                        }
                        IconKt.m290Iconww6aTOc(IntMath.painterResource(i, 0, gapComposer11), (String) null, (Modifier) null, 0L, gapComposer11, 56, 12);
                    }
                    break;
            }
            return unit;
        }
    }

    public /* synthetic */ LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1(byte b, MutableState mutableState, Enum r3, Function1 function1) {
        this.$r8$classId = b;
        this.$onSortTypeChange = function1;
        this.$menuExpanded$delegate = mutableState;
        this.$sortType = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Enum r5 = this.$sortType;
        final MutableState mutableState = this.$menuExpanded$delegate;
        final Function1 function1 = this.$onSortTypeChange;
        final byte b2 = 1;
        final byte b3 = 0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    for (final MixSortType mixSortType : MixSortType.values()) {
                        CardKt.DropdownMenuItem(Expect_jvmKt.rememberComposableLambda(2033249796, new AnonymousClass1(mixSortType, b3), gapComposer), new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1.2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b4 = b3;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState2 = mutableState;
                                Enum r3 = mixSortType;
                                Function1 function2 = function1;
                                switch (b4) {
                                    case 0:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 1:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 2:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 3:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 4:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 5:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 6:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 7:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 8:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    default:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                }
                                return unit2;
                            }
                        }, null, null, Expect_jvmKt.rememberComposableLambda(737216264, new AnonymousClass3(r5, mixSortType, b3), gapComposer), false, null, null, gapComposer, 24582, 492);
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    ArtistSongSortType[] artistSongSortTypeArrValues = ArtistSongSortType.values();
                    int length = artistSongSortTypeArrValues.length;
                    while (b3 < length) {
                        final ArtistSongSortType artistSongSortType = artistSongSortTypeArrValues[b3];
                        CardKt.DropdownMenuItem(Expect_jvmKt.rememberComposableLambda(2033249796, new AnonymousClass1(artistSongSortType, b2), gapComposer2), new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1.2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b4 = b2;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState2 = mutableState;
                                Enum r3 = artistSongSortType;
                                Function1 function2 = function1;
                                switch (b4) {
                                    case 0:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 1:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 2:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 3:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 4:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 5:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 6:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 7:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 8:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    default:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                }
                                return unit2;
                            }
                        }, null, null, Expect_jvmKt.rememberComposableLambda(737216264, new AnonymousClass3(r5, artistSongSortType, b2), gapComposer2), false, null, null, gapComposer2, 24582, 492);
                        b3++;
                    }
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    for (final AlbumSortType albumSortType : AlbumSortType.values()) {
                        final byte b4 = 2;
                        CardKt.DropdownMenuItem(Expect_jvmKt.rememberComposableLambda(2033249796, new AnonymousClass1(albumSortType, b4), gapComposer3), new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1.2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b5 = b4;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState2 = mutableState;
                                Enum r3 = albumSortType;
                                Function1 function2 = function1;
                                switch (b5) {
                                    case 0:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 1:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 2:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 3:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 4:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 5:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 6:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 7:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 8:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    default:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                }
                                return unit2;
                            }
                        }, null, null, Expect_jvmKt.rememberComposableLambda(737216264, new AnonymousClass3(r5, albumSortType, b4), gapComposer3), false, null, null, gapComposer3, 24582, 492);
                    }
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    for (final ArtistSortType artistSortType : ArtistSortType.values()) {
                        final byte b5 = 3;
                        CardKt.DropdownMenuItem(Expect_jvmKt.rememberComposableLambda(2033249796, new AnonymousClass1(artistSortType, b5), gapComposer4), new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1.2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b6 = b5;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState2 = mutableState;
                                Enum r3 = artistSortType;
                                Function1 function2 = function1;
                                switch (b6) {
                                    case 0:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 1:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 2:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 3:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 4:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 5:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 6:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 7:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 8:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    default:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                }
                                return unit2;
                            }
                        }, null, null, Expect_jvmKt.rememberComposableLambda(737216264, new AnonymousClass3(r5, artistSortType, b5), gapComposer4), false, null, null, gapComposer4, 24582, 492);
                    }
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                break;
            case 4:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    for (final PlaylistSortType playlistSortType : PlaylistSortType.values()) {
                        final byte b6 = 4;
                        CardKt.DropdownMenuItem(Expect_jvmKt.rememberComposableLambda(2033249796, new AnonymousClass1(playlistSortType, b6), gapComposer5), new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1.2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b7 = b6;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState2 = mutableState;
                                Enum r3 = playlistSortType;
                                Function1 function2 = function1;
                                switch (b7) {
                                    case 0:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 1:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 2:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 3:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 4:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 5:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 6:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 7:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 8:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    default:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                }
                                return unit2;
                            }
                        }, null, null, Expect_jvmKt.rememberComposableLambda(737216264, new AnonymousClass3(r5, playlistSortType, b6), gapComposer5), false, null, null, gapComposer5, 24582, 492);
                    }
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                break;
            case 5:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    for (final SongSortType songSortType : SongSortType.values()) {
                        final byte b7 = 5;
                        CardKt.DropdownMenuItem(Expect_jvmKt.rememberComposableLambda(2033249796, new AnonymousClass1(songSortType, b7), gapComposer6), new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1.2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b8 = b7;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState2 = mutableState;
                                Enum r3 = songSortType;
                                Function1 function2 = function1;
                                switch (b8) {
                                    case 0:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 1:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 2:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 3:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 4:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 5:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 6:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 7:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 8:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    default:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                }
                                return unit2;
                            }
                        }, null, null, Expect_jvmKt.rememberComposableLambda(737216264, new AnonymousClass3(r5, songSortType, b7), gapComposer6), false, null, null, gapComposer6, 24582, 492);
                    }
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                break;
            case 6:
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    for (final SongSortType songSortType2 : SongSortType.values()) {
                        final byte b8 = 6;
                        CardKt.DropdownMenuItem(Expect_jvmKt.rememberComposableLambda(2033249796, new AnonymousClass1(songSortType2, b8), gapComposer7), new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1.2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b9 = b8;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState2 = mutableState;
                                Enum r3 = songSortType2;
                                Function1 function2 = function1;
                                switch (b9) {
                                    case 0:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 1:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 2:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 3:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 4:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 5:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 6:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 7:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 8:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    default:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                }
                                return unit2;
                            }
                        }, null, null, Expect_jvmKt.rememberComposableLambda(737216264, new AnonymousClass3(r5, songSortType2, b8), gapComposer7), false, null, null, gapComposer7, 24582, 492);
                    }
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                break;
            case 7:
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    for (final SongSortType songSortType3 : SongSortType.values()) {
                        final byte b9 = 7;
                        CardKt.DropdownMenuItem(Expect_jvmKt.rememberComposableLambda(2033249796, new AnonymousClass1(songSortType3, b9), gapComposer8), new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1.2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b10 = b9;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState2 = mutableState;
                                Enum r3 = songSortType3;
                                Function1 function2 = function1;
                                switch (b10) {
                                    case 0:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 1:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 2:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 3:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 4:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 5:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 6:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 7:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 8:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    default:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                }
                                return unit2;
                            }
                        }, null, null, Expect_jvmKt.rememberComposableLambda(737216264, new AnonymousClass3(r5, songSortType3, b9), gapComposer8), false, null, null, gapComposer8, 24582, 492);
                    }
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                break;
            case 8:
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    for (final SongSortType songSortType4 : SongSortType.values()) {
                        final byte b10 = 8;
                        CardKt.DropdownMenuItem(Expect_jvmKt.rememberComposableLambda(2033249796, new AnonymousClass1(songSortType4, b10), gapComposer9), new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1.2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b11 = b10;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState2 = mutableState;
                                Enum r3 = songSortType4;
                                Function1 function2 = function1;
                                switch (b11) {
                                    case 0:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 1:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 2:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 3:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 4:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 5:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 6:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 7:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 8:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    default:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                }
                                return unit2;
                            }
                        }, null, null, Expect_jvmKt.rememberComposableLambda(737216264, new AnonymousClass3(r5, songSortType4, b10), gapComposer9), false, null, null, gapComposer9, 24582, 492);
                    }
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                break;
            default:
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Number) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    for (final PlaylistSongSortType playlistSongSortType : PlaylistSongSortType.values()) {
                        final byte b11 = 9;
                        CardKt.DropdownMenuItem(Expect_jvmKt.rememberComposableLambda(2033249796, new AnonymousClass1(playlistSongSortType, b11), gapComposer10), new Function0() { // from class: com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1.2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                byte b12 = b11;
                                Unit unit2 = Unit.INSTANCE;
                                MutableState mutableState2 = mutableState;
                                Enum r3 = playlistSongSortType;
                                Function1 function2 = function1;
                                switch (b12) {
                                    case 0:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 1:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 2:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 3:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 4:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 5:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 6:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 7:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    case 8:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                    default:
                                        function2.invoke(r3);
                                        mutableState2.setValue(Boolean.FALSE);
                                        break;
                                }
                                return unit2;
                            }
                        }, null, null, Expect_jvmKt.rememberComposableLambda(737216264, new AnonymousClass3(r5, playlistSongSortType, b11), gapComposer10), false, null, null, gapComposer10, 24582, 492);
                    }
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                break;
        }
        return unit;
    }
}
