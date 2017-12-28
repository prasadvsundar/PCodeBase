package com.codebase.queue;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Rohan Kamat(EmpId:1015)
 * @version 1.0
 * @organization NanoBi Analytics
 * @Date Sept 13, 2017
 */


public class NPCIData implements java.io.Serializable {

public NPCIData(){

}

public NPCIData(String txn_id,String txn_init_timestamp,String txn_comp_timestamp,String txn_type,String txn_subtype,String initiating_channel,String multiple_payee,String txn_status,String error_code,String respcd_payer,String respcd_payee,String reversal_respcode_payer,String reversal_respcode_payee,String payer_psp,String payer_seqnum,String payee_seqnum,String payee_psp,String remitter_bank,String beneficiary_bank,String payer_bin,String payer_ifsc,String payer_mmid,String payee_bin,String payee_ifsc,String payee_mmid,String payer_address,String payee_address,String payee_requested_amount,String payee_settlement_amount,String client,String port,String payer_location,String payee_location,String payer_geocode,String payee_geocode,String payer_os_type,String payee_os_type,String riskscore,String windowid,String payer_auth_respcd,String payee_auth_respcd,String payer_requested_amount,String imps,String payer_mobilenumber,String payee_mobilenumber,String beneficiary_mcc_code,String remitter_mcc_code,String debit_rrn,String credit_rrn,String custref,String payer_account_number,String payee_account_number,String payer_aadhar_number,String payee_aadhar_number,String mis_crtn_ts,String payer_settlement_amount,String payee_verified_name,String payer_device_id,String payee_device_id,String cred_type,String cred_subtype) {
super();
txn_id=txn_id.replaceAll("^\"|\"$", "");
this.txn_id = txn_id;
this.txn_init_timestamp = txn_init_timestamp;
this.txn_comp_timestamp = txn_comp_timestamp;
this.txn_type = txn_type;
this.txn_subtype = txn_subtype;
this.initiating_channel = initiating_channel;
this.multiple_payee = multiple_payee;
this.txn_status = txn_status;
this.error_code = error_code;
this.respcd_payer = respcd_payer;
this.respcd_payee = respcd_payee;
this.reversal_respcode_payer = reversal_respcode_payer;
this.reversal_respcode_payee = reversal_respcode_payee;
this.payer_psp = payer_psp;
this.payer_seqnum = payer_seqnum;
this.payee_seqnum = payee_seqnum;
this.payee_psp = payee_psp;
this.remitter_bank = remitter_bank;
this.beneficiary_bank = beneficiary_bank;
this.payer_bin = payer_bin;
this.payer_ifsc = payer_ifsc;
this.payer_mmid = payer_mmid;
this.payee_bin = payee_bin;
this.payee_ifsc = payee_ifsc;
this.payee_mmid = payee_mmid;
this.payer_address = payer_address;
this.payee_address = payee_address;
this.payee_requested_amount = (payee_requested_amount!=null?Double.parseDouble(payee_requested_amount):0);
this.payee_settlement_amount = payee_settlement_amount;
this.client = client;
this.port = port;
this.payer_location = payer_location;
this.payee_location = payee_location;
this.payer_geocode = payer_geocode;
this.payee_geocode = payee_geocode;
this.payer_os_type = payer_os_type;
this.payee_os_type = payee_os_type;
this.riskscore = riskscore;
this.windowid = windowid;
this.payer_auth_respcd = payer_auth_respcd;
this.payee_auth_respcd = payee_auth_respcd;
this.payer_requested_amount = payer_requested_amount;
this.imps = imps;
this.payer_mobilenumber = payer_mobilenumber;
this.payee_mobilenumber = payee_mobilenumber;
this.beneficiary_mcc_code = beneficiary_mcc_code;
this.remitter_mcc_code = remitter_mcc_code;
this.debit_rrn = debit_rrn;
this.credit_rrn = credit_rrn;
this.custref = custref;
this.payer_account_number = payer_account_number;
this.payee_account_number = payee_account_number;
this.payer_aadhar_number = payer_aadhar_number;
this.payee_aadhar_number = payee_aadhar_number;
this.mis_crtn_ts = mis_crtn_ts;
this.payer_settlement_amount = payer_settlement_amount;
this.payee_verified_name = payee_verified_name;
this.payer_device_id = payer_device_id;
this.payee_device_id = payee_device_id;
this.cred_type = cred_type;
this.cred_subtype = cred_subtype;
}







@Override
public String toString() {
return "NPCIData [txn_id=" + txn_id + ", txn_init_timestamp=" + txn_init_timestamp + ", txn_comp_timestamp="
+ txn_comp_timestamp + ", txn_type=" + txn_type + ", txn_subtype=" + txn_subtype
+ ", initiating_channel=" + initiating_channel + ", multiple_payee=" + multiple_payee + ", txn_status="
+ txn_status + ", error_code=" + error_code + ", respcd_payer=" + respcd_payer + ", respcd_payee="
+ respcd_payee + ", reversal_respcode_payer=" + reversal_respcode_payer + ", reversal_respcode_payee="
+ reversal_respcode_payee + ", payer_psp=" + payer_psp + ", payer_seqnum=" + payer_seqnum
+ ", payee_seqnum=" + payee_seqnum + ", payee_psp=" + payee_psp + ", remitter_bank=" + remitter_bank
+ ", beneficiary_bank=" + beneficiary_bank + ", payer_bin=" + payer_bin + ", payer_ifsc=" + payer_ifsc
+ ", payer_mmid=" + payer_mmid + ", payee_bin=" + payee_bin + ", payee_ifsc=" + payee_ifsc
+ ", payee_mmid=" + payee_mmid + ", payer_address=" + payer_address + ", payee_address=" + payee_address
+ ", payee_requested_amount=" + payee_requested_amount + ", payee_settlement_amount="
+ payee_settlement_amount + ", client=" + client + ", port=" + port + ", payer_location="
+ payer_location + ", payee_location=" + payee_location + ", payer_geocode=" + payer_geocode
+ ", payee_geocode=" + payee_geocode + ", payer_os_type=" + payer_os_type + ", payee_os_type="
+ payee_os_type + ", riskscore=" + riskscore + ", windowid=" + windowid + ", payer_auth_respcd="
+ payer_auth_respcd + ", payee_auth_respcd=" + payee_auth_respcd + ", payer_requested_amount="
+ payer_requested_amount + ", imps=" + imps + ", payer_mobilenumber=" + payer_mobilenumber
+ ", payee_mobilenumber=" + payee_mobilenumber + ", beneficiary_mcc_code=" + beneficiary_mcc_code
+ ", remitter_mcc_code=" + remitter_mcc_code + ", debit_rrn=" + debit_rrn + ", credit_rrn=" + credit_rrn
+ ", custref=" + custref + ", payer_account_number=" + payer_account_number + ", payee_account_number="
+ payee_account_number + ", payer_aadhar_number=" + payer_aadhar_number + ", payee_aadhar_number="
+ payee_aadhar_number + ", mis_crtn_ts=" + mis_crtn_ts + ", payer_settlement_amount="
+ payer_settlement_amount + ", payee_verified_name=" + payee_verified_name + ", payer_device_id="
+ payer_device_id + ", payee_device_id=" + payee_device_id + ", cred_type=" + cred_type
+ ", cred_subtype=" + cred_subtype + "]";
}



