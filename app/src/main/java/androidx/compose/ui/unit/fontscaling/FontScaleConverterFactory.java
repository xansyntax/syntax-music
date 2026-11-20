package androidx.compose.ui.unit.fontscaling;

import androidx.collection.ArraySetKt;
import androidx.collection.SparseArrayCompat;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.compose.ui.unit.InlineClassHelperKt;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FontScaleConverterFactory {
    public static final Object[] LookupTablesWriteLock;
    public static final float[] CommonFontSizes = {8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f};
    public static volatile SparseArrayCompat sLookupTables = new SparseArrayCompat(0);

    static {
        Object[] objArr = new Object[0];
        LookupTablesWriteLock = objArr;
        synchronized (objArr) {
            sLookupTables.put(115, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{9.2f, 11.5f, 13.8f, 16.4f, 19.8f, 21.8f, 25.2f, 30.0f, 100.0f}));
            sLookupTables.put(130, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{10.4f, 13.0f, 15.6f, 18.8f, 21.6f, 23.6f, 26.4f, 30.0f, 100.0f}));
            sLookupTables.put(150, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{12.0f, 15.0f, 18.0f, 22.0f, 24.0f, 26.0f, 28.0f, 30.0f, 100.0f}));
            sLookupTables.put(180, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{14.4f, 18.0f, 21.6f, 24.4f, 27.6f, 30.8f, 32.8f, 34.8f, 100.0f}));
            sLookupTables.put(200, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{16.0f, 20.0f, 24.0f, 26.0f, 30.0f, 34.0f, 36.0f, 38.0f, 100.0f}));
        }
        if ((sLookupTables.keyAt(0) / 100.0f) - 0.01f > 1.03f) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("You should only apply non-linear scaling to font scales > 1");
    }

    public static FontScaleConverter forScale(float f) {
        float fKeyAt;
        FontScaleConverter fontScaleConverterTable;
        float[] fArr = CommonFontSizes;
        if (f < 1.03f) {
            return null;
        }
        SparseArrayCompat sparseArrayCompat = sLookupTables;
        int i = (int) (f * 100.0f);
        sparseArrayCompat.getClass();
        FontScaleConverter fontScaleConverter = (FontScaleConverter) ArraySetKt.commonGet(sparseArrayCompat, i);
        if (fontScaleConverter != null) {
            return fontScaleConverter;
        }
        SparseArrayCompat sparseArrayCompat2 = sLookupTables;
        if (sparseArrayCompat2.garbage) {
            ArraySetKt.gc(sparseArrayCompat2);
        }
        int iBinarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat2.size, i, sparseArrayCompat2.keys);
        if (iBinarySearch >= 0) {
            return (FontScaleConverter) sLookupTables.valueAt(iBinarySearch);
        }
        int i2 = -(iBinarySearch + 1);
        int i3 = i2 - 1;
        if (i2 >= sLookupTables.size()) {
            FontScaleConverterTable fontScaleConverterTable2 = new FontScaleConverterTable(new float[]{1.0f}, new float[]{f});
            put(f, fontScaleConverterTable2);
            return fontScaleConverterTable2;
        }
        if (i3 < 0) {
            fontScaleConverterTable = new FontScaleConverterTable(fArr, fArr);
            fKeyAt = 1.0f;
        } else {
            fKeyAt = sLookupTables.keyAt(i3) / 100.0f;
            fontScaleConverterTable = (FontScaleConverter) sLookupTables.valueAt(i3);
        }
        float fKeyAt2 = sLookupTables.keyAt(i2) / 100.0f;
        float fMax = (Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Math.min(1.0f, fKeyAt == fKeyAt2 ? 0.0f : (f - fKeyAt) / (fKeyAt2 - fKeyAt))) * 1.0f) + CropImageView.DEFAULT_ASPECT_RATIO;
        FontScaleConverter fontScaleConverter2 = (FontScaleConverter) sLookupTables.valueAt(i2);
        float[] fArr2 = new float[9];
        for (int i4 = 0; i4 < 9; i4++) {
            float f2 = fArr[i4];
            float fConvertSpToDp = fontScaleConverterTable.convertSpToDp(f2);
            fArr2[i4] = ((fontScaleConverter2.convertSpToDp(f2) - fConvertSpToDp) * fMax) + fConvertSpToDp;
        }
        FontScaleConverterTable fontScaleConverterTable3 = new FontScaleConverterTable(fArr, fArr2);
        put(f, fontScaleConverterTable3);
        return fontScaleConverterTable3;
    }

    public static void put(float f, FontScaleConverterTable fontScaleConverterTable) {
        synchronized (LookupTablesWriteLock) {
            SparseArrayCompat sparseArrayCompatClone = sLookupTables.m7clone();
            sparseArrayCompatClone.put((int) (f * 100.0f), fontScaleConverterTable);
            sLookupTables = sparseArrayCompatClone;
        }
    }
}
