package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@TargetApi(11)
public final class zzrc extends Fragment implements zzrb {
    private static WeakHashMap<Activity, WeakReference<zzrc>> yZ = new WeakHashMap();
    private Map<String, zzra> za = new ArrayMap();
    private Bundle zb;
    private int zzbqm = 0;

    private void zzb(final String str, @NonNull final zzra com_google_android_gms_internal_zzra) {
        if (this.zzbqm > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ zzrc zd;

                public void run() {
                    if (this.zd.zzbqm >= 1) {
                        com_google_android_gms_internal_zzra.onCreate(this.zd.zb != null ? this.zd.zb.getBundle(str) : null);
                    }
                    if (this.zd.zzbqm >= 2) {
                        com_google_android_gms_internal_zzra.onStart();
                    }
                    if (this.zd.zzbqm >= 3) {
                        com_google_android_gms_internal_zzra.onStop();
                    }
                    if (this.zd.zzbqm >= 4) {
                        com_google_android_gms_internal_zzra.onDestroy();
                    }
                }
            });
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.zzrc zzt(android.app.Activity r3) {
        /*
        r0 = yZ;
        r0 = r0.get(r3);
        r0 = (java.lang.ref.WeakReference) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r0.get();
        r0 = (com.google.android.gms.internal.zzrc) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = r3.getFragmentManager();	 Catch:{ ClassCastException -> 0x0048 }
        r1 = "LifecycleFragmentImpl";
        r0 = r0.findFragmentByTag(r1);	 Catch:{ ClassCastException -> 0x0048 }
        r0 = (com.google.android.gms.internal.zzrc) r0;	 Catch:{ ClassCastException -> 0x0048 }
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r1 = r0.isRemoving();
        if (r1 == 0) goto L_0x003d;
    L_0x0027:
        r0 = new com.google.android.gms.internal.zzrc;
        r0.<init>();
        r1 = r3.getFragmentManager();
        r1 = r1.beginTransaction();
        r2 = "LifecycleFragmentImpl";
        r1 = r1.add(r0, r2);
        r1.commitAllowingStateLoss();
    L_0x003d:
        r1 = yZ;
        r2 = new java.lang.ref.WeakReference;
        r2.<init>(r0);
        r1.put(r3, r2);
        goto L_0x0012;
    L_0x0048:
        r0 = move-exception;
        r1 = new java.lang.IllegalStateException;
        r2 = "Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl";
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzrc.zzt(android.app.Activity):com.google.android.gms.internal.zzrc");
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (zzra dump : this.za.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (zzra onActivityResult : this.za.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzbqm = 1;
        this.zb = bundle;
        for (Entry entry : this.za.entrySet()) {
            ((zzra) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void onDestroy() {
        super.onStop();
        this.zzbqm = 4;
        for (zzra onDestroy : this.za.values()) {
            onDestroy.onDestroy();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.za.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((zzra) entry.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public void onStart() {
        super.onStop();
        this.zzbqm = 2;
        for (zzra onStart : this.za.values()) {
            onStart.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        this.zzbqm = 3;
        for (zzra onStop : this.za.values()) {
            onStop.onStop();
        }
    }

    public <T extends zzra> T zza(String str, Class<T> cls) {
        return (zzra) cls.cast(this.za.get(str));
    }

    public void zza(String str, @NonNull zzra com_google_android_gms_internal_zzra) {
        if (this.za.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.za.put(str, com_google_android_gms_internal_zzra);
        zzb(str, com_google_android_gms_internal_zzra);
    }

    public Activity zzasq() {
        return getActivity();
    }
}
