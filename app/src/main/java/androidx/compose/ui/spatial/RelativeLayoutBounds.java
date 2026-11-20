package androidx.compose.ui.spatial;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RelativeLayoutBounds {
    public final long bottomRight;
    public final Modifier.Node node;
    public final long screenOffset;
    public final long topLeft;
    public final float[] viewToWindowMatrix;
    public final long windowOffset;
    public final long windowSize;

    public RelativeLayoutBounds(long j, long j2, long j3, long j4, long j5, float[] fArr, Modifier.Node node) {
        this.topLeft = j;
        this.bottomRight = j2;
        this.windowOffset = j3;
        this.screenOffset = j4;
        this.windowSize = j5;
        this.viewToWindowMatrix = fArr;
        this.node = node;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x004e  */
    public final boolean equals(Object obj) {
        boolean zEquals;
        if (this != obj) {
            if (obj != null && RelativeLayoutBounds.class == obj.getClass()) {
                RelativeLayoutBounds relativeLayoutBounds = (RelativeLayoutBounds) obj;
                if (this.topLeft == relativeLayoutBounds.topLeft && this.bottomRight == relativeLayoutBounds.bottomRight && this.windowSize == relativeLayoutBounds.windowSize && IntOffset.m804equalsimpl0(this.windowOffset, relativeLayoutBounds.windowOffset) && IntOffset.m804equalsimpl0(this.screenOffset, relativeLayoutBounds.screenOffset)) {
                    float[] fArr = relativeLayoutBounds.viewToWindowMatrix;
                    float[] fArr2 = this.viewToWindowMatrix;
                    if (fArr2 == null) {
                        if (fArr == null) {
                            zEquals = true;
                        } else {
                            zEquals = false;
                        }
                    } else if (fArr == null) {
                        zEquals = false;
                    } else {
                        zEquals = fArr2.equals(fArr);
                    }
                    if (zEquals && this.node.equals(relativeLayoutBounds.node)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(this.topLeft) * 31, 31, this.bottomRight), 31, this.windowSize), 31, this.windowOffset), 31, this.screenOffset);
        float[] fArr = this.viewToWindowMatrix;
        return this.node.hashCode() + ((iM + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31);
    }
}
