package com.metrolist.music.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.app.NavUtils;
import com.metrolist.music.MainActivity;
import com.metrolist.music.recognition.MusicRecognitionService;
import com.metrolist.music.recognition.RecognitionForegroundService;
import com.yalantis.ucrop.R;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicRecognizerWidgetReceiver extends AppWidgetProvider {
    public static void applyMicState(RemoteViews remoteViews, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = i == 1 || i == 2;
        remoteViews.setInt(i3, "setBackgroundResource", z ? R.drawable.widget_mic_button_bg_active : R.drawable.widget_mic_button_bg);
        if (z) {
            int i6 = i2 % 4;
            if (i6 == 0) {
                i5 = R.drawable.widget_mic_pulse_1;
            } else if (i6 != 1) {
                i5 = i6 != 2 ? R.drawable.widget_mic_pulse_4 : R.drawable.widget_mic_pulse_3;
            } else {
                i5 = R.drawable.widget_mic_pulse_2;
            }
        } else {
            i5 = R.drawable.widget_mic_pulse_idle;
        }
        remoteViews.setImageViewResource(i4, i5);
    }

    public static void applyTextState(Context context, RemoteViews remoteViews, int i, String str, String str2, String str3) {
        if (i == 0) {
            remoteViews.setTextViewText(R.id.widget_recognizer_song_title, context.getString(R.string.widget_recognizer_tap_to_search));
            remoteViews.setViewVisibility(R.id.widget_recognizer_artist_name, 8);
            return;
        }
        if (i == 1) {
            remoteViews.setTextViewText(R.id.widget_recognizer_song_title, context.getString(R.string.widget_recognizer_listening));
            remoteViews.setViewVisibility(R.id.widget_recognizer_artist_name, 8);
            return;
        }
        if (i == 2) {
            remoteViews.setTextViewText(R.id.widget_recognizer_song_title, context.getString(R.string.widget_recognizer_processing));
            remoteViews.setViewVisibility(R.id.widget_recognizer_artist_name, 8);
            return;
        }
        if (i == 3) {
            if (str.length() == 0) {
                str = context.getString(R.string.widget_recognizer_unknown_song);
                str.getClass();
            }
            remoteViews.setTextViewText(R.id.widget_recognizer_song_title, str);
            if (str2.length() == 0) {
                str2 = context.getString(R.string.widget_recognizer_unknown_artist);
                str2.getClass();
            }
            remoteViews.setTextViewText(R.id.widget_recognizer_artist_name, str2);
            remoteViews.setViewVisibility(R.id.widget_recognizer_artist_name, 0);
            return;
        }
        if (i == 4) {
            remoteViews.setTextViewText(R.id.widget_recognizer_song_title, context.getString(R.string.widget_recognizer_no_match));
            remoteViews.setViewVisibility(R.id.widget_recognizer_artist_name, 8);
        } else {
            if (i != 5) {
                return;
            }
            remoteViews.setTextViewText(R.id.widget_recognizer_song_title, context.getString(R.string.widget_recognizer_error));
            if (str3.length() == 0) {
                str3 = context.getString(R.string.widget_recognizer_error_generic);
                str3.getClass();
            }
            remoteViews.setTextViewText(R.id.widget_recognizer_artist_name, str3);
            remoteViews.setViewVisibility(R.id.widget_recognizer_artist_name, 0);
        }
    }

    public static PendingIntent getMicIntent(Context context) {
        Intent intent = new Intent(context, (Class<?>) MusicRecognizerWidgetReceiver.class);
        intent.setAction("com.metrolist.music.widget.recognizer.TAP_MIC");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 20, intent, 201326592);
        broadcast.getClass();
        return broadcast;
    }

    public static void updateAllWidgets(Context context, AppWidgetManager appWidgetManager) {
        int[] iArr;
        String str;
        String str2;
        RemoteViews remoteViews;
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) MusicRecognizerWidgetReceiver.class));
        SharedPreferences sharedPreferences = context.getSharedPreferences("recognizer_widget_prefs", 0);
        int i = sharedPreferences.getInt("state", 0);
        String string = sharedPreferences.getString("song_title", "");
        if (string == null) {
            string = "";
        }
        String string2 = sharedPreferences.getString("artist_name", "");
        if (string2 == null) {
            string2 = "";
        }
        String string3 = sharedPreferences.getString("error_message", "");
        if (string3 == null) {
            string3 = "";
        }
        String string4 = sharedPreferences.getString("cover_art_path", "");
        String str3 = string4 != null ? string4 : "";
        int i2 = sharedPreferences.getInt("pulse_frame", 0);
        Bitmap bitmapDecodeFile = null;
        if (i == 3 && str3.length() > 0) {
            try {
                bitmapDecodeFile = BitmapFactory.decodeFile(str3);
            } catch (Exception unused) {
            }
        }
        Bitmap bitmap = bitmapDecodeFile;
        appWidgetIds.getClass();
        int length = appWidgetIds.length;
        int i3 = 0;
        while (i3 < length) {
            int i4 = appWidgetIds[i3];
            int i5 = appWidgetManager.getAppWidgetOptions(i4).getInt("appWidgetMinWidth");
            if (i5 < 110) {
                remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_recognizer_tiny);
                applyMicState(remoteViews, i, i2, R.id.widget_recognizer_tiny_mic_container, R.id.widget_recognizer_tiny_pulse);
                remoteViews.setOnClickPendingIntent(R.id.widget_recognizer_tiny_root, getMicIntent(context));
                str = string2;
                iArr = appWidgetIds;
                str2 = string3;
            } else {
                iArr = appWidgetIds;
                if (i5 < 230) {
                    remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_recognizer_compact);
                    if (i != 3 || bitmap == null) {
                        remoteViews.setViewVisibility(R.id.widget_recognizer_album_art, 8);
                    } else {
                        remoteViews.setImageViewBitmap(R.id.widget_recognizer_album_art, bitmap);
                        remoteViews.setViewVisibility(R.id.widget_recognizer_album_art, 0);
                    }
                    str = string2;
                    str2 = string3;
                    applyTextState(context, remoteViews, i, string, str, str2);
                    applyMicState(remoteViews, i, i2, R.id.widget_recognizer_mic_container, R.id.widget_recognizer_pulse);
                    remoteViews.setOnClickPendingIntent(R.id.widget_recognizer_mic_container, getMicIntent(context));
                    Intent intent = new Intent(context, (Class<?>) MainActivity.class);
                    intent.setAction("com.metrolist.music.action.RECOGNITION");
                    intent.setFlags(805306368);
                    PendingIntent activity = PendingIntent.getActivity(context, 21, intent, 201326592);
                    activity.getClass();
                    remoteViews.setOnClickPendingIntent(R.id.widget_recognizer_text_area, activity);
                    remoteViews.setOnClickPendingIntent(R.id.widget_recognizer_album_art, activity);
                } else {
                    str = string2;
                    str2 = string3;
                    remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_recognizer_wide);
                    if (i != 3 || bitmap == null) {
                        remoteViews.setViewVisibility(R.id.widget_recognizer_album_art, 8);
                    } else {
                        remoteViews.setImageViewBitmap(R.id.widget_recognizer_album_art, bitmap);
                        remoteViews.setViewVisibility(R.id.widget_recognizer_album_art, 0);
                    }
                    applyTextState(context, remoteViews, i, string, str, str2);
                    applyMicState(remoteViews, i, i2, R.id.widget_recognizer_mic_container, R.id.widget_recognizer_pulse);
                    remoteViews.setOnClickPendingIntent(R.id.widget_recognizer_mic_container, getMicIntent(context));
                    Intent intent2 = new Intent(context, (Class<?>) MainActivity.class);
                    intent2.setAction("com.metrolist.music.action.RECOGNITION");
                    intent2.setFlags(805306368);
                    PendingIntent activity2 = PendingIntent.getActivity(context, 21, intent2, 201326592);
                    activity2.getClass();
                    remoteViews.setOnClickPendingIntent(R.id.widget_recognizer_text_area, activity2);
                    remoteViews.setOnClickPendingIntent(R.id.widget_recognizer_album_art, activity2);
                }
            }
            appWidgetManager.updateAppWidget(i4, remoteViews);
            i3++;
            string3 = str2;
            appWidgetIds = iArr;
            string2 = str;
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int i, Bundle bundle) {
        context.getClass();
        appWidgetManager.getClass();
        bundle.getClass();
        super.onAppWidgetOptionsChanged(context, appWidgetManager, i, bundle);
        updateAllWidgets(context, appWidgetManager);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        context.getClass();
        intent.getClass();
        super.onReceive(context, intent);
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode == -322957258) {
                if (action.equals("com.metrolist.music.widget.recognizer.UPDATE")) {
                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                    appWidgetManager.getClass();
                    updateAllWidgets(context, appWidgetManager);
                    return;
                }
                return;
            }
            if (iHashCode == 1371971618) {
                if (action.equals("com.metrolist.music.widget.recognizer.RESET")) {
                    context.getSharedPreferences("recognizer_widget_prefs", 0).edit().putInt("state", 0).putString("song_title", "").putString("artist_name", "").putString("error_message", "").putString("cover_art_path", "").putInt("pulse_frame", 0).apply();
                    new File(context.getCacheDir(), "recognizer_widget_art.png").delete();
                    AppWidgetManager appWidgetManager2 = AppWidgetManager.getInstance(context);
                    appWidgetManager2.getClass();
                    updateAllWidgets(context, appWidgetManager2);
                    return;
                }
                return;
            }
            if (iHashCode == 1568255390 && action.equals("com.metrolist.music.widget.recognizer.TAP_MIC")) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("recognizer_widget_prefs", 0);
                int i = sharedPreferences.getInt("state", 0);
                if (i == 1 || i == 2) {
                    Intent intent2 = new Intent(context, (Class<?>) RecognitionForegroundService.class);
                    intent2.setAction("com.metrolist.music.widget.recognizer.STOP");
                    context.startService(intent2);
                    return;
                }
                if (i == 3 || i == 4 || i == 5) {
                    sharedPreferences.edit().putInt("state", 0).apply();
                }
                MusicRecognitionService musicRecognitionService = MusicRecognitionService.INSTANCE;
                if (NavUtils.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0) {
                    Intent intent3 = new Intent(context, (Class<?>) RecognitionForegroundService.class);
                    intent3.setAction("com.metrolist.music.widget.recognizer.START");
                    context.startForegroundService(intent3);
                } else {
                    Intent intent4 = new Intent(context, (Class<?>) MainActivity.class);
                    intent4.setAction("com.metrolist.music.action.RECOGNITION");
                    intent4.setFlags(805306368);
                    context.startActivity(intent4);
                }
            }
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        context.getClass();
        appWidgetManager.getClass();
        iArr.getClass();
        updateAllWidgets(context, appWidgetManager);
    }
}
