package com.example.cardreader;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;

import com.orhanobut.logger.Logger;
import com.syc.usbrfidreader.ICReaderApi;

/**
 * Created by Roy12 on 2017/11/23.
 */

public class CardReaderHelper {

    public String readCard(final ICReaderApi api, final Context context) {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                readCard(api,context);
            }
        };
        String text = "";
        byte mode = 0;
        byte blk_add = 16;
        byte mNum_blk = 1;
        byte[] snr = getByteArray("FF FF FF FF FF FF");
        byte[] buffer = new byte[16 * mNum_blk];

        int result = api.API_PCDRead(mode, blk_add, mNum_blk, snr, buffer);

        text = showStatue(text, result);
        if (result == 0) {
            text = showCardNum(text, snr);
            //Logger.d("if statement run");
            showDialog(text,context);
            handler.removeCallbacks(runnable);
            handler.postDelayed(runnable, 1500);
            return text;
        } else {
            Logger.d("else statement run, text == %s", text);
            // text = showStatue(text, snr[0]);
            handler.postDelayed(runnable, 500);
            //readCard();
        }
        return null;
    }

    private String showCardNum(String text, byte[] data) {
        StringBuilder dStr = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            dStr.append(String.format("%02x ", data[i]));
            Logger.d("dStr == %s", dStr);

        }
        //Logger.d("dStr == 2%s",dStr);
        text += ("卡号:\n" + dStr.toString().toUpperCase() + '\n');
        return text;
    }

    void showDialog(String text,Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("结果");
        builder.setMessage(text);
        builder.setPositiveButton("确认", null);
        final AlertDialog dialog = builder.create();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        }, 1000);
        dialog.show();

    }

    private byte[] getByteArray(String str) {
        str = str.replaceAll("[^0-9A-F]", "");
        byte[] ans = new byte[str.length() / 2];
        for (int i = 0; i < str.length(); i += 2) {
            ans[i / 2] = (byte) Integer.parseInt(str.substring(i, i + 2), 16);
        }
        return ans;
    }

    private String showStatue(String text, int Code) {
        String msg = null;
        switch (Code) {
            case 0x00:
                msg = "命令执行成功 .....";
                break;
            case 0x01:
                msg = "命令操作失败 .....";
                break;
            case 0x02:
                msg = "地址校验错误 .....";
                break;
            case 0x03:
                msg = "没有选择COM口 .....";
                break;
            case 0x04:
                msg = "读写器返回超时 .....";
                break;
            case 0x05:
                msg = "数据包流水号不正确 .....";
                break;
            case 0x07:
                msg = "接收异常 .....";
                break;
            case 0x0A:
                msg = "参数值超出范围 .....";
                break;
            case 0x80:
                msg = "参数设置成功 .....";
                break;
            case 0x81:
                msg = "参数设置失败 .....";
                break;
            case 0x82:
                msg = "通讯超时.....";
                break;
            case 0x83:
                msg = "卡不存在.....";
                break;
            case 0x84:
                msg = "接收卡数据出错.....";
                break;
            case 0x85:
                msg = "未知的错误.....";
                break;
            case 0x87:
                msg = "输入参数或者输入命令格式错误.....";
                break;
            case 0x89:
                msg = "输入的指令代码不存在.....";
                break;
            case 0x8A:
                msg = "在对于卡块初始化命令中出现错误.....";
                break;
            case 0x8B:
                msg = "在防冲突过程中得到错误的序列号.....";
                break;
            case 0x8C:
                msg = "密码认证没通过.....";
                break;
            case 0x8F:
                msg = "输入的指令代码不存在.....";
                break;
            case 0x90:
                msg = "卡不支持这个命令.....";
                break;
            case 0x91:
                msg = "命令格式有错误.....";
                break;
            case 0x92:
                msg = "在命令的FLAG参数中，不支持OPTION 模式.....";
                break;
            case 0x93:
                msg = "要操作的BLOCK不存在.....";
                break;
            case 0x94:
                msg = "要操作的对象已经别锁定，不能进行修改.....";
                break;
            case 0x95:
                msg = "锁定操作不成功.....";
                break;
            case 0x96:
                msg = "写操作不成功.....";
                break;
        }
        msg += '\n';
        text += msg;
        return text;
    }

}
