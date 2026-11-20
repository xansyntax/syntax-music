package androidx.compose.runtime;

import android.media.AudioRecord;
import androidx.datastore.core.Final;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences$Key;
import com.metrolist.music.AvailableUpdate;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.SharingCommand;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Recomposer$join$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recomposer$join$2(AvailableUpdate availableUpdate, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                Recomposer$join$2 recomposer$join$2 = new Recomposer$join$2(2, continuation, (byte) 0);
                recomposer$join$2.L$0 = obj;
                return recomposer$join$2;
            case 1:
                Recomposer$join$2 recomposer$join$3 = new Recomposer$join$2(2, continuation, (byte) 1);
                recomposer$join$3.L$0 = obj;
                return recomposer$join$3;
            case 2:
                Recomposer$join$2 recomposer$join$4 = new Recomposer$join$2(2, continuation, (byte) 2);
                recomposer$join$4.L$0 = obj;
                return recomposer$join$4;
            case 3:
                Recomposer$join$2 recomposer$join$5 = new Recomposer$join$2(null, continuation);
                recomposer$join$5.L$0 = obj;
                return recomposer$join$5;
            case 4:
                Recomposer$join$2 recomposer$join$6 = new Recomposer$join$2(2, continuation, (byte) 4);
                recomposer$join$6.L$0 = obj;
                return recomposer$join$6;
            case 5:
                Recomposer$join$2 recomposer$join$7 = new Recomposer$join$2(2, continuation, (byte) 5);
                recomposer$join$7.L$0 = obj;
                return recomposer$join$7;
            case 6:
                Recomposer$join$2 recomposer$join$8 = new Recomposer$join$2(2, continuation, (byte) 6);
                recomposer$join$8.L$0 = obj;
                return recomposer$join$8;
            case 7:
                Recomposer$join$2 recomposer$join$9 = new Recomposer$join$2(2, continuation, (byte) 7);
                recomposer$join$9.L$0 = obj;
                return recomposer$join$9;
            case 8:
                Recomposer$join$2 recomposer$join$10 = new Recomposer$join$2(2, continuation, (byte) 8);
                recomposer$join$10.L$0 = obj;
                return recomposer$join$10;
            case 9:
                Recomposer$join$2 recomposer$join$11 = new Recomposer$join$2(2, continuation, (byte) 9);
                recomposer$join$11.L$0 = obj;
                return recomposer$join$11;
            case 10:
                Recomposer$join$2 recomposer$join$12 = new Recomposer$join$2(2, continuation, (byte) 10);
                recomposer$join$12.L$0 = obj;
                return recomposer$join$12;
            case 11:
                Recomposer$join$2 recomposer$join$13 = new Recomposer$join$2(2, continuation, (byte) 11);
                recomposer$join$13.L$0 = obj;
                return recomposer$join$13;
            default:
                Recomposer$join$2 recomposer$join$14 = new Recomposer$join$2(2, continuation, (byte) 12);
                recomposer$join$14.L$0 = obj;
                return recomposer$join$14;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((Recomposer$join$2) create((Recomposer.State) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                return ((Recomposer$join$2) create((androidx.datastore.core.State) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 2:
                ((Recomposer$join$2) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 3:
                ((Recomposer$join$2) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 4:
                ((Recomposer$join$2) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 5:
                ((Recomposer$join$2) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 6:
                ((Recomposer$join$2) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 7:
                ((Recomposer$join$2) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 8:
                return ((Recomposer$join$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 9:
                ((Recomposer$join$2) create((MusicDatabase) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            case 10:
                return ((Recomposer$join$2) create((Playlist) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 11:
                ((Recomposer$join$2) create((MusicDatabase) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            default:
                return ((Recomposer$join$2) create((SharingCommand) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        int i = 0;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                return Boolean.valueOf(((Recomposer.State) this.L$0) == Recomposer.State.ShutDown);
            case 1:
                ResultKt.throwOnFailure(obj);
                return Boolean.valueOf(!(((androidx.datastore.core.State) this.L$0) instanceof Final));
            case 2:
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutablePreferences.remove(PreferenceKeysKt.InnerTubeCookieKey);
                mutablePreferences.remove(PreferenceKeysKt.VisitorDataKey);
                mutablePreferences.remove(PreferenceKeysKt.DataSyncIdKey);
                mutablePreferences.remove(PreferenceKeysKt.InnerTubeAuthUserKey);
                mutablePreferences.remove(PreferenceKeysKt.AccountNameKey);
                mutablePreferences.remove(PreferenceKeysKt.AccountEmailKey);
                mutablePreferences.remove(PreferenceKeysKt.AccountChannelHandleKey);
                return unit;
            case 3:
                ResultKt.throwOnFailure(obj);
                throw null;
            case 4:
                MutablePreferences mutablePreferences2 = (MutablePreferences) this.L$0;
                ResultKt.throwOnFailure(obj);
                String str = (String) mutablePreferences2.get(PreferenceKeysKt.LyricsProviderOrderKey);
                if (str == null) {
                    str = "";
                }
                if (StringsKt.contains(str, "SimpMusic", false)) {
                    List listSplit$default = StringsKt.split$default(str, new String[]{","}, 0, 6);
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
                    Iterator it = listSplit$default.iterator();
                    while (it.hasNext()) {
                        arrayList.add(StringsKt.trim((String) it.next()).toString());
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    while (i < size) {
                        Object obj2 = arrayList.get(i);
                        i++;
                        String str2 = (String) obj2;
                        if (!StringsKt.isBlank(str2) && !str2.equals("SimpMusic")) {
                            arrayList2.add(obj2);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList(arrayList2);
                    if (arrayList3.isEmpty()) {
                        mutablePreferences2.set(PreferenceKeysKt.LyricsProviderOrderKey, "");
                    } else {
                        mutablePreferences2.set(PreferenceKeysKt.LyricsProviderOrderKey, CollectionsKt.joinToString$default(arrayList3, ",", null, null, null, 62));
                    }
                }
                Preferences$Key preferences$Key = PreferenceKeysKt.PreferredLyricsProviderKey;
                if (Intrinsics.areEqual(mutablePreferences2.get(preferences$Key), "SIMPMUSIC")) {
                    mutablePreferences2.setUnchecked$datastore_preferences_core(preferences$Key, "LRCLIB");
                }
                mutablePreferences2.set(PreferenceKeysKt.SimpMusicMigrationDoneKey, Boolean.TRUE);
                mutablePreferences2.set(PreferenceKeysKt.LastSeenVersionKey, "4.1.0");
                return unit;
            case 5:
                MutablePreferences mutablePreferences3 = (MutablePreferences) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutablePreferences3.set(PreferenceKeysKt.VideoThumbnailMigrationDoneKey, Boolean.TRUE);
                return unit;
            case 6:
                MutablePreferences mutablePreferences4 = (MutablePreferences) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutablePreferences4.set(PreferenceKeysKt.LastSeenVersionKey, "4.1.0");
                return unit;
            case 7:
                MutablePreferences mutablePreferences5 = (MutablePreferences) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutablePreferences5.remove(PreferenceKeysKt.ListenTogetherSessionTokenKey);
                mutablePreferences5.remove(PreferenceKeysKt.ListenTogetherRoomCodeKey);
                mutablePreferences5.remove(PreferenceKeysKt.ListenTogetherUserIdKey);
                mutablePreferences5.remove(PreferenceKeysKt.ListenTogetherIsHostKey);
                mutablePreferences5.remove(PreferenceKeysKt.ListenTogetherSessionTimestampKey);
                return unit;
            case 8:
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
                ConnectionPool connectionPool = Timber.Forest;
                connectionPool.tag("MusicRecognitionService");
                ConnectionPool.d(new Integer(44100), new Integer(minBufferSize), new Long(12000L));
                AudioRecord audioRecord = new AudioRecord(1, 44100, 16, 2, minBufferSize);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[minBufferSize];
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    audioRecord.startRecording();
                    connectionPool.tag("MusicRecognitionService");
                    ConnectionPool.d(new Long(12000L));
                    while (System.currentTimeMillis() - jCurrentTimeMillis < 12000 && AwaitKt.isActive(coroutineScope)) {
                        int i2 = audioRecord.read(bArr, 0, minBufferSize);
                        if (i2 > 0) {
                            byteArrayOutputStream.write(bArr, 0, i2);
                        }
                    }
                    audioRecord.stop();
                    audioRecord.release();
                    int size2 = byteArrayOutputStream.size();
                    Timber.Forest.tag("MusicRecognitionService");
                    ConnectionPool.d(new Integer(size2));
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    audioRecord.stop();
                    audioRecord.release();
                    throw th;
                }
            case 9:
                MusicDatabase musicDatabase = (MusicDatabase) this.L$0;
                ResultKt.throwOnFailure(obj);
                musicDatabase.getClass();
                DatabaseDao databaseDao = musicDatabase.$$delegate_0;
                databaseDao.clearPlaylist("LP_WEEKLY_MOST");
                databaseDao.clearPlaylist("LP_MONTHLY_MOST");
                databaseDao.delete(new PlaylistEntity("LP_WEEKLY_MOST", "", null, null, false, null, null, null, null, null, null, 16380));
                databaseDao.delete(new PlaylistEntity("LP_MONTHLY_MOST", "", null, null, false, null, null, null, null, null, null, 16380));
                return unit;
            case 10:
                Playlist playlist = (Playlist) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Boolean.valueOf(playlist != null);
            case 11:
                MusicDatabase musicDatabase2 = (MusicDatabase) this.L$0;
                ResultKt.throwOnFailure(obj);
                musicDatabase2.getClass();
                DatabaseDao databaseDao2 = musicDatabase2.$$delegate_0;
                databaseDao2.clearPlaylist("LP_WEEKLY_MOST");
                databaseDao2.clearPlaylist("LP_MONTHLY_MOST");
                databaseDao2.delete(new PlaylistEntity("LP_WEEKLY_MOST", "", null, null, false, null, null, null, null, null, null, 16380));
                databaseDao2.delete(new PlaylistEntity("LP_MONTHLY_MOST", "", null, null, false, null, null, null, null, null, null, 16380));
                return unit;
            default:
                SharingCommand sharingCommand = (SharingCommand) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Boolean.valueOf(sharingCommand != SharingCommand.START);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Recomposer$join$2(int i, Continuation continuation, byte b) {
        super(i, continuation);
        this.$r8$classId = b;
    }
}