    public String getTxn_id() {
return txn_id;
}

public String getTxn_init_timestamp() {
return txn_init_timestamp;
}

public String getTxn_comp_timestamp() {
return txn_comp_timestamp;
}

public String getTxn_type() {
return txn_type;
}

public String getTxn_subtype() {
return txn_subtype;
}

public String getInitiating_channel() {
return initiating_channel;
}

public String getMultiple_payee() {
return multiple_payee;
}

public String getTxn_status() {
return txn_status;
}

public String getError_code() {
return error_code;
}

public String getRespcd_payer() {
return respcd_payer;
}

public String getRespcd_payee() {
return respcd_payee;
}

public String getReversal_respcode_payer() {
return reversal_respcode_payer;
}

public String getReversal_respcode_payee() {
return reversal_respcode_payee;
}

public String getPayer_psp() {
return payer_psp;
}

public String getPayer_seqnum() {
return payer_seqnum;
}

public String getPayee_seqnum() {
return payee_seqnum;
}

public String getPayee_psp() {
return payee_psp;
}

public String getRemitter_bank() {
return remitter_bank;
}

public String getBeneficiary_bank() {
return beneficiary_bank;
}

public String getPayer_bin() {
return payer_bin;
}

public String getPayer_ifsc() {
return payer_ifsc;
}

public String getPayer_mmid() {
return payer_mmid;
}

public String getPayee_bin() {
return payee_bin;
}

public String getPayee_ifsc() {
return payee_ifsc;
}

public String getPayee_mmid() {
return payee_mmid;
}

public String getPayer_address() {
return payer_address;
}

public String getPayee_address() {
return payee_address;
}

public Double getPayee_requested_amount() {
return payee_requested_amount;
}

public String getPayee_settlement_amount() {
return payee_settlement_amount;
}

public String getClient() {
return client;
}

public String getPort() {
return port;
}

public String getPayer_location() {
return payer_location;
}

public String getPayee_location() {
return payee_location;
}

public String getPayer_geocode() {
return payer_geocode;
}

public String getPayee_geocode() {
return payee_geocode;
}

public String getPayer_os_type() {
return payer_os_type;
}

public String getPayee_os_type() {
return payee_os_type;
}

public String getRiskscore() {
return riskscore;
}

public String getWindowid() {
return windowid;
}

public String getPayer_auth_respcd() {
return payer_auth_respcd;
}

public String getPayee_auth_respcd() {
return payee_auth_respcd;
}

public String getPayer_requested_amount() {
return payer_requested_amount;
}

public String getImps() {
return imps;
}

public String getPayer_mobilenumber() {
return payer_mobilenumber;
}

public String getPayee_mobilenumber() {
return payee_mobilenumber;
}

public String getBeneficiary_mcc_code() {
return beneficiary_mcc_code;
}

public String getRemitter_mcc_code() {
return remitter_mcc_code;
}

public String getDebit_rrn() {
return debit_rrn;
}

public String getCredit_rrn() {
return credit_rrn;
}

public String getCustref() {
return custref;
}

public String getPayer_account_number() {
return payer_account_number;
}

public String getPayee_account_number() {
return payee_account_number;
}

public String getPayer_aadhar_number() {
return payer_aadhar_number;
}

public String getPayee_aadhar_number() {
return payee_aadhar_number;
}

public String getMis_crtn_ts() {
return mis_crtn_ts;
}

public String getPayer_settlement_amount() {
return payer_settlement_amount;
}

public String getPayee_verified_name() {
return payee_verified_name;
}

public String getPayer_device_id() {
return payer_device_id;
}

public String getPayee_device_id() {
return payee_device_id;
}

public String getCred_type() {
return cred_type;
}

public String getCred_subtype() {
return cred_subtype;
}

public void setTxn_id(String txn_id) {
this.txn_id = txn_id;
}

public void setTxn_init_timestamp(String txn_init_timestamp) {
this.txn_init_timestamp = txn_init_timestamp;
}

public void setTxn_comp_timestamp(String txn_comp_timestamp) {
this.txn_comp_timestamp = txn_comp_timestamp;
}

public void setTxn_type(String txn_type) {
this.txn_type = txn_type;
}

public void setTxn_subtype(String txn_subtype) {
this.txn_subtype = txn_subtype;
}

public void setInitiating_channel(String initiating_channel) {
this.initiating_channel = initiating_channel;
}

public void setMultiple_payee(String multiple_payee) {
this.multiple_payee = multiple_payee;
}

public void setTxn_status(String txn_status) {
this.txn_status = txn_status;
}

public void setError_code(String error_code) {
this.error_code = error_code;
}

public void setRespcd_payer(String respcd_payer) {
this.respcd_payer = respcd_payer;
}

public void setRespcd_payee(String respcd_payee) {
this.respcd_payee = respcd_payee;
}

public void setReversal_respcode_payer(String reversal_respcode_payer) {
this.reversal_respcode_payer = reversal_respcode_payer;
}

public void setReversal_respcode_payee(String reversal_respcode_payee) {
this.reversal_respcode_payee = reversal_respcode_payee;
}

public void setPayer_psp(String payer_psp) {
this.payer_psp = payer_psp;
}

public void setPayer_seqnum(String payer_seqnum) {
this.payer_seqnum = payer_seqnum;
}

public void setPayee_seqnum(String payee_seqnum) {
this.payee_seqnum = payee_seqnum;
}

public void setPayee_psp(String payee_psp) {
this.payee_psp = payee_psp;
}

public void setRemitter_bank(String remitter_bank) {
this.remitter_bank = remitter_bank;
}

public void setBeneficiary_bank(String beneficiary_bank) {
this.beneficiary_bank = beneficiary_bank;
}

public void setPayer_bin(String payer_bin) {
this.payer_bin = payer_bin;
}

public void setPayer_ifsc(String payer_ifsc) {
this.payer_ifsc = payer_ifsc;
}

public void setPayer_mmid(String payer_mmid) {
this.payer_mmid = payer_mmid;
}

public void setPayee_bin(String payee_bin) {
this.payee_bin = payee_bin;
}

public void setPayee_ifsc(String payee_ifsc) {
this.payee_ifsc = payee_ifsc;
}

public void setPayee_mmid(String payee_mmid) {
this.payee_mmid = payee_mmid;
}

public void setPayer_address(String payer_address) {
this.payer_address = payer_address;
}

public void setPayee_address(String payee_address) {
this.payee_address = payee_address;
}

public void setPayee_requested_amount(Double payee_requested_amount) {
this.payee_requested_amount = payee_requested_amount;
}

public void setPayee_settlement_amount(String payee_settlement_amount) {
this.payee_settlement_amount = payee_settlement_amount;
}

public void setClient(String client) {
this.client = client;
}

public void setPort(String port) {
this.port = port;
}

public void setPayer_location(String payer_location) {
this.payer_location = payer_location;
}

public void setPayee_location(String payee_location) {
this.payee_location = payee_location;
}

public void setPayer_geocode(String payer_geocode) {
this.payer_geocode = payer_geocode;
}

public void setPayee_geocode(String payee_geocode) {
this.payee_geocode = payee_geocode;
}

public void setPayer_os_type(String payer_os_type) {
this.payer_os_type = payer_os_type;
}

public void setPayee_os_type(String payee_os_type) {
this.payee_os_type = payee_os_type;
}

public void setRiskscore(String riskscore) {
this.riskscore = riskscore;
}

public void setWindowid(String windowid) {
this.windowid = windowid;
}

public void setPayer_auth_respcd(String payer_auth_respcd) {
this.payer_auth_respcd = payer_auth_respcd;
}

public void setPayee_auth_respcd(String payee_auth_respcd) {
this.payee_auth_respcd = payee_auth_respcd;
}

public void setPayer_requested_amount(String payer_requested_amount) {
this.payer_requested_amount = payer_requested_amount;
}

public void setImps(String imps) {
this.imps = imps;
}

public void setPayer_mobilenumber(String payer_mobilenumber) {
this.payer_mobilenumber = payer_mobilenumber;
}

public void setPayee_mobilenumber(String payee_mobilenumber) {
this.payee_mobilenumber = payee_mobilenumber;
}

public void setBeneficiary_mcc_code(String beneficiary_mcc_code) {
this.beneficiary_mcc_code = beneficiary_mcc_code;
}

public void setRemitter_mcc_code(String remitter_mcc_code) {
this.remitter_mcc_code = remitter_mcc_code;
}

public void setDebit_rrn(String debit_rrn) {
this.debit_rrn = debit_rrn;
}

public void setCredit_rrn(String credit_rrn) {
this.credit_rrn = credit_rrn;
}

public void setCustref(String custref) {
this.custref = custref;
}

public void setPayer_account_number(String payer_account_number) {
this.payer_account_number = payer_account_number;
}

public void setPayee_account_number(String payee_account_number) {
	if(payee_account_number==null){
		this.payee_account_number = "";
	}else{
		this.payee_account_number = payee_account_number;
	}

}

public void setPayer_aadhar_number(String payer_aadhar_number) {
this.payer_aadhar_number = payer_aadhar_number;
}

public void setPayee_aadhar_number(String payee_aadhar_number) {
this.payee_aadhar_number = payee_aadhar_number;
}

public void setMis_crtn_ts(String mis_crtn_ts) {
this.mis_crtn_ts = mis_crtn_ts;
}

public void setPayer_settlement_amount(String payer_settlement_amount) {
this.payer_settlement_amount = payer_settlement_amount;
}

public void setPayee_verified_name(String payee_verified_name) {
this.payee_verified_name = payee_verified_name;
}

public void setPayer_device_id(String payer_device_id) {
this.payer_device_id = payer_device_id;
}

public void setPayee_device_id(String payee_device_id) {
this.payee_device_id = payee_device_id;
}

public void setCred_type(String cred_type) {
this.cred_type = cred_type;
}

public void setCred_subtype(String cred_subtype) {
this.cred_subtype = cred_subtype;
}

public static List<String> columns() {
        List<String> columns = new ArrayList<String>();
     columns.add("txn_id");
    columns.add("txn_init_timestamp");
    columns.add("txn_comp_timestamp");
    columns.add("txn_type");
    columns.add("txn_subtype");
    columns.add("initiating_channel");
    columns.add("multiple_payee");
    columns.add("txn_status");
    columns.add("error_code");
    columns.add("respcd_payer");
    columns.add("respcd_payee");
    columns.add("reversal_respcode_payer");
    columns.add("reversal_respcode_payee");
    columns.add("payer_psp");
    columns.add("payer_seqnum");
    columns.add("payee_seqnum");
    columns.add("payee_psp");
    columns.add("remitter_bank");
    columns.add("beneficiary_bank");
    columns.add("payer_bin");
    columns.add("payer_ifsc");
    columns.add("payer_mmid");
    columns.add("payee_bin");
    columns.add("payee_ifsc");
    columns.add("payee_mmid");
    columns.add("payer_address");
    columns.add("payee_address");
    columns.add("payee_requested_amount");
    columns.add("payee_settlement_amount");
    columns.add("client");
    columns.add("port");
    columns.add("payer_location");
    columns.add("payee_location");
    columns.add("payer_geocode");
    columns.add("payee_geocode");
    columns.add("payer_os_type");
    columns.add("payee_os_type");
    columns.add("riskscore");
    columns.add("windowid");
    columns.add("payer_auth_respcd");
    columns.add("payee_auth_respcd");
    columns.add("payer_requested_amount");
    columns.add("imps");
    columns.add("payer_mobilenumber");
    columns.add("payee_mobilenumber");
    columns.add("beneficiary_mcc_code");
    columns.add("remitter_mcc_code");
    columns.add("debit_rrn");
    columns.add("credit_rrn");
    columns.add("custref");
    columns.add("payer_account_number");
    columns.add("payee_account_number");
    columns.add("payer_aadhar_number");
    columns.add("payee_aadhar_number");
    columns.add("mis_crtn_ts");
    columns.add("payer_settlement_amount");
    columns.add("payee_verified_name");
    columns.add("payer_device_id");
    columns.add("payee_device_id");
    columns.add("cred_type");
    columns.add("cred_subtype"); 
        return columns;
    }






String txn_id;
String txn_init_timestamp;
String txn_comp_timestamp;
String txn_type;
String txn_subtype;
String initiating_channel;
String multiple_payee;
String txn_status;
String error_code;
String respcd_payer;
String respcd_payee;
String reversal_respcode_payer;
String reversal_respcode_payee;
String payer_psp;
String payer_seqnum;
String payee_seqnum;
String payee_psp;
String remitter_bank;
String beneficiary_bank;
String payer_bin;
String payer_ifsc;
String payer_mmid;
String payee_bin;
String payee_ifsc;
String payee_mmid;
String payer_address;
String payee_address;
Double payee_requested_amount;
String payee_settlement_amount;
String client;
String port;
String payer_location;
String payee_location;
String payer_geocode;
String payee_geocode;
String payer_os_type;
String payee_os_type;
String riskscore;
String windowid;
String payer_auth_respcd;
String payee_auth_respcd;
String payer_requested_amount;
String imps;
String payer_mobilenumber;
String payee_mobilenumber;
String beneficiary_mcc_code;
String remitter_mcc_code;
String debit_rrn;
String credit_rrn;
String custref;
String payer_account_number;
String payee_account_number;
String payer_aadhar_number;
String payee_aadhar_number;
String mis_crtn_ts;
String payer_settlement_amount;
String payee_verified_name;
String payer_device_id;
String payee_device_id;
String cred_type;
String cred_subtype;
}
