package androidx.compose.ui.input.indirect;

import android.view.MotionEvent;
import androidx.compose.ui.input.pointer.HistoricalChange;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.AbstractList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyHistoricalChangeList extends AbstractList {
    public ArrayList delegate;
    public final int index;
    public MotionEvent motionEvent;

    public LazyHistoricalChangeList(MotionEvent motionEvent, int i) {
        this.motionEvent = motionEvent;
        this.index = i;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof HistoricalChange) {
            return super.contains((HistoricalChange) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return (HistoricalChange) ((ArrayList) getDelegate()).get(i);
    }

    public final List getDelegate() {
        ArrayList arrayList = this.delegate;
        if (arrayList != null) {
            return arrayList;
        }
        MotionEvent motionEvent = this.motionEvent;
        motionEvent.getClass();
        int historySize = motionEvent.getHistorySize();
        ArrayList arrayList2 = new ArrayList(historySize);
        for (int i = 0; i < historySize; i++) {
            int i2 = this.index;
            float historicalX = motionEvent.getHistoricalX(i2, i);
            float historicalY = motionEvent.getHistoricalY(i2, i);
            if ((Float.floatToRawIntBits(historicalX) & Integer.MAX_VALUE) < 2139095040 && (Float.floatToRawIntBits(historicalY) & Integer.MAX_VALUE) < 2139095040) {
                arrayList2.add(new HistoricalChange(motionEvent.getHistoricalEventTime(i), (((long) Float.floatToRawIntBits(historicalX)) << 32) | (((long) Float.floatToRawIntBits(historicalY)) & 4294967295L), 1.0f, 0L));
            }
        }
        this.delegate = arrayList2;
        this.motionEvent = null;
        return arrayList2;
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return ((ArrayList) getDelegate()).size();
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof HistoricalChange) {
            return super.indexOf((HistoricalChange) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof HistoricalChange) {
            return super.lastIndexOf((HistoricalChange) obj);
        }
        return -1;
    }
}
