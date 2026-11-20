package com.metrolist.music.playback.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicAlarmRescheduleReceiver extends BroadcastReceiver {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        context.getClass();
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            switch (action.hashCode()) {
                case -905063602:
                    if (!action.equals("android.intent.action.LOCKED_BOOT_COMPLETED")) {
                        return;
                    }
                    break;
                case 502473491:
                    if (!action.equals("android.intent.action.TIMEZONE_CHANGED")) {
                        return;
                    }
                    break;
                case 505380757:
                    if (!action.equals("android.intent.action.TIME_SET")) {
                        return;
                    }
                    break;
                case 798292259:
                    if (!action.equals("android.intent.action.BOOT_COMPLETED")) {
                        return;
                    }
                    break;
                case 1737074039:
                    if (!action.equals("android.intent.action.MY_PACKAGE_REPLACED")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            AwaitKt.launch$default(AwaitKt.CoroutineScope(DefaultIoScheduler.INSTANCE), null, null, new MusicAlarmReceiver.AnonymousClass1(context, pendingResultGoAsync, null, (byte) 1), 3);
        }
    }
}
