package androidx.compose.ui.graphics.vector;

import androidx.collection.FloatFloatPair;
import androidx.compose.ui.graphics.Matrix;
import androidx.graphics.shapes.PointTransformer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PathParser implements PointTransformer {
    public float[] nodeData;

    public PathParser(float[] fArr) {
        this.nodeData = fArr;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 9201. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public static java.util.ArrayList pathStringToNodes$default(androidx.compose.ui.graphics.vector.PathParser r22, java.lang.String r23) {
        /*
            Method dump skipped, instruction units count: 920
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathParser.pathStringToNodes$default(androidx.compose.ui.graphics.vector.PathParser, java.lang.String):java.util.ArrayList");
    }

    @Override // androidx.graphics.shapes.PointTransformer
    /* JADX INFO: renamed from: transform-XgqJiTY */
    public long mo273transformXgqJiTY(float f, float f2) {
        long jM508mapMKHz9U = Matrix.m508mapMKHz9U((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32), this.nodeData);
        return FloatFloatPair.m0constructorimpl(Float.intBitsToFloat((int) (jM508mapMKHz9U >> 32)), Float.intBitsToFloat((int) (jM508mapMKHz9U & 4294967295L)));
    }
}
