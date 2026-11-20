package com.metrolist.music.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.metrolist.music.playback.MusicService;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicWidgetReceiver extends AppWidgetProvider {
    @Override // android.appwidget.AppWidgetProvider
    public final void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int i, Bundle bundle) {
        context.getClass();
        appWidgetManager.getClass();
        bundle.getClass();
        super.onAppWidgetOptionsChanged(context, appWidgetManager, i, bundle);
        boolean z = MusicService.isRunning;
        if (MusicService.isRunning) {
            Intent intent = new Intent(context, (Class<?>) MusicService.class);
            intent.setAction("com.metrolist.music.widget.UPDATE_WIDGET");
            try {
                context.startService(intent);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        context.getClass();
        intent.getClass();
        super.onReceive(context, intent);
        String action = intent.getAction();
        if (action != null) {
            switch (action.hashCode()) {
                case -1761542520:
                    if (!action.equals("com.metrolist.music.widget.PLAY_PAUSE")) {
                        return;
                    }
                    break;
                case -402585676:
                    if (!action.equals("com.metrolist.music.widget.PREVIOUS")) {
                        return;
                    }
                    break;
                case -60233004:
                    if (!action.equals("com.metrolist.music.widget.LIKE")) {
                        return;
                    }
                    break;
                case -60176848:
                    if (!action.equals("com.metrolist.music.widget.NEXT")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            Intent intent2 = new Intent(context, (Class<?>) MusicService.class);
            intent2.setAction(intent.getAction());
            intent2.putExtras(intent);
            try {
                context.startService(intent2);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        context.getClass();
        appWidgetManager.getClass();
        iArr.getClass();
        boolean z = MusicService.isRunning;
        if (MusicService.isRunning) {
            Intent intent = new Intent(context, (Class<?>) MusicService.class);
            intent.setAction("com.metrolist.music.widget.UPDATE_WIDGET");
            try {
                context.startService(intent);
            } catch (Exception unused) {
            }
        }
    }
}
