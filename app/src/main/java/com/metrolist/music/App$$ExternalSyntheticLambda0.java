package com.metrolist.music;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.datastore.preferences.PreferenceDataStoreSingletonDelegate;
import coil3.memory.RealMemoryCache;
import coil3.memory.RealStrongMemoryCache;
import com.yalantis.ucrop.R;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.math.MathKt;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class App$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Context f$0;

    public /* synthetic */ App$$ExternalSyntheticLambda0(Context context, PreferenceDataStoreSingletonDelegate preferenceDataStoreSingletonDelegate) {
        this.$r8$classId = (byte) 1;
        this.f$0 = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int largeMemoryClass;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Context context = this.f$0;
        switch (b) {
            case 0:
                App.Companion companion = App.Companion;
                PriorityQueue priorityQueue = new PriorityQueue((byte) 10);
                try {
                    Object systemService = context.getSystemService((Class<Object>) ActivityManager.class);
                    systemService.getClass();
                    ActivityManager activityManager = (ActivityManager) systemService;
                    largeMemoryClass = (context.getApplicationInfo().flags & ByteChannelKt.CHANNEL_MAX_SIZE) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
                    break;
                } catch (Exception unused) {
                    largeMemoryClass = 256;
                }
                return new RealMemoryCache(new RealStrongMemoryCache((long) (0.25d * ((long) largeMemoryClass) * 1048576), priorityQueue), priorityQueue);
            case 1:
                return new File(context.getApplicationContext().getFilesDir(), "datastore/".concat("settings.preferences_pb"));
            case 2:
                return MathKt.createNavController$NavHostControllerKt__NavHostController_androidKt(context);
            case 3:
                try {
                    Intent data = new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM").setData(Uri.parse("package:" + context.getPackageName()));
                    data.getClass();
                    context.startActivity(data);
                    break;
                } catch (ActivityNotFoundException unused2) {
                }
                return unit;
            case 4:
                try {
                    context.startActivity(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"));
                    break;
                } catch (ActivityNotFoundException unused3) {
                }
                return unit;
            case 5:
                context.startActivity(new Intent("android.settings.APP_LOCALE_SETTINGS", Uri.parse("package:" + context.getPackageName())));
                return unit;
            default:
                try {
                    Intent intent = new Intent("android.settings.APP_OPEN_BY_DEFAULT_SETTINGS", Uri.parse("package:" + context.getPackageName()));
                    intent.addFlags(WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE);
                    context.startActivity(intent);
                    break;
                } catch (Exception e) {
                    if (!(e instanceof ActivityNotFoundException) && (e instanceof SecurityException)) {
                        Toast.makeText(context, R.string.open_app_settings_error, 1).show();
                    } else {
                        Toast.makeText(context, R.string.open_app_settings_error, 1).show();
                    }
                }
                return unit;
        }
    }

    public /* synthetic */ App$$ExternalSyntheticLambda0(Context context, byte b) {
        this.$r8$classId = b;
        this.f$0 = context;
    }
}
