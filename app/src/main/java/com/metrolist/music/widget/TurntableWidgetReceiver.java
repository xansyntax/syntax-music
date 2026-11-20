package com.metrolist.music.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import com.metrolist.music.playback.MusicService;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TurntableWidgetReceiver extends AppWidgetProvider {
    /* JADX WARN: Code duplicated, block: B:36:0x0073  */
    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action;
        context.getClass();
        intent.getClass();
        super.onReceive(context, intent);
        String action2 = intent.getAction();
        if (action2 != null) {
            int iHashCode = action2.hashCode();
            if (iHashCode != -82081118) {
                if (iHashCode != 1300659702) {
                    if (iHashCode != 1730605086 || !action2.equals("com.metrolist.music.widget.TURNTABLE_NEXT")) {
                        return;
                    }
                } else if (!action2.equals("com.metrolist.music.widget.TURNTABLE_PLAY_PAUSE")) {
                    return;
                }
            } else if (!action2.equals("com.metrolist.music.widget.TURNTABLE_PREVIOUS")) {
                return;
            }
            Intent intent2 = new Intent(context, (Class<?>) MusicService.class);
            String action3 = intent.getAction();
            if (action3 == null) {
                action = intent.getAction();
            } else {
                int iHashCode2 = action3.hashCode();
                if (iHashCode2 != -82081118) {
                    if (iHashCode2 != 1300659702) {
                        if (iHashCode2 == 1730605086 && action3.equals("com.metrolist.music.widget.TURNTABLE_NEXT")) {
                            action = "com.metrolist.music.widget.NEXT";
                        } else {
                            action = intent.getAction();
                        }
                    } else if (action3.equals("com.metrolist.music.widget.TURNTABLE_PLAY_PAUSE")) {
                        action = "com.metrolist.music.widget.PLAY_PAUSE";
                    } else {
                        action = intent.getAction();
                    }
                } else if (action3.equals("com.metrolist.music.widget.TURNTABLE_PREVIOUS")) {
                    action = "com.metrolist.music.widget.PREVIOUS";
                } else {
                    action = intent.getAction();
                }
            }
            intent2.setAction(action);
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
            intent.setAction("com.metrolist.music.widget.UPDATE_TURNTABLE_WIDGET");
            try {
                context.startService(intent);
            } catch (Exception unused) {
            }
        }
    }
}
