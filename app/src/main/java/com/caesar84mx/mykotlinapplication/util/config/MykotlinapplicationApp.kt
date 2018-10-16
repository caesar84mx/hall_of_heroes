package com.caesar84mx.mykotlinapplication.util.config

import android.app.Application

/**
 * Created by Gabe on 10/11/18.
 */
class MykotlinapplicationApp: Application() {
    var globalConfigComponent: GlobalConfigComponent = DaggerGlobalConfigComponent.builder()
            .globalConfigModule(GlobalConfigModule())
            .build()
}