package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.compose.material3.ChipArrangement;
import androidx.sqlite.SQLite;
import com.metrolist.music.db.DatabaseDao_Impl;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RoundedPolygon {
    public final long center;
    public final ListBuilder cubics;
    public final List features;

    /* JADX WARN: Code duplicated, block: B:24:0x0164  */
    /* JADX WARN: Code duplicated, block: B:26:0x0170 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x0172  */
    /* JADX WARN: Code duplicated, block: B:30:0x017b  */
    /* JADX WARN: Code duplicated, block: B:31:0x017f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0182  */
    /* JADX WARN: Code duplicated, block: B:34:0x0186  */
    /* JADX WARN: Code duplicated, block: B:35:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:39:0x01b3 A[LOOP:0: B:11:0x0132->B:39:0x01b3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x01c9 A[EDGE_INSN: B:56:0x01c9->B:41:0x01c9 BREAK  A[LOOP:0: B:11:0x0132->B:39:0x01b3], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public RoundedPolygon(AbstractList abstractList, long j) {
        ArrayList arrayListMutableListOf;
        ArrayList arrayListMutableListOf2;
        char c;
        char c2;
        char c3;
        char c4;
        Cubic cubic;
        Cubic cubic2;
        List list;
        int size;
        int i;
        Cubic cubic3;
        char c5;
        char c6;
        abstractList.getClass();
        this.features = abstractList;
        this.center = j;
        ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
        char c7 = 5;
        char c8 = 4;
        char c9 = 3;
        char c10 = 2;
        if (abstractList.size() <= 0 || ((Feature) abstractList.get(0)).cubics.size() != 3) {
            arrayListMutableListOf = null;
            arrayListMutableListOf2 = null;
        } else {
            Cubic cubic4 = (Cubic) ((Feature) abstractList.get(0)).cubics.get(1);
            float[] fArr = cubic4.points;
            long jM0constructorimpl = FloatFloatPair.m0constructorimpl((cubic4.getAnchor1X() * 0.125f) + (fArr[4] * 0.375f) + (fArr[2] * 0.375f) + (fArr[0] * 0.125f), (cubic4.getAnchor1Y() * 0.125f) + (fArr[5] * 0.375f) + (fArr[3] * 0.375f) + (fArr[1] * 0.125f));
            float[] fArr2 = cubic4.points;
            float f = fArr2[0];
            float f2 = fArr2[1];
            float f3 = fArr2[2] * 0.5f;
            float f4 = fArr2[3] * 0.5f;
            Cubic Cubic = SQLite.Cubic(f, f2, f3 + (f * 0.5f), f4 + (f2 * 0.5f), (fArr2[4] * 0.25f) + (f * 0.25f) + f3, (fArr2[5] * 0.25f) + (f2 * 0.25f) + f4, DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jM0constructorimpl), DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jM0constructorimpl));
            Cubic Cubic2 = SQLite.Cubic(DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jM0constructorimpl), DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jM0constructorimpl), (cubic4.getAnchor1X() * 0.25f) + (fArr2[4] * 0.5f) + (fArr2[2] * 0.25f), (cubic4.getAnchor1Y() * 0.25f) + (fArr2[5] * 0.5f) + (fArr2[3] * 0.25f), (cubic4.getAnchor1X() * 0.5f) + (fArr2[4] * 0.5f), (cubic4.getAnchor1Y() * 0.5f) + (fArr2[5] * 0.5f), cubic4.getAnchor1X(), cubic4.getAnchor1Y());
            arrayListMutableListOf2 = CollectionsKt__IterablesKt.mutableListOf(((Feature) abstractList.get(0)).cubics.get(0), Cubic);
            arrayListMutableListOf = CollectionsKt__IterablesKt.mutableListOf(Cubic2, ((Feature) abstractList.get(0)).cubics.get(2));
        }
        int size2 = abstractList.size();
        if (size2 >= 0) {
            int i2 = 0;
            cubic = null;
            cubic2 = null;
            while (true) {
                if (i2 == 0 && arrayListMutableListOf != null) {
                    list = arrayListMutableListOf;
                } else if (i2 == this.features.size()) {
                    c = c7;
                    if (arrayListMutableListOf2 != null) {
                        list = arrayListMutableListOf2;
                        size = list.size();
                        c2 = c8;
                        i = 0;
                        while (i < size) {
                            cubic3 = (Cubic) list.get(i);
                            if (cubic3.zeroLength$graphics_shapes()) {
                                c5 = c9;
                                if (cubic2 != null) {
                                    float[] fArr3 = cubic2.points;
                                    c6 = c10;
                                    float[] fArrCopyOf = Arrays.copyOf(fArr3, fArr3.length);
                                    Cubic cubic5 = new Cubic(fArrCopyOf);
                                    fArrCopyOf[6] = cubic3.getAnchor1X();
                                    fArrCopyOf[7] = cubic3.getAnchor1Y();
                                    cubic2 = cubic5;
                                } else {
                                    c6 = c10;
                                }
                            } else {
                                if (cubic2 != null) {
                                    listBuilderCreateListBuilder.add(cubic2);
                                }
                                c5 = c9;
                                c6 = c10;
                                if (cubic == null) {
                                    cubic = cubic3;
                                    cubic2 = cubic;
                                } else {
                                    cubic2 = cubic3;
                                }
                            }
                            i++;
                            c9 = c5;
                            c10 = c6;
                        }
                        c3 = c9;
                        c4 = c10;
                        if (i2 != size2) {
                            break;
                        }
                        i2++;
                        c7 = c;
                        c8 = c2;
                        c9 = c3;
                        c10 = c4;
                    } else {
                        c2 = c8;
                        c3 = c9;
                        c4 = c10;
                        break;
                    }
                } else {
                    list = ((Feature) this.features.get(i2)).cubics;
                }
                c = c7;
                size = list.size();
                c2 = c8;
                i = 0;
                while (i < size) {
                    cubic3 = (Cubic) list.get(i);
                    if (cubic3.zeroLength$graphics_shapes()) {
                        if (cubic2 != null) {
                            listBuilderCreateListBuilder.add(cubic2);
                        }
                        c5 = c9;
                        c6 = c10;
                        if (cubic == null) {
                            cubic = cubic3;
                            cubic2 = cubic;
                        } else {
                            cubic2 = cubic3;
                        }
                    } else {
                        c5 = c9;
                        if (cubic2 != null) {
                            float[] fArr4 = cubic2.points;
                            c6 = c10;
                            float[] fArrCopyOf2 = Arrays.copyOf(fArr4, fArr4.length);
                            Cubic cubic6 = new Cubic(fArrCopyOf2);
                            fArrCopyOf2[6] = cubic3.getAnchor1X();
                            fArrCopyOf2[7] = cubic3.getAnchor1Y();
                            cubic2 = cubic6;
                        } else {
                            c6 = c10;
                        }
                    }
                    i++;
                    c9 = c5;
                    c10 = c6;
                }
                c3 = c9;
                c4 = c10;
                if (i2 != size2) {
                    break;
                    break;
                }
                i2++;
                c7 = c;
                c8 = c2;
                c9 = c3;
                c10 = c4;
            }
        } else {
            c = 5;
            c2 = 4;
            c3 = 3;
            c4 = 2;
            cubic = null;
            cubic2 = null;
        }
        if (cubic2 == null || cubic == null) {
            listBuilderCreateListBuilder.add(SQLite.Cubic(DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(this.center), DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(this.center), DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(this.center), DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(this.center), DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(this.center), DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(this.center), DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(this.center), DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(this.center)));
        } else {
            float[] fArr5 = cubic2.points;
            float f5 = fArr5[0];
            float f6 = fArr5[1];
            float f7 = fArr5[c4];
            float f8 = fArr5[c3];
            float f9 = fArr5[c2];
            float f10 = fArr5[c];
            float[] fArr6 = cubic.points;
            listBuilderCreateListBuilder.add(SQLite.Cubic(f5, f6, f7, f8, f9, f10, fArr6[0], fArr6[1]));
        }
        ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
        this.cubics = listBuilderBuild;
        Object obj = listBuilderBuild.get(listBuilderBuild.getSize() - 1);
        int size3 = listBuilderBuild.getSize();
        int i3 = 0;
        while (i3 < size3) {
            Cubic cubic7 = (Cubic) this.cubics.get(i3);
            Cubic cubic8 = (Cubic) obj;
            if (Math.abs(cubic7.points[0] - cubic8.getAnchor1X()) > 1.0E-4f || Math.abs(cubic7.points[1] - cubic8.getAnchor1Y()) > 1.0E-4f) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("RoundedPolygon must be contiguous, with the anchor points of all curves matching the anchor points of the preceding and succeeding cubics");
                throw null;
            }
            i3++;
            obj = cubic7;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundedPolygon)) {
            return false;
        }
        return this.features.equals(((RoundedPolygon) obj).features);
    }

    public final int hashCode() {
        return this.features.hashCode();
    }

    public final RoundedPolygon normalized() {
        char c;
        char c2;
        char c3;
        char c4;
        char c5 = 4;
        float[] fArr = new float[4];
        ListBuilder listBuilder = this.cubics;
        int size = listBuilder.getSize();
        float fMax = Float.MIN_VALUE;
        char c6 = 0;
        float fMin = Float.MAX_VALUE;
        float fMin2 = Float.MAX_VALUE;
        int i = 0;
        float fMax2 = Float.MIN_VALUE;
        while (i < size) {
            Cubic cubic = (Cubic) listBuilder.get(i);
            cubic.getClass();
            boolean zZeroLength$graphics_shapes = cubic.zeroLength$graphics_shapes();
            char c7 = c5;
            float[] fArr2 = cubic.points;
            if (zZeroLength$graphics_shapes) {
                fArr[c6] = fArr2[c6];
                fArr[1] = fArr2[1];
                fArr[2] = fArr2[c6];
                fArr[3] = fArr2[1];
                c = c6;
                c2 = 2;
                c3 = 1;
                c4 = 3;
            } else {
                c = c6;
                float fMin3 = Math.min(fArr2[c6], cubic.getAnchor1X());
                c2 = 2;
                float fMin4 = Math.min(fArr2[1], cubic.getAnchor1Y());
                c3 = 1;
                float fMax3 = Math.max(fArr2[c], cubic.getAnchor1X());
                float fMax4 = Math.max(fArr2[1], cubic.getAnchor1Y());
                c4 = 3;
                fArr[c] = Math.min(fMin3, Math.min(fArr2[2], fArr2[c7]));
                fArr[1] = Math.min(fMin4, Math.min(fArr2[3], fArr2[5]));
                fArr[2] = Math.max(fMax3, Math.max(fArr2[2], fArr2[c7]));
                fArr[3] = Math.max(fMax4, Math.max(fArr2[3], fArr2[5]));
            }
            fMin = Math.min(fMin, fArr[c]);
            fMin2 = Math.min(fMin2, fArr[c3]);
            fMax = Math.max(fMax, fArr[c2]);
            fMax2 = Math.max(fMax2, fArr[c4]);
            i++;
            c5 = c7;
            c6 = c;
        }
        char c8 = c6;
        fArr[c8] = fMin;
        fArr[1] = fMin2;
        fArr[2] = fMax;
        fArr[3] = fMax2;
        float f = fMax - fMin;
        float f2 = fMax2 - fMin2;
        float fMax5 = Math.max(f, f2);
        return transformed(new ChipArrangement(((fMax5 - f) / 2.0f) - fArr[c8], fMax5, ((fMax5 - f2) / 2.0f) - fArr[1]));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[RoundedPolygon. Cubics = ");
        sb.append(CollectionsKt.joinToString$default(this.cubics, null, null, null, null, 63));
        sb.append(" || Features = ");
        sb.append(CollectionsKt.joinToString$default(this.features, null, null, null, null, 63));
        sb.append(" || Center = (");
        long j = this.center;
        sb.append(DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(j));
        sb.append(", ");
        sb.append(DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(j));
        sb.append(")]");
        return sb.toString();
    }

    public final RoundedPolygon transformed(PointTransformer pointTransformer) {
        long j = this.center;
        long jMo273transformXgqJiTY = pointTransformer.mo273transformXgqJiTY(DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(j), DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(j));
        long jM0constructorimpl = FloatFloatPair.m0constructorimpl(Float.intBitsToFloat((int) (jMo273transformXgqJiTY >> 32)), Float.intBitsToFloat((int) (jMo273transformXgqJiTY & 4294967295L)));
        ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
        List list = this.features;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            listBuilderCreateListBuilder.add(((Feature) list.get(i)).transformed(pointTransformer));
        }
        return new RoundedPolygon(CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder), jM0constructorimpl);
    }
}
