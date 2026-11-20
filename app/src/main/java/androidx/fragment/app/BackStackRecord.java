package androidx.fragment.app;

import io.ktor.sse.ServerSentEventKt;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BackStackRecord {
    public boolean mAddToBackStack;
    public int mBreadCrumbShortTitleRes;
    public CharSequence mBreadCrumbShortTitleText;
    public int mBreadCrumbTitleRes;
    public CharSequence mBreadCrumbTitleText;
    public int mEnterAnim;
    public int mExitAnim;
    public int mIndex;
    public final FragmentManager mManager;
    public String mName;
    public final ArrayList mOps;
    public int mPopEnterAnim;
    public int mPopExitAnim;
    public boolean mReorderingAllowed;
    public ArrayList mSharedElementSourceNames;
    public ArrayList mSharedElementTargetNames;
    public int mTransition;

    public BackStackRecord(FragmentManager fragmentManager) {
        fragmentManager.getFragmentFactory();
        FragmentHostCallback fragmentHostCallback = fragmentManager.mHost;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.mContext.getClassLoader();
        }
        this.mOps = new ArrayList();
        this.mReorderingAllowed = false;
        this.mIndex = -1;
        this.mManager = fragmentManager;
    }

    public final void bumpBackStackNesting(int i) {
        if (this.mAddToBackStack) {
            if (FragmentManager.isLoggingEnabled(2)) {
                toString();
            }
            ArrayList arrayList = this.mOps;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                FragmentTransaction$Op fragmentTransaction$Op = (FragmentTransaction$Op) arrayList.get(i2);
                Fragment fragment = fragmentTransaction$Op.mFragment;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Objects.toString(fragmentTransaction$Op.mFragment);
                        int i3 = fragmentTransaction$Op.mFragment.mBackStackNesting;
                    }
                }
            }
        }
    }

    public final void dump(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(false);
            if (this.mTransition != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
            }
            if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        ArrayList arrayList = this.mOps;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            FragmentTransaction$Op fragmentTransaction$Op = (FragmentTransaction$Op) arrayList.get(i);
            switch (fragmentTransaction$Op.mCmd) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + fragmentTransaction$Op.mCmd;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(ServerSentEventKt.SPACE);
            printWriter.println(fragmentTransaction$Op.mFragment);
            if (z) {
                if (fragmentTransaction$Op.mEnterAnim != 0 || fragmentTransaction$Op.mExitAnim != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(fragmentTransaction$Op.mEnterAnim));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(fragmentTransaction$Op.mExitAnim));
                }
                if (fragmentTransaction$Op.mPopEnterAnim != 0 || fragmentTransaction$Op.mPopExitAnim != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(fragmentTransaction$Op.mPopEnterAnim));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(fragmentTransaction$Op.mPopExitAnim));
                }
            }
        }
    }

    public final void generateOps(ArrayList arrayList, ArrayList arrayList2) {
        if (FragmentManager.isLoggingEnabled(2)) {
            toString();
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.mAddToBackStack) {
            FragmentManager fragmentManager = this.mManager;
            ArrayList arrayList3 = fragmentManager.mBackStack;
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                fragmentManager.mBackStack = arrayList3;
            }
            arrayList3.add(this);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mName != null) {
            sb.append(ServerSentEventKt.SPACE);
            sb.append(this.mName);
        }
        sb.append("}");
        return sb.toString();
    }
}
