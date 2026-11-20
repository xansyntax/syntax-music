package com.metrolist.music.ui.utils;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import com.metrolist.music.ui.component.LyricsListItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ShowOffsetDialogKt$$ExternalSyntheticLambda3 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ParcelableSnapshotMutableIntState f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ ShowOffsetDialogKt$$ExternalSyntheticLambda3(MutableState mutableState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState) {
        this.$r8$classId = (byte) 1;
        this.f$1 = mutableState;
        this.f$0 = parcelableSnapshotMutableIntState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.f$0;
        switch (b) {
            case 0:
                parcelableSnapshotMutableIntState.setIntValue(0);
                mutableState.setValue("0");
                return unit;
            case 1:
                Iterator it = ((List) mutableState.getValue()).iterator();
                int i = 0;
                while (true) {
                    if (it.hasNext()) {
                        LyricsListItem lyricsListItem = (LyricsListItem) it.next();
                        if ((!(lyricsListItem instanceof LyricsListItem.Line) || ((LyricsListItem.Line) lyricsListItem).index != parcelableSnapshotMutableIntState.getIntValue()) && (!(lyricsListItem instanceof LyricsListItem.Indicator) || ((LyricsListItem.Indicator) lyricsListItem).afterLineIndex != parcelableSnapshotMutableIntState.getIntValue())) {
                            i++;
                        }
                    } else {
                        i = -1;
                    }
                }
                return Integer.valueOf(i >= 0 ? i : 0);
            case 2:
                parcelableSnapshotMutableIntState.setIntValue(UuidKt.coerceIn(parcelableSnapshotMutableIntState.getIntValue() - 50, -3000, 3000));
                mutableState.setValue(String.valueOf(parcelableSnapshotMutableIntState.getIntValue()));
                return unit;
            default:
                parcelableSnapshotMutableIntState.setIntValue(UuidKt.coerceIn(parcelableSnapshotMutableIntState.getIntValue() + 50, -3000, 3000));
                mutableState.setValue(String.valueOf(parcelableSnapshotMutableIntState.getIntValue()));
                return unit;
        }
    }

    public /* synthetic */ ShowOffsetDialogKt$$ExternalSyntheticLambda3(byte b, MutableState mutableState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState) {
        this.$r8$classId = b;
        this.f$0 = parcelableSnapshotMutableIntState;
        this.f$1 = mutableState;
    }
}
