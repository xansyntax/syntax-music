package androidx.compose.foundation.gestures;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DraggableAnchorsConfig {
    public final ArrayList keys = new ArrayList();
    public float[] positions;

    public DraggableAnchorsConfig() {
        float[] fArr = new float[5];
        for (int i = 0; i < 5; i++) {
            fArr[i] = Float.NaN;
        }
        this.positions = fArr;
    }

    public final void at(float f, Object obj) {
        ArrayList arrayList = this.keys;
        arrayList.add(obj);
        if (this.positions.length < arrayList.size()) {
            this.positions = Arrays.copyOf(this.positions, arrayList.size() + 2);
        }
        this.positions[arrayList.size() - 1] = f;
    }
}
