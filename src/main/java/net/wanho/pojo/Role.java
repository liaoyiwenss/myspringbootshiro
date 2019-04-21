package net.wanho.pojo;

import java.util.Date;
import java.util.List;

public class Role {
    private Long tid;

    private Date createtime;

    private Long logicaldelete;

    private Date modifytime;

    private String rolename;

    private List<Permission> permissions;

    private List<String> strpermissions;

    public List<String> getStrpermissions() {
        return strpermissions;
    }

    public void setStrpermissions(List<String> strpermissions) {
        this.strpermissions = strpermissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getLogicaldelete() {
        return logicaldelete;
    }

    public void setLogicaldelete(Long logicaldelete) {
        this.logicaldelete = logicaldelete;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }
}