/**
 * Generated by smali2java 1.0.0.558
 * Copyright (C) 2013 Hensence.com
 */

package com.mobcent.discuz.application;

import android.app.Application;
import java.util.List;
import android.app.Activity;
import android.os.Handler;

import com.litesuits.android.log.Log;
import com.mobcent.discuz.activity.LoginUtils;
import com.mobcent.discuz.base.constant.LocationProvider;

public class DiscuzApplication extends Application {
    public static final String TAG = "DiscuzApplication";
    public static DiscuzApplication _instance;
    public static boolean isDebug = true;
    private List<Activity> activityList;
    // private BaseResultModel<ConfigModel> configModel;
    private boolean isActivityTopic;
    private boolean isRateSucc;
    // private PayStateModel payStateModel;
    // private PermissionModel permissionModel;
    // private SettingModel settingModel;

    public void onCreate() {
        super.onCreate();
        Log.isPrint = true;
        _instance = this;
        LoginUtils.getInstance().init(this);
        LocationProvider.getInstance().init(this);
        /*MCLogUtil.e(TAG, "======DiscuzApplication======");
        MCLogUtil.isLog = 0x0;
        activityList = new ArrayList();
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
        _instance = this;
        try {
            LowestManager.getInstance().init(getApplicationContext(), new LowestConfigImpl(getApplicationContext()));
        } catch(Exception localException1) {
        }
        HeartBeatServiceHelper.startService(getApplicationContext());
        registNotificationListener();
        initImageLoader();
        String forumKey = SharedPreferencesDB.getInstance(getApplicationContext()).getForumKey();
        TCAgent.init(getApplicationContext(), "appbyme_" + forumKey, "appbyme");
        VMarkManager.getInstance().init(new VMarkConfigImpl(getApplicationContext()));
        UserManageHelper.getInstance(getApplicationContext()).registListener(new UserManageHelper.ChangeUserInfoListener(this) {

            public void change(boolean isLogin, UserInfoModel userInfoModel) {
                if(!isLogin) {
                    DbUserUtils.deleteAllUser(getApplicationContext());
                }
                if((isLogin) && (GotyeMsgHelper.isGotyeIM())) {
                    handler.post(new Runnable(this) {

                        public void run() {
                            GotyeMsgHelper.getInstance(getApplicationContext()).login();
                        }
                    });
                }
                DZPushHelper.bindPushToAnMiServer(getApplicationContext(), true);
            }
        });*/
    }

    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    /*public Activity getTopActivity() {
        if(!MCListUtils.isEmpty(activityList)) {
            return (Activity)activityList.get((activityList.size() - 0x1));
        }
        return null;
    }

    private void initImageLoader() {
        L.writeLogs(false);
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).imageScaleType(ImageScaleType.IN_SAMPLE_INT).bitmapConfig(Bitmap.Config.RGB_565).build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).threadPriority(0x3).denyCacheImageMultipleSizesInMemory().diskCacheFileNameGenerator(new Md5FileNameGenerator()).diskCacheSize(0x3200000).threadPoolSize(0x4).tasksProcessingOrder(QueueProcessingType.LIFO).writeDebugLogs().defaultDisplayImageOptions(options).build();
        ImageLoader.getInstance().init(config);
    }

    public BaseResultModel getConfigModel() {
        return configModel;
    }

    public void setConfigModel(BaseResultModel<ConfigModel> configModel) {
        if((configModel != null) && (!TextUtils.isEmpty(configModel.getVersion()))) {
            CrashHandler.SERVER_VERSION = configModel.getVersion();
        }
        configModel = configModel;
    }

    public ConfigModuleModel getModuleModel(long moduleId) {
        if((configModel != null) && (configModel.getData() != null)) {
            ConfigModel config = (ConfigModel)configModel.getData();
            return (ConfigModuleModel)config.getModuleMap().get(Long.valueOf(moduleId));
        }
        return null;
    }

    public boolean isRateSucc() {
        return isRateSucc;
    }

    public void setRateSucc(boolean isRateSucc) {
        isRateSucc = isRateSucc;
    }

    public void registNotificationListener() {
        MsgNotificationHelper.getInstance(getApplicationContext()).setIntentToNotification();
    }

    public void setSettingModel(SettingModel settingModel) {
        settingModel = settingModel;
    }

    public SettingModel getSettingModel() {
        if(settingModel == null) {
            SettingServiceImpl settingService = new SettingServiceImpl(getApplicationContext());
            return (SettingModel)settingService.getSettingByLocal().getData();
        }
        return settingModel;
    }

    public void setPermissionModel(PermissionModel permissionModel) {
        permissionModel = permissionModel;
    }

    public PermissionModel getPermissionModel() {
        return permissionModel;
    }

    public PayStateModel getPayStateModel() {
        return payStateModel;
    }

    public void setPayStateModel(PayStateModel payStateModel) {
        payStateModel = payStateModel;
    }

    public boolean isPayed() {
        if((payStateModel != null) && (payStateModel.isUserDefined())) {
            return true;
        }
        boolean localboolean1 = SharedPreferencesDB.getInstance(getApplicationContext()).getPayState() == null;
        return false;
    }
    private static boolean isLauching = 0x0;

    public boolean isPushTop(Activity activity) {
        if(isLauching) {
            return false;
        }
        if(MCActivityUtils.getActivitySize(activity) <= 0x1) {
            isLauching = 0x1;
            InitHelper.getInstance(activity).init(activity, ConfigOptHelper.getConfigId(activity), false, new RequestCalback(this, activity) {

                public void onPreExecute() {
                }

                public void onPostExecute(BaseResultModel<ConfigModel> result) {
                    access$102(false);
                    setConfigModel(result);
                    InitHelper.getInstance(activity).dispatchActivity(activity, "homeSkip", 0x0);
                }

                public void onPostExecute(PermissionModel permissionModel) {
                    setPermissionModel(permissionModel);
                }

                public void onPostExecute(SettingModel settingModel) {
                    setSettingModel(settingModel);
                }
            });
            return true;
        }
        return false;
    }*/
}
