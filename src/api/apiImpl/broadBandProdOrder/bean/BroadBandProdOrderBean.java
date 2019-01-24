package api.apiImpl.broadBandProdOrder.bean;

public class BroadBandProdOrderBean {

	private String channelNbr;
	private String commonRegionId;
	private String custOrderId;
	private String extCustOrderId;
	private BProdInfo prodInfo;
	private BProdOfferInfo prodOfferInfos;
	private String staffCode;

	public String getChannelNbr() {
		return channelNbr;
	}

	public void setChannelNbr(String channelNbr) {
		this.channelNbr = channelNbr;
	}

	public String getCommonRegionId() {
		return commonRegionId;
	}

	public void setCommonRegionId(String commonRegionId) {
		this.commonRegionId = commonRegionId;
	}

	public String getCustOrderId() {
		return custOrderId;
	}

	public void setCustOrderId(String custOrderId) {
		this.custOrderId = custOrderId;
	}

	public String getExtCustOrderId() {
		return extCustOrderId;
	}

	public void setExtCustOrderId(String extCustOrderId) {
		this.extCustOrderId = extCustOrderId;
	}

	public BProdInfo getProdInfo() {
		return prodInfo;
	}

	public void setProdInfo(BProdInfo prodInfo) {
		this.prodInfo = prodInfo;
	}

	public BProdOfferInfo getProdOfferInfos() {
		return prodOfferInfos;
	}

	public void setProdOfferInfos(BProdOfferInfo prodOfferInfos) {
		this.prodOfferInfos = prodOfferInfos;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

}
