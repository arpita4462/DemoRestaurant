package com.gmediasolutions.demorestaurant

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.gmediasolutions.demorestaurant.cache.ImagePipelineConfigFactory

class FrescoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this, ImagePipelineConfigFactory.getImagePipelineConfig(this))
    }

}
