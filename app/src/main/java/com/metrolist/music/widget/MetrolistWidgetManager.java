package com.metrolist.music.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RemoteViews;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import com.metrolist.music.MainActivity;
import com.metrolist.music.db.MusicDatabase;
import com.valentinilk.shimmer.ShimmerModifierKt$shimmer$1$1;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MetrolistWidgetManager {
    public Bitmap cachedAlbumArt;
    public String cachedArtworkUri;
    public Bitmap cachedCircularAlbumArt;
    public final Context context;
    public final SynchronizedLazyImpl imageLoader$delegate;
    public final PlaylistWidgetManager playlistWidgetManager;

    /* JADX INFO: renamed from: com.metrolist.music.widget.MetrolistWidgetManager$updateWidgets$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public long J$0;
        public long J$1;
        public String L$0;
        public String L$1;
        public String L$2;
        public AppWidgetManager L$3;
        public boolean Z$0;
        public boolean Z$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetrolistWidgetManager.this.updateWidgets(null, null, null, false, false, 0L, 0L, this);
        }
    }

    public MetrolistWidgetManager(Context context, MusicDatabase musicDatabase, PlaylistWidgetManager playlistWidgetManager) {
        musicDatabase.getClass();
        playlistWidgetManager.getClass();
        this.context = context;
        this.playlistWidgetManager = playlistWidgetManager;
        this.imageLoader$delegate = new SynchronizedLazyImpl(new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 20, this));
    }

    public static Bitmap getCircularBitmap(Bitmap bitmap) {
        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - iMin) / 2, (bitmap.getHeight() - iMin) / 2, iMin, iMin);
        bitmapCreateBitmap.getClass();
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap2.getClass();
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
        float f = iMin / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        if (!bitmapCreateBitmap.equals(bitmap)) {
            bitmapCreateBitmap.recycle();
        }
        return bitmapCreateBitmap2;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - iMin) / 2, (bitmap.getHeight() - iMin) / 2, iMin, iMin);
        bitmapCreateBitmap.getClass();
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap2.getClass();
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
        float f = iMin;
        canvas.drawRoundRect(new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, f), 48.0f, 48.0f, paint);
        if (!bitmapCreateBitmap.equals(bitmap)) {
            bitmapCreateBitmap.recycle();
        }
        return bitmapCreateBitmap2;
    }

    public final PendingIntent getOpenAppIntent() {
        Context context = this.context;
        PendingIntent activity = PendingIntent.getActivity(context, 0, new Intent(context, (Class<?>) MainActivity.class), 201326592);
        activity.getClass();
        return activity;
    }

    public final PendingIntent getPlayPauseIntent() {
        Context context = this.context;
        Intent intent = new Intent(context, (Class<?>) MusicWidgetReceiver.class);
        intent.setAction("com.metrolist.music.widget.PLAY_PAUSE");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, intent, 201326592);
        broadcast.getClass();
        return broadcast;
    }

    public final Bitmap getRoundedDefaultIcon() throws PackageManager.NameNotFoundException {
        Context context = this.context;
        Drawable applicationIcon = context.getPackageManager().getApplicationIcon(context.getPackageName());
        applicationIcon.getClass();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.getClass();
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        applicationIcon.setBounds(0, 0, 300, 300);
        applicationIcon.draw(canvas);
        return getRoundedCornerBitmap(bitmapCreateBitmap);
    }

    /* JADX WARN: Code duplicated, block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x00df  */
    /* JADX WARN: Code duplicated, block: B:37:0x010c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0112  */
    /* JADX WARN: Code duplicated, block: B:51:0x017e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0188  */
    /* JADX WARN: Code duplicated, block: B:69:0x021e  */
    /* JADX WARN: Code duplicated, block: B:70:0x0226  */
    /* JADX WARN: Code duplicated, block: B:72:0x022f  */
    /* JADX WARN: Code duplicated, block: B:73:0x0233  */
    /* JADX WARN: Code duplicated, block: B:76:0x023e  */
    /* JADX WARN: Code duplicated, block: B:77:0x0241  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:80:0x0253  */
    /* JADX WARN: Code duplicated, block: B:81:0x0269  */
    /* JADX WARN: Code duplicated, block: B:87:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:89:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:90:0x02da  */
    /* JADX WARN: Code duplicated, block: B:92:0x030c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0310  */
    /* JADX WARN: Code duplicated, block: B:96:0x036e A[LOOP:0: B:95:0x036c->B:96:0x036e, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object updateWidgets(String str, String str2, String str3, boolean z, boolean z2, long j, long j2, ContinuationImpl continuationImpl) throws PackageManager.NameNotFoundException {
        AnonymousClass1 anonymousClass1;
        boolean z3;
        boolean z4;
        long j3;
        String str4;
        long j4;
        String str5;
        Bitmap bitmap;
        AppWidgetManager appWidgetManager;
        String str6;
        Object obj;
        Bitmap circularBitmap;
        Bitmap bitmap2;
        String str7;
        int[] appWidgetIds;
        int length;
        int i;
        int i2;
        boolean z5;
        boolean z6;
        RemoteViews remoteViews;
        int i3;
        int i4;
        String str8;
        Context context;
        boolean z7;
        boolean z8;
        int[] appWidgetIds2;
        RemoteViews remoteViews2;
        int i5;
        int i6;
        int i7;
        int length2;
        int i8;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i9 = anonymousClass1.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i9 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj2 = anonymousClass1.result;
        int i10 = anonymousClass1.label;
        Context context2 = this.context;
        Object[] objArr = 0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i10 != 0) {
            if (i10 == 1) {
                long j5 = anonymousClass1.J$1;
                j3 = anonymousClass1.J$0;
                boolean z9 = anonymousClass1.Z$1;
                boolean z10 = anonymousClass1.Z$0;
                appWidgetManager = anonymousClass1.L$3;
                str4 = anonymousClass1.L$2;
                str5 = anonymousClass1.L$1;
                str6 = anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj2);
                z4 = z9;
                z3 = z10;
                obj = obj2;
                j4 = j5;
            } else {
                if (i10 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj2);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj2);
        AppWidgetManager appWidgetManager2 = AppWidgetManager.getInstance(context2);
        if (str3 == null || !str3.equals(this.cachedArtworkUri) || (bitmap = this.cachedAlbumArt) == null) {
            if (str3 != null) {
                anonymousClass1.L$0 = str;
                anonymousClass1.L$1 = str2;
                anonymousClass1.L$2 = str3;
                anonymousClass1.L$3 = appWidgetManager2;
                z3 = z;
                anonymousClass1.Z$0 = z3;
                z4 = z2;
                anonymousClass1.Z$1 = z4;
                j3 = j;
                anonymousClass1.J$0 = j3;
                anonymousClass1.J$1 = j2;
                anonymousClass1.label = 1;
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                Object objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new ShimmerModifierKt$shimmer$1$1((Object) this, (Object) str3, (Continuation) (objArr == true ? 1 : 0), (byte) 2), anonymousClass1);
                if (objWithContext == coroutineSingletons) {
                    return coroutineSingletons;
                }
                obj = objWithContext;
                appWidgetManager = appWidgetManager2;
                str6 = str;
                str4 = str3;
                str5 = str2;
                j4 = j2;
            } else {
                z3 = z;
                z4 = z2;
                j3 = j;
                str4 = str3;
                j4 = j2;
                str5 = str2;
                bitmap = null;
                appWidgetManager = appWidgetManager2;
                str6 = str;
            }
            circularBitmap = bitmap != null ? getCircularBitmap(bitmap) : null;
            this.cachedArtworkUri = str4;
            this.cachedAlbumArt = bitmap;
            this.cachedCircularAlbumArt = circularBitmap;
        } else {
            str5 = str2;
            z3 = z;
            z4 = z2;
            j3 = j;
            str4 = str3;
            appWidgetManager = appWidgetManager2;
            circularBitmap = this.cachedCircularAlbumArt;
            str6 = str;
            j4 = j2;
        }
        bitmap2 = bitmap;
        str7 = str4;
        appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context2, (Class<?>) MusicWidgetReceiver.class));
        appWidgetIds.getClass();
        if (appWidgetIds.length != 0) {
            length = appWidgetIds.length;
            i = 0;
            while (i < length) {
                int i11 = i;
                int i12 = appWidgetIds[i11];
                int i13 = length;
                Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(i12);
                appWidgetOptions.getClass();
                i2 = appWidgetOptions.getInt("appWidgetMinWidth");
                z5 = z4;
                int i14 = appWidgetOptions.getInt("appWidgetMinHeight");
                z6 = z3;
                if (i2 < 180 || i14 >= 100) {
                    if (i2 >= 180 || i14 >= 100) {
                        remoteViews = new RemoteViews(context2.getPackageName(), R.layout.widget_music_player);
                        remoteViews.setTextViewText(R.id.widget_song_title, str6);
                        remoteViews.setTextViewText(R.id.widget_artist_name, str5);
                        if (bitmap2 != null) {
                            remoteViews.setImageViewBitmap(R.id.widget_album_art, getRoundedCornerBitmap(bitmap2));
                        } else {
                            remoteViews.setImageViewBitmap(R.id.widget_album_art, getRoundedDefaultIcon());
                        }
                        if (z6) {
                            i3 = R.drawable.ic_widget_pause;
                        } else {
                            i3 = R.drawable.ic_widget_play;
                        }
                        remoteViews.setImageViewResource(R.id.widget_play_pause, i3);
                        if (z5) {
                            i4 = R.drawable.ic_widget_heart_nav;
                        } else {
                            i4 = R.drawable.ic_widget_heart_outline_nav;
                        }
                        remoteViews.setImageViewResource(R.id.widget_like_button, i4);
                        if (j3 > 0) {
                            remoteViews.setInt(R.id.widget_progress_fill, "setImageLevel", (int) ((j4 / j3) * 10000.0d));
                        } else {
                            remoteViews.setInt(R.id.widget_progress_fill, "setImageLevel", 0);
                        }
                        remoteViews.setOnClickPendingIntent(R.id.widget_album_art, getOpenAppIntent());
                        remoteViews.setOnClickPendingIntent(R.id.widget_play_pause_container, getPlayPauseIntent());
                        Intent intent = new Intent(context2, (Class<?>) MusicWidgetReceiver.class);
                        intent.setAction("com.metrolist.music.widget.LIKE");
                        PendingIntent broadcast = PendingIntent.getBroadcast(context2, 2, intent, 201326592);
                        broadcast.getClass();
                        remoteViews.setOnClickPendingIntent(R.id.widget_like_button, broadcast);
                    } else {
                        remoteViews = new RemoteViews(context2.getPackageName(), R.layout.widget_compact_wide);
                        remoteViews.setTextViewText(R.id.widget_wide_song_title, str6);
                        remoteViews.setTextViewText(R.id.widget_wide_artist_name, str5);
                        if (bitmap2 != null) {
                            remoteViews.setImageViewBitmap(R.id.widget_wide_album_art, getRoundedCornerBitmap(bitmap2));
                        } else {
                            remoteViews.setImageViewBitmap(R.id.widget_wide_album_art, getRoundedDefaultIcon());
                        }
                        remoteViews.setImageViewResource(R.id.widget_wide_play_pause, z6 ? R.drawable.ic_widget_pause_low : R.drawable.ic_widget_play_low);
                        remoteViews.setImageViewResource(R.id.widget_wide_like_button, z5 ? R.drawable.ic_widget_heart_nav : R.drawable.ic_widget_heart_outline_nav);
                        remoteViews.setOnClickPendingIntent(R.id.widget_wide_album_art, getOpenAppIntent());
                        remoteViews.setOnClickPendingIntent(R.id.widget_wide_play_container, getPlayPauseIntent());
                        Intent intent2 = new Intent(context2, (Class<?>) MusicWidgetReceiver.class);
                        intent2.setAction("com.metrolist.music.widget.LIKE");
                        PendingIntent broadcast2 = PendingIntent.getBroadcast(context2, 2, intent2, 201326592);
                        broadcast2.getClass();
                        remoteViews.setOnClickPendingIntent(R.id.widget_wide_like_button, broadcast2);
                    }
                    appWidgetManager.updateAppWidget(i12, remoteViews);
                    i = i11 + 1;
                    z4 = z5;
                    context2 = context2;
                    z3 = z6;
                    str6 = str6;
                    length = i13;
                } else {
                    remoteViews = new RemoteViews(context2.getPackageName(), R.layout.widget_compact_square);
                    if (bitmap2 != null) {
                        remoteViews.setImageViewBitmap(R.id.widget_compact_album_art, getRoundedCornerBitmap(bitmap2));
                    } else {
                        remoteViews.setImageViewBitmap(R.id.widget_compact_album_art, getRoundedDefaultIcon());
                    }
                    remoteViews.setImageViewResource(R.id.widget_compact_play_pause, z6 ? R.drawable.ic_widget_pause_low : R.drawable.ic_widget_play_low);
                    remoteViews.setOnClickPendingIntent(R.id.widget_compact_album_art, getOpenAppIntent());
                    remoteViews.setOnClickPendingIntent(R.id.widget_compact_play_container, getPlayPauseIntent());
                }
                context2 = context2;
                appWidgetManager.updateAppWidget(i12, remoteViews);
                i = i11 + 1;
                z4 = z5;
                context2 = context2;
                z3 = z6;
                str6 = str6;
                length = i13;
            }
        }
        str8 = str6;
        context = context2;
        z7 = z3;
        z8 = z4;
        appWidgetIds2 = appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) TurntableWidgetReceiver.class));
        appWidgetIds2.getClass();
        if (appWidgetIds2.length != 0) {
            remoteViews2 = new RemoteViews(context.getPackageName(), R.layout.widget_turntable);
            if (circularBitmap != null) {
                remoteViews2.setImageViewBitmap(R.id.widget_turntable_album_art, circularBitmap);
                i6 = R.id.widget_turntable_album_art;
                i5 = 0;
            } else {
                Drawable applicationIcon = context.getPackageManager().getApplicationIcon(context.getPackageName());
                applicationIcon.getClass();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.getClass();
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                i5 = 0;
                applicationIcon.setBounds(0, 0, 300, 300);
                applicationIcon.draw(canvas);
                Bitmap circularBitmap2 = getCircularBitmap(bitmapCreateBitmap);
                i6 = R.id.widget_turntable_album_art;
                remoteViews2.setImageViewBitmap(R.id.widget_turntable_album_art, circularBitmap2);
            }
            if (z7) {
                i7 = R.drawable.ic_widget_pause_secondary;
            } else {
                i7 = R.drawable.ic_widget_play_secondary;
            }
            remoteViews2.setImageViewResource(R.id.widget_turntable_play_pause, i7);
            remoteViews2.setOnClickPendingIntent(i6, getOpenAppIntent());
            Intent intent3 = new Intent(context, (Class<?>) TurntableWidgetReceiver.class);
            intent3.setAction("com.metrolist.music.widget.TURNTABLE_PLAY_PAUSE");
            PendingIntent broadcast3 = PendingIntent.getBroadcast(context, 3, intent3, 201326592);
            broadcast3.getClass();
            remoteViews2.setOnClickPendingIntent(R.id.widget_turntable_play_container, broadcast3);
            Intent intent4 = new Intent(context, (Class<?>) TurntableWidgetReceiver.class);
            intent4.setAction("com.metrolist.music.widget.TURNTABLE_PREVIOUS");
            PendingIntent broadcast4 = PendingIntent.getBroadcast(context, 5, intent4, 201326592);
            broadcast4.getClass();
            remoteViews2.setOnClickPendingIntent(R.id.widget_turntable_prev_button, broadcast4);
            Intent intent5 = new Intent(context, (Class<?>) TurntableWidgetReceiver.class);
            intent5.setAction("com.metrolist.music.widget.TURNTABLE_NEXT");
            PendingIntent broadcast5 = PendingIntent.getBroadcast(context, 4, intent5, 201326592);
            broadcast5.getClass();
            remoteViews2.setOnClickPendingIntent(R.id.widget_turntable_next_button, broadcast5);
            length2 = appWidgetIds2.length;
            for (i8 = i5; i8 < length2; i8++) {
                appWidgetManager.updateAppWidget(appWidgetIds2[i8], remoteViews2);
            }
        }
        anonymousClass1.L$0 = null;
        anonymousClass1.L$1 = null;
        anonymousClass1.L$2 = null;
        anonymousClass1.L$3 = null;
        anonymousClass1.Z$0 = z7;
        anonymousClass1.Z$1 = z8;
        anonymousClass1.J$0 = j3;
        anonymousClass1.J$1 = j4;
        anonymousClass1.label = 2;
        if (this.playlistWidgetManager.updateWidgets(str8, str5, str7, z7, z8, j3, j4, anonymousClass1) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
        bitmap = (Bitmap) obj;
        if (bitmap != null) {
        }
        this.cachedArtworkUri = str4;
        this.cachedAlbumArt = bitmap;
        this.cachedCircularAlbumArt = circularBitmap;
        bitmap2 = bitmap;
        str7 = str4;
        appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context2, (Class<?>) MusicWidgetReceiver.class));
        appWidgetIds.getClass();
        if (appWidgetIds.length != 0) {
            length = appWidgetIds.length;
            i = 0;
            while (i < length) {
                int i15 = i;
                int i16 = appWidgetIds[i15];
                int i17 = length;
                Bundle appWidgetOptions2 = appWidgetManager.getAppWidgetOptions(i16);
                appWidgetOptions2.getClass();
                i2 = appWidgetOptions2.getInt("appWidgetMinWidth");
                z5 = z4;
                int i18 = appWidgetOptions2.getInt("appWidgetMinHeight");
                z6 = z3;
                if (i2 < 180) {
                    if (i2 >= 180) {
                    }
                    remoteViews = new RemoteViews(context2.getPackageName(), R.layout.widget_music_player);
                    remoteViews.setTextViewText(R.id.widget_song_title, str6);
                    remoteViews.setTextViewText(R.id.widget_artist_name, str5);
                    if (bitmap2 != null) {
                        remoteViews.setImageViewBitmap(R.id.widget_album_art, getRoundedCornerBitmap(bitmap2));
                    } else {
                        remoteViews.setImageViewBitmap(R.id.widget_album_art, getRoundedDefaultIcon());
                    }
                    if (z6) {
                        i3 = R.drawable.ic_widget_pause;
                    } else {
                        i3 = R.drawable.ic_widget_play;
                    }
                    remoteViews.setImageViewResource(R.id.widget_play_pause, i3);
                    if (z5) {
                        i4 = R.drawable.ic_widget_heart_nav;
                    } else {
                        i4 = R.drawable.ic_widget_heart_outline_nav;
                    }
                    remoteViews.setImageViewResource(R.id.widget_like_button, i4);
                    if (j3 > 0) {
                        remoteViews.setInt(R.id.widget_progress_fill, "setImageLevel", (int) ((j4 / j3) * 10000.0d));
                    } else {
                        remoteViews.setInt(R.id.widget_progress_fill, "setImageLevel", 0);
                    }
                    remoteViews.setOnClickPendingIntent(R.id.widget_album_art, getOpenAppIntent());
                    remoteViews.setOnClickPendingIntent(R.id.widget_play_pause_container, getPlayPauseIntent());
                    Intent intent6 = new Intent(context2, (Class<?>) MusicWidgetReceiver.class);
                    intent6.setAction("com.metrolist.music.widget.LIKE");
                    PendingIntent broadcast6 = PendingIntent.getBroadcast(context2, 2, intent6, 201326592);
                    broadcast6.getClass();
                    remoteViews.setOnClickPendingIntent(R.id.widget_like_button, broadcast6);
                } else {
                    if (i2 >= 180) {
                    }
                    remoteViews = new RemoteViews(context2.getPackageName(), R.layout.widget_music_player);
                    remoteViews.setTextViewText(R.id.widget_song_title, str6);
                    remoteViews.setTextViewText(R.id.widget_artist_name, str5);
                    if (bitmap2 != null) {
                        remoteViews.setImageViewBitmap(R.id.widget_album_art, getRoundedCornerBitmap(bitmap2));
                    } else {
                        remoteViews.setImageViewBitmap(R.id.widget_album_art, getRoundedDefaultIcon());
                    }
                    if (z6) {
                        i3 = R.drawable.ic_widget_pause;
                    } else {
                        i3 = R.drawable.ic_widget_play;
                    }
                    remoteViews.setImageViewResource(R.id.widget_play_pause, i3);
                    if (z5) {
                        i4 = R.drawable.ic_widget_heart_nav;
                    } else {
                        i4 = R.drawable.ic_widget_heart_outline_nav;
                    }
                    remoteViews.setImageViewResource(R.id.widget_like_button, i4);
                    if (j3 > 0) {
                        remoteViews.setInt(R.id.widget_progress_fill, "setImageLevel", (int) ((j4 / j3) * 10000.0d));
                    } else {
                        remoteViews.setInt(R.id.widget_progress_fill, "setImageLevel", 0);
                    }
                    remoteViews.setOnClickPendingIntent(R.id.widget_album_art, getOpenAppIntent());
                    remoteViews.setOnClickPendingIntent(R.id.widget_play_pause_container, getPlayPauseIntent());
                    Intent intent7 = new Intent(context2, (Class<?>) MusicWidgetReceiver.class);
                    intent7.setAction("com.metrolist.music.widget.LIKE");
                    PendingIntent broadcast7 = PendingIntent.getBroadcast(context2, 2, intent7, 201326592);
                    broadcast7.getClass();
                    remoteViews.setOnClickPendingIntent(R.id.widget_like_button, broadcast7);
                }
                appWidgetManager.updateAppWidget(i16, remoteViews);
                i = i15 + 1;
                z4 = z5;
                context2 = context2;
                z3 = z6;
                str6 = str6;
                length = i17;
            }
        }
        str8 = str6;
        context = context2;
        z7 = z3;
        z8 = z4;
        appWidgetIds2 = appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) TurntableWidgetReceiver.class));
        appWidgetIds2.getClass();
        if (appWidgetIds2.length != 0) {
            remoteViews2 = new RemoteViews(context.getPackageName(), R.layout.widget_turntable);
            if (circularBitmap != null) {
                remoteViews2.setImageViewBitmap(R.id.widget_turntable_album_art, circularBitmap);
                i6 = R.id.widget_turntable_album_art;
                i5 = 0;
            } else {
                Drawable applicationIcon2 = context.getPackageManager().getApplicationIcon(context.getPackageName());
                applicationIcon2.getClass();
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap2.getClass();
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                i5 = 0;
                applicationIcon2.setBounds(0, 0, 300, 300);
                applicationIcon2.draw(canvas2);
                Bitmap circularBitmap3 = getCircularBitmap(bitmapCreateBitmap2);
                i6 = R.id.widget_turntable_album_art;
                remoteViews2.setImageViewBitmap(R.id.widget_turntable_album_art, circularBitmap3);
            }
            if (z7) {
                i7 = R.drawable.ic_widget_pause_secondary;
            } else {
                i7 = R.drawable.ic_widget_play_secondary;
            }
            remoteViews2.setImageViewResource(R.id.widget_turntable_play_pause, i7);
            remoteViews2.setOnClickPendingIntent(i6, getOpenAppIntent());
            Intent intent8 = new Intent(context, (Class<?>) TurntableWidgetReceiver.class);
            intent8.setAction("com.metrolist.music.widget.TURNTABLE_PLAY_PAUSE");
            PendingIntent broadcast8 = PendingIntent.getBroadcast(context, 3, intent8, 201326592);
            broadcast8.getClass();
            remoteViews2.setOnClickPendingIntent(R.id.widget_turntable_play_container, broadcast8);
            Intent intent9 = new Intent(context, (Class<?>) TurntableWidgetReceiver.class);
            intent9.setAction("com.metrolist.music.widget.TURNTABLE_PREVIOUS");
            PendingIntent broadcast9 = PendingIntent.getBroadcast(context, 5, intent9, 201326592);
            broadcast9.getClass();
            remoteViews2.setOnClickPendingIntent(R.id.widget_turntable_prev_button, broadcast9);
            Intent intent10 = new Intent(context, (Class<?>) TurntableWidgetReceiver.class);
            intent10.setAction("com.metrolist.music.widget.TURNTABLE_NEXT");
            PendingIntent broadcast10 = PendingIntent.getBroadcast(context, 4, intent10, 201326592);
            broadcast10.getClass();
            remoteViews2.setOnClickPendingIntent(R.id.widget_turntable_next_button, broadcast10);
            length2 = appWidgetIds2.length;
            while (i8 < length2) {
                appWidgetManager.updateAppWidget(appWidgetIds2[i8], remoteViews2);
            }
        }
        anonymousClass1.L$0 = null;
        anonymousClass1.L$1 = null;
        anonymousClass1.L$2 = null;
        anonymousClass1.L$3 = null;
        anonymousClass1.Z$0 = z7;
        anonymousClass1.Z$1 = z8;
        anonymousClass1.J$0 = j3;
        anonymousClass1.J$1 = j4;
        anonymousClass1.label = 2;
        if (this.playlistWidgetManager.updateWidgets(str8, str5, str7, z7, z8, j3, j4, anonymousClass1) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }
}
