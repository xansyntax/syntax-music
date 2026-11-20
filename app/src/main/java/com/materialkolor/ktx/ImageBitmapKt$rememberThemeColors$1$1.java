package com.materialkolor.ktx;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.ImageBitmap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageBitmapKt$rememberThemeColors$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $desired;
    public final /* synthetic */ long $fallback;
    public final /* synthetic */ boolean $filter;
    public final /* synthetic */ ImageBitmap $image;
    public final /* synthetic */ int $maxColors;
    public final /* synthetic */ MutableState $themeColors$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageBitmapKt$rememberThemeColors$1$1(ImageBitmap imageBitmap, int i, long j, boolean z, int i2, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.$image = imageBitmap;
        this.$maxColors = i;
        this.$fallback = j;
        this.$filter = z;
        this.$desired = i2;
        this.$themeColors$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ImageBitmapKt$rememberThemeColors$1$1(this.$image, this.$maxColors, this.$fallback, this.$filter, this.$desired, this.$themeColors$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ImageBitmapKt$rememberThemeColors$1$1 imageBitmapKt$rememberThemeColors$1$1 = (ImageBitmapKt$rememberThemeColors$1$1) create((CoroutineScope) obj, (Continuation) obj2);
        Unit unit = Unit.INSTANCE;
        imageBitmapKt$rememberThemeColors$1$1.invokeSuspend(unit);
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ResultKt.throwOnFailure(obj);
        this.$themeColors$delegate.setValue(ImageBitmapKt.m978themeColorsXOJAsU(this.$image, this.$maxColors, this.$fallback, this.$filter, this.$desired));
        return Unit.INSTANCE;
    }
}
