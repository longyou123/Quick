package com.scjw.quick.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


import com.scjw.quick.R;
import com.scjw.quick.util.StatusBarUtil;
import com.scjw.quick.view.XToast;

/**
 * Created by 蒋文龙 on 2018/6/25.
 * Activity 基类
 */

public class BaseActivity extends Activity {
    protected Dialog dialog;
    protected TextView DTitle;
    protected ImageView DImg;
    private Animation animation;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this, Color.BLACK);
        animation = AnimationUtils.loadAnimation(this, R.anim.dialog_progress_anim);
        dialog = createLoadingDialogLt(this, "数据处理中,请稍等....");
    }

    /**
     * 提示对话框
     *
     * @param context 上下文
     * @param msg     内容
     */
    public void showToast(Context context, String msg) {
        if (!TextUtils.isEmpty(msg)) {
            XToast.create(context, msg).show();
        }
    }

    /**
     * 提示对话框 设置时间
     *
     * @param context 上下文
     * @param msg     内容
     * @param time    时间
     */
    public void showToast(Context context, String msg, int time) {
        if (!TextUtils.isEmpty(msg)) {
            XToast.create(context, msg, time).show();
        }
    }


    /**
     * 加载框
     *
     * @param context 上下文
     * @param msg     内容
     * @return
     */
    public Dialog createLoadingDialogLt(Context context, String msg) {

        Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);//dialog样式
        loadingDialog.setContentView(R.layout.dialog_layout);//dialog布局文件
        loadingDialog.setCanceledOnTouchOutside(false);//点击外部不允许关闭dialog
        DImg = (ImageView) loadingDialog.findViewById(R.id.ivProgress);
        DTitle = (TextView) loadingDialog.findViewById(R.id.tvText);
        DTitle.setText(msg);
        return loadingDialog;
    }


    /**
     * 设置显示值
     *
     * @param message 内容
     */
    protected void setShowMessage(String message) {
        if (DTitle != null)
            DTitle.setText(message);
    }


    /**
     * 显示Dialog
     *
     * @author JiangWenLong
     * created at 2018/6/25 16:08
     */
    protected void showDialog() {
        if (dialog != null)
            if (!dialog.isShowing()) {
                dialog.show();

                if (DImg != null)
                    DImg.startAnimation(animation);
            }

    }

    /**
     * 关闭 Dialog
     *
     * @author JiangWenLong
     * created at 2018/6/25 16:09
     */

    protected void dismissDialog() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }

    }
}
