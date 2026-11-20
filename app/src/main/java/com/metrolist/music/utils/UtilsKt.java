package com.metrolist.music.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.content.FileProvider;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.PreferenceDataStoreSingletonDelegate;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.datastore.preferences.core.PreferencesKt$edit$2;
import androidx.palette.graphics.ColorCutQuantizer;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import coil3.util.FileSystemsKt;
import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.yalantis.ucrop.R;
import dagger.hilt.EntryPoints;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import io.ktor.sse.ServerSentEventKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.ReversedList;
import kotlin.collections.ReversedListReadOnly;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher$promoteAndExecute$Effects;
import okhttp3.Headers;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UtilsKt {
    public static volatile DataStore dataStoreInstance;
    public static final Object dataStoreLock = new Object();

    public static final File createExportFile(Context context, String str) throws IOException {
        String str2;
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "AuralysExports");
        if (!file.exists()) {
            file.mkdirs();
        }
        String strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(str, '.');
        String strSubstringAfterLast = StringsKt.substringAfterLast('.', str, "");
        File file2 = new File(file, str);
        int i = 1;
        while (file2.exists()) {
            if (strSubstringAfterLast.length() > 0) {
                str2 = strSubstringBeforeLast$default + "_" + i + "." + strSubstringAfterLast;
            } else {
                str2 = strSubstringBeforeLast$default + "_" + i;
            }
            i++;
            file2 = new File(file, str2);
        }
        file2.createNewFile();
        return file2;
    }

    /* JADX INFO: renamed from: exportPlaylistAsCSV-0E7RQCE, reason: not valid java name */
    public static Serializable m1526exportPlaylistAsCSV0E7RQCE(Context context, String str, List list) {
        String str2;
        context.getClass();
        str.getClass();
        list.getClass();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Title,Artist,Album,YouTube Video ID\n");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Song song = ((PlaylistSong) it.next()).song;
                SongEntity songEntity = song.song;
                List list2 = song.artists;
                AlbumEntity albumEntity = song.album;
                sb.append("\"" + StringsKt__StringsJVMKt.replace(songEntity.title, "\"", "\"\"", false) + "\"");
                sb.append(",");
                sb.append("\"" + CollectionsKt.joinToString$default(list2, "; ", null, null, new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 21), 30) + "\"");
                sb.append(",");
                sb.append("\"" + ((albumEntity == null || (str2 = albumEntity.title) == null) ? "" : StringsKt__StringsJVMKt.replace(str2, "\"", "\"\"", false)) + "\"");
                sb.append(",");
                sb.append(String.valueOf(songEntity.id));
                sb.append("\n");
            }
            String string = sb.toString();
            File fileCreateExportFile = createExportFile(context, str + ".csv");
            FileWriter fileWriter = new FileWriter(fileCreateExportFile);
            try {
                fileWriter.write(string);
                fileWriter.close();
                return fileCreateExportFile;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CharsKt.closeFinally(fileWriter, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            return new Result.Failure(e);
        }
    }

    /* JADX INFO: renamed from: exportPlaylistAsM3U-0E7RQCE, reason: not valid java name */
    public static Serializable m1527exportPlaylistAsM3U0E7RQCE(Context context, String str, List list) {
        context.getClass();
        str.getClass();
        list.getClass();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("#EXTM3U\n");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Song song = ((PlaylistSong) it.next()).song;
                SongEntity songEntity = song.song;
                List list2 = song.artists;
                sb.append("#EXTINF:" + songEntity.duration + ",");
                sb.append(CollectionsKt.joinToString$default(list2, ";", null, null, new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 22), 30) + " - " + songEntity.title);
                sb.append("\n");
                sb.append("https://youtube.com/watch?v=" + songEntity.id + "\n");
            }
            String string = sb.toString();
            File fileCreateExportFile = createExportFile(context, str + ".m3u");
            FileWriter fileWriter = new FileWriter(fileCreateExportFile);
            try {
                fileWriter.write(string);
                fileWriter.close();
                return fileCreateExportFile;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CharsKt.closeFinally(fileWriter, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            return new Result.Failure(e);
        }
    }

    public static final Serializable exportYouTubePlaylistAsCSV(Context context, String str, List list) {
        String str2;
        context.getClass();
        str.getClass();
        list.getClass();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Title,Artist,Album,YouTube Video ID\n");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                SongItem songItem = (SongItem) it.next();
                sb.append("\"" + StringsKt__StringsJVMKt.replace(songItem.title, "\"", "\"\"", false) + "\"");
                sb.append(",");
                sb.append("\"" + CollectionsKt.joinToString$default(songItem.artists, "; ", null, null, new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 23), 30) + "\"");
                sb.append(",");
                Album album = songItem.album;
                sb.append("\"" + ((album == null || (str2 = album.name) == null) ? "" : StringsKt__StringsJVMKt.replace(str2, "\"", "\"\"", false)) + "\"");
                sb.append(",");
                sb.append(String.valueOf(songItem.id));
                sb.append("\n");
            }
            String string = sb.toString();
            File fileCreateExportFile = createExportFile(context, str + ".csv");
            FileWriter fileWriter = new FileWriter(fileCreateExportFile);
            try {
                fileWriter.write(string);
                fileWriter.close();
                return fileCreateExportFile;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CharsKt.closeFinally(fileWriter, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            return new Result.Failure(e);
        }
    }

    public static final Serializable exportYouTubePlaylistAsM3U(Context context, String str, List list) {
        context.getClass();
        str.getClass();
        list.getClass();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("#EXTM3U\n");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                SongItem songItem = (SongItem) it.next();
                sb.append("#EXTINF:" + songItem.duration + ",");
                sb.append(CollectionsKt.joinToString$default(songItem.artists, " - ", null, null, new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 24), 30) + " - " + songItem.title);
                sb.append("\n");
                sb.append("#YTM:" + songItem.id + "\n");
            }
            String string = sb.toString();
            File fileCreateExportFile = createExportFile(context, str + ".m3u");
            FileWriter fileWriter = new FileWriter(fileCreateExportFile);
            try {
                fileWriter.write(string);
                fileWriter.close();
                return fileCreateExportFile;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CharsKt.closeFinally(fileWriter, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            return new Result.Failure(e);
        }
    }

    public static Bitmap fastBlur(Bitmap bitmap) {
        int i;
        int i2;
        int iRoundToInt = MathKt.roundToInt(bitmap.getWidth() * 1.0f);
        int iRoundToInt2 = MathKt.roundToInt(bitmap.getHeight() * 1.0f);
        if (iRoundToInt <= 0 || iRoundToInt2 <= 0) {
            return null;
        }
        int i3 = 0;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, iRoundToInt, iRoundToInt2, false);
        bitmapCreateScaledBitmap.getClass();
        int width = bitmapCreateScaledBitmap.getWidth();
        int height = bitmapCreateScaledBitmap.getHeight();
        int i4 = width * height;
        int[] iArr = new int[i4];
        bitmapCreateScaledBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i5 = width - 1;
        int i6 = height - 1;
        int[] iArr2 = new int[i4];
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[Math.max(width, height)];
        int[] iArr6 = new int[112896];
        for (int i7 = 0; i7 < 112896; i7++) {
            iArr6[i7] = i7 / 441;
        }
        char c = ')';
        int[][] iArr7 = new int[41][];
        for (int i8 = 0; i8 < 41; i8++) {
            iArr7[i8] = new int[3];
        }
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            char c2 = c;
            if (i9 >= height) {
                break;
            }
            int i12 = i3;
            int i13 = i12;
            int i14 = i13;
            int i15 = i14;
            int i16 = i15;
            int i17 = i16;
            int i18 = i17;
            int i19 = i18;
            int i20 = -20;
            int i21 = i19;
            for (int i22 = 20; i20 <= i22; i22 = 20) {
                int[] iArr8 = iArr4;
                int i23 = iArr[Math.min(i5, Math.max(i20, 0)) + i10];
                int[] iArr9 = iArr7[i20 + 20];
                iArr9[0] = (i23 & 16711680) >> 16;
                iArr9[1] = (i23 & 65280) >> 8;
                iArr9[2] = i23 & 255;
                int iAbs = 21 - Math.abs(i20);
                int i24 = iArr9[0];
                i21 = (i24 * iAbs) + i21;
                int i25 = iArr9[1];
                i12 = (i25 * iAbs) + i12;
                int i26 = iArr9[2];
                i13 = (iAbs * i26) + i13;
                if (i20 > 0) {
                    i17 += i24;
                    i18 += i25;
                    i19 += i26;
                } else {
                    i14 += i24;
                    i15 += i25;
                    i16 += i26;
                }
                i20++;
                iArr4 = iArr8;
            }
            int[] iArr10 = iArr4;
            int i27 = 0;
            int i28 = 20;
            while (i27 < width) {
                iArr2[i10] = iArr6[i21];
                iArr3[i10] = iArr6[i12];
                iArr10[i10] = iArr6[i13];
                int i29 = i21 - i14;
                int i30 = i12 - i15;
                int i31 = i13 - i16;
                int[] iArr11 = iArr7[(i28 + 21) % 41];
                int i32 = i14 - iArr11[0];
                int i33 = i15 - iArr11[1];
                int i34 = i16 - iArr11[2];
                if (i9 == 0) {
                    i2 = i27;
                    iArr5[i2] = Math.min(i2 + 21, i5);
                } else {
                    i2 = i27;
                }
                int i35 = iArr[i11 + iArr5[i2]];
                int i36 = (i35 & 16711680) >> 16;
                iArr11[0] = i36;
                int i37 = (i35 & 65280) >> 8;
                iArr11[1] = i37;
                int i38 = i35 & 255;
                iArr11[2] = i38;
                int i39 = i17 + i36;
                int i40 = i18 + i37;
                int i41 = i19 + i38;
                i21 = i29 + i39;
                i12 = i30 + i40;
                i13 = i31 + i41;
                i28 = (i28 + 1) % 41;
                int[] iArr12 = iArr7[i28 % 41];
                int i42 = iArr12[0];
                i14 = i32 + i42;
                int i43 = iArr12[1];
                i15 = i33 + i43;
                int i44 = iArr12[2];
                i16 = i34 + i44;
                i17 = i39 - i42;
                i18 = i40 - i43;
                i19 = i41 - i44;
                i10++;
                i27 = i2 + 1;
            }
            i11 += width;
            i9++;
            c = c2;
            iArr4 = iArr10;
            i3 = 0;
        }
        int[] iArr13 = iArr4;
        for (int i45 = 0; i45 < width; i45++) {
            int i46 = (-20) * width;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            for (int i56 = -20; i56 <= 20; i56++) {
                int iMax = Math.max(0, i46) + i45;
                int[] iArr14 = iArr7[i56 + 20];
                iArr14[0] = iArr2[iMax];
                iArr14[1] = iArr3[iMax];
                iArr14[2] = iArr13[iMax];
                int iAbs2 = 21 - Math.abs(i56);
                int i57 = iArr14[0];
                i54 = (i57 * iAbs2) + i54;
                int i58 = iArr14[1];
                i55 = (i58 * iAbs2) + i55;
                int i59 = iArr14[2];
                i47 = (iAbs2 * i59) + i47;
                if (i56 > 0) {
                    i51 += i57;
                    i52 += i58;
                    i53 += i59;
                } else {
                    i48 += i57;
                    i49 += i58;
                    i50 += i59;
                }
                if (i56 < i6) {
                    i46 += width;
                }
            }
            int i60 = i54;
            int i61 = i55;
            int i62 = 0;
            int i63 = 20;
            int i64 = i45;
            while (i62 < height) {
                iArr[i64] = (iArr6[i60] << 16) | (-16777216) | (iArr6[i61] << 8) | iArr6[i47];
                int i65 = i60 - i48;
                int i66 = i61 - i49;
                int i67 = i47 - i50;
                int[] iArr15 = iArr7[(i63 + 21) % 41];
                int i68 = i48 - iArr15[0];
                int i69 = i49 - iArr15[1];
                int i70 = i50 - iArr15[2];
                if (i45 == 0) {
                    i = i62;
                    iArr5[i] = Math.min(i + 21, i6) * width;
                } else {
                    i = i62;
                }
                int i71 = iArr5[i] + i45;
                int i72 = iArr2[i71];
                iArr15[0] = i72;
                int i73 = iArr3[i71];
                iArr15[1] = i73;
                int i74 = iArr13[i71];
                iArr15[2] = i74;
                int i75 = i51 + i72;
                int i76 = i52 + i73;
                int i77 = i53 + i74;
                i60 = i65 + i75;
                i61 = i66 + i76;
                i47 = i67 + i77;
                i63 = (i63 + 1) % 41;
                int[] iArr16 = iArr7[i63 % 41];
                int i78 = iArr16[0];
                i48 = i68 + i78;
                int i79 = iArr16[1];
                i49 = i69 + i79;
                int i80 = iArr16[2];
                i50 = i70 + i80;
                i51 = i75 - i78;
                i52 = i76 - i79;
                i53 = i77 - i80;
                i64 += width;
                i62 = i + 1;
            }
        }
        bitmapCreateScaledBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmapCreateScaledBitmap;
    }

    public static final Object get(DataStore dataStore, Preferences$Key preferences$Key, Object obj) {
        dataStore.getClass();
        preferences$Key.getClass();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return AwaitKt.runBlockingK(DefaultIoScheduler.INSTANCE, new DataStoreKt$get$2((Object) dataStore, (Object) preferences$Key, obj, (Continuation) null, (byte) 0));
    }

    public static final String getArtistSeparator(Context context) {
        return IntIntPair$$ExternalSyntheticOutline0.m(ServerSentEventKt.SPACE, context.getString(R.string.and), ServerSentEventKt.SPACE);
    }

    public static final DataStore getDataStore(Context context) {
        context.getClass();
        DataStore dataStore = dataStoreInstance;
        if (dataStore != null) {
            return dataStore;
        }
        synchronized (dataStoreLock) {
            DataStore dataStore2 = dataStoreInstance;
            if (dataStore2 != null) {
                return dataStore2;
            }
            new File(context.getFilesDir(), "datastore").mkdirs();
            RoomDatabase$$ExternalSyntheticLambda2 roomDatabase$$ExternalSyntheticLambda2 = new RoomDatabase$$ExternalSyntheticLambda2((byte) 1);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            Object value = new PreferenceDataStoreSingletonDelegate(roomDatabase$$ExternalSyntheticLambda2, AwaitKt.CoroutineScope(DefaultIoScheduler.INSTANCE.plus(AwaitKt.SupervisorJob$default()))).getValue(context, new DataStoreKt$dataStore$2$2(context, UtilsKt.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1, (byte) 0));
            dataStoreInstance = (DataStore) value;
            return (DataStore) value;
        }
    }

    public static final Uri getExportFileUri(Context context, File file) {
        context.getClass();
        Uri uriForFile = FileProvider.getUriForFile(context, file, context.getPackageName() + ".FileProvider");
        uriForFile.getClass();
        return uriForFile;
    }

    public static final Set idsRemovedRemotely(Collection collection, Set set, Set set2) {
        collection.getClass();
        set2.getClass();
        if (set == null) {
            return EmptySet.INSTANCE;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collection) {
            String str = (String) obj;
            if (set.contains(str) && !set2.contains(str)) {
                linkedHashSet.add(obj);
            }
        }
        return linkedHashSet;
    }

    public static final String joinByBullet(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null && str.length() != 0) {
                arrayList.add(str);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, " • ", null, null, null, 62);
    }

    public static final String joinToArtistString(List list, String str, Function1 function1) throws IOException {
        list.getClass();
        function1.getClass();
        int size = list.size();
        if (size == 0) {
            return "";
        }
        if (size == 1) {
            return (String) function1.invoke(list.get(0));
        }
        if (size != 2) {
            return CollectionsKt.joinToString$default(CollectionsKt.dropLast(1, list), ", ", null, null, new CodecsKt$$ExternalSyntheticLambda0(function1, (byte) 20), 30) + str + function1.invoke(CollectionsKt.last(list));
        }
        return function1.invoke(list.get(0)) + str + function1.invoke(list.get(1));
    }

    public static final String makeTimeString(Long l) {
        if (l == null || l.longValue() < 0) {
            return "";
        }
        long jLongValue = l.longValue() / 1000;
        long j = jLongValue / 86400;
        long j2 = jLongValue % 86400;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        long j5 = j4 / 60;
        long j6 = j4 % 60;
        if (j > 0) {
            return String.format("%d:%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j), Long.valueOf(j3), Long.valueOf(j5), Long.valueOf(j6)}, 4));
        }
        return j3 > 0 ? String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j3), Long.valueOf(j5), Long.valueOf(j6)}, 3)) : String.format("%d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j5), Long.valueOf(j6)}, 2));
    }

    public static final ArrayList preservedLocalSongs(List list, List list2, ArrayList arrayList) {
        ArrayDeque arrayDeque;
        list.getClass();
        if (list2.size() != arrayList.size()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
            return null;
        }
        boolean[] zArr = new boolean[list2.size()];
        boolean[] zArr2 = new boolean[list.size()];
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = CollectionsKt__IterablesKt.getIndices(list2).iterator();
        while (((IntProgressionIterator) it).hasNext) {
            int iNextInt = ((IntIterator) it).nextInt();
            String str = (String) arrayList.get(iNextInt);
            if (str != null) {
                Object arrayDeque2 = linkedHashMap.get(str);
                if (arrayDeque2 == null) {
                    arrayDeque2 = new ArrayDeque();
                    linkedHashMap.put(str, arrayDeque2);
                }
                ((ArrayDeque) arrayDeque2).addLast(Integer.valueOf(iNextInt));
            }
        }
        int i = 0;
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            String str2 = ((PlaylistSongMap) obj).setVideoId;
            Integer num = (str2 == null || (arrayDeque = (ArrayDeque) linkedHashMap.get(str2)) == null) ? null : (Integer) (arrayDeque.isEmpty() ? null : arrayDeque.removeFirst());
            if (num != null) {
                zArr2[i2] = true;
                zArr[num.intValue()] = true;
            }
            i2 = i3;
        }
        IntRange indices = CollectionsKt__IterablesKt.getIndices(list);
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = indices.iterator();
        while (((IntProgressionIterator) it2).hasNext) {
            Object next = ((IntIterator) it2).next();
            int iIntValue = ((Number) next).intValue();
            if (!zArr2[iIntValue] && ((PlaylistSongMap) list.get(iIntValue)).setVideoId == null) {
                arrayList2.add(next);
            }
        }
        IntRange indices2 = CollectionsKt__IterablesKt.getIndices(list2);
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = indices2.iterator();
        while (((IntProgressionIterator) it3).hasNext) {
            Object next2 = ((IntIterator) it3).next();
            if (!zArr[((Number) next2).intValue()]) {
                arrayList3.add(next2);
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
        int size = arrayList3.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj2 = arrayList3.get(i4);
            i4++;
            arrayList4.add((String) list2.get(((Number) obj2).intValue()));
        }
        ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
        int size2 = arrayList2.size();
        int i5 = 0;
        while (i5 < size2) {
            Object obj3 = arrayList2.get(i5);
            i5++;
            arrayList5.add(((PlaylistSongMap) list.get(((Number) obj3).intValue())).songId);
        }
        LinkedHashMap mutableMap = MapsKt__MapsKt.toMutableMap(UuidKt.eachCount(new Headers.Builder(arrayList4, (byte) 3)));
        IntRange indices3 = CollectionsKt__IterablesKt.getIndices(arrayList5);
        ArrayList arrayList6 = new ArrayList();
        Iterator it4 = indices3.iterator();
        while (((IntProgressionIterator) it4).hasNext) {
            Object next3 = ((IntIterator) it4).next();
            String str3 = (String) arrayList5.get(((Number) next3).intValue());
            Integer num2 = (Integer) mutableMap.get(str3);
            int iIntValue2 = num2 != null ? num2.intValue() : 0;
            if (iIntValue2 == 0) {
                arrayList6.add(next3);
            } else {
                mutableMap.put(str3, Integer.valueOf(iIntValue2 - 1));
            }
        }
        ArrayList arrayList7 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList6, 10));
        int size3 = arrayList6.size();
        int i6 = 0;
        while (i6 < size3) {
            Object obj4 = arrayList6.get(i6);
            i6++;
            arrayList7.add(Integer.valueOf(((Number) arrayList2.get(((Number) obj4).intValue())).intValue()));
        }
        ArrayList arrayList8 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList7, 10));
        int size4 = arrayList7.size();
        while (i < size4) {
            Object obj5 = arrayList7.get(i);
            i++;
            arrayList8.add((PlaylistSongMap) list.get(((Number) obj5).intValue()));
        }
        return arrayList8;
    }

    public static final DataStoreKt$rememberPreference$1$1 rememberPreference(Preferences$Key preferences$Key, Object obj, Composer composer, int i) {
        preferences$Key.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = StateFlowKt.distinctUntilChanged(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(getDataStore(context).getData(), preferences$Key, obj, (byte) 1));
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue2, obj, gapComposer, i & 112);
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = new DataStoreKt$rememberPreference$1$1(mutableStateCollectAsStateWithLifecycle, coroutineScope, context, preferences$Key);
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        return (DataStoreKt$rememberPreference$1$1) objRememberedValue3;
    }

    public static final void reportException(Throwable th) {
        th.getClass();
        th.printStackTrace();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object safeDataStoreEdit(Context context, Function2 function2, Continuation continuation) {
        DataStoreKt$safeDataStoreEdit$1 dataStoreKt$safeDataStoreEdit$1;
        boolean z;
        if (continuation instanceof DataStoreKt$safeDataStoreEdit$1) {
            dataStoreKt$safeDataStoreEdit$1 = (DataStoreKt$safeDataStoreEdit$1) continuation;
            int i = dataStoreKt$safeDataStoreEdit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dataStoreKt$safeDataStoreEdit$1.label = i - Integer.MIN_VALUE;
            } else {
                dataStoreKt$safeDataStoreEdit$1 = new DataStoreKt$safeDataStoreEdit$1(continuation);
            }
        } else {
            dataStoreKt$safeDataStoreEdit$1 = new DataStoreKt$safeDataStoreEdit$1(continuation);
        }
        Object obj = dataStoreKt$safeDataStoreEdit$1.result;
        int i2 = dataStoreKt$safeDataStoreEdit$1.label;
        Continuation continuation2 = null;
        int i3 = 0;
        boolean z2 = false;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                new File(context.getFilesDir(), "datastore").mkdirs();
                DataStore dataStore = getDataStore(context);
                dataStoreKt$safeDataStoreEdit$1.label = 1;
                Object objUpdateData = dataStore.updateData(new PreferencesKt$edit$2(function2, continuation2, z2 ? 1 : 0), dataStoreKt$safeDataStoreEdit$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objUpdateData == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            i3 = 1;
            z = i3;
        } catch (IOException e) {
            Timber.Forest.getClass();
            ConnectionPool.e$1(new Object[i3]);
            e.printStackTrace();
            z = i3;
        }
        return Boolean.valueOf(z);
    }

    public static Uri saveBitmapAsFile(Context context, Bitmap bitmap, String str) {
        context.getClass();
        bitmap.getClass();
        if (Build.VERSION.SDK_INT < 29) {
            File file = new File(context.getCacheDir(), "images");
            file.mkdirs();
            File file2 = new File(file, str.concat(".png"));
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
                Uri uriForFile = FileProvider.getUriForFile(context, file2, context.getPackageName() + ".FileProvider");
                uriForFile.getClass();
                return uriForFile;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CharsKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str.concat(".png"));
        contentValues.put("mime_type", "image/png");
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/Auralys");
        Uri uriInsert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Failed to create new MediaStore record");
            return null;
        }
        OutputStream outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(uriInsert);
        if (outputStreamOpenOutputStream == null) {
            return uriInsert;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStreamOpenOutputStream);
            outputStreamOpenOutputStream.close();
            return uriInsert;
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CharsKt.closeFinally(outputStreamOpenOutputStream, th3);
                throw th4;
            }
        }
    }

    public static Object saveToPublicDocuments$default(Context context, File file, String str) {
        context.getClass();
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return getExportFileUri(context, file);
            }
            ContentResolver contentResolver = context.getContentResolver();
            String str2 = Environment.DIRECTORY_DOCUMENTS + "/AuralysExports";
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", file.getName());
            contentValues.put("mime_type", str);
            contentValues.put("relative_path", str2);
            contentValues.put("is_pending", (Integer) 1);
            Uri uriInsert = contentResolver.insert(MediaStore.Files.getContentUri("external_primary"), contentValues);
            if (uriInsert == null) {
                return new Result.Failure(new IOException("Failed to create destination in MediaStore"));
            }
            OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
            if (outputStreamOpenOutputStream == null) {
                return new Result.Failure(new IOException("Failed to open output stream for MediaStore uri"));
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    EntryPoints.copyTo(fileInputStream, outputStreamOpenOutputStream);
                    fileInputStream.close();
                    outputStreamOpenOutputStream.close();
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("is_pending", (Integer) 0);
                    contentResolver.update(uriInsert, contentValues2, null, null);
                    return uriInsert;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CharsKt.closeFinally(fileInputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CharsKt.closeFinally(outputStreamOpenOutputStream, th3);
                    throw th4;
                }
            }
        } catch (Exception e) {
            return new Result.Failure(e);
        }
    }

    public static final List setVideoIdBackfills(List list, ArrayList arrayList) {
        list.getClass();
        if (list.size() != arrayList.size()) {
            return EmptyList.INSTANCE;
        }
        IntRange indices = CollectionsKt__IterablesKt.getIndices(list);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = indices.iterator();
        while (((IntProgressionIterator) it).hasNext) {
            int iNextInt = ((IntIterator) it).nextInt();
            String str = (String) arrayList.get(iNextInt);
            PlaylistSongMap playlistSongMap = (PlaylistSongMap) list.get(iNextInt);
            PlaylistSongMap playlistSongMapCopy$default = (str == null || Intrinsics.areEqual(playlistSongMap.setVideoId, str)) ? null : PlaylistSongMap.copy$default(playlistSongMap, 0, str, 15);
            if (playlistSongMapCopy$default != null) {
                arrayList2.add(playlistSongMapCopy$default);
            }
        }
        return arrayList2;
    }

    public static final List setVideoIdUpdatesForAddedSongs(List list, List list2, List list3) {
        list.getClass();
        list2.getClass();
        list3.getClass();
        boolean zIsEmpty = list.isEmpty();
        EmptyList emptyList = EmptyList.INSTANCE;
        if (zIsEmpty || list2.isEmpty() || list3.isEmpty()) {
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list3.iterator();
        while (it.hasNext()) {
            String str = ((PlaylistSongMap) it.next()).setVideoId;
            if (str != null) {
                arrayList.add(str);
            }
        }
        Set set = CollectionsKt.toSet(arrayList);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list2) {
            String str2 = ((SongItem) obj).id;
            Object arrayList2 = linkedHashMap.get(str2);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(str2, arrayList2);
            }
            ((List) arrayList2).add(obj);
        }
        ArrayList arrayList3 = new ArrayList();
        for (Map.Entry entry : UuidKt.eachCount(new Dispatcher$promoteAndExecute$Effects(list)).entrySet()) {
            String str3 = (String) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            List list4 = (List) linkedHashMap.get(str3);
            if (list4 == null) {
                list4 = emptyList;
            }
            ArrayList arrayList4 = new ArrayList();
            Iterator it2 = list4.iterator();
            while (it2.hasNext()) {
                String str4 = ((SongItem) it2.next()).setVideoId;
                if (str4 != null) {
                    arrayList4.add(str4);
                }
            }
            ArrayList arrayList5 = new ArrayList();
            int size = arrayList4.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList4.get(i);
                i++;
                if (!set.contains((String) obj2)) {
                    arrayList5.add(obj2);
                }
            }
            ArrayList arrayList6 = new ArrayList();
            for (Object obj3 : list3) {
                PlaylistSongMap playlistSongMap = (PlaylistSongMap) obj3;
                if (Intrinsics.areEqual(playlistSongMap.songId, str3) && playlistSongMap.setVideoId == null) {
                    arrayList6.add(obj3);
                }
            }
            List listSortedWith = CollectionsKt.sortedWith(arrayList6, new ColorCutQuantizer.AnonymousClass1((byte) 15));
            if (arrayList5.size() == iIntValue && listSortedWith.size() == iIntValue) {
                ReversedListReadOnly reversedListReadOnly = new ReversedListReadOnly(arrayList5);
                Iterator it3 = reversedListReadOnly.iterator();
                Iterator it4 = listSortedWith.iterator();
                ArrayList arrayList7 = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(reversedListReadOnly, 10), CollectionsKt__IterablesKt.collectionSizeOrDefault(listSortedWith, 10)));
                while (true) {
                    ListIterator listIterator = (ListIterator) ((ReversedList.AnonymousClass1) it3).delegateIterator;
                    if (!listIterator.hasPrevious() || !it4.hasNext()) {
                        break;
                    }
                    arrayList7.add(PlaylistSongMap.copy$default((PlaylistSongMap) it4.next(), 0, (String) listIterator.previous(), 15));
                }
                arrayList3.addAll(arrayList7);
            }
        }
        return arrayList3;
    }

    public static final Object get(DataStore dataStore, Preferences$Key preferences$Key) {
        dataStore.getClass();
        preferences$Key.getClass();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return AwaitKt.runBlockingK(DefaultIoScheduler.INSTANCE, new DataStoreKt$get$1((Object) dataStore, (Object) preferences$Key, (Continuation) null, (byte) 0));
    }
}
