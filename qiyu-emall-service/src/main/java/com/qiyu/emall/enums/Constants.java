package com.qiyu.emall.enums;

public interface Constants {

    interface MallUserInfo{
         String MallUserInfoKey="MALLUSER_";
    }

    interface MALLUSER_MEMBERTYPE{
        Integer NEWMEMBER=0;
        Integer OLDMEMBER=1;
    }

    interface MALLUSER_GERDER{
        Integer MEN=0;
        Integer WOMEN=1;
    }

    interface MALLUSER_SOURCE{
        Integer MINI_PROGRAM=0;
        Integer SYSTEM=1;//会员系统
    }
    interface MALLUSER_STATUS{
        Integer NORMAL=1;
        Integer FORBIDDEN=-1;
    }
}
