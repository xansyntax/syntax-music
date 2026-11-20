package com.materialkolor.quantize;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Surface;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.ThemeUtils;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.core.app.NavUtils;
import androidx.core.graphics.ColorUtils;
import androidx.media3.common.Format;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.cache.CachedContent;
import androidx.media3.datasource.cache.CachedContentIndex$Storage;
import androidx.media3.datasource.cache.DefaultContentMetadata;
import androidx.media3.exoplayer.mediacodec.LoudnessCodecController;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.session.PlayerInfo;
import androidx.media3.session.QueueTimeline;
import androidx.media3.session.SessionCommands;
import androidx.media3.session.SessionError;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableMap;
import com.yalantis.ucrop.R;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.ContextAwarePlatform;
import okhttp3.internal.platform.Platform;
import okio.ByteString;
import okio.InputStreamSource;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QuantizerWu {
    public Object cubes;
    public Object moments;
    public Object momentsB;
    public Object momentsG;
    public Object momentsR;
    public Object weights;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Box {
        public int b0;
        public int b1;
        public int g0;
        public int g1;
        public int r0;
        public int r1;
        public int vol;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Direction {
        public static final /* synthetic */ Direction[] $VALUES;
        public static final Direction BLUE;
        public static final Direction GREEN;
        public static final Direction RED;

        static {
            Direction direction = new Direction("RED", 0);
            RED = direction;
            Direction direction2 = new Direction("GREEN", 1);
            GREEN = direction2;
            Direction direction3 = new Direction("BLUE", 2);
            BLUE = direction3;
            $VALUES = new Direction[]{direction, direction2, direction3};
        }

        public static Direction valueOf(String str) {
            return (Direction) Enum.valueOf(Direction.class, str);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MaximizeResult {
        public int cutLocation;
        public double maximum;
    }

    public QuantizerWu(byte b) {
        switch (b) {
            case 5:
                this.weights = PlayerInfo.DEFAULT.copyWithTimeline(QueueTimeline.DEFAULT);
                this.momentsR = SessionCommands.EMPTY;
                this.momentsG = Player.Commands.EMPTY;
                ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                this.momentsB = RegularImmutableList.EMPTY;
                this.moments = Bundle.EMPTY;
                this.cubes = null;
                break;
            case 6:
                this.weights = new AtomicBoolean(false);
                this.momentsR = new CountDownLatch(1);
                this.cubes = "PublicSuffixDatabase.list";
                break;
            default:
                this.weights = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
                this.momentsR = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
                this.momentsG = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
                this.momentsB = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
                this.moments = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
                this.cubes = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
                break;
        }
    }

    public static boolean arrayContains(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList createButtonColorStateList(Context context, int i) {
        int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlHighlight);
        int disabledThemeAttrColor = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorButtonNormal);
        int[] iArr = ThemeUtils.DISABLED_STATE_SET;
        int[] iArr2 = ThemeUtils.PRESSED_STATE_SET;
        int iCompositeColors = ColorUtils.compositeColors(themeAttrColor, i);
        return new ColorStateList(new int[][]{iArr, iArr2, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{disabledThemeAttrColor, iCompositeColors, ColorUtils.compositeColors(themeAttrColor, i), i});
    }

    public static MediaSource$MediaPeriodId findCurrentPlayerMediaPeriodInQueue(Player player, ImmutableList immutableList, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Timeline.Period period) {
        Timeline currentTimeline = player.getCurrentTimeline();
        int currentPeriodIndex = player.getCurrentPeriodIndex();
        Object uidOfPeriod = currentTimeline.isEmpty() ? null : currentTimeline.getUidOfPeriod(currentPeriodIndex);
        int adGroupIndexAfterPositionUs = (player.isPlayingAd() || currentTimeline.isEmpty()) ? -1 : currentTimeline.getPeriod(currentPeriodIndex, period, false).getAdGroupIndexAfterPositionUs(Util.msToUs(player.getCurrentPosition()) - period.positionInWindowUs);
        for (int i = 0; i < immutableList.size(); i++) {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = (MediaSource$MediaPeriodId) immutableList.get(i);
            if (isMatchingMediaPeriod(mediaSource$MediaPeriodId2, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                return mediaSource$MediaPeriodId2;
            }
        }
        if (immutableList.isEmpty() && mediaSource$MediaPeriodId != null && isMatchingMediaPeriod(mediaSource$MediaPeriodId, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
            return mediaSource$MediaPeriodId;
        }
        return null;
    }

    public static LayerDrawable getRatingBarLayerDrawable(ResourceManagerInternal resourceManagerInternal, Context context, int i) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
        Drawable drawable = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_black_48dp);
        Drawable drawable2 = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_half_black_48dp);
        if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicWidth() == dimensionPixelSize && drawable.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawable;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawable.draw(canvas);
            bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawable2 instanceof BitmapDrawable) && drawable2.getIntrinsicWidth() == dimensionPixelSize && drawable2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawable2;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawable2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    public static boolean isMatchingMediaPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Object obj, boolean z, int i, int i2, int i3) {
        Object obj2 = mediaSource$MediaPeriodId.periodUid;
        int i4 = mediaSource$MediaPeriodId.adGroupIndex;
        if (!obj2.equals(obj)) {
            return false;
        }
        if (z && i4 == i && mediaSource$MediaPeriodId.adIndexInAdGroup == i2) {
            return true;
        }
        return !z && i4 == -1 && mediaSource$MediaPeriodId.nextAdGroupIndex == i3;
    }

    public static DefaultContentMetadata readContentMetadata(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            String utf = dataInputStream.readUTF();
            int i3 = dataInputStream.readInt();
            if (i3 < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(i3, "Invalid value size: "));
                return null;
            }
            int iMin = Math.min(i3, 10485760);
            byte[] bArrCopyOf = Util.EMPTY_BYTE_ARRAY;
            int i4 = 0;
            while (i4 != i3) {
                int i5 = i4 + iMin;
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i5);
                dataInputStream.readFully(bArrCopyOf, i4, iMin);
                iMin = Math.min(i3 - i5, 10485760);
                i4 = i5;
            }
            map.put(utf, bArrCopyOf);
        }
        return new DefaultContentMetadata(map);
    }

    public static void setPorterDuffColorFilter(Drawable drawable, int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        Drawable drawableMutate = drawable.mutate();
        if (mode == null) {
            mode = AppCompatDrawableManager.DEFAULT_MODE;
        }
        PorterDuff.Mode mode2 = AppCompatDrawableManager.DEFAULT_MODE;
        synchronized (AppCompatDrawableManager.class) {
            porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(i, mode);
        }
        drawableMutate.setColorFilter(porterDuffColorFilter);
    }

    public static void writeContentMetadata(DefaultContentMetadata defaultContentMetadata, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry> setEntrySet = defaultContentMetadata.metadata.entrySet();
        dataOutputStream.writeInt(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            dataOutputStream.writeUTF((String) entry.getKey());
            byte[] bArr = (byte[]) entry.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public void addTimelineForMediaPeriodId(StatusLine statusLine, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Timeline timeline) {
        if (mediaSource$MediaPeriodId == null) {
            return;
        }
        if (timeline.getIndexOfPeriod(mediaSource$MediaPeriodId.periodUid) != -1) {
            statusLine.put(mediaSource$MediaPeriodId, timeline);
            return;
        }
        Timeline timeline2 = (Timeline) ((RegularImmutableMap) this.momentsG).get(mediaSource$MediaPeriodId);
        if (timeline2 != null) {
            statusLine.put(mediaSource$MediaPeriodId, timeline2);
        }
    }

    public CachedContent get(String str) {
        return (CachedContent) ((HashMap) this.weights).get(str);
    }

    public CachedContent getOrAdd(String str) {
        HashMap map = (HashMap) this.weights;
        CachedContent cachedContent = (CachedContent) map.get(str);
        if (cachedContent != null) {
            return cachedContent;
        }
        SparseArray sparseArray = (SparseArray) this.momentsR;
        int size = sparseArray.size();
        int i = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
            iKeyAt = i;
        }
        CachedContent cachedContent2 = new CachedContent(iKeyAt, str, DefaultContentMetadata.EMPTY);
        map.put(str, cachedContent2);
        sparseArray.put(iKeyAt, str);
        ((SparseBooleanArray) this.momentsB).put(iKeyAt, true);
        ((CachedContentIndex$Storage) this.moments).onUpdate(cachedContent2);
        return cachedContent2;
    }

    public ColorStateList getTintListForDrawableRes(Context context, int i) {
        if (i == R.drawable.abc_edit_text_material) {
            return NavUtils.getColorStateList(context, R.color.abc_tint_edittext);
        }
        if (i == R.drawable.abc_switch_track_mtrl_alpha) {
            return NavUtils.getColorStateList(context, R.color.abc_tint_switch_track);
        }
        if (i != R.drawable.abc_switch_thumb_material) {
            if (i == R.drawable.abc_btn_default_mtrl_shape) {
                return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorButtonNormal));
            }
            if (i == R.drawable.abc_btn_borderless_material) {
                return createButtonColorStateList(context, 0);
            }
            if (i == R.drawable.abc_btn_colored_material) {
                return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorAccent));
            }
            if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                return NavUtils.getColorStateList(context, R.color.abc_tint_spinner);
            }
            if (arrayContains(i, (int[]) this.momentsR)) {
                return ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorControlNormal);
            }
            if (arrayContains(i, (int[]) this.moments)) {
                return NavUtils.getColorStateList(context, R.color.abc_tint_default);
            }
            if (arrayContains(i, (int[]) this.cubes)) {
                return NavUtils.getColorStateList(context, R.color.abc_tint_btn_checkable);
            }
            if (i == R.drawable.abc_seekbar_thumb_material) {
                return NavUtils.getColorStateList(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorSwitchThumbNormal);
        if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
            iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
            iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
            iArr2[2] = ThemeUtils.getThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = ThemeUtils.DISABLED_STATE_SET;
            iArr[0] = iArr3;
            iArr2[0] = themeAttrColorStateList.getColorForState(iArr3, 0);
            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
            iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
            iArr2[2] = themeAttrColorStateList.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public void initialize(long j) {
        CachedContentIndex$Storage cachedContentIndex$Storage;
        SparseArray sparseArray = (SparseArray) this.momentsR;
        HashMap map = (HashMap) this.weights;
        CachedContentIndex$Storage cachedContentIndex$Storage2 = (CachedContentIndex$Storage) this.moments;
        cachedContentIndex$Storage2.initialize(j);
        CachedContentIndex$Storage cachedContentIndex$Storage3 = (CachedContentIndex$Storage) this.cubes;
        if (cachedContentIndex$Storage3 != null) {
            cachedContentIndex$Storage3.initialize(j);
        }
        if (cachedContentIndex$Storage2.exists() || (cachedContentIndex$Storage = (CachedContentIndex$Storage) this.cubes) == null || !cachedContentIndex$Storage.exists()) {
            cachedContentIndex$Storage2.load(map, sparseArray);
        } else {
            ((CachedContentIndex$Storage) this.cubes).load(map, sparseArray);
            cachedContentIndex$Storage2.storeFully(map);
        }
        CachedContentIndex$Storage cachedContentIndex$Storage4 = (CachedContentIndex$Storage) this.cubes;
        if (cachedContentIndex$Storage4 != null) {
            cachedContentIndex$Storage4.delete();
            this.cubes = null;
        }
    }

    public InputStreamSource listSource() throws IOException {
        Platform platform = Platform.platform;
        Object obj = Platform.platform;
        ContextAwarePlatform contextAwarePlatform = obj != null ? (ContextAwarePlatform) obj : null;
        Context applicationContext = contextAwarePlatform != null ? contextAwarePlatform.getApplicationContext() : null;
        AssetManager assets = applicationContext != null ? applicationContext.getAssets() : null;
        if (assets != null) {
            InputStream inputStreamOpen = assets.open((String) this.cubes);
            inputStreamOpen.getClass();
            return StringsKt__IndentKt.source(inputStreamOpen);
        }
        if (Build.FINGERPRINT == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Platform applicationContext not initialized. Possibly running Android unit test without Robolectric. Android tests should run with Robolectric and call OkHttp.initialize before test");
            return null;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Platform applicationContext not initialized. Startup Initializer possibly disabled, call OkHttp.initialize before test.");
        return null;
    }

    public MaximizeResult maximize(Box box, Direction direction, int i, int i2, int i3, int i4, int i5, int i6) {
        QuantizerWu quantizerWu = this;
        Box box2 = box;
        int[] iArr = (int[]) quantizerWu.momentsR;
        if (iArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("momentsR");
            throw null;
        }
        int iBottom = CollectionsKt__IterablesKt.bottom(box2, direction, iArr);
        int[] iArr2 = (int[]) quantizerWu.momentsG;
        if (iArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("momentsG");
            throw null;
        }
        int iBottom2 = CollectionsKt__IterablesKt.bottom(box2, direction, iArr2);
        int[] iArr3 = (int[]) quantizerWu.momentsB;
        if (iArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("momentsB");
            throw null;
        }
        int iBottom3 = CollectionsKt__IterablesKt.bottom(box2, direction, iArr3);
        int[] iArr4 = (int[]) quantizerWu.weights;
        if (iArr4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weights");
            throw null;
        }
        int iBottom4 = CollectionsKt__IterablesKt.bottom(box2, direction, iArr4);
        int i7 = -1;
        double d = 0.0d;
        int i8 = i;
        while (i8 < i2) {
            int i9 = iBottom;
            int[] iArr5 = (int[]) quantizerWu.momentsR;
            if (iArr5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("momentsR");
                throw null;
            }
            int pVar = CollectionsKt__IterablesKt.top(box2, direction, i8, iArr5) + i9;
            int[] iArr6 = (int[]) quantizerWu.momentsG;
            if (iArr6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("momentsG");
                throw null;
            }
            int pVar2 = CollectionsKt__IterablesKt.top(box2, direction, i8, iArr6) + iBottom2;
            int[] iArr7 = (int[]) quantizerWu.momentsB;
            if (iArr7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("momentsB");
                throw null;
            }
            int pVar3 = CollectionsKt__IterablesKt.top(box2, direction, i8, iArr7) + iBottom3;
            int[] iArr8 = (int[]) quantizerWu.weights;
            if (iArr8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("weights");
                throw null;
            }
            int pVar4 = CollectionsKt__IterablesKt.top(box2, direction, i8, iArr8) + iBottom4;
            if (pVar4 != 0) {
                double d2 = ((double) ((pVar3 * pVar3) + ((pVar2 * pVar2) + (pVar * pVar)))) / ((double) pVar4);
                int i10 = i3 - pVar;
                int i11 = i4 - pVar2;
                int i12 = i5 - pVar3;
                int i13 = i6 - pVar4;
                if (i13 != 0) {
                    double d3 = (((double) ((i12 * i12) + ((i11 * i11) + (i10 * i10)))) / ((double) i13)) + d2;
                    if (d3 > d) {
                        d = d3;
                        i7 = i8;
                    }
                }
            }
            i8++;
            quantizerWu = this;
            box2 = box;
            iBottom = i9;
        }
        MaximizeResult maximizeResult = new MaximizeResult();
        maximizeResult.cutLocation = i7;
        maximizeResult.maximum = d;
        return maximizeResult;
    }

    public void maybeRemove(String str) {
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.momentsB;
        HashMap map = (HashMap) this.weights;
        CachedContent cachedContent = (CachedContent) map.get(str);
        if (cachedContent != null && cachedContent.cachedSpans.isEmpty() && cachedContent.lockedRanges.isEmpty()) {
            map.remove(str);
            int i = cachedContent.id;
            boolean z = sparseBooleanArray.get(i);
            ((CachedContentIndex$Storage) this.moments).onRemove(cachedContent, z);
            SparseArray sparseArray = (SparseArray) this.momentsR;
            if (z) {
                sparseArray.remove(i);
                sparseBooleanArray.delete(i);
            } else {
                sparseArray.put(i, null);
                ((SparseBooleanArray) this.momentsG).put(i, true);
            }
        }
    }

    public void readTheList() {
        try {
            RealBufferedSource realBufferedSource = new RealBufferedSource(listSource());
            try {
                ByteString byteString = realBufferedSource.readByteString(realBufferedSource.readInt());
                ByteString byteString2 = realBufferedSource.readByteString(realBufferedSource.readInt());
                realBufferedSource.close();
                synchronized (this) {
                    byteString.getClass();
                    this.momentsG = byteString;
                    byteString2.getClass();
                    this.momentsB = byteString2;
                }
                ((CountDownLatch) this.momentsR).countDown();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CharsKt.closeFinally(realBufferedSource, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            ((CountDownLatch) this.momentsR).countDown();
            throw th3;
        }
    }

    public void store() {
        ((CachedContentIndex$Storage) this.moments).storeIncremental((HashMap) this.weights);
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.momentsG;
        int size = sparseBooleanArray.size();
        for (int i = 0; i < size; i++) {
            ((SparseArray) this.momentsR).remove(sparseBooleanArray.keyAt(i));
        }
        sparseBooleanArray.clear();
        ((SparseBooleanArray) this.momentsB).clear();
    }

    public void updateMediaPeriodTimelines(Timeline timeline) {
        ImmutableList immutableList;
        StatusLine statusLine = new StatusLine(4);
        if (((ImmutableList) this.momentsR).isEmpty()) {
            addTimelineForMediaPeriodId(statusLine, (MediaSource$MediaPeriodId) this.moments, timeline);
            if (!Objects.equals((MediaSource$MediaPeriodId) this.cubes, (MediaSource$MediaPeriodId) this.moments)) {
                addTimelineForMediaPeriodId(statusLine, (MediaSource$MediaPeriodId) this.cubes, timeline);
            }
            if (!Objects.equals((MediaSource$MediaPeriodId) this.momentsB, (MediaSource$MediaPeriodId) this.moments) && !Objects.equals((MediaSource$MediaPeriodId) this.momentsB, (MediaSource$MediaPeriodId) this.cubes)) {
                addTimelineForMediaPeriodId(statusLine, (MediaSource$MediaPeriodId) this.momentsB, timeline);
            }
        } else {
            int i = 0;
            while (true) {
                int size = ((ImmutableList) this.momentsR).size();
                immutableList = (ImmutableList) this.momentsR;
                if (i >= size) {
                    break;
                }
                addTimelineForMediaPeriodId(statusLine, (MediaSource$MediaPeriodId) immutableList.get(i), timeline);
                i++;
            }
            if (!immutableList.contains((MediaSource$MediaPeriodId) this.momentsB)) {
                addTimelineForMediaPeriodId(statusLine, (MediaSource$MediaPeriodId) this.momentsB, timeline);
            }
        }
        this.momentsG = statusLine.build(true);
    }

    public double variance(Box box) {
        int[] iArr = (int[]) this.momentsR;
        if (iArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("momentsR");
            throw null;
        }
        int iVolume = CollectionsKt__IterablesKt.volume(box, iArr);
        int[] iArr2 = (int[]) this.momentsG;
        if (iArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("momentsG");
            throw null;
        }
        int iVolume2 = CollectionsKt__IterablesKt.volume(box, iArr2);
        int[] iArr3 = (int[]) this.momentsB;
        if (iArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("momentsB");
            throw null;
        }
        int iVolume3 = CollectionsKt__IterablesKt.volume(box, iArr3);
        double[] dArr = (double[]) this.moments;
        if (dArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moments");
            throw null;
        }
        double d = dArr[CollectionsKt__IterablesKt.getIndex(box.r1, box.g1, box.b1)];
        double[] dArr2 = (double[]) this.moments;
        if (dArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moments");
            throw null;
        }
        double d2 = d - dArr2[CollectionsKt__IterablesKt.getIndex(box.r1, box.g1, box.b0)];
        double[] dArr3 = (double[]) this.moments;
        if (dArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moments");
            throw null;
        }
        double d3 = d2 - dArr3[CollectionsKt__IterablesKt.getIndex(box.r1, box.g0, box.b1)];
        double[] dArr4 = (double[]) this.moments;
        if (dArr4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moments");
            throw null;
        }
        double d4 = d3 + dArr4[CollectionsKt__IterablesKt.getIndex(box.r1, box.g0, box.b0)];
        double[] dArr5 = (double[]) this.moments;
        if (dArr5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moments");
            throw null;
        }
        double d5 = d4 - dArr5[CollectionsKt__IterablesKt.getIndex(box.r0, box.g1, box.b1)];
        double[] dArr6 = (double[]) this.moments;
        if (dArr6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moments");
            throw null;
        }
        double d6 = d5 + dArr6[CollectionsKt__IterablesKt.getIndex(box.r0, box.g1, box.b0)];
        double[] dArr7 = (double[]) this.moments;
        if (dArr7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moments");
            throw null;
        }
        double d7 = d6 + dArr7[CollectionsKt__IterablesKt.getIndex(box.r0, box.g0, box.b1)];
        double[] dArr8 = (double[]) this.moments;
        if (dArr8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moments");
            throw null;
        }
        double d8 = d7 - dArr8[CollectionsKt__IterablesKt.getIndex(box.r0, box.g0, box.b0)];
        int i = iVolume3 * iVolume3;
        int i2 = i + (iVolume2 * iVolume2) + (iVolume * iVolume);
        int[] iArr4 = (int[]) this.weights;
        if (iArr4 != null) {
            return d8 - (((double) i2) / ((double) CollectionsKt__IterablesKt.volume(box, iArr4)));
        }
        Intrinsics.throwUninitializedPropertyAccessException("weights");
        throw null;
    }

    public QuantizerWu(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, Format format, Surface surface, MediaCrypto mediaCrypto, LoudnessCodecController loudnessCodecController) {
        this.weights = mediaCodecInfo;
        this.momentsR = mediaFormat;
        this.momentsG = format;
        this.momentsB = surface;
        this.moments = mediaCrypto;
        this.cubes = loudnessCodecController;
    }

    public QuantizerWu(PlayerInfo playerInfo, SessionCommands sessionCommands, Player.Commands commands, ImmutableList immutableList, Bundle bundle, SessionError sessionError) {
        this.weights = playerInfo;
        this.momentsR = sessionCommands;
        this.momentsG = commands;
        this.momentsB = immutableList;
        this.moments = bundle == null ? Bundle.EMPTY : bundle;
        this.cubes = sessionError;
    }
}
