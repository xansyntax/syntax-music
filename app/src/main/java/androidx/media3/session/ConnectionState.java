package androidx.media3.session;

import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.media3.common.Player;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionState {
    public static final String FIELD_COMMAND_BUTTONS_FOR_MEDIA_ITEMS;
    public static final String FIELD_CUSTOM_LAYOUT;
    public static final String FIELD_IN_PROCESS_BINDER;
    public static final String FIELD_LIBRARY_VERSION;
    public static final String FIELD_MEDIA_BUTTON_PREFERENCES;
    public static final String FIELD_PLATFORM_TOKEN;
    public static final String FIELD_PLAYER_COMMANDS_FROM_PLAYER;
    public static final String FIELD_PLAYER_COMMANDS_FROM_SESSION;
    public static final String FIELD_PLAYER_INFO;
    public static final String FIELD_SESSION_ACTIVITY;
    public static final String FIELD_SESSION_BINDER;
    public static final String FIELD_SESSION_COMMANDS;
    public static final String FIELD_SESSION_EXTRAS;
    public static final String FIELD_SESSION_INTERFACE_VERSION;
    public static final String FIELD_TOKEN_EXTRAS;
    public final ImmutableList commandButtonsForMediaItems;
    public final ImmutableList customLayout;
    public final int libraryVersion;
    public final ImmutableList mediaButtonPreferences;
    public final MediaSession.Token platformToken;
    public final Player.Commands playerCommandsFromPlayer;
    public final Player.Commands playerCommandsFromSession;
    public final PlayerInfo playerInfo;
    public final PendingIntent sessionActivity;
    public final IMediaSession sessionBinder;
    public final SessionCommands sessionCommands;
    public final Bundle sessionExtras;
    public final int sessionInterfaceVersion;
    public final Bundle tokenExtras;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class InProcessBinder extends Binder {
        public InProcessBinder() {
        }
    }

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_LIBRARY_VERSION = Integer.toString(0, 36);
        FIELD_SESSION_BINDER = Integer.toString(1, 36);
        FIELD_SESSION_ACTIVITY = Integer.toString(2, 36);
        FIELD_CUSTOM_LAYOUT = Integer.toString(9, 36);
        FIELD_MEDIA_BUTTON_PREFERENCES = Integer.toString(14, 36);
        FIELD_COMMAND_BUTTONS_FOR_MEDIA_ITEMS = Integer.toString(13, 36);
        FIELD_SESSION_COMMANDS = Integer.toString(3, 36);
        FIELD_PLAYER_COMMANDS_FROM_SESSION = Integer.toString(4, 36);
        FIELD_PLAYER_COMMANDS_FROM_PLAYER = Integer.toString(5, 36);
        FIELD_TOKEN_EXTRAS = Integer.toString(6, 36);
        FIELD_SESSION_EXTRAS = Integer.toString(11, 36);
        FIELD_PLAYER_INFO = Integer.toString(7, 36);
        FIELD_SESSION_INTERFACE_VERSION = Integer.toString(8, 36);
        FIELD_IN_PROCESS_BINDER = Integer.toString(10, 36);
        FIELD_PLATFORM_TOKEN = Integer.toString(12, 36);
    }

    public ConnectionState(int i, int i2, IMediaSession iMediaSession, PendingIntent pendingIntent, ImmutableList immutableList, ImmutableList immutableList2, ImmutableList immutableList3, SessionCommands sessionCommands, Player.Commands commands, Player.Commands commands2, Bundle bundle, Bundle bundle2, PlayerInfo playerInfo, MediaSession.Token token) {
        this.libraryVersion = i;
        this.sessionInterfaceVersion = i2;
        this.sessionBinder = iMediaSession;
        this.sessionActivity = pendingIntent;
        this.customLayout = immutableList;
        this.mediaButtonPreferences = immutableList2;
        this.commandButtonsForMediaItems = immutableList3;
        this.sessionCommands = sessionCommands;
        this.playerCommandsFromSession = commands;
        this.playerCommandsFromPlayer = commands2;
        this.tokenExtras = bundle;
        this.sessionExtras = bundle2;
        this.playerInfo = playerInfo;
        this.platformToken = token;
    }

    public static ConnectionState fromBundle(Bundle bundle) {
        RegularImmutableList regularImmutableListBuild;
        RegularImmutableList regularImmutableListBuild2;
        RegularImmutableList regularImmutableListBuild3;
        IMediaSession iMediaSession;
        IMediaSession iMediaSession2;
        IBinder binder = bundle.getBinder(FIELD_IN_PROCESS_BINDER);
        if (binder instanceof InProcessBinder) {
            return ConnectionState.this;
        }
        int i = bundle.getInt(FIELD_LIBRARY_VERSION, 0);
        int i2 = bundle.getInt(FIELD_SESSION_INTERFACE_VERSION, 0);
        IBinder binder2 = bundle.getBinder(FIELD_SESSION_BINDER);
        binder2.getClass();
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(FIELD_SESSION_ACTIVITY);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_CUSTOM_LAYOUT);
        if (parcelableArrayList != null) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i3 = 0; i3 < parcelableArrayList.size(); i3++) {
                Bundle bundle2 = (Bundle) parcelableArrayList.get(i3);
                bundle2.getClass();
                builder.add((Object) CommandButton.fromBundle(i2, bundle2));
            }
            regularImmutableListBuild = builder.build();
        } else {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            regularImmutableListBuild = RegularImmutableList.EMPTY;
        }
        RegularImmutableList regularImmutableList = regularImmutableListBuild;
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(FIELD_MEDIA_BUTTON_PREFERENCES);
        if (parcelableArrayList2 != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i4 = 0; i4 < parcelableArrayList2.size(); i4++) {
                Bundle bundle3 = (Bundle) parcelableArrayList2.get(i4);
                bundle3.getClass();
                builder2.add((Object) CommandButton.fromBundle(i2, bundle3));
            }
            regularImmutableListBuild2 = builder2.build();
        } else {
            ImmutableList.Itr itr2 = ImmutableList.EMPTY_ITR;
            regularImmutableListBuild2 = RegularImmutableList.EMPTY;
        }
        RegularImmutableList regularImmutableList2 = regularImmutableListBuild2;
        ArrayList parcelableArrayList3 = bundle.getParcelableArrayList(FIELD_COMMAND_BUTTONS_FOR_MEDIA_ITEMS);
        if (parcelableArrayList3 != null) {
            ImmutableList.Builder builder3 = ImmutableList.builder();
            for (int i5 = 0; i5 < parcelableArrayList3.size(); i5++) {
                Bundle bundle4 = (Bundle) parcelableArrayList3.get(i5);
                bundle4.getClass();
                builder3.add((Object) CommandButton.fromBundle(i2, bundle4));
            }
            regularImmutableListBuild3 = builder3.build();
        } else {
            ImmutableList.Itr itr3 = ImmutableList.EMPTY_ITR;
            regularImmutableListBuild3 = RegularImmutableList.EMPTY;
        }
        RegularImmutableList regularImmutableList3 = regularImmutableListBuild3;
        Bundle bundle5 = bundle.getBundle(FIELD_SESSION_COMMANDS);
        SessionCommands sessionCommandsFromBundle = bundle5 == null ? SessionCommands.EMPTY : SessionCommands.fromBundle(bundle5);
        Bundle bundle6 = bundle.getBundle(FIELD_PLAYER_COMMANDS_FROM_PLAYER);
        Player.Commands commandsFromBundle = bundle6 == null ? Player.Commands.EMPTY : Player.Commands.fromBundle(bundle6);
        Bundle bundle7 = bundle.getBundle(FIELD_PLAYER_COMMANDS_FROM_SESSION);
        Player.Commands commandsFromBundle2 = bundle7 == null ? Player.Commands.EMPTY : Player.Commands.fromBundle(bundle7);
        Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle.getBundle(FIELD_TOKEN_EXTRAS));
        Bundle bundleConvertToNullIfInvalid2 = Util.convertToNullIfInvalid(bundle.getBundle(FIELD_SESSION_EXTRAS));
        Bundle bundle8 = bundle.getBundle(FIELD_PLAYER_INFO);
        PlayerInfo playerInfoFromBundle = bundle8 == null ? PlayerInfo.DEFAULT : PlayerInfo.fromBundle(i2, bundle8);
        MediaSession.Token token = (MediaSession.Token) bundle.getParcelable(FIELD_PLATFORM_TOKEN);
        Bundle bundle9 = bundleConvertToNullIfInvalid2;
        int i6 = MediaSessionStub.$r8$clinit;
        IInterface iInterfaceQueryLocalInterface = binder2.queryLocalInterface("androidx.media3.session.IMediaSession");
        if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMediaSession)) {
            IMediaSession$Stub$Proxy iMediaSession$Stub$Proxy = new IMediaSession$Stub$Proxy();
            iMediaSession$Stub$Proxy.mRemote = binder2;
            iMediaSession = iMediaSession$Stub$Proxy;
        } else {
            iMediaSession2 = (IMediaSession) iInterfaceQueryLocalInterface;
        }
        if (bundleConvertToNullIfInvalid == null) {
            iMediaSession = iMediaSession2;
            bundleConvertToNullIfInvalid = Bundle.EMPTY;
        }
        iMediaSession = iMediaSession2;
        Bundle bundle10 = bundleConvertToNullIfInvalid;
        if (bundle9 == null) {
            bundle9 = Bundle.EMPTY;
        }
        return new ConnectionState(i, i2, iMediaSession, pendingIntent, regularImmutableList, regularImmutableList2, regularImmutableList3, sessionCommandsFromBundle, commandsFromBundle2, commandsFromBundle, bundle10, bundle9, playerInfoFromBundle, token);
    }

    public final Bundle toBundleForRemoteProcess(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_LIBRARY_VERSION, this.libraryVersion);
        bundle.putBinder(FIELD_SESSION_BINDER, this.sessionBinder.asBinder());
        bundle.putParcelable(FIELD_SESSION_ACTIVITY, this.sessionActivity);
        ImmutableList immutableList = this.customLayout;
        boolean zIsEmpty = immutableList.isEmpty();
        String str = FIELD_CUSTOM_LAYOUT;
        if (!zIsEmpty) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(immutableList.size());
            int size = immutableList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = immutableList.get(i2);
                i2++;
                arrayList.add(((CommandButton) obj).toBundle(i));
            }
            bundle.putParcelableArrayList(str, arrayList);
        }
        ImmutableList immutableList2 = this.mediaButtonPreferences;
        if (!immutableList2.isEmpty()) {
            if (i >= 7) {
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(immutableList2.size());
                int size2 = immutableList2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = immutableList2.get(i3);
                    i3++;
                    arrayList2.add(((CommandButton) obj2).toBundle(i));
                }
                bundle.putParcelableArrayList(FIELD_MEDIA_BUTTON_PREFERENCES, arrayList2);
            } else {
                RegularImmutableList customLayoutFromMediaButtonPreferences = CommandButton.getCustomLayoutFromMediaButtonPreferences(immutableList2, true, true, 9);
                ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>(customLayoutFromMediaButtonPreferences.size);
                ImmutableList.Itr itrListIterator = customLayoutFromMediaButtonPreferences.listIterator(0);
                while (itrListIterator.hasNext()) {
                    arrayList3.add(((CommandButton) itrListIterator.next()).toBundle(i));
                }
                bundle.putParcelableArrayList(str, arrayList3);
            }
        }
        ImmutableList immutableList3 = this.commandButtonsForMediaItems;
        if (!immutableList3.isEmpty()) {
            ArrayList<? extends Parcelable> arrayList4 = new ArrayList<>(immutableList3.size());
            int size3 = immutableList3.size();
            int i4 = 0;
            while (i4 < size3) {
                Object obj3 = immutableList3.get(i4);
                i4++;
                arrayList4.add(((CommandButton) obj3).toBundle(i));
            }
            bundle.putParcelableArrayList(FIELD_COMMAND_BUTTONS_FOR_MEDIA_ITEMS, arrayList4);
        }
        SessionCommands sessionCommands = this.sessionCommands;
        sessionCommands.getClass();
        Bundle bundle2 = new Bundle();
        ArrayList<? extends Parcelable> arrayList5 = new ArrayList<>();
        UnmodifiableIterator it = sessionCommands.commands.iterator();
        while (it.hasNext()) {
            arrayList5.add(((SessionCommand) it.next()).toBundle());
        }
        bundle2.putParcelableArrayList(SessionCommands.FIELD_SESSION_COMMANDS, arrayList5);
        bundle.putBundle(FIELD_SESSION_COMMANDS, bundle2);
        String str2 = FIELD_PLAYER_COMMANDS_FROM_SESSION;
        Player.Commands commands = this.playerCommandsFromSession;
        bundle.putBundle(str2, commands.toBundle());
        String str3 = FIELD_PLAYER_COMMANDS_FROM_PLAYER;
        Player.Commands commands2 = this.playerCommandsFromPlayer;
        bundle.putBundle(str3, commands2.toBundle());
        bundle.putBundle(FIELD_TOKEN_EXTRAS, this.tokenExtras);
        bundle.putBundle(FIELD_SESSION_EXTRAS, this.sessionExtras);
        bundle.putBundle(FIELD_PLAYER_INFO, this.playerInfo.filterByAvailableCommands(MediaUtils.intersect(commands, commands2), false, false).toBundleForRemoteProcess(i));
        bundle.putInt(FIELD_SESSION_INTERFACE_VERSION, this.sessionInterfaceVersion);
        MediaSession.Token token = this.platformToken;
        if (token != null) {
            bundle.putParcelable(FIELD_PLATFORM_TOKEN, token);
        }
        return bundle;
    }
}
