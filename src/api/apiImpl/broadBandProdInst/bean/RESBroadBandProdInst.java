package api.apiImpl.broadBandProdInst.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import api.ApiResponseData;

public class RESBroadBandProdInst extends ApiResponseData {

	private String account;
	private String certType;
	private String certNum;
	private String prodInstId;
	private String productNbr;
	private String productName;
	private String addressDesc;
	private String commonRegionId;
	private String statusCd;
	private List<BAttrInfo> attrInfos;

	public static RESBroadBandProdInst testInst() {
		RESBroadBandProdInst inst = new RESBroadBandProdInst();
		inst.setAccount("1118900001234");
		inst.setAddressDesc("北京市西城区广外街道xxxx");

		List<BAttrInfo> atts = new ArrayList<>();
		inst.setAttrInfos(atts);

		BAttrInfo ba1 = new BAttrInfo();

		ba1.setAttrSpecId("10010130");
		ba1.setAttrValue("100M");

		BAttrInfo ba2 = new BAttrInfo();
		ba2.setAttrSpecId("10010131");
		ba2.setAttrValue("50M");

		atts.add(ba1);
		atts.add(ba2);

		inst.setCertNum("360822198609284091");
		inst.setCertType("1");
		inst.setCommonRegionId("8101000");
		inst.setProdInstId("32312456");
		inst.setProductName("宽带");
		inst.setProductNbr("1000003734");
		inst.setStatusCd("100000");
		return inst;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public String getCertNum() {
		return certNum;
	}

	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}

	public String getProdInstId() {
		return prodInstId;
	}

	public void setProdInstId(String prodInstId) {
		this.prodInstId = prodInstId;
	}

	public String getProductNbr() {
		return productNbr;
	}

	public void setProductNbr(String productNbr) {
		this.productNbr = productNbr;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getAddressDesc() {
		return addressDesc;
	}

	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}

	public String getCommonRegionId() {
		return commonRegionId;
	}

	public void setCommonRegionId(String commonRegionId) {
		this.commonRegionId = commonRegionId;
	}

	public String getStatusCd() {
		return statusCd;
	}

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	public List<BAttrInfo> getAttrInfos() {
		return attrInfos;
	}

	public void setAttrInfos(List<BAttrInfo> attrInfos) {
		this.attrInfos = attrInfos;
	}

	@Override
	public String toJsonString() {
//		try {
//			return JSON.json(this);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return null;
	}

}
