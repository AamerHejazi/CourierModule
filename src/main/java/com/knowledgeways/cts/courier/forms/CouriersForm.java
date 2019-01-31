package com.knowledgeways.cts.courier.forms;

public class CouriersForm {

  private String nameAr;
  private String nameEn;
  private String mobile;
  private Integer organizationId;

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getOrganizationId() {
        System.out.println("inside getter"+ this.organizationId);
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
        System.out.println("inside setter"+ this.organizationId);
    }
}