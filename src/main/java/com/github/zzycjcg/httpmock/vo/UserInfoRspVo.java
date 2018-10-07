package com.github.zzycjcg.httpmock.vo;

import com.google.common.collect.ImmutableList;

import java.io.Serializable;
import java.util.List;

/**
 * {    "openid":" OPENID",
 * " nickname": NICKNAME,
 * "sex":"1",
 * "province":"PROVINCE"
 * "city":"CITY",
 * "country":"COUNTRY",
 * "headimgurl":    "http://thirdwx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46",
 * "privilege":[ "PRIVILEGE1" "PRIVILEGE2"     ],
 * "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
 * }
 * Created by zzy on  2018/10/06 15:00
 */
public class UserInfoRspVo implements Serializable {
    private static final long serialVersionUID = -315559274762559496L;
    private String openid;
    private String nickname;
    private String sex = "1";
    private String province = "浙江";
    private String city = "杭州";
    private String country = "中国";
    private String headimgurl = "http://thirdwx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46";
    private List<String> privilege = ImmutableList.of("PRIVILEGE1", "PRIVILEGE2");
    private String unionid = "o6_bmasdasdsad6_2sgVt7hMZOPfL";

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public List<String> getPrivilege() {
        return privilege;
    }

    public void setPrivilege(List<String> privilege) {
        this.privilege = privilege;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
