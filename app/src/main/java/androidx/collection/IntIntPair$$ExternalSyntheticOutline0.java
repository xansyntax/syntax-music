package androidx.collection;

import androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1$1;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.extractor.flv.TagPayloadReader;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import kotlin.ResultKt;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class IntIntPair$$ExternalSyntheticOutline0 {
    public static String m(int i, String str, String str2, int i2, String str3) {
        return str + i + str2 + i2 + str3;
    }

    public static int m(float f, int i, int i2) {
        return (Float.hashCode(f) + i) * i2;
    }

    public static int m(int i, int i2, int i3) {
        return (Integer.hashCode(i) + i2) * i3;
    }

    public static int m(int i, int i2, long j) {
        return (Long.hashCode(j) + i) * i2;
    }

    public static int m(int i, boolean z, int i2) {
        return (Boolean.hashCode(z) + i) * i2;
    }

    public static TwoWayConverterImpl m(ColorVectorConverterKt$ColorToVector$1$1 colorVectorConverterKt$ColorToVector$1$1, CallsKt$await$2$1 callsKt$await$2$1, GapComposer gapComposer) {
        TwoWayConverterImpl twoWayConverterImpl = new TwoWayConverterImpl(colorVectorConverterKt$ColorToVector$1$1, callsKt$await$2$1);
        gapComposer.updateRememberedValue(twoWayConverterImpl);
        return twoWayConverterImpl;
    }

    public static MutableInteractionSourceImpl m(GapComposer gapComposer) {
        MutableInteractionSourceImpl mutableInteractionSourceImpl = new MutableInteractionSourceImpl();
        gapComposer.updateRememberedValue(mutableInteractionSourceImpl);
        return mutableInteractionSourceImpl;
    }

    public static ClassCastException m(Object obj) {
        obj.getClass();
        return new ClassCastException();
    }

    public static Object m(GapComposer gapComposer, int i, boolean z, TagPayloadReader tagPayloadReader) {
        gapComposer.startReplaceGroup(i);
        gapComposer.end(z);
        return tagPayloadReader.getCurrentState();
    }

    public static String m(int i, String str) {
        return str + i;
    }

    public static String m(int i, String str, String str2) {
        return str + i + str2;
    }

    public static double m(double d, double d2, double d3, double d4) {
        return (d3 - (d * d2)) / d4;
    }

    public static String m(long j, String str, String str2) {
        return str + j + str2;
    }

    public static String m(String str, float f, String str2) {
        return str + f + str2;
    }

    public static String m(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String m(StringBuilder sb, int i, char c) {
        sb.append(i);
        sb.append(c);
        return sb.toString();
    }

    public static String m(StringBuilder sb, long j, String str) {
        sb.append(j);
        sb.append(str);
        return sb.toString();
    }

    public static String m(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String m(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    public static String m(StringBuilder sb, boolean z, String str) {
        sb.append(z);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static StringBuilder m2m(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static StringBuilder m3m(int i, String str, String str2, int i2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder m(String str, float f, String str2, float f2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(f);
        sb.append(str2);
        sb.append(f2);
        sb.append(str3);
        return sb;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static StringBuilder m4m(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder m(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static Ref$ObjectRef m5m(Object obj) {
        ResultKt.throwOnFailure(obj);
        return new Ref$ObjectRef();
    }

    public static void m(int i, GapComposer gapComposer, Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0, GapComposer gapComposer2) {
        Stack.m390setimpl(gapComposer, Integer.valueOf(i), updater$$ExternalSyntheticLambda0);
        Stack.m389reconcileimpl(gapComposer2);
    }

    public static void m(EmojiProcessor emojiProcessor, long j) {
        emojiProcessor.getCanvas().restore();
        emojiProcessor.m832setSizeuvyYCjk(j);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static void m6m(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }
}
