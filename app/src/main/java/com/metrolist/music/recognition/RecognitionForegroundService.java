package com.metrolist.music.recognition;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.IBinder;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationManagerCompat;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import com.metrolist.music.DaggerApp_HiltComponents_SingletonC$SingletonCImpl;
import com.metrolist.music.MainActivity;
import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.entities.RecognitionHistory;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.metrolist.music.widget.MusicRecognizerWidgetReceiver;
import com.metrolist.shazamkit.models.RecognitionResult;
import com.metrolist.shazamkit.models.RecognitionStatus;
import com.yalantis.ucrop.R;
import dagger.hilt.EntryPoints;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.File;
import java.time.LocalDateTime;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.CharsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RecognitionForegroundService extends Service {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final SynchronizedLazyImpl imageLoader$delegate;
    public boolean keepNotificationOnStop;
    public StandaloneCoroutine pulseJob;
    public StandaloneCoroutine recognitionJob;
    public final ContextScope serviceScope;
    public StandaloneCoroutine statusJob;
    public boolean terminalStateHandled;

    /* JADX INFO: renamed from: com.metrolist.music.recognition.RecognitionForegroundService$saveWidgetSuccess$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public RecognitionResult L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            int i = RecognitionForegroundService.$r8$clinit;
            return RecognitionForegroundService.this.saveWidgetSuccess(null, this);
        }
    }

    public RecognitionForegroundService() {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        this.serviceScope = AwaitKt.CoroutineScope(MainDispatcherLoader.dispatcher.immediate.plus(AwaitKt.SupervisorJob$default()));
        this.imageLoader$delegate = new SynchronizedLazyImpl(new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 8, this));
    }

    public static void updateNotification$default(RecognitionForegroundService recognitionForegroundService, String str, String str2, PendingIntent pendingIntent, PendingIntent pendingIntent2, String str3, int i) {
        boolean z = (i & 4) == 0;
        PendingIntent pendingIntent3 = (i & 8) != 0 ? null : pendingIntent;
        PendingIntent pendingIntent4 = (i & 32) != 0 ? null : pendingIntent2;
        String str4 = (i & 64) != 0 ? null : str3;
        recognitionForegroundService.getClass();
        new NotificationManagerCompat(recognitionForegroundService).notify(9100, recognitionForegroundService.buildNotification(str, str2, z, pendingIntent3, null, pendingIntent4, str4));
    }

    public final Notification buildNotification(String str, String str2, boolean z, PendingIntent pendingIntent, Bitmap bitmap, PendingIntent pendingIntent2, String str3) {
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this, "recognition_channel");
        notificationCompat$Builder.mNotification.icon = R.drawable.ic_widget_mic;
        notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(str);
        notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(str2);
        notificationCompat$Builder.mPriority = -1;
        notificationCompat$Builder.setFlag(8, true);
        notificationCompat$Builder.setFlag(2, !z);
        notificationCompat$Builder.setFlag(16, z);
        notificationCompat$Builder.mContentIntent = pendingIntent;
        notificationCompat$Builder.setLargeIcon(bitmap);
        if (pendingIntent2 != null && str3 != null) {
            notificationCompat$Builder.addAction(str3, pendingIntent2);
        }
        Notification notificationBuild = notificationCompat$Builder.build();
        notificationBuild.getClass();
        return notificationBuild;
    }

    public final void finishWithMessage(int i) {
        if (this.terminalStateHandled) {
            return;
        }
        this.terminalStateHandled = true;
        String string = getString(R.string.recognize_music);
        string.getClass();
        String string2 = getString(i);
        string2.getClass();
        updateNotification$default(this, string, string2, null, null, null, 120);
        this.keepNotificationOnStop = true;
        stopForeground(2);
        stopSelf();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        NotificationChannel notificationChannel = new NotificationChannel("recognition_channel", getString(R.string.recognition_notification_channel_name), 2);
        notificationChannel.setDescription(getString(R.string.recognition_notification_channel_desc));
        notificationChannel.setShowBadge(false);
        notificationManager.createNotificationChannel(notificationChannel);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        StandaloneCoroutine standaloneCoroutine = this.recognitionJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        StandaloneCoroutine standaloneCoroutine2 = this.statusJob;
        if (standaloneCoroutine2 != null) {
            standaloneCoroutine2.cancel(null);
        }
        StandaloneCoroutine standaloneCoroutine3 = this.pulseJob;
        if (standaloneCoroutine3 != null) {
            standaloneCoroutine3.cancel(null);
        }
        AwaitKt.cancel(this.serviceScope, (CancellationException) null);
        if (!this.keepNotificationOnStop) {
            stopForeground(1);
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        Timber.Forest.tag("RecognitionFgService");
        Continuation continuation = null;
        ConnectionPool.d(intent != null ? intent.getAction() : null);
        String action = intent != null ? intent.getAction() : null;
        ContextScope contextScope = this.serviceScope;
        byte b = 0;
        byte b2 = 1;
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != -232793425) {
                if (iHashCode == 1373325109 && action.equals("com.metrolist.music.widget.recognizer.START")) {
                    StandaloneCoroutine standaloneCoroutine = this.recognitionJob;
                    if ((standaloneCoroutine != null && standaloneCoroutine.isActive()) || !startInForeground(true)) {
                        return 2;
                    }
                    StandaloneCoroutine standaloneCoroutine2 = this.recognitionJob;
                    if (standaloneCoroutine2 != null && standaloneCoroutine2.isActive()) {
                        return 2;
                    }
                    this.keepNotificationOnStop = false;
                    StandaloneCoroutine standaloneCoroutine3 = this.statusJob;
                    if (standaloneCoroutine3 != null) {
                        standaloneCoroutine3.cancel(null);
                    }
                    this.statusJob = null;
                    MusicRecognitionService musicRecognitionService = MusicRecognitionService.INSTANCE;
                    MusicRecognitionService.reset();
                    getSharedPreferences("recognizer_widget_prefs", 0).edit().putInt("state", 1).apply();
                    updateAllWidgets();
                    StandaloneCoroutine standaloneCoroutine4 = this.pulseJob;
                    if (standaloneCoroutine4 != null) {
                        standaloneCoroutine4.cancel(null);
                    }
                    this.pulseJob = AwaitKt.launch$default(contextScope, null, null, new LazyListState.AnonymousClass2(this, null), 3);
                    this.recognitionJob = AwaitKt.launch$default(contextScope, null, null, new RecognitionForegroundService$startWidgetRecognition$2(this, null), 3);
                    return 2;
                }
            } else if (action.equals("com.metrolist.music.widget.recognizer.STOP")) {
                StandaloneCoroutine standaloneCoroutine5 = this.recognitionJob;
                if (standaloneCoroutine5 != null) {
                    standaloneCoroutine5.cancel(null);
                }
                StandaloneCoroutine standaloneCoroutine6 = this.pulseJob;
                if (standaloneCoroutine6 != null) {
                    standaloneCoroutine6.cancel(null);
                }
                getSharedPreferences("recognizer_widget_prefs", 0).edit().putInt("state", 0).apply();
                getSharedPreferences("recognizer_widget_prefs", 0).edit().putInt("pulse_frame", 0).apply();
                updateAllWidgets();
                stopForeground(1);
                stopSelf();
                return 2;
            }
        }
        StandaloneCoroutine standaloneCoroutine7 = this.recognitionJob;
        if ((standaloneCoroutine7 != null && standaloneCoroutine7.isActive()) || !startInForeground(false)) {
            return 2;
        }
        StandaloneCoroutine standaloneCoroutine8 = this.recognitionJob;
        if (standaloneCoroutine8 != null && standaloneCoroutine8.isActive()) {
            return 2;
        }
        this.keepNotificationOnStop = false;
        this.terminalStateHandled = false;
        MusicRecognitionService musicRecognitionService2 = MusicRecognitionService.INSTANCE;
        MusicRecognitionService.reset();
        StandaloneCoroutine standaloneCoroutine9 = this.statusJob;
        if (standaloneCoroutine9 != null) {
            standaloneCoroutine9.cancel(null);
        }
        this.statusJob = AwaitKt.launch$default(contextScope, null, null, new RecognitionForegroundService$startRecognition$1(this, continuation, b), 3);
        this.recognitionJob = AwaitKt.launch$default(contextScope, null, null, new RecognitionForegroundService$startRecognition$1(this, continuation, b2), 3);
        return 2;
    }

    public final void renderStatus(RecognitionStatus recognitionStatus) {
        if (recognitionStatus != null) {
            if (recognitionStatus instanceof RecognitionStatus.Listening) {
                String string = getString(R.string.recognize_music);
                string.getClass();
                String string2 = getString(R.string.recognition_notification_listening);
                string2.getClass();
                updateNotification$default(this, string, string2, null, null, null, 124);
                return;
            }
            if (recognitionStatus instanceof RecognitionStatus.Processing) {
                String string3 = getString(R.string.recognize_music);
                string3.getClass();
                String string4 = getString(R.string.recognition_notification_processing);
                string4.getClass();
                updateNotification$default(this, string3, string4, null, null, null, 124);
                return;
            }
            if (recognitionStatus instanceof RecognitionStatus.Success) {
                RecognitionResult result = ((RecognitionStatus.Success) recognitionStatus).getResult();
                if (this.terminalStateHandled) {
                    return;
                }
                this.terminalStateHandled = true;
                Intent intent = new Intent(this, (Class<?>) MainActivity.class);
                intent.setAction("com.metrolist.music.action.RECOGNITION");
                intent.putExtra("recognition_track_id", result.getTrackId());
                intent.putExtra("recognition_title", result.getTitle());
                intent.putExtra("recognition_artist", result.getArtist());
                intent.setFlags(805306368);
                PendingIntent activity = PendingIntent.getActivity(this, 9101, intent, 201326592);
                updateNotification$default(this, result.getTitle(), result.getArtist(), activity, activity, getString(R.string.listen_on_metrolist), 16);
                AwaitKt.launch$default(this.serviceScope, null, null, new DataStoreKt$get$2((Object) result, (Object) this, (Object) activity, (Continuation) null, (byte) 6), 3);
                return;
            }
            if (recognitionStatus instanceof RecognitionStatus.NoMatch) {
                finishWithMessage(R.string.recognition_notification_no_match);
                return;
            } else if (recognitionStatus instanceof RecognitionStatus.Error) {
                finishWithMessage(R.string.recognition_notification_failed);
                return;
            } else if (recognitionStatus instanceof RecognitionStatus.Ready) {
                return;
            }
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
    }

    public final void saveWidgetFailure(int i, String str) {
        getSharedPreferences("recognizer_widget_prefs", 0).edit().putInt("state", i).putString("error_message", str).putString("cover_art_path", "").putInt("pulse_frame", 0).apply();
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0068  */
    /* JADX WARN: Code duplicated, block: B:36:0x0119  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARN: Type inference failed for: r5v0, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public final Object saveWidgetSuccess(RecognitionResult recognitionResult, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        RecognitionResult recognitionResult2;
        Object failure;
        String absolutePath;
        Unit unit = Unit.INSTANCE;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objWithContext = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        ?? r5 = 0;
        r5 = 0;
        byte b = 1;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                String coverArtHqUrl = recognitionResult.getCoverArtHqUrl();
                if (coverArtHqUrl == null) {
                    coverArtHqUrl = recognitionResult.getCoverArtUrl();
                }
                if (coverArtHqUrl != null) {
                    anonymousClass1.L$0 = recognitionResult;
                    anonymousClass1.label = 1;
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new RecognitionForegroundService$loadBitmap$2(this, coverArtHqUrl, r5, b), anonymousClass1);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objWithContext == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    recognitionResult2 = recognitionResult;
                } else {
                    recognitionResult2 = recognitionResult;
                }
                if (r5 == 0) {
                    r5 = absolutePath;
                    r5 = "";
                }
                r5 = absolutePath;
                getSharedPreferences("recognizer_widget_prefs", 0).edit().putInt("state", 3).putString("song_title", recognitionResult2.getTitle()).putString("artist_name", recognitionResult2.getArtist()).putString("cover_art_path", r5).putInt("pulse_frame", 0).apply();
                Context applicationContext = getApplicationContext();
                applicationContext.getClass();
                DatabaseDao databaseDao = (DatabaseDao) ((DaggerApp_HiltComponents_SingletonC$SingletonCImpl) ((RecognitionEntryPoint) EntryPoints.get(CharsKt.getApplication(applicationContext.getApplicationContext()), RecognitionEntryPoint.class))).provideDaoProvider.get();
                String trackId = recognitionResult2.getTrackId();
                String title = recognitionResult2.getTitle();
                String artist = recognitionResult2.getArtist();
                String album = recognitionResult2.getAlbum();
                String coverArtUrl = recognitionResult2.getCoverArtUrl();
                String coverArtHqUrl2 = recognitionResult2.getCoverArtHqUrl();
                String genre = recognitionResult2.getGenre();
                String releaseDate = recognitionResult2.getReleaseDate();
                String label = recognitionResult2.getLabel();
                String shazamUrl = recognitionResult2.getShazamUrl();
                String appleMusicUrl = recognitionResult2.getAppleMusicUrl();
                String spotifyUrl = recognitionResult2.getSpotifyUrl();
                String isrc = recognitionResult2.getIsrc();
                String youtubeVideoId = recognitionResult2.getYoutubeVideoId();
                LocalDateTime localDateTimeNow = LocalDateTime.now();
                localDateTimeNow.getClass();
                databaseDao.insert(new RecognitionHistory(trackId, title, artist, album, coverArtUrl, coverArtHqUrl2, genre, releaseDate, label, shazamUrl, appleMusicUrl, spotifyUrl, isrc, youtubeVideoId, localDateTimeNow));
                MusicRecognitionService.resultSavedExternally = true;
                failure = unit;
                if (Result.m1866exceptionOrNullimpl(failure) != null) {
                    Timber.Forest.getClass();
                    ConnectionPool.e$1(new Object[0]);
                }
                return unit;
            }
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            recognitionResult2 = anonymousClass1.L$0;
            ResultKt.throwOnFailure(objWithContext);
            Context applicationContext2 = getApplicationContext();
            applicationContext2.getClass();
            DatabaseDao databaseDao2 = (DatabaseDao) ((DaggerApp_HiltComponents_SingletonC$SingletonCImpl) ((RecognitionEntryPoint) EntryPoints.get(CharsKt.getApplication(applicationContext2.getApplicationContext()), RecognitionEntryPoint.class))).provideDaoProvider.get();
            String trackId2 = recognitionResult2.getTrackId();
            String title2 = recognitionResult2.getTitle();
            String artist2 = recognitionResult2.getArtist();
            String album2 = recognitionResult2.getAlbum();
            String coverArtUrl2 = recognitionResult2.getCoverArtUrl();
            String coverArtHqUrl3 = recognitionResult2.getCoverArtHqUrl();
            String genre2 = recognitionResult2.getGenre();
            String releaseDate2 = recognitionResult2.getReleaseDate();
            String label2 = recognitionResult2.getLabel();
            String shazamUrl2 = recognitionResult2.getShazamUrl();
            String appleMusicUrl2 = recognitionResult2.getAppleMusicUrl();
            String spotifyUrl2 = recognitionResult2.getSpotifyUrl();
            String isrc2 = recognitionResult2.getIsrc();
            String youtubeVideoId2 = recognitionResult2.getYoutubeVideoId();
            LocalDateTime localDateTimeNow2 = LocalDateTime.now();
            localDateTimeNow2.getClass();
            databaseDao2.insert(new RecognitionHistory(trackId2, title2, artist2, album2, coverArtUrl2, coverArtHqUrl3, genre2, releaseDate2, label2, shazamUrl2, appleMusicUrl2, spotifyUrl2, isrc2, youtubeVideoId2, localDateTimeNow2));
            MusicRecognitionService.resultSavedExternally = true;
            failure = unit;
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        File file = (File) objWithContext;
        if (file != null) {
            absolutePath = file.getAbsolutePath();
        }
        if (r5 == 0) {
            r5 = absolutePath;
            r5 = "";
        }
        r5 = absolutePath;
        getSharedPreferences("recognizer_widget_prefs", 0).edit().putInt("state", 3).putString("song_title", recognitionResult2.getTitle()).putString("artist_name", recognitionResult2.getArtist()).putString("cover_art_path", r5).putInt("pulse_frame", 0).apply();
        if (Result.m1866exceptionOrNullimpl(failure) != null) {
            Timber.Forest.getClass();
            ConnectionPool.e$1(new Object[0]);
        }
        return unit;
    }

    public final boolean startInForeground(boolean z) {
        PendingIntent service;
        if (z) {
            Intent intent = new Intent(this, (Class<?>) RecognitionForegroundService.class);
            intent.setAction("com.metrolist.music.widget.recognizer.STOP");
            service = PendingIntent.getService(this, 1, intent, 201326592);
        } else {
            service = null;
        }
        PendingIntent activity = z ? PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) MainActivity.class), 201326592) : null;
        String string = getString(z ? R.string.widget_recognizer_listening : R.string.recognize_music);
        string.getClass();
        String string2 = getString(z ? R.string.widget_recognizer_notification_text : R.string.recognition_notification_listening);
        string2.getClass();
        Notification notificationBuildNotification = buildNotification(string, string2, false, activity, null, service, service != null ? getString(android.R.string.cancel) : null);
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                startForeground(9100, notificationBuildNotification, 128);
                return true;
            }
            startForeground(9100, notificationBuildNotification);
            return true;
        } catch (SecurityException unused) {
            Timber.Forest.getClass();
            ConnectionPool.w$1(new Object[0]);
            stopSelf();
            return false;
        } catch (RuntimeException e) {
            if (Build.VERSION.SDK_INT < 31 || !e.getClass().getName().equals("android.app.ForegroundServiceStartNotAllowedException")) {
                throw e;
            }
            Timber.Forest.getClass();
            ConnectionPool.w$1(new Object[0]);
            stopSelf();
            return false;
        }
    }

    public final void updateAllWidgets() {
        Intent intent = new Intent(this, (Class<?>) MusicRecognizerWidgetReceiver.class);
        intent.setAction("com.metrolist.music.widget.recognizer.UPDATE");
        sendBroadcast(intent);
    }
}
