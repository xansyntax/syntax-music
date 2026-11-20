package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.runtime.saveable.Saver;
import androidx.core.provider.CallbackWrapper;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SaversKt {
    public static final CallbackWrapper AnnotatedStringSaver;
    public static final CallbackWrapper AnnotationRangeListSaver;
    public static final CallbackWrapper AnnotationRangeSaver;
    public static final CallbackWrapper AnnotationSaver;
    public static final CallbackWrapper BaselineShiftSaver;
    public static final CallbackWrapper ClickableSaver;
    public static final SaversKt$NonNullValueClassSaver$1 ColorSaver;
    public static final CallbackWrapper FontStyleSaver;
    public static final CallbackWrapper FontSynthesisSaver;
    public static final CallbackWrapper FontWeightSaver;
    public static final SaversKt$NonNullValueClassSaver$1 HyphensSaver;
    public static final SaversKt$NonNullValueClassSaver$1 LineHeightStyleAlignmentSaver;
    public static final SaversKt$NonNullValueClassSaver$1 LineHeightStyleModeSaver;
    public static final CallbackWrapper LineHeightStyleSaver;
    public static final SaversKt$NonNullValueClassSaver$1 LineHeightStyleTrimSaver;
    public static final CallbackWrapper LinkSaver;
    public static final CallbackWrapper LocaleListSaver;
    public static final CallbackWrapper LocaleSaver;
    public static final SaversKt$NonNullValueClassSaver$1 OffsetSaver;
    public static final CallbackWrapper ParagraphStyleSaver;
    public static final CallbackWrapper ShadowSaver;
    public static final CallbackWrapper SpanStyleSaver;
    public static final SaversKt$NonNullValueClassSaver$1 TextAlignSaver;
    public static final CallbackWrapper TextDecorationSaver;
    public static final SaversKt$NonNullValueClassSaver$1 TextDirectionSaver;
    public static final CallbackWrapper TextGeometricTransformSaver;
    public static final CallbackWrapper TextIndentSaver;
    public static final CallbackWrapper TextLinkStylesSaver;
    public static final CallbackWrapper TextRangeSaver;
    public static final SaversKt$NonNullValueClassSaver$1 TextUnitSaver;
    public static final SaversKt$NonNullValueClassSaver$1 TextUnitTypeSaver;
    public static final CallbackWrapper UrlAnnotationSaver;
    public static final CallbackWrapper VerbatimTtsAnnotationSaver;

    static {
        byte b = 0;
        byte b2 = 9;
        byte b3 = 7;
        AnnotatedStringSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda0(b), new SaversKt$$ExternalSyntheticLambda2(b2), b3);
        byte b4 = 12;
        byte b5 = 20;
        AnnotationRangeListSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda0(b4), new SaversKt$$ExternalSyntheticLambda2(b5), b3);
        byte b6 = 24;
        byte b7 = 3;
        AnnotationRangeSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda0(b6), new SaversKt$$ExternalSyntheticLambda6(b7), b3);
        SaversKt$$ExternalSyntheticLambda5 saversKt$$ExternalSyntheticLambda5 = new SaversKt$$ExternalSyntheticLambda5(b7);
        byte b8 = 6;
        AnnotationSaver = new CallbackWrapper(saversKt$$ExternalSyntheticLambda5, new SaversKt$$ExternalSyntheticLambda6(b8), b3);
        byte b9 = 4;
        VerbatimTtsAnnotationSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda5(b9), new SaversKt$$ExternalSyntheticLambda6(b3), b3);
        byte b10 = 10;
        UrlAnnotationSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda0(b10), new SaversKt$$ExternalSyntheticLambda2(b), b3);
        byte b11 = 21;
        byte b12 = 28;
        LinkSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda0(b11), new SaversKt$$ExternalSyntheticLambda2(b12), b3);
        ClickableSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda5(b), new SaversKt$$ExternalSyntheticLambda6(b), b3);
        byte b13 = 5;
        byte b14 = 8;
        ParagraphStyleSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda5(b13), new SaversKt$$ExternalSyntheticLambda6(b14), b3);
        SpanStyleSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda5(b8), new SaversKt$$ExternalSyntheticLambda2(b14), b3);
        TextLinkStylesSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda0(b8), new SaversKt$$ExternalSyntheticLambda2(b10), b3);
        byte b15 = 11;
        TextDecorationSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda0(b3), new SaversKt$$ExternalSyntheticLambda2(b15), b3);
        TextGeometricTransformSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda0(b14), new SaversKt$$ExternalSyntheticLambda2(b4), b3);
        SaversKt$$ExternalSyntheticLambda0 saversKt$$ExternalSyntheticLambda0 = new SaversKt$$ExternalSyntheticLambda0(b2);
        byte b16 = 13;
        TextIndentSaver = new CallbackWrapper(saversKt$$ExternalSyntheticLambda0, new SaversKt$$ExternalSyntheticLambda2(b16), b3);
        byte b17 = 14;
        FontWeightSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda0(b15), new SaversKt$$ExternalSyntheticLambda2(b17), b3);
        SaversKt$$ExternalSyntheticLambda0 saversKt$$ExternalSyntheticLambda1 = new SaversKt$$ExternalSyntheticLambda0(b16);
        byte b18 = 15;
        BaselineShiftSaver = new CallbackWrapper(saversKt$$ExternalSyntheticLambda1, new SaversKt$$ExternalSyntheticLambda2(b18), b3);
        SaversKt$$ExternalSyntheticLambda0 saversKt$$ExternalSyntheticLambda2 = new SaversKt$$ExternalSyntheticLambda0(b17);
        byte b19 = 16;
        TextRangeSaver = new CallbackWrapper(saversKt$$ExternalSyntheticLambda2, new SaversKt$$ExternalSyntheticLambda2(b19), b3);
        SaversKt$$ExternalSyntheticLambda0 saversKt$$ExternalSyntheticLambda3 = new SaversKt$$ExternalSyntheticLambda0(b18);
        byte b20 = 17;
        ShadowSaver = new CallbackWrapper(saversKt$$ExternalSyntheticLambda3, new SaversKt$$ExternalSyntheticLambda2(b20), b3);
        ColorSaver = new SaversKt$NonNullValueClassSaver$1(SaversKt$ColorSaver$1.INSTANCE, SaversKt$ColorSaver$2.INSTANCE);
        SaversKt$$ExternalSyntheticLambda0 saversKt$$ExternalSyntheticLambda4 = new SaversKt$$ExternalSyntheticLambda0(b19);
        byte b21 = 18;
        TextAlignSaver = new SaversKt$NonNullValueClassSaver$1(saversKt$$ExternalSyntheticLambda4, new SaversKt$$ExternalSyntheticLambda2(b21));
        SaversKt$$ExternalSyntheticLambda0 saversKt$$ExternalSyntheticLambda6 = new SaversKt$$ExternalSyntheticLambda0(b20);
        byte b22 = 19;
        TextDirectionSaver = new SaversKt$NonNullValueClassSaver$1(saversKt$$ExternalSyntheticLambda6, new SaversKt$$ExternalSyntheticLambda2(b22));
        HyphensSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda0(b21), new SaversKt$$ExternalSyntheticLambda2(b11));
        FontStyleSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda0(b22), new SaversKt$$ExternalSyntheticLambda2((byte) 22), b3);
        FontSynthesisSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda0(b5), new SaversKt$$ExternalSyntheticLambda2((byte) 23), b3);
        TextUnitSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda0((byte) 22), new SaversKt$$ExternalSyntheticLambda2(b6));
        TextUnitTypeSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda0((byte) 23), new SaversKt$$ExternalSyntheticLambda2((byte) 25));
        OffsetSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda0((byte) 25), new SaversKt$$ExternalSyntheticLambda2((byte) 26));
        LocaleListSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda0((byte) 26), new SaversKt$$ExternalSyntheticLambda2((byte) 27), b3);
        LocaleSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda0((byte) 27), new SaversKt$$ExternalSyntheticLambda2((byte) 29), b3);
        LineHeightStyleSaver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda0(b12), new SaversKt$$ExternalSyntheticLambda6((byte) 1), b3);
        LineHeightStyleAlignmentSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda0((byte) 29), new SaversKt$$ExternalSyntheticLambda6((byte) 2));
        LineHeightStyleTrimSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda5((byte) 1), new SaversKt$$ExternalSyntheticLambda6(b9));
        LineHeightStyleModeSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda5((byte) 2), new SaversKt$$ExternalSyntheticLambda6(b13));
    }

    public static final Object save(Object obj, Saver saver, SaveableHolder saveableHolder) {
        Object objSave;
        return (obj == null || (objSave = saver.save(saveableHolder, obj)) == null) ? Boolean.FALSE : objSave;
    }
}
