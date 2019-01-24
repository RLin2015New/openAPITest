package api.apiImpl.broadBandProdOrder.bean;

import java.util.Map;

public class BProdOfferInfo {
	private Map<String, String> attrInfos;
	private String prodOfferNbr;
	private String serviceOfferId;

	public Map<String, String> getAttrInfos() {
		return attrInfos;
	}

	public void setAttrInfos(Map<String, String> attrInfos) {
		this.attrInfos = attrInfos;
	}

	public String getProdOfferNbr() {
		return prodOfferNbr;
	}

	public void setProdOfferNbr(String prodOfferNbr) {
		this.prodOfferNbr = prodOfferNbr;
	}

	public String getServiceOfferId() {
		return serviceOfferId;
	}

	public void setServiceOfferId(String serviceOfferId) {
		this.serviceOfferId = serviceOfferId;
	}

}
