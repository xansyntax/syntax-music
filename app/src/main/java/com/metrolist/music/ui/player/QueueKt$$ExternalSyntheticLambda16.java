package com.metrolist.music.ui.player;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.foundation.relocation.BringIntoViewRequesterImpl;
import androidx.compose.material3.TimePickerState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.platform.AndroidUriHandler;
import androidx.compose.ui.platform.UriHandler;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YouTubeAccount;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.innertube.pages.HomePage;
import com.metrolist.innertube.pages.MoodAndGenres;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.listentogether.ListenTogetherServer;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.models.ItemsPage;
import com.metrolist.music.models.SimilarRecommendation;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.screens.CrashActivity;
import com.metrolist.music.ui.screens.search.OnlineSearchResultKt;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.InnerTubeXPlayer$$ExternalSyntheticLambda3;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.viewmodels.ArtistViewModel;
import com.metrolist.music.viewmodels.CachePlaylistViewModel;
import com.metrolist.music.viewmodels.HomeViewModel;
import com.metrolist.music.viewmodels.LibraryAlbumsViewModel;
import com.metrolist.music.viewmodels.LibraryArtistsViewModel;
import com.metrolist.music.viewmodels.LibraryMixViewModel;
import com.metrolist.music.viewmodels.LibraryPlaylistsViewModel;
import com.metrolist.music.viewmodels.LibrarySongsViewModel;
import com.metrolist.music.viewmodels.LocalFilter;
import com.metrolist.music.viewmodels.LocalSearchViewModel;
import com.metrolist.music.viewmodels.OnlineSearchViewModel;
import com.metrolist.shazamkit.models.RecognitionResult;
import com.yalantis.ucrop.R;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueKt$$ExternalSyntheticLambda16 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda16(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x0276, code lost:
    
        if ((r15 instanceof com.metrolist.music.db.entities.Playlist) != false) goto L84;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke() throws IOException {
        String str;
        byte b = this.$r8$classId;
        boolean z = true;
        int i = 0;
        String str2 = null;
        Object[] objArr = 0;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                ((ParcelableSnapshotMutableFloatState) obj).setFloatValue(((Number) ((DataStoreKt$rememberPreference$1$1) obj2).getValue()).floatValue());
                return unit;
            case 1:
                ((MusicDatabase) obj2).query(new MimesKt$$ExternalSyntheticLambda0((byte) 7, (AlbumWithSongs) obj));
                return unit;
            case 2:
                MenuState menuState = (MenuState) obj2;
                menuState.show(new ComposableLambdaImpl(true, -1424967858, new AlbumMenuKt$$ExternalSyntheticLambda11((AlbumWithSongs) obj, menuState, (byte) 16)));
                return unit;
            case 3:
                CrashActivity crashActivity = (CrashActivity) obj2;
                String str3 = (String) obj;
                int i2 = CrashActivity.$r8$clinit;
                try {
                    File file = new File(crashActivity.getCacheDir(), "auralys_crash_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date()) + ".txt");
                    FilesKt.writeText$default(file, str3);
                    Uri uriForFile = FileProvider.getUriForFile(crashActivity, file, crashActivity.getPackageName() + ".FileProvider");
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.STREAM", uriForFile);
                    intent.putExtra("android.intent.extra.SUBJECT", crashActivity.getString(R.string.crash_report_subject));
                    intent.addFlags(1);
                    crashActivity.startActivity(Intent.createChooser(intent, crashActivity.getString(R.string.crash_share_title)));
                    break;
                } catch (Exception unused) {
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.setType("text/plain");
                    intent2.putExtra("android.intent.extra.TEXT", str3);
                    intent2.putExtra("android.intent.extra.SUBJECT", crashActivity.getString(R.string.crash_report_subject));
                    crashActivity.startActivity(Intent.createChooser(intent2, crashActivity.getString(R.string.crash_share_title)));
                }
                return unit;
            case 4:
                ((Function1) obj2).invoke((SongItem) obj);
                return unit;
            case 5:
                ((HomeViewModel) obj2).toggleChip((HomePage.Chip) ((MutableState) obj).getValue());
                return unit;
            case 6:
                NavHostController navHostController = (NavHostController) obj;
                LocalItem localItem = ((SimilarRecommendation) obj2).title;
                if (localItem != null) {
                    if (!(localItem instanceof Song)) {
                        if (!(localItem instanceof Album)) {
                            if (localItem instanceof Artist) {
                                Format$$ExternalSyntheticOutline0.m("artist/", ((Artist) localItem).artist.id, navHostController);
                            }
                            break;
                        } else {
                            str = ((Album) localItem).album.id;
                        }
                        return unit;
                    }
                    AlbumEntity albumEntity = ((Song) localItem).album;
                    albumEntity.getClass();
                    str = albumEntity.id;
                    Format$$ExternalSyntheticOutline0.m("album/", str, navHostController);
                    return unit;
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            case 7:
                AwaitKt.launch$default((CoroutineScope) obj2, null, null, new SyncUtils.AnonymousClass2((BringIntoViewRequesterImpl) obj, objArr == true ? 1 : 0, (byte) 26), 3);
                return unit;
            case 8:
                Listentogether.UserInfo userInfo = (Listentogether.UserInfo) obj;
                String userId = userInfo.getUserId();
                userId.getClass();
                String username = userInfo.getUsername();
                username.getClass();
                ((Function2) obj2).invoke(userId, username);
                return unit;
            case 9:
                ((MutableState) obj).setValue((YouTubeAccount) obj2);
                return unit;
            case 10:
                BrowseEndpoint browseEndpoint = ((MoodAndGenres.Item) obj).endpoint;
                NavHostController.navigate$default((NavHostController) obj2, "youtube_browse/" + browseEndpoint.browseId + "?params=" + browseEndpoint.params);
                return unit;
            case 11:
                Context context = (Context) obj;
                ArtistPage artistPage = (ArtistPage) ((ArtistViewModel) obj2).artistPage$delegate.getValue();
                if (artistPage != null) {
                    String strM = Fragment$5$$ExternalSyntheticOutline0.m("https://music.youtube.com/channel/", artistPage.artist.id);
                    Object systemService = context.getSystemService("clipboard");
                    systemService.getClass();
                    ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Artist Link", strM));
                    Toast.makeText(context, R.string.link_copied, 0).show();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((MutableState) obj).setValue(Boolean.FALSE);
                StateFlowImpl stateFlowImpl = ((LibraryAlbumsViewModel) obj2)._searchQuery;
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, "");
                return unit;
            case 13:
                ((MutableState) obj).setValue(Boolean.FALSE);
                StateFlowImpl stateFlowImpl2 = ((LibraryArtistsViewModel) obj2)._searchQuery;
                stateFlowImpl2.getClass();
                stateFlowImpl2.updateState(null, "");
                return unit;
            case 14:
                ((MutableState) obj).setValue(Boolean.FALSE);
                StateFlowImpl stateFlowImpl3 = ((LibraryMixViewModel) obj2)._searchQuery;
                stateFlowImpl3.getClass();
                stateFlowImpl3.updateState(null, "");
                return unit;
            case 15:
                ((MutableState) obj).setValue(Boolean.FALSE);
                StateFlowImpl stateFlowImpl4 = ((LibraryPlaylistsViewModel) obj2)._searchQuery;
                stateFlowImpl4.getClass();
                stateFlowImpl4.updateState(null, "");
                return unit;
            case 16:
                ((MutableState) obj).setValue(Boolean.FALSE);
                StateFlowImpl stateFlowImpl5 = ((LibrarySongsViewModel) obj2)._searchQuery;
                stateFlowImpl5.getClass();
                stateFlowImpl5.updateState(null, "");
                return unit;
            case 17:
                CachePlaylistViewModel cachePlaylistViewModel = (CachePlaylistViewModel) obj2;
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                int size = arrayList.size();
                while (i < size) {
                    Object obj3 = arrayList.get(i);
                    i++;
                    arrayList2.add(((Song) obj3).song.id);
                }
                cachePlaylistViewModel.removeSongsFromCache(arrayList2);
                return unit;
            case 18:
                PodcastItem podcastItem = (PodcastItem) obj2;
                NavHostController navHostController2 = (NavHostController) obj;
                String str4 = podcastItem.channelId;
                if (str4 == null) {
                    com.metrolist.innertube.models.Artist artist = podcastItem.author;
                    if (artist != null) {
                        str2 = artist.id;
                    }
                } else {
                    str2 = str4;
                }
                if (str2 != null) {
                    NavHostController.navigate$default(navHostController2, "artist/" + str2 + "?isPodcastChannel=true");
                }
                return unit;
            case 19:
                ((Function1) obj2).invoke((RecognitionResult) obj);
                return unit;
            case 20:
                ((LocalSearchViewModel) obj2).filter.setValue((LocalFilter) obj);
                return unit;
            case 21:
                OnlineSearchViewModel onlineSearchViewModel = (OnlineSearchViewModel) obj;
                String strOnlineSearchResult$lambda$24 = OnlineSearchResultKt.OnlineSearchResult$lambda$24((MutableState) obj2);
                if (strOnlineSearchResult$lambda$24 != null) {
                    return (ItemsPage) onlineSearchViewModel.viewStateMap.get(strOnlineSearchResult$lambda$24);
                }
                return null;
            case 22:
                TimePickerState timePickerState = (TimePickerState) obj;
                ((Function2) obj2).invoke(Integer.valueOf(timePickerState.getHour()), Integer.valueOf(timePickerState.getMinute()));
                return unit;
            case 23:
                ((MutableState) obj).setValue(Boolean.FALSE);
                ((Function1) obj2).invoke(Boolean.TRUE);
                return unit;
            case 24:
                ((ManagedActivityResultLauncher) obj2).launch(((String) obj) + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".backup");
                return unit;
            case 25:
                ((AndroidUriHandler) ((UriHandler) obj2)).openUri((String) obj);
                return unit;
            case 26:
                String str5 = (String) obj;
                if (StringsKt.isBlank((String) obj2) && StringsKt.isBlank(str5)) {
                    z = false;
                }
                return Stack.mutableStateOf$default(Boolean.valueOf(z));
            case 27:
                MutableState mutableState = (MutableState) obj;
                mutableState.setValue(((String) mutableState.getValue()) + ((String) obj2));
                return unit;
            case 28:
                Context context2 = (Context) obj;
                String strJoinToString$default = CollectionsKt.joinToString$default((List) obj2, "\n", null, null, new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 20), 30);
                Object systemService2 = context2.getSystemService("clipboard");
                systemService2.getClass();
                ((ClipboardManager) systemService2).setPrimaryClip(ClipData.newPlainText("ListenTogetherLogs", strJoinToString$default));
                Toast.makeText(context2, R.string.copied_to_clipboard, 0).show();
                return unit;
            default:
                ((Function1) obj2).invoke((ListenTogetherServer) obj);
                return unit;
        }
    }
}
