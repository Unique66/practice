package com.sxh.jvm.gc;/**
 * Created by SXH on 2019/7/27 23:45.
 */

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author SXH
 * @description
 * @date 2019/7/27 23:45.
 */
public class NormalObjectWeakReference extends WeakReference<NormalObject> {
    public String name;

    public NormalObjectWeakReference(NormalObject normalObject, ReferenceQueue rq) {
        super(normalObject, rq);
        this.name = normalObject.name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing NormalObjectWeakReference " + name);
    }
}
