package com.github.ajalt.colormath.model;

import androidx.media3.extractor.text.CueDecoder;
import com.github.ajalt.colormath.WhitePoint;
import com.github.ajalt.colormath.WhitePointColorSpace;
import com.github.ajalt.colormath.internal.ColorSpaceUtilsKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LABColorSpaceImpl implements WhitePointColorSpace {
    public final WhitePoint whitePoint;

    public LABColorSpaceImpl(WhitePoint whitePoint) {
        whitePoint.getClass();
        this.whitePoint = whitePoint;
        CueDecoder cueDecoder = ColorSpaceUtilsKt.alphaInfo;
        CueDecoder[] cueDecoderArr = {new CueDecoder("L", CropImageView.DEFAULT_ASPECT_RATIO, 100.0f), new CueDecoder("A", -128.0f, 128.0f), new CueDecoder("B", -128.0f, 128.0f)};
        Headers.Builder builder = new Headers.Builder(2);
        builder.addSpread(cueDecoderArr);
        builder.add(ColorSpaceUtilsKt.alphaInfo);
        ArrayList arrayList = builder.namesAndValues;
        CollectionsKt__IterablesKt.listOf(arrayList.toArray(new CueDecoder[arrayList.size()]));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LABColorSpaceImpl) {
            return Intrinsics.areEqual(this.whitePoint, ((LABColorSpaceImpl) obj).whitePoint);
        }
        return false;
    }

    @Override // com.github.ajalt.colormath.WhitePointColorSpace
    public final WhitePoint getWhitePoint() {
        throw null;
    }

    public final int hashCode() {
        return this.whitePoint.hashCode();
    }

    public final String toString() {
        return "LABColorSpace(" + this.whitePoint + ')';
    }
}
