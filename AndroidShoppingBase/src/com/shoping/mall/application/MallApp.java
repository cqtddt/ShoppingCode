package com.shoping.mall.application;

import android.annotation.SuppressLint;
import android.app.Application;

import com.shoping.mall.exception.CrashHandler;
import com.shoping.mall.util.LogUtil;

public class MallApp extends Application {

	
	
	private static boolean isConnect;
	
	// 组件实例
	private static MallApp mMallApp;
	
	public static MallApp getInstance() {
		return mMallApp;
	}

	public boolean isRun;
	public boolean isDown;
	
	@Override
	public void onCreate() {
		super.onCreate();
		if(!LogUtil.isOutPutLog){
			CrashHandler crashHandler = CrashHandler.getInstance();
			crashHandler.init(this);
		}
		mMallApp = this;
		
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}

	@SuppressLint("NewApi")
	@Override
	public void onTrimMemory(int level) {
		super.onTrimMemory(level);
		switch (level) {
		case TRIM_MEMORY_UI_HIDDEN:
			
			break;

		default:
			break;
		}
	}

	public static boolean isConnect(){
		return isConnect;
	}
	
	public static void setConnect(boolean connect){
		isConnect = connect;
	}
}
