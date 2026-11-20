package com.github.ajalt.colormath.internal;

import androidx.media3.extractor.text.CueDecoder;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ColorSpaceUtilsKt {
    public static final CueDecoder alphaInfo = new CueDecoder("alpha", CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);

    public static final void zeroOneComponentInfo(String str) {
        ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
        for (int i = 0; i < str.length(); i++) {
            listBuilderCreateListBuilder.add(new CueDecoder(String.valueOf(str.charAt(i)), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
        }
        listBuilderCreateListBuilder.add(alphaInfo);
        CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
    }
}
