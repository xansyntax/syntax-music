package com.metrolist.music.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.palette.graphics.Palette;
import androidx.palette.graphics.Target;
import coil3.Image;
import coil3.ImageLoader$Builder;
import coil3.RealImageLoader;
import coil3.UriKt;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.ImageResult;
import coil3.size.RealSizeResolver;
import coil3.size.SizeKt;
import com.metrolist.music.ui.component.LyricsBackgroundStyle;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeToImage$createLyricsImage$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $artistName;
    public final /* synthetic */ Integer $backgroundColor;
    public final /* synthetic */ LyricsBackgroundStyle $backgroundStyle;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $coverArtUrl;
    public final /* synthetic */ String $lyrics;
    public final /* synthetic */ Layout.Alignment $lyricsAlignment;
    public final /* synthetic */ Integer $secondaryTextColor;
    public final /* synthetic */ String $songTitle;
    public final /* synthetic */ Integer $textColor;
    public float F$0;
    public float F$1;
    public short I$0;
    public short I$1;
    public int I$5;
    public int I$6;
    public int I$7;
    public Bitmap L$0;
    public Canvas L$1;
    public RectF L$2;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeToImage$createLyricsImage$2(Integer num, Integer num2, Integer num3, String str, Context context, LyricsBackgroundStyle lyricsBackgroundStyle, String str2, String str3, String str4, Layout.Alignment alignment, Continuation continuation) {
        super(2, continuation);
        this.$backgroundColor = num;
        this.$textColor = num2;
        this.$secondaryTextColor = num3;
        this.$coverArtUrl = str;
        this.$context = context;
        this.$backgroundStyle = lyricsBackgroundStyle;
        this.$songTitle = str2;
        this.$artistName = str3;
        this.$lyrics = str4;
        this.$lyricsAlignment = alignment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ComposeToImage$createLyricsImage$2(this.$backgroundColor, this.$textColor, this.$secondaryTextColor, this.$coverArtUrl, this.$context, this.$backgroundStyle, this.$songTitle, this.$artistName, this.$lyrics, this.$lyricsAlignment, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ComposeToImage$createLyricsImage$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:106:0x03c7 A[EDGE_INSN: B:106:0x03c7->B:77:0x03c7 BREAK  A[LOOP:0: B:71:0x038c->B:76:0x03c4], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x03c7 A[EDGE_INSN: B:107:0x03c7->B:77:0x03c7 BREAK  A[LOOP:0: B:71:0x038c->B:76:0x03c4], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x00c3 A[Catch: Exception -> 0x00d5, TRY_LEAVE, TryCatch #5 {Exception -> 0x00d5, blocks: (B:20:0x00bb, B:22:0x00c3), top: B:100:0x00bb }] */
    /* JADX WARN: Code duplicated, block: B:24:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:39:0x0130  */
    /* JADX WARN: Code duplicated, block: B:40:0x0139  */
    /* JADX WARN: Code duplicated, block: B:42:0x013d  */
    /* JADX WARN: Code duplicated, block: B:46:0x015b A[Catch: Exception -> 0x017a, TRY_LEAVE, TryCatch #3 {Exception -> 0x017a, blocks: (B:44:0x0149, B:46:0x015b), top: B:96:0x0149 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0185  */
    /* JADX WARN: Code duplicated, block: B:53:0x0190  */
    /* JADX WARN: Code duplicated, block: B:56:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:62:0x0211  */
    /* JADX WARN: Code duplicated, block: B:65:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:66:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:68:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:69:0x0325  */
    /* JADX WARN: Code duplicated, block: B:73:0x0399  */
    /* JADX WARN: Code duplicated, block: B:76:0x03c4 A[LOOP:0: B:71:0x038c->B:76:0x03c4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:79:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:96:0x0149 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.graphics.Paint, android.graphics.Rect] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        short s;
        Bitmap bitmapCreateBitmap;
        Canvas canvas;
        RectF rectF;
        float f;
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        float f2;
        Bitmap bitmap;
        float f3;
        short s2;
        Object objExecute;
        short s3;
        Canvas canvas2;
        Paint paint;
        int iOrdinal;
        Context context;
        float f4;
        Bitmap bitmap2;
        Paint.Style style;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        Drawable drawable;
        Bitmap bitmap$default;
        float f14;
        float f15;
        float f16;
        float f17;
        TextPaint textPaint;
        float f18;
        float f19;
        Layout.Alignment alignment;
        String str;
        float height;
        StaticLayout staticLayoutBuild;
        int iSave;
        Bitmap bitmapFastBlur;
        Canvas canvas3;
        Image image;
        Bitmap bitmap$default2;
        boolean z = this.label;
        Context context2 = this.$context;
        Bitmap bitmap3 = null;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            s = 2160;
            bitmapCreateBitmap = Bitmap.createBitmap(2160, 2160, Bitmap.Config.ARGB_8888);
            canvas = new Canvas(bitmapCreateBitmap);
            rectF = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 2160.0f, 2160.0f);
            Path path = new Path();
            f = 127.05882f;
            path.addRoundRect(rectF, 127.05882f, 127.05882f, Path.Direction.CW);
            canvas.clipPath(path);
            iIntValue = this.$backgroundColor.intValue();
            iIntValue2 = this.$textColor.intValue();
            iIntValue3 = this.$secondaryTextColor.intValue();
            String str2 = this.$coverArtUrl;
            f2 = 6.352941f;
            if (str2 != null) {
                try {
                    RealImageLoader realImageLoaderBuild = new ImageLoader$Builder(context2).build();
                    bitmap = null;
                    try {
                        ImageRequest.Builder builder = new ImageRequest.Builder(context2);
                        builder.data = str2;
                        builder.sizeResolver = new RealSizeResolver(SizeKt.Size(1024, 1024));
                        ImageRequests_androidKt.allowHardware(builder);
                        ImageRequest imageRequestBuild = builder.build();
                        this.L$0 = bitmapCreateBitmap;
                        this.L$1 = canvas;
                        this.L$2 = rectF;
                        this.I$0 = (short) 2160;
                        this.I$1 = (short) 2160;
                        this.F$0 = 6.352941f;
                        this.F$1 = 127.05882f;
                        this.I$5 = iIntValue;
                        this.I$6 = iIntValue2;
                        this.I$7 = iIntValue3;
                        this.label = true;
                        objExecute = realImageLoaderBuild.execute(imageRequestBuild, this);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objExecute == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        f3 = 6.352941f;
                        s2 = 2160;
                        canvas = canvas;
                        image = ((ImageResult) objExecute).getImage();
                        if (image != null) {
                            bitmap$default2 = UriKt.toBitmap$default(image);
                        } else {
                            bitmap$default2 = bitmap;
                        }
                        bitmap3 = bitmap$default2;
                        s3 = s;
                        s = s2;
                        canvas3 = canvas;
                        f2 = f3;
                        canvas2 = canvas3;
                    } catch (Exception unused) {
                        f3 = 6.352941f;
                        s2 = 2160;
                        s3 = s;
                        s = s2;
                        bitmap3 = bitmap;
                        canvas3 = canvas;
                        f2 = f3;
                        canvas2 = canvas3;
                        paint = new Paint();
                        paint.setAntiAlias(true);
                        iOrdinal = this.$backgroundStyle.ordinal();
                        if (iOrdinal != 0) {
                            if (iOrdinal == 1) {
                                f4 = f2;
                                paint.setColor(-16777216);
                                canvas2.drawRect(rectF, paint);
                                if (bitmap3 != null) {
                                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap3, s / 10, s3 / 10, true);
                                    bitmapCreateScaledBitmap.getClass();
                                    bitmapFastBlur = UtilsKt.fastBlur(bitmapCreateScaledBitmap);
                                    if (bitmapFastBlur != null) {
                                        bitmap2 = bitmapCreateBitmap;
                                        context = context2;
                                        RectF rectF2 = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, s, s3);
                                        ?? r2 = bitmap;
                                        canvas2.drawBitmap(bitmapFastBlur, (Rect) r2, rectF2, (Paint) r2);
                                        Paint paint2 = new Paint();
                                        paint2.setColor(1291845632);
                                        canvas2.drawRect(rectF2, paint2);
                                    }
                                } else {
                                    context = context2;
                                    bitmap2 = bitmapCreateBitmap;
                                    paint.setColor(iIntValue);
                                    canvas2.drawRect(rectF, paint);
                                }
                            } else {
                                if (iOrdinal != 2) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return bitmap;
                                }
                                if (bitmap3 != null) {
                                    Palette paletteGenerate = new Palette.Builder(bitmap3).generate();
                                    f4 = f2;
                                    paint.setShader(new LinearGradient(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, s, s3, new int[]{paletteGenerate.getColorForTarget(Target.VIBRANT, iIntValue), paletteGenerate.getColorForTarget(Target.DARK_VIBRANT, iIntValue)}, (float[]) null, Shader.TileMode.CLAMP));
                                    canvas2.drawRect(rectF, paint);
                                } else {
                                    f4 = f2;
                                    paint.setColor(iIntValue);
                                    canvas2.drawRect(rectF, paint);
                                }
                            }
                            context = context2;
                            bitmap2 = bitmapCreateBitmap;
                        } else {
                            context = context2;
                            f4 = f2;
                            bitmap2 = bitmapCreateBitmap;
                            paint.setColor(iIntValue);
                            canvas2.drawRect(rectF, paint);
                        }
                        Paint paint3 = new Paint();
                        paint3.setColor(iIntValue2);
                        paint3.setAlpha(22);
                        style = Paint.Style.STROKE;
                        paint3.setStyle(style);
                        f5 = f4 * 1.0f;
                        paint3.setStrokeWidth(f5);
                        paint3.setAntiAlias(true);
                        canvas2.drawRoundRect(rectF, f, f, paint3);
                        f6 = 28.0f * f4;
                        f7 = 64.0f * f4;
                        float f20 = 12.0f * f4;
                        f8 = 3.0f * f4;
                        if (bitmap3 != null) {
                            float f21 = f6 + f7;
                            RectF rectF3 = new RectF(f6, f6, f21, f21);
                            Path path2 = new Path();
                            path2.addRoundRect(rectF3, f8, f8, Path.Direction.CW);
                            Paint paint4 = new Paint();
                            paint4.setColor(iIntValue2);
                            paint4.setAlpha(40);
                            paint4.setStyle(style);
                            paint4.setStrokeWidth(f5);
                            paint4.setAntiAlias(true);
                            iSave = canvas2.save();
                            canvas2.clipPath(path2);
                            canvas2.drawBitmap(bitmap3, (Rect) null, rectF3, (Paint) null);
                            canvas2.restoreToCount(iSave);
                            canvas2.drawRoundRect(rectF3, f8, f8, paint4);
                        }
                        float f22 = f6 + f7;
                        f9 = 16.0f * f4;
                        float f23 = f22 + f9;
                        float f24 = s;
                        TextPaint textPaint2 = new TextPaint();
                        textPaint2.setColor(iIntValue2);
                        textPaint2.setTextSize(20.0f * f4);
                        Typeface typeface = Typeface.DEFAULT_BOLD;
                        textPaint2.setTypeface(typeface);
                        textPaint2.setAntiAlias(true);
                        TextPaint textPaint3 = new TextPaint();
                        textPaint3.setColor(iIntValue3);
                        textPaint3.setTextSize(f9);
                        Typeface typeface2 = Typeface.DEFAULT;
                        textPaint3.setTypeface(typeface2);
                        textPaint3.setAntiAlias(true);
                        String str3 = this.$songTitle;
                        int i = (int) ((f24 - f23) - f6);
                        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(str3, 0, str3.length(), textPaint2, i);
                        Layout.Alignment alignment2 = Layout.Alignment.ALIGN_NORMAL;
                        StaticLayout.Builder maxLines = builderObtain.setAlignment(alignment2).setMaxLines(1);
                        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
                        StaticLayout staticLayoutBuild2 = maxLines.setEllipsize(truncateAt).build();
                        staticLayoutBuild2.getClass();
                        String str4 = this.$artistName;
                        StaticLayout staticLayoutBuild3 = StaticLayout.Builder.obtain(str4, 0, str4.length(), textPaint3, i).setAlignment(alignment2).setMaxLines(1).setEllipsize(truncateAt).build();
                        staticLayoutBuild3.getClass();
                        float f25 = f4 * 2.0f;
                        float height2 = ((f7 / 2.0f) + f6) - (((staticLayoutBuild3.getHeight() + staticLayoutBuild2.getHeight()) + f25) / 2.0f);
                        canvas2.save();
                        canvas2.translate(f23, height2);
                        staticLayoutBuild2.draw(canvas2);
                        canvas2.translate(CropImageView.DEFAULT_ASPECT_RATIO, staticLayoutBuild2.getHeight() + f25);
                        staticLayoutBuild3.draw(canvas2);
                        canvas2.restore();
                        f10 = 22.0f * f4;
                        f11 = (s3 - f6) - f10;
                        Paint paint5 = new Paint();
                        paint5.setColor(iIntValue3);
                        paint5.setAntiAlias(true);
                        f12 = f6 + f10;
                        f13 = f11 + f10;
                        canvas2.drawOval(new RectF(f6, f11, f12, f13), paint5);
                        Context context3 = context;
                        drawable = context3.getDrawable(R.drawable.small_icon);
                        if (drawable != null) {
                            bitmap$default = MathKt.toBitmap$default(drawable, 7);
                        } else {
                            bitmap$default = null;
                        }
                        if (bitmap$default != null) {
                            Paint paint6 = new Paint();
                            f14 = 2.0f;
                            paint6.setColorFilter(new PorterDuffColorFilter(iIntValue, PorterDuff.Mode.SRC_IN));
                            paint6.setAntiAlias(true);
                            float f26 = (f10 - f9) / 2.0f;
                            canvas2.drawBitmap(bitmap$default, (Rect) null, new RectF(f6 + f26, f11 + f26, f12 - f26, f13 - f26), paint6);
                        } else {
                            f14 = 2.0f;
                        }
                        String string = context3.getString(R.string.app_name);
                        string.getClass();
                        TextPaint textPaint4 = new TextPaint();
                        textPaint4.setColor(iIntValue3);
                        textPaint4.setTextSize(f4 * 14.0f);
                        textPaint4.setTypeface(typeface);
                        textPaint4.setAntiAlias(true);
                        canvas2.drawText(string, (f4 * 8.0f) + f12, ((f10 / f14) + f11) - ((textPaint4.ascent() + textPaint4.descent()) / f14), textPaint4);
                        f15 = f22 + f20;
                        f16 = (f11 - f20) - f15;
                        f17 = f24 - (f6 * f14);
                        textPaint = new TextPaint();
                        textPaint.setColor(iIntValue2);
                        textPaint.setTypeface(Typeface.create(typeface2, 1));
                        textPaint.setAntiAlias(true);
                        textPaint.setLetterSpacing(0.005f);
                        f18 = f4 * 50.0f;
                        f19 = 13.0f * f4;
                        while (true) {
                            alignment = this.$lyricsAlignment;
                            str = this.$lyrics;
                            if (f18 <= f19) {
                                break;
                                break;
                            }
                            textPaint.setTextSize(f18);
                            staticLayoutBuild = StaticLayout.Builder.obtain(str, 0, str.length(), textPaint, (int) f17).setAlignment(alignment).setLineSpacing(CropImageView.DEFAULT_ASPECT_RATIO, 1.2f).setIncludePad(false).build();
                            staticLayoutBuild.getClass();
                            if (staticLayoutBuild.getHeight() <= f16) {
                                break;
                                break;
                            }
                            f18 -= f5;
                        }
                        textPaint.setTextSize(f18);
                        StaticLayout staticLayoutBuild4 = StaticLayout.Builder.obtain(str, 0, str.length(), textPaint, (int) f17).setAlignment(alignment).setLineSpacing(CropImageView.DEFAULT_ASPECT_RATIO, 1.2f).setIncludePad(false).build();
                        staticLayoutBuild4.getClass();
                        height = staticLayoutBuild4.getHeight();
                        if (height < f16) {
                            f15 += (f16 - height) / f14;
                        }
                        int iSave2 = canvas2.save();
                        canvas2.translate(f6, f15);
                        staticLayoutBuild4.draw(canvas2);
                        return bitmap2;
                    }
                } catch (Exception unused2) {
                    bitmap = null;
                }
            } else {
                bitmap = null;
                s3 = 2160;
                canvas2 = canvas;
            }
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            iIntValue3 = this.I$7;
            iIntValue2 = this.I$6;
            iIntValue = this.I$5;
            f = this.F$1;
            f3 = this.F$0;
            s = this.I$1;
            s2 = this.I$0;
            rectF = this.L$2;
            canvas = this.L$1;
            bitmapCreateBitmap = this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                objExecute = obj;
                bitmap = null;
                canvas = canvas;
                try {
                    image = ((ImageResult) objExecute).getImage();
                    if (image != null) {
                        bitmap$default2 = UriKt.toBitmap$default(image);
                    } else {
                        bitmap$default2 = bitmap;
                    }
                    bitmap3 = bitmap$default2;
                    s3 = s;
                    s = s2;
                    canvas3 = canvas;
                } catch (Exception unused3) {
                    s3 = s;
                    s = s2;
                    bitmap3 = bitmap;
                    canvas3 = canvas;
                }
            } catch (Exception unused4) {
                bitmap = null;
                s3 = s;
                s = s2;
                bitmap3 = bitmap;
                canvas3 = canvas;
                f2 = f3;
                canvas2 = canvas3;
                paint = new Paint();
                paint.setAntiAlias(true);
                iOrdinal = this.$backgroundStyle.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal == 1) {
                        f4 = f2;
                        paint.setColor(-16777216);
                        canvas2.drawRect(rectF, paint);
                        if (bitmap3 != null) {
                            try {
                                Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmap3, s / 10, s3 / 10, true);
                                bitmapCreateScaledBitmap2.getClass();
                                bitmapFastBlur = UtilsKt.fastBlur(bitmapCreateScaledBitmap2);
                                if (bitmapFastBlur != null) {
                                    bitmap2 = bitmapCreateBitmap;
                                    context = context2;
                                    try {
                                        RectF rectF4 = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, s, s3);
                                        ?? r3 = bitmap;
                                        canvas2.drawBitmap(bitmapFastBlur, (Rect) r3, rectF4, (Paint) r3);
                                        Paint paint7 = new Paint();
                                        paint7.setColor(1291845632);
                                        canvas2.drawRect(rectF4, paint7);
                                    } catch (Exception unused5) {
                                        paint.setColor(iIntValue);
                                        canvas2.drawRect(rectF, paint);
                                    }
                                }
                            } catch (Exception unused6) {
                                context = context2;
                                bitmap2 = bitmapCreateBitmap;
                            }
                        } else {
                            context = context2;
                            bitmap2 = bitmapCreateBitmap;
                            paint.setColor(iIntValue);
                            canvas2.drawRect(rectF, paint);
                        }
                    } else {
                        if (iOrdinal != 2) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return bitmap;
                        }
                        if (bitmap3 != null) {
                            Palette paletteGenerate2 = new Palette.Builder(bitmap3).generate();
                            f4 = f2;
                            paint.setShader(new LinearGradient(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, s, s3, new int[]{paletteGenerate2.getColorForTarget(Target.VIBRANT, iIntValue), paletteGenerate2.getColorForTarget(Target.DARK_VIBRANT, iIntValue)}, (float[]) null, Shader.TileMode.CLAMP));
                            canvas2.drawRect(rectF, paint);
                        } else {
                            f4 = f2;
                            paint.setColor(iIntValue);
                            canvas2.drawRect(rectF, paint);
                        }
                    }
                    context = context2;
                    bitmap2 = bitmapCreateBitmap;
                } else {
                    context = context2;
                    f4 = f2;
                    bitmap2 = bitmapCreateBitmap;
                    paint.setColor(iIntValue);
                    canvas2.drawRect(rectF, paint);
                }
                Paint paint8 = new Paint();
                paint8.setColor(iIntValue2);
                paint8.setAlpha(22);
                style = Paint.Style.STROKE;
                paint8.setStyle(style);
                f5 = f4 * 1.0f;
                paint8.setStrokeWidth(f5);
                paint8.setAntiAlias(true);
                canvas2.drawRoundRect(rectF, f, f, paint8);
                f6 = 28.0f * f4;
                f7 = 64.0f * f4;
                float f27 = 12.0f * f4;
                f8 = 3.0f * f4;
                if (bitmap3 != null) {
                    float f28 = f6 + f7;
                    RectF rectF5 = new RectF(f6, f6, f28, f28);
                    Path path3 = new Path();
                    path3.addRoundRect(rectF5, f8, f8, Path.Direction.CW);
                    Paint paint9 = new Paint();
                    paint9.setColor(iIntValue2);
                    paint9.setAlpha(40);
                    paint9.setStyle(style);
                    paint9.setStrokeWidth(f5);
                    paint9.setAntiAlias(true);
                    iSave = canvas2.save();
                    canvas2.clipPath(path3);
                    try {
                        canvas2.drawBitmap(bitmap3, (Rect) null, rectF5, (Paint) null);
                        canvas2.restoreToCount(iSave);
                        canvas2.drawRoundRect(rectF5, f8, f8, paint9);
                    } catch (Throwable th) {
                        canvas2.restoreToCount(iSave);
                        throw th;
                    }
                }
                float f29 = f6 + f7;
                f9 = 16.0f * f4;
                float f210 = f29 + f9;
                float f211 = s;
                TextPaint textPaint5 = new TextPaint();
                textPaint5.setColor(iIntValue2);
                textPaint5.setTextSize(20.0f * f4);
                Typeface typeface3 = Typeface.DEFAULT_BOLD;
                textPaint5.setTypeface(typeface3);
                textPaint5.setAntiAlias(true);
                TextPaint textPaint6 = new TextPaint();
                textPaint6.setColor(iIntValue3);
                textPaint6.setTextSize(f9);
                Typeface typeface4 = Typeface.DEFAULT;
                textPaint6.setTypeface(typeface4);
                textPaint6.setAntiAlias(true);
                String str5 = this.$songTitle;
                int i2 = (int) ((f211 - f210) - f6);
                StaticLayout.Builder builderObtain2 = StaticLayout.Builder.obtain(str5, 0, str5.length(), textPaint5, i2);
                Layout.Alignment alignment3 = Layout.Alignment.ALIGN_NORMAL;
                StaticLayout.Builder maxLines2 = builderObtain2.setAlignment(alignment3).setMaxLines(1);
                TextUtils.TruncateAt truncateAt2 = TextUtils.TruncateAt.END;
                StaticLayout staticLayoutBuild5 = maxLines2.setEllipsize(truncateAt2).build();
                staticLayoutBuild5.getClass();
                String str6 = this.$artistName;
                StaticLayout staticLayoutBuild6 = StaticLayout.Builder.obtain(str6, 0, str6.length(), textPaint6, i2).setAlignment(alignment3).setMaxLines(1).setEllipsize(truncateAt2).build();
                staticLayoutBuild6.getClass();
                float f212 = f4 * 2.0f;
                float height3 = ((f7 / 2.0f) + f6) - (((staticLayoutBuild6.getHeight() + staticLayoutBuild5.getHeight()) + f212) / 2.0f);
                canvas2.save();
                canvas2.translate(f210, height3);
                staticLayoutBuild5.draw(canvas2);
                canvas2.translate(CropImageView.DEFAULT_ASPECT_RATIO, staticLayoutBuild5.getHeight() + f212);
                staticLayoutBuild6.draw(canvas2);
                canvas2.restore();
                f10 = 22.0f * f4;
                f11 = (s3 - f6) - f10;
                Paint paint10 = new Paint();
                paint10.setColor(iIntValue3);
                paint10.setAntiAlias(true);
                f12 = f6 + f10;
                f13 = f11 + f10;
                canvas2.drawOval(new RectF(f6, f11, f12, f13), paint10);
                Context context4 = context;
                drawable = context4.getDrawable(R.drawable.small_icon);
                if (drawable != null) {
                    bitmap$default = MathKt.toBitmap$default(drawable, 7);
                } else {
                    bitmap$default = null;
                }
                if (bitmap$default != null) {
                    Paint paint11 = new Paint();
                    f14 = 2.0f;
                    paint11.setColorFilter(new PorterDuffColorFilter(iIntValue, PorterDuff.Mode.SRC_IN));
                    paint11.setAntiAlias(true);
                    float f213 = (f10 - f9) / 2.0f;
                    canvas2.drawBitmap(bitmap$default, (Rect) null, new RectF(f6 + f213, f11 + f213, f12 - f213, f13 - f213), paint11);
                } else {
                    f14 = 2.0f;
                }
                String string2 = context4.getString(R.string.app_name);
                string2.getClass();
                TextPaint textPaint7 = new TextPaint();
                textPaint7.setColor(iIntValue3);
                textPaint7.setTextSize(f4 * 14.0f);
                textPaint7.setTypeface(typeface3);
                textPaint7.setAntiAlias(true);
                canvas2.drawText(string2, (f4 * 8.0f) + f12, ((f10 / f14) + f11) - ((textPaint7.ascent() + textPaint7.descent()) / f14), textPaint7);
                f15 = f29 + f27;
                f16 = (f11 - f27) - f15;
                f17 = f211 - (f6 * f14);
                textPaint = new TextPaint();
                textPaint.setColor(iIntValue2);
                textPaint.setTypeface(Typeface.create(typeface4, 1));
                textPaint.setAntiAlias(true);
                textPaint.setLetterSpacing(0.005f);
                f18 = f4 * 50.0f;
                f19 = 13.0f * f4;
                while (true) {
                    alignment = this.$lyricsAlignment;
                    str = this.$lyrics;
                    if (f18 <= f19) {
                        break;
                    }
                    textPaint.setTextSize(f18);
                    staticLayoutBuild = StaticLayout.Builder.obtain(str, 0, str.length(), textPaint, (int) f17).setAlignment(alignment).setLineSpacing(CropImageView.DEFAULT_ASPECT_RATIO, 1.2f).setIncludePad(false).build();
                    staticLayoutBuild.getClass();
                    if (staticLayoutBuild.getHeight() <= f16) {
                        break;
                    }
                    f18 -= f5;
                }
                textPaint.setTextSize(f18);
                StaticLayout staticLayoutBuild7 = StaticLayout.Builder.obtain(str, 0, str.length(), textPaint, (int) f17).setAlignment(alignment).setLineSpacing(CropImageView.DEFAULT_ASPECT_RATIO, 1.2f).setIncludePad(false).build();
                staticLayoutBuild7.getClass();
                height = staticLayoutBuild7.getHeight();
                if (height < f16) {
                    f15 += (f16 - height) / f14;
                }
                int iSave3 = canvas2.save();
                canvas2.translate(f6, f15);
                staticLayoutBuild7.draw(canvas2);
                return bitmap2;
            }
            f2 = f3;
            canvas2 = canvas3;
        }
        paint = new Paint();
        paint.setAntiAlias(true);
        iOrdinal = this.$backgroundStyle.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                f4 = f2;
                paint.setColor(-16777216);
                canvas2.drawRect(rectF, paint);
                if (bitmap3 != null) {
                    Bitmap bitmapCreateScaledBitmap3 = Bitmap.createScaledBitmap(bitmap3, s / 10, s3 / 10, true);
                    bitmapCreateScaledBitmap3.getClass();
                    bitmapFastBlur = UtilsKt.fastBlur(bitmapCreateScaledBitmap3);
                    if (bitmapFastBlur != null) {
                        bitmap2 = bitmapCreateBitmap;
                        context = context2;
                        RectF rectF6 = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, s, s3);
                        ?? r4 = bitmap;
                        canvas2.drawBitmap(bitmapFastBlur, (Rect) r4, rectF6, (Paint) r4);
                        Paint paint12 = new Paint();
                        paint12.setColor(1291845632);
                        canvas2.drawRect(rectF6, paint12);
                    }
                } else {
                    context = context2;
                    bitmap2 = bitmapCreateBitmap;
                    paint.setColor(iIntValue);
                    canvas2.drawRect(rectF, paint);
                }
            } else {
                if (iOrdinal != 2) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return bitmap;
                }
                if (bitmap3 != null) {
                    Palette paletteGenerate3 = new Palette.Builder(bitmap3).generate();
                    f4 = f2;
                    paint.setShader(new LinearGradient(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, s, s3, new int[]{paletteGenerate3.getColorForTarget(Target.VIBRANT, iIntValue), paletteGenerate3.getColorForTarget(Target.DARK_VIBRANT, iIntValue)}, (float[]) null, Shader.TileMode.CLAMP));
                    canvas2.drawRect(rectF, paint);
                } else {
                    f4 = f2;
                    paint.setColor(iIntValue);
                    canvas2.drawRect(rectF, paint);
                }
            }
            context = context2;
            bitmap2 = bitmapCreateBitmap;
        } else {
            context = context2;
            f4 = f2;
            bitmap2 = bitmapCreateBitmap;
            paint.setColor(iIntValue);
            canvas2.drawRect(rectF, paint);
        }
        Paint paint13 = new Paint();
        paint13.setColor(iIntValue2);
        paint13.setAlpha(22);
        style = Paint.Style.STROKE;
        paint13.setStyle(style);
        f5 = f4 * 1.0f;
        paint13.setStrokeWidth(f5);
        paint13.setAntiAlias(true);
        canvas2.drawRoundRect(rectF, f, f, paint13);
        f6 = 28.0f * f4;
        f7 = 64.0f * f4;
        float f214 = 12.0f * f4;
        f8 = 3.0f * f4;
        if (bitmap3 != null) {
            float f215 = f6 + f7;
            RectF rectF7 = new RectF(f6, f6, f215, f215);
            Path path4 = new Path();
            path4.addRoundRect(rectF7, f8, f8, Path.Direction.CW);
            Paint paint14 = new Paint();
            paint14.setColor(iIntValue2);
            paint14.setAlpha(40);
            paint14.setStyle(style);
            paint14.setStrokeWidth(f5);
            paint14.setAntiAlias(true);
            iSave = canvas2.save();
            canvas2.clipPath(path4);
            canvas2.drawBitmap(bitmap3, (Rect) null, rectF7, (Paint) null);
            canvas2.restoreToCount(iSave);
            canvas2.drawRoundRect(rectF7, f8, f8, paint14);
        }
        float f216 = f6 + f7;
        f9 = 16.0f * f4;
        float f217 = f216 + f9;
        float f218 = s;
        TextPaint textPaint8 = new TextPaint();
        textPaint8.setColor(iIntValue2);
        textPaint8.setTextSize(20.0f * f4);
        Typeface typeface5 = Typeface.DEFAULT_BOLD;
        textPaint8.setTypeface(typeface5);
        textPaint8.setAntiAlias(true);
        TextPaint textPaint9 = new TextPaint();
        textPaint9.setColor(iIntValue3);
        textPaint9.setTextSize(f9);
        Typeface typeface6 = Typeface.DEFAULT;
        textPaint9.setTypeface(typeface6);
        textPaint9.setAntiAlias(true);
        String str7 = this.$songTitle;
        int i3 = (int) ((f218 - f217) - f6);
        StaticLayout.Builder builderObtain3 = StaticLayout.Builder.obtain(str7, 0, str7.length(), textPaint8, i3);
        Layout.Alignment alignment4 = Layout.Alignment.ALIGN_NORMAL;
        StaticLayout.Builder maxLines3 = builderObtain3.setAlignment(alignment4).setMaxLines(1);
        TextUtils.TruncateAt truncateAt3 = TextUtils.TruncateAt.END;
        StaticLayout staticLayoutBuild8 = maxLines3.setEllipsize(truncateAt3).build();
        staticLayoutBuild8.getClass();
        String str8 = this.$artistName;
        StaticLayout staticLayoutBuild9 = StaticLayout.Builder.obtain(str8, 0, str8.length(), textPaint9, i3).setAlignment(alignment4).setMaxLines(1).setEllipsize(truncateAt3).build();
        staticLayoutBuild9.getClass();
        float f219 = f4 * 2.0f;
        float height4 = ((f7 / 2.0f) + f6) - (((staticLayoutBuild9.getHeight() + staticLayoutBuild8.getHeight()) + f219) / 2.0f);
        canvas2.save();
        canvas2.translate(f217, height4);
        staticLayoutBuild8.draw(canvas2);
        canvas2.translate(CropImageView.DEFAULT_ASPECT_RATIO, staticLayoutBuild8.getHeight() + f219);
        staticLayoutBuild9.draw(canvas2);
        canvas2.restore();
        f10 = 22.0f * f4;
        f11 = (s3 - f6) - f10;
        Paint paint15 = new Paint();
        paint15.setColor(iIntValue3);
        paint15.setAntiAlias(true);
        f12 = f6 + f10;
        f13 = f11 + f10;
        canvas2.drawOval(new RectF(f6, f11, f12, f13), paint15);
        Context context5 = context;
        drawable = context5.getDrawable(R.drawable.small_icon);
        if (drawable != null) {
            bitmap$default = MathKt.toBitmap$default(drawable, 7);
        } else {
            bitmap$default = null;
        }
        if (bitmap$default != null) {
            Paint paint16 = new Paint();
            f14 = 2.0f;
            paint16.setColorFilter(new PorterDuffColorFilter(iIntValue, PorterDuff.Mode.SRC_IN));
            paint16.setAntiAlias(true);
            float f2110 = (f10 - f9) / 2.0f;
            canvas2.drawBitmap(bitmap$default, (Rect) null, new RectF(f6 + f2110, f11 + f2110, f12 - f2110, f13 - f2110), paint16);
        } else {
            f14 = 2.0f;
        }
        String string3 = context5.getString(R.string.app_name);
        string3.getClass();
        TextPaint textPaint10 = new TextPaint();
        textPaint10.setColor(iIntValue3);
        textPaint10.setTextSize(f4 * 14.0f);
        textPaint10.setTypeface(typeface5);
        textPaint10.setAntiAlias(true);
        canvas2.drawText(string3, (f4 * 8.0f) + f12, ((f10 / f14) + f11) - ((textPaint10.ascent() + textPaint10.descent()) / f14), textPaint10);
        f15 = f216 + f214;
        f16 = (f11 - f214) - f15;
        f17 = f218 - (f6 * f14);
        textPaint = new TextPaint();
        textPaint.setColor(iIntValue2);
        textPaint.setTypeface(Typeface.create(typeface6, 1));
        textPaint.setAntiAlias(true);
        textPaint.setLetterSpacing(0.005f);
        f18 = f4 * 50.0f;
        f19 = 13.0f * f4;
        while (true) {
            alignment = this.$lyricsAlignment;
            str = this.$lyrics;
            if (f18 <= f19) {
                break;
                break;
            }
            textPaint.setTextSize(f18);
            staticLayoutBuild = StaticLayout.Builder.obtain(str, 0, str.length(), textPaint, (int) f17).setAlignment(alignment).setLineSpacing(CropImageView.DEFAULT_ASPECT_RATIO, 1.2f).setIncludePad(false).build();
            staticLayoutBuild.getClass();
            if (staticLayoutBuild.getHeight() <= f16) {
                break;
                break;
            }
            f18 -= f5;
        }
        textPaint.setTextSize(f18);
        StaticLayout staticLayoutBuild10 = StaticLayout.Builder.obtain(str, 0, str.length(), textPaint, (int) f17).setAlignment(alignment).setLineSpacing(CropImageView.DEFAULT_ASPECT_RATIO, 1.2f).setIncludePad(false).build();
        staticLayoutBuild10.getClass();
        height = staticLayoutBuild10.getHeight();
        if (height < f16) {
            f15 += (f16 - height) / f14;
        }
        int iSave4 = canvas2.save();
        canvas2.translate(f6, f15);
        try {
            staticLayoutBuild10.draw(canvas2);
            return bitmap2;
        } finally {
            canvas2.restoreToCount(iSave4);
        }
    }
}
