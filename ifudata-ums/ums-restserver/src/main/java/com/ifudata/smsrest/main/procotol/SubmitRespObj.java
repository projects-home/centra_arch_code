package com.ifudata.smsrest.main.procotol;

public class SubmitRespObj {
	private String retcode;
	private String retmsg;
	private String msg_id;
	public String getRetcode() {
		return retcode;
	}
	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}
	public String getRetmsg() {
		return retmsg;
	}
	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}
	public String getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}
	@Override
	public String toString() {
		return "SubmitRespObj [retcode=" + retcode + ", retmsg=" + retmsg + ", msg_id=" + msg_id + "]";
	}
}
