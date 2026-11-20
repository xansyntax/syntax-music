package com.metrolist.music.viewmodels;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CsvImportState {
    public final int artistColumnIndex;
    public final boolean hasHeader;
    public final List previewRows;
    public final int titleColumnIndex;
    public final int urlColumnIndex;

    public /* synthetic */ CsvImportState(int i, ArrayList arrayList, boolean z) {
        this((i & 1) != 0 ? EmptyList.INSTANCE : arrayList, 0, 1, -1, (i & 16) != 0 ? true : z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CsvImportState)) {
            return false;
        }
        CsvImportState csvImportState = (CsvImportState) obj;
        return Intrinsics.areEqual(this.previewRows, csvImportState.previewRows) && this.artistColumnIndex == csvImportState.artistColumnIndex && this.titleColumnIndex == csvImportState.titleColumnIndex && this.urlColumnIndex == csvImportState.urlColumnIndex && this.hasHeader == csvImportState.hasHeader;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.hasHeader) + IntIntPair$$ExternalSyntheticOutline0.m(this.urlColumnIndex, IntIntPair$$ExternalSyntheticOutline0.m(this.titleColumnIndex, IntIntPair$$ExternalSyntheticOutline0.m(this.artistColumnIndex, this.previewRows.hashCode() * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CsvImportState(previewRows=");
        sb.append(this.previewRows);
        sb.append(", artistColumnIndex=");
        sb.append(this.artistColumnIndex);
        sb.append(", titleColumnIndex=");
        sb.append(this.titleColumnIndex);
        sb.append(", urlColumnIndex=");
        sb.append(this.urlColumnIndex);
        sb.append(", hasHeader=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.hasHeader, ")");
    }

    public CsvImportState(List list, int i, int i2, int i3, boolean z) {
        list.getClass();
        this.previewRows = list;
        this.artistColumnIndex = i;
        this.titleColumnIndex = i2;
        this.urlColumnIndex = i3;
        this.hasHeader = z;
    }
}
