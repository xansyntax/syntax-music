package com.metrolist.music.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.metrolist.music.DaggerApp_HiltComponents_SingletonC$SingletonCImpl;
import com.metrolist.music.MainActivity;
import com.metrolist.music.playback.MusicService;
import com.valentinilk.shimmer.ShimmerModifierKt$shimmer$1$1;
import dagger.hilt.internal.GeneratedComponentManager;
import kotlin.coroutines.Continuation;
import kotlin.text.CharsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.internal.CombineKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistWidgetReceiver extends AppWidgetProvider {
    public volatile boolean injected = false;
    public final Object injectedLock = new Object();
    public PlaylistWidgetManager playlistWidgetManager;

    @Override // android.appwidget.AppWidgetProvider
    public final void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int i, Bundle bundle) {
        context.getClass();
        appWidgetManager.getClass();
        bundle.getClass();
        super.onAppWidgetOptionsChanged(context, appWidgetManager, i, bundle);
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        AwaitKt.launch$default(AwaitKt.CoroutineScope(MainDispatcherLoader.dispatcher), null, null, new CombineKt.AnonymousClass2.AnonymousClass1(this, i, bundle, pendingResultGoAsync, null, (byte) 1), 3);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        context.getClass();
        intent.getClass();
        onReceive$com$metrolist$music$widget$Hilt_PlaylistWidgetReceiver(context, intent);
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode == 637149648) {
                if (action.equals("com.metrolist.music.widget.playlists.UPDATE_WIDGET")) {
                    BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    AwaitKt.launch$default(AwaitKt.CoroutineScope(MainDispatcherLoader.dispatcher), null, null, new ShimmerModifierKt$shimmer$1$1((Object) this, (Object) pendingResultGoAsync, (Continuation) null, (byte) 3), 3);
                    return;
                }
                return;
            }
            if (iHashCode == 1522909650 && action.equals("com.metrolist.music.widget.playlists.PLAY_TARGET")) {
                Intent intent2 = new Intent(context, (Class<?>) MusicService.class);
                intent2.setAction("com.metrolist.music.widget.playlists.PLAY_TARGET");
                intent2.putExtra("playlist_widget_target_type", intent.getStringExtra("playlist_widget_target_type"));
                intent2.putExtra("playlist_widget_target_id", intent.getStringExtra("playlist_widget_target_id"));
                intent2.putExtra("playlist_widget_target_title", intent.getStringExtra("playlist_widget_target_title"));
                try {
                    context.startService(intent2);
                } catch (Exception unused) {
                    Timber.Forest.tag("PlaylistWidgetReceiver");
                    ConnectionPool.w$1(new Object[0]);
                    Intent intent3 = new Intent(context, (Class<?>) MainActivity.class);
                    intent3.setAction("com.metrolist.music.action.OPEN_WIDGET_TARGET");
                    intent3.setFlags(805306368);
                    intent3.putExtra("widget_target_type", intent.getStringExtra("playlist_widget_target_type"));
                    intent3.putExtra("widget_target_id", intent.getStringExtra("playlist_widget_target_id"));
                    context.startActivity(intent3);
                }
            }
        }
    }

    public final void onReceive$com$metrolist$music$widget$Hilt_PlaylistWidgetReceiver(Context context, Intent intent) {
        if (!this.injected) {
            synchronized (this.injectedLock) {
                try {
                    if (!this.injected) {
                        ComponentCallbacks2 application = CharsKt.getApplication(context.getApplicationContext());
                        boolean z = application instanceof GeneratedComponentManager;
                        Class<?> cls = application.getClass();
                        if (!z) {
                            throw new IllegalArgumentException("Hilt BroadcastReceiver must be attached to an @HiltAndroidApp Application. Found: " + cls);
                        }
                        this.playlistWidgetManager = (PlaylistWidgetManager) ((DaggerApp_HiltComponents_SingletonC$SingletonCImpl) ((PlaylistWidgetReceiver_GeneratedInjector) ((GeneratedComponentManager) application).generatedComponent())).playlistWidgetManagerProvider.get();
                        this.injected = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        super.onReceive(context, intent);
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        context.getClass();
        appWidgetManager.getClass();
        iArr.getClass();
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        AwaitKt.launch$default(AwaitKt.CoroutineScope(MainDispatcherLoader.dispatcher), null, null, new PlaylistWidgetReceiver$refreshIdleWidgets$1(iArr, pendingResultGoAsync, this, appWidgetManager, null), 3);
    }
}
