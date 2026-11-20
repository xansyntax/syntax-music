package androidx.core.os;

import android.app.Activity;
import android.app.LocaleManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioProfile;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.CursorAnchorInfo;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.window.Api33Impl$$ExternalSyntheticLambda0;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioCapabilities;
import com.google.common.collect.ImmutableList;
import com.metrolist.music.ui.component.AppNavigationKt$$ExternalSyntheticApiModelOutline0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BundleCompat$Api33Impl {
    public static OnBackInvokedDispatcher findOnBackInvokedDispatcher(Toolbar toolbar) {
        return toolbar.findOnBackInvokedDispatcher();
    }

    public static AudioCapabilities getCapabilitiesInternalForDirectPlayback(AudioManager audioManager, AudioAttributes audioAttributes, ImmutableList immutableList, List list) {
        List<AudioProfile> directProfilesForAttributes = audioManager.getDirectProfilesForAttributes(audioAttributes.getPlatformAudioAttributes());
        HashMap map = new HashMap();
        map.put(2, new HashSet(StringsKt__IndentKt.asList(12)));
        for (int i = 0; i < directProfilesForAttributes.size(); i++) {
            AudioProfile audioProfile = directProfilesForAttributes.get(i);
            if (audioProfile.getEncapsulationType() != 1) {
                int format = audioProfile.getFormat();
                if (Util.isEncodingLinearPcm(format) || AudioCapabilities.ALL_SURROUND_ENCODINGS_AND_MAX_CHANNELS.containsKey(Integer.valueOf(format))) {
                    if (map.containsKey(Integer.valueOf(format))) {
                        Set set = (Set) map.get(Integer.valueOf(format));
                        set.getClass();
                        set.addAll(StringsKt__IndentKt.asList(audioProfile.getChannelMasks()));
                    } else {
                        map.put(Integer.valueOf(format), new HashSet(StringsKt__IndentKt.asList(audioProfile.getChannelMasks())));
                    }
                }
            }
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Map.Entry entry : map.entrySet()) {
            builder.add((Object) new AudioCapabilities.AudioProfile((Set) entry.getValue(), ((Integer) entry.getKey()).intValue()));
        }
        return new AudioCapabilities(builder.build(), immutableList, list);
    }

    public static AudioDeviceInfo getDefaultRoutedDeviceForAttributes(AudioManager audioManager, AudioAttributes audioAttributes) {
        audioManager.getClass();
        List<AudioDeviceInfo> audioDevicesForAttributes = audioManager.getAudioDevicesForAttributes(audioAttributes.getPlatformAudioAttributes());
        if (audioDevicesForAttributes.isEmpty()) {
            return null;
        }
        return audioDevicesForAttributes.get(0);
    }

    public static int getMaxItems$activity() {
        int i = Build.VERSION.SDK_INT;
        if (i < 33 && (i < 30 || SdkExtensions.getExtensionVersion(30) < 2)) {
            return Integer.MAX_VALUE;
        }
        return MediaStore.getPickImagesMaxLimit();
    }

    public static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }

    public static Object getParcelable(Bundle bundle, String str, Class cls) {
        return bundle.getParcelable(str, cls);
    }

    public static ArrayList getParcelableArrayList(Bundle bundle, String str, Class cls) {
        return bundle.getParcelableArrayList(str, cls);
    }

    public static String getUniqueId(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getUniqueId();
    }

    public static boolean isSelectedChildViewEnabled(DropDownListView dropDownListView) {
        return dropDownListView.isSelectedChildViewEnabled();
    }

    public static boolean isTextSelectable(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isTextSelectable();
    }

    public static LocaleList localeManagerGetApplicationLocales(Object obj) {
        return ((LocaleManager) obj).getApplicationLocales();
    }

    public static void localeManagerSetApplicationLocales(Object obj, LocaleList localeList) {
        ((LocaleManager) obj).setApplicationLocales(localeList);
    }

    public static Api33Impl$$ExternalSyntheticLambda0 registerOnBackPressedCallback(Object obj, AppCompatDelegateImpl appCompatDelegateImpl) {
        Api33Impl$$ExternalSyntheticLambda0 api33Impl$$ExternalSyntheticLambda0 = new Api33Impl$$ExternalSyntheticLambda0((byte) 1, appCompatDelegateImpl);
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, api33Impl$$ExternalSyntheticLambda0);
        return api33Impl$$ExternalSyntheticLambda0;
    }

    public static final void setEditorBoundsInfo(CursorAnchorInfo.Builder builder, Rect rect) {
        builder.setEditorBoundsInfo(AppNavigationKt$$ExternalSyntheticApiModelOutline0.m().setEditorBounds(ColorKt.toAndroidRectF(rect)).setHandwritingBounds(ColorKt.toAndroidRectF(rect)).build());
    }

    public static void setSelectedChildViewEnabled(DropDownListView dropDownListView, boolean z) {
        dropDownListView.setSelectedChildViewEnabled(z);
    }

    public static void tryRegisterOnBackInvokedCallback(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
    }

    public static void tryUnregisterOnBackInvokedCallback(Object obj, Api33Impl$$ExternalSyntheticLambda0 api33Impl$$ExternalSyntheticLambda0) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback(api33Impl$$ExternalSyntheticLambda0);
    }

    public static void unregisterOnBackInvokedCallback(Object obj, Api33Impl$$ExternalSyntheticLambda0 api33Impl$$ExternalSyntheticLambda0) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback(api33Impl$$ExternalSyntheticLambda0);
    }
}
