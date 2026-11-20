package androidx.core.view;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RenderNode;
import android.media.AudioDescriptor;
import android.media.MediaDrm;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.media.session.MediaSession;
import android.os.Build;
import android.util.LongSparseArray;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.RoundedCorner;
import android.view.View;
import android.view.translation.TranslationRequestValue;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.AdjustedSemanticsNode;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda6;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.unit.DensityWithConverter;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.provider.CallbackWrapper;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioDescriptorUtil$$ExternalSyntheticLambda2;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import androidx.media3.session.legacy.MediaSessionCompat$MediaSessionImplApi23;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.materialkolor.quantize.QuantizerWu;
import com.metrolist.music.App;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.alarm.MusicAlarmEntry;
import com.metrolist.music.playback.alarm.MusicAlarmReceiver;
import com.metrolist.music.playback.alarm.MusicAlarmStore$loadBlocking$1;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DisplayCompat {
    public static Bitmap decode(byte[] bArr, int i, int i2) throws IOException {
        BitmapFactory.Options options;
        int i3 = 0;
        int intValue = 1;
        if (i2 != -1) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, i, options);
            options.inJustDecodeBounds = false;
            options.inSampleSize = 1;
            for (int iMax = Math.max(options.outWidth, options.outHeight); iMax > i2; iMax /= 2) {
                options.inSampleSize *= 2;
            }
        } else {
            options = null;
        }
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, i, options);
        if (options != null) {
            options.inSampleSize = 1;
        }
        if (bitmapDecodeByteArray == null) {
            throw ParserException.createForMalformedContainer(new IllegalStateException(), "Could not decode image data");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            ExifInterface exifInterface = new ExifInterface(byteArrayInputStream);
            byteArrayInputStream.close();
            ExifInterface.ExifAttribute exifAttribute = exifInterface.getExifAttribute("Orientation");
            if (exifAttribute != null) {
                try {
                    intValue = exifAttribute.getIntValue(exifInterface.mExifByteOrder);
                } catch (NumberFormatException unused) {
                }
            }
            switch (intValue) {
                case 3:
                case 4:
                    i3 = 180;
                    break;
                case 5:
                case 8:
                    i3 = 270;
                    break;
                case 6:
                case 7:
                    i3 = 90;
                    break;
            }
            if (i3 == 0) {
                return bitmapDecodeByteArray;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(i3);
            return Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, false);
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public static void doTranslation(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray longSparseArray) {
        TranslationResponseValue value;
        CharSequence text;
        AdjustedSemanticsNode adjustedSemanticsNode;
        SemanticsNode semanticsNode;
        Function1 function1;
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            long jKeyAt = longSparseArray.keyAt(i);
            ViewTranslationResponse viewTranslationResponse = (ViewTranslationResponse) longSparseArray.get(jKeyAt);
            if (viewTranslationResponse != null && (value = viewTranslationResponse.getValue("android:text")) != null && (text = value.getText()) != null && (adjustedSemanticsNode = (AdjustedSemanticsNode) androidContentCaptureManager.getCurrentSemanticsNodes$ui().get((int) jKeyAt)) != null && (semanticsNode = adjustedSemanticsNode.semanticsNode) != null) {
                Object obj = semanticsNode.unmergedConfig.props.get(SemanticsActions.SetTextSubstitution);
                if (obj == null) {
                    obj = null;
                }
                AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
                if (accessibilityAction != null && (function1 = (Function1) accessibilityAction.action) != null) {
                }
            }
        }
    }

    public static ImmutableList getAllLpcmChannelMasksFromPcmSads(List list) {
        if (Build.VERSION.SDK_INT < 31 || list == null) {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            return RegularImmutableList.EMPTY;
        }
        TreeSet treeSet = new TreeSet(Comparator.comparing(new AudioDescriptorUtil$$ExternalSyntheticLambda2()).reversed());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AudioDescriptor audioDescriptorM = FrameworkMediaDrm$$ExternalSyntheticLambda0.m(it.next());
            if (audioDescriptorM.getStandard() == 1) {
                byte[] descriptor = audioDescriptorM.getDescriptor();
                if (descriptor.length != 3) {
                    Log.w("AudioDescriptorUtil", "Invalid SAD length: " + descriptor.length);
                } else {
                    byte b = descriptor[0];
                    int i = (b & 7) + 1;
                    if (((b >> 3) & 15) == 1) {
                        treeSet.add(Integer.valueOf(Util.getAudioTrackChannelConfig(i)));
                    }
                }
            }
        }
        return ImmutableList.copyOf((Collection) treeSet);
    }

    public static Path getCutoutPath(DisplayCutout displayCutout) {
        return displayCutout.getCutoutPath();
    }

    public static RoundedCornerCompat getRoundedCorner(Display display, int i) {
        RoundedCorner roundedCorner;
        int i2;
        if (Build.VERSION.SDK_INT < 31 || (roundedCorner = display.getRoundedCorner(i)) == null) {
            return null;
        }
        int position = roundedCorner.getPosition();
        if (position != 0) {
            i2 = 1;
            if (position != 1) {
                i2 = 2;
                if (position != 2) {
                    i2 = 3;
                    if (position != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(position, "Invalid position: "));
                        return null;
                    }
                }
            }
        } else {
            i2 = 0;
        }
        return new RoundedCornerCompat(i2, roundedCorner.getRadius(), roundedCorner.getCenter());
    }

    public static boolean isActivity(PendingIntent pendingIntent) {
        return pendingIntent.isActivity();
    }

    public static Bitmap makeShared(Bitmap bitmap) {
        return Build.VERSION.SDK_INT >= 31 ? bitmap.asShared() : bitmap;
    }

    public static void onCreateVirtualViewTranslationRequests(AndroidContentCaptureManager androidContentCaptureManager, long[] jArr, Consumer consumer) {
        SemanticsNode semanticsNode;
        for (long j : jArr) {
            AdjustedSemanticsNode adjustedSemanticsNode = (AdjustedSemanticsNode) androidContentCaptureManager.getCurrentSemanticsNodes$ui().get((int) j);
            if (adjustedSemanticsNode != null && (semanticsNode = adjustedSemanticsNode.semanticsNode) != null) {
                ViewTranslationRequest.Builder builder = new ViewTranslationRequest.Builder(androidContentCaptureManager.view.getAutofillId(), semanticsNode.id);
                Object obj = semanticsNode.unmergedConfig.props.get(SemanticsProperties.Text);
                if (obj == null) {
                    obj = null;
                }
                List list = (List) obj;
                if (list != null) {
                    builder.setValue("android:text", TranslationRequestValue.forText(new AnnotatedString(ListUtilsKt.fastJoinToString$default(list, "\n", null, 62))));
                    consumer.accept(builder.build());
                }
            }
        }
    }

    public static boolean requiresSecureDecoder(MediaDrm mediaDrm, String str, int i) {
        return mediaDrm.requiresSecureDecoder(str, i);
    }

    public static void scheduleAll(Context context, List list) throws Throwable {
        int i;
        int i2;
        MusicAlarmEntry musicAlarmEntryCopy$default;
        context.getClass();
        list.getClass();
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(AlarmManager.class);
        if (alarmManager == null) {
            return;
        }
        List list2 = (List) AwaitKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new MusicAlarmStore$loadBlocking$1(context, (Continuation) null, (byte) 0));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((MusicAlarmEntry) it.next()).id);
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((MusicAlarmEntry) it2.next()).id);
        }
        Iterator it3 = CollectionsKt.toList(CollectionsKt.toMutableSet(CollectionsKt.plus((Iterable) arrayList2, (Collection) arrayList))).iterator();
        while (true) {
            i = Integer.MAX_VALUE;
            if (!it3.hasNext()) {
                break;
            }
            String str = (String) it3.next();
            str.getClass();
            AlarmManager alarmManager2 = (AlarmManager) context.getSystemService(AlarmManager.class);
            if (alarmManager2 != null) {
                Intent intentPutExtra = new Intent(context, (Class<?>) MusicService.class).setAction("com.metrolist.music.action.ALARM_TRIGGER").putExtra("extra_alarm_id", str);
                intentPutExtra.getClass();
                PendingIntent foregroundService = PendingIntent.getForegroundService(context, str.hashCode() & Integer.MAX_VALUE, intentPutExtra, 201326592);
                foregroundService.getClass();
                alarmManager2.cancel(foregroundService);
                Intent intentPutExtra2 = new Intent(context, (Class<?>) MusicAlarmReceiver.class).setAction("com.metrolist.music.action.TRIGGER_ALARM").putExtra("extra_alarm_id", str);
                intentPutExtra2.getClass();
                PendingIntent broadcast = PendingIntent.getBroadcast(context, str.hashCode() & Integer.MAX_VALUE, intentPutExtra2, 201326592);
                broadcast.getClass();
                alarmManager2.cancel(broadcast);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it4 = list.iterator();
        while (it4.hasNext()) {
            MusicAlarmEntry musicAlarmEntry = (MusicAlarmEntry) it4.next();
            boolean z = musicAlarmEntry.enabled;
            String str2 = musicAlarmEntry.id;
            String str3 = musicAlarmEntry.playlistId;
            if (!z || StringsKt.isBlank(str3)) {
                i2 = i;
                musicAlarmEntryCopy$default = MusicAlarmEntry.copy$default(musicAlarmEntry, false, 0, 0, null, false, -1L, 63);
            } else {
                int i3 = musicAlarmEntry.hour;
                int i4 = musicAlarmEntry.minute;
                i2 = i;
                Calendar calendar = Calendar.getInstance();
                calendar.set(13, 0);
                calendar.set(14, 0);
                calendar.set(11, i3);
                calendar.set(12, i4);
                if (calendar.getTimeInMillis() <= System.currentTimeMillis()) {
                    calendar.add(6, 1);
                }
                long timeInMillis = calendar.getTimeInMillis();
                Intent intentPutExtra3 = new Intent(context, (Class<?>) MusicService.class).setAction("com.metrolist.music.action.ALARM_TRIGGER").putExtra("extra_alarm_id", str2).putExtra("extra_alarm_playlist_id", str3).putExtra("extra_alarm_random_song", musicAlarmEntry.randomSong);
                intentPutExtra3.getClass();
                PendingIntent foregroundService2 = PendingIntent.getForegroundService(context, str2.hashCode() & i2, intentPutExtra3, 201326592);
                foregroundService2.getClass();
                if (Build.VERSION.SDK_INT < 31 || alarmManager.canScheduleExactAlarms()) {
                    alarmManager.setExactAndAllowWhileIdle(0, timeInMillis, foregroundService2);
                } else {
                    alarmManager.setAndAllowWhileIdle(0, timeInMillis, foregroundService2);
                }
                musicAlarmEntryCopy$default = MusicAlarmEntry.copy$default(musicAlarmEntry, false, 0, 0, null, false, timeInMillis, 63);
            }
            arrayList3.add(musicAlarmEntryCopy$default);
            i = i2;
        }
        AwaitKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new App.C01391(context, arrayList3, null, (byte) 23));
    }

    public static void scheduleFromPreferences(Context context) throws Throwable {
        scheduleAll(context, (List) AwaitKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new MusicAlarmStore$loadBlocking$1(context, (Continuation) null, (byte) 0)));
    }

    public static void setLogSessionIdOnMediaDrmSession(MediaDrm mediaDrm, byte[] bArr, PlayerId playerId) {
        LogSessionId logSessionId = playerId.getLogSessionId();
        if (logSessionId.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            return;
        }
        MediaDrm.PlaybackComponent playbackComponent = mediaDrm.getPlaybackComponent(bArr);
        playbackComponent.getClass();
        playbackComponent.setLogSessionId(logSessionId);
    }

    public static void setLogSessionIdToMediaCodecFormat(QuantizerWu quantizerWu, PlayerId playerId) {
        LogSessionId logSessionId = playerId.getLogSessionId();
        if (logSessionId.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            return;
        }
        ((MediaFormat) quantizerWu.momentsR).setString("log-session-id", logSessionId.getStringId());
    }

    public static void setMediaButtonBroadcastReceiver(CallbackWrapper callbackWrapper, ComponentName componentName) {
        try {
            MediaSession mediaSession = ((MediaSessionCompat$MediaSessionImplApi23) callbackWrapper.mCallback).sessionFwk;
            mediaSession.getClass();
            mediaSession.setMediaButtonBroadcastReceiver(componentName);
        } catch (IllegalArgumentException e) {
            if (!Build.MANUFACTURER.equals("motorola")) {
                throw e;
            }
            Log.e("MediaSessionLegacyStub", "caught IllegalArgumentException on a motorola device when attempting to set the media button broadcast receiver. See https://github.com/androidx/media/issues/1730 for details.", e);
        }
    }

    public static void setRenderEffect(RenderNode renderNode, RenderEffect renderEffect) {
        renderNode.setRenderEffect(renderEffect != null ? renderEffect.asAndroidRenderEffect() : null);
    }

    public static final String toAndroidString(FontVariation.Settings settings, Context context) {
        boolean z;
        float variationValue;
        List list = settings.settings;
        DensityWithConverter densityWithConverterDensity = MathKt.Density(context);
        int i = 0;
        int i2 = (Build.VERSION.SDK_INT < 31 || context.getResources().getConfiguration().fontWeightAdjustment == Integer.MAX_VALUE) ? 0 : context.getResources().getConfiguration().fontWeightAdjustment;
        if (i2 == 0) {
            return ListUtilsKt.fastJoinToString$default(list, null, new SaversKt$$ExternalSyntheticLambda6(densityWithConverterDensity), 31);
        }
        int size = list.size();
        String str = "";
        boolean z2 = false;
        while (i < size) {
            FontVariation.SettingInt settingInt = (FontVariation.SettingInt) list.get(i);
            if (Intrinsics.areEqual(settingInt.getAxisName(), "wght")) {
                variationValue = UuidKt.coerceIn(settingInt.toVariationValue() + i2, 1.0f, 1000.0f);
                z = true;
            } else {
                z = z2;
                variationValue = settingInt.toVariationValue();
            }
            if (i != 0) {
                str = ((Object) str) + ",";
            }
            str = ((Object) str) + "'" + settingInt.getAxisName() + "' " + variationValue;
            i++;
            z2 = z;
        }
        if (z2) {
            return str;
        }
        float fCoerceIn = UuidKt.coerceIn(i2 + 400.0f, 1.0f, 1000.0f);
        if (!list.isEmpty()) {
            str = ((Object) str) + ",";
        }
        return ((Object) str) + "'wght' " + fCoerceIn;
    }

    public static void setRenderEffect(View view, RenderEffect renderEffect) {
        view.setRenderEffect(renderEffect != null ? renderEffect.asAndroidRenderEffect() : null);
    }
}
