package com.materialkolor.ktx;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ImageBitmap;
import com.metrolist.music.discord.DiscordGateway;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageBitmapKt$rememberThemeColor$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ long $fallback;
    public boolean $filter;
    public final /* synthetic */ Object $image;
    public final /* synthetic */ int $maxColors;
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object $themeColor$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageBitmapKt$rememberThemeColor$1$1(ImageBitmap imageBitmap, long j, boolean z, int i, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.$image = imageBitmap;
        this.$fallback = j;
        this.$filter = z;
        this.$maxColors = i;
        this.$themeColor$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$themeColor$delegate;
        Object obj3 = this.$image;
        switch (b) {
            case 0:
                return new ImageBitmapKt$rememberThemeColor$1$1((ImageBitmap) obj3, this.$fallback, this.$filter, this.$maxColors, (MutableState) obj2, continuation);
            default:
                long j = this.$fallback;
                return new ImageBitmapKt$rememberThemeColor$1$1((DiscordGateway) obj3, this.$maxColors, (String) obj2, j, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                ((ImageBitmapKt$rememberThemeColor$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            default:
                return ((ImageBitmapKt$rememberThemeColor$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.$themeColor$delegate;
        Object obj3 = this.$image;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                ((MutableState) obj2).setValue(new Color(ImageBitmapKt.m976themeColorRPmYEkk((ImageBitmap) obj3, this.$fallback, this.$filter, this.$maxColors)));
                return unit;
            default:
                boolean z = this.$filter;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                this.$filter = true;
                Object objHandleClose = ((DiscordGateway) obj3).handleClose(this.$maxColors, (String) obj2, true, this.$fallback, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                return objHandleClose == coroutineSingletons ? coroutineSingletons : unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageBitmapKt$rememberThemeColor$1$1(DiscordGateway discordGateway, int i, String str, long j, Continuation continuation) {
        super(2, continuation);
        this.$image = discordGateway;
        this.$maxColors = i;
        this.$themeColor$delegate = str;
        this.$fallback = j;
    }
}
